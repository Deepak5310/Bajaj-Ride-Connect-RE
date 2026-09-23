package com.mappls.sdk.direction.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.layers.SymbolLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements MapView.OnDidFinishLoadingStyleListener {
    private LatLng d;
    private MapplsMap e;
    private MapView f;
    private ArrayList g;
    private Handler a = new Handler();
    private boolean b = false;
    private float c = 0.0f;
    private Runnable h = new Runnable() { // from class: com.mappls.sdk.direction.ui.plugin.a$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.b();
        }
    };

    /* JADX INFO: renamed from: com.mappls.sdk.direction.ui.plugin.a$a, reason: collision with other inner class name */
    final class C0074a implements Style.OnStyleLoaded {
        C0074a() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            style.removeLayer("directions-marker-bearing-layer");
            style.removeSource("directions_bearing");
            a.a(a.this, style);
        }
    }

    final class b implements Style.OnStyleLoaded {
        b() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            a.this.a(style);
            style.removeLayer("directions-marker-bearing-layer");
            style.removeSource("directions_bearing");
        }
    }

    final class c implements Style.OnStyleLoaded {
        c() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            a.a(a.this, true, style);
            ArrayList arrayList = new ArrayList();
            if (a.this.d != null) {
                Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(a.this.d.getLongitude(), a.this.d.getLatitude()));
                featureFromGeometry.addStringProperty("icon", "directions-marker-bearing-image");
                featureFromGeometry.addStringProperty("direction_type", "bearing");
                arrayList.add(featureFromGeometry);
            }
            Layer layer = style.getLayer("directions-marker-bearing-layer");
            if (layer != null) {
                layer.setProperties(PropertyFactory.iconRotate(Float.valueOf(a.this.c)));
            }
            FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList);
            GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource("directions_bearing");
            if (geoJsonSource != null) {
                geoJsonSource.setGeoJson(featureCollectionFromFeatures);
            }
        }
    }

    final class d implements Style.OnStyleLoaded {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            Layer layer = style.getLayer("directions-marker-bearing-layer");
            if (layer != null) {
                PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                propertyValueArr[0] = PropertyFactory.visibility(this.a ? "visible" : "none");
                layer.setProperties(propertyValueArr);
            }
        }
    }

    public a(MapView mapView, MapplsMap mapplsMap) {
        this.e = mapplsMap;
        this.f = mapView;
        mapplsMap.getStyle(new C0074a());
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    static void a(a aVar, Style style) {
        aVar.getClass();
        aVar.g = new ArrayList();
        style.addSource(new GeoJsonSource("directions_bearing"));
        try {
            aVar.a(ContextCompat.getDrawable(aVar.f.getContext(), R.drawable.mappls_direction_user_puck_icon_demo), style);
        } catch (Exception unused) {
            Timber.e("Unable to attach Traffic Layers to current style.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        this.e.getStyle(new c());
    }

    public final void a() {
        this.e.getStyle(new b());
    }

    public final void a(Style style) {
        GeoJsonSource geoJsonSource;
        if (this.e != null && (geoJsonSource = (GeoJsonSource) style.getSource("directions_bearing")) != null) {
            geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
        }
        this.b = false;
        this.c = 0.0f;
    }

    public final void a(boolean z) {
        this.e.getStyle(new d(z));
        this.b = z;
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        this.e.getStyle(new com.mappls.sdk.direction.ui.plugin.b(this));
    }

    static void a(a aVar, boolean z, Style style) {
        if (aVar.g == null) {
            return;
        }
        List<Layer> layers = style.getLayers();
        if (layers != null && layers.size() > 0) {
            for (Layer layer : layers) {
                if (aVar.g.contains(layer.getId())) {
                    PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                    propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                    layer.setProperties(propertyValueArr);
                }
            }
        }
        aVar.a(aVar.b);
    }

    private void a(Drawable drawable, Style style) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        style.addImage("directions-marker-bearing-image", bitmap);
        SymbolLayer symbolLayer = new SymbolLayer("directions-marker-bearing-layer", "directions_bearing");
        Boolean bool = Boolean.TRUE;
        SymbolLayer symbolLayerWithFilter = symbolLayer.withProperties(PropertyFactory.iconImage("directions-marker-bearing-image"), PropertyFactory.iconAllowOverlap(bool), PropertyFactory.iconIgnorePlacement(bool), PropertyFactory.iconRotationAlignment("map")).withFilter(Expression.match(Expression.get("direction_type"), Expression.literal(false), Expression.stop("bearing", bool)));
        style.addLayer(symbolLayerWithFilter);
        this.g.add(symbolLayerWithFilter.getId());
    }

    public final void a(float f, LatLng latLng) {
        this.c = f;
        this.d = latLng;
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(this.h, 100L);
    }
}
