package com.google.android.libraries.navigation.internal.lm;

import android.os.Handler;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.lt.c;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Executor {
    private final Handler a;

    public a(Looper looper) {
        this.a = new c(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
