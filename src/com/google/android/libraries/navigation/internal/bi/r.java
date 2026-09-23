package com.google.android.libraries.navigation.internal.bi;

import com.google.android.libraries.navigation.internal.adq.y;
import com.google.android.libraries.navigation.internal.adq.z;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.cs;
import com.google.android.libraries.navigation.internal.adr.fy;
import com.google.android.libraries.navigation.internal.adr.gd;
import com.google.android.libraries.navigation.internal.adr.ge;
import com.google.android.libraries.navigation.internal.adr.kz;
import com.google.android.libraries.navigation.internal.adr.la;
import com.google.android.libraries.navigation.internal.adr.lh;
import com.google.android.libraries.navigation.internal.adr.ln;
import com.google.android.libraries.navigation.internal.adr.lp;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.ca;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.ku;
import com.google.android.libraries.navigation.internal.afl.li;
import com.google.android.libraries.navigation.internal.afl.lj;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.lw;
import com.google.android.libraries.navigation.internal.afl.ly;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mh;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.cg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements q {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bi.r");

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.bi.q
    public final lz a(com.google.android.libraries.navigation.internal.bs.b bVar, mj mjVar, List list, lt ltVar, boolean z, boolean z2) {
        li liVar = (li) lj.a.q();
        fy fyVar = fy.TURN_BY_TURN;
        if (!liVar.b.H()) {
            liVar.v();
        }
        lj ljVar = (lj) liVar.b;
        ljVar.e = fyVar.g;
        ljVar.b |= 2;
        com.google.android.libraries.navigation.internal.ady.h hVar = bVar.c;
        if (!liVar.b.H()) {
            liVar.v();
        }
        lj ljVar2 = (lj) liVar.b;
        hVar.getClass();
        ljVar2.p = hVar;
        ljVar2.b |= 32768;
        lr lrVar = bVar.a;
        if (!liVar.b.H()) {
            liVar.v();
        }
        lj ljVar3 = (lj) liVar.b;
        lrVar.getClass();
        ljVar3.g = lrVar;
        ljVar3.b |= 4;
        for (Map.Entry entry : bVar.m.entrySet()) {
            gd gdVar = (gd) ge.a.q();
            al alVar = (al) entry.getKey();
            if (!gdVar.b.H()) {
                gdVar.v();
            }
            ge geVar = (ge) gdVar.b;
            geVar.c = alVar.k;
            geVar.b = 1 | geVar.b;
            fy fyVar2 = (fy) entry.getValue();
            if (!gdVar.b.H()) {
                gdVar.v();
            }
            ge geVar2 = (ge) gdVar.b;
            geVar2.d = fyVar2.g;
            geVar2.b |= 2;
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar4 = (lj) liVar.b;
            ge geVar3 = (ge) gdVar.t();
            geVar3.getClass();
            bz bzVar = ljVar4.f;
            if (!bzVar.c()) {
                ljVar4.f = bi.A(bzVar);
            }
            ljVar4.f.add(geVar3);
        }
        if (bVar.e != null) {
            int i = 0;
            while (i < bVar.e.size()) {
                ck ckVar = (ck) bVar.e.get(i);
                boolean z3 = i > 25 && z2;
                lh lhVar = (lh) ls.a.q();
                com.google.android.libraries.navigation.internal.oe.r rVarN = ckVar.n();
                if (ckVar.Z()) {
                    com.google.android.libraries.navigation.internal.adr.lj ljVar5 = com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_MY_LOCATION;
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar = (ls) lhVar.b;
                    lsVar.k = ljVar5.h;
                    lsVar.b |= 512;
                    int i2 = lp.d;
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar2 = (ls) lhVar.b;
                    int i3 = i2 - 1;
                    if (i2 == 0) {
                        throw null;
                    }
                    lsVar2.c = i3;
                    lsVar2.b |= 1;
                    if (ckVar.u() != null) {
                        String strU = ckVar.u();
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar3 = (ls) lhVar.b;
                        strU.getClass();
                        lsVar3.b |= 16384;
                        lsVar3.f230n = strU;
                    }
                } else if (!ckVar.X() && rVarN != null) {
                    z zVarB = rVarN.b();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar4 = (ls) lhVar.b;
                    zVarB.getClass();
                    lsVar4.f = zVarB;
                    lsVar4.b |= 8;
                    String strY = ckVar.y();
                    if (ckVar.s() != com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_NICKNAME || aq.c(strY)) {
                        int i4 = ckVar.D() ? lp.b : lp.c;
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar5 = (ls) lhVar.b;
                        int i5 = i4 - 1;
                        if (i4 == 0) {
                            throw null;
                        }
                        lsVar5.c = i5;
                        lsVar5.b |= 1;
                    } else {
                        int i6 = lp.c;
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar6 = (ls) lhVar.b;
                        int i7 = i6 - 1;
                        if (i6 == 0) {
                            throw null;
                        }
                        lsVar6.c = i7;
                        lsVar6.b |= 1;
                        if (strY != null) {
                            if (!lhVar.b.H()) {
                                lhVar.v();
                            }
                            ls lsVar7 = (ls) lhVar.b;
                            lsVar7.b |= 256;
                            lsVar7.j = strY;
                        }
                    }
                    com.google.android.libraries.navigation.internal.adr.lj ljVarS = ckVar.s();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar8 = (ls) lhVar.b;
                    lsVar8.k = ljVarS.h;
                    lsVar8.b |= 512;
                } else if (ckVar.w() != null) {
                    String strW = ckVar.w();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar9 = (ls) lhVar.b;
                    strW.getClass();
                    lsVar9.b |= 16;
                    lsVar9.g = strW;
                } else {
                    String strX = ckVar.x();
                    if (strX != null) {
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar10 = (ls) lhVar.b;
                        lsVar10.b |= 2;
                        lsVar10.d = strX;
                    }
                    if (ckVar.X()) {
                        String strF = ckVar.m().f();
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar11 = (ls) lhVar.b;
                        lsVar11.b |= 4;
                        lsVar11.e = strF;
                    }
                    if (rVarN != null) {
                        z zVarB2 = rVarN.b();
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar12 = (ls) lhVar.b;
                        zVarB2.getClass();
                        lsVar12.f = zVarB2;
                        lsVar12.b |= 8;
                    }
                    com.google.android.libraries.navigation.internal.pt.d dVarO = ckVar.o();
                    if (dVarO != null) {
                        com.google.android.libraries.navigation.internal.adq.g gVar = (com.google.android.libraries.navigation.internal.adq.g) com.google.android.libraries.navigation.internal.adq.h.a.q();
                        String strF2 = dVarO.b.f();
                        if (!gVar.b.H()) {
                            gVar.v();
                        }
                        com.google.android.libraries.navigation.internal.adq.h hVar2 = (com.google.android.libraries.navigation.internal.adq.h) gVar.b;
                        hVar2.b |= 1;
                        hVar2.c = strF2;
                        int i8 = dVarO.c;
                        if (i8 != Integer.MIN_VALUE) {
                            float f = i8;
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            com.google.android.libraries.navigation.internal.adq.h hVar3 = (com.google.android.libraries.navigation.internal.adq.h) gVar.b;
                            hVar3.b |= 2;
                            hVar3.d = f * 0.001f;
                        }
                        com.google.android.libraries.navigation.internal.adq.h hVar4 = (com.google.android.libraries.navigation.internal.adq.h) gVar.t();
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar13 = (ls) lhVar.b;
                        hVar4.getClass();
                        lsVar13.l = hVar4;
                        lsVar13.b |= 1024;
                    }
                    String strY2 = ckVar.y();
                    if ((z3 || ckVar.s() == com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_NICKNAME) && !aq.c(strY2)) {
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar14 = (ls) lhVar.b;
                        strY2.getClass();
                        lsVar14.b |= 256;
                        lsVar14.j = strY2;
                    }
                    com.google.android.libraries.navigation.internal.adr.lj ljVarS2 = ckVar.s();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar15 = (ls) lhVar.b;
                    lsVar15.k = ljVarS2.h;
                    lsVar15.b |= 512;
                    x xVarT = x.t(ckVar.G());
                    if (!xVarT.A()) {
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar16 = (ls) lhVar.b;
                        lsVar16.m = xVarT.x(ca.a);
                        lsVar16.b |= 4096;
                    }
                }
                if (ckVar.t() != null) {
                    Boolean boolT = ckVar.t();
                    boolean zBooleanValue = boolT != null ? boolT.booleanValue() : false;
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar17 = (ls) lhVar.b;
                    lsVar17.b |= 65536;
                    lsVar17.o = zBooleanValue;
                }
                if (ckVar.h() != null) {
                    cs csVarR = ckVar.R();
                    ar.q(csVarR);
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar18 = (ls) lhVar.b;
                    lsVar18.t = csVarR;
                    lsVar18.b |= 2097152;
                }
                if (ckVar.C()) {
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar19 = (ls) lhVar.b;
                    lsVar19.b |= 64;
                    lsVar19.h = true;
                    if (ckVar.b() != -1) {
                        int iB = ckVar.b();
                        if (!lhVar.b.H()) {
                            lhVar.v();
                        }
                        ls lsVar20 = (ls) lhVar.b;
                        lsVar20.b |= 128;
                        lsVar20.i = iB;
                    }
                }
                ln lnVarT = ckVar.T();
                if (lnVarT != null) {
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar21 = (ls) lhVar.b;
                    lsVar21.p = lnVarT;
                    lsVar21.b |= 131072;
                }
                int iL = ckVar.L();
                if (iL != 0) {
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar22 = (ls) lhVar.b;
                    lsVar22.r = iL - 1;
                    lsVar22.b |= 524288;
                }
                if (ckVar.a() > 0) {
                    int iA = ckVar.a();
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar23 = (ls) lhVar.b;
                    lsVar23.b |= 1048576;
                    lsVar23.s = iA;
                }
                if (ckVar.k() != null) {
                    com.google.android.libraries.navigation.internal.adr.lr lrVar2 = (com.google.android.libraries.navigation.internal.adr.lr) com.google.android.libraries.navigation.internal.hc.a.e(ckVar.k(), (dg) com.google.android.libraries.navigation.internal.adr.lr.a.aH(7, null), com.google.android.libraries.navigation.internal.adr.lr.a);
                    ar.q(lrVar2);
                    if (!lhVar.b.H()) {
                        lhVar.v();
                    }
                    ls lsVar24 = (ls) lhVar.b;
                    lsVar24.u = lrVar2;
                    lsVar24.b |= 4194304;
                }
                ls lsVar25 = (ls) lhVar.t();
                if (lsVar25 != null) {
                    if (!liVar.b.H()) {
                        liVar.v();
                    }
                    lj ljVar6 = (lj) liVar.b;
                    bz bzVar2 = ljVar6.c;
                    if (!bzVar2.c()) {
                        ljVar6.c = bi.A(bzVar2);
                    }
                    ljVar6.c.add(lsVar25);
                }
                i++;
            }
        }
        ev evVar = bVar.f;
        int size = evVar.size();
        for (int i9 = 0; i9 < size; i9++) {
            cg cgVar = (cg) evVar.get(i9);
            kz kzVar = (kz) la.a.q();
            int iA2 = cgVar.a();
            if (!kzVar.b.H()) {
                kzVar.v();
            }
            la laVar = (la) kzVar.b;
            laVar.b |= 1;
            laVar.c = iA2;
            y yVar = (y) z.a.q();
            double d = cgVar.c().a;
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar = (z) yVar.b;
            zVar.b |= 1;
            zVar.c = d;
            double d2 = cgVar.c().b;
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar2 = (z) yVar.b;
            zVar2.b |= 2;
            zVar2.d = d2;
            if (!kzVar.b.H()) {
                kzVar.v();
            }
            la laVar2 = (la) kzVar.b;
            z zVar3 = (z) yVar.t();
            zVar3.getClass();
            laVar2.d = zVar3;
            laVar2.b |= 2;
            la laVar3 = (la) kzVar.t();
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar7 = (lj) liVar.b;
            laVar3.getClass();
            bz bzVar3 = ljVar7.i;
            if (!bzVar3.c()) {
                ljVar7.i = bi.A(bzVar3);
            }
            ljVar7.i.add(laVar3);
        }
        com.google.android.libraries.navigation.internal.acc.b bVar2 = bVar.g;
        if (bVar2 != null) {
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar8 = (lj) liVar.b;
            ljVar8.d = bVar2;
            ljVar8.b |= 1;
        }
        bm.a aVar = bVar.d;
        if (aVar != null) {
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar9 = (lj) liVar.b;
            ljVar9.h = aVar.e;
            ljVar9.b |= 8;
        }
        if (!liVar.b.H()) {
            liVar.v();
        }
        lj ljVar10 = (lj) liVar.b;
        ljVar10.b |= 128;
        ljVar10.j = false;
        boolean z4 = bVar.i;
        if (!liVar.b.H()) {
            liVar.v();
        }
        lj ljVar11 = (lj) liVar.b;
        ljVar11.b |= 8192;
        ljVar11.o = z4;
        if (!bVar.k) {
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar12 = (lj) liVar.b;
            ljVar12.b |= 1024;
            ljVar12.m = true;
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar13 = (lj) liVar.b;
            ljVar13.b |= 256;
            ljVar13.k = true;
        }
        if (mjVar != null) {
            if (!liVar.b.H()) {
                liVar.v();
            }
            lj ljVar14 = (lj) liVar.b;
            ljVar14.f319n = mjVar;
            ljVar14.b |= 4096;
        }
        lw lwVar = (lw) lz.a.q();
        if (!lwVar.b.H()) {
            lwVar.v();
        }
        lz lzVar = (lz) lwVar.b;
        lj ljVar15 = (lj) liVar.t();
        ljVar15.getClass();
        lzVar.c = ljVar15;
        lzVar.b |= 1;
        if (!lwVar.b.H()) {
            lwVar.v();
        }
        lz lzVar2 = (lz) lwVar.b;
        lzVar2.b |= 8;
        lzVar2.h = true;
        if (list != null) {
            if (!lwVar.b.H()) {
                lwVar.v();
            }
            lz lzVar3 = (lz) lwVar.b;
            bq bqVar = lzVar3.d;
            if (!bqVar.c()) {
                lzVar3.d = bi.w(bqVar);
            }
            no it2 = ((ev) list).iterator();
            while (it2.hasNext()) {
                lzVar3.d.i(((ku) it2.next()).t);
            }
        }
        com.google.android.libraries.navigation.internal.aes.h hVar5 = bVar.h;
        if (hVar5 != null) {
            if (!lwVar.b.H()) {
                lwVar.v();
            }
            lz lzVar4 = (lz) lwVar.b;
            lzVar4.f = hVar5;
            lzVar4.b |= 2;
        }
        if (!lwVar.b.H()) {
            lwVar.v();
        }
        lz lzVar5 = (lz) lwVar.b;
        lzVar5.b |= 4;
        lzVar5.g = true;
        al alVarA = bVar.a();
        if (alVarA == al.WALK || alVarA == al.BICYCLE) {
            lwVar.c(ly.a);
        } else if (alVarA == al.TRANSIT) {
            lwVar.c(ly.c);
            mh mhVar = bVar.a.g;
            if (mhVar == null) {
                mhVar = mh.a;
            }
            if (!mhVar.b) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 29)).p("TransitSummary deprecated fields not suppressed.");
            }
        }
        if (ltVar != null) {
            if (!lwVar.b.H()) {
                lwVar.v();
            }
            lz lzVar6 = (lz) lwVar.b;
            lzVar6.i = ltVar;
            lzVar6.b |= 32;
        }
        if (z) {
            if (!lwVar.b.H()) {
                lwVar.v();
            }
            lz lzVar7 = (lz) lwVar.b;
            lzVar7.b |= 64;
            lzVar7.j = true;
        }
        return (lz) lwVar.t();
    }
}
