# Bajaj Pulsar NS400Z Ride Connect — Architecture & Developer Guide

## 1. Executive Summary

**Pulsar Ride Connect** (`com.bajaj.rideconnect.re`) is a standalone, lightweight, zero-bloat native Android automotive application engineered to interface directly with **Bajaj Pulsar & Dominar digital instrument clusters** over Bluetooth Low Energy (BLE).

The instrument cluster utilizes a custom Bluetooth Low Energy (BLE) GATT profile designed by **OTC Engineering**. This document provides a complete technical reference on the wire protocol, Android subsystem integrations, handlebar button handling, verified hardware features, and troubleshooting guidelines.

---

## 2. Verified & Tested Production Status

The following features have been tested and verified on the physical motorcycle:

| Feature | Handlebar Action / Trigger | Verification Status | Implementation Notes |
|---|---|---|---|
| **Media Play / Pause** | Single-press `SET` button | ✅ **Working** | Triggers `TransportControls.play()` / `pause()` with `dispatchMediaButtonEvent` fallback. |
| **Track Skip (Next)** | Long-press / Hold `^` (Up) | ✅ **Working** | Triggers `TransportControls.skipToNext()` with `KEYCODE_MEDIA_NEXT` fallback. |
| **Track Skip (Prev)** | Long-press / Hold `v` (Down) | ✅ **Working** | Auto-double skips if played > 2.5s so music players switch to previous track instead of rewinding to 0:00. |
| **Volume Control / Mute** | Single-press `^` / `v` | ✅ **Working** | Adjusts `AudioManager.STREAM_MUSIC` using cluster volume tenths (0–10) down to full mute (0) matching Bajaj `Controls.java`. |
| **Song Playback Ticker** | 1-second background ticker | ✅ **Working** | Continuously streams `0610` frames so track elapsed time (`00:01`, `00:02`, ...) ticks smoothly on cluster LCD. |
| **Phone Battery Gauge** | Phone battery change | ✅ **Working** | Bit-packed `0–4` bar scale into `0210` telemetry (`batteryLevel << 3`), accurately matching bike LCD icons. |
| **Phone Signal Gauge** | Cellular signal strength | ✅ **Working** | Streams `0–4` signal bars into `0210` telemetry; sets 0 when SIM is absent or airplane mode active. |
| **Bidirectional Volume Sync**| Phone volume rocker buttons | ✅ **Working** | `ContentObserver` on `Settings.System.CONTENT_URI` triggers immediate `0210` telemetry update to bike. |
| **Call Handling** | Telephony permissions | 🚫 **Dropped** | Removed telephony permissions & call handlers per zero-distraction riding design. |
| **Turn-by-Turn Nav** | Google Maps / Navigation | ℹ️ **Background Bridge** | 48-byte `0110` frame encoding with reverse distance byte ordering sent to bike LCD. |

---

## 3. System Architecture

```
                               ┌─────────────────────────────────────────────────┐
                               │             Android OS Subsystems               │
                               │  - MediaSessionManager & AudioManager           │
                               │  - BatteryManager & TelephonyCallback (Signal)  │
                               │  - WindowManager (SYSTEM_ALERT_WINDOW HUD)      │
                               │  - Settings.System ContentObserver              │
                               └──────────────────────┬──────────────────────────┘
                                                      │
                                                      ▼
                               ┌─────────────────────────────────────────────────┐
                               │           Application Service Layer             │
                               │  - MediaStateListener.kt                        │
                               │  - PhoneStateMonitor.kt (Battery & Signal)      │
                               │  - PulsarForegroundService.kt (BLE & Telemetry) │
                               │  - PulsarNotificationService.kt (TBT Parser)    │
                               └──────────────────────┬──────────────────────────┘
                                                      │
                                                      ▼
                               ┌─────────────────────────────────────────────────┐
                               │             BLE GATT Core Engine                │
                               │  - PulsarBleManager.kt (Queue & GATT client)  │
                               │  - PulsarProtocol.kt (Binary Frame Encoders)  │
                               └──────────────────────┬──────────────────────────┘
                                                      │
                                     BLE Wireless Link (MTU 247)
                                                      │
                                                      ▼
                               ┌─────────────────────────────────────────────────┐
                               │     Bajaj Pulsar NS400Z Digital Cluster         │
                               │  - OTC Engineering GATT Profile (0010676e...)   │
                               │  - Dot-Matrix LCD (Nav, Media, Battery, Calls)  │
                               │  - Left Handlebar Switchgear (SET, ^, v, Mode)  │
                               └─────────────────────────────────────────────────┘
```

