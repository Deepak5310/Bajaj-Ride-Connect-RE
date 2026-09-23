package com.google.android.libraries.navigation.internal.yw;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.yx.bz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final bz a;

    static {
        bz bVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            bVar = new a();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            bVar = new b();
        }
        a = bVar;
    }
}
