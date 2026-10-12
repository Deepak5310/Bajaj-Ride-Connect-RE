# Pulsar Ride Connect RE

[![Android](https://img.shields.io/badge/Android-11%2B-3DDC84?style=flat-square&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.4-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Compose-Material3-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![APK Size](https://img.shields.io/badge/APK_Size-1.8_MB-success?style=flat-square)](app/build.gradle.kts)
[![Tested Bike](https://img.shields.io/badge/Tested_Bike-Pulsar_NS400Z_UG-E53935?style=flat-square)](docs/HANDOFF.md)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

A lightweight, distraction-free native Android companion app and floating Cockpit HUD for **Bajaj Pulsar & Dominar series** motorcycles. Reverse-engineered from official Bajaj Ride Connect BLE GATT protocol to deliver instant handlebar switchgear control, live Google Maps side-docking, and zero telemetry bloat.

---

## Official App vs. Pulsar Ride Connect RE

| Metric / Feature | Official Bajaj Ride Connect | Pulsar Ride Connect RE |
|---|:---:|:---:|
| **APK Footprint** | ~75 MB+ (React Native / Bloatware) | **~1.8 MB** (Pure Native Kotlin + Compose) |
| **Privacy & Telemetry** | Background analytics, Firebase, Zersys | **100% Offline** — Zero analytics, zero permissions bloat |
| **Battery Consumption** | Heavy (Continuous GPS & Wi-Fi pollers) | **Near-Zero** (Event-driven BLE GATT state) |
| **Navigation Mode** | Proprietary Mappls locked inside app | **Live Google Maps** + 30% Dynamic Floating Dock HUD |
| **Switchgear Response** | Prone to lag and missed button triggers | **Instant response** (Tested on physical bike) |
| **Volume Control** | Coarse steps, feedback loop stutters | **Smooth down to full mute (0)** + real-time sync |
| **LCD Track Timer** | Elapsed playback timer frequently freezes | **Continuous 1-second progress ticker** |
| **Connection Recovery** | Requires manual app foregrounding | **Instant auto-reconnect** via saved cluster MAC |

---

## Compatibility

* **Tested Motorcycle**: **Bajaj Pulsar NS400Z UG (2025)**
* **Tested Android OS**: **Android 11 & Android 16**
* **Compatible Bikes**: All ICE/Petrol Bajaj motorcycles with Uno Minda / Pricol / OTC Bluetooth LCD clusters (Pulsar & Dominar series).

---

## Handlebar Switchgear Mapping

Left switch block controls (based on Pulsar NS400Z):

```text
              ┌──────────────┐
              │      ▲       │  Volume Up (Tap) / Next Track (Hold)
       ┌──────┴──────────────┴──────┐
       │     ⊃              SET     │  Exit / Dismiss (⊃) / Play-Pause (SET)
  Exit └──────┬──────────────┬──────┘
              │      ▼       │  Volume Down (Tap) / Prev Track (Hold)
              └──────────────┘
```

| Switch | Gesture | Media Action | BLE `0a10` Byte |
|:---:|:---:|---|:---:|
| `SET` | Single-press | **Play / Pause Toggle** | `Byte 6` (Play) / `Byte 7` (Pause) |
| `▲` | Tap / Long-press | **Volume Up** (Tap) / **Next Track** (Hold $\ge 1$s) | `Byte 0` (Vol nibble) / `Byte 8` (Next counter) |
| `▼` | Tap / Long-press | **Volume Down** (Tap down to mute `0`) / **Prev Track** (Hold $\ge 1$s) | `Byte 0` (Vol nibble) / `Byte 9` (Prev counter) |
| `⊃` | Single-press | **HUD Dismiss / Menu Exit** | `Byte 2` (Exit counter) |

---

## Verified Capabilities (Tested on Physical Bike)

### Media & Switchgear
- [x] **Play / Pause**: Single-press `SET` toggles playback reliably.
- [x] **Track Skip**: Long-press `▲` skips forward; long-press `▼` skips backward.
- [x] **Volume Control**: Tap `▲`/`▼` adjusts volume smoothly with half-step rounding calculation.
- [x] **Full Mute Step-Down**: Step down smoothly to complete silence/mute (`0`) matching `Controls.java`.
- [x] **Idle Release Filter**: Drops transient `volume=0` release pulses when `target > 1` or stepping up.
- [x] **Bidirectional Volume Sync**: Phone volume rocker updates HUD and cluster gauge synchronously.
- [x] **LCD Track Metadata**: Streams Title, Artist, and Album with UTF-8 multi-byte safe truncation ($\le 32$ B).
- [x] **Continuous Playback Ticker**: 1-second progress ticker streams elapsed time (`00:01`, `00:02`, ...).

### Telemetry & BLE Link
- [x] **Phone Battery Gauge**: Maps phone battery percentage to 0–4 bars (20% steps) in `0210`.
- [x] **Persistent Auto-Reconnect**: Automatically caches paired cluster MAC address in `SharedPreferences`.
- [x] **GATT Write Queue Protection**: Stale packet drop and auto-recovery on disconnects (`status=8`/`19`).
- [x] **Floating Cockpit HUD**: 30% dynamic landscape dock alongside Google Maps (70% viewport).

---

## Pending & Deferred Tasks

Features mapped from official protocol frames, but deferred from active SIM-less build for zero permissions:

- [ ] **Incoming Calls & Caller ID (`0210`, `0a10`)**: Telephony listener, cluster caller name, and handlebar accept/reject.
- [ ] **Dynamic Network Signal Sync (`0210`)**: Currently streams constant 4 bars (`DUMMY_SIGNAL_BARS = 4`) for SIM-less motorcycle setups; real-time cellular signal polling deferred.
- [ ] **Missed Calls (`0310`)**: 74-byte missed call frames and counter in `0210` telemetry.
- [ ] **SMS & WhatsApp Alerts (`0410`)**: 40-byte text notification banners to cluster dot-matrix LCD.
- [ ] **Cluster TBT Navigation (`0110`)**: Google Maps notification scraping bridge to 48-byte turn frames.

---

## Protocol Layout (OTC GATT Service)

```text
Service UUID: 0010676e-6972-6565-6e69-676e4543544f
├── Char 0210 (Telemetry, 55 B): Byte 0: Headset & Volume | Byte 1: Battery (0-4) | Byte 2: Signal (4 bars dummy)
├── Char 0610 (Media, 105 B):    Bytes 1-33: Title | Bytes 34-66: Artist | Bytes 67-99: Album | Bytes 100-104: Time & State
└── Char 0a10 (Controls, 20 B):  Byte 0: Vol nibble | Byte 6/7: Play/Pause | Byte 8: Next | Byte 9: Prev | Byte 2: Exit
```

---

## Build & Install

```bash
# 1. Build optimized debug APK
./gradlew :app:assembleDebug

# 2. Install directly over ADB
adb install -r app/build/outputs/apk/debug/app-debug.apk

# 3. Setup & Pair
# Open app -> Grant Bluetooth & Notification access -> Turn on motorcycle ignition
```

---

## Disclaimer

Independent reverse engineering and interoperability research project for personal use. Not affiliated with or endorsed by Bajaj Auto Ltd. Does not alter engine or safety-critical ECU parameters.