package com.mappls.sdk.services.api.directions;

import com.google.gson.GsonBuilder;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.api.ServicesException;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime;
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
public abstract class MapplsDirections extends MapplsService<DirectionsResponse, DirectionsService> {
    protected static final int MAX_URL_SIZE = 8192;

    public abstract Boolean alternatives();

    public abstract String annotation();

    public abstract String approaches();

    public abstract Double aux();

    public abstract Boolean bannerInstructions();

    @Override // com.mappls.sdk.services.api.MapplsService
    public abstract String baseUrl();

    public abstract Integer batteryCapacity();

    public abstract String bearing();

    public abstract String clientAppName();

    public abstract Boolean continueStraight();

    public abstract List<String> coordinates();

    public abstract String deviceId();

    public abstract Double efficiency();

    public abstract String exclude();

    public abstract String geometries();

    public abstract Boolean instructions();

    public abstract String internalDateTime();

    public abstract String internalSoc();

    public abstract Boolean isSort();

    public abstract String language();

    public abstract Boolean lessVerbose();

    public abstract Integer mass();

    public abstract String overview();

    public abstract String profile();

    public abstract String radius();

    public abstract Double regen();

    public abstract String resource();

    public abstract Boolean roundaboutExits();

    public abstract Boolean routeRefresh();

    public abstract Integer routeType();

    public abstract String sessionId();

    public abstract Boolean skipWaypoints();

    public abstract Boolean steps();

    public abstract Builder toBuilder();

    public abstract Boolean usePostMethod();

    public abstract String user();

    public abstract WalkingOptions walkingOptions();

    public abstract String waypointIndices();

    public abstract String waypointNames();

    public abstract String waypointTargets();

    protected MapplsDirections() {
        super(DirectionsService.class);
    }

