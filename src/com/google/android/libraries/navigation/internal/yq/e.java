package com.google.android.libraries.navigation.internal.yq;

import com.google.android.libraries.navigation.internal.aac.s;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements Runnable {
    public s a;
    public Executor b;

    public e(s sVar, Executor executor) {
        this.a = sVar;
        ar.q(executor);
        this.b = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a = null;
        this.b = null;
    }
}
