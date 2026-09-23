#!/usr/bin/env python3
"""
Bajaj Ride Connect APK Repackager & Universal ARM64 Dual-Installation Builder
Merges Split APKs into a standalone arm64-v8a APK, renames package ID to .debug,
isolates ContentProvider authorities, zip-aligns, and signs with Android debug keystore.
"""

import os
import sys
import struct
import zipfile
import subprocess
import argparse
import shutil

DEFAULT_OLD_PKG = "com.bajajconnect.rideapp"
DEFAULT_NEW_PKG = "com.bajajconnect.rideapp.debug"

BUILD_TOOLS_PATH = "/home/deepak/Android/Sdk/build-tools/36.0.0"
JAVA_HOME = "/opt/android-studio/jbr"
KEYTOOL_BIN = os.path.join(JAVA_HOME, "bin/keytool")
ZIPALIGN_BIN = os.path.join(BUILD_TOOLS_PATH, "zipalign")
APKSIGNER_BIN = os.path.join(BUILD_TOOLS_PATH, "apksigner")

def patch_axml(manifest_bytes: bytes, old_pkg: str, new_pkg: str) -> bytes:
    """Modifies Android binary XML (AXML) string pool to mutate package name & authorities."""
    chunk_type, header_size, total_chunk_size = struct.unpack('<HHI', manifest_bytes[0:8])
    sp_type, sp_header_size, sp_size, sp_str_count, sp_style_count, sp_flags, sp_str_start, sp_styles_start = struct.unpack('<HHIIIIII', manifest_bytes[8:36])

    is_utf8 = bool(sp_flags & 0x100)
    offsets = [struct.unpack('<I', manifest_bytes[36+i*4:40+i*4])[0] for i in range(sp_str_count)]
    str_block_start = 8 + sp_str_start

    strings = []
    for i, off in enumerate(offsets):
        pos = str_block_start + off
        if is_utf8:
            u16len = manifest_bytes[pos]
            pos += 2 if (u16len & 0x80) else 1
            u8len = manifest_bytes[pos]
            pos += 2 if (u8len & 0x80) else 1
            s = manifest_bytes[pos:pos+u8len].decode('utf-8', errors='ignore')
        else:
            u16len = struct.unpack('<H', manifest_bytes[pos:pos+2])[0]
            pos += 2
            s = manifest_bytes[pos:pos+u16len*2].decode('utf-16le', errors='ignore')
        strings.append(s)

    new_strings = []
    for s in strings:
        if s == old_pkg:
            new_strings.append(new_pkg)
        elif s.startswith(old_pkg + '.'):
            new_strings.append(s.replace(old_pkg, new_pkg))
        elif s == "base__abi,base__density":
            new_strings.append("")
        elif "vending.splits" in s or "com.android.stamp" in s or "com.android.vending.derived" in s:
            new_strings.append("")
        else:
            new_strings.append(s)

    # Rebuild string pool in UTF-16LE
    new_str_data = bytearray()
    new_offsets = []

    for s in new_strings:
        new_offsets.append(len(new_str_data))
        encoded = s.encode('utf-16le')
        length = len(s)
        new_str_data.extend(struct.pack('<H', length))
        new_str_data.extend(encoded)
        new_str_data.extend(b'\x00\x00')

    while len(new_str_data) % 4 != 0:
        new_str_data.append(0)

    sp_offsets_data = bytearray()
    for off in new_offsets:
        sp_offsets_data.extend(struct.pack('<I', off))

    new_sp_str_start = 28 + len(sp_offsets_data)
    new_sp_size = 28 + len(sp_offsets_data) + len(new_str_data)
    new_sp_chunk = struct.pack('<HHIIIIII', sp_type, sp_header_size, new_sp_size, sp_str_count, 0, 0, new_sp_str_start, 0)
    new_sp_chunk += sp_offsets_data + new_str_data

    rest_of_axml = manifest_bytes[8+sp_size:]
    new_total_size = 8 + len(new_sp_chunk) + len(rest_of_axml)
    new_root_header = struct.pack('<HHI', chunk_type, header_size, new_total_size)

    return new_root_header + new_sp_chunk + rest_of_axml

def ensure_keystore(keystore_path: str):
    os.makedirs(os.path.dirname(os.path.abspath(keystore_path)), exist_ok=True)
    if not os.path.exists(keystore_path):
        print(f"[*] Generating debug keystore at {keystore_path}...")
        cmd = [
            KEYTOOL_BIN, "-genkeypair", "-v",
            "-keystore", keystore_path,
            "-storepass", "android",
            "-alias", "androiddebugkey",
            "-keypass", "android",
            "-keyalg", "RSA",
            "-keysize", "2048",
            "-validity", "10000",
            "-dname", "CN=Android Debug,O=Android,C=US"
        ]
        subprocess.run(cmd, check=True, stdout=subprocess.DEVNULL)

