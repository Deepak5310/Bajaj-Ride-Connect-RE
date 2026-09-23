package com.google.android.libraries.navigation.internal.le;

import android.os.Looper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar {
    public static ao a(Object obj, String str) {
        com.google.android.libraries.navigation.internal.lh.be.k(obj, "Listener must not be null");
        com.google.android.libraries.navigation.internal.lh.be.k(str, "Listener type must not be null");
        com.google.android.libraries.navigation.internal.lh.be.i(str, "Listener type must not be empty");
        return new ao(obj, str);
    }

    public static aq b(Object obj, Looper looper, String str) {
        com.google.android.libraries.navigation.internal.lh.be.k(obj, "Listener must not be null");
        com.google.android.libraries.navigation.internal.lh.be.k(looper, "Looper must not be null");
        com.google.android.libraries.navigation.internal.lh.be.k(str, "Listener type must not be null");
        return new aq(looper, obj, str);
    }
}
