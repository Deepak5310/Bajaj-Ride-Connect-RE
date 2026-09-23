package com.mappls.sdk.navigation.ui.map.route;

import android.os.Handler;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0222b extends Thread {
    public final List a;
    public final WeakReference b;
    public FeatureCollection c = FeatureCollection.fromFeatures(new ArrayList());
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final Handler e;

    public C0222b(List list, k kVar, Handler handler) {
        this.a = list;
        this.b = new WeakReference(kVar);
        this.e = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C c;
        List list = this.a;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ReportDetails reportDetails : this.a) {
                if (this.d.get()) {
                    return;
                }
                Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(reportDetails.getLongitude().doubleValue(), reportDetails.getLatitude().doubleValue()));
                if (reportDetails.getChildCategory() == null || reportDetails.getParentCategory() == null) {
                    featureFromGeometry.addStringProperty("mappls-navigation-route-event-marker", reportDetails.getId());
                } else {
                    featureFromGeometry.addStringProperty("mappls-navigation-route-event-marker", reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory());
                }
                arrayList.add(featureFromGeometry);
            }
            this.c = FeatureCollection.fromFeatures(arrayList);
        }
        if (this.d.get() || (c = (C) this.b.get()) == null) {
            return;
        }
        this.e.post(new RunnableC0221a(this, c));
    }
}
