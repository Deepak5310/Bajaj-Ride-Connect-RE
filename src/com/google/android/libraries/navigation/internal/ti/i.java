package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.zs.bh;
import com.google.android.libraries.navigation.internal.zs.bi;
import com.google.android.libraries.navigation.internal.zs.bj;
import com.google.android.libraries.navigation.internal.zs.co;
import com.google.android.libraries.navigation.internal.zs.cp;
import com.google.android.libraries.navigation.internal.zs.cr;
import com.google.android.libraries.navigation.internal.zs.fh;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    public final ad a;
    public int e;
    public int f;
    private final af i;
    private final af j;
    private final e k;
    public int g = Integer.MIN_VALUE;
    public long h = -1;
    public final Map b = new EnumMap(cr.class);
    public final Map c = new EnumMap(cr.class);
    public List d = new ArrayList();

    public i(com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, ad adVar, af afVar, af afVar2, e eVar2) {
        this.a = adVar;
        this.i = afVar;
        this.j = afVar2;
        this.k = eVar2;
        fd fdVarK = fd.k(ap.NAVIGATION_INTERNAL, executor);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.dh.g.class, new j(com.google.android.libraries.navigation.internal.dh.g.class, this, ap.NAVIGATION_INTERNAL, j.b(ap.NAVIGATION_INTERNAL, fdVarK)));
        eVar.c(this, fzVar.a());
    }

    private static boolean c(cr crVar) {
        int iOrdinal = crVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            return false;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return true;
        }
        throw new RuntimeException();
    }

    public final cp a(cr crVar, boolean z, long j, com.google.android.libraries.navigation.internal.db.r rVar) {
        co coVar = (co) cp.a.q();
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar = (cp) coVar.b;
        cpVar.b |= 2;
        cpVar.d = z;
        ed edVarB = com.google.android.libraries.navigation.internal.aen.d.b(j);
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar2 = (cp) coVar.b;
        edVarB.getClass();
        cpVar2.e = edVarB;
        cpVar2.b |= 4;
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar3 = (cp) coVar.b;
        cpVar3.c = crVar.f;
        cpVar3.b |= 1;
        com.google.android.libraries.navigation.internal.afj.a aVar = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
        double d = rVar.b;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).b = d;
        double d2 = rVar.c;
        if (!aVar.b.H()) {
            aVar.v();
        }
        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).c = d2;
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar4 = (cp) coVar.b;
        com.google.android.libraries.navigation.internal.afj.b bVar = (com.google.android.libraries.navigation.internal.afj.b) aVar.t();
        bVar.getClass();
        cpVar4.f = bVar;
        cpVar4.b |= 8;
        if (rVar.r()) {
            float f = rVar.d;
            if (f > 0.0f) {
                int iRound = Math.round(f * 10.0f);
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar5 = (cp) coVar.b;
                cpVar5.b |= 32;
                cpVar5.h = iRound;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar6 = (cp) coVar.b;
                cpVar6.b |= 64;
                cpVar6.i = 68;
            }
        }
        al alVar = this.k.h;
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar7 = (cp) coVar.b;
        cpVar7.j = alVar.k;
        cpVar7.b |= 128;
        if (rVar.t() && (c(crVar) || (rVar.x() && rVar.f >= 3.0f))) {
            int iRound2 = Math.round(rVar.f());
            if (!coVar.b.H()) {
                coVar.v();
            }
            cp cpVar8 = (cp) coVar.b;
            cpVar8.b |= 512;
            cpVar8.l = iRound2;
        }
        if (rVar.x()) {
            int iRound3 = Math.round(rVar.f * 10.0f);
            if (!coVar.b.H()) {
                coVar.v();
            }
            cp cpVar9 = (cp) coVar.b;
            cpVar9.b |= 1024;
            cpVar9.m = iRound3;
        }
        if (rVar.s()) {
            int iRound4 = (int) Math.round(rVar.e);
            if (!coVar.b.H()) {
                coVar.v();
            }
            cp cpVar10 = (cp) coVar.b;
            cpVar10.b |= 2048;
            cpVar10.f674n = iRound4;
        }
        if (this.h != -1 && com.google.android.libraries.navigation.internal.ja.a.a(rVar.g) - this.h < 1500) {
            int i = this.g;
            if (!coVar.b.H()) {
                coVar.v();
            }
            cp cpVar11 = (cp) coVar.b;
            cpVar11.b |= 8192;
            cpVar11.p = i;
        }
        int i2 = this.j.a;
        if (!coVar.b.H()) {
            coVar.v();
        }
        cp cpVar12 = (cp) coVar.b;
        cpVar12.b |= 32768;
        cpVar12.q = i2;
        if (c(crVar)) {
            boolean zD = rVar.l().d();
            if (!coVar.b.H()) {
                coVar.v();
            }
            cp cpVar13 = (cp) coVar.b;
            cpVar13.b |= 256;
            cpVar13.k = zD;
            long j2 = rVar.l().s;
            if (j2 != -1) {
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar14 = (cp) coVar.b;
                cpVar14.b |= 16;
                cpVar14.g = j2;
            }
        }
        return (cp) coVar.t();
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0268  */
    /* JADX WARN: Code duplicated, block: B:124:0x0270  */
    /* JADX WARN: Code duplicated, block: B:127:0x0288  */
    /* JADX WARN: Code duplicated, block: B:205:0x041e  */
    /* JADX WARN: Code duplicated, block: B:207:0x0426  */
    /* JADX WARN: Code duplicated, block: B:210:0x043f  */
    /* JADX WARN: Code duplicated, block: B:387:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:389:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:393:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:398:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:400:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:403:0x07f9  */
    /* JADX WARN: Code duplicated, block: B:407:0x081f  */
    /* JADX WARN: Code duplicated, block: B:410:0x0826  */
    /* JADX WARN: Code duplicated, block: B:412:0x0832  */
    /* JADX WARN: Code duplicated, block: B:415:0x083c  */
    /* JADX WARN: Code duplicated, block: B:417:0x0842  */
    /* JADX WARN: Code duplicated, block: B:420:0x084f  */
    public final void b(cp cpVar) {
        long j;
        int i;
        boolean z;
        fh fhVarA;
        int i2;
        bj bjVar;
        int iO;
        int iO2;
        cr crVarB = cr.b(cpVar.c);
        if (crVarB == null) {
            crVarB = cr.UNKNOWN;
        }
        bi biVar = (bi) bj.a.q();
        ae aeVar = (ae) this.b.get(crVarB);
        if (aeVar == null) {
            ae aeVar2 = new ae(this.a, this.k, this.i);
            this.b.put(crVarB, aeVar2);
            aeVar = aeVar2;
        }
        Map map = this.c;
        cr crVarB2 = cr.b(cpVar.c);
        if (crVarB2 == null) {
            crVarB2 = cr.UNKNOWN;
        }
        bi biVar2 = (bi) map.get(crVarB2);
        boolean z2 = biVar2 == null;
        if (biVar2 == null) {
            biVar2 = (bi) bj.a.q();
            Map map2 = this.c;
            cr crVarB3 = cr.b(cpVar.c);
            if (crVarB3 == null) {
                crVarB3 = cr.UNKNOWN;
            }
            map2.put(crVarB3, biVar2);
        }
        boolean zC = c(crVarB);
        ar.k(1 == (cpVar.b & 1));
        if (!biVar.b.H()) {
            biVar.v();
        }
        bj bjVar2 = (bj) biVar.b;
        bjVar2.c = crVarB.f;
        bjVar2.b |= 1;
        if (!biVar2.b.H()) {
            biVar2.v();
        }
        bj bjVar3 = (bj) biVar2.b;
        bjVar3.c = crVarB.f;
        bjVar3.b |= 1;
        ar.k((cpVar.b & 2) != 0);
        boolean z3 = cpVar.d;
        if (z2 || z3 != ((bj) biVar2.b).d) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar4 = (bj) biVar.b;
            bjVar4.b |= 2;
            bjVar4.d = z3;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar5 = (bj) biVar2.b;
            bjVar5.b |= 2;
            bjVar5.d = z3;
        }
        ar.k((cpVar.b & 4) != 0);
        ed edVar = cpVar.e;
        if (edVar == null) {
            edVar = ed.a;
        }
        long jA = com.google.android.libraries.navigation.internal.aen.d.a(edVar);
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar6 = (bj) biVar.b;
            bjVar6.b |= 4;
            bjVar6.e = jA;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar7 = (bj) biVar2.b;
            bjVar7.b |= 4;
            bjVar7.e = jA;
        } else {
            long j2 = jA - ((bj) biVar2.b).e;
            if (j2 < 0) {
                return;
            }
            if (j2 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar8 = (bj) biVar.b;
                bjVar8.b |= 4;
                bjVar8.e = j2;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar9 = (bj) biVar2.b;
                bjVar9.b |= 4;
                bjVar9.e = jA;
            }
        }
        ar.k((cpVar.b & 8) != 0);
        com.google.android.libraries.navigation.internal.afj.b bVar = cpVar.f;
        if (bVar == null) {
            bVar = com.google.android.libraries.navigation.internal.afj.b.a;
        }
        int iRound = (int) Math.round(bVar.b * 1.0E7d);
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar10 = (bj) biVar.b;
            bjVar10.b |= 8;
            bjVar10.f = iRound;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar11 = (bj) biVar2.b;
            bjVar11.b |= 8;
            bjVar11.f = iRound;
        } else {
            int i3 = iRound - ((bj) biVar2.b).f;
            if (i3 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar12 = (bj) biVar.b;
                bjVar12.b |= 8;
                bjVar12.f = i3;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar13 = (bj) biVar2.b;
                bjVar13.b |= 8;
                bjVar13.f = iRound;
            }
        }
        ar.k((cpVar.b & 8) != 0);
        com.google.android.libraries.navigation.internal.afj.b bVar2 = cpVar.f;
        if (bVar2 == null) {
            bVar2 = com.google.android.libraries.navigation.internal.afj.b.a;
        }
        int iRound2 = (int) Math.round(bVar2.c * 1.0E7d);
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar14 = (bj) biVar.b;
            bjVar14.b |= 16;
            bjVar14.g = iRound2;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar15 = (bj) biVar2.b;
            bjVar15.b |= 16;
            bjVar15.g = iRound2;
        } else {
            long j3 = ((long) iRound2) - ((long) ((bj) biVar2.b).g);
            if (j3 > 1800000000) {
                j = -3600000000L;
            } else if (j3 <= -1800000000) {
                j = 3600000000L;
            } else if (j3 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                int i4 = (int) j3;
                bj bjVar16 = (bj) biVar.b;
                bjVar16.b |= 16;
                bjVar16.g = i4;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar17 = (bj) biVar2.b;
                bjVar17.b |= 16;
                bjVar17.g = iRound2;
            }
            j3 += j;
            if (j3 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                int i5 = (int) j3;
                bj bjVar18 = (bj) biVar.b;
                bjVar18.b |= 16;
                bjVar18.g = i5;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar19 = (bj) biVar2.b;
                bjVar19.b |= 16;
                bjVar19.g = iRound2;
            }
        }
        if (zC) {
            long j4 = (cpVar.b & 16) != 0 ? cpVar.g : -1L;
            if (z2) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar20 = (bj) biVar.b;
                bjVar20.b |= 32;
                bjVar20.h = j4;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar21 = (bj) biVar2.b;
                bjVar21.b |= 32;
                bjVar21.h = j4;
            } else {
                long j5 = j4 - ((bj) biVar2.b).h;
                if (j5 != 0) {
                    if (!biVar.b.H()) {
                        biVar.v();
                    }
                    bj bjVar22 = (bj) biVar.b;
                    bjVar22.b |= 32;
                    bjVar22.h = j5;
                    if (!biVar2.b.H()) {
                        biVar2.v();
                    }
                    bj bjVar23 = (bj) biVar2.b;
                    bjVar23.b |= 32;
                    bjVar23.h = j4;
                }
            }
        }
        int i6 = (cpVar.b & 32) != 0 ? cpVar.h : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar24 = (bj) biVar.b;
            bjVar24.b |= 64;
            bjVar24.i = i6;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar25 = (bj) biVar2.b;
            bjVar25.b |= 64;
            bjVar25.i = i6;
        } else {
            int i7 = i6 - ((bj) biVar2.b).i;
            if (i7 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar26 = (bj) biVar.b;
                bjVar26.b |= 64;
                bjVar26.i = i7;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar27 = (bj) biVar2.b;
                bjVar27.b |= 64;
                bjVar27.i = i6;
            }
        }
        int i8 = (cpVar.b & 64) != 0 ? cpVar.i : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar28 = (bj) biVar.b;
            bjVar28.b |= 128;
            bjVar28.j = i8;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar29 = (bj) biVar2.b;
            bjVar29.b |= 128;
            bjVar29.j = i8;
        } else {
            int i9 = i8 - ((bj) biVar2.b).j;
            if (i9 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar30 = (bj) biVar.b;
                bjVar30.b |= 128;
                bjVar30.j = i9;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar31 = (bj) biVar2.b;
                bjVar31.b |= 128;
                bjVar31.j = i8;
            }
        }
        ar.k((cpVar.b & 128) != 0);
        al alVarB = al.b(cpVar.j);
        if (alVarB == null) {
            alVarB = al.DRIVE;
        }
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar32 = (bj) biVar.b;
            bjVar32.k = alVarB.k;
            bjVar32.b |= 256;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar33 = (bj) biVar2.b;
            bjVar33.k = alVarB.k;
            bjVar33.b |= 256;
        } else {
            al alVarB2 = al.b(((bj) biVar2.b).k);
            if (alVarB2 == null) {
                alVarB2 = al.DRIVE;
            }
            if (alVarB != alVarB2) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar34 = (bj) biVar.b;
                bjVar34.k = alVarB.k;
                bjVar34.b |= 256;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar35 = (bj) biVar2.b;
                bjVar35.k = alVarB.k;
                bjVar35.b |= 256;
            }
        }
        if (zC) {
            ar.k((cpVar.b & 256) != 0);
            boolean z4 = cpVar.k;
            if (z2 || z4 != ((bj) biVar2.b).l) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar36 = (bj) biVar.b;
                bjVar36.b |= 512;
                bjVar36.l = z4;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar37 = (bj) biVar2.b;
                bjVar37.b |= 512;
                bjVar37.l = z4;
            }
        } else {
            ar.k(!((cpVar.b & 256) != 0));
        }
        int i10 = (cpVar.b & 512) != 0 ? cpVar.l : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar38 = (bj) biVar.b;
            bjVar38.b |= 1024;
            bjVar38.m = i10;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar39 = (bj) biVar2.b;
            bjVar39.b |= 1024;
            bjVar39.m = i10;
        } else {
            int i11 = i10 - ((bj) biVar2.b).m;
            if (i11 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar40 = (bj) biVar.b;
                bjVar40.b |= 1024;
                bjVar40.m = i11;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar41 = (bj) biVar2.b;
                bjVar41.b |= 1024;
                bjVar41.m = i10;
            }
        }
        int i12 = (cpVar.b & 1024) != 0 ? cpVar.m : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar42 = (bj) biVar.b;
            bjVar42.b |= 2048;
            bjVar42.f673n = i12;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar43 = (bj) biVar2.b;
            bjVar43.b |= 2048;
            bjVar43.f673n = i12;
        } else {
            int i13 = i12 - ((bj) biVar2.b).f673n;
            if (i13 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar44 = (bj) biVar.b;
                bjVar44.b |= 2048;
                bjVar44.f673n = i13;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar45 = (bj) biVar2.b;
                bjVar45.b |= 2048;
                bjVar45.f673n = i12;
            }
        }
        int i14 = cpVar.f674n;
        if (i14 > 0) {
            i = bh.b;
        } else {
            i = i14 < 0 ? bh.c : bh.a;
        }
        int iAbs = (cpVar.b & 2048) != 0 ? Math.abs(cpVar.f674n) : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar46 = (bj) biVar.b;
            int i15 = i - 1;
            if (i == 0) {
                throw null;
            }
            bjVar46.o = i15;
            bjVar46.b |= 4096;
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar47 = (bj) biVar.b;
            bjVar47.b |= 8192;
            bjVar47.p = iAbs;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar48 = (bj) biVar2.b;
            if (i == 0) {
                throw null;
            }
            bjVar48.o = i15;
            bjVar48.b |= 4096;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar49 = (bj) biVar2.b;
            bjVar49.b |= 8192;
            bjVar49.p = iAbs;
        } else {
            int iA = bh.a(((bj) biVar2.b).o);
            if (iA == 0) {
                iA = bh.a;
            }
            if (i != iA) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar50 = (bj) biVar.b;
                int i16 = i - 1;
                if (i == 0) {
                    throw null;
                }
                bjVar50.o = i16;
                bjVar50.b |= 4096;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar51 = (bj) biVar2.b;
                if (i == 0) {
                    throw null;
                }
                bjVar51.o = i16;
                bjVar51.b |= 4096;
            }
            int i17 = iAbs - ((bj) biVar2.b).p;
            if (i17 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar52 = (bj) biVar.b;
                bjVar52.b |= 8192;
                bjVar52.p = i17;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar53 = (bj) biVar2.b;
                bjVar53.b |= 8192;
                bjVar53.p = iAbs;
            }
        }
        int i18 = (cpVar.b & 4096) != 0 ? cpVar.o : -1;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar54 = (bj) biVar.b;
            bjVar54.b |= 16384;
            bjVar54.q = i18;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar55 = (bj) biVar2.b;
            bjVar55.b |= 16384;
            bjVar55.q = i18;
        } else {
            int i19 = i18 - ((bj) biVar2.b).q;
            if (i19 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar56 = (bj) biVar.b;
                bjVar56.b |= 16384;
                bjVar56.q = i19;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar57 = (bj) biVar2.b;
                bjVar57.b |= 16384;
                bjVar57.q = i18;
            }
        }
        if ((cpVar.b & 8192) == 0) {
            if (z2 || (((bj) biVar2.b).b & 32768) != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar58 = (bj) biVar.b;
                bjVar58.b |= 32768;
                bjVar58.r = Integer.MIN_VALUE;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar59 = (bj) biVar2.b;
                bjVar59.b &= -32769;
                z = false;
                bjVar59.r = 0;
            }
            fhVarA = aeVar.a(null, null);
            if (fhVarA != null) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar60 = (bj) biVar.b;
                bjVar60.s = fhVarA;
                bjVar60.b |= 65536;
            }
            if ((cpVar.b & 32768) != 0) {
                z = true;
            }
            ar.k(z);
            i2 = cpVar.q;
            if (z2 || i2 != ((bj) biVar2.b).t) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar61 = (bj) biVar.b;
                bjVar61.b |= 131072;
                bjVar61.t = i2;
                if (!biVar2.b.H()) {
                    biVar2.v();
                }
                bj bjVar62 = (bj) biVar2.b;
                bjVar62.b |= 131072;
                bjVar62.t = i2;
            }
            bjVar = (bj) biVar.t();
            this.d.add(bjVar);
            this.e++;
            if (bjVar.H()) {
                iO2 = bjVar.o(null);
                if (iO2 < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
                }
            } else {
                iO = bjVar.am & Integer.MAX_VALUE;
                if (iO == Integer.MAX_VALUE) {
                    iO = bjVar.o(null);
                    if (iO >= 0) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
                    }
                    bjVar.am = (bjVar.am & Integer.MIN_VALUE) | iO;
                }
                iO2 = iO;
            }
            this.f += iO2;
        }
        if (z2) {
            int i20 = cpVar.p;
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar63 = (bj) biVar.b;
            bjVar63.b |= 32768;
            bjVar63.r = i20;
        } else {
            bj bjVar64 = (bj) biVar2.b;
            int i21 = cpVar.p - ((bjVar64.b & 32768) != 0 ? bjVar64.r : 0);
            if (i21 != 0) {
                if (!biVar.b.H()) {
                    biVar.v();
                }
                bj bjVar65 = (bj) biVar.b;
                bjVar65.b |= 32768;
                bjVar65.r = i21;
            }
        }
        int i22 = cpVar.p;
        if (!biVar2.b.H()) {
            biVar2.v();
        }
        bj bjVar66 = (bj) biVar2.b;
        bjVar66.b |= 32768;
        bjVar66.r = i22;
        z = false;
        fhVarA = aeVar.a(null, null);
        if (fhVarA != null) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar67 = (bj) biVar.b;
            bjVar67.s = fhVarA;
            bjVar67.b |= 65536;
        }
        if ((cpVar.b & 32768) != 0) {
            z = true;
        }
        ar.k(z);
        i2 = cpVar.q;
        if (z2) {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar68 = (bj) biVar.b;
            bjVar68.b |= 131072;
            bjVar68.t = i2;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar69 = (bj) biVar2.b;
            bjVar69.b |= 131072;
            bjVar69.t = i2;
        } else {
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar610 = (bj) biVar.b;
            bjVar610.b |= 131072;
            bjVar610.t = i2;
            if (!biVar2.b.H()) {
                biVar2.v();
            }
            bj bjVar611 = (bj) biVar2.b;
            bjVar611.b |= 131072;
            bjVar611.t = i2;
        }
        bjVar = (bj) biVar.t();
        this.d.add(bjVar);
        this.e++;
        if (bjVar.H()) {
            iO2 = bjVar.o(null);
            if (iO2 < 0) {
                throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
            }
        } else {
            iO = bjVar.am & Integer.MAX_VALUE;
            if (iO == Integer.MAX_VALUE) {
                iO = bjVar.o(null);
                if (iO >= 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
                }
                bjVar.am = (bjVar.am & Integer.MIN_VALUE) | iO;
            }
            iO2 = iO;
        }
        this.f += iO2;
    }
}
