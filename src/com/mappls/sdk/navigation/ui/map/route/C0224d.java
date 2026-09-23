package com.mappls.sdk.navigation.ui.map.route;

import android.os.Handler;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0224d extends Thread {
    public final ArrayList a;
    public final WeakReference c;
    public final Handler f;
    public final int g;
    public final ArrayList b = new ArrayList();
    public final HashMap d = new HashMap();
    public final AtomicBoolean e = new AtomicBoolean(false);

    public C0224d(ArrayList arrayList, int i, u uVar, Handler handler) {
        this.a = arrayList;
        this.c = new WeakReference(uVar);
        this.f = handler;
        this.g = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        E e;
        int i = 0;
        while (i < this.a.size()) {
            if (this.e.get()) {
                return;
            }
            DirectionsRoute directionsRoute = (DirectionsRoute) this.a.get(i);
            boolean z = i == this.g;
            ArrayList arrayList = new ArrayList();
            if (directionsRoute != null) {
                LineString lineStringFromPolyline = LineString.fromPolyline(directionsRoute.geometry(), 6);
                Feature featureFromGeometry = Feature.fromGeometry(lineStringFromPolyline);
                featureFromGeometry.addBooleanProperty("primary-route", Boolean.valueOf(z));
                arrayList.add(featureFromGeometry);
                this.d.put(lineStringFromPolyline, directionsRoute);
                ArrayList arrayList2 = new ArrayList();
                for (RouteLeg routeLeg : directionsRoute.legs()) {
                    if (routeLeg.annotation() == null || routeLeg.annotation().congestion() == null) {
                        arrayList2.add(Feature.fromGeometry(lineStringFromPolyline));
                    } else {
                        for (int i2 = 0; i2 < routeLeg.annotation().congestion().size(); i2++) {
                            if (routeLeg.annotation().congestion().size() + 1 <= lineStringFromPolyline.coordinates().size()) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(lineStringFromPolyline.coordinates().get(i2));
                                arrayList3.add(lineStringFromPolyline.coordinates().get(i2 + 1));
                                Feature featureFromGeometry2 = Feature.fromGeometry(LineString.fromLngLats(arrayList3));
                                featureFromGeometry2.addStringProperty(DirectionsCriteria.ANNOTATION_CONGESTION, routeLeg.annotation().congestion().get(i2));
                                featureFromGeometry2.addBooleanProperty("primary-route", Boolean.valueOf(z));
                                arrayList2.add(featureFromGeometry2);
                            }
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
            this.b.add(FeatureCollection.fromFeatures(arrayList));
            i++;
        }
        if (this.e.get() || (e = (E) this.c.get()) == null) {
            return;
        }
        this.f.post(new RunnableC0223c(this, e));
    }
}
