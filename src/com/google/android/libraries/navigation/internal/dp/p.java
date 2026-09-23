package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.db.ar;
import com.google.android.libraries.navigation.internal.db.as;
import j$.time.Duration;
import j$.time.Instant;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p {
    final /* synthetic */ v a;
    private boolean b = false;

    public p(v vVar) {
        this.a = vVar;
    }

    public final void a(com.google.android.libraries.navigation.internal.dt.f fVar) {
        boolean zC;
        v vVar = this.a;
        if (vVar.B == null) {
            fVar.b();
            return;
        }
        this.b = vVar.s.k(vVar.e.a());
        synchronized (this.a.r) {
            v vVar2 = this.a;
            vVar2.s.b(vVar2.r);
            v vVar3 = this.a;
            if (vVar3.b.j) {
                zC = Duration.ofMillis(vVar3.r.l).plus(as.s).compareTo(Duration.ofMillis(this.a.d.a())) < 0;
            } else {
                zC = ar.c(Instant.ofEpochMilli(vVar3.r.k), this.a.d.f());
            }
            float f = true != zC ? 0.0f : 1.0f;
            com.google.android.libraries.navigation.internal.dt.f fVar2 = this.a.r;
            if (fVar2.j != f) {
                fVar2.j = f;
            }
            fVar.c(fVar2);
        }
        Iterator it2 = this.a.k.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.dq.f) it2.next()).a();
        }
    }

    public final boolean b() {
        synchronized (this.a.r) {
            if (this.a.r.f()) {
                return this.b;
            }
            return false;
        }
    }
}
