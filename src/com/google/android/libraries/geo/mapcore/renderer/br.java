package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum br {
    NONE(false, false),
    CLAMP(true, false),
    FULL(true, true);

    final boolean d;
    final boolean e;

    br(boolean z, boolean z2) {
        this.d = z;
        this.e = z2;
    }
}
