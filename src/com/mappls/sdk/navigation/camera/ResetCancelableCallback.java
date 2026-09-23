package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes4.dex */
class ResetCancelableCallback implements MapplsMap.CancelableCallback {
    private final NavigationCamera camera;

    ResetCancelableCallback(NavigationCamera navigationCamera) {
        this.camera = navigationCamera;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onCancel() {
        this.camera.updateIsResetting(false);
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onFinish() {
        this.camera.updateIsResetting(false);
    }
}
