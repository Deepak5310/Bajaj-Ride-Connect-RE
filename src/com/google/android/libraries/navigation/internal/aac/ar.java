package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ar extends ap implements bj {
    protected ar() {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.ap
    protected /* bridge */ /* synthetic */ Future d() {
        throw null;
    }

    protected abstract bj e();

    @Override // com.google.android.libraries.navigation.internal.aac.bj
    public final void l(Runnable runnable, Executor executor) {
        e().l(runnable, executor);
    }
}
