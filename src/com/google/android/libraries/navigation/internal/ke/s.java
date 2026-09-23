package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.cp;
import com.google.android.libraries.navigation.internal.afl.cq;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.afl.qp;
import com.google.android.libraries.navigation.internal.afl.qq;
import com.google.android.libraries.navigation.internal.afl.qr;
import com.google.android.libraries.navigation.internal.afl.qs;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ew;
import com.google.android.libraries.navigation.internal.yz.ex;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zp.by;
import com.google.android.libraries.navigation.internal.zp.cb;
import com.google.android.libraries.navigation.internal.zp.cd;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.fe;
import com.google.android.libraries.navigation.internal.zr.ff;
import com.google.android.libraries.navigation.internal.zr.fg;
import com.google.android.libraries.navigation.internal.zr.fh;
import com.google.android.libraries.navigation.internal.zr.fi;
import com.google.android.libraries.navigation.internal.zr.fj;
import j$.time.Duration;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends g {
    final an a;
    private final List d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final long f;
    private final boolean g;

    public s(List list, an anVar, com.google.android.libraries.navigation.internal.mj.a aVar, long j, com.google.android.libraries.navigation.internal.afo.a aVar2, boolean z) {
        super(aVar.a());
        this.d = list;
        this.e = aVar2;
        this.a = anVar;
        this.f = j;
        this.g = z;
    }

    private static fd w(List list) {
        ez ezVar = new ez();
        for (int i = 0; i < list.size(); i++) {
            ezVar.f(Integer.valueOf(((com.google.android.libraries.navigation.internal.kf.i) list.get(i)).c), Integer.valueOf(i));
        }
        return ezVar.d();
    }

    private static void x(qr qrVar, Iterable iterable, Map map) {
        if (gs.h(iterable)) {
            return;
        }
        cb cbVar = ((qs) qrVar.b).c;
        if (cbVar == null) {
            cbVar = cb.a;
        }
        by byVar = (by) cb.a.r(cbVar);
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) map.get(Integer.valueOf(((com.google.android.libraries.navigation.internal.kf.i) it2.next()).c));
            ar.q(num);
            byVar.a(num.intValue());
        }
        cb cbVar2 = (cb) byVar.t();
        if (!qrVar.b.H()) {
            qrVar.v();
        }
        qs qsVar = (qs) qrVar.b;
        cbVar2.getClass();
        qsVar.c = cbVar2;
        qsVar.b |= 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        long j = this.f;
        if (j != -1) {
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar = (pe) pdVar.b;
            pe peVar2 = pe.a;
            peVar.b |= 1;
            peVar.d = j;
        }
        ew ewVar = new ew();
        for (com.google.android.libraries.navigation.internal.kf.i iVar : this.d) {
            com.google.android.libraries.navigation.internal.jy.m mVar = iVar.d;
            String strF = f();
            ar.q(strF);
            if (mVar.f(strF) && !mVar.g()) {
                ewVar.b(Integer.valueOf(mVar.d()), iVar);
            }
        }
        ex exVarA = ewVar.a();
        if (!this.g) {
            ak akVarC = c();
            int i = com.google.android.libraries.navigation.internal.zp.n.aV.a;
            if (!akVarC.b.H()) {
                akVarC.v();
            }
            al alVar = (al) akVarC.b;
            al alVar2 = al.a;
            alVar.b |= 64;
            alVar.e = i;
            al alVar3 = (al) akVarC.t();
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar3 = (pe) pdVar.b;
            pe peVar4 = pe.a;
            alVar3.getClass();
            peVar3.f = alVar3;
            peVar3.b |= 4;
            int i2 = ev.d;
            eq eqVar = new eq();
            an anVar = this.a;
            by byVarA = com.google.android.libraries.navigation.internal.jw.i.a(anVar.g() ? (aa) anVar.c() : aa.k(com.google.android.libraries.navigation.internal.afe.k.a), Duration.ZERO, 0);
            fd fdVarW = w(this.d);
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                com.google.android.libraries.navigation.internal.kf.i iVar2 = (com.google.android.libraries.navigation.internal.kf.i) this.d.get(i3);
                qr qrVarA = iVar2.a();
                x(qrVarA, exVarA.c(Integer.valueOf(iVar2.c)), fdVarW);
                eqVar.h((qs) qrVarA.t());
                com.google.android.libraries.navigation.internal.jy.m mVar2 = iVar2.d;
                String strF2 = f();
                ar.q(strF2);
                if (!mVar2.f(strF2) || mVar2.g()) {
                    byVarA.a(i3);
                }
            }
            cb cbVar = (cb) byVarA.t();
            qr qrVar = (qr) qs.a.q();
            if (!qrVar.b.H()) {
                qrVar.v();
            }
            qs qsVar = (qs) qrVar.b;
            cbVar.getClass();
            qsVar.c = cbVar;
            qsVar.b |= 1;
            eqVar.h((qs) qrVar.t());
            ev evVarG = eqVar.g();
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar5 = (pe) pdVar.b;
            bz bzVar = peVar5.g;
            if (!bzVar.c()) {
                peVar5.g = bi.A(bzVar);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(evVarG, peVar5.g);
            return;
        }
        ak akVarC2 = c();
        int i4 = com.google.android.libraries.navigation.internal.zp.n.aW.a;
        if (!akVarC2.b.H()) {
            akVarC2.v();
        }
        al alVar4 = (al) akVarC2.b;
        al alVar5 = al.a;
        alVar4.b |= 64;
        alVar4.e = i4;
        al alVar6 = (al) akVarC2.t();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar6 = (pe) pdVar.b;
        pe peVar7 = pe.a;
        alVar6.getClass();
        peVar6.f = alVar6;
        peVar6.b |= 4;
        int i5 = ev.d;
        eq eqVar2 = new eq();
        for (com.google.android.libraries.navigation.internal.kf.i iVar3 : this.d) {
            com.google.android.libraries.navigation.internal.jy.m mVar3 = iVar3.d;
            String strF3 = f();
            ar.q(strF3);
            if (!mVar3.f(strF3)) {
                cp cpVar = (cp) cq.a.q();
                com.google.android.libraries.navigation.internal.jy.m mVar4 = iVar3.d;
                qp qpVar = (qp) qq.a.q();
                com.google.android.libraries.navigation.internal.zt.d dVarC = mVar4.b().c();
                if (dVarC != null) {
                    if (!qpVar.b.H()) {
                        qpVar.v();
                    }
                    qq qqVar = (qq) qpVar.b;
                    qqVar.c = dVarC;
                    qqVar.b |= 1;
                }
                cd cdVarB = mVar4.a().b();
                if (!qpVar.b.H()) {
                    qpVar.v();
                }
                qq qqVar2 = (qq) qpVar.b;
                cdVarB.getClass();
                qqVar2.d = cdVarB;
                qqVar2.b |= 2;
                qq qqVar3 = (qq) qpVar.t();
                if (!cpVar.b.H()) {
                    cpVar.v();
                }
                cq cqVar = (cq) cpVar.b;
                qqVar3.getClass();
                cqVar.c = qqVar3;
                cqVar.b |= 1;
                eq eqVar3 = new eq();
                eq eqVar4 = new eq();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(iVar3);
                while (!arrayDeque.isEmpty()) {
                    com.google.android.libraries.navigation.internal.kf.i iVar4 = (com.google.android.libraries.navigation.internal.kf.i) arrayDeque.pop();
                    eqVar4.h(iVar4);
                    arrayDeque.addAll(exVarA.c(Integer.valueOf(iVar4.c)));
                }
                ev evVarG2 = eqVar4.g();
                fd fdVarW2 = w(evVarG2);
                int i6 = ((lv) evVarG2).c;
                for (int i7 = 0; i7 < i6; i7++) {
                    com.google.android.libraries.navigation.internal.kf.i iVar5 = (com.google.android.libraries.navigation.internal.kf.i) evVarG2.get(i7);
                    qr qrVarA2 = iVar5.a();
                    x(qrVarA2, exVarA.c(Integer.valueOf(iVar5.c)), fdVarW2);
                    eqVar3.h((qs) qrVarA2.t());
                }
                ev evVarG3 = eqVar3.g();
                if (!cpVar.b.H()) {
                    cpVar.v();
                }
                cq cqVar2 = (cq) cpVar.b;
                bz bzVar2 = cqVar2.d;
                if (!bzVar2.c()) {
                    cqVar2.d = bi.A(bzVar2);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVarG3, cqVar2.d);
                eqVar2.h((cq) cpVar.t());
            }
        }
        ev evVarG4 = eqVar2.g();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar8 = (pe) pdVar.b;
        bz bzVar3 = peVar8.i;
        if (!bzVar3.c()) {
            peVar8.i = bi.A(bzVar3);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(evVarG4, peVar8.i);
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        com.google.android.libraries.navigation.internal.afd.a aVar;
        super.y(bhVar);
        com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) this.e.a()).a().e;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.nk.p.a;
        }
        if (pVar.k) {
            return;
        }
        fg fgVar = (fg) fj.a.q();
        for (com.google.android.libraries.navigation.internal.kf.i iVar : this.d) {
            aa aaVar = iVar.a;
            fh fhVar = (fh) fi.a.q();
            String str = aaVar.f;
            if (str != null) {
                if (!fhVar.b.H()) {
                    fhVar.v();
                }
                fi fiVar = (fi) fhVar.b;
                fiVar.b |= 1;
                fiVar.c = str;
            }
            com.google.android.libraries.navigation.internal.afd.a aVar2 = aaVar.k;
            if (aVar2 != null) {
                int iA = aVar2.a();
                if (!fhVar.b.H()) {
                    fhVar.v();
                }
                fi fiVar2 = (fi) fhVar.b;
                fiVar2.b |= 4;
                fiVar2.f = iA;
            }
            String str2 = aaVar.d;
            if (str2 != null && !str2.isEmpty()) {
                fe feVar = (fe) ff.a.q();
                if (!feVar.b.H()) {
                    feVar.v();
                }
                ff ffVar = (ff) feVar.b;
                ffVar.b |= 2;
                ffVar.c = str2;
                if (!fhVar.b.H()) {
                    fhVar.v();
                }
                fi fiVar3 = (fi) fhVar.b;
                ff ffVar2 = (ff) feVar.t();
                ffVar2.getClass();
                bz bzVar = fiVar3.d;
                if (!bzVar.c()) {
                    fiVar3.d = bi.A(bzVar);
                }
                fiVar3.d.add(ffVar2);
            }
            com.google.android.libraries.navigation.internal.zp.bi biVarD = aaVar.d();
            if (biVarD != null) {
                if (!fhVar.b.H()) {
                    fhVar.v();
                }
                fi fiVar4 = (fi) fhVar.b;
                fiVar4.g = biVarD;
                fiVar4.b |= 8;
            }
            long j = iVar.b;
            if (!fhVar.b.H()) {
                fhVar.v();
            }
            fi fiVar5 = (fi) fhVar.b;
            fiVar5.b |= 2;
            fiVar5.e = j;
            if (!fgVar.b.H()) {
                fgVar.v();
            }
            fj fjVar = (fj) fgVar.b;
            fi fiVar6 = (fi) fhVar.t();
            fiVar6.getClass();
            bz bzVar2 = fjVar.b;
            if (!bzVar2.c()) {
                fjVar.b = bi.A(bzVar2);
            }
            fjVar.b.add(fiVar6);
        }
        an anVar = this.a;
        if (anVar.g() && (aVar = ((aa) anVar.c()).k) != null) {
            by byVar = (by) cb.a.q();
            int iA2 = aVar.a();
            if (!byVar.b.H()) {
                byVar.v();
            }
            cb cbVar = (cb) byVar.b;
            cbVar.b |= 1;
            cbVar.c = iA2;
            if (!fgVar.b.H()) {
                fgVar.v();
            }
            fj fjVar2 = (fj) fgVar.b;
            cb cbVar2 = (cb) byVar.t();
            cbVar2.getClass();
            bz bzVar3 = fjVar2.c;
            if (!bzVar3.c()) {
                fjVar2.c = bi.A(bzVar3);
            }
            fjVar2.c.add(cbVar2);
        }
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.bi biVar = (com.google.android.libraries.navigation.internal.zr.bi) bhVar.b;
        fj fjVar3 = (fj) fgVar.t();
        com.google.android.libraries.navigation.internal.zr.bi biVar2 = com.google.android.libraries.navigation.internal.zr.bi.a;
        fjVar3.getClass();
        biVar.l = fjVar3;
        biVar.b |= 8192;
    }
}
