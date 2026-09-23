package com.google.android.libraries.navigation.internal.da;

import android.location.LocationListener;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.cw.k;
import com.google.android.libraries.navigation.internal.dh.ai;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.km.l;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements k {
    private static final long h = TimeUnit.SECONDS.toMillis(1);
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    private final Looper i;
    private final Executor j;
    private final com.google.android.libraries.navigation.internal.np.a m;
    private final c k = new c(this);
    private final b l = new b(this);
    public final Object c = new Object();
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    final LocationListener g = new a(this);

    public d(an anVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, Looper looper, Executor executor) {
        this.m = (com.google.android.libraries.navigation.internal.np.a) anVar.f();
        this.a = aVar;
        this.b = eVar;
        this.i = looper;
        this.j = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.k
    public final void a() {
        fd fdVarK = fd.k(ap.LOCATION_SENSORS, this.j);
        fz fzVar = new fz();
        ap apVar = ap.LOCATION_SENSORS;
        Executor executorB = g.b(ap.LOCATION_SENSORS, fdVarK);
        c cVar = this.k;
        fzVar.b(com.google.android.libraries.navigation.internal.pr.a.class, new g(com.google.android.libraries.navigation.internal.pr.a.class, cVar, apVar, executorB));
        this.b.c(cVar, fzVar.a());
        fz fzVar2 = new fz();
        ap apVar2 = ap.LOCATION_SENSORS;
        Executor executorB2 = f.b(ap.LOCATION_SENSORS, fdVarK);
        b bVar = this.l;
        fzVar2.b(ai.class, new f(ai.class, bVar, apVar2, executorB2));
        this.b.c(bVar, fzVar2.a());
    }

    @Override // com.google.android.libraries.navigation.internal.cw.k
    public final void b() {
        this.b.e(this.k);
        this.b.e(this.l);
        synchronized (this.c) {
            this.e = false;
            this.d = false;
            c();
        }
    }

    public final void c() {
        if (this.e && this.d) {
            if (this.f) {
                return;
            }
            try {
                int i = l.a;
                int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
                this.m.l("network", h, this.g, this.i);
                this.f = true;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (this.f) {
            try {
                int i3 = l.a;
                int i4 = com.google.android.libraries.navigation.internal.fp.a.a;
                this.m.f(this.g);
                this.f = false;
            } catch (Exception unused2) {
            }
        }
    }
}
