package com.google.android.libraries.navigation.internal.fq;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.yz.hy;
import com.google.android.libraries.navigation.internal.yz.in;
import com.google.android.libraries.navigation.internal.zb.an;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f implements p {
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fq.f");
    public final Runtime a;
    public final com.google.android.libraries.navigation.internal.wz.c b;
    public final com.google.android.libraries.navigation.internal.kl.a c;
    public long d;
    public boolean e;
    public final d f;
    private final ConcurrentMap h;
    private final AtomicBoolean i;
    private final ComponentCallbacks2 j;

    public f(Context context, com.google.android.libraries.navigation.internal.wz.c cVar, com.google.android.libraries.navigation.internal.kl.a aVar) {
        Runtime runtime = Runtime.getRuntime();
        hy hyVar = new hy();
        hyVar.g(in.WEAK);
        this.h = hyVar.f();
        this.i = new AtomicBoolean(false);
        this.d = -1L;
        this.e = false;
        c cVar2 = new c(this);
        this.j = cVar2;
        this.f = new d(this);
        this.a = runtime;
        if (runtime.maxMemory() < 16777216) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(an.FULL)).F(494)).r("Device has lower than minimum required amount of RAM: %d", runtime.maxMemory());
        }
        this.b = cVar;
        this.c = aVar;
        context.registerComponentCallbacks(cVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return null;
    }

    public final void b(e eVar) {
        h(eVar.i);
    }

    public final void c(p pVar, com.google.android.libraries.navigation.internal.xn.a aVar) {
        this.h.put(pVar, aVar);
    }

    public final void d(p pVar, String str) {
        c(pVar, com.google.android.libraries.navigation.internal.xn.a.d(str));
    }

    public final void e(p pVar) {
        this.h.remove(pVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final void h(float f) {
        if (f != 1.0f && this.i.compareAndSet(false, true)) {
            for (p pVar : this.h.keySet()) {
                synchronized (pVar) {
                    pVar.h(f);
                    com.google.android.libraries.navigation.internal.xn.a aVar = (com.google.android.libraries.navigation.internal.xn.a) this.h.get(pVar);
                    if (aVar != null) {
                        com.google.android.libraries.navigation.internal.hx.k.a("CacheManager_".concat(aVar.a), pVar.a());
                    }
                }
            }
            this.i.set(false);
            this.d = SystemClock.elapsedRealtime();
        }
    }
}
