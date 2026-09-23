package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ListenableResultFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m<T> extends com.google.android.libraries.navigation.internal.aac.d<T> implements ListenableResultFuture<T> {
    private final com.google.android.libraries.navigation.internal.vq.b a;

    public m(Executor executor) {
        this.a = new com.google.android.libraries.navigation.internal.vq.b(executor);
    }

    public static m e() {
        return new m(com.google.android.libraries.navigation.internal.vq.c.a);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final boolean d(Object obj) {
        return this.a.d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.a.get();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    @Override // com.google.android.libraries.navigation.ListenableResultFuture
    public final void setOnResultListener(ListenableResultFuture.OnResultListener<T> onResultListener) {
        this.a.c(new l(onResultListener));
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.a.get(j, timeUnit);
    }
}
