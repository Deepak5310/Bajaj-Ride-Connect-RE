package com.mappls.sdk.maps.rctmgl.modules;

import androidx.autofill.HintConstants;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.BV.LinearGradient.LinearGradientManager;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.maps.model.FeatureType;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsType;
import com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsList;
import com.mappls.sdk.geoanalytics.listing.MapplsGeoAnalyticsListManager;
import com.mappls.sdk.geoanalytics.listing.model.GeoAnalyticsListResponse;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRoute;
import com.mappls.sdk.services.api.alongroute.MapplsPOIAlongRouteManager;
import com.mappls.sdk.services.api.alongroute.POICriteria;
import com.mappls.sdk.services.api.alongroute.models.POIAlongRouteResponse;
import com.mappls.sdk.services.api.autosuggest.AutoSuggestCriteria;
import com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest;
import com.mappls.sdk.services.api.autosuggest.MapplsAutosuggestManager;
import com.mappls.sdk.services.api.autosuggest.model.AutoSuggestAtlasResponse;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimation;
import com.mappls.sdk.services.api.costestimation.MapplsCostEstimationManager;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTimeCurrent;
import com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTimeSpecified;
import com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefresh;
import com.mappls.sdk.services.api.directionsrefresh.MapplsDirectionsRefreshManager;
import com.mappls.sdk.services.api.distance.MapplsDistanceMatrix;
import com.mappls.sdk.services.api.distance.MapplsDistanceMatrixManager;
import com.mappls.sdk.services.api.distance.models.DistanceResponse;
import com.mappls.sdk.services.api.event.catmaster.MapplsCategoryMaster;
import com.mappls.sdk.services.api.event.catmaster.MapplsCategoryMasterManager;
import com.mappls.sdk.services.api.event.catmaster.model.ReportMasterResponse;
import com.mappls.sdk.services.api.event.nearby.MapplsNearbyReport;
import com.mappls.sdk.services.api.event.nearby.MapplsNearbyReportManager;
import com.mappls.sdk.services.api.event.nearby.model.NearbyReportResponse;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummary;
import com.mappls.sdk.services.api.event.route.MapplsRouteSummaryManager;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import com.mappls.sdk.services.api.feedback.MapplsFeedback;
import com.mappls.sdk.services.api.feedback.MapplsFeedbackManager;
import com.mappls.sdk.services.api.fuleCost.MapplsFuelCost;
import com.mappls.sdk.services.api.fuleCost.MapplsFuelCostManager;
import com.mappls.sdk.services.api.fuleCost.models.FuelCostResponse;
import com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP;
import com.mappls.sdk.services.api.generateotp.MapplsGenerateOtpManager;
import com.mappls.sdk.services.api.geocoding.GeoCodeResponse;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import com.mappls.sdk.services.api.geocoding.MapplsGeoCoding;
import com.mappls.sdk.services.api.geocoding.MapplsGeoCodingManager;
import com.mappls.sdk.services.api.hateaosnearby.MapplsHateosNearby;
import com.mappls.sdk.services.api.hateaosnearby.MapplsHateosNearbyManager;
import com.mappls.sdk.services.api.nearby.MapplsNearby;
import com.mappls.sdk.services.api.nearby.MapplsNearbyManager;
import com.mappls.sdk.services.api.nearby.NearbyCriteria;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail;
import com.mappls.sdk.services.api.placedetail.MapplsPlaceDetailManager;
import com.mappls.sdk.services.api.placedetail.model.PlaceDetailResponse;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices;
import com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevicesManager;
import com.mappls.sdk.services.api.session.devicelist.model.Device;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSession;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSessionManager;
import com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice;
import com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDeviceManager;
import com.mappls.sdk.services.api.textsearch.MapplsTextSearch;
import com.mappls.sdk.services.api.textsearch.MapplsTextSearchManager;
import com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetail;
import com.mappls.sdk.services.api.traffic.MapplsRoadTrafficDetailManager;
import com.mappls.sdk.services.api.traffic.model.TrafficRoadDetailResponse;
import com.mappls.sdk.services.api.transit.MapplsTransitPlanner;
import com.mappls.sdk.services.api.transit.MapplsTransitPlannerManager;
import com.mappls.sdk.services.api.transit.model.TransitPlannerResponse;
import com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisation;
import com.mappls.sdk.services.api.tripoptimisation.MapplsTripOptimisationManager;
import com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse;
import com.mappls.sdk.services.api.weather.MapplsWeather;
import com.mappls.sdk.services.api.weather.MapplsWeatherManager;
import com.mappls.sdk.services.api.weather.model.WeatherResponse;
import com.mappls.sdk.services.api.whitelist.MapplsWhitelist;
import com.mappls.sdk.services.api.whitelist.MapplsWhitelistManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLRestApiModule")
public class RCTMGLRestApiModule extends ReactContextBaseJavaModule {
    static final String REACT_CLASS = "RCTMGLRestApiModule";
    static final String REQUIRED_CODE = "REQUIRED PARAMETER";

