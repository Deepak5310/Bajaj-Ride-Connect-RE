# Pulsar Ride Connect (Pulsar & Dominar) — Developer Handoff & Status

## 1. What this project is

**Pulsar Ride Connect** (`StudioApp/`) is a standalone, lightweight, high-performance native Android application engineered to interface directly with **Bajaj Pulsar Series (NS400Z, N250, F250, NS200, N160, NS160, N150) and Dominar Series (400, 250)** digital instrument clusters over Bluetooth Low Energy (BLE GATT).

**Scope & Mission**: Strictly focused on **Now-Playing Media streaming & Physical Handlebar Switchgear control** (Play/Pause, Track Skip, Volume Up/Down). Zero EV/Chetak support, zero telemetry/call bloat.

---

## 2. Tested & Confirmed Working Features (Physical Bike)

Tested and verified on the physical Bajaj Pulsar NS400Z motorcycle:

1. **Volume Buttons (`^` / `v` single-press)**:
   - Increments and decrements phone media volume smoothly via `AudioManager.STREAM_MUSIC`.
   - Uses cluster volume tenths (0–10) with official Bajaj half-step rounding calculation (`d - (int)d >= 0.5`).
2. **Volume Down to Full Mute & Synchronous Feedback**:
   - Matches official Bajaj `Controls.java` `volumeToSet` delta tracking: supports smooth step-down to complete silence/mute (`0`) and step-up to maximum (`10`).
   - Direct synchronous telemetry (`PhoneStateMonitor.sendImmediateVolumeTelemetry`) feeds back the new volume nibble immediately without waiting for asynchronous `AudioService` updates, preventing echo loops.
3. **Track Skip (`^` / `v` long-press / hold)**:
   - Long-press `^` skips to **Next Track**.
   - Long-press `v` skips to **Previous Track**.
   - Dispatches via `MediaController.TransportControls` with fallback to `dispatchMediaKeyEvent`.
4. **Media Play / Pause (`SET` single-press)**:
   - Single-press `SET` on the left handlebar switch toggles Play and Pause reliably.
5. **Continuous Playback Ticker (`0610`)**:
   - 1-second background `progressTicker` continuously streams updated elapsed seconds (`00:01`, `00:02`, ...) so the cluster LCD playback time never freezes.
6. **Bidirectional Hardware Volume Sync**:
   - Phone volume rocker adjustments update the HUD and cluster volume synchronously.

---

## 3. Implementation Status Summary

| Subsystem / Feature | File Location | Status |
|---|---|---|
| **Minimalist Jetpack Compose Cockpit HUD** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/ui/cockpit/CockpitHud.kt` | ✅ **Production Ready** — Minimal clean automotive UI (OLED Obsidian + Cobalt Titanium palette), glove-friendly 44–52dp transport controls, Feather Icons (`compose-icons-feather`), cached `ImageBitmap` album art, auto-scrolling `basicMarquee()` track titles, portrait rotation toast on edge-pill tap, punch-hole camera offset (22dp), and reusable internal Handlebar Guide overlay |
| **BLE GATT Core Engine** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PulsarBleManager.kt` | ✅ **Production Ready** — Dynamic Bluetooth enable prompt, automatic connect on BT state ON, persistent last-connected cluster MAC (`SharedPreferences`), full GATT write-queue & characteristic reset on unexpected disconnect, StateFlow reactive state, MTU 247 |
| **Binary Protocol Frames** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PulsarProtocol.kt` | ✅ **Complete & Active** — Clean binary frame builders for telemetry (`0210`), media (`0610` with UTF-8 multi-byte safe `writeUtf8Field` truncation), and handlebar switchgear events (`0a10`) |
| **Phone State & Battery Monitor** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PhoneStateMonitor.kt` | ✅ **Complete & Active** — Streams phone battery gauge (0–4 bars), signal strength (0–4), and bidirectional volume sync to cluster (`0210`) |
| **Media Controller & Ticker** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MediaStateListener.kt` | ✅ **Verified on Bike** — Real-time Title, Artist & Album metadata (`METADATA_KEY_ALBUM`), interactive tap/drag seekbar, 1s ticker LCD streaming, persistent permission retention with IPC rebind retry |
| **Handlebar Switchgear Integration** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MediaStateListener.kt` | ✅ **Verified on Bike** — `SET` to play/pause, `^`/`v` hold to skip tracks, `^`/`v` click volume with volume mute protection |
| **Floating HUD Service** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/FloatingHudService.kt` | ✅ **Production Ready** — Single overlay architecture managing portrait pill and landscape dock, monochrome status bar icon (`ic_stat_pulsar`), 1-tap notification `EXIT` action, and safe window manager lifecycle |
| **Permissions Gatekeeper & Launcher** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MainActivity.kt` | ✅ **Production Ready** — Lean, minimal launcher handling Bluetooth/Location (Android 11+) and overlay permissions, starting FloatingHudService, launching Google Maps navigation, with zero duplicate overlay rendering |
| **Notification Listener & IPC Rebind** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PulsarNotificationService.kt` | ✅ **Production Ready** — Dual-layer listener verification (`NotificationManagerCompat` + secure settings) and automatic `requestRebindIfGranted()` binder recovery |
| **R8 & ProGuard Optimization** | `StudioApp/app/proguard-rules.pro` | ✅ **Production Ready** — R8 full minification & resource shrinking (`isMinifyEnabled = true`, `isShrinkResources = true`), trimming APK footprint from 30MB down to **1.8MB** (94% reduction) |
| **GitHub Actions CI Pipeline** | `StudioApp/.github/workflows/android-ci.yml` | ✅ **Active** — Automated JDK 21 + Gradle test, `lintDebug`, and `assembleDebug` APK artifact upload |
| **Legacy View Prototype** | `app/src/com/bajaj/rideconnect/re/` | 📦 **Archived Reference** — Original View/XML prototype |

---

## 4. Hardware Details & Protocol Essentials

- **Target Device:** Bajaj Pulsar Series / Dominar Series (discovered dynamically via advertised OTC Service UUID / device name keywords and persisted to `SharedPreferences`)
- **Service UUID:** `0010676e-6972-6565-6e69-676e4543544f`
- **Active Characteristics:**
  - `0210` — Phone Status & Battery Telemetry, 55-byte write (`WRITE_TYPE_DEFAULT`)
  - `0610` — Now-Playing Media, 105-byte write (`WRITE_TYPE_NO_RESPONSE`)
  - `0a10` — Handlebar Controls, 20-byte read / notify (CCCD `0x2902`, active 350ms poller)

*For detailed byte maps, bitmasks, and packet diagrams, see [docs/DEVELOPER_GUIDE.md](docs/DEVELOPER_GUIDE.md).*

---

## 5. Build & Quick Commands

```bash
# Build StudioApp debug APK
cd StudioApp && ./gradlew :app:assembleDebug

# Build optimized release APK with R8 minification (1.8MB)
cd StudioApp && ./gradlew :app:assembleRelease

# Filter logcat for real-time BLE, Media, and Telemetry debugging
adb logcat -v time -s PulsarBleManager:D MediaStateListener:D FloatingHudService:D
```

