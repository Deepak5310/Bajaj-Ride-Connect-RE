package com.google.android.libraries.navigation.internal.gp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final com.google.android.libraries.navigation.internal.adf.i a = (com.google.android.libraries.navigation.internal.adf.i) com.google.android.libraries.navigation.internal.adf.j.a.q();

    public final boolean a() {
        return !((com.google.android.libraries.navigation.internal.adf.j) this.a.t()).equals(com.google.android.libraries.navigation.internal.adf.j.a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return ((com.google.android.libraries.navigation.internal.adf.j) this.a.t()).equals(((b) obj).a.t());
        }
        return false;
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.adf.j jVar = (com.google.android.libraries.navigation.internal.adf.j) this.a.t();
        if (jVar.H()) {
            return jVar.n();
        }
        int iN = jVar.ak;
        if (iN == 0) {
            iN = jVar.n();
            jVar.ak = iN;
        }
        return iN;
    }
}
