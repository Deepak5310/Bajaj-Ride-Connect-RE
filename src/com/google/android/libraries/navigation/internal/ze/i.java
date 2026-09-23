package com.google.android.libraries.navigation.internal.ze;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends a {
    static final boolean a;
    static final boolean b;
    static final boolean c;
    public static final AtomicReference d;
    private static final AtomicLong f;
    private static final ConcurrentLinkedQueue g;
    public volatile com.google.android.libraries.navigation.internal.zd.j e;

    static {
        a = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        b = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        c = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
        d = new AtomicReference();
        f = new AtomicLong();
        g = new ConcurrentLinkedQueue();
    }

    public i(String str) {
        super(str);
        if (a || b) {
            this.e = new b().a(a());
        } else {
            if (!c) {
                this.e = null;
                return;
            }
            k kVar = m.c;
            String str2 = kVar.a;
            this.e = new k(kVar.b, Level.OFF, kVar.c, kVar.d).a(a());
        }
    }

    public static void e() {
        while (true) {
            h hVar = (h) g.poll();
            if (hVar == null) {
                return;
            }
            f.getAndDecrement();
            com.google.android.libraries.navigation.internal.zd.f fVar = hVar.b;
            com.google.android.libraries.navigation.internal.zd.j jVar = hVar.a;
            if (fVar.C() || jVar.d(fVar.m())) {
                jVar.c(fVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ze.a, com.google.android.libraries.navigation.internal.zd.j
    public final void b(RuntimeException runtimeException, com.google.android.libraries.navigation.internal.zd.f fVar) {
        if (this.e != null) {
            this.e.b(runtimeException, fVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final void c(com.google.android.libraries.navigation.internal.zd.f fVar) {
        if (this.e != null) {
            this.e.c(fVar);
            return;
        }
        if (f.incrementAndGet() > 20) {
            g.poll();
        }
        g.offer(new h(this, fVar));
        if (this.e != null) {
            e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final boolean d(Level level) {
        return this.e == null || this.e.d(level);
    }
}
