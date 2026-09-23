package com.google.android.libraries.navigation.internal.abg;

import com.google.android.libraries.navigation.internal.abf.z;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends FutureTask {
    public b(Callable callable) {
        super(callable);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        z.a.b();
        return super.get();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        z.a.b();
        return super.get(j, timeUnit);
    }
}
