package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el {
    final com.google.android.libraries.navigation.internal.afx.ba a;
    final Object b;

    public el(com.google.android.libraries.navigation.internal.afx.ba baVar, Object obj) {
        this.a = baVar;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            el elVar = (el) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.a, elVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, elVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("provider", this.a);
        akVarB.g("config", this.b);
        return akVarB.toString();
    }
}
