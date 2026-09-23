package com.mappls.sdk.maps.rctmgl.components.camera;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraUpdate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class CameraUpdateItem implements RunnableFuture<Void> {
    private boolean isCameraActionCancelled;
    private boolean isCameraActionFinished;
    private MapplsMap.CancelableCallback mCallback;
    private int mCameraMode;
    private CameraUpdate mCameraUpdate;
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

    public CameraUpdateItem(MapplsMap mapplsMap, CameraUpdate cameraUpdate, int i, MapplsMap.CancelableCallback cancelableCallback, int i2) {
        this.mCameraUpdate = cameraUpdate;
        this.mDuration = i;
        this.mCallback = cancelableCallback;
        this.mCameraMode = i2;
        this.mMap = new WeakReference<>(mapplsMap);
    }

    public int getDuration() {
        return this.mDuration;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        int i;
        MapplsMap.CancelableCallback cancelableCallback = new MapplsMap.CancelableCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.camera.CameraUpdateItem.1
            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onCancel() {
                CameraUpdateItem.this.handleCallbackResponse(true);
            }

            @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
            public void onFinish() {
                CameraUpdateItem.this.handleCallbackResponse(false);
            }
        };
        MapplsMap mapplsMap = this.mMap.get();
        if (mapplsMap == null) {
            this.isCameraActionCancelled = true;
            return;
        }
        int i2 = this.mDuration;
        if (i2 == 0 || (i = this.mCameraMode) == 4) {
            mapplsMap.moveCamera(this.mCameraUpdate, cancelableCallback);
            return;
        }
        if (i2 < 0) {
            i2 = 300;
        }
        if (i == 1) {
            mapplsMap.animateCamera(this.mCameraUpdate, i2, cancelableCallback);
        } else if (i == 3) {
            mapplsMap.easeCamera(this.mCameraUpdate, i2, false, cancelableCallback);
        } else if (i == 2) {
            mapplsMap.easeCamera(this.mCameraUpdate, i2, true, cancelableCallback);
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
