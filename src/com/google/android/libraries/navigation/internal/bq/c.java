package com.google.android.libraries.navigation.internal.bq;

import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.agg.es;
import com.google.android.libraries.navigation.internal.bp.ay;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.bd;
import com.google.android.libraries.navigation.internal.oe.h;
import com.google.android.libraries.navigation.internal.oe.t;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c implements ay {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.bq.c");
    public final bj b;
    private final ad c;
    private final t d;
    private final es e;
    private final List f;
    private final ev g;
    private final ad[][] h;
    private final t[][] i;
    private final ev j;
    private final boolean k;
    private final bg l;

    public c(b bVar) {
        ad adVarN = ad.n(bVar.f);
        this.c = adVarN;
        this.d = h(adVarN, bVar.d, bVar.e);
        es esVar = bVar.g;
        int i = ((de) esVar).b;
        if (i > 2) {
            this.e = esVar.subList(1, i);
        } else {
            de deVar = new de(1);
            this.e = deVar;
            deVar.c(adVarN.e() - 1);
        }
        ArrayList arrayList = new ArrayList(this.e.size());
        this.f = arrayList;
        arrayList.addAll(Collections.nCopies(this.e.size(), null));
        ev evVar = bVar.h;
        this.g = evVar;
        this.h = new ad[evVar.size()][];
        this.i = new t[evVar.size()][];
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            int size = ((es) this.g.get(i2)).size();
            this.h[i2] = new ad[size];
            this.i[i2] = new t[size];
        }
        this.j = ev.o(bVar.i);
        this.k = bVar.c;
        this.l = bVar.a;
        this.b = bVar.b;
    }

    private static t h(ad adVar, Integer num, Integer num2) {
        ai aiVarM = ai.m(adVar);
        if (aiVarM == null) {
            return null;
        }
        if (num == null || num2 == null) {
            return h.b(new bd(aiVarM));
        }
        if (aiVarM.a.l(aiVarM.b) < num.intValue()) {
            aiVarM = aiVarM.f((int) (((double) num2.intValue()) * aiVarM.a.e()));
        }
        return h.b(new bd(aiVarM));
    }

    private static t i(ad adVar) {
        return h(adVar, null, null);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final bg a() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final bj b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final ev c() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final boolean d() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final void e() {
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final t f() {
        ao aoVar;
        int size = this.e.size();
        if (size <= 0) {
            aoVar = null;
        } else if (size == 1) {
            aoVar = new ao(this.c, this.d);
        } else {
            ao aoVar2 = (ao) this.f.get(0);
            if (aoVar2 == null) {
                ad adVarC = new an(this.c, 0, this.e.B(0).intValue() + 1).c();
                ao aoVar3 = new ao(adVarC, i(adVarC));
                this.f.set(0, aoVar3);
                aoVar = aoVar3;
            } else {
                aoVar = aoVar2;
            }
        }
        if (aoVar == null) {
            return null;
        }
        return (t) aoVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ay
    public final t g() {
        t[] tVarArr;
        ad[] adVarArr;
        ad adVarC;
        t[][] tVarArr2 = this.i;
        if (tVarArr2.length <= 0 || (tVarArr = tVarArr2[0]) == null || tVarArr.length <= 0) {
            return null;
        }
        t tVar = tVarArr[0];
        if (tVar != null) {
            return tVar;
        }
        ad[][] adVarArr2 = this.h;
        if (adVarArr2.length > 0 && (adVarArr = adVarArr2[0]) != null && adVarArr.length > 0) {
            adVarC = adVarArr[0];
            if (adVarC == null) {
                adVarC = new an(this.c, 0, ((es) this.g.get(0)).B(0).intValue() + 1).c();
                adVarArr[0] = adVarC;
            }
        } else {
            adVarC = null;
        }
        if (adVarC == null) {
            return null;
        }
        t tVarI = i(adVarC);
        tVarArr[0] = tVarI;
        return tVarI;
    }
}
