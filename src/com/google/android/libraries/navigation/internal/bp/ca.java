package com.google.android.libraries.navigation.internal.bp;

import android.content.res.Resources;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.dh;
import com.google.android.libraries.navigation.internal.adr.dj;
import com.google.android.libraries.navigation.internal.adr.dl;
import com.google.android.libraries.navigation.internal.adr.dm;
import com.google.android.libraries.navigation.internal.adr.dr;
import com.google.android.libraries.navigation.internal.adr.ds;
import com.google.android.libraries.navigation.internal.adr.dv;
import com.google.android.libraries.navigation.internal.adr.dw;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.en;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.fv;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.adr.gy;
import com.google.android.libraries.navigation.internal.adr.hb;
import com.google.android.libraries.navigation.internal.adr.hd;
import com.google.android.libraries.navigation.internal.adr.he;
import com.google.android.libraries.navigation.internal.adr.hq;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lo;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ca {
    private static final fy b = fy.u(com.google.android.libraries.navigation.internal.aap.l.DEPART, com.google.android.libraries.navigation.internal.aap.l.TURN, com.google.android.libraries.navigation.internal.aap.l.NAME_CHANGE, com.google.android.libraries.navigation.internal.aap.l.STRAIGHT, com.google.android.libraries.navigation.internal.aap.l.UTURN, com.google.android.libraries.navigation.internal.aap.l.FORK, com.google.android.libraries.navigation.internal.aap.l.MERGE, com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_EXIT, com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT);
    private static final fy c = fy.q(com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME, com.google.android.libraries.navigation.internal.adr.bg.TYPE_FOLLOW_ROAD_NAME);
    public static final Duration a = Duration.ofSeconds(60);
    private static final com.google.android.libraries.navigation.internal.oe.x d = com.google.android.libraries.navigation.internal.oe.x.A(0.0d, 0.0d);

    /* JADX WARN: Code duplicated, block: B:152:0x0252  */
    /* JADX WARN: Code duplicated, block: B:319:0x0255 A[SYNTHETIC] */
    public static bp a(hv hvVar, int i, com.google.android.libraries.navigation.internal.oe.x xVar, ck ckVar) {
        String strV;
        int i2;
        Duration durationA;
        String str;
        String str2;
        hs hsVar;
        boolean z;
        com.google.android.libraries.navigation.internal.adq.h hVar;
        boolean z2;
        en enVarB;
        String strG;
        com.google.android.libraries.navigation.internal.ael.bz bzVar;
        l lVar;
        ArrayList arrayList;
        Duration duration;
        ar arVar;
        int size;
        at atVar;
        bw bwVar;
        if ((hvVar.b & 2) != 0) {
            Cif cif = hvVar.d;
            if (cif == null) {
                cif = Cif.a;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < cif.m.size(); i3++) {
                gn gnVar = (gn) cif.m.get(i3);
                if ((gnVar.b & 2) != 0) {
                    com.google.android.libraries.navigation.internal.adr.aj ajVar = gnVar.d;
                    if (ajVar == null) {
                        ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
                    }
                    sb.append(ajVar.c);
                }
            }
            strV = sb.toString();
        } else {
            strV = "";
        }
        int i4 = (hvVar.b & 8192) != 0 ? hvVar.s : 0;
        Cif cif2 = hvVar.d;
        if (cif2 == null) {
            cif2 = Cif.a;
        }
        com.google.android.libraries.navigation.internal.adr.bm bmVar = cif2.e;
        if (bmVar == null) {
            bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
        }
        if ((bmVar.b & 1) != 0) {
            Cif cif3 = hvVar.d;
            if (cif3 == null) {
                cif3 = Cif.a;
            }
            com.google.android.libraries.navigation.internal.adr.bm bmVar2 = cif3.e;
            if (bmVar2 == null) {
                bmVar2 = com.google.android.libraries.navigation.internal.adr.bm.a;
            }
            i2 = bmVar2.c;
        } else {
            i2 = 0;
        }
        Cif cif4 = hvVar.d;
        if (cif4 == null) {
            cif4 = Cif.a;
        }
        com.google.android.libraries.navigation.internal.aap.d dVar = cif4.f;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        if ((dVar.b & 1) != 0) {
            Cif cif5 = hvVar.d;
            if (cif5 == null) {
                cif5 = Cif.a;
            }
            com.google.android.libraries.navigation.internal.aap.d dVar2 = cif5.f;
            if (dVar2 == null) {
                dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
            }
            durationA = com.google.android.libraries.navigation.internal.bw.a.a(dVar2);
        } else {
            durationA = Duration.ZERO;
        }
        com.google.android.libraries.navigation.internal.aap.l lVarB = com.google.android.libraries.navigation.internal.aap.l.b(hvVar.i);
        if (lVarB == null) {
            lVarB = com.google.android.libraries.navigation.internal.aap.l.MANEUVER_UNKNOWN;
        }
        hs hsVarB = hs.b(hvVar.k);
        if (hsVarB == null) {
            hsVarB = hs.SIDE_UNSPECIFIED;
        }
        hu huVarB = hu.b(hvVar.j);
        if (huVarB == null) {
            huVarB = hu.TURN_UNKNOWN;
        }
        com.google.android.libraries.navigation.internal.aap.l lVar2 = com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT;
        com.google.android.libraries.navigation.internal.aap.l lVarB2 = com.google.android.libraries.navigation.internal.aap.l.b(hvVar.i);
        if (lVarB2 == null) {
            lVarB2 = com.google.android.libraries.navigation.internal.aap.l.MANEUVER_UNKNOWN;
        }
        int i5 = -1;
        int i6 = (lVar2 != lVarB2 || (hvVar.b & 2048) == 0) ? -1 : hvVar.f225n;
        com.google.android.libraries.navigation.internal.aap.l lVar3 = com.google.android.libraries.navigation.internal.aap.l.ROUNDABOUT_ENTER_AND_EXIT;
        com.google.android.libraries.navigation.internal.aap.l lVarB3 = com.google.android.libraries.navigation.internal.aap.l.b(hvVar.i);
        if (lVarB3 == null) {
            lVarB3 = com.google.android.libraries.navigation.internal.aap.l.MANEUVER_UNKNOWN;
        }
        if (lVar3 == lVarB3 && (hvVar.b & 1024) != 0) {
            i5 = hvVar.m;
        }
        Cif cif6 = hvVar.d;
        if (cif6 == null) {
            cif6 = Cif.a;
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar2 = cif6.h;
        en enVarB2 = en.b(hvVar.w);
        if (enVarB2 == null) {
            enVarB2 = en.NONE;
        }
        Cif cif7 = hvVar.d;
        if (cif7 == null) {
            cif7 = Cif.a;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar2 = xVar == null ? d : xVar;
        if ((hvVar.b & 8) != 0) {
            hq hqVar = hvVar.f;
            if (hqVar == null) {
                hqVar = hq.a;
            }
            str = hqVar.c ? "" : hqVar.d;
        } else {
            str = null;
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar3 = hvVar.r;
        hs hsVar2 = hsVarB;
        ArrayList arrayList2 = new ArrayList(bzVar3.size());
        Iterator it2 = bzVar3.iterator();
        int i7 = i;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            dm dmVar = (dm) it2.next();
            en enVar = enVarB2;
            if ((dmVar.b & 1) != 0) {
                bv bvVar = new bv();
                dh dhVarB = dh.b(dmVar.c);
                if (dhVarB == null) {
                    dhVarB = dh.PREPARE;
                }
                bvVar.a = dhVarB;
                bvVar.b = dmVar.d;
                bvVar.c = Duration.ofSeconds(dmVar.e);
                bvVar.d = dmVar.f;
                bvVar.e = dmVar.g;
                bvVar.f = i7;
                bvVar.g = (dmVar.b & 32) != 0 ? dmVar.h : null;
                for (final dl dlVar : dmVar.i) {
                    com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.bp.bu
                        @Override // com.google.android.libraries.navigation.internal.yx.br
                        public final Object a() {
                            final dl dlVar2 = dlVar;
                            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("StepGuidanceWithDistance.fromProtoLite()");
                            try {
                                int i8 = dlVar2.b;
                                r rVar = null;
                                if ((i8 & 2) != 0 && (i8 & 1) != 0 && (i8 & 4) != 0) {
                                    q qVar = new q();
                                    qVar.b(0);
                                    qVar.a(0);
                                    qVar.c(false);
                                    qVar.d(false);
                                    qVar.e = null;
                                    qVar.e = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.bp.bx
                                        @Override // com.google.android.libraries.navigation.internal.yx.br
                                        public final Object a() {
                                            ab abVar;
                                            dj djVar = dlVar2.e;
                                            if (djVar == null) {
                                                djVar = dj.a;
                                            }
                                            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("SpokenText.fromProtoLite()");
                                            try {
                                                bn bnVar = null;
                                                bnVar = null;
                                                if ((djVar.b & 1) != 0) {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    Iterator it4 = djVar.c.iterator();
                                                    while (true) {
                                                        if (!it4.hasNext()) {
                                                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("CannedMessage.fixupCannedMessageList()");
                                                            int i9 = 0;
                                                            for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                                                                try {
                                                                    int i11 = ((ab) arrayList3.get(i10)).a;
                                                                    if (i11 == 0) {
                                                                        ((com.google.android.libraries.navigation.internal.zb.h) ac.b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(52)).p("Fixing up UNITLESS_ID_UNKNOWN");
                                                                        arrayList3.subList(i9, arrayList3.size()).clear();
                                                                        break;
                                                                    }
                                                                    if (i11 == 83) {
                                                                        i9 = i10;
                                                                    }
                                                                } catch (Throwable th) {
                                                                    if (dVarB3 != null) {
                                                                        try {
                                                                            Trace.endSection();
                                                                        } catch (Throwable th2) {
                                                                            th.addSuppressed(th2);
                                                                        }
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                            if (arrayList3.isEmpty()) {
                                                                arrayList3.add(new ab(0));
                                                            }
                                                            if (dVarB3 != null) {
                                                                Trace.endSection();
                                                            }
                                                            bnVar = new bn(djVar.d, arrayList3, (djVar.b & 2) != 0 ? djVar.e : null);
                                                            break;
                                                        }
                                                        com.google.android.libraries.navigation.internal.adr.v vVar = (com.google.android.libraries.navigation.internal.adr.v) it4.next();
                                                        com.google.android.libraries.navigation.internal.nw.d dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("CannedMessage.fromProtoLite()");
                                                        if (vVar == null) {
                                                            if (dVarB4 != null) {
                                                                Trace.endSection();
                                                            }
                                                            abVar = null;
                                                        } else {
                                                            try {
                                                                if ((vVar.b & 1) != 0) {
                                                                    abVar = new ab(vVar.c);
                                                                    if (dVarB4 != null) {
                                                                        Trace.endSection();
                                                                    }
                                                                } else {
                                                                    ab abVar2 = new ab(0);
                                                                    if (dVarB4 != null) {
                                                                        Trace.endSection();
                                                                    }
                                                                    abVar = abVar2;
                                                                }
                                                            } catch (Throwable th3) {
                                                                if (dVarB4 != null) {
                                                                    try {
                                                                        Trace.endSection();
                                                                    } catch (Throwable th4) {
                                                                        th3.addSuppressed(th4);
                                                                    }
                                                                }
                                                                throw th3;
                                                            }
                                                        }
                                                        if (abVar == null) {
                                                            break;
                                                        }
                                                        arrayList3.add(abVar);
                                                    }
                                                }
                                                if (dVarB2 != null) {
                                                    Trace.endSection();
                                                }
                                                return Optional.ofNullable(bnVar);
                                            } catch (Throwable th5) {
                                                if (dVarB2 != null) {
                                                    try {
                                                        Trace.endSection();
                                                    } catch (Throwable th6) {
                                                        th5.addSuppressed(th6);
                                                    }
                                                }
                                                throw th5;
                                            }
                                        }
                                    });
                                    qVar.a(dlVar2.d);
                                    qVar.b(dlVar2.c);
                                    qVar.c(dlVar2.f);
                                    qVar.d(dlVar2.g);
                                    if (qVar.f != 15) {
                                        throw new IllegalStateException();
                                    }
                                    rVar = new r(qVar.a, qVar.b, qVar.c, qVar.d, qVar.e);
                                }
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                                return com.google.android.libraries.navigation.internal.yx.an.i(rVar);
                            } catch (Throwable th) {
                                if (dVarB != null) {
                                    try {
                                        Trace.endSection();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                    });
                    if (brVarA != null) {
                        bvVar.a(brVarA);
                    }
                }
                bwVar = new bw(bvVar);
            } else {
                bwVar = null;
            }
            i7++;
            if (bwVar != null) {
                arrayList2.add(bwVar);
            }
            it2 = it3;
            enVarB2 = enVar;
            str = str;
            i4 = i4;
            cif7 = cif7;
        }
        String str3 = str;
        Cif cif8 = cif7;
        int i8 = i4;
        en enVar2 = enVarB2;
        int size2 = hvVar.p.size();
        ArrayList arrayList3 = new ArrayList(size2);
        int i9 = 0;
        while (i9 < size2) {
            ds dsVar = (ds) hvVar.p.get(i9);
            if ((dsVar.b & 1) == 0 || (size = dsVar.d.size()) == 0) {
                arrayList = arrayList2;
                i2 = i2;
                duration = durationA;
            } else {
                ArrayList arrayList4 = new ArrayList(size);
                arrayList = arrayList2;
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        i2 = i2;
                        duration = durationA;
                        int iA = dr.a(dsVar.c);
                        if (iA == 0) {
                            iA = dr.a;
                        }
                        arVar = new ar(iA, arrayList4);
                        break;
                    }
                    int i11 = size;
                    dw dwVar = (dw) dsVar.d.get(i10);
                    duration = durationA;
                    if ((dwVar.b & 1) != 0) {
                        dv dvVarB = dv.b(dwVar.c);
                        if (dvVarB == null) {
                            dvVarB = dv.STRAIGHT;
                        }
                        atVar = new at(dvVarB, dwVar.d);
                    } else {
                        atVar = null;
                    }
                    if (atVar != null) {
                        arrayList4.add(atVar);
                        i10++;
                        size = i11;
                        durationA = duration;
                        i2 = i2;
                    }
                }
                if (arVar != null) {
                    arrayList3.add(arVar);
                }
                i9++;
                arrayList2 = arrayList;
                durationA = duration;
                i2 = i2;
            }
            arVar = null;
            if (arVar != null) {
                arrayList3.add(arVar);
            }
            i9++;
            arrayList2 = arrayList;
            durationA = duration;
            i2 = i2;
        }
        ArrayList arrayList5 = arrayList2;
        int i12 = i2;
        Duration duration2 = durationA;
        if (size2 != arrayList3.size()) {
            arrayList3 = new ArrayList();
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar4 = hvVar.v;
        com.google.android.libraries.navigation.internal.ael.bz<com.google.android.libraries.navigation.internal.adr.bh> bzVar5 = hvVar.o;
        ArrayList<bs> arrayList6 = new ArrayList();
        for (com.google.android.libraries.navigation.internal.adr.bh bhVar : bzVar5) {
            hs hsVarB2 = hs.b(hvVar.k);
            if (hsVarB2 == null) {
                hsVarB2 = hs.SIDE_UNSPECIFIED;
            }
            bs bsVarC = bs.c(bhVar, hsVarB2);
            if (bsVarC != null) {
                arrayList6.add(bsVarC);
            }
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar6 = hvVar.z;
        int i13 = ev.d;
        eq eqVar = new eq();
        Iterator it4 = bzVar6.iterator();
        while (it4.hasNext()) {
            he heVar = (he) it4.next();
            int i14 = heVar.b;
            if ((i14 & 1) == 0 || (i14 & 2) == 0 || (i14 & 4) == 0) {
                bzVar = bzVar4;
                lVar = null;
            } else {
                hb hbVar = heVar.d;
                if (hbVar == null) {
                    hbVar = hb.a;
                }
                com.google.android.libraries.navigation.internal.ael.bz bzVar7 = bzVar4;
                long j = hbVar.b;
                hb hbVar2 = heVar.d;
                if (hbVar2 == null) {
                    hbVar2 = hb.a;
                }
                bzVar = bzVar7;
                com.google.android.libraries.navigation.internal.oe.j jVar = new com.google.android.libraries.navigation.internal.oe.j(j, hbVar2.c);
                hd hdVar = heVar.e;
                if (hdVar == null) {
                    hdVar = hd.a;
                }
                int i15 = hdVar.b;
                hd hdVar2 = heVar.e;
                if (hdVar2 == null) {
                    hdVar2 = hd.a;
                }
                lVar = new l(heVar.c, jVar, com.google.android.libraries.navigation.internal.oe.x.x(i15, hdVar2.c), heVar.f, heVar.g);
            }
            if (lVar != null) {
                eqVar.h(lVar);
            }
            it4 = it4;
            i5 = i5;
            bzVar4 = bzVar;
        }
        com.google.android.libraries.navigation.internal.ael.bz bzVar8 = bzVar4;
        int i16 = i5;
        ev evVarG = eqVar.g();
        if (lVarB == com.google.android.libraries.navigation.internal.aap.l.DESTINATION) {
            if (com.google.android.libraries.navigation.internal.yx.aq.c(strV)) {
                Iterator it5 = arrayList6.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        strG = "";
                        break;
                    }
                    bs bsVar = (bs) it5.next();
                    if (bsVar.d() == com.google.android.libraries.navigation.internal.adr.bg.TYPE_TITLE && !com.google.android.libraries.navigation.internal.yx.aq.c(bsVar.g())) {
                        strG = bsVar.g();
                        break;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                for (bs bsVar2 : arrayList6) {
                    if (bsVar2.d() == com.google.android.libraries.navigation.internal.adr.bg.TYPE_ADDRESS && !com.google.android.libraries.navigation.internal.yx.aq.c(bsVar2.g())) {
                        if (sb2.length() > 0) {
                            sb2.append('\n');
                        }
                        sb2.append(bsVar2.g());
                    }
                }
                String string = sb2.toString();
                int length = strG.length();
                str2 = length > 0 ? string : null;
                if (length <= 0) {
                    strG = string;
                }
                if (ckVar == null || !com.google.android.libraries.navigation.internal.yx.aq.c(strG)) {
                    strV = strG;
                } else {
                    strV = ckVar.V();
                    str2 = null;
                }
                z2 = true;
            } else {
                str2 = null;
                z2 = false;
            }
            lo loVar = com.google.android.libraries.navigation.internal.br.l.a;
            if (bzVar2 == null) {
                enVarB = en.NONE;
                break;
            }
            Iterator it6 = bzVar2.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    enVarB = en.NONE;
                    break;
                }
                el elVar = (el) it6.next();
                if ((elVar.b & 8) != 0) {
                    fp fpVarB = fp.b(elVar.g);
                    if (fpVarB == null) {
                        fpVarB = fp.UNKNOWN;
                    }
                    if (fpVarB == fp.SIDE_OF_ROAD && (elVar.b & 262144) != 0) {
                        enVarB = en.b(elVar.x);
                        if (enVarB != null) {
                            break;
                        }
                        enVarB = en.NONE;
                        break;
                    }
                }
            }
            int iOrdinal = enVarB.ordinal();
            if (iOrdinal == 1) {
                hsVar = hs.SIDE_LEFT;
            } else if (iOrdinal != 2) {
                z = z2;
                hsVar = hsVar2;
            } else {
                hsVar = hs.SIDE_RIGHT;
            }
            z = z2;
        } else {
            str2 = null;
            hsVar = hsVar2;
            z = false;
        }
        if ((hvVar.b & 4096) != 0) {
            hVar = hvVar.q;
            if (hVar == null) {
                hVar = com.google.android.libraries.navigation.internal.adq.h.a;
            }
        } else {
            hVar = null;
        }
        String str4 = hvVar.c;
        bp bpVar = new bp();
        bpVar.f = xVar2;
        bpVar.a = lVarB;
        bpVar.b = hsVar;
        bpVar.c = huVarB;
        bpVar.d = i6;
        bpVar.e = i16;
        bpVar.h = i8;
        bpVar.l = i12;
        bpVar.f354n = duration2;
        bpVar.i = strV;
        bpVar.j = str2;
        bpVar.k = z;
        bpVar.q = arrayList6;
        bpVar.r = bzVar2;
        bpVar.s = arrayList5;
        bpVar.t = arrayList3;
        bpVar.u = bzVar8;
        bpVar.w = cif8;
        bpVar.y = hVar;
        bpVar.z = str4;
        bpVar.C = str3;
        bpVar.v = enVar2;
        bpVar.D = hvVar.u;
        bpVar.E = hvVar.x;
        bpVar.F = ev.o(hvVar.y);
        bpVar.G = hvVar.t;
        bpVar.H = evVarG;
        StringBuilder sb3 = new StringBuilder();
        hq hqVar2 = hvVar.f;
        if (hqVar2 == null) {
            hqVar2 = hq.a;
        }
        if ((hqVar2.b & 2) != 0) {
            hq hqVar3 = hvVar.f;
            if (hqVar3 == null) {
                hqVar3 = hq.a;
            }
            sb3.append(hqVar3.d);
        }
        if ((hvVar.b & 64) != 0) {
            com.google.android.libraries.navigation.internal.aap.l lVarB4 = com.google.android.libraries.navigation.internal.aap.l.b(hvVar.i);
            if (lVarB4 == null) {
                lVarB4 = com.google.android.libraries.navigation.internal.aap.l.MANEUVER_UNKNOWN;
            }
            sb3.append(lVarB4.F);
        }
        if ((hvVar.b & 128) != 0) {
            hu huVarB2 = hu.b(hvVar.j);
            if (huVarB2 == null) {
                huVarB2 = hu.TURN_UNKNOWN;
            }
            sb3.append(huVarB2.j);
        }
        if ((hvVar.b & 512) != 0) {
            int iA2 = gy.a(hvVar.l);
            if (iA2 == 0) {
                iA2 = gy.a;
            }
            int i17 = iA2 - 1;
            if (iA2 == 0) {
                throw null;
            }
            sb3.append(i17);
        }
        for (com.google.android.libraries.navigation.internal.adr.bh bhVar2 : hvVar.o) {
            if ((bhVar2.b & 1) != 0) {
                com.google.android.libraries.navigation.internal.adr.bg bgVarB = com.google.android.libraries.navigation.internal.adr.bg.b(bhVar2.c);
                if (bgVarB == null) {
                    bgVarB = com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME;
                }
                sb3.append(bgVarB.o);
            }
            if ((bhVar2.b & 2) != 0) {
                sb3.append(bhVar2.d);
            }
        }
        bpVar.J = sb3.toString();
        return bpVar;
    }

    static bq b(Resources resources, com.google.android.libraries.navigation.internal.adr.bq bqVar, bq bqVar2) {
        bp bpVarA = bqVar2.a();
        com.google.android.libraries.navigation.internal.adr.bo boVar = bqVar.d;
        if (boVar == null) {
            boVar = com.google.android.libraries.navigation.internal.adr.bo.a;
        }
        int i = boVar.c;
        bpVarA.i = resources.getString(com.google.android.libraries.navigation.internal.bx.g.j) + " · " + resources.getQuantityString(com.google.android.libraries.navigation.internal.bx.e.a, i, Integer.valueOf(i));
        bpVarA.j = null;
        fv fvVar = bqVar.c;
        if (fvVar == null) {
            fvVar = fv.a;
        }
        com.google.android.libraries.navigation.internal.adr.ah ahVar = fvVar.d;
        if (ahVar == null) {
            ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
        }
        bpVarA.A = ahVar.d;
        int i2 = ev.d;
        bpVarA.r = lv.a;
        bpVarA.I = true;
        return new bq(bpVarA);
    }

    public static bs c(bq bqVar) {
        bs bsVarE;
        if (bqVar == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.aap.l lVar = bqVar.d;
        if (lVar == com.google.android.libraries.navigation.internal.aap.l.DEPART && bqVar.r) {
            return bqVar.b();
        }
        if (lVar == com.google.android.libraries.navigation.internal.aap.l.UTURN && (bsVarE = e(bqVar)) != null) {
            return bsVarE;
        }
        bq bqVar2 = bqVar.N;
        if (bqVar2 != null && b.contains(bqVar2.d) && bqVar2.r) {
            bs bsVarE2 = bqVar2.d == com.google.android.libraries.navigation.internal.aap.l.UTURN ? e(bqVar2) : bqVar2.b();
            if (bsVarE2 != null && c.contains(bsVarE2.d())) {
                return bsVarE2;
            }
        }
        return null;
    }

    public static boolean d(com.google.android.libraries.navigation.internal.aap.l lVar) {
        return lVar == com.google.android.libraries.navigation.internal.aap.l.TURN || lVar == com.google.android.libraries.navigation.internal.aap.l.UTURN;
    }

    private static bs e(bq bqVar) {
        for (bs bsVar : bqVar.x) {
            if (bsVar.d() == com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME) {
                return bsVar;
            }
        }
        return null;
    }
}
