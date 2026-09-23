package com.bajajconnect.wifi.views;

import android.app.Presentation;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bajajconnect.NavApplication;
import com.bajajconnect.NavigationVariables;
import com.bajajconnect.R;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.utils.MapplsSessionHelper;
import com.bajajconnect.navigate.viewmodel.RouteViewModel;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.Screens;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.annotations.MarkerOptions;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentActivationOptions;
import com.mappls.sdk.maps.location.LocationComponentOptions;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.iface.IStopSession;
import com.mappls.sdk.navigation.model.NavigationResponse;
import com.mappls.sdk.navigation.util.ErrorType;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class RouteInfoPresentation extends Presentation implements OnMapReadyCallback, LocationEngineCallback<LocationEngineResult> {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f35app;
    private Location currentLocation;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private ELocation eLocation;
    private List<ELocation> eLocations;
    private boolean firstFix;
    private String fromLocation;
    private final Handler handler;
    public boolean isRouteDrawn;
    private LocationEngine locationEngine;
    private MapplsMap map;
    public MapView mapView;
    private DirectionsResponse trip;
    private RouteViewModel viewModel;

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onFailure(Exception exc) {
    }

    public RouteInfoPresentation(Context context, Display display, Handler handler) {
        super(context, display);
        this.firstFix = false;
        this.isRouteDrawn = false;
        this.handler = handler;
    }

    public RouteInfoPresentation(Context context, Display display, int i, Handler handler) {
        super(context, display, i);
        this.firstFix = false;
        this.isRouteDrawn = false;
        this.handler = handler;
    }

    public void showToast() {
        this.handler.post(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(RouteInfoPresentation.this.getContext(), "Please wait! ,Route is loading", 0).show();
            }
        });
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_route_presentation);
        this.mapView = (MapView) findViewById(R.id.map_view_route);
        this.viewModel = new RouteViewModel();
        this.f35app = NavApplication.forFragments();
        this.eLocation = NavApplication.eLocation;
        MapplsNavigationHelper.getInstance().init(NavApplication.application);
        MapplsSessionHelper.applyBuildConfigCredentials();
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(HomeActivity.class);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventEnabled(true);
        MapplsNavigationHelper.getInstance().setMute(false);
        MapplsNavigationHelper.getInstance().showRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().showSafetyEvents(true);
        MapplsNavigationHelper.getInstance().showTrafficEvents(true);
        MapplsNavigationHelper.getInstance().setNavigationEventAudioPromptEnabled(true);
        MapplsNavigationHelper.getInstance().speakRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().speakSafetyEvents(true);
        MapplsNavigationHelper.getInstance().speakTrafficEvents(true);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        Mappls.getInstance(getContext());
    }

    private String getAtlasClientId() {
        return "96dHZVzsAusdFSRGu047EP1OFqsfrwiJ19XJyUx0RRyUz35b0PgtCrbotg-HXvqrPZrmnvVYanbgDngvVX3S_w==";
    }

    private String getAtlasClientSecret() {
        return "lrFxI-iSEg8ktludBF9Ct_cKzeK5YAIgJuuvNwpTKIpmZZAMy7EwOfCSwYTOrEJwt78FT46APVqk-_mEDwVhMG2AeSda1vxG";
    }

    private String getMapSDKKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    private String getRestAPIKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    @Override // android.app.Presentation, android.app.Dialog
    protected void onStart() {
        super.onStart();
        MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
        this.mapView.getMapAsync(this);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    decorView.setSystemUiVisibility(5894);
                }
            }
        });
    }

    @Override // android.app.Presentation, android.app.Dialog
    protected void onStop() {
        super.onStop();
        LocationEngine locationEngine = this.locationEngine;
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates(this);
            this.locationEngine = null;
        }
        MapplsMap mapplsMap = this.map;
        if (mapplsMap != null) {
            mapplsMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setRoute, reason: merged with bridge method [inline-methods] */
    public void lambda$setRoute$0() {
        try {
            if (this.viewModel.getTrip() != null) {
                Log.e("RouteP", "setToute 0001");
                this.f35app.setTrip(this.viewModel.getTrip());
                this.viewModel.setSelectedIndex(0);
                addPolyLine(this.viewModel.getTrip());
                return;
            }
            try {
                if (this.currentLocation == null && MirroringGlobarVar.currentLat == null) {
                    this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setRoute$0();
                        }
                    }, 1000L);
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<ELocation> it2 = this.viewModel.geteLocations().iterator();
                while (it2.hasNext()) {
                    arrayList.add(getPoint(it2.next()));
                }
                Log.e("RouteP", "get route");
                arrayList.add(getPoint(this.viewModel.geteLocation()));
                if (this.currentLocation != null) {
                    getRoute(new LatLng(this.currentLocation.getLatitude(), this.currentLocation.getLongitude()), arrayList);
                } else {
                    getRoute(new LatLng(MirroringGlobarVar.currentLat.doubleValue(), MirroringGlobarVar.currentLng.doubleValue()), arrayList);
                }
            } catch (Exception e) {
                Timber.e(e);
                Log.e("RouteFragment", e.toString());
                Toast.makeText(getContext(), R.string.something_went_wrong, 0).show();
            }
        } catch (Exception e2) {
            Log.e("RouteFragment", e2.toString());
            Timber.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress() {
        try {
            getContext();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        try {
            getContext();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public void addPolyLine(DirectionsResponse directionsResponse) {
        if (this.map == null || directionsResponse == null || directionsResponse.routes().get(0).geometry() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.setEnabled(true);
            this.directionPolylinePlugin.setEnableCongestion(true);
            this.directionPolylinePlugin.removeAllData();
            ArrayList arrayList2 = new ArrayList();
            Iterator<DirectionsRoute> it2 = directionsResponse.routes().iterator();
            while (it2.hasNext()) {
                arrayList2.add(LineString.fromPolyline(it2.next().geometry(), 6));
            }
            ArrayList arrayList3 = new ArrayList();
            if (this.viewModel.geteLocations().size() > 0) {
                for (int i = 0; i < this.viewModel.geteLocations().size(); i++) {
                    if (this.viewModel.geteLocations().get(i).latitude != null && this.viewModel.geteLocations().get(i).longitude != null) {
                        arrayList3.add(new LatLng(this.viewModel.geteLocations().get(i).latitude.doubleValue(), this.viewModel.geteLocations().get(i).longitude.doubleValue()));
                    }
                }
            }
            this.directionPolylinePlugin.setTrips(arrayList2, null, (this.viewModel.geteLocation().latitude == null || this.viewModel.geteLocation().longitude == null) ? null : new LatLng(this.viewModel.geteLocation().latitude.doubleValue(), this.viewModel.geteLocation().longitude.doubleValue()), arrayList3.size() > 0 ? arrayList3 : null, directionsResponse.routes());
            this.directionPolylinePlugin.setOnNewRouteSelectedListener(new DirectionPolylinePlugin.OnNewRouteSelectedListener() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.3
                @Override // com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.OnNewRouteSelectedListener
                public void onNewRouteSelected(int i2, DirectionsRoute directionsRoute) {
                    RouteInfoPresentation.this.viewModel.setSelectedIndex(i2);
                }
            });
        }
        if (directionsResponse.routes().get(0).legs() != null && directionsResponse.routes().get(0).legs().size() > 0) {
            for (RouteLeg routeLeg : directionsResponse.routes().get(0).legs()) {
                if (routeLeg != null && routeLeg.steps() != null && routeLeg.steps().size() > 0) {
                    for (LegStep legStep : routeLeg.steps()) {
                        arrayList.add(new LatLng(legStep.maneuver().location().latitude(), legStep.maneuver().location().longitude()));
                    }
                }
            }
        }
        if (arrayList.size() == 1) {
            this.map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(((LatLng) arrayList.get(0)).getLatitude(), ((LatLng) arrayList.get(0)).getLongitude())));
        } else {
            try {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.includes(arrayList);
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20, 140, 20, 100));
            } catch (Exception e) {
                e.printStackTrace();
                this.map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(((LatLng) arrayList.get(0)).getLatitude(), ((LatLng) arrayList.get(0)).getLongitude())));
            }
        }
        this.isRouteDrawn = true;
    }

    private void getRoute(LatLng latLng, ArrayList<String> arrayList) {
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.removeAllData();
        }
        if (arrayList == null || arrayList.size() < 1) {
            return;
        }
        Point pointFromLngLat = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
        String str = arrayList.get(arrayList.size() - 1);
        Log.e("RouteP", "getToute 0002");
        MapplsDirections.Builder builderOverview = MapplsDirections.builder().origin(pointFromLngLat).destination(str).annotations(DirectionsCriteria.ANNOTATION_NODES, "duration").profile("biking").resource(DirectionsCriteria.RESOURCE_ROUTE).steps(true).alternatives(true).routeRefresh(true).deviceId(Settings.Secure.getString(getContext().getContentResolver(), "android_id")).overview("full");
        if (arrayList.size() >= 2) {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                builderOverview.addWaypoint(arrayList.get(i));
            }
        }
        showProgress();
        MapplsDirectionManager.newInstance(builderOverview.build()).call(new OnResponseCallback<DirectionsResponse>() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.4
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(DirectionsResponse directionsResponse) {
                RouteInfoPresentation.this.hideProgress();
                if (directionsResponse == null) {
                    Log.e("RouteInfoP", "direction response is null");
                    return;
                }
                Log.e("RouteP", "get route success");
                RouteInfoPresentation.this.viewModel.setTrip(directionsResponse);
                RouteInfoPresentation.this.f35app.setTrip(RouteInfoPresentation.this.viewModel.getTrip());
                RouteInfoPresentation.this.viewModel.setSelectedIndex(0);
                RouteInfoPresentation routeInfoPresentation = RouteInfoPresentation.this;
                routeInfoPresentation.addPolyLine(routeInfoPresentation.viewModel.getTrip());
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i2, String str2) {
                Log.e("RouteFragment", "errorCode " + i2 + "msg =" + str2);
                GlobalVar.isIsTakeMeHomeNavStarting = false;
                if (i2 != 0) {
                    if (i2 == 401) {
                        Log.e("RouteInforP", "Limit expired");
                    } else {
                        Log.e("RouteInforP", "Something went wrong");
                    }
                }
                RouteInfoPresentation.this.hideProgress();
            }
        });
    }

    public String getPoint(ELocation eLocation) {
        try {
            if (eLocation.latitude != null && eLocation.longitude != null) {
                return eLocation.longitude + "," + eLocation.latitude;
            }
            return eLocation.getMapplsPin();
        } catch (Exception unused) {
            return null;
        }
    }

    public WayPoint getNavigationGeoPoint(ELocation eLocation) {
        try {
            if (eLocation.entryLatitude != null && eLocation.entryLongitude != null && eLocation.entryLatitude.doubleValue() > 0.0d && eLocation.entryLongitude.doubleValue() > 0.0d) {
                return new WayPoint(eLocation.entryLatitude.doubleValue(), eLocation.entryLongitude.doubleValue(), eLocation.placeName, eLocation.placeName);
            }
            if (eLocation.latitude != null && eLocation.longitude != null) {
                return new WayPoint(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue(), eLocation.placeName, eLocation.placeName);
            }
            return new WayPoint(eLocation.getMapplsPin(), eLocation.placeName, eLocation.placeName);
        } catch (Exception unused) {
            return new WayPoint(0.0d, 0.0d, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WayPoint getWayPoints(ELocation eLocation) {
        try {
            return new WayPoint(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue(), eLocation.placeName, eLocation.placeName);
        } catch (Exception unused) {
            return new WayPoint(0.0d, 0.0d, null, null);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(final MapplsMap mapplsMap) {
        this.map = mapplsMap;
        mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 115);
        this.map.getUiSettings().setLogoEnabled(false);
        MirroringGlobarVar.currentScreen = Screens.ROUTE_SCREEN;
        MirroringGlobarVar.isSearchProcessing = false;
        Log.e("RouteInfo", "OnMap ready");
        GlobalVar.hydrateAppThemeFromPrefs(getContext());
        mapplsMap.setMapplsStyle(GlobalVar.mapplsStyleForAppTheme(), new Style.OnStyleLoaded() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.5
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                RouteInfoPresentation.this.directionPolylinePlugin = new DirectionPolylinePlugin(RouteInfoPresentation.this.mapView, RouteInfoPresentation.this.map);
                RouteInfoPresentation.this.enableLocationComponent(style);
                RouteInfoPresentation routeInfoPresentation = RouteInfoPresentation.this;
                routeInfoPresentation.currentLocation = routeInfoPresentation.map.getLocationComponent().getLastKnownLocation();
                RouteInfoPresentation.this.directionPolylinePlugin.setEnableCongestion(true);
                mapplsMap.setMaxZoomPreference(18.5d);
                mapplsMap.setMinZoomPreference(4.0d);
                mapplsMap.clear();
                if (RouteInfoPresentation.this.viewModel.getTrip() != null) {
                    RouteInfoPresentation routeInfoPresentation2 = RouteInfoPresentation.this;
                    routeInfoPresentation2.addPolyLine(routeInfoPresentation2.viewModel.getTrip());
                }
                if (RouteInfoPresentation.this.eLocation.mapplsPin != null) {
                    mapplsMap.addMarker(new MarkerOptions().mapplsPin(RouteInfoPresentation.this.eLocation.mapplsPin));
                } else {
                    mapplsMap.addMarker(new MarkerOptions().position(new LatLng(RouteInfoPresentation.this.eLocation.latitude.doubleValue(), RouteInfoPresentation.this.eLocation.longitude.doubleValue())));
                }
                RouteInfoPresentation routeInfoPresentation3 = RouteInfoPresentation.this;
                routeInfoPresentation3.getDirections(routeInfoPresentation3.eLocation);
                Log.e("RouteP", "set Route");
                RouteInfoPresentation.this.lambda$setRoute$0();
                MirroringGlobarVar.isSearchProcessing = false;
            }
        });
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        MirroringGlobarVar.isSearchProcessing = false;
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public void onSuccess(LocationEngineResult locationEngineResult) {
        if (locationEngineResult != null) {
            Location lastLocation = locationEngineResult.getLastLocation();
            Timber.i("onLocationChanged", new Object[0]);
            if (lastLocation != null) {
                try {
                    if (lastLocation.getLatitude() <= 0.0d) {
                        return;
                    }
                    if (!this.firstFix) {
                        this.firstFix = true;
                    }
                    this.currentLocation = lastLocation;
                } catch (Exception unused) {
                }
            }
        }
    }

    public void startNavigation() {
        Log.e("Route", "start navigation");
        try {
            this.currentLocation = this.map.getLocationComponent().getLastKnownLocation();
            new LongOperation().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class LongOperation extends AsyncTask<Void, Void, NavigationResponse> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        private LongOperation() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public NavigationResponse doInBackground(Void... voidArr) {
            NavLocation navLocation;
            ArrayList arrayList;
            try {
                Log.e("Route", "started");
                Log.e("RouteInfo", "current location" + RouteInfoPresentation.this.currentLocation);
                if (RouteInfoPresentation.this.currentLocation != null) {
                    navLocation = new NavLocation("router");
                    navLocation.setLatitude(RouteInfoPresentation.this.currentLocation.getLatitude());
                    navLocation.setLongitude(RouteInfoPresentation.this.currentLocation.getLongitude());
                } else {
                    navLocation = null;
                }
                LatLng latLng = navLocation != null ? new LatLng(navLocation.getLatitude(), navLocation.getLongitude()) : null;
                NavLocation navLocation2 = new NavLocation("navigation");
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (RouteLeg routeLeg : RouteInfoPresentation.this.viewModel.getTrip().routes().get(0).legs()) {
                    if (routeLeg != null && routeLeg.steps() != null && routeLeg.steps().size() > 0) {
                        for (Iterator<LegStep> it2 = routeLeg.steps().iterator(); it2.hasNext(); it2 = it2) {
                            LegStep next = it2.next();
                            arrayList3.add(next.maneuver().location());
                            arrayList4.add(new LatLng(next.maneuver().location().latitude(), next.maneuver().location().longitude()));
                            NavLocation navLocation3 = new NavLocation("navigation");
                            navLocation3.setLongitude(next.maneuver().location().longitude());
                            navLocation3.setLatitude(next.maneuver().location().latitude());
                            arrayList2 = arrayList2;
                            arrayList2.add(navLocation3);
                        }
                    }
                }
                Log.e("RouteInfo", "current location 2" + RouteInfoPresentation.this.currentLocation);
                Point pointLocation = RouteInfoPresentation.this.viewModel.getTrip().routes().get(0).legs().get(0).steps().get(0).maneuver().location();
                LatLng latLng2 = new LatLng(pointLocation.latitude(), pointLocation.longitude());
                navLocation2.setLongitude(latLng2.getLongitude());
                navLocation2.setLatitude(latLng2.getLatitude());
                MirroringGlobarVar.startNavigationLocationMirroring = navLocation2;
                RouteInfoPresentation.this.f35app.setStartNavigationLocation(navLocation2);
                if (latLng == null) {
                    Log.e("Route", "started 22");
                    return new NavigationResponse(ErrorType.UNKNOWN_ERROR, null);
                }
                Log.e("RouteInfo", "current location 3" + RouteInfoPresentation.this.currentLocation);
                if (RouteInfoPresentation.this.viewModel.geteLocations() != null && RouteInfoPresentation.this.viewModel.geteLocations().size() > 0) {
                    arrayList = new ArrayList();
                    Iterator<ELocation> it3 = RouteInfoPresentation.this.viewModel.geteLocations().iterator();
                    while (it3.hasNext()) {
                        arrayList.add(RouteInfoPresentation.this.getWayPoints(it3.next()));
                    }
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList5 = arrayList;
                Log.e("RouteInfo", "current location 4" + RouteInfoPresentation.this.currentLocation);
                NavigationVariables.selectedIndex = RouteInfoPresentation.this.viewModel.getSelectedIndex();
                NavigationVariables.currentLocation = latLng;
                RouteInfoPresentation routeInfoPresentation = RouteInfoPresentation.this;
                NavigationVariables.wayPoint = routeInfoPresentation.getNavigationGeoPoint(routeInfoPresentation.viewModel.geteLocation());
                NavigationVariables.wayPoints = arrayList5;
                MapplsNavigationHelper mapplsNavigationHelper = MapplsNavigationHelper.getInstance();
                DirectionsResponse trip = RouteInfoPresentation.this.viewModel.getTrip();
                int selectedIndex = RouteInfoPresentation.this.viewModel.getSelectedIndex();
                RouteInfoPresentation routeInfoPresentation2 = RouteInfoPresentation.this;
                return mapplsNavigationHelper.startNavigation(trip, selectedIndex, latLng, routeInfoPresentation2.getNavigationGeoPoint(routeInfoPresentation2.viewModel.geteLocation()), (List<WayPoint>) arrayList5, false);
            } catch (Exception e) {
                Timber.e(e);
                Log.e("RouteFragment", e.toString());
                return new NavigationResponse(ErrorType.UNKNOWN_ERROR, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(NavigationResponse navigationResponse) {
            RouteInfoPresentation.this.hideProgress();
            if (navigationResponse != null && navigationResponse.getError() != null) {
                Timber.d(navigationResponse.toString(), new Object[0]);
                Log.e("RouteInfo", navigationResponse.getError().errorMessage);
                if (navigationResponse.getError().errorCode == 409) {
                    RouteInfoPresentation.this.deleteNavigationSession();
                    return;
                }
                Toast.makeText(RouteInfoPresentation.this.getContext(), navigationResponse.getError().errorMessage + "", 0).show();
                return;
            }
            NavApplication.customProjection.startActivity();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            RouteInfoPresentation.this.showProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteNavigationSession() {
        StringBuilder sb = new StringBuilder("deleteNavigationSession vinSet=");
        sb.append((GlobalVar.vehcileVin == null || GlobalVar.vehcileVin.isEmpty()) ? false : true);
        Log.d("RouteInfoPresentation", sb.toString());
        MapplsNavigationHelper.getInstance().deleteSession(GlobalVar.vehcileVin, new IStopSession() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.6
            @Override // com.mappls.sdk.navigation.iface.IStopSession
            public void onSuccess() {
                RouteInfoPresentation.this.startNavigation();
            }

            @Override // com.mappls.sdk.navigation.iface.IStopSession
            public void onFailure() {
                Toast.makeText(RouteInfoPresentation.this.f35app, "Something went wrong.Try again", 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDirections(final ELocation eLocation) {
        try {
            if (this.map.getLocationComponent().getLastKnownLocation() == null && MirroringGlobarVar.currentLat == null) {
                Log.e("RouteP", "getDirections 121");
                this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.7
                    @Override // java.lang.Runnable
                    public void run() {
                        RouteInfoPresentation.this.getDirections(eLocation);
                    }
                }, 1000L);
                return;
            }
            Log.e("RouteP", "getDirections");
            if (this.viewModel.geteLocations() == null) {
                this.viewModel.seteLocations(new ArrayList());
            }
            this.viewModel.seteLocation(eLocation);
            this.viewModel.setFromLocation("");
            lambda$setRoute$0();
        } catch (Exception e) {
            Timber.e(e);
            e.printStackTrace();
            this.handler.postDelayed(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.8
                @Override // java.lang.Runnable
                public void run() {
                    RouteInfoPresentation.this.getDirections(eLocation);
                }
            }, 1000L);
        }
    }

    public void getReverseGeoCode(Double d, Double d2) {
        MapplsReverseGeoCodeManager.newInstance(MapplsReverseGeoCode.builder().setLocation(d.doubleValue(), d2.doubleValue()).build()).call(new OnResponseCallback<PlaceResponse>() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation.9
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(PlaceResponse placeResponse) {
                if (placeResponse != null) {
                    Place place = placeResponse.getPlaces().get(0);
                    RouteInfoPresentation.this.fromLocation = place.getFormattedAddress();
                    Log.e("Homefrg", "getReverseCode");
                    RouteInfoPresentation routeInfoPresentation = RouteInfoPresentation.this;
                    routeInfoPresentation.getDirections(routeInfoPresentation.eLocation);
                }
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                Log.e("HomeFragment", "Fragment error");
                Toast.makeText(RouteInfoPresentation.this.getContext(), str, 1).show();
                GlobalVar.isIsTakeMeHomeNavStarting = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableLocationComponent(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(getContext())) {
            LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(getContext()).trackingGesturesManagement(true).accuracyAlpha(0.0f).accuracyColor(ContextCompat.getColor(getContext(), R.color.accuracy_green)).build();
            LocationComponent locationComponent = this.map.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(getContext(), style).locationComponentOptions(locationComponentOptionsBuild).build());
            if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                locationComponent.setLocationComponentEnabled(true);
                this.locationEngine = locationComponent.getLocationEngine();
                LocationEngineRequest locationEngineRequestBuild = new LocationEngineRequest.Builder(1000L).setPriority(0).setFastestInterval(100L).build();
                if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    this.locationEngine.requestLocationUpdates(locationEngineRequestBuild, this, getContext().getMainLooper());
                    locationComponent.setCameraMode(24);
                    locationComponent.setRenderMode(4);
                }
            }
        }
    }

    @Override // android.app.Presentation
    public void onDisplayRemoved() {
        super.onDisplayRemoved();
        Log.e("RouteInfo", "onDisplay change");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public synchronized void zoomInTFT() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomInTFT$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomInTFT$1() {
        this.map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().zoom(Math.min(this.map.getCameraPosition().zoom + 0.05d, this.map.getMaxZoomLevel())).build()));
    }

    public synchronized void zoomOutTft() {
        NavApplication.activity.runOnUiThread(new Runnable() { // from class: com.bajajconnect.wifi.views.RouteInfoPresentation$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$zoomOutTft$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$zoomOutTft$2() {
        this.map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().zoom(Math.max(this.map.getCameraPosition().zoom - 0.05d, this.map.getMinZoomLevel())).build()));
    }
}
