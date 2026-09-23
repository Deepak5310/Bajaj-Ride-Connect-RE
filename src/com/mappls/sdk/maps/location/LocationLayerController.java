package com.mappls.sdk.maps.location;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.style.expressions.Expression;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class LocationLayerController {
    private static final String TAG = "Mbgl-LocationLayerController";
    private final LayerBitmapProvider bitmapProvider;
    private final OnRenderModeChangedListener internalRenderModeChangedListener;
    private boolean isStale;
    private LocationLayerRenderer locationLayerRenderer;
    private final MapplsMap mapplsMap;
    private LocationComponentOptions options;
    private LocationComponentPositionManager positionManager;
    private int renderMode;
    private final boolean useSpecializedLocationLayer;
    private boolean isHidden = true;
    private final MapplsAnimator.AnimationsValueChangeListener<LatLng> latLngValueListener = new MapplsAnimator.AnimationsValueChangeListener<LatLng>() { // from class: com.mappls.sdk.maps.location.LocationLayerController.1
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(LatLng latLng) {
            LocationLayerController.this.locationLayerRenderer.setLatLng(latLng);
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> gpsBearingValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationLayerController.2
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setGpsBearing(f);
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> compassBearingValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationLayerController.3
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setCompassBearing(f);
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> accuracyValueListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationLayerController.4
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.setAccuracyRadius(f);
        }
    };
    private final MapplsAnimator.AnimationsValueChangeListener<Float> pulsingCircleRadiusListener = new MapplsAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mappls.sdk.maps.location.LocationLayerController.5
        @Override // com.mappls.sdk.maps.location.MapplsAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationLayerController.this.locationLayerRenderer.updatePulsingUi(f.floatValue(), LocationLayerController.this.options.pulseFadeEnabled().booleanValue() ? Float.valueOf(1.0f - ((f.floatValue() / 100.0f) * 3.0f)) : null);
        }
    };

    LocationLayerController(MapplsMap mapplsMap, Style style, LayerSourceProvider layerSourceProvider, LayerFeatureProvider layerFeatureProvider, LayerBitmapProvider layerBitmapProvider, LocationComponentOptions locationComponentOptions, OnRenderModeChangedListener onRenderModeChangedListener, boolean z) {
        this.mapplsMap = mapplsMap;
        this.bitmapProvider = layerBitmapProvider;
        this.internalRenderModeChangedListener = onRenderModeChangedListener;
        this.useSpecializedLocationLayer = z;
        boolean zEnableStaleState = locationComponentOptions.enableStaleState();
        this.isStale = zEnableStaleState;
        if (z) {
            this.locationLayerRenderer = layerSourceProvider.getIndicatorLocationLayerRenderer();
        } else {
            this.locationLayerRenderer = layerSourceProvider.getSymbolLocationLayerRenderer(layerFeatureProvider, zEnableStaleState);
        }
        initializeComponents(style, locationComponentOptions);
    }

    void initializeComponents(Style style, LocationComponentOptions locationComponentOptions) {
        this.positionManager = new LocationComponentPositionManager(style, locationComponentOptions.layerAbove(), locationComponentOptions.layerBelow());
        this.locationLayerRenderer.initializeComponents(style);
        this.locationLayerRenderer.addLayers(this.positionManager);
        applyStyle(locationComponentOptions);
        if (this.isHidden) {
            hide();
        } else {
            show();
        }
    }

    void applyStyle(LocationComponentOptions locationComponentOptions) {
        if (this.positionManager.update(locationComponentOptions.layerAbove(), locationComponentOptions.layerBelow())) {
            this.locationLayerRenderer.removeLayers();
            this.locationLayerRenderer.addLayers(this.positionManager);
            if (this.isHidden) {
                hide();
            }
        }
        this.options = locationComponentOptions;
        styleBitmaps(locationComponentOptions);
        this.locationLayerRenderer.styleAccuracy(locationComponentOptions.accuracyAlpha(), locationComponentOptions.accuracyColor());
        styleScaling(locationComponentOptions);
        this.locationLayerRenderer.stylePulsingCircle(locationComponentOptions);
        determineIconsSource(locationComponentOptions);
        if (this.isHidden) {
            return;
        }
        show();
    }

    void setGpsBearing(float f) {
        this.locationLayerRenderer.setGpsBearing(Float.valueOf(f));
    }

    void setRenderMode(int i) {
        if (this.renderMode == i) {
            return;
        }
        this.renderMode = i;
        styleBitmaps(this.options);
        determineIconsSource(this.options);
        if (!this.isHidden) {
            show();
        }
        this.internalRenderModeChangedListener.onRenderModeChanged(i);
    }

    int getRenderMode() {
        return this.renderMode;
    }

    void show() {
        this.isHidden = false;
        this.locationLayerRenderer.show(this.renderMode, this.isStale);
    }

    void hide() {
        this.isHidden = true;
        this.locationLayerRenderer.hide();
    }

    boolean isHidden() {
        return this.isHidden;
    }

    boolean isConsumingCompass() {
        return this.renderMode == 4;
    }

    private void styleBitmaps(LocationComponentOptions locationComponentOptions) {
        Bitmap bitmap;
        Bitmap bitmapGenerateBitmap;
        Bitmap bitmapGenerateShadowBitmap = locationComponentOptions.elevation() > 0.0f ? this.bitmapProvider.generateShadowBitmap(locationComponentOptions) : null;
        Bitmap bitmapGenerateBitmap2 = this.bitmapProvider.generateBitmap(locationComponentOptions.backgroundDrawable(), locationComponentOptions.backgroundTintColor());
        Bitmap bitmapGenerateBitmap3 = this.bitmapProvider.generateBitmap(locationComponentOptions.backgroundDrawableStale(), locationComponentOptions.backgroundStaleTintColor());
        Bitmap bitmapGenerateBitmap4 = this.bitmapProvider.generateBitmap(locationComponentOptions.bearingDrawable(), locationComponentOptions.bearingTintColor());
        Bitmap bitmapGenerateBitmap5 = this.bitmapProvider.generateBitmap(locationComponentOptions.foregroundDrawable(), locationComponentOptions.foregroundTintColor());
        Bitmap bitmapGenerateBitmap6 = this.bitmapProvider.generateBitmap(locationComponentOptions.foregroundDrawableStale(), locationComponentOptions.foregroundStaleTintColor());
        if (this.renderMode == 8) {
            Bitmap bitmapGenerateBitmap7 = this.bitmapProvider.generateBitmap(locationComponentOptions.gpsDrawable(), locationComponentOptions.foregroundTintColor());
            bitmapGenerateBitmap = this.bitmapProvider.generateBitmap(locationComponentOptions.gpsStaleDrawable(), locationComponentOptions.foregroundStaleTintColor());
            bitmap = bitmapGenerateBitmap7;
        } else {
            bitmap = bitmapGenerateBitmap5;
            bitmapGenerateBitmap = bitmapGenerateBitmap6;
        }
        this.locationLayerRenderer.addBitmaps(this.renderMode, bitmapGenerateShadowBitmap, bitmapGenerateBitmap2, bitmapGenerateBitmap3, bitmapGenerateBitmap4, bitmap, bitmapGenerateBitmap);
    }

    private void styleScaling(LocationComponentOptions locationComponentOptions) {
        this.locationLayerRenderer.styleScaling(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(Double.valueOf(this.mapplsMap.getMinZoomLevel()), Float.valueOf(locationComponentOptions.minZoomIconScale())), Expression.stop(Double.valueOf(this.mapplsMap.getMaxZoomLevel()), Float.valueOf(locationComponentOptions.maxZoomIconScale()))));
    }

    private void determineIconsSource(LocationComponentOptions locationComponentOptions) {
        this.locationLayerRenderer.updateIconIds(buildIconString(this.renderMode == 8 ? locationComponentOptions.gpsName() : locationComponentOptions.foregroundName(), "mappls-location-icon"), buildIconString(locationComponentOptions.foregroundStaleName(), "mappls-location-stale-icon"), buildIconString(locationComponentOptions.backgroundName(), "mappls-location-stroke-icon"), buildIconString(locationComponentOptions.backgroundStaleName(), "mappls-location-background-stale-icon"), buildIconString(locationComponentOptions.bearingName(), "mappls-location-bearing-icon"));
    }

    private String buildIconString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (!this.useSpecializedLocationLayer) {
            return str;
        }
        Logger.e(TAG, str + " replacement ID provided for an unsupported specialized location layer");
        return str2;
    }

    void setLocationsStale(boolean z) {
        this.isStale = z;
        this.locationLayerRenderer.setLocationStale(z, this.renderMode);
    }

    boolean onMapClick(LatLng latLng) {
        return !this.mapplsMap.queryRenderedFeatures(this.mapplsMap.getProjection().toScreenLocation(latLng), LocationComponentConstants.BACKGROUND_LAYER, LocationComponentConstants.FOREGROUND_LAYER, LocationComponentConstants.BEARING_LAYER).isEmpty();
    }

    Set<AnimatorListenerHolder> getAnimationListeners() {
        HashSet hashSet = new HashSet();
        hashSet.add(new AnimatorListenerHolder(0, this.latLngValueListener));
        int i = this.renderMode;
        if (i == 8) {
            hashSet.add(new AnimatorListenerHolder(2, this.gpsBearingValueListener));
        } else if (i == 4) {
            hashSet.add(new AnimatorListenerHolder(3, this.compassBearingValueListener));
        }
        int i2 = this.renderMode;
        if (i2 == 4 || i2 == 18) {
            hashSet.add(new AnimatorListenerHolder(6, this.accuracyValueListener));
        }
        if (this.options.pulseEnabled().booleanValue()) {
            hashSet.add(new AnimatorListenerHolder(9, this.pulsingCircleRadiusListener));
        }
        return hashSet;
    }

    void cameraBearingUpdated(double d) {
        if (this.renderMode != 8) {
            this.locationLayerRenderer.cameraBearingUpdated(d);
        }
    }

    void cameraTiltUpdated(double d) {
        this.locationLayerRenderer.cameraTiltUpdated(d);
    }

    void adjustPulsingCircleLayerVisibility(boolean z) {
        this.locationLayerRenderer.adjustPulsingCircleLayerVisibility(z);
    }
}
