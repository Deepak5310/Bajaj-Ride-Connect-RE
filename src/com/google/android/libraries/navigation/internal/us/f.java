package com.google.android.libraries.navigation.internal.us;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.ut.b {
    private final com.google.android.libraries.navigation.internal.nc.t a;
    private final String b;
    private boolean c;
    private com.google.android.libraries.navigation.internal.jy.aa d;

    public f(com.google.android.libraries.navigation.internal.fz.d dVar, int i, String str, com.google.android.libraries.navigation.internal.nc.ah ahVar, boolean z, boolean z2) {
        this(dVar, com.google.android.libraries.navigation.internal.nc.j.m(i), str, (com.google.android.libraries.navigation.internal.nc.ah) null, true, z2);
    }

    public f(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.nc.t tVar, String str, com.google.android.libraries.navigation.internal.nc.ah ahVar, boolean z, boolean z2) {
        this.a = tVar;
        this.b = str;
        this.c = true;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.jy.aa a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.nc.t b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.nc.x c() {
        return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.r(), com.google.android.libraries.navigation.internal.w.a.b());
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.nc.x d() {
        return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.k(), com.google.android.libraries.navigation.internal.w.a.h());
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.nc.x e() {
        return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.n(), com.google.android.libraries.navigation.internal.w.a.h());
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public com.google.android.libraries.navigation.internal.nc.ah f() {
        return com.google.android.libraries.navigation.internal.nc.aj.c();
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public Boolean g() {
        return Boolean.valueOf(this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public Boolean h() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public Boolean i() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ut.b
    public String j() {
        return this.b;
    }

    public void k(com.google.android.libraries.navigation.internal.jy.aa aaVar) {
        this.d = aaVar;
    }
}
