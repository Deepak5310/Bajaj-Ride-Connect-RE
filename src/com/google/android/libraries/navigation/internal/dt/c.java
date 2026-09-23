package com.google.android.libraries.navigation.internal.dt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum c {
    MAP,
    DIRECTIONS_TWO_WHEELER,
    DIRECTIONS_DRIVE,
    DIRECTIONS_WALK,
    DIRECTIONS_BICYCLE,
    DIRECTIONS_TAXI,
    NAVIGATION(true),
    NAVIGATION_CUSTOM_3D_CHEVRON(true),
    SAFETY_OFF_ROUTE_DRIVE(true),
    NONE,
    INCOGNITO(true),
    LITE_NAV(true);

    public final boolean m;

    c() {
        this(false);
    }

    c(boolean z) {
        this.m = z;
    }
}
