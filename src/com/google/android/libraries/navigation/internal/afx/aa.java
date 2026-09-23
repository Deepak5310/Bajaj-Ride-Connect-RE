package com.google.android.libraries.navigation.internal.afx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aa extends bf {
    protected aa() {
    }

    public abstract bf a();

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("delegate", a());
        return akVarB.toString();
    }
}
