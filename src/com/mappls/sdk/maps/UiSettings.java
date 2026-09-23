package com.mappls.sdk.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.mappls.sdk.maps.attribution.AttributionView;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.widgets.CompassView;
import com.mappls.sdk.maps.widgets.LogoView;
import com.mappls.sdk.maps.widgets.indoor.FloorControllerView;

/* JADX INFO: loaded from: classes4.dex */
public final class UiSettings {
    private boolean anchorRotateOrZoomGesturesToCenterCoordinate;
    private AttributionDialogManager attributionDialogManager;
    AttributionView attributionsView;
    private double clockwiseBearing;
    CompassView compassView;
    ImageView eventView;
    FloorControllerView floorControllerView;
    private final FocalPointChangeListener focalPointChangeListener;
    LogoView logoView;
    private final MapView mapView;
    private final float pixelRatio;
    private final Projection projection;
    private PointF userProvidedFocalPoint;
    private final int[] compassMargins = new int[4];
    private final int[] floorControlMargins = new int[4];
    private final int[] attributionsMargins = new int[4];
    private final int[] logoMargins = new int[4];
    private int logoSize = 0;
    private final int[] eventMargins = new int[4];
    private boolean rotateGesturesEnabled = true;
    private boolean tiltGesturesEnabled = true;
    private boolean zoomGesturesEnabled = true;
    private boolean scrollGesturesEnabled = true;
    private boolean horizontalScrollGesturesEnabled = true;
    private boolean doubleTapGesturesEnabled = true;
    private boolean quickZoomGesturesEnabled = true;
    private boolean scaleVelocityAnimationEnabled = true;
    private boolean rotateVelocityAnimationEnabled = true;
    private boolean flingVelocityAnimationEnabled = true;
    private boolean increaseRotateThresholdWhenScaling = true;
    private boolean disableRotateWhenScaling = true;
    private boolean increaseScaleThresholdWhenRotating = true;
    private float zoomRate = 1.0f;
    private boolean deselectMarkersOnTap = true;
    boolean isCompassInitialized = false;
    boolean isLayerControlInitialized = false;
    boolean isAttributionInitialized = false;
    boolean isLogoInitialized = false;
    boolean isEventInitialized = false;
    private boolean enableLogoClick = true;

    UiSettings(Projection projection, FocalPointChangeListener focalPointChangeListener, float f, MapView mapView) {
        this.projection = projection;
        this.focalPointChangeListener = focalPointChangeListener;
        this.pixelRatio = f;
        this.mapView = mapView;
    }

    void initialise(Context context, MapplsMapOptions mapplsMapOptions) {
        Resources resources = context.getResources();
        initialiseGestures(mapplsMapOptions);
        if (mapplsMapOptions.getCompassEnabled()) {
            initialiseCompass(mapplsMapOptions, resources);
        }
        initialiseLogo(mapplsMapOptions, resources);
        initialiseEventView(mapplsMapOptions, resources);
        if (mapplsMapOptions.getLayerControlEnabled()) {
            initialiseLayerControl(context, mapplsMapOptions);
        }
        if (mapplsMapOptions.getAttributionEnabled()) {
            initialiseAttribution(context, mapplsMapOptions);
        }
    }

    public boolean isEnableLogoClick() {
        return this.enableLogoClick;
    }

    public void enableLogoClick(boolean z) {
        this.enableLogoClick = z;
    }

    void onSaveInstanceState(Bundle bundle) {
        saveGestures(bundle);
        saveCompass(bundle);
        saveLogo(bundle);
        saveEvent(bundle);
        saveLayerControl(bundle);
        saveAttribution(bundle);
        saveDeselectMarkersOnTap(bundle);
        saveFocalPoint(bundle);
    }

    void onRestoreInstanceState(Bundle bundle) {
        restoreGestures(bundle);
        restoreCompass(bundle);
        restoreLogo(bundle);
        restoreEvent(bundle);
        restoreLayerControl(bundle);
        restoreAttribution(bundle);
        restoreDeselectMarkersOnTap(bundle);
        restoreFocalPoint(bundle);
    }

