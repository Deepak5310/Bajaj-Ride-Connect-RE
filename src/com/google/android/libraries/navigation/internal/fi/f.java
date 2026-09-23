package com.google.android.libraries.navigation.internal.fi;

import android.location.Location;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.fj.a {
    private final com.google.android.libraries.navigation.internal.ia.e a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final q c;
    private final x d;
    private t e;
    private t f;
    private Location g;
    private final u h;

    public f(com.google.android.libraries.navigation.internal.ia.e eVar, u uVar, com.google.android.libraries.navigation.internal.mj.a aVar, q qVar, x xVar) {
        this.a = eVar;
        this.h = uVar;
        this.b = aVar;
        this.c = qVar;
        this.d = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fj.a
    public final synchronized void a() {
        t tVar = this.e;
        if (tVar != null) {
            tVar.a();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fj.a
    public final synchronized void b() {
        t tVar = this.e;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fj.a
    public final void c(com.google.android.libraries.navigation.internal.oe.r rVar) {
        t tVar = this.e;
        boolean z = false;
        if (tVar != null && tVar != this.f) {
            z = true;
        }
        if (rVar != null) {
            Location location = new Location("gps");
            location.setLatitude(rVar.a);
            location.setLongitude(rVar.b);
            location.setAccuracy(9.99f);
            location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(this.b.a()));
            this.g = location;
            this.f = this.h.a(this.c.a(location));
        } else {
            this.g = null;
            this.f = null;
        }
        if (z) {
            return;
        }
        e(this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.fj.a
    public final void d(bg bgVar, float f, double d) {
        x xVar = this.d;
        com.google.android.libraries.navigation.internal.ia.e eVar = (com.google.android.libraries.navigation.internal.ia.e) xVar.a.a();
        eVar.getClass();
        com.google.android.libraries.navigation.internal.mj.a aVar = (com.google.android.libraries.navigation.internal.mj.a) xVar.b.a();
        aVar.getClass();
        bgVar.getClass();
        e(this.h.a(new w(eVar, aVar, bgVar, f, d)));
    }

    final synchronized void e(t tVar) {
        t tVar2 = this.e;
        if (tVar2 != null) {
            tVar2.d();
        }
        if (tVar != null) {
            if (this.e == null) {
                this.a.f();
            }
            this.e = tVar;
            tVar.c(this);
        }
        b();
    }

    final synchronized void f(t tVar) {
        if (tVar == this.e) {
            this.e = null;
            this.a.d();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fj.a
    public final synchronized void g() {
        if (this.f != null) {
            ar.q(this.g);
            this.f = this.h.a(this.c.a(this.g));
        }
        e(this.f);
    }
}
