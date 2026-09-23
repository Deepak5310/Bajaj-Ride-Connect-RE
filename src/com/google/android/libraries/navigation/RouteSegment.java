package com.google.android.libraries.navigation;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface RouteSegment {
    LatLng getDestinationLatLng();

    Waypoint getDestinationWaypoint();

    List<LatLng> getLatLngs();

    NavigationTrafficData getTrafficData();
}
