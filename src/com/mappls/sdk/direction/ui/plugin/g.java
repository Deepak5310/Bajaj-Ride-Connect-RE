package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class g implements Runnable {
    final /* synthetic */ f a;

    final class a implements Runnable {
        final /* synthetic */ List a;

        /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.plugin.g$a$a, reason: collision with other inner class name */
        final class C0076a implements Style.OnStyleLoaded {
            C0076a() {
            }

            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public final void onStyleLoaded(Style style) {
                FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures((List<Feature>) a.this.a);
                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSourceAs("com.mappls.sdk.directions.DIRECTIONS_SOURCE_ID");
                if (geoJsonSource != null) {
                    geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                }
                f.a(g.this.a, true, style);
            }
        }

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.a.c.getStyle(new C0076a());
        }
    }

    g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LineString lineString;
        ArrayList arrayList = new ArrayList(this.a.f.size());
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.f.size()) {
            LineString lineString2 = (LineString) this.a.f.get(i2);
            Feature featureFromGeometry = Feature.fromGeometry(lineString2);
            featureFromGeometry.addStringProperty("mappls_direction_direction_type", this.a.l.equalsIgnoreCase("walking") ? this.a.k == i2 ? "selected-walking" : "alternate-walking" : this.a.k == i2 ? "selected" : "alternate");
            featureFromGeometry.addNumberProperty("mappls_direction_position_text", Integer.valueOf(i2));
            arrayList.add(featureFromGeometry);
            int i3 = i2 + 1;
            int size = lineString2.coordinates().size() / i3;
            Feature featureFromGeometry2 = Feature.fromGeometry((size <= 0 || size >= lineString2.coordinates().size()) ? lineString2.coordinates().get(lineString2.coordinates().size() / 2) : lineString2.coordinates().get(size));
            StringBuilder sb = new StringBuilder();
            sb.append(((DirectionsRoute) this.a.j.get(i2)).duration());
            sb.append(i2 == this.a.k ? "-selected" : "-alternative");
            featureFromGeometry2.addStringProperty("com.mappls.sdk.directions.directions-property-icon-eta", sb.toString());
            featureFromGeometry2.addStringProperty("com.mappls.sdk.directions.directions-property-eta-selection-type", i2 == this.a.k ? "com.mappls.sdk.directions.directions-property-eta-selected-filter" : "com.mappls.sdk.directions.directions-property-eta-alternative-filter");
            featureFromGeometry2.addStringProperty("mappls_direction_direction_type", "com.mappls.sdk.directions.directions-property-value-filter-callouts");
            featureFromGeometry2.addNumberProperty("com.mappls.sdk.directions.directions-property-value-eta-index", Integer.valueOf(i2));
            arrayList.add(featureFromGeometry2);
            i2 = i3;
        }
        if (this.a.f.size() > this.a.k && (lineString = (LineString) this.a.f.get(this.a.k)) != null) {
            List<Point> listCoordinates = lineString.coordinates();
            if (listCoordinates.size() > 2) {
                Feature featureFromGeometry3 = Feature.fromGeometry(listCoordinates.get(0));
                featureFromGeometry3.addStringProperty("icon", "com.mappls.sdk.directions.mappls_direction_start_polyline");
                featureFromGeometry3.addStringProperty("mappls_direction_direction_type", "line-point-marker");
                arrayList.add(featureFromGeometry3);
                Feature featureFromGeometry4 = Feature.fromGeometry(listCoordinates.get(listCoordinates.size() - 1));
                featureFromGeometry4.addStringProperty("icon", "com.mappls.sdk.directions.mappls_direction_end_polyline");
                featureFromGeometry4.addStringProperty("mappls_direction_direction_type", "line-point-marker");
                arrayList.add(featureFromGeometry4);
            }
        }
        this.a.getClass();
        if (this.a.g != null) {
            Feature featureFromGeometry5 = Feature.fromGeometry(Point.fromLngLat(this.a.g.getLongitude(), this.a.g.getLatitude()));
            featureFromGeometry5.addStringProperty("com.mappls.sdk.directions.directions-marker-image", "com.mappls.sdk.directions.mappls_direction_start_marker");
            featureFromGeometry5.addStringProperty("mappls_direction_direction_type", "marker");
            arrayList.add(f.a(this.a, featureFromGeometry5, "start-marker"));
        }
        if (this.a.h != null) {
            Feature featureFromGeometry6 = Feature.fromGeometry(Point.fromLngLat(this.a.h.getLongitude(), this.a.h.getLatitude()));
            featureFromGeometry6.addStringProperty("com.mappls.sdk.directions.directions-marker-image", "com.mappls.sdk.directions.mappls_direction_end_marker");
            featureFromGeometry6.addStringProperty("mappls_direction_direction_type", "marker");
            arrayList.add(f.a(this.a, featureFromGeometry6, "end-marker"));
        }
        if (this.a.i != null) {
            for (LatLng latLng : this.a.i) {
                Feature featureFromGeometry7 = Feature.fromGeometry(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
                StringBuilder sb2 = new StringBuilder("com.mappls.sdk.directions.mappls_direction_via_points_");
                int i4 = i + 1;
                sb2.append(i4);
                featureFromGeometry7.addStringProperty("com.mappls.sdk.directions.directions-marker-image", sb2.toString());
                featureFromGeometry7.addStringProperty("mappls_direction_direction_type", "marker");
                arrayList.add(f.a(this.a, featureFromGeometry7, "via-marker-" + i));
                i = i4;
            }
        }
        this.a.d.post(new a(arrayList));
        f.a(this.a, arrayList);
    }
}
