package com.google.android.libraries.geo.navcore.decoration.jni;

import com.google.android.apps.gmm.jni.util.NativeHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class DecorationCppInstance {
    public long a = 0;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    private native void nativeFree(long j);

    private static native boolean nativeInitClass();

    public native long nativeAllocate();
}
