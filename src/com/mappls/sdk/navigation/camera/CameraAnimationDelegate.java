package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraUpdate;

/* JADX INFO: loaded from: classes4.dex */
class CameraAnimationDelegate {
    private final MapplsMap mapplsMap;

    CameraAnimationDelegate(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
    }

    void render(NavigationCameraUpdate navigationCameraUpdate, int i, MapplsMap.CancelableCallback cancelableCallback) {
        CameraUpdateMode mode = navigationCameraUpdate.getMode();
        CameraUpdate cameraUpdate = navigationCameraUpdate.getCameraUpdate();
        if (mode == CameraUpdateMode.OVERRIDE) {
            this.mapplsMap.getLocationComponent().setCameraMode(8);
            this.mapplsMap.animateCamera(cameraUpdate, i, cancelableCallback);
        } else {
            if (isTracking()) {
                return;
            }
            this.mapplsMap.animateCamera(cameraUpdate, i, cancelableCallback);
        }
    }

    private boolean isTracking() {
        return this.mapplsMap.getLocationComponent().getCameraMode() != 8;
    }
}
