package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final Executor b;
    public final com.google.android.libraries.navigation.internal.fy.f e;
    public final com.google.android.libraries.navigation.internal.hm.h f;
    public final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    public final ca d = new ca();

    public g(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.hm.h hVar, Executor executor, com.google.android.libraries.navigation.internal.fy.f fVar) {
        this.a = eVar;
        this.f = hVar;
        this.b = executor;
        this.e = fVar;
    }

    public final synchronized URL a() {
        return this.e.a();
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.fy.f fVar = this.e;
        URL urlA = fVar.c.a();
        synchronized (fVar) {
            if (fVar.b == null || !urlA.equals(fVar.a)) {
                fVar.a = urlA;
                synchronized (fVar) {
                    com.google.android.libraries.navigation.internal.fy.c cVar = fVar.d;
                    cVar.getClass();
                    fVar.b = cVar.a(fVar.a);
                    ar.q(fVar.b);
                }
            }
        }
        this.d.d(null);
        if (this.g.getAndSet(true)) {
            return;
        }
        this.a.e(this);
    }
}