    private void initialiseGestures(MapplsMapOptions mapplsMapOptions) {
        setZoomGesturesEnabled(mapplsMapOptions.getZoomGesturesEnabled());
        setScrollGesturesEnabled(mapplsMapOptions.getScrollGesturesEnabled());
        setHorizontalScrollGesturesEnabled(mapplsMapOptions.getHorizontalScrollGesturesEnabled());
        setRotateGesturesEnabled(mapplsMapOptions.getRotateGesturesEnabled());
        setTiltGesturesEnabled(mapplsMapOptions.getTiltGesturesEnabled());
        setDoubleTapGesturesEnabled(mapplsMapOptions.getDoubleTapGesturesEnabled());
        setQuickZoomGesturesEnabled(mapplsMapOptions.getQuickZoomGesturesEnabled());
    }

    private void saveGestures(Bundle bundle) {
        bundle.putBoolean(MapplsConstants.STATE_HORIZONAL_SCROLL_ENABLED, isHorizontalScrollGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_ZOOM_ENABLED, isZoomGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_SCROLL_ENABLED, isScrollGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_ROTATE_ENABLED, isRotateGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_TILT_ENABLED, isTiltGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_DOUBLE_TAP_ENABLED, isDoubleTapGesturesEnabled());
        bundle.putBoolean(MapplsConstants.STATE_SCALE_ANIMATION_ENABLED, isScaleVelocityAnimationEnabled());
        bundle.putBoolean(MapplsConstants.STATE_ROTATE_ANIMATION_ENABLED, isRotateVelocityAnimationEnabled());
        bundle.putBoolean(MapplsConstants.STATE_FLING_ANIMATION_ENABLED, isFlingVelocityAnimationEnabled());
        bundle.putBoolean(MapplsConstants.STATE_INCREASE_ROTATE_THRESHOLD, isIncreaseRotateThresholdWhenScaling());
        bundle.putBoolean(MapplsConstants.STATE_DISABLE_ROTATE_WHEN_SCALING, isDisableRotateWhenScaling());
        bundle.putBoolean(MapplsConstants.STATE_INCREASE_SCALE_THRESHOLD, isIncreaseScaleThresholdWhenRotating());
        bundle.putBoolean(MapplsConstants.STATE_QUICK_ZOOM_ENABLED, isQuickZoomGesturesEnabled());
        bundle.putFloat(MapplsConstants.STATE_ZOOM_RATE, getZoomRate());
    }

