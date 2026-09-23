package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.au;
import com.google.android.libraries.navigation.internal.adi.av;
import com.google.android.libraries.navigation.internal.oe.aq;
import com.google.android.libraries.navigation.internal.oe.as;
import com.google.android.libraries.navigation.internal.qp.ac;
import com.google.android.libraries.navigation.internal.qp.ae;
import com.google.android.libraries.navigation.internal.qp.w;
import com.google.android.libraries.navigation.internal.qu.aa;
import com.google.android.libraries.navigation.internal.qu.bq;
import com.google.android.libraries.navigation.internal.qu.br;
import com.google.android.libraries.navigation.internal.qu.ce;
import com.google.android.libraries.navigation.internal.qu.ch;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends aa implements d, s {
    private final int q;
    private final b r;
    private final c s;
    private final ae t;

    /* JADX INFO: compiled from: PG */
    class a implements com.google.android.libraries.navigation.internal.qv.f {
        private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fl.e$a");

        @Override // com.google.android.libraries.navigation.internal.qv.f
        public final cl a(com.google.android.libraries.navigation.internal.dm.s sVar, an anVar, cd cdVar, byte[] bArr, as asVar) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            unsupportedOperationException.fillInStackTrace();
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(unsupportedOperationException)).F((char) 475)).o();
            return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNEXPECTED_EXCEPTION, com.google.android.libraries.navigation.internal.yx.a.a);
        }

        @Override // com.google.android.libraries.navigation.internal.qv.f
        public final boolean b(byte[] bArr) {
            throw new UnsupportedOperationException();
        }
    }

    public e(int i, ce ceVar, b bVar, c cVar, w wVar, ae aeVar, l lVar, com.google.android.libraries.navigation.internal.kl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, Runnable runnable, com.google.android.libraries.navigation.internal.mj.a aVar3, bn bnVar, bn bnVar2, br brVar) {
        super(new aq(lVar).a(G), cg.s, ceVar, new a(), null, wVar, lVar, aVar, aVar2, null, runnable, aVar3, bnVar, bnVar2, i, brVar, new ch(aVar3, G));
        this.q = i;
        this.r = bVar;
        this.s = cVar;
        this.t = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa
    protected final cc b(bq bqVar, ac acVar, com.google.android.libraries.navigation.internal.gz.a aVar) throws IOException {
        int i;
        if (acVar.e == au.a) {
            av avVar = acVar.a;
            int i2 = this.q;
            if ((avVar.b & 256) != 0 && (i = avVar.f) != i2) {
                i2 = i;
            }
            byte[] bArrB = avVar.d.B();
            if (i2 != this.q) {
                n(com.google.android.libraries.navigation.internal.km.p.ab, bqVar);
                this.s.c(this.q);
            }
            this.s.b(i2);
            if (bArrB != null) {
                b bVar = this.r;
                com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) com.google.android.libraries.navigation.internal.dm.s.a.q();
                if (!rVar.b.H()) {
                    rVar.v();
                }
                com.google.android.libraries.navigation.internal.dm.s sVar = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
                sVar.b |= 256;
                sVar.k = i2;
                bVar.o((com.google.android.libraries.navigation.internal.dm.s) rVar.t(), bArrB, aVar);
            }
            bqVar.m();
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa
    protected final cc c(com.google.android.libraries.navigation.internal.qv.g gVar, cd cdVar, bq bqVar) {
        if (gVar.h(cdVar)) {
            return gVar.b(cdVar);
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa
    protected final void d(bq bqVar) {
        this.t.c(!this.r.i());
        super.d(bqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa
    protected final void e(bq bqVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        super.e(bqVar, oVar);
        if (oVar.equals(com.google.android.libraries.navigation.internal.gg.o.m)) {
            this.s.c(this.q);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fl.s
    public final void f(cd cdVar) {
        g(cdVar, null, com.google.android.libraries.navigation.internal.rb.b.b());
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa, com.google.android.libraries.navigation.internal.qv.k
    public final void g(cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, com.google.android.libraries.navigation.internal.adf.j jVar) {
        int i = this.q;
        if (i == F || i != this.s.a()) {
            i(cdVar, iVar, false);
        } else {
            super.g(cdVar, iVar, jVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qu.aa, com.google.android.libraries.navigation.internal.fq.p
    public final void h(float f) {
    }
}
