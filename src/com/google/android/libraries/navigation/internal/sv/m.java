package com.google.android.libraries.navigation.internal.sv;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements com.google.android.libraries.navigation.internal.sp.b {
    public final com.google.android.libraries.navigation.internal.afo.a a;
    public final ao b;
    public final com.google.android.libraries.navigation.internal.aq.m c;
    public final com.google.android.libraries.navigation.internal.sx.bb d;
    public final com.google.android.libraries.navigation.internal.tc.j e;
    public final Executor f;
    public final c g;
    public final cd h;
    private final com.google.android.libraries.navigation.internal.ia.e i;

    public m(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.afo.a aVar, ao aoVar, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.sx.bb bbVar, cd cdVar, com.google.android.libraries.navigation.internal.tc.j jVar, Executor executor, c cVar) {
        this.i = eVar;
        this.a = aVar;
        this.b = aoVar;
        this.c = mVar;
        this.d = bbVar;
        this.h = cdVar;
        this.e = jVar;
        this.f = executor;
        this.g = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.g.b(this.i);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        c cVar = this.g;
        if (cVar.c.compareAndSet(true, false)) {
            this.i.e(cVar);
        }
    }
}
