package com.google.android.libraries.navigation.internal.ft;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bm;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ft.d");
    private final br b;

    public d(final com.google.android.libraries.navigation.internal.afo.a aVar, final bm bmVar) {
        this.b = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.ft.a
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                final com.google.android.libraries.navigation.internal.afo.a aVar2 = aVar;
                Objects.requireNonNull(aVar2);
                return bmVar.submit(new Callable() { // from class: com.google.android.libraries.navigation.internal.ft.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return (com.google.android.libraries.navigation.internal.kl.a) aVar2.a();
                    }
                });
            }
        });
    }

    public final void a(Consumer consumer, Executor executor) {
        com.google.android.libraries.navigation.internal.yu.c.d((bj) this.b.a(), new c(consumer), executor);
    }
}
