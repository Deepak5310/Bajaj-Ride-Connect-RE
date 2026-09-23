package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.location.OnLocationCameraTransitionListener;

/* JADX INFO: loaded from: classes4.dex */
class NavigationCameraTransitionListener implements OnLocationCameraTransitionListener {
    private final NavigationCamera camera;

    NavigationCameraTransitionListener(NavigationCamera navigationCamera) {
        this.camera = navigationCamera;
    }

    @Override // com.mappls.sdk.maps.location.OnLocationCameraTransitionListener
    public void onLocationCameraTransitionFinished(int i) {
        this.camera.updateTransitionListenersFinished(i);
    }

    @Override // com.mappls.sdk.maps.location.OnLocationCameraTransitionListener
    public void onLocationCameraTransitionCanceled(int i) {
        this.camera.updateTransitionListenersCancelled(i);
        this.camera.updateIsResetting(false);
    }
}
