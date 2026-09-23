package com.google.android.libraries.navigation.internal.yq;

import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.aac.s;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.yr.am;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public final e a;
    public final ca d;
    public final AtomicLong b = new AtomicLong(b(Integer.MIN_VALUE, Integer.MIN_VALUE));
    public final AtomicReference c = new AtomicReference(null);
    private final AtomicReference e = new AtomicReference(null);
    private final Executor f = new bz(ac.INSTANCE);

    public h(s sVar, Executor executor) {
        ca caVar = new ca();
        this.d = caVar;
        e eVar = new e(sVar, executor);
        this.a = eVar;
        caVar.l(eVar, ac.INSTANCE);
    }

    public static int a(long j) {
        return (int) (j >>> 32);
    }

    public static long b(int i, int i2) {
        return (((long) i2) & 4294967295L) | (i << 32);
    }

    public final bj c() {
        long j;
        final int iA;
        if (this.d.isDone()) {
            return this.d;
        }
        do {
            j = this.b.get();
            iA = a(j);
        } while (!this.b.compareAndSet(j, b(iA, ((int) j) + 1)));
        final ca caVar = new ca();
        bj bjVar = (bj) this.e.getAndSet(caVar);
        caVar.aA(bjVar == null ? az.l(am.c(new s() { // from class: com.google.android.libraries.navigation.internal.yq.b
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                return this.a.d(iA);
            }
        }), ac.INSTANCE) : com.google.android.libraries.navigation.internal.aac.c.i(bjVar, Throwable.class, am.d(new t() { // from class: com.google.android.libraries.navigation.internal.yq.c
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                return this.a.d(iA);
            }
        }), this.f));
        final f fVar = new f(this, iA);
        caVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.yq.d
            @Override // java.lang.Runnable
            public final void run() {
                f fVar2 = fVar;
                ca caVar2 = caVar;
                try {
                    Object objN = az.n(caVar2);
                    h hVar = this.a;
                    hVar.d.d(objN);
                    fVar2.aA(hVar.d);
                } catch (Throwable unused) {
                    fVar2.aA(caVar2);
                }
            }
        }, ac.INSTANCE);
        return fVar;
    }

    public final bj d(int i) {
        g gVar;
        if (a(this.b.get()) > i) {
            return az.f();
        }
        g gVar2 = new g(i);
        do {
            gVar = (g) this.c.get();
            if (gVar != null && gVar.a > i) {
                return az.f();
            }
        } while (!a.a(this.c, gVar, gVar2));
        if (a(this.b.get()) > i) {
            gVar2.cancel(true);
            a.a(this.c, gVar2, null);
            return gVar2;
        }
        e eVar = this.a;
        s sVar = eVar.a;
        Executor executor = eVar.b;
        if (sVar == null || executor == null) {
            gVar2.aA(this.d);
        } else {
            gVar2.aA(az.l(am.c(sVar), executor));
        }
        return gVar2;
    }
}
