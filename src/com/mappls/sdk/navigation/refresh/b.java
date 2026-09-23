package com.mappls.sdk.navigation.refresh;

import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.model.CongestionInfo;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static void a() {
        NavigationRoute navigationRouteK = NavigationContext.getNavigationContext().h().k();
        if (navigationRouteK != null) {
            List<Double> durations = navigationRouteK.getDurations();
            List<Double> baseDurations = navigationRouteK.getBaseDurations();
            List<String> congestion = navigationRouteK.getCongestion();
            if (durations != null && baseDurations != null && congestion != null && !durations.isEmpty() && !baseDurations.isEmpty() && !congestion.isEmpty()) {
                int currentRoute = navigationRouteK.getCurrentRoute() > 0 ? navigationRouteK.getCurrentRoute() : 0;
                List<NavLocation> immutableAllLocations = navigationRouteK.getImmutableAllLocations();
                if (immutableAllLocations != null && !immutableAllLocations.isEmpty() && currentRoute < immutableAllLocations.size()) {
                    ArrayList arrayList = new ArrayList();
                    a(arrayList, baseDurations, durations, congestion, currentRoute, immutableAllLocations, navigationRouteK.getRouteDistanceToFinish(0) > 50000 ? navigationRouteK.getIndexToRouteFromIndexToDistance(0, 50000) : immutableAllLocations.size() - 1);
                    navigationRouteK.setCongestionInfos(arrayList);
                    return;
                }
            }
            navigationRouteK.setCongestionInfos(null);
        }
    }

    private static void a(ArrayList arrayList, List list, List list2, List list3, int i, List list4, int i2) {
        int i3 = i;
        if (i3 >= list2.size() || i3 >= list.size() || i3 >= list3.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int i4 = i3 - 1;
        double dDoubleValue = 0.0d;
        while (i3 <= i2) {
            if (list3.size() > i3 && list2.size() > i3 && list.size() > i3) {
                if (((String) list3.get(i3)).equalsIgnoreCase("heavy") || ((String) list3.get(i3)).equalsIgnoreCase("severe")) {
                    dDoubleValue += ((Double) list2.get(i3)).doubleValue() - ((Double) list.get(i3)).doubleValue();
                    NavLocation navLocation = (NavLocation) list4.get(i3);
                    arrayList2.add(Point.fromLngLat(navLocation.getLongitude(), navLocation.getLatitude()));
                } else {
                    if (dDoubleValue >= 60.0d) {
                        CongestionInfo congestionInfo = new CongestionInfo();
                        congestionInfo.setDelayInfo(dDoubleValue);
                        congestionInfo.setCongestionRemainingDelay(dDoubleValue);
                        congestionInfo.setStartNodeIndex(Integer.valueOf(i4 + 1));
                        congestionInfo.setEndNodeIndex(Integer.valueOf(i3 - 1));
                        congestionInfo.setCongestionLocationPoints(arrayList2);
                        congestionInfo.setStartPoint((Point) arrayList2.get(0));
                        congestionInfo.setEndPoint((Point) arrayList2.get(arrayList2.size() - 1));
                        arrayList.add(congestionInfo);
                    }
                    arrayList2 = new ArrayList();
                    i4 = i3;
                    dDoubleValue = 0.0d;
                }
            }
            i3++;
        }
    }

    public static void b() {
        if (((Boolean) NavigationContext.getNavigationContext().k().L.get()).booleanValue()) {
            a();
        }
    }

    public static void c() {
        if (((Boolean) NavigationContext.getNavigationContext().k().L.get()).booleanValue()) {
            a();
        }
    }
}
