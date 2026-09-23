package com.google.android.libraries.navigation.internal.ra;

import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.hx.ab;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final ab a;

    public a(Executor executor) {
        this.a = new ab(new bz(executor), true);
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
