package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.zr.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    static final long a = TimeUnit.SECONDS.toMillis(60);
    public final t b = new t();
    public final List c = new ArrayList();
    public final List d = new ArrayList();
    public com.google.android.libraries.navigation.internal.oe.x e = null;
    public com.google.android.libraries.navigation.internal.db.r f = null;

    public static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 1; i < list.size(); i++) {
            if (((ck) list.get(i)).n() == null || ((ck) list2.get(i)).n() == null || !com.google.android.libraries.navigation.internal.oe.x.z(((ck) list.get(i)).n()).equals(com.google.android.libraries.navigation.internal.oe.x.z(((ck) list2.get(i)).n()))) {
                return false;
            }
        }
        return true;
    }

    public final int a(s sVar) {
        double dE = this.f.e(sVar.d);
        com.google.android.libraries.navigation.internal.oe.x xVar = this.e;
        ar.q(xVar);
        double dH = ((double) xVar.h(sVar.d)) / sVar.d.e();
        return (int) Math.round(((dH - dE) / dH) * 100.0d);
    }

    public final s b() {
        if (this.c.size() == 1) {
            return (s) this.c.get(0);
        }
        al alVar = ((s) this.c.get(0)).b;
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            if (((s) it2.next()).b != alVar) {
                alVar = al.MIXED;
                break;
            }
        }
        s sVar = new s(0L, alVar, ((s) gs.d(this.c)).c, ((s) gs.d(this.c)).d);
        sVar.f = true;
        Iterator it3 = this.c.iterator();
        while (it3.hasNext()) {
            sVar.f = sVar.f && ((s) it3.next()).f;
        }
        for (s sVar2 : this.c) {
            sVar.g += sVar2.g;
            sVar.i += sVar2.i;
            if (sVar.f) {
                sVar.h += sVar2.h;
            }
        }
        return sVar;
    }

    public final String toString() {
        if (this.c.isEmpty()) {
            return "RouteStats{}";
        }
        s sVarB = b();
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        sVarB.a(akVarB);
        for (int i = 0; i < this.d.size(); i++) {
            akVarB.g(Integer.toString(i), (cu) this.d.get(i));
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = sVarB.d;
        if (this.e != null && this.f != null) {
            akVarB.c("PROGRESS_PERCENTAGE", a(sVarB));
        }
        akVarB.g("ROUTE_SOURCES", this.b.toString());
        return akVarB.toString();
    }
}
