package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends x implements com.google.android.libraries.navigation.internal.ol.j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final com.google.android.libraries.navigation.internal.rm.d f529n = new com.google.android.libraries.navigation.internal.rm.d((byte[]) null);
    private final com.google.android.libraries.navigation.internal.ol.i o;
    private boolean p;

    public y(com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.geo.mapcore.internal.model.ce ceVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2, hi hiVar, w wVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ol.a aVar, boolean z) {
        super(aqVar, kVar, hVar, ceVar, aqVar2, hiVar, wVar, axVar, tVar, grVar, sVar, aVar);
        com.google.android.libraries.navigation.internal.ol.i iVar = new com.google.android.libraries.navigation.internal.ol.i();
        this.o = iVar;
        this.p = true;
        iVar.b(this.i);
        iVar.c(0.0f, this.i);
        iVar.d(1.0f, com.google.android.libraries.navigation.internal.ol.h.PIXEL);
    }

    @Override // com.google.android.libraries.navigation.internal.po.x
    public final synchronized void B() {
        com.google.android.libraries.navigation.internal.oe.x xVarC;
        ay ayVar;
        com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
        if (this.a) {
            super.B();
            if (this.p) {
                this.p = false;
                com.google.android.libraries.navigation.internal.ol.i iVar = this.o;
                com.google.android.libraries.navigation.internal.oe.x xVarV = com.google.android.libraries.navigation.internal.oe.x.v(iVar.a);
                float f = -iVar.d;
                com.google.android.libraries.navigation.internal.oe.x xVarV2 = com.google.android.libraries.navigation.internal.oe.x.v(iVar.e);
                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = iVar.b;
                float f2 = ayVar2.b;
                float f3 = ayVar2.c;
                com.google.android.libraries.navigation.internal.oe.x xVar = this.i;
                com.google.android.libraries.navigation.internal.ol.h hVar = iVar.c;
                if (f != 0.0f) {
                    xVarC = xVarV.C(xVarV2);
                    xVarC.U(Math.toRadians(f));
                    xVarC.S(xVarV2);
                } else {
                    xVarC = xVarV;
                }
                this.g.k(xVarC);
                Iterator it2 = f().iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.qq.j) it2.next()).k(xVarC);
                }
                this.g.j(f);
                Iterator it3 = f().iterator();
                while (it3.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.qq.j) it3.next()).j(f);
                }
                if (hVar == com.google.android.libraries.navigation.internal.ol.h.PIXEL) {
                    this.g.m(f2, f3);
                    Iterator it4 = f().iterator();
                    while (it4.hasNext()) {
                        ((com.google.android.libraries.navigation.internal.qq.j) it4.next()).m(f2, f3);
                    }
                    if (this.h != null) {
                        ay ayVar3 = this.h;
                        float f4 = (1.0f / f2) * ayVar3.g;
                        aw awVar = ayVar3.p;
                        awVar.a = true;
                        awVar.b = f4;
                        ayVar3.d();
                    }
                } else {
                    if (hVar != com.google.android.libraries.navigation.internal.ol.h.WORLD) {
                        throw new UnsupportedOperationException("This scale type is not supported yet.");
                    }
                    this.g.l(f2);
                    Iterator it5 = f().iterator();
                    while (it5.hasNext()) {
                        ((com.google.android.libraries.navigation.internal.qq.j) it5.next()).l(f2);
                    }
                    if (f2 != 0.0f && (ayVar = this.h) != null) {
                        ayVar.q = 1.0f / f2;
                        aw awVar2 = ayVar.p;
                        awVar2.a = false;
                        awVar2.b = 1.0f;
                        ayVar.d();
                    }
                }
                com.google.android.libraries.navigation.internal.rm.c cVar = new com.google.android.libraries.navigation.internal.rm.c();
                cVar.g(xVar.a - xVarV.a, xVar.b - xVarV.b, 0.0f);
                cVar.g(xVarV2.a, xVarV2.b, 0.0f);
                cVar.b(f529n, -f);
                cVar.g(-xVarV2.a, -xVarV2.b, 0.0f);
                if (this.f != null) {
                    if (hVar == com.google.android.libraries.navigation.internal.ol.h.WORLD) {
                        this.f.c(cVar, f2);
                    } else {
                        this.f.b(cVar, f2, f3);
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.j
    public final com.google.android.libraries.navigation.internal.ol.i c() {
        com.google.android.libraries.navigation.internal.ol.i iVar = new com.google.android.libraries.navigation.internal.ol.i();
        synchronized (this) {
            iVar.a(this.o);
        }
        return iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.j
    public final void d(com.google.android.libraries.navigation.internal.ol.i iVar) {
        synchronized (this) {
            boolean zEquals = this.o.a.equals(iVar.a);
            boolean z = (this.o.b.equals(iVar.b) && this.o.c == iVar.c) ? false : true;
            com.google.android.libraries.navigation.internal.ol.i iVar2 = this.o;
            boolean z2 = (iVar2.d == iVar.d && iVar2.e.equals(iVar.e)) ? false : true;
            this.o.a(iVar);
            if (!zEquals || z2 || z) {
                this.p = true;
                this.m.b();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.po.x
    protected final ay e(x xVar, w wVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.geo.mapcore.internal.model.g gVar, com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2) {
        com.google.android.libraries.navigation.internal.adg.gm gmVar = aqVar.c;
        if (gmVar == null) {
            gmVar = com.google.android.libraries.navigation.internal.adg.gm.a;
        }
        List listC = C(gmVar, kVar);
        int i = gVar.c;
        int i2 = aqVar.l;
        int iA = com.google.android.libraries.navigation.internal.adg.cz.a(aqVar.f);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.adg.cz.a;
        }
        com.google.android.libraries.navigation.internal.adg.fh fhVar = (com.google.android.libraries.navigation.internal.adg.fh) com.google.android.libraries.navigation.internal.adg.fi.a.q();
        no it2 = ((com.google.android.libraries.navigation.internal.yz.ev) listC).iterator();
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            com.google.android.libraries.navigation.internal.ael.x xVar2 = (com.google.android.libraries.navigation.internal.ael.x) it2.next();
            int iB = kVar.b(xVar2);
            no noVar = it2;
            D(fhVar, iB, xVar2, aqVar2, i, i2, iA);
            int i3 = iB + iB;
            float[] fArr = new float[i3];
            kVar.i(xVar2, 0, fArr);
            for (int i4 = 0; i4 < i3 - 1; i4 += 2) {
                fMin = Math.min(fArr[i4], fMin);
                fMin2 = Math.min(fArr[i4 + 1], fMin2);
            }
            it2 = noVar;
        }
        com.google.android.libraries.navigation.internal.ol.r rVarA = wVar.a(xVar, hVar, kVar, (com.google.android.libraries.navigation.internal.adg.fi) fhVar.t());
        if (rVarA == Cdo.a) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ay ayVar = (ay) rVarA;
        ayVar.b(arrayList);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            com.google.android.libraries.navigation.internal.qq.j jVar = (com.google.android.libraries.navigation.internal.qq.j) arrayList.get(i5);
            if (jVar.s) {
                com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
            }
            float[] fArr2 = jVar.f;
            fArr2[0] = fMin;
            fArr2[1] = fMin2;
            fArr2[2] = 0.0f;
            jVar.p = true;
        }
        return ayVar;
    }
}
