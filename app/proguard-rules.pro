# ProGuard / R8 Configuration for My Pulsar (com.bajaj.rideconnect.re)

# Preserve Android framework callbacks invoked via JNI / system binder
-keepclassmembers class * extends android.bluetooth.BluetoothGattCallback {
    public <methods>;
}

-keepclassmembers class * extends android.bluetooth.le.ScanCallback {
    public <methods>;
}

-keep class * extends android.service.notification.NotificationListenerService {
    public <methods>;
}

-keepclassmembers class * extends android.media.session.MediaController$Callback {
    public <methods>;
}

# Preserve Compose Immutable data classes
-keep class com.bajaj.rideconnect.re.ui.cockpit.MediaTrackInfo { *; }
-keep class com.bajaj.rideconnect.re.BleConnectionState { *; }
-keep class com.bajaj.rideconnect.re.PulsarProtocol$HandlebarEvent { *; }

# Feather Icons vector graphics
-dontwarn br.com.devsrsouza.compose.icons.**
-dontwarn compose.icons.**

# Optimization & Obfuscation tweaks
-repackageclasses ''
-allowaccessmodification