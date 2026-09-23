package com.bajajconnect.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.variables.GlobalVar;

/* JADX INFO: loaded from: classes3.dex */
public final class MirroringPolicy {
    public static Boolean FORCE_NAV_BOUND_MIRRORING = null;
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final long MIRROR_BIND_RETRY_MS = 100;

    private MirroringPolicy() {
    }

    public static boolean deferMirroringUntilNavigation() {
        Boolean bool = FORCE_NAV_BOUND_MIRRORING;
        if (bool != null) {
            return bool.booleanValue();
        }
        return VehicleFeature.WIFI_MIRROR_NAV_BOUND.isEnabledFor(BleFeatures.getInstance().modelCode);
    }

    public static void releaseCaptureBuffersBeforeNavLaunch(Context context) {
        Log.i("MirroringPolicy", "releaseCaptureBuffersBeforeNavLaunch");
        try {
            if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.udpServerService != null) {
                NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            }
        } catch (Exception e) {
            Log.w("MirroringPolicy", "stopScreenCapture before nav failed", e);
        }
        try {
            if (NavApplication.customProjection != null) {
                NavApplication.customProjection.releaseCaptureBuffers();
            }
        } catch (Exception e2) {
            Log.w("MirroringPolicy", "releaseCaptureBuffers before nav failed", e2);
        }
    }

    public static boolean ensureCellularNetworkForRouting(Context context) {
        if (context == null) {
            return false;
        }
        if (MirroringGlobarVar.isWifiConnected) {
            return NetworkRequestImpl.bindCellularForRouting(context, isMirroringOrNavNetworkCritical());
        }
        return true;
    }

    public static void restoreClusterNetworkAfterRouting(Context context) {
        if (context != null && MirroringGlobarVar.isWifiConnected && isMirroringOrNavNetworkCritical()) {
            Log.d("MirroringPolicy", "restoreClusterNetworkAfterRouting — process bind → cluster WiFi");
            NetworkRequestImpl.bindForActiveMirroring(context);
        }
    }

    private static boolean isMirroringOrNavNetworkCritical() {
        return MirroringGlobarVar.isOnMirroringPage || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN || MirroringGlobarVar.currentScreen == Screens.ROUTE_SCREEN || GlobalVar.isNavigationActive;
    }

    public static void bindClusterNetworkForMirroring(Context context) {
        if (deferMirroringUntilNavigation() && MirroringGlobarVar.isWifiConnected) {
            NetworkRequestImpl.bindForActiveMirroring(context);
        }
    }

    public static boolean shouldResumeMirrorAfterSoftAp() {
        return MirroringGlobarVar.pendingSoftApMirrorResume || GlobalVar.isNavigationActive || MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION || MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN || MirroringGlobarVar.currentScreen == Screens.ROUTE_SCREEN;
    }

    public static void markSoftApDropForMirrorResume() {
        if (shouldResumeMirrorAfterSoftAp()) {
            MirroringGlobarVar.pendingSoftApMirrorResume = true;
            Log.i("MirroringPolicy", "SoftAP drop while mirroring/nav — will resume UDP on reconnect navActive=" + GlobalVar.isNavigationActive + " navScreen=" + MirroringGlobarVar.currentNavigationScreen + " tft=" + MirroringGlobarVar.currentScreen);
        }
    }

    public static void resumeAfterSoftApReconnect(final Context context) {
        if (context == null || !MirroringGlobarVar.isWifiConnected) {
            return;
        }
        MirroringGlobarVar.pendingSoftApMirrorResume = false;
        boolean z = GlobalVar.isNavigationActive || MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
        boolean z2 = MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO;
        MirroringGlobarVar.isOnMirroringPage = true;
        if (!z && z2) {
            MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO;
        } else {
            MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
        }
        Log.i("MirroringPolicy", "resumeAfterSoftApReconnect — TCP+UDP + re-announce screen navScreen=" + MirroringGlobarVar.currentNavigationScreen + " hasProjection=" + hasLiveNavProjection());
        ensureCellularNetworkForRouting(context);
        bindClusterNetworkForMirroring(context);
        if (NavApplication.streamingHandler != null) {
            NavApplication.streamingHandler.initTcpServer();
            NavApplication.streamingHandler.initUdpServer();
        }
        if (!hasLiveNavProjection()) {
            try {
                LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED));
            } catch (Exception e) {
                Log.w("MirroringPolicy", "SOFTAP_RECONNECTED broadcast failed", e);
            }
        }
        MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                MirroringPolicy.finishSoftApMirrorResume(context, 0);
            }
        }, MIRROR_BIND_RETRY_MS);
    }

    private static boolean hasLiveNavProjection() {
        if (NavApplication.customProjection == null || NavApplication.customProjection.mImageReader == null) {
            return false;
        }
        return (NavApplication.customProjection.routeInfoPresentation == null && NavApplication.customProjection.routeInfoPresentationMMI == null && NavApplication.customProjection.myNavigationPresentation == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishSoftApMirrorResume(final Context context, final int i) {
        if (!MirroringGlobarVar.isWifiConnected || NavApplication.streamingHandler == null) {
            return;
        }
        if (i > 50) {
            Log.e("MirroringPolicy", "finishSoftApMirrorResume timed out waiting for sockets");
            if (hasLiveNavProjection()) {
                return;
            }
            try {
                LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!NavApplication.streamingHandler.isTcpBoundOrBinding()) {
            NavApplication.streamingHandler.initTcpServer();
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.finishSoftApMirrorResume(context, i + 1);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.onTcpReady()) {
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.finishSoftApMirrorResume(context, i + 1);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.isUdpBoundOrBinding()) {
            NavApplication.streamingHandler.initUdpServer();
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.finishSoftApMirrorResume(context, i + 1);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.onUdpReady()) {
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.finishSoftApMirrorResume(context, i + 1);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        MirroringGlobarVar.currentScreen = MirroringGlobarVar.currentNavigationScreen == MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO ? Screens.ROUTE_SCREEN : Screens.TBT_SCREEN;
        try {
            if (NavApplication.streamingHandler.udpServerService != null) {
                NavApplication.streamingHandler.udpServerService.onScreenChange();
            }
        } catch (Exception e) {
            Log.w("MirroringPolicy", "SoftAP resume onScreenChange failed", e);
        }
        Log.i("MirroringPolicy", "SoftAP resume — sockets ready, screen announced screen=" + MirroringGlobarVar.currentScreen + " hasProjection=" + hasLiveNavProjection());
        if (hasLiveNavProjection()) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED));
        } catch (Exception e2) {
            Log.w("MirroringPolicy", "SOFTAP_RECONNECTED rebroadcast failed", e2);
        }
    }

    public static void startTcpSyncOnWifiConnect(Context context) {
        if (deferMirroringUntilNavigation() && MirroringGlobarVar.isWifiConnected) {
            ensureCellularNetworkForRouting(context);
            Log.d("MirroringPolicy", "startTcpSyncOnWifiConnect — cellular routing + TCP");
            if (NavApplication.streamingHandler != null) {
                NavApplication.streamingHandler.initTcpServer();
            }
        }
    }

    public static void startRoutePreviewMirroring(Activity activity) {
        if (deferMirroringUntilNavigation() && MirroringGlobarVar.isWifiConnected) {
            MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.ROUTE_INFO;
            MirroringGlobarVar.isOnMirroringPage = true;
            MirroringGlobarVar.isSearchProcessing = false;
            bindClusterNetworkForMirroring(activity);
            beginProjectionMirroring(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void beginProjectionMirroring(final Activity activity) {
        if (!NavApplication.streamingHandler.isTcpBoundOrBinding()) {
            NavApplication.streamingHandler.initTcpServer();
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.beginProjectionMirroring(activity);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.onTcpReady()) {
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.beginProjectionMirroring(activity);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.isUdpBoundOrBinding()) {
            NavApplication.streamingHandler.initUdpServer();
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.beginProjectionMirroring(activity);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        if (!NavApplication.streamingHandler.onUdpReady()) {
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.beginProjectionMirroring(activity);
                }
            }, MIRROR_BIND_RETRY_MS);
            return;
        }
        try {
            NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            NavApplication.customProjection.startActivityRoute(activity);
            MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
            NavApplication.streamingHandler.udpServerService.onScreenChange();
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.lambda$beginProjectionMirroring$9();
                }
            }, 150L);
        } catch (Exception e) {
            Log.e("MirroringPolicy", "beginProjectionMirroring failed, retrying", e);
            MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.beginProjectionMirroring(activity);
                }
            }, MIRROR_BIND_RETRY_MS);
        }
    }

    static /* synthetic */ void lambda$beginProjectionMirroring$9() {
        if (NavApplication.customProjection == null || NavApplication.customProjection.routeInfoPresentation == null) {
            return;
        }
        NavApplication.customProjection.routeInfoPresentation.refreshRoutePreview();
    }

    public static void stopMirroringWhenReturningToReactNative(Context context) {
        if (deferMirroringUntilNavigation() && MirroringGlobarVar.isOnMirroringPage) {
            stopMirroringAfterNavigation(context, "returnToReactNative");
        }
    }

    public static void stopMirroringAfterNavigation(final Context context, String str) {
        MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NONE;
        MirroringGlobarVar.isSearchProcessing = false;
        MirroringGlobarVar.isOnMirroringPage = false;
        if (deferMirroringUntilNavigation()) {
            Log.d("MirroringPolicy", "stop nav-bound mirroring: " + str);
            MirroringGlobarVar.currentScreen = Screens.NONE;
            NetworkRequestImpl.restoreDefaultNetwork(context.getApplicationContext());
            Runnable runnable = new Runnable() { // from class: com.bajajconnect.wifi.MirroringPolicy$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MirroringPolicy.lambda$stopMirroringAfterNavigation$11(context);
                }
            };
            if (NavApplication.customProjection != null) {
                NavApplication.customProjection.releaseProjectionForNavBound(runnable);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        Log.d("MirroringPolicy", "stop legacy mirroring -> search screen: " + str);
        MirroringGlobarVar.currentScreen = Screens.SEARCH_SCREEN;
        if (NavApplication.customProjection != null) {
            NavApplication.customProjection.stopPresentation();
        }
        if (MirroringGlobarVar.isWifiConnected) {
            NetworkRequestImpl.bindCellularForRouting(context.getApplicationContext());
        }
        if (!MirroringGlobarVar.isWifiConnected || NavApplication.streamingHandler == null || !NavApplication.streamingHandler.onSocketsInitialise() || NavApplication.streamingHandler.udpServerService == null) {
            return;
        }
        NavApplication.streamingHandler.udpServerService.startScreenCaptures();
        NavApplication.streamingHandler.udpServerService.onScreenChange();
    }

    static /* synthetic */ void lambda$stopMirroringAfterNavigation$11(Context context) {
        if (NavApplication.streamingHandler != null) {
            NavApplication.streamingHandler.stopScreenMirroring();
        }
        if (MirroringGlobarVar.isWifiConnected) {
            NetworkRequestImpl.bindCellularForRouting(context.getApplicationContext());
            startTcpSyncOnWifiConnect(context);
        }
    }
}