---

## 4. OTC BLE GATT Protocol Specification

### 4.1 Service & Characteristic Topology
* **Base Service UUID:** `0010676e-6972-6565-6e69-676e4543544f`
* **CCCD Descriptor:** `00002902-0000-1000-8000-00805f9b34fb`
* **Negotiated MTU:** 247 bytes

| Short UUID | Full UUID | Direction | Properties | Size | Purpose |
|---|---|---|---|---|---|
| `0110` | `0110676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | 48 B | Turn-by-Turn Navigation instructions & glyphs |
| `0210` | `0210676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | 55 / 89 B | Phone status (battery, signal, call state, caller ID, volume) |
| `0310` | `0310676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | Variable | Missed calls list |
| `0410` | `0410676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | Variable | App / SMS alerts |
| `0510` | `0510676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | 177 B | Playlist titles |
| `0610` | `0610676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | 105 B | Now Playing metadata (Title, Artist, Album, Elapsed/Duration) |
| `0910` | `0910676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | 151 B | Favorite contacts |
| `0a10` | `0a10676e-6972-6565-6e69-676e4543544f` | Dash $\rightarrow$ App | Read / Notify | 20 B | Handlebar switch event counters & volume level |
| `0b10` | `0b10676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write | Variable | Recent call logs |

---

## 5. Binary Frame Structures & Encoding

### 5.1 Handlebar Controls Packet (`0a10` — Dash $\rightarrow$ App, 20 Bytes)
The cluster characteristic `0a10` uses **cumulative event counters**. Each button press increments the counter byte for that action.

```
Byte 0:       (Volume Level & 0x0F) | ((DialSource & 0x03) << 4)
Byte 1:       Call Accept Counter (increments on SET during ringing call)
Byte 2:       Call Reject Counter (increments on Mode / Hold during call)
Byte 3:       Call Reject with SMS Counter
Byte 4:       Playlist Requests (Bit 7: New Req, Bit 1: Page Req)
Byte 5:       Take Me Home Trigger Counter
Byte 6:       Music Play / Resume Counter
Byte 7:       Music Pause Counter
Byte 8:       Music Skip Next Counter (increments on long-press ^)
Byte 9:       Music Skip Previous Counter (increments on long-press v)
Byte 10:      Music Stop Counter
Byte 11:      Missed Calls Request Counter
Byte 12:      Alerts Request Counter
Byte 13:      Launch Media Player Trigger
Bytes 14-19:  Playlist index, speed-dial, reserved
```

#### Counter Delta & Edge-Detection Algorithm:
```java
// Seed baseline counters on first packet to prevent phantom clicks
if (!handlebarInitialized) {
    lastMusicPlayCtr = data[6] & 0xFF;
    lastMusicPauseCtr = data[7] & 0xFF;
    lastMusicNextCtr = data[8] & 0xFF;
    lastMusicPrevCtr = data[9] & 0xFF;
    lastCallAcceptCtr = data[1] & 0xFF;
    lastCallRejectCtr = data[2] & 0xFF;
    lastVolumeNibble = data[0] & 0x0F;
    handlebarInitialized = true;
    return null;
}

// Trigger action only when current counter != last counter
if ((data[8] & 0xFF) != lastMusicNextCtr) {
    ev.musicNext = true;
    lastMusicNextCtr = data[8] & 0xFF;
}
```

