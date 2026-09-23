package com.bajajconnect;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.iface.IStopSession;
import com.mappls.sdk.navigation.iface.OnAuthentication;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MyCustomModule extends ReactContextBaseJavaModule {
    private static final int CUSTOM_ACTIVITY_REQUEST_CODE = 1;
    private final ActivityEventListener mActivityEventListener;
    private final ReactApplicationContext reactContext;

    public MyCustomModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() { // from class: com.bajajconnect.MyCustomModule.1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            }
        };
        this.mActivityEventListener = baseActivityEventListener;
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(baseActivityEventListener);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "MyCustomModule";
    }

    @ReactMethod
    public void startNavigation(final ReadableMap readableMap, final Boolean bool, final String str, final Promise promise) {
        try {
            ReadableMap map = readableMap.getMap("directionsResponse");
            int i = readableMap.getInt("selectedIndex");
            readableMap.getMap("directionsResponse").getArray("waypoints");
            ArrayList arrayList = new ArrayList();
            MapplsNavigationHelper.getInstance().startNavigation(DirectionsResponse.fromJson(new JSONObject(map.toHashMap()).toString()), i, convertToLatLng(readableMap.getMap("directionsResponse").getArray("waypoints").getMap(0).getArray(FirebaseAnalytics.Param.LOCATION)), convertReadableMapToWaypoint(readableMap.getMap("directionsResponse").getArray("waypoints").getMap(1)), arrayList, new OnAuthentication() { // from class: com.bajajconnect.MyCustomModule.2
                @Override // com.mappls.sdk.navigation.iface.OnAuthentication
                public void onSuccess() {
                    promise.resolve("true");
                }

                @Override // com.mappls.sdk.navigation.iface.OnAuthentication
                public void onFailure(int i2, String str2, Throwable th) {
                    if (i2 == 409) {
                        MapplsNavigationHelper.getInstance().deleteSession(str, new IStopSession() { // from class: com.bajajconnect.MyCustomModule.2.1
                            @Override // com.mappls.sdk.navigation.iface.IStopSession
                            public void onSuccess() {
                                MyCustomModule.this.startNavigation(readableMap, bool, str, promise);
                            }

                            @Override // com.mappls.sdk.navigation.iface.IStopSession
                            public void onFailure() {
                                promise.resolve("false");
                            }
                        });
                    } else {
                        promise.resolve("false");
                    }
                }
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public LatLng convertToLatLng(ReadableArray readableArray) {
        return new LatLng(readableArray.getDouble(1), readableArray.getDouble(0));
    }

    public WayPoint convertReadableMapToWaypoint(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray(FirebaseAnalytics.Param.LOCATION);
        return new WayPoint(array.getDouble(1), array.getDouble(0), readableMap.getString("name"));
    }

    public List<WayPoint> convertReadableArrayToListOfWaypoints(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(convertReadableMapToWaypoint(readableArray.getMap(i)));
        }
        return arrayList;
    }

    @ReactMethod
    public void openNativeActivity() {
        this.reactContext.startActivityForResult(new Intent(this.reactContext, (Class<?>) NavigationUiActivity.class), 1, null);
    }
}
