package com.google.android.libraries.navigation.internal.uh;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.lj;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.bp.ah;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.eq;
import org.joda.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ w a;

    public t(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        Boolean bool;
        Instant.now();
        com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
        com.google.android.libraries.navigation.internal.rw.p pVar = iVar.c;
        w wVar = this.a;
        wVar.i = true;
        if (iVar.c != com.google.android.libraries.navigation.internal.rw.p.GUIDING) {
            ai aiVar = null;
            ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).c(null);
            com.google.android.libraries.navigation.internal.x.a aVar = (com.google.android.libraries.navigation.internal.x.a) wVar.f.a.b(com.google.android.libraries.navigation.internal.hh.r.ARRIVED_AT_PLACEMARK);
            com.google.android.libraries.navigation.internal.ui.a.C0035a c0035a = (com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b;
            c0035a.m = aVar;
            c0035a.s = (com.google.android.libraries.navigation.internal.sz.a) wVar.h.a.b(com.google.android.libraries.navigation.internal.hh.r.COMPLETED_NAVIGATION);
            if (aVar == null && ((bool = (Boolean) wVar.g.d.b(com.google.android.libraries.navigation.internal.hh.r.WAYPOINTS_CHANGED_IN_NAVIGATION)) == null || !bool.booleanValue())) {
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).o = null;
            } else if (aVar != null) {
                com.google.android.libraries.navigation.internal.ea.c cVar = wVar.b;
                com.google.android.libraries.navigation.internal.sy.b bVar2 = wVar.g;
                com.google.android.libraries.navigation.internal.bv.d dVarA = com.google.android.libraries.navigation.internal.sy.b.a;
                if (dVarA == null) {
                    dVarA = bVar2.c.a(com.google.android.libraries.navigation.internal.by.c.DIRECTIONS_AS_CHANGED_IN_NAVIGATION);
                    com.google.android.libraries.navigation.internal.sy.b.a = dVarA;
                }
                if (dVarA != null) {
                    Context context = bVar2.b;
                    mf mfVar = dVarA.c;
                    if (mfVar == null) {
                        mfVar = mf.a;
                    }
                    af afVar = new af(mfVar, dVarA.f);
                    lz lzVar = dVarA.b;
                    if (lzVar == null) {
                        lzVar = lz.a;
                    }
                    lj ljVar = lzVar.c;
                    if (ljVar == null) {
                        ljVar = lj.a;
                    }
                    bz bzVar = ljVar.c;
                    if (bzVar.size() >= 2) {
                        ah ahVar = new ah();
                        ahVar.a = afVar;
                        lr lrVar = ljVar.g;
                        if (lrVar == null) {
                            lrVar = lr.a;
                        }
                        ka kaVar = lrVar.f;
                        if (kaVar == null) {
                            kaVar = ka.a;
                        }
                        al alVarB = al.b(kaVar.c);
                        if (alVarB == null) {
                            alVarB = al.MIXED;
                        }
                        ahVar.c = alVarB;
                        if (com.google.android.libraries.navigation.internal.by.c.SAVE_THIS_ROUTE == null) {
                            ahVar.l = true;
                        }
                        if (afVar.m()) {
                            ahVar.d(com.google.android.libraries.navigation.internal.bt.j.a(afVar, context));
                        } else {
                            eq eqVar = new eq();
                            for (int i = 0; i < bzVar.size(); i++) {
                                eqVar.h(ck.O((ls) bzVar.get(i), context));
                            }
                            ahVar.d(eqVar.g());
                        }
                        lr lrVar2 = ljVar.g;
                        if (lrVar2 == null) {
                            lrVar2 = lr.a;
                        }
                        ahVar.c(lrVar2);
                        com.google.android.libraries.navigation.internal.bv.b bVar3 = dVarA.d;
                        if (bVar3 == null) {
                            bVar3 = com.google.android.libraries.navigation.internal.bv.b.a;
                        }
                        ahVar.h = j$.time.Instant.ofEpochMilli(bVar3.b);
                        ahVar.k = dVarA.e;
                        lz lzVar2 = dVarA.b;
                        if (lzVar2 == null) {
                            lzVar2 = lz.a;
                        }
                        ahVar.b(lzVar2);
                        aiVar = new ai(ahVar);
                    }
                }
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).o = aiVar;
            }
        } else {
            com.google.android.libraries.navigation.internal.tj.j jVarA = com.google.android.libraries.navigation.internal.rw.t.a(bVar);
            if (jVarA != null) {
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).c(jVarA);
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar.b).f615n = jVarA.h;
            }
        }
        wVar.q();
        int iOrdinal = iVar.c.ordinal();
        if (iOrdinal == 0) {
            wVar.e.a();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            wVar.e.e();
        }
    }
}
