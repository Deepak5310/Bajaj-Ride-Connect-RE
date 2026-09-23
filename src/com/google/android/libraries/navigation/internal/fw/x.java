package com.google.android.libraries.navigation.internal.fw;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.km.ao;
import com.google.android.libraries.navigation.internal.km.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements v {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final com.google.android.libraries.navigation.internal.kl.a b;
    public boolean c = false;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    private final u i;

    public x(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.a aVar2) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("createNetworkStatsLogger");
        try {
            this.i = new u();
            this.a = aVar;
            this.b = aVar2;
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

    @Override // com.google.android.libraries.navigation.internal.xc.a
    public final synchronized long a() {
        return this.i.a;
    }

    @Override // com.google.android.libraries.navigation.internal.xc.a
    public final synchronized long b() {
        return this.i.b;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.f
    public final synchronized long c() {
        return this.i.c;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.f
    public final synchronized long d() {
        return this.i.e;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.f
    public final synchronized long e() {
        return this.i.d;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.v
    public final void f(int i) {
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.g)).a();
        long j = i;
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.f)).b(j);
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.c)).a();
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.b)).b(j);
    }

    @Override // com.google.android.libraries.navigation.internal.fw.v
    public final void g(u uVar, long j, long j2, long j3, Class cls) {
        synchronized (this) {
            this.i.a(uVar);
        }
        long j4 = j2 - j;
        ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.h)).a(TimeUnit.NANOSECONDS.toMillis(j4));
        ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.i)).a(uVar.b);
        ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.j)).a(uVar.a);
        if (j3 > j) {
            ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.m)).a((uVar.a * TimeUnit.SECONDS.toNanos(1L)) / (j3 - j));
        }
        if (this.c) {
            this.e += uVar.b;
            this.f += uVar.a;
            this.h++;
        }
        if (cls != null) {
            com.google.android.libraries.navigation.internal.km.y yVar = ar.b(cls).b;
            if (yVar != null) {
                ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(yVar)).a(TimeUnit.NANOSECONDS.toMillis(j4));
            }
            com.google.android.libraries.navigation.internal.km.y yVar2 = ar.b(cls).e;
            if (yVar2 != null) {
                ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(yVar2)).a(uVar.b);
            }
            com.google.android.libraries.navigation.internal.km.y yVar3 = ar.b(cls).f;
            if (yVar3 != null) {
                ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(yVar3)).a(uVar.a);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fw.v
    public final void h(long j) {
        ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.l)).a(j);
    }

    @Override // com.google.android.libraries.navigation.internal.fw.v
    public final void i(int i, boolean z) {
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.c)).a();
        long j = i;
        ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.b)).b(j);
        ((com.google.android.libraries.navigation.internal.kk.l) this.b.a(ao.k)).a(j);
        if (z) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.e)).a();
            ((com.google.android.libraries.navigation.internal.kk.j) this.b.a(ao.d)).b(j);
        }
        if (this.c) {
            this.g++;
        }
    }
}