    public RCTMGLRestApiModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("POD_CITY", "CITY");
        map.put("POD_DISTRICT", AutoSuggestCriteria.POD_DISTRICT);
        map.put("POD_LOCALITY", "LC");
        map.put("POD_STATE", "STATE");
        map.put("POD_SUB_DISTRICT", AutoSuggestCriteria.POD_SUB_DISTRICT);
        map.put("POD_SUB_LOCALITY", "SLC");
        map.put("POD_SUB_SUB_LOCALITY", AutoSuggestCriteria.POD_SUB_SUB_LOCALITY);
        map.put("POD_VILLAGE", AutoSuggestCriteria.POD_VILLAGE);
        map.put("POD_POI", AutoSuggestCriteria.POD_POI);
        HashMap map2 = new HashMap();
        map2.put("BIAS_DEFAULT", 0);
        map2.put("BIAS_RURAL", -1);
        map2.put("BIAS_URBAN", 1);
        map2.put("POD_CITY", GeoCodingCriteria.POD_CITY);
        map2.put("POD_DISTRICT", "dist");
        map2.put("POD_HOUSE_NAME", GeoCodingCriteria.POD_HOUSE_NAME);
        map2.put("POD_HOUSE_NUMBER", GeoCodingCriteria.POD_HOUSE_NUMBER);
        map2.put("POD_LOCALITY", GeoCodingCriteria.POD_LOCALITY);
        map2.put("POD_PINCODE", GeoCodingCriteria.POD_PINCODE);
        map2.put("POD_POI", GeoCodingCriteria.POD_POINT_OF_INTEREST);
        map2.put("POD_STATE", "state");
        map2.put("POD_STREET", GeoCodingCriteria.POD_STREET);
        map2.put("POD_SUB_DISTRICT", GeoCodingCriteria.POD_SUB_DISTRICT);
        map2.put("POD_SUB_LOCALITY", GeoCodingCriteria.POD_SUB_LOCALITY);
        map2.put("POD_SUB_SUB_LOCALITY", GeoCodingCriteria.POD_SUB_SUB_LOCALITY);
        map2.put("POD_VILLAGE", GeoCodingCriteria.POD_VILLAGE);
        HashMap map3 = new HashMap();
        map3.put("DISTANCE_ASCENDING", NearbyCriteria.DISTANCE_ASCENDING);
        map3.put("DISTANCE_DESCENDING", NearbyCriteria.DISTANCE_DESCENDING);
        map3.put("NAME_ASCENDING", NearbyCriteria.NAME_ASCENDING);
        map3.put("NAME_DESCENDING", NearbyCriteria.NAME_DESCENDING);
        map3.put("DISTANCE", "dist");
        map3.put("IMPORTANCE", NearbyCriteria.IMPORTANCE);
        map3.put("POD_SUB_LOCALITY", "SLC");
        map3.put("POD_LOCALITY", "LC");
        map3.put("POD_CITY", "CITY");
        map3.put("POD_STATE", "STATE");
        HashMap map4 = new HashMap();
        map4.put("EXCLUDE_TUNNEL", DirectionsCriteria.EXCLUDE_TUNNEL);
        map4.put("EXCLUDE_RESTRICTED", DirectionsCriteria.EXCLUDE_RESTRICTED);
        map4.put("EXCLUDE_MOTORWAY", DirectionsCriteria.EXCLUDE_MOTORWAY);
        map4.put("EXCLUDE_FERRY", DirectionsCriteria.EXCLUDE_FERRY);
        map4.put("EXCLUDE_TOLL", DirectionsCriteria.EXCLUDE_TOLL);
        map4.put("ANNOTATION_SPEED", "speed");
        map4.put("ANNOTATION_NODES", DirectionsCriteria.ANNOTATION_NODES);
        map4.put("ANNOTATION_MAXSPEED", DirectionsCriteria.ANNOTATION_MAXSPEED);
        map4.put("ANNOTATION_DURATION", "duration");
        map4.put("ANNOTATION_DISTANCE", DirectionsCriteria.ANNOTATION_DISTANCE);
        map4.put("ANNOTATION_BASE_DURATION", DirectionsCriteria.ANNOTATION_BASE_DURATION);
        map4.put("ANNOTATION_CONGESTION", DirectionsCriteria.ANNOTATION_CONGESTION);
        map4.put("ANNOTATION_SPEED_LIMIT", DirectionsCriteria.ANNOTATION_SPEED_LIMIT);
        map4.put("ANNOTATION_TOLL_ROAD", DirectionsCriteria.ANNOTATION_TOLL_ROAD);
        map4.put("OVERVIEW_FALSE", "false");
        map4.put("OVERVIEW_SIMPLIFIED", "simplified");
        map4.put("OVERVIEW_FULL", "full");
        map4.put("PROFILE_WALKING", "walking");
        map4.put("PROFILE_TRUCKING", "trucking");
        map4.put("PROFILE_BIKING", "biking");
        map4.put("PROFILE_DRIVING", "driving");
        map4.put("RESOURCE_ROUTE_TRAFFIC", DirectionsCriteria.RESOURCE_ROUTE_TRAFFIC);
        map4.put("RESOURCE_ROUTE", DirectionsCriteria.RESOURCE_ROUTE);
        map4.put("RESOURCE_ROUTE_ETA", DirectionsCriteria.RESOURCE_ROUTE_ETA);
        map4.put("RESOURCE_DISTANCE", DirectionsCriteria.RESOURCE_DISTANCE);
        map4.put("RESOURCE_DISTANCE_ETA", DirectionsCriteria.RESOURCE_DISTANCE_ETA);
        map4.put("RESOURCE_DISTANCE_TRAFFIC", DirectionsCriteria.RESOURCE_DISTANCE_TRAFFIC);
        map4.put("RESOURCE_ROUTE_PREDICTIVE", DirectionsCriteria.RESOURCE_ROUTE_PREDICTIVE);
        map4.put("RESOURCE_DISTANCE_PREDICTIVE", DirectionsCriteria.RESOURCE_DISTANCE_PREDICTIVE);
        map4.put("APPROACH_CURB", DirectionsCriteria.APPROACH_CURB);
        map4.put("APPROACH_UNRESTRICTED", DirectionsCriteria.APPROACH_UNRESTRICTED);
        map4.put("DESTINATION_ANY", "any");
        map4.put("DESTINATION_LAST", "last");
        map4.put("GEOMETRY_POLYLINE", "polyline");
        map4.put("GEOMETRY_POLYLINE6", "polyline6");
        map4.put("GEOMETRY_COORDINATES", "geojson");
        map4.put("IMPERIAL", DirectionsCriteria.IMPERIAL);
        map4.put("METRIC", DirectionsCriteria.METRIC);
        map4.put("SOURCE_ANY", "any");
        map4.put("SOURCE_FIRST", "first");
        map4.put("ROUTE_TYPE_OPTIMAL", 0);
        map4.put("ROUTE_TYPE_SHORTEST", 1);
        map4.put("DISTANCE_ROUTE_TYPE_OPTIMAL", 0);
        map4.put("DISTANCE_ROUTE_TYPE_SHORTEST", 1);
        map4.put("SPECIFIED_ARRIVAL", 2);
        map4.put("SPECIFIED_DEPARTURE", 1);
        map4.put("DATE_TIME_SPECIFIED", 0);
        map4.put("DATE_TIME_CURRENT", 1);
        HashMap map5 = new HashMap();
        map5.put("GEOMETRY_BASE64", "base64");
        map5.put("GEOMETRY_POLYLINE5", POICriteria.GEOMETRY_POLYLINE5);
        map5.put("GEOMETRY_POLYLINE6", "polyline6");
        map5.put("GEOMETRY_COORDINATES", "geojson");
        HashMap map6 = new HashMap();
        map6.put("SESSION_TYPE_GLOBAL", "global");
        map6.put("SESSION_TYPE_NAVIGATION", "navigation");
        HashMap map7 = new HashMap();
        map7.put("STATE", MapplsGeoAnalyticsType.STATE.getName());
        map7.put("DISTRICT", MapplsGeoAnalyticsType.DISTRICT.getName());
        map7.put("SUB_DISTRICT", MapplsGeoAnalyticsType.SUB_DISTRICT.getName());
        map7.put("WARD", MapplsGeoAnalyticsType.WARD.getName());
        map7.put(FeatureType.LOCALITY, MapplsGeoAnalyticsType.LOCALITY.getName());
        map7.put("PANCHAYAT", MapplsGeoAnalyticsType.PANCHAYAT.getName());
        map7.put("BLOCK", MapplsGeoAnalyticsType.BLOCK.getName());
        map7.put("PINCODE", MapplsGeoAnalyticsType.PINCODE.getName());
        map7.put("TOWN", MapplsGeoAnalyticsType.TOWN.getName());
        map7.put("CITY", MapplsGeoAnalyticsType.CITY.getName());
        map7.put("VILLAGE", MapplsGeoAnalyticsType.VILLAGE.getName());
        map7.put("SUB_LOCALITY", MapplsGeoAnalyticsType.SUB_LOCALITY.getName());
        map7.put("SUB_SUB_LOCALITY", MapplsGeoAnalyticsType.SUB_SUB_LOCALITY.getName());
        return MapBuilder.builder().put("AutoSuggestCriteria", map).put("GeoCodingCriteria", map2).put("NearbyCriteria", map3).put("DirectionsCriteria", map4).put("POICriteria", map5).put("SessionCriteria", map6).put("GeoAnalyticsType", map7).build();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLRestApiModule";
    }

    @ReactMethod
    public void reverseGeocode(ReadableMap readableMap, final Promise promise) {
        if (readableMap.hasKey("latitude")) {
            double d = readableMap.getDouble("latitude");
            if (readableMap.hasKey("longitude")) {
                double d2 = readableMap.getDouble("longitude");
                MapplsReverseGeoCode.Builder builder = MapplsReverseGeoCode.builder();
                if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
                    builder.baseUrl(readableMap.getString("baseUrl"));
                }
                builder.setLocation(d, d2);
                if (readableMap.hasKey("lang")) {
                    builder.lang(readableMap.getString("lang"));
                }
                MapplsReverseGeoCodeManager.newInstance(builder.build()).call(new OnResponseCallback<PlaceResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.1
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(PlaceResponse placeResponse) {
                        promise.resolve(new Gson().toJson(placeResponse));
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i, String str) {
                        promise.reject(String.valueOf(i), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "PPlease provide longitude parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide latitude parameter");
    }

    @ReactMethod
    public void autoSuggest(ReadableMap readableMap, final Promise promise) {
        MapplsAutoSuggest.Builder builder = MapplsAutoSuggest.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(SearchIntents.EXTRA_QUERY) && !readableMap.isNull(SearchIntents.EXTRA_QUERY)) {
            builder.query(readableMap.getString(SearchIntents.EXTRA_QUERY));
            if (readableMap.hasKey("filter")) {
                builder.filter(readableMap.getString("filter"));
            }
            if (readableMap.hasKey("pod")) {
                builder.pod(readableMap.getString("pod"));
            }
            if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && !readableMap.isNull(FirebaseAnalytics.Param.LOCATION)) {
                ReadableMap map = readableMap.getMap(FirebaseAnalytics.Param.LOCATION);
                if (map.hasKey("latitude") && map.hasKey("longitude")) {
                    builder.setLocation(Double.valueOf(map.getDouble("latitude")), Double.valueOf(map.getDouble("longitude")));
                }
            }
            if (readableMap.hasKey("tokenizeAddress") && readableMap.getBoolean("tokenizeAddress")) {
                builder.tokenizeAddress(true);
            }
            if (readableMap.hasKey("zoom")) {
                builder.zoom(Double.valueOf(readableMap.getDouble("zoom")));
            }
            if (readableMap.hasKey("bridge") && !readableMap.isNull("bridge")) {
                builder.bridge(Boolean.valueOf(readableMap.getBoolean("bridge")));
            }
            if (readableMap.hasKey("hyperLocal") && !readableMap.isNull("hyperLocal")) {
                builder.hyperLocal(Boolean.valueOf(readableMap.getBoolean("hyperLocal")));
            }
            if (readableMap.hasKey("responseLang") && !readableMap.isNull("hyperLocal")) {
                builder.responseLang(readableMap.getString("responseLang"));
            }
            if (readableMap.hasKey("explain") && !readableMap.isNull("explain")) {
                builder.explain(Boolean.valueOf(readableMap.getBoolean("explain")));
            }
            MapplsAutosuggestManager.newInstance(builder.build()).call(new OnResponseCallback<AutoSuggestAtlasResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.2
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
                    promise.resolve(new Gson().toJson(autoSuggestAtlasResponse));
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide query parameter");
    }

    @ReactMethod
    public void geocode(ReadableMap readableMap, final Promise promise) {
        MapplsGeoCoding.Builder builder = MapplsGeoCoding.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(PlaceTypes.ADDRESS) && !readableMap.isNull(PlaceTypes.ADDRESS)) {
            builder.setAddress(readableMap.getString(PlaceTypes.ADDRESS));
            if (readableMap.hasKey("bias")) {
                builder.bias(Integer.valueOf(readableMap.getInt("bias")));
            }
            if (readableMap.hasKey("bound")) {
                builder.bound(readableMap.getString("bound"));
            }
            if (readableMap.hasKey("itemCount")) {
                builder.itemCount(Integer.valueOf(readableMap.getInt("itemCount")));
            }
            if (readableMap.hasKey("podFilter")) {
                builder.podFilter(readableMap.getString("podFilter"));
            }
            if (readableMap.hasKey("scores")) {
                builder.scores(Boolean.valueOf(readableMap.getBoolean("scores")));
            }
            MapplsGeoCodingManager.newInstance(builder.build()).call(new OnResponseCallback<GeoCodeResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.3
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(GeoCodeResponse geoCodeResponse) {
                    promise.resolve(new Gson().toJson(geoCodeResponse));
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
            return;
        }
        promise.reject(REQUIRED_CODE, "please provide address parameter");
    }

    @ReactMethod
    public void textSearch(ReadableMap readableMap, final Promise promise) {
        MapplsTextSearch.Builder builder = MapplsTextSearch.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(SearchIntents.EXTRA_QUERY) && !readableMap.isNull(SearchIntents.EXTRA_QUERY)) {
            builder.query(readableMap.getString(SearchIntents.EXTRA_QUERY));
            if (readableMap.hasKey("bridge")) {
                builder.bridge(Boolean.valueOf(readableMap.getBoolean("bridge")));
            }
            if (readableMap.hasKey("explain")) {
                builder.explain(Boolean.valueOf(readableMap.getBoolean("explain")));
            }
            if (readableMap.hasKey("filter")) {
                builder.filter(readableMap.getString("filter"));
            }
            if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && readableMap.hasKey("latitude") && readableMap.hasKey("longitude")) {
                builder.setLocation(Double.valueOf(readableMap.getDouble("latitude")), Double.valueOf(readableMap.getDouble("longitude")));
            }
            if (readableMap.hasKey(HintConstants.AUTOFILL_HINT_USERNAME)) {
                builder.username(readableMap.getString(HintConstants.AUTOFILL_HINT_USERNAME));
            }
            MapplsTextSearchManager.newInstance(builder.build()).call(new OnResponseCallback<AutoSuggestAtlasResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.4
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(AutoSuggestAtlasResponse autoSuggestAtlasResponse) {
                    promise.resolve(new Gson().toJson(autoSuggestAtlasResponse));
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
            return;
        }
        promise.reject(REQUIRED_CODE, "please provide query parameter");
    }

    @ReactMethod
    public void placeDetail(ReadableMap readableMap, final Promise promise) {
        MapplsPlaceDetail.Builder builder = MapplsPlaceDetail.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("mapplsPin") && !readableMap.isNull("mapplsPin")) {
            builder.mapplsPin(readableMap.getString("mapplsPin"));
            MapplsPlaceDetailManager.newInstance(builder.build()).call(new OnResponseCallback<PlaceDetailResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.5
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(PlaceDetailResponse placeDetailResponse) {
                    promise.resolve(new Gson().toJson(placeDetailResponse));
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
        } else {
            promise.reject(REQUIRED_CODE, "Please provide mappls pin parameter");
        }
    }

    @ReactMethod
    public void POIAlongRoute(ReadableMap readableMap, final Promise promise) {
        MapplsPOIAlongRoute.Builder builder = MapplsPOIAlongRoute.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(SavingTrackHelper.POINT_COL_CATEGORY) && !readableMap.isNull(SavingTrackHelper.POINT_COL_CATEGORY)) {
            builder.category(readableMap.getString(SavingTrackHelper.POINT_COL_CATEGORY));
            if (readableMap.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) && !readableMap.isNull(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                builder.path(readableMap.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
                if (readableMap.hasKey("buffer")) {
                    builder.buffer(Integer.valueOf(readableMap.getInt("buffer")));
                }
                if (readableMap.hasKey("geometries")) {
                    builder.geometries(readableMap.getString("geometries"));
                }
                if (readableMap.hasKey("page")) {
                    builder.page(Integer.valueOf(readableMap.getInt("page")));
                }
                if (readableMap.hasKey(Constants.SORT)) {
                    builder.sort(Boolean.valueOf(readableMap.getBoolean(Constants.SORT)));
                }
                MapplsPOIAlongRouteManager.newInstance(builder.build()).call(new OnResponseCallback<POIAlongRouteResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.6
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(POIAlongRouteResponse pOIAlongRouteResponse) {
                        promise.resolve(new Gson().toJson(pOIAlongRouteResponse));
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i, String str) {
                        promise.reject(String.valueOf(i), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "Please provide path parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide category parameter");
    }

    @ReactMethod
    public void nearby(ReadableMap readableMap, final Promise promise) {
        MapplsNearby.Builder builder = MapplsNearby.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("keyword") && !readableMap.isNull("keyword")) {
            builder.keyword(readableMap.getString("keyword"));
            if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && !readableMap.isNull(FirebaseAnalytics.Param.LOCATION)) {
                String string = readableMap.getString(FirebaseAnalytics.Param.LOCATION);
                if (string.contains(",")) {
                    String[] strArrSplit = string.split(",");
                    builder.setLocation(Double.valueOf(Double.parseDouble(strArrSplit[0])), Double.valueOf(Double.parseDouble(strArrSplit[1])));
                } else {
                    builder.setLocation(string);
                }
                if (readableMap.hasKey("bounds")) {
                    builder.bounds(readableMap.getString("bounds"));
                }
                if (readableMap.hasKey("filter")) {
                    builder.filter(readableMap.getString("filter"));
                }
                if (readableMap.hasKey("page")) {
                    builder.page(Integer.valueOf(readableMap.getInt("page")));
                }
                if (readableMap.hasKey("pod")) {
                    builder.pod(readableMap.getString("pod"));
                }
                if (readableMap.hasKey("radius")) {
                    builder.radius(Integer.valueOf(readableMap.getInt("radius")));
                }
                if (readableMap.hasKey("searchBy")) {
                    builder.searchBy(readableMap.getString("searchBy"));
                }
                if (readableMap.hasKey("sortBy")) {
                    builder.sortBy(readableMap.getString("sortBy"));
                }
                if (readableMap.hasKey("explain")) {
                    builder.explain(Boolean.valueOf(readableMap.getBoolean("explain")));
                }
                if (readableMap.hasKey("richData")) {
                    builder.richData(Boolean.valueOf(readableMap.getBoolean("richData")));
                }
                if (readableMap.hasKey("userName")) {
                    builder.userName(readableMap.getString("userName"));
                }
                MapplsNearbyManager.newInstance(builder.build()).call(new OnResponseCallback<NearbyAtlasResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.7
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(NearbyAtlasResponse nearbyAtlasResponse) {
                        promise.resolve(new Gson().toJson(nearbyAtlasResponse));
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i, String str) {
                        promise.reject(String.valueOf(i), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "Please provide location parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide keyword parameter");
    }

    @ReactMethod
    public void directionRefresh(ReadableMap readableMap, final Promise promise) {
        MapplsDirectionsRefresh.Builder builder = MapplsDirectionsRefresh.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(PlaceTypes.ROUTE)) {
            DirectionsRoute directionsRouteFromJson = DirectionsRoute.fromJson(readableMap.getString(PlaceTypes.ROUTE));
            if (directionsRouteFromJson.routeOptions() != null) {
                RouteOptions routeOptions = directionsRouteFromJson.routeOptions();
                if (routeOptions.requestUuid() != null) {
                    builder.requestId(routeOptions.requestUuid());
                    if (routeOptions.sessionId() != null) {
                        builder.sessionId(routeOptions.sessionId());
                        builder.profile(routeOptions.profile());
                        builder.isSort(routeOptions.isSort());
                    } else {
                        promise.reject(REQUIRED_CODE, "Session Id not available");
                        return;
                    }
                } else {
                    promise.reject(REQUIRED_CODE, "Request Id not available");
                    return;
                }
            }
            if (readableMap.hasKey("tripType")) {
                builder.tripType(Integer.valueOf(readableMap.getInt("tripType")));
                if (readableMap.hasKey("nodeIndex")) {
                    builder.nodeIndex(Long.valueOf(readableMap.getInt("nodeIndex")));
                }
                if (readableMap.hasKey("routeIndex")) {
                    builder.routeIndex(Integer.valueOf(readableMap.getInt("routeIndex")));
                }
                if (readableMap.hasKey("isRefresh")) {
                    builder.isRefresh(Boolean.valueOf(readableMap.getBoolean("isRefresh")));
                }
                MapplsDirectionsRefreshManager.newInstance(builder.build()).call(new OnResponseCallback<DirectionsRoute>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.8
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(DirectionsRoute directionsRoute) {
                        promise.resolve(directionsRoute.toJson());
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i, String str) {
                        promise.reject(String.valueOf(i), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "Please provide tripType parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide route parameter");
    }

    @ReactMethod
    public void direction(ReadableMap readableMap, final Promise promise) {
        MapplsDirections.Builder builder = MapplsDirections.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("origin")) {
            String string = readableMap.getString("origin");
            if (string.contains(",")) {
                String[] strArrSplit = string.split(",");
                builder.origin(Point.fromLngLat(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1])));
            } else {
                builder.origin(string);
            }
            if (readableMap.hasKey(FirebaseAnalytics.Param.DESTINATION)) {
                String string2 = readableMap.getString(FirebaseAnalytics.Param.DESTINATION);
                if (string2.contains(",")) {
                    String[] strArrSplit2 = string2.split(",");
                    builder.destination(Point.fromLngLat(Double.parseDouble(strArrSplit2[0]), Double.parseDouble(strArrSplit2[1])));
                } else {
                    builder.destination(string2);
                }
                if (readableMap.hasKey("waypoints") && !readableMap.isNull("waypoints")) {
                    ReadableArray array = readableMap.getArray("waypoints");
                    for (int i = 0; i < array.size(); i++) {
                        String string3 = array.getString(i);
                        if (string3.contains(",")) {
                            String[] strArrSplit3 = string3.split(",");
                            builder.addWaypoint(Point.fromLngLat(Double.parseDouble(strArrSplit3[0]), Double.parseDouble(strArrSplit3[1])));
                        } else {
                            builder.addWaypoint(string3);
                        }
                    }
                }
                if (readableMap.hasKey("excludes")) {
                    ReadableArray array2 = readableMap.getArray("excludes");
                    String[] strArr = new String[array2.size()];
                    for (int i2 = 0; i2 < array2.size(); i2++) {
                        strArr[i2] = array2.getString(i2);
                    }
                    builder.excludes(strArr);
                }
                if (readableMap.hasKey("annotations")) {
                    ReadableArray array3 = readableMap.getArray("annotations");
                    String[] strArr2 = new String[array3.size()];
                    for (int i3 = 0; i3 < array3.size(); i3++) {
                        strArr2[i3] = array3.getString(i3);
                    }
                    builder.annotations(strArr2);
                }
                if (readableMap.hasKey("overview")) {
                    builder.overview(readableMap.getString("overview"));
                }
                if (readableMap.hasKey("steps")) {
                    builder.steps(Boolean.valueOf(readableMap.getBoolean("steps")));
                }
                if (readableMap.hasKey("alternatives")) {
                    builder.alternatives(Boolean.valueOf(readableMap.getBoolean("alternatives")));
                }
                if (readableMap.hasKey("approaches")) {
                    ReadableArray array4 = readableMap.getArray("approaches");
                    String[] strArr3 = new String[array4.size()];
                    for (int i4 = 0; i4 < array4.size(); i4++) {
                        strArr3[i4] = array4.getString(i4);
                    }
                    builder.addApproaches(strArr3);
                }
                if (readableMap.hasKey("bearing")) {
                    ReadableMap map = readableMap.getMap("bearing");
                    if (map.hasKey(LinearGradientManager.PROP_ANGLE) && map.hasKey("tolerance")) {
                        builder.addBearing(Double.valueOf(map.getDouble(LinearGradientManager.PROP_ANGLE)), Double.valueOf(map.getDouble("tolerance")));
                    }
                }
                if (readableMap.hasKey("waypointIndices")) {
                    ReadableArray array5 = readableMap.getArray("waypointIndices");
                    Integer[] numArr = new Integer[array5.size()];
                    for (int i5 = 0; i5 < array5.size(); i5++) {
                        numArr[i5] = Integer.valueOf(array5.getInt(i5));
                    }
                    builder.addWaypointIndices(numArr);
                }
                if (readableMap.hasKey("waypointNames")) {
                    ReadableArray array6 = readableMap.getArray("waypointNames");
                    String[] strArr4 = new String[array6.size()];
                    for (int i6 = 0; i6 < array6.size(); i6++) {
                        strArr4[i6] = array6.getString(i6);
                    }
                    builder.addWaypointNames(strArr4);
                }
                if (readableMap.hasKey("waypointTargets")) {
                    ReadableArray array7 = readableMap.getArray("waypointTargets");
                    Point[] pointArr = new Point[array7.size()];
                    for (int i7 = 0; i7 < array7.size(); i7++) {
                        ReadableMap map2 = array7.getMap(i7);
                        if (map2.hasKey("latitude") && map2.hasKey("longitude")) {
                            pointArr[i7] = Point.fromLngLat(map2.getDouble("longitude"), map2.getDouble("longitude"));
                        }
                    }
                    builder.addWaypointTargets(pointArr);
                }
                if (readableMap.hasKey("bannerInstructions")) {
                    builder.bannerInstructions(Boolean.valueOf(readableMap.getBoolean("bannerInstructions")));
                }
                if (readableMap.hasKey("roundaboutExits")) {
                    builder.roundaboutExits(Boolean.valueOf(readableMap.getBoolean("roundaboutExits")));
                }
                if (readableMap.hasKey("instructions")) {
                    builder.instructions(Boolean.valueOf(readableMap.getBoolean("instructions")));
                }
                if (readableMap.hasKey("geometries")) {
                    builder.geometries(readableMap.getString("geometries"));
                }
                if (readableMap.hasKey("isSort")) {
                    builder.isSort(Boolean.valueOf(readableMap.getBoolean("isSort")));
                }
                if (readableMap.hasKey("lessVerbose")) {
                    builder.lessVerbose(Boolean.valueOf(readableMap.getBoolean("lessVerbose")));
                }
                if (readableMap.hasKey(Scopes.PROFILE)) {
                    builder.profile(readableMap.getString(Scopes.PROFILE));
                }
                if (readableMap.hasKey("radiuses")) {
                    ReadableArray array8 = readableMap.getArray("radiuses");
                    double[] dArr = new double[array8.size()];
                    for (int i8 = 0; i8 < array8.size(); i8++) {
                        dArr[i8] = array8.getDouble(i8);
                    }
                    builder.radiuses(dArr);
                }
                if (readableMap.hasKey("resource")) {
                    builder.resource(readableMap.getString("resource"));
                }
                if (readableMap.hasKey("routeRefresh")) {
                    builder.routeRefresh(Boolean.valueOf(readableMap.getBoolean("routeRefresh")));
                }
                if (readableMap.hasKey("deviceId")) {
                    builder.deviceId(readableMap.getString("deviceId"));
                }
                if (readableMap.hasKey("sessionId")) {
                    builder.sessionId(readableMap.getString("sessionId"));
                }
                if (readableMap.hasKey("skipWaypoints")) {
                    builder.skipWaypoints(Boolean.valueOf(readableMap.getBoolean("skipWaypoints")));
                }
                if (readableMap.hasKey("routeType")) {
                    builder.routeType(Integer.valueOf(readableMap.getInt("routeType")));
                }
                if (readableMap.hasKey("dateTime")) {
                    ReadableMap map3 = readableMap.getMap("dateTime");
                    if (map3.hasKey("type")) {
                        if (map3.getInt("type") == 1) {
                            builder.dateTime(new MapplsDirectionDateTimeCurrent());
                        } else {
                            builder.dateTime(new MapplsDirectionDateTimeSpecified(Integer.valueOf(map3.getInt("specifiedType")), Long.valueOf(map3.getInt("timeStamp"))));
                        }
                    }
                }
                MapplsDirectionManager.newInstance(builder.build()).call(new OnResponseCallback<DirectionsResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.9
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(DirectionsResponse directionsResponse) {
                        promise.resolve(directionsResponse.toJson());
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i9, String str) {
                        promise.reject(String.valueOf(i9), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "Please provide destination parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide origin parameter");
    }

    @ReactMethod
    public void distance(ReadableMap readableMap, final Promise promise) {
        MapplsDistanceMatrix.Builder builder = MapplsDistanceMatrix.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("coordinates")) {
            ReadableArray array = readableMap.getArray("coordinates");
            if (array.size() >= 2) {
                for (int i = 0; i < array.size(); i++) {
                    String string = array.getString(i);
                    if (string.contains(",")) {
                        String[] strArrSplit = string.split(",");
                        builder.coordinate(Point.fromLngLat(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1])));
                    } else {
                        builder.coordinate(string);
                    }
                }
            } else {
                promise.reject(REQUIRED_CODE, "Please provide atleast two coordinates");
            }
        } else {
            promise.reject(REQUIRED_CODE, "Please provide coordinates");
        }
        if (readableMap.hasKey(Scopes.PROFILE)) {
            builder.profile(readableMap.getString(Scopes.PROFILE));
        }
        if (readableMap.hasKey("resource")) {
            builder.resource(readableMap.getString("resource"));
        }
        if (readableMap.hasKey("routeType")) {
            builder.routeType(Integer.valueOf(readableMap.getInt("routeType")));
        }
        if (readableMap.hasKey("fallbackSpeed")) {
            builder.fallbackSpeed(Double.valueOf(readableMap.getDouble("fallbackSpeed")));
        }
        if (readableMap.hasKey("fallbackCoordinate")) {
            builder.fallbackCoordinate(readableMap.getString("fallbackCoordinate"));
        }
        if (readableMap.hasKey("dateTime")) {
            ReadableMap map = readableMap.getMap("dateTime");
            if (map.hasKey("type")) {
                if (map.getInt("type") == 1) {
                    builder.dateTime(new MapplsDirectionDateTimeCurrent());
                } else {
                    builder.dateTime(new MapplsDirectionDateTimeSpecified(Integer.valueOf(map.getInt("specifiedType")), Long.valueOf(map.getInt("timeStamp"))));
                }
            }
        }
        MapplsDistanceMatrixManager.newInstance(builder.build()).call(new OnResponseCallback<DistanceResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.10
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(DistanceResponse distanceResponse) {
                promise.resolve(distanceResponse.toJson());
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i2, String str) {
                promise.reject(String.valueOf(i2), str);
            }
        });
    }

    @ReactMethod
    public void hateosnearby(ReadableMap readableMap, final Promise promise) {
        MapplsHateosNearby.Builder builder = MapplsHateosNearby.builder();
        if (readableMap.hasKey("hyperlink") && !readableMap.isNull("hyperlink")) {
            builder.hyperlink(readableMap.getString("hyperlink"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide hyperlink");
        }
        MapplsHateosNearbyManager.newInstance(builder.build()).call(new OnResponseCallback<NearbyAtlasResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.11
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(NearbyAtlasResponse nearbyAtlasResponse) {
                promise.resolve(new Gson().toJson(nearbyAtlasResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void feedback(ReadableMap readableMap, final Promise promise) {
        MapplsFeedback.Builder builder = MapplsFeedback.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("typedKeyword")) {
            builder.typedKeyword(readableMap.getString("typedKeyword"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide typed keyword");
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.INDEX)) {
            builder.index(Integer.valueOf(readableMap.getInt(FirebaseAnalytics.Param.INDEX)));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide index");
        }
        if (readableMap.hasKey(RemoteConfigConstants.RequestFieldKey.APP_VERSION)) {
            builder.appVersion(readableMap.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide appVersion");
        }
        if (readableMap.hasKey("locationName")) {
            builder.locationName(readableMap.getString("locationName"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide locationName");
        }
        if (readableMap.hasKey("userName")) {
            builder.userName(readableMap.getString("userName"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide userName");
        }
        if (readableMap.hasKey("latitude")) {
            builder.latitude(Double.valueOf(readableMap.getDouble("latitude")));
        }
        if (readableMap.hasKey("longitude")) {
            builder.longitude(Double.valueOf(readableMap.getDouble("longitude")));
        }
        if (readableMap.hasKey("mapplsPin")) {
            builder.mapplsPin(readableMap.getString("mapplsPin"));
        }
        MapplsFeedbackManager.newInstance(builder.build()).call(new OnResponseCallback<Void>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.12
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(Void r2) {
                promise.resolve(FirebaseAnalytics.Param.SUCCESS);
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void clusterLinkedDevices(ReadableMap readableMap, final Promise promise) {
        MapplsClusterLinkedDevices.Builder builder = MapplsClusterLinkedDevices.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("clusterId") && !readableMap.isNull("clusterId")) {
            builder.clusterId(readableMap.getString("clusterId"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide clusterId");
        }
        if (readableMap.hasKey("sessionType") && !readableMap.isNull("sessionType")) {
            builder.sessionType(readableMap.getString("sessionType"));
        } else {
            builder.sessionType("global");
        }
        MapplsClusterLinkedDevicesManager.newInstance(builder.build()).call(new OnResponseCallback<List<Device>>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.13
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(List<Device> list) {
                promise.resolve(new Gson().toJson(list));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void deleteClusterLinkedDevice(ReadableMap readableMap, final Promise promise) {
        MapplsDeleteClusterLinkedDevice.Builder builder = MapplsDeleteClusterLinkedDevice.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("linkedDevice") && !readableMap.isNull("linkedDevice")) {
            builder.linkedDevice(readableMap.getString("linkedDevice"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide linkedDevice");
        }
        if (readableMap.hasKey("clusterId") && !readableMap.isNull("clusterId")) {
            builder.clusterId(readableMap.getString("clusterId"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide clusterId");
        }
        if (readableMap.hasKey("sessionType") && !readableMap.isNull("sessionType")) {
            builder.sessionType((String) Objects.requireNonNull(readableMap.getString("sessionType")));
        } else {
            builder.sessionType("global");
        }
        MapplsDeleteClusterLinkedDeviceManager.newInstance(builder.build()).call(new OnResponseCallback<Void>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.14
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(Void r2) {
                promise.resolve(FirebaseAnalytics.Param.SUCCESS);
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void endSession(ReadableMap readableMap, final Promise promise) {
        MapplsEndSession.Builder builder = MapplsEndSession.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("clusterId") && !readableMap.isNull("clusterId")) {
            builder.clusterId(readableMap.getString("clusterId"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide clusterId");
        }
        if (readableMap.hasKey("sessionType") && !readableMap.isNull("sessionType")) {
            builder.sessionType((String) Objects.requireNonNull(readableMap.getString("sessionType")));
        } else {
            builder.sessionType("global");
        }
        MapplsEndSessionManager.newInstance(builder.build()).call(new OnResponseCallback<Void>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.15
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(Void r2) {
                promise.resolve(FirebaseAnalytics.Param.SUCCESS);
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void geoAnalyticsList(ReadableMap readableMap, final Promise promise) {
        MapplsGeoAnalyticsList.Builder builder = MapplsGeoAnalyticsList.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("api") && !readableMap.isNull("api")) {
            builder.api((String) Objects.requireNonNull(readableMap.getString("api")));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide api parameter");
        }
        if (readableMap.hasKey("geoBoundType") && !readableMap.isNull("geoBoundType")) {
            builder.geoBoundType((String) Objects.requireNonNull(readableMap.getString("geoBoundType")));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide geoBoundType parameter");
        }
        if (readableMap.hasKey("geoBound") && !readableMap.isNull("geoBound")) {
            ReadableArray array = readableMap.getArray("geoBound");
            String[] strArr = new String[array.size()];
            for (int i = 0; i < array.size(); i++) {
                strArr[i] = array.getString(i);
            }
            builder.geoBound(strArr);
        } else {
            promise.reject(REQUIRED_CODE, "Please provide geoBound parameter");
        }
        if (readableMap.hasKey("attributes") && !readableMap.isNull("attributes")) {
            builder.attributes(readableMap.getString("attributes"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide attributes parameter");
        }
        MapplsGeoAnalyticsListManager.newInstance(builder.build()).call(new OnResponseCallback<GeoAnalyticsListResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.16
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(GeoAnalyticsListResponse geoAnalyticsListResponse) {
                promise.resolve(new Gson().toJson(geoAnalyticsListResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i2, String str) {
                promise.reject(String.valueOf(i2), str);
            }
        });
    }

    @ReactMethod
    public void roadTrafficDetail(ReadableMap readableMap, final Promise promise) {
        MapplsRoadTrafficDetail.Builder builder = MapplsRoadTrafficDetail.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && !readableMap.isNull(FirebaseAnalytics.Param.LOCATION)) {
            ReadableMap map = readableMap.getMap(FirebaseAnalytics.Param.LOCATION);
            if (map.hasKey("latitude") && !map.isNull("latitude") && map.hasKey("longitude") && !map.isNull("longitude")) {
                builder.latitude(Double.valueOf(map.getDouble("latitude")));
                builder.longitude(Double.valueOf(map.getDouble("longitude")));
            } else {
                promise.reject(REQUIRED_CODE, "Please provide latitude or longitude parameter");
            }
        } else {
            promise.reject(REQUIRED_CODE, "Please provide location parameter");
        }
        if (readableMap.hasKey("radius") && !readableMap.isNull("radius")) {
            builder.radius(Long.valueOf(Double.valueOf(readableMap.getDouble("radius")).longValue()));
        }
        MapplsRoadTrafficDetailManager.newInstance(builder.build()).call(new OnResponseCallback<TrafficRoadDetailResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.17
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(TrafficRoadDetailResponse trafficRoadDetailResponse) {
                promise.resolve(new Gson().toJson(trafficRoadDetailResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void generateOtp(String str, final Promise promise) {
        if (str == null) {
            promise.reject(REQUIRED_CODE, "Please provide userHandle parameter");
        } else {
            MapplsGenerateOtpManager.newInstance(MapplsGenerateOTP.builder().userHandle(str).build()).call(new OnResponseCallback<String>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.18
                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onSuccess(String str2) {
                    promise.resolve(str2);
                }

                @Override // com.mappls.sdk.services.api.OnResponseCallback
                public void onError(int i, String str2) {
                    promise.reject(String.valueOf(i), str2);
                }
            });
        }
    }

    @ReactMethod
    public void whiteList(ReadableMap readableMap, final Promise promise) {
        if (!readableMap.hasKey(ImagesContract.URL) || readableMap.isNull(ImagesContract.URL)) {
            promise.reject(REQUIRED_CODE, "Please provide url parameter");
            return;
        }
        if (!readableMap.hasKey("userHandle") || readableMap.isNull("userHandle")) {
            promise.reject(REQUIRED_CODE, "Please provide userHandle parameter");
            return;
        }
        if (!readableMap.hasKey("otp") || readableMap.isNull("otp")) {
            promise.reject(REQUIRED_CODE, "Please provide otp parameter");
            return;
        }
        String string = readableMap.getString(ImagesContract.URL);
        String string2 = readableMap.getString("userHandle");
        MapplsWhitelistManager.newInstance(MapplsWhitelist.builder().refLocation(string).userHandle(string2).otp(readableMap.getString("otp")).build()).call(new OnResponseCallback<Void>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.19
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(Void r2) {
                promise.resolve(null);
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void nearbyReports(ReadableMap readableMap, final Promise promise) {
        if (!readableMap.hasKey("topLeft") || readableMap.isNull("topLeft")) {
            promise.reject(REQUIRED_CODE, "Please provide topLeft parameter");
            return;
        }
        if (!readableMap.hasKey("bottomRight") || readableMap.isNull("bottomRight")) {
            promise.reject(REQUIRED_CODE, "Please provide bottomRight parameter");
            return;
        }
        ReadableArray array = readableMap.getArray("topLeft");
        ReadableArray array2 = readableMap.getArray("bottomRight");
        double d = array.getDouble(0);
        Double dValueOf = Double.valueOf(d);
        double d2 = array.getDouble(1);
        Double dValueOf2 = Double.valueOf(d2);
        double d3 = array2.getDouble(0);
        Double dValueOf3 = Double.valueOf(d3);
        double d4 = array2.getDouble(1);
        Double dValueOf4 = Double.valueOf(d4);
        MapplsNearbyReport.Builder builder = MapplsNearbyReport.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        dValueOf.getClass();
        dValueOf2.getClass();
        builder.topLeft(Point.fromLngLat(d, d2));
        dValueOf3.getClass();
        dValueOf4.getClass();
        builder.bottomRight(Point.fromLngLat(d3, d4));
        MapplsNearbyReportManager.newInstance(builder.build()).call(new OnResponseCallback<NearbyReportResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.20
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(NearbyReportResponse nearbyReportResponse) {
                promise.resolve(new Gson().toJson(nearbyReportResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void weather(ReadableMap readableMap, final Promise promise) {
        MapplsWeather.Builder builder = MapplsWeather.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && !readableMap.isNull(FirebaseAnalytics.Param.LOCATION)) {
            ReadableMap map = readableMap.getMap(FirebaseAnalytics.Param.LOCATION);
            if (map.hasKey("latitude") && !map.isNull("latitude") && map.hasKey("longitude") && !map.isNull("longitude")) {
                builder.location(Double.valueOf(map.getDouble("latitude")), Double.valueOf(map.getDouble("longitude")));
            } else {
                promise.reject(REQUIRED_CODE, "Please provide latitude or longitude parameter");
            }
        } else {
            promise.reject(REQUIRED_CODE, "Please provide location parameter");
        }
        if (readableMap.hasKey("theme") && !readableMap.isNull("theme")) {
            builder.theme(readableMap.getString("theme"));
        }
        if (readableMap.hasKey("size") && !readableMap.isNull("size")) {
            builder.size(readableMap.getString("size"));
        }
        if (readableMap.hasKey("tempUnit") && !readableMap.isNull("tempUnit")) {
            builder.tempUnit(readableMap.getString("tempUnit"));
        }
        if (readableMap.hasKey("unitType") && !readableMap.isNull("unitType")) {
            builder.unitType(readableMap.getString("unitType"));
        }
        if (readableMap.hasKey("unit") && !readableMap.isNull("unit")) {
            builder.unit(Integer.valueOf(readableMap.getInt("unit")));
        }
        MapplsWeatherManager.newInstance(builder.build()).call(new OnResponseCallback<WeatherResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.21
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(WeatherResponse weatherResponse) {
                promise.resolve(new Gson().toJson(weatherResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void tripCostEstimation(ReadableMap readableMap, final Promise promise) {
        MapplsCostEstimation.Builder builder = MapplsCostEstimation.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID) && !readableMap.isNull(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)) {
            builder.routeId(readableMap.getString(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID));
        }
        if (readableMap.hasKey("routeIndex") && !readableMap.isNull("routeIndex")) {
            builder.routeIndex(Integer.valueOf(readableMap.getInt("routeIndex")));
        }
        if (readableMap.hasKey("vehicleType") && !readableMap.isNull("vehicleType")) {
            builder.vehicleType(readableMap.getString("vehicleType"));
        }
        if (readableMap.hasKey("isTollEnabled") && !readableMap.isNull("isTollEnabled")) {
            builder.isTollEnabled(Boolean.valueOf(readableMap.getBoolean("isTollEnabled")));
        }
        if (readableMap.hasKey("vehicleFuelType") && !readableMap.isNull("vehicleFuelType")) {
            builder.vehicleFuelType(readableMap.getString("vehicleFuelType"));
        }
        if (readableMap.hasKey("fuelEfficiency") && !readableMap.isNull("fuelEfficiency")) {
            builder.fuelEfficiency(Integer.valueOf(readableMap.getInt("fuelEfficiency")));
        }
        if (readableMap.hasKey("fuelEfficiencyUnit") && !readableMap.isNull("fuelEfficiencyUnit")) {
            builder.fuelEfficiencyUnit(readableMap.getString("fuelEfficiencyUnit"));
        }
        if (readableMap.hasKey("fuelPrice") && !readableMap.isNull("fuelPrice")) {
            builder.fuelPrice(Double.valueOf(readableMap.getDouble("fuelPrice")));
        }
        if (readableMap.hasKey(DirectionsCriteria.ANNOTATION_DISTANCE) && !readableMap.isNull(DirectionsCriteria.ANNOTATION_DISTANCE)) {
            builder.distance(Double.valueOf(readableMap.getDouble(DirectionsCriteria.ANNOTATION_DISTANCE)));
        }
        if (readableMap.hasKey("latitude") && !readableMap.isNull("latitude")) {
            builder.latitude(Double.valueOf(readableMap.getDouble("latitude")));
        }
        if (readableMap.hasKey("longitude") && !readableMap.isNull("longitude")) {
            builder.longitude(Double.valueOf(readableMap.getDouble("longitude")));
        }
        MapplsCostEstimationManager.newInstance(builder.build()).call(new OnResponseCallback<CostEstimationResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.22
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(CostEstimationResponse costEstimationResponse) {
                promise.resolve(new Gson().toJson(costEstimationResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void eventCategoryMaster(ReadableMap readableMap, final Promise promise) {
        MapplsCategoryMaster.Builder builder = MapplsCategoryMaster.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        MapplsCategoryMasterManager.newInstance(builder.build()).call(new OnResponseCallback<ReportMasterResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.23
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(ReportMasterResponse reportMasterResponse) {
                promise.resolve(new Gson().toJson(reportMasterResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void routeReportSummary(ReadableMap readableMap, final Promise promise) {
        MapplsRouteSummary.Builder builder = MapplsRouteSummary.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID) && !readableMap.isNull(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)) {
            builder.routeId(readableMap.getString(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide routeId parameter");
        }
        if (readableMap.hasKey("routeIndex")) {
            builder.routeIdx(Integer.valueOf(readableMap.getInt("routeIndex")));
        }
        if (readableMap.hasKey("currentNode")) {
            builder.currentNode(readableMap.getString("currentNode"));
        }
        if (readableMap.hasKey("isGroup")) {
            builder.isGroup(Integer.valueOf(readableMap.getInt("isGroup")));
        }
        if (readableMap.hasKey("categories")) {
            ReadableArray array = readableMap.getArray("categories");
            String[] strArr = new String[array.size()];
            for (int i = 0; i < array.size(); i++) {
                strArr[i] = array.getString(i);
            }
            builder.categories(strArr);
        }
        MapplsRouteSummaryManager.newInstance(builder.build()).call(new OnResponseCallback<RouteReportSummaryResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.24
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(RouteReportSummaryResponse routeReportSummaryResponse) {
                promise.resolve(new Gson().toJson(routeReportSummaryResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i2, String str) {
                promise.reject(String.valueOf(i2), str);
            }
        });
    }

    @ReactMethod
    public void fuelCost(ReadableMap readableMap, final Promise promise) {
        MapplsFuelCost.Builder builder = MapplsFuelCost.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION) && !readableMap.isNull(FirebaseAnalytics.Param.LOCATION)) {
            ReadableMap map = readableMap.getMap(FirebaseAnalytics.Param.LOCATION);
            if (map.hasKey("latitude") && !map.isNull("latitude") && map.hasKey("longitude") && !map.isNull("longitude")) {
                builder.location(Double.valueOf(map.getDouble("latitude")), Double.valueOf(map.getDouble("longitude")));
            } else {
                promise.reject(REQUIRED_CODE, "Please provide latitude or longitude parameter");
            }
        } else {
            promise.reject(REQUIRED_CODE, "Please provide location parameter");
        }
        MapplsFuelCostManager.newInstance(builder.build()).call(new OnResponseCallback<FuelCostResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.25
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(FuelCostResponse fuelCostResponse) {
                promise.resolve(new Gson().toJson(fuelCostResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void transitPlanner(ReadableMap readableMap, final Promise promise) {
        MapplsTransitPlanner.Builder builder = MapplsTransitPlanner.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("origin") && !readableMap.isNull("origin")) {
            builder.origin(readableMap.getString("origin"));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide origin parameter");
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.DESTINATION) && !readableMap.isNull(FirebaseAnalytics.Param.DESTINATION)) {
            builder.destination(readableMap.getString(FirebaseAnalytics.Param.DESTINATION));
        } else {
            promise.reject(REQUIRED_CODE, "Please provide destination parameter");
        }
        if (readableMap.hasKey(ModeProp.name) && !readableMap.isNull(ModeProp.name)) {
            builder.mode(readableMap.getString(ModeProp.name));
        }
        if (readableMap.hasKey("date")) {
            builder.date(readableMap.getString("date"));
        }
        if (readableMap.hasKey("time")) {
            builder.time(readableMap.getString("time"));
        }
        if (readableMap.hasKey("arriveBy")) {
            builder.arriveBy(Boolean.valueOf(readableMap.getBoolean("arriveBy")));
        }
        if (readableMap.hasKey("optimalRoute")) {
            builder.optimalRoute(Boolean.valueOf(readableMap.getBoolean("optimalRoute")));
        }
        if (readableMap.hasKey("searchWindow")) {
            builder.searchWindow(Integer.valueOf(readableMap.getInt("searchWindow")));
        }
        if (readableMap.hasKey("maxTransfers")) {
            builder.maxTransfers(Integer.valueOf(readableMap.getInt("maxTransfers")));
        }
        if (readableMap.hasKey("showIntermediateStops")) {
            builder.showIntermediateStops(Boolean.valueOf(readableMap.getBoolean("showIntermediateStops")));
        }
        if (readableMap.hasKey("walkSpeed")) {
            builder.walkSpeed(Double.valueOf(readableMap.getDouble("walkSpeed")));
        }
        MapplsTransitPlannerManager.newInstance(builder.build()).call(new OnResponseCallback<TransitPlannerResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.26
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(TransitPlannerResponse transitPlannerResponse) {
                promise.resolve(new Gson().toJson(transitPlannerResponse));
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }
        });
    }

    @ReactMethod
    public void tripOptimisation(ReadableMap readableMap, final Promise promise) {
        MapplsTripOptimisation.Builder builder = MapplsTripOptimisation.builder();
        if (readableMap.hasKey("baseUrl") && readableMap.getString("baseUrl") != null) {
            builder.baseUrl(readableMap.getString("baseUrl"));
        }
        if (readableMap.hasKey("origin")) {
            String string = readableMap.getString("origin");
            if (string.contains(",")) {
                String[] strArrSplit = string.split(",");
                builder.origin(Point.fromLngLat(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1])));
            } else {
                builder.origin(string);
            }
            if (readableMap.hasKey(FirebaseAnalytics.Param.DESTINATION)) {
                String string2 = readableMap.getString(FirebaseAnalytics.Param.DESTINATION);
                if (string2.contains(",")) {
                    String[] strArrSplit2 = string2.split(",");
                    builder.destination(Point.fromLngLat(Double.parseDouble(strArrSplit2[0]), Double.parseDouble(strArrSplit2[1])));
                } else {
                    builder.destination(string2);
                }
                if (readableMap.hasKey("waypoints") && !readableMap.isNull("waypoints")) {
                    ReadableArray array = readableMap.getArray("waypoints");
                    for (int i = 0; i < array.size(); i++) {
                        String string3 = array.getString(i);
                        if (string3.contains(",")) {
                            String[] strArrSplit3 = string3.split(",");
                            builder.addWayPoint(Point.fromLngLat(Double.parseDouble(strArrSplit3[0]), Double.parseDouble(strArrSplit3[1])));
                        } else {
                            builder.addWayPoint(string3);
                        }
                    }
                }
                if (readableMap.hasKey("overview") && !readableMap.isNull("overview")) {
                    builder.overview(readableMap.getString("overview"));
                }
                if (readableMap.hasKey("geometries") && !readableMap.isNull("geometries")) {
                    builder.geometries(readableMap.getString("geometries"));
                }
                if (readableMap.hasKey("steps")) {
                    builder.steps(Boolean.valueOf(readableMap.getBoolean("steps")));
                }
                if (readableMap.hasKey("sourceType")) {
                    builder.sourceType(readableMap.getString("sourceType"));
                }
                if (readableMap.hasKey("destinationType")) {
                    builder.destinationType(readableMap.getString("destinationType"));
                }
                if (readableMap.hasKey("roundTrip")) {
                    builder.roundTrip(Boolean.valueOf(readableMap.getBoolean("roundTrip")));
                }
                if (readableMap.hasKey("lessVerbose")) {
                    builder.lessVerbose(Boolean.valueOf(readableMap.getBoolean("lessVerbose")));
                }
                if (readableMap.hasKey("continueStraight")) {
                    builder.continueStraight(Boolean.valueOf(readableMap.getBoolean("continueStraight")));
                }
                MapplsTripOptimisationManager.newInstance(builder.build()).call(new OnResponseCallback<TripOptimisationResponse>() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLRestApiModule.27
                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onSuccess(TripOptimisationResponse tripOptimisationResponse) {
                        promise.resolve(new Gson().toJson(tripOptimisationResponse));
                    }

                    @Override // com.mappls.sdk.services.api.OnResponseCallback
                    public void onError(int i2, String str) {
                        promise.reject(String.valueOf(i2), str);
                    }
                });
                return;
            }
            promise.reject(REQUIRED_CODE, "Please provide destination parameter");
            return;
        }
        promise.reject(REQUIRED_CODE, "Please provide origin parameter");
    }
}
