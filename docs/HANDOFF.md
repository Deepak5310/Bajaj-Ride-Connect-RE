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
2. **Volume Mute Protection & Telemetry Feedback**:
   - Fixed the issue where single-press `^` from mute rebound back to 0.
   - Direction & timestamp tracking (`MediaStateListener.kt`) filters cluster `0a10` Byte 0 idle pulses (`volume=0`) occurring within 1.5s of an upward step or when current phone volume `> 1`.
   - Direct synchronous telemetry (`PhoneStateMonitor.sendImmediateVolumeTelemetry`) feeds back the new volume nibble immediately without waiting for asynchronous `AudioService` updates.
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
| **Minimalist Jetpack Compose Cockpit HUD** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/ui/cockpit/CockpitHud.kt` | ✅ **Phase 4 Complete** — Minimal clean automotive UI (OLED Obsidian + Cobalt Titanium palette), glove-friendly 44–52dp transport controls, pure Canvas vector icons (no emojis), punch-hole camera offset (22dp), handlebar-only volume control, and dynamic footer actions (Exit App service termination + Handlebar Guide overlay) |
| **BLE GATT Core Engine** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PulsarBleManager.kt` | ✅ **Phase 4 Complete** — Dynamic Bluetooth enable prompt, automatic connect on BT state ON, leak-free lifecycle, StateFlow reactive state, GATT write queue, MTU 247 |
| **Binary Protocol Frames** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PulsarProtocol.kt` | ✅ **Complete & Active** — Clean binary frame builders for telemetry (0210), media (0610), and handlebar switchgear events (0a10) |
| **Phone State & Battery Monitor** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/PhoneStateMonitor.kt` | ✅ **Complete & Active** — Streams phone battery gauge (0-4 bars), signal strength (0-4), and bidirectional volume sync to cluster (0210) |
| **Media Controller & Ticker** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MediaStateListener.kt` | ✅ **Verified on Bike** — Real-time YT Music & Metrolist metadata, interactive tap/drag seekbar, 1s ticker LCD streaming |
| **Handlebar Switchgear Integration** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MediaStateListener.kt` | ✅ **Phase 3 Complete** — SET to play/pause, ^/v hold to skip tracks, ^/v click volume with volume mute protection |
| **Floating HUD Service** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/FloatingHudService.kt` | ✅ **Phase 4 Complete** — Wires BLE engine, media listener, phone telemetry monitor, overlay Compose tree, and audio volume sync |
| **Permissions Gatekeeper & Launcher** | `StudioApp/app/src/main/java/com/bajaj/rideconnect/re/MainActivity.kt` | ✅ **Complete** — Auto-shifts into left floating HUD & launches Google Maps with minimal permissions |
| **Legacy View Prototype** | `app/src/com/bajaj/rideconnect/re/` | 📦 **Archived Reference** — Original View/XML prototype |

---

## 4. Hardware Details & Protocol Essentials

- **Target Device:** Bajaj Pulsar Series / Dominar Series (`PULSAR6741`, MAC `C0:63:80:2D:0C:42`)
- **Service UUID:** `0010676e-6972-6565-6e69-676e4543544f`
- **Active Characteristics:**
  - `0210` — Phone Status & Battery Telemetry, 55-byte write (`WRITE_TYPE_DEFAULT`)
  - `0610` — Now-Playing Media, 105-byte write
  - `0a10` — Handlebar Controls, 20-byte read / notify (CCCD `0x2902`, active 350ms poller)

*For detailed byte maps, bitmasks, and packet diagrams, see [docs/DEVELOPER_GUIDE.md](docs/DEVELOPER_GUIDE.md).*

---

## 5. Build & Quick Commands

```bash
# Filter logcat for real-time BLE, Media, Call and Telemetry debugging
adb logcat -v time -s PulsarBleManager:D MediaStateListener:D FloatingHudService:D
```

