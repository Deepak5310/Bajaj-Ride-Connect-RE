package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cc {
    private static volatile boolean a = false;

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Not on render thread");
        }
    }

    public static boolean b() {
        return Thread.currentThread() instanceof bl;
    }
}
