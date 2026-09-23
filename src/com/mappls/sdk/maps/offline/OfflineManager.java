package com.mappls.sdk.maps.offline;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mappls.sdk.maps.LibraryLoader;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.net.ConnectivityReceiver;
import com.mappls.sdk.maps.storage.FileSource;
import com.mappls.sdk.maps.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes4.dex */
public class OfflineManager {
    private static final String TAG = "Mbgl - OfflineManager";
    private static OfflineManager instance;
    private Context context;
    private final FileSource fileSource;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long nativePtr;

    public interface CreateOfflineRegionCallback {
        void onCreate(OfflineRegion offlineRegion);

        void onError(String str);
    }

    public interface FileSourceCallback {
        void onError(String str);

        void onSuccess();
    }

    public interface ListOfflineRegionsCallback {
        void onError(String str);

        void onList(OfflineRegion[] offlineRegionArr);
    }

    public interface MergeOfflineRegionsCallback {
        void onError(String str);

        void onMerge(OfflineRegion[] offlineRegionArr);
    }

    private native void createOfflineRegion(FileSource fileSource, OfflineRegionDefinition offlineRegionDefinition, byte[] bArr, CreateOfflineRegionCallback createOfflineRegionCallback);

    private native void initialize(FileSource fileSource);

    private native void listOfflineRegions(FileSource fileSource, ListOfflineRegionsCallback listOfflineRegionsCallback);

    private native void mergeOfflineRegions(FileSource fileSource, String str, MergeOfflineRegionsCallback mergeOfflineRegionsCallback);

    private native void nativeClearAmbientCache(FileSourceCallback fileSourceCallback);

    private native void nativeInvalidateAmbientCache(FileSourceCallback fileSourceCallback);

    private native void nativePackDatabase(FileSourceCallback fileSourceCallback);

    private native void nativeResetDatabase(FileSourceCallback fileSourceCallback);

    private native void nativeSetMaximumAmbientCacheSize(long j, FileSourceCallback fileSourceCallback);

    protected native void finalize() throws Throwable;

    public native void putResourceWithUrl(String str, byte[] bArr, long j, long j2, String str2, boolean z);

    public native void runPackDatabaseAutomatically(boolean z);

    public native void setOfflineMapplsTileCountLimit(long j);

    static {
        LibraryLoader.load();
    }

