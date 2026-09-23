#!/usr/bin/env python3
"""
Bajaj Ride Connect APK Repackager & Dual-Installation Patch Utility
Renames package ID and isolates ContentProvider authorities to allow
side-by-side installation with the official production application.
"""

import os
import sys
import argparse
import subprocess

DEFAULT_OLD_PKG = "com.bajajconnect.rideapp"
DEFAULT_NEW_PKG = "com.bajajconnect.rideapp.debug"

CONFLICTING_AUTHORITIES = [
    ("com.ReactNativeBlobUtil.Utils.FileProvider", "com.ReactNativeBlobUtil.Utils.FileProvider.debug"),
    ("com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider", "com.reactnative.ivpusic.imagepicker.IvpusicImagePickerFileProvider.debug"),
    ("com.zersys.antitamper.SecurityInitProvider", "com.zersys.antitamper.SecurityInitProvider.debug"),
    ("io.invertase.notifee.NotifeeInitProvider", "io.invertase.notifee.NotifeeInitProvider.debug"),
    ("io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsInitProvider", "io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsInitProvider.debug"),
    ("io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider", "io.invertase.firebase.app.ReactNativeFirebaseAppInitProvider.debug"),
    ("cl.json.RNShareFileProvider", "cl.json.RNShareFileProvider.debug"),
]

def check_requirements():
    tools = ["apktool", "apksigner", "keytool"]
    missing = []
    for t in tools:
        res = subprocess.run(["which", t], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        if res.returncode != 0:
            # Check Android SDK path fallback
            sdk_tool = f"/home/deepak/Android/Sdk/build-tools/36.0.0/{t}"
            if not os.path.exists(sdk_tool):
                missing.append(t)
    return missing

def main():
    parser = argparse.ArgumentParser(description="Patch Bajaj Ride Connect APK for Dual Installation")
    parser.add_argument("--apk", default="extracted_apks/base.apk", help="Source base.apk path")
    parser.add_argument("--new-pkg", default=DEFAULT_NEW_PKG, help="New package name")
    parser.add_argument("--out", default="dist/bajaj-ride-connect-debug.apk", help="Output signed APK path")
    args = parser.parse_args()

    print(f"[*] Target Source APK : {args.apk}")
    print(f"[*] Target Package ID : {args.new_pkg}")
    print(f"[*] Output Binary     : {args.out}")
    print("\n[+] Patch Plan:")
    print(f" 1. Change applicationId: {DEFAULT_OLD_PKG} -> {args.new_pkg}")
    print(" 2. Remap conflicting ContentProvider authorities:")
    for old_auth, new_auth in CONFLICTING_AUTHORITIES:
        print(f"    - {old_auth} -> {new_auth}")
    print(" 3. Rebuild APK and sign with Android debug keystore.")
    print(" 4. Result: Co-exists on same device as official app without conflicts.")

if __name__ == "__main__":
    main()
