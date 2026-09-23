package com.google.android.libraries.navigation.internal.px;

import android.util.SparseArray;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.ho;
import com.google.android.libraries.navigation.internal.adg.ie;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fa;
import com.google.android.libraries.navigation.internal.agg.fc;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.jd;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bh {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.bh");
    private static final da b = di.a;
    private final com.google.android.libraries.navigation.internal.qc.g c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.rc.f e;
    private final j f = new j();
    private final d g = new d();
    private final Set h = new HashSet();
    private final com.google.android.libraries.navigation.internal.agl.a i;

    public bh(com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.rc.f fVar) {
        this.c = gVar;
        this.d = aVar;
        this.i = aVar2;
        this.e = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:109:0x01fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:112:0x0207 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x020a A[LOOP:2: B:105:0x01e1->B:114:0x020a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:122:0x022f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0237  */
    /* JADX WARN: Code duplicated, block: B:127:0x023d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0243  */
    /* JADX WARN: Code duplicated, block: B:133:0x0253  */
    /* JADX WARN: Code duplicated, block: B:135:0x025f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0263  */
    /* JADX WARN: Code duplicated, block: B:140:0x0277  */
    /* JADX WARN: Code duplicated, block: B:145:0x0294  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:151:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:152:0x02be  */
    /* JADX WARN: Code duplicated, block: B:154:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:156:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:158:0x02e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:218:0x043c  */
    /* JADX WARN: Code duplicated, block: B:222:0x044a  */
    /* JADX WARN: Code duplicated, block: B:225:0x0452  */
    /* JADX WARN: Code duplicated, block: B:265:0x04f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:266:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:268:0x050f  */
    /* JADX WARN: Code duplicated, block: B:270:0x0529  */
    /* JADX WARN: Code duplicated, block: B:302:0x05de  */
    /* JADX WARN: Code duplicated, block: B:304:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:308:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:311:0x05f4  */
    /* JADX WARN: Code duplicated, block: B:313:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:316:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:319:0x0608  */
    /* JADX WARN: Code duplicated, block: B:320:0x060d  */
    /* JADX WARN: Code duplicated, block: B:322:0x0611  */
    /* JADX WARN: Code duplicated, block: B:325:0x0617  */
    /* JADX WARN: Code duplicated, block: B:328:0x0623  */
    /* JADX WARN: Code duplicated, block: B:331:0x0634  */
    /* JADX WARN: Code duplicated, block: B:335:0x064f  */
    /* JADX WARN: Code duplicated, block: B:337:0x0653  */
    /* JADX WARN: Code duplicated, block: B:341:0x065d  */
    /* JADX WARN: Code duplicated, block: B:346:0x0667  */
    /* JADX WARN: Code duplicated, block: B:349:0x0671  */
    /* JADX WARN: Code duplicated, block: B:351:0x0675  */
    /* JADX WARN: Code duplicated, block: B:354:0x067b  */
    /* JADX WARN: Code duplicated, block: B:357:0x0685  */
    /* JADX WARN: Code duplicated, block: B:359:0x0689  */
    /* JADX WARN: Code duplicated, block: B:362:0x0693  */
    /* JADX WARN: Code duplicated, block: B:363:0x0698  */
    /* JADX WARN: Code duplicated, block: B:365:0x069c  */
    /* JADX WARN: Code duplicated, block: B:368:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:371:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:374:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:377:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:380:0x06eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:381:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:382:0x0704  */
    /* JADX WARN: Code duplicated, block: B:385:0x070c  */
    /* JADX WARN: Code duplicated, block: B:388:0x0712  */
    /* JADX WARN: Code duplicated, block: B:390:0x0718  */
    /* JADX WARN: Code duplicated, block: B:394:0x072e  */
    /* JADX WARN: Code duplicated, block: B:397:0x074f  */
    /* JADX WARN: Code duplicated, block: B:400:0x0763  */
    /* JADX WARN: Code duplicated, block: B:412:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:417:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:419:0x07ed  */
    /* JADX WARN: Code duplicated, block: B:423:0x0820  */
    /* JADX WARN: Code duplicated, block: B:431:0x07aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:432:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:433:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x077b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:438:0x078d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:439:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:440:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x071e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:447:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:448:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0100  */
    /* JADX WARN: Code duplicated, block: B:64:0x010c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0123  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    /* JADX WARN: Code duplicated, block: B:70:0x013e  */
    /* JADX WARN: Code duplicated, block: B:71:0x014a  */
    /* JADX WARN: Code duplicated, block: B:74:0x015c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0160  */
    /* JADX WARN: Code duplicated, block: B:78:0x016e  */
    /* JADX WARN: Code duplicated, block: B:82:0x018a  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01cf  */
    private final ek c(ek ekVar, SparseArray sparseArray, int i, ez ezVar, ez ezVar2) {
        be beVar;
        com.google.android.libraries.navigation.internal.adg.ef efVarO;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        Object objK;
        Object objC;
        com.google.android.libraries.navigation.internal.adg.t tVar;
        com.google.android.libraries.navigation.internal.ado.j jVarS;
        com.google.android.libraries.navigation.internal.ado.i iVar;
        com.google.android.libraries.navigation.internal.ado.j jVar;
        com.google.android.libraries.navigation.internal.adq.ae aeVar;
        Iterator it2;
        com.google.android.libraries.navigation.internal.adg.dy dyVar;
        com.google.android.libraries.navigation.internal.adg.ad adVar;
        boolean z;
        com.google.android.libraries.navigation.internal.adg.t tVar2;
        com.google.android.libraries.navigation.internal.ado.i iVar2;
        com.google.android.libraries.navigation.internal.adg.ef efVar;
        com.google.android.libraries.navigation.internal.adg.ad adVar2;
        com.google.android.libraries.navigation.internal.adq.ah ahVar;
        int iIntValue;
        hg hgVar;
        com.google.android.libraries.navigation.internal.adg.ef efVar2;
        com.google.android.libraries.navigation.internal.adg.ef efVar3;
        com.google.android.libraries.navigation.internal.adg.df dfVar;
        com.google.android.libraries.navigation.internal.adg.ef efVar4;
        com.google.android.libraries.navigation.internal.adg.df dfVar2;
        int i2;
        com.google.android.libraries.navigation.internal.ado.i iVar3;
        com.google.android.libraries.navigation.internal.adg.ad adVar3;
        boolean z2;
        boolean zA;
        com.google.android.libraries.navigation.internal.adg.df dfVar3;
        com.google.android.libraries.navigation.internal.adg.df dfVar4;
        com.google.android.libraries.navigation.internal.adg.df dfVar5;
        com.google.android.libraries.navigation.internal.adg.df dfVar6;
        com.google.android.libraries.navigation.internal.adg.df dfVar7;
        com.google.android.libraries.navigation.internal.adg.ef efVar5;
        com.google.android.libraries.navigation.internal.adg.an anVar;
        com.google.android.libraries.navigation.internal.adg.u uVar;
        com.google.android.libraries.navigation.internal.ael.bz bzVar;
        com.google.android.libraries.navigation.internal.adg.df dfVar8;
        com.google.android.libraries.navigation.internal.adg.ae aeVar2;
        com.google.android.libraries.navigation.internal.adg.df dfVar9;
        com.google.android.libraries.navigation.internal.adg.am amVar;
        com.google.android.libraries.navigation.internal.adg.df dfVar10;
        com.google.android.libraries.navigation.internal.adg.df dfVar11;
        com.google.android.libraries.navigation.internal.adg.ef efVar6;
        com.google.android.libraries.navigation.internal.ael.bz bzVar2;
        bf bfVar;
        com.google.android.libraries.navigation.internal.adg.df dfVar12;
        com.google.android.libraries.navigation.internal.adg.am amVar2;
        com.google.android.libraries.navigation.internal.adg.df dfVar13;
        com.google.android.libraries.navigation.internal.adg.am amVar3;
        com.google.android.libraries.navigation.internal.adg.ef efVar7;
        com.google.android.libraries.navigation.internal.ael.bq bqVar;
        bf bfVar2;
        com.google.android.libraries.navigation.internal.adq.d dVar;
        bf bfVarA;
        com.google.android.libraries.navigation.internal.adg.dq dqVar;
        bf bfVar3;
        Cdo cdo;
        com.google.android.libraries.navigation.internal.qc.g gVar;
        com.google.android.libraries.navigation.internal.adg.df dfVar14;
        com.google.android.libraries.navigation.internal.adg.dd ddVar;
        int iY;
        com.google.android.libraries.navigation.internal.zy.e eVarE;
        int i3;
        int i4;
        int iIntValue2;
        int i5;
        fd fdVar;
        com.google.android.libraries.navigation.internal.zy.e eVarE2;
        int iA;
        com.google.android.libraries.navigation.internal.adg.df dfVar15;
        com.google.android.libraries.navigation.internal.adg.df dfVar16;
        com.google.android.libraries.navigation.internal.adg.am amVar4;
        Iterator it3;
        Integer num;
        int iIntValue3;
        int i6;
        Iterator it4;
        int i7;
        int iIntValue4;
        int i8;
        int i9;
        com.google.android.libraries.navigation.internal.adq.ah ahVar2;
        this = this;
        sparseArray = sparseArray;
        int i10 = i;
        ezVar = ezVar;
        ezVar2.clear();
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            hg hgVar2 = (hg) sparseArray.valueAt(i11);
            com.google.android.libraries.navigation.internal.adg.df dfVar17 = hgVar2.d;
            if (dfVar17 == null) {
                dfVar17 = com.google.android.libraries.navigation.internal.adg.df.a;
            }
            if ((dfVar17.b & 4) != 0 && !com.google.android.libraries.navigation.internal.pa.a.b(hgVar2, ezVar)) {
                com.google.android.libraries.navigation.internal.adg.df dfVar18 = hgVar2.d;
                if (dfVar18 == null) {
                    dfVar18 = com.google.android.libraries.navigation.internal.adg.df.a;
                }
                com.google.android.libraries.navigation.internal.adg.am amVar5 = dfVar18.e;
                if (amVar5 == null) {
                    amVar5 = com.google.android.libraries.navigation.internal.adg.am.a;
                }
                ezVar2.addAll(amVar5.b);
            }
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar8 = null;
        if (ekVar.c() != -1) {
            ez ezVarA = ei.a(ekVar.o());
            ezVarA.e(ezVar2);
            fa faVar = com.google.android.libraries.navigation.internal.agg.fd.a;
            fc fcVar = new fc(ezVarA);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarD = this.c.d(ekVar, fcVar, i10);
            com.google.android.libraries.navigation.internal.adg.ak akVar = aiVarD.v;
            if (akVar == null) {
                ekVar.o();
            } else {
                int i12 = aiVarD.w;
                com.google.android.libraries.navigation.internal.adg.en enVar = aiVarD.u;
                bg bgVar = bg.NONE;
                com.google.android.libraries.navigation.internal.adg.dt dtVar = ekVar.o().d;
                if (dtVar == null) {
                    dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                }
                Iterator it5 = dtVar.c.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = ekVar.o().c;
                        if (dtVar2 == null) {
                            dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
                        }
                        for (com.google.android.libraries.navigation.internal.adg.dp dpVar : dtVar2.c) {
                            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarB = this.c.b(dpVar, ekVar, fcVar, i10);
                            if (aiVarB.q() && !((com.google.android.libraries.geo.mapcore.internal.model.o) aiVarB.r).h && (dpVar.b & 1) != 0 && !aiVarB.i()) {
                                bgVar = bg.ON_PRIMARY;
                                break;
                            }
                        }
                        break;
                    }
                    com.google.android.libraries.navigation.internal.adg.dp dpVar2 = (com.google.android.libraries.navigation.internal.adg.dp) it5.next();
                    com.google.android.libraries.geo.mapcore.internal.model.ai aiVarB2 = this.c.b(dpVar2, ekVar, fcVar, i10);
                    if ((aiVarB2.q() && !((com.google.android.libraries.geo.mapcore.internal.model.o) aiVarB2.r).h && (dpVar2.b & 1) != 0) || aiVarB2.i()) {
                        bgVar = bg.ON_SECONDARY;
                        break;
                    }
                }
                beVar = new be(ekVar, fcVar, akVar, enVar, bgVar, i12);
            }
            if (beVar != null) {
                if (!beVar.c.b.isEmpty()) {
                    efVarO = ekVar.o();
                    bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ac);
                    efVarO.h(bhVarS);
                    objK = efVarO.w.k(bhVarS.d);
                    if (objK == null) {
                        objC = bhVarS.b;
                    } else {
                        objC = bhVarS.c(objK);
                    }
                    com.google.android.libraries.navigation.internal.adg.u uVar2 = (com.google.android.libraries.navigation.internal.adg.u) objC;
                    com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) uVar2.aH(5, null);
                    bbVar.x(uVar2);
                    tVar = (com.google.android.libraries.navigation.internal.adg.t) bbVar;
                    jVarS = ekVar.s();
                    if (jVarS != null) {
                        com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) jVarS.aH(5, null);
                        bbVar2.x(jVarS);
                        iVar = (com.google.android.libraries.navigation.internal.ado.i) bbVar2;
                    } else {
                        iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                    }
                    jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
                    if ((jVar.b & 1) != 0) {
                        ahVar2 = jVar.c;
                        if (ahVar2 == null) {
                            ahVar2 = com.google.android.libraries.navigation.internal.adq.ah.a;
                        }
                        com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) ahVar2.aH(5, null);
                        bbVar3.x(ahVar2);
                        aeVar = (com.google.android.libraries.navigation.internal.adq.ae) bbVar3;
                    } else {
                        aeVar = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                    }
                    it2 = beVar.c.b.iterator();
                    dyVar = null;
                    adVar = null;
                    int i13 = 0;
                    z = false;
                    while (it2.hasNext()) {
                        iIntValue = ((Integer) it2.next()).intValue();
                        hgVar = (hg) sparseArray.get(iIntValue);
                        it2 = it2;
                        if (hgVar != null) {
                            if (dyVar == null) {
                                com.google.android.libraries.navigation.internal.ael.bb bbVar4 = (com.google.android.libraries.navigation.internal.ael.bb) efVarO.aH(5, null);
                                bbVar4.x(efVarO);
                                dyVar = (com.google.android.libraries.navigation.internal.adg.dy) bbVar4;
                            }
                            if (com.google.android.libraries.navigation.internal.pa.a.b(hgVar, ezVar)) {
                                efVar2 = efVarO;
                                efVar3 = null;
                            } else {
                                dfVar = hgVar.d;
                                if (dfVar == null) {
                                    dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar.b & 4) != 0) {
                                    dfVar15 = hgVar.d;
                                    if (dfVar15 == null) {
                                        dfVar15 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if (dfVar15.g.size() == 0) {
                                        dfVar16 = hgVar.d;
                                        if (dfVar16 == null) {
                                            dfVar16 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar4 = dfVar16.e;
                                        if (amVar4 == null) {
                                            amVar4 = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        it3 = amVar4.b.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                num = (Integer) it3.next();
                                                efVar2 = efVarO;
                                                iIntValue3 = num.intValue();
                                                i6 = ie.C;
                                                it4 = it3;
                                                i7 = i6 - 1;
                                                if (i6 != 0) {
                                                    throw null;
                                                }
                                                if (iIntValue3 != i7) {
                                                    iIntValue4 = num.intValue();
                                                    i8 = ie.I;
                                                    i9 = i8 - 1;
                                                    if (i8 != 0) {
                                                        throw null;
                                                    }
                                                    if (iIntValue4 == i9) {
                                                        efVarO = efVar2;
                                                        it3 = it4;
                                                    }
                                                }
                                                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 936)).p("Photopin annotation received without data-bound value.");
                                                efVar3 = null;
                                            }
                                        }
                                    }
                                }
                                efVar4 = efVarO;
                                dfVar2 = hgVar.d;
                                if (dfVar2 == null) {
                                    dfVar2 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar2.b & 8) != 0) {
                                    gVar = this.c;
                                    dfVar14 = hgVar.d;
                                    if (dfVar14 == null) {
                                        dfVar14 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    ddVar = dfVar14.f;
                                    if (ddVar == null) {
                                        ddVar = com.google.android.libraries.navigation.internal.adg.dd.a;
                                    }
                                    iY = ekVar.Y();
                                    eVarE = gVar.e(ekVar);
                                    if (ekVar.ac() != null) {
                                        iVar3 = iVar;
                                        eVarE2 = gVar.e(ekVar);
                                        if (eVarE2.d()) {
                                            iA = 0;
                                        } else {
                                            iA = eVarE2.a(0);
                                        }
                                        i2 = iIntValue;
                                        adVar3 = adVar;
                                        i3 = 1;
                                        while (true) {
                                            if (i3 < eVarE2.b()) {
                                                if (((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).i < eVarE2.a(i3) && ((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).i < iA) {
                                                    break;
                                                }
                                                iA = eVarE2.a(i3);
                                                i3++;
                                            }
                                        }
                                        i4 = ddVar.b;
                                        if (gVar.e(ekVar).b() > i3) {
                                            if (ekVar.k() != null) {
                                                fdVar = ekVar.k().f;
                                            } else {
                                                fdVar = ma.b;
                                            }
                                            z2 = false;
                                            iIntValue2 = ((Integer) fdVar.getOrDefault(Integer.valueOf(i4), 0)).intValue();
                                        } else {
                                            z2 = false;
                                            iIntValue2 = 0;
                                        }
                                        if (iIntValue2 != 0) {
                                            i5 = i3 - iIntValue2;
                                            if (eVarE.b() <= Math.max(iY, i5) && i5 >= 0) {
                                                int iA2 = eVarE.a(i5) - eVarE.a(i3);
                                                int i14 = (i5 - iY) * 8;
                                                if (!dyVar.b.H()) {
                                                    dyVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.adg.ef efVar9 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                efVar9.b |= 256;
                                                efVar9.j = i14;
                                                int iB = com.google.android.libraries.navigation.internal.zw.e.b(((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).i, iA2);
                                                if (!dyVar.b.H()) {
                                                    dyVar.v();
                                                }
                                                com.google.android.libraries.navigation.internal.adg.ef efVar10 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                efVar10.b |= 128;
                                                efVar10.i = iB;
                                                com.google.android.libraries.navigation.internal.adg.df dfVar19 = hgVar.d;
                                                if (dfVar19 == null) {
                                                    dfVar19 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                com.google.android.libraries.navigation.internal.adg.dd ddVar2 = dfVar19.f;
                                                if (ddVar2 == null) {
                                                    ddVar2 = com.google.android.libraries.navigation.internal.adg.dd.a;
                                                }
                                                int i15 = ddVar2.b;
                                                if (hgVar.m) {
                                                    int i16 = com.google.android.libraries.navigation.internal.adq.ag.p;
                                                    if (!aeVar.b.H()) {
                                                        aeVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.ah ahVar3 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.b;
                                                    if (i16 == 0) {
                                                        throw null;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bq bqVar2 = ahVar3.d;
                                                    if (!bqVar2.c()) {
                                                        ahVar3.d = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar2);
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bq bqVar3 = ahVar3.d;
                                                    if (i16 == 0) {
                                                        throw null;
                                                    }
                                                    bqVar3.i(i16);
                                                    com.google.android.libraries.navigation.internal.adq.c cVar = (com.google.android.libraries.navigation.internal.adq.c) com.google.android.libraries.navigation.internal.adq.d.a.q();
                                                    com.google.android.libraries.navigation.internal.adq.e eVar = (com.google.android.libraries.navigation.internal.adq.e) com.google.android.libraries.navigation.internal.adq.f.a.q();
                                                    com.google.android.libraries.navigation.internal.adg.df dfVar20 = hgVar.d;
                                                    if (dfVar20 == null) {
                                                        dfVar20 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                    }
                                                    int i17 = dfVar20.c;
                                                    if (!eVar.b.H()) {
                                                        eVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.f fVar = (com.google.android.libraries.navigation.internal.adq.f) eVar.b;
                                                    fVar.b |= 4;
                                                    fVar.d = i17;
                                                    if (!eVar.b.H()) {
                                                        eVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.f fVar2 = (com.google.android.libraries.navigation.internal.adq.f) eVar.b;
                                                    fVar2.b |= 16;
                                                    fVar2.f = i15;
                                                    if (!cVar.b.H()) {
                                                        cVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.d dVar2 = (com.google.android.libraries.navigation.internal.adq.d) cVar.b;
                                                    com.google.android.libraries.navigation.internal.adq.f fVar3 = (com.google.android.libraries.navigation.internal.adq.f) eVar.t();
                                                    fVar3.getClass();
                                                    dVar2.d = fVar3;
                                                    dVar2.b |= 2;
                                                    aeVar.c(cVar);
                                                } else {
                                                    aeVar.e(com.google.android.libraries.navigation.internal.adq.ad.H);
                                                    com.google.android.libraries.navigation.internal.adq.c cVar2 = (com.google.android.libraries.navigation.internal.adq.c) com.google.android.libraries.navigation.internal.adq.d.a.q();
                                                    com.google.android.libraries.navigation.internal.adq.e eVar2 = (com.google.android.libraries.navigation.internal.adq.e) com.google.android.libraries.navigation.internal.adq.f.a.q();
                                                    if (!eVar2.b.H()) {
                                                        eVar2.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.f fVar4 = (com.google.android.libraries.navigation.internal.adq.f) eVar2.b;
                                                    fVar4.b |= 8;
                                                    fVar4.e = i15;
                                                    if (!cVar2.b.H()) {
                                                        cVar2.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adq.d dVar3 = (com.google.android.libraries.navigation.internal.adq.d) cVar2.b;
                                                    com.google.android.libraries.navigation.internal.adq.f fVar5 = (com.google.android.libraries.navigation.internal.adq.f) eVar2.t();
                                                    fVar5.getClass();
                                                    dVar3.d = fVar5;
                                                    dVar3.b |= 2;
                                                    aeVar.c(cVar2);
                                                    if ((hgVar.b & 128) != 0) {
                                                        com.google.android.libraries.navigation.internal.adq.d dVar4 = hgVar.j;
                                                        if (dVar4 == null) {
                                                            dVar4 = com.google.android.libraries.navigation.internal.adq.d.a;
                                                        }
                                                        if (dVar4.c != 0) {
                                                            com.google.android.libraries.navigation.internal.adq.d dVar5 = hgVar.j;
                                                            if (dVar5 == null) {
                                                                dVar5 = com.google.android.libraries.navigation.internal.adq.d.a;
                                                            }
                                                            aeVar.d(dVar5);
                                                        }
                                                    }
                                                }
                                                zA = true;
                                            }
                                        }
                                        dfVar3 = hgVar.d;
                                        if (dfVar3 == null) {
                                            dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if ((dfVar3.b & 2) != 0 || beVar.f <= i13) {
                                            i = i;
                                            dfVar4 = hgVar.d;
                                            if (dfVar4 == null) {
                                                dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            int i18 = dfVar4.b;
                                        } else {
                                            if (beVar.d != null && beVar.d.ordinal() == 1) {
                                                if (beVar.e.a()) {
                                                    com.google.android.libraries.navigation.internal.adg.dt dtVar3 = ((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).d;
                                                    if (dtVar3 == null) {
                                                        dtVar3 = com.google.android.libraries.navigation.internal.adg.dt.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar5 = (com.google.android.libraries.navigation.internal.ael.bb) dtVar3.aH(5, null);
                                                    bbVar5.x(dtVar3);
                                                    dqVar = (com.google.android.libraries.navigation.internal.adg.dq) bbVar5;
                                                } else if (beVar.e == bg.ON_PRIMARY) {
                                                    com.google.android.libraries.navigation.internal.adg.dt dtVar4 = ((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).c;
                                                    if (dtVar4 == null) {
                                                        dtVar4 = com.google.android.libraries.navigation.internal.adg.dt.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar6 = (com.google.android.libraries.navigation.internal.ael.bb) dtVar4.aH(5, null);
                                                    bbVar6.x(dtVar4);
                                                    dqVar = (com.google.android.libraries.navigation.internal.adg.dq) bbVar6;
                                                } else {
                                                    bfVarA = bf.a();
                                                }
                                                com.google.android.libraries.navigation.internal.adg.df dfVar21 = hgVar.d;
                                                if (dfVar21 == null) {
                                                    dfVar21 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                com.google.android.libraries.navigation.internal.adg.dh dhVar = dfVar21.d;
                                                if (dhVar == null) {
                                                    dhVar = com.google.android.libraries.navigation.internal.adg.dh.a;
                                                }
                                                int i19 = 1;
                                                boolean z3 = true;
                                                for (com.google.android.libraries.navigation.internal.adg.dp dpVar3 : dhVar.b) {
                                                    com.google.android.libraries.geo.mapcore.internal.model.ai aiVarB3 = this.c.b(dpVar3, beVar.a, beVar.b, i);
                                                    if ((dpVar3.b & 1) != 0) {
                                                        if (aiVarB3.q() && !((com.google.android.libraries.geo.mapcore.internal.model.o) aiVarB3.r).h) {
                                                            if (z3) {
                                                                com.google.android.libraries.navigation.internal.ael.bb bbVar7 = (com.google.android.libraries.navigation.internal.ael.bb) dpVar3.aH(5, null);
                                                                bbVar7.x(dpVar3);
                                                                cdo = (Cdo) bbVar7;
                                                                if (!cdo.b.H()) {
                                                                    cdo.v();
                                                                }
                                                                com.google.android.libraries.navigation.internal.adg.dp dpVar4 = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
                                                                dpVar4.b |= 32;
                                                                dpVar4.h = true;
                                                                dqVar.e((com.google.android.libraries.navigation.internal.adg.dp) cdo.t());
                                                            } else {
                                                                dqVar.e(dpVar3);
                                                            }
                                                            i19 = 2;
                                                            z3 = false;
                                                        }
                                                    } else if (aiVarB3.i()) {
                                                        if (z3) {
                                                            com.google.android.libraries.navigation.internal.ael.bb bbVar8 = (com.google.android.libraries.navigation.internal.ael.bb) dpVar3.aH(5, null);
                                                            bbVar8.x(dpVar3);
                                                            cdo = (Cdo) bbVar8;
                                                            if (!cdo.b.H()) {
                                                                cdo.v();
                                                            }
                                                            com.google.android.libraries.navigation.internal.adg.dp dpVar5 = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
                                                            dpVar5.b |= 32;
                                                            dpVar5.h = true;
                                                            dqVar.e((com.google.android.libraries.navigation.internal.adg.dp) cdo.t());
                                                        } else {
                                                            dqVar.e(dpVar3);
                                                        }
                                                        i19 = 2;
                                                        z3 = false;
                                                    }
                                                    this = this;
                                                }
                                                if (beVar.e.a()) {
                                                    if (!dyVar.b.H()) {
                                                        dyVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adg.ef efVar11 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                    com.google.android.libraries.navigation.internal.adg.dt dtVar5 = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
                                                    dtVar5.getClass();
                                                    efVar11.d = dtVar5;
                                                    efVar11.b |= 2;
                                                    bfVar3 = new bf(i19, beVar.e);
                                                } else {
                                                    if (!dyVar.b.H()) {
                                                        dyVar.v();
                                                    }
                                                    com.google.android.libraries.navigation.internal.adg.ef efVar12 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                    com.google.android.libraries.navigation.internal.adg.dt dtVar6 = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.t();
                                                    dtVar6.getClass();
                                                    efVar12.c = dtVar6;
                                                    efVar12.b |= 1;
                                                    bfVar3 = new bf(i19, beVar.e);
                                                }
                                                bfVarA = bfVar3;
                                            } else {
                                                bfVarA = bf.a();
                                            }
                                            if (bc.a(bfVarA.b)) {
                                                i13++;
                                                if (!hgVar.m && (hgVar.b & 32) != 0) {
                                                    com.google.android.libraries.navigation.internal.adq.d dVar6 = hgVar.h;
                                                    if (dVar6 == null) {
                                                        dVar6 = com.google.android.libraries.navigation.internal.adq.d.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bb bbVar9 = (com.google.android.libraries.navigation.internal.ael.bb) dVar6.aH(5, null);
                                                    bbVar9.x(dVar6);
                                                    bg bgVar2 = bfVarA.a;
                                                    com.google.android.libraries.navigation.internal.adq.c cVar3 = (com.google.android.libraries.navigation.internal.adq.c) bbVar9;
                                                    if (!cVar3.b.H()) {
                                                        cVar3.v();
                                                    }
                                                    int i20 = bgVar2.d;
                                                    com.google.android.libraries.navigation.internal.adq.d dVar7 = (com.google.android.libraries.navigation.internal.adq.d) cVar3.b;
                                                    int i21 = i20 - 1;
                                                    if (i20 == 0) {
                                                        throw null;
                                                    }
                                                    dVar7.e = i21;
                                                    dVar7.b |= 4;
                                                    aeVar.c(cVar3);
                                                }
                                                zA = true;
                                            }
                                        }
                                        dfVar5 = hgVar.d;
                                        if (dfVar5 == null) {
                                            dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if ((dfVar5.b & 4) != 0) {
                                            dfVar12 = hgVar.d;
                                            if (dfVar12 == null) {
                                                dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            amVar2 = dfVar12.e;
                                            if (amVar2 == null) {
                                                amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                            }
                                            if (amVar2.b.size() == 0) {
                                                bfVar2 = bf.a();
                                            } else {
                                                dfVar13 = hgVar.d;
                                                if (dfVar13 == null) {
                                                    dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                amVar3 = dfVar13.e;
                                                if (amVar3 == null) {
                                                    amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                                }
                                                com.google.android.libraries.navigation.internal.ael.bq bqVar4 = amVar3.b;
                                                if (!dyVar.b.H()) {
                                                    dyVar.v();
                                                }
                                                efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                com.google.android.libraries.navigation.internal.adg.ef efVar13 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                                bqVar = efVar7.p;
                                                if (!bqVar.c()) {
                                                    efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                                }
                                                com.google.android.libraries.navigation.internal.ael.b.m(bqVar4, efVar7.p);
                                                bfVar2 = new bf(2, bg.NONE);
                                            }
                                            if (bc.a(bfVar2.b)) {
                                                if (!hgVar.m && (hgVar.b & 64) != 0) {
                                                    dVar = hgVar.i;
                                                    if (dVar == null) {
                                                        dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                                    }
                                                    aeVar.d(dVar);
                                                }
                                                zA = true;
                                            }
                                        }
                                        dfVar6 = hgVar.d;
                                        if (dfVar6 == null) {
                                            dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if (dfVar6.g.size() > 0) {
                                            dfVar9 = hgVar.d;
                                            if (dfVar9 == null) {
                                                dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            amVar = dfVar9.e;
                                            if (amVar == null) {
                                                amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                            }
                                            if (amVar.b.size() > 0) {
                                                dfVar10 = hgVar.d;
                                                if (dfVar10 == null) {
                                                    dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                if (dfVar10.g.size() == 0) {
                                                    bfVar = bf.a();
                                                } else {
                                                    dfVar11 = hgVar.d;
                                                    if (dfVar11 == null) {
                                                        dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.bz bzVar3 = dfVar11.g;
                                                    if (!dyVar.b.H()) {
                                                        dyVar.v();
                                                    }
                                                    efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                    com.google.android.libraries.navigation.internal.adg.ef efVar14 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                                    bzVar2 = efVar6.t;
                                                    if (!bzVar2.c()) {
                                                        efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                                    }
                                                    com.google.android.libraries.navigation.internal.ael.b.m(bzVar3, efVar6.t);
                                                    bfVar = new bf(2, bg.NONE);
                                                }
                                                zA |= bc.a(bfVar.b);
                                            } else {
                                                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                            }
                                        }
                                        dfVar7 = hgVar.d;
                                        if (dfVar7 == null) {
                                            dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if ((dfVar7.b & 16) != 0) {
                                            if (adVar3 == null) {
                                                com.google.android.libraries.navigation.internal.adg.ae aeVar3 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                                efVar5 = null;
                                                com.google.android.libraries.navigation.internal.ael.bb bbVar10 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar3.aH(5, null);
                                                bbVar10.x(aeVar3);
                                                adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar10;
                                            } else {
                                                efVar5 = null;
                                                adVar = adVar3;
                                            }
                                            dfVar8 = hgVar.d;
                                            if (dfVar8 == null) {
                                                dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            aeVar2 = dfVar8.h;
                                            if (aeVar2 == null) {
                                                aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                            }
                                            adVar.x(aeVar2);
                                        } else {
                                            efVar5 = null;
                                            adVar = adVar3;
                                        }
                                        if (zA) {
                                            anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                            if (!anVar.b.H()) {
                                                anVar.v();
                                            }
                                            com.google.android.libraries.navigation.internal.adg.ao aoVar = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                            aoVar.b |= 1;
                                            aoVar.c = i2;
                                            com.google.android.libraries.navigation.internal.adg.ao aoVar2 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                            tVar = tVar;
                                            if (!tVar.b.H()) {
                                                tVar.v();
                                            }
                                            uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                            com.google.android.libraries.navigation.internal.adg.u uVar3 = com.google.android.libraries.navigation.internal.adg.u.a;
                                            aoVar2.getClass();
                                            bzVar = uVar.b;
                                            if (!bzVar.c()) {
                                                uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                            }
                                            uVar.b.add(aoVar2);
                                            i10 = i;
                                            efVar8 = efVar5;
                                            efVarO = efVar4;
                                            iVar = iVar3;
                                            z = true;
                                            tVar = tVar;
                                        } else {
                                            sparseArray = sparseArray;
                                            ezVar = ezVar;
                                            i10 = i;
                                            efVar8 = efVar5;
                                            efVarO = efVar4;
                                            iVar = iVar3;
                                            tVar = tVar;
                                        }
                                    } else {
                                        i2 = iIntValue;
                                        tVar = tVar;
                                        iVar3 = iVar;
                                        adVar3 = adVar;
                                    }
                                    i3 = (((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).j / 8) + iY;
                                    i4 = ddVar.b;
                                    if (gVar.e(ekVar).b() > i3) {
                                        if (ekVar.k() != null) {
                                            fdVar = ekVar.k().f;
                                        } else {
                                            fdVar = ma.b;
                                        }
                                        z2 = false;
                                        iIntValue2 = ((Integer) fdVar.getOrDefault(Integer.valueOf(i4), 0)).intValue();
                                    } else {
                                        z2 = false;
                                        iIntValue2 = 0;
                                    }
                                    if (iIntValue2 != 0) {
                                        i5 = i3 - iIntValue2;
                                        if (eVarE.b() <= Math.max(iY, i5)) {
                                        }
                                    }
                                    dfVar3 = hgVar.d;
                                    if (dfVar3 == null) {
                                        dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar3.b & 2) != 0) {
                                        i = i;
                                        dfVar4 = hgVar.d;
                                        if (dfVar4 == null) {
                                            dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        int i110 = dfVar4.b;
                                    } else {
                                        i = i;
                                        dfVar4 = hgVar.d;
                                        if (dfVar4 == null) {
                                            dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        int i111 = dfVar4.b;
                                    }
                                    dfVar5 = hgVar.d;
                                    if (dfVar5 == null) {
                                        dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar5.b & 4) != 0) {
                                        dfVar12 = hgVar.d;
                                        if (dfVar12 == null) {
                                            dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar2 = dfVar12.e;
                                        if (amVar2 == null) {
                                            amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        if (amVar2.b.size() == 0) {
                                            bfVar2 = bf.a();
                                        } else {
                                            dfVar13 = hgVar.d;
                                            if (dfVar13 == null) {
                                                dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            amVar3 = dfVar13.e;
                                            if (amVar3 == null) {
                                                amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                            }
                                            com.google.android.libraries.navigation.internal.ael.bq bqVar5 = amVar3.b;
                                            if (!dyVar.b.H()) {
                                                dyVar.v();
                                            }
                                            efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                            com.google.android.libraries.navigation.internal.adg.ef efVar15 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                            bqVar = efVar7.p;
                                            if (!bqVar.c()) {
                                                efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                            }
                                            com.google.android.libraries.navigation.internal.ael.b.m(bqVar5, efVar7.p);
                                            bfVar2 = new bf(2, bg.NONE);
                                        }
                                        if (bc.a(bfVar2.b)) {
                                            if (!hgVar.m) {
                                                dVar = hgVar.i;
                                                if (dVar == null) {
                                                    dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                                }
                                                aeVar.d(dVar);
                                            }
                                            zA = true;
                                        }
                                    }
                                    dfVar6 = hgVar.d;
                                    if (dfVar6 == null) {
                                        dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if (dfVar6.g.size() > 0) {
                                        dfVar9 = hgVar.d;
                                        if (dfVar9 == null) {
                                            dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar = dfVar9.e;
                                        if (amVar == null) {
                                            amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        if (amVar.b.size() > 0) {
                                            dfVar10 = hgVar.d;
                                            if (dfVar10 == null) {
                                                dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            if (dfVar10.g.size() == 0) {
                                                bfVar = bf.a();
                                            } else {
                                                dfVar11 = hgVar.d;
                                                if (dfVar11 == null) {
                                                    dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                com.google.android.libraries.navigation.internal.ael.bz bzVar4 = dfVar11.g;
                                                if (!dyVar.b.H()) {
                                                    dyVar.v();
                                                }
                                                efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                com.google.android.libraries.navigation.internal.adg.ef efVar16 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                                bzVar2 = efVar6.t;
                                                if (!bzVar2.c()) {
                                                    efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                                }
                                                com.google.android.libraries.navigation.internal.ael.b.m(bzVar4, efVar6.t);
                                                bfVar = new bf(2, bg.NONE);
                                            }
                                            zA |= bc.a(bfVar.b);
                                        } else {
                                            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                        }
                                    }
                                    dfVar7 = hgVar.d;
                                    if (dfVar7 == null) {
                                        dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar7.b & 16) != 0) {
                                        if (adVar3 == null) {
                                            com.google.android.libraries.navigation.internal.adg.ae aeVar4 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                            efVar5 = null;
                                            com.google.android.libraries.navigation.internal.ael.bb bbVar11 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar4.aH(5, null);
                                            bbVar11.x(aeVar4);
                                            adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar11;
                                        } else {
                                            efVar5 = null;
                                            adVar = adVar3;
                                        }
                                        dfVar8 = hgVar.d;
                                        if (dfVar8 == null) {
                                            dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        aeVar2 = dfVar8.h;
                                        if (aeVar2 == null) {
                                            aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                        }
                                        adVar.x(aeVar2);
                                    } else {
                                        efVar5 = null;
                                        adVar = adVar3;
                                    }
                                    if (zA) {
                                        anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                        if (!anVar.b.H()) {
                                            anVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adg.ao aoVar3 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                        aoVar3.b |= 1;
                                        aoVar3.c = i2;
                                        com.google.android.libraries.navigation.internal.adg.ao aoVar4 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                        tVar = tVar;
                                        if (!tVar.b.H()) {
                                            tVar.v();
                                        }
                                        uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                        com.google.android.libraries.navigation.internal.adg.u uVar4 = com.google.android.libraries.navigation.internal.adg.u.a;
                                        aoVar4.getClass();
                                        bzVar = uVar.b;
                                        if (!bzVar.c()) {
                                            uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                        }
                                        uVar.b.add(aoVar4);
                                        i10 = i;
                                        efVar8 = efVar5;
                                        efVarO = efVar4;
                                        iVar = iVar3;
                                        z = true;
                                        tVar = tVar;
                                    } else {
                                        sparseArray = sparseArray;
                                        ezVar = ezVar;
                                        i10 = i;
                                        efVar8 = efVar5;
                                        efVarO = efVar4;
                                        iVar = iVar3;
                                        tVar = tVar;
                                    }
                                } else {
                                    i2 = iIntValue;
                                    tVar = tVar;
                                    iVar3 = iVar;
                                    adVar3 = adVar;
                                    z2 = false;
                                }
                                zA = z2;
                                dfVar3 = hgVar.d;
                                if (dfVar3 == null) {
                                    dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar3.b & 2) != 0) {
                                    i = i;
                                    dfVar4 = hgVar.d;
                                    if (dfVar4 == null) {
                                        dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    int i112 = dfVar4.b;
                                } else {
                                    i = i;
                                    dfVar4 = hgVar.d;
                                    if (dfVar4 == null) {
                                        dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    int i113 = dfVar4.b;
                                }
                                dfVar5 = hgVar.d;
                                if (dfVar5 == null) {
                                    dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar5.b & 4) != 0) {
                                    dfVar12 = hgVar.d;
                                    if (dfVar12 == null) {
                                        dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar2 = dfVar12.e;
                                    if (amVar2 == null) {
                                        amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    if (amVar2.b.size() == 0) {
                                        bfVar2 = bf.a();
                                    } else {
                                        dfVar13 = hgVar.d;
                                        if (dfVar13 == null) {
                                            dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar3 = dfVar13.e;
                                        if (amVar3 == null) {
                                            amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        com.google.android.libraries.navigation.internal.ael.bq bqVar6 = amVar3.b;
                                        if (!dyVar.b.H()) {
                                            dyVar.v();
                                        }
                                        efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                        com.google.android.libraries.navigation.internal.adg.ef efVar17 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                        bqVar = efVar7.p;
                                        if (!bqVar.c()) {
                                            efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                        }
                                        com.google.android.libraries.navigation.internal.ael.b.m(bqVar6, efVar7.p);
                                        bfVar2 = new bf(2, bg.NONE);
                                    }
                                    if (bc.a(bfVar2.b)) {
                                        if (!hgVar.m) {
                                            dVar = hgVar.i;
                                            if (dVar == null) {
                                                dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                            }
                                            aeVar.d(dVar);
                                        }
                                        zA = true;
                                    }
                                }
                                dfVar6 = hgVar.d;
                                if (dfVar6 == null) {
                                    dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if (dfVar6.g.size() > 0) {
                                    dfVar9 = hgVar.d;
                                    if (dfVar9 == null) {
                                        dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar = dfVar9.e;
                                    if (amVar == null) {
                                        amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    if (amVar.b.size() > 0) {
                                        dfVar10 = hgVar.d;
                                        if (dfVar10 == null) {
                                            dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if (dfVar10.g.size() == 0) {
                                            bfVar = bf.a();
                                        } else {
                                            dfVar11 = hgVar.d;
                                            if (dfVar11 == null) {
                                                dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            com.google.android.libraries.navigation.internal.ael.bz bzVar5 = dfVar11.g;
                                            if (!dyVar.b.H()) {
                                                dyVar.v();
                                            }
                                            efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                            com.google.android.libraries.navigation.internal.adg.ef efVar18 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                            bzVar2 = efVar6.t;
                                            if (!bzVar2.c()) {
                                                efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                            }
                                            com.google.android.libraries.navigation.internal.ael.b.m(bzVar5, efVar6.t);
                                            bfVar = new bf(2, bg.NONE);
                                        }
                                        zA |= bc.a(bfVar.b);
                                    } else {
                                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                    }
                                }
                                dfVar7 = hgVar.d;
                                if (dfVar7 == null) {
                                    dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar7.b & 16) != 0) {
                                    if (adVar3 == null) {
                                        com.google.android.libraries.navigation.internal.adg.ae aeVar5 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                        efVar5 = null;
                                        com.google.android.libraries.navigation.internal.ael.bb bbVar12 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar5.aH(5, null);
                                        bbVar12.x(aeVar5);
                                        adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar12;
                                    } else {
                                        efVar5 = null;
                                        adVar = adVar3;
                                    }
                                    dfVar8 = hgVar.d;
                                    if (dfVar8 == null) {
                                        dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    aeVar2 = dfVar8.h;
                                    if (aeVar2 == null) {
                                        aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                    }
                                    adVar.x(aeVar2);
                                } else {
                                    efVar5 = null;
                                    adVar = adVar3;
                                }
                                if (zA) {
                                    anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                    if (!anVar.b.H()) {
                                        anVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adg.ao aoVar5 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                    aoVar5.b |= 1;
                                    aoVar5.c = i2;
                                    com.google.android.libraries.navigation.internal.adg.ao aoVar6 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                    tVar = tVar;
                                    if (!tVar.b.H()) {
                                        tVar.v();
                                    }
                                    uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                    com.google.android.libraries.navigation.internal.adg.u uVar5 = com.google.android.libraries.navigation.internal.adg.u.a;
                                    aoVar6.getClass();
                                    bzVar = uVar.b;
                                    if (!bzVar.c()) {
                                        uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                    }
                                    uVar.b.add(aoVar6);
                                    i10 = i;
                                    efVar8 = efVar5;
                                    efVarO = efVar4;
                                    iVar = iVar3;
                                    z = true;
                                    tVar = tVar;
                                } else {
                                    sparseArray = sparseArray;
                                    ezVar = ezVar;
                                    i10 = i;
                                    efVar8 = efVar5;
                                    efVarO = efVar4;
                                    iVar = iVar3;
                                    tVar = tVar;
                                }
                            }
                            i10 = i10;
                            efVar8 = efVar3;
                            efVarO = efVar2;
                            iVar = iVar;
                            adVar = adVar;
                            tVar = tVar;
                        } else {
                            sparseArray = sparseArray;
                            ezVar = ezVar;
                            efVar8 = null;
                        }
                    }
                    tVar2 = tVar;
                    iVar2 = iVar;
                    efVar = efVar8;
                    adVar2 = adVar;
                    if (dyVar != null && adVar2 != null) {
                        dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.af, (com.google.android.libraries.navigation.internal.adg.ae) adVar2.t());
                    }
                    if (dyVar == null && z) {
                        ahVar = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.t();
                        if (!ahVar.equals(com.google.android.libraries.navigation.internal.adq.ah.a)) {
                            if (!iVar2.b.H()) {
                                iVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.ado.j jVar2 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.b;
                            ahVar.getClass();
                            jVar2.c = ahVar;
                            jVar2.b |= 1;
                            com.google.android.libraries.navigation.internal.ado.j jVar3 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.t();
                            int i22 = com.google.android.libraries.navigation.internal.rb.a.a;
                            dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.M, jVar3);
                        }
                        dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.ac, (com.google.android.libraries.navigation.internal.adg.u) tVar2.t());
                        efVar8 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.t();
                    } else {
                        efVar8 = efVar;
                    }
                }
                if (efVar8 != null) {
                    return ekVar.aa(efVar8);
                }
            }
            return ekVar;
        }
        ekVar.o();
        beVar = null;
        if (beVar != null) {
            if (!beVar.c.b.isEmpty()) {
                efVarO = ekVar.o();
                bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ac);
                efVarO.h(bhVarS);
                objK = efVarO.w.k(bhVarS.d);
                if (objK == null) {
                    objC = bhVarS.b;
                } else {
                    objC = bhVarS.c(objK);
                }
                com.google.android.libraries.navigation.internal.adg.u uVar6 = (com.google.android.libraries.navigation.internal.adg.u) objC;
                com.google.android.libraries.navigation.internal.ael.bb bbVar13 = (com.google.android.libraries.navigation.internal.ael.bb) uVar6.aH(5, null);
                bbVar13.x(uVar6);
                tVar = (com.google.android.libraries.navigation.internal.adg.t) bbVar13;
                jVarS = ekVar.s();
                if (jVarS != null) {
                    com.google.android.libraries.navigation.internal.ael.bb bbVar14 = (com.google.android.libraries.navigation.internal.ael.bb) jVarS.aH(5, null);
                    bbVar14.x(jVarS);
                    iVar = (com.google.android.libraries.navigation.internal.ado.i) bbVar14;
                } else {
                    iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                }
                jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
                if ((jVar.b & 1) != 0) {
                    ahVar2 = jVar.c;
                    if (ahVar2 == null) {
                        ahVar2 = com.google.android.libraries.navigation.internal.adq.ah.a;
                    }
                    com.google.android.libraries.navigation.internal.ael.bb bbVar15 = (com.google.android.libraries.navigation.internal.ael.bb) ahVar2.aH(5, null);
                    bbVar15.x(ahVar2);
                    aeVar = (com.google.android.libraries.navigation.internal.adq.ae) bbVar15;
                } else {
                    aeVar = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                }
                it2 = beVar.c.b.iterator();
                dyVar = null;
                adVar = null;
                int i114 = 0;
                z = false;
                while (it2.hasNext()) {
                    iIntValue = ((Integer) it2.next()).intValue();
                    hgVar = (hg) sparseArray.get(iIntValue);
                    it2 = it2;
                    if (hgVar != null) {
                        if (dyVar == null) {
                            com.google.android.libraries.navigation.internal.ael.bb bbVar16 = (com.google.android.libraries.navigation.internal.ael.bb) efVarO.aH(5, null);
                            bbVar16.x(efVarO);
                            dyVar = (com.google.android.libraries.navigation.internal.adg.dy) bbVar16;
                        }
                        if (com.google.android.libraries.navigation.internal.pa.a.b(hgVar, ezVar)) {
                            dfVar = hgVar.d;
                            if (dfVar == null) {
                                dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if ((dfVar.b & 4) != 0) {
                                dfVar15 = hgVar.d;
                                if (dfVar15 == null) {
                                    dfVar15 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if (dfVar15.g.size() == 0) {
                                    dfVar16 = hgVar.d;
                                    if (dfVar16 == null) {
                                        dfVar16 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar4 = dfVar16.e;
                                    if (amVar4 == null) {
                                        amVar4 = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    it3 = amVar4.b.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            num = (Integer) it3.next();
                                            efVar2 = efVarO;
                                            iIntValue3 = num.intValue();
                                            i6 = ie.C;
                                            it4 = it3;
                                            i7 = i6 - 1;
                                            if (i6 != 0) {
                                                throw null;
                                            }
                                            if (iIntValue3 != i7) {
                                                iIntValue4 = num.intValue();
                                                i8 = ie.I;
                                                i9 = i8 - 1;
                                                if (i8 != 0) {
                                                    throw null;
                                                }
                                                if (iIntValue4 == i9) {
                                                    efVarO = efVar2;
                                                    it3 = it4;
                                                }
                                            }
                                            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 936)).p("Photopin annotation received without data-bound value.");
                                            efVar3 = null;
                                        }
                                    }
                                }
                            }
                            efVar4 = efVarO;
                            dfVar2 = hgVar.d;
                            if (dfVar2 == null) {
                                dfVar2 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if ((dfVar2.b & 8) != 0) {
                                gVar = this.c;
                                dfVar14 = hgVar.d;
                                if (dfVar14 == null) {
                                    dfVar14 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                ddVar = dfVar14.f;
                                if (ddVar == null) {
                                    ddVar = com.google.android.libraries.navigation.internal.adg.dd.a;
                                }
                                iY = ekVar.Y();
                                eVarE = gVar.e(ekVar);
                                if (ekVar.ac() != null) {
                                    iVar3 = iVar;
                                    eVarE2 = gVar.e(ekVar);
                                    if (eVarE2.d()) {
                                        iA = 0;
                                    } else {
                                        iA = eVarE2.a(0);
                                    }
                                    i2 = iIntValue;
                                    adVar3 = adVar;
                                    i3 = 1;
                                    while (true) {
                                        if (i3 < eVarE2.b()) {
                                            if (((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).i < eVarE2.a(i3)) {
                                            }
                                            iA = eVarE2.a(i3);
                                            i3++;
                                        }
                                    }
                                    i4 = ddVar.b;
                                    if (gVar.e(ekVar).b() > i3) {
                                        if (ekVar.k() != null) {
                                            fdVar = ekVar.k().f;
                                        } else {
                                            fdVar = ma.b;
                                        }
                                        z2 = false;
                                        iIntValue2 = ((Integer) fdVar.getOrDefault(Integer.valueOf(i4), 0)).intValue();
                                    } else {
                                        z2 = false;
                                        iIntValue2 = 0;
                                    }
                                    if (iIntValue2 != 0) {
                                        i5 = i3 - iIntValue2;
                                        if (eVarE.b() <= Math.max(iY, i5)) {
                                        }
                                    }
                                    dfVar3 = hgVar.d;
                                    if (dfVar3 == null) {
                                        dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar3.b & 2) != 0) {
                                        i = i;
                                        dfVar4 = hgVar.d;
                                        if (dfVar4 == null) {
                                            dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        int i115 = dfVar4.b;
                                    } else {
                                        i = i;
                                        dfVar4 = hgVar.d;
                                        if (dfVar4 == null) {
                                            dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        int i116 = dfVar4.b;
                                    }
                                    dfVar5 = hgVar.d;
                                    if (dfVar5 == null) {
                                        dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar5.b & 4) != 0) {
                                        dfVar12 = hgVar.d;
                                        if (dfVar12 == null) {
                                            dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar2 = dfVar12.e;
                                        if (amVar2 == null) {
                                            amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        if (amVar2.b.size() == 0) {
                                            bfVar2 = bf.a();
                                        } else {
                                            dfVar13 = hgVar.d;
                                            if (dfVar13 == null) {
                                                dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            amVar3 = dfVar13.e;
                                            if (amVar3 == null) {
                                                amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                            }
                                            com.google.android.libraries.navigation.internal.ael.bq bqVar7 = amVar3.b;
                                            if (!dyVar.b.H()) {
                                                dyVar.v();
                                            }
                                            efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                            com.google.android.libraries.navigation.internal.adg.ef efVar19 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                            bqVar = efVar7.p;
                                            if (!bqVar.c()) {
                                                efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                            }
                                            com.google.android.libraries.navigation.internal.ael.b.m(bqVar7, efVar7.p);
                                            bfVar2 = new bf(2, bg.NONE);
                                        }
                                        if (bc.a(bfVar2.b)) {
                                            if (!hgVar.m) {
                                                dVar = hgVar.i;
                                                if (dVar == null) {
                                                    dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                                }
                                                aeVar.d(dVar);
                                            }
                                            zA = true;
                                        }
                                    }
                                    dfVar6 = hgVar.d;
                                    if (dfVar6 == null) {
                                        dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if (dfVar6.g.size() > 0) {
                                        dfVar9 = hgVar.d;
                                        if (dfVar9 == null) {
                                            dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar = dfVar9.e;
                                        if (amVar == null) {
                                            amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        if (amVar.b.size() > 0) {
                                            dfVar10 = hgVar.d;
                                            if (dfVar10 == null) {
                                                dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            if (dfVar10.g.size() == 0) {
                                                bfVar = bf.a();
                                            } else {
                                                dfVar11 = hgVar.d;
                                                if (dfVar11 == null) {
                                                    dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                                }
                                                com.google.android.libraries.navigation.internal.ael.bz bzVar6 = dfVar11.g;
                                                if (!dyVar.b.H()) {
                                                    dyVar.v();
                                                }
                                                efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                                com.google.android.libraries.navigation.internal.adg.ef efVar110 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                                bzVar2 = efVar6.t;
                                                if (!bzVar2.c()) {
                                                    efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                                }
                                                com.google.android.libraries.navigation.internal.ael.b.m(bzVar6, efVar6.t);
                                                bfVar = new bf(2, bg.NONE);
                                            }
                                            zA |= bc.a(bfVar.b);
                                        } else {
                                            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                        }
                                    }
                                    dfVar7 = hgVar.d;
                                    if (dfVar7 == null) {
                                        dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if ((dfVar7.b & 16) != 0) {
                                        if (adVar3 == null) {
                                            com.google.android.libraries.navigation.internal.adg.ae aeVar6 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                            efVar5 = null;
                                            com.google.android.libraries.navigation.internal.ael.bb bbVar17 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar6.aH(5, null);
                                            bbVar17.x(aeVar6);
                                            adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar17;
                                        } else {
                                            efVar5 = null;
                                            adVar = adVar3;
                                        }
                                        dfVar8 = hgVar.d;
                                        if (dfVar8 == null) {
                                            dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        aeVar2 = dfVar8.h;
                                        if (aeVar2 == null) {
                                            aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                        }
                                        adVar.x(aeVar2);
                                    } else {
                                        efVar5 = null;
                                        adVar = adVar3;
                                    }
                                    if (zA) {
                                        anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                        if (!anVar.b.H()) {
                                            anVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adg.ao aoVar7 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                        aoVar7.b |= 1;
                                        aoVar7.c = i2;
                                        com.google.android.libraries.navigation.internal.adg.ao aoVar8 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                        tVar = tVar;
                                        if (!tVar.b.H()) {
                                            tVar.v();
                                        }
                                        uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                        com.google.android.libraries.navigation.internal.adg.u uVar7 = com.google.android.libraries.navigation.internal.adg.u.a;
                                        aoVar8.getClass();
                                        bzVar = uVar.b;
                                        if (!bzVar.c()) {
                                            uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                        }
                                        uVar.b.add(aoVar8);
                                        i10 = i;
                                        efVar8 = efVar5;
                                        efVarO = efVar4;
                                        iVar = iVar3;
                                        z = true;
                                        tVar = tVar;
                                    } else {
                                        sparseArray = sparseArray;
                                        ezVar = ezVar;
                                        i10 = i;
                                        efVar8 = efVar5;
                                        efVarO = efVar4;
                                        iVar = iVar3;
                                        tVar = tVar;
                                    }
                                } else {
                                    i2 = iIntValue;
                                    tVar = tVar;
                                    iVar3 = iVar;
                                    adVar3 = adVar;
                                }
                                i3 = (((com.google.android.libraries.navigation.internal.adg.ef) dyVar.b).j / 8) + iY;
                                i4 = ddVar.b;
                                if (gVar.e(ekVar).b() > i3) {
                                    if (ekVar.k() != null) {
                                        fdVar = ekVar.k().f;
                                    } else {
                                        fdVar = ma.b;
                                    }
                                    z2 = false;
                                    iIntValue2 = ((Integer) fdVar.getOrDefault(Integer.valueOf(i4), 0)).intValue();
                                } else {
                                    z2 = false;
                                    iIntValue2 = 0;
                                }
                                if (iIntValue2 != 0) {
                                    i5 = i3 - iIntValue2;
                                    if (eVarE.b() <= Math.max(iY, i5)) {
                                    }
                                }
                                dfVar3 = hgVar.d;
                                if (dfVar3 == null) {
                                    dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar3.b & 2) != 0) {
                                    i = i;
                                    dfVar4 = hgVar.d;
                                    if (dfVar4 == null) {
                                        dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    int i117 = dfVar4.b;
                                } else {
                                    i = i;
                                    dfVar4 = hgVar.d;
                                    if (dfVar4 == null) {
                                        dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    int i118 = dfVar4.b;
                                }
                                dfVar5 = hgVar.d;
                                if (dfVar5 == null) {
                                    dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar5.b & 4) != 0) {
                                    dfVar12 = hgVar.d;
                                    if (dfVar12 == null) {
                                        dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar2 = dfVar12.e;
                                    if (amVar2 == null) {
                                        amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    if (amVar2.b.size() == 0) {
                                        bfVar2 = bf.a();
                                    } else {
                                        dfVar13 = hgVar.d;
                                        if (dfVar13 == null) {
                                            dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        amVar3 = dfVar13.e;
                                        if (amVar3 == null) {
                                            amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                        }
                                        com.google.android.libraries.navigation.internal.ael.bq bqVar8 = amVar3.b;
                                        if (!dyVar.b.H()) {
                                            dyVar.v();
                                        }
                                        efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                        com.google.android.libraries.navigation.internal.adg.ef efVar111 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                        bqVar = efVar7.p;
                                        if (!bqVar.c()) {
                                            efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                        }
                                        com.google.android.libraries.navigation.internal.ael.b.m(bqVar8, efVar7.p);
                                        bfVar2 = new bf(2, bg.NONE);
                                    }
                                    if (bc.a(bfVar2.b)) {
                                        if (!hgVar.m) {
                                            dVar = hgVar.i;
                                            if (dVar == null) {
                                                dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                            }
                                            aeVar.d(dVar);
                                        }
                                        zA = true;
                                    }
                                }
                                dfVar6 = hgVar.d;
                                if (dfVar6 == null) {
                                    dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if (dfVar6.g.size() > 0) {
                                    dfVar9 = hgVar.d;
                                    if (dfVar9 == null) {
                                        dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar = dfVar9.e;
                                    if (amVar == null) {
                                        amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    if (amVar.b.size() > 0) {
                                        dfVar10 = hgVar.d;
                                        if (dfVar10 == null) {
                                            dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        if (dfVar10.g.size() == 0) {
                                            bfVar = bf.a();
                                        } else {
                                            dfVar11 = hgVar.d;
                                            if (dfVar11 == null) {
                                                dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                            }
                                            com.google.android.libraries.navigation.internal.ael.bz bzVar7 = dfVar11.g;
                                            if (!dyVar.b.H()) {
                                                dyVar.v();
                                            }
                                            efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                            com.google.android.libraries.navigation.internal.adg.ef efVar112 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                            bzVar2 = efVar6.t;
                                            if (!bzVar2.c()) {
                                                efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                            }
                                            com.google.android.libraries.navigation.internal.ael.b.m(bzVar7, efVar6.t);
                                            bfVar = new bf(2, bg.NONE);
                                        }
                                        zA |= bc.a(bfVar.b);
                                    } else {
                                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                    }
                                }
                                dfVar7 = hgVar.d;
                                if (dfVar7 == null) {
                                    dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                if ((dfVar7.b & 16) != 0) {
                                    if (adVar3 == null) {
                                        com.google.android.libraries.navigation.internal.adg.ae aeVar7 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                        efVar5 = null;
                                        com.google.android.libraries.navigation.internal.ael.bb bbVar18 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar7.aH(5, null);
                                        bbVar18.x(aeVar7);
                                        adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar18;
                                    } else {
                                        efVar5 = null;
                                        adVar = adVar3;
                                    }
                                    dfVar8 = hgVar.d;
                                    if (dfVar8 == null) {
                                        dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    aeVar2 = dfVar8.h;
                                    if (aeVar2 == null) {
                                        aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                    }
                                    adVar.x(aeVar2);
                                } else {
                                    efVar5 = null;
                                    adVar = adVar3;
                                }
                                if (zA) {
                                    anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                    if (!anVar.b.H()) {
                                        anVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adg.ao aoVar9 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                    aoVar9.b |= 1;
                                    aoVar9.c = i2;
                                    com.google.android.libraries.navigation.internal.adg.ao aoVar10 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                    tVar = tVar;
                                    if (!tVar.b.H()) {
                                        tVar.v();
                                    }
                                    uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                    com.google.android.libraries.navigation.internal.adg.u uVar8 = com.google.android.libraries.navigation.internal.adg.u.a;
                                    aoVar10.getClass();
                                    bzVar = uVar.b;
                                    if (!bzVar.c()) {
                                        uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                    }
                                    uVar.b.add(aoVar10);
                                    i10 = i;
                                    efVar8 = efVar5;
                                    efVarO = efVar4;
                                    iVar = iVar3;
                                    z = true;
                                    tVar = tVar;
                                } else {
                                    sparseArray = sparseArray;
                                    ezVar = ezVar;
                                    i10 = i;
                                    efVar8 = efVar5;
                                    efVarO = efVar4;
                                    iVar = iVar3;
                                    tVar = tVar;
                                }
                            } else {
                                i2 = iIntValue;
                                tVar = tVar;
                                iVar3 = iVar;
                                adVar3 = adVar;
                                z2 = false;
                            }
                            zA = z2;
                            dfVar3 = hgVar.d;
                            if (dfVar3 == null) {
                                dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if ((dfVar3.b & 2) != 0) {
                                i = i;
                                dfVar4 = hgVar.d;
                                if (dfVar4 == null) {
                                    dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                int i119 = dfVar4.b;
                            } else {
                                i = i;
                                dfVar4 = hgVar.d;
                                if (dfVar4 == null) {
                                    dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                int i1110 = dfVar4.b;
                            }
                            dfVar5 = hgVar.d;
                            if (dfVar5 == null) {
                                dfVar5 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if ((dfVar5.b & 4) != 0) {
                                dfVar12 = hgVar.d;
                                if (dfVar12 == null) {
                                    dfVar12 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                amVar2 = dfVar12.e;
                                if (amVar2 == null) {
                                    amVar2 = com.google.android.libraries.navigation.internal.adg.am.a;
                                }
                                if (amVar2.b.size() == 0) {
                                    bfVar2 = bf.a();
                                } else {
                                    dfVar13 = hgVar.d;
                                    if (dfVar13 == null) {
                                        dfVar13 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    amVar3 = dfVar13.e;
                                    if (amVar3 == null) {
                                        amVar3 = com.google.android.libraries.navigation.internal.adg.am.a;
                                    }
                                    com.google.android.libraries.navigation.internal.ael.bq bqVar9 = amVar3.b;
                                    if (!dyVar.b.H()) {
                                        dyVar.v();
                                    }
                                    efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                    com.google.android.libraries.navigation.internal.adg.ef efVar113 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                    bqVar = efVar7.p;
                                    if (!bqVar.c()) {
                                        efVar7.p = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
                                    }
                                    com.google.android.libraries.navigation.internal.ael.b.m(bqVar9, efVar7.p);
                                    bfVar2 = new bf(2, bg.NONE);
                                }
                                if (bc.a(bfVar2.b)) {
                                    if (!hgVar.m) {
                                        dVar = hgVar.i;
                                        if (dVar == null) {
                                            dVar = com.google.android.libraries.navigation.internal.adq.d.a;
                                        }
                                        aeVar.d(dVar);
                                    }
                                    zA = true;
                                }
                            }
                            dfVar6 = hgVar.d;
                            if (dfVar6 == null) {
                                dfVar6 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if (dfVar6.g.size() > 0) {
                                dfVar9 = hgVar.d;
                                if (dfVar9 == null) {
                                    dfVar9 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                amVar = dfVar9.e;
                                if (amVar == null) {
                                    amVar = com.google.android.libraries.navigation.internal.adg.am.a;
                                }
                                if (amVar.b.size() > 0) {
                                    dfVar10 = hgVar.d;
                                    if (dfVar10 == null) {
                                        dfVar10 = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    if (dfVar10.g.size() == 0) {
                                        bfVar = bf.a();
                                    } else {
                                        dfVar11 = hgVar.d;
                                        if (dfVar11 == null) {
                                            dfVar11 = com.google.android.libraries.navigation.internal.adg.df.a;
                                        }
                                        com.google.android.libraries.navigation.internal.ael.bz bzVar8 = dfVar11.g;
                                        if (!dyVar.b.H()) {
                                            dyVar.v();
                                        }
                                        efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
                                        com.google.android.libraries.navigation.internal.adg.ef efVar114 = com.google.android.libraries.navigation.internal.adg.ef.a;
                                        bzVar2 = efVar6.t;
                                        if (!bzVar2.c()) {
                                            efVar6.t = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                                        }
                                        com.google.android.libraries.navigation.internal.ael.b.m(bzVar8, efVar6.t);
                                        bfVar = new bf(2, bg.NONE);
                                    }
                                    zA |= bc.a(bfVar.b);
                                } else {
                                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 935)).p("Unexpected data-bound values received without style transform.");
                                }
                            }
                            dfVar7 = hgVar.d;
                            if (dfVar7 == null) {
                                dfVar7 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            if ((dfVar7.b & 16) != 0) {
                                if (adVar3 == null) {
                                    com.google.android.libraries.navigation.internal.adg.ae aeVar8 = (com.google.android.libraries.navigation.internal.adg.ae) dyVar.y(com.google.android.libraries.navigation.internal.adg.bj.af);
                                    efVar5 = null;
                                    com.google.android.libraries.navigation.internal.ael.bb bbVar19 = (com.google.android.libraries.navigation.internal.ael.bb) aeVar8.aH(5, null);
                                    bbVar19.x(aeVar8);
                                    adVar = (com.google.android.libraries.navigation.internal.adg.ad) bbVar19;
                                } else {
                                    efVar5 = null;
                                    adVar = adVar3;
                                }
                                dfVar8 = hgVar.d;
                                if (dfVar8 == null) {
                                    dfVar8 = com.google.android.libraries.navigation.internal.adg.df.a;
                                }
                                aeVar2 = dfVar8.h;
                                if (aeVar2 == null) {
                                    aeVar2 = com.google.android.libraries.navigation.internal.adg.ae.a;
                                }
                                adVar.x(aeVar2);
                            } else {
                                efVar5 = null;
                                adVar = adVar3;
                            }
                            if (zA) {
                                anVar = (com.google.android.libraries.navigation.internal.adg.an) com.google.android.libraries.navigation.internal.adg.ao.a.q();
                                if (!anVar.b.H()) {
                                    anVar.v();
                                }
                                com.google.android.libraries.navigation.internal.adg.ao aoVar11 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.b;
                                aoVar11.b |= 1;
                                aoVar11.c = i2;
                                com.google.android.libraries.navigation.internal.adg.ao aoVar12 = (com.google.android.libraries.navigation.internal.adg.ao) anVar.t();
                                tVar = tVar;
                                if (!tVar.b.H()) {
                                    tVar.v();
                                }
                                uVar = (com.google.android.libraries.navigation.internal.adg.u) tVar.b;
                                com.google.android.libraries.navigation.internal.adg.u uVar9 = com.google.android.libraries.navigation.internal.adg.u.a;
                                aoVar12.getClass();
                                bzVar = uVar.b;
                                if (!bzVar.c()) {
                                    uVar.b = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                                }
                                uVar.b.add(aoVar12);
                                i10 = i;
                                efVar8 = efVar5;
                                efVarO = efVar4;
                                iVar = iVar3;
                                z = true;
                                tVar = tVar;
                            } else {
                                sparseArray = sparseArray;
                                ezVar = ezVar;
                                i10 = i;
                                efVar8 = efVar5;
                                efVarO = efVar4;
                                iVar = iVar3;
                                tVar = tVar;
                            }
                        } else {
                            efVar2 = efVarO;
                            efVar3 = null;
                        }
                        i10 = i10;
                        efVar8 = efVar3;
                        efVarO = efVar2;
                        iVar = iVar;
                        adVar = adVar;
                        tVar = tVar;
                    } else {
                        sparseArray = sparseArray;
                        ezVar = ezVar;
                        efVar8 = null;
                    }
                }
                tVar2 = tVar;
                iVar2 = iVar;
                efVar = efVar8;
                adVar2 = adVar;
                if (dyVar != null) {
                    dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.af, (com.google.android.libraries.navigation.internal.adg.ae) adVar2.t());
                }
                if (dyVar == null) {
                    efVar8 = efVar;
                } else {
                    ahVar = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.t();
                    if (!ahVar.equals(com.google.android.libraries.navigation.internal.adq.ah.a)) {
                        if (!iVar2.b.H()) {
                            iVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.ado.j jVar4 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.b;
                        ahVar.getClass();
                        jVar4.c = ahVar;
                        jVar4.b |= 1;
                        com.google.android.libraries.navigation.internal.ado.j jVar5 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.t();
                        int i23 = com.google.android.libraries.navigation.internal.rb.a.a;
                        dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.M, jVar5);
                    }
                    dyVar.C(com.google.android.libraries.navigation.internal.adg.bj.ac, (com.google.android.libraries.navigation.internal.adg.u) tVar2.t());
                    efVar8 = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.t();
                }
            }
            if (efVar8 != null) {
                return ekVar.aa(efVar8);
            }
        }
        return ekVar;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0221  */
    /* JADX WARN: Code duplicated, block: B:126:0x023a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0247  */
    /* JADX WARN: Code duplicated, block: B:128:0x0258  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6 A[PHI: r18
      0x00c6: PHI (r18v6 int) = (r18v0 int), (r18v7 int) binds: [B:101:0x019a, B:44:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x015b  */
    /* JADX WARN: Code duplicated, block: B:83:0x015f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0165  */
    /* JADX WARN: Code duplicated, block: B:90:0x016c  */
    /* JADX WARN: Code duplicated, block: B:91:0x016e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0175  */
    /* JADX WARN: Code duplicated, block: B:96:0x017a  */
    public final void a(ArrayList arrayList, float f, f fVar) {
        fy fyVarO;
        SparseArray sparseArray;
        int i;
        int i2;
        boolean zA;
        Iterator it2;
        int i3;
        SparseArray sparseArray2;
        com.google.android.libraries.navigation.internal.adg.df dfVar;
        com.google.android.libraries.navigation.internal.adg.dd ddVar;
        ek ekVarC;
        bd bdVar;
        int i4;
        ez ezVar;
        int i5;
        d dVar;
        c cVar;
        ArrayList arrayList2 = arrayList;
        Object objA = this.d.a();
        com.google.android.libraries.navigation.internal.om.n nVar = (com.google.android.libraries.navigation.internal.om.n) objA;
        if (nVar.g()) {
            return;
        }
        ez ezVarD = nVar.d();
        int i6 = (int) f;
        synchronized (this) {
            fyVarO = fy.o(this.h);
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelAnnotationApplier.buildAnnotationMatcher");
        try {
            j jVar = this.f;
            com.google.android.libraries.geo.mapcore.internal.model.v vVar = ((com.google.android.libraries.navigation.internal.po.cp) this.c).b;
            bd bdVar2 = new bd(jVar, fVar, vVar == null ? new com.google.android.libraries.navigation.internal.po.cn() : new com.google.android.libraries.navigation.internal.po.co(vVar), ezVarD, fyVarO, i6, ((com.google.android.libraries.navigation.internal.om.n) objA).u());
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.agg.dh dhVar = new com.google.android.libraries.navigation.internal.agg.dh(2);
            int i7 = 0;
            while (i7 < arrayList.size()) {
                ek ekVar = (ek) arrayList2.get(i7);
                boolean zAd = ekVar.ad(bdVar2.f);
                long jE = ekVar.e();
                if (jE != 0) {
                    sparseArray = (SparseArray) bdVar2.a.h(jE);
                    if (!zAd && sparseArray != null) {
                        for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                            com.google.android.libraries.navigation.internal.adg.df dfVar2 = ((hg) sparseArray.valueAt(i8)).d;
                            if (dfVar2 == null) {
                                dfVar2 = com.google.android.libraries.navigation.internal.adg.df.a;
                            }
                            com.google.android.libraries.navigation.internal.adg.dd ddVar2 = dfVar2.f;
                            if (ddVar2 == null) {
                                ddVar2 = com.google.android.libraries.navigation.internal.adg.dd.a;
                            }
                            if (ddVar2.b != 0) {
                                zAd = true;
                                break;
                            }
                        }
                    }
                } else {
                    sparseArray = null;
                }
                if (bdVar2.g || ekVar.o().q.size() != 0) {
                    Iterator it3 = bdVar2.b.iterator();
                    boolean z = false;
                    while (it3.hasNext()) {
                        hg hgVar = (hg) it3.next();
                        j jVar2 = bdVar2.d;
                        int iT = ekVar.T();
                        i iVar = jVar2.b;
                        iVar.a = iT;
                        iVar.b = hgVar;
                        h hVar = (h) jVar2.a.get(iVar);
                        if (hVar == null) {
                            i2 = 1;
                        } else {
                            hVar.a = jVar2.c;
                            i2 = hVar.b;
                        }
                        int i9 = i2 - 1;
                        if (i9 != 0) {
                            i3 = i7;
                            it2 = it3;
                            if (i9 != 1) {
                                it3 = it2;
                                i7 = i3;
                            } else {
                                if (zAd) {
                                    zAd = true;
                                } else {
                                    dfVar = hgVar.d;
                                    if (dfVar == null) {
                                        dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    ddVar = dfVar.f;
                                    if (ddVar == null) {
                                        ddVar = com.google.android.libraries.navigation.internal.adg.dd.a;
                                    }
                                    if (ddVar.b != 0) {
                                        zAd = true;
                                    } else {
                                        zAd = false;
                                    }
                                }
                                if (z || sparseArray == null) {
                                    if (sparseArray != null) {
                                        sparseArray2 = sparseArray.clone();
                                    } else {
                                        sparseArray2 = new SparseArray();
                                    }
                                    sparseArray = sparseArray2;
                                }
                                bd.a(bdVar2.c, sparseArray, hgVar);
                                it3 = it2;
                                i7 = i3;
                                z = true;
                            }
                        } else {
                            if (bdVar2.g) {
                                com.google.android.libraries.navigation.internal.qc.f fVar2 = bdVar2.e;
                                ho hoVar = hgVar.c;
                                if (hoVar == null) {
                                    hoVar = ho.a;
                                }
                                com.google.android.libraries.navigation.internal.adg.ag agVar = hoVar.d;
                                if (agVar == null) {
                                    agVar = com.google.android.libraries.navigation.internal.adg.ag.a;
                                }
                                zA = fVar2.a(ekVar, agVar);
                            } else {
                                com.google.android.libraries.navigation.internal.ael.bz bzVar = ekVar.o().q;
                                ho hoVar2 = hgVar.c;
                                if (hoVar2 == null) {
                                    hoVar2 = ho.a;
                                }
                                com.google.android.libraries.navigation.internal.adg.ag agVar2 = hoVar2.d;
                                if (agVar2 == null) {
                                    agVar2 = com.google.android.libraries.navigation.internal.adg.ag.a;
                                }
                                zA = com.google.android.libraries.geo.mapcore.internal.model.f.a(bzVar, agVar2);
                            }
                            j jVar3 = bdVar2.d;
                            it2 = it3;
                            i3 = i7;
                            jVar3.a.put(new i(ekVar.T(), hgVar), new h(jVar3.c, true != zA ? 3 : 2));
                            if (zA) {
                                if (zAd) {
                                    zAd = true;
                                } else {
                                    dfVar = hgVar.d;
                                    if (dfVar == null) {
                                        dfVar = com.google.android.libraries.navigation.internal.adg.df.a;
                                    }
                                    ddVar = dfVar.f;
                                    if (ddVar == null) {
                                        ddVar = com.google.android.libraries.navigation.internal.adg.dd.a;
                                    }
                                    if (ddVar.b != 0) {
                                        zAd = true;
                                    } else {
                                        zAd = false;
                                    }
                                }
                                if (z) {
                                    if (sparseArray != null) {
                                        sparseArray2 = sparseArray.clone();
                                    } else {
                                        sparseArray2 = new SparseArray();
                                    }
                                    sparseArray = sparseArray2;
                                } else {
                                    if (sparseArray != null) {
                                        sparseArray2 = sparseArray.clone();
                                    } else {
                                        sparseArray2 = new SparseArray();
                                    }
                                    sparseArray = sparseArray2;
                                }
                                bd.a(bdVar2.c, sparseArray, hgVar);
                                it3 = it2;
                                i7 = i3;
                                z = true;
                            } else {
                                it3 = it2;
                                i7 = i3;
                            }
                        }
                    }
                    i = i7;
                    if (!zAd) {
                        sparseArray = null;
                    }
                } else {
                    i = i7;
                    if (!zAd) {
                        sparseArray = null;
                    }
                }
                if (sparseArray == null) {
                    arrayList2 = arrayList;
                    bdVar = bdVar2;
                    i4 = i6;
                    ezVar = ezVarD;
                    i5 = i;
                } else {
                    ekVar.o();
                    sparseArray.size();
                    ArrayList arrayListF = hx.f(sparseArray.size());
                    for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                        arrayListF.add((hg) sparseArray.valueAt(i10));
                    }
                    com.google.android.libraries.navigation.internal.pa.a.a(arrayListF, ezVarD, this.e);
                    d dVar2 = this.g;
                    c cVar2 = (c) dVar2.a.get(ekVar);
                    if (cVar2 == null) {
                        dVar2.e++;
                    } else if (arrayListF.size() != cVar2.b.b) {
                        dVar2.d++;
                    } else {
                        Iterator it4 = arrayListF.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                dVar2.c++;
                                cVar2.c = dVar2.b;
                                ekVarC = cVar2.a;
                                break;
                            }
                            if (!cVar2.b.contains((hg) it4.next())) {
                                dVar2.d++;
                            }
                        }
                        if (ekVarC == null) {
                            bdVar = bdVar2;
                            i4 = i6;
                            ezVar = ezVarD;
                            ekVarC = c(ekVar, sparseArray, i6, ezVarD, dhVar);
                            dVar = this.g;
                            cVar = (c) dVar.a.get(ekVar);
                            if (cVar == null) {
                                dVar.a.put(ekVar, new c(ekVarC, arrayListF, dVar.b));
                            } else {
                                int i11 = dVar.b;
                                cVar.a = ekVarC;
                                cVar.b.clear();
                                cVar.b.addAll(arrayListF);
                                cVar.c = i11;
                            }
                        } else {
                            bdVar = bdVar2;
                            i4 = i6;
                            ezVar = ezVarD;
                        }
                        arrayList2 = arrayList;
                        i5 = i;
                        arrayList2.set(i5, ekVarC);
                    }
                    ekVarC = null;
                    if (ekVarC == null) {
                        bdVar = bdVar2;
                        i4 = i6;
                        ezVar = ezVarD;
                        ekVarC = c(ekVar, sparseArray, i6, ezVarD, dhVar);
                        dVar = this.g;
                        cVar = (c) dVar.a.get(ekVar);
                        if (cVar == null) {
                            dVar.a.put(ekVar, new c(ekVarC, arrayListF, dVar.b));
                        } else {
                            int i12 = dVar.b;
                            cVar.a = ekVarC;
                            cVar.b.clear();
                            cVar.b.addAll(arrayListF);
                            cVar.c = i12;
                        }
                    } else {
                        bdVar = bdVar2;
                        i4 = i6;
                        ezVar = ezVarD;
                    }
                    arrayList2 = arrayList;
                    i5 = i;
                    arrayList2.set(i5, ekVarC);
                }
                bdVar2 = bdVar;
                i6 = i4;
                ezVarD = ezVar;
                i7 = i5 + 1;
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("LabelAnnotationApplier.endPassForCache");
            try {
                j jVar4 = this.f;
                gi giVarListIterator = jVar4.a.values().listIterator();
                while (giVarListIterator.hasNext()) {
                    if (((h) giVarListIterator.next()).a != jVar4.c) {
                        giVarListIterator.remove();
                    }
                }
                jVar4.c++;
                d dVar3 = this.g;
                gi giVarA = dVar3.a.d().a();
                while (giVarA.hasNext()) {
                    if (((c) ((jd) giVarA).next().getValue()).c != dVar3.b) {
                        giVarA.remove();
                    }
                }
                dVar3.b++;
                if (dVarB2 != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (dVarB2 == null) {
                    throw th;
                }
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (dVarB == null) {
                throw th3;
            }
            try {
                Trace.endSection();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public final void b() {
        this.f.a.clear();
        this.g.a.clear();
    }
}
