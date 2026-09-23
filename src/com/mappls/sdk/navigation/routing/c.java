package com.mappls.sdk.navigation.routing;

import android.app.Application;
import android.provider.Settings;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.util.MapplsNavigationMode;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    public enum a {
        /* JADX INFO: Fake field, exist only in values array */
        MAPMYINDIA("MAPMYINDIA"),
        OSRM("OSRM"),
        OSRM_MIREO("OSRM MIREO");

        private final String a;

        a(String str) {
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    public static NavigationRoute a(b bVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bVar.a != null && bVar.b != null) {
            StringBuilder sbA = com.mappls.sdk.navigation.h.a("Start finding route from ");
            sbA.append(bVar.a);
            sbA.append(" to ");
            sbA.append(bVar.b);
            sbA.append(" using ");
            sbA.append(bVar.f.a());
            NavigationLogger.i(sbA.toString(), new Object[0]);
            try {
                a aVar = bVar.f;
                NavigationRoute navigationRouteB = (aVar == a.OSRM || aVar == a.OSRM_MIREO) ? b(bVar) : new NavigationRoute("Selected route SERVICE is not available", 8);
                NavigationLogger.i("Finding route contained " + navigationRouteB.getImmutableAllLocations().size() + " points for " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms", new Object[0]);
                return navigationRouteB;
            } catch (Exception e) {
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().handledExceptions("calculateRouteImpl", "navigation-sdk", "0.14.2", e);
                }
                NavigationLogger.e(e, "Failed to find route ", new Object[0]);
            }
        }
        return new NavigationRoute(null);
    }

    private static ApiResponse a(Application application, Point point, String str, double d, List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(point.longitude() + "," + point.longitude());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(((LatLng) list.get(i)).getLongitude() + "," + ((LatLng) list.get(i)).getLatitude());
        }
        arrayList.add(str);
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, arrayList.size(), 2);
        double[] dArr2 = new double[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (d > 0.0d) {
                if (i2 == 0) {
                    dArr[i2] = new double[]{(int) d, 90.0d};
                } else {
                    dArr[i2] = new double[]{0.0d, 180.0d};
                }
            }
            dArr2[i2] = 350.0d;
        }
        RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
        String strBaseUrl = routeOptionsFromJson.baseUrl();
        if (NavigationContext.getNavigationContext().k().s.get() == MapplsNavigationMode.AUTOMATIC) {
            if (NavigationContext.getNavigationContext().k().a(true)) {
                strBaseUrl = Constants.ADVANCE_MAP_BASE_URL;
            } else if (NavigationContext.getNavigationContext().k().t.get() != null) {
                strBaseUrl = NavigationContext.getNavigationContext().k().t.get();
            }
        }
        MapplsDirections.Builder builderRadiuses = MapplsDirections.builder().baseUrl(strBaseUrl).origin(point).destination(str).profile(routeOptionsFromJson.profile()).resource(routeOptionsFromJson.resource()).steps(routeOptionsFromJson.steps()).annotations(routeOptionsFromJson.annotations()).alternatives(routeOptionsFromJson.alternatives()).deviceId(Settings.Secure.getString(application.getContentResolver(), "android_id")).overview("full").lessVerbose(routeOptionsFromJson.lessVerbose()).routeType(routeOptionsFromJson.routeType()).bannerInstructions(routeOptionsFromJson.bannerInstructions()).geometries(routeOptionsFromJson.geometries()).continueStraight(routeOptionsFromJson.continueStraight()).skipWaypoints(routeOptionsFromJson.skipWaypoints()).isSort(routeOptionsFromJson.isSort()).radiuses(dArr2);
        if (MapplsNavigationHelper.getInstance().getSessionId() != null) {
            builderRadiuses.sessionId(MapplsNavigationHelper.getInstance().getSessionId());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LatLng latLng = (LatLng) it2.next();
            builderRadiuses.addWaypoint(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
        }
        if (routeOptionsFromJson.resource().equalsIgnoreCase(DirectionsCriteria.RESOURCE_ROUTE_ETA)) {
            builderRadiuses.routeRefresh(Boolean.TRUE);
        }
        if (routeOptionsFromJson.roundaboutExits() != null) {
            builderRadiuses.roundaboutExits(routeOptionsFromJson.roundaboutExits());
        }
        if (routeOptionsFromJson.exclude() != null) {
            builderRadiuses.excludes(routeOptionsFromJson.exclude());
        }
        if (d > 0.0d) {
            for (int i3 = 0; i3 < dArr.length; i3++) {
                if (i3 == 0) {
                    builderRadiuses.addBearing(Double.valueOf(dArr[i3][0]), Double.valueOf(dArr[i3][1]));
                } else {
                    builderRadiuses.addBearing(null, null);
                }
            }
        }
        try {
            ApiResponse<DirectionsResponse> apiResponseExecuteCall = MapplsDirectionManager.newInstance(builderRadiuses.build()).executeCall();
            if (apiResponseExecuteCall != null && apiResponseExecuteCall.getResponseCode() == 200) {
                MapplsNavigationHelper.getInstance().setRouteIndex(0);
            }
            return apiResponseExecuteCall;
        } catch (Exception e) {
            NavigationLogger.e(e);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().handledExceptions("getRouteCalculationResultOSRM", "navigation-sdk", "0.14.2", e);
            }
            boolean z = e instanceof UnknownHostException;
            String message = e.getMessage();
            return z ? ApiResponse.error(1, message) : ApiResponse.error(2, message);
        }
    }

    /* JADX WARN: Code duplicated, block: B:96:0x02eb  */
    private static NavigationRoute b(b bVar) {
        String str;
        String str2;
        RouteOptions routeOptions;
        String str3;
        String str4 = "0.14.2";
        ArrayList arrayList = new ArrayList();
        try {
            ApiResponse apiResponseA = a(bVar.d, Point.fromLngLat(bVar.a.getLongitude(), bVar.a.getLatitude()), bVar.b, bVar.a.getBearing(), bVar.c);
            if (apiResponseA == null) {
                c(bVar);
                return new NavigationRoute(bVar.d.getString(R.string.mappls_error_calculating_route), 6);
            }
            if (apiResponseA.getResponseCode() != 200) {
                c(bVar);
                return new NavigationRoute(apiResponseA.getErrorMessage(), apiResponseA.getResponseCode());
            }
            DirectionsResponse directionsResponse = (DirectionsResponse) apiResponseA.getResponse();
            if (directionsResponse == null) {
                c(bVar);
                return new NavigationRoute("No Route Found", 5);
            }
            DirectionsRoute directionsRoute = directionsResponse.routes().get(MapplsNavigationHelper.getInstance().getRouteIndex());
            List<Point> listCoordinates = LineString.fromPolyline(directionsRoute.geometry(), 6).coordinates();
            if (MapplsNavigationHelper.getInstance().isCallAlternativeDuringNavigation()) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    List<DirectionsRoute> listRoutes = directionsResponse.routes();
                    Double dDuration = listRoutes.get(0).duration();
                    if (listRoutes.size() > 1) {
                        int i = 1;
                        while (i < listRoutes.size()) {
                            str = str4;
                            try {
                                arrayList2.add(new AlternateRoute(Integer.valueOf((int) (listRoutes.get(i).duration().doubleValue() - dDuration.doubleValue())), listRoutes.get(i)));
                                i++;
                                str4 = str;
                            } catch (Exception e) {
                                e = e;
                                str4 = str;
                                NavigationLogger.d(e);
                                if (MapplsLMSManager.isInitialised()) {
                                    MapplsLMSManager.getInstance().handledExceptions("getRouteCalculationResultOSRM", "navigation-sdk", str4, e);
                                }
                                return new NavigationRoute(e.getMessage(), 7);
                            }
                        }
                    }
                    str = str4;
                    MapplsNavigationHelper.getInstance().setAlternateRoutes(arrayList2);
                } catch (Exception e2) {
                    e = e2;
                    NavigationLogger.d(e);
                    if (MapplsLMSManager.isInitialised()) {
                        MapplsLMSManager.getInstance().handledExceptions("getRouteCalculationResultOSRM", "navigation-sdk", str4, e);
                    }
                    return new NavigationRoute(e.getMessage(), 7);
                }
            } else {
                str = "0.14.2";
            }
            for (int i2 = 0; i2 < listCoordinates.size(); i2++) {
                NavLocation navLocation = new NavLocation("router");
                navLocation.setLatitude(listCoordinates.get(i2).latitude());
                navLocation.setLongitude(listCoordinates.get(i2).longitude());
                arrayList.add(navLocation);
            }
            if (directionsRoute.routeOptions() != null) {
                NavigationContext.getNavigationContext().k().a.set(directionsRoute.routeOptions().toJson());
            }
            try {
                ArrayList arrayList3 = new ArrayList();
                List<DirectionsWaypoint> listSubList = directionsResponse.waypoints().subList(1, directionsResponse.waypoints().size() - 1);
                if (listSubList != null) {
                    for (DirectionsWaypoint directionsWaypoint : listSubList) {
                        arrayList3.add(new LatLng(directionsWaypoint.location().latitude(), directionsWaypoint.location().longitude()));
                    }
                }
                bVar.c = arrayList3;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", bVar.a.getLatitude() + "," + bVar.a.getLongitude());
                    String str5 = bVar.b;
                    if (str5 != null) {
                        if (str5.contains(",")) {
                            String[] strArrSplit = bVar.b.split(",");
                            if (strArrSplit.length > 1) {
                                str3 = strArrSplit[1] + "," + strArrSplit[0];
                            }
                            MapplsNavigationHelper.getInstance().setUuid(directionsResponse.uuid());
                            MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse);
                            NavigationLogger.d(bVar.toString(), new Object[0]);
                            return new NavigationRoute(directionsRoute, (List<NavLocation>) arrayList, (List<NavigationStep>) null, bVar, (List<LocationPoint>) null, true);
                        }
                        str3 = bVar.b;
                        jSONObject.put(FirebaseAnalytics.Param.DESTINATION, str3);
                    }
                    List<LatLng> list = bVar.c;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList4 = new ArrayList();
                        for (LatLng latLng : bVar.c) {
                            arrayList4.add(latLng.getLatitude() + "," + latLng.getLongitude());
                        }
                        jSONObject.put("via_point", MapplsUtils.join("|", arrayList4.toArray()));
                    }
                    if (directionsResponse.sessionId() != null) {
                        jSONObject.put("session_id", directionsResponse.sessionId());
                    }
                    if (directionsResponse.uuid() != null) {
                        jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, directionsResponse.uuid());
                    }
                    jSONObject.put("selected_index", 0);
                    if (directionsResponse.routes().size() > 0 && (routeOptions = directionsResponse.routes().get(0).routeOptions()) != null) {
                        jSONObject.put("resource", routeOptions.resource());
                        jSONObject.put(Scopes.PROFILE, routeOptions.profile());
                        jSONObject.put("alternatives", routeOptions.alternatives());
                    }
                    if (MapplsLMSManager.isInitialised()) {
                        str2 = str;
                        try {
                            MapplsLMSManager.getInstance().add("navigation-reroute-succeed", "navigation-sdk", str2, jSONObject);
                        } catch (JSONException unused) {
                        } catch (Exception e3) {
                            e = e3;
                            if (MapplsLMSManager.isInitialised()) {
                                MapplsLMSManager.getInstance().handledExceptions("getRouteCalculationResultOSRM-2", "navigation-sdk", str2, e);
                            }
                            NavigationLogger.d(e);
                        }
                    }
                } catch (JSONException unused2) {
                }
            } catch (Exception e4) {
                e = e4;
                str2 = str;
            }
            MapplsNavigationHelper.getInstance().setUuid(directionsResponse.uuid());
            MapplsNavigationHelper.getInstance().setDirectionsResponse(directionsResponse);
            NavigationLogger.d(bVar.toString(), new Object[0]);
            return new NavigationRoute(directionsRoute, (List<NavLocation>) arrayList, (List<NavigationStep>) null, bVar, (List<LocationPoint>) null, true);
        } catch (Exception e5) {
            e = e5;
        }
    }

    private static void c(b bVar) {
        RouteOptions routeOptions;
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("source", bVar.a.getLatitude() + "," + bVar.a.getLongitude());
            String str2 = bVar.b;
            if (str2 != null) {
                if (str2.contains(",")) {
                    String[] strArrSplit = bVar.b.split(",");
                    if (strArrSplit.length > 1) {
                        str = strArrSplit[1] + "," + strArrSplit[0];
                    }
                } else {
                    str = bVar.b;
                }
                jSONObject.put(FirebaseAnalytics.Param.DESTINATION, str);
            }
            List<LatLng> list = bVar.c;
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (LatLng latLng : bVar.c) {
                    arrayList.add(latLng.getLatitude() + "," + latLng.getLongitude());
                }
                jSONObject.put("via_point", MapplsUtils.join("|", arrayList.toArray()));
            }
            if (MapplsNavigationHelper.getInstance().getSessionId() != null) {
                jSONObject.put("session_id", MapplsNavigationHelper.getInstance().getSessionId());
            }
            if (MapplsNavigationHelper.getInstance().getUuid() != null) {
                jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, MapplsNavigationHelper.getInstance().getUuid());
            }
            jSONObject.put("selected_index", MapplsNavigationHelper.getInstance().getRouteIndex());
            DirectionsResponse directionsResponse = MapplsNavigationHelper.getInstance().getDirectionsResponse();
            if (directionsResponse.routes().size() > 0 && (routeOptions = directionsResponse.routes().get(0).routeOptions()) != null) {
                jSONObject.put("resource", routeOptions.resource());
                jSONObject.put(Scopes.PROFILE, routeOptions.profile());
                jSONObject.put("alternatives", routeOptions.alternatives());
            }
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("navigation-reroute-failed", "navigation-sdk", "0.14.2", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }
}
