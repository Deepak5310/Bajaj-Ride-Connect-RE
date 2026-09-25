#!/usr/bin/env bash
set -euo pipefail

ANDROID_HOME="${ANDROID_HOME:-/home/deepak/Android/Sdk}"
JAVA_HOME="${JAVA_HOME:-/opt/android-studio/jbr}"
export PATH="$JAVA_HOME/bin:$PATH"

BUILD_TOOLS="$ANDROID_HOME/build-tools/36.0.0"
PLATFORM_JAR="$ANDROID_HOME/platforms/android-37.0/android.jar"
ADB="$ANDROID_HOME/platform-tools/adb"

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC="$ROOT/app"
BUILD="$SRC/build"
SRC="$ROOT/app/src/main"
BUILD="$ROOT/app/build"
DIST="$ROOT/dist"
APK="$DIST/my-pulsar.apk"
KS="$DIST/debug.keystore"

mkdir -p "$DIST"
[[ -f "$KS" ]] || keytool -genkeypair -v -keystore "$KS" -storepass android \
  -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 \
  -validity 10000 -dname "CN=Android Debug,O=Android,C=US" >/dev/null 2>&1

rm -rf "$BUILD"
mkdir -p "$BUILD"/{res,gen,obj,dex}

echo "=== Building My Pulsar APK ==="

# 1. Compile & Link Resources
echo "[1/4] Processing resources..."
"$BUILD_TOOLS/aapt2" compile --dir "$SRC/res" -o "$BUILD/res"
"$BUILD_TOOLS/aapt2" link -I "$PLATFORM_JAR" \
  --manifest "$SRC/AndroidManifest.xml" \
  --java "$BUILD/gen" \
  --min-sdk-version 26 \
  --target-sdk-version 35 \
  -o "$BUILD/unaligned.apk" \
  --auto-add-overlay "$BUILD"/res/*.flat

# 2. Compile Java & DEX
echo "[2/4] Compiling Java & DEX..."
find "$SRC/java" "$BUILD/gen" -name "*.java" > "$BUILD/sources.txt"
javac -source 17 -target 17 -Xlint:-options -classpath "$PLATFORM_JAR" -d "$BUILD/obj" @"$BUILD/sources.txt"
"$BUILD_TOOLS/d8" --min-api 24 --output "$BUILD/dex" --lib "$PLATFORM_JAR" $(find "$BUILD/obj" -name "*.class")
"$BUILD_TOOLS/d8" --min-api 26 --output "$BUILD/dex" --lib "$PLATFORM_JAR" $(find "$BUILD/obj" -name "*.class")

# 3. Package & Align
echo "[3/4] Aligning APK..."
(cd "$BUILD/dex" && zip -ujq "$BUILD/unaligned.apk" classes.dex)
"$BUILD_TOOLS/zipalign" -p -f 4 "$BUILD/unaligned.apk" "$BUILD/aligned.apk"

# 4. Sign
echo "[4/4] Signing APK..."
"$BUILD_TOOLS/apksigner" -J-enable-native-access=ALL-UNNAMED sign --ks "$KS" --ks-pass pass:android \
  --ks-key-alias androiddebugkey --key-pass pass:android \
  --min-sdk-version 24 --v1-signing-enabled true --v2-signing-enabled true \
  --v3-signing-enabled true --out "$APK" "$BUILD/aligned.apk"

echo "=================================================="
echo "[✓] SUCCESS: $APK ($(du -h "$APK" | cut -f1))"
echo "=================================================="

if [[ "${1:-}" == "--install" || "${1:-}" == "-i" ]]; then
  echo "[*] Installing to device via ADB..."
  "$ADB" install -r "$APK"
  "$ADB" shell am start -n com.bajaj.rideconnect.re/.MainActivity
fi

