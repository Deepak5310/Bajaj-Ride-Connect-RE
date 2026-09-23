package com.google.android.libraries.navigation.internal.abf;

import android.os.StrictMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public static final w a = new w();
    private static final String b = "w";

    private w() {
    }

    public final StrictMode.ThreadPolicy a() {
        p.f(b, 5);
        return StrictMode.allowThreadDiskReads();
    }

    public final StrictMode.ThreadPolicy b() {
        StrictMode.ThreadPolicy threadPolicyA = a();
        c();
        return threadPolicyA;
    }

    public final StrictMode.ThreadPolicy c() {
        p.f(b, 5);
        return StrictMode.allowThreadDiskWrites();
    }

    public final void d(StrictMode.ThreadPolicy threadPolicy) {
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
