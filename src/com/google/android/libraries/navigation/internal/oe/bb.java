package com.google.android.libraries.navigation.internal.oe;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb {
    public final r a;
    public final r b;
    public final r c;
    public final r d;
    public final t e;

    public bb(r rVar, r rVar2, r rVar3, r rVar4, t tVar) {
        this.a = rVar;
        this.b = rVar2;
        this.c = rVar3;
        this.d = rVar4;
        this.e = tVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        return this.a.equals(bbVar.a) && this.b.equals(bbVar.b) && this.c.equals(bbVar.c) && this.d.equals(bbVar.d) && this.e.equals(bbVar.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("nearLeft", this.a);
        akVarB.g("nearRight", this.b);
        akVarB.g("farLeft", this.c);
        akVarB.g("farRight", this.d);
        akVarB.g("latLngBounds", this.e);
        return akVarB.toString();
    }
}
