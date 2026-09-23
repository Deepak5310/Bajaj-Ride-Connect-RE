package com.google.android.apps.gmm.offline.routing;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.yx.br;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class OfflineReroutingController implements a, h {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.apps.gmm.offline.routing.OfflineReroutingController");
    public boolean a = false;
    public long b;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    public OfflineReroutingController(com.google.android.libraries.navigation.internal.ev.b bVar) {
        this.b = 0L;
        File file = new File(bVar.b.getFilesDir(), String.valueOf(com.google.android.libraries.navigation.internal.ev.b.a).concat("rerouting"));
        com.google.android.libraries.navigation.internal.ex.e eVar = com.google.android.libraries.navigation.internal.ex.e.a;
        com.google.android.libraries.navigation.internal.acn.e eVar2 = (com.google.android.libraries.navigation.internal.acn.e) com.google.android.libraries.navigation.internal.acn.f.a.q();
        eVar.b();
        if (!eVar2.b.H()) {
            eVar2.v();
        }
        com.google.android.libraries.navigation.internal.acn.f fVar = (com.google.android.libraries.navigation.internal.acn.f) eVar2.b;
        fVar.b |= 1;
        fVar.c = "disabled";
        File file2 = new File(file, ((com.google.android.libraries.navigation.internal.acn.f) eVar2.t()).c);
        long jNativeInitRerouting = nativeInitRerouting(file2.getPath(), file2.getPath());
        this.b = jNativeInitRerouting;
        if (jNativeInitRerouting == 0) {
            throw new NullPointerException("Could not initialize native OfflineRerouting object.");
        }
    }

    private native void nativeAddRoadGraphTile(long j, byte[] bArr, int i, long j2);

    private native void nativeDestroyRerouting(long j);

    private native void nativeExpireAllRoadGraphTilesOlderThan(long j, long j2);

    private native int[] nativeGetAvailableVersionsForSnaptile(long j, int i, int i2);

    private native byte[] nativeGetLocalizedSnaptile(long j, String str, String str2, int i, int i2, int i3);

    private native byte[] nativeGetReroute(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i);

    private native byte[] nativeGetSnaptile(long j, int i, int i2, int i3);

    private native byte[] nativeGetSnaptileMetadata(long j, int i);

    private static native boolean nativeInitClass();

    private static native long nativeInitRerouting(String str, String str2);

    private native byte[] nativeQuerySnaptiles(long j, byte[] bArr);

    private native void nativeTrimToSize(long j, long j2, long j3);

    @Override // com.google.android.apps.gmm.offline.routing.NativeCapableSnaptileProvider
    public final long a() {
        return this.b;
    }

    @Override // com.google.android.apps.gmm.offline.routing.a
    public final void b(byte[] bArr, int i, long j) {
        nativeAddRoadGraphTile(this.b, bArr, i, j);
    }

    @Override // com.google.android.apps.gmm.offline.routing.a
    public final void c(long j) {
        nativeExpireAllRoadGraphTilesOlderThan(this.b, j);
    }

    @Override // com.google.android.apps.gmm.offline.routing.a
    public final void d(long j) {
        nativeTrimToSize(this.b, 52428800L, j);
    }

    @Override // com.google.android.apps.gmm.offline.routing.m
    public final Object e(br brVar) {
        com.google.android.apps.gmm.jni.util.c e;
        Object obj;
        long j = this.b;
        byte[] bArr = i.a;
        com.google.android.apps.gmm.jni.util.c cVar = null;
        try {
            nativeBeginRoadGraphTileWork(j);
            try {
                Object objA = brVar.a();
                try {
                    nativeEndRoadGraphTileWork(j);
                    obj = objA;
                    e = null;
                } catch (com.google.android.apps.gmm.jni.util.c e2) {
                    e = e2;
                    obj = null;
                }
            } catch (com.google.android.apps.gmm.jni.util.c e3) {
                try {
                    nativeEndRoadGraphTileWork(j);
                    obj = null;
                    cVar = e3;
                    e = null;
                } catch (com.google.android.apps.gmm.jni.util.c e4) {
                    cVar = e3;
                    e = e4;
                    obj = null;
                }
            } catch (Throwable th) {
                try {
                    nativeEndRoadGraphTileWork(j);
                } catch (com.google.android.apps.gmm.jni.util.c unused) {
                }
                throw th;
            }
            i.a(cVar);
            i.a(e);
            return obj;
        } catch (com.google.android.apps.gmm.jni.util.c e5) {
            i.a(e5);
            return null;
        }
    }

    @Override // com.google.android.apps.gmm.offline.routing.l
    public final byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) {
        try {
            return nativeGetReroute(this.b, bArr, bArr2, bArr3, bArr4, i);
        } catch (RuntimeException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) d.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 440)).o();
            return i.a;
        }
    }

    protected final void finalize() {
        long j = this.b;
        if (j != 0) {
            nativeDestroyRerouting(j);
            this.b = 0L;
        }
    }

    @Override // com.google.android.apps.gmm.offline.routing.m
    public final byte[] g(byte[] bArr) {
        return nativeQuerySnaptiles(this.b, bArr);
    }

    @Override // com.google.android.apps.gmm.offline.routing.h
    public native void nativeBeginRoadGraphTileWork(long j);

    @Override // com.google.android.apps.gmm.offline.routing.h
    public native void nativeEndRoadGraphTileWork(long j);

    @Override // com.google.android.apps.gmm.offline.routing.h
    public native void nativePerformExpensiveInitialization(long j);
}
