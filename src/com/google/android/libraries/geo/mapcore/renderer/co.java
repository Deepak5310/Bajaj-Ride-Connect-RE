package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum co implements af {
    TILE_STENCIL;

    public static final int b = cq.values().length;

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
        return dy.STENCIL_PASS;
    }
}
