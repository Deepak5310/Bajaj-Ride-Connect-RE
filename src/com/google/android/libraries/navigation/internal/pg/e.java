package com.google.android.libraries.navigation.internal.pg;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cr;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.u;
import com.google.android.libraries.geo.mapcore.renderer.v;
import com.google.android.libraries.navigation.internal.agi.gt;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.bc;
import com.google.android.libraries.navigation.internal.oe.bd;
import com.google.android.libraries.navigation.internal.oe.w;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e extends j {
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.pg.e");
    private final Set g;
    private final bd h;
    private float i;
    private int j;
    private an k;
    private final ai l;

    public e(com.google.android.libraries.navigation.internal.adi.an anVar, ct ctVar, an anVar2) {
        super(anVar, ctVar);
        this.g = new gt();
        this.h = new bd(new ai(new x(), new x()));
        this.i = -1.0f;
        this.j = -1;
        this.k = com.google.android.libraries.navigation.internal.yx.a.a;
        this.l = new ai(new x(), new x());
        this.k = anVar2;
    }

    private final long g(List list) {
        list.addAll(this.g);
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final synchronized long a(t tVar, List list) {
        com.google.android.libraries.navigation.internal.pd.d dVar;
        int i;
        int i2;
        boolean zJ;
        list.clear();
        Set set = this.g;
        v vVarX = tVar.x();
        boolean zIsEmpty = set.isEmpty();
        com.google.android.libraries.navigation.internal.pd.d dVar2 = vVarX.a;
        x xVar = new x(vVarX.h, vVarX.i, vVarX.j);
        float f2 = dVar2.k;
        cr crVarA = this.e.a(xVar, this.a);
        int iA = crVarA != null ? crVarA.a(f2) : (int) f2;
        if (!zIsEmpty && vVarX == this.d && iA == this.j) {
            return g(list);
        }
        bc bcVar = vVarX.u;
        if (this.k.g()) {
            float fB = w.b(tVar.o()) * ((Float) this.k.c()).floatValue();
            double d = vVarX.a.l;
            float f3 = vVarX.q;
            double d2 = fB + f3;
            double dAtan2 = Math.atan2(d2 - ((double) f3), Math.tan(0.017453292519943295d * d) * d2) * 57.29577951308232d;
            bc bcVar2 = new bc(new x[]{new x(), new x(), new x(), new x()});
            u.H(vVarX.a, vVarX.h, vVarX.i, vVarX.k, vVarX.l, vVarX.m, vVarX.b, vVarX.c, vVarX.g, vVarX.r, (float) (dAtan2 + d), vVarX.y, bcVar2, new float[8]);
            bcVar = bcVar2;
            dVar = dVar2;
        } else {
            dVar = dVar2;
        }
        if (dVar.l == 0.0f && dVar.m == 0.0f) {
            if (!zIsEmpty && this.i == dVar.k && this.j == i) {
                i2 = 0;
                if (this.h.g(bcVar.c(0))) {
                    if (this.h.g(bcVar.c(2))) {
                        i = iA;
                        return g(list);
                    }
                    i = iA;
                }
                i = iA;
                list = list;
            } else {
                i = iA;
                i2 = 0;
            }
            zJ = cd.j(bcVar.d, i, list, this.h);
            this.i = dVar.k;
        } else {
            list = list;
            i = iA;
            i2 = 0;
            zJ = cd.j(bcVar.d, i, list, null);
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                cd cdVar = (cd) list.get(i4);
                cdVar.i(this.l);
                if (bcVar.k(this.l)) {
                    list.set(i3, cdVar);
                    i3++;
                }
            }
            while (true) {
                size--;
                if (size < i3) {
                    break;
                }
                list.remove(size);
            }
            this.i = -1.0f;
        }
        if (!zJ) {
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(845)).x("Excessive tile coordinate count from rect %s and %s", bcVar.d, dVar);
        }
        f(list, dVar.j);
        int size2 = list.size();
        for (int i5 = i2; i5 < size2; i5++) {
            if (!this.g.contains(list.get(i5))) {
                this.b++;
                break;
            }
        }
        this.g.clear();
        this.g.addAll(list);
        this.d = vVarX;
        this.j = i;
        return this.b;
    }
}
