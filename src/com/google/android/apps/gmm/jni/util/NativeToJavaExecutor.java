package com.google.android.apps.gmm.jni.util;

import com.google.android.libraries.navigation.internal.aac.bj;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeToJavaExecutor {
    private static final bj a = NativeHelper.a(new Runnable() { // from class: com.google.android.apps.gmm.jni.util.d
        @Override // java.lang.Runnable
        public final void run() {
            NativeToJavaExecutor.nativeInitClass();
        }
    });
    private final Executor b;

    public NativeToJavaExecutor(Executor executor) {
        NativeHelper.b(a);
        this.b = executor;
    }

    public static native void nativeExecuteInvokablePtr(long j);

    public static native boolean nativeInitClass();

    private void schedule(final long j) {
        this.b.execute(new Runnable() { // from class: com.google.android.apps.gmm.jni.util.e
            @Override // java.lang.Runnable
            public final void run() {
                NativeToJavaExecutor.nativeExecuteInvokablePtr(j);
            }
        });
    }
}
