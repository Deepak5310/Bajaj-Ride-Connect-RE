package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.gg;
import com.google.android.libraries.navigation.internal.adg.jl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class az {
    public long a = -1;
    public int b = -1;
    public int c = 0;

    public final az a(com.google.android.libraries.navigation.internal.adg.aq aqVar) {
        int i = aqVar.b;
        int i2 = i & 256;
        int i3 = i & 128;
        long j = aqVar.j;
        int i4 = aqVar.i;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(et.b);
        aqVar.h(bhVarS);
        Object objK = aqVar.w.k(bhVarS.d);
        Object objC = objK == null ? bhVarS.b : bhVarS.c(objK);
        f(i2 != 0, j, i3 != 0, i4, (es) objC);
        return this;
    }

    public final az b(fg fgVar) {
        int i = fgVar.b;
        int i2 = i & 512;
        int i3 = i & 256;
        long j = fgVar.f197n;
        int i4 = fgVar.m;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(et.f);
        fgVar.h(bhVarS);
        Object objK = fgVar.w.k(bhVarS.d);
        Object objC = objK == null ? bhVarS.b : bhVarS.c(objK);
        f(i2 != 0, j, i3 != 0, i4, (es) objC);
        return this;
    }

    public final az c(gg ggVar) {
        int i = ggVar.b;
        int i2 = i & 16;
        int i3 = i & 8;
        long j = ggVar.g;
        int i4 = ggVar.f;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(et.a);
        ggVar.h(bhVarS);
        Object objK = ggVar.w.k(bhVarS.d);
        Object objC = objK == null ? bhVarS.b : bhVarS.c(objK);
        f(i2 != 0, j, i3 != 0, i4, (es) objC);
        return this;
    }

    public final az d(jl jlVar) {
        int i = jlVar.b;
        int i2 = i & 32;
        int i3 = i & 16;
        long j = jlVar.h;
        int i4 = jlVar.g;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(et.l);
        jlVar.h(bhVarS);
        Object objK = jlVar.w.k(bhVarS.d);
        Object objC = objK == null ? bhVarS.b : bhVarS.c(objK);
        f(i2 != 0, j, i3 != 0, i4, (es) objC);
        return this;
    }

    public final ba e() {
        return new ba(this.a, this.b, this.c);
    }

    public final void f(boolean z, long j, boolean z2, int i, es esVar) {
        if (true != z) {
            j = -1;
        }
        this.a = j;
        if (true != z2) {
            i = -1;
        }
        this.b = i;
        this.c = (esVar.b & 1) != 0 ? esVar.c : 0;
    }
}
