package com.bajajconnect.wifi.navv2;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.R;
import com.bajajconnect.gMaps.util.GmapUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationDirectionsHelper {
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final ExecutorService EXEC = Executors.newCachedThreadPool();
    private static final String TAG = "NavV2Dir";

    public interface SummaryCallback {
        void onResult(NavV2Models.RouteSummary routeSummary);
    }

    private NavigationDirectionsHelper() {
    }

    public static void enrichAndSortByRouteDistance(Context context, final double d, final double d2, List<NavV2Models.ClusterPoiItem> list, int i, final GooglePlacesClusterService.PlacesCallback placesCallback) {
        int i2;
        if (placesCallback == null) {
            return;
        }
        ArrayList arrayList = list != null ? new ArrayList(list) : new ArrayList();
        final int iMax = Math.max(1, i);
        if (arrayList.isEmpty()) {
            placesCallback.onResult(new ArrayList());
            return;
        }
        final NavV2Models.ClusterPoiItem[] clusterPoiItemArr = new NavV2Models.ClusterPoiItem[arrayList.size()];
        final AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        int i3 = 0;
        while (i3 < arrayList.size()) {
            final NavV2Models.ClusterPoiItem clusterPoiItem = (NavV2Models.ClusterPoiItem) arrayList.get(i3);
            if (clusterPoiItem == null || !clusterPoiItem.hasCoordinates()) {
                i2 = i3;
                clusterPoiItemArr[i2] = clusterPoiItem;
                if (atomicInteger.decrementAndGet() == 0) {
                    placesCallback.onResult(takeTopByRoadDistance(clusterPoiItemArr, d, d2, iMax));
                }
            } else {
                final int i4 = i3;
                i2 = i3;
                fetchRouteSummary(context, d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, null, new SummaryCallback() { // from class: com.bajajconnect.wifi.navv2.NavigationDirectionsHelper$$ExternalSyntheticLambda4
                    @Override // com.bajajconnect.wifi.navv2.NavigationDirectionsHelper.SummaryCallback
                    public final void onResult(NavV2Models.RouteSummary routeSummary) {
                        NavigationDirectionsHelper.lambda$enrichAndSortByRouteDistance$0(clusterPoiItemArr, i4, clusterPoiItem, d, d2, atomicInteger, placesCallback, iMax, routeSummary);
                    }
                });
            }
            i3 = i2 + 1;
        }
    }

    static /* synthetic */ void lambda$enrichAndSortByRouteDistance$0(NavV2Models.ClusterPoiItem[] clusterPoiItemArr, int i, NavV2Models.ClusterPoiItem clusterPoiItem, double d, double d2, AtomicInteger atomicInteger, GooglePlacesClusterService.PlacesCallback placesCallback, int i2, NavV2Models.RouteSummary routeSummary) {
        if (routeSummary != null && routeSummary.distanceMeters >= 0) {
            clusterPoiItemArr[i] = clusterPoiItem.withRouteDistance(routeSummary.distanceMeters, routeSummary.distanceText);
        } else {
            float[] fArr = new float[1];
            Location.distanceBetween(d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, fArr);
            int iRound = Math.round(fArr[0]);
            clusterPoiItemArr[i] = clusterPoiItem.withRouteDistance(iRound, formatDistance(iRound, NavV2Models.Units.KILOMETRES));
        }
        if (atomicInteger.decrementAndGet() == 0) {
            placesCallback.onResult(takeTopByRoadDistance(clusterPoiItemArr, d, d2, i2));
        }
    }

    private static List<NavV2Models.ClusterPoiItem> takeTopByRoadDistance(NavV2Models.ClusterPoiItem[] clusterPoiItemArr, final double d, final double d2, int i) {
        ArrayList arrayList = new ArrayList();
        for (NavV2Models.ClusterPoiItem clusterPoiItem : clusterPoiItemArr) {
            if (clusterPoiItem != null) {
                arrayList.add(clusterPoiItem);
            }
        }
        arrayList.sort(new Comparator() { // from class: com.bajajconnect.wifi.navv2.NavigationDirectionsHelper$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                double d3 = d;
                double d4 = d2;
                return Integer.compare(NavigationDirectionsHelper.sortMeters((NavV2Models.ClusterPoiItem) obj, d3, d4), NavigationDirectionsHelper.sortMeters((NavV2Models.ClusterPoiItem) obj2, d3, d4));
            }
        });
        return arrayList.size() > i ? new ArrayList(arrayList.subList(0, i)) : arrayList;
    }

    private static int sortMeters(NavV2Models.ClusterPoiItem clusterPoiItem, double d, double d2) {
        if (clusterPoiItem == null) {
            return Integer.MAX_VALUE;
        }
        if (clusterPoiItem.hasRouteDistance()) {
            return clusterPoiItem.distanceMeters;
        }
        if (!clusterPoiItem.hasCoordinates()) {
            return Integer.MAX_VALUE;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, fArr);
        return Math.round(fArr[0]);
    }

    public static void fetchRouteSummary(Context context, final double d, final double d2, final double d3, final double d4, NavV2Models.RoutePreference routePreference, final SummaryCallback summaryCallback) {
        final String strApiKey = apiKey(context);
        if (strApiKey.isEmpty()) {
            summaryCallback.onResult(null);
        } else {
            final NavV2Models.RoutePreference routePreference2 = routePreference != null ? routePreference : new NavV2Models.RoutePreference();
            EXEC.execute(new Runnable() { // from class: com.bajajconnect.wifi.navv2.NavigationDirectionsHelper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    NavigationDirectionsHelper.lambda$fetchRouteSummary$2(d, d2, d3, d4, strApiKey, routePreference2, summaryCallback);
                }
            });
        }
    }

    static /* synthetic */ void lambda$fetchRouteSummary$2(double d, double d2, double d3, double d4, String str, NavV2Models.RoutePreference routePreference, SummaryCallback summaryCallback) {
        try {
            StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?origin=");
            sb.append(d);
            sb.append(',');
            sb.append(d2);
            sb.append("&destination=");
            sb.append(d3);
            sb.append(',');
            sb.append(d4);
            sb.append("&key=");
            sb.append(encode(str));
            ArrayList arrayList = new ArrayList();
            boolean z = true;
            if ((routePreference.bitmask & 1) != 0) {
                arrayList.add("tolls");
            }
            if ((routePreference.bitmask & 2) != 0) {
                arrayList.add("highways");
            }
            if (routePreference.routeMode == NavV2Models.RouteMode.AVOID_TOLLS && !arrayList.contains("tolls")) {
                arrayList.add("tolls");
            }
            if (!arrayList.isEmpty()) {
                sb.append("&avoid=");
                sb.append(encode(NavigationDirectionsHelper$$ExternalSyntheticBackport0.m("|", arrayList)));
            }
            if ((routePreference.bitmask & 4) != 0) {
                sb.append("&departure_time=now&traffic_model=best_guess");
            }
            if (routePreference.routeMode == NavV2Models.RouteMode.SHORTEST) {
                sb.append("&alternatives=true");
            }
            JSONObject jSONObjectFetchJson = fetchJson(sb.toString());
            if (jSONObjectFetchJson != null && "OK".equals(jSONObjectFetchJson.optString(NotificationCompat.CATEGORY_STATUS))) {
                JSONObject jSONObjectSelectRoute = selectRoute(jSONObjectFetchJson.optJSONArray("routes"), routePreference);
                if (jSONObjectSelectRoute == null) {
                    summaryCallback.onResult(null);
                    return;
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectSelectRoute.optJSONArray("legs");
                JSONObject jSONObjectOptJSONObject = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? null : jSONArrayOptJSONArray.optJSONObject(0);
                if (jSONObjectOptJSONObject == null) {
                    summaryCallback.onResult(null);
                    return;
                }
                int iOptInt = jSONObjectOptJSONObject.optJSONObject(DirectionsCriteria.ANNOTATION_DISTANCE) != null ? jSONObjectOptJSONObject.optJSONObject(DirectionsCriteria.ANNOTATION_DISTANCE).optInt("value", 0) : 0;
                if ((routePreference.bitmask & 4) == 0) {
                    z = false;
                }
                int iResolveDurationSeconds = resolveDurationSeconds(jSONObjectOptJSONObject, z);
                summaryCallback.onResult(new NavV2Models.RouteSummary(formatDistance(iOptInt, routePreference.units), formatDuration(iResolveDurationSeconds), iOptInt, iResolveDurationSeconds, appliedRouteMode(routePreference)));
                return;
            }
            summaryCallback.onResult(null);
        } catch (Exception e) {
            Log.w(TAG, "fetchRouteSummary failed", e);
            summaryCallback.onResult(null);
        }
    }

    public static List<NavV2Models.ClusterPoiItem> filterItemsByRadiusKm(List<NavV2Models.ClusterPoiItem> list, double d, double d2, int i) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        float fMax = Math.max(1, i) * 1000.0f;
        ArrayList arrayList = new ArrayList();
        for (NavV2Models.ClusterPoiItem clusterPoiItem : list) {
            if (clusterPoiItem != null) {
                if (!clusterPoiItem.hasCoordinates()) {
                    arrayList.add(clusterPoiItem);
                } else {
                    float[] fArr = new float[1];
                    Location.distanceBetween(d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, fArr);
                    if (fArr[0] <= fMax) {
                        arrayList.add(clusterPoiItem);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<NavV2Models.ClusterPoiItem> takeClosestWithCoordinates(List<NavV2Models.ClusterPoiItem> list, final double d, final double d2, int i) {
        if (list == null || list.isEmpty() || i <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (NavV2Models.ClusterPoiItem clusterPoiItem : list) {
            if (clusterPoiItem != null && clusterPoiItem.hasCoordinates()) {
                arrayList.add(clusterPoiItem);
            }
        }
        arrayList.sort(new Comparator() { // from class: com.bajajconnect.wifi.navv2.NavigationDirectionsHelper$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return NavigationDirectionsHelper.lambda$takeClosestWithCoordinates$3(d, d2, (NavV2Models.ClusterPoiItem) obj, (NavV2Models.ClusterPoiItem) obj2);
            }
        });
        return new ArrayList(arrayList.subList(0, Math.min(i, arrayList.size())));
    }

    static /* synthetic */ int lambda$takeClosestWithCoordinates$3(double d, double d2, NavV2Models.ClusterPoiItem clusterPoiItem, NavV2Models.ClusterPoiItem clusterPoiItem2) {
        float[] fArr = new float[1];
        float[] fArr2 = new float[1];
        Location.distanceBetween(d, d2, clusterPoiItem.latitude, clusterPoiItem.longitude, fArr);
        Location.distanceBetween(d, d2, clusterPoiItem2.latitude, clusterPoiItem2.longitude, fArr2);
        return Float.compare(fArr[0], fArr2[0]);
    }

    public static boolean voiceGuidanceEnabled(NavV2Models.RoutePreference routePreference) {
        return (routePreference == null || (routePreference.bitmask & 8) == 0) ? false : true;
    }

    public static String formatDistance(int i, NavV2Models.Units units) {
        if (i < 0) {
            return "0 m";
        }
        if (units == NavV2Models.Units.MILES) {
            double d = i;
            double d2 = d / 1609.344d;
            if (d2 >= 0.1d) {
                return String.format(Locale.US, "%.1f mi", Double.valueOf(d2));
            }
            return String.format(Locale.US, "%.0f ft", Double.valueOf(d * 3.28084d));
        }
        if (i >= 1000) {
            return String.format(Locale.US, "%.1f km", Double.valueOf(((double) i) / 1000.0d));
        }
        return i + " m";
    }

    public static String formatDuration(int i) {
        if (i <= 0) {
            return "0 min";
        }
        if (i < 60) {
            return i + " sec";
        }
        int iMax = Math.max(1, (i + 29) / 60);
        if (iMax < 60) {
            return iMax + " min";
        }
        int i2 = iMax / 60;
        int i3 = iMax % 60;
        if (i3 <= 0) {
            return i2 + " hr";
        }
        return i2 + " hr " + i3 + " min";
    }

    private static JSONObject selectRoute(JSONArray jSONArray, NavV2Models.RoutePreference routePreference) {
        JSONObject jSONObject = null;
        if (jSONArray != null && jSONArray.length() != 0) {
            if (routePreference.routeMode != NavV2Models.RouteMode.SHORTEST) {
                return jSONArray.optJSONObject(0);
            }
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                int iRouteDistanceMeters = routeDistanceMeters(jSONObjectOptJSONObject);
                if (iRouteDistanceMeters < i) {
                    jSONObject = jSONObjectOptJSONObject;
                    i = iRouteDistanceMeters;
                }
            }
        }
        return jSONObject;
    }

    private static int routeDistanceMeters(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("legs")) == null) {
            return Integer.MAX_VALUE;
        }
        int iOptInt = 0;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optJSONObject(DirectionsCriteria.ANNOTATION_DISTANCE) != null) {
                iOptInt += jSONObjectOptJSONObject.optJSONObject(DirectionsCriteria.ANNOTATION_DISTANCE).optInt("value", 0);
            }
        }
        return iOptInt;
    }

    private static int resolveDurationSeconds(JSONObject jSONObject, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        if (z && (jSONObjectOptJSONObject = jSONObject.optJSONObject("duration_in_traffic")) != null) {
            return jSONObjectOptJSONObject.optInt("value", 0);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("duration");
        if (jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2.optInt("value", 0);
        }
        return 0;
    }

    private static NavV2Models.RouteMode appliedRouteMode(NavV2Models.RoutePreference routePreference) {
        if (routePreference == null || routePreference.routeMode == null) {
            return NavV2Models.RouteMode.FASTEST;
        }
        return routePreference.routeMode;
    }

    private static JSONObject fetchJson(String str) throws Exception {
        Response responseExecute = FirebasePerfOkHttpClient.execute(CLIENT.newCall(new Request.Builder().url(str).get().build()));
        try {
            if (responseExecute.isSuccessful() && responseExecute.body() != null) {
                JSONObject jSONObject = new JSONObject(responseExecute.body().string());
                if (responseExecute != null) {
                    responseExecute.close();
                }
                return jSONObject;
            }
            if (responseExecute == null) {
                return null;
            }
            responseExecute.close();
            return null;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static String apiKey(Context context) {
        String apiKey = GmapUtil.getApiKey();
        if (apiKey != null && !apiKey.trim().isEmpty()) {
            return apiKey.trim();
        }
        if (context == null) {
            return "";
        }
        try {
            String string = context.getString(R.string.GOOGLE_MAPS_API_KEY);
            if (string == null) {
                return "";
            }
            return string.trim();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String encode(String str) {
        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return str;
        }
    }
}
