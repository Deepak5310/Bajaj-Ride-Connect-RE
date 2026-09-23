# Bajaj Pulsar NS400Z Wi-Fi & Screen Mirroring Protocol Specification

This document details the high-bandwidth Wi-Fi protocol between the **Bajaj Ride Connect** Android application and the **Bajaj Pulsar NS400Z** digital instrument cluster.

---

## 1. Network Topology

* **Access Point Mode:** Vehicle acts as Wi-Fi SoftAP Hotspot
* **Cluster Gateway IP:** `192.168.4.1`
* **Phone Assigned IP Range:** `192.168.4.x / 24`
* **Routing Policy:** Cellular internet routing is preserved on the phone for live navigation data while maintaining Wi-Fi communication with the cluster.

---

## 2. Ports & Protocols

```
               ┌────────────────────────────────────────────────────────┐
               │              Bajaj Ride Connect Mobile App             │
               └──────────────┬──────────────────────────┬──────────────┘
                              │                          │
                 (TCP Port 5558)            (UDP Port 5556)
                 Nav Protocol V2            AES-256 Screen Mirror
                              │                          │
                              ▼                          ▼
               ┌────────────────────────────────────────────────────────┐
               │           NS400Z Instrument Cluster (192.168.4.1)      │
               └────────────────────────────────────────────────────────┘
```

---

## 3. TCP Service (`TcpServerService` : Port 5558)

Handles Navigation Protocol V2 commands, POI search results, route calculations, and document exchange.

### Frame Format
```
[0x01] [0x02] [COMMAND_ID (1B)] [PAYLOAD_LEN_MSB (1B)] [PAYLOAD_LEN_LSB (1B)] [PAYLOAD (NB)]
```

### Supported Command IDs

| CMD ID | Name | Direction | Description |
| :--- | :--- | :--- | :--- |
| `0x07` | `GET_POI_LIST` | Dash $\rightarrow$ App | Requests nearby POI categories (Fuel, Food, Service) |
| `0x08` | `GET_POI_DETAIL` | Dash $\rightarrow$ App | Requests detailed location info for a selected POI index |
| `0x09` | `GET_FAVOURITES` | Dash $\rightarrow$ App | Fetches rider's saved favorite destinations |
| `0x0A` | `GET_RECENT_TRIPS`| Dash $\rightarrow$ App | Fetches recent ride trip history |
| `0x0B` | `GET_TRIP_DETAIL` | Dash $\rightarrow$ App | Requests trip statistics and waypoint breakdown |
| `0x0C` | `GET_ROUTE_PREVIEW`| Dash $\rightarrow$ App | Requests route calculation preview (ETA & Distance) |
| `0x0D` | `SET_ROUTE_PREF` | Dash $\rightarrow$ App | Sets routing preferences (Avoid Tolls, Highway, Shortest) |
| `0x0E` | `GET_ROUTE_PREF` | Dash $\rightarrow$ App | Reads current routing preference |
| `0x0F` | `START_NAVIGATION`| Dash $\rightarrow$ App | Triggers active turn-by-turn navigation session |

---

## 4. UDP Screen Mirroring Service (`UdpServerService` : Port 5556)

Streams live navigation maps, turn overlays, and incoming call popups directly to the motorcycle's TFT cluster.

### Cryptographic Configuration
* **Cipher:** AES-256-CBC with PKCS5 / PKCS7 Padding
* **Hardcoded Secret Key:** `Z7in5HGAGFdXXU6ZfDc8lIff4iwLY01o` (32 bytes ASCII)
* **Frame Size:** 1024 bytes per packet (1008 bytes compressed JPEG payload + 16 bytes IV/padding)
* **Integrity Check:** Standard CRC32 checksum per transmitted frame
* **Compression:** Adaptive JPEG compression (Quality: 25% to 50%)
