package com.google.android.libraries.navigation.internal.r;

import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.ob.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ot.o;
import com.google.android.libraries.navigation.internal.ot.p;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f {
    public final Executor a;
    private final l b;
    private final Map c = new HashMap();

    public f(Executor executor, l lVar) {
        this.a = new bz(executor);
        this.b = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(f fVar, fy fyVar, ev evVar, ev evVar2, boolean z, boolean z2) {
        fVar.a(evVar2);
        if (((lv) evVar).c <= 0) {
            return;
        }
        e eVar = (e) evVar.get(0);
        l lVar = fVar.b;
        r rVar = eVar.a;
        fyVar.contains(rVar);
        m mVar = lVar.a;
        ar.q(null);
        m mVar2 = lVar.a;
        ar.q(null);
        lVar.a.j.a(rVar, lVar.b(rVar));
        x.z(rVar.i());
        p.c(o.PLACEMARK_SELECTION);
        m mVar3 = lVar.a;
        throw null;
    }

    public final void a(ev evVar) {
        int size = evVar.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.c.remove((com.google.android.libraries.navigation.internal.s.a) evVar.get(i));
            if (gVar != null) {
                gVar.c.b(gVar.a);
                gVar.a.c();
                com.google.android.libraries.navigation.internal.ol.g gVar2 = gVar.b;
                if (gVar2 != null) {
                    ((com.google.android.libraries.navigation.internal.po.x) gVar2).j.d(gVar2);
                    gVar.b.h();
                }
            }
        }
    }
}
