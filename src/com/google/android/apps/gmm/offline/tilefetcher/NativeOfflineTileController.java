package com.google.android.apps.gmm.offline.tilefetcher;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.apps.gmm.offline.settings.dataview.OfflineDataViewProvider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class NativeOfflineTileController implements d {
    private long a;
    private final TileSourcesProvider b;
    private final OfflineDataViewProvider c;
    private final com.google.android.libraries.navigation.internal.ew.b d;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    public NativeOfflineTileController(TileSourcesProvider tileSourcesProvider, OfflineDataViewProvider offlineDataViewProvider, com.google.android.libraries.navigation.internal.ew.b bVar) {
        this.a = 0L;
        this.b = tileSourcesProvider;
        this.c = offlineDataViewProvider;
        this.d = bVar;
        long jNativeInitOfflineTileController = nativeInitOfflineTileController(tileSourcesProvider.a(), offlineDataViewProvider.a(), 0L, false);
        this.a = jNativeInitOfflineTileController;
        if (jNativeInitOfflineTileController == 0) {
            throw new NullPointerException("Could not initialize native OfflineTileController object.");
        }
    }

    private native void nativeDestroyOfflineTileController(long j);

    private static native boolean nativeInitClass();

    private native long nativeInitOfflineTileController(long j, long j2, long j3, boolean z);

    @Override // com.google.android.apps.gmm.offline.tilefetcher.d
    public final synchronized long a() {
        return this.a;
    }

    protected final synchronized void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroyOfflineTileController(j);
            this.a = 0L;
        }
        this.b.b();
        this.c.b();
    }
}
