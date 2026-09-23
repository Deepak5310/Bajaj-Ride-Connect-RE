package com.mappls.sdk.navigation.camera;

import android.location.Location;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class DynamicCamera extends SimpleCamera {
    static final double MAX_CAMERA_ZOOM = 16.35d;
    static final double MIN_CAMERA_ZOOM = 14.0d;
    private LegStep currentStep;
    private boolean forceUpdateZoom;
    private boolean hasPassedHighAlertLevel;
    private boolean hasPassedLowAlertLevel;
    private boolean hasPassedMediumAlertLevel;
    private MapplsMap mapplsMap;
    private boolean isShutdown = false;
    private double maxCameraZoom = MAX_CAMERA_ZOOM;
    private double minCameraZoom = MIN_CAMERA_ZOOM;

    public DynamicCamera(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
    }

    @Override // com.mappls.sdk.navigation.camera.SimpleCamera, com.mappls.sdk.navigation.camera.Camera
    public double zoom(RouteInformation routeInformation) {
        if (this.isShutdown) {
            return getDefaultZoom();
        }
        if (validLocationAndProgress(routeInformation) && shouldUpdateZoom(routeInformation)) {
            return createZoom(routeInformation);
        }
        if (routeInformation.getRoute() != null) {
            return super.zoom(routeInformation);
        }
        return getDefaultZoom();
    }

    public double getMaxCameraZoom() {
        return this.maxCameraZoom;
    }

    public void setMaxCameraZoom(double d) {
        this.maxCameraZoom = d;
    }

    public double getMinCameraZoom() {
        return this.minCameraZoom;
    }

    public void setMinCameraZoom(double d) {
        this.minCameraZoom = d;
    }

    public void forceResetZoomLevel() {
        this.forceUpdateZoom = true;
    }

    public void clearMap() {
        this.isShutdown = true;
        this.mapplsMap = null;
    }

    private double createZoom(RouteInformation routeInformation) {
        CameraPosition cameraPositionCreateCameraPosition = createCameraPosition(routeInformation.getLocation(), routeInformation.getAdviseInfo());
        if (cameraPositionCreateCameraPosition == null) {
            return getDefaultZoom();
        }
        routeInformation.getAdviseInfo();
        double d = cameraPositionCreateCameraPosition.zoom;
        double d2 = this.maxCameraZoom;
        if (d > d2) {
            return d2;
        }
        double d3 = cameraPositionCreateCameraPosition.zoom;
        double d4 = this.minCameraZoom;
        return d3 < d4 ? d4 : cameraPositionCreateCameraPosition.zoom;
    }

    private CameraPosition createCameraPosition(Location location, AdviseInfo adviseInfo) {
        LegStep legStep = (LegStep) adviseInfo.getInfo();
        if (legStep != null) {
            Point pointLocation = legStep.maneuver().location();
            ArrayList arrayList = new ArrayList();
            LatLng latLng = new LatLng(location);
            LatLng latLng2 = new LatLng(pointLocation.latitude(), pointLocation.longitude());
            arrayList.add(latLng);
            arrayList.add(latLng2);
            if (arrayList.size() < 1 || latLng.equals(latLng2)) {
                return this.mapplsMap.getCameraPosition();
            }
            return this.mapplsMap.getCameraForLatLngBounds(new LatLngBounds.Builder().includes(arrayList).build(), new int[]{0, 0, 0, 0});
        }
        return this.mapplsMap.getCameraPosition();
    }

    private boolean isForceUpdate() {
        if (!this.forceUpdateZoom) {
            return false;
        }
        this.forceUpdateZoom = false;
        return true;
    }

    private boolean isNewStep(AdviseInfo adviseInfo) {
        LegStep legStep = this.currentStep;
        boolean z = legStep == null || !legStep.equals(adviseInfo.getInfo());
        this.currentStep = (LegStep) adviseInfo.getInfo();
        resetAlertLevels(z);
        return z;
    }

    private void resetAlertLevels(boolean z) {
        if (z) {
            this.hasPassedLowAlertLevel = false;
            this.hasPassedMediumAlertLevel = false;
            this.hasPassedHighAlertLevel = false;
        }
    }

    private boolean validLocationAndProgress(RouteInformation routeInformation) {
        return (routeInformation.getLocation() == null || routeInformation.getAdviseInfo() == null) ? false : true;
    }

    private boolean shouldUpdateZoom(RouteInformation routeInformation) {
        AdviseInfo adviseInfo = routeInformation.getAdviseInfo();
        return isForceUpdate() || isNewStep(adviseInfo) || isLowAlert(adviseInfo) || isMediumAlert(adviseInfo) || isHighAlert(adviseInfo);
    }

    private boolean isLowAlert(AdviseInfo adviseInfo) {
        if (!this.hasPassedLowAlertLevel) {
            double leftTime = adviseInfo.getLeftTime();
            double dDuration = ((LegStep) adviseInfo.getInfo()).duration();
            boolean z = leftTime < 125.0d;
            if (dDuration > 125.0d && z) {
                this.hasPassedLowAlertLevel = true;
                return true;
            }
        }
        return false;
    }

    private boolean isMediumAlert(AdviseInfo adviseInfo) {
        if (!this.hasPassedMediumAlertLevel) {
            double leftTime = adviseInfo.getLeftTime();
            double dDuration = ((LegStep) adviseInfo.getInfo()).duration();
            boolean z = leftTime < 70.0d;
            if (dDuration > 70.0d && z) {
                this.hasPassedMediumAlertLevel = true;
                return true;
            }
        }
        return false;
    }

    private boolean isHighAlert(AdviseInfo adviseInfo) {
        if (!this.hasPassedHighAlertLevel) {
            double leftTime = adviseInfo.getLeftTime();
            double dDuration = ((LegStep) adviseInfo.getInfo()).duration();
            boolean z = leftTime < 15.0d;
            if (dDuration > 15.0d && z) {
                this.hasPassedHighAlertLevel = true;
                return true;
            }
        }
        return false;
    }
}
