package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class x implements CoordinateCallback {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ z c;

    public x(z zVar, HashMap map, ArrayList arrayList) {
        this.c = zVar;
        this.a = map;
        this.b = arrayList;
    }

    @Override // com.mappls.sdk.maps.CoordinateCallback
    public final void coordinateResultSuccess(List list) {
        if (list != null && list.size() > 0) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CoordinateResult coordinateResult = (CoordinateResult) it2.next();
                Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(coordinateResult.getLongitude().doubleValue(), coordinateResult.getLatitude().doubleValue()));
                featureFromGeometry.addStringProperty("wayPoint", (String) this.a.get(coordinateResult.getMapplsPin()));
                this.b.add(featureFromGeometry);
            }
        }
        z zVar = this.c;
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(this.b);
        zVar.y = featureCollectionFromFeatures;
        zVar.s.setGeoJson(featureCollectionFromFeatures);
    }

    @Override // com.mappls.sdk.maps.CoordinateCallback
    public final void onFailure() {
        z zVar = this.c;
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(this.b);
        zVar.y = featureCollectionFromFeatures;
        zVar.s.setGeoJson(featureCollectionFromFeatures);
    }
}
