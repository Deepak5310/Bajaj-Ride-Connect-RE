package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class au implements eq {
    @Override // com.google.android.libraries.navigation.internal.aga.eq
    public final /* bridge */ /* synthetic */ Object a() {
        return Executors.newCachedThreadPool(az.c("grpc-default-executor-%d"));
    }

    @Override // com.google.android.libraries.navigation.internal.aga.eq
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        ((ExecutorService) obj).shutdown();
    }

    public final String toString() {
        return "grpc-default-executor";
    }
}
