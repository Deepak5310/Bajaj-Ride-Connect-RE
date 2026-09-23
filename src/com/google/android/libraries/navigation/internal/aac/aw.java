package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw implements Callable {
    final /* synthetic */ Runnable a;

    public aw(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.a.run();
        return null;
    }
}
