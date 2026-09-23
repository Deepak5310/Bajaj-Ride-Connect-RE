package com.google.android.libraries.navigation.internal.zb;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends ah {
    private static final w a = new d();
    private final AtomicLong b = new AtomicLong(-1);

    static ah b(com.google.android.libraries.navigation.internal.zd.n nVar, u uVar, long j) {
        if (((e) nVar.d(o.d)) == null) {
            return null;
        }
        f fVar = (f) a.b(uVar, nVar);
        com.google.android.libraries.navigation.internal.zj.b.a(j >= 0, "timestamp cannot be negative");
        long j2 = fVar.b.get();
        if (j2 >= 0) {
            throw null;
        }
        fVar.b.compareAndSet(j2, -j);
        return fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.ah
    public final void a() {
        this.b.set(Math.max(-this.b.get(), 0L));
    }
}
