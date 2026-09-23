#!/usr/bin/env python3
"""
Bajaj Pulsar NS400Z Turn-by-Turn (TBT) Navigation Bridge & BLE Frame Builder
Converts navigation maneuvers (Google Maps / OsmAnd / Custom) into 48-byte BLE GATT frames
and dispatches them directly to the motorcycle's dot-matrix cluster display.
"""

import sys
import time
import struct
import argparse
from typing import Optional, Tuple

# OTC Engineering Primary Turn Glyphs (ASCII codes used by cluster firmware)
GLYPH_MAP = {
    "STRAIGHT": 71,            # 'G'
    "TURN_LEFT": 73,           # 'I'
    "TURN_RIGHT": 74,          # 'J'
    "SLIGHT_LEFT": 67,         # 'C'
    "SLIGHT_RIGHT": 68,        # 'D'
    "SHARP_LEFT": 69,          # 'E'
    "SHARP_RIGHT": 70,         # 'F'
    "U_TURN_LEFT": 79,         # 'O'
    "U_TURN_RIGHT": 80,        # 'P'
    "KEEP_LEFT": 90,           # 'Z'
    "KEEP_RIGHT": 88,          # 'X'
    "ROUNDABOUT_CW": 78,       # 'N'
    "ROUNDABOUT_CCW": 85,      # 'U'
    "MERGE": 86,               # 'V'
    "FORK_LEFT": 81,           # 'Q'
    "FORK_RIGHT": 82,          # 'R'
    "RAMP_LEFT": 75,           # 'K'
    "RAMP_RIGHT": 76,          # 'L'
    "DESTINATION": 72,         # 'H'
    "WRONG_WAY": 66,           # 'B'
}

REVERSE_GLYPH_MAP = {v: k for k, v in GLYPH_MAP.items()}
# Add lowercase blinking variants
for k, v in list(GLYPH_MAP.items()):
    REVERSE_GLYPH_MAP[v + 32] = f"{k} (BLINKING)"

def format_distance_bytes(distance_meters: float) -> Tuple[int, bytes]:
    """
    Encodes distance into unit flag and 4 byte representation matching NavigationHelper.java:
    Unit: 1 = Meters (if < 1000m), 0 = Kilometers (if >= 1000m)
    Returns (unit_flag, 4_bytes: [dec_lsb, dec_msb, int_lsb, int_msb])
    """
    if distance_meters < 1000.0:
        val = int(distance_meters)
        unit = 1  # Meters
        int_part = val
        dec_part = 0
    else:
        val = distance_meters / 1000.0
        unit = 0  # Kilometers
        int_part = int(val)
        dec_part = int((val - int_part) * 100.0)

    # 16-bit little-endian for int & dec parts
    b_int = struct.pack("<H", int_part)
    b_dec = struct.pack("<H", dec_part)
    # [dec[1], dec[0], int[1], int[0]] -> indices [4,3,2,1] from Java toBytes
    return unit, bytes([b_dec[1], b_dec[0], b_int[1], b_int[0]])

def build_tbt_frame(
    maneuver: str = "STRAIGHT",
    step_distance_m: float = 0.0,
    total_distance_m: float = 0.0,
    eta_hour: int = 12,
    eta_minute: int = 0,
    is_pm: bool = False,
    street_name: str = "",
    active: bool = True,
    gps_active: bool = True,
    roundabout_exit: int = 0
) -> bytearray:
    """
    Constructs an exact 48-byte BLE Turn-by-Turn GATT frame for Characteristic 0110.
    """
    frame = bytearray(48)
    if not active:
        return frame

    glyph = GLYPH_MAP.get(maneuver.upper(), 71)
    # If distance to maneuver is under 100 meters, enable blinking (ASCII lowercase +32)
    if 0 < step_distance_m < 100 and glyph not in (72, 66):
        glyph += 32

    step_unit, step_bytes = format_distance_bytes(step_distance_m)
    tot_unit, tot_bytes = format_distance_bytes(total_distance_m)

    # Byte 0: Active | (StepUnit << 4) | (isPM << 7)
    frame[0] = 1 | (step_unit << 4) | ((1 if is_pm else 0) << 7)

    # Byte 1: Glyph Code
    frame[1] = glyph & 0xFF

    # Bytes 2-5: Step Distance (Decimals & Integers)
    frame[2:6] = step_bytes

    # Byte 6: ETA Minute (0-59)
    frame[6] = eta_minute & 0xFF

    # Byte 7: ETA Hour (1-12) | (RoundaboutExit << 4)
    h_val = eta_hour if 1 <= eta_hour <= 12 else 12
    frame[7] = (h_val & 0x0F) | ((roundabout_exit & 0x0F) << 4)

    # Bytes 8-11: Total Distance
    frame[8:12] = tot_bytes

    # Byte 12: Total Distance Unit | (GpsStatus << 2)
    gps_val = 1 if gps_active else 0
    frame[12] = (tot_unit & 0x03) | ((gps_val & 0x03) << 2)

    # Byte 13: Take Me Home ACK (0)
    frame[13] = 0

    # Sanitize street text for LCD (alphanumeric + spaces only)
    sanitized = "".join(c for c in street_name if c.isalnum() or c in " .-")[:31].strip()
    if sanitized:
        frame[14] = len(sanitized)
        frame[15:15+len(sanitized)] = sanitized.encode('ascii', errors='ignore')

    # Byte 47: 8-bit Checksum
    chk = sum(frame[:47]) & 0xFF
    frame[47] = chk

    return frame

