package com.google.android.libraries.navigation.internal.cl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.ds;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adr.cf;
import com.google.android.libraries.navigation.internal.adr.cg;
import com.google.android.libraries.navigation.internal.adr.ci;
import com.google.android.libraries.navigation.internal.adr.cj;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i implements ba {
    protected final h a;
    protected final bh b;
    private final com.google.android.libraries.navigation.internal.bj.b c;
    private final com.google.android.libraries.navigation.internal.hn.r d;
    private final com.google.android.libraries.navigation.internal.hf.c e;
    private final bp f;
    private final com.google.android.libraries.navigation.internal.op.i g;

    protected i(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.bj.b bVar, Context context, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.hf.c cVar, com.google.android.libraries.navigation.internal.op.i iVar) {
        this.g = iVar;
        h hVar = new h(aVar, context);
        this.a = hVar;
        this.c = bVar;
        this.d = rVar;
        this.e = cVar;
        bi biVar = new bi(hVar);
        this.b = biVar;
        this.f = new bp(biVar, rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static boolean g(ev evVar, int i) {
        int size = evVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            cj cjVar = (cj) evVar.get(i2);
            if ((cjVar.b & 1) != 0) {
                int iA = ci.a(cjVar.c);
                if (iA == 0) {
                    iA = ci.a;
                }
                boolean z = iA == i;
                if (iA == 0) {
                    throw null;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final e h(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        j jVar = new j();
        if (z) {
            com.google.android.libraries.navigation.internal.oo.f fVarC = this.a.a().c(z2, z4, false);
            this.a.a();
            com.google.android.libraries.navigation.internal.oo.f fVar = (com.google.android.libraries.navigation.internal.oo.f) bo.g(com.google.android.libraries.navigation.internal.oj.l.a, z2, z4);
            com.google.android.libraries.navigation.internal.oo.f fVarB = z4 ? (com.google.android.libraries.navigation.internal.oo.f) bo.e(com.google.android.libraries.navigation.internal.oj.l.a, z2) : this.a.a().a(z3, z2).b();
            jVar.c = fVarC;
            jVar.e = fVar;
            jVar.g = fVarB;
        } else {
            com.google.android.libraries.navigation.internal.ol.aq aqVar = (com.google.android.libraries.navigation.internal.ol.aq) bo.f(this.a.a().c, z2, z4, false);
            com.google.android.libraries.navigation.internal.ol.aq aqVar2 = (com.google.android.libraries.navigation.internal.ol.aq) bo.g(this.a.a().c, z2, z4);
            bo boVarA = this.a.a();
            com.google.android.libraries.navigation.internal.ol.aq aqVarA = z4 ? (com.google.android.libraries.navigation.internal.ol.aq) bo.e(boVarA.c, z2) : boVarA.a(z3, z2).a();
            jVar.b = aqVar;
            jVar.d = aqVar2;
            jVar.f = aqVarA;
        }
        jVar.h = z3 || z2;
        jVar.i = (short) (jVar.i | 512);
        return jVar;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:41:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0106  */
    /* JADX WARN: Code duplicated, block: B:43:0x0121  */
    /* JADX WARN: Code duplicated, block: B:44:0x012c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0154  */
    /* JADX WARN: Code duplicated, block: B:54:0x017a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0186  */
    private static ev i(f fVar, Context context, boolean z, com.google.android.libraries.navigation.internal.hf.c cVar) {
        boolean z2;
        boolean zY;
        int iG;
        String string;
        String string2;
        String[] strArr;
        String str;
        String str2;
        String string3;
        List listI;
        k kVar = (k) fVar;
        int iOrdinal = kVar.a.ordinal();
        if (iOrdinal == 4) {
            return ev.q(kVar.d ? context.getString(com.google.android.libraries.navigation.internal.qr.e.r) : context.getString(com.google.android.libraries.navigation.internal.qr.e.f560n));
        }
        if (iOrdinal == 5) {
            return ev.q(kVar.d ? context.getString(com.google.android.libraries.navigation.internal.qr.e.o) : context.getString(com.google.android.libraries.navigation.internal.qr.e.q));
        }
        if (iOrdinal == 6) {
            return ev.q(kVar.d ? context.getString(com.google.android.libraries.navigation.internal.qr.e.o) : context.getString(com.google.android.libraries.navigation.internal.qr.e.f560n));
        }
        bc bcVar = kVar.b;
        be beVar = kVar.c;
        int i = kVar.e;
        int i2 = kVar.f;
        boolean z3 = kVar.g;
        boolean z4 = kVar.h;
        int iOrdinal2 = beVar.ordinal();
        List listD = null;
        strA = null;
        String strA = null;
        if (iOrdinal2 == 0) {
            ArrayList arrayList = new ArrayList();
            com.google.android.libraries.navigation.internal.bp.bg bgVar = bcVar.a;
            if (!bgVar.Y() || z4) {
                z2 = !z4;
                zY = bcVar.a.Y();
                if (z3) {
                    iG = com.google.android.libraries.navigation.internal.hf.u.g(i, z2) - 1;
                    if (iG != 0) {
                        string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.w, com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), Math.abs(i), 2));
                    } else if (iG != 1) {
                        string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.x, com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), Math.abs(i), 2));
                    } else {
                        string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.v);
                    }
                    com.google.android.libraries.navigation.internal.yx.ar.q(string);
                    String[] strArrSplit = string.split("\\n");
                    String str3 = strArrSplit[0];
                    strA = strArrSplit.length > 1 ? com.google.android.libraries.navigation.internal.yx.aq.a(strArrSplit[1]) : null;
                    string2 = str3;
                } else {
                    string2 = com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), i, 2).toString();
                    if (zY) {
                        string2 = context.getString(com.google.android.libraries.navigation.internal.hg.a.c, string2);
                    }
                }
                strArr = new String[]{string2, strA};
                if (z || (str2 = strArr[1]) == null) {
                    String str4 = strArr[0];
                    com.google.android.libraries.navigation.internal.yx.ar.q(str4);
                    arrayList.add(str4);
                    str = strArr[1];
                    if (str != null) {
                        arrayList.add(str);
                    }
                    listD = arrayList;
                } else {
                    listD = hx.d(String.format("%s %s", strArr[0], str2));
                }
            } else {
                String str5 = bgVar.M;
                if (com.google.android.libraries.navigation.internal.yx.aq.c(str5)) {
                    z2 = !z4;
                    zY = bcVar.a.Y();
                    if (z3) {
                        string2 = com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), i, 2).toString();
                        if (zY) {
                            string2 = context.getString(com.google.android.libraries.navigation.internal.hg.a.c, string2);
                        }
                    } else {
                        iG = com.google.android.libraries.navigation.internal.hf.u.g(i, z2) - 1;
                        if (iG != 0) {
                            string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.w, com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), Math.abs(i), 2));
                        } else if (iG != 1) {
                            string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.x, com.google.android.libraries.navigation.internal.hf.u.e(context.getResources(), Math.abs(i), 2));
                        } else {
                            string = context.getResources().getString(com.google.android.libraries.navigation.internal.f.h.v);
                        }
                        com.google.android.libraries.navigation.internal.yx.ar.q(string);
                        String[] strArrSplit2 = string.split("\\n");
                        String str6 = strArrSplit2[0];
                        if (strArrSplit2.length > 1) {
                        }
                        string2 = str6;
                    }
                    strArr = new String[]{string2, strA};
                    if (z) {
                        String str7 = strArr[0];
                        com.google.android.libraries.navigation.internal.yx.ar.q(str7);
                        arrayList.add(str7);
                        str = strArr[1];
                        if (str != null) {
                            arrayList.add(str);
                        }
                        listD = arrayList;
                    } else {
                        String str8 = strArr[0];
                        com.google.android.libraries.navigation.internal.yx.ar.q(str8);
                        arrayList.add(str8);
                        str = strArr[1];
                        if (str != null) {
                            arrayList.add(str);
                        }
                        listD = arrayList;
                    }
                } else {
                    listD = hx.d(context.getString(com.google.android.libraries.navigation.internal.hg.a.c, str5));
                }
            }
        } else if (iOrdinal2 == 1) {
            com.google.android.libraries.navigation.internal.bp.bg bgVar2 = bcVar.a;
            String str9 = true != z ? "\n" : StringUtils.SPACE;
            new ArrayList();
            com.google.android.libraries.navigation.internal.adr.bm.a aVar = bgVar2.O;
            if (z3) {
                int iF = com.google.android.libraries.navigation.internal.hf.c.f(i2) - 1;
                if (iF != 0) {
                    string3 = iF != 1 ? cVar.a.getResources().getString(com.google.android.libraries.navigation.internal.f.h.r, cVar.d(Math.abs(i2), aVar, true, true), str9) : cVar.a.getResources().getString(com.google.android.libraries.navigation.internal.f.h.q, str9);
                } else {
                    string3 = cVar.a.getResources().getString(com.google.android.libraries.navigation.internal.f.h.s, cVar.d(Math.abs(i2), aVar, true, true), str9);
                }
                com.google.android.libraries.navigation.internal.yx.ar.q(string3);
                listI = com.google.android.libraries.navigation.internal.yx.bj.b('\n').i(string3);
            } else {
                listI = hx.d(cVar.d(i2, aVar, true, true));
            }
            listD = listI;
            com.google.android.libraries.navigation.internal.yx.ar.k(!listD.isEmpty());
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(listD);
        return ev.o(ev.o(listD));
    }

    private final void j(f fVar, dy dyVar, boolean z) {
        com.google.android.libraries.navigation.internal.ado.i iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
        com.google.android.libraries.navigation.internal.adq.ae aeVar = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
        aeVar.e(com.google.android.libraries.navigation.internal.adq.ad.s);
        com.google.android.libraries.navigation.internal.adq.ah ahVar = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.t();
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.ado.j jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
        ahVar.getClass();
        jVar.c = ahVar;
        jVar.b |= 1;
        com.google.android.libraries.navigation.internal.rp.c.h(dyVar, (com.google.android.libraries.navigation.internal.ado.j) iVar.t());
        fs fsVar = ((ef) dyVar.b).u;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) fsVar.aH(5, null);
        bbVar.x(fsVar);
        fr frVar = (fr) bbVar;
        frVar.C(fu.w, cx.a);
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        bc bcVar = ((k) fVar).b;
        ef efVar = (ef) dyVar.b;
        fs fsVar2 = (fs) frVar.t();
        fsVar2.getClass();
        efVar.u = fsVar2;
        efVar.b |= 65536;
        c(fVar, dyVar, z, bcVar.a);
    }

    public final bg a(Resources resources, String str, cf cfVar, boolean z, boolean z2) {
        m mVar = new m();
        mVar.b(cfVar);
        if (z2) {
            mVar.b = this.a.a().d(resources, str, z);
            return mVar.c();
        }
        mVar.a = this.a.a().b(resources, str, z);
        return mVar.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.libraries.navigation.internal.adr.cj] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    protected final ev b(bc bcVar, boolean z, String str) {
        com.google.android.libraries.navigation.internal.yx.an anVarJ;
        if (!z) {
            return ((com.google.android.libraries.navigation.internal.bp.n) bcVar.a.x).a;
        }
        if (!((com.google.android.libraries.navigation.internal.afl.bh) this.d.b()).f) {
            return ((com.google.android.libraries.navigation.internal.bp.n) bcVar.a.x).b;
        }
        com.google.android.libraries.navigation.internal.bp.bl blVar = bcVar.a.x;
        if (com.google.android.libraries.navigation.internal.yx.aq.c(str) || !blVar.c().containsKey(str)) {
            return blVar.a();
        }
        fd fdVarC = blVar.c();
        int i = ev.d;
        ev evVar = (ev) fdVarC.getOrDefault(str, lv.a);
        eq eqVar = new eq();
        ev evVarA = blVar.a();
        int size = evVarA.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object objC = (cj) evVarA.get(i2);
            int iA = ci.a(objC.c);
            if (iA == 0) {
                iA = ci.a;
            }
            int size2 = evVar.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                    break;
                }
                cj cjVar = (cj) evVar.get(i3);
                int iA2 = ci.a(cjVar.c);
                if (iA2 == 0) {
                    iA2 = ci.a;
                }
                boolean z2 = iA2 == iA;
                if (iA2 == 0) {
                    throw null;
                }
                i3++;
                if (z2) {
                    anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(cjVar);
                    break;
                }
            }
            if (anVarJ.g()) {
                objC = anVarJ.c();
            }
            eqVar.h(objC);
        }
        return eqVar.g();
    }

    protected abstract void c(f fVar, dy dyVar, boolean z, com.google.android.libraries.navigation.internal.bp.bg bgVar);

    @Override // com.google.android.libraries.navigation.internal.cl.ba
    public final void d() {
        h hVar = this.a;
        if (hVar.a) {
            bo boVarA = hVar.a();
            boVarA.d.d();
            boVarA.g.d();
            boVarA.h.d();
            boVarA.i.d();
            boVarA.j.d();
            synchronized (boVarA) {
                Iterator it2 = boVarA.A.values().iterator();
                while (it2.hasNext()) {
                    ((bn) it2.next()).d();
                }
                boVarA.A.clear();
            }
            boVarA.f.d();
            boVarA.e.d();
            ((bk) ((com.google.android.libraries.navigation.internal.yx.aw) boVarA.w).a).d();
            ((bk) ((com.google.android.libraries.navigation.internal.yx.aw) boVarA.x).a).d();
            ((bk) ((com.google.android.libraries.navigation.internal.yx.aw) boVarA.y).a).d();
            ((bk) ((com.google.android.libraries.navigation.internal.yx.aw) boVarA.z).a).d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cl.ba
    public final com.google.android.libraries.navigation.internal.op.f e(final Context context, bd bdVar, bc bcVar, be beVar, boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, boolean z8) {
        f fVar;
        dq dqVar;
        ev evVarG;
        ev evVarQ;
        ev evVarA;
        final f fVar2;
        dq dqVar2;
        boolean z9;
        com.google.android.libraries.navigation.internal.oo.f fVar3;
        String str2;
        com.google.android.libraries.navigation.internal.oo.f fVar4;
        String str3;
        com.google.android.libraries.navigation.internal.yx.ar.q(this.g);
        boolean z10 = (z6 && z2) ? false : z3;
        com.google.android.libraries.navigation.internal.oj.c cVarF = com.google.android.libraries.navigation.internal.oj.c.f(this.g, this.a.a().c(z, z6, false), new com.google.android.libraries.navigation.internal.op.b());
        e eVarH = h(true, z, z10, z6, false);
        eVarH.e(bdVar);
        eVarH.c(bcVar);
        eVarH.d(beVar);
        eVarH.l(z);
        eVarH.k(z2);
        eVarH.m(i);
        eVarH.f(i2);
        eVarH.i(z10);
        eVarH.n(z4);
        eVarH.h(z5);
        eVarH.g(z6);
        eVarH.j(z7);
        ((j) eVarH).a = str;
        f fVarB = eVarH.b();
        k kVar = (k) fVarB;
        com.google.android.libraries.navigation.internal.oo.f fVar5 = kVar.m;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar5);
        dq dqVarB = cVarF.b(fVar5);
        ds dsVar = com.google.android.libraries.navigation.internal.gz.i.a(context) ? ds.RIGHT_JUSTIFY : ds.LEFT_JUSTIFY;
        if (!dqVarB.b.H()) {
            dqVarB.v();
        }
        dt dtVar = (dt) dqVarB.b;
        dt dtVar2 = dt.a;
        dtVar.f = dsVar.d;
        dtVar.b |= 4;
        ev evVarB = b(kVar.b, kVar.h, kVar.k);
        int i3 = ev.d;
        eq eqVar = new eq();
        com.google.android.libraries.navigation.internal.oo.f fVar6 = kVar.i ? kVar.q : kVar.o;
        if (fVar6 == null) {
            evVarG = eqVar.g();
            fVar = fVarB;
            dqVar = dqVarB;
        } else {
            int size = evVarB.size();
            int i4 = 0;
            while (i4 < size) {
                cj cjVar = (cj) evVarB.get(i4);
                bp bpVar = this.f;
                Resources resources = context.getResources();
                ev evVar = evVarB;
                h hVar = this.a;
                int i5 = size;
                boolean z11 = kVar.r;
                dq dqVar3 = dqVarB;
                boolean z12 = kVar.i;
                bo boVarA = hVar.a();
                f fVar7 = fVarB;
                int iA = ci.a(cjVar.c);
                if (iA == 0) {
                    iA = ci.a;
                }
                if (bpVar.b(iA)) {
                    ev evVar2 = lv.a;
                    if ((cjVar.b & 4) != 0) {
                        cg cgVar = cjVar.e;
                        if (cgVar == null) {
                            cgVar = cg.a;
                        }
                        com.google.android.libraries.navigation.internal.oo.f fVarD = boVarA.d(resources, bp.a(cgVar, z11, z12), z12);
                        m mVar = new m();
                        mVar.b = fVarD;
                        cg cgVar2 = cjVar.e;
                        if (cgVar2 == null) {
                            cgVar2 = cg.a;
                        }
                        cf cfVarB = cf.b(cgVar2.d);
                        if (cfVarB == null) {
                            cfVarB = cf.POSITION_UNKNOWN;
                        }
                        mVar.b(cfVarB);
                        evVarQ = ev.q(mVar.c());
                    } else {
                        evVarQ = evVar2;
                    }
                    evVarA = bpVar.a.a(cVarF, resources.getConfiguration(), fVar6, ev.q(cjVar.d), evVarQ, false, false, z12);
                } else {
                    evVarA = lv.a;
                }
                eqVar.j(evVarA);
                i4++;
                evVarB = evVar;
                size = i5;
                dqVarB = dqVar3;
                fVarB = fVar7;
            }
            fVar = fVarB;
            dqVar = dqVarB;
            evVarG = eqVar.g();
        }
        boolean z13 = !evVarG.isEmpty();
        if (bdVar == bd.SHOW_ALTERNATES_WITH_ALL_SEMANTIC_LABELS && z) {
            dqVar2 = dqVar;
            fVar2 = fVar;
        } else {
            ArrayList arrayList = new ArrayList();
            fVar2 = fVar;
            arrayList.addAll(hx.h(kVar.b.e(kVar.r), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.cl.c
                public final /* synthetic */ boolean d = true;

                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    f fVar8 = fVar2;
                    Resources resources2 = context.getResources();
                    cf cfVar = cf.POSITION_START;
                    boolean z14 = ((k) fVar8).i;
                    return this.a.a(resources2, (String) obj, cfVar, z14, true);
                }
            }));
            arrayList.addAll(hx.h(kVar.b.d(kVar.r), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.cl.d
                public final /* synthetic */ boolean d = true;

                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    f fVar8 = fVar2;
                    Resources resources2 = context.getResources();
                    cf cfVar = cf.POSITION_END;
                    boolean z14 = ((k) fVar8).i;
                    return this.a.a(resources2, (String) obj, cfVar, z14, true);
                }
            }));
            if (kVar.j) {
                h hVar2 = this.a;
                boolean z14 = kVar.r;
                bo boVarA2 = hVar2.a();
                com.google.android.libraries.navigation.internal.oo.f fVarB2 = (z14 ? boVarA2.e : boVarA2.f).b();
                m mVar2 = new m();
                mVar2.b = fVarB2;
                mVar2.b(cf.POSITION_START);
                arrayList.add(mVar2.c());
            }
            if (!((com.google.android.libraries.navigation.internal.afl.bh) this.d.b()).e) {
                ev evVarB2 = b(kVar.b, kVar.h, kVar.k);
                int size2 = evVarB2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    cj cjVar2 = (cj) evVarB2.get(i6);
                    int iA2 = ci.a(cjVar2.c);
                    if (iA2 == 0) {
                        iA2 = ci.a;
                    }
                    if (iA2 == ci.b && (cjVar2.b & 4) != 0) {
                        Resources resources2 = context.getResources();
                        cg cgVar3 = cjVar2.e;
                        if (cgVar3 == null) {
                            cgVar3 = cg.a;
                        }
                        boolean z15 = kVar.r;
                        boolean z16 = kVar.i;
                        arrayList.add(a(resources2, bp.a(cgVar3, z15, z16), cf.POSITION_END, z16, true));
                    }
                }
            }
            ev evVarI = i(fVar2, context, z13, this.e);
            bh bhVar = this.b;
            Configuration configuration = context.getResources().getConfiguration();
            com.google.android.libraries.navigation.internal.oo.f fVar8 = kVar.o;
            com.google.android.libraries.navigation.internal.yx.ar.q(fVar8);
            ev evVarA2 = bhVar.a(cVarF, configuration, fVar8, evVarI, ev.o(arrayList), true, true, kVar.i);
            dqVar2 = dqVar;
            dqVar2.c(evVarA2);
        }
        dqVar2.c(evVarG);
        com.google.android.libraries.navigation.internal.bj.b bVar = this.c;
        if (kVar.h) {
            bVar.c();
        }
        if (!kVar.i && (fVar4 = kVar.o) != null && (str3 = (String) kVar.b.c(context.getResources(), bVar).f()) != null) {
            dqVar2.c(this.b.a(cVarF, context.getResources().getConfiguration(), fVar4, ev.q(str3), lv.a, Collections.unmodifiableList(((dt) dqVar2.b).c).isEmpty(), false, kVar.i));
        }
        if (kVar.h || kVar.i || (fVar3 = kVar.q) == null || (str2 = (String) kVar.b.b(context).f()) == null) {
            z9 = false;
        } else {
            dqVar2.c(this.b.a(cVarF, context.getResources().getConfiguration(), fVar3, ev.q(str2), lv.a, Collections.unmodifiableList(((dt) dqVar2.b).c).isEmpty(), false, kVar.i));
            z9 = true;
        }
        dy dyVarC = cVarF.c();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar2 = (com.google.android.libraries.navigation.internal.adg.b) bo.a.get(2);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        dVar.d = bVar2.j;
        dVar.b |= 2;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        ef efVar = (ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        ef efVar2 = ef.a;
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        if (((dt) dqVar2.b).c.size() > 0) {
            if (!dyVarC.b.H()) {
                dyVarC.v();
            }
            ef efVar3 = (ef) dyVarC.b;
            dt dtVar3 = (dt) dqVar2.t();
            dtVar3.getClass();
            efVar3.c = dtVar3;
            efVar3.b = 1 | efVar3.b;
        }
        j(fVar2, dyVarC, z9);
        return ((com.google.android.libraries.navigation.internal.oj.b) cVarF).e();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x031f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.cl.ba
    public final ef f(final Context context, bd bdVar, bc bcVar, be beVar, boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        dq dqVar;
        ev evVarG;
        ev evVarQ;
        ev evVarB;
        dq dqVar2;
        boolean z8;
        com.google.android.libraries.navigation.internal.ol.aq aqVar;
        com.google.android.libraries.navigation.internal.ol.aq aqVar2;
        boolean z9 = (z6 && z2) ? false : z3;
        e eVarH = h(false, z, z9, z6, false);
        eVarH.e(bdVar);
        eVarH.c(bcVar);
        eVarH.d(beVar);
        eVarH.l(z);
        eVarH.k(z2);
        eVarH.m(i);
        eVarH.f(i2);
        eVarH.i(z9);
        eVarH.n(z4);
        eVarH.h(z5);
        eVarH.g(z6);
        eVarH.j(z7);
        ((j) eVarH).a = str;
        final f fVarB = eVarH.b();
        k kVar = (k) fVarB;
        com.google.android.libraries.navigation.internal.ol.aq aqVar3 = kVar.l;
        if (aqVar3 == null || kVar.f375n == null) {
            return ef.a;
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(aqVar3);
        dq dqVarC = aqVar3.c();
        ds dsVar = com.google.android.libraries.navigation.internal.gz.i.a(context) ? ds.RIGHT_JUSTIFY : ds.LEFT_JUSTIFY;
        if (!dqVarC.b.H()) {
            dqVarC.v();
        }
        dt dtVar = (dt) dqVarC.b;
        dt dtVar2 = dt.a;
        dtVar.f = dsVar.d;
        dtVar.b |= 4;
        ev evVarB2 = b(kVar.b, kVar.h, kVar.k);
        int i3 = ev.d;
        eq eqVar = new eq();
        com.google.android.libraries.navigation.internal.ol.aq aqVar4 = kVar.i ? kVar.p : kVar.f375n;
        if (aqVar4 == null) {
            evVarG = eqVar.g();
            dqVar = dqVarC;
        } else {
            int size = evVarB2.size();
            int i4 = 0;
            while (i4 < size) {
                cj cjVar = (cj) evVarB2.get(i4);
                bp bpVar = this.f;
                Resources resources = context.getResources();
                h hVar = this.a;
                ev evVar = evVarB2;
                boolean z10 = kVar.r;
                int i5 = size;
                boolean z11 = kVar.i;
                bo boVarA = hVar.a();
                dq dqVar3 = dqVarC;
                int iA = ci.a(cjVar.c);
                if (iA == 0) {
                    iA = ci.a;
                }
                if (bpVar.b(iA)) {
                    ev evVar2 = lv.a;
                    if ((cjVar.b & 4) != 0) {
                        cg cgVar = cjVar.e;
                        if (cgVar == null) {
                            cgVar = cg.a;
                        }
                        com.google.android.libraries.navigation.internal.ol.aq aqVarB = boVarA.b(resources, bp.a(cgVar, z10, z11), z11);
                        m mVar = new m();
                        mVar.a = aqVarB;
                        cg cgVar2 = cjVar.e;
                        if (cgVar2 == null) {
                            cgVar2 = cg.a;
                        }
                        cf cfVarB = cf.b(cgVar2.d);
                        if (cfVarB == null) {
                            cfVarB = cf.POSITION_UNKNOWN;
                        }
                        mVar.b(cfVarB);
                        evVarQ = ev.q(mVar.c());
                    } else {
                        evVarQ = evVar2;
                    }
                    evVarB = bpVar.a.b(resources.getConfiguration(), aqVar4, ev.q(cjVar.d), evVarQ, false, false, z11);
                } else {
                    evVarB = lv.a;
                }
                eqVar.j(evVarB);
                i4++;
                evVarB2 = evVar;
                size = i5;
                dqVarC = dqVar3;
            }
            dqVar = dqVarC;
            evVarG = eqVar.g();
        }
        boolean z12 = !evVarG.isEmpty();
        if (bdVar == bd.SHOW_ALTERNATES_WITH_ALL_SEMANTIC_LABELS && z) {
            dqVar2 = dqVar;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(hx.h(kVar.b.e(kVar.r), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.cl.a
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    f fVar = fVarB;
                    Resources resources2 = context.getResources();
                    cf cfVar = cf.POSITION_START;
                    boolean z13 = ((k) fVar).i;
                    return this.a.a(resources2, (String) obj, cfVar, z13, false);
                }
            }));
            arrayList.addAll(hx.h(kVar.b.d(kVar.r), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.cl.b
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    f fVar = fVarB;
                    Resources resources2 = context.getResources();
                    cf cfVar = cf.POSITION_END;
                    boolean z13 = ((k) fVar).i;
                    return this.a.a(resources2, (String) obj, cfVar, z13, false);
                }
            }));
            if (kVar.j) {
                h hVar2 = this.a;
                boolean z13 = kVar.r;
                bo boVarA2 = hVar2.a();
                com.google.android.libraries.navigation.internal.ol.aq aqVarA = (z13 ? boVarA2.e : boVarA2.f).a();
                m mVar2 = new m();
                mVar2.a = aqVarA;
                mVar2.b(cf.POSITION_START);
                arrayList.add(mVar2.c());
            }
            if (!((com.google.android.libraries.navigation.internal.afl.bh) this.d.b()).e) {
                ev evVarB3 = b(kVar.b, kVar.h, kVar.k);
                int size2 = evVarB3.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    cj cjVar2 = (cj) evVarB3.get(i6);
                    int iA2 = ci.a(cjVar2.c);
                    if (iA2 == 0) {
                        iA2 = ci.a;
                    }
                    if (iA2 == ci.b && (cjVar2.b & 4) != 0) {
                        Resources resources2 = context.getResources();
                        cg cgVar3 = cjVar2.e;
                        if (cgVar3 == null) {
                            cgVar3 = cg.a;
                        }
                        boolean z14 = kVar.r;
                        boolean z15 = kVar.i;
                        arrayList.add(a(resources2, bp.a(cgVar3, z14, z15), cf.POSITION_END, z15, false));
                    }
                }
            }
            ev evVarI = i(fVarB, context, z12, this.e);
            bh bhVar = this.b;
            Configuration configuration = context.getResources().getConfiguration();
            com.google.android.libraries.navigation.internal.ol.aq aqVar5 = kVar.f375n;
            com.google.android.libraries.navigation.internal.yx.ar.q(aqVar5);
            ev evVarB4 = bhVar.b(configuration, aqVar5, evVarI, ev.o(arrayList), true, true, kVar.i);
            dqVar2 = dqVar;
            dqVar2.c(evVarB4);
        }
        dqVar2.c(evVarG);
        com.google.android.libraries.navigation.internal.bj.b bVar = this.c;
        if (kVar.h) {
            bVar.c();
        }
        if (!kVar.i && (aqVar2 = kVar.f375n) != null) {
            com.google.android.libraries.navigation.internal.yx.an anVarC = kVar.b.c(context.getResources(), bVar);
            if (anVarC.g()) {
                dqVar2.c(this.b.b(context.getResources().getConfiguration(), aqVar2, ev.q(anVarC.c()), lv.a, Collections.unmodifiableList(((dt) dqVar2.b).c).isEmpty(), false, kVar.i));
            }
        }
        if (kVar.h || kVar.i || (aqVar = kVar.p) == null) {
            z8 = false;
        } else {
            com.google.android.libraries.navigation.internal.yx.an anVarB = kVar.b.b(context);
            if (anVarB.g()) {
                dqVar2.c(this.b.b(context.getResources().getConfiguration(), aqVar, ev.q((String) anVarB.c()), lv.a, Collections.unmodifiableList(((dt) dqVar2.b).c).isEmpty(), false, kVar.i));
                z8 = true;
            } else {
                z8 = false;
            }
        }
        dy dyVar = (dy) ef.a.q();
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar2 = (com.google.android.libraries.navigation.internal.adg.b) bo.a.get(2);
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        dVar.d = bVar2.j;
        dVar.b |= 2;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        dVar2.getClass();
        efVar.e = dVar2;
        efVar.b |= 8;
        if (((dt) dqVar2.b).c.size() > 0) {
            if (!dyVar.b.H()) {
                dyVar.v();
            }
            ef efVar2 = (ef) dyVar.b;
            dt dtVar3 = (dt) dqVar2.t();
            dtVar3.getClass();
            efVar2.c = dtVar3;
            efVar2.b |= 1;
        }
        j(fVarB, dyVar, z8);
        return (ef) dyVar.t();
    }
}
