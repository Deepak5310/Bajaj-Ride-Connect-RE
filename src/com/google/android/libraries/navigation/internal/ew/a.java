package com.google.android.libraries.navigation.internal.ew;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.gi;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.adr.gw;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.hw;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.adr.ie;
import com.google.android.libraries.navigation.internal.adr.kb;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.afl.gm;
import com.google.android.libraries.navigation.internal.afl.gn;
import com.google.android.libraries.navigation.internal.afl.go;
import com.google.android.libraries.navigation.internal.afl.gp;
import com.google.android.libraries.navigation.internal.afl.lb;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.lk;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mc;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.ke.l;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends l {
    private final lz a;
    private final mf d;

    public a(com.google.android.libraries.navigation.internal.mj.a aVar, lz lzVar, mf mfVar) {
        super(aVar);
        this.a = lzVar;
        int i = 5;
        bb bbVar = (bb) mfVar.aH(5, null);
        bbVar.x(mfVar);
        mc mcVar = (mc) bbVar;
        ll llVar = mfVar.c;
        lh lhVar = (llVar == null ? ll.a : llVar).c;
        lhVar = lhVar == null ? lh.a : lhVar;
        bb bbVar2 = (bb) lhVar.aH(5, null);
        bbVar2.x(lhVar);
        lb lbVar = (lb) bbVar2;
        int i2 = 0;
        while (i2 < ((lh) lbVar.b).d.size()) {
            ki kiVarC = lbVar.c(i2);
            bb bbVar3 = (bb) kiVarC.aH(i, null);
            bbVar3.x(kiVarC);
            kb kbVar = (kb) bbVar3;
            int i3 = 0;
            while (i3 < ((ki) kbVar.b).h.size()) {
                gj gjVarC = kbVar.c(i3);
                bb bbVar4 = (bb) gjVarC.aH(i, null);
                bbVar4.x(gjVarC);
                gi giVar = (gi) bbVar4;
                int i4 = 0;
                while (i4 < ((gj) giVar.b).e.size()) {
                    ib ibVarC = giVar.c(i4);
                    bb bbVar5 = (bb) ibVarC.aH(i, null);
                    bbVar5.x(ibVarC);
                    hw hwVar = (hw) bbVar5;
                    int i5 = 0;
                    while (i5 < ((ib) hwVar.b).d.size()) {
                        hv hvVarC = hwVar.c(i5);
                        bb bbVar6 = (bb) hvVarC.aH(i, null);
                        bbVar6.x(hvVarC);
                        gw gwVar = (gw) bbVar6;
                        Cif cif = ((hv) gwVar.b).d;
                        Cif cifN = n(cif == null ? Cif.a : cif);
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        hv hvVar = (hv) gwVar.b;
                        cifN.getClass();
                        hvVar.d = cifN;
                        hvVar.b |= 2;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        hv hvVar2 = (hv) gwVar.b;
                        hvVar2.f = null;
                        hvVar2.b &= -9;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        hv hvVar3 = (hv) gwVar.b;
                        hvVar3.g = null;
                        hvVar3.b &= -17;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        hv hvVar4 = (hv) gwVar.b;
                        hvVar4.h = null;
                        hvVar4.b &= -33;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        ((hv) gwVar.b).o = dj.b;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        ((hv) gwVar.b).p = dj.b;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        hv hvVar5 = (hv) gwVar.b;
                        hvVar5.q = null;
                        hvVar5.b &= -4097;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        ((hv) gwVar.b).r = dj.b;
                        if (!gwVar.b.H()) {
                            gwVar.v();
                        }
                        ((hv) gwVar.b).v = dj.b;
                        hwVar.e(i5, (hv) gwVar.t());
                        i5++;
                        i = 5;
                    }
                    Cif cif2 = ((ib) hwVar.b).c;
                    Cif cifN2 = n(cif2 == null ? Cif.a : cif2);
                    if (!hwVar.b.H()) {
                        hwVar.v();
                    }
                    ib ibVar = (ib) hwVar.b;
                    cifN2.getClass();
                    ibVar.c = cifN2;
                    ibVar.b |= 2;
                    if (!hwVar.b.H()) {
                        hwVar.v();
                    }
                    ib ibVar2 = (ib) hwVar.b;
                    ibVar2.e = null;
                    ibVar2.b &= -9;
                    if (!hwVar.b.H()) {
                        hwVar.v();
                    }
                    ib ibVar3 = (ib) hwVar.b;
                    ibVar3.f = null;
                    ibVar3.b &= -33;
                    giVar.e(i4, (ib) hwVar.t());
                    i4++;
                    i = 5;
                }
                Cif cif3 = ((gj) giVar.b).c;
                Cif cifN3 = n(cif3 == null ? Cif.a : cif3);
                if (!giVar.b.H()) {
                    giVar.v();
                }
                gj gjVar = (gj) giVar.b;
                cifN3.getClass();
                gjVar.c = cifN3;
                gjVar.b |= 1;
                kbVar.f(i3, (gj) giVar.t());
                i3++;
                i = 5;
            }
            Cif cif4 = ((ki) kbVar.b).g;
            Cif cifN4 = n(cif4 == null ? Cif.a : cif4);
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar = (ki) kbVar.b;
            cifN4.getClass();
            kiVar.g = cifN4;
            kiVar.b |= 16;
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar2 = (ki) kbVar.b;
            kiVar2.i = null;
            kiVar2.b &= -33;
            int size = lbVar.d(kiVarC.l).c.size();
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar3 = (ki) kbVar.b;
            kiVar3.b |= 512;
            kiVar3.l = size;
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar4 = (ki) kbVar.b;
            kiVar4.o = null;
            kiVar4.b &= -32769;
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar5 = (ki) kbVar.b;
            kiVar5.b &= -2097153;
            kiVar5.t = ki.a.t;
            if (!kbVar.b.H()) {
                kbVar.v();
            }
            ki kiVar6 = (ki) kbVar.b;
            kiVar6.b &= -4194305;
            kiVar6.u = ki.a.u;
            lbVar.h(i2, (ki) kbVar.t());
            i2++;
            i = 5;
        }
        if (!lbVar.b.H()) {
            lbVar.v();
        }
        ((lh) lbVar.b).i = dj.b;
        ll llVar2 = mfVar.c;
        llVar2 = llVar2 == null ? ll.a : llVar2;
        bb bbVar7 = (bb) llVar2.aH(5, null);
        bbVar7.x(llVar2);
        lk lkVar = (lk) bbVar7;
        if (!lkVar.b.H()) {
            lkVar.v();
        }
        ll llVar3 = (ll) lkVar.b;
        lh lhVar2 = (lh) lbVar.t();
        lhVar2.getClass();
        llVar3.c = lhVar2;
        llVar3.b |= 1;
        if (!mcVar.b.H()) {
            mcVar.v();
        }
        mf mfVar2 = (mf) mcVar.b;
        ll llVar4 = (ll) lkVar.t();
        llVar4.getClass();
        mfVar2.c = llVar4;
        mfVar2.b |= 1;
        this.d = (mf) mcVar.t();
    }

    private static Cif n(Cif cif) {
        bb bbVar = (bb) cif.aH(5, null);
        bbVar.x(cif);
        ie ieVar = (ie) bbVar;
        if (!ieVar.b.H()) {
            ieVar.v();
        }
        Cif cif2 = (Cif) ieVar.b;
        Cif cif3 = Cif.a;
        cif2.b &= -3;
        cif2.d = Cif.a.d;
        if (!ieVar.b.H()) {
            ieVar.v();
        }
        Cif cif4 = (Cif) ieVar.b;
        cif4.l = null;
        cif4.b &= -8193;
        if (!ieVar.b.H()) {
            ieVar.v();
        }
        ((Cif) ieVar.b).m = dj.b;
        return ieVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.ke.l
    public final gp a() {
        go goVar = (go) gp.a.q();
        if (!goVar.b.H()) {
            goVar.v();
        }
        gp gpVar = (gp) goVar.b;
        gpVar.b |= 1;
        gpVar.e = 142;
        gm gmVar = (gm) gn.a.q();
        lz lzVar = this.a;
        if (!gmVar.b.H()) {
            gmVar.v();
        }
        gn gnVar = (gn) gmVar.b;
        gnVar.c = lzVar;
        gnVar.b |= 1;
        mf mfVar = this.d;
        if (!gmVar.b.H()) {
            gmVar.v();
        }
        gn gnVar2 = (gn) gmVar.b;
        mfVar.getClass();
        gnVar2.d = mfVar;
        gnVar2.b |= 2;
        if (!goVar.b.H()) {
            goVar.v();
        }
        gp gpVar2 = (gp) goVar.b;
        gn gnVar3 = (gn) gmVar.t();
        gnVar3.getClass();
        gpVar2.d = gnVar3;
        gpVar2.c = 3;
        return (gp) goVar.t();
    }
}
