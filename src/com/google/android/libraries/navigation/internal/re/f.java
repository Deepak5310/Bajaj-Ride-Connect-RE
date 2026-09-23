package com.google.android.libraries.navigation.internal.re;

import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ol.ad;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.ol.n;
import com.google.android.libraries.navigation.internal.op.i;
import com.google.android.libraries.navigation.internal.op.j;
import com.google.android.libraries.navigation.internal.op.k;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.px.bk;
import com.google.android.libraries.navigation.internal.rl.p;
import com.google.android.libraries.navigation.internal.rl.u;
import com.google.android.libraries.navigation.internal.rl.w;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements i {
    public final bk b;
    public final com.google.android.libraries.navigation.internal.oq.d d;
    private final ai h;
    private ad j;
    private final u l;
    private final AtomicLong g = new AtomicLong(0);
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    private k i = null;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean(false);
    private final boolean k = true;
    public final boolean c = false;

    public f(ai aiVar, u uVar, bk bkVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        this.h = aiVar;
        this.l = uVar;
        this.b = bkVar;
        this.d = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.op.i
    public final synchronized void a(final k kVar) {
        ad adVar = this.j;
        if (adVar != null) {
            this.h.j(adVar);
            this.j = null;
        }
        if (kVar != null) {
            ad adVar2 = new ad() { // from class: com.google.android.libraries.navigation.internal.re.a
                @Override // com.google.android.libraries.navigation.internal.ol.ad
                public final void a(t tVar, aq aqVar) {
                    f fVar = this.a;
                    AtomicBoolean atomicBoolean = fVar.f;
                    boolean andSet = fVar.e.getAndSet(false);
                    boolean andSet2 = atomicBoolean.getAndSet(false);
                    if (!andSet || andSet2) {
                        kVar.a(fVar.d());
                    }
                }
            };
            this.j = adVar2;
            this.h.e(adVar2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.op.i
    public final com.google.android.libraries.navigation.internal.op.e b(com.google.android.libraries.navigation.internal.oo.f fVar) {
        com.google.android.libraries.navigation.internal.rj.d dVar = new com.google.android.libraries.navigation.internal.rj.d() { // from class: com.google.android.libraries.navigation.internal.re.b
            @Override // com.google.android.libraries.navigation.internal.rj.d
            public final Object a(ef efVar, com.google.android.libraries.navigation.internal.rl.d dVar2) {
                return this.a.c(efVar, dVar2);
            }
        };
        w wVar = new w(this.l);
        return new com.google.android.libraries.navigation.internal.rj.a(wVar.a(fVar).c(), wVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00e9  */
    /* JADX WARN: Multi-variable type inference failed */
    public final d c(ef efVar, com.google.android.libraries.navigation.internal.rl.d dVar) {
        long jIncrementAndGet = this.g.incrementAndGet();
        com.google.android.libraries.navigation.internal.op.a aVar = new com.google.android.libraries.navigation.internal.op.a(jIncrementAndGet);
        bb bbVar = (bb) efVar.aH(5, null);
        bbVar.x(efVar);
        dy dyVar = (dy) bbVar;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar2 = (ef) dyVar.b;
        ef efVar3 = ef.a;
        efVar2.e = null;
        efVar2.b &= -9;
        fs fsVar = efVar.u;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        bb bbVar2 = (bb) fsVar.aH(5, null);
        bbVar2.x(fsVar);
        fr frVar = (fr) bbVar2;
        bh bhVar = com.google.android.libraries.navigation.internal.adk.f.a;
        com.google.android.libraries.navigation.internal.adk.d dVar2 = (com.google.android.libraries.navigation.internal.adk.d) com.google.android.libraries.navigation.internal.adk.e.a.q();
        if (!dVar2.b.H()) {
            dVar2.v();
        }
        com.google.android.libraries.navigation.internal.adk.e eVar = (com.google.android.libraries.navigation.internal.adk.e) dVar2.b;
        eVar.b |= 1;
        eVar.c = jIncrementAndGet;
        frVar.C(bhVar, (com.google.android.libraries.navigation.internal.adk.e) dVar2.t());
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar4 = (ef) dyVar.b;
        fs fsVar2 = (fs) frVar.t();
        fsVar2.getClass();
        efVar4.u = fsVar2;
        efVar4.b |= 65536;
        ef efVar5 = (ef) dyVar.t();
        p pVarC = dVar != 0 ? dVar.c() : null;
        n nVarA = this.h.a(efVar5, jr.WORLD_ENCODING_LAT_LNG_E7, pVarC != null ? pVarC.a() : null);
        fs fsVar3 = efVar5.u;
        if (fsVar3 == null) {
            fsVar3 = fs.a;
        }
        bh bhVarS = bi.s(fu.w);
        fsVar3.h(bhVarS);
        if (fsVar3.w.n(bhVarS.d)) {
            nVarA.l();
        } else {
            bh bhVarS2 = bi.s(bj.V);
            efVar5.h(bhVarS2);
            if (efVar5.w.n(bhVarS2.d)) {
                nVarA.l();
            } else {
                bh bhVarS3 = bi.s(com.google.android.libraries.navigation.internal.adl.k.a);
                efVar5.h(bhVarS3);
                if (efVar5.w.n(bhVarS3.d)) {
                    nVarA.l();
                }
            }
        }
        d dVar3 = new d(this, aVar, nVarA, pVarC, null);
        this.h.h();
        this.a.put(dVar3.b, dVar3);
        this.f.set(true);
        return dVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final fd d() {
        ev evVarO = ev.o(this.a.values());
        ez ezVarH = fd.h(evVarO.size());
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) evVarO.get(i);
            j jVarD = dVar.d();
            if (jVarD != null) {
                ezVarH.f(dVar.b, jVarD);
            }
        }
        return ezVarH.d();
    }
}
