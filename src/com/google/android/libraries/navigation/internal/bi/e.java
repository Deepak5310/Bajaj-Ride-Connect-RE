package com.google.android.libraries.navigation.internal.bi;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements com.google.android.libraries.navigation.internal.gg.g {
    private final com.google.android.libraries.navigation.internal.fr.d a;
    private final com.google.android.libraries.navigation.internal.gg.g b;

    public e(com.google.android.libraries.navigation.internal.fr.d dVar, com.google.android.libraries.navigation.internal.gg.g gVar) {
        this.a = dVar;
        this.b = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.g
    public final com.google.android.libraries.navigation.internal.gg.b a(final Object obj, final com.google.android.libraries.navigation.internal.gg.e eVar, Executor executor) {
        if (this.a.d()) {
            return this.b.a(obj, eVar, executor);
        }
        executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bi.c
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.gg.h hVar = new com.google.android.libraries.navigation.internal.gg.h();
                hVar.a = obj;
                hVar.e = new com.google.android.libraries.navigation.internal.gg.n(null);
                hVar.a(1);
                eVar.a(new com.google.android.libraries.navigation.internal.gg.i(hVar), com.google.android.libraries.navigation.internal.gg.o.k);
            }
        });
        return new com.google.android.libraries.navigation.internal.gg.b() { // from class: com.google.android.libraries.navigation.internal.bi.d
            @Override // com.google.android.libraries.navigation.internal.gg.b
            public final boolean a() {
                return false;
            }
        };
    }
}
