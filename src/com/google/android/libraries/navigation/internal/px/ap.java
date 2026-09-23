package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap {
    final ev a;
    final ev b;
    final ev c;
    final ev d;
    public final com.google.android.libraries.geo.mapcore.renderer.et e;
    final ev f;
    public final com.google.android.libraries.navigation.internal.oe.ay g = new com.google.android.libraries.navigation.internal.oe.ay();
    public double h;
    public float i;
    public final float j;
    public final float k;
    public ao l;

    public ap() {
        int i = ev.d;
        this.a = lv.a;
        this.f = lv.a;
        this.b = lv.a;
        this.c = lv.a;
        this.d = lv.a;
        this.e = null;
        this.j = 0.0f;
        this.k = 0.0f;
    }

    public final void a() {
        ar.i(this.a);
        ar.i(this.d);
        com.google.android.libraries.geo.mapcore.renderer.et etVar = this.e;
        if (etVar != null) {
            etVar.c();
        }
    }

    public final boolean b() {
        if (this.f.isEmpty()) {
            return false;
        }
        return this.f.size() == this.a.size();
    }

    public ap(ar arVar, List list, List list2, List list3, List list4, List list5) {
        this.a = ev.o(list);
        this.f = ev.o(list5);
        this.b = ev.o(list2);
        this.c = ev.o(list3);
        this.d = ev.o(list4);
        com.google.android.libraries.navigation.internal.qc.a aVar = arVar.g;
        this.e = aVar == null ? null : aVar.j();
        this.j = arVar.c();
        this.k = arVar.a();
    }
}
