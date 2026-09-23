package com.google.android.libraries.navigation.internal.ft;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public final com.google.android.libraries.navigation.internal.km.y a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final Executor c;
    private final d d;

    public af(com.google.android.libraries.navigation.internal.mj.a aVar, Executor executor, d dVar, com.google.android.libraries.navigation.internal.km.y yVar) {
        this.b = aVar;
        this.c = executor;
        this.d = dVar;
        this.a = yVar;
    }

    public final Object a(br brVar) {
        long jA = this.b.a();
        try {
            return brVar.a();
        } finally {
            final long jA2 = this.b.a() - jA;
            this.d.a(new Consumer() { // from class: com.google.android.libraries.navigation.internal.ft.ad
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.a) obj).a(this.a.a)).a(jA2);
                }
            }, this.c);
        }
    }

    public final void b(final Runnable runnable) {
        a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.ae
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                runnable.run();
                return null;
            }
        });
    }
}
