# Pulsar Ride Connect (NS400Z) — Developer Handoff & Status

## 1. What this project is

**Pulsar Ride Connect** (`app/src/com/bajaj/rideconnect/re/`) is a standalone, high-performance native Android application engineered to interface directly with the **Bajaj Pulsar NS400Z digital instrument cluster** (`PULSAR6741`, MAC: `C0:63:80:2D:0C:42`) over Bluetooth Low Energy (BLE GATT).

It streams phone telemetry (battery/signal), caller ID, and music metadata to the bike's dot-matrix LCD, and processes physical handlebar switchgear actions (Play/Pause, Track Skip, Volume, Call Accept/Reject).

The authoritative protocol reference is the decompiled official Bajaj app in `src/com/bajajconnect/`.

---

## 2. Tested & Confirmed Working Features (Physical Bike)

Tested and verified on the physical Bajaj Pulsar NS400Z motorcycle:

1. **Volume Buttons (`^` / `v` single-press)**:
   - Increments and decrements phone media volume smoothly via `AudioManager.STREAM_MUSIC`.
   - Uses cluster volume tenths (0–10) with official Bajaj half-step rounding calculation (`d - (int)d >= 0.5`).
2. **Volume Mute Protection**:
   - Fixed the issue where releasing `^` caused volume to mute after a few seconds.
   - Cluster `0a10` Byte 0 idle pulse (`volume=0`) is filtered when current phone volume `> 1` (`MediaStateListener.java`).
3. **Track Skip (`^` / `v` long-press / hold)**:
   - Long-press `^` skips to **Next Track**.
   - Long-press `v` skips to **Previous Track**.
   - Dispatches via `MediaController.TransportControls` with fallback to `dispatchMediaKeyEvent`.
4. **Media Play / Pause (`SET` single-press)**:
   - Single-press `SET` on the left handlebar switch toggles Play and Pause reliably.
5. **Continuous Playback Ticker (`0610`)**:
   - 1-second background `progressTicker` continuously streams updated elapsed seconds (`00:01`, `00:02`, ...) so the cluster LCD playback time never freezes.
6. **Phone Battery Gauge (`0210`)**:
   - Discrete 0–4 bar scaling (`getBatteryLevel(percent)`) bit-packed at `(batteryLevel << 3)` in `0210` telemetry byte 1.
   - Matches physical battery gauge icon on the motorcycle LCD.
7. **Bidirectional Hardware Volume Sync**:
   - Phone volume rocker adjustments trigger `Settings.System.CONTENT_URI` ContentObserver and immediately send updated telemetry (`0210`) to the bike.

---

## 3. Implementation Status Summary

| Subsystem / Feature | File Location | Status |
|---|---|---|
| **BLE GATT Core Engine** | `app/src/com/bajaj/rideconnect/re/PulsarBleManager.java` | ✅ **Complete & Active** |
| **Binary Protocol Frames** | `app/src/com/bajaj/rideconnect/re/PulsarProtocol.java` | ✅ **Complete & Active** |
| **Media Controller & Ticker** | `app/src/com/bajaj/rideconnect/re/MediaStateListener.java` | ✅ **Verified on Bike** |
| **Phone Telemetry Heartbeat** | `app/src/com/bajaj/rideconnect/re/PhoneStateMonitor.java` | ✅ **Verified on Bike** |
| **Caller ID & Handlebar Calls** | `app/src/com/bajaj/rideconnect/re/TelephonyCallHandler.java` | ⚠️ **Implemented (Untested)** |
| **Turn-by-Turn Navigation** | `app/src/com/bajaj/rideconnect/re/GoogleMapsNotificationListener.java` | ℹ️ **Implemented (Optional)** |
| **Automotive Cockpit UI & Dock** | `app/src/com/bajaj/rideconnect/re/MainActivity.java` | ✅ **Complete & Active** (Zero margin edge-to-edge flush layout, display cutout `shortEdges` enabled to eliminate notch letterboxing, 3-cluster ergonomic layout tailored for 360dp landscape height on Mi A3, 46dp–52dp glove hitboxes, zoom `+/-` buttons stripped for clean gesture-driven map canvas, one-tap collapsible split view with compact floating music pill, navigation drawer streamlined with About removed and direct clickable `@Deepak5310` GitHub footer link below Exit button, Supported bikes: NS400Z v1/v2/v3, Dominar 400) |
| **Official Bajaj Adaptive Launcher Icon** | `app/res/drawable/ic_launcher*.xml` | ✅ **Complete & Verified** (108dp Android adaptive icon using official Bajaj vector logo from `bajaj-seeklogo.svg`; Royal Blue gradient background with centered safe-zone white Bajaj flying-B emblem and wordmark) |
| **Material You & Dead Code Audit** | `./app/` | ✅ **Audited & Deep Cleaned** (Material You / Monet engine dropped for high-contrast Android 11 AMOLED cockpit palette `#000000`/`#07080B`/`#38BDF8`, zoom pill & zoom icon drawables deleted, navigation drawer About sub-view/drawables `ic_menu_info` & `ic_tab_bike` removed, 0 unused assets/strings, WebView lifecycle hooks `onResume`/`onPause`/`onDestroy` added, socket `HttpURLConnection` cleanup, handler memory leaks resolved) |

---

## 4. Hardware Details & Protocol Essentials

- **Target Device:** `PULSAR6741`, MAC `C0:63:80:2D:0C:42`
- **Service UUID:** `0010676e-6972-6565-6e69-676e4543544f`
- **Primary Characteristics:**
  - `0110` — Turn-by-Turn Navigation, 48-byte write
  - `0210` — Phone Telemetry / Caller ID, 55-byte compact write
  - `0610` — Now-Playing Media, 105-byte write
  - `0a10` — Handlebar Controls, 20-byte read / notify (CCCD `0x2902`, active 500ms poller)

*For detailed byte maps, bitmasks, and packet diagrams, see [docs/DEVELOPER_GUIDE.md](docs/DEVELOPER_GUIDE.md).*

---

## 5. Build & Quick Commands

```bash
# Clean build, package, sign and install APK to device over ADB
./build.sh -i

# Filter logcat for real-time BLE, Media, Call and Telemetry debugging
adb logcat -v time -s PulsarBleManager:D MediaStateListener:D TelephonyCallHandler:D PhoneStateMonitor:D
```
