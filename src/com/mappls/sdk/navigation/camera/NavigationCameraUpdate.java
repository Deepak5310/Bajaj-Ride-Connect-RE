package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.camera.CameraUpdate;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationCameraUpdate {
    private final CameraUpdate cameraUpdate;
    private CameraUpdateMode mode = CameraUpdateMode.DEFAULT;

    public NavigationCameraUpdate(CameraUpdate cameraUpdate) {
        this.cameraUpdate = cameraUpdate;
    }

    public void setMode(CameraUpdateMode cameraUpdateMode) {
        this.mode = cameraUpdateMode;
    }

    CameraUpdate getCameraUpdate() {
        return this.cameraUpdate;
    }

    CameraUpdateMode getMode() {
        return this.mode;
    }
}
