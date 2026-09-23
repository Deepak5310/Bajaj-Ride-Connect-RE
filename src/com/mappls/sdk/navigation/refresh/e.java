package com.mappls.sdk.navigation.refresh;

import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class e implements OnResponseCallback<DirectionsRoute> {
    final /* synthetic */ AdviseInfo a;
    final /* synthetic */ f b;

    e(f fVar, AdviseInfo adviseInfo) {
        this.b = fVar;
        this.a = adviseInfo;
    }

    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onError(int i, String str) {
        this.b.d();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0148  */
    /* JADX WARN: Code duplicated, block: B:50:0x0167  */
    /* JADX WARN: Code duplicated, block: B:53:0x017e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0186  */
    /* JADX WARN: Code duplicated, block: B:57:0x018a  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x022e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0238 A[LOOP:2: B:64:0x0232->B:66:0x0238, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x028c  */
    /* JADX WARN: Code duplicated, block: B:96:0x01bb A[SYNTHETIC] */
    @Override // com.mappls.sdk.services.api.OnResponseCallback
    public final void onSuccess(DirectionsRoute directionsRoute) {
        int iIntValue;
        NavigationRoute navigationRouteA;
        Double dDuration;
        int i;
        DirectionsRoute directionsRoute2;
        AlternateRoute alternateRoute;
        DirectionsRoute directionsRoute3 = directionsRoute;
        if (NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().a()) {
            return;
        }
        if (!NavigationContext.getNavigationContext().h().s() && NavigationContext.getNavigationContext().h().x()) {
            if (this.b.e == null) {
                AdviseInfo adviseInfo = this.a;
                iIntValue = adviseInfo == null ? 0 : adviseInfo.getLeftTime();
            } else {
                iIntValue = this.b.e.intValue();
            }
            AdviseInfo adviseInfo2 = this.a;
            if (adviseInfo2 != null) {
                this.b.e = Integer.valueOf(adviseInfo2.getLeftDistance());
            }
            if (this.b.c == 0) {
                if (!MapplsNavigationHelper.getInstance().isCallAlternativeDuringNavigation() || directionsRoute3 == null || directionsRoute3.alternatives() == null || directionsRoute3.alternatives().size() <= 0) {
                    MapplsNavigationHelper.getInstance().setAlternateRoutes(new ArrayList());
                    if (directionsRoute3 != null) {
                        try {
                            if (NavigationContext.getNavigationContext().h().k() != null && NavigationContext.getNavigationContext().h().k().getParams() != null && !NavigationContext.getNavigationContext().h().s() && NavigationContext.getNavigationContext().h().q() && (navigationRouteA = f.a(this.b, directionsRoute3)) != null) {
                                NavigationContext.getNavigationContext().h().a(navigationRouteA);
                            }
                        } catch (Exception e) {
                            NavigationLogger.e(e);
                        }
                    }
                } else if (NavigationContext.getNavigationContext().h().k() != null && NavigationContext.getNavigationContext().h().k().getParams() != null && !NavigationContext.getNavigationContext().h().s() && NavigationContext.getNavigationContext().h().q()) {
                    DirectionsResponse directionsResponse = MapplsNavigationHelper.getInstance().getDirectionsResponse();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    List<DirectionsRoute> listAlternatives = directionsRoute3.alternatives();
                    if (this.a != null) {
                        double d = iIntValue;
                        if (d > listAlternatives.get(0).duration().doubleValue()) {
                            NavigationContext.getNavigationContext().p();
                            if (((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() == 2) {
                                arrayList.add(directionsRoute3);
                                arrayList.addAll(listAlternatives);
                                dDuration = listAlternatives.get(0).duration();
                                for (i = 0; i < arrayList.size(); i++) {
                                    directionsRoute2 = (DirectionsRoute) arrayList.get(i);
                                    if (i == 1) {
                                        if (i != 0) {
                                            alternateRoute = new AlternateRoute(Integer.valueOf((int) (directionsRoute2.duration().doubleValue() - dDuration.doubleValue())), directionsRoute2);
                                        } else {
                                            alternateRoute = new AlternateRoute(Integer.valueOf((int) (((double) this.b.e.intValue()) - dDuration.doubleValue())), directionsRoute2);
                                        }
                                        arrayList2.add(alternateRoute);
                                    }
                                }
                                DirectionsRoute directionsRoute4 = (DirectionsRoute) arrayList.get(1);
                                MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse.toBuilder().routes(arrayList).uuid(directionsRoute4.routeId()).build());
                                MapplsNavigationHelper.getInstance().setUuid(directionsRoute4.routeId());
                                MapplsNavigationHelper.getInstance().setRouteIndex(1);
                                NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().requestUuid(directionsRoute4.routeId()).build().toJson());
                            } else {
                                for (DirectionsRoute directionsRoute5 : listAlternatives) {
                                    arrayList2.add(new AlternateRoute(Integer.valueOf((int) (directionsRoute5.duration().doubleValue() - ((double) iIntValue))), directionsRoute5));
                                }
                                arrayList.add(directionsRoute3);
                                arrayList.addAll(listAlternatives);
                                MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse.toBuilder().routes(arrayList).build());
                                MapplsNavigationHelper.getInstance().setRouteIndex(0);
                                if (((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() == 1) {
                                    NavigationContext.getNavigationContext().h().a(listAlternatives);
                                }
                            }
                        } else {
                            for (DirectionsRoute directionsRoute6 : listAlternatives) {
                                arrayList2.add(new AlternateRoute(Integer.valueOf((int) (directionsRoute6.duration().doubleValue() - d)), directionsRoute6));
                            }
                            arrayList.add(directionsRoute3);
                            arrayList.addAll(listAlternatives);
                            MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse.toBuilder().routes(arrayList).build());
                            MapplsNavigationHelper.getInstance().setRouteIndex(0);
                        }
                        com.mappls.sdk.navigation.routing.d dVarH = NavigationContext.getNavigationContext().h();
                        directionsRoute3.betterRouteId();
                        dVarH.a(arrayList2);
                    } else {
                        NavigationContext.getNavigationContext().p();
                        if (((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() == 2) {
                            arrayList.add(directionsRoute3);
                            arrayList.addAll(listAlternatives);
                            dDuration = listAlternatives.get(0).duration();
                            while (i < arrayList.size()) {
                                directionsRoute2 = (DirectionsRoute) arrayList.get(i);
                                if (i == 1) {
                                    if (i != 0) {
                                        alternateRoute = new AlternateRoute(Integer.valueOf((int) (directionsRoute2.duration().doubleValue() - dDuration.doubleValue())), directionsRoute2);
                                    } else {
                                        alternateRoute = new AlternateRoute(Integer.valueOf((int) (((double) this.b.e.intValue()) - dDuration.doubleValue())), directionsRoute2);
                                    }
                                    arrayList2.add(alternateRoute);
                                }
                            }
                            DirectionsRoute directionsRoute7 = (DirectionsRoute) arrayList.get(1);
                            MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse.toBuilder().routes(arrayList).uuid(directionsRoute7.routeId()).build());
                            MapplsNavigationHelper.getInstance().setUuid(directionsRoute7.routeId());
                            MapplsNavigationHelper.getInstance().setRouteIndex(1);
                            NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().requestUuid(directionsRoute7.routeId()).build().toJson());
                        } else {
                            while (r6.hasNext()) {
                                arrayList2.add(new AlternateRoute(Integer.valueOf((int) (directionsRoute5.duration().doubleValue() - ((double) iIntValue))), directionsRoute5));
                            }
                            arrayList.add(directionsRoute3);
                            arrayList.addAll(listAlternatives);
                            MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse.toBuilder().routes(arrayList).build());
                            MapplsNavigationHelper.getInstance().setRouteIndex(0);
                            if (((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() == 1) {
                                NavigationContext.getNavigationContext().h().a(listAlternatives);
                            }
                            com.mappls.sdk.navigation.routing.d dVarH2 = NavigationContext.getNavigationContext().h();
                            directionsRoute3.betterRouteId();
                            dVarH2.a(arrayList2);
                        }
                    }
                    MapplsNavigationHelper.getInstance().setAlternateRoutes(arrayList2);
                    NavigationRoute navigationRouteA2 = f.a(this.b, (DirectionsRoute) arrayList.get(0));
                    if (navigationRouteA2 != null) {
                        NavigationContext.getNavigationContext().h().a(navigationRouteA2);
                    }
                }
            }
        }
        this.b.d();
    }
}
