package com.google.android.libraries.navigation.internal.abh;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba {
    private final Handler a = new ay(Looper.getMainLooper());
    private final Handler b = new az(Looper.getMainLooper());

    public final void a(com.google.android.libraries.navigation.internal.abg.n nVar) {
        Message.obtain(this.a, 0, nVar).sendToTarget();
    }

    public final void b(com.google.android.libraries.navigation.internal.abg.n nVar) {
        Message.obtain(this.b, 0, nVar).sendToTarget();
    }
}
