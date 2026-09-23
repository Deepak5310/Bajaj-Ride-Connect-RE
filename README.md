# bajaj-ride-connect-re

Reverse engineering, protocol analysis, and interoperability research repository for the **Bajaj Ride Connect** ecosystem and the **"My Pulsar"** universal Bluetooth dashboard bridge (`com.bajaj.rideconnect.re`).

Compatible with ~80% of Bajaj Bluetooth-equipped motorcycles (Pulsar NS400Z, N250, F250, NS200, N160, NS160, N150, Dominar 400/250, and Bluetooth-equipped variants).

---

## 📁 Repository Structure

```
bajaj-ride-connect-re/
├── app/                           # "My Pulsar" standalone Android cockpit app
│   ├── AndroidManifest.xml
│   ├── res/                       # Vectors, HUD layouts & Dark Knight themes
│   └── src/                       # Java sources (BLE, Media, Navigation, Telemetry)
├── docs/                          # Hardware specs, BLE protocol & owner manual
│   ├── ble_protocol_spec.md       # Full Bluetooth Low Energy GATT specification & schemas
│   ├── wifi_protocol_spec.md      # Wi-Fi Navigation V2, TCP/UDP ports & AES screen mirroring
│   ├── HANDOFF.md                 # Hardware target notes & protocol findings
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
├── build.sh                       # Optimized Linux Bash build script (AAPT2 + D8)
└── README.md
```

---

## 🏍️ Vehicle Target & Architecture

* **Target Ecosystem:** Bajaj Bluetooth-enabled motorcycles (~80% of current line-up including Pulsar NS400Z, Pulsar N-Series, Dominar series).
* **Cluster Hardware:** Segmented LCD with Dot-Matrix display (`CLUSTER_V1`, Pricol / Uno Minda / OTC Engineering).
* **Connectivity Architecture:**
  1. **Bluetooth Low Energy (GATT):** 100% active transport. Telemetry (`0210`), Phone battery/signal, Caller ID, Music controls (`0610`), Handlebar triggers (`0a10`), and 48-byte Turn-by-Turn maneuvers (`0110`).
  2. **Wi-Fi Hotspot (TCP:5558 / UDP:5556):** Available on full-color TFT vehicles (Chetak EV / KTM).

---

## 🛠️ Usage & Tools

### 1. "My Pulsar" Standalone Landscape Cockpit Bridge APK
A native, lightweight automotive cockpit dashboard and background service (`com.bajaj.rideconnect.re`) that connects directly to the Bajaj BLE cluster, intercepts active navigation notifications from **Google Maps**, and renders turn arrows, step distances, ETA, and street names on the bike's LCD dot-matrix display:

```bash
# Build, sign, and install standalone bridge APK to connected Android phone
./build.sh --install
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
