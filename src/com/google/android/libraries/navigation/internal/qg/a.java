package com.google.android.libraries.navigation.internal.qg;

import android.content.res.Resources;
import com.google.android.libraries.geo.mapcore.internal.model.ac;
import com.google.android.libraries.geo.mapcore.internal.model.af;
import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import com.google.android.libraries.geo.mapcore.internal.model.v;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.adg.jh;
import com.google.android.libraries.navigation.internal.adg.jj;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.ol.w;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final s a;
    private final com.google.android.libraries.navigation.internal.kl.b b;
    private final Resources c;
    private final at d;
    private final br e;
    private final br f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final boolean h = false;
    private final br i;
    private final br j;
    private final br k;
    private final gr l;

    public a(s sVar, com.google.android.libraries.navigation.internal.kl.b bVar, gr grVar, Resources resources, at atVar, br brVar, br brVar2, com.google.android.libraries.navigation.internal.afo.a aVar, boolean z, br brVar3, br brVar4, br brVar5) {
        this.a = sVar;
        this.b = bVar;
        this.l = grVar;
        this.c = resources;
        this.d = atVar;
        this.e = brVar;
        this.f = brVar2;
        this.g = aVar;
        this.i = brVar3;
        this.j = brVar4;
        this.k = brVar5;
    }

    final com.google.android.libraries.navigation.internal.qi.e a(ac acVar, com.google.android.libraries.navigation.internal.qi.f fVar, ax axVar, w wVar, com.google.android.libraries.navigation.internal.qy.h hVar) {
        ce ceVar = new ce(acVar.a, new com.google.android.libraries.geo.mapcore.internal.model.s(), 0, jh.a, jj.d);
        fd fdVar = ma.b;
        String str = acVar.b().l;
        com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac acVar2 = new com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac(ceVar, axVar, this.l, this.c, acVar, null, 0, null, -1L, -1L, fVar, null, null, hVar, this.d, fdVar);
        acVar2.r(acVar, ((com.google.android.libraries.navigation.internal.qi.a) fVar).c, wVar);
        return acVar2;
    }

    final com.google.android.libraries.navigation.internal.qi.e b(cq cqVar, com.google.android.libraries.navigation.internal.qi.f fVar, v vVar, ax axVar, af afVar, com.google.android.libraries.navigation.internal.qy.h hVar) {
        com.google.android.libraries.navigation.internal.qi.a aVar = (com.google.android.libraries.navigation.internal.qi.a) fVar;
        return com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac.F(cqVar, aVar.d, aVar.c, axVar, this.a, this.b, this.l, this.c, vVar, afVar, fVar, hVar, this.d, ((Boolean) this.e.a()).booleanValue(), ((Boolean) this.f.a()).booleanValue(), (com.google.android.libraries.navigation.internal.oz.f) this.g.a(), false, ((Boolean) this.i.a()).booleanValue(), ((Boolean) this.j.a()).booleanValue(), ((Boolean) this.k.a()).booleanValue());
    }
}
