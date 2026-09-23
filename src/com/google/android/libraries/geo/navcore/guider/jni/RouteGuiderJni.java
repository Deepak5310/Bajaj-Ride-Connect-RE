package com.google.android.libraries.geo.navcore.guider.jni;

import androidx.tracing.Trace;
import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.acj.ae;
import com.google.android.libraries.navigation.internal.acj.ah;
import com.google.android.libraries.navigation.internal.acj.aj;
import com.google.android.libraries.navigation.internal.acj.ak;
import com.google.android.libraries.navigation.internal.acj.am;
import com.google.android.libraries.navigation.internal.acj.ao;
import com.google.android.libraries.navigation.internal.acj.ap;
import com.google.android.libraries.navigation.internal.acj.at;
import com.google.android.libraries.navigation.internal.acj.au;
import com.google.android.libraries.navigation.internal.acj.av;
import com.google.android.libraries.navigation.internal.acj.aw;
import com.google.android.libraries.navigation.internal.acj.g;
import com.google.android.libraries.navigation.internal.acj.h;
import com.google.android.libraries.navigation.internal.acj.s;
import com.google.android.libraries.navigation.internal.adr.aa;
import com.google.android.libraries.navigation.internal.adr.ab;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.b;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.agg.ef;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.bp.cg;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.nw.d;
import com.google.android.libraries.navigation.internal.nw.e;
import com.google.android.libraries.navigation.internal.oe.ac;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteGuiderJni {
    public static final /* synthetic */ int b = 0;
    public long a;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    /* JADX WARN: Code duplicated, block: B:361:0x076a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x0757 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:395:? A[Catch: all -> 0x0761, SYNTHETIC, TRY_LEAVE, TryCatch #0 {all -> 0x0761, blocks: (B:335:0x0760, B:334:0x075d, B:282:0x0702, B:294:0x0718, B:293:0x0715, B:303:0x0728, B:302:0x0725, B:312:0x0738, B:311:0x0735, B:298:0x071f, B:245:0x061e, B:247:0x062e, B:248:0x0631, B:250:0x0646, B:251:0x0649, B:253:0x065e, B:254:0x0661, B:280:0x06fa, B:307:0x072f, B:289:0x070f, B:274:0x06e5, B:275:0x06ea, B:260:0x0688, B:262:0x06a0, B:263:0x06a3, B:265:0x06ba, B:267:0x06c2, B:268:0x06c5, B:270:0x06d1, B:271:0x06d7, B:272:0x06dc, B:330:0x0757), top: B:347:0x000d, inners: #2, #5, #6, #11, #12, #13, #15 }] */
    /* JADX WARN: Code duplicated, block: B:397:? A[SYNTHETIC] */
    public RouteGuiderJni(bg bgVar, r rVar, double d) throws Throwable {
        d dVar;
        Throwable th;
        d dVar2;
        Throwable th2;
        int i;
        int i2;
        ae aeVar;
        com.google.android.libraries.navigation.internal.pt.d dVarA;
        Iterator it2;
        int i3;
        RouteGuiderJni routeGuiderJni = this;
        d dVarB = e.b("RouteGuiderJni");
        try {
            try {
                d dVarB2 = e.b("RouteGuiderJni.serializeTripProto");
                try {
                    ap apVar = (ap) au.a.q();
                    long j = bgVar.Y;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar = (au) apVar.b;
                    auVar.b |= 32;
                    auVar.i = j;
                    String str = bgVar.Z;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar2 = (au) apVar.b;
                    str.getClass();
                    auVar2.b |= 64;
                    auVar2.j = str;
                    al alVar = bgVar.j;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar3 = (au) apVar.b;
                    auVar3.c = alVar.k;
                    int i4 = 1;
                    auVar3.b |= 1;
                    boolean z = bgVar.aa == 0;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar4 = (au) apVar.b;
                    auVar4.b |= 2;
                    auVar4.d = z;
                    boolean z2 = bgVar.m() == 2;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar5 = (au) apVar.b;
                    auVar5.b |= 32768;
                    auVar5.t = z2;
                    ad adVarC = bgVar.y().c();
                    final aa aaVar = (aa) ab.a.q();
                    adVarC.s(new ac() { // from class: com.google.android.libraries.navigation.internal.oe.z
                        @Override // com.google.android.libraries.navigation.internal.oe.ac
                        public final void a(int i5, int i6) {
                            com.google.android.libraries.navigation.internal.adr.aa aaVar2 = aaVar;
                            if (!aaVar2.b.H()) {
                                aaVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.adr.ab abVar = (com.google.android.libraries.navigation.internal.adr.ab) aaVar2.b;
                            com.google.android.libraries.navigation.internal.adr.ab abVar2 = com.google.android.libraries.navigation.internal.adr.ab.a;
                            bq bqVar = abVar.b;
                            if (!bqVar.c()) {
                                abVar.b = bi.w(bqVar);
                            }
                            abVar.b.i(i5);
                            if (!aaVar2.b.H()) {
                                aaVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.adr.ab abVar3 = (com.google.android.libraries.navigation.internal.adr.ab) aaVar2.b;
                            bq bqVar2 = abVar3.c;
                            if (!bqVar2.c()) {
                                abVar3.c = bi.w(bqVar2);
                            }
                            abVar3.c.i(i6);
                        }
                    });
                    ab abVar = (ab) aaVar.t();
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar6 = (au) apVar.b;
                    abVar.getClass();
                    auVar6.f = abVar;
                    auVar6.b |= 8;
                    int i5 = bgVar.o;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar7 = (au) apVar.b;
                    auVar7.b |= 4;
                    auVar7.e = i5;
                    com.google.android.libraries.navigation.internal.bp.bq[] bqVarArrAb = bgVar.ab();
                    al alVar2 = bgVar.j;
                    ArrayList arrayList = new ArrayList();
                    int length = bqVarArrAb.length;
                    int i6 = 0;
                    while (i6 < length) {
                        try {
                            com.google.android.libraries.navigation.internal.bp.bq bqVar = bqVarArrAb[i6];
                            com.google.android.libraries.navigation.internal.acj.al alVar3 = (com.google.android.libraries.navigation.internal.acj.al) am.a.q();
                            int i7 = bqVar.k;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar = (am) alVar3.b;
                            com.google.android.libraries.navigation.internal.bp.bq[] bqVarArr = bqVarArrAb;
                            amVar.b |= i4;
                            amVar.c = i7;
                            int i8 = bqVar.i;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar2 = (am) alVar3.b;
                            amVar2.b |= 2;
                            amVar2.d = i8;
                            int i9 = bqVar.l;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar3 = (am) alVar3.b;
                            amVar3.b |= 4;
                            amVar3.e = i9;
                            l lVar = bqVar.d;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar4 = (am) alVar3.b;
                            amVar4.g = lVar.F;
                            amVar4.b |= 8;
                            al alVar4 = alVar2;
                            int seconds = (int) bqVar.f355n.toSeconds();
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar5 = (am) alVar3.b;
                            amVar5.b |= 16;
                            amVar5.h = seconds;
                            hs hsVar = bqVar.e;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar6 = (am) alVar3.b;
                            amVar6.j = hsVar.d;
                            amVar6.b |= 64;
                            hu huVar = bqVar.f;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar7 = (am) alVar3.b;
                            amVar7.k = huVar.j;
                            amVar7.b |= 128;
                            List list = bqVar.A;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                bw bwVar = (bw) it3.next();
                                int iOrdinal = bwVar.a.ordinal();
                                if (iOrdinal != 0) {
                                    it2 = it3;
                                    if (iOrdinal == 1) {
                                        i3 = aj.b;
                                    } else {
                                        if (iOrdinal != 2) {
                                            if (iOrdinal != 3) {
                                                throw new IllegalStateException("Unexpected eventTypeEnum value: " + bwVar.a.e);
                                            }
                                            i3 = aj.d;
                                            dVar2 = dVarB2;
                                            th2 = th;
                                            if (dVar2 != null) {
                                                throw th2;
                                            }
                                            try {
                                                Trace.endSection();
                                                throw th2;
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                                throw th2;
                                            }
                                            th = th;
                                            if (dVar != null) {
                                                throw th;
                                            }
                                            try {
                                                Trace.endSection();
                                                throw th;
                                            } catch (Throwable th4) {
                                                th.addSuppressed(th4);
                                                throw th;
                                            }
                                        }
                                        i3 = aj.c;
                                    }
                                } else {
                                    it2 = it3;
                                    i3 = aj.a;
                                }
                                ah ahVar = (ah) ak.a.q();
                                int i10 = length;
                                int i11 = bwVar.d;
                                dVar = dVarB;
                                try {
                                    if (!ahVar.b.H()) {
                                        try {
                                            ahVar.v();
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                    ak akVar = (ak) ahVar.b;
                                    akVar.b |= 1;
                                    akVar.c = i11;
                                    dVar2 = dVarB2;
                                    try {
                                        int seconds2 = (int) bwVar.c.toSeconds();
                                        if (!ahVar.b.H()) {
                                            ahVar.v();
                                        }
                                        ak akVar2 = (ak) ahVar.b;
                                        akVar2.b |= 2;
                                        akVar2.d = seconds2;
                                        int i12 = bwVar.b;
                                        if (!ahVar.b.H()) {
                                            ahVar.v();
                                        }
                                        ak akVar3 = (ak) ahVar.b;
                                        akVar3.b |= 4;
                                        akVar3.e = i12;
                                        if (!ahVar.b.H()) {
                                            ahVar.v();
                                        }
                                        ak akVar4 = (ak) ahVar.b;
                                        int i13 = i3 - 1;
                                        if (i3 == 0) {
                                            throw null;
                                        }
                                        akVar4.f = i13;
                                        akVar4.b |= 8;
                                        boolean z3 = bwVar.e;
                                        if (!ahVar.b.H()) {
                                            ahVar.v();
                                        }
                                        ak akVar5 = (ak) ahVar.b;
                                        akVar5.b |= 16;
                                        akVar5.g = z3;
                                        arrayList2.add((ak) ahVar.t());
                                        routeGuiderJni = this;
                                        dVarB2 = dVar2;
                                        it3 = it2;
                                        length = i10;
                                        dVarB = dVar;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        th2 = th;
                                        if (dVar2 != null) {
                                            throw th2;
                                        }
                                        Trace.endSection();
                                        throw th2;
                                        th = th;
                                        if (dVar != null) {
                                            throw th;
                                        }
                                        Trace.endSection();
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    dVar2 = dVarB2;
                                    th2 = th;
                                    if (dVar2 != null) {
                                        throw th2;
                                    }
                                    Trace.endSection();
                                    throw th2;
                                    th = th;
                                    if (dVar != null) {
                                        throw th;
                                    }
                                    Trace.endSection();
                                    throw th;
                                }
                            }
                            d dVar3 = dVarB;
                            int i14 = length;
                            d dVar4 = dVarB2;
                            if (!alVar3.b.H()) {
                                alVar3.v();
                            }
                            am amVar8 = (am) alVar3.b;
                            bz bzVar = amVar8.f;
                            if (!bzVar.c()) {
                                amVar8.f = bi.A(bzVar);
                            }
                            b.m(arrayList2, amVar8.f);
                            if (com.google.android.libraries.navigation.internal.pt.e.a(alVar4) && (dVarA = com.google.android.libraries.navigation.internal.pt.d.a(bqVar.D)) != null) {
                                com.google.android.libraries.navigation.internal.aci.b bVarC = dVarA.c();
                                if (!alVar3.b.H()) {
                                    alVar3.v();
                                }
                                am amVar9 = (am) alVar3.b;
                                bVarC.getClass();
                                amVar9.i = bVarC;
                                amVar9.b |= 32;
                            }
                            arrayList.add((am) alVar3.t());
                            i6++;
                            routeGuiderJni = this;
                            dVarB2 = dVar4;
                            alVar2 = alVar4;
                            bqVarArrAb = bqVarArr;
                            length = i14;
                            dVarB = dVar3;
                            i4 = 1;
                        } catch (Throwable th8) {
                            th = th8;
                            dVar = dVarB;
                        }
                    }
                    dVar = dVarB;
                    dVar2 = dVarB2;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar8 = (au) apVar.b;
                    bz bzVar2 = auVar8.g;
                    if (!bzVar2.c()) {
                        auVar8.g = bi.A(bzVar2);
                    }
                    b.m(arrayList, auVar8.g);
                    boolean z4 = bgVar.k;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar9 = (au) apVar.b;
                    auVar9.b |= 16;
                    auVar9.h = z4;
                    ev<cg> evVar = bgVar.q;
                    ArrayList arrayList3 = new ArrayList();
                    for (cg cgVar : evVar) {
                        av avVar = (av) aw.a.q();
                        com.google.android.libraries.navigation.internal.afj.b bVarC2 = cgVar.c().c();
                        if (!avVar.b.H()) {
                            avVar.v();
                        }
                        aw awVar = (aw) avVar.b;
                        bVarC2.getClass();
                        awVar.c = bVarC2;
                        awVar.b |= 1;
                        int iB = cgVar.b();
                        if (!avVar.b.H()) {
                            avVar.v();
                        }
                        aw awVar2 = (aw) avVar.b;
                        awVar2.b |= 2;
                        awVar2.d = iB;
                        arrayList3.add((aw) avVar.t());
                    }
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar10 = (au) apVar.b;
                    bz bzVar3 = auVar10.l;
                    if (!bzVar3.c()) {
                        auVar10.l = bi.A(bzVar3);
                    }
                    b.m(arrayList3, auVar10.l);
                    boolean zW = bgVar.W();
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar11 = (au) apVar.b;
                    auVar11.b |= 256;
                    auVar11.m = zW;
                    int i15 = bgVar.P.l;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    au auVar12 = (au) apVar.b;
                    auVar12.b |= 16384;
                    auVar12.s = i15;
                    if (bgVar.t().n() == null) {
                        x xVar = bgVar.r(0).c;
                        ar.q(xVar);
                        com.google.android.libraries.navigation.internal.afj.a aVar = (com.google.android.libraries.navigation.internal.afj.a) com.google.android.libraries.navigation.internal.afj.b.a.q();
                        double dB = xVar.b();
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).b = dB;
                        double d2 = xVar.d();
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        ((com.google.android.libraries.navigation.internal.afj.b) aVar.b).c = d2;
                        com.google.android.libraries.navigation.internal.afj.b bVar = (com.google.android.libraries.navigation.internal.afj.b) aVar.t();
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        au auVar13 = (au) apVar.b;
                        bVar.getClass();
                        auVar13.f170n = bVar;
                        auVar13.b |= 512;
                    } else {
                        com.google.android.libraries.navigation.internal.oe.r rVarN = bgVar.t().n();
                        ar.q(rVarN);
                        com.google.android.libraries.navigation.internal.afj.b bVarC3 = rVarN.c();
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        au auVar14 = (au) apVar.b;
                        bVarC3.getClass();
                        auVar14.f170n = bVarC3;
                        auVar14.b |= 512;
                    }
                    ii iiVar = bgVar.u;
                    if (iiVar != null) {
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        au auVar15 = (au) apVar.b;
                        auVar15.k = iiVar;
                        auVar15.b |= 128;
                    }
                    int iA = lq.a(bgVar.P.m);
                    iA = iA == 0 ? lq.b : iA;
                    int i16 = iA - 1;
                    try {
                        if (iA == 0) {
                            throw null;
                        }
                        if (i16 == 0) {
                            i = at.a;
                        } else if (i16 == 1) {
                            i = at.b;
                        } else if (i16 == 2) {
                            i = at.c;
                        } else {
                            if (i16 != 3) {
                                int iA2 = lq.a(bgVar.P.m);
                                iA2 = iA2 == 0 ? lq.b : iA2;
                                int i17 = iA2 - 1;
                                if (iA2 == 0) {
                                    throw null;
                                }
                                throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(i17, "Unexpected tripOrderEnum value: "));
                            }
                            i = at.d;
                        }
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        au auVar16 = (au) apVar.b;
                        int i18 = i - 1;
                        if (i == 0) {
                            throw null;
                        }
                        auVar16.q = i18;
                        auVar16.b |= 4096;
                        int iOrdinal2 = bgVar.Q.ordinal();
                        if (iOrdinal2 == 0) {
                            i2 = com.google.android.libraries.navigation.internal.acj.ar.a;
                        } else if (iOrdinal2 == 1) {
                            i2 = com.google.android.libraries.navigation.internal.acj.ar.b;
                        } else {
                            if (iOrdinal2 != 2) {
                                throw new IllegalStateException("Unexpected value: ".concat(String.valueOf(String.valueOf(bgVar.Q))));
                            }
                            i2 = com.google.android.libraries.navigation.internal.acj.ar.c;
                        }
                        if (!apVar.b.H()) {
                            apVar.v();
                        }
                        au auVar17 = (au) apVar.b;
                        int i19 = i2 - 1;
                        if (i2 == 0) {
                            throw null;
                        }
                        auVar17.r = i19;
                        auVar17.b |= 8192;
                        if (com.google.android.libraries.navigation.internal.pt.e.a(bgVar.j)) {
                            com.google.android.libraries.navigation.internal.pt.d dVarO = bgVar.t().o();
                            if (dVarO == null) {
                                com.google.android.libraries.navigation.internal.bp.bq[] bqVarArr2 = bgVar.l;
                                dVarO = bqVarArr2.length == 0 ? null : com.google.android.libraries.navigation.internal.pt.d.a(bqVarArr2[0].D);
                            }
                            if (dVarO != null) {
                                com.google.android.libraries.navigation.internal.aci.b bVarC4 = dVarO.c();
                                if (!apVar.b.H()) {
                                    apVar.v();
                                }
                                au auVar18 = (au) apVar.b;
                                bVarC4.getClass();
                                auVar18.o = bVarC4;
                                auVar18.b |= 1024;
                            }
                            com.google.android.libraries.navigation.internal.pt.d dVarO2 = bgVar.u().o();
                            if (dVarO2 != null) {
                                com.google.android.libraries.navigation.internal.aci.b bVarC5 = dVarO2.c();
                                if (!apVar.b.H()) {
                                    apVar.v();
                                }
                                au auVar19 = (au) apVar.b;
                                bVarC5.getClass();
                                auVar19.p = bVarC5;
                                auVar19.b |= 2048;
                            }
                        }
                        byte[] bArrM = ((au) apVar.t()).m();
                        if (dVar2 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        }
                        d dVarB3 = e.b("RouteGuiderJni.serializeGuiderParamsProto");
                        try {
                            g gVar = (g) h.a.q();
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            h hVar = (h) gVar.b;
                            hVar.b |= 1;
                            hVar.c = false;
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            h hVar2 = (h) gVar.b;
                            hVar2.b |= 2;
                            hVar2.d = false;
                            if (!gVar.b.H()) {
                                gVar.v();
                            }
                            h hVar3 = (h) gVar.b;
                            hVar3.b |= 4;
                            hVar3.e = d;
                            byte[] bArrM2 = ((h) gVar.t()).m();
                            if (dVarB3 != null) {
                                Trace.endSection();
                            }
                            d dVarB4 = e.b("RouteGuiderJni.serializeRouteFromLocationProto");
                            if (rVar == null) {
                                aeVar = null;
                            } else {
                                try {
                                    com.google.android.libraries.navigation.internal.acj.ad adVar = (com.google.android.libraries.navigation.internal.acj.ad) ae.a.q();
                                    com.google.android.libraries.navigation.internal.afj.b bVarC6 = rVar.m().c();
                                    if (!adVar.b.H()) {
                                        adVar.v();
                                    }
                                    ae aeVar2 = (ae) adVar.b;
                                    bVarC6.getClass();
                                    aeVar2.c = bVarC6;
                                    aeVar2.b |= 1;
                                    ef efVar = rVar.l().C;
                                    if (efVar != null) {
                                        if (!adVar.b.H()) {
                                            adVar.v();
                                        }
                                        ae aeVar3 = (ae) adVar.b;
                                        bq bqVar2 = aeVar3.d;
                                        if (!bqVar2.c()) {
                                            aeVar3.d = bi.w(bqVar2);
                                        }
                                        b.m(efVar, aeVar3.d);
                                    }
                                    aeVar = (ae) adVar.t();
                                } catch (Throwable th10) {
                                    if (dVarB4 == null) {
                                        throw th10;
                                    }
                                    try {
                                        Trace.endSection();
                                        throw th10;
                                    } catch (Throwable th11) {
                                        th10.addSuppressed(th11);
                                        throw th10;
                                    }
                                    th = th;
                                    if (dVar != null) {
                                        throw th;
                                    }
                                    Trace.endSection();
                                    throw th;
                                }
                            }
                            byte[] bArrM3 = aeVar != null ? aeVar.m() : new byte[0];
                            if (dVarB4 != null) {
                                Trace.endSection();
                            }
                            d dVarB5 = e.b("RouteGuiderJni.nativeCreateGuider");
                            try {
                                this.a = nativeCreateGuider(bArrM, bArrM2, bArrM3);
                                if (dVarB5 != null) {
                                    Trace.endSection();
                                }
                                if (dVar != null) {
                                    Trace.endSection();
                                    return;
                                }
                                return;
                            } catch (Throwable th12) {
                                if (dVarB5 == null) {
                                    throw th12;
                                }
                                try {
                                    Trace.endSection();
                                    throw th12;
                                } catch (Throwable th13) {
                                    th12.addSuppressed(th13);
                                    throw th12;
                                }
                                th = th;
                                if (dVar != null) {
                                    throw th;
                                }
                                Trace.endSection();
                                throw th;
                            }
                        } catch (Throwable th14) {
                            if (dVarB3 == null) {
                                throw th14;
                            }
                            try {
                                Trace.endSection();
                                throw th14;
                            } catch (Throwable th15) {
                                th14.addSuppressed(th15);
                                throw th14;
                            }
                            th = th;
                            if (dVar != null) {
                                throw th;
                            }
                            Trace.endSection();
                            throw th;
                        }
                    } catch (Throwable th16) {
                        th = th16;
                        th2 = th;
                        if (dVar2 != null) {
                            throw th2;
                        }
                        Trace.endSection();
                        throw th2;
                        th = th;
                        if (dVar != null) {
                            throw th;
                        }
                        Trace.endSection();
                        throw th;
                    }
                } catch (Throwable th17) {
                    th = th17;
                    dVar = dVarB;
                }
            } catch (Throwable th18) {
                th = th18;
            }
        } catch (Throwable th19) {
            th = th19;
            dVar = dVarB;
        }
        th = th;
        if (dVar != null) {
            throw th;
        }
        Trace.endSection();
        throw th;
    }

    public static s a(byte[] bArr) {
        try {
            bi biVarV = bi.v(s.a, bArr, 0, bArr.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            bi.I(biVarV);
            return (s) biVarV;
        } catch (cc e) {
            throw new IllegalArgumentException(e);
        }
    }

    private native byte[] nativeBuildTripGuidanceState(long j);

    private native void nativeClearTrafficData(long j);

    private native long nativeCreateGuider(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private native void nativeDeleteGuider(long j);

    private native double nativeGetSecondsToFinalDestination(long j);

    private static native boolean nativeInitClass();

    public static native byte[] nativeOnLocationChanged(long[] jArr, int i, byte[] bArr, boolean z);

    private native void nativeUpdateTrafficData(long j, byte[] bArr, int i, int i2);

    public final ao b() {
        c();
        byte[] bArrNativeBuildTripGuidanceState = nativeBuildTripGuidanceState(this.a);
        try {
            bi biVarV = bi.v(ao.a, bArrNativeBuildTripGuidanceState, 0, bArrNativeBuildTripGuidanceState.length, com.google.android.libraries.navigation.internal.ael.ar.b());
            bi.I(biVarV);
            return (ao) biVarV;
        } catch (cc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final void c() {
        if (this.a == 0) {
            throw new IllegalStateException("Guider is not initialized.");
        }
    }

    public final synchronized void d() {
        long j = this.a;
        if (j != 0) {
            nativeDeleteGuider(j);
            this.a = 0L;
        }
    }

    public final void e(ii iiVar, int i, int i2) {
        c();
        if (iiVar != null) {
            nativeUpdateTrafficData(this.a, iiVar.m(), i, i2);
        } else {
            nativeClearTrafficData(this.a);
        }
    }

    public final void finalize() {
        d();
    }

    public native boolean nativeIsOnRouteWithConfidenceThreshold(long j, double d, double d2);

    public native byte[] nativeResumeGeneratingGuidanceEvents(long j);
}
