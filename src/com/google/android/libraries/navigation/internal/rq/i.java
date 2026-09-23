package com.google.android.libraries.navigation.internal.rq;

import android.os.Looper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final i a = new i(Looper.getMainLooper().getThread());
    public final Thread b;
    public final String c = "Not on the main thread";

    private i(Thread thread) {
        this.b = thread;
    }
}