#### Handlebar Volume Control & Synchronous Telemetry Feedback:
Matching official Bajaj `Controls.java`, volume level (0–10) is received in Byte 0 (`data[0] & 0x0F`) and mapped directly to `AudioManager.STREAM_MUSIC`:
1. **Delta Tracking (`volumeToSet`)**: Volume adjustments are dispatched whenever `newNibble != volumeToSet`, supporting full step-down to complete silence/mute (`0`) and step-up to maximum (`10`).
2. **Synchronous Telemetry Feedback (`PhoneStateMonitor.sendImmediateVolumeTelemetry(vol)`)**: Immediately feeds the confirmed volume nibble back to the dash in the `0210` telemetry packet, eliminating echo loops from asynchronous `AudioManager` status queries.

```kotlin
if (ev.volumeChanged) {
    val newNibble = ev.volumeLevel
    if (newNibble != volumeToSet) {
        volumeToSet = newNibble
        setVolumeFromCluster(newNibble)
    }
}
```

---

### 5.2 Now Playing Media Frame (`0610` — App $\rightarrow$ Dash, 105 Bytes)

```
Byte 0:       Header (0x01)
Byte 1:       Title Length (N <= 31)
Bytes 2-33:   Track Title (UTF-8 bytes, null padded)
Byte 34:      Artist Length (N <= 31)
Bytes 35-66:  Artist Name (UTF-8 bytes, null padded)
Byte 67:      Album Length (N <= 31)
Bytes 68-99:  Album Name (UTF-8 bytes, null padded)
Bytes 100-101:Position in seconds (uint16 Big-Endian: (pos >> 8) & 0xFF, pos & 0xFF)
Bytes 102-103:Duration in seconds (uint16 Big-Endian: (dur >> 8) & 0xFF, dur & 0xFF)
Byte 104:     Playback Status (0 = Stopped/None, 1 = Paused, 2 = Playing)
```

*Note: In the NS400Z cluster firmware layout, Artist is at bytes 34–66 and Album is at bytes 67–99.*

---

### 5.3 General Telemetry & Status Frame (`0210` — App $\rightarrow$ Dash, 55 Bytes Compact)

```
Byte 0:       ((isHeadset ? 1 : 0) << 4) | (volumeLevel & 0x0F) | 0xC0
Byte 1:       (callState & 0x07) | ((batteryLevel & 0x07) << 3)
Byte 2:       signalBars & 0x07 (0 to 4)
Byte 3:       Active Call Flag (callState == 3 ? 1 : 0)
Byte 4:       No Call Flag (callState == 3 ? 0 : 1)
Bytes 5-12:   Reserved / ACKs
Byte 13:      Missed Calls Count
Byte 15:      Unread SMS Count
Byte 18:      Caller Active Flag (1 = Display Caller, 0 = Idle)
Byte 20:      Caller String Length (max 30 chars)
Bytes 21-50:  Caller Name / Number (Sanitized ASCII / UTF-8)
Byte 53:      Sequence Heartbeat Counter
Byte 54:      Sequence Heartbeat Counter
```

#### Battery Level Discrete Mapping (0–4 Bars):
```java
public static int getBatteryLevel(int percent) {
    if (percent < 20) return 0; // Empty / 0 bars
    if (percent < 40) return 1; // 1 bar
    if (percent < 60) return 2; // 2 bars
    if (percent < 80) return 3; // 3 bars
    return 4;                   // Full / 4 bars
}
```

---

### 5.4 Turn-by-Turn Navigation Frame (`0110` — App $\rightarrow$ Dash, 48 Bytes)

