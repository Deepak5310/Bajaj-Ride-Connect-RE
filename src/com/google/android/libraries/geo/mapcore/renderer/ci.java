package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum ci implements af {
    CLIENT_INJECTED_AREAS_UNDER_LABELS,
    LABELS;

    public static final int c = cl.b + cl.values().length;

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int a() {
        return c + ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int b() {
        return ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final dy c() {
        return dy.LABEL_PASS;
    }
}
