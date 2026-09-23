package com.bajajconnect.wifi.views;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.gMaps.util.GmapUtil;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.navigate.adapter.NavigationPagerAdapter;
import com.bajajconnect.navigate.maps.plugins.BearingIconPlugin;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.maps.plugins.MapEventsPlugin;
import com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin;
import com.bajajconnect.navigate.model.Stop;
import com.bajajconnect.navigate.poi.PoiModel;
import com.bajajconnect.navigate.poi.PoiResultsAdapter;
import com.bajajconnect.navigate.utils.NavigationLocationEngine;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.Screens;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.LocationComponentConstants;
import com.mappls.sdk.maps.location.LocationComponentOptions;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineProvider;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.utils.MathUtils;
import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationLocationProvider;
import com.mappls.sdk.navigation.camera.NavigationCamera;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.events.NavEvent;
import com.mappls.sdk.navigation.iface.INavigationListener;
import com.mappls.sdk.navigation.iface.JunctionInfoChangedListener;
import com.mappls.sdk.navigation.iface.JunctionViewsLoadedListener;
import com.mappls.sdk.navigation.iface.LocationChangedListener;
import com.mappls.sdk.navigation.iface.NavigationEventListener;
import com.mappls.sdk.navigation.iface.NavigationEventLoadedListener;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.util.GPSInfo;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class VirtualNavigationPresentation extends Presentation implements LocationChangedListener, MapplsMap.OnMoveListener, INavigationListener, OnMapReadyCallback, LocationEngineCallback<LocationEngineResult> {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f36app;
    private BearingIconPlugin bearingIconPlugin;
    private NavigationCamera camera;
    private LinearLayout cardview;
    public float currentMapZoom;
    private int currentPageLocation;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private AnimationSet fadeInSlowOut;
    public boolean followMeFlag;
    Handler gpsHandler;
    private GPSInfo gpsInfo;
    Runnable gpsRunnable;
    private boolean isItSaveForFragmentTransaction;
    private boolean isNavEventVisible;
    private ImageView junctionViewImageView;
    private LocationEngine locationEngine;
    private LocationComponent locationPlugin;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean mFragmentTransactionSave;
    private MapEventsPlugin mapEventsPlugin;
    public MapView mapView;
    private MapplsMap mapplsMap;
    private Bitmap navEventBitmap;
    private TextView navEventDistance;
    private ImageView navEventImage;
    private TextView navEventLbl;
    private ExecutorService networkExecutor;
    private OkHttpClient okHttpClient;
    private PoiResultsAdapter poiAdapter;
    private LinearLayout poiCategoryContainer;
    private RecyclerView poiResultsList;
    private RouteArrowPlugin routeArrowPlugin;
    private boolean setCompassClick;

    /* JADX INFO: Access modifiers changed from: private */
    interface OnImageAdded {
        void getBitmap(Bitmap bitmap);
    }

    void dismissSnackBar() {
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onFailure(Exception exc) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMove(MoveGestureDetector moveGestureDetector) {
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onWayPointReached(WayPoint wayPoint) {
    }

    void showSnackBar(String str) {
    }

    public VirtualNavigationPresentation(Context context, Display display) {
        super(context, display);
        this.gpsHandler = new Handler();
        this.isItSaveForFragmentTransaction = true;
        this.mFragmentTransactionSave = true;
        this.currentPageLocation = 1;
        this.isNavEventVisible = false;
        this.okHttpClient = new OkHttpClient();
        this.networkExecutor = Executors.newSingleThreadExecutor();
        this.gpsRunnable = new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };
        this.setCompassClick = false;
        this.currentMapZoom = 14.5f;
        this.followMeFlag = true;
    }

    public VirtualNavigationPresentation(Context context, Display display, int i) {
        super(context, display, i);
        this.gpsHandler = new Handler();
        this.isItSaveForFragmentTransaction = true;
        this.mFragmentTransactionSave = true;
        this.currentPageLocation = 1;
        this.isNavEventVisible = false;
        this.okHttpClient = new OkHttpClient();
        this.networkExecutor = Executors.newSingleThreadExecutor();
        this.gpsRunnable = new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };
        this.setCompassClick = false;
        this.currentMapZoom = 14.5f;
        this.followMeFlag = true;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_navigation_new);
        this.mapView = (MapView) findViewById(R.id.map_view_new);
        this.junctionViewImageView = (ImageView) findViewById(R.id.junction_view_new);
        this.mBroadcastReceiver = new MyLocalBroadcastReceiver();
        this.f36app = NavApplication.forFragments();
        this.cardview = (LinearLayout) findViewById(R.id.tft_nav_event_view);
        this.navEventDistance = (TextView) findViewById(R.id.tft_nav_event_distance);
        this.navEventLbl = (TextView) findViewById(R.id.tft_nav_event_lbl);
        this.navEventImage = (ImageView) findViewById(R.id.tft_event_icon);
        try {
            this.poiCategoryContainer = (LinearLayout) findViewById(R.id.poi_category_container);
            this.poiResultsList = (RecyclerView) findViewById(R.id.poi_results_list);
        } catch (Throwable unused) {
            this.poiCategoryContainer = null;
            this.poiResultsList = null;
        }
        if (this.poiCategoryContainer != null) {
            String[][] strArr = {new String[]{PlaceTypes.GAS_STATION, "Petrol"}, new String[]{PlaceTypes.CAFE, "Cafes"}, new String[]{PlaceTypes.RESTAURANT, "Restaurants"}, new String[]{PlaceTypes.ATM, "ATM"}, new String[]{PlaceTypes.HOSPITAL, "Hospital"}};
            if (this.poiResultsList != null) {
                this.poiAdapter = new PoiResultsAdapter(new PoiResultsAdapter.OnItemClickListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda6
                    @Override // com.bajajconnect.navigate.poi.PoiResultsAdapter.OnItemClickListener
                    public final void onItemClick(PoiModel poiModel) {
                        this.f$0.lambda$onCreate$0(poiModel);
                    }
                });
                this.poiResultsList.setLayoutManager(new LinearLayoutManager(getContext()));
                this.poiResultsList.setAdapter(this.poiAdapter);
            }
            for (int i = 0; i < 5; i++) {
                String[] strArr2 = strArr[i];
                TextView textView = new TextView(getContext());
                textView.setText(strArr2[1]);
                textView.setTag(strArr2[0]);
                textView.setPadding(20, 10, 20, 10);
                textView.setTextColor(getContext().getResources().getColor(R.color.app_blue));
                textView.setBackground(getContext().getResources().getDrawable(R.drawable.sound_chip_background));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(8, 8, 8, 8);
                textView.setLayoutParams(layoutParams);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreate$1(view);
                    }
                });
                this.poiCategoryContainer.addView(textView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        String str = (String) view.getTag();
        Toast.makeText(getContext(), "Searching: " + str, 0).show();
        fetchPlaces(str);
        RecyclerView recyclerView = this.poiResultsList;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPolyLine() {
        if (getContext() == null) {
            return;
        }
        new ArrayList();
        String strGeometry = MapplsNavigationHelper.getInstance().getCurrentRoute().geometry();
        Timber.e(MapplsNavigationHelper.getInstance().getCurrentRoute().toJson(), new Object[0]);
        if (this.directionPolylinePlugin != null) {
            LatLng latLng = (this.f36app.getELocation() == null || this.f36app.getELocation().latitude == null || this.f36app.getELocation().longitude == null) ? null : new LatLng(this.f36app.getELocation().latitude.doubleValue(), this.f36app.getELocation().longitude.doubleValue());
            ArrayList arrayList = new ArrayList();
            arrayList.add(LineString.fromPolyline(strGeometry, 6));
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.f36app.getTrip().waypoints().size() - 1; i++) {
                try {
                    if (i != 0) {
                        Point pointLocation = this.f36app.getTrip().waypoints().get(i).location();
                        arrayList2.add(new LatLng(pointLocation.latitude(), pointLocation.longitude()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(MapplsNavigationHelper.getInstance().getCurrentRoute());
            this.directionPolylinePlugin.setTrips(arrayList, null, latLng, arrayList2, arrayList3);
            this.directionPolylinePlugin.setEnabled(true);
            this.directionPolylinePlugin.setEnableCongestion(true);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        BleFeatures.navigationCallback.onNavigationStop();
        MapplsNavigationHelper.getInstance().stopNavigation();
    }

    public NavApplication getMyApplication() {
        if (getContext() != null) {
            return NavApplication.forFragments();
        }
        return null;
    }

    float getLocationAngle(NavLocation navLocation) {
        try {
            List<NavLocation> path = getMyApplication().getCalculatedRoute().getPath();
            return (float) MathUtils.wrap(navLocation.bearingTo(path.get(path.indexOf(navLocation) + 1)), 0.0d, 360.0d);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(final MapplsMap mapplsMap) {
        try {
            Timber.e("onMapReady", new Object[0]);
            Log.e("VirtualNavigation", "onMap ready");
            this.mapplsMap = mapplsMap;
            mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 110);
            mapplsMap.getUiSettings().setLogoEnabled(true);
            MirroringGlobarVar.isSearchProcessing = false;
            mapplsMap.getStyle(new Style.OnStyleLoaded() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda9
                @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
                public final void onStyleLoaded(Style style) {
                    this.f$0.lambda$onMapReady$3(mapplsMap, style);
                }
            });
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$3(MapplsMap mapplsMap, Style style) {
        setCompassDrawable();
        enableLocationComponenet(style);
        try {
            this.mapplsMap.removeAnnotations();
            LocationComponent locationComponent = this.mapplsMap.getLocationComponent();
            this.locationPlugin = locationComponent;
            locationComponent.setRenderMode(8);
            this.directionPolylinePlugin = new DirectionPolylinePlugin(this.mapView, this.mapplsMap);
            this.bearingIconPlugin = new BearingIconPlugin(this.mapView, this.mapplsMap);
            this.routeArrowPlugin = new RouteArrowPlugin(this.mapView, this.mapplsMap);
            this.mapEventsPlugin = new MapEventsPlugin(this.mapView, this.mapplsMap);
            List<NavigationStep> routeDirections = this.f36app.getRouteDirections();
            AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
            LegStep legStep = (LegStep) routeDirections.get(adviseInfo.getPosition() == 0 ? adviseInfo.getPosition() : adviseInfo.getPosition() - 1).getExtraInfo();
            RouteArrowPlugin routeArrowPlugin = this.routeArrowPlugin;
            if (routeArrowPlugin != null) {
                routeArrowPlugin.addUpcomingManeuverArrow(legStep, null);
            }
            this.directionPolylinePlugin.setOnNewRouteSelectedListener(new DirectionPolylinePlugin.OnNewRouteSelectedListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.2
                @Override // com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.OnNewRouteSelectedListener
                public void onNewRouteSelected(int i, DirectionsRoute directionsRoute) {
                    MapplsNavigationHelper.getInstance().setRouteIndex(i);
                }
            });
            BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
            if (bearingIconPlugin != null) {
                bearingIconPlugin.setBearingLayerVisibility(false);
                this.bearingIconPlugin.setBearingIcon(0.0f, null);
            }
            mapplsMap.addOnMoveListener(this);
            NavigationCamera navigationCamera = this.camera;
            if (navigationCamera != null) {
                navigationCamera.updateCameraTrackingMode(0);
                adviseInfo.setLocation(NavigationLocationProvider.convertLocation(getLocationForNavigation(), this.f36app));
                onRouteProgress(MapplsNavigationHelper.getInstance().getAdviseInfo());
            }
            this.mapView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return VirtualNavigationPresentation.lambda$onMapReady$2(view, motionEvent);
                }
            });
            if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                locationModeNavigation(true);
            }
            setNavigationPadding(true);
            drawPolyLine();
            initCamera();
            this.mapplsMap.setMaxZoomPreference(18.5d);
            this.mapplsMap.setMinZoomPreference(4.0d);
            followMe(true);
            style.getLayer(LocationComponentConstants.SHADOW_LAYER).setProperties(PropertyFactory.visibility("none"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ boolean lambda$onMapReady$2(View view, MotionEvent motionEvent) {
        Log.e("VirtualN", "mapview touch");
        return view.onTouchEvent(motionEvent);
    }

    private void enableLocationComponenet(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(getContext())) {
            LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(getContext()).trackingGesturesManagement(true).accuracyAlpha(0.0f).accuracyColor(ContextCompat.getColor(getContext(), R.color.accuracy_green)).build();
            LocationComponent locationComponent = this.mapplsMap.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(getContext(), style).locationComponentOptions(locationComponentOptionsBuild).build());
            if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                locationComponent.setLocationComponentEnabled(true);
                this.locationEngine = locationComponent.getLocationEngine();
                this.locationEngine.requestLocationUpdates(new LocationEngineRequest.Builder(1000L).setPriority(0).setFastestInterval(100L).build(), this, getContext().getMainLooper());
                locationComponent.setCameraMode(24);
                locationComponent.setRenderMode(4);
            }
        }
    }

    public void setCompassDrawable() {
        this.mapView.getCompassView().setEnabled(false);
    }

    public int dpToPx(float f) {
        return (int) (f * getResources().getDisplayMetrics().density);
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        Timber.e(i + "------" + str, new Object[0]);
    }

    private void fetchPlaces(String str) {
        Double d;
        Double d2;
        try {
            if (MirroringGlobarVar.currentLat != null && MirroringGlobarVar.currentLng != null) {
                d = MirroringGlobarVar.currentLat;
                d2 = MirroringGlobarVar.currentLng;
            } else {
                NavApplication navApplication = this.f36app;
                if (navApplication == null || navApplication.getELocation() == null || this.f36app.getELocation().latitude == null || this.f36app.getELocation().longitude == null) {
                    d = null;
                    d2 = null;
                } else {
                    d = this.f36app.getELocation().latitude;
                    d2 = this.f36app.getELocation().longitude;
                }
            }
            if (d != null && d2 != null) {
                double dDoubleValue = d.doubleValue();
                double dDoubleValue2 = d2.doubleValue();
                FirebasePerfOkHttpClient.enqueue(this.okHttpClient.newCall(new Request.Builder().url("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + dDoubleValue + "," + dDoubleValue2 + "&radius=5000&type=" + str + "&key=" + GmapUtil.getApiKey()).build()), new AnonymousClass3(dDoubleValue, dDoubleValue2));
                return;
            }
            Toast.makeText(getContext(), "Current location unknown", 0).show();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.views.VirtualNavigationPresentation$3, reason: invalid class name */
    class AnonymousClass3 implements Callback {
        final /* synthetic */ double val$baseLatVal;
        final /* synthetic */ double val$baseLngVal;

        AnonymousClass3(double d, double d2) {
            this.val$baseLatVal = d;
            this.val$baseLngVal = d2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Timber.e(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            String strString = response.body() != null ? response.body().string() : null;
            if (strString == null) {
                return;
            }
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(strString).optJSONArray("results");
                final ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("name");
                        String strOptString2 = jSONObject.optString("vicinity", jSONObject.optString("formatted_address"));
                        String strOptString3 = jSONObject.optString("place_id");
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("geometry");
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(FirebaseAnalytics.Param.LOCATION) : null;
                        double dOptDouble = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optDouble("lat", 0.0d) : 0.0d;
                        double dOptDouble2 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optDouble("lng", 0.0d) : 0.0d;
                        float[] fArr = new float[1];
                        Location.distanceBetween(this.val$baseLatVal, this.val$baseLngVal, dOptDouble, dOptDouble2, fArr);
                        PoiModel poiModel = new PoiModel(strOptString3, strOptString, strOptString2, dOptDouble, dOptDouble2);
                        poiModel.distanceMeters = fArr[0];
                        arrayList = arrayList;
                        arrayList.add(poiModel);
                    }
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResponse$0(arrayList);
                    }
                });
            } catch (JSONException e) {
                Timber.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(List list) {
            if (VirtualNavigationPresentation.this.poiAdapter != null) {
                VirtualNavigationPresentation.this.poiAdapter.setItems(list);
            }
            if (VirtualNavigationPresentation.this.poiResultsList != null) {
                VirtualNavigationPresentation.this.poiResultsList.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onPoiClicked, reason: merged with bridge method [inline-methods] */
    public void lambda$onCreate$0(final PoiModel poiModel) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(poiModel.name);
            builder.setMessage(poiModel.address == null ? "" : poiModel.address);
            builder.setPositiveButton("Navigate", new DialogInterface.OnClickListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onPoiClicked$4(poiModel, dialogInterface, i);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPoiClicked$4(PoiModel poiModel, DialogInterface dialogInterface, int i) {
        startNavigationTo(poiModel);
    }

    private void startNavigationTo(PoiModel poiModel) {
        try {
            GlobalVar.lat = Double.valueOf(poiModel.lat);
            GlobalVar.lng = Double.valueOf(poiModel.lng);
            ELocation eLocation = new ELocation();
            eLocation.latitude = Double.valueOf(poiModel.lat);
            eLocation.longitude = Double.valueOf(poiModel.lng);
            eLocation.placeName = poiModel.name;
            eLocation.placeAddress = poiModel.address;
            NavApplication.eLocation = eLocation;
            Intent intent = new Intent(getContext(), (Class<?>) HomeActivity.class);
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public void startNavigation() {
        MapplsNavigationHelper.getInstance().addNavigationListener(this);
        MapplsNavigationHelper.getInstance().addNavigationListener(StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen);
        onRouteProgress(MapplsNavigationHelper.getInstance().getAdviseInfo());
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventLoadedListener(new NavigationEventLoadedListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.4
            @Override // com.mappls.sdk.navigation.iface.NavigationEventLoadedListener
            public void onNavigationEventsLoaded(List<ReportDetails> list) {
                Timber.d(new Gson().toJson(list), new Object[0]);
                if (MapplsNavigationHelper.getInstance().getEvents() == null || MapplsNavigationHelper.getInstance().getEvents().size() <= 0 || VirtualNavigationPresentation.this.mapEventsPlugin == null) {
                    return;
                }
                VirtualNavigationPresentation.this.mapEventsPlugin.setNavigationEvents(MapplsNavigationHelper.getInstance().getEvents());
            }
        });
        MapplsNavigationHelper.getInstance().setJunctionInfoChangedListener(new JunctionInfoChangedListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.5
            @Override // com.mappls.sdk.navigation.iface.JunctionInfoChangedListener
            public void junctionInfoChanged(Junction junction) {
                if (junction == null) {
                    Timber.tag("JunctionView").d("Junction point is null", new Object[0]);
                    VirtualNavigationPresentation.this.junctionViewImageView.setVisibility(4);
                    Log.e("VirtualNavigationFragment", "junction view invisible");
                } else {
                    Timber.tag("JunctionView").d("Junction View approaching %s", Double.valueOf(junction.getLeftDistance()));
                    if (junction.bitmap != null) {
                        VirtualNavigationPresentation.this.junctionViewImageView.setImageBitmap(junction.bitmap);
                    }
                    Log.e("VirtualNavigationFragment", "junction view visible");
                    VirtualNavigationPresentation.this.junctionViewImageView.setVisibility(0);
                }
            }
        });
        MapplsNavigationHelper.getInstance().setJunctionVisualPromptBefore(200);
        MapplsNavigationHelper.getInstance().setJunctionViewsLoadedListener(new JunctionViewsLoadedListener() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.6
            @Override // com.mappls.sdk.navigation.iface.JunctionViewsLoadedListener
            public void onJunctionViewsLoaded(List<Junction> list) {
            }
        });
        MapplsNavigationHelper.getInstance().setNavigationEventListener(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: com.bajajconnect.wifi.views.VirtualNavigationPresentation$7, reason: invalid class name */
    class AnonymousClass7 implements NavigationEventListener {
        AnonymousClass7() {
        }

        @Override // com.mappls.sdk.navigation.iface.NavigationEventListener
        public void onNavigationEvent(NavEvent navEvent) {
            if (navEvent != null) {
                Log.e("NavigationFragment", "Navigation Event approaching %s in %f" + navEvent.getName() + navEvent.getDistanceLeft());
                Timber.d("Navigation Event approaching %s in %f", navEvent.getName(), Double.valueOf(navEvent.getDistanceLeft()));
                if (!VirtualNavigationPresentation.this.isNavEventVisible) {
                    VirtualNavigationPresentation.this.isNavEventVisible = true;
                }
                VirtualNavigationPresentation.this.cardview.setVisibility(0);
                int distanceLeft = (int) navEvent.getDistanceLeft();
                VirtualNavigationPresentation.this.navEventDistance.setText(distanceLeft + " m");
                VirtualNavigationPresentation.this.navEventLbl.setText(navEvent.getName());
                if (VirtualNavigationPresentation.this.navEventBitmap == null) {
                    VirtualNavigationPresentation.this.getBitmap(navEvent.getReportDetails().getReportIcon("48px"), new OnImageAdded() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$7$$ExternalSyntheticLambda0
                        @Override // com.bajajconnect.wifi.views.VirtualNavigationPresentation.OnImageAdded
                        public final void getBitmap(Bitmap bitmap) {
                            this.f$0.lambda$onNavigationEvent$0(bitmap);
                        }
                    });
                    return;
                } else {
                    VirtualNavigationPresentation.this.navEventImage.setImageBitmap(VirtualNavigationPresentation.this.navEventBitmap);
                    return;
                }
            }
            if (VirtualNavigationPresentation.this.isNavEventVisible) {
                VirtualNavigationPresentation.this.isNavEventVisible = false;
                VirtualNavigationPresentation.this.navEventBitmap = null;
                VirtualNavigationPresentation.this.navEventImage.setImageBitmap(null);
                VirtualNavigationPresentation.this.cardview.setVisibility(4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNavigationEvent$0(final Bitmap bitmap) {
            Log.e("NavigationFragment", "icon downloaded");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.7.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("NavigationFragment", "icon downloaded set image");
                    VirtualNavigationPresentation.this.navEventBitmap = bitmap;
                    VirtualNavigationPresentation.this.navEventImage.setImageBitmap(bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBitmap(final String str, final OnImageAdded onImageAdded) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                VirtualNavigationPresentation.lambda$getBitmap$6(str, onImageAdded);
            }
        });
    }

    static /* synthetic */ void lambda$getBitmap$6(String str, OnImageAdded onImageAdded) {
        URL url;
        Bitmap bitmapDecodeStream = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).getInputStream());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        onImageAdded.getBitmap(bitmapDecodeStream);
    }

    @Override // android.app.Presentation, android.app.Dialog
    protected void onStop() {
        super.onStop();
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.removeAllData();
        }
        if (!GlobalVar.isNavigationActive && this.locationPlugin != null) {
            Log.e("NavigationFragment", "set location component disable");
            this.locationPlugin.setLocationComponentEnabled(false);
            locationModeNavigation(false);
        }
        this.camera = null;
        MapplsNavigationHelper.getInstance().removeNavigationListener(this);
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.removeOnMoveListener(this);
            this.mapplsMap.removeAnnotations();
        }
    }

    @Override // android.app.Presentation, android.app.Dialog
    public void onStart() {
        super.onStart();
        initViews();
        NavApplication.streamingHandler.udpServerService.onScreenChange();
        MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
        Log.e("VirtualNavigation", "on start");
        this.mapView.getMapAsync(this);
        startNavigation();
    }

    private void initCamera() {
        try {
            NavigationCamera navigationCamera = new NavigationCamera(this.mapplsMap);
            this.camera = navigationCamera;
            navigationCamera.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void locationModeNavigation(boolean z) {
        try {
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap == null) {
                return;
            }
            if (z) {
                this.f36app.getLocationProvider().setLocationChangedListener(this);
                Location locationForNavigation = getLocationForNavigation();
                if (this.locationPlugin != null && !this.mapView.isDestroyed()) {
                    this.locationPlugin.forceLocationUpdate(locationForNavigation);
                }
                this.mapplsMap.getLocationComponent().setLocationEngine(new NavigationLocationEngine());
                followMe(true);
                return;
            }
            mapplsMap.getLocationComponent().setLocationEngine(LocationEngineProvider.getBestLocationEngine(getContext()));
            this.f36app.getLocationProvider().setLocationChangedListener(null);
            this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().bearing(0.0d).tilt(0.0d).build()));
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public Location getLocationForNavigation() {
        if (getContext() == null) {
            return null;
        }
        Location location = new Location("gps");
        NavLocation navLocation = MirroringGlobarVar.startNavigationLocationMirroring;
        if (navLocation != null) {
            location.setLatitude(navLocation.getLatitude());
            location.setLongitude(navLocation.getLongitude());
        }
        try {
            NavLocation firstLocation = MapplsNavigationHelper.getInstance().getFirstLocation();
            if (firstLocation.distanceTo(NavigationLocationProvider.convertLocation(location, this.f36app)) < 10.0f) {
                firstLocation.setBearing(firstLocation.bearingTo(MapplsNavigationHelper.getInstance().getSecondLocation()));
                return NavigationLocationProvider.revertLocation(firstLocation, this.f36app);
            }
            if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            LocationComponent locationComponent = this.locationPlugin;
            Location lastKnownLocation = locationComponent != null ? locationComponent.getLastKnownLocation() : null;
            return lastKnownLocation != null ? lastKnownLocation : NavigationLocationProvider.revertLocation(this.f36app.getLocationProvider().getFirstTimeRunDefaultLocation(), this.f36app);
        } catch (Exception e) {
            Timber.e(e);
            return NavigationLocationProvider.revertLocation(this.f36app.getLocationProvider().getFirstTimeRunDefaultLocation(), this.f36app);
        }
    }

    public synchronized void followMe(boolean z) {
        Location lastKnownLocation;
        if (getContext() == null) {
            return;
        }
        this.followMeFlag = z;
        if (z) {
            setNavigationPadding(true);
            if ((ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) && (lastKnownLocation = this.locationPlugin.getLastKnownLocation()) != null) {
                Log.e("VirtualNavigatin", "move camers");
                this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(0.0d).zoom(14.5d).target(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())).build()));
            }
            BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
            if (bearingIconPlugin != null) {
                bearingIconPlugin.setBearingLayerVisibility(false);
            }
        }
        if (z) {
            this.camera.updateCameraTrackingMode(0);
            Log.e("Virturesentation", "set camera gps");
        } else {
            Log.e("Virturesentation", "set camera null");
            this.camera.updateCameraTrackingMode(2);
        }
    }

    public void setCompassClick() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.8
            @Override // java.lang.Runnable
            public void run() {
                if (!VirtualNavigationPresentation.this.setCompassClick) {
                    VirtualNavigationPresentation.this.setCompassClick = false;
                    VirtualNavigationPresentation.this.camera.updateCameraTrackingMode(1);
                } else {
                    VirtualNavigationPresentation.this.setCompassClick = true;
                    VirtualNavigationPresentation.this.camera.updateCameraTrackingMode(0);
                }
            }
        });
    }

    private void mute() {
        MapplsNavigationHelper.getInstance().setMute(true);
    }

    private void unmute() {
        MapplsNavigationHelper.getInstance().setMute(false);
    }

    private void initAnimations() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        alphaAnimation2.setStartOffset(1000L);
        alphaAnimation2.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        this.fadeInSlowOut = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.fadeInSlowOut.addAnimation(alphaAnimation2);
    }

    public void toggleMute() {
        if (MapplsNavigationHelper.getInstance().isMute()) {
            unmute();
        } else {
            mute();
        }
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onLocationChanged(Location location) {
        this.gpsHandler.removeCallbacksAndMessages(null);
        if (getContext() == null || location == null || this.mapplsMap == null || !this.mFragmentTransactionSave || this.mapView.isDestroyed()) {
            return;
        }
        LocationComponent locationComponent = this.locationPlugin;
        if (locationComponent != null) {
            locationComponent.forceLocationUpdate(location);
        }
        dismissSnackBar();
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onGPSConnectionChanged(boolean z) {
        if (z) {
            BleFeatures.navigationCallback.onGpsStateChange(true);
            showSnackBar(getContext().getString(R.string.gps_connection_restored));
            dismissSnackBar();
        } else {
            BleFeatures.navigationCallback.onGpsStateChange(false);
            showSnackBar(getContext().getString(R.string.gps_connection_lost));
        }
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onSatelliteInfoChanged(GPSInfo gPSInfo) {
        this.gpsInfo = gPSInfo;
        this.gpsHandler.postDelayed(this.gpsRunnable, 2000L);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationStarted() {
        BleFeatures.navigationCallback.onNavigationStart();
        Timber.e("onNavigationStarted", new Object[0]);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onReRoutingRequested() {
        Timber.e("onReRoutingRequested", new Object[0]);
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onRerouting();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReRoutingRequested$7();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReRoutingRequested$8();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReRoutingRequested$7() {
        try {
            LocationComponent locationComponent = this.locationPlugin;
            if (locationComponent != null) {
                locationComponent.setLocationComponentEnabled(true);
                Location locationForNavigation = getLocationForNavigation();
                if (locationForNavigation != null) {
                    this.locationPlugin.forceLocationUpdate(locationForNavigation);
                }
            }
            followMe(true);
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReRoutingRequested$8() {
        try {
            followMe(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onEvent(NavEvent navEvent) {
        if (navEvent != null) {
            Log.e("VirtualNavigationFragment", "distanceLeft " + navEvent.getDistanceLeft());
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onAlternateRoutesUpdate(List<AlternateRoute> list) {
        super.onAlternateRoutesUpdate(list);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onBetterRouteAvailable(List<DirectionsRoute> list) {
        super.onBetterRouteAvailable(list);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRerouteFailed(int i, String str) {
        super.onRerouteFailed(i, str);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onETARefreshed(String str) {
        Log.e("OnEtaRefreshed", "eta " + str);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNewRoute(String str) {
        if (getContext() == null) {
            return;
        }
        Timber.e("onNewRoute", new Object[0]);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation.9
            @Override // java.lang.Runnable
            public void run() {
                if (VirtualNavigationPresentation.this.getContext() == null) {
                    return;
                }
                VirtualNavigationPresentation.this.setAdapter();
                if (VirtualNavigationPresentation.this.mapplsMap != null) {
                    VirtualNavigationPresentation.this.mapplsMap.removeAnnotations();
                }
                Location locationForNavigation = VirtualNavigationPresentation.this.getLocationForNavigation();
                NavLocation navLocation = new NavLocation("Router");
                if (locationForNavigation != null) {
                    navLocation.setLatitude(locationForNavigation.getLatitude());
                    navLocation.setLongitude(locationForNavigation.getLongitude());
                }
                List<RouteLeg> listLegs = MapplsNavigationHelper.getInstance().getCurrentRoute().legs();
                if (listLegs != null && listLegs.size() > 0 && listLegs.get(0).annotation() != null) {
                    VirtualNavigationPresentation.this.getCongestionPercentage(listLegs.get(0).annotation().congestion(), MapplsNavigationHelper.getInstance().getNodeIndex());
                }
                VirtualNavigationPresentation.this.drawPolyLine();
                try {
                    if (VirtualNavigationPresentation.this.locationPlugin != null) {
                        VirtualNavigationPresentation.this.locationPlugin.setLocationComponentEnabled(true);
                        if (locationForNavigation != null) {
                            VirtualNavigationPresentation.this.locationPlugin.forceLocationUpdate(locationForNavigation);
                        }
                    }
                    VirtualNavigationPresentation.this.followMe(true);
                } catch (Exception e) {
                    Timber.e(e);
                }
                try {
                    if (BleFeatures.navigationCallback != null) {
                        BleFeatures.navigationCallback.onRouteReady();
                    }
                } catch (Exception e2) {
                    Log.w("VNav", "onRouteReady after Mappls onNewRoute failed", e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCongestionPercentage(List<String> list, int i) {
        List<String> arrayList;
        if (list == null || list.isEmpty()) {
            return R.color.navigation_eta_text_color_with_out_traffic;
        }
        if ((list == null || !list.isEmpty()) && i < list.size()) {
            arrayList = list.subList(i, list.size());
        } else {
            arrayList = new ArrayList<>();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).equals("heavy") || arrayList.get(i3).equals("moderate") || arrayList.get(i3).equals("severe")) {
                i2++;
            }
        }
        int size = !arrayList.isEmpty() ? (i2 * 100) / arrayList.size() : 1;
        if (size <= 10) {
            return R.color.navigation_eta_text_color_with_out_traffic;
        }
        if (size <= 25) {
            return R.color.navigation_eta_text_color_with_low_traffic;
        }
        return R.color.navigation_eta_text_color_with_traffic;
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationCancelled() {
        Timber.e("onNavigationCancelled", new Object[0]);
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onGpsStateChange(false);
            BleFeatures.navigationCallback.onNavigationStop();
        }
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationFinished() {
        Timber.e("onRouteFinished", new Object[0]);
        BleFeatures.navigationCallback.onDestinationReached();
        Toast.makeText(this.f36app, "Reached to destination", 0).show();
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRouteProgress(final AdviseInfo adviseInfo) {
        if (getContext() == null || adviseInfo == null) {
            return;
        }
        BleFeatures.navigationCallback.onNavigationProgress(adviseInfo, null);
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onRouteProgress$9(adviseInfo);
            }
        });
        Timber.tag("Test").e("Advise Info----" + adviseInfo.toString(), new Object[0]);
        List<NavigationStep> routeDirections = this.f36app.getRouteDirections();
        int position = adviseInfo.getPosition() == 0 ? adviseInfo.getPosition() : adviseInfo.getPosition() - 1;
        LegStep legStep = (LegStep) routeDirections.get(position).getExtraInfo();
        int i = position + 1;
        LegStep legStep2 = routeDirections.size() > i ? (LegStep) routeDirections.get(i).getExtraInfo() : null;
        RouteArrowPlugin routeArrowPlugin = this.routeArrowPlugin;
        if (routeArrowPlugin != null) {
            routeArrowPlugin.addUpcomingManeuverArrow(legStep, legStep2);
        }
        this.currentPageLocation = adviseInfo.getPosition();
        if (this.locationPlugin != null && adviseInfo.getLocation() != null) {
            this.locationPlugin.forceLocationUpdate(adviseInfo.getLocation());
        }
        NavigationCamera navigationCamera = this.camera;
        if (navigationCamera != null && this.followMeFlag) {
            navigationCamera.onRouteProgress(adviseInfo);
        } else {
            Log.e("VNav", "camera tracking off");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRouteProgress$9(AdviseInfo adviseInfo) {
        try {
            DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
            if (directionPolylinePlugin != null) {
                directionPolylinePlugin.setCurrentLocation(adviseInfo.getLocation());
            }
        } catch (Exception unused) {
        }
    }

    public int setDistance(long j) {
        return j > 0 ? Math.round(j / 10) * 10 : (int) j;
    }

    int getDrawableResId(int i) {
        return getResources().getIdentifier("ic_step_" + i, "drawable", getContext().getPackageName());
    }

    public void setNavigationPadding(boolean z) {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null) {
            return;
        }
        if (z) {
            if (getResources().getConfiguration().orientation == 1) {
                this.mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 100.0d, 600.0d, 0.0d));
                return;
            } else {
                this.mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 0.0d, 0.0d, 50.0d));
                return;
            }
        }
        mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 0.0d, 0.0d, 0.0d));
    }

    void initViews() {
        initAnimations();
    }

    void setAdapter() {
        if (getContext() == null) {
            return;
        }
        List<NavigationStep> routeDirections = this.f36app.getRouteDirections();
        Stop stop = new Stop();
        stop.setName("END STOP");
        new NavigationPagerAdapter(getContext(), routeDirections, stop).setSelectedPosition(1);
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onSuccess(LocationEngineResult locationEngineResult) {
        if (locationEngineResult != null) {
            Location lastLocation = locationEngineResult.getLastLocation();
            Timber.i("onLocationChanged", new Object[0]);
            if (lastLocation != null) {
                try {
                    lastLocation.getLatitude();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
        followMe(false);
        StreamingImageHandler.navigationSearchScreen.tftTurnByTurnScreen.setRecenterBtnVisibility(true);
    }

    class MyLocalBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }

        MyLocalBroadcastReceiver() {
        }
    }

    @Override // android.app.Presentation
    public void onDisplayRemoved() {
        super.onDisplayRemoved();
        Log.e("VirtualNav", "onDisplay change");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public synchronized void zoomInTFT() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomInTFT$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomInTFT$10() {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null) {
            return;
        }
        this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().zoom(Math.min(mapplsMap.getCameraPosition().zoom + 0.1d, this.mapplsMap.getMaxZoomLevel())).build()));
    }

    public synchronized void zoomOutTft() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.wifi.views.VirtualNavigationPresentation$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomOutTft$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomOutTft$11() {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null) {
            return;
        }
        this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().zoom(Math.max(mapplsMap.getCameraPosition().zoom - 0.1d, this.mapplsMap.getMinZoomLevel())).build()));
    }
}
