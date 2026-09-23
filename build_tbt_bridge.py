#!/usr/bin/env python3
"""Standalone Build Script for My Pulsar (Bajaj Ride Connect RE) APK.

Compiles Android resources (aapt2), generates R.java, compiles Java sources (javac),
desugars to DEX (d8), packages APK, 4-byte memory aligns (zipalign), and signs (apksigner).
"""

import os
import shutil
import subprocess
import sys
import time
import zipfile
from pathlib import Path

# ---------------------------------------------------------------------------
# SDK & Toolchain Configuration
# ---------------------------------------------------------------------------
ANDROID_HOME = Path(
    os.environ.get("ANDROID_HOME")
    or os.environ.get("ANDROID_SDK_ROOT")
    or "/home/deepak/Android/Sdk"
)
BUILD_TOOLS_VERSION = "36.0.0"
PLATFORM_VERSION = "android-37.0"

BUILD_TOOLS = ANDROID_HOME / "build-tools" / BUILD_TOOLS_VERSION
PLATFORM_JAR = ANDROID_HOME / "platforms" / PLATFORM_VERSION / "android.jar"
JAVA_HOME = Path(os.environ.get("JAVA_HOME") or "/opt/android-studio/jbr")

AAPT2_BIN = BUILD_TOOLS / "aapt2"
D8_BIN = BUILD_TOOLS / "d8"
ZIPALIGN_BIN = BUILD_TOOLS / "zipalign"
APKSIGNER_BIN = BUILD_TOOLS / "apksigner"
ADB_BIN = ANDROID_HOME / "platform-tools" / "adb"

JAVAC_BIN = JAVA_HOME / "bin" / "javac"
KEYTOOL_BIN = JAVA_HOME / "bin" / "keytool"

# ---------------------------------------------------------------------------
# Project Paths
# ---------------------------------------------------------------------------
ROOT_DIR = Path(__file__).resolve().parent
PROJECT_DIR = ROOT_DIR / "tbt-bridge"
BUILD_DIR = PROJECT_DIR / "build"
DIST_DIR = ROOT_DIR / "dist"

MANIFEST_FILE = PROJECT_DIR / "AndroidManifest.xml"
RES_DIR = PROJECT_DIR / "res"
SRC_DIR = PROJECT_DIR / "src"

KEYSTORE_PATH = DIST_DIR / "debug.keystore"
OUTPUT_APK = DIST_DIR / "my-pulsar.apk"

# Pre-configured environment for tools requiring Java in PATH
BUILD_ENV = dict(os.environ)
BUILD_ENV["PATH"] = f"{JAVA_HOME / 'bin'}:{BUILD_ENV.get('PATH', '')}"
BUILD_ENV["JAVA_HOME"] = str(JAVA_HOME)


def ensure_keystore() -> None:
    """Generate a 2048-bit RSA debug keystore if it doesn't already exist."""
    DIST_DIR.mkdir(parents=True, exist_ok=True)
    if not KEYSTORE_PATH.exists():
        print(f"[*] Generating debug keystore at {KEYSTORE_PATH}...")
        cmd = [
            str(KEYTOOL_BIN),
            "-genkeypair",
            "-v",
            "-keystore",
            str(KEYSTORE_PATH),
            "-storepass",
            "android",
            "-alias",
            "androiddebugkey",
            "-keypass",
            "android",
            "-keyalg",
            "RSA",
            "-keysize",
            "2048",
            "-validity",
            "10000",
            "-dname",
            "CN=Android Debug,O=Android,C=US",
        ]
        subprocess.run(
            cmd,
            check=True,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL,
            env=BUILD_ENV,
        )


