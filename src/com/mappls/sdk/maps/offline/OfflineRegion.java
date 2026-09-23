package com.mappls.sdk.maps.offline;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mappls.sdk.maps.LibraryLoader;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.net.ConnectivityReceiver;
import com.mappls.sdk.maps.storage.FileSource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class OfflineRegion {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    private OfflineRegionDefinition definition;
    private FileSource fileSource;
    private long id;
    private boolean isDeleted;
    private byte[] metadata;
    private long nativePtr;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int state = 0;
    private boolean deliverInactiveMessages = false;
    private final Context context = Mappls.getApplicationContext();

    @Retention(RetentionPolicy.SOURCE)
    public @interface DownloadState {
    }

    public interface OfflineRegionDeleteCallback {
        void onDelete();

        void onError(String str);
    }

    public interface OfflineRegionInvalidateCallback {
        void onError(String str);

        void onInvalidate();
    }

    public interface OfflineRegionObserver {
        void mapplsTileCountLimitExceeded(long j);

        void onError(OfflineRegionError offlineRegionError);

        void onStatusChanged(OfflineRegionStatus offlineRegionStatus);
    }

    public interface OfflineRegionStatusCallback {
        void onError(String str);

        void onStatus(OfflineRegionStatus offlineRegionStatus);
    }

    public interface OfflineRegionUpdateMetadataCallback {
        void onError(String str);

        void onUpdate(byte[] bArr);
    }

    private native void deleteOfflineRegion(OfflineRegionDeleteCallback offlineRegionDeleteCallback);

    private native void getOfflineRegionStatus(OfflineRegionStatusCallback offlineRegionStatusCallback);

    private native void initialize(long j, FileSource fileSource);

    private native void invalidateOfflineRegion(OfflineRegionInvalidateCallback offlineRegionInvalidateCallback);

    private native void setOfflineRegionDownloadState(int i);

    private native void setOfflineRegionObserver(OfflineRegionObserver offlineRegionObserver);

    private native void updateOfflineRegionMetadata(byte[] bArr, OfflineRegionUpdateMetadataCallback offlineRegionUpdateMetadataCallback);

    protected native void finalize();

    static {
        LibraryLoader.load();
    }

    public boolean isDeliveringInactiveMessages() {
        return this.deliverInactiveMessages;
    }

    public void setDeliverInactiveMessages(boolean z) {
        this.deliverInactiveMessages = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deliverMessages() {
        if (this.state == 1) {
            return true;
        }
        return isDeliveringInactiveMessages();
    }

    private OfflineRegion(long j, FileSource fileSource, long j2, OfflineRegionDefinition offlineRegionDefinition, byte[] bArr) {
        this.fileSource = fileSource;
        this.id = j2;
        this.definition = offlineRegionDefinition;
        this.metadata = bArr;
        initialize(j, fileSource);
    }

    public long getID() {
        return this.id;
    }

    public OfflineRegionDefinition getDefinition() {
        return this.definition;
    }

    public byte[] getMetadata() {
        return this.metadata;
    }

    public void setObserver(final OfflineRegionObserver offlineRegionObserver) {
        setOfflineRegionObserver(new OfflineRegionObserver() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.1
            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void onStatusChanged(final OfflineRegionStatus offlineRegionStatus) {
                if (OfflineRegion.this.deliverMessages()) {
                    OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (offlineRegionObserver != null) {
                                offlineRegionObserver.onStatusChanged(offlineRegionStatus);
                            }
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void onError(final OfflineRegionError offlineRegionError) {
                if (OfflineRegion.this.deliverMessages()) {
                    OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (offlineRegionObserver != null) {
                                offlineRegionObserver.onError(offlineRegionError);
                            }
                        }
                    });
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionObserver
            public void mapplsTileCountLimitExceeded(final long j) {
                if (OfflineRegion.this.deliverMessages()) {
                    OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (offlineRegionObserver != null) {
                                offlineRegionObserver.mapplsTileCountLimitExceeded(j);
                            }
                        }
                    });
                }
            }
        });
    }

    public void setDownloadState(int i) {
        if (this.state == i) {
            return;
        }
        if (i == 1) {
            ConnectivityReceiver.instance(this.context).activate();
            this.fileSource.activate();
        } else {
            this.fileSource.deactivate();
            ConnectivityReceiver.instance(this.context).deactivate();
        }
        this.state = i;
        setOfflineRegionDownloadState(i);
    }

    public void getStatus(final OfflineRegionStatusCallback offlineRegionStatusCallback) {
        this.fileSource.activate();
        getOfflineRegionStatus(new OfflineRegionStatusCallback() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.2
            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionStatusCallback
            public void onStatus(final OfflineRegionStatus offlineRegionStatus) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.fileSource.deactivate();
                        offlineRegionStatusCallback.onStatus(offlineRegionStatus);
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionStatusCallback
            public void onError(final String str) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.fileSource.deactivate();
                        offlineRegionStatusCallback.onError(str);
                    }
                });
            }
        });
    }

    public void delete(final OfflineRegionDeleteCallback offlineRegionDeleteCallback) {
        if (this.isDeleted) {
            return;
        }
        this.isDeleted = true;
        this.fileSource.activate();
        deleteOfflineRegion(new OfflineRegionDeleteCallback() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.3
            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionDeleteCallback
            public void onDelete() {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.fileSource.deactivate();
                        offlineRegionDeleteCallback.onDelete();
                        OfflineRegion.this.finalize();
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionDeleteCallback
            public void onError(final String str) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.isDeleted = false;
                        OfflineRegion.this.fileSource.deactivate();
                        offlineRegionDeleteCallback.onError(str);
                    }
                });
            }
        });
    }

    public void invalidate(final OfflineRegionInvalidateCallback offlineRegionInvalidateCallback) {
        this.fileSource.activate();
        invalidateOfflineRegion(new OfflineRegionInvalidateCallback() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.4
            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionInvalidateCallback
            public void onInvalidate() {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.fileSource.deactivate();
                        if (offlineRegionInvalidateCallback != null) {
                            offlineRegionInvalidateCallback.onInvalidate();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionInvalidateCallback
            public void onError(final String str) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.fileSource.deactivate();
                        if (offlineRegionInvalidateCallback != null) {
                            offlineRegionInvalidateCallback.onError(str);
                        }
                    }
                });
            }
        });
    }

    public void updateMetadata(byte[] bArr, final OfflineRegionUpdateMetadataCallback offlineRegionUpdateMetadataCallback) {
        updateOfflineRegionMetadata(bArr, new OfflineRegionUpdateMetadataCallback() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.5
            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionUpdateMetadataCallback
            public void onUpdate(final byte[] bArr2) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineRegion.this.metadata = bArr2;
                        offlineRegionUpdateMetadataCallback.onUpdate(bArr2);
                    }
                });
            }

            @Override // com.mappls.sdk.maps.offline.OfflineRegion.OfflineRegionUpdateMetadataCallback
            public void onError(final String str) {
                OfflineRegion.this.handler.post(new Runnable() { // from class: com.mappls.sdk.maps.offline.OfflineRegion.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        offlineRegionUpdateMetadataCallback.onError(str);
                    }
                });
            }
        });
    }
}
