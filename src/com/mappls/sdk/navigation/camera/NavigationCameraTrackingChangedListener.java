package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.location.OnCameraTrackingChangedListener;

/* JADX INFO: loaded from: classes4.dex */
class NavigationCameraTrackingChangedListener implements OnCameraTrackingChangedListener {
    private final NavigationCamera camera;

    NavigationCameraTrackingChangedListener(NavigationCamera navigationCamera) {
        this.camera = navigationCamera;
    }

    @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
    public void onCameraTrackingDismissed() {
        this.camera.updateCameraTrackingMode(2);
    }

    @Override // com.mappls.sdk.maps.location.OnCameraTrackingChangedListener
    public void onCameraTrackingChanged(int i) {
        Integer numFindTrackingModeFor = this.camera.findTrackingModeFor(i);
        if (numFindTrackingModeFor != null) {
            this.camera.updateCameraTrackingMode(numFindTrackingModeFor.intValue());
        }
    }
}
