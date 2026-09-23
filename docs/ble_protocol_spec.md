# Bajaj Pulsar NS400Z BLE GATT Protocol Specification

This document details the reverse-engineered Bluetooth Low Energy (BLE) protocol between the **Bajaj Ride Connect** Android application and the **Bajaj Pulsar NS400Z** digital instrument cluster (manufactured by Pricol / Uno Minda / OTC Engineering).

---

## 1. GATT Topology & Identity

* **Base UUID Suffix:** `-6972-6565-6e69-676e4543544f` (*ASCII Little Endian representation: `OTCEngineering`*)
* **Negotiated MTU:** 247 bytes (Default 23 bytes fallback)
* **Primary Service UUID:** `0010676e-6972-6565-6e69-676e4543544f`

### Characteristic Summary

| Characteristic | UUID | Direction | Properties | Payload Size |
| :--- | :--- | :--- | :--- | :--- |
| **TBT Navigation** | `0110676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | 49 Bytes |
| **General Status V2** | `0210676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | 89 Bytes |
| **Missed Calls** | `0310676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | Variable |
| **Alerts Info** | `0410676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | Variable |
| **Playlist Info** | `0510676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | 177 Bytes |
| **Media / Now Playing** | `0610676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | 105 Bytes |
| **Favorite Contacts** | `0910676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | 151 Bytes |
| **Cluster Controls** | `0a10676e-6972-6565-6e69-676e4543544f` | Dash $\rightarrow$ App | Notify (CCCD `0x2902`) | 20 Bytes |
| **Recent Calls** | `0b10676e-6972-6565-6e69-676e4543544f` | App $\rightarrow$ Dash | Write / Write Without Resp | Variable |

---

## 2. Frame Specifications

### A. Cluster Controls (`0a10`) — Dash $\rightarrow$ App (20 Bytes)
Notified whenever the rider interacts with handlebar switches or cluster joystick.

```
Byte 0:       [ Volume Nibble (4 bits: 0-15) ] | [ Dial Source (2 bits) ]
Byte 1:       Call Accept Trigger Counter
Byte 2:       Call Reject Trigger Counter
Byte 3:       Call Reject with SMS Trigger Counter
Byte 4:       [ Playlist New Req (1 bit: Bit 7) ] | [ Playlist Page Req (1 bit: Bit 1) ]
Byte 5:       Take Me Home Trigger Counter
Byte 6:       Music Resume / Play Trigger Counter
Byte 7:       Music Pause Trigger Counter
Byte 8:       Music Skip Next Trigger Counter
Byte 9:       Music Skip Previous Trigger Counter
Byte 10:      Music Stop Trigger Counter
Byte 11:      Missed Calls Request Counter
Byte 12:      Alerts Request Counter
Byte 13:      Launch Media Player Trigger
Bytes 14-15:  Selected Playlist Song Index (uint16)
Bytes 16-17:  Dial Index & Transaction ID (Cluster speed-dial selection)
Bytes 18-19:  Reserved
```

### B. General Status V2 (`0210`) — App $\rightarrow$ Dash (89 Bytes)
Periodic telemetry frame containing phone stats, network signal, and active call data.

```
Byte 0:       (Volume & 0x0F) | ((isHeadsetConnected ? 1 : 0) << 4) | 0xC0
Byte 1:       (isDndEnabled ? 0x80 : 0) | ((batteryLevel & 0x03) << 4) | (callState & 0x0F)
Byte 2:       (signalBars & 0x07) | ((birthdayDay & 0x1F) << 3)
Byte 3:       birthdayMonth & 0x0F
Bytes 4-12:   Action Acknowledgements (Call, Music, Media ACKs)
Byte 13:      Missed Call Count
Byte 14:      Missed Call Get ACK
Byte 15:      SMS Unread Count
Byte 16:      Alerts Get ACK
Byte 17:      Playlist Song ACK
Byte 18:      Caller Active Flag (1 = Display Caller, 0 = Idle)
Byte 19:      Caller String Length (max 32)
Bytes 20-51:  Caller Name / Number (UTF-8 bytes, null padded)
Bytes 52-53:  Call Duration in seconds (uint16 Little-Endian)
Byte 54:      Heartbeat Sequence Counter (increments every frame)
Byte 55:      Phone Model Name Length (max 32)
Bytes 56-87:  Phone Model Name (e.g. "Pixel 8 Pro", null padded)
Byte 88:      8-bit Checksum: sum(Byte[0..87]) & 0xFF
```

### C. Turn-by-Turn (TBT) Navigation (`0110`) — App $\rightarrow$ Dash (48 Bytes)
Transmits maneuver icons, distances, ETA, and street text to the dot-matrix LCD.

```
Byte 0:       (ActiveFlag: 1=Active, 0=Stop) | ((DistanceUnit: 1=Meters, 0=Km) << 4) | ((isPM ? 1 : 0) << 7)
Byte 1:       Maneuver Glyph ASCII (e.g. 71='G' Straight, 73='I' Left, 74='J' Right, +32 for Blinking/Imminent)
Bytes 2-5:    Step Distance (Bytes: [Decimals LSB, Decimals MSB, Integer LSB, Integer MSB])
Byte 6:       ETA Minute (0-59 in BCD/Decimal)
Byte 7:       (ETA Hour: 1-12) | ((RoundaboutExit & 0x0F) << 4)
Bytes 8-11:   Total Remaining Distance (Bytes: [Decimals LSB, Decimals MSB, Integer LSB, Integer MSB])
Byte 12:      (TotalDistanceUnit: 1=Meters, 0=Km) | ((GpsStatus: 0=NoFix, 1=Active) << 2)
Byte 13:      Take Me Home ACK Counter
Byte 14:      Street Name Length (max 31 chars)
Bytes 15-46:  Street Name / Maneuver Text (ASCII characters, dot-matrix sanitized)
Byte 47:      8-bit Checksum: sum(Byte[0..46]) & 0xFF
```

#### Primary Turn Glyphs (`PrimaryTurns` Enum)

| Code | Char | Maneuver Description | Blinking Code (< 100m) |
| :--- | :--- | :--- | :--- |
| `66` | `'B'` | `WRONG_WAY` / U-Turn Warning | `98` (`'b'`) |
| `67` | `'C'` | `TURN_SLIGHT_LEFT` | `99` (`'c'`) |
| `68` | `'D'` | `TURN_SLIGHT_RIGHT` | `100` (`'d'`) |
| `69` | `'E'` | `TURN_SHARP_LEFT` | `101` (`'e'`) |
| `70` | `'F'` | `TURN_SHARP_RIGHT` | `102` (`'f'`) |
| `71` | `'G'` | `STRAIGHT` / Continue | `103` (`'g'`) |
| `72` | `'H'` | `DESTINATION_REACHED` | `104` (`'h'`) |
| `73` | `'I'` | `TURN_LEFT` | `105` (`'i'`) |
| `74` | `'J'` | `TURN_RIGHT` | `106` (`'j'`) |
| `75` | `'K'` | `RAMP_LEFT` | `107` (`'k'`) |
| `76` | `'L'` | `RAMP_RIGHT` | `108` (`'l'`) |
| `78` | `'N'` | `ROUNDABOUT_RIGHT` (Clockwise) | `110` (`'n'`) |
| `79` | `'O'` | `U_TURN_LEFT` | `111` (`'o'`) |
| `80` | `'P'` | `U_TURN_RIGHT` / Keep Right | `112` (`'p'`) |
| `81` | `'Q'` | `FORK_LEFT` | `113` (`'q'`) |
| `82` | `'R'` | `FORK_RIGHT` | `114` (`'r'`) |
| `85` | `'U'` | `ROUNDABOUT_LEFT` (Counter-Clockwise) | `117` (`'u'`) |
| `86` | `'V'` | `MERGE` | `118` (`'v'`) |
| `90` | `'Z'` | `KEEP_LEFT` / U-Turn | `122` (`'z'`) |

### D. Now Playing Media (`0610`) — App $\rightarrow$ Dash (105 Bytes)

```
Byte 0:       Status Header (0x01)
Byte 1:       Track Name Length (max 32)
Bytes 2-33:   Track Title (UTF-8, null padded)
Byte 34:      Artist Name Length (max 32)
Bytes 35-66:  Artist Name (UTF-8, null padded)
Byte 67:      Album Name Length (max 32)
Bytes 68-99:  Album Name (UTF-8, null padded)
Bytes 100-101: Current Position in seconds (uint16 Big-Endian)
Bytes 102-103: Total Duration in seconds (uint16 Big-Endian)
Byte 104:     Playback Status (0 = Stopped, 1 = Playing, 2 = Paused)
```

### E. Favorite Contacts (`0910`) — App $\rightarrow$ Dash (151 Bytes)

```
Byte 0:       0xC0 (Fixed Header)
Byte 1:       (ContactCount & 0x0F) << 4  (Max 5 contacts)
Bytes 2-149:  5x Contact Records (Each: [1B Name Len] [10B Name ASCII] [1B Phone Len] [15B Phone ASCII])
Byte 150:     8-bit Checksum: sum(Byte[0..149]) & 0xFF
```
