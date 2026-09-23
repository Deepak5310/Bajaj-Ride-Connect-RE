package com.google.android.libraries.geo.navcore.jni;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NavCppInstance {
    public long a = 0;

    private native void nativeFree(long j);

    public static native boolean nativeInitClass();

    public final synchronized long a() {
        return this.a;
    }

    public native long nativeAllocate();
}
