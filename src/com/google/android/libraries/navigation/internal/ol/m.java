package com.google.android.libraries.navigation.internal.ol;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public final com.google.android.libraries.navigation.internal.oe.x a;
    public com.google.android.libraries.navigation.internal.adg.b b;

    public m() {
        this.a = new com.google.android.libraries.navigation.internal.oe.x();
        this.b = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT;
    }

    public m(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        this.a = xVar2;
        this.b = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT;
        xVar2.W(xVar);
        this.b = bVar;
    }

    public final void a(m mVar) {
        this.a.W(mVar.a);
        this.b = mVar.b;
    }

    public final void b(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a.W(xVar);
    }
}
