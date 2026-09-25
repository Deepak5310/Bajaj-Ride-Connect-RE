# Bajaj Pulsar NS400Z Ride Connect — Architecture & Developer Guide

## 1. Executive Summary

**Pulsar Ride Connect** (`com.bajaj.rideconnect.re`) is a standalone, lightweight, zero-bloat native Android automotive application engineered to interface directly with the **Bajaj Pulsar NS400Z digital instrument cluster** (`PULSAR6741`, MAC: `C0:63:80:2D:0C:42`).

The instrument cluster utilizes a custom Bluetooth Low Energy (BLE) GATT profile designed by **OTC Engineering**. This document provides a complete technical reference on the wire protocol, Android subsystem integrations, handlebar button handling, verified hardware features, and troubleshooting guidelines.

---

## 2. Verified & Tested Production Status

The following features have been tested and verified on the physical motorcycle:

| Feature | Handlebar Action / Trigger | Verification Status | Implementation Notes |
|---|---|---|---|
| **Media Play / Pause** | Single-press `SET` button | ✅ **Working** | Triggers `TransportControls.play()` / `pause()` with `dispatchMediaButtonEvent` fallback. |
| **Track Skip (Next)** | Long-press / Hold `^` (Up) | ✅ **Working** | Triggers `TransportControls.skipToNext()` with `KEYCODE_MEDIA_NEXT` fallback. |
| **Track Skip (Prev)** | Long-press / Hold `v` (Down) | ✅ **Working** | Triggers `TransportControls.skipToPrevious()` with `KEYCODE_MEDIA_PREVIOUS` fallback. |
| **Volume Up / Down** | Single-press `^` / `v` | ✅ **Working** | Adjusts `AudioManager.STREAM_MUSIC` using cluster volume tenths (0–10) with half-step rounding. |
| **Volume Mute Protection** | Button release / idle | ✅ **Working** | Filters cluster `0a10` Byte 0 idle pulse (`volume=0` when phone `volume > 1`). |
| **Song Playback Ticker** | 1-second background ticker | ✅ **Working** | Continuously streams `0610` frames so track elapsed time (`00:01`, `00:02`, ...) ticks smoothly on cluster LCD. |
| **Phone Battery Gauge** | Phone battery change | ✅ **Working** | Bit-packed `0–4` bar scale into `0210` telemetry (`batteryLevel << 3`), accurately matching bike LCD icons. |
| **Phone Signal Gauge** | Cellular signal strength | ✅ **Working** | Streams `0–4` signal bars into `0210` telemetry. |
| **Bidirectional Volume Sync**| Phone volume rocker buttons | ✅ **Working** | `ContentObserver` on `Settings.System.CONTENT_URI` triggers immediate `0210` telemetry update to bike. |
| **Call Accept / Reject** | Handlebar call switches | ⚠️ **Implemented (Untested)** | Uses `TelecomManager.acceptRingingCall()` / `endCall()` + `KEYCODE_HEADSETHOOK` fallback. |
| **Turn-by-Turn Nav** | Google Maps / Navigation | ℹ️ **Implemented (Optional)** | 48-byte `0110` frame encoding with reverse distance byte ordering. |

---

## 3. System Architecture

```
                               ┌─────────────────────────────────────────────────┐
                               │             Android OS Subsystems               │
                               │  - MediaSessionManager & AudioManager           │
                               │  - TelephonyManager & TelecomManager            │
                               │  - BatteryManager & TelephonyCallback           │
                               │  - Settings.System ContentObserver              │
                               └──────────────────────┬──────────────────────────┘
                                                      │
                                                      ▼
                               ┌─────────────────────────────────────────────────┐
                               │           Application Service Layer             │
                               │  - MediaStateListener.kt                      │
                               │  - TelephonyCallHandler.kt                    │
                               │  - PhoneStateMonitor.kt                       │
                               │  - PulsarNotificationService.kt               │
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

#### Critical Volume Idle Pulse Filter:
When pressing `^` or `v`, the cluster reports the target volume in `data[0] & 0x0F` (0–10). However, upon button release/idle, the cluster sends an idle pulse resetting `data[0] & 0x0F` to `0`. Without filtering, the phone volume drops to 0 (mute).

```java
// Official Bajaj reference filter (Controls.java:163)
if (ev.volumeChanged) {
    int curVol = getCurrentVolumeTenths();
    if (ev.volumeLevel == 0 && curVol > 1) {
        Log.i(TAG, "Ignoring cluster volume=0 idle pulse");
    } else {
        setVolumeFromCluster(ev.volumeLevel);
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

### 8.1 Build Pipeline
The project uses a standalone Python build script without Gradle overhead:
```bash
# Build, package, sign and install directly to connected phone over ADB
./build.sh -i
```
Pipeline stages:
1. `aapt2 compile` & `aapt2 link` $\rightarrow$ Resources & `R.java`
2. `javac -release 17` $\rightarrow$ Compiles Java sources
3. `d8` (Android DEX compiler) $\rightarrow$ Produces `classes.dex`
4. `zipalign` $\rightarrow$ 4-byte aligns APK
5. `apksigner` $\rightarrow$ Signs with v2/v3 signatures

### 8.2 Logcat Monitoring Filters
To debug BLE, Media, Calls, and Telemetry in real time:
```bash
adb logcat -v time -s PulsarBleManager:D MediaStateListener:D TelephonyCallHandler:D PhoneStateMonitor:D
```

---

## 9. Key Source Files Directory

```
app/src/com/bajaj/rideconnect/re/
├── MainActivity.kt             # Modern Automotive Cockpit UI & Map View
├── PulsarBleManager.kt         # BLE GATT Connection, Queue & 500ms Poller
├── PulsarProtocol.kt           # Binary Encoders (0110, 0210, 0610) & Parser (0a10)
├── MediaStateListener.kt       # MediaSession hook, 1s ticker, Volume sync & filter
├── TelephonyCallHandler.kt     # Caller ID & Handlebar Call Accept/Reject
├── PhoneStateMonitor.kt        # Battery %, Signal bars & 4s Heartbeat Telemetry
└── PulsarNotificationService.kt# Android Notification Listener
```
