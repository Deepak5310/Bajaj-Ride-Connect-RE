package com.google.android.libraries.navigation.internal.oi;

import com.google.android.libraries.navigation.internal.oa.k;
import com.google.android.libraries.navigation.internal.ob.h;
import com.google.android.libraries.navigation.internal.om.x;
import com.google.android.libraries.navigation.internal.qq.f;
import com.google.android.libraries.navigation.internal.vu.l;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements c, a {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final Object b;
    private f c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private final boolean j;
    private final com.google.android.libraries.navigation.internal.afo.a k;

    public e(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, boolean z, boolean z2, boolean z3, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        Object obj = new Object();
        this.b = obj;
        this.h = false;
        this.i = false;
        this.a = aVar;
        this.d = aVar2;
        this.e = aVar3;
        this.f = false;
        this.g = z2;
        this.j = false;
        this.k = aVar4;
        synchronized (obj) {
            d dVar = d.LEGACY_AMBIENT;
            this.c = g().a(z);
        }
    }

    private final com.google.android.libraries.navigation.internal.qq.e g() {
        if (this.g) {
            return this.f ? com.google.android.libraries.navigation.internal.qq.e.j : com.google.android.libraries.navigation.internal.qq.e.c;
        }
        if (i(h.AIR_QUALITY_HEATMAP)) {
            return com.google.android.libraries.navigation.internal.qq.e.y;
        }
        if (i(h.BICYCLING)) {
            return this.f ? com.google.android.libraries.navigation.internal.qq.e.o : com.google.android.libraries.navigation.internal.qq.e.b;
        }
        if (this.f) {
            return com.google.android.libraries.navigation.internal.qq.e.p;
        }
        if (i(h.TRANSIT) || this.i) {
            return com.google.android.libraries.navigation.internal.qq.e.t;
        }
        if (i(h.THREE_DIMENSIONAL)) {
            return com.google.android.libraries.navigation.internal.qq.e.b;
        }
        return this.h ? com.google.android.libraries.navigation.internal.qq.e.v : com.google.android.libraries.navigation.internal.qq.e.b;
    }

    private final void h(h hVar, boolean z) {
        if (!k()) {
            ((k) this.d.a()).b().h(hVar, z);
            return;
        }
        ar.q(this.k);
        if (z) {
            ((l) this.k).a.b(hVar);
        } else {
            ((l) this.k).a.a(hVar);
        }
    }

    private final boolean i(h hVar) {
        if (!k()) {
            return ((k) this.d.a()).b().m(hVar);
        }
        ar.q(this.k);
        return ((l) this.k).a.c(hVar);
    }

    private final boolean j() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.a;
        return aVar != null && ((com.google.android.libraries.navigation.internal.oo.b) aVar.a()).s().b();
    }

    private final boolean k() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.a;
        return aVar != null && ((com.google.android.libraries.navigation.internal.oo.b) aVar.a()).s().c();
    }

    private final boolean l() {
        boolean z;
        synchronized (this.b) {
            z = false;
            if (!i(h.SATELLITE) && !i(h.TERRAIN) && ((com.google.android.libraries.navigation.internal.qq.b) this.c).e != com.google.android.libraries.navigation.internal.qq.e.a) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final void a() {
        if (!j()) {
            ((k) this.d.a()).A();
            return;
        }
        h(h.SATELLITE, false);
        h(h.TERRAIN, false);
        ((k) this.d.a()).b().o();
        synchronized (this.b) {
            this.c = g().a(((com.google.android.libraries.navigation.internal.qq.b) this.c).d);
            ((com.google.android.libraries.navigation.internal.oo.b) this.a.a()).r(((com.google.android.libraries.navigation.internal.qq.b) this.c).c.E);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final void b() {
        if (!j()) {
            ((k) this.d.a()).B();
            return;
        }
        h(h.SATELLITE, true);
        ((k) this.d.a()).b().o();
        synchronized (this.b) {
            this.c = ((this.g && ((x) this.e.a()).o()) ? com.google.android.libraries.navigation.internal.qq.e.e : com.google.android.libraries.navigation.internal.qq.e.q).a(((com.google.android.libraries.navigation.internal.qq.b) this.c).d);
            ((com.google.android.libraries.navigation.internal.oo.b) this.a.a()).r(((com.google.android.libraries.navigation.internal.qq.b) this.c).c.E);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final void c(boolean z) {
        if (!j()) {
            ((k) this.d.a()).D(z);
        } else if (this.i != z) {
            this.i = z;
            if (l()) {
                a();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final void d(boolean z) {
        if (!j()) {
            ((k) this.d.a()).E(z);
        } else if (this.h != z) {
            this.h = z;
            if (l()) {
                a();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final void e() {
        if (!j()) {
            ((k) this.d.a()).F();
            return;
        }
        h(h.TERRAIN, true);
        ((k) this.d.a()).b().o();
        synchronized (this.b) {
            this.c = com.google.android.libraries.navigation.internal.qq.e.s.a(((com.google.android.libraries.navigation.internal.qq.b) this.c).d);
            ((com.google.android.libraries.navigation.internal.oo.b) this.a.a()).r(((com.google.android.libraries.navigation.internal.qq.b) this.c).c.E);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.c
    public final boolean f() {
        return !j() ? ((k) this.d.a()).K() : this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.oi.a
    public final void v(boolean z) {
        if (!j()) {
            ((k) this.d.a()).v(z);
            return;
        }
        if (this.g != z) {
            this.g = z;
            if (l()) {
                a();
            } else if (i(h.SATELLITE)) {
                b();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oi.a
    public final void y(boolean z) {
        if (!j()) {
            ((k) this.d.a()).y(z);
        } else if (this.f != z) {
            this.f = z;
            if (l()) {
                a();
            }
        }
    }
}
