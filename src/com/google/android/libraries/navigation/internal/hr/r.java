package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.aac.ac;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements com.google.android.libraries.navigation.internal.hs.d {
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hr.r");
    public final com.google.android.libraries.navigation.internal.hu.a a;
    public final o b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final com.google.android.libraries.navigation.internal.iv.f e;
    private final AtomicInteger g = new AtomicInteger(0);
    private final q h;

    public r(com.google.android.libraries.navigation.internal.hu.a aVar, o oVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.iv.f fVar) {
        q qVar = new q(this);
        this.h = qVar;
        this.a = aVar;
        this.b = oVar;
        this.c = aVar2;
        this.d = aVar3;
        this.e = fVar;
        aVar.c().e(qVar, ac.INSTANCE);
    }

    @Override // com.google.android.libraries.navigation.internal.hs.d
    public final void a() {
        this.g.incrementAndGet();
        o oVar = this.b;
        synchronized (oVar.i) {
            if (oVar.s != 3) {
                oVar.s = 2;
            } else {
                oVar.d(0L, com.google.android.libraries.navigation.internal.ir.a.FORCED_UPDATE, Thread.currentThread().getName());
            }
        }
    }
}
