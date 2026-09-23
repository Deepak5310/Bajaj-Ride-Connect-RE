package com.bajajconnect.wifi.views;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.gMaps.NavInfoReceivingService;
import com.bajajconnect.gMaps.util.GmapUtil;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.Screens;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.libraries.navigation.AlternateRoutesStrategy;
import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.DisplayOptions;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.NavigationApi;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RouteSegment;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.Waypoint;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.services.api.Place;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleMapPresentation extends Presentation implements OnMapReadyCallback {
    private static final float MIRROR_FOLLOW_ZOOM_DEFAULT = 17.5f;
    private static final float MIRROR_FOLLOW_ZOOM_MAX = 20.0f;
    private static final float MIRROR_FOLLOW_ZOOM_MIN = 12.0f;
    private static final int MIRROR_LOGO_BOTTOM_PADDING_PX = 110;
    private static final int SCROLL_BY_PX = 100;
    private Activity activity;
    private Navigator.ArrivalListener arrivalListener;
    public float currentMapZoom;
    private Navigator defaultNavigator;
    public GestureDetector gestureDetector;
    private GoogleMap googleMap;
    private final Handler handler;
    public boolean isRouteDrawn;
    private LatLngBounds latLngBounds;
    private Polyline liveRoutePolyline;
    private final Handler mainHandler;
    private float mirrorFollowZoom;
    private Navigator.NavigationSessionListener navigationSessionListener;
    private NavigationView navigationView;
    private boolean navigatorListenersAttached;
    private Navigator.ReroutingListener reroutingListener;
    private Navigator.RouteChangedListener routeChangedListener;
    private PolylineOptions routePolyline;

    /* JADX INFO: Access modifiers changed from: private */
    public Context getSafeContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        if (BleFeatures.getInstance().context != null) {
            return BleFeatures.getInstance().context;
        }
        if (NavApplication.activity != null) {
            return NavApplication.activity;
        }
        return null;
    }

    public GoogleMapPresentation(Context context, Display display, Handler handler, @Nullable Activity activity) {
        super(context, display);
        this.isRouteDrawn = true;
        this.currentMapZoom = 14.5f;
        this.mirrorFollowZoom = MIRROR_FOLLOW_ZOOM_DEFAULT;
        this.navigatorListenersAttached = false;
        this.arrivalListener = new Navigator.ArrivalListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda3
            @Override // com.google.android.libraries.navigation.Navigator.ArrivalListener
            public final void onArrival(ArrivalEvent arrivalEvent) {
                GoogleMapPresentation.lambda$new$2(arrivalEvent);
            }
        };
        this.navigationSessionListener = new Navigator.NavigationSessionListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.5
            @Override // com.google.android.libraries.navigation.Navigator.NavigationSessionListener
            public void onNewNavigationSession() {
            }
        };
        this.reroutingListener = new Navigator.ReroutingListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.6
            @Override // com.google.android.libraries.navigation.Navigator.ReroutingListener
            public void onReroutingRequestedByOffRoute() {
                Log.e("GMAPPP", "on rerouting requested — cellular for route + restore follow");
                Context safeContext = GoogleMapPresentation.this.getSafeContext();
                if (safeContext != null) {
                    MirroringPolicy.ensureCellularNetworkForRouting(safeContext);
                }
                if (BleFeatures.navigationCallback != null) {
                    BleFeatures.navigationCallback.onRerouting();
                }
                if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    GoogleMapPresentation.this.scheduleFollowRestore("offRoute");
                }
            }
        };
        this.routeChangedListener = new Navigator.RouteChangedListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.7
            @Override // com.google.android.libraries.navigation.Navigator.RouteChangedListener
            public void onRouteChanged() {
                Log.e("GMAPPP", "on route changed");
                if (BleFeatures.navigationCallback != null) {
                    BleFeatures.navigationCallback.onRouteReady();
                }
                Context safeContext = GoogleMapPresentation.this.getSafeContext();
                if (safeContext != null) {
                    MirroringPolicy.restoreClusterNetworkAfterRouting(safeContext);
                }
                if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    GoogleMapPresentation.this.ensureLiveRoutePolyline("routeChanged");
                    GoogleMapPresentation.this.scheduleFollowRestore("routeChanged");
                } else {
                    GoogleMapPresentation.this.showSharedRouteOnMap();
                }
            }
        };
        this.handler = handler;
        this.activity = activity;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public GoogleMapPresentation(Context context, Display display, int i, Handler handler, @Nullable Activity activity) {
        super(context, display, i);
        this.isRouteDrawn = true;
        this.currentMapZoom = 14.5f;
        this.mirrorFollowZoom = MIRROR_FOLLOW_ZOOM_DEFAULT;
        this.navigatorListenersAttached = false;
        this.arrivalListener = new Navigator.ArrivalListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda3
            @Override // com.google.android.libraries.navigation.Navigator.ArrivalListener
            public final void onArrival(ArrivalEvent arrivalEvent) {
                GoogleMapPresentation.lambda$new$2(arrivalEvent);
            }
        };
        this.navigationSessionListener = new Navigator.NavigationSessionListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.5
            @Override // com.google.android.libraries.navigation.Navigator.NavigationSessionListener
            public void onNewNavigationSession() {
            }
        };
        this.reroutingListener = new Navigator.ReroutingListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.6
            @Override // com.google.android.libraries.navigation.Navigator.ReroutingListener
            public void onReroutingRequestedByOffRoute() {
                Log.e("GMAPPP", "on rerouting requested — cellular for route + restore follow");
                Context safeContext = GoogleMapPresentation.this.getSafeContext();
                if (safeContext != null) {
                    MirroringPolicy.ensureCellularNetworkForRouting(safeContext);
                }
                if (BleFeatures.navigationCallback != null) {
                    BleFeatures.navigationCallback.onRerouting();
                }
                if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    GoogleMapPresentation.this.scheduleFollowRestore("offRoute");
                }
            }
        };
        this.routeChangedListener = new Navigator.RouteChangedListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.7
            @Override // com.google.android.libraries.navigation.Navigator.RouteChangedListener
            public void onRouteChanged() {
                Log.e("GMAPPP", "on route changed");
                if (BleFeatures.navigationCallback != null) {
                    BleFeatures.navigationCallback.onRouteReady();
                }
                Context safeContext = GoogleMapPresentation.this.getSafeContext();
                if (safeContext != null) {
                    MirroringPolicy.restoreClusterNetworkAfterRouting(safeContext);
                }
                if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    GoogleMapPresentation.this.ensureLiveRoutePolyline("routeChanged");
                    GoogleMapPresentation.this.scheduleFollowRestore("routeChanged");
                } else {
                    GoogleMapPresentation.this.showSharedRouteOnMap();
                }
            }
        };
        this.handler = handler;
        this.activity = activity;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gmap_route_pp);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        this.navigationView = navigationView;
        navigationView.onCreate(bundle);
        getGestureDetector();
    }

    private GestureDetector getGestureDetector() {
        if (this.gestureDetector == null) {
            this.gestureDetector = new GestureDetector(getSafeContext(), new GestureDetector.OnGestureListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    GoogleMapPresentation.this.changeCamera(CameraUpdateFactory.scrollBy(f, f2));
                    return false;
                }
            });
        }
        return this.gestureDetector;
    }

    @Override // android.app.Presentation, android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (GlobalVar.isNavigationActive) {
            MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
        } else {
            MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
        }
        this.navigationView.onStart();
        this.navigationView.onResume();
        GlobalVar.hydrateAppThemeFromPrefs(getContext());
        try {
            this.navigationView.setForceNightMode(GlobalVar.appThemeIsDark ? 2 : 1);
        } catch (Exception e) {
            Log.w("GMapPP", "setForceNightMode", e);
        }
        this.navigationView.getMapAsync(this);
    }

    @Override // android.app.Presentation, android.app.Dialog
    protected void onStop() {
        try {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                try {
                    navigationView.onPause();
                } catch (Exception unused) {
                }
                this.navigationView.onStop();
            }
        } catch (Exception e) {
            Log.e("GMapPP", "onStop failed", e);
        }
        try {
            super.onStop();
        } catch (Exception e2) {
            Log.e("GMapPP", "super.onStop failed", e2);
        }
        Log.e("GMapPP", "on stop called");
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onSaveInstanceState(bundleOnSaveInstanceState);
        }
        return bundleOnSaveInstanceState;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        MirroringGlobarVar.isSearchProcessing = false;
        this.googleMap = googleMap;
        this.navigationView.setRecenterButtonEnabled(false);
        this.navigationView.setPadding(0, 0, 0, -30);
        googleMap.setBuildingsEnabled(false);
        intializeNavigationApi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchRoute() {
        String apiKey = GmapUtil.getApiKey();
        FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url("https://maps.googleapis.com/maps/api/directions/json?origin=" + (MirroringGlobarVar.currentLat + "," + MirroringGlobarVar.currentLng) + "&destination=" + (String.valueOf(GlobalVar.lat) + "," + String.valueOf(GlobalVar.lng)) + "&key=" + apiKey).build()), new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.views.GoogleMapPresentation$2, reason: invalid class name */
    class AnonymousClass2 implements Callback {
        AnonymousClass2() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                try {
                    JSONArray jSONArray = new JSONObject(response.body().string()).getJSONArray("routes");
                    if (jSONArray.length() > 0) {
                        final List<LatLng> listDecodePolyline = GoogleMapPresentation.this.decodePolyline(jSONArray.getJSONObject(0).getJSONObject("overview_polyline").getString("points"));
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$2$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onResponse$0(listDecodePolyline);
                            }
                        });
                    } else {
                        Log.e("NavigationAtivity", "route null null");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(List list) {
            PolylineOptions polylineOptionsWidth = new PolylineOptions().addAll(list).color(-16776961).width(10.0f);
            GoogleMapPresentation.this.routePolyline = polylineOptionsWidth;
            GoogleMapPresentation.this.googleMap.addPolyline(polylineOptionsWidth);
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                builder.include((LatLng) it2.next());
            }
            GoogleMapPresentation.this.latLngBounds = builder.build();
            GoogleMapPresentation.this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(GoogleMapPresentation.this.latLngBounds, 120));
        }
    }

    public List<LatLng> decodePolyline(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
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
            arrayList.add(new LatLng(((double) i8) / 100000.0d, ((double) i5) / 100000.0d));
            i4 = i8;
            i3 = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        Toast.makeText(getContext(), str, 1).show();
    }

    private void registerListners() {
        Log.e("GoogleMApsPP", "register for pp");
        if (this.defaultNavigator.registerServiceForNavUpdates(getSafeContext().getPackageName(), NavInfoReceivingService.class.getName(), Integer.MAX_VALUE)) {
            Log.e("GoogleMApsPP", "Successfully registered service for nav updates");
        } else {
            Log.e("GoogleMApsPP", "Successfully registered service for nav updates");
        }
    }

    private void navigateToPlace(Place place, final boolean z) {
        Waypoint waypointBuild = Waypoint.builder().setLatLng(GlobalVar.lat.doubleValue(), GlobalVar.lng.doubleValue()).build();
        RoutingOptions routingOptions = new RoutingOptions();
        routingOptions.routingStrategy(1);
        routingOptions.travelMode(3);
        routingOptions.alternateRoutesStrategy(AlternateRoutesStrategy.SHOW_NONE);
        this.defaultNavigator.setDestination(waypointBuild, routingOptions, new DisplayOptions()).setOnResultListener(new ListenableResultFuture.OnResultListener<Navigator.RouteStatus>() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.3
            @Override // com.google.android.libraries.navigation.ListenableResultFuture.OnResultListener
            public void onResult(Navigator.RouteStatus routeStatus) {
                if (AnonymousClass8.$SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus[routeStatus.ordinal()] == 1) {
                    if (z) {
                        if (GoogleMapPresentation.this.latLngBounds != null) {
                            GoogleMapPresentation.this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(GoogleMapPresentation.this.latLngBounds, 120));
                            return;
                        } else {
                            GoogleMapPresentation.this.fetchRoute();
                            return;
                        }
                    }
                    GoogleMapPresentation.this.showSharedRouteOnMap();
                    if (GlobalVar.isIsTakeMeHomeNavStarting) {
                        LocalBroadcastManager.getInstance(GoogleMapPresentation.this.getSafeContext()).sendBroadcast(new Intent(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
                    }
                }
                if (routeStatus != Navigator.RouteStatus.OK) {
                    Log.e("GMAPPP", "error " + routeStatus);
                } else {
                    Log.e("GMAPPP", "success " + routeStatus);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.views.GoogleMapPresentation$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus;

        static {
            int[] iArr = new int[Navigator.RouteStatus.values().length];
            $SwitchMap$com$google$android$libraries$navigation$Navigator$RouteStatus = iArr;
            try {
                iArr[Navigator.RouteStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void intializeNavigationApi() {
        NavigationApi.getNavigator(this.activity, new NavigationApi.NavigatorListener() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation.4
            @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
            public void onError(int i) {
                if (i == 1) {
                    GoogleMapPresentation.this.showToast("Error loading Navigation API: Your API key is invalid or not authorized to use Navigation.");
                } else {
                    if (i != 2) {
                        return;
                    }
                    GoogleMapPresentation.this.showToast("Error loading Navigation API: User did not accept the Navigation Terms of Use.");
                }
            }

            @Override // com.google.android.libraries.navigation.NavigationApi.NavigatorListener
            public void onNavigatorReady(Navigator navigator) {
                GoogleMapPresentation.this.defaultNavigator = navigator;
                GoogleMapPresentation.this.addListners();
                GoogleMapPresentation.this.defaultNavigator.setHeadsUpNotificationEnabled(false);
                GoogleMapPresentation.this.googleMap.getUiSettings().setCompassEnabled(false);
                GoogleMapPresentation.this.googleMap.getUiSettings().setMapToolbarEnabled(false);
                GoogleMapPresentation.this.suppressGoogleNavChromeForMirror();
                navigator.setTaskRemovedBehavior(1);
                if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
                    GoogleMapPresentation.this.scheduleFollowRestore("navigatorReady/nav");
                } else if (GoogleMapPresentation.this.defaultNavigator.getCurrentTimeAndDistance() != null) {
                    GoogleMapPresentation.this.showSharedRouteOnMap();
                }
            }
        });
    }

    public void refreshRoutePreview() {
        showSharedRouteOnMap();
    }

    public void startNavigation() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startNavigation$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startNavigation$1() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null) {
            Log.e("GoogleMApsPP", "startNavigation: navigator is null");
            return;
        }
        if (navigator.getCurrentTimeAndDistance() == null) {
            Log.e("GoogleMApsPP", "startNavigation: route not ready");
            return;
        }
        registerListners();
        this.navigationView.setNavigationUiEnabled(true);
        this.googleMap.setMyLocationEnabled(true);
        suppressGoogleNavChromeForMirror();
        this.mirrorFollowZoom = MIRROR_FOLLOW_ZOOM_DEFAULT;
        this.currentMapZoom = MIRROR_FOLLOW_ZOOM_DEFAULT;
        GlobalVar.isNavigationActive = true;
        MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
        if (NavApplication.streamingHandler != null && NavApplication.streamingHandler.udpServerService != null) {
            NavApplication.streamingHandler.udpServerService.onScreenChange();
        }
        recenterNavigationCamera();
        ensureLiveRoutePolyline("startNavigation");
        this.mainHandler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startNavigation$0();
            }
        }, 500L);
        this.mainHandler.postDelayed(new GoogleMapPresentation$$ExternalSyntheticLambda10(this), 300L);
        this.mainHandler.postDelayed(new GoogleMapPresentation$$ExternalSyntheticLambda10(this), 900L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startNavigation$0() {
        ensureLiveRoutePolyline("startNavigationDelayed");
    }

    static /* synthetic */ void lambda$new$2(ArrivalEvent arrivalEvent) {
        Log.i("GoogleMapPP", "onArrival — defer to BleService distance gate");
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onDestinationReached();
        }
    }

    private void clearLiveRoutePolyline() {
        Polyline polyline = this.liveRoutePolyline;
        if (polyline != null) {
            polyline.remove();
            this.liveRoutePolyline = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureLiveRoutePolyline(final String str) {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || this.googleMap == null) {
            return;
        }
        try {
            List<RouteSegment> routeSegments = navigator.getRouteSegments();
            if (routeSegments != null && !routeSegments.isEmpty()) {
                final ArrayList arrayList = new ArrayList();
                Iterator<RouteSegment> it2 = routeSegments.iterator();
                while (it2.hasNext()) {
                    List<LatLng> latLngs = it2.next().getLatLngs();
                    if (latLngs != null && !latLngs.isEmpty()) {
                        arrayList.addAll(latLngs);
                    }
                }
                if (arrayList.size() >= 2) {
                    this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$ensureLiveRoutePolyline$3(arrayList, str);
                        }
                    });
                    return;
                }
                Log.w("GMAPPP", "ensureLiveRoutePolyline <2 pts (" + str + ")");
                return;
            }
            Log.w("GMAPPP", "ensureLiveRoutePolyline empty segments (" + str + ")");
        } catch (Exception e) {
            Log.w("GMAPPP", "ensureLiveRoutePolyline failed (" + str + ")", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureLiveRoutePolyline$3(List list, String str) {
        if (this.googleMap == null) {
            return;
        }
        clearLiveRoutePolyline();
        PolylineOptions polylineOptionsWidth = new PolylineOptions().addAll(list).color(-16776961).width(10.0f);
        this.routePolyline = polylineOptionsWidth;
        this.liveRoutePolyline = this.googleMap.addPolyline(polylineOptionsWidth);
        this.isRouteDrawn = true;
        Log.d("GMAPPP", "ensureLiveRoutePolyline " + str + " pts=" + list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSharedRouteOnMap() {
        if (this.navigationView == null || this.googleMap == null) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showSharedRouteOnMap$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSharedRouteOnMap$5() {
        this.navigationView.setNavigationUiEnabled(true);
        suppressGoogleNavChromeForMirror();
        if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
            scheduleFollowRestore("showSharedRouteOnMap/nav");
            return;
        }
        try {
            this.googleMap.setMyLocationEnabled(false);
            this.navigationView.showRouteOverview();
            this.mainHandler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showSharedRouteOnMap$4();
                }
            }, 500L);
        } catch (Exception e) {
            Log.e("GMAPPP", "showRouteOverview failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSharedRouteOnMap$4() {
        NavigationView navigationView;
        if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN || (navigationView = this.navigationView) == null) {
            return;
        }
        try {
            navigationView.showRouteOverview();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recenterNavigationCamera() {
        Context safeContext;
        if (this.googleMap == null || (safeContext = getSafeContext()) == null) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(safeContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(safeContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            try {
                NavigationView navigationView = this.navigationView;
                if (navigationView != null) {
                    navigationView.setNavigationUiEnabled(true);
                    suppressGoogleNavChromeForMirror();
                }
                this.googleMap.setMyLocationEnabled(true);
                this.googleMap.setPadding(0, 0, 0, MIRROR_LOGO_BOTTOM_PADDING_PX);
                this.googleMap.followMyLocation(2, FollowMyLocationOptions.builder().setZoomLevel(this.mirrorFollowZoom).build());
            } catch (Exception e) {
                Log.e("GMAPPP", "recenterNavigationCamera failed", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suppressGoogleNavChromeForMirror() {
        NavigationView navigationView = this.navigationView;
        if (navigationView == null) {
            return;
        }
        try {
            navigationView.setEtaCardEnabled(false);
            this.navigationView.setHeaderEnabled(false);
            this.navigationView.setTripProgressBarEnabled(false);
            this.navigationView.setRecenterButtonEnabled(false);
            this.navigationView.setSpeedLimitIconEnabled(false);
            this.navigationView.setSpeedometerEnabled(false);
            this.navigationView.setTrafficIncidentCardsEnabled(false);
            this.navigationView.setTrafficPromptsEnabled(false);
        } catch (Exception e) {
            Log.e("GMAPPP", "suppressGoogleNavChromeForMirror failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleFollowRestore(String str) {
        Log.d("GMAPPP", "scheduleFollowRestore: " + str);
        this.mainHandler.post(new GoogleMapPresentation$$ExternalSyntheticLambda10(this));
        this.mainHandler.postDelayed(new GoogleMapPresentation$$ExternalSyntheticLambda10(this), 300L);
        this.mainHandler.postDelayed(new GoogleMapPresentation$$ExternalSyntheticLambda10(this), 1000L);
        this.mainHandler.postDelayed(new GoogleMapPresentation$$ExternalSyntheticLambda10(this), 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addListners() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || this.navigatorListenersAttached) {
            return;
        }
        navigator.addNavigationSessionListener(this.navigationSessionListener);
        this.defaultNavigator.addArrivalListener(this.arrivalListener);
        this.defaultNavigator.addReroutingListener(this.reroutingListener);
        this.defaultNavigator.addRouteChangedListener(this.routeChangedListener);
        this.navigatorListenersAttached = true;
    }

    private void removeListners() {
        Navigator navigator = this.defaultNavigator;
        if (navigator == null || !this.navigatorListenersAttached) {
            return;
        }
        navigator.removeNavigationSessionListener(this.navigationSessionListener);
        this.defaultNavigator.removeArrivalListener(this.arrivalListener);
        this.defaultNavigator.removeReroutingListener(this.reroutingListener);
        this.defaultNavigator.removeRouteChangedListener(this.routeChangedListener);
        this.navigatorListenersAttached = false;
    }

    public synchronized void zoomInTFT() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomInTFT$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomInTFT$6() {
        if (this.googleMap == null) {
            Log.e("GMapPP", "g map null");
            return;
        }
        float fMin = Math.min(this.mirrorFollowZoom + 0.5f, 20.0f);
        this.mirrorFollowZoom = fMin;
        this.currentMapZoom = fMin;
        if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
            recenterNavigationCamera();
        } else {
            this.googleMap.moveCamera(CameraUpdateFactory.zoomTo(this.mirrorFollowZoom));
        }
    }

    public synchronized void zoomOutTft() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomOutTft$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomOutTft$7() {
        if (this.googleMap == null) {
            Log.e("GMapPP", "g map null");
            return;
        }
        float fMax = Math.max(this.mirrorFollowZoom - 0.5f, MIRROR_FOLLOW_ZOOM_MIN);
        this.mirrorFollowZoom = fMax;
        this.currentMapZoom = fMax;
        if (GlobalVar.isNavigationActive || MirroringGlobarVar.currentScreen == Screens.TBT_SCREEN) {
            recenterNavigationCamera();
        } else {
            this.googleMap.moveCamera(CameraUpdateFactory.zoomTo(this.mirrorFollowZoom));
        }
    }

    public void backToRoute() {
        try {
            this.defaultNavigator.getSimulator().unsetUserLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.defaultNavigator.stopGuidance();
        removeListners();
        this.defaultNavigator.unregisterServiceForNavUpdates();
        GlobalVar.isNavigationActive = false;
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStop();
        }
        try {
            this.googleMap.setMyLocationEnabled(false);
        } catch (Exception unused) {
        }
        this.navigationView.setRecenterButtonEnabled(false);
        this.navigationView.setSpeedLimitIconEnabled(false);
        this.navigationView.setSpeedometerEnabled(false);
        Place place = new Place();
        place.setLat(GlobalVar.lat);
        place.setLng(GlobalVar.lng);
        LatLngBounds latLngBounds = this.latLngBounds;
        if (latLngBounds != null) {
            this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 1));
        } else {
            fetchRoute();
        }
    }

    public void stopNavigation() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopNavigation$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopNavigation$8() {
        try {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                navigationView.setNavigationUiEnabled(false);
            }
            GlobalVar.isNavigationActive = false;
        } catch (Exception e) {
            Log.e("GMapPP", "stopNavigation failed", e);
        }
    }

    public void followMe(boolean z) {
        if (z) {
            recenterNavigationCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCamera(CameraUpdate cameraUpdate) {
        changeCamera(cameraUpdate, null);
    }

    private void moveCamera() {
        changeCamera(CameraUpdateFactory.scrollBy(0.0f, -100.0f));
    }

    private void changeCamera(final CameraUpdate cameraUpdate, GoogleMap.CancelableCallback cancelableCallback) {
        this.mainHandler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.GoogleMapPresentation$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeCamera$9(cameraUpdate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeCamera$9(CameraUpdate cameraUpdate) {
        this.googleMap.moveCamera(cameraUpdate);
    }
}
