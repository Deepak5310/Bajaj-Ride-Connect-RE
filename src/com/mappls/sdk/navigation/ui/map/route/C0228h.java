package com.mappls.sdk.navigation.ui.map.route;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.maps.utils.MathUtils;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.turf.TurfMeasurement;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0228h {
    public final int a;
    public final int b;
    public final MapView c;
    public final MapplsMap d;
    public ArrayList e;
    public GeoJsonSource f;
    public GeoJsonSource g;
    public ArrayList h;

    public C0228h(MapView mapView, MapplsMap mapplsMap, String str, int i) {
        this.c = mapView;
        this.d = mapplsMap;
        Context context = mapView.getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.NavigationMapRoute);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_upcomingManeuverArrowColor, ContextCompat.getColor(context, R.color.white));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_upcomingManeuverArrowBorderColor, ContextCompat.getColor(context, R.color.colorGray700));
        typedArrayObtainStyledAttributes.recycle();
        this.h = null;
        mapplsMap.getStyle(new C0225e(this, str));
    }

    public final void a(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        double dBearing = TurfMeasurement.bearing((Point) arrayList.get(arrayList.size() - 2), (Point) arrayList.get(arrayList.size() - 1));
        Feature featureFromGeometry = Feature.fromGeometry((Geometry) arrayList.get(arrayList.size() - 1));
        featureFromGeometry.addNumberProperty("mappls-navigation-arrow-bearing", Float.valueOf((float) MathUtils.wrap(dBearing, 0.0d, 360.0d)));
        this.g.setGeoJson(featureFromGeometry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, Style style) {
        if (style.getSource("mappls-navigation-arrow-shaft-source") == null) {
            GeoJsonSource geoJsonSource = new GeoJsonSource("mappls-navigation-arrow-shaft-source", FeatureCollection.fromFeatures(new Feature[0]), new GeoJsonOptions().withMaxZoom(16));
            this.f = geoJsonSource;
            style.addSource(geoJsonSource);
        }
        ArrayList arrayList = this.h;
        if (arrayList != null) {
            this.f.setGeoJson(Feature.fromGeometry(LineString.fromLngLats(arrayList)));
        }
        if (style.getSource("mappls-navigation-arrow-head-source") == null) {
            GeoJsonSource geoJsonSource2 = new GeoJsonSource("mappls-navigation-arrow-head-source", FeatureCollection.fromFeatures(new Feature[0]), new GeoJsonOptions().withMaxZoom(16));
            this.g = geoJsonSource2;
            style.addSource(geoJsonSource2);
        }
        ArrayList arrayList2 = this.h;
        if (arrayList2 != null) {
            a(arrayList2);
        }
        Drawable drawable = AppCompatResources.getDrawable(this.c.getContext(), R.drawable.ic_arrow_head);
        if (drawable != null) {
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawableWrap.mutate(), this.a);
            style.addImage("mappls-navigation-arrow-head-icon", BitmapUtils.getBitmapFromDrawable(drawableWrap));
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.c.getContext(), R.drawable.ic_arrow_head_casing);
        if (drawable2 != null) {
            Drawable drawableWrap2 = DrawableCompat.wrap(drawable2);
            DrawableCompat.setTint(drawableWrap2.mutate(), this.b);
            style.addImage("mappls-navigation-arrow-head-icon-casing", BitmapUtils.getBitmapFromDrawable(drawableWrap2));
        }
        Layer layer = (LineLayer) style.getLayerAs("mappls-navigation-arrow-shaft-layer");
        if (layer != null) {
            style.removeLayer(layer);
        }
        Layer layerWithProperties = new LineLayer("mappls-navigation-arrow-shaft-layer", "mappls-navigation-arrow-shaft-source").withProperties(PropertyFactory.lineColor(Expression.color(this.a)), PropertyFactory.lineWidth(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(2.6f)), Expression.stop(22, Float.valueOf(13.0f)))), PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.visibility("none"), PropertyFactory.lineOpacity(Expression.step(Expression.zoom(), Float.valueOf(0.0f), Expression.stop(14, Float.valueOf(1.0f)))));
        Layer layer2 = (LineLayer) style.getLayer("mappls-navigation-arrow-shaft-casing-layer");
        if (layer2 != null) {
            style.removeLayer(layer2);
        }
        Layer layerWithProperties2 = new LineLayer("mappls-navigation-arrow-shaft-casing-layer", "mappls-navigation-arrow-shaft-source").withProperties(PropertyFactory.lineColor(Expression.color(this.b)), PropertyFactory.lineWidth(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(3.4f)), Expression.stop(22, Float.valueOf(17.0f)))), PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.visibility("none"), PropertyFactory.lineOpacity(Expression.step(Expression.zoom(), Float.valueOf(0.0f), Expression.stop(14, Float.valueOf(1.0f)))));
        Layer layer3 = (SymbolLayer) style.getLayer("mappls-navigation-arrow-head-layer");
        if (layer3 != null) {
            style.removeLayer(layer3);
        }
        SymbolLayer symbolLayer = new SymbolLayer("mappls-navigation-arrow-head-layer", "mappls-navigation-arrow-head-source");
        PropertyValue<String> propertyValueIconImage = PropertyFactory.iconImage("mappls-navigation-arrow-head-icon");
        Boolean bool = Boolean.TRUE;
        Layer layerWithProperties3 = symbolLayer.withProperties(propertyValueIconImage, PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.iconSize(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(0.2f)), Expression.stop(22, Float.valueOf(0.8f)))), PropertyFactory.iconOffset(H.b), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.get("mappls-navigation-arrow-bearing")), PropertyFactory.visibility("none"), PropertyFactory.iconOpacity(Expression.step(Expression.zoom(), Float.valueOf(0.0f), Expression.stop(14, Float.valueOf(1.0f)))));
        Layer layer4 = (SymbolLayer) style.getLayer("mappls-navigation-arrow-head-casing-layer");
        if (layer4 != null) {
            style.removeLayer(layer4);
        }
        Layer layerWithProperties4 = new SymbolLayer("mappls-navigation-arrow-head-casing-layer", "mappls-navigation-arrow-head-source").withProperties(PropertyFactory.iconImage("mappls-navigation-arrow-head-icon-casing"), PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.iconSize(Expression.interpolate(Expression.linear(), Expression.zoom(), Expression.stop(10, Float.valueOf(0.2f)), Expression.stop(22, Float.valueOf(0.8f)))), PropertyFactory.iconOffset(H.a), PropertyFactory.iconRotationAlignment("map"), PropertyFactory.iconRotate(Expression.get("mappls-navigation-arrow-bearing")), PropertyFactory.visibility("none"), PropertyFactory.iconOpacity(Expression.step(Expression.zoom(), Float.valueOf(0.0f), Expression.stop(14, Float.valueOf(1.0f)))));
        style.addLayerAbove(layerWithProperties2, str);
        style.addLayerAbove(layerWithProperties4, layerWithProperties2.getId());
        style.addLayerAbove(layerWithProperties, layerWithProperties4.getId());
        style.addLayerAbove(layerWithProperties3, layerWithProperties.getId());
        ArrayList arrayList3 = new ArrayList();
        this.e = arrayList3;
        arrayList3.add(layerWithProperties2.getId());
        this.e.add(layerWithProperties.getId());
        this.e.add(layerWithProperties4.getId());
        this.e.add(layerWithProperties3.getId());
    }
}
