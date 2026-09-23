package com.google.android.libraries.gmm.fileobserver;

import com.google.android.libraries.navigation.internal.yx.ca;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class Inotifier implements Closeable {
    private int a = nativeInotifyInit();

    /* JADX INFO: compiled from: PG */
    public interface Callback {
        void onInotifyEvent(int i, int i2, String str);
    }

    static {
        ca.c(nativeInitClass(), new Object[0]);
    }

    static native void nativeClose(int i);

    private static native void nativeDispatchInotifyEvents(byte[] bArr, int i, Callback callback);

    private static native boolean nativeInitClass();

    private static native int nativeInotifyAddWatch(int i, String str, int i2);

    private static native int nativeInotifyInit();

    private static native int nativeReadInotifyEvents(int i, byte[] bArr);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        int i = this.a;
        if (i >= 0) {
            nativeClose(i);
            this.a = -1;
        }
    }
}
