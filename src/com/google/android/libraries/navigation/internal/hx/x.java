package com.google.android.libraries.navigation.internal.hx;

import android.os.Process;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends Thread implements ao {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hx.x");
    private final ap b;

    public x(final Runnable runnable, final ap apVar, final String str) {
        super(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hx.v
            @Override // java.lang.Runnable
            public final void run() {
                int iB = apVar.b();
                try {
                    Process.setThreadPriority(iB);
                } catch (SecurityException unused) {
                    x.b("Hey, you don't have permission to set thread " + str + " to " + iB);
                }
                runnable.run();
            }
        }, str);
        this.b = apVar;
        try {
            ah.a(str, null);
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 710)).o();
        }
        if (apVar == ap.CURRENT) {
            b("Cannot start a GmmThread as Threads.CURRENT");
        }
        if (apVar.b() < 0) {
            b(com.google.android.libraries.navigation.internal.b.b.g(str, "Hey, don't create a thread (", ") with an android thread priority having a lower number than the UI thread's priority of 0"));
        }
    }

    public static void b(String str) {
        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new IllegalArgumentException(str))).F((char) 711)).o();
    }

    @Override // com.google.android.libraries.navigation.internal.hx.ao
    public final ap a() {
        return this.b;
    }
}
