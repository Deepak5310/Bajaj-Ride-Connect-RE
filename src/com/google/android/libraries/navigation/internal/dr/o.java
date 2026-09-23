package com.google.android.libraries.navigation.internal.dr;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.po.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public p a;
    public final z b;

    public o(p pVar, z zVar) {
        this.a = pVar;
        this.b = zVar;
    }

    final h a() {
        z zVar = this.b;
        if (zVar.f()) {
            return new h(null);
        }
        com.google.android.libraries.navigation.internal.po.aa aaVarN = ((dh) zVar.a.b).n(ef.a, jr.WORLD_ENCODING_LAT_LNG_E7);
        aaVarN.l();
        return new h(new com.google.android.libraries.navigation.internal.oj.d(aaVarN));
    }

    final h b() {
        p pVar = this.a;
        int i = pVar.l;
        int i2 = pVar.i;
        int i3 = pVar.k;
        int i4 = pVar.m;
        int i5 = pVar.f410n;
        z zVar = this.b;
        if (zVar.f()) {
            return new h((com.google.android.libraries.navigation.internal.op.f) zVar.b(com.google.android.libraries.navigation.internal.oj.c.f(zVar.b.g(), (com.google.android.libraries.navigation.internal.oo.f) zVar.d.a(i3, i2), new com.google.android.libraries.navigation.internal.op.b()), zVar.d, com.google.android.libraries.navigation.internal.du.d.a, i, i2, i3, i4, i5));
        }
        com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g((aq) zVar.c.a(i3, i2));
        return new h(new com.google.android.libraries.navigation.internal.oj.d(((dh) zVar.a.b).n((ef) zVar.b(cVarG, zVar.c, com.google.android.libraries.navigation.internal.du.d.a, i, i2, i3, i4, i5), jr.WORLD_ENCODING_LAT_LNG_E7)));
    }

    final m c(n nVar) {
        int iA = nVar.a(this.a);
        z zVar = this.b;
        x xVarA = zVar.a(iA);
        return new m(zVar.a.a, nVar.g, xVarA.a, zVar.j(xVarA, nVar.h), nVar);
    }

    final void d(h hVar) {
        p pVar = this.a;
        int i = pVar.l;
        int i2 = pVar.i;
        int i3 = pVar.k;
        int i4 = pVar.m;
        int i5 = pVar.f410n;
        z zVar = this.b;
        if (zVar.f()) {
            hVar.c((com.google.android.libraries.navigation.internal.op.f) zVar.b(com.google.android.libraries.navigation.internal.oj.c.f(zVar.b.g(), (com.google.android.libraries.navigation.internal.oo.f) zVar.d.a(i3, i2), new com.google.android.libraries.navigation.internal.op.b()), zVar.d, com.google.android.libraries.navigation.internal.du.d.a, i, i2, i3, i4, i5));
            return;
        }
        com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g((aq) zVar.c.a(i3, i2));
        hVar.c(new com.google.android.libraries.navigation.internal.oj.d(((dh) zVar.a.b).n((ef) zVar.b(cVarG, zVar.c, com.google.android.libraries.navigation.internal.du.d.a, i, i2, i3, i4, i5), jr.WORLD_ENCODING_LAT_LNG_E7)));
    }

    final void e(m mVar) {
        this.b.e(mVar, mVar.f.a(this.a));
    }

    final void f(String str, h hVar) {
        p pVar = this.a;
        int i = pVar.h;
        int i2 = pVar.i;
        int i3 = pVar.j;
        z zVar = this.b;
        if (zVar.f()) {
            hVar.c((com.google.android.libraries.navigation.internal.op.f) z.c(com.google.android.libraries.navigation.internal.oj.c.f(zVar.b.g(), (com.google.android.libraries.navigation.internal.oo.f) zVar.d.a(i3, i2), new com.google.android.libraries.navigation.internal.op.b()), zVar.d, str, i, i2, i3));
            return;
        }
        com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g((aq) zVar.c.a(i3, i2));
        hVar.c(new com.google.android.libraries.navigation.internal.oj.d(((dh) zVar.a.b).n((ef) z.c(cVarG, zVar.c, str, i, i2, i3), jr.WORLD_ENCODING_LAT_LNG_E7)));
    }
}
