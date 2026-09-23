package com.google.android.libraries.navigation.internal.dh;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ace.jx;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements ac {
    private static final com.google.android.libraries.navigation.internal.zb.j u = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dh.f");
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public com.google.android.libraries.navigation.internal.kl.a c;
    public final bn e;
    public final Executor f;
    long h;
    long i;
    d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final jx f396n;
    public com.google.android.libraries.navigation.internal.dg.a r;
    public final com.google.android.libraries.navigation.internal.np.a t;
    private final Context v;
    private Looper w = null;
    public boolean d = false;
    private ab x = ab.GPS_AND_NETWORK;
    private Future y = com.google.android.libraries.navigation.internal.aac.az.f();
    long g = 0;
    final e j = new e(this, "gps", 1, true);
    final e k = new e(this, "network", 3, false);
    final e l = new e(this, "passive", 5, false);
    public int o = 0;
    public boolean p = true;
    public com.google.android.libraries.navigation.internal.yx.an q = com.google.android.libraries.navigation.internal.yx.a.a;
    public int s = 3;

    public f(Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.np.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2, bn bnVar, bn bnVar2) {
        this.v = context;
        this.a = eVar;
        this.t = aVar;
        this.b = aVar2;
        this.e = bnVar;
        this.f = com.google.android.libraries.navigation.internal.hx.l.a(bnVar2);
        fVar.y(com.google.android.libraries.navigation.internal.iv.ab.cm, false);
        this.f396n = jx.a;
    }

    @Override // com.google.android.libraries.navigation.internal.dh.ac
    public final void a() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        b();
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        if (this.w == null) {
            this.w = new Handler().getLooper();
        }
        int iOrdinal = this.x.ordinal();
        if (iOrdinal == 0) {
            this.l.b(this.w);
            this.j.a();
            this.k.a();
        } else if (iOrdinal == 1) {
            this.j.b(this.w);
            this.k.a();
            this.l.a();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.j.b(this.w);
            this.k.b(this.w);
            this.l.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    @Override // com.google.android.libraries.navigation.internal.dh.ac
    public final void c(ab abVar, com.google.android.libraries.navigation.internal.kl.a aVar) {
        int i;
        this.h = this.b.f().toEpochMilli();
        this.i = this.b.a();
        this.o = 0;
        this.p = true;
        if (Build.VERSION.SDK_INT < 34) {
            this.r = new com.google.android.libraries.navigation.internal.dg.a();
        } else {
            int iA = this.t.a();
            if (iA != 1) {
                i = 2;
                if (iA != 2) {
                    i = 3;
                }
            } else {
                i = 1;
            }
            this.s = i;
            if (i == 3) {
                this.r = new com.google.android.libraries.navigation.internal.dg.a();
            }
        }
        this.c = aVar;
        int i2 = com.google.android.libraries.navigation.internal.km.l.a;
        int i3 = com.google.android.libraries.navigation.internal.fp.a.a;
        if (this.d) {
            return;
        }
        this.x = abVar;
        b();
        d();
        this.d = true;
    }

    public final void d() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        this.y.cancel(false);
        this.y = this.e.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dh.c
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
                final f fVar = this.a;
                if (fVar.d) {
                    fVar.j.a();
                    fVar.k.a();
                    fVar.l.a();
                    fVar.e.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dh.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
                            f fVar2 = fVar;
                            if (fVar2.d) {
                                fVar2.b();
                                fVar2.g = fVar2.b.b();
                                fVar2.a.a(new ar(FirebaseAnalytics.Param.LOCATION));
                                fVar2.d();
                            }
                        }
                    }, 1L, TimeUnit.SECONDS);
                }
            }
        }, 57L, TimeUnit.SECONDS);
    }

    @Override // com.google.android.libraries.navigation.internal.dh.ac
    public final void e() {
        int i = com.google.android.libraries.navigation.internal.km.l.a;
        int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        if (this.d) {
            this.y.cancel(false);
            this.l.a();
            this.j.a();
            this.k.a();
            f();
            this.d = false;
        }
    }

    final void f() {
        d dVar;
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        if (Build.VERSION.SDK_INT < 31 || (dVar = this.m) == null) {
            return;
        }
        try {
            this.t.g(dVar);
        } catch (SecurityException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 359)).p("SecurityException from unregisterGnssMeasurementsCallback");
        }
        this.m = null;
        this.q = com.google.android.libraries.navigation.internal.yx.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.dh.ac
    public final void g(ab abVar) {
        this.x = abVar;
        b();
    }

    @Override // com.google.android.libraries.navigation.internal.dh.ac
    public final boolean h() {
        return true;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarE = com.google.android.libraries.navigation.internal.yx.al.b(this).e("isStarted", this.d);
        akVarE.g("preferredProviders", this.x);
        akVarE.g("gps", this.j.toString());
        akVarE.g("network", this.k.toString());
        akVarE.g("passive", this.l.toString());
        return akVarE.toString();
    }
}
