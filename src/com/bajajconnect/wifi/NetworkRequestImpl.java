package com.bajajconnect.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.bajajconnect.NavApplication;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.perf.util.Constants;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkRequestImpl extends ConnectivityManager.NetworkCallback {
    private static final int NETWORK_REQUEST_TIMEOUT_RECONNECT_MS = 35000;
    private static final int NETWORK_REQUEST_TIMEOUT_USER_MS = 90000;
    private static final int RECONNECT_DELAY_MS_BASE = 3000;
    private static final int RECONNECT_DELAY_MS_MAX = 15000;
    private static ConnectivityManager.NetworkCallback cellularRoutingCallback;
    private static boolean cellularRoutingRequested;
    private final String appName;
    final ConnectivityManager connectivityManager;
    private String lastBssid;
    private String lastPassword;
    private String lastSsid;
    private String pendingSpecifierSsid;
    private final PowerManager powerManager;
    private ReactApplicationContext reactApplicationContext;
    private PowerManager.WakeLock wakeLock;
    private WifiManager.WifiLock wifiLock;
    private final WifiManager wifiManager;
    private int password = 12345689;
    NetworkRequest networkRequest = null;
    private boolean autoReconnectEnabled = false;
    private int reconnectAttempt = 0;
    private boolean reconnectScheduled = false;
    private volatile boolean specifierRequestActive = false;
    private final Runnable reconnectRunnable = new Runnable() { // from class: com.bajajconnect.wifi.NetworkRequestImpl.1
        @Override // java.lang.Runnable
        public void run() {
            NetworkRequestImpl.this.reconnectScheduled = false;
            if (!NetworkRequestImpl.this.autoReconnectEnabled || MirroringGlobarVar.isWifiConnected) {
                return;
            }
            NetworkRequestImpl.this.attemptSoftApReconnect("scheduled");
        }
    };
    private final Runnable runnable = new Runnable() { // from class: com.bajajconnect.wifi.NetworkRequestImpl.2
        @Override // java.lang.Runnable
        public void run() {
            if (NavApplication.streamingHandler.isTcpInitialised && NavApplication.streamingHandler.isUdpInitialised) {
                Util.createNetworkRouteMobile(NetworkRequestImpl.this.reactApplicationContext);
            } else {
                NetworkRequestImpl.this.handler.postDelayed(this, 1000L);
            }
        }
    };
    private boolean isScanning = false;
    BroadcastReceiver wifiReceiver = new BroadcastReceiver() { // from class: com.bajajconnect.wifi.NetworkRequestImpl.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", false);
            if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                return;
            }
            if (booleanExtra) {
                List<ScanResult> scanResults = NetworkRequestImpl.this.wifiManager.getScanResults();
                context.unregisterReceiver(this);
                for (ScanResult scanResult : scanResults) {
                    if (scanResult.SSID.equals(GlobalVar.bleDeviceName)) {
                        NetworkRequestImpl.this.requestWifi(scanResult.SSID, scanResult.BSSID, GlobalVar.wifiPassword);
                        break;
                    }
                }
            } else {
                context.unregisterReceiver(this);
                for (ScanResult scanResult2 : NetworkRequestImpl.this.wifiManager.getScanResults()) {
                    if (scanResult2.SSID.equals(GlobalVar.bleDeviceName)) {
                        NetworkRequestImpl.this.requestWifi(scanResult2.SSID, scanResult2.BSSID, GlobalVar.wifiPassword);
                        break;
                    }
                }
            }
            NetworkRequestImpl.this.isScanning = false;
        }
    };
    private final Handler handler = new Handler(Looper.getMainLooper());

    public NetworkRequestImpl(ReactApplicationContext reactApplicationContext) {
        this.reactApplicationContext = reactApplicationContext;
        this.connectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.powerManager = (PowerManager) reactApplicationContext.getApplicationContext().getSystemService("power");
        this.wifiManager = (WifiManager) reactApplicationContext.getApplicationContext().getSystemService("wifi");
        this.appName = getApplicationName(reactApplicationContext);
    }

    private String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    private void startMirroring() {
        NavApplication.streamingHandler.initWifiServers();
        this.handler.postDelayed(this.runnable, 1000L);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        MirroringGlobarVar.network = network;
        if (!MirroringGlobarVar.isWifiConnected) {
            MirroringGlobarVar.connectedWifiName = GlobalVar.bleDeviceName;
            Log.e("NavigationManager", "wifi connected bb");
            MirroringGlobarVar.isWifiConnected = true;
            this.reconnectAttempt = 0;
            this.handler.removeCallbacks(this.reconnectRunnable);
            this.reconnectScheduled = false;
            this.specifierRequestActive = false;
            this.pendingSpecifierSsid = null;
            Log.i("NetworkRequest", "SoftAP available — auto-reconnect counter reset");
            if (MirroringPolicy.deferMirroringUntilNavigation()) {
                acquireLocks();
                emitInfoWifi(true);
                if (MirroringPolicy.shouldResumeMirrorAfterSoftAp()) {
                    MirroringPolicy.resumeAfterSoftApReconnect(this.reactApplicationContext);
                    return;
                }
                MirroringGlobarVar.isOnMirroringPage = false;
                MirroringGlobarVar.currentScreen = Screens.NONE;
                MirroringPolicy.startTcpSyncOnWifiConnect(this.reactApplicationContext);
                Log.d("NetworkRequest", "WiFi connected; TCP/doc sync started, screen mirroring deferred until navigation");
                return;
            }
            MirroringPolicy.ensureCellularNetworkForRouting(this.reactApplicationContext);
            bindAndStart();
            return;
        }
        this.reconnectAttempt = 0;
        this.handler.removeCallbacks(this.reconnectRunnable);
        this.reconnectScheduled = false;
        this.specifierRequestActive = false;
        this.pendingSpecifierSsid = null;
        boolean z = NavApplication.streamingHandler == null || !NavApplication.streamingHandler.onUdpReady();
        if (!MirroringPolicy.shouldResumeMirrorAfterSoftAp()) {
            if (!MirroringPolicy.deferMirroringUntilNavigation() || !z) {
                return;
            }
            if (!GlobalVar.isNavigationActive && MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NONE) {
                return;
            }
        }
        Log.i("NetworkRequest", "SoftAP onAvailable while still marked connected — resume mirror udpDead=" + z + " pending=" + MirroringGlobarVar.pendingSoftApMirrorResume);
        acquireLocks();
        emitInfoWifi(true);
        MirroringPolicy.resumeAfterSoftApReconnect(this.reactApplicationContext);
    }

    public void bindToNetworkAndMirror() {
        if (MirroringPolicy.deferMirroringUntilNavigation()) {
            bindAndStart();
        } else {
            MirroringPolicy.ensureCellularNetworkForRouting(this.reactApplicationContext);
            bindAndStart();
        }
    }

    public void bindAndStart() {
        acquireLocks();
        emitInfoWifi(true);
        if (MirroringPolicy.deferMirroringUntilNavigation()) {
            if (MirroringPolicy.shouldResumeMirrorAfterSoftAp()) {
                MirroringPolicy.resumeAfterSoftApReconnect(this.reactApplicationContext);
                return;
            }
            MirroringGlobarVar.isOnMirroringPage = false;
            MirroringGlobarVar.currentScreen = Screens.NONE;
            MirroringPolicy.startTcpSyncOnWifiConnect(this.reactApplicationContext);
            Log.d("NetworkRequest", "WiFi connected; TCP/doc sync started, screen mirroring deferred until navigation");
            return;
        }
        startMirroring();
    }

    public static void bindForActiveMirroring(Context context) {
        ConnectivityManager connectivityManager;
        if (MirroringGlobarVar.network == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        Log.d("NetworkRequest", "bindForActiveMirroring: " + connectivityManager.bindProcessToNetwork(MirroringGlobarVar.network));
    }

    public static synchronized boolean bindCellularForRouting(Context context) {
        return bindCellularForRouting(context, false);
    }

    public static synchronized boolean bindCellularForRouting(Context context, final boolean z) {
        try {
            Context applicationContext = context.getApplicationContext();
            final ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (!z) {
                restoreDefaultNetwork(applicationContext);
            }
            for (Network network : connectivityManager.getAllNetworks()) {
                if (bindProcessToCellular(connectivityManager, network)) {
                    Log.d("NetworkRequest", "bound cellular for routing via getAllNetworks preserveClusterSockets=" + z);
                    return true;
                }
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && bindProcessToCellular(connectivityManager, activeNetwork)) {
                Log.d("NetworkRequest", "bound cellular for routing via active network preserveClusterSockets=" + z);
                return true;
            }
            ConnectivityManager.NetworkCallback networkCallback = cellularRoutingCallback;
            if (networkCallback != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                } catch (Exception e) {
                    Log.w("NetworkRequest", "unregister cellular routing callback", e);
                }
                cellularRoutingCallback = null;
                cellularRoutingRequested = false;
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
            ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.bajajconnect.wifi.NetworkRequestImpl.3
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    NetworkRequestImpl.bindProcessToCellular(connectivityManager, network2);
                    Log.d("NetworkRequest", "cellular routing network available preserveClusterSockets=" + z);
                }
            };
            cellularRoutingCallback = networkCallback2;
            try {
                connectivityManager.requestNetwork(networkRequestBuild, networkCallback2);
                cellularRoutingRequested = true;
            } catch (Exception e2) {
                Log.e("NetworkRequest", "bindCellularForRouting failed", e2);
                cellularRoutingCallback = null;
                cellularRoutingRequested = false;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bindProcessToCellular(ConnectivityManager connectivityManager, Network network) {
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities != null && networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
            return connectivityManager.bindProcessToNetwork(network);
        }
        return false;
    }

    public static synchronized void releaseCellularRoutingRequest(Context context) {
        if (cellularRoutingCallback == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(cellularRoutingCallback);
            } catch (Exception e) {
                Log.w("NetworkRequest", "releaseCellularRoutingRequest", e);
            }
        }
        cellularRoutingCallback = null;
        cellularRoutingRequested = false;
    }

    public static void restoreDefaultNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            connectivityManager.bindProcessToNetwork(null);
            Log.d("NetworkRequest", "restoreDefaultNetwork");
        }
    }

    private boolean bindProcessToClusterNetwork(Network network) {
        return this.connectivityManager.bindProcessToNetwork(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        if (MirroringGlobarVar.isWifiConnected) {
            MirroringGlobarVar.connectedWifiName = "";
            Log.e("Navigation", "wifi inavialble");
            emitInfoWifi(false);
        }
        MirroringGlobarVar.isWifiConnected = false;
        this.specifierRequestActive = false;
        this.pendingSpecifierSsid = null;
        restoreDefaultNetwork(this.reactApplicationContext);
        Log.e("NetworkCallback", "on unavialble");
        scheduleAutoReconnect("onUnavailable");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i) {
        super.onLosing(network, i);
        releaseWakeLocks();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        super.onLost(network);
        Log.e("NetworkCallback", "onLost");
        emitInfoWifi(false);
        if (MirroringGlobarVar.isWifiConnected) {
            MirroringGlobarVar.connectedWifiName = "";
            Log.e("Navigation", "wifi disconnected");
            MirroringPolicy.markSoftApDropForMirrorResume();
            stopServices();
        }
        MirroringGlobarVar.network = null;
        MirroringGlobarVar.isWifiConnected = false;
        this.specifierRequestActive = false;
        this.pendingSpecifierSsid = null;
        restoreDefaultNetwork(this.reactApplicationContext);
        releaseWakeLocks();
        scheduleAutoReconnect("onLost");
    }

    public void emitInfoWifi(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("name", "dooley-doo");
        writableMapCreateMap.putInt("version", 16);
        writableMapCreateMap.putBoolean("isConnected", z);
        sendEvent("WIFI_EVENT", writableMapCreateMap);
    }

    public void stopServices() {
        NavApplication.streamingHandler.stopAllConnections();
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void requestWifi(String str, String str2, String str3) {
        requestWifi(str, str2, str3, true);
    }

    private void requestWifi(String str, String str2, String str3, boolean z) {
        boolean z2 = false;
        if (!this.wifiManager.isWifiEnabled()) {
            if (z) {
                Toast.makeText(this.reactApplicationContext, "Please Turn On Wifi", 0).show();
                return;
            } else {
                Log.w("NetworkRequest", "auto-reconnect skipped — phone WiFi off");
                scheduleAutoReconnect("wifi_off");
                return;
            }
        }
        if (str3 == null || str3.length() < 8) {
            StringBuilder sb = new StringBuilder("requestWifi aborted — invalid passphrase len=");
            sb.append(str3 == null ? -1 : str3.length());
            Log.e("NetworkRequest", sb.toString());
            if (z) {
                Toast.makeText(this.reactApplicationContext, "WiFi password invalid", 0).show();
                return;
            }
            return;
        }
        if (this.specifierRequestActive && str != null && str.equals(this.pendingSpecifierSsid) && !MirroringGlobarVar.isWifiConnected) {
            Log.i("NetworkRequest", "requestWifi ignored — specifier already pending userInitiated=" + z);
            if (z) {
                this.lastSsid = str;
                this.lastBssid = str2;
                this.lastPassword = str3;
                this.autoReconnectEnabled = true;
                this.handler.removeCallbacks(this.reconnectRunnable);
                this.reconnectScheduled = false;
                return;
            }
            return;
        }
        if (z) {
            this.lastSsid = str;
            this.lastBssid = str2;
            this.lastPassword = str3;
            this.autoReconnectEnabled = true;
            this.reconnectAttempt = 0;
            this.handler.removeCallbacks(this.reconnectRunnable);
            this.reconnectScheduled = false;
            StringBuilder sb2 = new StringBuilder("SoftAP auto-reconnect armed ssidLen=");
            sb2.append(str != null ? str.length() : 0);
            Log.i("NetworkRequest", sb2.toString());
        }
        try {
            this.connectivityManager.unregisterNetworkCallback(this);
        } catch (Exception unused) {
        }
        this.specifierRequestActive = false;
        WifiNetworkSpecifier wifiNetworkSpecifierBuild = null;
        this.pendingSpecifierSsid = null;
        StringBuilder sb3 = new StringBuilder("requestWifi ssidLen=");
        sb3.append(str != null ? str.length() : 0);
        sb3.append(" bssidSet=");
        if (str2 != null && !str2.isEmpty()) {
            z2 = true;
        }
        sb3.append(z2);
        sb3.append(" passwordLen=");
        sb3.append(str3.length());
        sb3.append(" userInitiated=");
        sb3.append(z);
        sb3.append(" attempt=");
        sb3.append(this.reconnectAttempt);
        Log.i("NetworkRequest", sb3.toString());
        if (!z) {
            str2 = null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            WifiNetworkSpecifier.Builder wpa2Passphrase = Peripheral$$ExternalSyntheticApiModelOutline0.m2297m().setSsid(str).setWpa2Passphrase(str3);
            if (str2 != null && !str2.isEmpty()) {
                wpa2Passphrase.setBssid(MacAddress.fromString(str2));
            }
            wifiNetworkSpecifierBuild = wpa2Passphrase.build();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.networkRequest = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(wifiNetworkSpecifierBuild).build();
        }
        int i = z ? NETWORK_REQUEST_TIMEOUT_USER_MS : NETWORK_REQUEST_TIMEOUT_RECONNECT_MS;
        if (Build.VERSION.SDK_INT >= 26) {
            this.connectivityManager.requestNetwork(this.networkRequest, this, this.handler, i);
        } else {
            this.connectivityManager.requestNetwork(this.networkRequest, this);
        }
        this.specifierRequestActive = true;
        this.pendingSpecifierSsid = str;
        Log.i("NetworkRequest", "specifier request armed timeoutMs=" + i + " ssid=" + str);
    }

    private void scheduleAutoReconnect(String str) {
        String str2;
        if (this.autoReconnectEnabled) {
            if (this.specifierRequestActive) {
                Log.i("NetworkRequest", "auto-reconnect deferred — specifier still active reason=" + str);
                if (this.reconnectScheduled || MirroringGlobarVar.isWifiConnected) {
                    return;
                }
                this.reconnectScheduled = true;
                this.handler.postDelayed(this.reconnectRunnable, 3000L);
                Log.i("NetworkRequest", "auto-reconnect will retry in 3000ms after specifier settles");
                return;
            }
            if (this.lastSsid == null || (str2 = this.lastPassword) == null || str2.length() < 8) {
                Log.w("NetworkRequest", "auto-reconnect skipped — no cached credentials reason=" + str);
                return;
            }
            if (MirroringGlobarVar.isWifiConnected || this.reconnectScheduled) {
                return;
            }
            int iMin = Math.min(RECONNECT_DELAY_MS_MAX, (this.reconnectAttempt * Constants.MAX_URL_LENGTH) + 3000);
            this.reconnectAttempt++;
            this.reconnectScheduled = true;
            Log.i("NetworkRequest", "schedule SoftAP reconnect attempt=" + this.reconnectAttempt + " delayMs=" + iMin + " reason=" + str + " ssid=" + this.lastSsid);
            this.handler.postDelayed(this.reconnectRunnable, (long) iMin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptSoftApReconnect(String str) {
        if (!this.autoReconnectEnabled || MirroringGlobarVar.isWifiConnected) {
            return;
        }
        if (this.specifierRequestActive) {
            Log.i("NetworkRequest", "attempt SoftAP reconnect skipped — specifier active");
            return;
        }
        if (this.lastSsid == null || this.lastPassword == null) {
            return;
        }
        String str2 = GlobalVar.wifiPassword;
        if (str2 == null || str2.length() < 8) {
            str2 = this.lastPassword;
        } else {
            this.lastPassword = str2;
        }
        StringBuilder sb = new StringBuilder("attempt SoftAP reconnect ssidLen=");
        String str3 = this.lastSsid;
        sb.append(str3 != null ? str3.length() : 0);
        sb.append(" reason=");
        sb.append(str);
        sb.append(" attempt=");
        sb.append(this.reconnectAttempt);
        Log.i("NetworkRequest", sb.toString());
        requestWifi(this.lastSsid, null, str2, false);
    }

    public void cancelAutoReconnect(String str) {
        this.autoReconnectEnabled = false;
        this.reconnectScheduled = false;
        this.reconnectAttempt = 0;
        this.handler.removeCallbacks(this.reconnectRunnable);
        MirroringGlobarVar.pendingSoftApMirrorResume = false;
        Log.i("NetworkRequest", "cancel SoftAP auto-reconnect reason=" + str);
    }

    public void releaseNetworkCallback() {
        cancelAutoReconnect("releaseNetworkCallback");
        this.specifierRequestActive = false;
        this.pendingSpecifierSsid = null;
        try {
            this.connectivityManager.unregisterNetworkCallback(this);
        } catch (Exception unused) {
        }
    }

    public void acquireLocks() {
        if (this.wakeLock == null) {
            this.wakeLock = this.powerManager.newWakeLock(1, this.appName + ":myWakeLockTag");
            this.wifiLock = this.wifiManager.createWifiLock(3, this.appName + ":MyWifiLock");
        }
        if (!this.wakeLock.isHeld()) {
            this.wakeLock.acquire();
        }
        if (this.wifiLock.isHeld()) {
            return;
        }
        this.wifiLock.acquire();
    }

    private void releaseWakeLocks() {
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock == null) {
            return;
        }
        if (wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        if (this.wifiLock.isHeld()) {
            this.wifiLock.release();
        }
    }

    public void scanWifi() {
        if (this.isScanning) {
            return;
        }
        this.isScanning = true;
        this.reactApplicationContext.registerReceiver(this.wifiReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        this.wifiManager.startScan();
    }
}
