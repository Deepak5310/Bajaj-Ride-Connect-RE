package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public an a;
    private an b;
    private bz c;
    private k d;

    public o() {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.b = aVar;
        this.a = aVar;
        this.c = bz.a;
        this.d = q.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.concurrent.ScheduledExecutorService] */
    public final q a(br brVar, g gVar, as asVar) {
        boolean z = true;
        if (!this.b.g() && !this.a.g()) {
            z = false;
        }
        ar.l(z, "Either executor or scheduledExecutorService needs to be set.");
        return new q(brVar, gVar, asVar, (Executor) this.b.a(this.a).c(), this.a.g() ? this.a.c() : p.a, this.c, this.d);
    }

    public final void b(Executor executor) {
        this.b = an.j(executor);
    }
}
