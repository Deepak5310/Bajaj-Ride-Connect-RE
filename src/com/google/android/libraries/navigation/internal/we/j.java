package com.google.android.libraries.navigation.internal.we;

import android.content.Context;
import com.google.android.libraries.navigation.internal.add.bh;
import com.google.android.libraries.navigation.internal.add.bj;
import com.google.android.libraries.navigation.internal.add.bk;
import com.google.android.libraries.navigation.internal.add.bl;
import com.google.android.libraries.navigation.internal.add.bm;
import com.google.android.libraries.navigation.internal.add.bn;
import com.google.android.libraries.navigation.internal.add.bo;
import com.google.android.libraries.navigation.internal.add.bp;
import com.google.android.libraries.navigation.internal.add.bs;
import com.google.android.libraries.navigation.internal.add.bt;
import com.google.android.libraries.navigation.internal.add.bu;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.en;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.ry.c;
import com.google.android.libraries.navigation.internal.ry.d;
import com.google.android.libraries.navigation.internal.rz.al;
import com.google.android.libraries.navigation.internal.rz.am;
import com.google.android.libraries.navigation.internal.rz.an;
import com.google.android.libraries.navigation.internal.rz.o;
import com.google.android.libraries.navigation.internal.rz.p;
import com.google.android.libraries.navigation.internal.sa.f;
import com.google.android.libraries.navigation.internal.sa.h;
import com.google.android.libraries.navigation.internal.up.e;
import com.google.android.libraries.navigation.internal.up.g;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements i {
    private final com.google.android.libraries.navigation.internal.wf.l a;
    private final Context b;
    private final com.google.android.libraries.navigation.internal.kl.b c;
    private String d;
    private com.google.android.libraries.navigation.internal.wl.d e = com.google.android.libraries.navigation.internal.wl.d.c;
    private fd f = ma.b;
    private com.google.android.libraries.navigation.internal.ade.n g = com.google.android.libraries.navigation.internal.ade.n.a;
    private long h;
    private final com.google.android.libraries.navigation.internal.wp.a i;

    public j(com.google.android.libraries.navigation.internal.wf.l lVar, com.google.android.libraries.navigation.internal.wp.a aVar, Context context, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.a = lVar;
        this.i = aVar;
        this.b = context;
        this.c = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v21 */
    private final com.google.android.libraries.navigation.internal.add.x i(com.google.android.libraries.navigation.internal.bp.bg bgVar, boolean z, com.google.android.libraries.navigation.internal.ade.n nVar) {
        String str;
        String str2;
        com.google.android.libraries.navigation.internal.rz.ad adVar;
        Optional optionalEmpty;
        br brVar;
        br brVar2;
        com.google.android.libraries.navigation.internal.rz.ae aeVar;
        com.google.android.libraries.navigation.internal.rz.t tVar;
        String str3;
        String str4;
        bu buVar;
        String str5 = "";
        com.google.android.libraries.navigation.internal.ade.q qVar = (com.google.android.libraries.navigation.internal.ade.q) com.google.android.libraries.navigation.internal.ade.r.a.q();
        int iB = com.google.android.libraries.navigation.internal.ade.a.b(nVar.b);
        if (iB == 0) {
            iB = com.google.android.libraries.navigation.internal.ade.a.d;
        }
        if (!qVar.b.H()) {
            qVar.v();
        }
        ((com.google.android.libraries.navigation.internal.ade.r) qVar.b).b = com.google.android.libraries.navigation.internal.ade.a.a(iB);
        try {
            com.google.android.libraries.navigation.internal.wf.l lVar = this.a;
            Context context = this.b;
            com.google.android.libraries.navigation.internal.vm.f fVar = new com.google.android.libraries.navigation.internal.vm.f(com.google.android.libraries.navigation.internal.nw.e.b("GuidanceRouteTranslator.translateToGuidanceRoute"), ((com.google.android.libraries.navigation.internal.kk.n) lVar.a.a.a(com.google.android.libraries.navigation.internal.km.ak.m)).a());
            try {
                com.google.android.libraries.navigation.internal.wh.a aVar = (com.google.android.libraries.navigation.internal.wh.a) com.google.android.libraries.navigation.internal.wh.b.a.q();
                ll llVar = bgVar.d.c;
                if (llVar == null) {
                    llVar = ll.a;
                }
                lh lhVar = llVar.c;
                if (lhVar == null) {
                    lhVar = lh.a;
                }
                bz bzVar = lhVar.c;
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.wh.b bVar = (com.google.android.libraries.navigation.internal.wh.b) aVar.b;
                bz bzVar2 = bVar.b;
                if (!bzVar2.c()) {
                    bVar.b = bi.A(bzVar2);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(bzVar, bVar.b);
                ii iiVar = bgVar.u;
                long j = bgVar.Y;
                cf cfVar = bgVar.g;
                ll llVar2 = bgVar.d.c;
                if (llVar2 == null) {
                    llVar2 = ll.a;
                }
                lh lhVar2 = llVar2.c;
                if (lhVar2 == null) {
                    lhVar2 = lh.a;
                }
                com.google.android.libraries.navigation.internal.oe.ad adVar2 = bgVar.m;
                if (iiVar == null) {
                    ii iiVar2 = ii.a;
                }
                String str6 = bgVar.Z;
                com.google.android.libraries.navigation.internal.ade.l lVarA = com.google.android.libraries.navigation.internal.wg.a.a();
                com.google.android.libraries.navigation.internal.add.w wVar = (com.google.android.libraries.navigation.internal.add.w) com.google.android.libraries.navigation.internal.add.x.a.q();
                if (!wVar.b.H()) {
                    wVar.v();
                }
                com.google.android.libraries.navigation.internal.add.x xVar = (com.google.android.libraries.navigation.internal.add.x) wVar.b;
                lVarA.getClass();
                xVar.c = lVarA;
                xVar.b |= 1;
                bq[] bqVarArr = bgVar.l;
                int length = bqVarArr.length;
                ?? r7 = 0;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    final bq bqVar = bqVarArr[i];
                    final com.google.android.libraries.navigation.internal.ry.d dVar = new com.google.android.libraries.navigation.internal.ry.d(context);
                    com.google.android.libraries.navigation.internal.rz.k kVar = new com.google.android.libraries.navigation.internal.rz.k();
                    kVar.a = -1;
                    byte b = kVar.f570n;
                    kVar.b = r7;
                    kVar.f570n = (byte) (b | 3);
                    kVar.b(Optional.empty());
                    kVar.d = r7;
                    byte b2 = kVar.f570n;
                    kVar.e = r7;
                    kVar.f = r7;
                    kVar.f570n = (byte) (b2 | Ascii.FS);
                    kVar.a(r7);
                    int i3 = ev.d;
                    kVar.d(new bv(lv.a));
                    kVar.i = new bv(lv.a);
                    kVar.c(com.google.android.libraries.navigation.internal.rz.ae.b().a());
                    com.google.android.libraries.navigation.internal.rz.a aVar2 = new com.google.android.libraries.navigation.internal.rz.a();
                    aVar2.a = str5;
                    aVar2.b = str5;
                    aVar2.c = str5;
                    aVar2.d = r7;
                    aVar2.e = (byte) 1;
                    String str7 = aVar2.a;
                    if (str7 == null || (str = aVar2.b) == null || (str2 = aVar2.c) == null) {
                        throw new IllegalStateException();
                    }
                    bq[] bqVarArr2 = bqVarArr;
                    int i4 = length;
                    kVar.k = new com.google.android.libraries.navigation.internal.rz.b(str7, str, str2, 0);
                    kVar.l = str5;
                    kVar.m = str5;
                    kVar.d(bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.sb.b
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.android.libraries.navigation.internal.yx.br
                        public final Object a() {
                            h hVarA;
                            d dVar2 = (d) dVar;
                            Context context2 = dVar2.a;
                            bq bqVar2 = bqVar;
                            e eVarF = g.f(context2, bqVar2, 1);
                            if (eVarF.a.isEmpty()) {
                                com.google.android.libraries.navigation.internal.sa.g gVarF = h.f();
                                com.google.android.libraries.navigation.internal.sa.e eVarB = f.b();
                                al alVarG = an.g(am.TEXTUAL);
                                alVarG.f(bqVar2.j);
                                eVarB.c(alVarG.a());
                                gVarF.b().h(eVarB.a());
                                hVarA = gVarF.a();
                            } else {
                                hVarA = dVar2.a(eVarF.a, eVarF.c);
                            }
                            h hVarA2 = dVar2.a(eVarF.b, eVarF.d);
                            ArrayList arrayList = new ArrayList();
                            ev evVarA = c.a(hVarA, hVarA2);
                            int size = evVarA.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                com.google.android.libraries.navigation.internal.ry.e eVar = (com.google.android.libraries.navigation.internal.ry.e) evVarA.get(i5);
                                o oVar = new o();
                                int i6 = ev.d;
                                oVar.a(lv.a);
                                oVar.a(ev.r(a.a(eVar.a), a.a(eVar.b)));
                                if (oVar.a == null) {
                                    oVar.a = lv.a;
                                }
                                arrayList.add(new p(oVar.a));
                            }
                            return ev.o(arrayList);
                        }
                    }));
                    kVar.a(bqVar.M != null);
                    en enVar = bqVar.E;
                    com.google.android.libraries.navigation.internal.aap.l lVar2 = bqVar.d;
                    if (enVar == null) {
                        enVar = en.NONE;
                    }
                    hu huVar = bqVar.f;
                    hs hsVar = bqVar.e;
                    int iOrdinal = lVar2.ordinal();
                    if (iOrdinal == 1) {
                        adVar = com.google.android.libraries.navigation.internal.rz.ad.DEPART;
                    } else if (iOrdinal == 2) {
                        adVar = com.google.android.libraries.navigation.internal.rz.ad.NAME_CHANGE;
                    } else if (iOrdinal == 3) {
                        adVar = com.google.android.libraries.navigation.internal.rz.ad.STRAIGHT;
                    } else if (iOrdinal == 5) {
                        switch (huVar.ordinal()) {
                            case 1:
                                int iOrdinal2 = hsVar.ordinal();
                                if (iOrdinal2 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_SLIGHT_LEFT;
                                } else if (iOrdinal2 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_SLIGHT_RIGHT;
                                }
                                break;
                            case 2:
                                int iOrdinal3 = hsVar.ordinal();
                                if (iOrdinal3 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_NORMAL_LEFT;
                                } else if (iOrdinal3 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_NORMAL_RIGHT;
                                }
                                break;
                            case 3:
                                int iOrdinal4 = hsVar.ordinal();
                                if (iOrdinal4 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_SHARP_LEFT;
                                } else if (iOrdinal4 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.TURN_SHARP_RIGHT;
                                }
                                break;
                            case 4:
                                int iOrdinal5 = hsVar.ordinal();
                                if (iOrdinal5 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.KEEP_LEFT;
                                } else if (iOrdinal5 == 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.KEEP_RIGHT;
                                } else if (iOrdinal5 != 2) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.STRAIGHT;
                                }
                                break;
                            case 5:
                                int iOrdinal6 = hsVar.ordinal();
                                if (iOrdinal6 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.U_TURN_LEFT;
                                } else if (iOrdinal6 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.U_TURN_RIGHT;
                                }
                                break;
                            case 6:
                                adVar = com.google.android.libraries.navigation.internal.rz.ad.STRAIGHT;
                                break;
                            default:
                                adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                break;
                        }
                    } else if (iOrdinal != 29) {
                        switch (iOrdinal) {
                            case 7:
                                int iOrdinal7 = hsVar.ordinal();
                                if (iOrdinal7 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.U_TURN_LEFT;
                                } else if (iOrdinal7 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.U_TURN_RIGHT;
                                }
                                break;
                            case 8:
                                switch (huVar.ordinal()) {
                                    case 1:
                                        int iOrdinal8 = hsVar.ordinal();
                                        if (iOrdinal8 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_SLIGHT_LEFT;
                                        } else if (iOrdinal8 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_SLIGHT_RIGHT;
                                        }
                                        break;
                                    case 2:
                                        int iOrdinal9 = hsVar.ordinal();
                                        if (iOrdinal9 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_NORMAL_LEFT;
                                        } else if (iOrdinal9 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_NORMAL_RIGHT;
                                        }
                                        break;
                                    case 3:
                                        int iOrdinal10 = hsVar.ordinal();
                                        if (iOrdinal10 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_SHARP_LEFT;
                                        } else if (iOrdinal10 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_SHARP_RIGHT;
                                        }
                                        break;
                                    case 4:
                                        int iOrdinal11 = hsVar.ordinal();
                                        if (iOrdinal11 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_KEEP_LEFT;
                                        } else if (iOrdinal11 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_KEEP_RIGHT;
                                        }
                                        break;
                                    case 5:
                                        int iOrdinal12 = hsVar.ordinal();
                                        if (iOrdinal12 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_U_TURN_LEFT;
                                        } else if (iOrdinal12 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ON_RAMP_U_TURN_RIGHT;
                                        }
                                        break;
                                    case 6:
                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.STRAIGHT;
                                        break;
                                    default:
                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        break;
                                }
                                break;
                            case 9:
                                switch (huVar.ordinal()) {
                                    case 1:
                                        int iOrdinal13 = hsVar.ordinal();
                                        if (iOrdinal13 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_SLIGHT_LEFT;
                                        } else if (iOrdinal13 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_SLIGHT_RIGHT;
                                        }
                                        break;
                                    case 2:
                                        int iOrdinal14 = hsVar.ordinal();
                                        if (iOrdinal14 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_NORMAL_LEFT;
                                        } else if (iOrdinal14 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_NORMAL_RIGHT;
                                        }
                                        break;
                                    case 3:
                                        int iOrdinal15 = hsVar.ordinal();
                                        if (iOrdinal15 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_SHARP_LEFT;
                                        } else if (iOrdinal15 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_SHARP_RIGHT;
                                        }
                                        break;
                                    case 4:
                                        int iOrdinal16 = hsVar.ordinal();
                                        if (iOrdinal16 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_KEEP_LEFT;
                                        } else if (iOrdinal16 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_KEEP_RIGHT;
                                        }
                                        break;
                                    case 5:
                                        int iOrdinal17 = hsVar.ordinal();
                                        if (iOrdinal17 == 0) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_U_TURN_LEFT;
                                        } else if (iOrdinal17 != 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.OFF_RAMP_U_TURN_RIGHT;
                                        }
                                        break;
                                    case 6:
                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.STRAIGHT;
                                        break;
                                    default:
                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        break;
                                }
                                break;
                            case 10:
                                int iOrdinal18 = hsVar.ordinal();
                                if (iOrdinal18 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.FORK_LEFT;
                                } else if (iOrdinal18 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.FORK_RIGHT;
                                }
                                break;
                            case 11:
                                int iOrdinal19 = hsVar.ordinal();
                                if (iOrdinal19 == 0) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.MERGE_LEFT;
                                } else if (iOrdinal19 != 1) {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.MERGE;
                                } else {
                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.MERGE_RIGHT;
                                }
                                break;
                            case 12:
                                adVar = com.google.android.libraries.navigation.internal.rz.ad.FERRY_BOAT;
                                break;
                            case 13:
                                adVar = com.google.android.libraries.navigation.internal.rz.ad.FERRY_TRAIN;
                                break;
                            default:
                                switch (iOrdinal) {
                                    case 15:
                                        int iOrdinal20 = enVar.ordinal();
                                        if (iOrdinal20 == 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_CW;
                                        } else if (iOrdinal20 != 2) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_CCW;
                                        }
                                        break;
                                    case 16:
                                        int iOrdinal21 = enVar.ordinal();
                                        if (iOrdinal21 == 1) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_EXIT_CW;
                                        } else if (iOrdinal21 != 2) {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_EXIT_CCW;
                                        }
                                        break;
                                    case 17:
                                        int iOrdinal22 = enVar.ordinal();
                                        if (iOrdinal22 == 1) {
                                            switch (huVar.ordinal()) {
                                                case 1:
                                                    int iOrdinal23 = hsVar.ordinal();
                                                    if (iOrdinal23 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_SLIGHT_LEFT;
                                                    } else if (iOrdinal23 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_SLIGHT_RIGHT;
                                                    }
                                                    break;
                                                case 2:
                                                    int iOrdinal24 = hsVar.ordinal();
                                                    if (iOrdinal24 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_NORMAL_LEFT;
                                                    } else if (iOrdinal24 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_NORMAL_RIGHT;
                                                    }
                                                    break;
                                                case 3:
                                                    int iOrdinal25 = hsVar.ordinal();
                                                    if (iOrdinal25 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_SHARP_LEFT;
                                                    } else if (iOrdinal25 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_SHARP_RIGHT;
                                                    }
                                                    break;
                                                case 4:
                                                case 6:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_STRAIGHT;
                                                    break;
                                                case 5:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CW_U_TURN;
                                                    break;
                                                default:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    break;
                                            }
                                        } else if (iOrdinal22 == 2) {
                                            switch (huVar.ordinal()) {
                                                case 1:
                                                    int iOrdinal26 = hsVar.ordinal();
                                                    if (iOrdinal26 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_SLIGHT_LEFT;
                                                    } else if (iOrdinal26 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_SLIGHT_RIGHT;
                                                    }
                                                    break;
                                                case 2:
                                                    int iOrdinal27 = hsVar.ordinal();
                                                    if (iOrdinal27 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_NORMAL_LEFT;
                                                    } else if (iOrdinal27 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_NORMAL_RIGHT;
                                                    }
                                                    break;
                                                case 3:
                                                    int iOrdinal28 = hsVar.ordinal();
                                                    if (iOrdinal28 == 0) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_SHARP_LEFT;
                                                    } else if (iOrdinal28 != 1) {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    } else {
                                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_SHARP_RIGHT;
                                                    }
                                                    break;
                                                case 4:
                                                case 6:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_STRAIGHT;
                                                    break;
                                                case 5:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.ROUNDABOUT_ENTER_AND_EXIT_CCW_U_TURN;
                                                    break;
                                                default:
                                                    adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                                    break;
                                            }
                                        } else {
                                            adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                            break;
                                        }
                                        break;
                                    default:
                                        adVar = com.google.android.libraries.navigation.internal.rz.ad.UNKNOWN;
                                        break;
                                }
                                break;
                        }
                    } else {
                        int iOrdinal29 = hsVar.ordinal();
                        adVar = iOrdinal29 != 0 ? iOrdinal29 != 1 ? com.google.android.libraries.navigation.internal.rz.ad.DESTINATION : com.google.android.libraries.navigation.internal.rz.ad.DESTINATION_RIGHT : com.google.android.libraries.navigation.internal.rz.ad.DESTINATION_LEFT;
                    }
                    com.google.android.libraries.navigation.internal.rz.ac acVarB = com.google.android.libraries.navigation.internal.rz.ae.b();
                    acVarB.b(adVar);
                    kVar.c(acVarB.a());
                    List list = bqVar.B;
                    com.google.android.libraries.navigation.internal.rz.e eVar = new com.google.android.libraries.navigation.internal.rz.e();
                    Iterator it2 = list.iterator();
                    boolean z2 = false;
                    while (it2.hasNext()) {
                        com.google.android.libraries.geo.navcore.ui.header.views.e[][] eVarArrB = com.google.android.libraries.geo.navcore.ui.header.views.f.b((com.google.android.libraries.navigation.internal.bp.ar) it2.next());
                        if (eVarArrB.length > 0) {
                            eVar.a().h(com.google.android.libraries.navigation.internal.ry.b.a(eVarArrB[0]));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        eq eqVar = eVar.a;
                        if (eqVar != null) {
                            eVar.b = eqVar.g();
                        } else if (eVar.b == null) {
                            eVar.b = lv.a;
                        }
                        optionalEmpty = Optional.ofNullable(new com.google.android.libraries.navigation.internal.rz.f(eVar.b));
                    } else {
                        optionalEmpty = Optional.empty();
                    }
                    if (optionalEmpty.isPresent()) {
                        kVar.b(optionalEmpty);
                    }
                    if (kVar.f570n != 63 || (brVar = kVar.h) == null || (brVar2 = kVar.i) == null || (aeVar = kVar.j) == null || (tVar = kVar.k) == null || (str3 = kVar.l) == null || (str4 = kVar.m) == null) {
                        throw new IllegalStateException();
                    }
                    String str8 = str5;
                    Context context2 = context;
                    com.google.android.libraries.navigation.internal.rz.l lVar3 = new com.google.android.libraries.navigation.internal.rz.l(kVar.a, false, kVar.c, false, false, false, kVar.g, brVar, brVar2, aeVar, tVar, str3, str4);
                    com.google.android.libraries.navigation.internal.add.bg bgVar2 = (com.google.android.libraries.navigation.internal.add.bg) bh.a.q();
                    if (lVar3.a.isPresent()) {
                        com.google.android.libraries.navigation.internal.add.an anVar = (com.google.android.libraries.navigation.internal.add.an) new com.google.android.libraries.navigation.internal.wf.p().c((com.google.android.libraries.navigation.internal.rz.x) lVar3.a.get());
                        if (!bgVar2.b.H()) {
                            bgVar2.v();
                        }
                        bh bhVar = (bh) bgVar2.b;
                        anVar.getClass();
                        bhVar.e = anVar;
                        bhVar.b |= 1;
                    }
                    com.google.android.libraries.navigation.internal.add.aq aqVar = (com.google.android.libraries.navigation.internal.add.aq) new com.google.android.libraries.navigation.internal.wf.r().c(lVar3.c);
                    if (!bgVar2.b.H()) {
                        bgVar2.v();
                    }
                    bh bhVar2 = (bh) bgVar2.b;
                    aqVar.getClass();
                    bhVar2.g = aqVar;
                    bhVar2.b |= 2;
                    ev evVar = (ev) lVar3.b.a();
                    int size = evVar.size();
                    int i5 = 0;
                    while (i5 < size) {
                        com.google.android.libraries.navigation.internal.rz.ak akVar = (com.google.android.libraries.navigation.internal.rz.ak) evVar.get(i5);
                        bk bkVar = (bk) bl.a.q();
                        ev evVarA = akVar.a();
                        int i6 = ((lv) evVarA).c;
                        int i7 = 0;
                        while (i7 < i6) {
                            com.google.android.libraries.navigation.internal.rz.ai aiVar = (com.google.android.libraries.navigation.internal.rz.ai) evVarA.get(i7);
                            com.google.android.libraries.navigation.internal.add.bi biVar = (com.google.android.libraries.navigation.internal.add.bi) bj.a.q();
                            ev evVarA2 = aiVar.a();
                            ev evVar2 = evVar;
                            int i8 = ((lv) evVarA2).c;
                            int i9 = size;
                            int i10 = 0;
                            while (i10 < i8) {
                                com.google.android.libraries.navigation.internal.rz.an anVar2 = (com.google.android.libraries.navigation.internal.rz.an) evVarA2.get(i10);
                                int i11 = i8;
                                int iOrdinal30 = anVar2.b().ordinal();
                                if (iOrdinal30 == 0) {
                                    i6 = i6;
                                    evVarA2 = evVarA2;
                                    bm bmVar = (bm) bu.a.q();
                                    com.google.android.libraries.navigation.internal.add.br brVar3 = (com.google.android.libraries.navigation.internal.add.br) bs.a.q();
                                    String strE = anVar2.e();
                                    if (!brVar3.b.H()) {
                                        brVar3.v();
                                    }
                                    ((bs) brVar3.b).b = strE;
                                    boolean zF = anVar2.f();
                                    if (!brVar3.b.H()) {
                                        brVar3.v();
                                    }
                                    ((bs) brVar3.b).c = zF;
                                    int i12 = bt.b;
                                    if (!brVar3.b.H()) {
                                        brVar3.v();
                                    }
                                    ((bs) brVar3.b).d = bt.a(i12);
                                    if (!bmVar.b.H()) {
                                        bmVar.v();
                                    }
                                    bu buVar2 = (bu) bmVar.b;
                                    bs bsVar = (bs) brVar3.t();
                                    bsVar.getClass();
                                    buVar2.c = bsVar;
                                    buVar2.b = 1;
                                    buVar = (bu) bmVar.t();
                                } else if (iOrdinal30 == 1) {
                                    bm bmVar2 = (bm) bu.a.q();
                                    bp bpVar = (bp) com.google.android.libraries.navigation.internal.add.bq.a.q();
                                    String strE2 = anVar2.e();
                                    if (!bpVar.b.H()) {
                                        bpVar.v();
                                    }
                                    ((com.google.android.libraries.navigation.internal.add.bq) bpVar.b).b = strE2;
                                    String strD = anVar2.d();
                                    if (!bpVar.b.H()) {
                                        bpVar.v();
                                    }
                                    ((com.google.android.libraries.navigation.internal.add.bq) bpVar.b).c = strD;
                                    if (!bmVar2.b.H()) {
                                        bmVar2.v();
                                    }
                                    bu buVar3 = (bu) bmVar2.b;
                                    com.google.android.libraries.navigation.internal.add.bq bqVar2 = (com.google.android.libraries.navigation.internal.add.bq) bpVar.t();
                                    bqVar2.getClass();
                                    buVar3.c = bqVar2;
                                    buVar3.b = 5;
                                    buVar = (bu) bmVar2.t();
                                } else if (iOrdinal30 == 2) {
                                    bm bmVar3 = (bm) bu.a.q();
                                    bn bnVar = (bn) bo.a.q();
                                    String strE3 = anVar2.e();
                                    if (!bnVar.b.H()) {
                                        bnVar.v();
                                    }
                                    ((bo) bnVar.b).b = strE3;
                                    com.google.android.libraries.navigation.internal.add.az azVar = (com.google.android.libraries.navigation.internal.add.az) new com.google.android.libraries.navigation.internal.wf.v().c(anVar2.c());
                                    if (!bnVar.b.H()) {
                                        bnVar.v();
                                    }
                                    ((bo) bnVar.b).c = azVar.a();
                                    if (!bmVar3.b.H()) {
                                        bmVar3.v();
                                    }
                                    bu buVar4 = (bu) bmVar3.b;
                                    bo boVar = (bo) bnVar.t();
                                    boVar.getClass();
                                    buVar4.c = boVar;
                                    buVar4.b = 6;
                                    buVar = (bu) bmVar3.t();
                                } else if (iOrdinal30 == 5) {
                                    bm bmVar4 = (bm) bu.a.q();
                                    com.google.android.libraries.navigation.internal.add.br brVar4 = (com.google.android.libraries.navigation.internal.add.br) bs.a.q();
                                    String strE4 = anVar2.e();
                                    if (!brVar4.b.H()) {
                                        brVar4.v();
                                    }
                                    ((bs) brVar4.b).b = strE4;
                                    boolean zF2 = anVar2.f();
                                    if (!brVar4.b.H()) {
                                        brVar4.v();
                                    }
                                    ((bs) brVar4.b).c = zF2;
                                    int i13 = bt.c;
                                    if (!brVar4.b.H()) {
                                        brVar4.v();
                                    }
                                    ((bs) brVar4.b).d = bt.a(i13);
                                    if (!bmVar4.b.H()) {
                                        bmVar4.v();
                                    }
                                    bu buVar5 = (bu) bmVar4.b;
                                    bs bsVar2 = (bs) brVar4.t();
                                    bsVar2.getClass();
                                    buVar5.c = bsVar2;
                                    buVar5.b = 1;
                                    buVar = (bu) bmVar4.t();
                                } else if (iOrdinal30 != 6) {
                                    buVar = bu.a;
                                } else {
                                    bm bmVar5 = (bm) bu.a.q();
                                    com.google.android.libraries.navigation.internal.add.br brVar5 = (com.google.android.libraries.navigation.internal.add.br) bs.a.q();
                                    String strE5 = anVar2.e();
                                    if (!brVar5.b.H()) {
                                        brVar5.v();
                                    }
                                    ((bs) brVar5.b).b = strE5;
                                    boolean zF3 = anVar2.f();
                                    if (!brVar5.b.H()) {
                                        brVar5.v();
                                    }
                                    ((bs) brVar5.b).c = zF3;
                                    int i14 = bt.d;
                                    if (!brVar5.b.H()) {
                                        brVar5.v();
                                    }
                                    ((bs) brVar5.b).d = bt.a(i14);
                                    if (!bmVar5.b.H()) {
                                        bmVar5.v();
                                    }
                                    bu buVar6 = (bu) bmVar5.b;
                                    bs bsVar3 = (bs) brVar5.t();
                                    bsVar3.getClass();
                                    buVar6.c = bsVar3;
                                    buVar6.b = 1;
                                    buVar = (bu) bmVar5.t();
                                }
                                if (!biVar.b.H()) {
                                    biVar.v();
                                }
                                bj bjVar = (bj) biVar.b;
                                buVar.getClass();
                                bz bzVar3 = bjVar.b;
                                if (!bzVar3.c()) {
                                    bjVar.b = bi.A(bzVar3);
                                }
                                bjVar.b.add(buVar);
                                i10++;
                                evVarA = evVarA;
                                i8 = i11;
                                i6 = i6;
                                evVarA2 = evVarA2;
                            }
                            ev evVar3 = evVarA;
                            int i15 = i6;
                            if (!bkVar.b.H()) {
                                bkVar.v();
                            }
                            bl blVar = (bl) bkVar.b;
                            bj bjVar2 = (bj) biVar.t();
                            bjVar2.getClass();
                            bz bzVar4 = blVar.b;
                            if (!bzVar4.c()) {
                                blVar.b = bi.A(bzVar4);
                            }
                            blVar.b.add(bjVar2);
                            i7++;
                            evVar = evVar2;
                            size = i9;
                            evVarA = evVar3;
                            i6 = i15;
                        }
                        ev evVar4 = evVar;
                        int i16 = size;
                        bl blVar2 = (bl) bkVar.t();
                        if (!bgVar2.b.H()) {
                            bgVar2.v();
                        }
                        bh bhVar3 = (bh) bgVar2.b;
                        blVar2.getClass();
                        bz bzVar5 = bhVar3.f;
                        if (!bzVar5.c()) {
                            bhVar3.f = bi.A(bzVar5);
                        }
                        bhVar3.f.add(blVar2);
                        i5++;
                        evVar = evVar4;
                        size = i16;
                    }
                    Cif cif = bqVar.a;
                    if (cif != null) {
                        if (!bgVar2.b.H()) {
                            bgVar2.v();
                        }
                        ((bh) bgVar2.b).c = i2;
                        bz<gn> bzVar6 = cif.m;
                        StringBuilder sb = new StringBuilder();
                        for (gn gnVar : bzVar6) {
                            if ((gnVar.b & 2) != 0) {
                                com.google.android.libraries.navigation.internal.adr.aj ajVar = gnVar.d;
                                if (ajVar == null) {
                                    ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
                                }
                                sb.append(ajVar.c);
                            }
                        }
                        String string = sb.toString();
                        if (!bgVar2.b.H()) {
                            bgVar2.v();
                        }
                        ((bh) bgVar2.b).d = string;
                    }
                    com.google.android.libraries.navigation.internal.ade.b bVar2 = (com.google.android.libraries.navigation.internal.ade.b) com.google.android.libraries.navigation.internal.ade.c.a.q();
                    int i17 = bqVar.k;
                    if (!bVar2.b.H()) {
                        bVar2.v();
                    }
                    ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).b = i17;
                    if (!bVar2.b.H()) {
                        bVar2.v();
                    }
                    ((com.google.android.libraries.navigation.internal.ade.c) bVar2.b).c = 0.0f;
                    com.google.android.libraries.navigation.internal.ade.c cVar = (com.google.android.libraries.navigation.internal.ade.c) bVar2.t();
                    if (!bgVar2.b.H()) {
                        bgVar2.v();
                    }
                    bh bhVar4 = (bh) bgVar2.b;
                    cVar.getClass();
                    bhVar4.h = cVar;
                    bhVar4.b |= 4;
                    bh bhVar5 = (bh) bgVar2.t();
                    if (!wVar.b.H()) {
                        wVar.v();
                    }
                    com.google.android.libraries.navigation.internal.add.x xVar2 = (com.google.android.libraries.navigation.internal.add.x) wVar.b;
                    bhVar5.getClass();
                    bz bzVar7 = xVar2.d;
                    if (!bzVar7.c()) {
                        xVar2.d = bi.A(bzVar7);
                    }
                    xVar2.d.add(bhVar5);
                    Cif cif2 = bqVar.a;
                    if (cif2 != null && (cif2.b & 4) != 0) {
                        com.google.android.libraries.navigation.internal.adr.bm bmVar6 = cif2.e;
                        if (bmVar6 == null) {
                            bmVar6 = com.google.android.libraries.navigation.internal.adr.bm.a;
                        }
                        i2 = bmVar6.c;
                    }
                    i++;
                    r7 = 0;
                    bqVarArr = bqVarArr2;
                    length = i4;
                    str5 = str8;
                    context = context2;
                }
                com.google.android.libraries.navigation.internal.add.x xVar3 = (com.google.android.libraries.navigation.internal.add.x) wVar.t();
                fVar.close();
                return xVar3;
            } catch (Throwable th) {
                try {
                    fVar.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Exception e) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.c.a(com.google.android.libraries.navigation.internal.km.ak.f)).a();
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, e.getMessage(), e.getCause()));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final com.google.android.libraries.navigation.internal.wl.d a(com.google.android.libraries.navigation.internal.add.aw awVar) {
        fd fdVarD;
        ez ezVar = new ez();
        fd fdVar = ((com.google.android.libraries.navigation.internal.wl.b) this.e).b;
        com.google.android.libraries.navigation.internal.ade.p pVar = awVar.c;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        com.google.android.libraries.navigation.internal.wl.c cVar = (com.google.android.libraries.navigation.internal.wl.c) fdVar.get(pVar.b);
        if (cVar == null) {
            fdVarD = null;
            break;
        }
        com.google.android.libraries.navigation.internal.ade.p pVar2 = awVar.c;
        if (pVar2 == null) {
            pVar2 = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        ezVar.f(pVar2.b, cVar);
        Iterator it2 = awVar.d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                fdVarD = ezVar.d();
                break;
            }
            com.google.android.libraries.navigation.internal.ade.p pVar3 = (com.google.android.libraries.navigation.internal.ade.p) it2.next();
            com.google.android.libraries.navigation.internal.wl.c cVar2 = (com.google.android.libraries.navigation.internal.wl.c) ((com.google.android.libraries.navigation.internal.wl.b) this.e).b.get(pVar3.b);
            if (cVar2 == null) {
                fdVarD = null;
                break;
            }
            ezVar.f(pVar3.b, cVar2);
        }
        if (fdVarD == null) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.wl.b(awVar, fdVarD);
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final fd b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final com.google.android.libraries.navigation.internal.add.aw c() {
        return ((com.google.android.libraries.navigation.internal.wl.b) this.e).a;
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final com.google.android.libraries.navigation.internal.ade.n d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final String e() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final void f() {
        this.e = com.google.android.libraries.navigation.internal.wl.d.c;
        this.d = null;
        this.f = ma.b;
        this.h = 0L;
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final boolean g(com.google.android.libraries.navigation.internal.wl.d dVar, com.google.android.libraries.navigation.internal.ade.n nVar) {
        com.google.android.libraries.navigation.internal.wl.b bVar = (com.google.android.libraries.navigation.internal.wl.b) dVar;
        com.google.android.libraries.navigation.internal.ade.p pVar = bVar.a.c;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        com.google.android.libraries.navigation.internal.wl.c cVar = (com.google.android.libraries.navigation.internal.wl.c) bVar.b.get(pVar.b);
        com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
        if (cVar.a().i.toEpochMilli() == this.h && dVar.equals(this.e)) {
            return false;
        }
        this.g = nVar;
        ez ezVar = new ez();
        com.google.android.libraries.navigation.internal.ade.p pVar2 = bVar.a.c;
        if (pVar2 == null) {
            pVar2 = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        com.google.android.libraries.navigation.internal.wl.c cVar2 = (com.google.android.libraries.navigation.internal.wl.c) bVar.b.get(pVar2.b);
        com.google.android.libraries.navigation.internal.yx.ar.q(cVar2);
        com.google.android.libraries.navigation.internal.bp.bg bgVarA = cVar2.a();
        ezVar.f(bgVarA.Z, i(bgVarA, true, nVar));
        Iterator it2 = bVar.a.d.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.wl.c cVar3 = (com.google.android.libraries.navigation.internal.wl.c) bVar.b.get(((com.google.android.libraries.navigation.internal.ade.p) it2.next()).b);
            com.google.android.libraries.navigation.internal.yx.ar.q(cVar3);
            com.google.android.libraries.navigation.internal.bp.bg bgVarA2 = cVar3.a();
            ezVar.f(bgVarA2.Z, i(bgVarA2, false, nVar));
        }
        try {
            this.f = ezVar.d();
            this.e = dVar;
            this.d = com.google.android.libraries.navigation.internal.wp.a.a(((com.google.android.libraries.navigation.internal.wl.b) dVar).a);
            com.google.android.libraries.navigation.internal.wl.b bVar2 = (com.google.android.libraries.navigation.internal.wl.b) this.e;
            fd fdVar = bVar2.b;
            com.google.android.libraries.navigation.internal.ade.p pVar3 = bVar2.a.c;
            if (pVar3 == null) {
                pVar3 = com.google.android.libraries.navigation.internal.ade.p.a;
            }
            com.google.android.libraries.navigation.internal.wl.c cVar4 = (com.google.android.libraries.navigation.internal.wl.c) fdVar.get(pVar3.b);
            com.google.android.libraries.navigation.internal.yx.ar.q(cVar4);
            this.h = cVar4.a().i.toEpochMilli();
            return true;
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.c.a(com.google.android.libraries.navigation.internal.km.ak.o)).a();
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, e.getMessage(), e.getCause()));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.we.i
    public final void h() {
    }
}
