package com.mappls.sdk.geoanalytics;

import android.graphics.Bitmap;
import android.view.View;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
class g {
    private MapplsMap a;
    private MapView b;
    private LatLng c;
    private FeatureCollection d = FeatureCollection.fromFeatures(new ArrayList());

    class a implements Style.OnStyleLoaded {
        final /* synthetic */ HashMap a;

        a(HashMap map) {
            this.a = map;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            style.addImages(this.a);
        }
    }

    class b implements Style.OnStyleLoaded {
        b() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource("com.mappls.sdk.geoanalytics.SOURCE_ID_STRING");
            if (geoJsonSource == null) {
                g.this.c(style);
            } else {
                geoJsonSource.setGeoJson(g.this.d);
            }
        }
    }

    public g(MapplsMap mapplsMap, MapView mapView) {
        this.a = mapplsMap;
        this.b = mapView;
    }

    private void a(Style style) {
        if (style.getLayer("com.mappls.sdk.geoanalytics.LAYER_ID_INFO_WINDOW") == null) {
            style.addLayer(new SymbolLayer("com.mappls.sdk.geoanalytics.LAYER_ID_INFO_WINDOW", "com.mappls.sdk.geoanalytics.SOURCE_ID_STRING").withProperties(PropertyFactory.iconImage("{name}"), PropertyFactory.iconAnchor("bottom"), PropertyFactory.iconAllowOverlap(Boolean.TRUE)));
        }
    }

    private void b(Style style) {
        if (style.getSource("com.mappls.sdk.geoanalytics.SOURCE_ID_STRING") == null) {
            style.addSource(new GeoJsonSource("com.mappls.sdk.geoanalytics.SOURCE_ID_STRING", this.d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Style style) {
        b(style);
        a(style);
    }

    public void a() {
        this.d = FeatureCollection.fromFeatures(new ArrayList());
        c();
    }

    public void a(View view, LatLng latLng) {
        this.c = latLng;
        Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
        featureFromGeometry.addStringProperty("name", "custom_info");
        this.d = FeatureCollection.fromFeature(featureFromGeometry);
        if (view != null) {
            new e(this, this.b, view).execute(new Void[0]);
            c();
        }
    }

    public void a(FeatureCollection featureCollection, LatLng latLng) {
        this.c = latLng;
        this.d = featureCollection;
        if (featureCollection != null) {
            new f(this, this.b).execute(featureCollection);
            c();
        }
    }

    void a(HashMap<String, Bitmap> map) {
        MapplsMap mapplsMap = this.a;
        if (mapplsMap != null) {
            mapplsMap.getStyle(new a(map));
        }
    }

    public void b() {
        c();
    }

    void c() {
        this.a.getStyle(new b());
    }
}
