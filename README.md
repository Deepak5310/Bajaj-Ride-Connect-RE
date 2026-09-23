# bajaj-ride-connect-re

Reverse engineering, protocol analysis, and interoperability research repository for the **Bajaj Ride Connect** Android application and the **Bajaj Pulsar NS400Z** digital instrument cluster.

---

## 📁 Repository Structure

```
bajaj-ride-connect-re/
├── docs/
│   ├── ble_protocol_spec.md       # Full Bluetooth Low Energy GATT specification & schemas
│   └── wifi_protocol_spec.md      # Wi-Fi Navigation V2, TCP/UDP ports & AES screen mirroring
├── scripts/
│   ├── ble_decoder.py             # CLI tool to decode live or logged BLE packets
│   ├── tbt_bridge.py              # Turn-by-Turn frame builder, simulator & G-Maps bridge
│   └── patch_package.py           # Universal ARM64 dual-installation repackager & signer
├── src/                           # Application sources & lightweight bridge
│   ├── com/bajajconnect/
│   │   ├── tbt/                   # Lightweight Native TBT Bridge (G-Maps Notification Listener)
│   │   ├── ble/                   # Bluetooth GATT frames, services, and handlers
│   │   ├── wifi/                  # Wi-Fi screen mirroring & Navigation Protocol V2 (TFT models)
│   │   ├── features/              # SKU feature registry & NS400Z cohort definitions
│   │   └── security/              # Cryptographic AES / JNI utilities
└── README.md
```

---

## 🏍️ Vehicle Target & Architecture

* **Target Vehicle:** Bajaj Pulsar NS400Z (2024–2026)
* **Cluster Hardware:** Segmented LCD with Blue Monochrome Dot-Matrix display (`CLUSTER_V1`, Pricol / Uno Minda / OTC Engineering).
* **Connectivity Architecture:**
  1. **Bluetooth Low Energy (GATT):** 100% active transport on NS400Z. Telemetry (`0210`), Phone battery/signal, Caller ID, Music controls (`0610`), Handlebar triggers (`0a10`), and 48-byte Turn-by-Turn maneuvers (`0110`).
  2. **Wi-Fi Hotspot (TCP:5558 / UDP:5556):** Dormant on NS400Z. Present in the unified APK codebase for full-color TFT vehicles (Chetak EV / KTM).

---

## 🛠️ Usage & Tools

### 1. BLE Packet Decoder CLI
Decode raw hex packets captured from BLE sniffer or Android HCI logs:

```bash
# Decode Handlebar button event (0a10)
python3 scripts/ble_decoder.py "00 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00"

# Decode General Status V2 Telemetry (0210)
python3 scripts/ble_decoder.py "<89-byte hex string>"

# Decode Turn-by-Turn Navigation Frame (0110)
python3 scripts/ble_decoder.py "91 49 00 00 00 fa 2d 07 00 32 00 08 04 00 07 4d 47 20 52 4f 41 44 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 27"
```

### 2. Turn-by-Turn (TBT) Bridge & Simulator
Generate and dispatch real-time 48-byte turn frames directly to the NS400Z cluster:

```bash
# Generate a Left Turn frame in 250m on MG Road with ETA 07:45 PM
python3 scripts/tbt_bridge.py --maneuver TURN_LEFT --step-dist 250 --total-dist 8500 --eta-hour 7 --eta-minute 45 --pm --street "MG ROAD"

# Decode a captured 48-byte TBT frame
python3 scripts/tbt_bridge.py --decode "<48-byte hex string>"
```

### 3. Dual-App Side-by-Side Standalone Build
Merge Split APKs into a single universal ARM64 package with isolated package ID and ContentProvider authorities:

```bash
# Builds signed dist/bajaj-ride-connect-debug.apk
python3 scripts/patch_package.py
```

---

## 🔒 Safety & Research Scope

This repository is strictly for personal research, protocol observation, and interoperability development. It does not alter safety-critical ECU/engine parameters.
