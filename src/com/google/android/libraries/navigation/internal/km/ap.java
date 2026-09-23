package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap {
    public final x a;
    public final y b;
    public final y c;
    public final y d;
    public final y e;
    public final y f;
    public final y g;
    public final x h;

    public ap() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public ap(String str) {
        this.a = new x("RequestPerformanceNumTries".concat(str), w.REQUEST_PERFORMANCE);
        this.b = new y("RequestPerformanceNetworkLatency".concat(str), w.REQUEST_PERFORMANCE);
        this.c = new y("RequestPerformanceEndToEndLatency".concat(str), w.REQUEST_PERFORMANCE);
        this.d = new y("RequestPerformanceEndToEndSuccessLatency".concat(str), w.REQUEST_PERFORMANCE);
        this.e = new y("RequestPerformanceSentBytes".concat(str), w.REQUEST_PERFORMANCE);
        this.f = new y("RequestPerformanceReceivedBytes".concat(str), w.REQUEST_PERFORMANCE);
        new y("RequestPerformanceMetadataSentBytes".concat(str), w.REQUEST_PERFORMANCE);
        this.g = new y("RequestPerformanceServerTime".concat(str), w.REQUEST_PERFORMANCE);
        this.h = new x("RequestPerformanceStatus".concat(str), w.REQUEST_PERFORMANCE);
    }
}
