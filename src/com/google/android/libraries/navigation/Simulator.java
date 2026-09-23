package com.google.android.libraries.navigation;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public interface Simulator {
    void hideDummyTrafficPrompt();

    void pause();

    void resume();

    void setUserLocation(LatLng latLng);

    void showDummyTrafficPrompt();

    void simulateLocationsAlongExistingRoute();

    void simulateLocationsAlongExistingRoute(SimulationOptions simulationOptions);

    ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(List<Waypoint> list);

    ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(List<Waypoint> list, RoutingOptions routingOptions);

    ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(List<Waypoint> list, RoutingOptions routingOptions, SimulationOptions simulationOptions);

    void unsetUserLocation();
}
