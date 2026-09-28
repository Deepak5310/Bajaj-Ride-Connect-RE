# bajaj-ride-connect-re

Reverse engineering, protocol analysis, and interoperability research repository for the **Bajaj Ride Connect** ecosystem and the **"My Pulsar"** universal Bluetooth dashboard bridge (`com.bajaj.rideconnect.re`).

Compatible with ~80% of Bajaj Bluetooth-equipped motorcycles (Pulsar NS400Z, N250, F250, NS200, N160, NS160, N150, Dominar 400/250, and Bluetooth-equipped variants).

---

## 📁 Repository Structure

```
bajaj-ride-connect-re/
├── StudioApp/                     # Production Jetpack Compose Cockpit HUD app (Material3, BLE, Media, Telemetry)
│   └── app/src/main/              # Kotlin sources, custom Pulsar emblem icons, WindowManager overlay HUD
├── app/                           # "My Pulsar" standalone Android cockpit app (Legacy View reference)
│   ├── AndroidManifest.xml
│   ├── res/                       # Vectors, HUD layouts & Dark Knight themes
│   └── src/                       # 100% Idiomatic Kotlin sources (BLE, Media, Navigation, Telemetry)
├── docs/                          # Hardware specs, BLE protocol & owner manual
│   ├── DEVELOPER_GUIDE.md         # Full BLE GATT specification, architecture & verified hardware matrix
│   ├── HANDOFF.md                 # Production implementation status & hardware target notes
│   └── pulsar-ns400z-owners-manual.pdf
├── references/                    # Original APK bundles, split APKs & Hermes string dumps
├── scripts/                       # Diagnostic CLI tools & protocol decoders
│   ├── ble_decoder.py             # CLI tool to decode live or logged BLE packets
│   ├── patch_package.py           # Universal ARM64 dual-installation repackager & signer
│   └── tbt_bridge.py              # Turn-by-Turn frame builder, simulator & G-Maps bridge
├── src/                           # Reference decompiled sources (Bajaj, Mappls, Spotify)
│   └── com/
│       ├── bajajconnect/          # Original Bajaj Ride Connect protocol & models
│       ├── mappls/                # MapmyIndia navigation SDK reference
│       ├── spotify/               # Spotify app remote protocol reference
│       └── zersys/                # Anti-tamper security reference
├── build.sh                       # Optimized Linux Bash build script (AAPT2 + D8 for legacy app/)
└── README.md
```

---

## 🏍️ Vehicle Target & Architecture

* **Target Ecosystem:** Bajaj Bluetooth-enabled motorcycles (Pulsar NS400Z, Pulsar N-Series, Dominar series). **Strictly Petrol/ICE motorcycles — zero EV/Chetak support.**
* **Cluster Hardware:** Segmented LCD with Dot-Matrix display (`CLUSTER_V1`, Pricol / Uno Minda / OTC Engineering).
* **Connectivity Architecture:**
  * **Bluetooth Low Energy (GATT):** 100% active transport for Now-Playing Media streaming (`0610` with UTF-8 multi-byte safe truncation and Album metadata sync), phone battery & signal telemetry (`0210`), and physical handlebar switchgear triggers (`0a10` - Play/Pause, Next/Prev, Volume with idle-pulse mute protection).
  * **Dynamic Cluster Pairing & Persistence:** Automatically discovers Pulsar/Dominar clusters by advertised OTC Service UUID or device name keywords and persists the last connected cluster MAC in `SharedPreferences` for instant future reconnections.

---

## 🛠️ Usage & Tools

### 1. "My Pulsar" Jetpack Compose Cockpit HUD (`StudioApp/`)
A native, zero-bloat automotive floating overlay HUD (`com.bajaj.rideconnect.re`) that docks alongside **Google Maps** in landscape mode, connects directly to the Bajaj BLE cluster, and provides glove-friendly media controls, auto-scrolling marquee track titles, and 1-tap notification exit:

```bash
# Build StudioApp debug APK via Gradle
cd StudioApp && ./gradlew :app:assembleDebug

# Install directly to connected phone over ADB
adb install -r StudioApp/app/build/outputs/apk/debug/app-debug.apk
```

### 2. Legacy Standalone Build Script (`app/`)
```bash
# Build optimized release APK (arm64-v8a, RSA 4096-bit production signed, V1/V2/V3/V4)
./build.sh release

# Build and auto-install to connected phone over ADB
./build.sh release --install
```

### 2. BLE Packet Decoder CLI
Decode raw hex packets captured from BLE sniffer or Android HCI logs:

```bash
# Decode Handlebar button event (0a10)
python3 scripts/ble_decoder.py "00 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00"

# Decode General Status V2 Telemetry (0210)
python3 scripts/ble_decoder.py "<89-byte hex string>"

# Decode Turn-by-Turn Navigation Frame (0110)
python3 scripts/ble_decoder.py "91 49 00 00 00 fa 2d 07 00 32 00 08 04 00 07 4d 47 20 52 4f 41 44 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 27"
```

### 3. Turn-by-Turn (TBT) Simulator CLI
Generate and test 48-byte turn frames directly from command line:

```bash
# Generate a Left Turn frame in 250m on MG Road with ETA 07:45 PM
python3 scripts/tbt_bridge.py --maneuver TURN_LEFT --step-dist 250 --total-dist 8500 --eta-hour 7 --eta-minute 45 --pm --street "MG ROAD"

# Decode a captured 48-byte TBT frame
python3 scripts/tbt_bridge.py --decode "<48-byte hex string>"
```

### 4. Dual-App Side-by-Side Standalone Repackager
Merges Split APKs, strips Zersys AntiTamper (`libsecurity_native.so`), Firebase Crashlytics (`libcrashlytics*.so`), and Wi-Fi daemons, isolates ContentProvider authorities, and re-signs for side-by-side co-existence with the official app:

```bash
# Builds signed dist/bajaj-ride-connect-debug.apk and installs split packages
python3 scripts/patch_package.py --install
```

---

## 🔒 Safety & Research Scope

This repository is strictly for personal research, protocol observation, and interoperability development. It does not alter safety-critical ECU/engine parameters.
