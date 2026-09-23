package com.mappls.sdk.direction.ui.plugin;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements MapView.OnDidFinishLoadingStyleListener {
    private final MapplsMap a;
    private final MapView b;
    private FeatureCollection d;
    private HashMap e;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final Runnable f = new a();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l.this.c();
            l lVar = l.this;
            l.a(lVar, lVar.e);
        }
    }

    final class b implements Style.OnStyleLoaded {
        b() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource("mappls_directions_events_source_id");
            if (geoJsonSource == null) {
                l.a(l.this, style);
            } else if (l.this.d != null) {
                geoJsonSource.setGeoJson(l.this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface c {
        void a(Bitmap bitmap);
    }

    public l(MapView mapView, MapplsMap mapplsMap) {
        this.a = mapplsMap;
        this.b = mapView;
        c();
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    static void a(l lVar, HashMap map) {
        lVar.a.getStyle(new m(lVar, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a.getStyle(new b());
    }

    public final void a() {
        if (this.a.getStyle() == null || !this.a.getStyle().isFullyLoaded()) {
            return;
        }
        this.a.getStyle().removeLayer("mappls_directions_events_layer_id");
        this.a.getStyle().removeSource("mappls_directions_events_source_id");
    }

    public final void a(List<ReportDetails> list) {
        HashMap map;
        String id;
        this.e = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ReportDetails reportDetails : list) {
            Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(reportDetails.getLongitude().doubleValue(), reportDetails.getLatitude().doubleValue()));
            if (reportDetails.getChildCategory() == null || reportDetails.getParentCategory() == null) {
                featureFromGeometry.addStringProperty("mappls_directions_events_image_name", reportDetails.getId());
                map = this.e;
                id = reportDetails.getId();
            } else {
                featureFromGeometry.addStringProperty("mappls_directions_events_image_name", reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory());
                map = this.e;
                id = reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory();
            }
            map.put(id, reportDetails.getReportIcon("24px"));
            arrayList.add(featureFromGeometry);
        }
        this.d = FeatureCollection.fromFeatures(arrayList);
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(this.f, 100L);
    }

    public final void b() {
        GeoJsonSource geoJsonSource;
        if (this.a.getStyle() == null || !this.a.getStyle().isFullyLoaded() || (geoJsonSource = (GeoJsonSource) this.a.getStyle().getSourceAs("mappls_directions_events_source_id")) == null) {
            return;
        }
        geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(this.f, 100L);
    }

    static void a(l lVar, Style style) {
        style.addSource(lVar.d != null ? new GeoJsonSource("mappls_directions_events_source_id", lVar.d) : new GeoJsonSource("mappls_directions_events_source_id"));
        style.addLayerAbove(new SymbolLayer("mappls_directions_events_layer_id", "mappls_directions_events_source_id").withProperties(PropertyFactory.iconImage(Expression.get("mappls_directions_events_image_name"))), "com.mappls.sdk.directions.route_selected");
    }
}
