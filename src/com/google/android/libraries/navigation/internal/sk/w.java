package com.google.android.libraries.navigation.internal.sk;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements Callable {
    final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        dp dpVar = this.a.p;
        if (dpVar != null) {
            return dpVar.k;
        }
        return null;
    }
}
