package com.google.android.libraries.navigation.internal.abm;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.libraries.navigation.internal.abh.fn;
import com.google.android.libraries.navigation.internal.abh.fw;
import com.google.android.libraries.navigation.internal.adg.gl;
import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ds extends com.google.android.libraries.navigation.internal.ol.ar implements fn {
    static final jr a = jr.WORLD_ENCODING_LAT_LNG_DOUBLE;
    public final fw b;
    public final com.google.android.libraries.navigation.internal.ol.z c;
    public final df d;
    public final com.google.android.libraries.navigation.internal.abf.z e;
    final com.google.android.libraries.navigation.internal.adg.ap f;
    boolean g;
    boolean h;
    private final float i;
    private final f j;
    private final Executor k;
    private final dr l;
    private final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final gl f135n;
    private final ic o;
    private final z p;
    private final List q;
    private final List r;

    public ds(float f, com.google.android.libraries.navigation.internal.ol.z zVar, fw fwVar, int i) {
        z zVar2 = new z(zVar);
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        f fVar = f.a;
        df dfVar = df.b;
        com.google.android.libraries.navigation.internal.abf.z zVar3 = com.google.android.libraries.navigation.internal.abf.z.a;
        dr drVar = dr.a;
        this.i = f;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.c = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(fwVar, "polyModel");
        this.b = fwVar;
        this.m = i;
        this.p = zVar2;
        this.k = executorA;
        this.j = fVar;
        com.google.android.libraries.navigation.internal.abf.s.k(dfVar, "multiZoomStyleFactoryPhoenix");
        this.d = dfVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar3, "uiThreadChecker");
        this.e = zVar3;
        this.l = drVar;
        this.g = false;
        this.h = false;
        this.f = (com.google.android.libraries.navigation.internal.adg.ap) com.google.android.libraries.navigation.internal.adg.aq.a.q();
        this.f135n = (gl) gm.a.q();
        this.o = (ic) id.a.q();
        this.q = new ArrayList();
        this.r = new ArrayList();
    }

    private final com.google.android.libraries.navigation.internal.ol.as f() {
        if (this.b.H()) {
            return this;
        }
        return null;
    }

    private final void g() {
        int iB;
        final int i = ((com.google.android.libraries.navigation.internal.adg.aq) this.f.b).i;
        int iA = this.b.J() ? this.b.A() : 0;
        if (this.b.K() != null) {
            df dfVar = this.d;
            com.google.android.libraries.navigation.internal.ol.z zVar = this.c;
            fw fwVar = this.b;
            ic icVar = this.o;
            float f = this.i;
            PatternItem[] patternItemArrK = fwVar.K();
            float fY = fwVar.y();
            float fZ = fwVar.z();
            com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
            com.google.android.libraries.navigation.internal.abf.s.k(patternItemArrK, "patternItems");
            com.google.android.libraries.navigation.internal.abf.s.k(icVar, "strokeStyleBuilder");
            com.google.android.libraries.navigation.internal.on.c cVar = new com.google.android.libraries.navigation.internal.on.c(fY, f);
            com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
            com.google.android.libraries.navigation.internal.abf.s.k(patternItemArrK, "patternItems");
            com.google.android.libraries.navigation.internal.abf.s.k(icVar, "strokeStyleBuilder");
            f fVar = dfVar.c;
            com.google.android.libraries.navigation.internal.abf.s.k(fVar, "concl/versionUtilsPhoenix");
            com.google.android.libraries.navigation.internal.ol.ax axVarE = zVar.e();
            int iB2 = fVar.b(fZ);
            com.google.android.libraries.navigation.internal.ol.aq aqVarD = axVarE.d(iB2, ev.q(new com.google.android.libraries.navigation.internal.ol.b((id) icVar.t(), df.c(patternItemArrK, cVar), null, null)));
            iB = ((com.google.android.libraries.navigation.internal.po.dq) axVarE.b(iA, iB2, aqVarD)).e;
            axVarE.j(aqVarD);
        } else {
            iB = this.d.b(this.c, this.o, iA, this.b.z());
        }
        com.google.android.libraries.navigation.internal.adg.ap apVar = this.f;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        aqVar.b |= 128;
        aqVar.i = iB;
        this.p.d((com.google.android.libraries.navigation.internal.adg.aq) this.f.t(), a, f(), 1.0f, new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dp
            @Override // java.lang.Runnable
            public final void run() {
                ds dsVar = this.a;
                dsVar.d.d(dsVar.c, i);
            }
        });
    }

    private final void h() {
        if (this.b.I()) {
            gl glVar = this.f135n;
            if (!glVar.b.H()) {
                glVar.v();
            }
            gm.e((gm) glVar.b);
            gl glVar2 = this.f135n;
            if (!glVar2.b.H()) {
                glVar2.v();
            }
            gm gmVar = (gm) glVar2.b;
            gmVar.b &= -9;
            gmVar.j = -1;
        } else {
            gl glVar3 = this.f135n;
            if (!glVar3.b.H()) {
                glVar3.v();
            }
            gm.d((gm) glVar3.b);
            gl glVar4 = this.f135n;
            if (!glVar4.b.H()) {
                glVar4.v();
            }
            gm gmVar2 = (gm) glVar4.b;
            gmVar2.b &= -5;
            gmVar2.h = -1;
        }
        this.b.E(this.q);
        this.b.D(this.r);
        List list = this.q;
        List list2 = this.r;
        com.google.android.libraries.navigation.internal.abf.s.a(!list.isEmpty(), "Outline cannot be empty");
        ArrayList<List> arrayList = new ArrayList(list2.size() + 1);
        arrayList.add(list);
        arrayList.addAll(list2);
        int size = 0;
        for (List list3 : arrayList) {
            com.google.android.libraries.navigation.internal.abf.s.k(list3, arrayList.toString());
            size += list3.size();
        }
        double[] dArr = new double[size + size];
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            List<LatLng> list4 = (List) arrayList.get(i2);
            if (!list4.isEmpty()) {
                for (LatLng latLng : list4) {
                    dArr[i] = latLng.latitude;
                    dArr[i + 1] = latLng.longitude;
                    i += 2;
                }
                arrayList2.add(Integer.valueOf(i / 2));
            }
        }
        e eVar = new e(dArr, arrayList2);
        gl glVar5 = this.f135n;
        com.google.android.libraries.navigation.internal.ael.x xVarB = com.google.android.libraries.navigation.internal.on.k.b(eVar.a);
        if (!glVar5.b.H()) {
            glVar5.v();
        }
        gm gmVar3 = (gm) glVar5.b;
        gmVar3.b |= 1;
        gmVar3.c = xVarB;
        gl glVar6 = this.f135n;
        int length = eVar.a.length >> 1;
        if (!glVar6.b.H()) {
            glVar6.v();
        }
        gm gmVar4 = (gm) glVar6.b;
        gmVar4.b |= 2;
        gmVar4.f = length;
        gl glVar7 = this.f135n;
        if (!glVar7.b.H()) {
            glVar7.v();
        }
        ((gm) glVar7.b).d = com.google.android.libraries.navigation.internal.ael.bj.a;
        gl glVar8 = this.f135n;
        List list5 = eVar.b;
        if (!glVar8.b.H()) {
            glVar8.v();
        }
        gm gmVar5 = (gm) glVar8.b;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = gmVar5.d;
        if (!bqVar.c()) {
            gmVar5.d = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(list5, gmVar5.d);
        com.google.android.libraries.navigation.internal.adg.ap apVar = this.f;
        gl glVar9 = this.f135n;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        gm gmVar6 = (gm) glVar9.t();
        com.google.android.libraries.navigation.internal.adg.aq aqVar2 = com.google.android.libraries.navigation.internal.adg.aq.a;
        gmVar6.getClass();
        aqVar.c = gmVar6;
        aqVar.b |= 1;
    }

    private final void i() {
        int iB = this.b.J() ? this.b.B() : 0;
        ic icVar = this.o;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar = (id) icVar.b;
        id idVar2 = id.a;
        idVar.b |= 1;
        idVar.c = iB;
    }

    private final void j() {
        int iA = this.j.a(this.b.y(), this.i);
        ic icVar = this.o;
        if (!icVar.b.H()) {
            icVar.v();
        }
        id idVar = (id) icVar.b;
        id idVar2 = id.a;
        idVar.b |= 8;
        idVar.e = iA;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dq
            @Override // java.lang.Runnable
            public final void run() {
                ds dsVar = this.a;
                dsVar.e.a();
                if (dsVar.g && !dsVar.h && dsVar.b.H()) {
                    dsVar.b.F();
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void b(Set set) {
        this.e.a();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            c(((Integer) it2.next()).intValue());
        }
        set.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void c(int i) {
        this.e.a();
        com.google.android.libraries.navigation.internal.abf.s.d(this.g, "init() should be called first");
        if (this.h) {
            return;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                h();
                this.p.b((com.google.android.libraries.navigation.internal.adg.aq) this.f.t(), a, f());
                return;
            case 3:
                j();
                g();
                return;
            case 4:
            case 6:
                i();
                g();
                return;
            case 5:
            case 7:
            case 11:
                g();
                return;
            case 8:
            case 9:
            default:
                throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i, "Invalid notifyPropertyUpdated(", ")"));
            case 10:
                k();
                this.p.b((com.google.android.libraries.navigation.internal.adg.aq) this.f.t(), a, f());
                return;
            case 12:
                this.p.e(f());
                return;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fn
    public final void d() {
        this.e.a();
        com.google.android.libraries.navigation.internal.abf.s.d(this.g, "init() should be called first");
        if (this.h) {
            return;
        }
        this.d.d(this.c, ((com.google.android.libraries.navigation.internal.adg.aq) this.f.b).i);
        this.p.a();
        this.h = true;
    }

    public final void e() {
        boolean z = this.g;
        boolean z2 = false;
        if (!z && !this.h) {
            z2 = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.e(z2, "isInitialized=%s isRemoved=%s", Boolean.valueOf(z), Boolean.valueOf(this.h));
        com.google.android.libraries.navigation.internal.adg.ap apVar = this.f;
        int i = this.m;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        com.google.android.libraries.navigation.internal.adg.aq aqVar2 = com.google.android.libraries.navigation.internal.adg.aq.a;
        aqVar.b |= 512;
        aqVar.k = i;
        com.google.android.libraries.navigation.internal.adg.ap apVar2 = this.f;
        if (!apVar2.b.H()) {
            apVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar3 = (com.google.android.libraries.navigation.internal.adg.aq) apVar2.b;
        aqVar3.b |= 4;
        aqVar3.e = true;
        h();
        k();
        j();
        i();
        g();
        this.g = true;
    }

    private final void k() {
        int iC = this.b.C();
        if (iC == 0) {
            com.google.android.libraries.navigation.internal.adg.ap apVar = this.f;
            int i = com.google.android.libraries.navigation.internal.adg.cz.b;
            if (!apVar.b.H()) {
                apVar.v();
            }
            com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
            com.google.android.libraries.navigation.internal.adg.aq aqVar2 = com.google.android.libraries.navigation.internal.adg.aq.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            aqVar.f = i2;
            aqVar.b |= 8;
            return;
        }
        if (iC == 1) {
            com.google.android.libraries.navigation.internal.adg.ap apVar2 = this.f;
            int i3 = com.google.android.libraries.navigation.internal.adg.cz.a;
            if (!apVar2.b.H()) {
                apVar2.v();
            }
            com.google.android.libraries.navigation.internal.adg.aq aqVar3 = (com.google.android.libraries.navigation.internal.adg.aq) apVar2.b;
            com.google.android.libraries.navigation.internal.adg.aq aqVar4 = com.google.android.libraries.navigation.internal.adg.aq.a;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            aqVar3.f = i4;
            aqVar3.b |= 8;
            return;
        }
        if (iC != 2) {
            com.google.android.libraries.navigation.internal.adg.ap apVar3 = this.f;
            int i5 = com.google.android.libraries.navigation.internal.adg.cz.b;
            if (!apVar3.b.H()) {
                apVar3.v();
            }
            com.google.android.libraries.navigation.internal.adg.aq aqVar5 = (com.google.android.libraries.navigation.internal.adg.aq) apVar3.b;
            com.google.android.libraries.navigation.internal.adg.aq aqVar6 = com.google.android.libraries.navigation.internal.adg.aq.a;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            aqVar5.f = i6;
            aqVar5.b |= 8;
            return;
        }
        com.google.android.libraries.navigation.internal.adg.ap apVar4 = this.f;
        int i7 = com.google.android.libraries.navigation.internal.adg.cz.c;
        if (!apVar4.b.H()) {
            apVar4.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar7 = (com.google.android.libraries.navigation.internal.adg.aq) apVar4.b;
        com.google.android.libraries.navigation.internal.adg.aq aqVar8 = com.google.android.libraries.navigation.internal.adg.aq.a;
        int i8 = i7 - 1;
        if (i7 == 0) {
            throw null;
        }
        aqVar7.f = i8;
        aqVar7.b |= 8;
    }
}
