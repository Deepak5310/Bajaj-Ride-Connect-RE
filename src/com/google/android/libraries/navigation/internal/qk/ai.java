package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.px.cg;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends ak {
    private final i a;
    private h b;
    private boolean c = false;

    public ai(i iVar, h hVar) {
        this.a = iVar;
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final com.google.android.libraries.navigation.internal.op.g a() {
        return ((com.google.android.libraries.navigation.internal.po.aa) ((b) this.b).a).d;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final r b() {
        return ((b) this.b).b;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final void c() {
        boolean z;
        synchronized (this) {
            d();
            z = this.c;
            this.c = true;
        }
        if (z) {
            return;
        }
        ((b) this.b).a.h();
    }

    public final synchronized void d() {
        if (this.c) {
            return;
        }
        i iVar = this.a;
        com.google.android.libraries.navigation.internal.ol.n nVar = ((b) this.b).a;
        synchronized (((n) iVar).c) {
            ((n) iVar).d.remove(nVar);
            ((n) iVar).b.i(nVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final synchronized void e(r rVar) {
        d();
        a aVar = new a(this.b);
        aVar.c(rVar);
        this.b = aVar.g();
        f();
    }

    @Override // com.google.android.libraries.navigation.internal.qk.ak
    public final synchronized void f() {
        com.google.android.libraries.navigation.internal.oe.x xVar;
        if (!this.c) {
            i iVar = this.a;
            h hVar = this.b;
            com.google.android.libraries.navigation.internal.ol.n nVar = ((b) hVar).a;
            cg cgVar = ((com.google.android.libraries.navigation.internal.px.b) ((com.google.android.libraries.navigation.internal.po.aa) nVar).g).f;
            if (cgVar.h() || cgVar.g()) {
                com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((com.google.android.libraries.navigation.internal.px.m) ((com.google.android.libraries.navigation.internal.px.b) ((com.google.android.libraries.navigation.internal.po.aa) nVar).g).f).a;
                ar.q(cVar);
                xVar = cVar.a;
            } else {
                xVar = null;
            }
            com.google.android.libraries.navigation.internal.oe.x xVar2 = xVar;
            com.google.android.libraries.navigation.internal.adg.b bVar = ((com.google.android.libraries.navigation.internal.po.aa) nVar).e;
            if (bVar != null) {
                synchronized (((n) iVar).c) {
                    if (!((n) iVar).d.containsKey(nVar)) {
                        ((n) iVar).d.put(nVar, new m(((b) hVar).b, ((b) hVar).c, ((b) hVar).d, xVar2, bVar, ((b) hVar).e));
                    }
                }
                ((n) iVar).b.h();
            }
        }
    }
}