    private static String formatCoordinates(List<String> list) {
        return MapplsUtils.join(";", list.toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatWaypointTargets(Point[] pointArr) {
        String[] strArr = new String[pointArr.length];
        int i = 0;
        for (Point point : pointArr) {
            if (point == null) {
                strArr[i] = "";
                i++;
            } else {
                strArr[i] = String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(point.longitude()), MapplsUtils.formatCoordinate(point.latitude()));
                i++;
            }
        }
        return MapplsUtils.join(";", strArr);
    }

    public static Builder builder() {
        return new AutoValue_MapplsDirections.Builder().baseUrl(Constants.ADVANCE_MAP_BASE_URL).profile("driving").resource(DirectionsCriteria.RESOURCE_ROUTE).user(DirectionsCriteria.PROFILE_DEFAULT_USER).overview("full").geometries("polyline6").isSort(true);
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<DirectionsResponse> initializeCall() {
        if (usePostMethod() == null) {
            return callForUrlLength();
        }
        if (usePostMethod().booleanValue()) {
            return post();
        }
        return get();
    }

    @Override // com.mappls.sdk.services.api.MapplsService
    protected GsonBuilder getGsonBuilder() {
        return super.getGsonBuilder().registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    private Call<DirectionsResponse> callForUrlLength() {
        Call<DirectionsResponse> call = get();
        return call.request().url().getUrl().length() < 8192 ? call : post();
    }

    private Call<DirectionsResponse> get() {
        return getLoginService(true).getCall(profile(), resource(), formatCoordinates(coordinates()), MapplsAccountManager.getInstance().getRestAPIKey(), radius(), steps(), bearing(), lessVerbose(), annotation(), language(), roundaboutExits(), continueStraight(), bannerInstructions(), exclude(), routeRefresh(), deviceId(), sessionId(), isSort(), skipWaypoints(), instructions(), routeType(), createRequest());
    }

    private Map<String, Object> createRequest() {
        HashMap map = new HashMap();
        map.put("geometries", geometries());
        if (alternatives() != null) {
            map.put("alternatives", alternatives());
        }
        if (overview() != null) {
            map.put("overview", overview());
        }
        if (internalDateTime() != null) {
            map.put("date_time", internalDateTime());
        }
        if (internalSoc() != null) {
            map.put("soc", internalSoc());
        }
        if (batteryCapacity() != null) {
            map.put("battery_capacity", batteryCapacity());
        }
        if (mass() != null) {
            map.put("mass", mass());
        }
        if (efficiency() != null) {
            map.put("efficiency", efficiency());
        }
        if (aux() != null) {
            map.put("aux", aux());
        }
        if (regen() != null) {
            map.put("regen", regen());
        }
        return map;
    }

    private Call<DirectionsResponse> post() {
        return getLoginService(true).postCall(profile(), resource(), formatCoordinates(coordinates()), MapplsAccountManager.getInstance().getRestAPIKey(), radius(), steps(), bearing(), lessVerbose(), annotation(), language(), roundaboutExits(), continueStraight(), bannerInstructions(), exclude(), routeRefresh(), deviceId(), sessionId(), isSort(), skipWaypoints(), instructions(), routeType(), createRequest());
    }

    void enqueue(final Callback<DirectionsResponse> callback) {
        getCall().enqueue(new Callback<DirectionsResponse>() { // from class: com.mappls.sdk.services.api.directions.MapplsDirections.1
            @Override // retrofit2.Callback
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                callback.onResponse(call, new DirectionsResponseFactory(MapplsDirections.this).generate(response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<DirectionsResponse> call, Throwable th) {
                callback.onFailure(call, th);
            }
        });
    }

    Response<DirectionsResponse> execute() throws IOException {
        return new DirectionsResponseFactory(this).generate(super.executeCall());
    }

    void cancel() {
        cancelCall();
    }

    boolean executed() {
        return super.isExecuted();
    }

    Double walkingSpeed() {
        if (hasWalkingOptions()) {
            return walkingOptions().walkingSpeed();
        }
        return null;
    }

    Double walkwayBias() {
        if (hasWalkingOptions()) {
            return walkingOptions().walkwayBias();
        }
        return null;
    }

    Double alleyBias() {
        if (hasWalkingOptions()) {
            return walkingOptions().alleyBias();
        }
        return null;
    }

    private boolean hasWalkingOptions() {
        return walkingOptions() != null;
    }

    public static abstract class Builder {
        private String[] annotations;
        private String[] approaches;
        private List<Double[]> bearings = new ArrayList();
        private List<String> coordinates = new ArrayList();
        private String destination;
        private Boolean excludeContainmentZone;
        private String[] excludes;
        private String origin;
        private double[] radiuses;
        private String[] socs;
        private Integer[] waypointIndices;
        private String[] waypointNames;
        private Point[] waypointTargets;

        public abstract Builder alternatives(Boolean bool);

        abstract Builder annotation(String str);

        abstract Builder approaches(String str);

        abstract MapplsDirections autoBuild();

        public abstract Builder aux(Double d);

        public abstract Builder bannerInstructions(Boolean bool);

        public abstract Builder baseUrl(String str);

        public abstract Builder batteryCapacity(Integer num);

        abstract Builder bearing(String str);

        public abstract Builder clientAppName(String str);

        public abstract Builder continueStraight(Boolean bool);

        abstract Builder coordinates(List<String> list);

        public abstract Builder deviceId(String str);

        public abstract Builder efficiency(Double d);

        abstract Builder exclude(String str);

        public abstract Builder geometries(String str);

        public abstract Builder instructions(Boolean bool);

        public abstract Builder internalDateTime(String str);

        abstract Builder internalSoc(String str);

        public abstract Builder isSort(Boolean bool);

        abstract Builder language(String str);

        public abstract Builder lessVerbose(Boolean bool);

        public abstract Builder mass(Integer num);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        abstract Builder radius(String str);

        public abstract Builder regen(Double d);

        public abstract Builder resource(String str);

        public abstract Builder roundaboutExits(Boolean bool);

        public abstract Builder routeRefresh(Boolean bool);

        public abstract Builder routeType(Integer num);

        public abstract Builder sessionId(String str);

        public abstract Builder skipWaypoints(Boolean bool);

        public abstract Builder steps(Boolean bool);

        abstract Builder usePostMethod(Boolean bool);

        abstract Boolean usePostMethod();

        public abstract Builder user(String str);

        public abstract Builder walkingOptions(WalkingOptions walkingOptions);

        abstract WalkingOptions walkingOptions();

        abstract Builder waypointIndices(String str);

        abstract Builder waypointNames(String str);

        abstract Builder waypointTargets(String str);

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

        public Builder dateTime(MapplsDirectionDateTime mapplsDirectionDateTime) {
            return internalDateTime(mapplsDirectionDateTime.type() + "," + mapplsDirectionDateTime.dateTimeInMillis());
        }

        public Builder language(Locale locale) {
            if (locale != null) {
                language(locale.getLanguage());
            }
            return this;
        }

        public Builder annotations(String... strArr) {
            this.annotations = strArr;
            return this;
        }

        public Builder addBearing(Double d, Double d2) {
            if (d == null || d2 == null) {
                this.bearings.add(new Double[0]);
            } else {
                this.bearings.add(new Double[]{d, d2});
            }
            return this;
        }

        public Builder radiuses(double... dArr) {
            this.radiuses = dArr;
            return this;
        }

        public Builder excludes(String... strArr) {
            this.excludes = strArr;
            return this;
        }

        public Builder addApproaches(String... strArr) {
            this.approaches = strArr;
            return this;
        }

        public Builder addWaypointIndices(Integer... numArr) {
            this.waypointIndices = numArr;
            return this;
        }

        public Builder addWaypointNames(String... strArr) {
            this.waypointNames = strArr;
            return this;
        }

        public Builder addWaypointTargets(Point... pointArr) {
            this.waypointTargets = pointArr;
            return this;
        }

        public Builder excludeContainmentZone(Boolean bool) {
            this.excludeContainmentZone = bool;
            return this;
        }

        public Builder post() {
            usePostMethod(true);
            return this;
        }

        public Builder get() {
            usePostMethod(false);
            return this;
        }

        public Builder soc(String... strArr) {
            this.socs = strArr;
            return this;
        }

        public MapplsDirections build() {
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
            if (this.coordinates.size() > 100) {
                throw new ServicesException("Maximum of 100 coordinates are allowed including origin and destination for this API.");
            }
            Integer[] numArr = this.waypointIndices;
            if (numArr != null) {
                if (numArr.length < 2) {
                    throw new ServicesException("Waypoints must be a list of at least two indexes separated by ';'");
                }
                if (numArr[0].intValue() == 0) {
                    Integer[] numArr2 = this.waypointIndices;
                    if (numArr2[numArr2.length - 1].intValue() == this.coordinates.size() - 1) {
                        int i = 1;
                        while (true) {
                            Integer[] numArr3 = this.waypointIndices;
                            if (i >= numArr3.length - 1) {
                                break;
                            }
                            if (numArr3[i].intValue() < 0 || this.waypointIndices[i].intValue() >= this.coordinates.size()) {
                                throw new ServicesException("Waypoints index too large (no corresponding coordinate)");
                            }
                            i++;
                        }
                    }
                }
                throw new ServicesException("Waypoints must contain indices of the first and last coordinates");
            }
            String[] strArr = this.waypointNames;
            if (strArr != null) {
                waypointNames(MapplsUtils.formatWaypointNames(strArr));
            }
            Point[] pointArr = this.waypointTargets;
            if (pointArr != null) {
                if (pointArr.length == this.coordinates.size()) {
                    waypointTargets(MapplsDirections.formatWaypointTargets(this.waypointTargets));
                } else {
                    throw new ServicesException("Number of waypoint targets must match  the number of waypoints provided.");
                }
            }
            String[] strArr2 = this.approaches;
            if (strArr2 != null) {
                if (strArr2.length != this.coordinates.size()) {
                    throw new ServicesException("Number of approach elements must match number of coordinates provided.");
                }
                String approaches = MapplsUtils.formatApproaches(this.approaches);
                if (approaches == null) {
                    throw new ServicesException("All approaches values must be one of curb, unrestricted");
                }
                approaches(approaches);
            }
            coordinates(this.coordinates);
            bearing(MapplsUtils.formatBearing(this.bearings));
            String strJoin = MapplsUtils.join(",", this.annotations);
            if (strJoin != null && strJoin.equalsIgnoreCase(BuildConfig.TRAVIS)) {
                strJoin = null;
            }
            annotation(strJoin);
            String strJoin2 = MapplsUtils.join(",", this.excludes);
            exclude((strJoin2 == null || !strJoin2.equalsIgnoreCase(BuildConfig.TRAVIS)) ? strJoin2 : null);
            radius(MapplsUtils.formatRadiuses(this.radiuses));
            waypointIndices(MapplsUtils.join(";", this.waypointIndices));
            Boolean bool = this.excludeContainmentZone;
            if (bool != null && bool.booleanValue()) {
                routeType(2);
            }
            String strJoin3 = MapplsUtils.join(",", this.socs);
            if (strJoin3 != null) {
                internalSoc(strJoin3);
            }
            return autoBuild();
        }
    }
}
