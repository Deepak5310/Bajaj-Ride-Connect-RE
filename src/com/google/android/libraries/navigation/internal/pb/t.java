package com.google.android.libraries.navigation.internal.pb;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.google.android.libraries.geo.mapcore.renderer.u {
    public int a;
    public final m b;
    public a c;
    public com.google.android.libraries.navigation.internal.pd.j d;
    private final o i;

    public t(t tVar) {
        super(tVar);
        this.i = new o();
        this.a = tVar.a;
        this.d = tVar.d;
        this.b = tVar.b;
    }

    public final o a() {
        z();
        return this.i;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00be  */
    @Override // com.google.android.libraries.geo.mapcore.renderer.u
    public final void b(int i, int i2) {
        Runnable runnable;
        n nVar;
        com.google.android.libraries.navigation.internal.pd.d dVar;
        boolean z;
        com.google.android.libraries.geo.mapcore.renderer.v vVar = (com.google.android.libraries.geo.mapcore.renderer.v) this.e.get();
        if (vVar.b != i || vVar.c != i2) {
            C(i, i2);
        }
        z();
        a aVar = this.c;
        if (aVar != null) {
            d(aVar.b());
            this.d = aVar.a();
        }
        o oVar = this.i;
        n nVar2 = oVar.b;
        oVar.b = oVar.c;
        oVar.c = nVar2;
        n nVar3 = oVar.c;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        nVar3.a = w();
        nVar3.b = s();
        nVar3.c = r();
        nVar3.d = x();
        nVar3.e = this.a;
        nVar3.f = jElapsedRealtime;
        n nVar4 = oVar.b;
        com.google.android.libraries.navigation.internal.pd.d dVar2 = nVar4.a;
        if (dVar2 == null || (dVar = (nVar = oVar.c).a) == null) {
            oVar.i = false;
        } else {
            if (nVar4.b != nVar.b || nVar4.c != nVar.c || dVar2.l >= 0.001f || dVar.l >= 0.001f || Math.abs(dVar2.k - dVar.k) >= 0.001f || Math.abs(dVar2.m - dVar.m) >= 0.001f) {
                z = false;
            } else {
                com.google.android.libraries.navigation.internal.pd.e eVar = dVar2.f515n;
                com.google.android.libraries.navigation.internal.pd.e eVar2 = dVar.f515n;
                if (Math.abs(eVar.b - eVar2.b) >= 1.0E-4f || Math.abs(eVar.c - eVar2.c) >= 1.0E-4f) {
                    z = false;
                } else {
                    z = true;
                }
            }
            oVar.i = z;
            boolean zM = j.m(this, dVar2.j, oVar.a);
            float[] fArr = oVar.a;
            float f = fArr[0];
            float f2 = fArr[1];
            boolean zM2 = j.m(this, oVar.c.a.j, fArr);
            float[] fArr2 = oVar.a;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            oVar.d = f3 - f;
            oVar.e = f4 - f2;
            n nVar5 = oVar.c;
            float f5 = nVar5.a.k;
            n nVar6 = oVar.b;
            float f6 = f5 - nVar6.a.k;
            long j = nVar5.f - nVar6.f;
            if (!zM || !zM2 || nVar5.e == 0 || nVar6.e == 0 || j <= 0) {
                oVar.h = 0.0f;
                oVar.g = 0.0f;
                oVar.f = 0.0f;
            } else {
                float millis = TimeUnit.SECONDS.toMillis(1L) / j;
                float f7 = oVar.d * millis;
                float f8 = oVar.e * millis;
                oVar.f = o.a(f7, oVar.f);
                oVar.g = o.a(f8, oVar.g);
                oVar.h = o.a(f6 * millis, oVar.h);
            }
        }
        com.google.android.libraries.geo.mapcore.renderer.v vVar2 = (com.google.android.libraries.geo.mapcore.renderer.v) this.e.get();
        this.e.set(y(vVar2.a, i, i2, vVar2.d, vVar2.e, vVar2.f, vVar2.g));
        if ((this.a & 4) == 0 || (runnable = this.f) == null) {
            return;
        }
        runnable.run();
    }

    public final void c(float[] fArr) {
        z();
        o oVar = this.i;
        fArr[0] = oVar.f;
        fArr[1] = oVar.g;
        fArr[2] = oVar.h;
    }

    public final void d(int i) {
        if (this.a == i) {
            return;
        }
        this.a = i;
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void e() {
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
        } else {
            d(6);
        }
    }

    public final boolean f() {
        return (this.a & 2) != 0;
    }

    public t(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, float f) {
        this(dVar, i, i2, f, null, new m(null, 65.0f));
    }

    public t(com.google.android.libraries.navigation.internal.pd.d dVar, int i, int i2, float f, Runnable runnable, m mVar) {
        super(dVar, i, i2, f, runnable);
        this.i = new o();
        this.b = mVar;
    }
}
