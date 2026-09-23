package com.google.android.libraries.navigation.internal.xt;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj {
    public static final /* synthetic */ int a = 0;
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static void a(final int... iArr) {
        if (b.compareAndSet(false, true)) {
            com.google.android.libraries.navigation.internal.ky.o.h(new com.google.android.libraries.navigation.internal.ky.m() { // from class: com.google.android.libraries.navigation.internal.xt.bi
                @Override // com.google.android.libraries.navigation.internal.ky.m
                public final com.google.android.libraries.navigation.internal.ky.n a(com.google.android.libraries.navigation.internal.ky.n nVar) {
                    int i = bj.a;
                    try {
                        nVar.a(iArr);
                    } catch (IllegalArgumentException unused) {
                    }
                    return nVar;
                }
            });
        }
    }
}
