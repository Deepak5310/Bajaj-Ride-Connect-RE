package com.google.android.apps.gmm.offline.tilefetcher;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.apps.gmm.offline.routing.NativeCapableSnaptileProvider;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class SnaptileTileSourceFactory implements e {
    private final br a;
    private final EndTileWorkScheduler b;
    private final x c;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    public SnaptileTileSourceFactory(br brVar, EndTileWorkScheduler endTileWorkScheduler, com.google.android.libraries.navigation.internal.acs.b bVar) {
        this.a = brVar;
        this.b = endTileWorkScheduler;
        this.c = bVar.k();
    }

    private static native boolean nativeInitClass();

    private static native long nativeInitSnaptileTileSource(NativeCapableSnaptileProvider nativeCapableSnaptileProvider, long j, EndTileWorkScheduler endTileWorkScheduler, byte[] bArr);

    @Override // com.google.android.apps.gmm.offline.tilefetcher.e
    public final long a() {
        com.google.android.apps.gmm.offline.routing.a aVar;
        synchronized (this) {
            aVar = ((g) this.a).a;
            int i = h.b;
        }
        long jA = aVar.a();
        if (jA == 0) {
            return 0L;
        }
        return nativeInitSnaptileTileSource(aVar, jA, this.b, this.c.B());
    }
}
