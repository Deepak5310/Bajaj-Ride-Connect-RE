package com.bajajconnect;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.bajajconnect.gMaps.GoogleNavSdkGate;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.NetworkRequestImpl;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.stats.CodePackage;
import com.google.android.libraries.navigation.AlternateRoutesStrategy;
import com.google.android.libraries.navigation.DisplayOptions;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RouteSegment;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.android.libraries.navigation.Waypoint;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleDirectionsModule extends ReactContextBaseJavaModule {
    private static final MediaType JSON_MEDIA = MediaType.parse("application/json; charset=utf-8");
    private static final String ROUTES_API_URL = "https://routes.googleapis.com/directions/v2:computeRoutes";
    private static final String TAG = "GoogleDirectionsModule";
    private final OkHttpClient httpClient;

    GoogleDirectionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.httpClient = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    private String getApiKey() {
        String string;
        try {
            ApplicationInfo applicationInfo = getReactApplicationContext().getPackageManager().getApplicationInfo(getReactApplicationContext().getPackageName(), 128);
            return (applicationInfo.metaData == null || (string = applicationInfo.metaData.getString("com.google.android.geo.API_KEY")) == null) ? "" : string;
        } catch (Exception e) {
            Log.e(TAG, "getApiKey error", e);
            return "";
        }
    }

    @ReactMethod
    public void getDirections(final double d, final double d2, final double d3, final double d4, ReadableArray readableArray, final Promise promise) {
        new Thread(new Runnable() { // from class: com.bajajconnect.GoogleDirectionsModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDirections$0(d, d2, d3, d4, promise);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDirections$0(double d, double d2, double d3, double d4, Promise promise) {
        try {
            Log.d(TAG, "getDirections: origin=" + d + "," + d2 + " dest=" + d3 + "," + d4);
            if (GoogleNavSdkGate.navigationActivityOwnsNavigator()) {
                Log.w(TAG, "getDirections skipped — NavigationActivity owns Navigator");
                promise.resolve(buildEmptyResult(d2, d, d4, d3, true));
            } else {
                prepareNetworkForRouting();
                tryNavigationSdk(d, d2, d3, d4, promise);
            }
        } catch (Exception e) {
            Log.e(TAG, "getDirections error", e);
            promise.reject("DIRECTIONS_ERROR", e.getMessage(), e);
        }
    }

    private void prepareNetworkForRouting() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext == null) {
            return;
        }
        NetworkRequestImpl.restoreDefaultNetwork(reactApplicationContext);
        if (!MirroringGlobarVar.isWifiConnected) {
            Log.d(TAG, "prepareNetworkForRouting: restored default (no cluster wifi)");
            return;
        }
        boolean zBindCellularForRouting = NetworkRequestImpl.bindCellularForRouting(reactApplicationContext, false);
        Log.d(TAG, "prepareNetworkForRouting cellularBound=" + zBindCellularForRouting);
        if (zBindCellularForRouting) {
            return;
        }
        try {
            Thread.sleep(150L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        NetworkRequestImpl.bindCellularForRouting(reactApplicationContext, false);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0296  */
    /* JADX WARN: Code duplicated, block: B:73:0x02d3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.bajajconnect.GoogleDirectionsModule] */
    private WritableMap tryRoutesApiV2(String str, double d, double d2, double d3, double d4, ReadableArray readableArray) {
        String str2;
        String str3;
        ReadableArray readableArray2;
        double d5;
        double d6;
        double d7;
        double d8;
        String str4;
        double d9;
        WritableArray writableArray;
        String strSubstring;
        String strOptString;
        String str5;
        double d10 = d;
        String str6 = "navigationInstruction";
        String str7 = "longitude";
        String str8 = TAG;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("latitude", d10);
            jSONObject4.put("longitude", d2);
            jSONObject3.put("latLng", jSONObject4);
            jSONObject2.put(FirebaseAnalytics.Param.LOCATION, jSONObject3);
            jSONObject.put("origin", jSONObject2);
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = new JSONObject();
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("latitude", d3);
            jSONObject7.put("longitude", d4);
            jSONObject6.put("latLng", jSONObject7);
            jSONObject5.put(FirebaseAnalytics.Param.LOCATION, jSONObject6);
            jSONObject.put(FirebaseAnalytics.Param.DESTINATION, jSONObject5);
            ReadableArray readableArray3 = readableArray;
            if (readableArray3 == null || readableArray.size() <= 0) {
                str3 = FirebaseAnalytics.Param.DESTINATION;
            } else {
                JSONArray jSONArray = new JSONArray();
                str3 = FirebaseAnalytics.Param.DESTINATION;
                int i = 0;
                while (i < readableArray.size()) {
                    ReadableArray array = readableArray3.getArray(i);
                    if (array != null && array.size() >= 2) {
                        JSONObject jSONObject8 = new JSONObject();
                        JSONObject jSONObject9 = new JSONObject();
                        JSONObject jSONObject10 = new JSONObject();
                        jSONObject10.put("latitude", array.getDouble(1));
                        jSONObject10.put("longitude", array.getDouble(0));
                        jSONObject9.put("latLng", jSONObject10);
                        jSONObject8.put(FirebaseAnalytics.Param.LOCATION, jSONObject9);
                        jSONArray.put(jSONObject8);
                    }
                    i++;
                    readableArray3 = readableArray;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("intermediates", jSONArray);
                }
            }
            jSONObject.put("travelMode", CodePackage.DRIVE);
            jSONObject.put("routingPreference", "TRAFFIC_AWARE");
            jSONObject.put("computeAlternativeRoutes", false);
            Request requestBuild = new Request.Builder().url(ROUTES_API_URL).addHeader("Content-Type", "application/json").addHeader("X-Goog-Api-Key", str).addHeader("X-Goog-FieldMask", "routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline,routes.legs.duration,routes.legs.distanceMeters,routes.legs.steps.navigationInstruction,routes.legs.steps.startLocation,routes.legs.steps.endLocation,routes.legs.startLocation,routes.legs.endLocation").post(RequestBody.create(JSON_MEDIA, jSONObject.toString())).build();
            StringBuilder sb = new StringBuilder();
            sb.append("Routes API v2 request: origin=");
            sb.append(d10);
            sb.append(",");
            double d11 = d2;
            sb.append(d11);
            sb.append(" dest=");
            sb.append(d3);
            sb.append(",");
            sb.append(d4);
            try {
                Log.d(str8, sb.toString());
                String str9 = "latLng";
                str2 = this;
                Response responseExecute = FirebasePerfOkHttpClient.execute(str2.httpClient.newCall(requestBuild));
                String strString = responseExecute.body().string();
                if (!responseExecute.isSuccessful()) {
                    Log.e(str8, "Routes API v2 HTTP " + responseExecute.code() + ": " + strString);
                    return null;
                }
                JSONObject jSONObject11 = new JSONObject(strString);
                if (jSONObject11.has("error")) {
                    Log.e(str8, "Routes API v2 error: " + jSONObject11.getJSONObject("error").optString(StackTraceHelper.MESSAGE_KEY, EnvironmentCompat.MEDIA_UNKNOWN));
                    return null;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject11.optJSONArray("routes");
                try {
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                        String str10 = FirebaseAnalytics.Param.LOCATION;
                        JSONObject jSONObject12 = jSONArrayOptJSONArray.getJSONObject(0);
                        str8 = str8;
                        double durationSeconds = str2.parseDurationSeconds(jSONObject12.optString("duration", "0s"));
                        double dOptDouble = jSONObject12.optDouble("distanceMeters", 0.0d);
                        String str11 = "";
                        String strOptString2 = jSONObject12.has("polyline") ? jSONObject12.getJSONObject("polyline").optString("encodedPolyline", "") : "";
                        WritableArray writableArrayCreateArray = Arguments.createArray();
                        double d12 = dOptDouble;
                        WritableArray writableArrayCreateArray2 = Arguments.createArray();
                        JSONArray jSONArrayOptJSONArray2 = jSONObject12.optJSONArray("legs");
                        if (jSONArrayOptJSONArray2 != null) {
                            double dOptDouble2 = d3;
                            double dOptDouble3 = d4;
                            double dOptDouble4 = d10;
                            double dOptDouble5 = d11;
                            int i2 = 0;
                            while (i2 < jSONArrayOptJSONArray2.length()) {
                                JSONObject jSONObject13 = jSONArrayOptJSONArray2.getJSONObject(i2);
                                String str12 = strOptString2;
                                String str13 = "startLocation";
                                if (i2 == 0 && jSONObject13.has("startLocation")) {
                                    writableArray = writableArrayCreateArray;
                                    JSONObject jSONObject14 = jSONObject13.getJSONObject("startLocation");
                                    if (jSONObject14.has(str9)) {
                                        JSONObject jSONObject15 = jSONObject14.getJSONObject(str9);
                                        dOptDouble4 = jSONObject15.optDouble("latitude", d10);
                                        dOptDouble5 = jSONObject15.optDouble(str7, d11);
                                    }
                                } else {
                                    writableArray = writableArrayCreateArray;
                                }
                                if (i2 == jSONArrayOptJSONArray2.length() - 1 && jSONObject13.has("endLocation")) {
                                    JSONObject jSONObject16 = jSONObject13.getJSONObject("endLocation");
                                    if (jSONObject16.has(str9)) {
                                        JSONObject jSONObject17 = jSONObject16.getJSONObject(str9);
                                        dOptDouble2 = jSONObject17.optDouble("latitude", d3);
                                        dOptDouble3 = jSONObject17.optDouble(str7, d4);
                                    }
                                }
                                if (i2 < jSONArrayOptJSONArray2.length() - 1 && jSONObject13.has("endLocation")) {
                                    JSONObject jSONObject18 = jSONObject13.getJSONObject("endLocation");
                                    if (jSONObject18.has(str9)) {
                                        JSONObject jSONObject19 = jSONObject18.getJSONObject(str9);
                                        WritableArray writableArrayCreateArray3 = Arguments.createArray();
                                        writableArrayCreateArray3.pushDouble(jSONObject19.optDouble(str7, 0.0d));
                                        writableArrayCreateArray3.pushDouble(jSONObject19.optDouble("latitude", 0.0d));
                                        writableArrayCreateArray2.pushArray(writableArrayCreateArray3);
                                    }
                                }
                                JSONArray jSONArrayOptJSONArray3 = jSONObject13.optJSONArray("steps");
                                if (jSONArrayOptJSONArray3 != null) {
                                    int i3 = 0;
                                    while (i3 < jSONArrayOptJSONArray3.length()) {
                                        JSONObject jSONObject20 = jSONArrayOptJSONArray3.getJSONObject(i3);
                                        WritableMap writableMapCreateMap = Arguments.createMap();
                                        String str14 = str6;
                                        if (jSONObject20.has(str14)) {
                                            JSONObject jSONObject21 = jSONObject20.getJSONObject(str14);
                                            strOptString = jSONObject21.optString("maneuver", str11);
                                            strSubstring = jSONObject21.optString("instructions", str11);
                                        } else {
                                            strSubstring = str11;
                                            strOptString = strSubstring;
                                        }
                                        String[] strArrManeuverToTypeModifier = str2.maneuverToTypeModifier(strOptString, strSubstring);
                                        JSONArray jSONArray2 = jSONArrayOptJSONArray3;
                                        writableMapCreateMap.putString("type", strArrManeuverToTypeModifier[0]);
                                        writableMapCreateMap.putString("modifier", strArrManeuverToTypeModifier[1]);
                                        WritableArray writableArrayCreateArray4 = Arguments.createArray();
                                        str13 = str13;
                                        if (jSONObject20.has(str13)) {
                                            JSONObject jSONObject22 = jSONObject20.getJSONObject(str13);
                                            String str15 = str9;
                                            if (jSONObject22.has(str15)) {
                                                JSONObject jSONObject23 = jSONObject22.getJSONObject(str15);
                                                str5 = str15;
                                                writableArrayCreateArray4.pushDouble(jSONObject23.optDouble(str7, d2));
                                                writableArrayCreateArray4.pushDouble(jSONObject23.optDouble("latitude", d));
                                            } else {
                                                str5 = str15;
                                                writableArrayCreateArray4.pushDouble(d2);
                                                writableArrayCreateArray4.pushDouble(d);
                                            }
                                        } else {
                                            str5 = str9;
                                            writableArrayCreateArray4.pushDouble(d2);
                                            writableArrayCreateArray4.pushDouble(d);
                                        }
                                        String str16 = str10;
                                        writableMapCreateMap.putArray(str16, writableArrayCreateArray4);
                                        if (strSubstring.length() > 200) {
                                            strSubstring = strSubstring.substring(0, 200);
                                        }
                                        writableMapCreateMap.putString("roadName", strSubstring);
                                        writableMapCreateMap.putInt("bearingAfter", 0);
                                        writableMapCreateMap.putInt("bearingBefore", 0);
                                        WritableArray writableArray2 = writableArray;
                                        writableArray2.pushMap(writableMapCreateMap);
                                        i3++;
                                        writableArray = writableArray2;
                                        str10 = str16;
                                        jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                                        jSONArrayOptJSONArray3 = jSONArray2;
                                        str11 = str11;
                                        str9 = str5;
                                        str7 = str7;
                                        str6 = str14;
                                    }
                                }
                                d11 = d2;
                                i2++;
                                str10 = str10;
                                d10 = d;
                                strOptString2 = str12;
                                str11 = str11;
                                str9 = str9;
                                str7 = str7;
                                d12 = d12;
                                durationSeconds = durationSeconds;
                                writableArrayCreateArray = writableArray;
                                jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                                str6 = str6;
                            }
                            readableArray2 = writableArrayCreateArray;
                            d5 = durationSeconds;
                            d6 = d12;
                            str4 = strOptString2;
                            d11 = dOptDouble5;
                            d7 = dOptDouble4;
                            d9 = dOptDouble3;
                            d8 = dOptDouble2;
                        } else {
                            readableArray2 = writableArrayCreateArray;
                            d5 = durationSeconds;
                            d6 = d12;
                            d7 = d10;
                            d8 = d3;
                            str4 = strOptString2;
                            d9 = d4;
                        }
                        List<double[]> listDecodePolyline = str2.decodePolyline(str4);
                        WritableArray writableArrayCreateArray5 = Arguments.createArray();
                        Iterator<double[]> it2 = listDecodePolyline.iterator();
                        while (it2.hasNext()) {
                            double[] next = it2.next();
                            WritableArray writableArrayCreateArray6 = Arguments.createArray();
                            writableArrayCreateArray6.pushDouble(next[1]);
                            writableArrayCreateArray6.pushDouble(next[0]);
                            writableArrayCreateArray5.pushArray(writableArrayCreateArray6);
                            it2 = it2;
                            d8 = d8;
                        }
                        double d13 = d8;
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        writableMapCreateMap2.putString("type", "LineString");
                        writableMapCreateMap2.putArray("coordinates", writableArrayCreateArray5);
                        WritableMap writableMapCreateMap3 = Arguments.createMap();
                        writableMapCreateMap3.putString("type", "Feature");
                        writableMapCreateMap3.putMap("geometry", writableMapCreateMap2);
                        WritableMap writableMapCreateMap4 = Arguments.createMap();
                        WritableArray writableArrayCreateArray7 = Arguments.createArray();
                        WritableMap writableMapCreateMap5 = Arguments.createMap();
                        double d14 = d5;
                        writableMapCreateMap5.putDouble("duration", d14);
                        double d15 = d6;
                        writableMapCreateMap5.putDouble(DirectionsCriteria.ANNOTATION_DISTANCE, d15);
                        writableArrayCreateArray7.pushMap(writableMapCreateMap5);
                        writableMapCreateMap4.putArray("routes", writableArrayCreateArray7);
                        WritableArray writableArrayCreateArray8 = Arguments.createArray();
                        writableArrayCreateArray8.pushDouble(d11);
                        writableArrayCreateArray8.pushDouble(d7);
                        WritableArray writableArrayCreateArray9 = Arguments.createArray();
                        writableArrayCreateArray9.pushDouble(d9);
                        writableArrayCreateArray9.pushDouble(d13);
                        WritableMap writableMapCreateMap6 = Arguments.createMap();
                        writableMapCreateMap6.putArray("directionData", readableArray2);
                        writableMapCreateMap6.putMap("polygon", writableMapCreateMap3);
                        writableMapCreateMap6.putMap("navigationData", writableMapCreateMap4);
                        writableMapCreateMap6.putArray("source", writableArrayCreateArray8);
                        writableMapCreateMap6.putArray(str3, writableArrayCreateArray9);
                        writableMapCreateMap6.putArray("middleWayPoints", writableArrayCreateArray2);
                        Log.d(str8, "Routes API v2 success: " + readableArray2.size() + " steps, " + d14 + "s, " + d15 + "m, " + listDecodePolyline.size() + " polyline points");
                        return writableMapCreateMap6;
                    }
                    Log.e(str8, "Routes API v2: no routes returned");
                    return null;
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = str8;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str8;
        }
        Log.e(str2, "Routes API v2 exception", e);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private void tryNavigationSdk(final double d, final double d2, final double d3, final double d4, Promise promise) {
        Promise promise2;
        String str;
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e(TAG, "No current activity for Navigation SDK");
            promise.resolve(buildEmptyResult(d2, d, d4, d3));
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference(null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.GoogleDirectionsModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$tryNavigationSdk$1(currentActivity, atomicReference, d2, d, d4, d3, countDownLatch);
            }
        });
        try {
            if (!countDownLatch.await(20L, TimeUnit.SECONDS)) {
                str = TAG;
                try {
                    Log.e(str, "Nav SDK timeout");
                } catch (Exception e) {
                    e = e;
                    promise2 = promise;
                    Log.e(str, "Nav SDK latch error", e);
                    promise2.resolve(buildEmptyResult(d2, d, d4, d3));
                }
            } else {
                str = TAG;
            }
            WritableMap writableMapBuildEmptyResult = (WritableMap) atomicReference.get();
            if (writableMapBuildEmptyResult == null) {
                writableMapBuildEmptyResult = buildEmptyResult(d2, d, d4, d3);
            }
            promise2 = promise;
            try {
                promise2.resolve(writableMapBuildEmptyResult);
            } catch (Exception e2) {
                e = e2;
                Log.e(str, "Nav SDK latch error", e);
                promise2.resolve(buildEmptyResult(d2, d, d4, d3));
            }
        } catch (Exception e3) {
            e = e3;
            promise2 = promise;
            str = TAG;
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.GoogleDirectionsModule$1, reason: invalid class name */
    class AnonymousClass1 implements NavigationApi.NavigatorListener {
        final /* synthetic */ double val$destLat;
        final /* synthetic */ double val$destLng;
        final /* synthetic */ CountDownLatch val$latch;
        final /* synthetic */ double val$originLat;
        final /* synthetic */ double val$originLng;
        final /* synthetic */ AtomicReference val$resultRef;

        AnonymousClass1(AtomicReference atomicReference, double d, double d2, double d3, double d4, CountDownLatch countDownLatch) {
            this.val$resultRef = atomicReference;
            this.val$originLng = d;
            this.val$originLat = d2;
            this.val$destLng = d3;
            this.val$destLat = d4;
            this.val$latch = countDownLatch;
        }

        @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
        public void onError(int i) {
            Log.e(GoogleDirectionsModule.TAG, "Navigation SDK error code: " + i);
            this.val$resultRef.set(GoogleDirectionsModule.this.buildEmptyResult(this.val$originLng, this.val$originLat, this.val$destLng, this.val$destLat));
            this.val$latch.countDown();
        }

        @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
        public void onNavigatorReady(final Navigator navigator) {
            navigator.setHeadsUpNotificationEnabled(false);
            if (GoogleNavSdkGate.navigationActivityOwnsNavigator()) {
                Log.w(GoogleDirectionsModule.TAG, "onNavigatorReady: abort setDestination — NavigationActivity owns Navigator");
                this.val$resultRef.set(GoogleDirectionsModule.this.buildEmptyResult(this.val$originLng, this.val$originLat, this.val$destLng, this.val$destLat, true));
                this.val$latch.countDown();
                return;
            }
            try {
                Waypoint waypointBuild = Waypoint.builder().setLatLng(this.val$destLat, this.val$destLng).build();
                RoutingOptions routingOptions = new RoutingOptions();
                routingOptions.routingStrategy(1);
                routingOptions.travelMode(3);
                routingOptions.alternateRoutesStrategy(AlternateRoutesStrategy.SHOW_NONE);
                DisplayOptions displayOptions = new DisplayOptions();
                synchronized (GoogleNavSdkGate.LOCK) {
                    if (GoogleNavSdkGate.navigationActivityOwnsNavigator()) {
                        Log.w(GoogleDirectionsModule.TAG, "abort setDestination — NavigationActivity owns Navigator");
                        this.val$resultRef.set(GoogleDirectionsModule.this.buildEmptyResult(this.val$originLng, this.val$originLat, this.val$destLng, this.val$destLat, true));
                        this.val$latch.countDown();
                        return;
                    }
                    ListenableResultFuture<Navigator.RouteStatus> destination = navigator.setDestination(waypointBuild, routingOptions, displayOptions);
                    final double d = this.val$originLng;
                    final double d2 = this.val$originLat;
                    final double d3 = this.val$destLng;
                    final double d4 = this.val$destLat;
                    final AtomicReference atomicReference = this.val$resultRef;
                    final CountDownLatch countDownLatch = this.val$latch;
                    destination.setOnResultListener(new ListenableResultFuture.OnResultListener() { // from class: com.bajajconnect.GoogleDirectionsModule$1$$ExternalSyntheticLambda0
                        @Override // com.google.android.libraries.navigation.ListenableResultFuture.OnResultListener
                        public final void onResult(Object obj) {
                            this.f$0.lambda$onNavigatorReady$0(navigator, d, d2, d3, d4, atomicReference, countDownLatch, (Navigator.RouteStatus) obj);
                        }
                    });
                }
            } catch (Exception e) {
                Log.e(GoogleDirectionsModule.TAG, "Nav SDK setDestination error", e);
                this.val$resultRef.set(GoogleDirectionsModule.this.buildEmptyResult(this.val$originLng, this.val$originLat, this.val$destLng, this.val$destLat));
                this.val$latch.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:34:0x00ae A[Catch: Exception -> 0x00cb, TryCatch #2 {Exception -> 0x00cb, blocks: (B:26:0x006d, B:34:0x00ae, B:37:0x00cd, B:49:0x0161, B:52:0x016b, B:54:0x0171, B:56:0x017d, B:58:0x0183, B:60:0x01be, B:62:0x01d4, B:64:0x01ea, B:65:0x01f4), top: B:95:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00f6 A[Catch: Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:39:0x00e4, B:41:0x00f6, B:43:0x00fc, B:47:0x0135), top: B:91:0x00e4 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:51:0x016a  */
        /* JADX WARN: Code duplicated, block: B:54:0x0171 A[Catch: Exception -> 0x00cb, TryCatch #2 {Exception -> 0x00cb, blocks: (B:26:0x006d, B:34:0x00ae, B:37:0x00cd, B:49:0x0161, B:52:0x016b, B:54:0x0171, B:56:0x017d, B:58:0x0183, B:60:0x01be, B:62:0x01d4, B:64:0x01ea, B:65:0x01f4), top: B:95:0x006d }] */
        /* JADX WARN: Code duplicated, block: B:63:0x01e9  */
        public /* synthetic */ void lambda$onNavigatorReady$0(Navigator navigator, double d, double d2, double d3, double d4, AtomicReference atomicReference, CountDownLatch countDownLatch, Navigator.RouteStatus routeStatus) {
            AtomicReference atomicReference2;
            String str;
            int i;
            double d5;
            String str2;
            int size;
            String str3;
            int i2;
            List<LatLng> latLngs;
            String str4 = "type";
            Navigator.RouteStatus routeStatus2 = Navigator.RouteStatus.OK;
            String str5 = GoogleDirectionsModule.TAG;
            if (routeStatus == routeStatus2) {
                try {
                    TimeAndDistance currentTimeAndDistance = navigator.getCurrentTimeAndDistance();
                    double seconds = currentTimeAndDistance != null ? currentTimeAndDistance.getSeconds() : 0.0d;
                    double meters = currentTimeAndDistance != null ? currentTimeAndDistance.getMeters() : 0.0d;
                    List<RouteSegment> routeSegments = navigator.getRouteSegments();
                    try {
                        WritableArray writableArrayCreateArray = Arguments.createArray();
                        if (routeSegments == null) {
                            d5 = meters;
                            str2 = "type";
                            str = GoogleDirectionsModule.TAG;
                            i = 0;
                            if (i == 0) {
                                WritableArray writableArrayCreateArray2 = Arguments.createArray();
                                writableArrayCreateArray2.pushDouble(d);
                                writableArrayCreateArray2.pushDouble(d2);
                                writableArrayCreateArray.pushArray(writableArrayCreateArray2);
                                WritableArray writableArrayCreateArray3 = Arguments.createArray();
                                writableArrayCreateArray3.pushDouble(d3);
                                writableArrayCreateArray3.pushDouble(d4);
                                writableArrayCreateArray.pushArray(writableArrayCreateArray3);
                                i = 2;
                            }
                            int i3 = i;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Nav SDK route OK: ");
                            sb.append(seconds);
                            sb.append("s, ");
                            double d6 = d5;
                            sb.append(d6);
                            sb.append("m, ");
                            sb.append(i3);
                            sb.append(" polyline points, ");
                            if (routeSegments != null) {
                                size = routeSegments.size();
                            } else {
                                size = 0;
                            }
                            sb.append(size);
                            sb.append(" segments");
                            String string = sb.toString();
                            str3 = str;
                            Log.d(str3, string);
                            WritableMap writableMapCreateMap = Arguments.createMap();
                            String str6 = str2;
                            writableMapCreateMap.putString(str6, "LineString");
                            writableMapCreateMap.putArray("coordinates", writableArrayCreateArray);
                            WritableMap writableMapCreateMap2 = Arguments.createMap();
                            writableMapCreateMap2.putString(str6, "Feature");
                            writableMapCreateMap2.putMap("geometry", writableMapCreateMap);
                            WritableMap writableMapCreateMap3 = Arguments.createMap();
                            WritableArray writableArrayCreateArray4 = Arguments.createArray();
                            str = str3;
                            WritableMap writableMapCreateMap4 = Arguments.createMap();
                            writableMapCreateMap4.putDouble("duration", seconds);
                            writableMapCreateMap4.putDouble(DirectionsCriteria.ANNOTATION_DISTANCE, d6);
                            writableArrayCreateArray4.pushMap(writableMapCreateMap4);
                            writableMapCreateMap3.putArray("routes", writableArrayCreateArray4);
                            WritableArray writableArrayCreateArray5 = Arguments.createArray();
                            writableArrayCreateArray5.pushDouble(d);
                            writableArrayCreateArray5.pushDouble(d2);
                            WritableArray writableArrayCreateArray6 = Arguments.createArray();
                            writableArrayCreateArray6.pushDouble(d3);
                            writableArrayCreateArray6.pushDouble(d4);
                            WritableArray writableArrayCreateArray7 = Arguments.createArray();
                            if (routeSegments != null) {
                                while (i2 < routeSegments.size()) {
                                    RouteSegment routeSegment = routeSegments.get(i2);
                                    latLngs = routeSegment.getLatLngs();
                                    if (latLngs == null) {
                                    }
                                }
                            }
                            WritableMap writableMapCreateMap5 = Arguments.createMap();
                            writableMapCreateMap5.putArray("directionData", writableArrayCreateArray7);
                            writableMapCreateMap5.putMap("polygon", writableMapCreateMap2);
                            writableMapCreateMap5.putMap("navigationData", writableMapCreateMap3);
                            writableMapCreateMap5.putArray("source", writableArrayCreateArray5);
                            writableMapCreateMap5.putArray(FirebaseAnalytics.Param.DESTINATION, writableArrayCreateArray6);
                            writableMapCreateMap5.putArray("middleWayPoints", Arguments.createArray());
                            atomicReference2 = atomicReference;
                            atomicReference2.set(writableMapCreateMap5);
                        } else {
                            try {
                                if (routeSegments.isEmpty()) {
                                    d5 = meters;
                                    str2 = "type";
                                    str = GoogleDirectionsModule.TAG;
                                    i = 0;
                                } else {
                                    Iterator<RouteSegment> it2 = routeSegments.iterator();
                                    i = 0;
                                    while (it2.hasNext()) {
                                        List<LatLng> latLngs2 = it2.next().getLatLngs();
                                        if (latLngs2 != null) {
                                            for (LatLng latLng : latLngs2) {
                                                String str7 = str4;
                                                str = str5;
                                                try {
                                                    WritableArray writableArrayCreateArray8 = Arguments.createArray();
                                                    writableArrayCreateArray8.pushDouble(latLng.longitude);
                                                    writableArrayCreateArray8.pushDouble(latLng.latitude);
                                                    writableArrayCreateArray.pushArray(writableArrayCreateArray8);
                                                    i++;
                                                    str5 = str;
                                                    str4 = str7;
                                                    meters = meters;
                                                } catch (Exception e) {
                                                    e = e;
                                                    atomicReference2 = atomicReference;
                                                    Log.e(str, "Nav SDK result extraction error", e);
                                                    atomicReference2.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4));
                                                    countDownLatch.countDown();
                                                }
                                            }
                                        }
                                        str5 = str5;
                                        str4 = str4;
                                        meters = meters;
                                    }
                                    d5 = meters;
                                    str2 = str4;
                                    str = str5;
                                }
                                if (i == 0) {
                                    WritableArray writableArrayCreateArray9 = Arguments.createArray();
                                    writableArrayCreateArray9.pushDouble(d);
                                    writableArrayCreateArray9.pushDouble(d2);
                                    writableArrayCreateArray.pushArray(writableArrayCreateArray9);
                                    WritableArray writableArrayCreateArray10 = Arguments.createArray();
                                    writableArrayCreateArray10.pushDouble(d3);
                                    writableArrayCreateArray10.pushDouble(d4);
                                    writableArrayCreateArray.pushArray(writableArrayCreateArray10);
                                    i = 2;
                                }
                                int i4 = i;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Nav SDK route OK: ");
                                sb2.append(seconds);
                                sb2.append("s, ");
                                double d7 = d5;
                                try {
                                    sb2.append(d7);
                                    sb2.append("m, ");
                                    sb2.append(i4);
                                    sb2.append(" polyline points, ");
                                    if (routeSegments != null) {
                                        size = routeSegments.size();
                                    } else {
                                        size = 0;
                                    }
                                    sb2.append(size);
                                    sb2.append(" segments");
                                    String string2 = sb2.toString();
                                    str3 = str;
                                    try {
                                        Log.d(str3, string2);
                                        WritableMap writableMapCreateMap6 = Arguments.createMap();
                                        String str8 = str2;
                                        writableMapCreateMap6.putString(str8, "LineString");
                                        writableMapCreateMap6.putArray("coordinates", writableArrayCreateArray);
                                        WritableMap writableMapCreateMap7 = Arguments.createMap();
                                        writableMapCreateMap7.putString(str8, "Feature");
                                        writableMapCreateMap7.putMap("geometry", writableMapCreateMap6);
                                        WritableMap writableMapCreateMap8 = Arguments.createMap();
                                        WritableArray writableArrayCreateArray11 = Arguments.createArray();
                                        str = str3;
                                        WritableMap writableMapCreateMap9 = Arguments.createMap();
                                        writableMapCreateMap9.putDouble("duration", seconds);
                                        writableMapCreateMap9.putDouble(DirectionsCriteria.ANNOTATION_DISTANCE, d7);
                                        writableArrayCreateArray11.pushMap(writableMapCreateMap9);
                                        writableMapCreateMap8.putArray("routes", writableArrayCreateArray11);
                                        WritableArray writableArrayCreateArray12 = Arguments.createArray();
                                        writableArrayCreateArray12.pushDouble(d);
                                        writableArrayCreateArray12.pushDouble(d2);
                                        WritableArray writableArrayCreateArray13 = Arguments.createArray();
                                        writableArrayCreateArray13.pushDouble(d3);
                                        writableArrayCreateArray13.pushDouble(d4);
                                        WritableArray writableArrayCreateArray14 = Arguments.createArray();
                                        if (routeSegments != null) {
                                            for (i2 = 0; i2 < routeSegments.size(); i2++) {
                                                RouteSegment routeSegment2 = routeSegments.get(i2);
                                                latLngs = routeSegment2.getLatLngs();
                                                if (latLngs == null && !latLngs.isEmpty()) {
                                                    WritableMap writableMapCreateMap10 = Arguments.createMap();
                                                    writableMapCreateMap10.putString(str8, "turn");
                                                    writableMapCreateMap10.putString("modifier", "straight");
                                                    WritableArray writableArrayCreateArray15 = Arguments.createArray();
                                                    writableArrayCreateArray15.pushDouble(latLngs.get(0).longitude);
                                                    writableArrayCreateArray15.pushDouble(latLngs.get(0).latitude);
                                                    writableMapCreateMap10.putArray(FirebaseAnalytics.Param.LOCATION, writableArrayCreateArray15);
                                                    writableMapCreateMap10.putString("roadName", routeSegment2.getDestinationWaypoint() != null ? "Segment " + (i2 + 1) : "Route");
                                                    writableMapCreateMap10.putInt("bearingAfter", 0);
                                                    writableMapCreateMap10.putInt("bearingBefore", 0);
                                                    writableArrayCreateArray14.pushMap(writableMapCreateMap10);
                                                }
                                            }
                                        }
                                        WritableMap writableMapCreateMap11 = Arguments.createMap();
                                        writableMapCreateMap11.putArray("directionData", writableArrayCreateArray14);
                                        writableMapCreateMap11.putMap("polygon", writableMapCreateMap7);
                                        writableMapCreateMap11.putMap("navigationData", writableMapCreateMap8);
                                        writableMapCreateMap11.putArray("source", writableArrayCreateArray12);
                                        writableMapCreateMap11.putArray(FirebaseAnalytics.Param.DESTINATION, writableArrayCreateArray13);
                                        writableMapCreateMap11.putArray("middleWayPoints", Arguments.createArray());
                                        atomicReference2 = atomicReference;
                                        try {
                                            atomicReference2.set(writableMapCreateMap11);
                                        } catch (Exception e2) {
                                            e = e2;
                                            Log.e(str, "Nav SDK result extraction error", e);
                                            atomicReference2.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4));
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        str = str3;
                                        atomicReference2 = atomicReference;
                                        Log.e(str, "Nav SDK result extraction error", e);
                                        atomicReference2.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4));
                                        countDownLatch.countDown();
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str = str5;
                                atomicReference2 = atomicReference;
                                Log.e(str, "Nav SDK result extraction error", e);
                                atomicReference2.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4));
                                countDownLatch.countDown();
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        atomicReference2 = atomicReference;
                        str = GoogleDirectionsModule.TAG;
                        Log.e(str, "Nav SDK result extraction error", e);
                        atomicReference2.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4));
                        countDownLatch.countDown();
                    }
                } catch (Exception e7) {
                    e = e7;
                    atomicReference2 = atomicReference;
                }
            } else {
                Log.e(GoogleDirectionsModule.TAG, "Nav SDK route status: " + routeStatus);
                atomicReference.set(GoogleDirectionsModule.this.buildEmptyResult(d, d2, d3, d4, GoogleNavSdkGate.navigationActivityOwnsNavigator() || routeStatus == Navigator.RouteStatus.ROUTE_CANCELED));
            }
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryNavigationSdk$1(Activity activity, AtomicReference atomicReference, double d, double d2, double d3, double d4, CountDownLatch countDownLatch) {
        try {
            NavigationApi.getNavigator(activity, new AnonymousClass1(atomicReference, d, d2, d3, d4, countDownLatch));
        } catch (Exception e) {
            Log.e(TAG, "Nav SDK init error", e);
            atomicReference.set(buildEmptyResult(d, d2, d3, d4));
            countDownLatch.countDown();
        }
    }

    private double parseDurationSeconds(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str.replace("s", "").trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap buildEmptyResult(double d, double d2, double d3, double d4) {
        return buildEmptyResult(d, d2, d3, d4, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WritableMap buildEmptyResult(double d, double d2, double d3, double d4, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("directionData", Arguments.createArray());
        writableMapCreateMap.putMap("polygon", Arguments.createMap());
        writableMapCreateMap.putNull("navigationData");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushDouble(d);
        writableArrayCreateArray.pushDouble(d2);
        writableMapCreateMap.putArray("source", writableArrayCreateArray);
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        writableArrayCreateArray2.pushDouble(d3);
        writableArrayCreateArray2.pushDouble(d4);
        writableMapCreateMap.putArray(FirebaseAnalytics.Param.DESTINATION, writableArrayCreateArray2);
        writableMapCreateMap.putArray("middleWayPoints", Arguments.createArray());
        writableMapCreateMap.putBoolean("skippedDueToNativeNav", z);
        return writableMapCreateMap;
    }

    private List<double[]> decodePolyline(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    i = i3 + 1;
                    int iCharAt = str.charAt(i3) - '?';
                    i6 |= (iCharAt & 31) << i7;
                    i7 += 5;
                    if (iCharAt < 32) {
                        break;
                    }
                    i3 = i;
                }
                int i8 = ((i6 & 1) != 0 ? ~(i6 >> 1) : i6 >> 1) + i4;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    i2 = i + 1;
                    int iCharAt2 = str.charAt(i) - '?';
                    i9 |= (iCharAt2 & 31) << i10;
                    i10 += 5;
                    if (iCharAt2 < 32) {
                        break;
                    }
                    i = i2;
                }
                int i11 = i9 & 1;
                int i12 = i9 >> 1;
                if (i11 != 0) {
                    i12 = ~i12;
                }
                i5 += i12;
                arrayList.add(new double[]{((double) i8) / 100000.0d, ((double) i5) / 100000.0d});
                i4 = i8;
                i3 = i2;
            }
        }
        return arrayList;
    }

    private String[] maneuverToTypeModifier(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return new String[]{"turn", instructionToModifier(str2)};
        }
        String upperCase = str.toUpperCase();
        if (upperCase.contains("TURN_SHARP_LEFT") || upperCase.contains("turn-sharp-left")) {
            return new String[]{"turn", "sharp left"};
        }
        if (upperCase.contains("TURN_SHARP_RIGHT") || upperCase.contains("turn-sharp-right")) {
            return new String[]{"turn", "sharp right"};
        }
        if (upperCase.contains("TURN_SLIGHT_LEFT") || upperCase.contains("turn-slight-left")) {
            return new String[]{"turn", "slight left"};
        }
        if (upperCase.contains("TURN_SLIGHT_RIGHT") || upperCase.contains("turn-slight-right")) {
            return new String[]{"turn", "slight right"};
        }
        if (upperCase.contains("TURN_LEFT") || upperCase.contains("turn-left")) {
            return new String[]{"turn", "left"};
        }
        if (upperCase.contains("TURN_RIGHT") || upperCase.contains("turn-right")) {
            return new String[]{"turn", "right"};
        }
        if (upperCase.contains("UTURN") || upperCase.contains("U_TURN") || upperCase.contains("u-turn")) {
            return new String[]{"turn", "uturn"};
        }
        if (upperCase.contains("KEEP_LEFT") || upperCase.contains("keep-left") || upperCase.contains("RAMP_LEFT") || upperCase.contains("ramp-left")) {
            return new String[]{"turn", "slight left"};
        }
        if (upperCase.contains("KEEP_RIGHT") || upperCase.contains("keep-right") || upperCase.contains("RAMP_RIGHT") || upperCase.contains("ramp-right")) {
            return new String[]{"turn", "slight right"};
        }
        if (upperCase.contains("MERGE") || upperCase.contains("merge")) {
            return new String[]{"turn", "straight"};
        }
        if (upperCase.contains("ROUNDABOUT") || upperCase.contains("roundabout")) {
            return new String[]{"roundabout", "straight"};
        }
        if (upperCase.contains("FORK_LEFT") || upperCase.contains("fork-left")) {
            return new String[]{"fork", "left"};
        }
        if (upperCase.contains("FORK_RIGHT") || upperCase.contains("fork-right")) {
            return new String[]{"fork", "right"};
        }
        return new String[]{"turn", "straight"};
    }

    private String instructionToModifier(String str) {
        if (str == null || str.isEmpty()) {
            return "straight";
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("sharp") && lowerCase.contains("left")) {
            return "sharp left";
        }
        if (lowerCase.contains("sharp") && lowerCase.contains("right")) {
            return "sharp right";
        }
        if (lowerCase.contains("turn left")) {
            return "left";
        }
        if (lowerCase.contains("turn right")) {
            return "right";
        }
        if (lowerCase.contains("slight left")) {
            return "slight left";
        }
        if (lowerCase.contains("slight right")) {
            return "slight right";
        }
        if (lowerCase.contains("u-turn") || lowerCase.contains("u turn")) {
            return "uturn";
        }
        if (lowerCase.contains("keep left")) {
            return "slight left";
        }
        if (!lowerCase.contains("keep right")) {
            return "straight";
        }
        return "slight right";
    }
}
