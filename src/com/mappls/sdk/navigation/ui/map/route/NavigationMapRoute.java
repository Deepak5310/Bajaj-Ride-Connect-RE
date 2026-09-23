package com.mappls.sdk.navigation.ui.map.route;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.navigation.camera.INavigation;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationMapRoute implements LifecycleObserver, MapView.OnDidFinishLoadingStyleListener {
    private final MapplsMap a;
    private final MapView b;
    private i c;
    private A d;
    private boolean e;
    private boolean f;
    private final z g;
    private final C0228h h;
    private final q i;
    private final INavigation j;

    public NavigationMapRoute(MapView mapView, MapplsMap mapplsMap, INavigation iNavigation, int i) {
        this.e = false;
        this.f = false;
        this.b = mapView;
        this.a = mapplsMap;
        this.j = iNavigation;
        Context context = mapView.getContext();
        z zVar = new z(context, mapplsMap, i, new j(context), new B(), new r(), new Handler(context.getMainLooper()));
        this.g = zVar;
        C0228h c0228h = new C0228h(mapView, mapplsMap, zVar.a(), i);
        this.h = c0228h;
        String strA = zVar.a();
        if (!c0228h.e.isEmpty()) {
            ArrayList arrayList = c0228h.e;
            strA = (String) arrayList.get(arrayList.size() - 1);
        }
        this.i = new q(mapView, mapplsMap, strA);
        i iVar = new i(zVar);
        this.c = iVar;
        this.d = new A(c0228h);
        if (!this.e) {
            mapplsMap.addOnMapClickListener(iVar);
            this.e = true;
        }
        if (iNavigation != null) {
            iNavigation.setProgressChangeListener(this.d);
        }
        if (this.f) {
            return;
        }
        mapView.addOnDidFinishLoadingStyleListener(this);
        this.f = true;
    }

    public final void a() {
        z zVar = this.g;
        if (zVar != null && zVar.r.getStyle() != null && zVar.r.getStyle().isFullyLoaded()) {
            zVar.r.getStyle().removeLayer("mappls-navigation-waypoint-layer");
            zVar.r.getStyle().removeSource("mappls-navigation-waypoint-source");
            zVar.r.getStyle().removeLayer("mappls-navigation-route-layer");
            zVar.r.getStyle().removeLayer("mappls-navigation-route-shield-layer");
            zVar.r.getStyle().removeSource("mappls-navigation-route-source");
        }
        C0228h c0228h = this.h;
        if (c0228h != null && c0228h.d.getStyle() != null && c0228h.d.getStyle().isFullyLoaded()) {
            c0228h.d.getStyle().removeLayer("mappls-navigation-arrow-shaft-casing-layer");
            c0228h.d.getStyle().removeLayer("mappls-navigation-arrow-shaft-layer");
            c0228h.d.getStyle().removeLayer("mappls-navigation-arrow-head-layer");
            c0228h.d.getStyle().removeLayer("mappls-navigation-arrow-head-casing-layer");
            c0228h.d.getStyle().removeSource("mappls-navigation-arrow-shaft-source");
            c0228h.d.getStyle().removeSource("mappls-navigation-arrow-head-source");
        }
        q qVar = this.i;
        if (qVar == null || qVar.b.getStyle() == null || !qVar.b.getStyle().isFullyLoaded()) {
            return;
        }
        qVar.b.getStyle().removeLayer("mappls-navigation-route-event-symbol-layer");
        qVar.b.getStyle().removeSource("mappls-navigation-route-event-source-id");
    }

    public final void b() {
        z zVar = this.g;
        zVar.r.getStyle(new w(zVar));
        C0228h c0228h = this.h;
        c0228h.d.getStyle(new C0226f(c0228h, this.g.a()));
        q qVar = this.i;
        String strA = this.g.a();
        qVar.d = strA;
        qVar.b.getStyle(new m(qVar, strA));
        INavigation iNavigation = this.j;
        if (iNavigation != null) {
            iNavigation.removeProgressChangeListener(this.d);
        }
        A a = new A(this.h);
        this.d = a;
        INavigation iNavigation2 = this.j;
        if (iNavigation2 != null) {
            iNavigation2.setProgressChangeListener(a);
        }
        this.a.removeOnMapClickListener(this.c);
        i iVar = new i(this.g);
        this.c = iVar;
        this.a.addOnMapClickListener(iVar);
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public final void onDidFinishLoadingStyle() {
        b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (!this.e) {
            this.a.addOnMapClickListener(this.c);
            this.e = true;
        }
        INavigation iNavigation = this.j;
        if (iNavigation != null) {
            iNavigation.setProgressChangeListener(this.d);
        }
        if (this.f) {
            return;
        }
        this.b.addOnDidFinishLoadingStyleListener(this);
        this.f = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        if (this.e) {
            this.a.removeOnMapClickListener(this.c);
            this.e = false;
        }
        INavigation iNavigation = this.j;
        if (iNavigation != null) {
            iNavigation.removeProgressChangeListener(this.d);
        }
        if (this.f) {
            this.b.removeOnDidFinishLoadingStyleListener(this);
            this.f = false;
        }
    }

    public final void a(ArrayList arrayList) {
        z zVar = this.g;
        zVar.getClass();
        if (arrayList.isEmpty()) {
            return;
        }
        if (!zVar.c.isEmpty()) {
            zVar.c.clear();
        }
        if (!zVar.a.isEmpty()) {
            zVar.a.clear();
        }
        if (!zVar.b.isEmpty()) {
            zVar.b.clear();
        }
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(new Feature[0]);
        zVar.x = featureCollectionFromFeatures;
        zVar.t.setGeoJson(featureCollectionFromFeatures);
        FeatureCollection featureCollectionFromFeatures2 = FeatureCollection.fromFeatures(new Feature[0]);
        zVar.y = featureCollectionFromFeatures2;
        zVar.s.setGeoJson(featureCollectionFromFeatures2);
        zVar.c.addAll(arrayList);
        zVar.u = 0;
        zVar.w = arrayList.size() > 1;
        zVar.v = true;
        C0224d c0224d = (C0224d) zVar.z.getAndSet(new C0224d(arrayList, zVar.u, zVar.K, zVar.B));
        if (c0224d != null) {
            c0224d.e.set(true);
        }
        C0224d c0224d2 = (C0224d) zVar.z.get();
        if (c0224d2 != null) {
            c0224d2.start();
        }
    }

    public final void a(com.mappls.sdk.navigation.ui.navigation.f fVar) {
        this.c.b = fVar;
    }

    public final void a(List list) {
        String id;
        q qVar = this.i;
        if (qVar != null) {
            Timber.tag("addMapEvents").e(new Gson().toJson(list), new Object[0]);
            C0222b c0222b = (C0222b) qVar.f.getAndSet(new C0222b(list, qVar.g, new Handler(qVar.a.getContext().getMainLooper())));
            if (c0222b != null) {
                c0222b.d.set(true);
            }
            C0222b c0222b2 = (C0222b) qVar.f.get();
            if (c0222b2 != null) {
                c0222b2.start();
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ReportDetails reportDetails = (ReportDetails) it2.next();
                o oVar = new o(qVar);
                if (reportDetails.getChildCategory() != null && reportDetails.getParentCategory() != null) {
                    id = reportDetails.getParentCategory() + "_" + reportDetails.getChildCategory();
                } else {
                    id = reportDetails.getId();
                }
                com.mappls.sdk.navigation.ui.g gVar = com.mappls.sdk.navigation.ui.g.b;
                if ((gVar.a.containsKey(id) ? (Bitmap) gVar.a.get(id) : null) == null) {
                    Executors.newSingleThreadExecutor().execute(new p(reportDetails, id, oVar));
                } else {
                    qVar.b.getStyle(new n(id, gVar.a.containsKey(id) ? (Bitmap) gVar.a.get(id) : null));
                }
            }
        }
    }
}
