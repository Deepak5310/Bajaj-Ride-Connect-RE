package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class q {
    public final MapView a;
    public final MapplsMap b;
    public GeoJsonSource c;
    public String d;
    public FeatureCollection e;
    public final AtomicReference f = new AtomicReference(null);
    public final k g = new k(this);

    public q(MapView mapView, MapplsMap mapplsMap, String str) {
        this.a = mapView;
        this.b = mapplsMap;
        this.d = str;
        mapplsMap.getStyle(new l(this, str));
    }

    public final void a(String str, Style style) {
        if (style.getSource("mappls-navigation-route-event-source-id") == null) {
            GeoJsonSource geoJsonSource = new GeoJsonSource("mappls-navigation-route-event-source-id", FeatureCollection.fromFeatures(new Feature[0]));
            this.c = geoJsonSource;
            style.addSource(geoJsonSource);
        }
        FeatureCollection featureCollection = this.e;
        if (featureCollection != null) {
            this.c.setGeoJson(featureCollection);
        }
        Layer layer = (SymbolLayer) style.getLayerAs("mappls-navigation-route-event-symbol-layer");
        if (layer != null) {
            style.removeLayer(layer);
        }
        Layer layerWithProperties = new SymbolLayer("mappls-navigation-route-event-symbol-layer", "mappls-navigation-route-event-source-id").withProperties(PropertyFactory.iconImage(Expression.get("mappls-navigation-route-event-marker")), PropertyFactory.iconAllowOverlap(Boolean.FALSE));
        layerWithProperties.setMinZoom(13.0f);
        if (style.getLayer(str) != null) {
            style.addLayerAbove(layerWithProperties, str);
        } else {
            style.addLayer(layerWithProperties);
        }
    }
}