def merge_and_patch_apk(extracted_dir: str, output_apk: str, old_pkg: str, new_pkg: str):
    base_apk = os.path.join(extracted_dir, "base.apk")
    arm64_apk = os.path.join(extracted_dir, "split_config.arm64_v8a.apk")
    xxhdpi_apk = os.path.join(extracted_dir, "split_config.xxhdpi.apk")
    en_apk = os.path.join(extracted_dir, "split_config.en.apk")

    tmp_unaligned = output_apk + ".unaligned.tmp"
    tmp_aligned = output_apk + ".aligned.tmp"
    keystore_path = "dist/debug.keystore"

    print(f"[*] Step 1: Merging Split APKs for arm64-v8a target...")
    ensure_keystore(keystore_path)

    added_files = set()
    with zipfile.ZipFile(tmp_unaligned, 'w', compression=zipfile.ZIP_DEFLATED) as out_zip:
        # 1. Base APK files
        with zipfile.ZipFile(base_apk, 'r') as z_base:
            manifest_bytes = z_base.read('AndroidManifest.xml')
            patched_manifest = patch_axml(manifest_bytes, old_pkg, new_pkg)
            out_zip.writestr('AndroidManifest.xml', patched_manifest)
            added_files.add('AndroidManifest.xml')

            for item in z_base.infolist():
                if item.filename in ('AndroidManifest.xml', 'stamp-cert-sha256'):
                    continue
                if item.filename.startswith('META-INF/'):
                    continue  # Strip old signatures
                out_zip.writestr(item, z_base.read(item.filename))
                added_files.add(item.filename)

        # 2. ARM64-v8a native libraries
        if os.path.exists(arm64_apk):
            print("    + Merging arm64-v8a native .so libraries...")
            with zipfile.ZipFile(arm64_apk, 'r') as z_arm:
                for item in z_arm.infolist():
                    if item.filename.startswith('META-INF/') or item.filename in ('AndroidManifest.xml', 'stamp-cert-sha256'):
                        continue
                    if item.filename not in added_files:
                        out_zip.writestr(item, z_arm.read(item.filename))
                        added_files.add(item.filename)

        # 3. High-density drawables
        if os.path.exists(xxhdpi_apk):
            print("    + Merging xxhdpi screen assets...")
            with zipfile.ZipFile(xxhdpi_apk, 'r') as z_xxhdpi:
                for item in z_xxhdpi.infolist():
                    if item.filename.startswith('META-INF/') or item.filename in ('AndroidManifest.xml', 'resources.arsc', 'stamp-cert-sha256'):
                        continue
                    if item.filename not in added_files:
                        out_zip.writestr(item, z_xxhdpi.read(item.filename))
                        added_files.add(item.filename)

        # 4. English language resources
        if os.path.exists(en_apk):
            print("    + Merging English locale resources...")
            with zipfile.ZipFile(en_apk, 'r') as z_en:
                for item in z_en.infolist():
                    if item.filename.startswith('META-INF/') or item.filename in ('AndroidManifest.xml', 'resources.arsc', 'stamp-cert-sha256'):
                        continue
                    if item.filename not in added_files:
                        out_zip.writestr(item, z_en.read(item.filename))
                        added_files.add(item.filename)

    print(f"[+] Merged {len(added_files)} files into unified standalone APK.")

    # 4-byte zipalign
    print(f"[*] Step 2: Running 4-byte memory alignment (zipalign)...")
    if os.path.exists(tmp_aligned):
        os.remove(tmp_aligned)
    cmd_zipalign = [ZIPALIGN_BIN, "-p", "-f", "4", tmp_unaligned, tmp_aligned]
    subprocess.run(cmd_zipalign, check=True)
    os.remove(tmp_unaligned)

    # apksigner
    print(f"[*] Step 3: Signing APK with debug keystore (apksigner)...")
    if os.path.exists(output_apk):
        os.remove(output_apk)
    shutil.move(tmp_aligned, output_apk)

    env = dict(os.environ)
    env["PATH"] = f"{os.path.join(JAVA_HOME, 'bin')}:{env.get('PATH', '')}"
    env["JAVA_HOME"] = JAVA_HOME

    cmd_sign = [
        APKSIGNER_BIN, "sign",
        "--ks", keystore_path,
        "--ks-pass", "pass:android",
        "--ks-key-alias", "androiddebugkey",
        "--key-pass", "pass:android",
        "--min-sdk-version", "21",
        "--max-sdk-version", "35",
        "--v1-signing-enabled", "true",
        "--v2-signing-enabled", "true",
        "--v3-signing-enabled", "true",
        output_apk
    ]
    subprocess.run(cmd_sign, check=True, env=env)

    # Verification
    print(f"[*] Step 4: Verifying APK signature...")
    cmd_verify = [APKSIGNER_BIN, "verify", "--verbose", output_apk]
    res = subprocess.run(cmd_verify, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, env=env)
    print(res.stdout.strip())

    apk_size_mb = os.path.getsize(output_apk) / (1024 * 1024)
    print(f"\n[✓] SUCCESS: Built standalone dual-install APK:")
    print(f"    Path        : {output_apk}")
    print(f"    Size        : {apk_size_mb:.2f} MB")
    print(f"    Package ID  : {new_pkg}")
    print(f"    Target Arch : arm64-v8a")
    print(f"    Co-existence: Side-by-side with official {old_pkg}")

