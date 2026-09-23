package com.google.android.libraries.navigation.internal.afx;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw {
    public final cm a;
    public final c b;
    public final bs c;

    public bw(cm cmVar, c cVar, bs bsVar) {
        this.a = cmVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(cVar, "attributes");
        this.b = cVar;
        this.c = bsVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bw)) {
            return false;
        }
        bw bwVar = (bw) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, bwVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, bwVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, bwVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("addressesOrError", this.a.toString());
        akVarB.g("attributes", this.b);
        akVarB.g("serviceConfigOrError", this.c);
        return akVarB.toString();
    }
}
