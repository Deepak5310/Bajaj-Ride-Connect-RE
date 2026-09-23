package com.google.android.apps.gmm.location.navigation;

import com.google.android.apps.gmm.jni.util.NativeToJavaExecutor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class ab extends LocationIntegratorJni {
    public ab(long j, long j2, NativeToJavaExecutor nativeToJavaExecutor, byte[] bArr, boolean z, String str, String str2, long j3, byte[] bArr2, byte[] bArr3) {
        e();
        nativeCreateSnaptileLocationIntegrator(this.b, j, j2, nativeToJavaExecutor, bArr, false, true, str, str2, j3, "", bArr2, bArr3);
    }

    public final void a(boolean z) {
        if (f()) {
            nativeEnableAcausalResolver(this.b, z);
        }
    }
}
