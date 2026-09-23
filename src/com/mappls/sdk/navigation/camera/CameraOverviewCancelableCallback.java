package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraUpdate;

/* JADX INFO: loaded from: classes4.dex */
class CameraOverviewCancelableCallback implements MapplsMap.CancelableCallback {
    private static final int OVERVIEW_UPDATE_DURATION_IN_MILLIS = 750;
    private MapplsMap mapplsMap;
    private CameraUpdate overviewUpdate;

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onCancel() {
    }

    CameraOverviewCancelableCallback(CameraUpdate cameraUpdate, MapplsMap mapplsMap) {
        this.overviewUpdate = cameraUpdate;
        this.mapplsMap = mapplsMap;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.CancelableCallback
    public void onFinish() {
        this.mapplsMap.animateCamera(this.overviewUpdate, OVERVIEW_UPDATE_DURATION_IN_MILLIS);
    }
}
