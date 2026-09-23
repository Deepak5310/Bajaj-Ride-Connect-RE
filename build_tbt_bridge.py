#!/usr/bin/env python3
"""
Standalone Build Script for Pulsar NS400Z Google Maps TBT Bridge APK.
Compiles Java sources, resources, generates DEX, packages, zip-aligns, and signs APK.
"""

import os
import sys
import shutil
import subprocess

BUILD_TOOLS = "/home/deepak/Android/Sdk/build-tools/36.0.0"
PLATFORM_JAR = "/home/deepak/Android/Sdk/platforms/android-37.0/android.jar"
JAVA_HOME = "/opt/android-studio/jbr"
JAVAC_BIN = os.path.join(JAVA_HOME, "bin/javac")
KEYTOOL_BIN = os.path.join(JAVA_HOME, "bin/keytool")
AAPT2_BIN = os.path.join(BUILD_TOOLS, "aapt2")
D8_BIN = os.path.join(BUILD_TOOLS, "d8")
ZIPALIGN_BIN = os.path.join(BUILD_TOOLS, "zipalign")
APKSIGNER_BIN = os.path.join(BUILD_TOOLS, "apksigner")
ADB_BIN = "/home/deepak/Android/Sdk/platform-tools/adb"

KEYSTORE_PATH = "dist/debug.keystore"
OUTPUT_APK = "dist/pulsar-tbt-bridge.apk"
BUILD_DIR = "tbt-bridge/build"

def ensure_keystore():
    os.makedirs(os.path.dirname(os.path.abspath(KEYSTORE_PATH)), exist_ok=True)
    if not os.path.exists(KEYSTORE_PATH):
        print(f"[*] Generating debug keystore at {KEYSTORE_PATH}...")
        cmd = [
            KEYTOOL_BIN, "-genkeypair", "-v",
            "-keystore", KEYSTORE_PATH,
            "-storepass", "android",
            "-alias", "androiddebugkey",
            "-keypass", "android",
            "-keyalg", "RSA",
            "-keysize", "2048",
            "-validity", "10000",
            "-dname", "CN=Android Debug,O=Android,C=US"
        ]
        env = dict(os.environ)
        env["PATH"] = f"{os.path.join(JAVA_HOME, 'bin')}:{env.get('PATH', '')}"
        env["JAVA_HOME"] = JAVA_HOME
        subprocess.run(cmd, check=True, stdout=subprocess.DEVNULL, env=env)

