package com.bajajconnect.navigation;

import android.bluetooth.BluetoothManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bajajconnect.MainActivity;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.ble.BluetoothLeService;
import com.bajajconnect.enums.VehicleFaults;
import com.bajajconnect.features.SkuFeatureGate;
import com.bajajconnect.features.SkuFeatureRegistry;
import com.bajajconnect.features.VehicleFeature;
import com.bajajconnect.gMaps.GoogleNavSdkGate;
import com.bajajconnect.gMaps.NavigationActivity;
import com.bajajconnect.interfaces.BleConnectionCallback;
import com.bajajconnect.interfaces.SelectRideConnectAppSong;
import com.bajajconnect.music.MediaSessionListener;
import com.bajajconnect.music.MusicCallbackImpl;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.util.ScreenshotUtil;
import com.bajajconnect.utils.Util;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.NetworkRequestImpl;
import com.bajajconnect.wifi.Screens;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.bajajconnect.wifi.interfaces.RNEmiiterCallback;
import com.bajajconnect.wifi.navv2.NavV2Models;
import com.bajajconnect.wifi.navv2.NavigationProtocolV2Handler;
import com.bajajconnect.wifi.navv2.NavigationProtocolV2SelfTest;
import com.bajajconnect.wifi.navv2.NavigationRecentTripsStore;
import com.bajajconnect.wifi.tftEnums.TftAddress;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.gms.common.Scopes;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.maps.android.BuildConfig;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationManager extends ReactContextBaseJavaModule implements BleConnectionCallback, SelectRideConnectAppSong, RNEmiiterCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static MusicCallbackImpl callback;
    private static final ExecutorService documentExecutor = Executors.newSingleThreadExecutor();
    ConnectivityManager m;
    ConnectivityManager.NetworkCallback networkCallback;
    NetworkRequestImpl networkRequest1;
    private PowerManager powerManager;
    private Promise promise;
    private final ReactApplicationContext reactContext;
    private Runnable runnable;
    private PowerManager.WakeLock wakeLock;
    private WifiManager.WifiLock wifiLock;
    private WifiManager wifiManager;

    @ReactMethod
    public void callNativeApiMethod(Promise promise) {
    }

    @Override // com.bajajconnect.wifi.interfaces.RNEmiiterCallback
    public void onBluetoothStatusChanged(boolean z) {
    }

    @Override // com.bajajconnect.wifi.interfaces.RNEmiiterCallback
    public void onWifiStatusChanged(boolean z) {
    }

    @Override // com.bajajconnect.interfaces.SelectRideConnectAppSong
    public void onSongSelect(int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("song", i);
        sendEvent("PLAY_SONG", writableMapCreateMap);
    }

    NavigationManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.runnable = new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (NavApplication.streamingHandler.isTcpInitialised && NavApplication.streamingHandler.isUdpInitialised) {
                    Util.createNetworkRouteMobile(NavigationManager.this.reactContext);
                }
            }
        };
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.bajajconnect.navigation.NavigationManager.5
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NavigationManager.this.createNetworkRouteMobile();
                if (MirroringGlobarVar.isWifiConnected) {
                    return;
                }
                Log.e("NavigationManager", "wifi connected bb");
                MirroringGlobarVar.isWifiConnected = true;
                MirroringGlobarVar.network = network;
                NavigationManager.this.emitInfoWifi(true);
                NavigationManager.this.acquireLocks();
                if (!MirroringPolicy.deferMirroringUntilNavigation()) {
                    NavigationManager.this.startWifiMirroring();
                    return;
                }
                MirroringGlobarVar.isOnMirroringPage = false;
                MirroringGlobarVar.currentScreen = Screens.NONE;
                MirroringPolicy.startTcpSyncOnWifiConnect(NavigationManager.this.reactContext);
                Log.d("NavigationManager", "WiFi connected; TCP/doc sync started, screen mirroring deferred until navigation");
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                super.onLosing(network, i);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                Log.e("Navigation", "wifi lost");
                if (MirroringGlobarVar.isWifiConnected) {
                    Log.e("Navigation", "wifi disconnected");
                    NavigationManager.this.emitInfoWifi(false);
                }
                MirroringGlobarVar.isWifiConnected = false;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
                Log.e("Navigation", "wifi unavailable");
                if (MirroringGlobarVar.isWifiConnected) {
                    Log.e("Navigation", "wifi disconnected");
                    NavigationManager.this.emitInfoWifi(false);
                }
                MirroringGlobarVar.isWifiConnected = false;
            }
        };
        this.reactContext = reactApplicationContext;
        GlobalVar.hydrateAppThemeFromPrefs(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNNavigationManager";
    }

    private boolean isAppNavigationEnabledForCurrentSku() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.APP_NAVIGATION.isEnabledFor(str);
    }

    private boolean isWifiEnabledForCurrentSku() {
        String str = BleFeatures.getInstance().modelCode;
        return !VehicleFeature.BLE_GENERAL_PACKET_V2.isEnabledFor(str) || VehicleFeature.WIFI_CLUSTER_CONNECT.isEnabledFor(str);
    }

    @ReactMethod
    public void stopNavigationMirroring() {
        MirroringPolicy.stopMirroringAfterNavigation(getReactApplicationContext(), "RNNavigationManager.stopNavigationMirroring");
    }

    @ReactMethod
    public void startWifiMirroring() {
        if (!isWifiEnabledForCurrentSku()) {
            Log.i("NavigationManager", "startWifiMirroring skipped — SKU has no WiFi capability");
        } else if (MirroringPolicy.deferMirroringUntilNavigation()) {
            Log.d("NavigationManager", "startWifiMirroring skipped — deferred until native route preview");
        } else {
            NavApplication.streamingHandler.initWifiServers();
            startHandler();
        }
    }

    @ReactMethod
    public void setVin(String str) {
        GlobalVar.vehcileVin = str;
        GlobalVar.wifiPassword = MainActivity.getSecretKey2(this.reactContext, str);
    }

    private void startHandler() {
        new Handler(Looper.getMainLooper()).postDelayed(this.runnable, 1000L);
    }

    @ReactMethod
    public void setAppThemeIsDark(boolean z) {
        GlobalVar.setAppThemeIsDark(this.reactContext, z);
        Log.i("NavigationManager", "setAppThemeIsDark=" + z);
    }

    @ReactMethod
    public void startNavigationActivity(Double d, Double d2, String str, String str2) {
        if (!isAppNavigationEnabledForCurrentSku()) {
            Log.i("NavigationManager", "startNavigationActivity skipped — SKU has no navigation capability");
            return;
        }
        try {
            GlobalVar.lat = d;
            GlobalVar.lng = d2;
            GoogleNavSdkGate.setNavigationActivityOwnsNavigator(true);
            ELocation eLocation = new ELocation();
            eLocation.placeName = str;
            eLocation.placeAddress = str2;
            NavApplication.eLocation = eLocation;
            this.reactContext.getApplicationContext().startActivity(NavigationActivity.createLaunchIntent(this.reactContext.getApplicationContext()));
        } catch (Exception e) {
            GoogleNavSdkGate.setNavigationActivityOwnsNavigator(false);
            e.printStackTrace();
            Toast.makeText(this.reactContext, "Something went wrong", 0).show();
        }
    }

    @ReactMethod
    public void startNavigationActivityMMI(String str, String str2, String str3) {
        if (!isAppNavigationEnabledForCurrentSku()) {
            Log.i("NavigationManager", "startNavigationActivityMMI skipped — SKU has no navigation capability");
            return;
        }
        try {
            if (GlobalVar.waypoints == null) {
                GlobalVar.waypoints = new ArrayList();
            } else {
                GlobalVar.waypoints.clear();
            }
            GlobalVar.mapplsPin = str;
            ELocation eLocation = new ELocation();
            eLocation.mapplsPin = str;
            eLocation.placeName = str2;
            eLocation.placeAddress = str3;
            NavApplication.eLocation = eLocation;
            Intent intent = new Intent(this.reactContext, (Class<?>) HomeActivity.class);
            intent.addFlags(268435456);
            this.reactContext.getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.reactContext, "Something went wrong", 0).show();
        }
    }

    @ReactMethod
    public void createNetworkRouteMobile() {
        MirroringPolicy.ensureCellularNetworkForRouting(this.reactContext);
    }

    @ReactMethod
    public void navigateToPoint(Double d, Double d2, String str) {
        if (!isAppNavigationEnabledForCurrentSku()) {
            Log.i("NavigationManager", "navigateToPoint skipped — SKU has no navigation capability");
            return;
        }
        if (d != null && d2 != null) {
            try {
                if (d.doubleValue() != 0.0d || d2.doubleValue() != 0.0d) {
                    GlobalVar.lat = d;
                    GlobalVar.lng = d2;
                }
            } catch (Exception unused) {
                Toast.makeText(this.reactContext, "Something went wrong", 0).show();
                return;
            }
        }
        ELocation eLocation = new ELocation();
        eLocation.latitude = d;
        eLocation.longitude = d2;
        eLocation.placeName = str;
        NavApplication.eLocation = eLocation;
        Intent intent = new Intent(this.reactContext, (Class<?>) HomeActivity.class);
        intent.addFlags(268435456);
        this.reactContext.getApplicationContext().startActivity(intent);
    }

    @ReactMethod
    public void clearData() {
        if (GlobalVar.waypoints != null) {
            GlobalVar.waypoints.clear();
        }
        GlobalVar.waypoints = new ArrayList();
    }

    @ReactMethod
    public void yourMethod(String str, String str2, String str3) {
        try {
            ELocation eLocation = new ELocation();
            eLocation.mapplsPin = str;
            eLocation.placeName = str2;
            eLocation.placeAddress = str3;
            GlobalVar.waypoints.add(eLocation);
        } catch (Exception e) {
            Log.e("NavigationManager", e.toString());
        }
    }

    @ReactMethod
    public void startBle() {
        BleFeatures.getInstance().registerBleCallback(this);
        BleFeatures.getInstance().init(this.reactContext.getApplicationContext());
        BleFeatures.getInstance().rnEmiiterCallback = this;
        callback = new MusicCallbackImpl();
    }

    @ReactMethod
    public void startMusicListening(boolean z) {
        if (z) {
            BleFeatures.getInstance().listenMusic(this.reactContext.getApplicationContext(), callback);
        } else {
            BleFeatures.getInstance().stopMusicListening();
        }
    }

    @ReactMethod
    public void stopBle() {
        BleFeatures.getInstance().stop(this.reactContext.getApplicationContext());
    }

    @ReactMethod
    public void listenMusic() {
        BleFeatures.getInstance().listenMusic(this.reactContext.getApplicationContext(), new MusicCallbackImpl());
    }

    @ReactMethod
    public void setBleName(String str) {
        BleFeatures.getInstance().setBleDeviceName(str);
        emitInfoWifi(MirroringGlobarVar.connectedWifiName.equals(str));
    }

    public void getReverseGeoCode(final LatLng latLng) {
        MapplsReverseGeoCodeManager.newInstance(MapplsReverseGeoCode.builder().setLocation(latLng.getLatitude(), latLng.getLongitude()).build()).call(new OnResponseCallback<PlaceResponse>() { // from class: com.bajajconnect.navigation.NavigationManager.2
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(PlaceResponse placeResponse) {
                if (placeResponse != null) {
                    Place place = placeResponse.getPlaces().get(0);
                    ELocation eLocation = new ELocation();
                    eLocation.entryLongitude = Double.valueOf(latLng.getLongitude());
                    eLocation.longitude = Double.valueOf(latLng.getLongitude());
                    eLocation.entryLatitude = Double.valueOf(latLng.getLatitude());
                    eLocation.latitude = Double.valueOf(latLng.getLatitude());
                    eLocation.placeName = place.getFormattedAddress();
                    eLocation.placeAddress = NavigationManager.this.reactContext.getString(R.string.point_on_map);
                    GlobalVar.waypoints.add(eLocation);
                }
            }
        });
    }

    @ReactMethod
    public void isNotificationEnabled(Promise promise) {
        promise.resolve(Boolean.valueOf(MediaSessionListener.isNotificationListenerEnabled(this.reactContext.getApplicationContext())));
    }

    @ReactMethod
    public void goToNotificationAccessSettings(final Promise promise) {
        MainActivity mainActivity = (MainActivity) getReactApplicationContext().getCurrentActivity();
        mainActivity.onActivityResultImplementation = new OnActivityResultImplementation() { // from class: com.bajajconnect.navigation.NavigationManager$$ExternalSyntheticLambda1
            @Override // com.bajajconnect.navigation.OnActivityResultImplementation
            public final Object execute(Object obj) {
                return NavigationManager.lambda$goToNotificationAccessSettings$0(promise, obj);
            }
        };
        mainActivity.mStartForResult.launch(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    static /* synthetic */ Object lambda$goToNotificationAccessSettings$0(Promise promise, Object obj) {
        int resultCode = ((ActivityResult) obj).getResultCode();
        if (resultCode == -1) {
            promise.resolve(true);
            return null;
        }
        if (resultCode == 0) {
            promise.resolve(false);
            return null;
        }
        promise.resolve(false);
        return null;
    }

    @ReactMethod
    public void shareScreenShot() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$shareScreenShot$1();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareScreenShot$1() {
        File fileStore;
        Bitmap bitmapTakeS = ScreenshotUtil.takeS(getCurrentActivity());
        if (bitmapTakeS == null || (fileStore = ScreenshotUtil.store(this.reactContext.getApplicationContext(), bitmapTakeS, "moneySaved")) == null) {
            return;
        }
        ScreenshotUtil.shareImage(fileStore, this.reactContext.getCurrentActivity());
    }

    @ReactMethod
    public void setCallrejectMsg(String str) {
        GlobalVar.callRejectMsg = str;
    }

    public void emitInfo(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("name", "dooley-doo");
        writableMapCreateMap.putInt("version", 16);
        writableMapCreateMap.putBoolean("isConnected", z);
        sendEvent("INFO_EVENT", writableMapCreateMap);
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @Override // com.bajajconnect.interfaces.BleConnectionCallback
    public void onStateChange(boolean z) {
        emitInfo(z);
        Promise promise = this.promise;
        if (promise != null) {
            promise.resolve(Boolean.valueOf(z));
        }
    }

    @Override // com.bajajconnect.interfaces.BleConnectionCallback
    public void onScanning(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isScanning", z);
        sendEvent("SCANNING_EVENT", writableMapCreateMap);
    }

    @ReactMethod
    public void setTakeMeHomeAddress(String str, Double d, Double d2) {
        GlobalVar.takeMeHomeAddress = str;
        GlobalVar.takeMeHomeLat = d;
        GlobalVar.takeMeHomeLng = d2;
    }

    @ReactMethod
    public void setHomeAddress(String str, Double d, Double d2) {
        MirroringGlobarVar.homeAddress = new TftAddress(str, d, d2);
    }

    @ReactMethod
    public void setWorkAddress(String str, Double d, Double d2) {
        MirroringGlobarVar.workAddress = new TftAddress(str, d, d2);
    }

    @ReactMethod
    public void setFavAddress(String str, Double d, Double d2) {
        MirroringGlobarVar.favAddress = new TftAddress(str, d, d2);
    }

    @ReactMethod
    public void syncSavedLocationsForCluster(String str) {
        String[] strArr;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        String str2;
        try {
            MirroringGlobarVar.homeAddress = null;
            MirroringGlobarVar.workAddress = null;
            MirroringGlobarVar.favAddress = null;
            if (str != null && !str.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject(str);
                String[] strArr2 = {"home", "work", "favorite"};
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < 3) {
                    String str3 = strArr2[i];
                    if (!jSONObject2.has(str3) || jSONObject2.isNull(str3) || (jSONObjectOptJSONObject = jSONObject2.optJSONObject(str3)) == null) {
                        strArr = strArr2;
                        jSONObject = jSONObject2;
                    } else {
                        String strOptString = jSONObjectOptJSONObject.optString("placeAddress", jSONObjectOptJSONObject.optString("placeName", ""));
                        if (!strOptString.trim().isEmpty()) {
                            if ("home".equals(str3)) {
                                str2 = "Home";
                            } else {
                                str2 = "work".equals(str3) ? "Work" : "Favorite";
                            }
                            String str4 = str2;
                            double dOptDouble = jSONObjectOptJSONObject.optDouble("latitude", 0.0d);
                            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("longitude", 0.0d);
                            if (dOptDouble == 0.0d && dOptDouble2 == 0.0d) {
                                Log.w("NavigationManager", "skip saved location without coords key=" + str3);
                            } else {
                                strArr = strArr2;
                                jSONObject = jSONObject2;
                                arrayList.add(new NavV2Models.IndexedPlace(i, str4, dOptDouble, dOptDouble2, strOptString));
                                if ("home".equals(str3)) {
                                    setHomeAddress(strOptString, Double.valueOf(dOptDouble), Double.valueOf(dOptDouble2));
                                } else if ("work".equals(str3)) {
                                    setWorkAddress(strOptString, Double.valueOf(dOptDouble), Double.valueOf(dOptDouble2));
                                } else {
                                    setFavAddress(strOptString, Double.valueOf(dOptDouble), Double.valueOf(dOptDouble2));
                                }
                            }
                        }
                        strArr = strArr2;
                        jSONObject = jSONObject2;
                    }
                    i++;
                    strArr2 = strArr;
                    jSONObject2 = jSONObject;
                }
                NavigationProtocolV2Handler.getInstance().syncFavouritesFromBridge(arrayList);
                return;
            }
            NavigationProtocolV2Handler.getInstance().syncFavouritesFromBridge(new ArrayList());
        } catch (Exception e) {
            Log.w("NavigationManager", "syncSavedLocationsForCluster failed", e);
        }
    }

    @ReactMethod
    public void syncRecentTripsForCluster(String str) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length() && arrayList.size() < 5; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("name", "");
                        if (!strOptString.trim().isEmpty()) {
                            arrayList.add(new NavV2Models.IndexedPlace(arrayList.size(), strOptString, jSONObjectOptJSONObject.optDouble("latitude", 0.0d), jSONObjectOptJSONObject.optDouble("longitude", 0.0d), jSONObjectOptJSONObject.optString(PlaceTypes.ADDRESS, strOptString)));
                        }
                    }
                }
                NavigationRecentTripsStore.importTripsFromBridge(getReactApplicationContext(), arrayList);
            } catch (Exception e) {
                Log.w("NavigationManager", "syncRecentTripsForCluster failed", e);
            }
        }
    }

    @ReactMethod
    public void runNavV2PoiSelfTest(boolean z, final Promise promise) {
        NavigationProtocolV2SelfTest.runPoiFlow(getReactApplicationContext(), z, new NavigationProtocolV2SelfTest.ResultCallback() { // from class: com.bajajconnect.navigation.NavigationManager$$ExternalSyntheticLambda0
            @Override // com.bajajconnect.wifi.navv2.NavigationProtocolV2SelfTest.ResultCallback
            public final void onComplete(JSONObject jSONObject) {
                promise.resolve(jSONObject.toString());
            }
        });
    }

    @ReactMethod
    public void disconnect() {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BluetoothLeService.class);
        intent.setAction("com.bajajconnect.ble.ACTION_BLE_DISCONNECT");
        getReactApplicationContext().startService(intent);
    }

    @ReactMethod
    public void connectToBle() {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BluetoothLeService.class);
        intent.setAction("com.bajajconnect.ble.ACTION_BLE_CONNECT");
        getReactApplicationContext().startService(intent);
    }

    @ReactMethod
    public void startForeground() {
        if (NavApplication.isForeground) {
            startForgroundService();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager.3
                @Override // java.lang.Runnable
                public void run() {
                    NavigationManager.this.startForeground();
                }
            }, 5000L);
        }
    }

    public void startForgroundService() {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BleService.class);
        intent.setAction(BleService.ACTION_START_FOREGROUND);
        if (Build.VERSION.SDK_INT >= 26) {
            getReactApplicationContext().startForegroundService(intent);
        } else {
            getReactApplicationContext().startService(intent);
        }
    }

    @ReactMethod
    public void setBirthday(String str, String str2) {
        try {
            GlobalVar.birthdayDay = Integer.parseInt(str);
            GlobalVar.birthdayMonth = Integer.parseInt(str2);
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void isConnected(Callback callback2) {
        callback2.invoke(Boolean.valueOf(GlobalVar.isBlueToothConnected));
    }

    @ReactMethod
    public void setTotalTime(int i) {
        GlobalVar.inbuiltMusicTotalDuration = i;
    }

    @ReactMethod
    public boolean checkStartPermissionRequest() {
        if (Settings.canDrawOverlays(getReactApplicationContext())) {
            return true;
        }
        this.reactContext.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.reactContext.getPackageName())), PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE, null);
        return false;
    }

    @ReactMethod
    public void checkIfDrawOverAppEnabled(Callback callback2) {
        callback2.invoke(Boolean.valueOf(Settings.canDrawOverlays(getReactApplicationContext())));
    }

    @ReactMethod
    public void isBluetoothEnabled(Callback callback2) {
        callback2.invoke(Boolean.valueOf(((BluetoothManager) this.reactContext.getSystemService("bluetooth")).getAdapter().isEnabled()));
    }

    @ReactMethod
    public void enableBluetooth() {
        try {
            ((BluetoothManager) this.reactContext.getSystemService("bluetooth")).getAdapter().enable();
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void isSpotifyInstalled(Callback callback2) {
        callback2.invoke(Boolean.valueOf(SpotifyAppRemote.isSpotifyInstalled(this.reactContext)));
    }

    @ReactMethod
    public void connectToSpotifyRemote() {
        MainActivity mainActivity = (MainActivity) getCurrentActivity();
        if (mainActivity != null) {
            mainActivity.lambda$onConnect$1();
        }
    }

    @ReactMethod
    public void connectToSpotifyWebAPI() {
    }

    @ReactMethod
    public void checkSpotifyAuthState(Callback callback2) {
        MainActivity mainActivity = (MainActivity) getCurrentActivity();
        if (mainActivity != null) {
            callback2.invoke(Boolean.valueOf(mainActivity.getSpotifyState()));
        } else {
            callback2.invoke(true);
        }
    }

    @ReactMethod
    public void setModelCode(String str) {
        String strNormalizeSku = SkuFeatureGate.normalizeSku(str);
        BleFeatures.getInstance().setModelCode(strNormalizeSku);
        GlobalVar.isGoogleNavigation = VehicleFeature.MAP_GOOGLE_NAV.isEnabledFor(strNormalizeSku);
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(GlobalVar.isGoogleNavigation ? NavigationActivity.class : HomeActivity.class);
    }

    @ReactMethod
    public void setSkuCohorts(ReadableArray readableArray, ReadableArray readableArray2) {
        SkuFeatureRegistry.setCohortSkus(SkuFeatureRegistry.COHORT_CLUSTER_V1, readableArrayToSkuList(readableArray));
        SkuFeatureRegistry.setCohortSkus(SkuFeatureRegistry.COHORT_BLE_ONLY_GENERAL_V2, readableArrayToSkuList(readableArray2));
        String str = BleFeatures.getInstance().modelCode;
        if (str == null || str.isEmpty()) {
            return;
        }
        GlobalVar.isGoogleNavigation = VehicleFeature.MAP_GOOGLE_NAV.isEnabledFor(str);
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(GlobalVar.isGoogleNavigation ? NavigationActivity.class : HomeActivity.class);
    }

    private static List<String> readableArrayToSkuList(ReadableArray readableArray) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (readableArray == null) {
            return arrayList;
        }
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.String && (string = readableArray.getString(i)) != null && !string.trim().isEmpty()) {
                arrayList.add(string.trim());
            }
        }
        return arrayList;
    }

    @ReactMethod
    public void isNewFeaturesSkuEnabled(Promise promise) {
        promise.resolve(Boolean.valueOf(VehicleFeature.WIFI_CLUSTER_CONNECT.isEnabledFor(BleFeatures.getInstance().modelCode)));
    }

    @ReactMethod
    public void isVehicleFeatureEnabled(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(SkuFeatureRegistry.isEnabled(str, BleFeatures.getInstance().modelCode)));
    }

    @ReactMethod
    public void setCurrentPack(String str) {
        BleFeatures.getInstance().setCurrentPack(str);
    }

    @ReactMethod
    public void compressImage(final String str, final Promise promise) {
        new Thread(new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$compressImage$3(str, promise);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b A[Catch: Exception -> 0x0234, TryCatch #1 {Exception -> 0x0234, blocks: (B:3:0x0012, B:5:0x001a, B:7:0x0022, B:9:0x002b, B:11:0x003d, B:13:0x0057, B:15:0x0060, B:17:0x006a, B:42:0x00eb, B:46:0x0108, B:47:0x011d, B:49:0x012b, B:50:0x012e, B:51:0x013a, B:55:0x0147, B:56:0x0152, B:58:0x0162, B:61:0x0175, B:63:0x0192, B:64:0x0195, B:65:0x01a1, B:41:0x00d8, B:20:0x007e, B:31:0x00a6, B:36:0x00bf, B:38:0x00d2, B:32:0x00ac, B:33:0x00b2, B:34:0x00b6, B:35:0x00bc), top: B:77:0x0012, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0143  */
    /* JADX WARN: Code duplicated, block: B:63:0x0192 A[Catch: Exception -> 0x0234, TryCatch #1 {Exception -> 0x0234, blocks: (B:3:0x0012, B:5:0x001a, B:7:0x0022, B:9:0x002b, B:11:0x003d, B:13:0x0057, B:15:0x0060, B:17:0x006a, B:42:0x00eb, B:46:0x0108, B:47:0x011d, B:49:0x012b, B:50:0x012e, B:51:0x013a, B:55:0x0147, B:56:0x0152, B:58:0x0162, B:61:0x0175, B:63:0x0192, B:64:0x0195, B:65:0x01a1, B:41:0x00d8, B:20:0x007e, B:31:0x00a6, B:36:0x00bf, B:38:0x00d2, B:32:0x00ac, B:33:0x00b2, B:34:0x00b6, B:35:0x00bc), top: B:77:0x0012, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x013a A[SYNTHETIC] */
    public /* synthetic */ void lambda$compressImage$3(String str, Promise promise) {
        int width;
        int height;
        int iMin;
        Bitmap bitmapCreateScaledBitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        int iMax;
        int width2;
        int height2;
        Bitmap bitmapCreateScaledBitmap2;
        try {
            File file = new File(str.startsWith("file://") ? str.replace("file://", "") : str);
            if (!file.exists()) {
                promise.reject("FILE_NOT_FOUND", "Source file does not exist: " + str);
                return;
            }
            long length = file.length();
            Log.e("NavigationManager", "compressImage: input size=" + length);
            if (length <= 400000) {
                Log.e("NavigationManager", "compressImage: file already under 400KB, skipping");
                promise.resolve(str);
                return;
            }
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bitmapDecodeFile == null) {
                promise.reject("DECODE_FAILED", "Failed to decode image: " + str);
                return;
            }
            try {
                int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                Matrix matrix = new Matrix();
                try {
                    if (attributeInt == 2) {
                        matrix.postScale(-1.0f, 1.0f);
                    } else if (attributeInt == 3) {
                        matrix.postRotate(180.0f);
                    } else if (attributeInt == 4) {
                        matrix.postScale(1.0f, -1.0f);
                    } else {
                        if (attributeInt != 6) {
                            if (attributeInt == 8) {
                                matrix.postRotate(270.0f);
                            }
                            width = bitmapDecodeFile.getWidth();
                            height = bitmapDecodeFile.getHeight();
                            iMin = Math.min(width, height);
                            if (iMin > 1440) {
                                float f = 1440.0f / iMin;
                                width = (int) (width * f);
                                height = (int) (height * f);
                                Log.e("NavigationManager", "compressImage: downscaled to " + width + "x" + height);
                            }
                            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, Math.max(2, width), Math.max(2, height), true);
                            if (bitmapCreateScaledBitmap != bitmapDecodeFile) {
                                bitmapDecodeFile.recycle();
                            }
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            iMax = 92;
                            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 92, byteArrayOutputStream);
                            while (byteArrayOutputStream.size() > 400000) {
                                if (iMax > 58) {
                                    iMax -= 4;
                                    byteArrayOutputStream.reset();
                                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iMax, byteArrayOutputStream);
                                } else {
                                    width2 = bitmapCreateScaledBitmap.getWidth();
                                    height2 = bitmapCreateScaledBitmap.getHeight();
                                    if (Math.min(width2, height2) <= 720) {
                                        iMax = Math.max(50, iMax - 2);
                                        byteArrayOutputStream.reset();
                                        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iMax, byteArrayOutputStream);
                                        if (iMax <= 50) {
                                            break;
                                        }
                                    } else {
                                        bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, Math.max(2, Math.round(width2 * 0.9f)), Math.max(2, Math.round(height2 * 0.9f)), true);
                                        if (bitmapCreateScaledBitmap2 != bitmapCreateScaledBitmap) {
                                            bitmapCreateScaledBitmap.recycle();
                                        }
                                        byteArrayOutputStream.reset();
                                        iMax = 90;
                                        bitmapCreateScaledBitmap2.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                                        bitmapCreateScaledBitmap = bitmapCreateScaledBitmap2;
                                    }
                                }
                            }
                            Log.e("NavigationManager", "compressImage: output quality=" + iMax + " size=" + byteArrayOutputStream.size() + " dims=" + bitmapCreateScaledBitmap.getWidth() + "x" + bitmapCreateScaledBitmap.getHeight());
                            File file2 = new File(this.reactContext.getCacheDir(), "compressed_" + System.currentTimeMillis() + ".jpg");
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            fileOutputStream.write(byteArrayOutputStream.toByteArray());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            bitmapCreateScaledBitmap.recycle();
                            byteArrayOutputStream.close();
                            String absolutePath = file2.getAbsolutePath();
                            Log.e("NavigationManager", "compressImage: compressed to " + absolutePath);
                            promise.resolve(absolutePath);
                            return;
                        }
                        matrix.postRotate(90.0f);
                    }
                    File file3 = new File(this.reactContext.getCacheDir(), "compressed_" + System.currentTimeMillis() + ".jpg");
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    bitmapCreateScaledBitmap.recycle();
                    byteArrayOutputStream.close();
                    String absolutePath2 = file3.getAbsolutePath();
                    Log.e("NavigationManager", "compressImage: compressed to " + absolutePath2);
                    promise.resolve(absolutePath2);
                    return;
                } catch (Exception e) {
                    e = e;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                if (bitmapCreateBitmap != bitmapDecodeFile) {
                    bitmapDecodeFile.recycle();
                    bitmapDecodeFile = bitmapCreateBitmap;
                }
            } catch (Exception e2) {
                Log.e("NavigationManager", "compressImage: failed to apply EXIF orientation: " + e2.getMessage());
            }
            width = bitmapDecodeFile.getWidth();
            height = bitmapDecodeFile.getHeight();
            iMin = Math.min(width, height);
            if (iMin > 1440) {
                float f2 = 1440.0f / iMin;
                width = (int) (width * f2);
                height = (int) (height * f2);
                Log.e("NavigationManager", "compressImage: downscaled to " + width + "x" + height);
            }
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, Math.max(2, width), Math.max(2, height), true);
            if (bitmapCreateScaledBitmap != bitmapDecodeFile) {
                bitmapDecodeFile.recycle();
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            iMax = 92;
            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 92, byteArrayOutputStream);
            while (byteArrayOutputStream.size() > 400000) {
                if (iMax > 58) {
                    iMax -= 4;
                    byteArrayOutputStream.reset();
                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iMax, byteArrayOutputStream);
                } else {
                    width2 = bitmapCreateScaledBitmap.getWidth();
                    height2 = bitmapCreateScaledBitmap.getHeight();
                    if (Math.min(width2, height2) <= 720) {
                        iMax = Math.max(50, iMax - 2);
                        byteArrayOutputStream.reset();
                        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iMax, byteArrayOutputStream);
                        if (iMax <= 50) {
                            break;
                            break;
                        }
                    } else {
                        bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, Math.max(2, Math.round(width2 * 0.9f)), Math.max(2, Math.round(height2 * 0.9f)), true);
                        if (bitmapCreateScaledBitmap2 != bitmapCreateScaledBitmap) {
                            bitmapCreateScaledBitmap.recycle();
                        }
                        byteArrayOutputStream.reset();
                        iMax = 90;
                        bitmapCreateScaledBitmap2.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                        bitmapCreateScaledBitmap = bitmapCreateScaledBitmap2;
                    }
                }
            }
            Log.e("NavigationManager", "compressImage: output quality=" + iMax + " size=" + byteArrayOutputStream.size() + " dims=" + bitmapCreateScaledBitmap.getWidth() + "x" + bitmapCreateScaledBitmap.getHeight());
        } catch (Exception e3) {
            e = e3;
        }
        Log.e("NavigationManager", "compressImage error: " + e.getMessage());
        promise.reject("COMPRESS_ERROR", e.getMessage(), e);
    }

    @ReactMethod
    public void getDocuments(final String str, final String str2) {
        String str3 = BleFeatures.getInstance().modelCode;
        if (str3 != null && !str3.isEmpty() && !VehicleFeature.WIFI_DOCUMENTS_SYNC.isEnabledFor(str3)) {
            Log.w("NavigationManager", "getDocuments skipped: WIFI_DOCUMENTS_SYNC not enabled for SKU=" + str3);
            return;
        }
        documentExecutor.submit(new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager.4
            @Override // java.lang.Runnable
            public void run() {
                Log.e("NavigationManager", "getDocuments: START processing docType=" + str2 + " path=" + str);
                NavigationManager.this.loadDocumentImageNew(str, str2);
                StringBuilder sb = new StringBuilder("getDocuments: DONE processing docType=");
                sb.append(str2);
                Log.e("NavigationManager", sb.toString());
            }
        });
    }

    @ReactMethod
    public void processDocumentImageForStorageWithComposeRect(final String str, final String str2, final double d, final double d2, final double d3, final double d4, final double d5, final double d6, final double d7, final double d8, final Promise promise) {
        new Thread(new Runnable() { // from class: com.bajajconnect.navigation.NavigationManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$processDocumentImageForStorageWithComposeRect$4(str, promise, d, d2, d3, d4, d7, d8, d5, d6, str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:105:0x0244 A[Catch: Exception -> 0x0247, TRY_LEAVE, TryCatch #13 {Exception -> 0x0247, blocks: (B:103:0x023e, B:105:0x0244), top: B:139:0x023e }] */
    /* JADX WARN: Code duplicated, block: B:109:0x024f A[Catch: Exception -> 0x0252, TRY_LEAVE, TryCatch #8 {Exception -> 0x0252, blocks: (B:107:0x0249, B:109:0x024f), top: B:130:0x0249 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x003d A[Catch: all -> 0x0210, Exception -> 0x0213, TryCatch #15 {Exception -> 0x0213, all -> 0x0210, blocks: (B:4:0x0014, B:6:0x001a, B:7:0x0020, B:9:0x002b, B:11:0x003d, B:13:0x0047, B:15:0x004f), top: B:146:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0226 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0249 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0047 A[Catch: all -> 0x0210, Exception -> 0x0213, TryCatch #15 {Exception -> 0x0213, all -> 0x0210, blocks: (B:4:0x0014, B:6:0x001a, B:7:0x0020, B:9:0x002b, B:11:0x003d, B:13:0x0047, B:15:0x004f), top: B:146:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x004f A[Catch: all -> 0x0210, Exception -> 0x0213, TRY_LEAVE, TryCatch #15 {Exception -> 0x0213, all -> 0x0210, blocks: (B:4:0x0014, B:6:0x001a, B:7:0x0020, B:9:0x002b, B:11:0x003d, B:13:0x0047, B:15:0x004f), top: B:146:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d3 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #16 {Exception -> 0x020c, all -> 0x0208, blocks: (B:17:0x0059, B:18:0x005c, B:26:0x00be, B:32:0x0111, B:34:0x0123, B:44:0x0141, B:46:0x0156, B:48:0x015c, B:59:0x017c, B:63:0x0187, B:65:0x01b7, B:82:0x0207, B:81:0x0204, B:27:0x00d3, B:29:0x00fb, B:31:0x0102, B:30:0x0100), top: B:145:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00fb A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #16 {Exception -> 0x020c, all -> 0x0208, blocks: (B:17:0x0059, B:18:0x005c, B:26:0x00be, B:32:0x0111, B:34:0x0123, B:44:0x0141, B:46:0x0156, B:48:0x015c, B:59:0x017c, B:63:0x0187, B:65:0x01b7, B:82:0x0207, B:81:0x0204, B:27:0x00d3, B:29:0x00fb, B:31:0x0102, B:30:0x0100), top: B:145:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0100 A[Catch: all -> 0x0208, Exception -> 0x020c, TryCatch #16 {Exception -> 0x020c, all -> 0x0208, blocks: (B:17:0x0059, B:18:0x005c, B:26:0x00be, B:32:0x0111, B:34:0x0123, B:44:0x0141, B:46:0x0156, B:48:0x015c, B:59:0x017c, B:63:0x0187, B:65:0x01b7, B:82:0x0207, B:81:0x0204, B:27:0x00d3, B:29:0x00fb, B:31:0x0102, B:30:0x0100), top: B:145:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0123 A[Catch: all -> 0x0208, Exception -> 0x020c, TRY_LEAVE, TryCatch #16 {Exception -> 0x020c, all -> 0x0208, blocks: (B:17:0x0059, B:18:0x005c, B:26:0x00be, B:32:0x0111, B:34:0x0123, B:44:0x0141, B:46:0x0156, B:48:0x015c, B:59:0x017c, B:63:0x0187, B:65:0x01b7, B:82:0x0207, B:81:0x0204, B:27:0x00d3, B:29:0x00fb, B:31:0x0102, B:30:0x0100), top: B:145:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0132 A[Catch: Exception -> 0x0135, TRY_LEAVE, TryCatch #6 {Exception -> 0x0135, blocks: (B:36:0x012c, B:38:0x0132), top: B:128:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x013d A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #9 {Exception -> 0x0140, blocks: (B:40:0x0137, B:42:0x013d), top: B:132:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0141 A[Catch: all -> 0x0208, Exception -> 0x020c, TRY_ENTER, TryCatch #16 {Exception -> 0x020c, all -> 0x0208, blocks: (B:17:0x0059, B:18:0x005c, B:26:0x00be, B:32:0x0111, B:34:0x0123, B:44:0x0141, B:46:0x0156, B:48:0x015c, B:59:0x017c, B:63:0x0187, B:65:0x01b7, B:82:0x0207, B:81:0x0204, B:27:0x00d3, B:29:0x00fb, B:31:0x0102, B:30:0x0100), top: B:145:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0185  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ed A[Catch: Exception -> 0x01f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x01f0, blocks: (B:67:0x01e7, B:69:0x01ed), top: B:120:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01f2 A[Catch: Exception -> 0x023a, TRY_ENTER, TryCatch #11 {Exception -> 0x023a, blocks: (B:71:0x01f2, B:73:0x01f8, B:97:0x0231, B:99:0x0237), top: B:135:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01f8 A[Catch: Exception -> 0x023a, TRY_LEAVE, TryCatch #11 {Exception -> 0x023a, blocks: (B:71:0x01f2, B:73:0x01f8, B:97:0x0231, B:99:0x0237), top: B:135:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x022c A[Catch: Exception -> 0x022f, TRY_LEAVE, TryCatch #1 {Exception -> 0x022f, blocks: (B:93:0x0226, B:95:0x022c), top: B:122:0x0226 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0231 A[Catch: Exception -> 0x023a, TRY_ENTER, TryCatch #11 {Exception -> 0x023a, blocks: (B:71:0x01f2, B:73:0x01f8, B:97:0x0231, B:99:0x0237), top: B:135:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0237 A[Catch: Exception -> 0x023a, TRY_LEAVE, TryCatch #11 {Exception -> 0x023a, blocks: (B:71:0x01f2, B:73:0x01f8, B:97:0x0231, B:99:0x0237), top: B:135:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x002b A[Catch: all -> 0x0210, Exception -> 0x0213, TryCatch #15 {Exception -> 0x0213, all -> 0x0210, blocks: (B:4:0x0014, B:6:0x001a, B:7:0x0020, B:9:0x002b, B:11:0x003d, B:13:0x0047, B:15:0x004f), top: B:146:0x0014 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x002b, please report this as an issue */
    public /* synthetic */ void lambda$processDocumentImageForStorageWithComposeRect$4(String str, Promise promise, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, String str2) throws Throwable {
        File file;
        Bitmap bitmapDecodeFile;
        Bitmap bitmapApplyExifOrientation;
        Bitmap bitmapCreateBitmap;
        int iMin;
        float width;
        float f;
        float f2;
        RectF rectF;
        Rect rect;
        byte[] bArrEncodeDocumentJpegUnderLimit;
        File file2;
        String str3;
        FileOutputStream fileOutputStream;
        String strReplace = str;
        Bitmap bitmap = null;
        try {
            if (strReplace != null) {
                try {
                    if (strReplace.startsWith("file://")) {
                        strReplace = strReplace.replace("file://", "");
                    }
                    file = new File(strReplace);
                    if (!file.exists()) {
                        promise.reject("FILE_NOT_FOUND", "Source file does not exist: " + strReplace);
                        return;
                    }
                    bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (bitmapDecodeFile == null) {
                        promise.reject("DECODE_FAILED", "Unable to load source image");
                        return;
                    }
                    bitmapApplyExifOrientation = applyExifOrientation(bitmapDecodeFile, file.getAbsolutePath());
                    if (bitmapApplyExifOrientation != bitmapDecodeFile) {
                        try {
                            bitmapDecodeFile.recycle();
                        } catch (Exception e) {
                            e = e;
                            bitmap = bitmapApplyExifOrientation;
                            try {
                                Log.e("NavigationManager", "processDocumentImageForStorageWithComposeRect failed", e);
                                promise.reject("COMPOSE_ERROR", e.getMessage(), e);
                                if (bitmap != null) {
                                    try {
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                                if (bitmap == 0) {
                                }
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bitmap != null) {
                                    try {
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (bitmap == null) {
                                    throw th;
                                }
                                try {
                                    if (bitmap.isRecycled()) {
                                        throw th;
                                    }
                                    bitmap.recycle();
                                    throw th;
                                } catch (Exception unused3) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap = null;
                            bitmap = bitmapApplyExifOrientation;
                            if (bitmap != null) {
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                            }
                            if (bitmap == null) {
                                throw th;
                            }
                            if (bitmap.isRecycled()) {
                                throw th;
                            }
                            bitmap.recycle();
                            throw th;
                        }
                    }
                    bitmapCreateBitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-1);
                    int iMax = Math.max(0, (int) Math.floor(d));
                    int iMax2 = Math.max(0, (int) Math.floor(d2));
                    int iMax3 = Math.max(0, (int) Math.ceil(d3));
                    int iMax4 = Math.max(0, (int) Math.ceil(d4));
                    iMin = Math.min(iMax3, Math.max(0, bitmapApplyExifOrientation.getWidth() - iMax));
                    int iMin2 = Math.min(iMax4, Math.max(0, bitmapApplyExifOrientation.getHeight() - iMax2));
                    if (iMin >= 1 || iMin2 < 1 || d5 <= 0.0d || d6 <= 0.0d) {
                        Log.w("NavigationManager", "composeRect empty — falling back to full-image letterbox");
                        Rect rect2 = new Rect(0, 0, bitmapApplyExifOrientation.getWidth(), bitmapApplyExifOrientation.getHeight());
                        width = bitmapApplyExifOrientation.getWidth() / bitmapApplyExifOrientation.getHeight();
                        if (width > 1.6666666f) {
                            f2 = 800.0f / width;
                            f = 800.0f;
                        } else {
                            f = width * 480.0f;
                            f2 = 480.0f;
                        }
                        float f3 = (800.0f - f) / 2.0f;
                        float f4 = (480.0f - f2) / 2.0f;
                        rectF = new RectF(f3, f4, f + f3, f2 + f4);
                        rect = rect2;
                    } else {
                        rect = new Rect(iMax, iMax2, iMin + iMax, iMin2 + iMax2);
                        rectF = new RectF((float) d7, (float) d8, (float) (d7 + d5), (float) (d8 + d6));
                    }
                    canvas.drawBitmap(bitmapApplyExifOrientation, rect, rectF, new Paint(3));
                    bArrEncodeDocumentJpegUnderLimit = encodeDocumentJpegUnderLimit(bitmapCreateBitmap, 200000);
                    if (bArrEncodeDocumentJpegUnderLimit == null) {
                        promise.reject("ENCODE_FAILED", "Unable to encode processed JPEG under size limit");
                        if (bitmapApplyExifOrientation != null) {
                            try {
                                if (!bitmapApplyExifOrientation.isRecycled()) {
                                    bitmapApplyExifOrientation.recycle();
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        if (bitmapCreateBitmap != null) {
                            try {
                                if (bitmapCreateBitmap.isRecycled()) {
                                    return;
                                }
                                bitmapCreateBitmap.recycle();
                                return;
                            } catch (Exception unused5) {
                                return;
                            }
                        }
                        return;
                    }
                    file2 = new File(getReactApplicationContext().getFilesDir(), "documents");
                    if (file2.exists() && !file2.mkdirs()) {
                        promise.reject("WRITE_FAILED", "Unable to create documents directory");
                        if (bitmapApplyExifOrientation != null) {
                            try {
                                if (!bitmapApplyExifOrientation.isRecycled()) {
                                    bitmapApplyExifOrientation.recycle();
                                }
                            } catch (Exception unused6) {
                            }
                        }
                        if (bitmapCreateBitmap != null) {
                            try {
                                if (bitmapCreateBitmap.isRecycled()) {
                                    return;
                                }
                                bitmapCreateBitmap.recycle();
                                return;
                            } catch (Exception unused7) {
                                return;
                            }
                        }
                        return;
                    }
                    if (str2 != null || str2.isEmpty()) {
                        str3 = "Document";
                    } else {
                        str3 = str2;
                    }
                    File file3 = new File(file2, str3 + "_processed_" + (System.currentTimeMillis() / 1000) + ".jpeg");
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        fileOutputStream.write(bArrEncodeDocumentJpegUnderLimit);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Log.e("NavigationManager", "processDocumentImageForStorageWithComposeRect success out=" + file3.getAbsolutePath() + " bytes=" + bArrEncodeDocumentJpegUnderLimit.length + " doc=" + str3);
                        promise.resolve(file3.getAbsolutePath());
                        if (bitmapApplyExifOrientation != null) {
                            try {
                                if (!bitmapApplyExifOrientation.isRecycled()) {
                                    bitmapApplyExifOrientation.recycle();
                                }
                            } catch (Exception unused8) {
                            }
                        }
                        if (bitmapCreateBitmap != null) {
                            return;
                        }
                        if (!bitmapCreateBitmap.isRecycled()) {
                            bitmapCreateBitmap.recycle();
                        }
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.e("NavigationManager", "processDocumentImageForStorageWithComposeRect failed", e);
                    promise.reject("COMPOSE_ERROR", e.getMessage(), e);
                    if (bitmap != null) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    if (bitmap == 0) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = null;
                    if (bitmap != null) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    if (bitmap == null) {
                        throw th;
                    }
                    if (bitmap.isRecycled()) {
                        throw th;
                    }
                    bitmap.recycle();
                    throw th;
                }
            } else {
                file = new File(strReplace);
                if (!file.exists()) {
                    promise.reject("FILE_NOT_FOUND", "Source file does not exist: " + strReplace);
                    return;
                }
                bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (bitmapDecodeFile == null) {
                    promise.reject("DECODE_FAILED", "Unable to load source image");
                    return;
                }
                bitmapApplyExifOrientation = applyExifOrientation(bitmapDecodeFile, file.getAbsolutePath());
                if (bitmapApplyExifOrientation != bitmapDecodeFile) {
                    bitmapDecodeFile.recycle();
                }
                bitmapCreateBitmap = Bitmap.createBitmap(800, StreamingImageHandler.TFT_HEIGHT, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                canvas2.drawColor(-1);
                int iMax5 = Math.max(0, (int) Math.floor(d));
                int iMax6 = Math.max(0, (int) Math.floor(d2));
                int iMax7 = Math.max(0, (int) Math.ceil(d3));
                int iMax8 = Math.max(0, (int) Math.ceil(d4));
                iMin = Math.min(iMax7, Math.max(0, bitmapApplyExifOrientation.getWidth() - iMax5));
                int iMin3 = Math.min(iMax8, Math.max(0, bitmapApplyExifOrientation.getHeight() - iMax6));
                if (iMin >= 1) {
                    Log.w("NavigationManager", "composeRect empty — falling back to full-image letterbox");
                    Rect rect3 = new Rect(0, 0, bitmapApplyExifOrientation.getWidth(), bitmapApplyExifOrientation.getHeight());
                    width = bitmapApplyExifOrientation.getWidth() / bitmapApplyExifOrientation.getHeight();
                    if (width > 1.6666666f) {
                        f2 = 800.0f / width;
                        f = 800.0f;
                    } else {
                        f = width * 480.0f;
                        f2 = 480.0f;
                    }
                    float f5 = (800.0f - f) / 2.0f;
                    float f6 = (480.0f - f2) / 2.0f;
                    rectF = new RectF(f5, f6, f + f5, f2 + f6);
                    rect = rect3;
                } else {
                    Log.w("NavigationManager", "composeRect empty — falling back to full-image letterbox");
                    Rect rect4 = new Rect(0, 0, bitmapApplyExifOrientation.getWidth(), bitmapApplyExifOrientation.getHeight());
                    width = bitmapApplyExifOrientation.getWidth() / bitmapApplyExifOrientation.getHeight();
                    if (width > 1.6666666f) {
                        f2 = 800.0f / width;
                        f = 800.0f;
                    } else {
                        f = width * 480.0f;
                        f2 = 480.0f;
                    }
                    float f7 = (800.0f - f) / 2.0f;
                    float f8 = (480.0f - f2) / 2.0f;
                    rectF = new RectF(f7, f8, f + f7, f2 + f8);
                    rect = rect4;
                }
                canvas2.drawBitmap(bitmapApplyExifOrientation, rect, rectF, new Paint(3));
                bArrEncodeDocumentJpegUnderLimit = encodeDocumentJpegUnderLimit(bitmapCreateBitmap, 200000);
                if (bArrEncodeDocumentJpegUnderLimit == null) {
                    promise.reject("ENCODE_FAILED", "Unable to encode processed JPEG under size limit");
                    if (bitmapApplyExifOrientation != null) {
                        if (!bitmapApplyExifOrientation.isRecycled()) {
                            bitmapApplyExifOrientation.recycle();
                        }
                    }
                    if (bitmapCreateBitmap != null) {
                        if (bitmapCreateBitmap.isRecycled()) {
                            bitmapCreateBitmap.recycle();
                            return;
                        }
                        return;
                    }
                    return;
                }
                file2 = new File(getReactApplicationContext().getFilesDir(), "documents");
                if (file2.exists()) {
                }
                if (str2 != null) {
                    str3 = "Document";
                } else {
                    str3 = "Document";
                }
                File file4 = new File(file2, str3 + "_processed_" + (System.currentTimeMillis() / 1000) + ".jpeg");
                fileOutputStream = new FileOutputStream(file4);
                fileOutputStream.write(bArrEncodeDocumentJpegUnderLimit);
                fileOutputStream.flush();
                fileOutputStream.close();
                Log.e("NavigationManager", "processDocumentImageForStorageWithComposeRect success out=" + file4.getAbsolutePath() + " bytes=" + bArrEncodeDocumentJpegUnderLimit.length + " doc=" + str3);
                promise.resolve(file4.getAbsolutePath());
                if (bitmapApplyExifOrientation != null) {
                    if (!bitmapApplyExifOrientation.isRecycled()) {
                        bitmapApplyExifOrientation.recycle();
                    }
                }
                if (bitmapCreateBitmap != null) {
                    return;
                }
                if (!bitmapCreateBitmap.isRecycled()) {
                    bitmapCreateBitmap.recycle();
                }
            }
        } catch (Exception unused9) {
        }
    }

    private static Bitmap applyExifOrientation(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return null;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            Matrix matrix = new Matrix();
            if (attributeInt == 2) {
                matrix.postScale(-1.0f, 1.0f);
            } else if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 4) {
                matrix.postScale(1.0f, -1.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else {
                if (attributeInt != 8) {
                    return bitmap;
                }
                matrix.postRotate(270.0f);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmapCreateBitmap != null ? bitmapCreateBitmap : bitmap;
        } catch (Exception e) {
            Log.e("NavigationManager", "applyExifOrientation failed: " + e.getMessage());
            return bitmap;
        }
    }

    private static byte[] encodeDocumentJpegUnderLimit(Bitmap bitmap, int i) {
        byte[] byteArray = null;
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 42;
        int i3 = 100;
        int i4 = 42;
        while (i2 <= i3) {
            int i5 = (i2 + i3) / 2;
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            if (byteArray2.length <= i) {
                i2 = i5 + 1;
                i4 = i5;
                byteArray = byteArray2;
            } else {
                i3 = i5 - 1;
            }
        }
        while (byteArray != null && byteArray.length > i && i4 > 18) {
            i4 -= 4;
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        if (byteArray != null) {
            return byteArray;
        }
        byteArrayOutputStream.reset();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 18, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static Bitmap cropCenterToAspect(Bitmap bitmap, float f, float f2) {
        int iRound;
        int i;
        int i2;
        int i3;
        if (bitmap == null) {
            return null;
        }
        float f3 = f / f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 1 || height <= 1) {
            return bitmap;
        }
        float f4 = width;
        float f5 = height;
        float f6 = f4 / f5;
        if (f6 > f3 + 1.0E-4f) {
            iRound = Math.round(f5 * f3);
            i2 = (width - iRound) / 2;
            i3 = 0;
            i = height;
        } else if (f6 < f3 - 1.0E-4f) {
            int iRound2 = Math.round(f4 / f3);
            i3 = (height - iRound2) / 2;
            i2 = 0;
            i = iRound2;
            iRound = width;
        } else {
            iRound = width;
            i = height;
            i2 = 0;
            i3 = 0;
        }
        if (iRound < 2 || i < 2) {
            return bitmap;
        }
        int iMax = Math.max(0, Math.min(i2, width - iRound));
        int iMax2 = Math.max(0, Math.min(i3, height - i));
        return (iMax + iRound > width || iMax2 + i > height) ? bitmap : Bitmap.createBitmap(bitmap, iMax, iMax2, iRound, i);
    }

    private static Bitmap scaleLicenseRegistrationForCluster(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == 800 && bitmap.getHeight() == 480) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMax = Math.max(width, height);
        if (iMax > 4096) {
            float f = 4096.0f / iMax;
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.max(2, Math.round(width * f)), Math.max(2, Math.round(height * f)), true);
            if (bitmapCreateScaledBitmap != bitmap) {
                bitmap.recycle();
            }
            int width2 = bitmapCreateScaledBitmap.getWidth();
            height = bitmapCreateScaledBitmap.getHeight();
            width = width2;
            bitmap = bitmapCreateScaledBitmap;
        }
        float f2 = width;
        float f3 = height;
        float fMax = Math.max(800.0f / f2, 480.0f / f3);
        int iMax2 = Math.max(800, Math.round(f2 * fMax));
        int iMax3 = Math.max(StreamingImageHandler.TFT_HEIGHT, Math.round(f3 * fMax));
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, iMax2, iMax3, true);
        if (bitmapCreateScaledBitmap2 != bitmap) {
            bitmap.recycle();
        }
        int i = iMax2 - 800;
        int iMax4 = Math.max(0, i / 2);
        if (iMax4 + 800 > iMax2) {
            iMax4 = Math.max(0, i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap2, iMax4, 480 > iMax3 ? Math.max(0, iMax3 - StreamingImageHandler.TFT_HEIGHT) : 0, 800, StreamingImageHandler.TFT_HEIGHT);
        if (bitmapCreateBitmap != bitmapCreateScaledBitmap2) {
            bitmapCreateScaledBitmap2.recycle();
        }
        return bitmapCreateBitmap;
    }

    private static Bitmap scaleDocumentForCluster(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "Registration":
            case "License":
            case "Insurance":
                return scaleLicenseRegistrationForCluster(bitmap);
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02d7 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x02db  */
    /* JADX WARN: Code duplicated, block: B:107:0x030e A[Catch: Exception -> 0x039f, TRY_ENTER, TryCatch #2 {Exception -> 0x039f, blocks: (B:3:0x004d, B:7:0x005b, B:38:0x00e2, B:40:0x010d, B:46:0x0125, B:47:0x0129, B:123:0x0398, B:104:0x02f4, B:107:0x030e, B:109:0x032b, B:111:0x0337, B:113:0x0354, B:115:0x0360, B:116:0x037b, B:36:0x00ce, B:127:0x039e, B:4:0x0052, B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:142:0x004d, inners: #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x032a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0337 A[Catch: Exception -> 0x039f, TryCatch #2 {Exception -> 0x039f, blocks: (B:3:0x004d, B:7:0x005b, B:38:0x00e2, B:40:0x010d, B:46:0x0125, B:47:0x0129, B:123:0x0398, B:104:0x02f4, B:107:0x030e, B:109:0x032b, B:111:0x0337, B:113:0x0354, B:115:0x0360, B:116:0x037b, B:36:0x00ce, B:127:0x039e, B:4:0x0052, B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:142:0x004d, inners: #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0353  */
    /* JADX WARN: Code duplicated, block: B:115:0x0360 A[Catch: Exception -> 0x039f, TryCatch #2 {Exception -> 0x039f, blocks: (B:3:0x004d, B:7:0x005b, B:38:0x00e2, B:40:0x010d, B:46:0x0125, B:47:0x0129, B:123:0x0398, B:104:0x02f4, B:107:0x030e, B:109:0x032b, B:111:0x0337, B:113:0x0354, B:115:0x0360, B:116:0x037b, B:36:0x00ce, B:127:0x039e, B:4:0x0052, B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:142:0x004d, inners: #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x038c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x0165 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x015c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x010d A[Catch: Exception -> 0x039f, TRY_LEAVE, TryCatch #2 {Exception -> 0x039f, blocks: (B:3:0x004d, B:7:0x005b, B:38:0x00e2, B:40:0x010d, B:46:0x0125, B:47:0x0129, B:123:0x0398, B:104:0x02f4, B:107:0x030e, B:109:0x032b, B:111:0x0337, B:113:0x0354, B:115:0x0360, B:116:0x037b, B:36:0x00ce, B:127:0x039e, B:4:0x0052, B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:142:0x004d, inners: #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0122  */
    /* JADX WARN: Code duplicated, block: B:46:0x0125 A[Catch: Exception -> 0x039f, TRY_ENTER, TryCatch #2 {Exception -> 0x039f, blocks: (B:3:0x004d, B:7:0x005b, B:38:0x00e2, B:40:0x010d, B:46:0x0125, B:47:0x0129, B:123:0x0398, B:104:0x02f4, B:107:0x030e, B:109:0x032b, B:111:0x0337, B:113:0x0354, B:115:0x0360, B:116:0x037b, B:36:0x00ce, B:127:0x039e, B:4:0x0052, B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:142:0x004d, inners: #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x013e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0170 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0202  */
    /* JADX WARN: Code duplicated, block: B:76:0x0212 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x021a  */
    /* JADX WARN: Code duplicated, block: B:79:0x021c A[Catch: all -> 0x016b, TRY_LEAVE, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0224  */
    /* JADX WARN: Code duplicated, block: B:82:0x0226  */
    /* JADX WARN: Code duplicated, block: B:85:0x022b  */
    /* JADX WARN: Code duplicated, block: B:87:0x022e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0231 A[Catch: all -> 0x016b, TRY_ENTER, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x024c A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0269 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0283 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02a0 A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x02ba A[Catch: all -> 0x016b, TryCatch #9 {all -> 0x016b, blocks: (B:51:0x0142, B:53:0x015c, B:54:0x0165, B:58:0x0170, B:61:0x017f, B:65:0x0189, B:66:0x0198, B:89:0x0231, B:90:0x024c, B:92:0x0269, B:93:0x026c, B:94:0x0283, B:96:0x02a0, B:97:0x02a3, B:98:0x02ba, B:100:0x02d7, B:102:0x02dc, B:73:0x0208, B:76:0x0212, B:79:0x021c), top: B:155:0x0142, outer: #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:107:0x030e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:111:0x0337, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:115:0x0360, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x010d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:89:0x0231, please report this as an issue */
    public void loadDocumentImageNew(String str, String str2) {
        Bitmap bitmap;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmapScaleDocumentForCluster;
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        int i2;
        int i3;
        int i4;
        int iHashCode;
        byte b;
        int length;
        byte[] bArr;
        String str3;
        String str4;
        String str5;
        int i5;
        int i6;
        byte[] byteArray2;
        int i7;
        File file = new File(str);
        Log.e("NavigationManager", "loadDocumentImageNew: docType=" + str2 + " path=" + str + " exists=" + file.exists() + " size=" + file.length());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                if (bitmapDecodeStream == null) {
                    Log.e("NavigationManager", "loadDocumentImageNew: FAILED to decode bitmap for " + str2);
                    return;
                }
                try {
                    int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    Matrix matrix = new Matrix();
                    try {
                        if (attributeInt == 2) {
                            matrix.postScale(-1.0f, 1.0f);
                        } else if (attributeInt == 3) {
                            matrix.postRotate(180.0f);
                        } else if (attributeInt == 4) {
                            matrix.postScale(1.0f, -1.0f);
                        } else {
                            if (attributeInt != 6) {
                                if (attributeInt != 8) {
                                    bitmap = bitmapDecodeStream;
                                } else {
                                    matrix.postRotate(270.0f);
                                }
                                bitmapCreateBitmap = bitmap;
                                Log.e("NavigationManager", "loadDocumentImageNew: decoded " + str2 + " bitmap=" + bitmapCreateBitmap.getWidth() + "x" + bitmapCreateBitmap.getHeight());
                                bitmapScaleDocumentForCluster = scaleDocumentForCluster(bitmapCreateBitmap, str2);
                                if (bitmapScaleDocumentForCluster == null) {
                                    Log.e("NavigationManager", "loadDocumentImageNew: unsupported docType or scale failed: " + str2);
                                    if (bitmapCreateBitmap != null) {
                                        try {
                                            bitmapCreateBitmap.recycle();
                                            return;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                                byteArray = null;
                                if (bitmapScaleDocumentForCluster != bitmapCreateBitmap) {
                                    bitmapCreateBitmap.recycle();
                                    bitmapCreateBitmap = null;
                                }
                                int width = bitmapScaleDocumentForCluster.getWidth();
                                int height = bitmapScaleDocumentForCluster.getHeight();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                i = 42;
                                i2 = 100;
                                i3 = 42;
                                while (i <= i2) {
                                    try {
                                        i5 = (i + i2) / 2;
                                        byteArrayOutputStream.reset();
                                        i6 = i;
                                        bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
                                        byteArray2 = byteArrayOutputStream.toByteArray();
                                        i7 = i2;
                                        if (byteArray2.length <= 200000) {
                                            i = i5 + 1;
                                            i3 = i5;
                                            i2 = i7;
                                            byteArray = byteArray2;
                                        } else {
                                            i2 = i5 - 1;
                                            i = i6;
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        throw th;
                                    }
                                }
                                if (byteArray == null) {
                                    byteArrayOutputStream.reset();
                                    bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                                    byteArray = byteArrayOutputStream.toByteArray();
                                }
                                i4 = i3;
                                while (byteArray != null && byteArray.length > 200000 && i4 > 18) {
                                    i4 -= 4;
                                    byteArrayOutputStream.reset();
                                    bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                                    byteArray = byteArrayOutputStream.toByteArray();
                                }
                                Log.e("NavigationManager", "loadDocumentImageNew: " + str2 + " scaled=" + width + "x" + height + " quality=" + i3 + " compressed=" + byteArray.length + " bytes");
                                String strMd5Hex = md5Hex(byteArray);
                                StringBuilder sb = new StringBuilder();
                                sb.append("loadDocumentImageNew: ");
                                sb.append(str2);
                                sb.append(" result md5=");
                                sb.append(strMd5Hex);
                                sb.append(" len=");
                                sb.append(byteArray.length);
                                Log.e("NavigationManager", sb.toString());
                                iHashCode = str2.hashCode();
                                if (iHashCode != -1185989415) {
                                    if (iHashCode != 1831410721) {
                                        if (iHashCode == 2077017786 && str2.equals("Insurance")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                    } else if (str2.equals("License")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str2.equals("Registration")) {
                                    b = 1;
                                } else {
                                    b = -1;
                                }
                                if (b != 0) {
                                    MirroringGlobarVar.setLicenseImageData(byteArray);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("ASSIGNED License slot md5=");
                                    sb2.append(md5Hex(MirroringGlobarVar.licenseImageData));
                                    sb2.append(" len=");
                                    if (MirroringGlobarVar.licenseImageData != null) {
                                        length = MirroringGlobarVar.licenseImageData.length;
                                    } else {
                                        length = 0;
                                    }
                                    sb2.append(length);
                                    sb2.append(" ts=");
                                    sb2.append(MirroringGlobarVar.licenseImageTimestamp);
                                    Log.e("NavigationManager", sb2.toString());
                                    notifyClusterDocCacheUpdated(0);
                                } else if (b != 1) {
                                    MirroringGlobarVar.setRegistrationImageData(byteArray);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("ASSIGNED Registration slot md5=");
                                    sb3.append(md5Hex(MirroringGlobarVar.registrationImageData));
                                    sb3.append(" len=");
                                    sb3.append(MirroringGlobarVar.registrationImageData != null ? MirroringGlobarVar.registrationImageData.length : 0);
                                    sb3.append(" ts=");
                                    sb3.append(MirroringGlobarVar.registrationImageTimestamp);
                                    Log.e("NavigationManager", sb3.toString());
                                    notifyClusterDocCacheUpdated(1);
                                } else if (b != 2) {
                                    Log.e("NavigationManager", "loadDocumentImageNew: UNKNOWN docType='" + str2 + "' — data NOT assigned!");
                                } else {
                                    MirroringGlobarVar.setInsuranceImageData(byteArray);
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("ASSIGNED Insurance slot md5=");
                                    sb4.append(md5Hex(MirroringGlobarVar.insuranceImageData));
                                    sb4.append(" len=");
                                    sb4.append(MirroringGlobarVar.insuranceImageData != null ? MirroringGlobarVar.insuranceImageData.length : 0);
                                    sb4.append(" ts=");
                                    sb4.append(MirroringGlobarVar.insuranceImageTimestamp);
                                    Log.e("NavigationManager", sb4.toString());
                                    notifyClusterDocCacheUpdated(2);
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("=== SLOT SNAPSHOT after ");
                                sb5.append(str2);
                                sb5.append(" === License=[");
                                bArr = MirroringGlobarVar.licenseImageData;
                                str3 = BuildConfig.TRAVIS;
                                if (bArr != null) {
                                    str4 = MirroringGlobarVar.licenseImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.licenseImageData);
                                } else {
                                    str4 = BuildConfig.TRAVIS;
                                }
                                sb5.append(str4);
                                sb5.append("] Registration=[");
                                if (MirroringGlobarVar.registrationImageData != null) {
                                    str5 = MirroringGlobarVar.registrationImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.registrationImageData);
                                } else {
                                    str5 = BuildConfig.TRAVIS;
                                }
                                sb5.append(str5);
                                sb5.append("] Insurance=[");
                                if (MirroringGlobarVar.insuranceImageData != null) {
                                    str3 = MirroringGlobarVar.insuranceImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.insuranceImageData);
                                }
                                sb5.append(str3);
                                sb5.append("]");
                                Log.e("NavigationManager", sb5.toString());
                                if (bitmapScaleDocumentForCluster != null) {
                                    try {
                                        bitmapScaleDocumentForCluster.recycle();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (bitmapCreateBitmap != null) {
                                    try {
                                        bitmapCreateBitmap.recycle();
                                    } catch (Exception unused6) {
                                        return;
                                    }
                                }
                            }
                            matrix.postRotate(90.0f);
                        }
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                        if (bitmapCreateBitmap != bitmap) {
                            bitmap.recycle();
                        } else {
                            bitmapCreateBitmap = bitmap;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e("NavigationManager", "loadDocumentImageNew: failed to apply EXIF orientation: " + e.getMessage());
                    }
                    bitmap = bitmapDecodeStream;
                } catch (Exception e2) {
                    e = e2;
                    bitmap = bitmapDecodeStream;
                }
                Log.e("NavigationManager", "loadDocumentImageNew: decoded " + str2 + " bitmap=" + bitmapCreateBitmap.getWidth() + "x" + bitmapCreateBitmap.getHeight());
                bitmapScaleDocumentForCluster = scaleDocumentForCluster(bitmapCreateBitmap, str2);
                if (bitmapScaleDocumentForCluster == null) {
                    Log.e("NavigationManager", "loadDocumentImageNew: unsupported docType or scale failed: " + str2);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                        return;
                    }
                    return;
                }
                byteArray = null;
                if (bitmapScaleDocumentForCluster != bitmapCreateBitmap) {
                    bitmapCreateBitmap.recycle();
                    bitmapCreateBitmap = null;
                }
                int width2 = bitmapScaleDocumentForCluster.getWidth();
                int height2 = bitmapScaleDocumentForCluster.getHeight();
                byteArrayOutputStream = new ByteArrayOutputStream();
                i = 42;
                i2 = 100;
                i3 = 42;
                while (i <= i2) {
                    i5 = (i + i2) / 2;
                    byteArrayOutputStream.reset();
                    i6 = i;
                    bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream);
                    byteArray2 = byteArrayOutputStream.toByteArray();
                    i7 = i2;
                    if (byteArray2.length <= 200000) {
                        i = i5 + 1;
                        i3 = i5;
                        i2 = i7;
                        byteArray = byteArray2;
                    } else {
                        i2 = i5 - 1;
                        i = i6;
                    }
                }
                if (byteArray == null) {
                    byteArrayOutputStream.reset();
                    bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                i4 = i3;
                while (byteArray != null) {
                    i4 -= 4;
                    byteArrayOutputStream.reset();
                    bitmapScaleDocumentForCluster.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                Log.e("NavigationManager", "loadDocumentImageNew: " + str2 + " scaled=" + width2 + "x" + height2 + " quality=" + i3 + " compressed=" + byteArray.length + " bytes");
                String strMd5Hex2 = md5Hex(byteArray);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("loadDocumentImageNew: ");
                sb6.append(str2);
                sb6.append(" result md5=");
                sb6.append(strMd5Hex2);
                sb6.append(" len=");
                sb6.append(byteArray.length);
                Log.e("NavigationManager", sb6.toString());
                iHashCode = str2.hashCode();
                if (iHashCode != -1185989415) {
                    if (iHashCode != 1831410721) {
                        if (iHashCode == 2077017786) {
                            b = 2;
                        }
                        b = -1;
                    } else if (str2.equals("License")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("Registration")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    MirroringGlobarVar.setLicenseImageData(byteArray);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("ASSIGNED License slot md5=");
                    sb7.append(md5Hex(MirroringGlobarVar.licenseImageData));
                    sb7.append(" len=");
                    if (MirroringGlobarVar.licenseImageData != null) {
                        length = MirroringGlobarVar.licenseImageData.length;
                    } else {
                        length = 0;
                    }
                    sb7.append(length);
                    sb7.append(" ts=");
                    sb7.append(MirroringGlobarVar.licenseImageTimestamp);
                    Log.e("NavigationManager", sb7.toString());
                    notifyClusterDocCacheUpdated(0);
                } else if (b != 1) {
                    MirroringGlobarVar.setRegistrationImageData(byteArray);
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("ASSIGNED Registration slot md5=");
                    sb8.append(md5Hex(MirroringGlobarVar.registrationImageData));
                    sb8.append(" len=");
                    sb8.append(MirroringGlobarVar.registrationImageData != null ? MirroringGlobarVar.registrationImageData.length : 0);
                    sb8.append(" ts=");
                    sb8.append(MirroringGlobarVar.registrationImageTimestamp);
                    Log.e("NavigationManager", sb8.toString());
                    notifyClusterDocCacheUpdated(1);
                } else if (b != 2) {
                    Log.e("NavigationManager", "loadDocumentImageNew: UNKNOWN docType='" + str2 + "' — data NOT assigned!");
                } else {
                    MirroringGlobarVar.setInsuranceImageData(byteArray);
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("ASSIGNED Insurance slot md5=");
                    sb9.append(md5Hex(MirroringGlobarVar.insuranceImageData));
                    sb9.append(" len=");
                    sb9.append(MirroringGlobarVar.insuranceImageData != null ? MirroringGlobarVar.insuranceImageData.length : 0);
                    sb9.append(" ts=");
                    sb9.append(MirroringGlobarVar.insuranceImageTimestamp);
                    Log.e("NavigationManager", sb9.toString());
                    notifyClusterDocCacheUpdated(2);
                }
                byteArrayOutputStream.close();
                StringBuilder sb10 = new StringBuilder();
                sb10.append("=== SLOT SNAPSHOT after ");
                sb10.append(str2);
                sb10.append(" === License=[");
                bArr = MirroringGlobarVar.licenseImageData;
                str3 = BuildConfig.TRAVIS;
                if (bArr != null) {
                    str4 = MirroringGlobarVar.licenseImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.licenseImageData);
                } else {
                    str4 = BuildConfig.TRAVIS;
                }
                sb10.append(str4);
                sb10.append("] Registration=[");
                if (MirroringGlobarVar.registrationImageData != null) {
                    str5 = MirroringGlobarVar.registrationImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.registrationImageData);
                } else {
                    str5 = BuildConfig.TRAVIS;
                }
                sb10.append(str5);
                sb10.append("] Insurance=[");
                if (MirroringGlobarVar.insuranceImageData != null) {
                    str3 = MirroringGlobarVar.insuranceImageData.length + "B md5=" + md5Hex(MirroringGlobarVar.insuranceImageData);
                }
                sb10.append(str3);
                sb10.append("]");
                Log.e("NavigationManager", sb10.toString());
                if (bitmapScaleDocumentForCluster != null) {
                    bitmapScaleDocumentForCluster.recycle();
                }
                if (bitmapCreateBitmap != null) {
                    bitmapCreateBitmap.recycle();
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                    throw th2;
                } catch (Exception unused7) {
                    throw th2;
                }
            }
        } catch (Exception e3) {
            Log.e("NavigationManager", "loadDocumentImageNew: ERROR for " + str2 + ": " + e3.getMessage());
            e3.printStackTrace();
        }
    }

    private void notifyClusterDocCacheUpdated(int i) {
        try {
            if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.tcpServerService != null) {
                NavApplication.streamingHandler.tcpServerService.primeDocumentMetadataIfTcpReady(i);
            }
        } catch (Exception e) {
            Log.w("NavigationManager", "notifyClusterDocCacheUpdated failed", e);
        }
    }

    private static String md5Hex(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.TRAVIS;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Integer.valueOf(b & 255)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0089  */
    public void getDocImage(String str, String str2) {
        byte b;
        try {
            InputStream inputStream = ((HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()))).getInputStream();
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new BufferedInputStream(inputStream));
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.max(1, bitmapDecodeStream.getWidth() / 32) * 32, Math.max(1, bitmapDecodeStream.getHeight() / 32) * 32, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            int iHashCode = str2.hashCode();
            if (iHashCode != -1185989415) {
                if (iHashCode != 1831410721) {
                    if (iHashCode == 2077017786 && str2.equals("Insurance")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("License")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("Registration")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                MirroringGlobarVar.setLicenseImageData(byteArrayOutputStream.toByteArray());
                StringBuilder sb = new StringBuilder("file Downloaded licence");
                sb.append(MirroringGlobarVar.licenseImageData != null ? MirroringGlobarVar.licenseImageData.length : 0);
                sb.append(" ts=");
                sb.append(MirroringGlobarVar.licenseImageTimestamp);
                Log.e("NavigationManager", sb.toString());
            } else if (b == 1) {
                MirroringGlobarVar.setRegistrationImageData(byteArrayOutputStream.toByteArray());
                StringBuilder sb2 = new StringBuilder("file Downloaded registration");
                sb2.append(MirroringGlobarVar.registrationImageData != null ? MirroringGlobarVar.registrationImageData.length : 0);
                sb2.append(" ts=");
                sb2.append(MirroringGlobarVar.registrationImageTimestamp);
                Log.e("NavigationManager", sb2.toString());
            } else if (b == 2) {
                MirroringGlobarVar.setInsuranceImageData(byteArrayOutputStream.toByteArray());
                StringBuilder sb3 = new StringBuilder("file Downloaded insurance ");
                sb3.append(MirroringGlobarVar.insuranceImageData != null ? MirroringGlobarVar.insuranceImageData.length : 0);
                sb3.append(" ts=");
                sb3.append(MirroringGlobarVar.insuranceImageTimestamp);
                Log.e("NavigationManager", sb3.toString());
            }
            Log.e("NAvigation", "size heigth " + bitmapCreateScaledBitmap.getHeight());
            Log.e("NAvigation", "size width " + bitmapCreateScaledBitmap.getWidth());
            inputStream.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setCurrentLocation(Double d, Double d2) {
        MirroringGlobarVar.currentLat = d;
        MirroringGlobarVar.currentLng = d2;
        if (d != null && d2 != null) {
            GlobalVar.lat = d;
            GlobalVar.lng = d2;
        }
        Log.i("NavigationManager", "setCurrentLocation lat=" + d + " lng=" + d2);
    }

    @ReactMethod
    public void setMMIAreaCode(String str) {
        GlobalVar.MMI_AREA_CODE = str;
        MapplsAccountManager.getInstance().setRegion(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquireLocks() {
        if (this.wakeLock == null) {
            this.powerManager = (PowerManager) this.reactContext.getApplicationContext().getSystemService("power");
            this.wifiManager = (WifiManager) this.reactContext.getApplicationContext().getSystemService("wifi");
            this.wakeLock = this.powerManager.newWakeLock(1, getApplicationName() + ":myWakeLockTag");
            this.wifiLock = this.wifiManager.createWifiLock(3, getApplicationName() + ":MyWifiLock");
        }
        if (!this.wakeLock.isHeld()) {
            this.wakeLock.acquire();
        }
        if (this.wifiLock.isHeld()) {
            return;
        }
        this.wifiLock.acquire();
    }

    private String getApplicationName() {
        ApplicationInfo applicationInfo = this.reactContext.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : this.reactContext.getString(i);
    }

    @ReactMethod
    public void connectToWifi() {
        if (!isWifiEnabledForCurrentSku()) {
            Log.i("NavigationManager", "connectToWifi skipped — SKU has no WiFi capability");
            return;
        }
        if (this.networkRequest1 == null) {
            this.networkRequest1 = new NetworkRequestImpl(getReactApplicationContext());
        }
        if (MirroringGlobarVar.isWifiConnected) {
            return;
        }
        this.networkRequest1.scanWifi();
    }

    @ReactMethod
    public void connectToClusterWifi(String str) {
        if (!isWifiEnabledForCurrentSku()) {
            Log.i("NavigationManager", "connectToClusterWifi skipped — SKU has no WiFi capability");
            return;
        }
        String strTrim = str != null ? str.trim() : "";
        if (strTrim.isEmpty()) {
            Log.w("NavigationManager", "connectToClusterWifi: empty ssid");
            return;
        }
        if (this.networkRequest1 == null) {
            this.networkRequest1 = new NetworkRequestImpl(getReactApplicationContext());
        }
        String str2 = GlobalVar.vehcileVin;
        if (str2 == null || str2.trim().isEmpty()) {
            Log.w("NavigationManager", "connectToClusterWifi: VIN not set — call setVin first");
        }
        String str3 = GlobalVar.wifiPassword;
        if ((str3 == null || str3.length() < 8) && str2 != null && !str2.trim().isEmpty()) {
            GlobalVar.wifiPassword = MainActivity.getSecretKey2(getReactApplicationContext(), str2);
            str3 = GlobalVar.wifiPassword;
        }
        this.networkRequest1.requestWifi(strTrim, null, str3);
    }

    @ReactMethod
    public void connectToHardcodedWifi() {
        Log.w("NavigationManager", "connectToHardcodedWifi deprecated — use connectToClusterWifi + setVin");
        String strTrim = GlobalVar.bleDeviceName != null ? GlobalVar.bleDeviceName.trim() : "";
        if (strTrim.isEmpty()) {
            Log.w("NavigationManager", "connectToHardcodedWifi aborted — no bleDeviceName (no hardcoded SSID fallback)");
        } else {
            connectToClusterWifi(strTrim);
        }
    }

    @ReactMethod
    public void isWifiEnabled(Promise promise) {
        try {
            if (this.wifiManager == null) {
                this.wifiManager = (WifiManager) getReactApplicationContext().getApplicationContext().getSystemService("wifi");
            }
            WifiManager wifiManager = this.wifiManager;
            promise.resolve(Boolean.valueOf(wifiManager != null && wifiManager.isWifiEnabled()));
        } catch (Exception unused) {
            promise.resolve(true);
        }
    }

    @ReactMethod
    public void openWifiSettings() {
        try {
            Intent intent = new Intent("android.settings.WIFI_SETTINGS");
            intent.addFlags(268435456);
            getReactApplicationContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void disconnectFromClusterWifi() {
        try {
            NetworkRequestImpl networkRequestImpl = this.networkRequest1;
            if (networkRequestImpl != null) {
                networkRequestImpl.cancelAutoReconnect("userDisconnect");
                this.networkRequest1.stopServices();
                this.networkRequest1.releaseNetworkCallback();
            }
            MirroringGlobarVar.isWifiConnected = false;
            NetworkRequestImpl.restoreDefaultNetwork(getReactApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void disconnectFromHardcodedWifi() {
        disconnectFromClusterWifi();
    }

    public void emitInfoWifi(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("name", "dooley-doo");
        writableMapCreateMap.putInt("version", 16);
        writableMapCreateMap.putBoolean("isConnected", z);
        sendEvent("WIFI_EVENT", writableMapCreateMap);
    }

    public void emitTcpConnected(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isConnected", z);
        sendEvent("TCP_EVENT", writableMapCreateMap);
    }

    @ReactMethod
    public void getTcpConnected(Promise promise) {
        promise.resolve(Boolean.valueOf(NavApplication.streamingHandler != null && NavApplication.streamingHandler.onTcpReady()));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    @ReactMethod
    public void clearDocument(String str) {
        byte b;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1185989415) {
                if (iHashCode != 1831410721) {
                    if (iHashCode == 2077017786 && str.equals("Insurance")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("License")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("Registration")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                MirroringGlobarVar.setLicenseImageData(null);
            } else if (b == 1) {
                MirroringGlobarVar.setRegistrationImageData(null);
            } else if (b == 2) {
                MirroringGlobarVar.setInsuranceImageData(null);
            }
            Log.d("NavigationManager", "clearDocument: cleared " + str + " (no unsolicited TCP)");
        } catch (Exception e) {
            Log.e("NavigationManager", "clearDocument error: " + e.getMessage());
        }
    }

    private void saveToStorage(Bitmap bitmap, String str) {
        File dir = new ContextWrapper(this.reactContext.getApplicationContext()).getDir(Scopes.PROFILE, 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, str + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.e("SAVE_IMAGE", e.getMessage(), e);
        }
    }

    public void readFromInternalStorage(String str) {
        File dir = new ContextWrapper(this.reactContext.getApplicationContext()).getDir(Scopes.PROFILE, 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            new FileInputStream(new File(dir, str + ".jpg"));
            Log.e("NavigationManager", "file read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bajajconnect.wifi.interfaces.RNEmiiterCallback
    public void onFaultDetected(VehicleFaults vehicleFaults) {
        if (vehicleFaults == VehicleFaults.BATTERY_HEALTH_CRITICAL) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean("isFault", true);
            sendEvent("FAULT_EVENT", writableMapCreateMap);
        } else if (vehicleFaults == VehicleFaults.NONE) {
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putBoolean("isFault", false);
            sendEvent("FAULT_EVENT", writableMapCreateMap2);
        }
    }

    @ReactMethod
    public void checkLockscreenNotificationAllowed(Promise promise) {
        if (ActivityCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_NOTIFICATION_POLICY") != 0) {
            Log.e("NavigationManager", "Notification permission is granted ,  Take me home work");
            promise.resolve(true);
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    public void checkOppoVivo(Promise promise) {
        String lowerCase = Build.BRAND.toLowerCase();
        if ((lowerCase.contains("xiaomi") || lowerCase.contains("oppo") || lowerCase.contains("vivo")) && Build.VERSION.SDK_INT >= 31) {
            promise.resolve(true);
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    public void setNavigationType(boolean z) {
        GlobalVar.isGoogleNavigation = z;
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(z ? NavigationActivity.class : HomeActivity.class);
    }
}
