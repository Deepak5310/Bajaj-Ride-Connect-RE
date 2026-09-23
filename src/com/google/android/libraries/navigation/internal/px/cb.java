package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cb implements com.google.android.libraries.navigation.internal.ol.au, com.google.android.libraries.navigation.internal.pp.f {
    private final ek a;
    private volatile dj b;
    private volatile com.google.android.libraries.navigation.internal.jy.p c;

    public cb(ek ekVar) {
        this.a = ekVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final ek D() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final com.google.android.libraries.navigation.internal.yx.an E() {
        return com.google.android.libraries.navigation.internal.yx.an.i(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final void G(com.google.android.libraries.navigation.internal.jy.p pVar) {
        this.c = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pp.f
    public final void H(dj djVar) {
        this.b = djVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aa
    public final com.google.android.libraries.navigation.internal.yx.an g() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.au
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.ael.cy n() {
        return ((b) this.a).a;
    }
}
