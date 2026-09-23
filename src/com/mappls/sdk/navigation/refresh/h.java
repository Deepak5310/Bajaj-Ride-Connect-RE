package com.mappls.sdk.navigation.refresh;

import android.os.Handler;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummary;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummaryManager;
import java.util.ArrayList;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private final Handler b = new Handler();
    private final Runnable c = new Runnable() { // from class: com.mappls.sdk.navigation.refresh.h$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.b();
        }
    };
    private boolean a = ((Boolean) NavigationContext.getNavigationContext().k().K.get()).booleanValue();

    static void a(h hVar) {
        hVar.b.removeCallbacksAndMessages(null);
        if (NavigationContext.getNavigationContext().h().q()) {
            Handler handler = hVar.b;
            Runnable runnable = hVar.c;
            int iIntValue = ((Integer) NavigationContext.getNavigationContext().k().c.get()).intValue();
            int iIntValue2 = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
            if (iIntValue > 30000) {
                iIntValue2 = ((Integer) NavigationContext.getNavigationContext().k().c.get()).intValue();
            }
            handler.postDelayed(runnable, iIntValue2);
        }
    }

    public final void a() {
        Timber.e("endTrip", new Object[0]);
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(Boolean bool) {
        if (this.a == bool.booleanValue()) {
            return;
        }
        this.a = bool.booleanValue();
        b();
    }

    public final void b() {
        RouteOptions routeOptionsFromJson;
        String str;
        Timber.e("routeRecalculated", new Object[0]);
        if (!this.a || !MapplsNavigationHelper.getInstance().isNavigating()) {
            NavigationContext.getNavigationContext().h().k().setEvents(new ArrayList());
            NavigationContext.getNavigationContext().o().a(6);
            return;
        }
        if (!NavigationContext.getNavigationContext().h().q() || (routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get())) == null || routeOptionsFromJson.annotations() == null || !routeOptionsFromJson.annotations().contains(DirectionsCriteria.ANNOTATION_NODES) || routeOptionsFromJson.requestUuid() == null || !this.a || MapplsNavigationHelper.getInstance().getCurrentRoute() == null) {
            return;
        }
        int routeIndex = MapplsNavigationHelper.getInstance().getRouteIndex();
        if (MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex() != null) {
            routeIndex = MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex().intValue();
        }
        MapplsRouteSummary.Builder builder = MapplsRouteSummary.builder();
        if (MapplsNavigationHelper.getInstance().getBaseRes() != null) {
            builder.baseUrl(MapplsNavigationHelper.getInstance().getBaseRes() + "apis/O2O/");
        }
        MapplsRouteSummary.Builder builderRouteIdx = builder.routeId(routeOptionsFromJson.requestUuid()).routeIdx(Integer.valueOf(routeIndex));
        if (MapplsNavigationHelper.getInstance().getCurrentNodeId().longValue() > 0) {
            str = MapplsNavigationHelper.getInstance().getCurrentNodeId() + "";
        } else {
            str = null;
        }
        MapplsRouteSummaryManager.newInstance(builderRouteIdx.currentNode(str).build()).call(new g(this));
    }

    public final void c() {
        this.b.removeCallbacksAndMessages(null);
        if (NavigationContext.getNavigationContext().h().q()) {
            this.b.postDelayed(this.c, 0L);
        }
    }
}
