package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ej;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public final bg a;
    public final com.google.android.libraries.navigation.internal.hx.ag b;
    public volatile com.google.android.libraries.navigation.internal.rw.p d;
    private final ev f;
    private final com.google.android.libraries.navigation.internal.ol.ai g;
    private final com.google.android.libraries.navigation.internal.ot.h h;
    private final boolean i;
    private final com.google.android.libraries.navigation.internal.cm.b j;
    public volatile double c = 0.0d;
    public final ArrayDeque e = new ArrayDeque(3);
    private int k = 0;

    public t(List list, com.google.android.libraries.navigation.internal.ol.ai aiVar, com.google.android.libraries.navigation.internal.ot.h hVar, bg bgVar, com.google.android.libraries.navigation.internal.cm.b bVar, Executor executor, com.google.android.libraries.navigation.internal.rw.p pVar, boolean z) {
        this.f = ev.w(new Comparator() { // from class: com.google.android.libraries.navigation.internal.bo.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                el elVar = (el) obj;
                el elVar2 = (el) obj2;
                bm bmVar = (elVar.c == 31 ? (ej) elVar.d : ej.a).c;
                if (bmVar == null) {
                    bmVar = bm.a;
                }
                double d = bmVar.c;
                bm bmVar2 = (elVar2.c == 31 ? (ej) elVar2.d : ej.a).c;
                if (bmVar2 == null) {
                    bmVar2 = bm.a;
                }
                return Double.compare(d, bmVar2.c);
            }
        }, list);
        this.g = aiVar;
        this.h = hVar;
        this.a = bgVar;
        this.j = bVar;
        this.b = new com.google.android.libraries.navigation.internal.hx.ag(executor);
        this.d = pVar;
        this.i = z;
    }

    public static void b(com.google.android.libraries.navigation.internal.cm.a aVar) {
        aVar.a.b();
        aVar.a.c();
    }

    public final void a() {
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            b((com.google.android.libraries.navigation.internal.cm.a) it2.next());
        }
        this.e.clear();
        this.k = 0;
    }

    public final void c() {
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.cm.a) it2.next()).a.d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        while (this.k < this.f.size()) {
            el elVar = (el) this.f.get(this.k);
            this.k++;
            if (this.e.size() < 3) {
                bm bmVar = (elVar.c == 31 ? (ej) elVar.d : ej.a).c;
                if (bmVar == null) {
                    bmVar = bm.a;
                }
                if (bmVar.c > this.c) {
                    ef efVarA = this.j.a(elVar.c == 31 ? (ej) elVar.d : ej.a, this.a);
                    if (this.i) {
                        com.google.android.libraries.navigation.internal.ot.h hVar = this.h;
                        com.google.android.libraries.navigation.internal.ot.f fVarB = com.google.android.libraries.navigation.internal.ot.g.b();
                        fVarB.b(jr.WORLD_ENCODING_LAT_LNG_E7);
                        this.e.add(new com.google.android.libraries.navigation.internal.cm.a(elVar, hVar.a(efVarA, fVarB.a())));
                    } else {
                        this.e.add(new com.google.android.libraries.navigation.internal.cm.a(elVar, new com.google.android.libraries.navigation.internal.oj.i(((dh) this.g).b(efVarA, jr.WORLD_ENCODING_LAT_LNG_E7), this.g)));
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean e() {
        return this.d == com.google.android.libraries.navigation.internal.rw.p.GUIDING;
    }
}
