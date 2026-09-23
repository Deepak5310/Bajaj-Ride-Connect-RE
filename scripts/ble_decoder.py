#!/usr/bin/env python3
"""
Bajaj Pulsar NS400Z BLE Packet Decoder CLI
Parses raw hex bytes or logs into human-readable telemetry & controls.
"""

import sys
import argparse

def decode_controls(data: bytes):
    if len(data) < 18:
        print(f"[!] Invalid length {len(data)} (expected >= 18 bytes)")
        return
    print("┌── [0a10: CLUSTER CONTROLS EVENT]")
    print(f"│ Volume Nibble : {data[0] & 0x0F} (0-15)")
    print(f"│ Call Actions  : Accept={data[1]}, Reject={data[2]}, RejectSMS={data[3]}")
    print(f"│ Media Actions : Play={data[6]}, Pause={data[7]}, Next={data[8]}, Prev={data[9]}, Stop={data[10]}")
    print(f"│ UI Triggers   : TakeMeHome={data[5]}, MissedCalls={data[11]}, Alerts={data[12]}, MediaLaunch={data[13]}")
    if len(data) >= 16:
        print(f"│ Playlist/Track: Req={data[14]}, SelectedTrackIdx={data[15]}")
    if len(data) >= 18:
        print(f"│ Speed Dial    : DialIdx={data[16]}, TxnID={data[17]}")
    print(f"└── Raw: {data.hex(' ')}")

def decode_general_v2(data: bytes):
    if len(data) != 89:
        print(f"[!] Invalid General V2 length {len(data)} (expected 89 bytes)")
        return
    has_caller = data[18] == 1
    caller_len = min(data[19], 32)
    caller = data[20:20+caller_len].decode('utf-8', errors='ignore') if has_caller else ""
    duration = data[52] | (data[53] << 8)
    model_len = min(data[55], 32)
    model = data[56:56+model_len].decode('utf-8', errors='ignore')
    chk = data[88]
    calc_chk = sum(data[:88]) & 0xFF

    print("┌── [0210: GENERAL STATUS V2 TELEMETRY]")
    print(f"│ Battery Level : {((data[1] >> 4) & 0x03)}/3 | Signal: {(data[2] & 0x07)}/7 bars")
    print(f"│ DND Mode      : {bool(data[1] & 0x80)} | Headset: {bool(data[0] & 0x10)}")
    print(f"│ Call State    : Code {data[1] & 0x0F} | Duration: {duration}s | Caller: '{caller}'")
    print(f"│ Counts        : SMS={data[15]}, MissedCalls={data[13]}")
    print(f"│ Device Model  : '{model}' | Heartbeat: {data[54]}")
    print(f"│ Checksum      : 0x{chk:02X} ({'VALID' if chk == calc_chk else 'INVALID'})")
    print(f"└── Raw: {data.hex(' ')}")

def decode_media(data: bytes):
    if len(data) < 105:
        print(f"[!] Invalid Media length {len(data)} (expected 105 bytes)")
        return
    t_len = min(data[1], 32)
    title = data[2:2+t_len].decode('utf-8', errors='ignore')
    a_len = min(data[34], 32)
    artist = data[35:35+a_len].decode('utf-8', errors='ignore')
    alb_len = min(data[67], 32)
    album = data[68:68+alb_len].decode('utf-8', errors='ignore')
    pos = (data[100] << 8) | data[101]
    dur = (data[102] << 8) | data[103]
    status_map = {0: "STOPPED", 1: "PLAYING", 2: "PAUSED"}

    print("┌── [0610: NOW PLAYING MEDIA METADATA]")
    print(f"│ Track  : '{title}'")
    print(f"│ Artist : '{artist}'")
    print(f"│ Album  : '{album}'")
    print(f"│ Time   : {pos}s / {dur}s | Status: {status_map.get(data[104], 'UNKNOWN')}")
    print(f"└── Raw: {data.hex(' ')}")

def decode_tbt(data: bytes):
    if len(data) < 10:
        print(f"[!] Invalid TBT length {len(data)}")
        return
    turn_icon = data[0] & 0x0F
    next_dist = data[2] | (data[3] << 8)
    eta_h = data[4]
    eta_m = data[5] & 0x0F
    tot_dist = data[6] | (data[7] << 8)
    text = data[10:].decode('utf-8', errors='ignore').strip('\x00') if len(data) > 10 else ""

    print("┌── [0110: TURN-BY-TURN NAVIGATION]")
    print(f"│ Next Turn  : Icon ID {turn_icon} in {next_dist}m")
    print(f"│ ETA Time   : {eta_h:02d}:{eta_m:02d} | Remaining Distance: {tot_dist}m")
    print(f"│ Street/Info: '{text}'")
    print(f"└── Raw: {data.hex(' ')}")

def main():
    parser = argparse.ArgumentParser(description="Bajaj Pulsar NS400Z BLE Frame Decoder")
    parser.add_argument("hex", help="Hex string of BLE packet (e.g. '00 01 02 ...')")
    parser.add_argument("--type", choices=["controls", "general", "media", "tbt", "auto"], default="auto", help="Packet type")
    args = parser.parse_args()

    clean_hex = args.hex.replace(" ", "").replace(":", "").replace(",", "")
    try:
        raw_bytes = bytes.fromhex(clean_hex)
    except ValueError as e:
        print(f"[-] Invalid hex string: {e}")
        sys.exit(1)

    t = args.type
    if t == "auto":
        if len(raw_bytes) == 20:
            t = "controls"
        elif len(raw_bytes) == 89:
            t = "general"
        elif len(raw_bytes) == 105:
            t = "media"
        elif len(raw_bytes) == 49:
            t = "tbt"
        else:
            print(f"[*] Unknown length {len(raw_bytes)} bytes. Try specifying --type.")
            return

    if t == "controls":
        decode_controls(raw_bytes)
    elif t == "general":
        decode_general_v2(raw_bytes)
    elif t == "media":
        decode_media(raw_bytes)
    elif t == "tbt":
        decode_tbt(raw_bytes)

if __name__ == "__main__":
    main()
