package com.google.android.libraries.navigation.internal.cv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum a {
    TRAFFIC(true, true),
    BICYCLING(true, true),
    TRANSIT(true, true),
    SATELLITE(true, false),
    TERRAIN(true, false),
    REALTIME(true, true),
    STREETVIEW(false, true),
    THREE_DIMENSIONAL(false, true),
    COVID19(false, true),
    AIR_QUALITY(false, true),
    WILDFIRES(false, true),
    UNKNOWN(false, false);

    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f382n;

    a(boolean z, boolean z2) {
        this.m = z;
        this.f382n = z2;
    }
}
