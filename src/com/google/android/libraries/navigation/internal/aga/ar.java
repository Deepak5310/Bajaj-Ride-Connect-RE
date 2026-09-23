package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ar extends com.google.android.libraries.navigation.internal.afx.bd {
    private final com.google.android.libraries.navigation.internal.afx.bd a;

    public ar(com.google.android.libraries.navigation.internal.afx.bd bdVar) {
        this.a = bdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.e
    public final String a() {
        return this.a.a();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("delegate", this.a);
        return akVarB.toString();
    }
}
