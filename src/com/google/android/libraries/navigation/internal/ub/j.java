package com.google.android.libraries.navigation.internal.ub;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.afl.fa;
import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oe.y;
import com.google.android.libraries.navigation.internal.pb.ac;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public final com.google.android.libraries.navigation.internal.fz.d a;
    private final com.google.android.libraries.navigation.internal.uc.i d;
    private final com.google.android.libraries.navigation.internal.oq.h e;
    private final float f;
    public final ay b = new ay(0.0f, 0.0f);
    private final float[] g = new float[8];
    private float h = -1.0f;
    public final ac c = new ac(new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f), ad.n(hx.d(new x(0, 0))));

    public j(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.uc.i iVar, com.google.android.libraries.navigation.internal.oq.h hVar, float f) {
        this.a = dVar;
        this.d = iVar;
        this.e = hVar;
        this.f = f;
    }

    private final fa c(ff ffVar) {
        com.google.android.libraries.navigation.internal.uc.b bVar = (com.google.android.libraries.navigation.internal.uc.b) this.d;
        boolean z = bVar.c;
        fa faVar = this.a.b().i(bVar.a, bVar.b, z, ffVar).d;
        return faVar == null ? fa.a : faVar;
    }

    public final float a(ff ffVar) {
        return c(ffVar).d;
    }

    final com.google.android.libraries.navigation.internal.rf.g b(x xVar, x xVar2, List list, Rect rect, ff ffVar, int i, int i2, int i3, int i4, float f, float f2) {
        x xVar3;
        x xVar4;
        if (xVar != null) {
            xVar3 = xVar;
        } else {
            if (list.isEmpty()) {
                return null;
            }
            xVar3 = new x();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                xVar3.S(((an) it2.next()).b(0));
            }
            xVar3.V(1.0f / list.size());
        }
        if (xVar2 != null) {
            xVar4 = xVar2;
        } else {
            if (list == null || list.isEmpty()) {
                return null;
            }
            xVar4 = new x();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                an anVar = (an) it3.next();
                xVar4.S(anVar.b(anVar.a() - 1));
            }
            xVar4.V(1.0f / list.size());
        }
        int iMax = Math.max(i3, ((int) (25.0f * f2)) + (i2 - rect.bottom));
        float fExactCenterX = rect.exactCenterX();
        com.google.android.libraries.navigation.internal.pd.e eVar = new com.google.android.libraries.navigation.internal.pd.e(((fExactCenterX + fExactCenterX) / i) - 1.0f, 1.0f - ((iMax + iMax) / i2));
        float fA = a(ffVar);
        float fA2 = this.e.a(fA);
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        com.google.android.libraries.navigation.internal.pd.a aVar = new com.google.android.libraries.navigation.internal.pd.a();
        aVar.e(xVar3);
        aVar.c = fA;
        aVar.d = Math.min(fA2, c(ffVar).c);
        aVar.e = y.c(xVar3, xVar4);
        aVar.f = eVar;
        com.google.android.libraries.navigation.internal.pd.d dVarA = aVar.a();
        if (!Float.isNaN(Float.NaN)) {
            com.google.android.libraries.navigation.internal.pd.a aVar2 = new com.google.android.libraries.navigation.internal.pd.a(dVarA);
            aVar2.e = Float.NaN;
            dVarA = aVar2.a();
        }
        float fA3 = a(ffVar);
        com.google.android.libraries.navigation.internal.rf.g gVar = new com.google.android.libraries.navigation.internal.rf.g(com.google.android.libraries.navigation.internal.pd.d.b(dVarA), i, i2, f2);
        if (!list.isEmpty()) {
            x xVar5 = new x();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                an anVar2 = (an) it4.next();
                int iMax2 = Math.max(anVar2.a() / 10, 1);
                for (int i5 = 0; i5 < anVar2.a(); i5 += iMax2) {
                    anVar2.e(i5, xVar5);
                    gVar = com.google.android.libraries.navigation.internal.pb.j.v(gVar, this.e, xVar5, rect, i4, fA3, this.h, this.f);
                }
            }
        }
        com.google.android.libraries.navigation.internal.rf.g gVarV = com.google.android.libraries.navigation.internal.pb.j.v(gVar, this.e, xVar4, rect, i4, fA3, this.h, this.f);
        this.h = ((com.google.android.libraries.navigation.internal.oq.b) gVarV.g()).e;
        return gVarV;
    }
}
