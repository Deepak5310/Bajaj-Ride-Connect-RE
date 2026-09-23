package com.mappls.sdk.navigation.ui.map.route;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.layers.Property;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class z {
    public final AtomicReference A;
    public final Handler B;
    public final r C;
    public final B D;
    public final Drawable E;
    public final Drawable F;
    public final Drawable G;
    public final Drawable H;
    public final String I;
    public final s J;
    public final u K;
    public final HashMap a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f717n;
    public final float o;
    public final float p;
    public final boolean q;
    public final MapplsMap r;
    public GeoJsonSource s;
    public GeoJsonSource t;
    public int u;
    public boolean v;
    public boolean w;
    public FeatureCollection x;
    public FeatureCollection y;
    public final AtomicReference z;

    public z(Context context, MapplsMap mapplsMap, int i, j jVar, B b, r rVar, Handler handler) {
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(new Feature[0]);
        FeatureCollection featureCollectionFromFeatures2 = FeatureCollection.fromFeatures(new Feature[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        this.a = map2;
        ArrayList arrayList3 = new ArrayList();
        this.b = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.c = arrayList4;
        this.v = true;
        this.w = true;
        this.z = new AtomicReference(null);
        this.A = new AtomicReference(null);
        this.J = new s(this);
        this.K = new u(this);
        this.d = new ArrayList();
        this.B = handler;
        this.r = mapplsMap;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.NavigationMapRoute);
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_routeColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_default_color));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_routeModerateCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_congestion_moderate_color));
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_routeHeavyCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_congestion_heavy_color));
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_routeSevereCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_congestion_severe_color));
        this.f717n = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_routeShieldColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_sheild_color));
        this.o = typedArrayObtainStyledAttributes.getFloat(R.styleable.NavigationMapRoute_routeScale, 1.0f);
        this.q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.NavigationMapRoute_roundedLineCap, true);
        this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_alternativeRouteColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_alternate_default_color));
        this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_alternativeRouteModerateCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_alternate_congestion_moderate_color));
        this.l = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_alternativeRouteSevereCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_alternate_congestion_severe_color));
        this.k = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_alternativeRouteHeavyCongestionColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_alternate_congestion_heavy_color));
        this.m = typedArrayObtainStyledAttributes.getColor(R.styleable.NavigationMapRoute_alternativeRouteShieldColor, ContextCompat.getColor(context, R.color.mappls_navigation_ui_alternate_sheild_color));
        this.p = typedArrayObtainStyledAttributes.getFloat(R.styleable.NavigationMapRoute_alternativeRouteScale, 1.0f);
        this.D = b;
        this.C = rVar;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationMapRoute_waypointIcon_1, R.drawable.navigation_ui_marker_via_1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationMapRoute_waypointIcon_2, R.drawable.navigation_ui_marker_via_2);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationMapRoute_waypointIcon_3, R.drawable.navigation_ui_marker_via_3);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationMapRoute_destinationIcon, R.drawable.destination_marker);
        typedArrayObtainStyledAttributes.recycle();
        this.E = AppCompatResources.getDrawable(jVar.a, resourceId);
        this.F = AppCompatResources.getDrawable(jVar.a, resourceId2);
        this.G = AppCompatResources.getDrawable(jVar.a, resourceId3);
        this.H = AppCompatResources.getDrawable(jVar.a, resourceId4);
        this.C = rVar;
        this.I = "highway_name";
        arrayList4.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        map2.putAll(map);
        mapplsMap.getStyle(new v(this, featureCollectionFromFeatures2, b, featureCollectionFromFeatures, rVar, arrayList, arrayList2));
    }

    public final String a() {
        if (this.d.isEmpty()) {
            return "mapbox-location-shadow-layer";
        }
        ArrayList arrayList = this.d;
        return (String) arrayList.get(arrayList.size() - 1);
    }

    public final void b(boolean z, Style style) {
        this.v = z;
        if (this.r != null) {
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                Layer layer = style.getLayer((String) it2.next());
                if (layer != null) {
                    layer.setProperties(PropertyFactory.visibility(z ? "visible" : "none"));
                }
            }
        }
    }

    public final void a(Style style) {
        GeoJsonOptions geoJsonOptionsWithMaxZoom = new GeoJsonOptions().withMaxZoom(16);
        if (style.getSource("mappls-navigation-waypoint-source") == null) {
            B b = this.D;
            FeatureCollection featureCollection = this.y;
            b.getClass();
            GeoJsonSource geoJsonSource = new GeoJsonSource("mappls-navigation-waypoint-source", featureCollection, geoJsonOptionsWithMaxZoom);
            this.s = geoJsonSource;
            style.addSource(geoJsonSource);
        } else {
            GeoJsonSource geoJsonSource2 = (GeoJsonSource) style.getSource("mappls-navigation-waypoint-source");
            this.s = geoJsonSource2;
            if (geoJsonSource2 != null) {
                geoJsonSource2.setGeoJson(this.y);
            }
        }
        GeoJsonOptions geoJsonOptionsWithMaxZoom2 = new GeoJsonOptions().withMaxZoom(16);
        if (style.getSource("mappls-navigation-route-source") == null) {
            B b2 = this.D;
            FeatureCollection featureCollection2 = this.x;
            b2.getClass();
            GeoJsonSource geoJsonSource3 = new GeoJsonSource("mappls-navigation-route-source", featureCollection2, geoJsonOptionsWithMaxZoom2);
            this.t = geoJsonSource3;
            style.addSource(geoJsonSource3);
            return;
        }
        GeoJsonSource geoJsonSource4 = (GeoJsonSource) style.getSource("mappls-navigation-route-source");
        this.t = geoJsonSource4;
        if (geoJsonSource4 != null) {
            geoJsonSource4.setGeoJson(this.x);
        }
    }

    public final void a(int i) {
        this.u = i;
        if (i < 0 || i > this.b.size() - 1) {
            return;
        }
        G g = (G) this.A.getAndSet(new G(i, this.b, this.J, this.B));
        if (g != null) {
            g.d.set(true);
        }
        G g2 = (G) this.A.get();
        if (g2 != null) {
            g2.start();
        }
    }

    public final void a(Style style, r rVar, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, String str) {
        z zVar;
        Float f;
        Style style2;
        z zVar2;
        String str2;
        String str3;
        Layer layer = style.getLayer("mappls-navigation-route-shield-layer");
        Float fValueOf = Float.valueOf(19.0f);
        Float fValueOf2 = Float.valueOf(14.0f);
        Float fValueOf3 = Float.valueOf(7.0f);
        Float fValueOf4 = Float.valueOf(1.5f);
        Float fValueOf5 = Float.valueOf(10.0f);
        if (layer == null) {
            float f2 = this.o;
            float f3 = this.p;
            int i = this.f717n;
            int i2 = this.m;
            rVar.getClass();
            LineLayer lineLayer = (LineLayer) style.getLayerAs("mappls-navigation-route-shield-layer");
            if (lineLayer != null) {
                style.removeLayer(lineLayer);
            }
            LineLayer lineLayerWithProperties = new LineLayer("mappls-navigation-route-shield-layer", "mappls-navigation-route-source").withProperties(PropertyFactory.lineCap("round"), PropertyFactory.lineJoin("round"), PropertyFactory.lineWidth(Expression.interpolate(Expression.exponential(fValueOf4), Expression.zoom(), Expression.stop(fValueOf5, fValueOf3), Expression.stop(fValueOf2, Expression.product(Expression.literal((Number) Float.valueOf(8.0f)), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f2)), Expression.literal((Number) Float.valueOf(f3))))), Expression.stop(fValueOf, Expression.product(Expression.literal((Number) Float.valueOf(9.0f)), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f2)), Expression.literal((Number) Float.valueOf(f3))))))), PropertyFactory.lineColor(Expression.switchCase(Expression.get("primary-route"), Expression.color(i), Expression.color(i2))));
            if (style.isFullyLoaded() || style.getLayer(lineLayerWithProperties.getId()) == null) {
                if (str == null) {
                    style.addLayer(lineLayerWithProperties);
                } else {
                    style.addLayerBelow(lineLayerWithProperties, str);
                }
            }
            zVar = this;
            zVar.d.add(lineLayerWithProperties.getId());
        } else {
            zVar = this;
        }
        if (style.getLayer("mappls-navigation-route-layer") == null) {
            boolean z = zVar.q;
            float f4 = zVar.o;
            float f5 = zVar.p;
            int i3 = zVar.e;
            int i4 = zVar.f;
            int i5 = zVar.g;
            int i6 = zVar.h;
            int i7 = zVar.i;
            int i8 = zVar.j;
            int i9 = zVar.l;
            int i10 = zVar.k;
            rVar.getClass();
            LineLayer lineLayer2 = (LineLayer) style.getLayerAs("mappls-navigation-route-layer");
            if (lineLayer2 != null) {
                style.removeLayer(lineLayer2);
            }
            if (z) {
                str2 = "round";
                str3 = str2;
            } else {
                str2 = Property.LINE_CAP_BUTT;
                str3 = Property.LINE_JOIN_BEVEL;
            }
            f = fValueOf5;
            LineLayer lineLayerWithProperties2 = new LineLayer("mappls-navigation-route-layer", "mappls-navigation-route-source").withProperties(PropertyFactory.lineCap(str2), PropertyFactory.lineJoin(str3), PropertyFactory.lineWidth(Expression.interpolate(Expression.exponential(Float.valueOf(1.0f)), Expression.zoom(), Expression.stop(fValueOf5, Expression.product(Expression.literal((Number) Float.valueOf(5.5f)), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f4)), Expression.literal((Number) Float.valueOf(f5))))), Expression.stop(fValueOf2, Expression.product(Expression.literal((Number) Float.valueOf(6.5f)), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f4)), Expression.literal((Number) Float.valueOf(f5))))), Expression.stop(fValueOf, Expression.product(Expression.literal((Number) fValueOf3), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f4)), Expression.literal((Number) Float.valueOf(f5))))), Expression.stop(Float.valueOf(22.0f), Expression.product(Expression.literal((Number) Float.valueOf(7.5f)), Expression.switchCase(Expression.get("primary-route"), Expression.literal((Number) Float.valueOf(f4)), Expression.literal((Number) Float.valueOf(f5))))))), PropertyFactory.lineColor(Expression.switchCase(Expression.get("primary-route"), Expression.match(Expression.toString(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION)), Expression.color(i3), Expression.stop("moderate", Expression.color(i4)), Expression.stop("heavy", Expression.color(i6)), Expression.stop("severe", Expression.color(i5))), Expression.match(Expression.toString(Expression.get(DirectionsCriteria.ANNOTATION_CONGESTION)), Expression.color(i7), Expression.stop("moderate", Expression.color(i8)), Expression.stop("heavy", Expression.color(i10)), Expression.stop("severe", Expression.color(i9))))));
            if (style.isFullyLoaded()) {
                style2 = style;
            } else {
                style2 = style;
                if (style2.getLayer(lineLayerWithProperties2.getId()) == null) {
                }
                zVar2 = this;
                zVar2.d.add(lineLayerWithProperties2.getId());
            }
            if (style2.getLayer("mappls-navigation-route-shield-layer") == null) {
                style2.addLayer(lineLayerWithProperties2);
            } else {
                style2.addLayerAbove(lineLayerWithProperties2, "mappls-navigation-route-shield-layer");
            }
            zVar2 = this;
            zVar2.d.add(lineLayerWithProperties2.getId());
        } else {
            f = fValueOf5;
            z zVar3 = zVar;
            style2 = style;
            zVar2 = zVar3;
        }
        if (style2.getLayer("mappls-navigation-waypoint-layer") == null) {
            rVar.getClass();
            SymbolLayer symbolLayer = (SymbolLayer) style2.getLayerAs("mappls-navigation-waypoint-layer");
            if (symbolLayer != null) {
                style2.removeLayer(symbolLayer);
            }
            style2.addImage("wapointMarker_1", BitmapUtils.getBitmapFromDrawable(drawable));
            style2.addImage("wapointMarker_2", BitmapUtils.getBitmapFromDrawable(drawable2));
            style2.addImage("wapointMarker_3", BitmapUtils.getBitmapFromDrawable(drawable3));
            style2.addImage("destinationMarker", BitmapUtils.getBitmapFromDrawable(drawable4));
            SymbolLayer symbolLayer2 = new SymbolLayer("mappls-navigation-waypoint-layer", "mappls-navigation-waypoint-source");
            PropertyValue<String> propertyValueIconAnchor = PropertyFactory.iconAnchor("bottom");
            PropertyValue<Expression> propertyValueIconImage = PropertyFactory.iconImage(Expression.match(Expression.toString(Expression.get("wayPoint")), Expression.literal("wapointMarker_1"), Expression.stop("origin_1", Expression.literal("wapointMarker_1")), Expression.stop("origin_2", Expression.literal("wapointMarker_2")), Expression.stop("origin_3", Expression.literal("wapointMarker_3")), Expression.stop(FirebaseAnalytics.Param.DESTINATION, Expression.literal("destinationMarker"))));
            PropertyValue<Expression> propertyValueIconSize = PropertyFactory.iconSize(Expression.interpolate(Expression.exponential(fValueOf4), Expression.zoom(), Expression.stop(Float.valueOf(0.0f), Float.valueOf(0.8f)), Expression.stop(f, Float.valueOf(1.0f)), Expression.stop(Float.valueOf(12.0f), Float.valueOf(1.2f)), Expression.stop(Float.valueOf(22.0f), Float.valueOf(2.4f))));
            Boolean bool = Boolean.TRUE;
            SymbolLayer symbolLayerWithProperties = symbolLayer2.withProperties(propertyValueIconAnchor, propertyValueIconImage, propertyValueIconSize, PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool));
            if (style.isFullyLoaded() || style2.getLayer(symbolLayerWithProperties.getId()) == null) {
                if (style2.getLayer("mappls-navigation-route-layer") == null) {
                    style2.addLayer(symbolLayerWithProperties);
                } else {
                    style2.addLayerAbove(symbolLayerWithProperties, "mappls-navigation-route-layer");
                }
            }
            zVar2.d.add(symbolLayerWithProperties.getId());
        }
    }

    public final void a(boolean z, Style style) {
        this.w = z;
        if (this.r != null) {
            for (String str : this.d) {
                if (str.equals("mappls-navigation-route-layer") || str.equals("mappls-navigation-route-shield-layer")) {
                    Layer layer = style.getLayer(str);
                    if (layer != null) {
                        LineLayer lineLayer = (LineLayer) layer;
                        if (z) {
                            lineLayer.setFilter(Expression.literal(true));
                        } else {
                            lineLayer.setFilter(Expression.eq(Expression.get("primary-route"), true));
                        }
                    }
                }
            }
        }
    }
}
