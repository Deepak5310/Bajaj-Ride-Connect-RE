package com.mappls.sdk.maps.location;

import android.graphics.Bitmap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.ColorUtils;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class SymbolLocationLayerRenderer implements LocationLayerRenderer {
    private final Set<String> layerSet;
    private final LayerSourceProvider layerSourceProvider;
    private Feature locationFeature;
    private GeoJsonSource locationSource;
    private Style style;

    SymbolLocationLayerRenderer(LayerSourceProvider layerSourceProvider, LayerFeatureProvider layerFeatureProvider, boolean z) {
        this.layerSourceProvider = layerSourceProvider;
        this.layerSet = layerSourceProvider.getEmptyLayerSet();
        this.locationFeature = layerFeatureProvider.generateLocationFeature(this.locationFeature, z);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void initializeComponents(Style style) {
        this.style = style;
        addLocationSource();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void addLayers(LocationComponentPositionManager locationComponentPositionManager) {
        Layer layerGenerateLayer = this.layerSourceProvider.generateLayer(LocationComponentConstants.BEARING_LAYER);
        locationComponentPositionManager.addLayerToMap(layerGenerateLayer);
        this.layerSet.add(layerGenerateLayer.getId());
        addSymbolLayer(LocationComponentConstants.FOREGROUND_LAYER, LocationComponentConstants.BEARING_LAYER);
        addSymbolLayer(LocationComponentConstants.BACKGROUND_LAYER, LocationComponentConstants.FOREGROUND_LAYER);
        addSymbolLayer(LocationComponentConstants.SHADOW_LAYER, LocationComponentConstants.BACKGROUND_LAYER);
        addAccuracyLayer();
        addPulsingCircleLayerToMap();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void removeLayers() {
        Style style = this.style;
        if (style != null && style.isFullyLoaded()) {
            Iterator<String> it2 = this.layerSet.iterator();
            while (it2.hasNext()) {
                this.style.removeLayer(it2.next());
            }
        }
        this.layerSet.clear();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void hide() {
        Iterator<String> it2 = this.layerSet.iterator();
        while (it2.hasNext()) {
            setLayerVisibility(it2.next(), false);
        }
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void cameraTiltUpdated(double d) {
        updateForegroundOffset(d);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void cameraBearingUpdated(double d) {
        updateForegroundBearing((float) d);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void show(int i, boolean z) {
        if (i == 4) {
            setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, true);
            setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
            setLayerVisibility(LocationComponentConstants.BEARING_LAYER, true);
            return;
        }
        if (i == 8) {
            setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, false);
            setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, false);
            setLayerVisibility(LocationComponentConstants.BEARING_LAYER, false);
            return;
        }
        if (i != 18) {
            return;
        }
        setLayerVisibility(LocationComponentConstants.SHADOW_LAYER, true);
        setLayerVisibility(LocationComponentConstants.FOREGROUND_LAYER, true);
        setLayerVisibility(LocationComponentConstants.BACKGROUND_LAYER, true);
        setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
        setLayerVisibility(LocationComponentConstants.BEARING_LAYER, false);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void styleAccuracy(float f, int i) {
        this.locationFeature.addNumberProperty("mappls-property-accuracy-alpha", Float.valueOf(f));
        this.locationFeature.addStringProperty("mappls-property-accuracy-color", ColorUtils.colorToRgbaString(i));
        refreshSource();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setLatLng(LatLng latLng) {
        setLocationPoint(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setGpsBearing(Float f) {
        setBearingProperty("mappls-property-gps-bearing", f.floatValue());
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setCompassBearing(Float f) {
        setBearingProperty("mappls-property-compass-bearing", f.floatValue());
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setAccuracyRadius(Float f) {
        updateAccuracyRadius(f.floatValue());
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void styleScaling(Expression expression) {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return;
        }
        Iterator<String> it2 = this.layerSet.iterator();
        while (it2.hasNext()) {
            Layer layer = this.style.getLayer(it2.next());
            if (layer instanceof SymbolLayer) {
                layer.setProperties(PropertyFactory.iconSize(expression));
            }
        }
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void setLocationStale(boolean z, int i) {
        this.locationFeature.addBooleanProperty("mappls-property-location-stale", Boolean.valueOf(z));
        refreshSource();
        if (i != 8) {
            setLayerVisibility(LocationComponentConstants.ACCURACY_LAYER, !z);
        }
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void updateIconIds(String str, String str2, String str3, String str4, String str5) {
        this.locationFeature.addStringProperty("mappls-property-foreground-icon", str);
        this.locationFeature.addStringProperty("mappls-property-background-icon", str3);
        this.locationFeature.addStringProperty("mappls-property-foreground-stale-icon", str2);
        this.locationFeature.addStringProperty("mappls-property-background-stale-icon", str4);
        this.locationFeature.addStringProperty("mappls-property-shadow-icon", str5);
        refreshSource();
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void addBitmaps(int i, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return;
        }
        if (bitmap != null) {
            this.style.addImage("mappls-location-shadow-icon", bitmap);
        } else {
            this.style.removeImage("mappls-location-shadow-icon");
        }
        this.style.addImage("mappls-location-stroke-icon", bitmap2);
        this.style.addImage("mappls-location-background-stale-icon", bitmap3);
        this.style.addImage("mappls-location-bearing-icon", bitmap4);
        this.style.addImage("mappls-location-icon", bitmap5);
        this.style.addImage("mappls-location-stale-icon", bitmap6);
    }

    private void updateForegroundOffset(double d) {
        JsonArray jsonArray = new JsonArray();
        Float fValueOf = Float.valueOf(0.0f);
        jsonArray.add(fValueOf);
        jsonArray.add(Float.valueOf((float) ((-0.05d) * d)));
        this.locationFeature.addProperty("mappls-property-foreground-icon-offset", jsonArray);
        JsonArray jsonArray2 = new JsonArray();
        jsonArray2.add(fValueOf);
        jsonArray2.add(Float.valueOf((float) (d * 0.05d)));
        this.locationFeature.addProperty("mappls-property-shadow-icon-offset", jsonArray2);
        refreshSource();
    }

    private void updateForegroundBearing(float f) {
        setBearingProperty("mappls-property-gps-bearing", f);
    }

    private void setLayerVisibility(String str, boolean z) {
        Layer layer;
        Style style = this.style;
        if (style == null || !style.isFullyLoaded() || (layer = this.style.getLayer(str)) == null) {
            return;
        }
        if (layer.getVisibility().value.equals(z ? "visible" : "none")) {
            return;
        }
        PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
        propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
        layer.setProperties(propertyValueArr);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void adjustPulsingCircleLayerVisibility(boolean z) {
        setLayerVisibility(LocationComponentConstants.PULSING_CIRCLE_LAYER, z);
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void stylePulsingCircle(LocationComponentOptions locationComponentOptions) {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded() || this.style.getLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER) == null) {
            return;
        }
        setLayerVisibility(LocationComponentConstants.PULSING_CIRCLE_LAYER, true);
        this.style.getLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER).setProperties(PropertyFactory.circleRadius(Expression.get("mappls-property-pulsing-circle-radius")), PropertyFactory.circleColor(locationComponentOptions.pulseColor().intValue()), PropertyFactory.circleStrokeColor(locationComponentOptions.pulseColor().intValue()), PropertyFactory.circleOpacity(Expression.get("mappls-property-pulsing-circle-opacity")));
    }

    @Override // com.mappls.sdk.maps.location.LocationLayerRenderer
    public void updatePulsingUi(float f, Float f2) {
        this.locationFeature.addNumberProperty("mappls-property-pulsing-circle-radius", Float.valueOf(f));
        if (f2 != null) {
            this.locationFeature.addNumberProperty("mappls-property-pulsing-circle-opacity", f2);
        }
        refreshSource();
    }

    private void addSymbolLayer(String str, String str2) {
        addLayerToMap(this.layerSourceProvider.generateLayer(str), str2);
    }

    private void addAccuracyLayer() {
        addLayerToMap(this.layerSourceProvider.generateAccuracyLayer(), LocationComponentConstants.BACKGROUND_LAYER);
    }

    private void addPulsingCircleLayerToMap() {
        addLayerToMap(this.layerSourceProvider.generatePulsingCircleLayer(), LocationComponentConstants.ACCURACY_LAYER);
    }

    private void addLayerToMap(Layer layer, String str) {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return;
        }
        this.style.addLayerBelow(layer, str);
        this.layerSet.add(layer.getId());
    }

    private void addLocationSource() {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return;
        }
        GeoJsonSource geoJsonSourceGenerateSource = this.layerSourceProvider.generateSource(this.locationFeature);
        this.locationSource = geoJsonSourceGenerateSource;
        this.style.addSource(geoJsonSourceGenerateSource);
    }

    private void refreshSource() {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded() || ((GeoJsonSource) this.style.getSourceAs(LocationComponentConstants.LOCATION_SOURCE)) == null) {
            return;
        }
        this.locationSource.setGeoJson(this.locationFeature);
    }

    private void setLocationPoint(Point point) {
        JsonObject jsonObjectProperties = this.locationFeature.properties();
        if (jsonObjectProperties != null) {
            this.locationFeature = Feature.fromGeometry(point, jsonObjectProperties);
            refreshSource();
        }
    }

    private void setBearingProperty(String str, float f) {
        this.locationFeature.addNumberProperty(str, Float.valueOf(f));
        refreshSource();
    }

    private void updateAccuracyRadius(float f) {
        this.locationFeature.addNumberProperty("mappls-property-accuracy-radius", Float.valueOf(f));
        refreshSource();
    }
}