def build_app(install: bool = False) -> None:
    """Execute complete compilation, dexing, alignment, and signing pipeline."""
    total_start = time.time()
    print("=" * 64)
    print("  Building 'My Pulsar' Standalone Automotive Bridge APK")
    print("=" * 64)

    # 1. Clean and setup build staging directories
    if BUILD_DIR.exists():
        shutil.rmtree(BUILD_DIR)

    compiled_res_dir = BUILD_DIR / "compiled_res"
    gen_dir = BUILD_DIR / "gen"
    obj_dir = BUILD_DIR / "obj"
    dex_dir = BUILD_DIR / "dex"

    for d in (compiled_res_dir, gen_dir, obj_dir, dex_dir, DIST_DIR):
        d.mkdir(parents=True, exist_ok=True)

    ensure_keystore()

    # Step 1: AAPT2 Compile Resources
    t0 = time.time()
    print("[1/6] Compiling Android resources (aapt2 compile)...")
    cmd_res_compile = [
        str(AAPT2_BIN),
        "compile",
        "--dir",
        str(RES_DIR),
        "-o",
        str(compiled_res_dir),
    ]
    subprocess.run(cmd_res_compile, check=True)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    # Step 2: AAPT2 Link Resources & Generate R.java
    t0 = time.time()
    print("[2/6] Linking resources & generating R.java (aapt2 link)...")
    res_zips = [str(f) for f in compiled_res_dir.glob("*.flat")]
    unaligned_apk = BUILD_DIR / "unaligned.apk"

    cmd_link = [
        str(AAPT2_BIN),
        "link",
        "-I",
        str(PLATFORM_JAR),
        "--manifest",
        str(MANIFEST_FILE),
        "--java",
        str(gen_dir),
        "-o",
        str(unaligned_apk),
        "--auto-add-overlay",
        *res_zips,
    ]
    subprocess.run(cmd_link, check=True)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    # Step 3: Java Compilation
    t0 = time.time()
    print("[3/6] Compiling Java sources (javac)...")
    java_files = [str(f) for f in SRC_DIR.rglob("*.java")]
    java_files.extend(str(f) for f in gen_dir.rglob("*.java"))

    cmd_javac = [
        str(JAVAC_BIN),
        "-source",
        "17",
        "-target",
        "17",
        "-Xlint:-options",
        "-classpath",
        str(PLATFORM_JAR),
        "-d",
        str(obj_dir),
        *java_files,
    ]
    subprocess.run(cmd_javac, check=True)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    # Step 4: D8 DEX Compilation
    t0 = time.time()
    print("[4/6] Converting bytecode to Dalvik Executable (d8)...")
    class_files = [str(f) for f in obj_dir.rglob("*.class")]

    cmd_d8 = [
        str(D8_BIN),
        "--min-api",
        "24",
        "--output",
        str(dex_dir),
        "--lib",
        str(PLATFORM_JAR),
        *class_files,
    ]
    subprocess.run(cmd_d8, check=True, env=BUILD_ENV)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    # Step 5: Add classes.dex into APK and Zipalign
    t0 = time.time()
    print("[5/6] Packaging & 4-byte memory aligning (zipalign)...")
    with zipfile.ZipFile(unaligned_apk, "a") as z:
        z.write(dex_dir / "classes.dex", "classes.dex")

    aligned_apk = BUILD_DIR / "aligned.apk"
    if aligned_apk.exists():
        aligned_apk.unlink()

    cmd_zipalign = [
        str(ZIPALIGN_BIN),
        "-p",
        "-f",
        "4",
        str(unaligned_apk),
        str(aligned_apk),
    ]
    subprocess.run(cmd_zipalign, check=True)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    # Step 6: Sign with APKSIGNER
    t0 = time.time()
    print("[6/6] Signing APK with debug keystore (apksigner)...")
    if OUTPUT_APK.exists():
        OUTPUT_APK.unlink()
    shutil.move(str(aligned_apk), str(OUTPUT_APK))

    cmd_sign = [
        str(APKSIGNER_BIN),
        "sign",
        "--ks",
        str(KEYSTORE_PATH),
        "--ks-pass",
        "pass:android",
        "--ks-key-alias",
        "androiddebugkey",
        "--key-pass",
        "pass:android",
        "--min-sdk-version",
        "24",
        "--v1-signing-enabled",
        "true",
        "--v2-signing-enabled",
        "true",
        "--v3-signing-enabled",
        "true",
        str(OUTPUT_APK),
    ]
    subprocess.run(cmd_sign, check=True, env=BUILD_ENV)
    print(f"      -> Completed in {time.time() - t0:.2f}s")

    size_kb = OUTPUT_APK.stat().st_size / 1024
    elapsed = time.time() - total_start
    print("\n" + "=" * 64)
    print("[✓] SUCCESS: Built standalone My Pulsar Bridge APK:")
    print(f"    Path    : {OUTPUT_APK}")
    print(f"    Size    : {size_kb:.1f} KB (Ultra-lightweight!)")
    print(f"    Time    : {elapsed:.2f}s")
    print("=" * 64)

    if install:
        print(f"\n[*] Installing {OUTPUT_APK} to connected device via ADB...")
        cmd_install = [str(ADB_BIN), "install", "-r", str(OUTPUT_APK)]
        res = subprocess.run(cmd_install, capture_output=True, text=True, check=False)
        output = (res.stdout or res.stderr).strip()
        print(output)
        if res.returncode == 0:
            print("[✓] Installed successfully on device!")
            print("[*] Launching My Pulsar...")
            cmd_launch = [
                str(ADB_BIN),
                "shell",
                "am",
                "start",
                "-n",
                "com.bajaj.rideconnect.re/.MainActivity",
            ]
            subprocess.run(cmd_launch, check=True)
        else:
            print(f"[!] ADB Install error: {res.stderr.strip()}")


if __name__ == "__main__":
    install_flag = "--install" in sys.argv or "-i" in sys.argv
    try:
        build_app(install=install_flag)
    except subprocess.CalledProcessError as e:
        print(f"\n[!] Build failed during step: {e.cmd[0] if e.cmd else 'command'}")
        sys.exit(e.returncode)
