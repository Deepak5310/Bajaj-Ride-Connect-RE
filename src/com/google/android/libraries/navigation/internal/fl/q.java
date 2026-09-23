package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    private static final long d = TimeUnit.SECONDS.toMillis(15);
    public final com.google.android.apps.gmm.offline.routing.a a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    private final bn e;
    private long f = 0;
    public boolean c = false;

    public q(com.google.android.apps.gmm.offline.routing.a aVar, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar2) {
        this.a = aVar;
        this.e = bnVar;
        this.b = aVar2;
    }

    public final synchronized void a() {
        if (this.c) {
            return;
        }
        long jA = (this.f + d) - this.b.a();
        if (jA < 0) {
            jA = 0;
        }
        this.c = true;
        this.e.e(new p(this), jA, TimeUnit.MILLISECONDS);
    }

    public final synchronized void b() {
        this.a.e(new br() { // from class: com.google.android.libraries.navigation.internal.fl.o
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                q qVar = this.a;
                qVar.a.c(qVar.b.f().getEpochSecond());
                return null;
            }
        });
    }

    final synchronized void c() {
        this.c = false;
        this.f = this.b.a();
        this.a.e(new br() { // from class: com.google.android.libraries.navigation.internal.fl.n
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                q qVar = this.a;
                qVar.a.d(qVar.b.f().getEpochSecond());
                return null;
            }
        });
    }
}
