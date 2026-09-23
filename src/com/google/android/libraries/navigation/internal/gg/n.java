package com.google.android.libraries.navigation.internal.gg;

import com.google.android.libraries.navigation.internal.aac.bn;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public final List a = new ArrayList();
    public Duration b = Duration.ZERO;
    public Duration c = Duration.ZERO;
    private final com.google.android.libraries.navigation.internal.mj.a d;

    public n(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.d = aVar;
    }

    public final void a(bn bnVar) {
        com.google.android.libraries.navigation.internal.mj.a aVar = this.d;
        if (aVar != null) {
            this.c = Duration.ofMillis(aVar.a());
        }
        synchronized (this) {
            for (final k kVar : this.a) {
                int i = k.B;
                if (!kVar.z.isDone()) {
                    com.google.android.libraries.navigation.internal.hx.n.a(bnVar.e(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gg.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            kVar.a();
                        }
                    }, k.a.toMillis(), TimeUnit.MILLISECONDS), bnVar);
                }
            }
        }
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.mj.a aVar = this.d;
        if (aVar != null) {
            this.b = Duration.ofMillis(aVar.a());
        }
    }
}
