#!/usr/bin/env bash
set -euo pipefail

# ==============================================================================
# Pulsar Ride Connect — Official Android & Google Standards Build Engine
# Optimized for: ARM64-v8a | Production Signing | Modern D8/R8 | Zero Warnings
# ==============================================================================

ANDROID_HOME="${ANDROID_HOME:-/home/deepak/Android/Sdk}"
JAVA_HOME="${JAVA_HOME:-/opt/android-studio/jbr}"
export PATH="$JAVA_HOME/bin:$PATH"

BUILD_TOOLS="$ANDROID_HOME/build-tools/36.0.0"
PLATFORM_JAR="$ANDROID_HOME/platforms/android-37.0/android.jar"
ADB="$ANDROID_HOME/platform-tools/adb"

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC="$ROOT/app"
BUILD="$SRC/build"
DIST="$ROOT/dist"

TARGET_ABI="arm64-v8a"
BUILD_TYPE="release"
DO_INSTALL=false

for arg in "$@"; do
  case "$arg" in
    debug)
      BUILD_TYPE="debug"
      ;;
    release)
      BUILD_TYPE="release"
      ;;
    --install|-i)
      DO_INSTALL=true
      ;;
    *)
      ;;
  esac
done

FINAL_APK="$DIST/my-pulsar-${BUILD_TYPE}-${TARGET_ABI}.apk"
DEFAULT_APK="$DIST/my-pulsar.apk"

mkdir -p "$DIST"
rm -rf "$BUILD"
mkdir -p "$BUILD"/{res,gen,obj,dex}

# Keystore configuration
if [[ "$BUILD_TYPE" == "release" ]]; then
  KS="${PROD_KEYSTORE:-$DIST/release.keystore}"
  KS_PASS="${PROD_KEYSTORE_PASS:-pulsar@production2026}"
  KEY_ALIAS="${PROD_KEY_ALIAS:-pulsar-release}"
  KEY_PASS="${PROD_KEY_PASS:-pulsar@production2026}"

  if [[ ! -f "$KS" ]]; then
    echo "[*] Generating production release keystore (RSA 4096-bit)..."
    keytool -genkeypair -v -keystore "$KS" -storepass "$KS_PASS" \
      -alias "$KEY_ALIAS" -keypass "$KEY_PASS" -keyalg RSA -keysize 4096 \
      -validity 10000 -dname "CN=Bajaj Pulsar Connect, OU=Automotive, O=Bajaj, C=IN" >/dev/null 2>&1
    chmod 600 "$KS"
  fi
else
  KS="$DIST/debug.keystore"
  KS_PASS="android"
  KEY_ALIAS="androiddebugkey"
  KEY_PASS="android"

  if [[ ! -f "$KS" ]]; then
    echo "[*] Generating debug keystore..."
    keytool -genkeypair -v -keystore "$KS" -storepass android \
      -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 \
      -validity 10000 -dname "CN=Android Debug,O=Android,C=US" >/dev/null 2>&1
  fi
fi

echo "=================================================="
echo " Building My Pulsar [$BUILD_TYPE] [target: $TARGET_ABI]"
echo "=================================================="

# 1. Compile & Link Resources (AAPT2)
echo "[1/5] Processing resources (AAPT2)..."
"$BUILD_TOOLS/aapt2" compile --dir "$SRC/res" -o "$BUILD/res"

AAPT2_LINK_ARGS=(
  -I "$PLATFORM_JAR"
  --manifest "$SRC/AndroidManifest.xml"
  --java "$BUILD/gen"
  -o "$BUILD/unaligned.apk"
  --auto-add-overlay
)
if [[ "$BUILD_TYPE" == "debug" ]]; then
  AAPT2_LINK_ARGS+=(--debug-mode)
fi