```
Byte 0:       (ActiveFlag: 1=Active, 0=Stop) | ((DistanceUnit: 1=Meters, 0=Km) << 4) | ((!isPm ? 1 : 0) << 7)
Byte 1:       Maneuver Glyph ASCII (e.g. 71='G' Straight, 73='I' Left, 74='J' Right)
Bytes 2-5:    Step Distance [Decimals LSB, Decimals MSB, Integer LSB, Integer MSB] (REVERSED)
Byte 6:       ETA Minute (0–59)
Byte 7:       (ETA Hour: 1–12) | ((RoundaboutExit & 0x0F) << 4)
Bytes 8-11:   Total Distance [Decimals LSB, Decimals MSB, Integer LSB, Integer MSB] (REVERSED)
Byte 12:      (TotalDistanceUnit: 1=Meters, 0=Km) | ((GpsStatus: 0=NoFix, 1=Active) << 2)
Byte 13:      Take Me Home ACK Counter
Byte 14:      Street Name Length (max 31)
Bytes 15-46:  Street Name / Maneuver Text (Sanitized dot-matrix ASCII)
Byte 47:      8-bit Additive Checksum: sum(Byte[0..46]) & 0xFF
```

#### Important TBT Protocol Gotchas:
1. **Distance Bytes Order:** Distance array `[unit, decMSB, decLSB, intMSB, intLSB]` is copied in reverse order into `frame[2..5]`.
2. **AM/PM Bit Inversion:** Bit 7 of Byte 0 is `1` for **AM** and `0` for **PM** (`(!isPm ? 1 : 0) << 7`).
3. **Glyph Code for KEEP_RIGHT:** Glyph code is `88` (not `80`, which is `U_TURN_RIGHT`).
4. **LCD Crash Prevention:** Sending malformed `0110` frames can cause the dot-matrix LCD renderer to freeze or blank (recovers on ignition power-cycle).

---

## 6. Vehicle Data Capabilities (Odometer / Trip A / Battery Voltage)

### Can the App Read Bike Odometer or Trip A over BLE?
**No.** The OTC BLE GATT profile on the NS400Z instrument cluster is strictly a **Display Terminal & Remote Control** interface. The cluster firmware does **not** expose ECU, CAN-bus, or sensor data (Odometer, Trip A/B, fuel level, bike battery voltage) over any BLE characteristic.

### How the Official App Displays Trip & Ride Stats:
The official Bajaj Connect app computes Trip Distances, Ride Time, Average Speed, and Top Speed using the **Phone's GPS Location Sensor** while connected to the bike.

---

## 7. Android Subsystem Integration

### 7.1 Media Integration (`MediaStateListener.kt`)
* Hooks into active Android `MediaSession` via `MediaSessionManager.addOnActiveSessionsChangedListener()`.
* Captures metadata changes (`MediaMetadata.METADATA_KEY_TITLE`, `ARTIST`, `ALBUM`, `DURATION`, `ALBUM_ART`).
* Executes transport commands (`play`, `pause`, `skipToNext`, `skipToPrevious`, `seekTo`) with `dispatchMediaKeyEvent` fallback.
* Registers `ContentObserver` on `Settings.System.CONTENT_URI` to synchronize phone volume adjustments with the cluster in real time.
* Runs a 1-second `progressTicker` Runnable that calculates interpolated elapsed position and broadcasts `0610` BLE frames to the bike cluster.

### 7.2 Telephony Integration (`TelephonyCallHandler.kt`)
* Uses `TelephonyCallback.CallStateListener` (Android 12+ API 31) and legacy `TelephonyManager` fallback.
* Queries contact names using `ContactsContract.PhoneLookup`.
* Dispatches caller ID string and call state (`1=RINGING`, `3=ACTIVE_CALL`, `0=IDLE`) to `0210`.
* Answers ringing calls via `TelecomManager.acceptRingingCall()` and ends calls via `TelecomManager.endCall()`.

### 7.3 Telemetry & Battery Monitor (`PhoneStateMonitor.kt`)
* Listens to `Intent.ACTION_BATTERY_CHANGED` (sticky broadcast).
* Listens to cellular signal strength via `TelephonyCallback.SignalStrengthsListener`.
* Checks for connected audio accessories (Bluetooth headsets, A2DP, wired earphones) via `AudioManager.getDevices()`.
* Dispatches a periodic 4-second heartbeat telemetry frame (`0210`) to keep cluster indicators fresh.

