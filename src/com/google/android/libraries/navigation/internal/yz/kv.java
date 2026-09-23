package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class kv implements kt {
    public final boolean equals(Object obj) {
        if (obj instanceof kt) {
            kt ktVar = (kt) obj;
            if (a() == ktVar.a() && com.google.android.libraries.navigation.internal.yx.am.a(b(), ktVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object objB = b();
        return (objB == null ? 0 : objB.hashCode()) ^ a();
    }

    public final String toString() {
        String strValueOf = String.valueOf(b());
        int iA = a();
        if (iA == 1) {
            return strValueOf;
        }
        return strValueOf + " x " + iA;
    }
}
