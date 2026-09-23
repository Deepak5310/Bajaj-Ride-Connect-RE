package com.bajajconnect.navigate.maps.plugins;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class MapEventsPlugin implements MapView.OnDidFinishLoadingStyleListener {
    private static final String IMAGE_NAME = "mappls_events_image_name";
    private static final String LAYER_ID = "mappls_events_layer_id";
    private static final String SOURCE_ID = "mappls_events_source_id";
    private FeatureCollection featureCollection;
    private Map<String, String> imagesMap;
    private MapView mMapView;
    private MapplsMap mapplsMap;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable updateMapEvents = new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin.1
        @Override // java.lang.Runnable
        public void run() {
            MapEventsPlugin.this.updateState();
            MapEventsPlugin mapEventsPlugin = MapEventsPlugin.this;
            mapEventsPlugin.addImagesOnMap(mapEventsPlugin.imagesMap);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    interface OnImageAdded {
        void getBitmap(Bitmap bitmap);
    }

    public MapEventsPlugin(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        this.mMapView = mapView;
        mapView.addOnDidFinishLoadingStyleListener(this);
        updateState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateState() {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                GeoJsonSource geoJsonSource = (GeoJsonSource) style.getSource(MapEventsPlugin.SOURCE_ID);
                if (geoJsonSource == null) {
                    MapEventsPlugin.this.initialize("directions-marker-layer", style);
                } else if (MapEventsPlugin.this.featureCollection != null) {
                    geoJsonSource.setGeoJson(MapEventsPlugin.this.featureCollection);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize(String str, Style style) {
        addSource(style);
        addLayer(str, style);
    }

    private void addLayer(String str, Style style) {
        style.addLayerAbove(new SymbolLayer(LAYER_ID, SOURCE_ID).withProperties(PropertyFactory.iconImage(Expression.get(IMAGE_NAME))), str);
    }

    private void addSource(Style style) {
        GeoJsonSource geoJsonSource;
        if (this.featureCollection != null) {
            geoJsonSource = new GeoJsonSource(SOURCE_ID, this.featureCollection);
        } else {
            geoJsonSource = new GeoJsonSource(SOURCE_ID);
        }
        style.addSource(geoJsonSource);
    }

    public void setNavigationEvents(List<ReportDetails> list) {
        this.imagesMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ReportDetails reportDetails : list) {
            Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(reportDetails.getLongitude().doubleValue(), reportDetails.getLatitude().doubleValue()));
            if (reportDetails.getChildCategory() != null && reportDetails.getParentCategory() != null) {
                featureFromGeometry.addStringProperty(IMAGE_NAME, reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory());
                this.imagesMap.put(reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory(), reportDetails.getReportIcon("24px"));
            } else {
                featureFromGeometry.addStringProperty(IMAGE_NAME, reportDetails.getId());
                this.imagesMap.put(reportDetails.getId(), reportDetails.getReportIcon("24px"));
            }
            arrayList.add(featureFromGeometry);
        }
        this.featureCollection = FeatureCollection.fromFeatures(arrayList);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.updateMapEvents, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addImagesOnMap(final Map<String, String> map) {
        this.mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin.3

            /* JADX INFO: renamed from: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin$3$1, reason: invalid class name */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ Style val$style;

                AnonymousClass1(Style style) {
                    this.val$style = style;
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (final String str : map.keySet()) {
                        if (this.val$style.getImage(str) == null) {
                            MapEventsPlugin mapEventsPlugin = MapEventsPlugin.this;
                            String str2 = (String) map.get(str);
                            final Style style = this.val$style;
                            mapEventsPlugin.getBitmap(str2, new OnImageAdded() { // from class: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin$3$1$$ExternalSyntheticLambda0
                                @Override // com.bajajconnect.navigate.maps.plugins.MapEventsPlugin.OnImageAdded
                                public final void getBitmap(Bitmap bitmap) {
                                    MapEventsPlugin.AnonymousClass3.AnonymousClass1.lambda$run$0(style, str, bitmap);
                                }
                            });
                        }
                    }
                }

                static /* synthetic */ void lambda$run$0(Style style, String str, Bitmap bitmap) {
                    try {
                        style.addImageAsync(str, bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                MapEventsPlugin.this.mMapView.post(new AnonymousClass1(style));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBitmap(final String str, final OnImageAdded onImageAdded) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.navigate.maps.plugins.MapEventsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                URL url;
                Bitmap bitmapDecodeStream = null;
                try {
                    url = new URL(str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).getInputStream());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                onImageAdded.getBitmap(bitmapDecodeStream);
            }
        });
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.updateMapEvents, 100L);
    }
}
