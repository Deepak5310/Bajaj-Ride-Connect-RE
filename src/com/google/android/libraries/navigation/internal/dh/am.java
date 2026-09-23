package com.google.android.libraries.navigation.internal.dh;

import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public final ap a;
    public final com.google.android.libraries.navigation.internal.ia.e b;
    public com.google.android.libraries.navigation.internal.kl.a c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final bn g;
    public boolean e = false;
    public Future f = com.google.android.libraries.navigation.internal.aac.az.f();
    long h = 0;

    public am(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.np.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2, bn bnVar) {
        this.b = eVar;
        this.d = aVar2;
        this.g = bnVar;
        this.a = new ap(new al(this), aVar, aVar2);
    }

    public final void a() {
        boolean zD = this.a.d();
        this.a.b();
        boolean zD2 = this.a.d();
        if (zD || !zD2) {
            return;
        }
        this.b.a(new com.google.android.libraries.navigation.internal.ds.c(true));
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
        this.f.cancel(false);
        this.f = this.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dh.ak
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
                final am amVar = this.a;
                if (amVar.e) {
                    amVar.a.c();
                    amVar.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.dh.aj
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.libraries.navigation.internal.hx.ap.LOCATION_SENSORS.f();
                            am amVar2 = amVar;
                            if (amVar2.e) {
                                amVar2.a.e(amVar2.c);
                                amVar2.h = amVar2.d.b();
                                amVar2.b.a(new ar("satellite"));
                                amVar2.b();
                            }
                        }
                    }, 1L, TimeUnit.SECONDS);
                }
            }
        }, 57L, TimeUnit.SECONDS);
    }
}
