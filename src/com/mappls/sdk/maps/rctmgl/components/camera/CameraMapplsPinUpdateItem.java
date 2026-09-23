package com.mappls.sdk.maps.rctmgl.components.camera;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraMapplsPinBoundUpdate;
import com.mappls.sdk.maps.camera.CameraMapplsPinUpdate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class CameraMapplsPinUpdateItem implements RunnableFuture<Void> {
    private CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate;
    private CameraMapplsPinUpdate cameraMapplsPinUpdate;
    private boolean isCameraActionCancelled;
    private boolean isCameraActionFinished;
    private MapplsMap.CancelableCallback mCallback;
    private int mCameraMode;
    private int mDuration;
    private WeakReference<MapplsMap> mMap;

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Void get() throws ExecutionException, InterruptedException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Void get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return null;
    }

    public CameraMapplsPinUpdateItem(MapplsMap mapplsMap, CameraMapplsPinUpdate cameraMapplsPinUpdate, int i, MapplsMap.CancelableCallback cancelableCallback, int i2) {
        this.cameraMapplsPinUpdate = cameraMapplsPinUpdate;
        this.mDuration = i;
        this.mCallback = cancelableCallback;
        this.mCameraMode = i2;
        this.mMap = new WeakReference<>(mapplsMap);
    }

    public CameraMapplsPinUpdateItem(MapplsMap mapplsMap, CameraMapplsPinBoundUpdate cameraMapplsPinBoundUpdate, int i, MapplsMap.CancelableCallback cancelableCallback, int i2) {
        this.cameraMapplsPinBoundUpdate = cameraMapplsPinBoundUpdate;
        this.mDuration = i;
        this.mCallback = cancelableCallback;
        this.mCameraMode = i2;
        this.mMap = new WeakReference<>(mapplsMap);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        int i;
        MapplsMap.CancelableCallback cancelableCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.CameraMapplsPinUpdateItem.1
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                CameraMapplsPinUpdateItem.this.handleCallbackResponse(true);
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                CameraMapplsPinUpdateItem.this.handleCallbackResponse(false);
            }
        };
        MapplsMap mapplsMap = this.mMap.get();
        if (mapplsMap == null) {
            this.isCameraActionCancelled = true;
            return;
        }
        int i2 = this.mDuration;
        if (i2 == 0 || (i = this.mCameraMode) == 4) {
            CameraMapplsPinUpdate cameraMapplsPinUpdate = this.cameraMapplsPinUpdate;
            if (cameraMapplsPinUpdate != null) {
                mapplsMap.moveCamera(cameraMapplsPinUpdate, cancelableCallback);
                return;
            } else {
                mapplsMap.moveCamera(this.cameraMapplsPinBoundUpdate, cancelableCallback);
                return;
            }
        }
        if (i2 < 0) {
            i2 = 300;
        }
        if (i == 1) {
            CameraMapplsPinUpdate cameraMapplsPinUpdate2 = this.cameraMapplsPinUpdate;
            if (cameraMapplsPinUpdate2 != null) {
                mapplsMap.animateCamera(cameraMapplsPinUpdate2, i2, cancelableCallback);
                return;
            } else {
                mapplsMap.animateCamera(this.cameraMapplsPinBoundUpdate, i2, cancelableCallback);
                return;
            }
        }
        if (i == 3) {
            CameraMapplsPinUpdate cameraMapplsPinUpdate3 = this.cameraMapplsPinUpdate;
            if (cameraMapplsPinUpdate3 != null) {
                mapplsMap.easeCamera(cameraMapplsPinUpdate3, i2, false, cancelableCallback);
                return;
            } else {
                mapplsMap.easeCamera(this.cameraMapplsPinBoundUpdate, i2, cancelableCallback);
                return;
            }
        }
        if (i == 2) {
            CameraMapplsPinUpdate cameraMapplsPinUpdate4 = this.cameraMapplsPinUpdate;
            if (cameraMapplsPinUpdate4 != null) {
                mapplsMap.easeCamera(cameraMapplsPinUpdate4, i2, true, cancelableCallback);
            } else {
                mapplsMap.easeCamera(this.cameraMapplsPinBoundUpdate, i2, cancelableCallback);
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.isCameraActionCancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.isCameraActionFinished;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallbackResponse(boolean z) {
        MapplsMap.CancelableCallback cancelableCallback = this.mCallback;
        if (cancelableCallback == null) {
            return;
        }
        this.isCameraActionCancelled = z;
        this.isCameraActionFinished = !z;
        if (z) {
            cancelableCallback.onCancel();
        } else {
            cancelableCallback.onFinish();
        }
    }
}