"$BUILD_TOOLS/aapt2" link "${AAPT2_LINK_ARGS[@]}" "$BUILD"/res/*.flat

# 2. Compile Generated R.java & Kotlin Sources
echo "[2/5] Compiling generated R.java & Kotlin sources..."
find "$BUILD/gen" -name "*.java" > "$BUILD/gen_sources.txt"
if [[ -s "$BUILD/gen_sources.txt" ]]; then
  javac -source 17 -target 17 -Xlint:-options -classpath "$PLATFORM_JAR" -d "$BUILD/obj" @"$BUILD/gen_sources.txt"
fi

KOTLIN_HOME="${KOTLIN_HOME:-/opt/android-studio/plugins/Kotlin/kotlinc}"
KOTLINC="$KOTLIN_HOME/bin/kotlinc"
KOTLIN_LIB="$KOTLIN_HOME/lib"

find "$SRC/src" -name "*.kt" > "$BUILD/kt_sources.txt"
if [[ -s "$BUILD/kt_sources.txt" ]]; then
  "$KOTLINC" -language-version 2.1 -api-version 2.1 -jvm-target 17 \
    -classpath "$PLATFORM_JAR:$BUILD/obj" -d "$BUILD/obj" @"$BUILD/kt_sources.txt"
fi

# 3. Modern R8 / D8 DEX Engine (Release Optimized, Zero Metadata Warnings)
echo "[3/5] Converting bytecode to Dalvik Executable ($BUILD_TYPE DEX)..."
R8_JAR=""
for candidate in \
  "/opt/android-studio/plugins/android/lib/r8.jar" \
  "$ANDROID_HOME/cmdline-tools/22.0/lib/r8.jar"; do
  if [[ -f "$candidate" ]]; then
    R8_JAR="$candidate"
    break
  fi
done

if [[ -n "$R8_JAR" ]]; then
  D8_CMD=(java -cp "$R8_JAR" com.android.tools.r8.D8)
else
  D8_CMD=("$BUILD_TOOLS/d8")
fi

D8_FLAGS=(--min-api 26)
if [[ "$BUILD_TYPE" == "release" ]]; then
  D8_FLAGS+=(--release)
else
  D8_FLAGS+=(--debug)
fi

"${D8_CMD[@]}" "${D8_FLAGS[@]}" --output "$BUILD/dex" --lib "$PLATFORM_JAR" \
  $(find "$BUILD/obj" -name "*.class") "$KOTLIN_LIB/kotlin-stdlib.jar"

# 4. Package & Align (ARM64-v8a 4-byte Page Alignment)
echo "[4/5] Packaging & Aligning APK ($TARGET_ABI)..."
(cd "$BUILD/dex" && zip -ujq "$BUILD/unaligned.apk" classes.dex)

if [[ -d "$SRC/jniLibs/$TARGET_ABI" ]]; then
  mkdir -p "$BUILD/lib/$TARGET_ABI"
  cp "$SRC/jniLibs/$TARGET_ABI"/*.so "$BUILD/lib/$TARGET_ABI/" 2>/dev/null || true
  (cd "$BUILD" && zip -ujq "$BUILD/unaligned.apk" lib/"$TARGET_ABI"/*.so)
fi

"$BUILD_TOOLS/zipalign" -p -f 4 "$BUILD/unaligned.apk" "$BUILD/aligned.apk"
"$BUILD_TOOLS/zipalign" -c 4 "$BUILD/aligned.apk"

# 5. Sign (Production Key with V1, V2, V3, V4 Schemes)
echo "[5/5] Cryptographically Signing APK ($KEY_ALIAS)..."
"$BUILD_TOOLS/apksigner" -J-enable-native-access=ALL-UNNAMED sign \
  --ks "$KS" --ks-pass "pass:$KS_PASS" \
  --ks-key-alias "$KEY_ALIAS" --key-pass "pass:$KEY_PASS" \
  --min-sdk-version 24 \
  --v1-signing-enabled true \
  --v2-signing-enabled true \
  --v3-signing-enabled true \
  --v4-signing-enabled true \
  --out "$FINAL_APK" "$BUILD/aligned.apk"

# Verification
"$BUILD_TOOLS/apksigner" -J-enable-native-access=ALL-UNNAMED verify --verbose "$FINAL_APK" >/dev/null

# Create canonical link to dist/my-pulsar.apk
cp -f "$FINAL_APK" "$DEFAULT_APK"

echo "=================================================="
echo "[✓] SUCCESS: $FINAL_APK ($(du -h "$FINAL_APK" | cut -f1))"
echo "    Target ABI : $TARGET_ABI (AArch64)"
echo "    Build Type : $BUILD_TYPE"
echo "    Signer     : $KEY_ALIAS (RSA 4096 / SHA-256)"
echo "    Signatures : V1, V2, V3, V4 (Verified)"
echo "    Canonical  : $DEFAULT_APK"
echo "=================================================="

if [[ "$DO_INSTALL" == true ]]; then
  echo "[*] Installing to device via ADB..."
  "$ADB" install -r "$FINAL_APK"
  "$ADB" shell am start -n com.bajaj.rideconnect.re/.MainActivity
fi
