package com.google.android.libraries.navigation.internal.oe;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements Serializable {
    public final r a;
    public final r b;

    public t() {
        this.b = new r();
        this.a = new r();
    }

    public t(r rVar, r rVar2) {
        double d = rVar2.a;
        double d2 = rVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.i(d >= d2, "Southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d2), Double.valueOf(d));
        this.a = rVar;
        this.b = rVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a.equals(tVar.a) && this.b.equals(tVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("southwest", this.a);
        akVarB.g("northeast", this.b);
        return akVarB.toString();
    }
}
