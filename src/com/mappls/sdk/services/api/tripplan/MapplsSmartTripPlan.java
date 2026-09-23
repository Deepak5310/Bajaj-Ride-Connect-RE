package com.mappls.sdk.services.api.tripplan;

import com.BV.LinearGradient.LinearGradientManager;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.tripplan.model.SmartTripPlanResponse;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapplsSmartTripPlan extends MapplsService<SmartTripPlanResponse, SmartTripPlanService> {
    abstract Integer actualDistanceToEmpty();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract List<String> coordinates();

    abstract String geometries();

    abstract String routeGeometry();

    abstract Integer searchStateOfCharge();

    abstract List<String> snappedCoordinates();

    abstract String socketType();

    abstract Integer stateOfCharge();

    abstract List<String> waypointNames();

    public MapplsSmartTripPlan() {
        super(SmartTripPlanService.class);
    }

    public static Builder builder() {
        return new AutoValue_MapplsSmartTripPlan.Builder().baseUrl(Constants.EXPLORE_BASE_URL).geometries("polyline6");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<SmartTripPlanResponse> initializeCall() {
        return getLoginService(true).getCall(createRequest());
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("dteActual", actualDistanceToEmpty());
        map.put("soc", stateOfCharge());
        map.put("searchSoc", searchStateOfCharge());
        map.put("polyline", geometries());
        if (socketType() != null) {
            map.put("socketType", socketType());
        }
        map.put("geom", routeGeometry());
        if (waypointNames() != null) {
            map.put("waypointName", waypointNames());
        }
        map.put(LinearGradientManager.PROP_LOCATIONS, MapplsUtils.join(";", coordinates().toArray()));
        map.put("snappedLocations", MapplsUtils.join(";", coordinates().toArray()));
        return map;
    }

    void enqueue(Callback<SmartTripPlanResponse> callback) {
        super.enqueueCall(callback);
    }

    Response<SmartTripPlanResponse> execute() throws IOException {
        return super.executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private String destination;
        private String origin;
        private List<String> coordinates = new ArrayList();
        private List<String> snappedCoordinates = new ArrayList();

        public abstract Builder actualDistanceToEmpty(Integer num);

        abstract MapplsSmartTripPlan autoBuild();

        public abstract Builder baseUrl(String str);

        abstract Builder coordinates(List<String> list);

        public abstract Builder geometries(String str);

        public abstract Builder routeGeometry(String str);

        public abstract Builder searchStateOfCharge(Integer num);

        abstract Builder snappedCoordinates(List<String> list);

        public abstract Builder socketType(String str);

        public abstract Builder stateOfCharge(Integer num);

        public abstract Builder waypointNames(List<String> list);

        public Builder origin(Point point) {
            this.origin = String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude()));
            return this;
        }

        public Builder origin(String str) {
            this.origin = str;
            return this;
        }

        public Builder destination(Point point) {
            this.destination = String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude()));
            return this;
        }

        public Builder destination(String str) {
            this.destination = str;
            return this;
        }

        public Builder directionsWaypoints(List<DirectionsWaypoint> list) {
            this.snappedCoordinates = new ArrayList();
            for (DirectionsWaypoint directionsWaypoint : list) {
                if (directionsWaypoint.location() != null) {
                    this.snappedCoordinates.add(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(directionsWaypoint.location().longitude()), MapplsUtils.formatCoordinate(directionsWaypoint.location().latitude())));
                }
            }
            return this;
        }

        public Builder addWaypoint(Point point) {
            this.coordinates.add(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
            return this;
        }

        public Builder addWaypoint(String str) {
            this.coordinates.add(str);
            return this;
        }

        public MapplsSmartTripPlan build() {
            if (!MapplsUtils.isAccessTokenValid(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid keys.");
            }
            String str = this.origin;
            if (str != null) {
                this.coordinates.add(0, str);
            }
            String str2 = this.destination;
            if (str2 != null) {
                this.coordinates.add(str2);
            }
            if (this.coordinates.size() < 2) {
                throw new ServicesException("An origin and destination are required before making the directions API request.");
            }
            coordinates(this.coordinates);
            if (this.snappedCoordinates.size() < 2) {
                throw new ServicesException("Please pass all the Waypoints received from DirectionsResponse");
            }
            snappedCoordinates(this.snappedCoordinates);
            return autoBuild();
        }
    }
}
