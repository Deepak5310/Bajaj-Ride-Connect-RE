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
│   └── patch_package.py           # Repackaging & dual-installation patching utility
├── src/                           # Decompiled Java/Kotlin application sources
│   ├── com/bajajconnect/
│   │   ├── ble/                   # Bluetooth GATT frames, services, and handlers
│   │   ├── wifi/                  # Wi-Fi screen mirroring & Navigation Protocol V2
│   │   ├── features/              # SKU feature registry & NS400Z cohort definitions
│   │   └── security/              # Cryptographic AES / JNI utilities
└── README.md
```

---

## 🏍️ Vehicle Target & Architecture

* **Target Vehicle:** Bajaj Pulsar NS400Z (2024–2026)
* **Cluster Hardware:** Digital LCD/TFT display cluster (Pricol / Uno Minda / OTC Engineering)
* **Connectivity Modes:**
  1. **Bluetooth Low Energy (GATT):** Telemetry, phone battery/signal, caller ID, music metadata, handlebar controls, and compact Turn-by-Turn instructions.
  2. **Wi-Fi Hotspot (TCP:5558 / UDP:5556):** Screen mirroring with AES-256 encryption, Navigation Protocol V2 (POIs, route previews, search).

---

## 🛠️ Usage & Tools

### 1. BLE Packet Decoder CLI
Decode raw hex packets captured from BLE sniffer or Android HCI logs:

```bash
# Decode Handlebar button event (0a10)
python3 scripts/ble_decoder.py "00 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00"

# Decode General Status V2 Telemetry (0210)
python3 scripts/ble_decoder.py "<89-byte hex string>"
```

### 2. Dual-App Side-by-Side Installation
To install the research/debug build alongside the official app on the same device without conflicts:
```bash
python3 scripts/patch_package.py --new-pkg com.bajajconnect.rideapp.debug
```

---

## 🔒 Safety & Research Scope

This repository is strictly for personal research, protocol observation, and interoperability development. It does not alter safety-critical ECU/engine parameters.
