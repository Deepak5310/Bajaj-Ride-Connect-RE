package com.google.android.libraries.navigation.internal.um;

import com.google.android.libraries.navigation.internal.dw.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b {
    STRAIGHT(g.v, 0.5f),
    STRAIGHT_TALL(g.w, 0.5f),
    SLIGHT(g.t, 0.25f),
    SLIGHT_TALL(g.u, 0.25f),
    NORMAL(g.p, 0.25f),
    NORMAL_SHORT(g.q, 0.25f),
    SHARP(g.r, 0.25f),
    SHARP_SHORT(g.s, 0.375f),
    UTURN(g.y, 0.25f),
    UTURN_SHORT(g.z, 0.375f),
    STUB(g.x, 0.5f),
    DOTS(g.o, 0.5f);

    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f619n;

    b(int i, float f) {
        this.m = i;
        this.f619n = f;
    }
}
