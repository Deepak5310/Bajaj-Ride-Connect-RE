package com.mappls.sdk.services.api.predictive.directions;

import com.BV.LinearGradient.LinearGradientManager;
import com.google.android.gms.common.Scopes;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.predictive.MapplsDirectionSpeedType;
import com.mappls.sdk.services.api.predictive.directions.model.PredictiveDirectionsResponse;
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
public abstract class MapplsPredictiveDirections extends MapplsService<PredictiveDirectionsResponse, DirectionsService> {
    abstract Integer alternatives();

    abstract List<String> avoidLocations();

    abstract Boolean avoidTolls();

    abstract Double axleLoad();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    abstract List<String> coordinates();

    abstract Boolean excludeBridge();

    abstract Boolean excludeTunnel();

    abstract Boolean hazmat();

    abstract Integer heading();

    abstract Integer headingTolerance();

    abstract Double height();

    abstract List<String> internalAvoidPolygons();

    abstract String internalDateTime();

    abstract String internalSpeedType();

    abstract Double length();

    abstract String maxRouteClass();

    abstract String minRouteClass();

    abstract String preferredSide();

    abstract String profile();

    abstract String routeName();

    abstract Integer searchCutoff();

    abstract Double useFerry();

    abstract Double useHighway();

    abstract Double weight();

    abstract Double width();

    protected MapplsPredictiveDirections() {
        super(DirectionsService.class);
    }

    private static String formatCoordinates(List<String> list) {
        return MapplsUtils.join(";", list.toArray());
    }

    public static Builder builder() {
        return new AutoValue_MapplsPredictiveDirections.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).profile("driving");
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<PredictiveDirectionsResponse> initializeCall() {
        return getLoginService(true).getCall(toMap());
    }

    private Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put(LinearGradientManager.PROP_LOCATIONS, formatCoordinates(coordinates()));
        map.put(Scopes.PROFILE, profile());
        if (internalSpeedType() != null) {
            map.put("speedTypes", internalSpeedType());
        }
        if (internalDateTime() != null) {
            map.put("date_time", internalDateTime());
        }
        if (heading() != null) {
            map.put("heading", heading());
        }
        if (headingTolerance() != null) {
            map.put("heading_tolerance", headingTolerance());
        }
        if (preferredSide() != null) {
            map.put("preferred_side", preferredSide());
        }
        if (searchCutoff() != null) {
            map.put("search_cutoff", searchCutoff());
        }
        if (avoidLocations() != null) {
            map.put("avoid_locations", formatCoordinates(avoidLocations()));
        }
        if (internalAvoidPolygons() != null) {
            map.put("avoid_polygons", formatCoordinates(internalAvoidPolygons()));
        }
        if (routeName() != null) {
            map.put("id", routeName());
        }
        if (useFerry() != null) {
            map.put("use_ferry", useFerry());
        }
        if (useHighway() != null) {
            map.put("use_highway", useHighway());
        }
        if (alternatives() != null) {
            map.put("alternatives", alternatives());
        }
        if (excludeTunnel() != null) {
            map.put("exclude_tunnel", excludeTunnel());
        }
        if (excludeBridge() != null) {
            map.put("exclude_bridge", excludeBridge());
        }
        if (avoidTolls() != null) {
            map.put("avoid_tolls", avoidTolls());
        }
        if (minRouteClass() != null) {
            map.put("min_route_class", minRouteClass());
        }
        if (maxRouteClass() != null) {
            map.put("max_route_class", maxRouteClass());
        }
        if (height() != null) {
            map.put("height", height());
        }
        if (width() != null) {
            map.put("width", width());
        }
        if (length() != null) {
            map.put("length", length());
        }
        if (weight() != null) {
            map.put("weight", weight());
        }
        if (axleLoad() != null) {
            map.put("axle_load", axleLoad());
        }
        if (hazmat() != null) {
            map.put("hazmat", hazmat());
        }
        return map;
    }

    void enqueue(Callback<PredictiveDirectionsResponse> callback) {
        enqueueCall(callback);
    }

    Response<PredictiveDirectionsResponse> execute() throws IOException {
        return executeCall();
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    public static abstract class Builder {
        private Point[] avoidLocations;
        private List<List<Point>> avoidPolygons;
        private List<String> coordinates = new ArrayList();
        private String destination;
        private String origin;

        public abstract Builder alternatives(Integer num);

        abstract MapplsPredictiveDirections autoBuild();

        abstract Builder avoidLocations(List<String> list);

        public abstract Builder avoidTolls(Boolean bool);

        public abstract Builder axleLoad(Double d);

        public abstract Builder baseUrl(String str);

        abstract Builder coordinates(List<String> list);

        public abstract Builder excludeBridge(Boolean bool);

        public abstract Builder excludeTunnel(Boolean bool);

        public abstract Builder hazmat(Boolean bool);

        public abstract Builder heading(Integer num);

        public abstract Builder headingTolerance(Integer num);

        public abstract Builder height(Double d);

        abstract Builder internalAvoidPolygons(List<String> list);

        abstract Builder internalDateTime(String str);

        abstract Builder internalSpeedType(String str);

        public abstract Builder length(Double d);

        public abstract Builder maxRouteClass(String str);

        public abstract Builder minRouteClass(String str);

        public abstract Builder preferredSide(String str);

        public abstract Builder profile(String str);

        public abstract Builder routeName(String str);

        public abstract Builder searchCutoff(Integer num);

        public abstract Builder useFerry(Double d);

        public abstract Builder useHighway(Double d);

        public abstract Builder weight(Double d);

        public abstract Builder width(Double d);

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

        public Builder addWaypoint(Point point) {
            this.coordinates.add(String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude())));
            return this;
        }

        public Builder addWaypoint(String str) {
            this.coordinates.add(str);
            return this;
        }

        public Builder speedType(MapplsDirectionSpeedType mapplsDirectionSpeedType) {
            return internalSpeedType(mapplsDirectionSpeedType.speedType()).internalDateTime(mapplsDirectionSpeedType.speedDateTime());
        }

        public Builder avoidLocations(Point... pointArr) {
            this.avoidLocations = pointArr;
            return this;
        }

        public Builder avoidPolygons(List<List<Point>> list) {
            this.avoidPolygons = list;
            return this;
        }

        public MapplsPredictiveDirections build() {
            if (MapplsUtils.isEmpty(MapplsAccountManager.getInstance().getAtlasClientId())) {
                throw new ServicesException("Using Mappls Services requires setting a valid API Key.");
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
            if (this.avoidLocations != null) {
                ArrayList arrayList = new ArrayList();
                for (Point point : this.avoidLocations) {
                    arrayList.add(point.longitude() + "," + point.latitude());
                }
                avoidLocations(arrayList);
            }
            if (this.avoidPolygons != null) {
                ArrayList arrayList2 = new ArrayList();
                if (this.avoidPolygons.size() == 1) {
                    for (Point point2 : this.avoidPolygons.get(0)) {
                        arrayList2.add(point2.longitude() + "," + point2.latitude());
                    }
                    internalAvoidPolygons(arrayList2);
                }
            }
            return autoBuild();
        }
    }
}
