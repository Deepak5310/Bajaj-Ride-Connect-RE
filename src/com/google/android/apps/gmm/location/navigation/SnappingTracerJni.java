package com.google.android.apps.gmm.location.navigation;

import com.google.android.apps.gmm.jni.util.NativeHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class SnappingTracerJni {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.SnappingTracerJni");
    public static final com.google.android.libraries.navigation.internal.aac.bj b = NativeHelper.a(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.bv
        @Override // java.lang.Runnable
        public final void run() {
            SnappingTracerJni.nativeInitClass();
        }
    });
    public long c;

    public static native long nativeCreateSnappingTracer(int i, float f, float f2, long j);

    private native void nativeDeleteSnappingTracer(long j);

    private native byte[] nativeGetWholeBufferAsSnappingTrace(long j);

    public static native boolean nativeInitClass();

    private native void nativeOnGmmCarProjectionState(long j, byte[] bArr, long j2);

    private native void nativeOnTravelModeChanged(long j, int i, long j2);

    public final void a() {
        if (!c()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 300)).p("SnappingTracerJni called onStop() when stopped");
        } else {
            nativeDeleteSnappingTracer(this.c);
            this.c = 0L;
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.ady.al alVar, long j) {
        if (c()) {
            nativeOnTravelModeChanged(this.c, alVar.k, j);
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 301)).p("SnappingTracerJni called onTravelModeChanged() when stopped");
        }
    }

    public final boolean c() {
        return this.c != 0;
    }

    protected final void finalize() {
        if (c()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 289)).p("SnappingTracerJni not stopped properly");
            a();
        }
    }

    public native byte[] nativeFlush(long j);

    public native byte[] nativeMaybeFlush(long j, long j2);

    public native void nativeOnForegroundnessChanged(long j, boolean z, long j2);

    public native void nativeOnGuidanceAlertEnded(long j, int i, long j2);

    public native void nativeOnGuidanceAlertQueued(long j, byte[] bArr, double d, double d2, long j2);

    public native void nativeOnGuidanceAlertStarted(long j, byte[] bArr, long j2);

    public native void nativeOnIsNavigatingChanged(long j, boolean z, long j2);

    public native void nativeOnRawLocation(long j, double d, double d2, float f, float f2, float f3, String str, long j2);

    public native void nativeOnRawLocationTimeout(long j, long j2);

    public native void nativeOnRerouteRequested(long j, boolean z, long j2);
}
