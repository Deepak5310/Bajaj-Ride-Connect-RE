package com.mappls.sdk.maps.location;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.CircleLayer;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.layers.TransitionOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class LayerSourceProvider {
    private static final String EMPTY_STRING = "";

    LayerSourceProvider() {
    }

    GeoJsonSource generateSource(Feature feature) {
        return new GeoJsonSource(LocationComponentConstants.LOCATION_SOURCE, feature, new GeoJsonOptions().withMaxZoom(16));
    }

    Layer generateLayer(String str) {
        SymbolLayer symbolLayer = new SymbolLayer(str, LocationComponentConstants.LOCATION_SOURCE);
        Expression expressionLiteral = Expression.literal(str);
        Float fValueOf = Float.valueOf(0.0f);
        symbolLayer.setProperties(PropertyFactory.iconAllowOverlap((Boolean) true), PropertyFactory.iconIgnorePlacement((Boolean) true), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.match(expressionLiteral, Expression.literal((Number) fValueOf), Expression.stop(LocationComponentConstants.FOREGROUND_LAYER, Expression.get("mappls-property-gps-bearing")), Expression.stop(LocationComponentConstants.BACKGROUND_LAYER, Expression.get("mappls-property-gps-bearing")), Expression.stop(LocationComponentConstants.SHADOW_LAYER, Expression.get("mappls-property-gps-bearing")), Expression.stop(LocationComponentConstants.BEARING_LAYER, Expression.get("mappls-property-compass-bearing")))), PropertyFactory.iconImage(Expression.match(Expression.literal(str), Expression.literal(""), Expression.stop(LocationComponentConstants.FOREGROUND_LAYER, Expression.switchCase(Expression.get("mappls-property-location-stale"), Expression.get("mappls-property-foreground-stale-icon"), Expression.get("mappls-property-foreground-icon"))), Expression.stop(LocationComponentConstants.BACKGROUND_LAYER, Expression.switchCase(Expression.get("mappls-property-location-stale"), Expression.get("mappls-property-background-stale-icon"), Expression.get("mappls-property-background-icon"))), Expression.stop(LocationComponentConstants.SHADOW_LAYER, Expression.literal("mappls-location-shadow-icon")), Expression.stop(LocationComponentConstants.BEARING_LAYER, Expression.get("mappls-property-shadow-icon")))), PropertyFactory.iconOffset(Expression.match(Expression.literal(str), Expression.literal((Object[]) new Float[]{fValueOf, fValueOf}), Expression.stop(Expression.literal(LocationComponentConstants.FOREGROUND_LAYER), Expression.get("mappls-property-foreground-icon-offset")), Expression.stop(Expression.literal(LocationComponentConstants.SHADOW_LAYER), Expression.get("mappls-property-shadow-icon-offset")))));
        return symbolLayer;
    }

    Layer generateAccuracyLayer() {
        return new CircleLayer(LocationComponentConstants.ACCURACY_LAYER, LocationComponentConstants.LOCATION_SOURCE).withProperties(PropertyFactory.circleRadius(Expression.get("mappls-property-accuracy-radius")), PropertyFactory.circleColor(Expression.get("mappls-property-accuracy-color")), PropertyFactory.circleOpacity(Expression.get("mappls-property-accuracy-alpha")), PropertyFactory.circleStrokeColor(Expression.get("mappls-property-accuracy-color")), PropertyFactory.circlePitchAlignment("map"));
    }

    Set<String> getEmptyLayerSet() {
        return new HashSet();
    }

    LocationLayerRenderer getSymbolLocationLayerRenderer(LayerFeatureProvider layerFeatureProvider, boolean z) {
        return new SymbolLocationLayerRenderer(this, layerFeatureProvider, z);
    }

    LocationLayerRenderer getIndicatorLocationLayerRenderer() {
        return new IndicatorLocationLayerRenderer(this);
    }

    Layer generateLocationComponentLayer() {
        LocationIndicatorLayer locationIndicatorLayer = new LocationIndicatorLayer(LocationComponentConstants.FOREGROUND_LAYER);
        locationIndicatorLayer.setLocationTransition(new TransitionOptions(0L, 0L));
        locationIndicatorLayer.setProperties(LocationPropertyFactory.perspectiveCompensation(Float.valueOf(0.9f)), LocationPropertyFactory.imageTiltDisplacement(Float.valueOf(4.0f)));
        return locationIndicatorLayer;
    }

    Layer generatePulsingCircleLayer() {
        return new CircleLayer(LocationComponentConstants.PULSING_CIRCLE_LAYER, LocationComponentConstants.LOCATION_SOURCE).withProperties(PropertyFactory.circlePitchAlignment("map"));
    }
}
