package com.mappls.sdk.navigation.iface;

import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface INavigationListener {
    default void onAlternateRoutesUpdate(List<AlternateRoute> list) {
    }

    default void onBetterRouteAvailable(List<DirectionsRoute> list) {
    }

    void onETARefreshed(String str);

    void onEvent(NavEvent navEvent);

    void onNavigationCancelled();

    void onNavigationFinished();

    void onNavigationStarted();

    void onNewRoute(String str);

    void onReRoutingRequested();

    default void onRerouteFailed(int i, String str) {
    }

    void onRouteProgress(AdviseInfo adviseInfo);

    void onWayPointReached(WayPoint wayPoint);
}
