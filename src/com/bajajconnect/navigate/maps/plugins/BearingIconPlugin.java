package com.bajajconnect.navigate.maps.plugins;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bajajconnect.R;
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

/* JADX INFO: loaded from: classes3.dex */
public final class BearingIconPlugin implements MapView.OnDidFinishLoadingStyleListener {
    private static final String FILTER_TEXT = "direction_type";
    private static final String POSITION_TEXT = "position_text";
    private List<String> layerIds;
    private MapView mMapView;
    private MapplsMap mapplsMap;
    private LatLng position;
    private Handler handler = new Handler();
    private boolean bearingVisibility = false;
    private float bearing = 0.0f;
    private Runnable updatePolylineStateRunnable = new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.BearingIconPlugin$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.updateSelectedPolylineStates();
        }
    };
    private boolean enabled = false;

    public BearingIconPlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        this.mMapView = mapView;
        updateState();
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    static Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        if (z != this.enabled) {
            this.enabled = z;
            updateState();
        }
    }

    public void toggle() {
        this.enabled = !this.enabled;
        updateState();
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        updateState();
        if (isEnabled()) {
            updatePolylineStatus();
        }
    }

    private void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.BearingIconPlugin.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (style.getSource("directions_bearing") == null) {
                    BearingIconPlugin.this.initialise(style);
                } else {
                    BearingIconPlugin bearingIconPlugin = BearingIconPlugin.this;
                    bearingIconPlugin.setVisibility(bearingIconPlugin.enabled, style);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialise(Style style) {
        this.layerIds = new ArrayList();
        addDirectionPolylineSource(style);
        addDirectionsLayer(style);
    }

    private void addDirectionPolylineSource(Style style) {
        style.addSource(new GeoJsonSource("directions_bearing"));
    }

    private void addDirectionsLayer(Style style) {
        try {
            addBearingLayer(ContextCompat.getDrawable(this.mMapView.getContext(), R.drawable.user_puck_icon_demo), style);
        } catch (Exception unused) {
            Timber.e("Unable to attach Traffic Layers to current style.", new Object[0]);
        }
    }

    private String getLastAddedLayerId() {
        List<String> list = this.layerIds;
        return list.get(list.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibility(boolean z, Style style) {
        if (this.layerIds == null) {
            return;
        }
        List<Layer> layers = style.getLayers();
        if (layers != null && layers.size() > 0) {
            for (Layer layer : layers) {
                if (this.layerIds.contains(layer.getId())) {
                    PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
                    propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
                    layer.setProperties(propertyValueArr);
                }
            }
        }
        setBearingLayerVisibility(this.bearingVisibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateSelectedPolylineStates() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.BearingIconPlugin.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                BearingIconPlugin.this.setVisibility(true, style);
                ArrayList arrayList = new ArrayList();
                if (BearingIconPlugin.this.position != null) {
                    Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(BearingIconPlugin.this.position.getLongitude(), BearingIconPlugin.this.position.getLatitude()));
                    featureFromGeometry.addStringProperty("icon", "directions-marker-bearing-image");
                    featureFromGeometry.addStringProperty(BearingIconPlugin.FILTER_TEXT, "bearing");
                    arrayList.add(featureFromGeometry);
                }
                Layer layer = style.getLayer("directions-marker-bearing-layer");
                if (layer != null) {
                    layer.setProperties(PropertyFactory.iconRotate(Float.valueOf(BearingIconPlugin.this.bearing)));
                }
                FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList);
                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource("directions_bearing");
                if (geoJsonSource != null) {
                    geoJsonSource.setGeoJson(featureCollectionFromFeatures);
                }
            }
        });
    }

    private void updatePolylineStatus() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.updatePolylineStateRunnable, 100L);
    }

    public void removeAllData() {
        GeoJsonSource geoJsonSource;
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null && mapplsMap.getStyle() != null && this.mapplsMap.getStyle().isFullyLoaded() && (geoJsonSource = (GeoJsonSource) this.mapplsMap.getStyle().getSource("directions_bearing")) != null) {
            geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(new ArrayList()));
        }
        this.bearingVisibility = false;
        this.bearing = 0.0f;
    }

    public void setBearingLayerVisibility(boolean z) {
        Layer layer;
        if (this.mapplsMap.getStyle() != null && this.mapplsMap.getStyle().isFullyLoaded() && (layer = this.mapplsMap.getStyle().getLayer("directions-marker-bearing-layer")) != null) {
            PropertyValue<?>[] propertyValueArr = new PropertyValue[1];
            propertyValueArr[0] = PropertyFactory.visibility(z ? "visible" : "none");
            layer.setProperties(propertyValueArr);
        }
        this.bearingVisibility = z;
    }

    public void setBearingIcon(float f, LatLng latLng) {
        this.bearing = f;
        this.position = latLng;
        updatePolylineStatus();
    }

    private void addBearingLayer(Drawable drawable, Style style) {
        addLocationLayerToMap(getLayer("directions-marker-bearing-layer", "directions-marker-bearing-image", drawable, style), null, style);
    }

    private Layer getLayer(String str, String str2, Drawable drawable, Style style) {
        style.addImage(str2, getBitmapFromDrawable(drawable));
        return new SymbolLayer(str, "directions_bearing").withProperties(PropertyFactory.iconImage(str2), PropertyFactory.iconAllowOverlap((Boolean) true), PropertyFactory.iconIgnorePlacement((Boolean) true), PropertyFactory.iconRotationAlignment("map")).withFilter(Expression.match(Expression.get(FILTER_TEXT), Expression.literal(false), Expression.stop("bearing", true)));
    }

    private void addLocationLayerToMap(Layer layer, String str, Style style) {
        if (str == null) {
            style.addLayer(layer);
        } else {
            style.addLayerAbove(layer, str);
        }
        this.layerIds.add(layer.getId());
    }

    private static class DirectionPolylineData {
        private static final String SOURCE_ID = "directions_bearing";
        private static final String SOURCE_LAYER = "directions_bearing";

        private DirectionPolylineData() {
        }
    }

    private static class DirectionsSymbolLayer {
        private static final String BASE_BEARING_LAYER_ID = "directions-marker-bearing-layer";
        private static final String ICON_BEARING_IMAGE = "directions-marker-bearing-image";

        private DirectionsSymbolLayer() {
        }
    }
}