def build_split_apks(extracted_dir: str, splits_out_dir: str, old_pkg: str, new_pkg: str, install: bool = False):
    """Patches and signs individual split APKs to preserve exact resource tables."""
    os.makedirs(splits_out_dir, exist_ok=True)
    keystore_path = "dist/debug.keystore"
    ensure_keystore(keystore_path)

    env = dict(os.environ)
    env["PATH"] = f"{os.path.join(JAVA_HOME, 'bin')}:{env.get('PATH', '')}"
    env["JAVA_HOME"] = JAVA_HOME

    apks = ["base.apk", "split_config.arm64_v8a.apk", "split_config.xxhdpi.apk", "split_config.en.apk"]
    output_apks = []

    print(f"[*] Packaging individual split APKs for {new_pkg}...")
    for apk_name in apks:
        in_path = os.path.join(extracted_dir, apk_name)
        if not os.path.exists(in_path):
            continue
        tmp_unaligned = os.path.join(splits_out_dir, apk_name + ".unaligned.tmp")
        tmp_aligned = os.path.join(splits_out_dir, apk_name + ".aligned.tmp")
        out_path = os.path.join(splits_out_dir, apk_name)

        with zipfile.ZipFile(in_path, 'r') as zin:
            with zipfile.ZipFile(tmp_unaligned, 'w', compression=zipfile.ZIP_DEFLATED) as zout:
                for item in zin.infolist():
                    if item.filename == 'AndroidManifest.xml':
                        m_data = zin.read('AndroidManifest.xml')
                        patched = patch_axml(m_data, old_pkg, new_pkg)
                        zout.writestr('AndroidManifest.xml', patched)
                    elif item.filename.startswith('META-INF/') or item.filename == 'stamp-cert-sha256':
                        continue
                    else:
                        zout.writestr(item, zin.read(item.filename))

        if os.path.exists(tmp_aligned):
            os.remove(tmp_aligned)
        subprocess.run([ZIPALIGN_BIN, "-p", "-f", "4", tmp_unaligned, tmp_aligned], check=True)
        os.remove(tmp_unaligned)

        if os.path.exists(out_path):
            os.remove(out_path)
        shutil.move(tmp_aligned, out_path)

        cmd_sign = [
            APKSIGNER_BIN, "sign",
            "--ks", keystore_path,
            "--ks-pass", "pass:android",
            "--ks-key-alias", "androiddebugkey",
            "--key-pass", "pass:android",
            "--min-sdk-version", "21",
            "--max-sdk-version", "35",
            "--v1-signing-enabled", "true",
            "--v2-signing-enabled", "true",
            "--v3-signing-enabled", "true",
            out_path
        ]
        subprocess.run(cmd_sign, check=True, env=env)
        output_apks.append(out_path)
        print(f"    + Signed: {out_path}")

    print(f"[✓] Successfully built {len(output_apks)} patched split APKs in {splits_out_dir}/")

    if install:
        adb_bin = "/home/deepak/Android/Sdk/platform-tools/adb"
        print(f"[*] Installing split APKs via ADB ({adb_bin} install-multiple)...")
        cmd_install = [adb_bin, "install-multiple", "-r"] + output_apks
        res = subprocess.run(cmd_install, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        print(res.stdout.strip())
        if res.returncode == 0:
            print(f"[✓] Installed successfully on connected Android device!")
        else:
            print(f"[!] ADB Install error: {res.stderr.strip()}")

def main():
    parser = argparse.ArgumentParser(description="Universal ARM64 Dual-Installation APK Builder")
    parser.add_argument("--extracted-dir", default="extracted_apks", help="Directory with split APKs")
    parser.add_argument("--old-pkg", default=DEFAULT_OLD_PKG, help="Original package name")
    parser.add_argument("--new-pkg", default=DEFAULT_NEW_PKG, help="New package name")
    parser.add_argument("--out", default="dist/bajaj-ride-connect-debug.apk", help="Output APK path")
    parser.add_argument("--splits-dir", default="dist/splits", help="Output directory for split APKs")
    parser.add_argument("--install", action="store_true", help="Install split APKs directly to connected device via ADB")
    args = parser.parse_args()

    os.makedirs(os.path.dirname(os.path.abspath(args.out)), exist_ok=True)
    merge_and_patch_apk(args.extracted_dir, args.out, args.old_pkg, args.new_pkg)
    build_split_apks(args.extracted_dir, args.splits_dir, args.old_pkg, args.new_pkg, install=args.install)

if __name__ == "__main__":
    main()
