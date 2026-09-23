package com.google.android.libraries.navigation.internal.tq;

import android.app.Application;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.an;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.adq.be;
import com.google.android.libraries.navigation.internal.adr.at;
import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.lj;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.bp.bd;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zr.cu;
import j$.time.Instant;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final Application a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    private final Executor c;

    public e(Application application, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = application;
        this.c = executor;
        this.b = aVar;
    }

    public final bj a(final List list, final gv gvVar, final com.google.android.libraries.navigation.internal.aco.b bVar, final lz lzVar, final mf mfVar, final int i, final ck[] ckVarArr, final boolean z, final long j) {
        if (list.isEmpty()) {
            return az.h(new a(cu.NO_PATH_FOUND));
        }
        com.google.android.libraries.navigation.internal.es.a aVar = (com.google.android.libraries.navigation.internal.es.a) list.get(0);
        t tVar = new t() { // from class: com.google.android.libraries.navigation.internal.tq.b
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                ((h) j.b.F((char) 1827)).p("OfflineAsyncRerouter#getReroute failed");
                List list2 = list;
                return this.a.a(list2.subList(1, list2.size()), gvVar, bVar, lzVar, mfVar, i, ckVarArr, z, j);
            }
        };
        return com.google.android.libraries.navigation.internal.aac.c.i(com.google.android.libraries.navigation.internal.aac.c.i(com.google.android.libraries.navigation.internal.aac.j.h(an.q(aVar.a(bVar, gvVar, lzVar, mfVar, i)), new aa() { // from class: com.google.android.libraries.navigation.internal.tq.c
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                mf mfVar2 = (mf) obj;
                ll llVar = mfVar2.c;
                if (llVar == null) {
                    llVar = ll.a;
                }
                if ((llVar.b & 1) != 0) {
                    ll llVar2 = mfVar2.c;
                    if (llVar2 == null) {
                        llVar2 = ll.a;
                    }
                    lh lhVar = llVar2.c;
                    if (lhVar == null) {
                        lhVar = lh.a;
                    }
                    at atVarB = at.b(lhVar.g);
                    if (atVarB == null) {
                        atVarB = at.SUCCESS;
                    }
                    if (atVarB == at.SUCCESS) {
                        lz lzVar2 = lzVar;
                        ck[] ckVarArr2 = ckVarArr;
                        long j2 = j;
                        e eVar = this.a;
                        af afVar = new af(mfVar2);
                        Instant instantOfEpochMilli = Instant.ofEpochMilli(j2);
                        Instant instant = bg.b;
                        int i2 = be.c;
                        ev evVarP = ev.p(ckVarArr2);
                        lj ljVar = lzVar2.c;
                        if (ljVar == null) {
                            ljVar = lj.a;
                        }
                        lr lrVar = ljVar.g;
                        if (lrVar == null) {
                            lrVar = lr.a;
                        }
                        Application application = eVar.a;
                        boolean z2 = z;
                        bd bdVarAd = bg.ad(afVar, instantOfEpochMilli, instant, 0, application, i2, evVarP, lv.a, z2, lrVar);
                        if (bdVarAd == null) {
                            throw new d();
                        }
                        bdVarAd.B = bf.REROUTING;
                        return new a(new bg(bdVarAd));
                    }
                }
                throw new d();
            }
        }, this.c), com.google.android.libraries.navigation.internal.eq.a.class, tVar, ac.INSTANCE), d.class, tVar, ac.INSTANCE);
    }
}
