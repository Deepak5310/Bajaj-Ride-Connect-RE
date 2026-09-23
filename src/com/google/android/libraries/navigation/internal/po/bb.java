package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb extends ag implements com.google.android.libraries.navigation.internal.ol.u {
    private final dg c;
    private boolean d;
    private boolean e;
    private com.google.android.libraries.navigation.internal.ol.bd h;

    public bb(com.google.android.libraries.navigation.internal.or.c cVar, com.google.android.libraries.geo.mapcore.internal.model.c cVar2, dd ddVar, af afVar, dg dgVar, com.google.android.libraries.navigation.internal.adg.ef efVar, int i, com.google.android.libraries.navigation.internal.ol.ai aiVar) {
        super(ddVar, afVar, com.google.android.libraries.navigation.internal.px.ep.as(efVar, null, i, cVar, com.google.android.libraries.navigation.internal.px.cg.e(cVar2)), aiVar);
        this.h = com.google.android.libraries.navigation.internal.ol.bd.a;
        this.c = dgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.u
    public final void a() {
        synchronized (this) {
            this.c.a.remove(this);
            if (this.e && this.d) {
                this.c.b(this, this.h);
            }
            this.e = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.u
    public final void b(com.google.android.libraries.navigation.internal.ol.t tVar) {
        synchronized (this) {
            if (!this.e && this.d) {
                this.c.c(this);
            }
            this.c.a.put(this, tVar);
            this.f.g();
            this.e = true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.u
    public final void c(com.google.android.libraries.navigation.internal.ol.bd bdVar) {
        boolean z;
        com.google.android.libraries.navigation.internal.ol.bd bdVar2;
        synchronized (this) {
            z = this.e;
            com.google.android.libraries.navigation.internal.ol.bd bdVar3 = this.h;
            com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) bdVar3.aH(5, null);
            bbVar.x(bdVar3);
            com.google.android.libraries.navigation.internal.ol.ay ayVar = (com.google.android.libraries.navigation.internal.ol.ay) bbVar;
            ayVar.x(bdVar);
            bdVar2 = (com.google.android.libraries.navigation.internal.ol.bd) ayVar.t();
            this.h = bdVar2;
            this.d = true;
        }
        if (!z) {
            this.c.b(this, bdVar2);
        }
        this.f.g();
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.ol.v
    public final /* bridge */ /* synthetic */ void i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pf.a
    public final com.google.android.libraries.navigation.internal.oe.x j() {
        com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((com.google.android.libraries.navigation.internal.px.m) ((com.google.android.libraries.navigation.internal.px.b) this.g).f).a;
        com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
        return cVar.a;
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final /* bridge */ /* synthetic */ void w() {
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final void x() {
        synchronized (this) {
            if (!this.e && this.d) {
                this.c.c(this);
            }
            this.d = false;
        }
        super.x();
    }

    @Override // com.google.android.libraries.navigation.internal.po.ag, com.google.android.libraries.navigation.internal.pp.d
    public final void y() {
        a();
        super.y();
    }

    public bb(com.google.android.libraries.navigation.internal.or.c cVar, com.google.android.libraries.geo.mapcore.internal.model.c cVar2, dd ddVar, af afVar, dg dgVar, com.google.android.libraries.navigation.internal.adg.ef efVar, int i, com.google.android.libraries.navigation.internal.ol.ai aiVar, byte[] bArr) {
        super(ddVar, afVar, com.google.android.libraries.navigation.internal.px.ep.as(efVar, null, i, cVar, com.google.android.libraries.navigation.internal.px.cg.e(cVar2)), aiVar, false);
        this.h = com.google.android.libraries.navigation.internal.ol.bd.a;
        this.c = dgVar;
    }
}
