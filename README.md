# Pulsar Ride Connect RE

[![Android](https://img.shields.io/badge/Android-11%2B-3DDC84?style=flat-square&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.4-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Compose-Material3-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![APK Size](https://img.shields.io/badge/APK_Size-1.8_MB-success?style=flat-square)](app/build.gradle.kts)
[![Hardware](https://img.shields.io/badge/Tested_Bike-Pulsar_NS400Z_UG_(2025)-E53935?style=flat-square)](docs/HANDOFF.md)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

A lightweight, distraction-free, native Android companion app and floating Cockpit HUD for **Bajaj Pulsar & Dominar series** motorcycles. Built via clean-room reverse engineering of the official [Bajaj Ride Connect](https://play.google.com/store/apps/details?id=com.bajajconnect.rideapp) BLE GATT protocol.

---

## Comparison: Official App vs. Our Custom App

| Metric / Feature | [Official Bajaj Ride Connect](https://play.google.com/store/apps/details?id=com.bajajconnect.rideapp) | Pulsar Ride Connect RE |
|---|:---:|:---:|
| **APK Footprint** | ~75 MB+ (React Native / Hermes / Bloatware) | **~1.8 MB** (Pure Native Kotlin + Jetpack Compose) |
| **Privacy & Telemetry** | Background analytics, Firebase, Zersys hooks | **100% Private** — Zero tracking, runs fully offline |
| **Battery Impact** | Heavy (Continuous GPS & Wi-Fi pollers) | **Near-Zero** (Event-driven BLE GATT state) |
| **Navigation Mode** | Proprietary Mappls locked inside app | **Live Google Maps** + 30% Floating Dock HUD |
| **Handlebar Media Controls** | Prone to lag and missed button triggers | **Instant response** (Tested on physical bike) |
| **Volume Control** | Coarse steps, feedback loop stutters | **Smooth down to full mute (0)** + synchronous sync |
| **LCD Track Timer** | Elapsed playback timer frequently freezes | **Continuous 1-second progress ticker** |
| **Connection Recovery** | Requires manual app foregrounding | **Instant auto-reconnect** via saved cluster MAC |

---

## Compatibility

* **Tested Motorcycle**: **Bajaj Pulsar NS400Z UG (2025)**
* **Tested Android OS**: **Android 11** (Xiaomi Mi A3, API 30)
* **Compatible Bikes**: All ICE/Petrol Bajaj motorcycles with Uno Minda / Pricol / OTC Bluetooth LCD clusters:
  * **Pulsar Series**: NS400Z, N250, NS200, N160, NS160
  * **Dominar Series**: Dominar 400, Dominar 250

---

## Physical Handlebar Switchgear Mapping

Based on the left handlebar switch block (Bajaj Owner's Manual, Page 22):

```text
              ┌──────────────┐
              │      ▲       │  Volume Up (Tap) / Next Track (Hold)
       ┌──────┴──────────────┴──────┐
       │     ⊃              SET     │  Call Reject (⊃) / Call Accept (SET) / Play-Pause
  Exit └──────┬──────────────┬──────┘
              │      ▼       │  Volume Down (Tap) / Prev Track (Hold)
              └──────────────┘
```

| Button | Gesture | Call Mode (< 1s) | Media Mode | BLE `0a10` Byte |
|:---:|:---:|---|---|:---:|
| `SET` | Single-press | **Call Accept** | **Play / Pause Toggle** | `Byte 1` (Call Accept), `Byte 6/7` (Play/Pause) |
| `▲` | Tap / Hold | — | **Volume Up** (Tap) / **Next Track** (Hold) | `Byte 0` (Vol nibble), `Byte 8` (Next counter) |
| `⊃` | Single-press | **Call Reject** | Menu Exit | `Byte 2` (Call Reject), `Byte 3` (Reject + SMS) |
| `▼` | Tap / Hold | — | **Volume Down** (Tap) / **Prev Track** (Hold) | `Byte 0` (Vol nibble), `Byte 9` (Prev counter) |

---

## Feature & Testing Status

### Media & Handlebar Switchgear (Tested on Bike)
- [x] **Play / Pause**: Single-press `SET` toggles playback reliably.
- [x] **Next Track**: Long-press `▲` skips forward to next track.
- [x] **Previous Track**: Long-press `▼` skips backward to previous track.
- [x] **Volume Up**: Single-press `▲` increments phone media volume.
- [x] **Volume Down**: Single-press `▼` decrements volume down to complete silence (`0`).
- [x] **Bidirectional Volume Sync**: Phone volume rocker adjustments update cluster gauge in real time.
- [x] **LCD Track Metadata**: Stream Title, Artist, and Album with UTF-8 multi-byte safe truncation ($\le 32$ bytes).
- [x] **Continuous Progress Ticker**: 1-second elapsed time streaming (`00:01`, `00:02`, ...) keeps cluster LCD alive.
- [x] **Floating Cockpit HUD**: 30% dynamic landscape dock alongside Google Maps (70% viewport) with glove-friendly controls.

### Telemetry & BLE Link (Tested on Bike)
- [x] **Phone Battery Gauge**: Quantized to 0–4 bars (20% steps) and streamed via `0210`.
- [x] **Cellular Signal Bars**: Real-time signal strength (0–4 bars) synced to cluster.
- [x] **Persistent Auto-Reconnect**: Automatically caches paired cluster MAC address in `SharedPreferences`.
- [x] **GATT Write Queue Protection**: Stale packet drop and auto-recovery on unexpected disconnects (`status=8`/`19`).

### Calls & Alerts
- [x] **Call Frame & Handlebar Triggers**: Binary telemetry builder (`0210`), caller ID sanitization, and handlebar `0a10` trigger parsing (`SET` Accept, `⊃` Reject) implemented.
- [ ] **Live TelecomManager Hook**: System call accept/reject action dispatching *(Pending bike testing)*.
- [ ] **SMS & App Alerts**: Missed call / SMS counter forwarding *(Protocol frame ready, pending background hook)*.

### Turn-by-Turn Navigation
- [x] **Floating HUD with Google Maps**: Side-by-side cockpit overlay during active navigation.
- [ ] **Cluster LCD TBT Maneuvers (`0110`)**: BLE packet generator implemented in `scripts/tbt_bridge.py`; Google Maps notification scraping bridge into cluster display *(Pending)*.

---

## Protocol & Architecture Reference

The instrument cluster communicates over **Bluetooth Low Energy (GATT)** via OTC Engineering's custom binary protocol.

### Decompiled Source Reference
Decompiled sources from the official app are preserved in the root repository under [`src/com/`](https://github.com/Deepak5310/Bajaj-Ride-Connect-RE/tree/main/src/com):
* **[`src/com/bajajconnect/ble/`](https://github.com/Deepak5310/Bajaj-Ride-Connect-RE/tree/main/src/com/bajajconnect/ble/)**: GATT connection & queue management (`BluetoothLeService.java`, `Controls.java`, `BleFeatures.java`, `CallFrame.java`).
* **[`src/com/bajajconnect/utils/`](https://github.com/Deepak5310/Bajaj-Ride-Connect-RE/tree/main/src/com/bajajconnect/utils/)**: Binary frame builders (`CallFrame.java`).
* **[`src/com/mappls/`](https://github.com/Deepak5310/Bajaj-Ride-Connect-RE/tree/main/src/com/mappls/)**: Mappls navigation SDK reference.

### GATT Protocol Layout

```
Service UUID: 0010676e-6972-6565-6e69-676e4543544f (OTC OTC_SERVICE)
│
├── Char 0210: Phone Telemetry (55 bytes, WRITE_TYPE_DEFAULT)
│   ├── Byte 0: Headset state flag | volume tenths nibble (0-10)
│   ├── Byte 1: Call state | battery gauge (0-4 bars)
│   ├── Byte 2: Cellular signal bars (0-4)
│   └── Bytes 18-50: Caller presence & sanitized caller name/number
│
├── Char 0610: Now-Playing Media (105 bytes, WRITE_TYPE_NO_RESPONSE)
│   ├── Bytes 1-33: Track Title (length prefix + UTF-8 bytes up to 32)
│   ├── Bytes 34-66: Artist Name (length prefix + UTF-8 bytes up to 32)
│   ├── Bytes 67-99: Album Name (length prefix + UTF-8 bytes up to 32)
│   ├── Bytes 100-101: Track position (seconds, big-endian)
│   ├── Bytes 102-103: Track duration (seconds, big-endian)
│   └── Byte 104: Playback state (2 = Playing, 1 = Paused, 0 = Inactive / None)
│
└── Char 0a10: Handlebar Controls (20 bytes, READ / NOTIFY)
    ├── Byte 0: Volume level tenths (bits 0-3, 0-10)
    ├── Byte 1: Call Accept counter (SET during incoming call)
    ├── Byte 2: Call Reject counter (⊃ during incoming call)
    ├── Byte 3: Call Reject with SMS counter
    ├── Byte 6: Play / Resume counter (SET)
    ├── Byte 7: Pause counter (SET)
    ├── Byte 8: Skip Next counter (▲ hold)
    ├── Byte 9: Skip Prev counter (▼ hold)
    └── Byte 10: Stop counter
```

---

## Quick Start

```bash
# 1. Build Debug APK
./gradlew :app:assembleDebug

# 2. Install on Device over ADB
adb install -r app/build/outputs/apk/debug/app-debug.apk

# 3. Setup & Pair
# Open app -> Grant Bluetooth & Notification permissions -> Turn on bike ignition
```

---

## Disclaimer

This repository is an independent reverse engineering and interoperability research project for personal use. It is not affiliated with, endorsed by, or sponsored by Bajaj Auto Ltd. Does not alter engine or safety-critical ECU parameters.