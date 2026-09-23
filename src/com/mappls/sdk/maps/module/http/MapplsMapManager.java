package com.mappls.sdk.maps.module.http;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsMapManager {
    private static final MapplsMapManager OUR_INSTANCE = new MapplsMapManager();
    private long keyExpirationTime;
    private String rawPublicKey;

    private MapplsMapManager() {
    }

    public static MapplsMapManager getInstance() {
        return OUR_INSTANCE;
    }

    public String getRawPublicKey() {
        return this.rawPublicKey;
    }

    public void setRawPublicKey(String str) {
        this.rawPublicKey = str;
    }

    long getKeyExpirationTime() {
        return this.keyExpirationTime;
    }

    public void setKeyExpirationTime(long j) {
        this.keyExpirationTime = j;
    }
}
