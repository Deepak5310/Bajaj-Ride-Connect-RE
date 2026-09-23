package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl implements com.google.android.libraries.navigation.internal.pb.a {
    public final com.google.android.libraries.navigation.internal.oa.k a;
    public final z b;
    public final be c;
    public final be d;
    public final be e;
    public final Executor f;
    public final com.google.android.libraries.navigation.internal.abf.z g;
    long h;
    long i;
    public u j;
    private final ad k;

    public bl(com.google.android.libraries.navigation.internal.oa.k kVar, z zVar, be beVar) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
        ad adVar = new ad();
        com.google.android.libraries.navigation.internal.abf.s.k(kVar, "mapContainer");
        this.a = kVar;
        this.b = zVar;
        this.e = beVar;
        this.f = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "uiThreadChecker");
        this.g = zVar2;
        this.k = adVar;
        this.c = null;
        this.d = null;
        this.j = null;
    }

    private final void g(final ae aeVar) {
        this.g.b();
        if (aeVar.a) {
            final long j = this.i;
            this.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.bk
                @Override // java.lang.Runnable
                public final void run() {
                    bl blVar = this.a;
                    blVar.g.a();
                    if (!com.google.android.libraries.navigation.internal.afu.d.j()) {
                        long j2 = j;
                        blVar.g.a();
                        if (blVar.h != j2) {
                            return;
                        } else {
                            blVar.c.q(blVar.d);
                        }
                    }
                    u uVar = blVar.j;
                    if (uVar != null) {
                        ae aeVar2 = aeVar;
                        CopyOnWriteArrayList copyOnWriteArrayList = uVar.h;
                        CameraPosition cameraPositionC = uVar.c();
                        Iterator it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            u.A((com.google.android.libraries.navigation.internal.ly.u) it2.next(), cameraPositionC);
                        }
                        if (aeVar2.g) {
                            u.A(uVar.g, cameraPositionC);
                        }
                    }
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pb.a
    public final com.google.android.libraries.navigation.internal.pd.j a() {
        return this.b.a();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.a
    public final int b() {
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            synchronized (this.e) {
                this.k.a();
                this.b.d(this.k, this.e);
                be beVar = this.e;
                ad adVar = this.k;
                beVar.u(adVar.d, adVar.e);
                g(new ae(this.k));
                this.b.c();
            }
            return this.b.e() ? 0 : 6;
        }
        synchronized (this) {
            if (this.i == 0) {
                this.d.u(this.c.f(), this.c.i());
                this.d.r(this.c.p());
            }
            this.i = this.h;
            this.k.a();
            com.google.android.libraries.navigation.internal.afu.d.u();
            this.b.d(this.k, this.d);
            be beVar2 = this.d;
            ad adVar2 = this.k;
            beVar2.u(adVar2.d, adVar2.e);
            g(new ae(this.k));
            this.b.c();
        }
        return this.b.e() ? 0 : 6;
    }

    public final be c() {
        this.g.a();
        return this.c;
    }

    public final void d(bf bfVar) {
        synchronized (this.e) {
            aw awVar = new aw(this.e);
            bfVar.a(awVar);
            awVar.b = true;
        }
    }

    public final void e(final v vVar) {
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.bh
                @Override // java.lang.Runnable
                public final void run() {
                    bl blVar = this.a;
                    blVar.b.b(vVar, blVar.e);
                }
            });
        } else {
            f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abn.bi
                @Override // java.lang.Runnable
                public final void run() {
                    bl blVar = this.a;
                    blVar.b.b(vVar, blVar.c);
                }
            });
        }
    }

    public final void f(Runnable runnable) {
        this.g.a();
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            runnable.run();
        } else {
            synchronized (this) {
                runnable.run();
                this.h++;
            }
        }
        this.a.c().e();
    }

    public bl(com.google.android.libraries.navigation.internal.oa.k kVar, z zVar, be beVar, be beVar2) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
        ad adVar = new ad();
        com.google.android.libraries.navigation.internal.abf.s.k(kVar, "mapContainer");
        this.a = kVar;
        this.b = zVar;
        this.c = beVar;
        this.d = beVar2;
        this.f = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "uiThreadChecker");
        this.g = zVar2;
        this.k = adVar;
        this.h = 0L;
        this.i = 0L;
        this.j = null;
        this.e = null;
    }
}
