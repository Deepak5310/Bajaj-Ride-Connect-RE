package com.google.android.libraries.navigation.internal.qq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap extends h implements q {
    private final boolean a;
    private ao b;
    private boolean c;
    private final com.google.android.libraries.navigation.internal.oe.x e;

    public ap(com.google.android.libraries.geo.mapcore.renderer.af afVar, boolean z) {
        super(afVar, 0);
        this.e = new com.google.android.libraries.navigation.internal.oe.x();
        this.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.q
    public final synchronized boolean a(x xVar, float f) {
        ao aoVar = this.b;
        if (aoVar == null) {
            return false;
        }
        return aoVar.w(xVar, this.a, this.e) != 1;
    }

    public final synchronized com.google.android.libraries.navigation.internal.oe.x f() {
        return new com.google.android.libraries.navigation.internal.oe.x(this.e);
    }

    public final synchronized void k() {
        this.b = null;
    }

    public final synchronized void l(ao aoVar) {
        this.b = aoVar;
        this.c = aoVar.q();
    }

    public final synchronized boolean m() {
        return this.c;
    }
}
