package com.mappls.sdk.services.api.directionsrefresh;

import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
class DirectionsRefreshResponseFactory {
    private final MapplsDirectionsRefresh mapplsDirectionsRefresh;

    DirectionsRefreshResponseFactory(MapplsDirectionsRefresh mapplsDirectionsRefresh) {
        this.mapplsDirectionsRefresh = mapplsDirectionsRefresh;
    }

    Response<DirectionsRoute> generate(Response<DirectionsRoute> response) {
        return isNotSuccessful(response) ? response : Response.success(response.body().toBuilder().routeId(this.mapplsDirectionsRefresh.requestId()).alternatives(generateAlternatives(response)).build(), new okhttp3.Response.Builder().code(200).message("OK").protocol(response.raw().protocol()).headers(response.headers()).request(response.raw().request()).build());
    }

    private List<DirectionsRoute> generateAlternatives(Response<DirectionsRoute> response) {
        List<DirectionsRoute> listAlternatives = response.body().alternatives();
        if (listAlternatives == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DirectionsRoute> it2 = listAlternatives.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBuilder().routeId(response.body().betterRouteId()).build());
        }
        return arrayList;
    }

    private boolean isNotSuccessful(Response<DirectionsRoute> response) {
        return !response.isSuccessful() || response.body() == null;
    }
}