    private void restoreGestures(Bundle bundle) {
        setHorizontalScrollGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_HORIZONAL_SCROLL_ENABLED));
        setZoomGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_ZOOM_ENABLED));
        setScrollGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_SCROLL_ENABLED));
        setRotateGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_ROTATE_ENABLED));
        setTiltGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_TILT_ENABLED));
        setDoubleTapGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_DOUBLE_TAP_ENABLED));
        setScaleVelocityAnimationEnabled(bundle.getBoolean(MapplsConstants.STATE_SCALE_ANIMATION_ENABLED));
        setRotateVelocityAnimationEnabled(bundle.getBoolean(MapplsConstants.STATE_ROTATE_ANIMATION_ENABLED));
        setFlingVelocityAnimationEnabled(bundle.getBoolean(MapplsConstants.STATE_FLING_ANIMATION_ENABLED));
        setIncreaseRotateThresholdWhenScaling(bundle.getBoolean(MapplsConstants.STATE_INCREASE_ROTATE_THRESHOLD));
        setDisableRotateWhenScaling(bundle.getBoolean(MapplsConstants.STATE_DISABLE_ROTATE_WHEN_SCALING));
        setIncreaseScaleThresholdWhenRotating(bundle.getBoolean(MapplsConstants.STATE_INCREASE_SCALE_THRESHOLD));
        setQuickZoomGesturesEnabled(bundle.getBoolean(MapplsConstants.STATE_QUICK_ZOOM_ENABLED));
        setZoomRate(bundle.getFloat(MapplsConstants.STATE_ZOOM_RATE, 1.0f));
    }

    private void initialiseCompass(MapplsMapOptions mapplsMapOptions, Resources resources) {
        this.isCompassInitialized = true;
        CompassView compassViewInitialiseCompassView = this.mapView.initialiseCompassView();
        this.compassView = compassViewInitialiseCompassView;
        compassViewInitialiseCompassView.setBackgroundDrawable(ResourcesCompat.getDrawable(resources, R.drawable.mappls_maps_compass_bg, null));
        int iDpToPx = dpToPx(8.0f, resources);
        int iDpToPx2 = dpToPx(8.0f, resources);
        this.compassView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        ViewCompat.setElevation(this.compassView, iDpToPx2);
        setCompassEnabled(mapplsMapOptions.getCompassEnabled());
        setCompassGravity(mapplsMapOptions.getCompassGravity());
        int[] compassMargins = mapplsMapOptions.getCompassMargins();
        if (compassMargins != null) {
            setCompassMargins(compassMargins[0], compassMargins[1], compassMargins[2], compassMargins[3]);
        } else {
            int dimension = (int) resources.getDimension(R.dimen.mappls_maps_four_dp);
            setCompassMargins(dimension, dimension, dimension, dimension);
        }
        setCompassFadeFacingNorth(mapplsMapOptions.getCompassFadeFacingNorth());
        if (mapplsMapOptions.getCompassImage() == null) {
            mapplsMapOptions.compassImage(ResourcesCompat.getDrawable(resources, R.drawable.mappls_maps_compass_icon, null));
        }
        setCompassImage(mapplsMapOptions.getCompassImage());
    }

    public int dpToPx(float f, Resources resources) {
        return (int) (f * resources.getDisplayMetrics().density);
    }

    private void saveCompass(Bundle bundle) {
        bundle.putBoolean(MapplsConstants.STATE_COMPASS_ENABLED, isCompassEnabled());
        bundle.putInt(MapplsConstants.STATE_COMPASS_GRAVITY, getCompassGravity());
        bundle.putInt(MapplsConstants.STATE_COMPASS_MARGIN_LEFT, getCompassMarginLeft());
        bundle.putInt(MapplsConstants.STATE_COMPASS_MARGIN_TOP, getCompassMarginTop());
        bundle.putInt(MapplsConstants.STATE_COMPASS_MARGIN_BOTTOM, getCompassMarginBottom());
        bundle.putInt(MapplsConstants.STATE_COMPASS_MARGIN_RIGHT, getCompassMarginRight());
        bundle.putBoolean(MapplsConstants.STATE_COMPASS_FADE_WHEN_FACING_NORTH, isCompassFadeWhenFacingNorth());
        bundle.putByteArray(MapplsConstants.STATE_COMPASS_IMAGE_BITMAP, BitmapUtils.getByteArrayFromDrawable(getCompassImage()));
    }

    private void restoreCompass(Bundle bundle) {
        if (bundle.getBoolean(MapplsConstants.STATE_COMPASS_ENABLED) && !this.isCompassInitialized) {
            this.compassView = this.mapView.initialiseCompassView();
            this.isCompassInitialized = true;
        }
        setCompassEnabled(bundle.getBoolean(MapplsConstants.STATE_COMPASS_ENABLED));
        setCompassGravity(bundle.getInt(MapplsConstants.STATE_COMPASS_GRAVITY));
        setCompassMargins(bundle.getInt(MapplsConstants.STATE_COMPASS_MARGIN_LEFT), bundle.getInt(MapplsConstants.STATE_COMPASS_MARGIN_TOP), bundle.getInt(MapplsConstants.STATE_COMPASS_MARGIN_RIGHT), bundle.getInt(MapplsConstants.STATE_COMPASS_MARGIN_BOTTOM));
        setCompassFadeFacingNorth(bundle.getBoolean(MapplsConstants.STATE_COMPASS_FADE_WHEN_FACING_NORTH));
        setCompassImage(BitmapUtils.getDrawableFromByteArray(this.mapView.getContext(), bundle.getByteArray(MapplsConstants.STATE_COMPASS_IMAGE_BITMAP)));
    }

    private void initialiseLogo(MapplsMapOptions mapplsMapOptions, Resources resources) {
        this.isLogoInitialized = true;
        this.logoView = this.mapView.initialiseLogoView();
        setLogoEnabled(mapplsMapOptions.getLogoEnabled());
        setLogoGravity(mapplsMapOptions.getLogoGravity());
        setLogoMargins(resources, mapplsMapOptions.getLogoMargins());
    }

    private void initialiseEventView(MapplsMapOptions mapplsMapOptions, Resources resources) {
        this.isEventInitialized = true;
        this.eventView = this.mapView.initialiseEventView();
        setEventGravity(mapplsMapOptions.getEventGravity());
        setEventMargins(resources, mapplsMapOptions.getEventMargins());
    }

    public void setEventGravity(int i) {
        setWidgetGravity(this.eventView, i);
    }

    private void setLogoMargins(Resources resources, int[] iArr) {
        if (iArr != null) {
            setLogoMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            int dimension = (int) resources.getDimension(R.dimen.mappls_maps_four_dp);
            setLogoMargins(dimension, dimension, dimension, dimension);
        }
    }

    private void setEventMargins(Resources resources, int[] iArr) {
        if (iArr != null) {
            setEventMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            int dimension = (int) resources.getDimension(R.dimen.mappls_maps_four_dp);
            setEventMargins(dimension, dimension, dimension, dimension);
        }
    }

    private void saveLogo(Bundle bundle) {
        bundle.putInt(MapplsConstants.STATE_LOGO_GRAVITY, getLogoGravity());
        bundle.putInt(MapplsConstants.STATE_LOGO_MARGIN_LEFT, getLogoMarginLeft());
        bundle.putInt(MapplsConstants.STATE_LOGO_MARGIN_TOP, getLogoMarginTop());
        bundle.putInt(MapplsConstants.STATE_LOGO_MARGIN_RIGHT, getLogoMarginRight());
        bundle.putInt(MapplsConstants.STATE_LOGO_MARGIN_BOTTOM, getLogoMarginBottom());
        bundle.putBoolean(MapplsConstants.STATE_LOGO_ENABLED, isLogoEnabled());
        bundle.putInt(MapplsConstants.STATE_LOGO_SIZE, getLogoSize());
    }

    private void saveEvent(Bundle bundle) {
        bundle.putInt(MapplsConstants.STATE_EVENT_GRAVITY, getEventGravity());
        bundle.putInt(MapplsConstants.STATE_EVENT_MARGIN_LEFT, getEventMarginLeft());
        bundle.putInt(MapplsConstants.STATE_EVENT_MARGIN_TOP, getEventMarginTop());
        bundle.putInt(MapplsConstants.STATE_EVENT_MARGIN_RIGHT, getEventMarginRight());
        bundle.putInt(MapplsConstants.STATE_EVENT_MARGIN_BOTTOM, getEventMarginBottom());
    }

    private void restoreLogo(Bundle bundle) {
        if (bundle.getBoolean(MapplsConstants.STATE_LOGO_ENABLED) && !this.isLogoInitialized) {
            this.logoView = this.mapView.initialiseLogoView();
            this.isLogoInitialized = true;
        }
        setLogoEnabled(bundle.getBoolean(MapplsConstants.STATE_LOGO_ENABLED));
        setLogoGravity(bundle.getInt(MapplsConstants.STATE_LOGO_GRAVITY));
        setLogoMargins(bundle.getInt(MapplsConstants.STATE_LOGO_MARGIN_LEFT), bundle.getInt(MapplsConstants.STATE_LOGO_MARGIN_TOP), bundle.getInt(MapplsConstants.STATE_LOGO_MARGIN_RIGHT), bundle.getInt(MapplsConstants.STATE_LOGO_MARGIN_BOTTOM));
    }

    private void restoreEvent(Bundle bundle) {
        if (!this.isEventInitialized) {
            this.eventView = this.mapView.initialiseEventView();
            this.isEventInitialized = true;
        }
        setEventGravity(bundle.getInt(MapplsConstants.STATE_EVENT_GRAVITY));
        setEventMargins(bundle.getInt(MapplsConstants.STATE_EVENT_MARGIN_LEFT), bundle.getInt(MapplsConstants.STATE_EVENT_MARGIN_TOP), bundle.getInt(MapplsConstants.STATE_EVENT_MARGIN_RIGHT), bundle.getInt(MapplsConstants.STATE_EVENT_MARGIN_BOTTOM));
    }

    private void initialiseLayerControl(Context context, MapplsMapOptions mapplsMapOptions) {
        this.isLayerControlInitialized = true;
        this.floorControllerView = this.mapView.initialiseLayerControlView();
        setLayerControlEnabled(mapplsMapOptions.getLayerControlEnabled());
        setLayerControlGravity(mapplsMapOptions.getLayerControlGravity());
        setLayerControlMargins(context, mapplsMapOptions.getLayerControlMargins());
    }

    private void setLayerControlMargins(Context context, int[] iArr) {
        if (iArr != null) {
            setLayerControlMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
            return;
        }
        Resources resources = context.getResources();
        int dimension = (int) resources.getDimension(R.dimen.mappls_maps_four_dp);
        setLayerControlMargins((int) resources.getDimension(R.dimen.mappls_maps_ninety_two_dp), dimension, dimension, dimension);
    }

    private void saveLayerControl(Bundle bundle) {
        bundle.putInt(MapplsConstants.STATE_LAYER_CONTROL_GRAVITY, getLayerControlGravity());
        bundle.putInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_LEFT, getLayerControlMarginLeft());
        bundle.putInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_TOP, getLayerControlMarginTop());
        bundle.putInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_RIGHT, getLayerControlMarginRight());
        bundle.putInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_BOTTOM, getLayerControlMarginBottom());
        bundle.putBoolean(MapplsConstants.STATE_LAYER_CONTROL_ENABLED, isLayerControlEnabled());
    }

    private void restoreLayerControl(Bundle bundle) {
        if (bundle.getBoolean(MapplsConstants.STATE_LAYER_CONTROL_ENABLED) && !this.isLayerControlInitialized) {
            this.floorControllerView = this.mapView.initialiseLayerControlView();
            this.isLayerControlInitialized = true;
        }
        setLayerControlEnabled(bundle.getBoolean(MapplsConstants.STATE_LAYER_CONTROL_ENABLED));
        setLayerControlGravity(bundle.getInt(MapplsConstants.STATE_LAYER_CONTROL_GRAVITY));
        setLayerControlMargins(bundle.getInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_LEFT), bundle.getInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_TOP), bundle.getInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_RIGHT), bundle.getInt(MapplsConstants.STATE_LAYER_CONTROL_MARGIN_BOTTOM));
    }

    private void initialiseAttribution(Context context, MapplsMapOptions mapplsMapOptions) {
        this.isAttributionInitialized = true;
        this.attributionsView = this.mapView.initialiseAttributionView();
        setAttributionEnabled(mapplsMapOptions.getAttributionEnabled());
        setAttributionGravity(mapplsMapOptions.getAttributionGravity());
        setAttributionMargins(context, mapplsMapOptions.getAttributionMargins());
    }

    private void setAttributionMargins(Context context, int[] iArr) {
        if (iArr != null) {
            setAttributionMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
            return;
        }
        Resources resources = context.getResources();
        int dimension = (int) resources.getDimension(R.dimen.mappls_maps_four_dp);
        setAttributionMargins((int) resources.getDimension(R.dimen.mappls_maps_ninety_two_dp), dimension, dimension, dimension);
    }

    private void saveAttribution(Bundle bundle) {
        bundle.putInt(MapplsConstants.STATE_ATTRIBUTION_GRAVITY, getAttributionGravity());
        bundle.putInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_LEFT, getAttributionMarginLeft());
        bundle.putInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_TOP, getAttributionMarginTop());
        bundle.putInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_RIGHT, getAttributionMarginRight());
        bundle.putInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_BOTTOM, getAttributionMarginBottom());
        bundle.putBoolean(MapplsConstants.STATE_ATTRIBUTION_ENABLED, isAttributionEnabled());
    }

    private void restoreAttribution(Bundle bundle) {
        if (bundle.getBoolean(MapplsConstants.STATE_ATTRIBUTION_ENABLED) && !this.isAttributionInitialized) {
            this.attributionsView = this.mapView.initialiseAttributionView();
            this.isAttributionInitialized = true;
        }
        setAttributionEnabled(bundle.getBoolean(MapplsConstants.STATE_ATTRIBUTION_ENABLED));
        setAttributionGravity(bundle.getInt(MapplsConstants.STATE_ATTRIBUTION_GRAVITY));
        setAttributionMargins(bundle.getInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_LEFT), bundle.getInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_TOP), bundle.getInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_RIGHT), bundle.getInt(MapplsConstants.STATE_ATTRIBUTION_MARGIN_BOTTOM));
    }

    public void setCompassEnabled(boolean z) {
        if (z && !this.isCompassInitialized) {
            initialiseCompass(this.mapView.mapplsMapOptions, this.mapView.getContext().getResources());
        }
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.setEnabled(z);
            this.compassView.update(this.clockwiseBearing);
        }
    }

    public boolean isCompassEnabled() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.isEnabled();
        }
        return false;
    }

    public void setCompassGravity(int i) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            setWidgetGravity(compassView, i);
        }
    }

    public void setCompassFadeFacingNorth(boolean z) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.fadeCompassViewFacingNorth(z);
        }
    }

    public void setCompassImage(Drawable drawable) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.setCompassImage(drawable);
        }
    }

    public boolean isCompassFadeWhenFacingNorth() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.isFadeCompassViewFacingNorth();
        }
        return false;
    }

    public int getCompassGravity() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return ((FrameLayout.LayoutParams) compassView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setCompassMargins(int i, int i2, int i3, int i4) {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            setWidgetMargins(compassView, this.compassMargins, i, i2, i3, i4);
        }
    }

    public int getCompassMarginLeft() {
        return this.compassMargins[0];
    }

    public int getCompassMarginTop() {
        return this.compassMargins[1];
    }

    public int getCompassMarginRight() {
        return this.compassMargins[2];
    }

    public int getCompassMarginBottom() {
        return this.compassMargins[3];
    }

    public Drawable getCompassImage() {
        CompassView compassView = this.compassView;
        if (compassView != null) {
            return compassView.getCompassImage();
        }
        return null;
    }

    void update(CameraPosition cameraPosition) {
        double d = -cameraPosition.bearing;
        this.clockwiseBearing = d;
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.update(d);
        }
    }

    public void setLogoEnabled(boolean z) {
        if (z && !this.isLogoInitialized) {
            initialiseLogo(this.mapView.mapplsMapOptions, this.mapView.getContext().getResources());
        }
        LogoView logoView = this.logoView;
        if (logoView != null) {
            logoView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isLogoEnabled() {
        LogoView logoView = this.logoView;
        return logoView != null && logoView.getVisibility() == 0;
    }

    public int getLogoSize() {
        return this.logoSize;
    }

    public void setLogoGravity(int i) {
        LogoView logoView = this.logoView;
        if (logoView != null) {
            setWidgetGravity(logoView, i);
        }
    }

    public int getLogoGravity() {
        LogoView logoView = this.logoView;
        if (logoView != null) {
            return ((FrameLayout.LayoutParams) logoView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public int getEventGravity() {
        ImageView imageView = this.eventView;
        if (imageView != null) {
            return ((FrameLayout.LayoutParams) imageView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setLogoMargins(int i, int i2, int i3, int i4) {
        LogoView logoView = this.logoView;
        if (logoView != null) {
            setWidgetMargins(logoView, this.logoMargins, i, i2, i3, i4);
        }
    }

    public void setEventMargins(int i, int i2, int i3, int i4) {
        ImageView imageView = this.eventView;
        if (imageView != null) {
            setWidgetMargins(imageView, this.eventMargins, i, i2, i3, i4);
        }
    }

    public int getLogoMarginLeft() {
        return this.logoMargins[0];
    }

    public int getLogoMarginTop() {
        return this.logoMargins[1];
    }

    public int getLogoMarginRight() {
        return this.logoMargins[2];
    }

    public int getLogoMarginBottom() {
        return this.logoMargins[3];
    }

    public int getEventMarginLeft() {
        return this.eventMargins[0];
    }

    public int getEventMarginTop() {
        return this.eventMargins[1];
    }

    public int getEventMarginRight() {
        return this.eventMargins[2];
    }

    public int getEventMarginBottom() {
        return this.eventMargins[3];
    }

    public void setLayerControlEnabled(boolean z) {
        if (z && !this.isLayerControlInitialized) {
            initialiseLayerControl(this.mapView.getContext(), this.mapView.mapplsMapOptions);
        }
        FloorControllerView floorControllerView = this.floorControllerView;
        if (floorControllerView != null) {
            floorControllerView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isLayerControlEnabled() {
        FloorControllerView floorControllerView = this.floorControllerView;
        return floorControllerView != null && floorControllerView.getVisibility() == 0;
    }

    public void setLayerControlGravity(int i) {
        FloorControllerView floorControllerView = this.floorControllerView;
        if (floorControllerView != null) {
            setWidgetGravity(floorControllerView, i);
        }
    }

    public int getLayerControlGravity() {
        FloorControllerView floorControllerView = this.floorControllerView;
        if (floorControllerView != null) {
            return ((FrameLayout.LayoutParams) floorControllerView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setLayerControlMargins(int i, int i2, int i3, int i4) {
        FloorControllerView floorControllerView = this.floorControllerView;
        if (floorControllerView != null) {
            setWidgetMargins(floorControllerView, this.floorControlMargins, i, i2, i3, i4);
        }
    }

    public int getLayerControlMarginLeft() {
        return this.floorControlMargins[0];
    }

    public int getLayerControlMarginTop() {
        return this.floorControlMargins[1];
    }

    public int getLayerControlMarginRight() {
        return this.floorControlMargins[2];
    }

    public int getLayerControlMarginBottom() {
        return this.floorControlMargins[3];
    }

    public void setAttributionEnabled(boolean z) {
        if (z && !this.isAttributionInitialized) {
            initialiseAttribution(this.mapView.getContext(), this.mapView.mapplsMapOptions);
        }
        AttributionView attributionView = this.attributionsView;
        if (attributionView != null) {
            attributionView.setVisibility(z ? 0 : 8);
        }
    }

    public boolean isAttributionEnabled() {
        AttributionView attributionView = this.attributionsView;
        return attributionView != null && attributionView.getVisibility() == 0;
    }

    public void setAttributionDialogManager(AttributionDialogManager attributionDialogManager) {
        this.attributionDialogManager = attributionDialogManager;
    }

    public AttributionDialogManager getAttributionDialogManager() {
        return this.attributionDialogManager;
    }

    public void setAttributionGravity(int i) {
        AttributionView attributionView = this.attributionsView;
        if (attributionView != null) {
            setWidgetGravity(attributionView, i);
        }
    }

    public int getAttributionGravity() {
        AttributionView attributionView = this.attributionsView;
        if (attributionView != null) {
            return ((FrameLayout.LayoutParams) attributionView.getLayoutParams()).gravity;
        }
        return -1;
    }

    public void setAttributionMargins(int i, int i2, int i3, int i4) {
        AttributionView attributionView = this.attributionsView;
        if (attributionView != null) {
            setWidgetMargins(attributionView, this.attributionsMargins, i, i2, i3, i4);
        }
    }

    public int getAttributionMarginLeft() {
        return this.attributionsMargins[0];
    }

    public int getAttributionMarginTop() {
        return this.attributionsMargins[1];
    }

    public int getAttributionMarginRight() {
        return this.attributionsMargins[2];
    }

    public int getAttributionMarginBottom() {
        return this.attributionsMargins[3];
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.rotateGesturesEnabled = z;
    }

    public boolean isRotateGesturesEnabled() {
        return this.rotateGesturesEnabled;
    }

    public void setTiltGesturesEnabled(boolean z) {
        this.tiltGesturesEnabled = z;
    }

    public boolean isTiltGesturesEnabled() {
        return this.tiltGesturesEnabled;
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.zoomGesturesEnabled = z;
    }

    public boolean isZoomGesturesEnabled() {
        return this.zoomGesturesEnabled;
    }

    public void setDoubleTapGesturesEnabled(boolean z) {
        this.doubleTapGesturesEnabled = z;
    }

    public boolean isDoubleTapGesturesEnabled() {
        return this.doubleTapGesturesEnabled;
    }

    public boolean isQuickZoomGesturesEnabled() {
        return this.quickZoomGesturesEnabled;
    }

    public void setQuickZoomGesturesEnabled(boolean z) {
        this.quickZoomGesturesEnabled = z;
    }

    public float getZoomRate() {
        return this.zoomRate;
    }

    public void setZoomRate(float f) {
        this.zoomRate = f;
    }

    private void restoreDeselectMarkersOnTap(Bundle bundle) {
        setDeselectMarkersOnTap(bundle.getBoolean(MapplsConstants.STATE_DESELECT_MARKER_ON_TAP));
    }

    private void saveDeselectMarkersOnTap(Bundle bundle) {
        bundle.putBoolean(MapplsConstants.STATE_DESELECT_MARKER_ON_TAP, isDeselectMarkersOnTap());
    }

    public boolean isDeselectMarkersOnTap() {
        return this.deselectMarkersOnTap;
    }

    public void setDeselectMarkersOnTap(boolean z) {
        this.deselectMarkersOnTap = z;
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.scrollGesturesEnabled = z;
    }

    public boolean isScrollGesturesEnabled() {
        return this.scrollGesturesEnabled;
    }

    public void setHorizontalScrollGesturesEnabled(boolean z) {
        this.horizontalScrollGesturesEnabled = z;
    }

    public boolean isHorizontalScrollGesturesEnabled() {
        return this.horizontalScrollGesturesEnabled;
    }

    public boolean isScaleVelocityAnimationEnabled() {
        return this.scaleVelocityAnimationEnabled;
    }

    public void setScaleVelocityAnimationEnabled(boolean z) {
        this.scaleVelocityAnimationEnabled = z;
    }

    public boolean isRotateVelocityAnimationEnabled() {
        return this.rotateVelocityAnimationEnabled;
    }

    public void setRotateVelocityAnimationEnabled(boolean z) {
        this.rotateVelocityAnimationEnabled = z;
    }

    public boolean isFlingVelocityAnimationEnabled() {
        return this.flingVelocityAnimationEnabled;
    }

    public void setFlingVelocityAnimationEnabled(boolean z) {
        this.flingVelocityAnimationEnabled = z;
    }

    public void setAllVelocityAnimationsEnabled(boolean z) {
        setScaleVelocityAnimationEnabled(z);
        setRotateVelocityAnimationEnabled(z);
        setFlingVelocityAnimationEnabled(z);
    }

    @Deprecated
    public boolean isIncreaseRotateThresholdWhenScaling() {
        return this.increaseRotateThresholdWhenScaling;
    }

    @Deprecated
    public void setIncreaseRotateThresholdWhenScaling(boolean z) {
        this.increaseRotateThresholdWhenScaling = z;
    }

    public boolean isDisableRotateWhenScaling() {
        return this.disableRotateWhenScaling;
    }

    public void setDisableRotateWhenScaling(boolean z) {
        this.disableRotateWhenScaling = z;
    }

    public boolean isIncreaseScaleThresholdWhenRotating() {
        return this.increaseScaleThresholdWhenRotating;
    }

    public void setIncreaseScaleThresholdWhenRotating(boolean z) {
        this.increaseScaleThresholdWhenRotating = z;
    }

    public boolean isAnchorRotateOrZoomGesturesToCenterCoordinate() {
        return this.anchorRotateOrZoomGesturesToCenterCoordinate;
    }

    public void setAnchorRotateOrZoomGesturesToCenterCoordinate(boolean z) {
        this.anchorRotateOrZoomGesturesToCenterCoordinate = z;
    }

    public void setAllGesturesEnabled(boolean z) {
        setScrollGesturesEnabled(z);
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setDoubleTapGesturesEnabled(z);
        setQuickZoomGesturesEnabled(z);
    }

    public boolean areAllGesturesEnabled() {
        return this.rotateGesturesEnabled && this.tiltGesturesEnabled && this.zoomGesturesEnabled && this.scrollGesturesEnabled && this.doubleTapGesturesEnabled && this.quickZoomGesturesEnabled;
    }

    private void saveFocalPoint(Bundle bundle) {
        bundle.putParcelable(MapplsConstants.STATE_USER_FOCAL_POINT, getFocalPoint());
    }

    private void restoreFocalPoint(Bundle bundle) {
        PointF pointF = (PointF) bundle.getParcelable(MapplsConstants.STATE_USER_FOCAL_POINT);
        if (pointF != null) {
            setFocalPoint(pointF);
        }
    }

    public void setFocalPoint(PointF pointF) {
        this.userProvidedFocalPoint = pointF;
        this.focalPointChangeListener.onFocalPointChanged(pointF);
    }

    public PointF getFocalPoint() {
        return this.userProvidedFocalPoint;
    }

    public float getHeight() {
        return this.projection.getHeight();
    }

    public float getWidth() {
        return this.projection.getWidth();
    }

    float getPixelRatio() {
        return this.pixelRatio;
    }

    public void invalidate() {
        setLogoMargins(getLogoMarginLeft(), getLogoMarginTop(), getLogoMarginRight(), getLogoMarginBottom());
        setCompassEnabled(isCompassEnabled());
        setCompassMargins(getCompassMarginLeft(), getCompassMarginTop(), getCompassMarginRight(), getCompassMarginBottom());
        setLayerControlMargins(getLayerControlMarginLeft(), getLayerControlMarginTop(), getLayerControlMarginRight(), getLayerControlMarginBottom());
        setAttributionMargins(getAttributionMarginLeft(), getAttributionMarginTop(), getAttributionMarginRight(), getAttributionMarginBottom());
    }

    private void setWidgetGravity(View view, int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.gravity = i;
        view.setLayoutParams(layoutParams);
    }

    private void setWidgetMargins(View view, int[] iArr, int i, int i2, int i3, int i4) {
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i3);
        view.setLayoutParams(layoutParams);
    }

    AttributionView getAttributionsView() {
        return this.attributionsView;
    }

    FloorControllerView getLayerControl() {
        return this.floorControllerView;
    }
}
