package com.mappls.sdk.services.api.directions;

import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
class DirectionsResponseFactory {
    private final MapplsDirections mapplsDirections;

    DirectionsResponseFactory(MapplsDirections mapplsDirections) {
        this.mapplsDirections = mapplsDirections;
    }

    Response<DirectionsResponse> generate(Response<DirectionsResponse> response) {
        return isNotSuccessful(response) ? response : Response.success(response.body().toBuilder().routes(generateRouteOptions(response)).build(), new okhttp3.Response.Builder().code(200).message("OK").protocol(response.raw().protocol()).headers(response.headers()).request(response.raw().request()).build());
    }

    private boolean isNotSuccessful(Response<DirectionsResponse> response) {
        return !response.isSuccessful() || response.body() == null || response.body().routes().isEmpty();
    }

    private List<DirectionsRoute> generateRouteOptions(Response<DirectionsResponse> response) {
        List<DirectionsRoute> listRoutes = response.body().routes();
        ArrayList arrayList = new ArrayList();
        Iterator<DirectionsRoute> it2 = listRoutes.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBuilder().routeOptions(RouteOptions.builder().profile(this.mapplsDirections.profile()).resource(this.mapplsDirections.resource()).baseUrl(this.mapplsDirections.baseUrl()).coordinates(this.mapplsDirections.coordinates()).waypointIndices(this.mapplsDirections.waypointIndices()).waypointNames(this.mapplsDirections.waypointNames()).waypointTargets(this.mapplsDirections.waypointTargets()).skipWaypoints(this.mapplsDirections.skipWaypoints()).lessVerbose(this.mapplsDirections.lessVerbose()).annotations(this.mapplsDirections.annotation()).approaches(this.mapplsDirections.approaches()).bearings(this.mapplsDirections.bearing()).alternatives(this.mapplsDirections.alternatives()).language(this.mapplsDirections.language()).radiuses(this.mapplsDirections.radius()).user(this.mapplsDirections.user()).continueStraight(this.mapplsDirections.continueStraight()).bannerInstructions(this.mapplsDirections.bannerInstructions()).instructions(this.mapplsDirections.instructions()).roundaboutExits(this.mapplsDirections.roundaboutExits()).dateTime(this.mapplsDirections.internalDateTime()).geometries(this.mapplsDirections.geometries()).overview(this.mapplsDirections.overview()).steps(this.mapplsDirections.steps()).exclude(this.mapplsDirections.exclude()).walkingOptions(this.mapplsDirections.walkingOptions()).routeRefresh(this.mapplsDirections.routeRefresh()).deviceID(this.mapplsDirections.deviceId()).requestUuid(response.body().uuid()).sessionId(response.body().sessionId()).isSort(this.mapplsDirections.isSort()).routeType(this.mapplsDirections.routeType()).soc(this.mapplsDirections.internalSoc()).batteryCapacity(this.mapplsDirections.batteryCapacity()).mass(this.mapplsDirections.mass()).efficiency(this.mapplsDirections.efficiency()).aux(this.mapplsDirections.aux()).regen(this.mapplsDirections.regen()).build()).routeId(response.body().uuid()).build());
        }
        return arrayList;
    }
}
