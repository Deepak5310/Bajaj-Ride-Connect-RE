# My Pulsar (Android App)

Standalone Landscape Automotive Cockpit Dashboard and Bluetooth Bridge for Bajaj motorcycles.

## Overview
* **Package**: `com.bajaj.rideconnect.re`
* **Orientation**: Sensor Landscape (`sensorLandscape`)
* **Compatibility**: ~80% Bajaj Bluetooth-equipped motorcycles (Pulsar NS400Z, N250, F250, NS200, N160, NS160, N150, Dominar 400/250)
* **Zero Dependencies**: Pure native Android SDK APIs (AAPT2 + JAVAC + D8). No Gradle or third-party libraries.

## Architecture & Features
* **Cockpit Layout**: 25% Left Panel (Media / Calls / SMS / Bike) + 75% Right Map Workspace.
* **Fullscreen Mode**: Expand map to 100% with floating bottom-left Music Pill (`[Art] Track • Artist ▶/❚❚ ⏭`).
* **Slide-out Drawer**: Right edge automotive drawer with bike telemetry, stats, and master session disconnect.
* **MediaSession Pipeline**: Two-way binding with phone's active music playback (Spotify / YouTube Music) via `MediaStateListener`.
* **Navigation Pipeline**: Intercepts Google Maps navigation via `GoogleMapsNotificationListener` and streams 48-byte frames to cluster GATT (`0110`).
* **Telemetry Pipeline**: Streams phone battery & cellular signal to cluster GATT (`0210`).

## Build & Install
Run from repository root:
```bash
./build.sh            # Compile and sign APK (dist/my-pulsar.apk)
./build.sh --install  # Compile and install to connected phone via ADB
```
