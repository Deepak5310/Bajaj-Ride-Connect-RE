package com.google.android.libraries.navigation.internal.ox;

import android.view.Choreographer;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.bg;
import com.google.android.libraries.navigation.internal.kk.l;
import com.google.android.libraries.navigation.internal.km.p;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pi.aa;
import com.google.android.libraries.navigation.internal.po.gk;
import com.google.android.libraries.navigation.internal.pu.k;
import com.google.android.libraries.navigation.internal.qq.ai;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Choreographer.FrameCallback, c {
    public volatile long a;
    private volatile long c;
    private volatile long d;
    private long f;
    private final int h;
    private final l i;
    private volatile long j;
    private final Choreographer l;
    private final t m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile t f511n;
    private final com.google.android.libraries.navigation.internal.pc.b o;
    private boolean q;
    private boolean r;
    private final com.google.android.libraries.navigation.internal.ni.a t;
    private final ai z;
    private volatile boolean e = false;
    private long g = 0;
    public boolean b = false;
    private boolean k = true;
    private final float[] p = new float[8];
    private volatile boolean s = true;
    private int y = 1;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final x x = new x();

    public a(com.google.android.libraries.navigation.internal.ni.a aVar, ai aiVar, t tVar, com.google.android.libraries.navigation.internal.pc.b bVar, int i, int i2, com.google.android.libraries.navigation.internal.kl.b bVar2, Choreographer choreographer) {
        this.z = aiVar;
        this.l = choreographer;
        this.m = tVar;
        this.o = bVar;
        this.f511n = new t(tVar);
        this.t = aVar;
        g(30L);
        this.h = i2 == 0 ? 16 : 1000 / i2;
        this.i = (l) bVar2.a(p.c);
        this.d = TimeUnit.SECONDS.toMillis(1L) / ((long) i);
    }

    private final long j() {
        long j = this.f;
        m();
        return (j + this.c) - 3;
    }

    private final synchronized void k(boolean z) {
        ai aiVar = this.z;
        aiVar.a.j.c(z);
        aiVar.a.h.a(new aa(z));
        if (this.k != z) {
            if (!z) {
                this.k = false;
                this.g = 0L;
                f();
            } else {
                this.k = true;
                if (!this.r) {
                    this.l.removeFrameCallback(this);
                    this.q = false;
                }
            }
        }
    }

    private final void l() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.l.postFrameCallback(this);
        this.j = this.t.a();
    }

    private final boolean m() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final synchronized void a() {
        this.r = true;
        l();
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final synchronized void b() {
        this.y = 1;
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final synchronized void c() {
        this.y = 3;
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final void d() {
        k(false);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        boolean zD;
        com.google.android.libraries.navigation.internal.rg.b bVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ActiveFrameRateRegulator.doFrame()");
        try {
            long millis = TimeUnit.NANOSECONDS.toMillis(j);
            boolean z = j() - millis > 0;
            long j2 = this.g;
            if (j2 != 0 && this.b) {
                this.i.a(Math.max(0, ((int) (millis - j2)) - this.h));
            }
            this.g = millis;
            com.google.android.libraries.navigation.internal.pc.b bVar2 = this.o;
            k kVar = ((gk) bVar2).a.y;
            if (kVar == null || !kVar.a() || (bVar = ((gk) bVar2).a.x) == null) {
                zD = ((gk) bVar2).a.s.d();
            } else {
                bVar.a();
                zD = false;
            }
            this.b = zD;
            m();
            if (!z) {
                bg bgVar = this.z.a.e;
                ar.q(bgVar);
                z = !bgVar.h();
            }
            if (this.s && z) {
                this.w++;
                this.l.postFrameCallback(this);
            } else {
                this.v++;
                synchronized (this) {
                    this.q = false;
                    this.r = false;
                    int i = this.y;
                    if (i == 3 || (i == 1 && this.j < j())) {
                        this.u = true;
                    } else if (this.y == 1) {
                        this.u = false;
                    }
                    this.y = 2;
                }
                this.f = millis;
                this.f511n = new t(this.m);
                bg bgVar2 = this.z.a.e;
                ar.q(bgVar2);
                bgVar2.f();
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final void e() {
        k(true);
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final synchronized void f() {
        if (this.k) {
            return;
        }
        l();
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final void g(long j) {
        this.a = j;
        this.c = TimeUnit.SECONDS.toMillis(1L) / j;
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final synchronized boolean h() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.ox.c
    public final void i() {
    }
}