---

## 8. Build, Deploy & Verification

### 8.1 StudioApp Gradle Build & CI Pipeline
`StudioApp/` uses the standard Android Gradle Plugin (Kotlin 2.2 / Jetpack Compose Material3) with an automated GitHub Actions CI workflow (`.github/workflows/android-ci.yml`) that runs `./gradlew test lintDebug assembleDebug` on every push and PR:
```bash
# Build and install StudioApp debug APK over ADB
cd StudioApp && ./gradlew :app:assembleDebug && adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### 8.2 Legacy Standalone Build Script (`app/`)
The legacy View prototype uses a standalone Bash build script without Gradle overhead:
```bash
# Build, package, sign and install directly to connected phone over ADB
./build.sh -i
```

### 8.3 Logcat Monitoring Filters
To debug BLE, Media, and Telemetry in real time:
```bash
adb logcat -v time -s PulsarBleManager:D MediaStateListener:D PhoneStateMonitor:D FloatingHudService:D
```

---

## 9. Key Source Files Directory

```
StudioApp/app/src/main/java/com/bajaj/rideconnect/re/
├── MainActivity.kt             # Minimal launcher (BT & overlay permissions, 1-tap Maps launch)
├── FloatingHudService.kt       # Single overlay service (portrait pill, landscape dock, notification EXIT action)
├── PulsarBleManager.kt         # BLE GATT Engine, Write Queue reset on disconnect, MAC persistence & 350ms poller
├── PulsarProtocol.kt           # Binary Encoders (0210, 0610 with UTF-8 safe writeUtf8Field, 0a10 parser)
├── MediaStateListener.kt       # MediaSession controller, Title/Artist/Album sync, 1s ticker, permission retry & Volume filter
├── PulsarNotificationService.kt# Dual-layer listener verification (NotificationManagerCompat) & requestRebind recovery
├── PhoneStateMonitor.kt        # Battery (0-4 bars), Cellular Signal (0-4 bars) & Volume ContentObserver
├── ui/cockpit/CockpitHud.kt    # Minimalist Automotive Music Cockpit UI, marquee title, cached album art, Edge Tab
└── ui/theme/Color.kt           # OLED Obsidian + Cobalt Titanium palette tokens
```

---

## 10. StudioApp Compose Cockpit HUD & Reliability Highlights

### 10.1 UI/UX Architecture & Ergonomics
* **Target Motorcycles**: Bajaj Pulsar Series (NS400Z, N250, F250, NS200, N160, NS160, N150) & Dominar Series (400, 250). Strictly Petrol/ICE motorcycles — zero EV/Chetak support.
* **Minimalist Automotive Palette**: OLED Obsidian (`#090B10`), Charcoal Slate (`#131722`), Electric Cobalt (`#3B82F6`), Titanium White action button (`#F8FAFC`), and subtle hairline borders (`#222938`) eliminating distraction and glare.
* **Custom Brand Identity**: Custom Pulsar emblem launcher icon (`ic_launcher_foreground.xml` + `mipmap-*`) and monochrome status bar notification silhouette (`ic_stat_pulsar.xml`).
* **Pure Media Focus & Zero-Allocation Ticker**: Dedicated floating music card with cached `ImageBitmap` album art (`remember(mediaInfo.albumArt)`), auto-scrolling `basicMarquee()` track titles, interactive seekbar, primary playback controls (44–52dp glove-friendly touch targets), and punch-hole camera offset (22dp).
* **Single Overlay Architecture & 30% Dynamic Scaling**: The floating HUD overlay is managed solely by `FloatingHudService`, eliminating duplicate HUD invocations in `MainActivity`. In landscape orientation, the HUD dynamically scales to 30% of screen width (`(screenWidth * 0.30f).toInt()`), leaving 70% of screen real estate for Google Maps navigation with optimal ergonomics and zero text clipping.
* **Safe Compose Teardown**: Explicitly invokes `view.disposeComposition()` in `onDestroy()` before WindowManager view removal, instantly halting background Compose animations (`PulsingDot`), coroutines, and observers without memory leaks.
* **Streamlined Cockpit Footer Deck**: Modern 2-element footer featuring a full-width BLE status pill (`CONNECT BIKE >` / `LINKED >`) and an amber circular power exit button (`⏻`), providing instant status awareness and rapid shutdown.
* **Portrait Ergonomics & 1-Tap Notification Exit**: Launching the app or tapping the collapsed edge pill in Portrait mode shows a clear rotation toast (`"Rotate to landscape to use Cockpit HUD"`), while the foreground notification provides a direct **EXIT** action button (`ACTION_STOP_SERVICE`) so riders can stop the service in Portrait mode without rotating their phone.
* **Automotive Monospace Typography & Minimalist Iconography**: Utilizes `PulsarTypography` tokens (`MonospaceNumeric`, `MonospaceMeta`) for jitter-free real-time telemetry and track timers, combined with `br.com.devsrsouza.compose.icons:feather` (Feather Icons) for uniform 2px stroke vector iconography.

