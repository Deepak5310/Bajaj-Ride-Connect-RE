package com.mappls.sdk.plugins.places.placepicker.plugin;

import android.graphics.Color;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.layers.CircleLayer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.plugins.places.placepicker.model.PlacePickerOptions;
import com.mappls.sdk.services.api.EntryCoordinate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements MapView.OnDidFinishLoadingStyleListener {
    private final MapView a;
    private final MapplsMap b;
    private final PlacePickerOptions c;
    private List<EntryCoordinate> d;

    final class a implements Style.OnStyleLoaded {
        a() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            d.a(d.this, style);
            d.b(d.this, style);
        }
    }

    final class b implements Style.OnStyleLoaded {
        b() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            style.removeLayer("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.LAYER_ID");
            style.removeSource("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID");
        }
    }

    public d(MapView mapView, MapplsMap mapplsMap, PlacePickerOptions placePickerOptions) {
        this.a = mapView;
        this.b = mapplsMap;
        this.c = placePickerOptions;
        b();
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    static void a(d dVar, Style style) {
        dVar.getClass();
        if (style.isFullyLoaded()) {
            ArrayList arrayList = new ArrayList();
            List<EntryCoordinate> list = dVar.d;
            if (list != null) {
                for (EntryCoordinate entryCoordinate : list) {
                    arrayList.add(Feature.fromGeometry(Point.fromLngLat(entryCoordinate.getEntryLongitude(), entryCoordinate.getEntryLatitude())));
                }
            }
            if (style.getSource("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID") == null) {
                style.addSource(new GeoJsonSource("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID", FeatureCollection.fromFeatures(arrayList)));
            } else {
                ((GeoJsonSource) style.getSourceAs("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID")).setGeoJson(FeatureCollection.fromFeatures(arrayList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.b.getStyle(new a());
    }

    static void b(d dVar, Style style) {
        dVar.getClass();
        if (style.isFullyLoaded() && style.getLayer("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.LAYER_ID") == null) {
            CircleLayer circleLayer = new CircleLayer("com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.LAYER_ID", "com.mappls.sdk.plugins.places.placepicker.plugin.EntryCoordinatePlugin.SOURCE_ID");
            circleLayer.withProperties(PropertyFactory.circleColor(Color.parseColor(dVar.c.entryCoordinateCircleColor())), PropertyFactory.circleRadius(dVar.c.entryCoordinateCircleRadius()));
            style.addLayer(circleLayer);
        }
    }

    public final void c() {
        this.b.getStyle(new b());
        this.a.removeOnDidFinishLoadingStyleListener(this);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        b();
    }

    public final void a() {
        this.d = new ArrayList();
        this.b.getStyle(new e(this));
    }

    public final void a(List<EntryCoordinate> list) {
        this.d = list;
        this.b.getStyle(new e(this));
    }
}
