package com.google.android.libraries.navigation.internal.xt;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap {
    static void a(final com.google.android.libraries.navigation.internal.aac.bj bjVar) {
        bjVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.an
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.google.android.libraries.navigation.internal.aac.az.n(bjVar);
                } catch (ExecutionException e) {
                    com.google.android.libraries.navigation.internal.xx.c.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xt.ao
                        @Override // java.lang.Runnable
                        public final void run() {
                            throw new RuntimeException(e.getCause());
                        }
                    });
                }
            }
        }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }
}
