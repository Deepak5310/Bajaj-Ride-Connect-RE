package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import com.google.android.libraries.navigation.internal.zr.ab;
import com.google.android.libraries.navigation.internal.zr.ac;
import com.google.android.libraries.navigation.internal.zr.bf;
import com.google.android.libraries.navigation.internal.zr.bg;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;
import com.google.android.libraries.navigation.internal.zr.br;
import com.google.android.libraries.navigation.internal.zr.bs;
import com.google.android.libraries.navigation.internal.zr.ey;
import com.google.android.libraries.navigation.internal.zr.fa;
import com.google.android.libraries.navigation.internal.zr.fb;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g extends c {
    private static final int[] a = new int[0];
    private final bh d;
    private int[] e;
    private com.google.android.libraries.navigation.internal.zp.d f;
    private an g;
    private final com.google.android.libraries.navigation.internal.kd.f h;

    public g(long j) {
        this(j, j, com.google.android.libraries.navigation.internal.kd.f.a);
    }

    private final synchronized bi w() {
        bh bhVar;
        bhVar = (bh) bi.a.r((bi) this.d.t());
        y(bhVar);
        return (bi) bhVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.ke.c
    public synchronized void b(pd pdVar) {
        super.b(pdVar);
        bi biVarW = w();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        pe peVar2 = pe.a;
        biVarW.getClass();
        peVar.k = biVarW;
        peVar.b |= 128;
    }

    public final synchronized int n() {
        return ((bi) this.d.b).d;
    }

    public final synchronized boolean o() {
        return (((bi) this.d.b).b & 4) != 0;
    }

    public final synchronized void p(com.google.android.libraries.navigation.internal.zp.d dVar) {
        this.f = dVar;
    }

    public final synchronized void q(com.google.android.libraries.navigation.internal.zr.q qVar) {
        bh bhVar = this.d;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        qVar.getClass();
        biVar.i = qVar;
        biVar.b |= 512;
    }

    public void r(List list) {
        s(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final synchronized void s(List list) {
        bh bhVar = this.d;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        biVar.h = dj.b;
        no it2 = ((ev) list).iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.kb.c cVar = (com.google.android.libraries.navigation.internal.kb.c) it2.next();
            bf bfVar = (bf) bg.a.q();
            com.google.android.libraries.navigation.internal.zt.d dVarC = cVar.c();
            if (dVarC != null) {
                if (!bfVar.b.H()) {
                    bfVar.v();
                }
                bg bgVar = (bg) bfVar.b;
                bgVar.c = dVarC;
                bgVar.b |= 1;
            }
            bh bhVar2 = this.d;
            if (!bhVar2.b.H()) {
                bhVar2.v();
            }
            bi biVar3 = (bi) bhVar2.b;
            bg bgVar2 = (bg) bfVar.t();
            bgVar2.getClass();
            bz bzVar = biVar3.h;
            if (!bzVar.c()) {
                biVar3.h = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
            }
            biVar3.h.add(bgVar2);
        }
    }

    public final synchronized void t(int[] iArr) {
        this.e = iArr;
    }

    public final synchronized void u(int i) {
        bh bhVar = this.d;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        biVar.b |= 4;
        biVar.d = i;
    }

    public final synchronized void v(fa faVar) {
        this.g = an.j(faVar);
    }

    public synchronized void y(bh bhVar) {
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        biVar.j = bj.a;
        for (int i : this.e) {
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            bi biVar3 = (bi) bhVar.b;
            bq bqVar = biVar3.j;
            if (!bqVar.c()) {
                biVar3.j = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
            }
            biVar3.j.i(i);
        }
        ac acVar = ((bi) bhVar.b).f;
        if (acVar == null) {
            acVar = ac.a;
        }
        bb bbVar = (bb) acVar.aH(5, null);
        bbVar.x(acVar);
        ab abVar = (ab) bbVar;
        com.google.android.libraries.navigation.internal.zp.d dVar = this.f;
        if (dVar != null) {
            ar.q(dVar);
            if (!abVar.b.H()) {
                abVar.v();
            }
            ac acVar2 = (ac) abVar.b;
            acVar2.h = dVar;
            acVar2.b |= 2048;
        }
        fa faVar = (fa) this.g.f();
        if (faVar != null) {
            ey eyVar = (ey) fb.a.q();
            if (!eyVar.b.H()) {
                eyVar.v();
            }
            fb fbVar = (fb) eyVar.b;
            fbVar.c = faVar.d;
            fbVar.b |= 1;
            fb fbVar2 = (fb) eyVar.t();
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            bi biVar4 = (bi) bhVar.b;
            fbVar2.getClass();
            biVar4.e = fbVar2;
            biVar4.b |= 32;
        }
        com.google.android.libraries.navigation.internal.wz.b bVarC = com.google.android.libraries.navigation.internal.wz.b.c();
        long j = bVarC.o;
        double d = bVarC.p;
        long jMax = Math.max(0L, j);
        int iMax = (int) Math.max(0L, Math.min(2147483647L, Math.round(d / 1024.0d)));
        int iMax2 = (int) Math.max(0L, Math.min(2147483647L, Math.round(bVarC.q / 1024.0d)));
        br brVar = (br) bs.a.q();
        if (!brVar.b.H()) {
            brVar.v();
        }
        bs bsVar = (bs) brVar.b;
        bsVar.b |= 1;
        bsVar.c = jMax;
        if (!brVar.b.H()) {
            brVar.v();
        }
        bs bsVar2 = (bs) brVar.b;
        bsVar2.b |= 4;
        bsVar2.e = iMax;
        if (!brVar.b.H()) {
            brVar.v();
        }
        bs bsVar3 = (bs) brVar.b;
        bsVar3.b |= 2;
        bsVar3.d = iMax2;
        int i2 = com.google.android.libraries.navigation.internal.kr.a.a;
        bs bsVar4 = (bs) brVar.t();
        if (!abVar.b.H()) {
            abVar.v();
        }
        ac acVar3 = (ac) abVar.b;
        bsVar4.getClass();
        acVar3.g = bsVar4;
        acVar3.b |= 128;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar5 = (bi) bhVar.b;
        ac acVar4 = (ac) abVar.t();
        acVar4.getClass();
        biVar5.f = acVar4;
        biVar5.b |= 64;
    }

    public g(long j, long j2, com.google.android.libraries.navigation.internal.kd.f fVar) {
        super(j, j2);
        this.e = a;
        this.f = null;
        this.g = com.google.android.libraries.navigation.internal.yx.a.a;
        this.d = (bh) bi.a.q();
        this.h = fVar;
    }
}
