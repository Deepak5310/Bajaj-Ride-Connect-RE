package com.mappls.sdk.navigation.refresh;

import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationConstants;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRouteManager;
import com.mappls.sdk.services.api.alongroute.models.POIAlongRouteResponse;
import com.mappls.sdk.services.api.alongroute.models.SuggestedPOI;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private int a;
    private List<d> b;
    private boolean c;

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.refresh.a$a, reason: collision with other inner class name */
    final class C0098a implements OnResponseCallback<POIAlongRouteResponse> {
        final /* synthetic */ int a;

        C0098a(int i) {
            this.a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int a(d dVar, d dVar2) {
            return dVar.b - dVar2.b;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onSuccess(POIAlongRouteResponse pOIAlongRouteResponse) {
            Timber.d("onSuccess", new Object[0]);
            if (!NavigationContext.getNavigationContext().h().q() || pOIAlongRouteResponse == null || pOIAlongRouteResponse.getSuggestedPOIs() == null || pOIAlongRouteResponse.getSuggestedPOIs().size() <= 0 || NavigationContext.getNavigationContext().h().k().directionsRoute == null) {
                NavigationContext.getNavigationContext().o().a(new ArrayList());
                NavigationContext.getNavigationContext().o().a(2);
            } else {
                List<Point> listDecode = PolylineUtils.decode(NavigationContext.getNavigationContext().h().k().directionsRoute.geometry(), 6);
                a.this.b = new ArrayList();
                for (SuggestedPOI suggestedPOI : pOIAlongRouteResponse.getSuggestedPOIs()) {
                    Point pointFromLngLat = Point.fromLngLat(suggestedPOI.getLongitude().doubleValue(), suggestedPOI.getLatitude().doubleValue());
                    Timber.d("suggestedPOI = %s", pointFromLngLat);
                    Feature featureNearestPointOnLine = TurfMisc.nearestPointOnLine(pointFromLngLat, listDecode);
                    Integer num = (Integer) featureNearestPointOnLine.getNumberProperty(FirebaseAnalytics.Param.INDEX);
                    int iIntValue = num.intValue();
                    Timber.d("Index = %d", num);
                    Timber.d("nearestPoint = %s", featureNearestPointOnLine.toJson());
                    a.this.b.add(new d(suggestedPOI, iIntValue));
                }
                Collections.sort(a.this.b, new Comparator() { // from class: com.mappls.sdk.navigation.refresh.a$a$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return a.C0098a.a((d) obj, (d) obj2);
                    }
                });
                NavigationContext.getNavigationContext().o().a(a.this.b);
                NavigationContext.getNavigationContext().o().a(2);
                Iterator it2 = a.this.b.iterator();
                while (it2.hasNext()) {
                    Timber.d("Index = %d", Integer.valueOf(((d) it2.next()).a()));
                }
            }
            a.this.a = this.a;
            a.this.getClass();
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            Timber.d("onError", new Object[0]);
            Timber.e("Request failed with code = %d and message = %s", Integer.valueOf(i), str);
            a.this.getClass();
        }
    }

    public a() {
        new Handler();
        this.a = 0;
        new Runnable() { // from class: com.mappls.sdk.navigation.refresh.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        };
        this.c = ((Boolean) NavigationContext.getNavigationContext().k().G.get()).booleanValue();
    }

    public static void a() {
        Timber.e("endTrip", new Object[0]);
    }

    private void b() {
        if (NavigationContext.getNavigationContext().h().q() && this.c) {
            if (NavigationContext.getNavigationContext().h().k() != null && NavigationContext.getNavigationContext().h().k().getWholeDistance() > 0) {
                int wholeDistance = NavigationContext.getNavigationContext().h().k().getWholeDistance() / NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
            }
            Timber.d("getAlongTheRoutePOIs", new Object[0]);
            int wholeDistance2 = (NavigationContext.getNavigationContext().h().k().getWholeDistance() - NavigationContext.getNavigationContext().h().h()) / NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
            Timber.d("Current segment before call = %d", Integer.valueOf(wholeDistance2));
            long j = wholeDistance2 * NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
            Timber.d("Segment distance = %d", Long.valueOf(j));
            if (NavigationContext.getNavigationContext().h().k() == null || NavigationContext.getNavigationContext().h().k().directionsRoute == null || NavigationContext.getNavigationContext().h().k().directionsRoute.geometry() == null) {
                return;
            }
            MapplsPOIAlongRouteManager.newInstance(MapplsPOIAlongRoute.builder().buffer(Integer.valueOf(((Long) NavigationContext.getNavigationContext().k().H.get()).intValue())).path(TurfMisc.lineSliceAlong(LineString.fromPolyline(NavigationContext.getNavigationContext().h().k().directionsRoute.geometry(), 6), j, j + 5000, TurfConstants.UNIT_METERS).toPolyline(6)).category((String) NavigationContext.getNavigationContext().k().I.get()).build()).call(new C0098a(wholeDistance2));
        }
    }

    public final void c() {
        int wholeDistance = (NavigationContext.getNavigationContext().h().k().getWholeDistance() - NavigationContext.getNavigationContext().h().h()) / NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
        Timber.d("current segment = %d", Integer.valueOf(wholeDistance));
        if (wholeDistance > this.a) {
            try {
                b();
            } catch (Exception e) {
                NavigationLogger.e(e);
            }
        }
    }

    public final void d() {
        Timber.d("routeRecalculated", new Object[0]);
        if (!this.c || !MapplsNavigationHelper.getInstance().isNavigating()) {
            NavigationContext.getNavigationContext().o().a(2);
            return;
        }
        try {
            b();
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
    }

    public final void e() {
        Timber.e("startTrip", new Object[0]);
        try {
            b();
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
    }
}
