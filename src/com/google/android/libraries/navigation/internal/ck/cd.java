package com.google.android.libraries.navigation.internal.ck;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.afl.nz;
import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd {
    public final com.google.android.libraries.navigation.internal.ol.ax a;
    public final List b = new ArrayList();
    public final List c = new ArrayList();
    public final List d = new ArrayList();
    private final ev e;
    private final ev f;
    private final com.google.android.libraries.navigation.internal.ot.h g;
    private final com.google.android.libraries.navigation.internal.ol.ai h;
    private final com.google.android.libraries.navigation.internal.oj.l i;
    private final boolean j;

    public cd(ev evVar, ev evVar2, com.google.android.libraries.navigation.internal.ot.h hVar, com.google.android.libraries.navigation.internal.ol.ai aiVar, com.google.android.libraries.navigation.internal.ol.ax axVar, boolean z) {
        this.e = evVar;
        this.f = evVar2;
        this.g = hVar;
        this.h = aiVar;
        this.a = axVar;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        this.i = new com.google.android.libraries.navigation.internal.oj.j(axVar);
        this.j = z;
    }

    static ga a(oa oaVar) {
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        ej ejVar = (ej) eo.a.q();
        com.google.android.libraries.navigation.internal.adg.cq cqVar = (com.google.android.libraries.navigation.internal.adg.cq) com.google.android.libraries.navigation.internal.adg.cr.a.q();
        String str = oaVar.l;
        if (!cqVar.b.H()) {
            cqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cr crVar = (com.google.android.libraries.navigation.internal.adg.cr) cqVar.b;
        str.getClass();
        crVar.b |= 1;
        crVar.c = str;
        if (!cqVar.b.H()) {
            cqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cr crVar2 = (com.google.android.libraries.navigation.internal.adg.cr) cqVar.b;
        crVar2.b |= 8;
        crVar2.f = 4;
        ejVar.c(cqVar);
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        eo eoVar = (eo) ejVar.t();
        eoVar.getClass();
        dbVar.e = eoVar;
        dbVar.b |= 4;
        fxVar.c(daVar);
        return (ga) fxVar.t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void d(com.google.android.libraries.navigation.internal.oj.h hVar, com.google.android.libraries.navigation.internal.oj.l lVar, v vVar) {
        int i;
        int iA = vVar.a().a() != 0 ? vVar.a().a() : 168;
        int iB = vVar.a().b() != 0 ? vVar.a().b() : NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT;
        dy dyVarB = hVar.b();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(vVar.a().d());
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar = (ef) dyVarB.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        ef efVar2 = ef.a;
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        dq dqVar = (dq) dt.a.q();
        dqVar.d(hVar.a(lVar.e(iA)));
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar3 = (ef) dyVarB.b;
        dt dtVar = (dt) dqVar.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        String strE = vVar.a().e();
        List listA = com.google.android.libraries.navigation.internal.aam.a.a(strE);
        if (listA.size() <= 2) {
            i = 0;
        } else {
            com.google.android.libraries.navigation.internal.yx.bj bjVar = com.google.android.libraries.navigation.internal.yx.bp.a;
            ArrayList arrayList = new ArrayList();
            Iterator it2 = com.google.android.libraries.navigation.internal.yx.bp.a.g(strE).iterator();
            while (it2.hasNext()) {
                arrayList.add((String) it2.next());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            ArrayList arrayList2 = new ArrayList();
            for (String string : strArr) {
                if (string.length() > 20) {
                    StringBuilder sb = new StringBuilder();
                    int length = 0;
                    for (String str : com.google.android.libraries.navigation.internal.yx.bp.b.g(string)) {
                        if (length == 0) {
                            length = str.length();
                        } else {
                            length = length + str.length() + 1;
                            if (length <= 20) {
                                sb.append(' ');
                            } else {
                                sb.append('\n');
                                length = str.length();
                            }
                        }
                        sb.append(str);
                    }
                    string = sb.toString();
                }
                arrayList2.add(string);
            }
            String[] strArrSplit = com.google.android.libraries.navigation.internal.yx.ah.e('\n').f(arrayList2).split("\n");
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < strArrSplit.length && i2 < 2; i2++) {
                sb2.append(strArrSplit[i2]);
                sb2.append(StringUtils.SPACE);
            }
            listA = com.google.android.libraries.navigation.internal.aam.a.a(sb2.toString());
            if (listA.size() > 2) {
                listA = Arrays.asList(strArrSplit).subList(0, 2);
            }
            if (listA.isEmpty()) {
                i = 0;
            } else {
                int iMin = Math.min(2, listA.size()) - 1;
                String strSubstring = (String) listA.get(iMin);
                StringBuilder sb3 = new StringBuilder();
                if (strSubstring.length() <= 1 || strSubstring.length() != 20) {
                    i = 0;
                } else {
                    i = 0;
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                sb3.append(strSubstring);
                sb3.append(Typography.ellipsis);
                listA.set(iMin, sb3.toString());
            }
        }
        Object objE = lVar.e(iB);
        dq dqVar2 = (dq) dt.a.q();
        int i3 = i;
        while (i3 < listA.size()) {
            Cdo cdoA = hVar.a(objE);
            String str2 = (String) listA.get(i3);
            if (!cdoA.b.H()) {
                cdoA.v();
            }
            dp dpVar = (dp) cdoA.b;
            dp dpVar2 = dp.a;
            str2.getClass();
            dpVar.b |= 1;
            dpVar.c = str2;
            boolean z = i3 > 0 ? 1 : i;
            if (!cdoA.b.H()) {
                cdoA.v();
            }
            dp dpVar3 = (dp) cdoA.b;
            dpVar3.b |= 32;
            dpVar3.h = z;
            dqVar2.d(cdoA);
            i3++;
        }
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar4 = (ef) dyVarB.b;
        dt dtVar2 = (dt) dqVar2.t();
        dtVar2.getClass();
        efVar4.d = dtVar2;
        efVar4.b |= 2;
        com.google.android.libraries.navigation.internal.ael.bh bhVar = com.google.android.libraries.navigation.internal.adg.bj.V;
        com.google.android.libraries.navigation.internal.adg.cw cwVar = (com.google.android.libraries.navigation.internal.adg.cw) com.google.android.libraries.navigation.internal.adg.cx.a.q();
        String strE2 = vVar.a().e();
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cx cxVar = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
        strE2.getClass();
        cxVar.b |= 512;
        cxVar.i = strE2;
        long j = vVar.a().c().b;
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cx cxVar2 = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
        cxVar2.b |= 16;
        cxVar2.f = j;
        long j2 = vVar.a().c().c;
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cx cxVar3 = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
        cxVar3.b |= 32;
        cxVar3.g = j2;
        dyVarB.C(bhVar, (com.google.android.libraries.navigation.internal.adg.cx) cwVar.t());
        com.google.android.libraries.navigation.internal.adl.v vVarB = com.google.android.libraries.navigation.internal.rp.c.b(dyVarB);
        if (!vVarB.b.H()) {
            vVarB.v();
        }
        com.google.android.libraries.navigation.internal.adl.x xVar = (com.google.android.libraries.navigation.internal.adl.x) vVarB.b;
        com.google.android.libraries.navigation.internal.adl.x xVar2 = com.google.android.libraries.navigation.internal.adl.x.a;
        xVar.b |= 256;
        xVar.k = true;
        dyVarB.C(com.google.android.libraries.navigation.internal.adl.k.a, (com.google.android.libraries.navigation.internal.adl.x) vVarB.t());
        dyVarB.C(com.google.android.libraries.navigation.internal.adl.k.c, com.google.android.libraries.navigation.internal.rp.c.a);
        if (vVar.b() == com.google.android.libraries.navigation.internal.aap.l.TURN) {
            if (!dyVarB.b.H()) {
                dyVarB.v();
            }
            ef efVar5 = (ef) dyVarB.b;
            efVar5.b |= 256;
            efVar5.j = 88;
        } else {
            if (!dyVarB.b.H()) {
                dyVarB.v();
            }
            ef efVar6 = (ef) dyVarB.b;
            efVar6.b |= 256;
            efVar6.j = PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION;
        }
        if (vVar.c()) {
            if (!dyVarB.b.H()) {
                dyVarB.v();
            }
            ef efVar7 = (ef) dyVarB.b;
            efVar7.b |= 64;
            efVar7.h = 17;
        }
    }

    private static void e(com.google.android.libraries.navigation.internal.oj.h hVar, oa oaVar, Object obj) {
        com.google.android.libraries.navigation.internal.afm.z zVar = oaVar.f;
        if (zVar == null) {
            zVar = com.google.android.libraries.navigation.internal.afm.z.a;
        }
        com.google.android.libraries.navigation.internal.oe.x xVarW = com.google.android.libraries.navigation.internal.oe.x.w(zVar.c, zVar.d);
        com.google.android.libraries.navigation.internal.yz.g gVar = com.google.android.libraries.navigation.internal.tt.e.c.b;
        nz nzVarB = nz.b(oaVar.d);
        if (nzVarB == null) {
            nzVarB = nz.INCIDENT_OTHER;
        }
        com.google.android.libraries.navigation.internal.adr.Cdo cdo = (com.google.android.libraries.navigation.internal.adr.Cdo) gVar.get(nzVarB);
        com.google.android.libraries.navigation.internal.yx.ar.q(cdo);
        dy dyVarB = hVar.b();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(xVarW);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar = (ef) dyVarB.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        ef efVar2 = ef.a;
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        dq dqVar = (dq) dt.a.q();
        dqVar.d(hVar.a(obj));
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar3 = (ef) dyVarB.b;
        dt dtVar = (dt) dqVar.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        if (!dyVarB.b.H()) {
            dyVarB.v();
        }
        ef efVar4 = (ef) dyVarB.b;
        efVar4.b |= 64;
        efVar4.h = 1;
        com.google.android.libraries.navigation.internal.ael.bh bhVar = com.google.android.libraries.navigation.internal.adg.bj.V;
        com.google.android.libraries.navigation.internal.adg.cw cwVar = (com.google.android.libraries.navigation.internal.adg.cw) com.google.android.libraries.navigation.internal.adg.cx.a.q();
        String str = oaVar.f323n;
        if (!cwVar.b.H()) {
            cwVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.cx cxVar = (com.google.android.libraries.navigation.internal.adg.cx) cwVar.b;
        str.getClass();
        cxVar.b |= 512;
        cxVar.i = str;
        dyVarB.C(bhVar, (com.google.android.libraries.navigation.internal.adg.cx) cwVar.t());
        com.google.android.libraries.navigation.internal.ael.bh bhVar2 = com.google.android.libraries.navigation.internal.adg.bj.N;
        com.google.android.libraries.navigation.internal.adf.m mVar = (com.google.android.libraries.navigation.internal.adf.m) com.google.android.libraries.navigation.internal.adf.n.a.q();
        com.google.android.libraries.navigation.internal.afd.a aVar = (com.google.android.libraries.navigation.internal.afd.a) com.google.android.libraries.navigation.internal.tt.e.b.get(cdo);
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        int iA = aVar.a();
        if (!mVar.b.H()) {
            mVar.v();
        }
        com.google.android.libraries.navigation.internal.adf.n nVar = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
        nVar.b |= 8;
        nVar.d = iA;
        dyVarB.C(bhVar2, (com.google.android.libraries.navigation.internal.adf.n) mVar.t());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void b() {
        com.google.android.libraries.navigation.internal.ot.q iVar;
        com.google.android.libraries.navigation.internal.ot.q iVar2;
        int i = 0;
        while (true) {
            ev evVar = this.e;
            if (i >= ((lv) evVar).c) {
                break;
            }
            oa oaVar = (oa) evVar.get(i);
            List list = this.c;
            boolean z = this.j;
            jr jrVar = jr.WORLD_ENCODING_LAT_LNG_E7;
            if (z) {
                com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
                com.google.android.libraries.navigation.internal.rd.c cVar = new com.google.android.libraries.navigation.internal.rd.c(a(oaVar));
                com.google.android.libraries.navigation.internal.ot.h hVar = this.g;
                com.google.android.libraries.navigation.internal.ot.f fVarB = com.google.android.libraries.navigation.internal.ot.g.b();
                fVarB.b(jrVar);
                com.google.android.libraries.navigation.internal.oj.h hVarE = com.google.android.libraries.navigation.internal.oj.h.e(hVar, null, fVarB.a());
                e(hVarE, oaVar, cVar);
                iVar2 = (com.google.android.libraries.navigation.internal.ot.q) hVarE.d();
            } else {
                com.google.android.libraries.navigation.internal.ol.aq aqVarC = ((com.google.android.libraries.navigation.internal.oj.j) this.i).c(a(oaVar));
                this.b.add(aqVarC);
                com.google.android.libraries.navigation.internal.oj.h hVarF = com.google.android.libraries.navigation.internal.oj.h.f(null);
                e(hVarF, oaVar, aqVarC);
                com.google.android.libraries.navigation.internal.po.ag agVarO = ((dh) this.h).o(((com.google.android.libraries.navigation.internal.oj.e) hVarF).d(), jrVar);
                agVarO.l();
                iVar2 = new com.google.android.libraries.navigation.internal.oj.i(agVarO, this.h);
            }
            list.add(iVar2);
            i++;
        }
        ev evVar2 = this.f;
        for (int i2 = 0; i2 < ((lv) evVar2).c; i2++) {
            v vVar = (v) evVar2.get(i2);
            if (vVar.c()) {
                List list2 = this.c;
                boolean z2 = this.j;
                jr jrVar2 = jr.WORLD_ENCODING_LAT_LNG_E7;
                if (z2) {
                    com.google.android.libraries.navigation.internal.ot.h hVar2 = this.g;
                    com.google.android.libraries.navigation.internal.rd.e eVarD = com.google.android.libraries.navigation.internal.rd.e.d(ex.LEGEND_STYLE_MICRO_LANDMARK_LABEL_LAYOUT);
                    com.google.android.libraries.navigation.internal.ot.f fVarB2 = com.google.android.libraries.navigation.internal.ot.g.b();
                    fVarB2.b(jrVar2);
                    com.google.android.libraries.navigation.internal.oj.h hVarE2 = com.google.android.libraries.navigation.internal.oj.h.e(hVar2, eVarD, fVarB2.a());
                    d(hVarE2, com.google.android.libraries.navigation.internal.oj.l.a, vVar);
                    iVar = (com.google.android.libraries.navigation.internal.ot.q) hVarE2.d();
                } else {
                    com.google.android.libraries.navigation.internal.oj.h hVarF2 = com.google.android.libraries.navigation.internal.oj.h.f(this.a.f(ex.LEGEND_STYLE_MICRO_LANDMARK_LABEL_LAYOUT));
                    d(hVarF2, this.i, vVar);
                    com.google.android.libraries.navigation.internal.po.ag agVarO2 = ((dh) this.h).o(((com.google.android.libraries.navigation.internal.oj.e) hVarF2).d(), jrVar2);
                    agVarO2.l();
                    iVar = new com.google.android.libraries.navigation.internal.oj.i(agVarO2, this.h);
                }
                list2.add(iVar);
            }
        }
    }

    public final void c() {
        ev evVarO;
        synchronized (this) {
            evVarO = ev.o(this.d);
            this.d.clear();
        }
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.navigation.internal.ot.q) evVarO.get(i)).b();
        }
        synchronized (this) {
            this.c.addAll(evVarO);
        }
    }
}
