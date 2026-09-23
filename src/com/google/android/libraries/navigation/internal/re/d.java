package com.google.android.libraries.navigation.internal.re;

import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.ol.m;
import com.google.android.libraries.navigation.internal.ol.n;
import com.google.android.libraries.navigation.internal.op.j;
import com.google.android.libraries.navigation.internal.rl.l;
import com.google.android.libraries.navigation.internal.rl.p;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements com.google.android.libraries.navigation.internal.op.f {
    public final f a;
    public final com.google.android.libraries.navigation.internal.op.g b;
    final n c;
    private final c d = new c(this);
    private volatile com.google.android.libraries.navigation.internal.adg.b e = null;
    private boolean f = false;
    private boolean g = false;
    private e h;
    private final l i;
    private final p j;

    public d(f fVar, com.google.android.libraries.navigation.internal.op.g gVar, n nVar, p pVar, l lVar) {
        this.a = fVar;
        this.b = gVar;
        this.c = nVar;
        this.j = pVar;
        this.i = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final com.google.android.libraries.navigation.internal.op.g a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final synchronized void b() {
        if (!this.g) {
            if (this.c == null) {
                this.a.b.x();
            } else if (this.f) {
                this.f = false;
                this.a.k;
                this.c.i();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final synchronized void c() {
        if (!this.g) {
            this.g = true;
            n nVar = this.c;
            if (nVar != null) {
                nVar.h();
            }
            boolean z = this.a.c;
            f fVar = this.a;
            fVar.a.remove(this.b);
            this.a.f.set(true);
            p pVar = this.j;
            if (pVar != null) {
                pVar.close();
            }
            l lVar = this.i;
            if (lVar != null) {
                lVar.close();
            }
        }
    }

    public final synchronized j d() {
        n nVar = this.c;
        if (nVar != null) {
            return nVar.b();
        }
        j jVar = this.d.b;
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final synchronized void e(r rVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        if (this.g) {
            return;
        }
        boolean z = this.a.c;
        m mVar = new m(x.z(rVar), bVar);
        this.e = bVar;
        this.a.k;
        n nVar = this.c;
        ar.q(nVar);
        nVar.e(mVar, false);
        synchronized (this) {
            if (this.h != null) {
                this.h = null;
                this.c.d(null);
            }
            if (!this.f) {
                this.f = true;
                this.c.m();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.op.f
    public final synchronized void f(r rVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        if (!this.g) {
            if (this.c == null) {
                e(rVar, bVar);
                return;
            }
            e eVar = this.h;
            if (eVar == null) {
                e eVar2 = new e(rVar, bVar);
                this.c.d(eVar2);
                this.h = eVar2;
            } else {
                eVar.a.L(rVar.a, rVar.b);
                eVar.b = bVar;
            }
            if (!this.f) {
                this.f = true;
                this.c.m();
            }
        }
    }
}
