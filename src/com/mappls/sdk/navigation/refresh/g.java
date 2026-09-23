package com.mappls.sdk.navigation.refresh;

import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
final class g implements OnResponseCallback<RouteReportSummaryResponse> {
    final /* synthetic */ h a;

    g(h hVar) {
        this.a = hVar;
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onError(int i, String str) {
        if (NavigationContext.getNavigationContext().h().q() && (NavigationContext.getNavigationContext().h().s() || !NavigationContext.getNavigationContext().h().x())) {
            h.a(this.a);
        }
        Timber.e("Request failed with code = %d and message = %s", Integer.valueOf(i), str);
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onSuccess(RouteReportSummaryResponse routeReportSummaryResponse) {
        RouteReportSummaryResponse routeReportSummaryResponse2 = routeReportSummaryResponse;
        if (routeReportSummaryResponse2 != null && routeReportSummaryResponse2.getRoutes() != null && routeReportSummaryResponse2.getRoutes().size() > 0) {
            NavigationContext.getNavigationContext().h().k().setEvents(routeReportSummaryResponse2.getRoutes().get(0).getReports());
        }
        if (NavigationContext.getNavigationContext().h().q()) {
            MapplsNavigationHelper.getInstance().setRouteReportSummaryResponse(routeReportSummaryResponse2);
            if (NavigationContext.getNavigationContext().h().s() || !NavigationContext.getNavigationContext().h().x()) {
                h.a(this.a);
            }
        }
    }
}
