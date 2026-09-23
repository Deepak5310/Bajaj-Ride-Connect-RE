package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bw implements com.google.android.libraries.navigation.internal.ol.z {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.bw");
    public com.google.android.libraries.navigation.internal.on.h a = null;
    public volatile boolean b = false;
    public final List c = new ArrayList();
    private final com.google.android.libraries.geo.mapcore.renderer.ax e;
    private final com.google.android.libraries.navigation.internal.oa.f f;
    private final com.google.android.libraries.navigation.internal.ol.a g;
    private final com.google.android.libraries.navigation.internal.ol.ak h;
    private final com.google.android.libraries.navigation.internal.ol.ai i;
    private final com.google.android.libraries.navigation.internal.ol.ax j;
    private final com.google.android.libraries.navigation.internal.ol.aj k;
    private final bv l;
    private final dr m;

    public bw(com.google.android.libraries.navigation.internal.oa.f fVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, bv bvVar, com.google.android.libraries.navigation.internal.ol.a aVar, com.google.android.libraries.navigation.internal.ol.ak akVar, com.google.android.libraries.navigation.internal.ol.ai aiVar, com.google.android.libraries.navigation.internal.ol.ax axVar2, com.google.android.libraries.navigation.internal.ol.aj ajVar, dr drVar) {
        this.e = axVar;
        this.l = bvVar;
        this.g = aVar;
        this.h = akVar;
        this.i = aiVar;
        this.j = axVar2;
        this.k = ajVar;
        this.m = drVar;
        this.f = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final com.google.android.libraries.navigation.internal.ol.a a() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final com.google.android.libraries.navigation.internal.ol.ai b() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final com.google.android.libraries.navigation.internal.ol.aj c() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final com.google.android.libraries.navigation.internal.ol.ak d() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final com.google.android.libraries.navigation.internal.ol.ax e() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void f(com.google.android.libraries.geo.mapcore.renderer.cb cbVar) {
        this.e.e(cbVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void g(Runnable runnable) {
        boolean z;
        synchronized (this) {
            z = this.b;
            if (!z) {
                this.c.add(runnable);
            }
        }
        if (z) {
            runnable.run();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void h(int i) {
        com.google.android.libraries.navigation.internal.ox.c cVar = ((fk) this.f.b()).j.i;
        if (cVar != null) {
            cVar.g(i);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void i(com.google.android.libraries.navigation.internal.ol.x xVar) {
        this.l.a(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void j(com.google.android.libraries.navigation.internal.ol.y yVar) {
        this.l.b(yVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void k(int[] iArr) {
        this.l.c(iArr);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final boolean l() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final bf n() {
        return new bf(((fk) this.f.b()).C);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final bf o() {
        return new bf(((fk) this.f.b()).C, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final dr p() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.z
    public final void m(int i, com.google.android.libraries.navigation.internal.oe.x xVar) {
        com.google.android.libraries.geo.mapcore.renderer.dp dpVar = this.e.q;
        if (dpVar == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 875)).p("GoogleMap.pick called with a null picker");
            return;
        }
        if (i == 1) {
            bs bsVar = (bs) dpVar;
            bs.a aVar = bsVar.k;
            aVar.b(bsVar);
            aVar.a(new br(1, xVar));
            return;
        }
        bs bsVar2 = (bs) dpVar;
        bs.a aVar2 = bsVar2.k;
        aVar2.b(bsVar2);
        aVar2.a(new br(2, xVar));
    }
}
