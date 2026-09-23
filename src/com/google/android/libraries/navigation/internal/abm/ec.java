package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.abh.hn;
import com.google.android.libraries.navigation.internal.abh.ho;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ec implements hn {
    public final com.google.android.libraries.navigation.internal.ol.z a;
    public final ho b;
    public final com.google.android.libraries.navigation.internal.abf.z c;
    public final f d;
    public final Executor e;
    public com.google.android.libraries.navigation.internal.po.di f;
    private final int g;

    public ec(com.google.android.libraries.navigation.internal.ol.z zVar, ho hoVar, int i) {
        com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
        f fVar = f.a;
        ExecutorService executorServiceC = com.google.android.libraries.navigation.internal.abf.ah.c("tileoverlay", 3);
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.a = zVar;
        this.b = hoVar;
        com.google.android.libraries.navigation.internal.abf.s.k(hoVar.c, "getTileProvider()");
        this.g = i;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "uiThreadChecker");
        this.c = zVar2;
        this.d = fVar;
        com.google.android.libraries.navigation.internal.abf.s.k(executorServiceC, "tileOverlayExecutor");
        this.e = executorServiceC;
    }

    public final void a() {
        if (this.b.q()) {
            this.f.b(true);
            this.f.a(this.b.n());
        } else {
            this.f.b(false);
            this.f.a(0.0f);
        }
    }

    public final void b() {
        ho hoVar = this.b;
        com.google.android.libraries.navigation.internal.po.di diVar = this.f;
        diVar.a.F(new com.google.android.libraries.navigation.internal.ol.w(this.d.b(hoVar.o()), this.g));
        diVar.a.G();
    }
}
