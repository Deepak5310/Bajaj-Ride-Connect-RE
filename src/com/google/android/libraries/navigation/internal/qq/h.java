package com.google.android.libraries.navigation.internal.qq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class h extends com.google.android.libraries.geo.mapcore.renderer.al {
    private final int a;
    public final com.google.android.libraries.geo.mapcore.renderer.af d;

    public h(com.google.android.libraries.geo.mapcore.renderer.af afVar, int i) {
        this(afVar, com.google.android.libraries.geo.mapcore.renderer.ae.a, i);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final int h() {
        return this.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final com.google.android.libraries.geo.mapcore.renderer.af i() {
        return this.d;
    }

    public h(com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.geo.mapcore.renderer.ae aeVar, int i) {
        super(afVar.c(), aeVar);
        this.a = i;
        this.d = afVar;
    }
}
