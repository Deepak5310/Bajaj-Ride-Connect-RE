package com.google.android.libraries.gmm.fileobserver;

import android.util.SparseArray;
import com.google.android.libraries.navigation.internal.yx.ca;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class Epoller implements Closeable {
    private final SparseArray a = new SparseArray();
    private int b = nativeEpollCreate1();

    static {
        ca.c(nativeInitClass(), new Object[0]);
    }

    private static native void nativeEpollAdd(int i, int i2);

    private static native int nativeEpollCreate1();

    private static native void nativeEpollRemove(int i, int i2);

    private native int nativeEpollWaitAndDispatch(int i, int i2);

    private static native boolean nativeInitClass();

    private void onEpollEvent(int i, int i2) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.a.get(i);
        }
        if (aVar != null) {
            try {
                aVar.a();
            } catch (RuntimeException unused) {
                ((h) j.b.F(1976)).o();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.b;
        if (i >= 0) {
            Inotifier.nativeClose(i);
            this.b = -1;
        }
    }
}
