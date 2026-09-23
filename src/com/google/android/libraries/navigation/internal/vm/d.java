package com.google.android.libraries.navigation.internal.vm;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d {
    public final Object a;
    public final Executor b;
    public volatile boolean c = false;

    public d(Object obj, Executor executor) {
        this.a = obj;
        this.b = executor;
    }

    public final synchronized void a() {
        this.c = true;
    }
}
