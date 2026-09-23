package com.google.android.libraries.navigation.internal.nj;

import android.os.Looper;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static void a() {
        ar.l(Looper.myLooper() != Looper.getMainLooper(), "Expected to be running off the main thread, but running on main thread");
    }

    public static void b() {
        Looper looperMyLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        ar.o(looperMyLooper == mainLooper, "Expected to be running on the main thread, but running on thread with name '%s'", Thread.currentThread().getName());
    }
}
