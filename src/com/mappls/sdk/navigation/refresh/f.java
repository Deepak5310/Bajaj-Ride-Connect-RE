package com.mappls.sdk.navigation.refresh;

import android.os.Handler;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.navigation.util.NavigationUtils;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh;
import com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefreshManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private String b;
    private MapplsDirectionsRefreshManager d;
    private Integer e;
    private final Handler a = new Handler();
    private int c = 0;
    private final Runnable f = new a();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
            if (routeOptionsFromJson == null || !routeOptionsFromJson.resource().equalsIgnoreCase(DirectionsCriteria.RESOURCE_ROUTE_ETA)) {
                return;
            }
            f.d(f.this);
        }
    }

    static NavigationRoute a(f fVar, DirectionsRoute directionsRoute) {
        DirectionsRoute directionsRouteBuild;
        fVar.getClass();
        ArrayList arrayList = new ArrayList();
        if (directionsRoute == null) {
            return null;
        }
        try {
            if (directionsRoute.geometry() == null) {
                return null;
            }
            List<Point> listCoordinates = LineString.fromPolyline((String) Objects.requireNonNull(directionsRoute.geometry()), 6).coordinates();
            for (int i = 0; i < listCoordinates.size(); i++) {
                NavLocation navLocation = new NavLocation("router");
                navLocation.setLatitude(listCoordinates.get(i).latitude());
                navLocation.setLongitude(listCoordinates.get(i).longitude());
                arrayList.add(navLocation);
            }
            DirectionsRoute.Builder builder = directionsRoute.toBuilder();
            builder.legs(NavigationUtils.mergeRouteLegs(directionsRoute));
            directionsRouteBuild = builder.build();
        } catch (Exception e) {
            NavigationLogger.d(e);
            directionsRouteBuild = null;
        }
        if (directionsRouteBuild == null) {
            return null;
        }
        NavigationRoute navigationRoute = new NavigationRoute(directionsRouteBuild, arrayList, null, NavigationContext.getNavigationContext().h().k().getParams(), null, true, NavigationContext.getNavigationContext().h().k().getJunctionViews(), NavigationContext.getNavigationContext().h().k().getEvents(), NavigationContext.getNavigationContext().h().k().getCongestionInfos());
        navigationRoute.updateCurrentRoute(NavigationContext.getNavigationContext().h().k().getCurrentRoute());
        return navigationRoute;
    }

    static void d(f fVar) {
        int i;
        fVar.getClass();
        if (NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().a()) {
            return;
        }
        if (fVar.c != 2) {
            fVar.b = MapplsNavigationHelper.getInstance().getUuid();
            if ((NavigationContext.getNavigationContext().h().s() || MapplsNavigationHelper.getInstance().getUuid() == null) && MapplsNavigationHelper.getInstance().getUuid() == null && (i = fVar.c) != 2 && i != 3) {
                return;
            }
        }
        if (NavigationContext.getNavigationContext().k().a.get() == null) {
            return;
        }
        RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
        try {
            if (fVar.b == null || routeOptionsFromJson == null || routeOptionsFromJson.baseUrl() == null || HttpUrl.parse(routeOptionsFromJson.baseUrl()) == null) {
                return;
            }
            if (!NavigationContext.getNavigationContext().h().x()) {
                fVar.d();
                return;
            }
            MapplsDirectionsRefreshManager mapplsDirectionsRefreshManager = fVar.d;
            if (mapplsDirectionsRefreshManager != null) {
                mapplsDirectionsRefreshManager.cancel();
            }
            AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
            int routeIndex = MapplsNavigationHelper.getInstance().getRouteIndex();
            if (MapplsNavigationHelper.getInstance().getCurrentRoute() != null && MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex() != null) {
                routeIndex = MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex().intValue();
            }
            MapplsDirectionsRefresh.Builder builderTripType = MapplsDirectionsRefresh.builder().baseUrl(routeOptionsFromJson.baseUrl()).isRefresh(Boolean.TRUE).requestId(fVar.b).profile(routeOptionsFromJson.profile()).nodeIndex(Long.valueOf(MapplsNavigationHelper.getInstance().getNodeIndex())).routeIndex(Integer.valueOf(routeIndex)).sessionId(MapplsNavigationHelper.getInstance().getSessionId()).tripType(Integer.valueOf(fVar.c));
            if (adviseInfo != null && MapplsNavigationHelper.getInstance().isCallAlternativeDuringNavigation()) {
                NavLocation navLocation = adviseInfo.getNavLocation();
                if (navLocation != null) {
                    builderTripType.source(Point.fromLngLat(navLocation.getLongitude(), navLocation.getLatitude()));
                }
                NavigationContext.getNavigationContext().p();
            }
            MapplsDirectionsRefreshManager mapplsDirectionsRefreshManagerNewInstance = MapplsDirectionsRefreshManager.newInstance(builderTripType.build());
            fVar.d = mapplsDirectionsRefreshManagerNewInstance;
            mapplsDirectionsRefreshManagerNewInstance.call(new e(fVar, adviseInfo));
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
    }

    public final void a() {
        NavigationLogger.d("cancelTrip", new Object[0]);
        this.c = 3;
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(this.f, 0L);
    }

    public final void b() {
        NavigationLogger.d("endTrip", new Object[0]);
        this.c = 2;
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(this.f, 0L);
    }

    public final void c() {
        NavigationLogger.d("recalculated", new Object[0]);
        this.a.removeCallbacksAndMessages(null);
        this.c = 0;
        if (NavigationContext.getNavigationContext().h().q()) {
            this.a.postDelayed(this.f, 0L);
        }
    }

    public final void e() {
        NavigationLogger.d("startTrip", new Object[0]);
        this.a.removeCallbacksAndMessages(null);
        this.c = 1;
        if (NavigationContext.getNavigationContext().h().q()) {
            this.a.postDelayed(this.f, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i = this.c;
        if (i == 2 || i == 3) {
            this.a.removeCallbacksAndMessages(null);
            MapplsDirectionsRefreshManager mapplsDirectionsRefreshManager = this.d;
            if (mapplsDirectionsRefreshManager != null) {
                mapplsDirectionsRefreshManager.cancel();
                return;
            }
            return;
        }
        this.c = 0;
        this.a.removeCallbacksAndMessages(null);
        if (NavigationContext.getNavigationContext().h().q()) {
            Handler handler = this.a;
            Runnable runnable = this.f;
            int iIntValue = ((Integer) NavigationContext.getNavigationContext().k().b.get()).intValue();
            int iIntValue2 = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
            if (iIntValue > 30000) {
                iIntValue2 = ((Integer) NavigationContext.getNavigationContext().k().b.get()).intValue();
            }
            handler.postDelayed(runnable, iIntValue2);
        }
    }
}
