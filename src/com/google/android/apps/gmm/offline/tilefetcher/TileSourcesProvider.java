package com.google.android.apps.gmm.offline.tilefetcher;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class TileSourcesProvider {
    private static final j a;
    private long b = nativeInitTileSourcesProvider();
    private final fd c;

    static {
        NativeHelper.c();
        nativeInitClass();
        a = j.e("com.google.android.apps.gmm.offline.tilefetcher.TileSourcesProvider");
    }

    public TileSourcesProvider(fd fdVar) {
        this.c = fdVar;
    }

    private long createTileSourcePtrForFetchingCookie(byte[] bArr) {
        try {
            bi biVarV = bi.v(com.google.android.libraries.navigation.internal.acs.b.a, bArr, 0, bArr.length, ar.b());
            bi.I(biVarV);
            e eVar = (e) this.c.get((com.google.android.libraries.navigation.internal.acs.b) biVarV);
            if (eVar != null) {
                return eVar.a();
            }
            return 0L;
        } catch (cc e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 443)).o();
            return 0L;
        }
    }

    private long[] createTileSourcePtrs() {
        com.google.android.libraries.navigation.internal.zy.g gVar = com.google.android.libraries.navigation.internal.zy.g.a;
        com.google.android.libraries.navigation.internal.zy.f fVar = new com.google.android.libraries.navigation.internal.zy.f(10);
        nn nnVarListIterator = this.c.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            long jA = ((e) entry.getValue()).a();
            if (jA == 0) {
                int iA = com.google.android.libraries.navigation.internal.acs.d.a(((com.google.android.libraries.navigation.internal.acs.b) entry.getKey()).c);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.acs.d.a;
                }
                com.google.android.libraries.navigation.internal.acs.d.toString$ar$edu$3a3ec22c_0(iA);
            } else {
                fVar.b(jA);
            }
        }
        long[] jArrC = fVar.a().c();
        int length = jArrC.length;
        return jArrC;
    }

    private static native void nativeDestroyTileSourcesProvider(long j);

    private static native boolean nativeInitClass();

    private native long nativeInitTileSourcesProvider();

    public final synchronized long a() {
        return this.b;
    }

    public final synchronized void b() {
        long j = this.b;
        if (j != 0) {
            nativeDestroyTileSourcesProvider(j);
            this.b = 0L;
        }
    }
}
