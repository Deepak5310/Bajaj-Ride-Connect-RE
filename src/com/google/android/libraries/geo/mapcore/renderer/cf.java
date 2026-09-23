package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum cf implements af {
    BUILDING;

    public static final int b = cn.j + cn.values().length;

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int a() {
        return b + ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int b() {
        return ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final dy c() {
        return dy.BUILDING_PASS;
    }
}
