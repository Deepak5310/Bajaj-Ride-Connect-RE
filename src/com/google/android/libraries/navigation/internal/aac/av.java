package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av implements Runnable {
    bj a;
    Future b;

    public av(bj bjVar, Future future) {
        this.a = bjVar;
        this.b = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        az.p(this.a, this.b);
        this.a = null;
        this.b = null;
    }
}
