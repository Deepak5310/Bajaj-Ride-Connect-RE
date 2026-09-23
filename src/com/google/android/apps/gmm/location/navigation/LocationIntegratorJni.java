package com.google.android.apps.gmm.location.navigation;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.apps.gmm.jni.util.NativeToJavaExecutor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
abstract class LocationIntegratorJni {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.location.navigation.LocationIntegratorJni");
    private static final com.google.android.libraries.navigation.internal.aac.bj c = NativeHelper.a(new Runnable() { // from class: com.google.android.apps.gmm.location.navigation.z
        @Override // java.lang.Runnable
        public final void run() {
            LocationIntegratorJni.nativeInitClass();
        }
    });
    protected long b;

    public LocationIntegratorJni() {
        NativeHelper.b(c);
        this.b = nativeCreateLocationIntegratorJniData();
    }

    protected static void e() {
        NativeHelper.b(c);
        nativeSetRuntimeFlavor(5, false, false);
    }

    private native byte[] nativeAddObservations(long j, byte[] bArr);

    private static native long nativeCreateLocationIntegratorJniData();

    protected static native void nativeCreateRouteLocationIntegrator(long j, long j2, byte[] bArr, boolean z, byte[] bArr2);

    protected static native void nativeCreateSnaptileLocationIntegrator(long j, long j2, long j3, NativeToJavaExecutor nativeToJavaExecutor, byte[] bArr, boolean z, boolean z2, String str, String str2, long j4, String str3, byte[] bArr2, byte[] bArr3);

    private native void nativeDeleteLocationIntegrator(long j);

    private native void nativeDeleteLocationIntegratorJniData(long j);

    private native byte[] nativeDoFollowUpWork(long j, long j2);

    public static native boolean nativeInitClass();

    private native void nativeReplaceRoutesFromProto(long j, long j2, byte[] bArr);

    private native void nativeRestartAcausalStats(long j);

    private native void nativeRestoreState(long j, long j2, byte[] bArr);

    private static native void nativeSetRuntimeFlavor(int i, boolean z, boolean z2);

    public final void b() {
        long j = this.b;
        if (j != 0) {
            nativeDeleteLocationIntegratorJniData(j);
            this.b = 0L;
        }
    }

    public final void c(long j, byte[] bArr) {
        if (f()) {
            nativeReplaceRoutesFromProto(this.b, j, bArr);
        }
    }

    public final void d() {
        long j = this.b;
        if (j != 0) {
            nativeRestartAcausalStats(j);
        }
    }

    public final boolean f() {
        return this.b != 0;
    }

    protected final void finalize() {
        if (f()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 231)).p("LocationIntegrator not closed correctly.");
        }
        b();
    }

    public final byte[] g(byte[] bArr) {
        long j = this.b;
        if (j == 0) {
            return null;
        }
        return nativeAddObservations(j, bArr);
    }

    public final byte[] h(long j) {
        long j2 = this.b;
        if (j2 != 0) {
            return nativeDoFollowUpWork(j2, j);
        }
        return null;
    }

    protected native void nativeCancelAllBackgroundWork(long j);

    protected native void nativeDidReroute(long j);

    protected native void nativeEnableAcausalResolver(long j, boolean z);

    protected native byte[] nativeGetRouteLocationAsProto(long j, long j2);

    protected native byte[] nativeGetSnaptileLocationAsProto(long j, long j2, int i);

    protected native byte[] nativeGetTileStateDebugString(long j);

    protected native void nativeUpdateSnaptilePrefetchingVersion(long j, int i);

    protected native void nativeWokeFromSleep(long j, long j2, long j3);
}
