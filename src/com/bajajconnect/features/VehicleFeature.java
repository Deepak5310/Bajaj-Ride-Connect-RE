package com.bajajconnect.features;

/* JADX INFO: loaded from: classes3.dex */
public enum VehicleFeature {
    BLE_GENERAL_PACKET_V2,
    BLE_PROTOCOL_V2,
    BLE_FAV_RECENT_CALLS,
    APP_NAVIGATION,
    BLE_TBT,
    WIFI_CLUSTER_CONNECT,
    WIFI_DOCUMENTS_SYNC,
    UI_DRAWER_DOCUMENTS,
    UI_NAV_POI,
    UI_NAV_SAVED_LOCATIONS,
    UI_DASHBOARD_WIFI,
    MAP_GOOGLE_NAV,
    WIFI_MIRROR_NAV_BOUND;

    public boolean isEnabledFor(String str) {
        return SkuFeatureRegistry.isEnabled(this, str);
    }
}
