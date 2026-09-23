package com.google.android.libraries.geo.mapcore.internal.store.diskcache;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NativeSqliteDiskCacheImpl implements Closeable, b {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.store.diskcache.NativeSqliteDiskCacheImpl");
    public long b;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    public NativeSqliteDiskCacheImpl(long j) {
        this.b = j;
    }

    private static native void nativeDestroySqliteDiskCache(long j);

    private static native boolean nativeInitClass();

    public static native long nativeOpenOrCreateSqliteDiskCache(String str, String str2, int i);

    public static native void nativeSqliteDiskCacheClear(long j);

    public static native void nativeSqliteDiskCacheClearTiles(long j);

    private static native void nativeSqliteDiskCacheDeleteEmptyTiles(long j, byte[] bArr, int[] iArr);

    public static native int nativeSqliteDiskCacheDeleteExpired(long j);

    public static native void nativeSqliteDiskCacheDeleteResource(long j, byte[] bArr);

    public static native void nativeSqliteDiskCacheDeleteTile(long j, byte[] bArr);

    public static native void nativeSqliteDiskCacheFlushWrites(long j);

    public static native byte[] nativeSqliteDiskCacheGetAndClearStats(long j);

    private static native long nativeSqliteDiskCacheGetDatabaseSize(long j);

    public static native byte[] nativeSqliteDiskCacheGetResource(long j, byte[] bArr);

    public static native int nativeSqliteDiskCacheGetServerDataVersion(long j);

    public static native byte[] nativeSqliteDiskCacheGetTile(long j, byte[] bArr);

    public static native byte[] nativeSqliteDiskCacheGetTileMetadata(long j, byte[] bArr);

    private static native boolean nativeSqliteDiskCacheHasResource(long j, byte[] bArr);

    public static native boolean nativeSqliteDiskCacheHasTile(long j, byte[] bArr);

    public static native void nativeSqliteDiskCacheIncrementalVacuum(long j, long j2);

    public static native void nativeSqliteDiskCacheInsertOrUpdateEmptyTile(long j, byte[] bArr);

    public static native void nativeSqliteDiskCacheInsertOrUpdateResource(long j, byte[] bArr, byte[] bArr2);

    public static native void nativeSqliteDiskCacheInsertOrUpdateTile(long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSqliteDiskCachePinTile(long j, byte[] bArr, byte[] bArr2);

    public static native void nativeSqliteDiskCacheSetServerDataVersion(long j, int i);

    public static native void nativeSqliteDiskCacheSetStyleTablePriorityBoostMillis(long j, long j2);

    public static native void nativeSqliteDiskCacheTrimToSize(long j, long j2);

    private static native void nativeSqliteDiskCacheUnpinTiles(long j, byte[] bArr);

    public static native void nativeSqliteDiskCacheUpdateTileMetadata(long j, byte[] bArr);

    @Override // com.google.android.libraries.geo.mapcore.internal.store.diskcache.b
    public final long a() throws d {
        try {
            return nativeSqliteDiskCacheGetDatabaseSize(this.b);
        } catch (com.google.android.apps.gmm.jni.util.c e) {
            throw new d(e);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.store.diskcache.b
    public final boolean c(com.google.android.libraries.navigation.internal.dm.i iVar) throws d {
        try {
            return nativeSqliteDiskCacheHasResource(this.b, iVar.m());
        } catch (com.google.android.apps.gmm.jni.util.c e) {
            throw new d(e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j = this.b;
        if (j != 0) {
            nativeDestroySqliteDiskCache(j);
        }
        this.b = 0L;
    }

    protected final void finalize() {
        close();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.store.diskcache.b
    public final void b() throws d {
        try {
            nativeSqliteDiskCacheFlushWrites(this.b);
        } catch (com.google.android.apps.gmm.jni.util.c e) {
            throw new d(e);
        }
    }
}
