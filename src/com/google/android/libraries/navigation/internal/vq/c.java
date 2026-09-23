package com.google.android.libraries.navigation.internal.vq;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Executor {
    public static final c a = new c();
    private final Handler b = new Handler(Looper.getMainLooper());

    private c() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }
}