def build_app(install: bool = False):
    print("=" * 60)
    print("  Building Pulsar NS400Z TBT Navigation Bridge APK")
    print("=" * 60)

    # Clean build dir
    if os.path.exists(BUILD_DIR):
        shutil.rmtree(BUILD_DIR)
    os.makedirs(f"{BUILD_DIR}/compiled_res", exist_ok=True)
    os.makedirs(f"{BUILD_DIR}/gen", exist_ok=True)
    os.makedirs(f"{BUILD_DIR}/obj", exist_ok=True)
    os.makedirs(f"{BUILD_DIR}/dex", exist_ok=True)

    ensure_keystore()

    # Step 1: AAPT2 Compile Resources
    print("[1/6] Compiling Android resources (aapt2 compile)...")
    cmd_res_compile = [
        AAPT2_BIN, "compile", "--dir", "tbt-bridge/res", "-o", f"{BUILD_DIR}/compiled_res"
    ]
    subprocess.run(cmd_res_compile, check=True)

    # Step 2: AAPT2 Link Resources & Generate R.java
    print("[2/6] Linking resources & generating R.java (aapt2 link)...")
    res_zips = [os.path.join(f"{BUILD_DIR}/compiled_res", f) for f in os.listdir(f"{BUILD_DIR}/compiled_res") if f.endswith(".flat")]
    unaligned_apk = f"{BUILD_DIR}/unaligned.apk"
    cmd_link = [
        AAPT2_BIN, "link",
        "-I", PLATFORM_JAR,
        "--manifest", "tbt-bridge/AndroidManifest.xml",
        "--java", f"{BUILD_DIR}/gen",
        "-o", unaligned_apk,
        "--auto-add-overlay"
    ] + res_zips
    subprocess.run(cmd_link, check=True)

    # Step 3: Java Compilation
    print("[3/6] Compiling Java sources (javac)...")
    java_files = []
    for root, _, files in os.walk("tbt-bridge/src"):
        for f in files:
            if f.endswith(".java"):
                java_files.append(os.path.join(root, f))
    for root, _, files in os.walk(f"{BUILD_DIR}/gen"):
        for f in files:
            if f.endswith(".java"):
                java_files.append(os.path.join(root, f))

    cmd_javac = [
        JAVAC_BIN,
        "-source", "17",
        "-target", "17",
        "-classpath", PLATFORM_JAR,
        "-d", f"{BUILD_DIR}/obj"
    ] + java_files
    subprocess.run(cmd_javac, check=True)

    env = dict(os.environ)
    env["PATH"] = f"{os.path.join(JAVA_HOME, 'bin')}:{env.get('PATH', '')}"
    env["JAVA_HOME"] = JAVA_HOME

    # Step 4: D8 DEX Compilation
    print("[4/6] Converting bytecode to Dalvik Executable (d8)...")
    class_files = []
    for root, _, files in os.walk(f"{BUILD_DIR}/obj"):
        for f in files:
            if f.endswith(".class"):
                class_files.append(os.path.join(root, f))

    cmd_d8 = [
        D8_BIN,
        "--min-api", "24",
        "--output", f"{BUILD_DIR}/dex",
        "--lib", PLATFORM_JAR
    ] + class_files
    subprocess.run(cmd_d8, check=True, env=env)

    # Step 5: Add classes.dex into APK and Zipalign
    print("[5/6] Packaging & 4-byte memory aligning (zipalign)...")
    # Add classes.dex to unaligned.apk
    import zipfile
    with zipfile.ZipFile(unaligned_apk, 'a') as z:
        z.write(f"{BUILD_DIR}/dex/classes.dex", "classes.dex")

    aligned_apk = f"{BUILD_DIR}/aligned.apk"
    if os.path.exists(aligned_apk):
        os.remove(aligned_apk)
    cmd_zipalign = [ZIPALIGN_BIN, "-p", "-f", "4", unaligned_apk, aligned_apk]
    subprocess.run(cmd_zipalign, check=True)

    # Step 6: Sign with APKSIGNER
    print("[6/6] Signing APK with debug keystore (apksigner)...")
    if os.path.exists(OUTPUT_APK):
        os.remove(OUTPUT_APK)
    shutil.move(aligned_apk, OUTPUT_APK)

    env = dict(os.environ)
    env["PATH"] = f"{os.path.join(JAVA_HOME, 'bin')}:{env.get('PATH', '')}"
    env["JAVA_HOME"] = JAVA_HOME

    cmd_sign = [
        APKSIGNER_BIN, "sign",
        "--ks", KEYSTORE_PATH,
        "--ks-pass", "pass:android",
        "--ks-key-alias", "androiddebugkey",
        "--key-pass", "pass:android",
        "--min-sdk-version", "24",
        "--v1-signing-enabled", "true",
        "--v2-signing-enabled", "true",
        "--v3-signing-enabled", "true",
        OUTPUT_APK
    ]
    subprocess.run(cmd_sign, check=True, env=env)

    size_kb = os.path.getsize(OUTPUT_APK) / 1024
    print("\n" + "=" * 60)
    print(f"[✓] SUCCESS: Built standalone Google Maps TBT Bridge APK:")
    print(f"    Path : {OUTPUT_APK}")
    print(f"    Size : {size_kb:.1f} KB (Ultra-lightweight!)")
    print("=" * 60)

    if install:
        print(f"\n[*] Installing {OUTPUT_APK} to connected device via ADB...")
        cmd_install = [ADB_BIN, "install", "-r", OUTPUT_APK]
        res = subprocess.run(cmd_install, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        print(res.stdout.strip())
        if res.returncode == 0:
            print("[✓] Installed successfully on device!")
            print("[*] Launching NS400Z TBT Bridge...")
            subprocess.run([ADB_BIN, "shell", "am", "start", "-n", "com.pulsar.ns400z.tbtbridge/.MainActivity"], check=True)
        else:
            print(f"[!] ADB Install error: {res.stderr.strip()}")

if __name__ == "__main__":
    install_flag = "--install" in sys.argv or "-i" in sys.argv
    build_app(install=install_flag)
