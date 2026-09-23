package com.mappls.sdk.geoanalytics;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.style.layers.RasterLayer;
import com.mappls.sdk.maps.style.sources.RasterSource;
import com.mappls.sdk.maps.style.sources.TileSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.functions.FuncN;
import rx.plugins.RxJavaSchedulersHook;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public class c implements MapView.OnDidFinishLoadingStyleListener {
    private static final String LAYER_ID = "com.mappls.sdk.geoanalytics.WMS_LAYER_ID_";
    private static final String LAYER_ID_INFO_WINDOW = "com.mappls.sdk.geoanalytics.LAYER_ID_INFO_WINDOW";
    private static final String SOURCE_ID = "com.mappls.sdk.geoanalytics.WMS_SOURCE_ID_";
    private CustomGeoAnalyticsInfoWindowAdapter customGeoAnalyticsInfoWindowAdapter;
    g geoAnalyticsAnnotationPlugin;
    private MapplsGeoAnalyticsCallback mCallback;
    private final MapView mapView;
    private final MapplsMap mapplsMap;
    private boolean showInfoWindow = true;
    private Map<h, List<MapplsGeoAnalyticsRequest>> addedLayer = new HashMap();

    class a implements Style.OnStyleLoaded {
        final /* synthetic */ h a;
        final /* synthetic */ boolean b;
        final /* synthetic */ List c;

        a(h hVar, boolean z, List list) {
            this.a = hVar;
            this.b = z;
            this.c = list;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            ArrayList arrayList = new ArrayList();
            c.this.removeLayer(this.a, style, this.b);
            if (!this.b) {
                c.this.addedLayer.put(this.a, this.c);
            }
            for (int i = 0; i < this.c.size(); i++) {
                arrayList.add(this.a != h.VILLAGE ? MapplsGeoAnalytics.createUrl(c.this.mapView, this.a, (MapplsGeoAnalyticsRequest) this.c.get(i)) : MapplsGeoAnalytics.createPointUrl(c.this.mapView, this.a, (MapplsGeoAnalyticsRequest) this.c.get(i)));
            }
            c.this.createLayer(this.a, arrayList, style);
        }
    }

    class b implements Style.OnStyleLoaded {
        final /* synthetic */ MapplsGeoAnalyticsType a;

        b(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
            this.a = mapplsGeoAnalyticsType;
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            c.this.removeLayer(h.a(this.a), style, false);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.c$c, reason: collision with other inner class name */
    class C0080c implements MapplsMap.OnMapClickListener {
        private FeatureCollection a;

        /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.c$c$a */
        class a implements FuncN<CombinedResponse> {
            a() {
            }

            @Override // rx.functions.FuncN
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CombinedResponse call(Object... objArr) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArr) {
                    if (obj instanceof ResponseBody) {
                        arrayList.add((ResponseBody) obj);
                    }
                }
                return new CombinedResponse(arrayList);
            }
        }

        /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.c$c$b */
        class b extends Subscriber<CombinedResponse> {
            final /* synthetic */ LatLng a;

            /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.c$c$b$a */
            class a implements Runnable {
                final /* synthetic */ List a;

                a(List list) {
                    this.a = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    cVar.geoAnalyticsAnnotationPlugin.a(cVar.customGeoAnalyticsInfoWindowAdapter.setCustomInfoWindow(this.a), b.this.a);
                }
            }

            /* JADX INFO: renamed from: com.mappls.sdk.geoanalytics.c$c$b$b, reason: collision with other inner class name */
            class RunnableC0081b implements Runnable {
                RunnableC0081b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0080c c0080c = C0080c.this;
                    c.this.geoAnalyticsAnnotationPlugin.a(c0080c.a, b.this.a);
                }
            }

            b(LatLng latLng) {
                this.a = latLng;
            }

            @Override // rx.Observer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(CombinedResponse combinedResponse) {
                C0080c c0080c;
                FeatureCollection featureCollectionFromFeatures;
                FeatureCollection featureCollectionFromJson;
                if (combinedResponse != null) {
                    List<ResponseBody> responseBodies = combinedResponse.getResponseBodies();
                    if (responseBodies != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<ResponseBody> it2 = responseBodies.iterator();
                        while (it2.hasNext()) {
                            try {
                                featureCollectionFromJson = FeatureCollection.fromJson(it2.next().string());
                            } catch (Exception e) {
                                FeatureCollection featureCollectionFromFeatures2 = FeatureCollection.fromFeatures(new ArrayList());
                                e.printStackTrace();
                                featureCollectionFromJson = featureCollectionFromFeatures2;
                            }
                            if (featureCollectionFromJson.features() != null) {
                                arrayList.addAll(featureCollectionFromJson.features());
                            }
                        }
                        if (arrayList.size() > 0) {
                            Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(this.a.getLongitude(), this.a.getLatitude()));
                            featureFromGeometry.addStringProperty("id", ((Feature) arrayList.get(0)).id());
                            featureFromGeometry.addProperty("properties", ((Feature) arrayList.get(0)).properties());
                            featureFromGeometry.addStringProperty("name", ((Feature) arrayList.get(0)).id());
                            arrayList.add(featureFromGeometry);
                            c0080c = C0080c.this;
                            featureCollectionFromFeatures = FeatureCollection.fromFeature((Feature) arrayList.get(arrayList.size() - 1));
                        } else {
                            c0080c = C0080c.this;
                            featureCollectionFromFeatures = FeatureCollection.fromFeatures(new ArrayList());
                        }
                        c0080c.a = featureCollectionFromFeatures;
                    }
                    Timber.tag("TAG").e(combinedResponse.getResponseBodies().size() + "", new Object[0]);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                MapView mapView;
                Runnable runnableC0081b;
                List<Feature> listFeatures;
                ArrayList arrayList = new ArrayList();
                if (C0080c.this.a != null && (listFeatures = C0080c.this.a.features()) != null) {
                    int size = listFeatures.size();
                    for (int i = 0; i < size; i++) {
                        if (listFeatures.get(i).properties() != null) {
                            MapplsGeoAnalyticsDetail mapplsGeoAnalyticsDetail = (MapplsGeoAnalyticsDetail) new Gson().fromJson((JsonElement) listFeatures.get(i).properties(), MapplsGeoAnalyticsDetail.class);
                            mapplsGeoAnalyticsDetail.setType(C0080c.this.a(listFeatures.get(i).id()));
                            arrayList.add(mapplsGeoAnalyticsDetail);
                        }
                    }
                }
                if (c.this.showInfoWindow) {
                    if (c.this.customGeoAnalyticsInfoWindowAdapter != null) {
                        mapView = c.this.mapView;
                        runnableC0081b = new a(arrayList);
                    } else {
                        mapView = c.this.mapView;
                        runnableC0081b = new RunnableC0081b();
                    }
                    mapView.post(runnableC0081b);
                }
                if (c.this.mCallback != null) {
                    c.this.mCallback.getSelectedFeatures(arrayList);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                th.printStackTrace();
            }
        }

        C0080c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(String str) {
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.split("\\.");
            return strArrSplit.length > 0 ? strArrSplit[0] : str;
        }

        private List<Observable<ResponseBody>> a(h hVar, LatLng latLng) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ((List) c.this.addedLayer.get(hVar)).iterator();
            while (it2.hasNext()) {
                arrayList.add(MapplsGeoAnalytics.getFeatureCollection(c.this.mapView, c.this.mapplsMap, hVar, (MapplsGeoAnalyticsRequest) it2.next(), latLng));
            }
            return arrayList;
        }

        private void a(LatLng latLng) {
            List<Feature> listQueryRenderedFeatures;
            if (c.this.mapplsMap.getStyle() != null && c.this.mapplsMap.getStyle().isFullyLoaded() && c.this.mapplsMap.getStyle().getLayer(c.LAYER_ID_INFO_WINDOW) != null && (listQueryRenderedFeatures = c.this.mapplsMap.queryRenderedFeatures(c.this.mapplsMap.getProjection().toScreenLocation(latLng), c.LAYER_ID_INFO_WINDOW)) != null && listQueryRenderedFeatures.size() > 0) {
                g gVar = c.this.geoAnalyticsAnnotationPlugin;
                if (gVar != null) {
                    gVar.a();
                    return;
                }
                return;
            }
            g gVar2 = c.this.geoAnalyticsAnnotationPlugin;
            if (gVar2 != null) {
                gVar2.a();
            }
            ArrayList arrayList = new ArrayList();
            Map map = c.this.addedLayer;
            h hVar = h.STATE;
            if (map.containsKey(hVar)) {
                arrayList.addAll(a(hVar, latLng));
            }
            Map map2 = c.this.addedLayer;
            h hVar2 = h.DISTRICT;
            if (map2.containsKey(hVar2)) {
                arrayList.addAll(a(hVar2, latLng));
            }
            Map map3 = c.this.addedLayer;
            h hVar3 = h.SUB_DISTRICT;
            if (map3.containsKey(hVar3)) {
                arrayList.addAll(a(hVar3, latLng));
            }
            Map map4 = c.this.addedLayer;
            h hVar4 = h.TOWN;
            if (map4.containsKey(hVar4)) {
                arrayList.addAll(a(hVar4, latLng));
            }
            Map map5 = c.this.addedLayer;
            h hVar5 = h.WARD;
            if (map5.containsKey(hVar5)) {
                arrayList.addAll(a(hVar5, latLng));
            }
            Map map6 = c.this.addedLayer;
            h hVar6 = h.BLOCK;
            if (map6.containsKey(hVar6)) {
                arrayList.addAll(a(hVar6, latLng));
            }
            Map map7 = c.this.addedLayer;
            h hVar7 = h.PANCHAYAT;
            if (map7.containsKey(hVar7)) {
                arrayList.addAll(a(hVar7, latLng));
            }
            Map map8 = c.this.addedLayer;
            h hVar8 = h.VILLAGE;
            if (map8.containsKey(hVar8)) {
                arrayList.addAll(a(hVar8, latLng));
            }
            Map map9 = c.this.addedLayer;
            h hVar9 = h.PINCODE;
            if (map9.containsKey(hVar9)) {
                arrayList.addAll(a(hVar9, latLng));
            }
            Map map10 = c.this.addedLayer;
            h hVar10 = h.CITY;
            if (map10.containsKey(hVar10)) {
                arrayList.addAll(a(hVar10, latLng));
            }
            Map map11 = c.this.addedLayer;
            h hVar11 = h.LOCALITY;
            if (map11.containsKey(hVar11)) {
                arrayList.addAll(a(hVar11, latLng));
            }
            Map map12 = c.this.addedLayer;
            h hVar12 = h.SUB_LOCALITY;
            if (map12.containsKey(hVar12)) {
                arrayList.addAll(a(hVar12, latLng));
            }
            Map map13 = c.this.addedLayer;
            h hVar13 = h.SUB_SUB_LOCALITY;
            if (map13.containsKey(hVar13)) {
                arrayList.addAll(a(hVar13, latLng));
            }
            Observable.zip(arrayList, new a()).subscribeOn(RxJavaSchedulersHook.createIoScheduler()).subscribe((Subscriber) new b(latLng));
        }

        @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
        public boolean onMapClick(LatLng latLng) {
            a(latLng);
            return false;
        }
    }

    c(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        this.mapView = mapView;
        this.geoAnalyticsAnnotationPlugin = new g(mapplsMap, mapView);
        mapplsMap.addOnMapClickListener(new C0080c());
        mapView.addOnDidFinishLoadingStyleListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLayer(h hVar, List<String> list, Style style) {
        for (int i = 0; i < list.size(); i++) {
            style.addSource(new RasterSource(SOURCE_ID + hVar.a + i, new TileSet("tileset", list.get(i))));
            if (style.getLayer(LAYER_ID_INFO_WINDOW) != null) {
                style.addLayerBelow(new RasterLayer(LAYER_ID + hVar.a + i, SOURCE_ID + hVar.a + i), LAYER_ID_INFO_WINDOW);
            } else {
                style.addLayer(new RasterLayer(LAYER_ID + hVar.a + i, SOURCE_ID + hVar.a + i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLayer(h hVar, Style style, boolean z) {
        if (style.isFullyLoaded()) {
            if (this.addedLayer.containsKey(hVar)) {
                List<MapplsGeoAnalyticsRequest> list = this.addedLayer.get(hVar);
                for (int i = 0; i < list.size(); i++) {
                    style.removeLayer(LAYER_ID + hVar.a + i);
                    style.removeSource(SOURCE_ID + hVar.a + i);
                }
            }
            if (z) {
                return;
            }
            this.addedLayer.remove(hVar);
        }
    }

    private void showGeoAnalytics(h hVar, List<MapplsGeoAnalyticsRequest> list, boolean z) {
        this.mapplsMap.getStyle(new a(hVar, z, list));
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        for (h hVar : this.addedLayer.keySet()) {
            showGeoAnalytics(hVar, this.addedLayer.get(hVar), true);
            this.geoAnalyticsAnnotationPlugin.b();
        }
    }

    void removeLayer(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
        this.mapplsMap.getStyle(new b(mapplsGeoAnalyticsType));
    }

    void setCustomGeoAnalyticsInfoWindowAdapter(CustomGeoAnalyticsInfoWindowAdapter customGeoAnalyticsInfoWindowAdapter) {
        this.customGeoAnalyticsInfoWindowAdapter = customGeoAnalyticsInfoWindowAdapter;
    }

    void setGeoAnalyticsCallback(MapplsGeoAnalyticsCallback mapplsGeoAnalyticsCallback) {
        this.mCallback = mapplsGeoAnalyticsCallback;
    }

    void shouldShowInfoWindow(boolean z) {
        this.showInfoWindow = z;
    }

    void showGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType, List<MapplsGeoAnalyticsRequest> list) {
        showGeoAnalytics(h.a(mapplsGeoAnalyticsType), list, false);
    }
}
