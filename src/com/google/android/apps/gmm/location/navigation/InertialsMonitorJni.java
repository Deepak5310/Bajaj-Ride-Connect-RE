package com.google.android.apps.gmm.location.navigation;

import com.google.android.apps.gmm.jni.util.NativeHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class InertialsMonitorJni {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.InertialsMonitorJni");
    public static final com.google.android.libraries.navigation.internal.aac.bj b = NativeHelper.a(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.t
        @Override // java.lang.Runnable
        public final void run() {
            InertialsMonitorJni.nativeInitClass();
        }
    });
    public long c;

    public static native long nativeCreateInertialsMonitor(byte[] bArr, boolean z, boolean z2);

    private native void nativeDeleteInertialsMonitor(long j);

    public static native boolean nativeInitClass();

    private native void nativeOnDebugInertialState(long j, byte[] bArr);

    public final void a() {
        if (!b()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 210)).p("InertialsMonitorJni called onStop() when stopped");
        } else {
            nativeDeleteInertialsMonitor(this.c);
            this.c = 0L;
        }
    }

    public final boolean b() {
        return this.c != 0;
    }

    protected final void finalize() {
        if (b()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 206)).p("InertialsMonitorJni not stopped properly");
            a();
        }
    }

    public native byte[] nativeGetInertialState(long j);

    public native byte[] nativeOnInertialsSummary(long j, long j2, long j3, long j4, float f, float f2, float f3, float f4, boolean z, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13);

    public native byte[] nativeOnLocation(long j, long j2, long j3, String str, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6);

    public native void nativeOnSnappedLocation(long j, long j2, double d, double d2, double d3, double d4, boolean z, boolean z2);

    public native byte[] nativeOnWheelSpeed(long j, long j2, float f);
}