def decode_tbt_frame(data: bytes):
    """
    Decodes and prints 48-byte BLE Turn-by-Turn frame.
    """
    if len(data) < 48:
        print(f"[!] Invalid TBT frame length: {len(data)} (expected 48 bytes)")
        return

    active = bool(data[0] & 0x01)
    step_unit = "m" if (data[0] & 0x10) else "km"
    is_pm = bool(data[0] & 0x80)

    glyph_code = data[1]
    glyph_name = REVERSE_GLYPH_MAP.get(glyph_code, f"UNKNOWN (0x{glyph_code:02X})")

    eta_min = data[6]
    eta_hr = data[7] & 0x0F
    roundabout = (data[7] >> 4) & 0x0F

    tot_unit = "m" if (data[12] & 0x01) else "km"
    gps_ok = bool((data[12] >> 2) & 0x01)

    s_len = min(data[14], 31)
    street = data[15:15+s_len].decode('ascii', errors='ignore') if s_len > 0 else ""

    chk = data[47]
    calc_chk = sum(data[:47]) & 0xFF

    print("┌── [0110: TURN-BY-TURN NAVIGATION FRAME]")
    print(f"│ Active State : {'ACTIVE' if active else 'INACTIVE'} | GPS Fix: {'YES' if gps_ok else 'NO'}")
    print(f"│ Maneuver     : {glyph_name} (Code {glyph_code})")
    print(f"│ Street Info  : '{street}'")
    print(f"│ ETA Time     : {eta_hr:02d}:{eta_min:02d} {'PM' if is_pm else 'AM'}")
    if roundabout > 0:
        print(f"│ Roundabout   : Exit #{roundabout}")
    print(f"│ Checksum     : 0x{chk:02X} ({'VALID' if chk == calc_chk else 'INVALID'})")
    print(f"└── Raw Hex    : {data.hex(' ')}")

def parse_navigation_string(text: str) -> dict:
    """
    Simple natural language / notification parser for navigation cues.
    Example: "Turn left in 300m on Western Express Hwy, ETA 05:45 PM"
    """
    t_lower = text.lower()
    maneuver = "STRAIGHT"
    if "left" in t_lower:
        maneuver = "TURN_SHARP_LEFT" if "sharp" in t_lower else ("SLIGHT_LEFT" if "slight" in t_lower else "TURN_LEFT")
    elif "right" in t_lower:
        maneuver = "TURN_SHARP_RIGHT" if "sharp" in t_lower else ("SLIGHT_RIGHT" if "slight" in t_lower else "TURN_RIGHT")
    elif "u-turn" in t_lower or "uturn" in t_lower:
        maneuver = "U_TURN_LEFT"
    elif "destination" in t_lower or "arrive" in t_lower:
        maneuver = "DESTINATION"
    elif "roundabout" in t_lower:
        maneuver = "ROUNDABOUT_CW"

    return {
        "maneuver": maneuver,
        "street": text.strip()
    }

def main():
    parser = argparse.ArgumentParser(description="Bajaj Pulsar NS400Z TBT Frame Builder & Bridge")
    parser.add_argument("--maneuver", default="TURN_LEFT", choices=list(GLYPH_MAP.keys()), help="Maneuver glyph")
    parser.add_argument("--step-dist", type=float, default=250.0, help="Step distance in meters")
    parser.add_argument("--total-dist", type=float, default=5200.0, help="Total remaining distance in meters")
    parser.add_argument("--eta-hour", type=int, default=6, help="ETA Hour (1-12)")
    parser.add_argument("--eta-minute", type=int, default=30, help="ETA Minute (0-59)")
    parser.add_argument("--pm", action="store_true", help="ETA is PM")
    parser.add_argument("--street", default="MG ROAD", help="Street / Maneuver Text")
    parser.add_argument("--decode", help="Hex string of 48-byte TBT frame to decode")
    args = parser.parse_args()

    if args.decode:
        clean = args.decode.replace(" ", "").replace(":", "")
        data = bytes.fromhex(clean)
        decode_tbt_frame(data)
        return

    frame = build_tbt_frame(
        maneuver=args.maneuver,
        step_distance_m=args.step_dist,
        total_distance_m=args.total_dist,
        eta_hour=args.eta_hour,
        eta_minute=args.eta_minute,
        is_pm=args.pm,
        street_name=args.street
    )

    print(f"[*] Generated 48-byte TBT BLE Frame:")
    decode_tbt_frame(frame)
    print(f"\n[+] Raw BLE Byte Array for Characteristic 0110:")
    print(f"    {frame.hex(' ')}")

if __name__ == "__main__":
    main()
