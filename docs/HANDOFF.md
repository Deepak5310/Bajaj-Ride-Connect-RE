# Pulsar Connect (NS400Z) — Agent Handoff

Context transfer for a fresh agent picking up this work. Read this first, then
verify against the actual code — parts of it may have drifted.

## What this project is

`tbt-bridge/` is a standalone, zero-dependency native Android app ("Pulsar
Connect") that bridges an Android phone to the **Bajaj Pulsar NS400Z digital
instrument cluster** over BLE GATT. It streams Google Maps turn-by-turn
navigation, phone telemetry (battery/signal), caller ID, and music metadata to
the bike's LCD, and receives handlebar button presses back from the cluster.

This is reverse-engineered from the official Bajaj Connect app. The decompiled
originals live in `src/com/bajajconnect/` and are the **authoritative
reference** for the wire protocol — when in doubt, diff against them.

Build is a hand-rolled Python script (`build_tbt_bridge.py`) calling
`aapt2` → `javac` → `d8` → `zipalign` → `apksigner`. No Gradle. APK is ~89 KB.

## Hardware target

- Device name: `PULSAR6741`, MAC `C0:63:80:2D:0C:42`
- Name matching is fuzzy/case-insensitive: `PULSAR*`, `NS400*`, `BAJAJ*`,
  `OTC*`, `CLUSTER*`, `DOMINAR*`, `CHETAK*`
- Service UUID `0010676e-6972-6565-6e69-676e4543544f`
- Characteristics (short prefix → purpose):
  - `0110` — Turn-by-turn navigation, 48-byte write
  - `0210` — Phone telemetry / caller ID, 55-byte (compact) or 89-byte write
  - `0610` — Now-playing media, 105-byte write
  - `0a10` — Handlebar controls, **notify** (subscribe via CCCD `0x2902`)

## Protocol gotchas that cost real debugging time

These were the cause of a cluster display crash (screen went blank, needed an
ignition power-cycle to recover). All three are **fixed and committed** in
`c3e69968`. Do not "simplify" them back:

1. **Distance bytes are written in reverse.** `encodeDistance()` returns
   `[unit, decMSB, decLSB, intMSB, intLSB]`, but the frame copies them
   backwards: `frame[2]=d[4], frame[3]=d[3], frame[4]=d[2], frame[5]=d[1]`
   (and the same pattern at `frame[8..11]` for total distance). This matches
   `TbtNavFrame.buildNavHelperFrame()` in the decompiled original.
2. **The AM/PM bit is inverted.** Byte 0 bit 7 is `1` for **AM**, `0` for PM —
   so the code is `((!isPm ? 1 : 0) << 7)`.
3. **`KEEP_RIGHT` glyph is 88**, not 80. 80 is `U_TURN_RIGHT`; the duplicate
   sent a U-turn glyph for keep-right.

Malformed frames on `0110` will blank the cluster LCD. It is a **display
rendering crash, not hardware damage** — firmware is in read-only flash, BLE
payloads only reach RAM buffers. A power cycle fully recovers it (it does reset
the trip meter and clock, which is volatile RAM). Safe to keep testing, but
expect a blank screen as the failure mode for a bad frame.

## Work completed

### Committed (`c3e69968`)
Byte-order, AM/PM bit, and `KEEP_RIGHT` glyph fixes described above.
Verified byte-for-byte against the decompiled original: e.g. 250 m →
`encodeDistance` = `[1, 0x00, 0x00, 0x00, 0xFA]` → `0xFA` lands at `frame[2]`.

### Uncommitted working-tree changes — status pill bug, FIXED, builds clean
**Symptom:** the app's top-right status pill stayed on `CONNECTING` even though
the bike was connected and the BLE card showed `Link: Active`.

**Root cause:** `PulsarBleManager` is a singleton that held exactly **one**
`BleListener`. `MainActivity.onCreate()` registered itself, then immediately
started `PulsarForegroundService`, whose `onCreate()` registered *itself* —
clobbering the Activity's listener. The Activity therefore never received
`onConnectionStateChanged`, so the pill never left its `CONNECTING` state.

**Fix applied:**
- `PulsarBleManager` now holds a `List<BleListener>` with
  `addListener()` / `removeListener()`. Three private dispatch helpers
  (`notifyConnectionState`, `notifyPacketSent`, `notifyHandlebarEvent`) fan out
  to all listeners on the main thread, iterating a defensive copy.
- `addListener()` immediately replays current connection state to the new
  listener, so a late-registering Activity gets correct state right away.
- `MainActivity` uses `addListener(this)` and now has an `onDestroy()` that
  calls `removeListener(this)` — without this, a recreated Activity leaks
  (listener identity is reference equality, so a rotated/recreated Activity
  would accumulate dead entries).
- `PulsarForegroundService` likewise uses `addListener` and removes itself in
  `onDestroy()`.
- `setListener()` is kept only as a thin shim because dead code still calls it
  (see below).

**Not yet verified on the bike.** Compiles and packages; needs an on-device
check that the pill flips to `CONNECTED`.

## Work pending

### 1. Media metadata never reaches the cluster — NOT FIXED
**Symptom:** user played a track in YouTube Music; the cluster kept showing
`♫ Idle`. Notification-listener permission *is* granted (the app's own
"Notification Hook: ACTIVE" check passes), so the permission is not the issue.

Relevant file: `tbt-bridge/src/com/pulsar/ns400z/tbtbridge/MediaStateListener.java`

**Prime suspect — no re-send when the bike connects later.**
`PulsarBleManager.sendMedia()` (line ~307) starts with
`if (charMedia == null || !isConnected) return false;` — it **silently drops**
the frame. `syncMetadata()` ignores that return value and never retries. So the
likely sequence is: music starts → `syncMetadata()` fires → bike not yet
connected (or characteristics not yet discovered) → frame dropped → no further
metadata change ever occurs, so nothing is ever re-sent. The cluster stays idle
for the rest of the session. **Fix direction:** re-run `syncMetadata()` from
`onConnectionStateChanged(connected=true)` once `charMedia` is bound.

**Secondary suspects:**
- `updateActiveController()` blindly takes `controllers.get(0)`. With several
  apps holding media sessions, index 0 may be a stale/paused session rather
  than the one actually playing. Should pick the session whose
  `PlaybackState` is `STATE_PLAYING`, preferring that over position in the list.
- The guard `if (activeController != newController)` means if YT Music's
  session is not at index 0, its callback is never registered at all.
- `refreshMediaSessions()` is only invoked from
  `GoogleMapsNotificationListener.onListenerConnected()`. If the foreground
  service constructs `MediaStateListener` before the notification listener has
  connected, `getActiveSessions()` can throw `SecurityException` — which is
  caught and merely logged at WARN, leaving `mediaSessionManager` usable but
  the controller list never populated.
- There is **no logging** of which sessions were discovered. Add that first;
  it will disambiguate all of the above in one run.

### 2. Bike-side verification of the committed protocol fixes
The byte-order fix is installed but the user has only confirmed the *in-app*
simulation buttons render correctly. Live Google Maps navigation against the
real cluster with the corrected frames is still unverified.

## Build / install / test

```bash
python3 build_tbt_bridge.py          # → dist/pulsar-tbt-bridge.apk
adb install -r dist/pulsar-tbt-bridge.apk
```

The phone is debugged **over WiFi ADB** (it has to leave the desk to reach the
bike), previously at `10.140.237.29:5555` — re-pair if the IP changed:

```bash
adb connect <phone-ip>:5555
adb logcat -s PulsarBleManager:V MediaStateListener:V \
               GoogleMapsTbtListener:V PulsarForegroundService:V
```

For a test ride where the laptop can't follow, capture to a file on the device
and pull it afterwards rather than streaming.

In-app simulation buttons (Left 250 m, Right 500 m, Roundabout exit 2, Arrived,
Caller ID, Spotify track, Clear) exercise every frame type without riding, and
per the user these all render correctly now.

## Known dead code

`tbt-bridge/src/com/pulsar/ns400z/tbtbridge/TbtBleDispatcher.java` is an unused
backwards-compat wrapper — nothing references it and it is never instantiated,
so it is inert. It is the sole remaining caller of
`PulsarBleManager.setListener()`. Deleting both it and the `setListener` shim
was attempted and blocked by a permission classifier; it's worth retrying, as
removing it would eliminate a second source of listener registration.

## Working relationship notes

The user writes in Hinglish and tests on real hardware — their own motorcycle.
They asked for reassurance about hardware safety before re-testing after the
cluster blanked, so **flag physical-risk implications explicitly** before
suggesting they run something on the bike. They prefer to be told which tests
to run and how, since the phone is untethered during a test ride.