    private OfflineManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        FileSource fileSource = FileSource.getInstance(applicationContext);
        this.fileSource = fileSource;
        initialize(fileSource);
        deleteAmbientDatabase(this.context);
    }

    private void deleteAmbientDatabase(Context context) {
        FileUtils.deleteFile(FileSource.getInternalCachePath(context) + File.separator + "mbgl-cache.db");
    }

    public static synchronized OfflineManager getInstance(Context context) {
        if (instance == null) {
            instance = new OfflineManager(context);
        }
        return instance;
    }

    public void listOfflineRegions(final ListOfflineRegionsCallback listOfflineRegionsCallback) {
        this.fileSource.activate();
        listOfflineRegions(this.fileSource, new ListOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.1
            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onList(final OfflineRegion[] offlineRegionArr) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        listOfflineRegionsCallback.onList(offlineRegionArr);
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.ListOfflineRegionsCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        listOfflineRegionsCallback.onError(str);
                    }
                });
            }
        });
    }

    public void mergeOfflineRegions(String str, final MergeOfflineRegionsCallback mergeOfflineRegionsCallback) {
        final File file = new File(str);
        new Thread(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                final String message = null;
                if (file.canWrite()) {
                    OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OfflineManager.this.mergeOfflineDatabaseFiles(file, mergeOfflineRegionsCallback, false);
                        }
                    });
                } else if (file.canRead()) {
                    final File file2 = new File(FileSource.getInternalCachePath(OfflineManager.this.context), file.getName());
                    try {
                        OfflineManager.copyTempDatabaseFile(file, file2);
                        OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                OfflineManager.this.mergeOfflineDatabaseFiles(file2, mergeOfflineRegionsCallback, true);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                        message = e.getMessage();
                    }
                } else {
                    message = "Secondary database needs to be located in a readable path.";
                }
                if (message != null) {
                    OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            mergeOfflineRegionsCallback.onError(message);
                        }
                    });
                }
            }
        }).start();
    }

    public void resetDatabase(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeResetDatabase(new FileSourceCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.3
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void packDatabase(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativePackDatabase(new FileSourceCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.4
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void invalidateAmbientCache(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeInvalidateAmbientCache(new FileSourceCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.5
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void clearAmbientCache(final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeClearAmbientCache(new FileSourceCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.6
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void setMaximumAmbientCacheSize(long j, final FileSourceCallback fileSourceCallback) {
        this.fileSource.activate();
        nativeSetMaximumAmbientCacheSize(j, new FileSourceCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.7
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onSuccess();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(final String str) {
                OfflineManager.this.fileSource.activate();
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        if (fileSourceCallback != null) {
                            fileSourceCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    public static void copyTempDatabaseFile(File file, File file2) throws Throwable {
        FileChannel fileChannel;
        if (!file2.exists() && !file2.createNewFile()) {
            throw new IOException("Unable to copy database file for merge.");
        }
        FileChannel channel = null;
        try {
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
                channel.transferFrom(channel2, 0L, channel2.size());
                if (channel2 != null) {
                    channel2.close();
                }
                if (channel != null) {
                    channel.close();
                }
            } catch (IOException e) {
                e = e;
                FileChannel fileChannel2 = channel;
                channel = channel2;
                fileChannel = fileChannel2;
                try {
                    throw new IOException(String.format("Unable to copy database file for merge. %s", e.getMessage()));
                } catch (Throwable th) {
                    th = th;
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel3 = channel;
                channel = channel2;
                fileChannel = fileChannel3;
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOfflineDatabaseFiles(final File file, final MergeOfflineRegionsCallback mergeOfflineRegionsCallback, final boolean z) {
        this.fileSource.activate();
        mergeOfflineRegions(this.fileSource, file.getAbsolutePath(), new MergeOfflineRegionsCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.8
            @Override // com.mappls.sdk.maps.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onMerge(final OfflineRegion[] offlineRegionArr) {
                if (z) {
                    file.delete();
                }
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        mergeOfflineRegionsCallback.onMerge(offlineRegionArr);
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.MergeOfflineRegionsCallback
            public void onError(final String str) {
                if (z) {
                    file.delete();
                }
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineManager.this.fileSource.deactivate();
                        mergeOfflineRegionsCallback.onError(str);
                    }
                });
            }
        });
    }

    public void createOfflineRegion(OfflineRegionDefinition offlineRegionDefinition, byte[] bArr, final CreateOfflineRegionCallback createOfflineRegionCallback) {
        if (!isValidOfflineRegionDefinition(offlineRegionDefinition)) {
            createOfflineRegionCallback.onError(String.format(this.context.getString(R.string.mappls_maps_offline_error_region_definition_invalid), offlineRegionDefinition.getBounds()));
            return;
        }
        ConnectivityReceiver.instance(this.context).activate();
        FileSource.getInstance(this.context).activate();
        createOfflineRegion(this.fileSource, offlineRegionDefinition, bArr, new CreateOfflineRegionCallback() { // from class: com.mappls.sdk.maps.offline.OfflineManager.9
            @Override // com.mappls.sdk.maps.offline.OfflineManager.CreateOfflineRegionCallback
            public void onCreate(final OfflineRegion offlineRegion) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityReceiver.instance(OfflineManager.this.context).deactivate();
                        FileSource.getInstance(OfflineManager.this.context).deactivate();
                        createOfflineRegionCallback.onCreate(offlineRegion);
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.CreateOfflineRegionCallback
            public void onError(final String str) {
                OfflineManager.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineManager.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectivityReceiver.instance(OfflineManager.this.context).deactivate();
                        FileSource.getInstance(OfflineManager.this.context).deactivate();
                        createOfflineRegionCallback.onError(str);
                    }
                });
            }
        });
    }

    private boolean isValidOfflineRegionDefinition(OfflineRegionDefinition offlineRegionDefinition) {
        return LatLngBounds.world().contains(offlineRegionDefinition.getBounds());
    }
}
