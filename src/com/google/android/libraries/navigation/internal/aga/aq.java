package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class aq implements u {
    @Override // com.google.android.libraries.navigation.internal.aga.de
    public final Runnable a(dd ddVar) {
        return d().a(ddVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.al
    public final com.google.android.libraries.navigation.internal.afx.aj b() {
        return d().b();
    }

    @Override // com.google.android.libraries.navigation.internal.aga.de
    public void c(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        d().c(clVar);
    }

    protected abstract u d();

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("delegate", d());
        return akVarB.toString();
    }
}