### 10.2 BLE GATT & Protocol Hardening
* **UTF-8 Multi-Byte Safe Truncation (`PulsarProtocol.writeUtf8Field`)**: Safely truncates track, artist, and album strings to $\le 31$ UTF-8 bytes without splitting multi-byte characters (Devanagari, emojis, accented symbols) or overflowing field boundaries in the 105-byte `0610` packet.
* **Unexpected Disconnect Queue Recovery**: Resets `charTelemetry`, `charMedia`, `charControls`, `writeQueue`, and `isWriting` on unexpected GATT disconnects (`status=8` / `status=19`) so reconnections never deadlock the write queue.
* **Dynamic Cluster MAC Persistence**: Automatically saves the verified OTC cluster MAC address to `SharedPreferences` (`pulsar_ble_prefs` / `last_cluster_mac`) upon service discovery, enabling instant reconnection to any rider's Pulsar/Dominar cluster alongside keyword matching.

### 10.3 R8 Minification, ProGuard & Release Optimization
* **R8 Minification & Resource Stripping**: `isMinifyEnabled = true` and `isShrinkResources = true` enabled in the release build type.
* **Custom ProGuard Rules (`proguard-rules.pro`)**: Keeps framework callbacks (`BluetoothGattCallback`, `ScanCallback`), system services (`NotificationListenerService`, `MediaController.Callback`), Compose data classes (`MediaTrackInfo`, `BleConnectionState`, `HandlebarEvent`), and Feather Icons (`br.com.devsrsouza.compose.icons`).
* **Ultra-Light Release Footprint**: Strips APK size from 30MB down to **1.7MB** (a 94% reduction) with zero dead code or unused assets.
* **Modern Permissions & Storage**: Adds Android 13+ `POST_NOTIFICATIONS` runtime declaration, sets `android:allowBackup="false"`, and provides dual backup rules (`dataExtractionRules` for Android 12+ and `fullBackupContent` for Android 10-11) preventing BLE token leakage.

### 10.4 Notification Listener Rebind & Permission Retention
* **Dual-Layer Listener Detection**: Queries `NotificationManagerCompat.getEnabledListenerPackages(context)` with fallback parsing of `enabled_notification_listeners` secure settings.
* **Automatic Binder Recovery (`requestRebindIfGranted`)**: Forces Android IPC binder reattachment via `NotificationListenerService.requestRebind()` on process startup and activity resume.
* **Transient SecurityException Grace**: Prevents falsely resetting `hasPermission = false` when `msm.getActiveSessions` encounters transient binder connection delays; schedules automated retries and immediately renders the ready media controller when sessions activate.

