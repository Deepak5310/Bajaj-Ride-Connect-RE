package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class as extends com.google.android.libraries.navigation.internal.afx.by {
    public final com.google.android.libraries.navigation.internal.afx.by a;

    public as(com.google.android.libraries.navigation.internal.afx.by byVar) {
        this.a = byVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final String a() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public final void b() {
        this.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.by
    public void c() {
        throw null;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("delegate", this.a);
        return akVarB.toString();
    }
}
