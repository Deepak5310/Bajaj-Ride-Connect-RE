package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class NativeTessellator implements Closeable {
    public static final int[] a;
    public static final float[] b;
    public static final com.google.android.libraries.navigation.internal.fq.o c;
    public long nativeTessellatorPtr;

    static {
        NativeHelper.c();
        nativeInitClass();
        a = new int[0];
        b = new float[0];
        c = new bb();
    }

    public NativeTessellator() {
        com.google.android.libraries.navigation.internal.yx.ar.k(true);
        long jNativeInit = nativeInit();
        this.nativeTessellatorPtr = jNativeInit;
        com.google.android.libraries.navigation.internal.yx.ar.l(jNativeInit != 0, "Unable to allocate memory for native helper.");
    }

    private native void nativeDestroyTessellator(long j);

    private native void nativeFinishLoops(int[] iArr, long j);

    private static native long nativeInit();

    private static native boolean nativeInitClass();

    private native void nativePrepareForLoops(int[] iArr, int i, long j);

    final void a(int[] iArr, int i, int i2, List list, boolean z) {
        int iIntValue;
        nativePrepareForLoops(iArr, i2, this.nativeTessellatorPtr);
        int i3 = 0;
        while (i < i2) {
            while (true) {
                if (i3 >= list.size()) {
                    iIntValue = 0;
                    break;
                } else {
                    if (((Integer) list.get(i3)).intValue() > i) {
                        iIntValue = ((Integer) list.get(i3)).intValue();
                        break;
                    }
                    i3++;
                }
            }
            if (i3 >= list.size()) {
                iIntValue = i2;
            }
            nativeAddLoop(i, iIntValue, this.nativeTessellatorPtr);
            if (z) {
                nativeFinishPolygon(this.nativeTessellatorPtr);
            }
            i = iIntValue;
        }
        nativeFinishPolygon(this.nativeTessellatorPtr);
        nativeFinishLoops(iArr, this.nativeTessellatorPtr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j = this.nativeTessellatorPtr;
        if (j != 0) {
            nativeDestroyTessellator(j);
        }
        this.nativeTessellatorPtr = 0L;
    }

    protected final void finalize() {
        close();
    }

    public native void nativeAddLoop(int i, int i2, long j);

    public native void nativeAppendIndices(int[] iArr, int i, long j);

    public native void nativeAppendSyntheticVertices(int[] iArr, int i, long j);

    public native void nativeAppendSyntheticVerticesFloat(float[] fArr, int i, long j);

    public native void nativeClear(long j);

    public native void nativeFinishLoopsFloat(float[] fArr, long j);

    public native void nativeFinishPolygon(long j);

    public native int nativeNumIndices(long j);

    public native int nativeNumSyntheticVertices(long j);

    public native void nativePrepareForLoopsFloat(float[] fArr, int i, long j);
}
