package com.mappls.sdk.direction.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.Scopes;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.category.model.PoiResult;
import com.mappls.sdk.direction.ui.DirectionViewModel;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.databinding.MapplsRoutingLayoutBinding;
import com.mappls.sdk.direction.ui.model.DirectionOptions;
import com.mappls.sdk.direction.ui.model.DirectionPoint;
import com.mappls.sdk.direction.ui.model.StopModel;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraUpdate;
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
import com.mappls.sdk.plugin.directions.DateTimeFormat;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DistanceType;
import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceAutocompleteFragment;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.costestimation.model.CostEstimationResponse;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.directions.models.LegAnnotation;
import com.mappls.sdk.services.api.directions.models.RouteClasses;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import com.mappls.sdk.services.utils.MapplsUtils;
import com.mappls.sdk.turf.TurfMeasurement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class l extends Fragment implements LocationEngineCallback<LocationEngineResult>, OnMapReadyCallback {
    public boolean a;
    boolean b = false;
    Location c;
    private MapplsRoutingLayoutBinding d;
    private DirectionViewModel e;
    private com.mappls.sdk.direction.ui.adapters.j f;
    private com.mappls.sdk.direction.ui.adapters.b g;
    private BottomSheetBehavior<RelativeLayout> h;
    private MapplsMap i;
    private LocationEngine j;
    private MapView k;
    private ArrayList l;
    private RecyclerViewDragDropManager m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private h f699n;
    private int o;
    private Context p;
    private DirectionPoint q;
    private DirectionPoint r;

    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Trip-Cost-Summary");
                l.this.a(jSONObject);
                jSONObject.put("is_toll_data_available", l.this.e.tollHashMap.containsKey(Integer.valueOf(l.this.e.getSelectedIndex())));
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            if (l.this.e.tollHashMap.containsKey(Integer.valueOf(l.this.e.getSelectedIndex()))) {
                if (l.this.f699n != null) {
                    l.this.f699n.onTripEstimation(l.this.e.tollHashMap.get(Integer.valueOf(l.this.e.getSelectedIndex())), l.this.e.getDirectionsResponse(), l.this.e.getSelectedIndex());
                }
            } else if (l.this.f699n != null) {
                l.this.f699n.onTripEstimation(null, l.this.e.getDirectionsResponse(), l.this.e.getSelectedIndex());
            }
        }
    }

    final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Retry-Click");
                l.this.a(jSONObject);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            l.this.a();
        }
    }

    final class c implements com.mappls.sdk.direction.ui.adapters.j.a {

        final class a implements PlaceSelectionListener {
            final /* synthetic */ PlaceAutocompleteFragment a;
            final /* synthetic */ int b;

            a(PlaceAutocompleteFragment placeAutocompleteFragment, int i) {
                this.a = placeAutocompleteFragment;
                this.b = i;
            }

            @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
            public final void onCancel() {
                if (l.this.getChildFragmentManager() != null) {
                    l.this.getChildFragmentManager().popBackStack();
                }
            }

            @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
            public final void onFavoritePlaceSelected(MapplsFavoritePlace mapplsFavoritePlace) {
                if (l.this.getChildFragmentManager() != null) {
                    l.this.getChildFragmentManager().popBackStack(this.a.getClass().getName(), 1);
                }
                if (l.this.e.getStopModels().size() == 2) {
                    String mapplsPin = (this.b == 0 ? l.this.e.getStopModels().get(1) : l.this.e.getStopModels().get(0)).getMapplsPin();
                    if (mapplsPin != null && mapplsFavoritePlace.getMapplsPin().equalsIgnoreCase(mapplsPin)) {
                        Toast.makeText(l.this.p, "You might select same source and destination", 0).show();
                        return;
                    }
                }
                StopModel stopModel = l.this.e.getStopModels().get(this.b);
                if (mapplsFavoritePlace.getLongitude() == null || mapplsFavoritePlace.getLatitude() == null) {
                    stopModel.setLocation(null);
                } else {
                    stopModel.setLocation(Point.fromLngLat(mapplsFavoritePlace.getLongitude().doubleValue(), mapplsFavoritePlace.getLatitude().doubleValue()));
                }
                stopModel.setEntryLocation(null);
                stopModel.setLocationType(StopModel.TYPE_STOP);
                stopModel.setPlaceName(mapplsFavoritePlace.getPlaceName());
                stopModel.setPlaceAddress(mapplsFavoritePlace.getPlaceAddress());
                stopModel.setMapplsPin(mapplsFavoritePlace.getMapplsPin());
                if (l.this.e.getStopModels().size() < 5 && l.this.e.getStopModels().size() > 2 && !com.mappls.sdk.direction.ui.common.a.a(l.this.e.getStopModels().get(l.this.e.getStopModels().size() - 1))) {
                    StopModel stopModel2 = new StopModel();
                    stopModel2.setLocationType(StopModel.TYPE_BLANK);
                    l.this.e.getStopModels().add(stopModel2);
                }
                l.h(l.this);
            }

            @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
            public final void onPlaceSelected(ELocation eLocation) {
                if (l.this.getChildFragmentManager() != null) {
                    l.this.getChildFragmentManager().popBackStack(this.a.getClass().getName(), 1);
                }
                if (l.this.e.getStopModels().size() == 2) {
                    String mapplsPin = (this.b == 0 ? l.this.e.getStopModels().get(1) : l.this.e.getStopModels().get(0)).getMapplsPin();
                    if (mapplsPin != null && eLocation.getMapplsPin().equalsIgnoreCase(mapplsPin)) {
                        Toast.makeText(l.this.p, "You might select same source and destination", 0).show();
                        return;
                    }
                }
                StopModel stopModel = l.this.e.getStopModels().get(this.b);
                Double d = eLocation.longitude;
                if (d == null || eLocation.latitude == null) {
                    stopModel.setLocation(null);
                } else {
                    stopModel.setLocation(Point.fromLngLat(d.doubleValue(), eLocation.latitude.doubleValue()));
                }
                Double d2 = eLocation.entryLongitude;
                if (d2 == null || eLocation.entryLatitude == null) {
                    stopModel.setEntryLocation(null);
                } else {
                    stopModel.setEntryLocation(Point.fromLngLat(d2.doubleValue(), eLocation.entryLatitude.doubleValue()));
                }
                stopModel.setLocationType(StopModel.TYPE_STOP);
                stopModel.setPlaceName(eLocation.placeName);
                stopModel.setPlaceAddress(eLocation.placeAddress);
                stopModel.setMapplsPin(eLocation.getMapplsPin());
                if (l.this.e.getStopModels().size() < 5 && l.this.e.getStopModels().size() > 2 && !com.mappls.sdk.direction.ui.common.a.a(l.this.e.getStopModels().get(l.this.e.getStopModels().size() - 1))) {
                    StopModel stopModel2 = new StopModel();
                    stopModel2.setLocationType(StopModel.TYPE_BLANK);
                    l.this.e.getStopModels().add(stopModel2);
                }
                l.h(l.this);
            }

            @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
            public final void requestForCurrentLocation() {
                if (l.this.getChildFragmentManager() != null) {
                    l.this.getChildFragmentManager().popBackStack(this.a.getClass().getName(), 1);
                }
                l lVar = l.this;
                if (lVar.c != null) {
                    if (lVar.e.getStopModels().size() == 2) {
                        Point location = (this.b == 0 ? l.this.e.getStopModels().get(1) : l.this.e.getStopModels().get(0)).getLocation();
                        if (location != null && TurfMeasurement.distance(Point.fromLngLat(l.this.c.getLongitude(), l.this.c.getLatitude()), location) < 10.0d) {
                            Toast.makeText(l.this.p, "You might select same source and destination", 0).show();
                            return;
                        }
                    }
                    StopModel stopModel = l.this.e.getStopModels().get(this.b);
                    stopModel.setLocation(Point.fromLngLat(l.this.c.getLongitude(), l.this.c.getLatitude()));
                    stopModel.setEntryLocation(null);
                    stopModel.setLocationType(StopModel.TYPE_CURRENT_LOCATION);
                    stopModel.setPlaceName("Current Location");
                    stopModel.setPlaceAddress("");
                    stopModel.setMapplsPin(null);
                    if (l.this.e.getStopModels().size() < 5 && l.this.e.getStopModels().size() > 2 && !com.mappls.sdk.direction.ui.common.a.a(l.this.e.getStopModels().get(l.this.e.getStopModels().size() - 1))) {
                        StopModel stopModel2 = new StopModel();
                        stopModel2.setLocationType(StopModel.TYPE_BLANK);
                        l.this.e.getStopModels().add(stopModel2);
                    }
                    l.h(l.this);
                }
            }
        }

        c() {
        }

        @Override // com.mappls.sdk.direction.ui.adapters.j.a
        public final void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Reverse-Stop-Point");
                l.this.a(jSONObject);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            Collections.reverse(l.this.e.getStopModels());
            l.this.f.a(l.this.e.getStopModels());
            l.this.a();
        }

        @Override // com.mappls.sdk.direction.ui.adapters.j.a
        public final void a(int i) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Add-New-Stop-Point");
                l.this.a(jSONObject);
                jSONObject.put(ViewProps.POSITION, i);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            if (!(l.this.e.getStopModels().get(i).getLocation() == null && l.this.e.getStopModels().get(i).getMapplsPin() == null) && l.this.f.getItemCount() <= 4) {
                StopModel stopModel = new StopModel();
                stopModel.setLocationType(StopModel.TYPE_BLANK);
                l.this.e.getStopModels().add(stopModel);
                l.this.f.a(l.this.e.getStopModels());
                l.this.d.bottomSheetDetails.setVisibility(8);
                l.this.d.errorLayout.setVisibility(8);
                l.this.d.notificationLayout.setVisibility(8);
                if (l.this.i != null && l.this.i.getUiSettings() != null) {
                    l.this.i.getUiSettings().setLogoMargins(0, 0, 0, 0);
                }
                l.this.d.viewGetRoute.setVisibility(0);
            }
        }

        @Override // com.mappls.sdk.direction.ui.adapters.j.a
        public final void a(StopModel stopModel) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Remove-Stop-Point");
                l.this.a(jSONObject);
                jSONObject.put(ViewProps.POSITION, l.this.e.getStopModels().lastIndexOf(stopModel));
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            l.this.e.getStopModels().remove(stopModel);
            l.this.f.a(l.this.e.getStopModels());
            if (l.this.e.getStopModels().size() < 3) {
                if (l.this.f699n != null) {
                    l.this.f699n.clearRoute();
                }
                l.this.d.searchCategoryFab.setVisibility(8);
                l.this.d.viewGetRoute.setVisibility(8);
            }
        }

        @Override // com.mappls.sdk.direction.ui.adapters.j.a
        public final void b(int i) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Edit-Stop-Point");
                l.this.a(jSONObject);
                jSONObject.put(ViewProps.POSITION, i);
                jSONObject.put("is_editing_point", !com.mappls.sdk.direction.ui.common.a.a(l.this.e.getStopModels().get(i)));
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            PlaceAutocompleteFragment placeAutocompleteFragmentNewInstance = PlaceAutocompleteFragment.newInstance(l.this.e.options.searchPlaceOption());
            placeAutocompleteFragmentNewInstance.setOnPlaceSelectedListener(new a(placeAutocompleteFragmentNewInstance, i));
            l lVar = l.this;
            if ((lVar.getChildFragmentManager() != null ? lVar.getChildFragmentManager().findFragmentByTag(placeAutocompleteFragmentNewInstance.getClass().getName()) : null) == null) {
                FragmentTransaction fragmentTransactionBeginTransaction = lVar.getChildFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.add(R.id.direction_container, placeAutocompleteFragmentNewInstance, placeAutocompleteFragmentNewInstance.getClass().getName());
                fragmentTransactionBeginTransaction.addToBackStack(placeAutocompleteFragmentNewInstance.getClass().getName());
                try {
                    fragmentTransactionBeginTransaction.commit();
                } catch (IllegalStateException unused2) {
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                }
            }
        }
    }

    final class d implements Style.OnStyleLoaded {
        d() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            Point pointLocation;
            Point pointLocation2;
            l.a(l.this, style);
            if (l.this.e == null || l.this.e.getDirectionsResponse() == null) {
                return;
            }
            DirectionsRoute directionsRoute = l.this.e.getDirectionsResponse().routes().get(0);
            LatLng latLng = null;
            List<Point> listDecode = directionsRoute.geometry() != null ? PolylineUtils.decode(directionsRoute.geometry(), 6) : null;
            if (listDecode == null) {
                listDecode = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            for (Point point : listDecode) {
                arrayList.add(new LatLng(point.latitude(), point.longitude()));
            }
            LatLng latLng2 = (l.this.e.getStopModels().get(0).getLocationType() != StopModel.TYPE_STOP || l.this.e.getDirectionsResponse().waypoints() == null || l.this.e.getDirectionsResponse().waypoints().size() <= 0 || (pointLocation2 = l.this.e.getDirectionsResponse().waypoints().get(0).location()) == null) ? null : new LatLng(pointLocation2.latitude(), pointLocation2.longitude());
            if (l.this.e.getStopModels().get(l.this.e.getStopModels().size() - 1).getLocationType() == StopModel.TYPE_STOP && l.this.e.getDirectionsResponse().waypoints() != null && l.this.e.getDirectionsResponse().waypoints().size() > 0 && (pointLocation = l.this.e.getDirectionsResponse().waypoints().get(l.this.e.getDirectionsResponse().waypoints().size() - 1).location()) != null) {
                latLng = new LatLng(pointLocation.latitude(), pointLocation.longitude());
            }
            LatLng latLng3 = latLng;
            ArrayList arrayList2 = new ArrayList();
            if (l.this.e.getStopModels().size() > 2) {
                for (int i = 1; i < l.this.e.getStopModels().size() - 1; i++) {
                    if (l.this.e.getDirectionsResponse().waypoints() != null && l.this.e.getDirectionsResponse().waypoints().size() >= i && l.this.e.getStopModels().get(i).getLocationType() == StopModel.TYPE_STOP) {
                        DirectionsWaypoint directionsWaypoint = l.this.e.getDirectionsResponse().waypoints().get(i);
                        if (directionsWaypoint.location() != null) {
                            arrayList2.add(new LatLng(directionsWaypoint.location().latitude(), directionsWaypoint.location().longitude()));
                        }
                    }
                }
            }
            if (l.this.f699n != null) {
                l.this.f699n.onUpdateRoute(latLng2, latLng3, arrayList2, l.this.e.getDirectionsResponse().routes(), l.this.e.getSelectedIndex());
            }
            l.this.a(arrayList);
        }
    }

    final class e implements Style.OnStyleLoaded {
        e() {
        }

        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public final void onStyleLoaded(Style style) {
            l.a(l.this, style);
        }
    }

    private void a(int i) {
        ArrayList arrayList = this.l;
        if (arrayList == null || arrayList.size() <= 0) {
            Toast.makeText(this.p, "No steps available to show Preview", 0).show();
            return;
        }
        h hVar = this.f699n;
        if (hVar != null) {
            hVar.onPreviewClick(this.l, i, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.e.getRouteReportSummaryResponse() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Route-Report");
                a(jSONObject);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                }
            } catch (Exception unused) {
            }
            h hVar = this.f699n;
            if (hVar != null) {
                hVar.onRouteReportSummaryClick(this.e.getRouteReportSummaryResponse(), Integer.valueOf(this.e.getSelectedIndex()), this.e.getDirectionsResponse());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(com.mappls.sdk.direction.ui.common.b bVar) {
        T t;
        if (bVar == null || bVar.a != 1 || (t = bVar.c) == 0) {
            return;
        }
        Pair pair = (Pair) t;
        this.e.tollHashMap.put((Integer) pair.first, (CostEstimationResponse) pair.second);
        h hVar = this.f699n;
        if (hVar != null) {
            hVar.onTollInformationUpdate(this.e.tollHashMap);
        }
    }

    static void a(l lVar, Style style) {
        Context context = lVar.p;
        int iCheckSelfPermission = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
        int iCheckSelfPermission2 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION");
        if (iCheckSelfPermission != 0 || iCheckSelfPermission2 != 0) {
            if (lVar.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION") || lVar.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                lVar.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 102);
                return;
            } else {
                lVar.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 102);
                return;
            }
        }
        LocationComponentOptions locationComponentOptionsBuild = LocationComponentOptions.builder(lVar.p).trackingGesturesManagement(true).foregroundDrawable(R.drawable.mappls_direction_current_location_marker).foregroundDrawableStale(R.drawable.mappls_direction_current_location_stale).bearingDrawable(R.drawable.mappls_direction_bearing_icon).accuracyColor(ContextCompat.getColor(lVar.p, R.color.mappls_direction_colorPrimaryDark)).build();
        LocationComponent locationComponent = lVar.i.getLocationComponent();
        locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(lVar.p, style).locationComponentOptions(locationComponentOptionsBuild).build());
        locationComponent.setLocationComponentEnabled(lVar.e.options.showCurrentLocationOnMap().booleanValue());
        if (locationComponent.getLastKnownLocation() != null) {
            lVar.a(locationComponent.getLastKnownLocation());
        }
        LocationEngine locationEngine = locationComponent.getLocationEngine();
        lVar.j = locationEngine;
        locationEngine.getLastLocation(lVar);
        lVar.j.requestLocationUpdates(new LocationEngineRequest.Builder(1000L).setPriority(0).build(), lVar, Looper.getMainLooper());
        locationComponent.setCameraMode(8);
        locationComponent.setRenderMode(4);
    }

    private void a(DirectionsResponse directionsResponse) {
        this.d.errorLayout.setVisibility(8);
        this.d.notificationLayout.setVisibility(8);
        this.d.recyclerDirectionStep.setLayoutManager(new LinearLayoutManager(this.p));
        this.d.recyclerDirectionStep.setAdapter(this.g);
        this.d.bottomSheetShadow.setVisibility(8);
        this.d.progressBar.setVisibility(8);
        this.d.bottomSheetShadow.setVisibility(0);
        this.d.bottomSheetDetails.setBackgroundColor(0);
        this.d.bottomSheetDetails.setVisibility(0);
        this.d.recyclerDirectionStep.setVisibility(0);
        this.d.layoutTimeDetails.setVisibility(0);
        MapplsMap mapplsMap = this.i;
        if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
            this.i.getUiSettings().setLogoMargins(0, 0, 0, 350);
        }
        DirectionsRoute directionsRoute = directionsResponse.routes().get(this.e.getSelectedIndex());
        List<DirectionsRoute> listRoutes = directionsResponse.routes();
        List<Point> listDecode = directionsRoute.geometry() != null ? PolylineUtils.decode(directionsRoute.geometry(), 6) : null;
        if (listDecode == null) {
            listDecode = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (Point point : listDecode) {
            arrayList.add(new LatLng(point.latitude(), point.longitude()));
        }
        List<RouteLeg> listLegs = listRoutes.get(this.e.getSelectedIndex()).legs();
        this.l = new ArrayList();
        if (listLegs != null) {
            for (RouteLeg routeLeg : listLegs) {
                if (routeLeg.steps() != null) {
                    this.l.addAll(routeLeg.steps());
                }
            }
        }
        ArrayList arrayList2 = this.l;
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (this.g == null) {
                com.mappls.sdk.direction.ui.adapters.b bVar = new com.mappls.sdk.direction.ui.adapters.b(this.p, this.o, this.e.options, this.b);
                this.g = bVar;
                this.d.recyclerDirectionStep.setAdapter(bVar);
            }
            this.g.a(this.l, this.e.getStopModels());
        }
        a(arrayList);
        a(directionsRoute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        MapplsMap mapplsMap;
        CameraUpdate cameraUpdateNewLatLngBounds;
        if (this.i == null || arrayList.size() < 1) {
            return;
        }
        LatLngBounds latLngBoundsBuild = new LatLngBounds.Builder().includes(arrayList).build();
        if (getResources().getConfiguration().orientation == 2) {
            mapplsMap = this.i;
            cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, 400, 20, 80, 20);
        } else {
            mapplsMap = this.i;
            cameraUpdateNewLatLngBounds = CameraUpdateFactory.newLatLngBounds(latLngBoundsBuild, 20, 600, 20, 350);
        }
        mapplsMap.animateCamera(cameraUpdateNewLatLngBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) throws JSONException {
        RouteOptions routeOptions;
        DirectionsResponse directionsResponse = this.e.getDirectionsResponse();
        if (this.e.getStopModels().size() > 1) {
            StopModel stopModel = this.e.getStopModels().get(0);
            if (!com.mappls.sdk.direction.ui.common.a.a(stopModel)) {
                jSONObject.put("source", stopModel.getVisualValue());
            }
            StopModel stopModel2 = this.e.getStopModels().get(1);
            if (!com.mappls.sdk.direction.ui.common.a.a(stopModel2)) {
                jSONObject.put(FirebaseAnalytics.Param.DESTINATION, stopModel2.getVisualValue());
            }
            if (this.e.getStopModels().size() > 2) {
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i < this.e.getStopModels().size() - 1; i++) {
                    StopModel stopModel3 = this.e.getStopModels().get(i);
                    if (!com.mappls.sdk.direction.ui.common.a.a(stopModel3)) {
                        arrayList.add(stopModel3.getVisualValue());
                    }
                }
                if (arrayList.size() > 0) {
                    jSONObject.put("via_point", MapplsUtils.join("|", arrayList.toArray()));
                }
            }
        }
        if (directionsResponse != null) {
            if (directionsResponse.sessionId() != null) {
                jSONObject.put("session_id", directionsResponse.sessionId());
            }
            if (directionsResponse.uuid() != null) {
                jSONObject.put("request_id", directionsResponse.uuid());
            }
            if (directionsResponse.routes().size() > 0 && (routeOptions = directionsResponse.routes().get(0).routeOptions()) != null) {
                jSONObject.put("resource", routeOptions.resource());
                jSONObject.put(Scopes.PROFILE, routeOptions.profile());
                jSONObject.put("alternatives", routeOptions.alternatives());
            }
            jSONObject.put("routes_count", directionsResponse.routes().size());
            jSONObject.put("selected_route_index", this.e.getSelectedIndex());
        }
    }

    private void b() {
        this.e.directionResponseResourceLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.b((com.mappls.sdk.direction.ui.common.b) obj);
            }
        });
        this.e.routeReportSummaryResourceLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.c((com.mappls.sdk.direction.ui.common.b) obj);
            }
        });
        this.e.costEstimationResponseLiveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.a((com.mappls.sdk.direction.ui.common.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Direction-List-Item");
            a(jSONObject);
            jSONObject.put(ViewProps.POSITION, i);
            ArrayList arrayList = this.l;
            jSONObject.put("leg_step_size", arrayList != null ? arrayList.size() : 0);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.e.getStopModels().get(0).getLocationType() == StopModel.TYPE_STOP || !this.e.options.showStartNavigation().booleanValue()) {
            a(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_view", "Preview-Direction");
                a(jSONObject);
                jSONObject.put("show_navigation_option", this.e.options.showStartNavigation());
                jSONObject.put("is_source_current_location", this.e.getStopModels().get(0).getLocationType() == StopModel.TYPE_CURRENT_LOCATION);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (this.e.getStopModels().get(0).getLocationType() == StopModel.TYPE_CURRENT_LOCATION) {
            StopModel stopModel = this.e.getStopModels().get(0);
            DirectionPoint direction = stopModel.getLocation() != null ? DirectionPoint.setDirection(stopModel.getLocation(), stopModel.getPlaceName(), stopModel.getPlaceAddress()) : DirectionPoint.setDirection(stopModel.getMapplsPin(), stopModel.getPlaceName(), stopModel.getPlaceAddress());
            StopModel stopModel2 = this.e.getStopModels().get(this.e.getStopModels().size() - 1);
            if (com.mappls.sdk.direction.ui.common.a.a(stopModel2)) {
                stopModel2 = this.e.getStopModels().get(this.e.getStopModels().size() - 2);
                this.e.getStopModels().remove(this.e.getStopModels().size() - 1);
            }
            DirectionPoint direction2 = stopModel2.getLocation() != null ? DirectionPoint.setDirection(stopModel2.getLocation(), stopModel2.getPlaceName(), stopModel2.getPlaceAddress()) : DirectionPoint.setDirection(stopModel2.getMapplsPin(), stopModel2.getPlaceName(), stopModel2.getPlaceAddress());
            ArrayList arrayList = new ArrayList();
            if (this.e.getStopModels().size() > 2) {
                for (int i = 1; i < this.e.getStopModels().size() - 1; i++) {
                    StopModel stopModel3 = this.e.getStopModels().get(i);
                    arrayList.add(stopModel3.getLocation() != null ? DirectionPoint.setDirection(stopModel3.getLocation(), stopModel3.getPlaceName(), stopModel3.getPlaceAddress()) : DirectionPoint.setDirection(stopModel3.getMapplsPin(), stopModel3.getPlaceName(), stopModel3.getPlaceAddress()));
                }
            }
            DirectionsResponse directionsResponse = this.e.getDirectionsResponse();
            int selectedIndex = this.e.getSelectedIndex();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("event_view", "Start-Direction");
                a(jSONObject2);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject2);
                }
            } catch (Exception unused2) {
            }
            this.f699n.onStartNavigation(direction, direction2, arrayList, directionsResponse, selectedIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.mappls.sdk.direction.ui.common.b bVar) {
        DirectionsResponse directionsResponse;
        Point pointLocation;
        Point pointLocation2;
        if (bVar != null) {
            int i = bVar.a;
            if (i != 1) {
                if (i == 2) {
                    this.d.errorLayout.setVisibility(0);
                    this.d.notificationLayout.setVisibility(8);
                    this.d.bottomSheetDetails.setVisibility(8);
                    this.d.searchCategoryFab.setVisibility(8);
                    MapplsMap mapplsMap = this.i;
                    if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
                        this.i.getUiSettings().setLogoMargins(10, 0, 0, 10);
                    }
                    h hVar = this.f699n;
                    if (hVar != null) {
                        hVar.clearRoute();
                        return;
                    }
                    return;
                }
                return;
            }
            this.d.errorLayout.setVisibility(8);
            this.d.notificationLayout.setVisibility(8);
            this.e.tollHashMap.clear();
            T t = bVar.c;
            if (t == 0 || ((DirectionsResponse) t).routes().size() <= 0) {
                return;
            }
            a(this.e.getDirectionsResponse());
            LatLng latLng = null;
            LatLng latLng2 = (this.e.getStopModels().get(0).getLocationType() != StopModel.TYPE_STOP || ((DirectionsResponse) bVar.c).waypoints() == null || ((DirectionsResponse) bVar.c).waypoints().size() <= 0 || (pointLocation2 = ((DirectionsResponse) bVar.c).waypoints().get(0).location()) == null) ? null : new LatLng(pointLocation2.latitude(), pointLocation2.longitude());
            if (this.e.getStopModels().get(this.e.getStopModels().size() - 1).getLocationType() == StopModel.TYPE_STOP && ((DirectionsResponse) bVar.c).waypoints() != null && ((DirectionsResponse) bVar.c).waypoints().size() > 0 && (pointLocation = ((DirectionsResponse) bVar.c).waypoints().get(((DirectionsResponse) bVar.c).waypoints().size() - 1).location()) != null) {
                latLng = new LatLng(pointLocation.latitude(), pointLocation.longitude());
            }
            LatLng latLng3 = latLng;
            ArrayList arrayList = new ArrayList();
            if (this.e.getStopModels().size() > 2) {
                for (int i2 = 1; i2 < this.e.getStopModels().size() - 1; i2++) {
                    if (((DirectionsResponse) bVar.c).waypoints() != null && ((DirectionsResponse) bVar.c).waypoints().size() >= i2 && this.e.getStopModels().get(i2).getLocationType() == StopModel.TYPE_STOP) {
                        DirectionsWaypoint directionsWaypoint = ((DirectionsResponse) bVar.c).waypoints().get(i2);
                        if (directionsWaypoint.location() != null) {
                            arrayList.add(new LatLng(directionsWaypoint.location().latitude(), directionsWaypoint.location().longitude()));
                        }
                    }
                }
            }
            h hVar2 = this.f699n;
            if (hVar2 != null) {
                hVar2.onUpdateRoute(latLng2, latLng3, arrayList, ((DirectionsResponse) bVar.c).routes(), this.e.getSelectedIndex());
            }
            if (this.e.options.searchAlongRoute().booleanValue()) {
                this.d.searchCategoryFab.setVisibility(0);
            }
            if (!this.e.profile.equalsIgnoreCase("walking") && this.e.options.resource().equalsIgnoreCase(DirectionsCriteria.RESOURCE_ROUTE_ETA) && this.e.options.showRouteReportSummary().booleanValue() && (directionsResponse = (DirectionsResponse) bVar.c) != null && directionsResponse.sessionId() != null) {
                this.e.getRouteSummaryLiveData(directionsResponse.sessionId());
            }
            if (((DirectionsResponse) bVar.c).sessionId() == null || !this.e.options.showTripCostSummary().booleanValue()) {
                this.d.tripCostSummary.setVisibility(8);
                return;
            }
            this.d.tripCostSummary.setVisibility(0);
            for (int i3 = 0; i3 < ((DirectionsResponse) bVar.c).routes().size(); i3++) {
                this.e.getTollCostLiveData(((DirectionsResponse) bVar.c).sessionId(), i3, null, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Back-Direction");
            a(jSONObject);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        h hVar = this.f699n;
        if (hVar != null) {
            hVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void c(com.mappls.sdk.direction.ui.common.b bVar) {
        ImageView imageView;
        if (bVar != null) {
            int i = bVar.a;
            if (i == 1) {
                if (bVar.c != 0) {
                    this.d.nearbyReport.setVisibility(0);
                    this.e.setRouteReportSummaryResponse((RouteReportSummaryResponse) bVar.c);
                    h hVar = this.f699n;
                    if (hVar != null) {
                        hVar.onUpdateRouteReport(((RouteReportSummaryResponse) bVar.c).getRoutes(), this.e.getSelectedIndex());
                        return;
                    }
                    return;
                }
                imageView = this.d.nearbyReport;
            } else {
                if (i != 2) {
                    return;
                }
                this.d.nearbyReport.setVisibility(8);
                imageView = this.d.tripCostSummary;
            }
            imageView.setVisibility(8);
            this.e.setRouteReportSummaryResponse(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Show-Map");
            a(jSONObject);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        if (view != null) {
            a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view) {
        ImageView imageView;
        Context context;
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.getStopModels().size(); i3++) {
            if (com.mappls.sdk.direction.ui.common.a.a(this.e.getStopModels().get(i3)) || (i3 > 0 && com.mappls.sdk.direction.ui.common.e.a(this.e.getStopModels().get(i3 - 1), this.e.getStopModels().get(i3)))) {
                arrayList.add(this.e.getStopModels().get(i3));
            }
        }
        this.e.getStopModels().removeAll(arrayList);
        if (this.e.getStopModels().size() < 2) {
            StopModel stopModel = new StopModel();
            stopModel.setLocationType(StopModel.TYPE_BLANK);
            this.e.getStopModels().add(stopModel);
        }
        com.mappls.sdk.direction.ui.adapters.j jVar = this.f;
        if (jVar != null) {
            jVar.a(this.e.getStopModels());
        }
        if (this.e.getStopModels().size() > 2) {
            this.d.recyclerStop.setVisibility(8);
            this.d.viewGetRoute.setVisibility(8);
            this.d.collapsedRouteTimeline.collapsedRouteTimeline.setVisibility(0);
            this.d.errorLayout.setVisibility(8);
            this.d.notificationLayout.setVisibility(8);
            this.d.bottomSheetDetails.setVisibility(0);
            this.d.containerRouteDetails.setVisibility(0);
            this.d.recyclerDirectionStep.setVisibility(8);
            this.d.progressBar.setVisibility(0);
            this.d.bottomSheetShadow.setVisibility(8);
            this.d.bottomSheetDetails.setBackgroundColor(-1);
            this.d.layoutTimeDetails.setVisibility(8);
            this.d.collapsedRouteTimeline.setSourceRouteLocation(this.e.getSourceLocation());
            MapplsMap mapplsMap = this.i;
            if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
                this.i.getUiSettings().setLogoMargins(0, 0, 0, 350);
            }
            if (this.e.getSourceLocation().equals("Your Current Location")) {
                imageView = this.d.collapsedRouteTimeline.imgSourceLocation;
                context = this.p;
                i = R.drawable.mappls_direction_current_location_icon;
            } else {
                imageView = this.d.collapsedRouteTimeline.imgSourceLocation;
                context = this.p;
                i = R.drawable.mappls_direction_start_loc;
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(context, i));
            this.d.collapsedRouteTimeline.setDestinationRouteLocation(this.e.getDestinationLocation());
            this.d.collapsedRouteTimeline.setWayPoints((this.e.getStopModels().size() - 2) + " waypoints");
        } else {
            this.d.viewGetRoute.setVisibility(8);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Get-Routes");
            a(jSONObject);
            jSONObject.put("item_size", this.e.getStopModels().size());
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        Iterator<StopModel> it2 = this.e.getStopModels().iterator();
        while (it2.hasNext()) {
            if (!com.mappls.sdk.direction.ui.common.a.a(it2.next())) {
                i2++;
            }
        }
        if (i2 <= 1) {
            this.e.getStopModels().size();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view) {
        if (this.e.getStopModels().size() > 2 && this.e.getStopModels().size() < 5) {
            StopModel stopModel = new StopModel();
            stopModel.setLocationType(StopModel.TYPE_BLANK);
            this.e.addStop(stopModel);
            this.f.a(this.e.getStopModels());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Expand-Locations-View");
            a(jSONObject);
            jSONObject.put("item_size", this.e.getStopModels().size());
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        this.d.recyclerStop.setVisibility(0);
        this.d.viewGetRoute.setVisibility(0);
        this.d.collapsedRouteTimeline.collapsedRouteTimeline.setVisibility(8);
        this.d.errorLayout.setVisibility(8);
        this.d.notificationLayout.setVisibility(8);
        this.d.bottomSheetDetails.setVisibility(8);
        this.d.viewGetRoute.setVisibility(0);
        Iterator<StopModel> it2 = this.e.getStopModels().iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (!com.mappls.sdk.direction.ui.common.a.a(it2.next())) {
                i++;
            }
        }
        if (i <= 1) {
            this.e.getStopModels().size();
        }
        MapplsMap mapplsMap = this.i;
        if (mapplsMap == null || mapplsMap.getUiSettings() == null) {
            return;
        }
        this.i.getUiSettings().setLogoMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view) {
        if (this.e.getDirectionsResponse() == null) {
            Toast.makeText(this.p, "Route is not available.", 0).show();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Search-Along-Route");
            a(jSONObject);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        this.f699n.searchCategory(this.e.getDirectionsResponse().routes().get(this.e.getSelectedIndex()).geometry(), this.e.options);
    }

    static void h(l lVar) {
        com.mappls.sdk.direction.ui.adapters.j jVar = lVar.f;
        if (jVar != null) {
            jVar.a(lVar.e.getStopModels());
        }
        if (lVar.e.getStopModels().size() == 2) {
            List<StopModel> stopModels = lVar.e.getStopModels();
            if (com.mappls.sdk.direction.ui.common.a.a(stopModels.get(0)) || com.mappls.sdk.direction.ui.common.a.a(stopModels.get(1))) {
                return;
            }
            lVar.d.bottomSheetDetails.setVisibility(0);
            lVar.d.errorLayout.setVisibility(8);
            lVar.d.notificationLayout.setVisibility(8);
            lVar.d.containerRouteDetails.setVisibility(0);
            lVar.d.progressBar.setVisibility(0);
            lVar.d.bottomSheetShadow.setVisibility(8);
            lVar.d.bottomSheetDetails.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(lVar.p, R.color.mappls_directions_white), lVar.p));
            lVar.d.layoutTimeDetails.setVisibility(8);
            lVar.d.recyclerDirectionStep.setVisibility(8);
            MapplsMap mapplsMap = lVar.i;
            if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
                lVar.i.getUiSettings().setLogoMargins(0, 0, 0, 300);
            }
            lVar.a();
        }
    }

    public final void a(int i, DirectionsRoute directionsRoute) {
        h hVar;
        this.e.setSelectedIndex(i);
        if (this.e.getRouteReportSummaryResponse() != null && (hVar = this.f699n) != null) {
            hVar.onUpdateRouteReport(this.e.getRouteReportSummaryResponse().getRoutes(), i);
        }
        a(directionsRoute);
    }

    public final void a(Location location) {
        DirectionViewModel directionViewModel;
        if (location == null || (directionViewModel = this.e) == null || directionViewModel.getStopModels().size() != 2) {
            return;
        }
        StopModel stopModel = this.e.getStopModels().get(0);
        if (com.mappls.sdk.direction.ui.common.a.a(stopModel)) {
            int locationType = this.e.getStopModels().get(1).getLocationType();
            int i = StopModel.TYPE_CURRENT_LOCATION;
            if (locationType != i) {
                stopModel.setLocationType(i);
                stopModel.setPlaceName("Current Location");
                stopModel.setPlaceAddress("");
                stopModel.setLocation(Point.fromLngLat(location.getLongitude(), location.getLatitude()));
                this.i.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16.0d));
                a();
            }
        }
        com.mappls.sdk.direction.ui.adapters.j jVar = this.f;
        if (jVar != null) {
            jVar.a(this.e.getStopModels());
        }
    }

    public final void a(PoiResult poiResult) {
        if (this.e.getStopModels().size() < 2 || this.e.getStopModels().size() >= 5) {
            return;
        }
        StopModel stopModel = new StopModel();
        if (poiResult.getLatitude() != null && poiResult.getLongitude() != null) {
            stopModel.setLocation(Point.fromLngLat(poiResult.getLongitude().doubleValue(), poiResult.getLatitude().doubleValue()));
        }
        stopModel.setMapplsPin(poiResult.getMapplsPin());
        stopModel.setPlaceName(poiResult.getPlaceName());
        stopModel.setPlaceAddress(poiResult.getPlaceAddress());
        stopModel.setLocationType(StopModel.TYPE_STOP);
        for (int i = 0; i < this.e.getStopModels().size(); i++) {
            if (com.mappls.sdk.direction.ui.common.e.a(stopModel, this.e.getStopModels().get(i))) {
                Toast.makeText(this.p, "Already added", 0).show();
                return;
            }
        }
        this.e.addWayPoint(stopModel);
        a();
    }

    public final void a(h hVar) {
        this.f699n = hVar;
    }

    public final void a(MapView mapView) {
        this.k = mapView;
        if (this.p == null || this.a) {
            return;
        }
        mapView.getMapAsync(this);
    }

    public final void a(CostEstimationResponse costEstimationResponse) {
        DirectionViewModel directionViewModel = this.e;
        directionViewModel.tollHashMap.put(Integer.valueOf(directionViewModel.getSelectedIndex()), costEstimationResponse);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        this.p = context;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x018e  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017d, code lost:
    
        if (r8 != 32) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b0, code lost:
    
        if (r7.e.options.theme().intValue() == 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b2, code lost:
    
        r8 = r7.e.options.directionDarkTheme().intValue();
        r7.o = r8;
        r7.b = true;
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ImageView imageView;
        Context context;
        int i;
        TabLayout.Tab tabAt;
        this.a = false;
        this.d = (MapplsRoutingLayoutBinding) DataBindingUtil.inflate(layoutInflater, R.layout.mappls_routing_layout, viewGroup, false);
        this.e = (DirectionViewModel) new ViewModelProvider(this).get(DirectionViewModel.class);
        Bundle arguments = getArguments();
        if (bundle != null || arguments == null) {
            this.e.directionResponseResourceLiveData = new MutableLiveData<>();
            this.e.costEstimationResponseLiveData = new MutableLiveData<>();
            this.e.routeReportSummaryResourceLiveData = new MutableLiveData<>();
        } else {
            DirectionOptions directionOptions = (DirectionOptions) arguments.getParcelable("com.mappls.sdk.direction.ui.DirectionModel");
            if (directionOptions != null) {
                this.e.options = directionOptions;
                this.q = directionOptions.destination();
                this.r = this.e.options.origin();
            }
            arguments.clear();
        }
        DirectionViewModel directionViewModel = this.e;
        if (directionViewModel.options == null) {
            directionViewModel.options = DirectionOptions.builder().build();
        }
        DirectionViewModel directionViewModel2 = this.e;
        if (directionViewModel2.profile == null) {
            directionViewModel2.profile = directionViewModel2.options.profile();
        }
        if (this.e.options.showProfileOption().booleanValue()) {
            this.d.mapplsDirectionTabLayout.setVisibility(0);
            if (!this.e.options.showHeavyVehicleProfile().booleanValue() && this.d.mapplsDirectionTabLayout.getTabAt(2) != null) {
                this.d.mapplsDirectionTabLayout.getTabAt(2).view.setVisibility(8);
            }
            if (!this.e.options.showWalkingProfile().booleanValue() && this.d.mapplsDirectionTabLayout.getTabAt(3) != null) {
                this.d.mapplsDirectionTabLayout.getTabAt(3).view.setVisibility(8);
            }
            String str = this.e.profile;
            if (str.equalsIgnoreCase("driving")) {
                if (this.d.mapplsDirectionTabLayout.getTabAt(0) != null) {
                    tabAt = this.d.mapplsDirectionTabLayout.getTabAt(0);
                    tabAt.select();
                }
            } else if (str.equalsIgnoreCase("biking")) {
                if (this.d.mapplsDirectionTabLayout.getTabAt(1) != null) {
                    tabAt = this.d.mapplsDirectionTabLayout.getTabAt(1);
                    tabAt.select();
                }
            } else if (str.equalsIgnoreCase("walking")) {
                if (this.d.mapplsDirectionTabLayout.getTabAt(3) != null) {
                    tabAt = this.d.mapplsDirectionTabLayout.getTabAt(3);
                    tabAt.select();
                }
            } else if (str.equalsIgnoreCase("trucking") && this.d.mapplsDirectionTabLayout.getTabAt(3) != null) {
                tabAt = this.d.mapplsDirectionTabLayout.getTabAt(2);
                tabAt.select();
            }
        } else {
            this.d.mapplsDirectionTabLayout.setVisibility(8);
        }
        if (this.e.options.theme().intValue() == 0) {
            int i2 = getResources().getConfiguration().uiMode & 48;
            if (i2 == 16) {
                int iIntValue = this.e.options.directionDayTheme().intValue();
                this.o = iIntValue;
                this.b = false;
                this.p.setTheme(iIntValue);
            }
        } else if (this.e.options.theme().intValue() == 1) {
            int iIntValue2 = this.e.options.directionDayTheme().intValue();
            this.o = iIntValue2;
            this.b = false;
            this.p.setTheme(iIntValue2);
        }
        this.d.directionDecorationImageView.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.directionsTopView.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_top_card_background, R.drawable.mappls_direction_background_card_layout, this.p));
        this.d.mapplsDirectionTabLayout.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_profile_selection_background, R.drawable.mappls_directions_tab_background, this.p));
        this.d.viewGetRoute.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_get_route_background, R.drawable.mappls_direction_get_route_background, this.p));
        this.d.viewGetRoute.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_get_route_text_color, Color.parseColor("#007BBE"), this.p));
        this.d.mapplsDirectionBack.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_back, R.drawable.mappls_direction_baseline_arrow_back_24, this.p));
        this.d.collapsedRouteTimeline.textSourceRoute.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.collapsedRouteTimeline.textViewWaypoints.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.collapsedRouteTimeline.textDestinationRoute.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.searchCategoryFab.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_search_along_background, R.drawable.mappls_direction_ic_search_button, this.p));
        this.d.searchCategoryFab.setImageResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_search_along_icon, R.drawable.mappls_direction_ic_baseline_search_24, this.p));
        this.d.errorLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.tvRouteNotFoundHeading.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.tvRouteNotFoundText.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.bottomSheetDetails.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.layoutTimeDetails.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_eta_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.progressBar.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.textRoute.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_time_text_color, ContextCompat.getColor(this.p, R.color.mappls_directions_route_time_text_Color), this.p));
        this.d.distanceText.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.directionEtaTextView.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.directionListTextview.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_primary, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.mapplsDirectionEtaSeperator.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_eta_seperator, Color.parseColor("#DEDEDE"), this.p));
        this.d.notificationLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.tvClassNotification.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_route_notification_background, R.drawable.mappls_direction_notification_background, this.p));
        this.d.tvClassNotification.setTextColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_text_color, ContextCompat.getColor(this.p, R.color.mappls_directions_colorTextPrimary), this.p));
        this.d.recyclerDirectionStep.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_step_list_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.d.directionListTextview.setBackgroundResource(com.mappls.sdk.direction.ui.utils.b.b(R.styleable.mappls_direction_mappls_directions_list_text_tv_drawable, R.drawable.mappls_direction_drawable_direction, this.p));
        this.d.showOnMapsLayout.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_show_map_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
        this.f = new com.mappls.sdk.direction.ui.adapters.j(this.e.options);
        this.d.recyclerStop.setLayoutManager(new LinearLayoutManager(this.p));
        RecyclerViewDragDropManager recyclerViewDragDropManager = new RecyclerViewDragDropManager();
        this.m = recyclerViewDragDropManager;
        recyclerViewDragDropManager.setInitiateOnMove(false);
        this.m.setInitiateOnLongPress(true);
        this.m.setDraggingItemAlpha(0.4f);
        this.d.recyclerStop.setAdapter(this.m.createWrappedAdapter(this.f));
        this.m.attachRecyclerView(this.d.recyclerStop);
        if (this.e.getStopModels().size() < 2) {
            StopModel stopModel = new StopModel();
            if (this.r == null) {
                stopModel.setLocationType(StopModel.TYPE_BLANK);
            } else {
                stopModel.setLocationType(StopModel.TYPE_STOP);
                if (this.r.getLatitude() != null || this.r.getLongitude() != null) {
                    stopModel.setLocation(Point.fromLngLat(this.r.getLongitude().doubleValue(), this.r.getLatitude().doubleValue()));
                }
                stopModel.setPlaceAddress(this.r.getPlaceAddress());
                stopModel.setPlaceName(this.r.getPlaceName());
                stopModel.setMapplsPin(this.r.getMapplsPin());
            }
            this.e.getStopModels().add(stopModel);
            StopModel stopModel2 = new StopModel();
            if (this.q == null) {
                stopModel2.setLocationType(StopModel.TYPE_BLANK);
            } else {
                stopModel2.setLocationType(StopModel.TYPE_STOP);
                if (this.q.getLatitude() != null || this.q.getLongitude() != null) {
                    stopModel2.setLocation(Point.fromLngLat(this.q.getLongitude().doubleValue(), this.q.getLatitude().doubleValue()));
                }
                stopModel2.setPlaceAddress(this.q.getPlaceAddress());
                stopModel2.setPlaceName(this.q.getPlaceName());
                stopModel2.setMapplsPin(this.q.getMapplsPin());
            }
            this.e.getStopModels().add(stopModel2);
        }
        com.mappls.sdk.direction.ui.adapters.j jVar = this.f;
        if (jVar != null) {
            jVar.a(this.e.getStopModels());
        }
        if (this.e.getStopModels().size() > 2) {
            this.d.recyclerStop.setVisibility(8);
            this.d.viewGetRoute.setVisibility(8);
            this.d.collapsedRouteTimeline.collapsedRouteTimeline.setVisibility(0);
            this.d.errorLayout.setVisibility(8);
            this.d.notificationLayout.setVisibility(8);
            this.d.bottomSheetDetails.setVisibility(0);
            this.d.containerRouteDetails.setVisibility(0);
            this.d.recyclerDirectionStep.setVisibility(8);
            this.d.progressBar.setVisibility(0);
            this.d.bottomSheetShadow.setVisibility(8);
            this.d.bottomSheetDetails.setBackgroundColor(com.mappls.sdk.direction.ui.utils.b.a(R.styleable.mappls_direction_mappls_directions_route_background, ContextCompat.getColor(this.p, R.color.mappls_directions_white), this.p));
            MapplsMap mapplsMap = this.i;
            if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
                this.i.getUiSettings().setLogoMargins(0, 0, 0, 350);
            }
            this.d.layoutTimeDetails.setVisibility(8);
            this.d.collapsedRouteTimeline.setSourceRouteLocation(this.e.getSourceLocation());
            if (this.e.getSourceLocation().equals("Your Current Location")) {
                imageView = this.d.collapsedRouteTimeline.imgSourceLocation;
                context = this.p;
                i = R.drawable.mappls_direction_current_location_icon;
            } else {
                imageView = this.d.collapsedRouteTimeline.imgSourceLocation;
                context = this.p;
                i = R.drawable.mappls_direction_start_loc;
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(context, i));
            this.d.collapsedRouteTimeline.setDestinationRouteLocation(this.e.getDestinationLocation());
            this.d.collapsedRouteTimeline.setWayPoints((this.e.getStopModels().size() - 2) + " waypoints");
        } else {
            this.d.viewGetRoute.setVisibility(8);
        }
        Iterator<StopModel> it2 = this.e.getStopModels().iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            if (!com.mappls.sdk.direction.ui.common.a.a(it2.next())) {
                i3++;
            }
        }
        if (i3 <= 1) {
            this.e.getStopModels().size();
        }
        if (this.q != null) {
            a();
        }
        MapView mapView = this.k;
        if (mapView != null && !this.a) {
            mapView.getMapAsync(this);
        }
        b();
        this.g = new com.mappls.sdk.direction.ui.adapters.b(this.p, this.o, this.e.options, this.b);
        this.d.setOnRouteReportClick(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.d.tripCostSummary.setOnClickListener(new a());
        this.d.setRetryButtonClick(new b());
        this.d.setStartButtonClick(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        if (this.e.getDirectionsResponse() != null) {
            a(this.e.getDirectionsResponse());
            if (this.e.options.searchAlongRoute().booleanValue()) {
                this.d.searchCategoryFab.setVisibility(0);
            }
            if (this.e.getDirectionsResponse().sessionId() == null || !this.e.options.showTripCostSummary().booleanValue()) {
                this.d.tripCostSummary.setVisibility(8);
            } else {
                this.d.tripCostSummary.setVisibility(0);
                for (int i4 = 0; i4 < this.e.getDirectionsResponse().routes().size(); i4++) {
                    DirectionViewModel directionViewModel3 = this.e;
                    directionViewModel3.getTollCostLiveData(directionViewModel3.getDirectionsResponse().sessionId(), i4, null, null, null);
                }
            }
            this.d.setOnStartClick(this.e);
        }
        if (getChildFragmentManager() != null && getChildFragmentManager().findFragmentByTag(PlaceAutocompleteFragment.class.getName()) != null) {
            getChildFragmentManager().popBackStack();
        }
        this.f.a(new c());
        this.g.a(new com.mappls.sdk.direction.ui.adapters.b.e() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda6
            @Override // com.mappls.sdk.direction.ui.adapters.b.e
            public final void a(int i5) {
                this.f$0.b(i5);
            }
        });
        this.d.setOnHandleBack(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        this.d.showOnMapsBtn.setOnClickListener(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
        this.d.setOnClickGetRoute(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.e(view);
            }
        });
        this.d.collapsedRouteTimeline.setOnclickHandleBack(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.f(view);
            }
        });
        this.d.setOnClickSearchCategory(new View.OnClickListener() { // from class: com.mappls.sdk.direction.ui.fragment.l$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.g(view);
            }
        });
        this.d.mapplsDirectionTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new m(this));
        return this.d.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        RecyclerViewDragDropManager recyclerViewDragDropManager = this.m;
        if (recyclerViewDragDropManager != null) {
            recyclerViewDragDropManager.release();
        }
        this.e.directionResponseResourceLiveData.removeObservers(this);
        LocationEngine locationEngine = this.j;
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates(this);
        }
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public final void onFailure(Exception exc) {
        exc.printStackTrace();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapError(int i, String str) {
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public final void onMapReady(MapplsMap mapplsMap) {
        this.i = mapplsMap;
        this.a = true;
        mapplsMap.clear();
        if (mapplsMap.getUiSettings() != null) {
            this.i.getUiSettings().setLogoMargins(0, 0, 0, 0);
        }
        mapplsMap.getStyle(new d());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        MapplsMap mapplsMap;
        if (i != 102 || iArr.length <= 0 || iArr[0] != 0 || (mapplsMap = this.i) == null) {
            return;
        }
        mapplsMap.getStyle(new e());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
    public final void onSuccess(LocationEngineResult locationEngineResult) {
        Location lastLocation;
        LocationEngineResult locationEngineResult2 = locationEngineResult;
        if (locationEngineResult2 == null || (lastLocation = locationEngineResult2.getLastLocation()) == null) {
            return;
        }
        this.c = lastLocation;
        a(lastLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String mapplsPin;
        List<StopModel> stopModels = this.e.getStopModels();
        if (com.mappls.sdk.direction.ui.common.a.a(stopModels.get(0)) || com.mappls.sdk.direction.ui.common.a.a(stopModels.get(1))) {
            return;
        }
        StopModel stopModel = stopModels.get(0);
        Point location = stopModel.getLocation();
        Point entryLocation = stopModel.getEntryLocation();
        String mapplsPin2 = entryLocation != null ? String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(entryLocation.longitude()), MapplsUtils.formatCoordinate(entryLocation.latitude())) : location != null ? String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(location.longitude()), MapplsUtils.formatCoordinate(location.latitude())) : stopModel.getMapplsPin();
        this.d.setOnStartClick(this.e);
        ArrayList arrayList = new ArrayList();
        if (this.e.getStopModels().size() > 2) {
            for (int i = 1; i < this.e.getStopModels().size() - 1; i++) {
                if (this.e.getStopModels().get(i).getEntryLocation() != null) {
                    Point entryLocation2 = this.e.getStopModels().get(i).getEntryLocation();
                    mapplsPin = String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(entryLocation2.longitude()), MapplsUtils.formatCoordinate(entryLocation2.latitude()));
                } else if (this.e.getStopModels().get(i).getLocation() != null) {
                    Point location2 = this.e.getStopModels().get(i).getLocation();
                    mapplsPin = String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(location2.longitude()), MapplsUtils.formatCoordinate(location2.latitude()));
                } else {
                    if (this.e.getStopModels().get(i).getMapplsPin() != null) {
                        mapplsPin = this.e.getStopModels().get(i).getMapplsPin();
                    }
                }
                arrayList.add(mapplsPin);
            }
        }
        if (stopModels.size() >= 3 || !com.mappls.sdk.direction.ui.common.a.a(stopModels.get(1))) {
            if (com.mappls.sdk.direction.ui.common.a.a(stopModels.get(stopModels.size() - 1))) {
                stopModels.remove(stopModels.size() - 1);
                this.e.setStopModels(stopModels);
                Iterator<StopModel> it2 = stopModels.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    if (!com.mappls.sdk.direction.ui.common.a.a(it2.next())) {
                        i2++;
                    }
                }
                if (i2 <= 1) {
                    stopModels.size();
                }
                com.mappls.sdk.direction.ui.adapters.j jVar = this.f;
                if (jVar != null) {
                    jVar.a(this.e.getStopModels());
                }
            }
            Point location3 = stopModels.get(stopModels.size() - 1).getLocation();
            Point entryLocation3 = stopModels.get(stopModels.size() - 1).getEntryLocation();
            String mapplsPin3 = entryLocation3 != null ? String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(entryLocation3.longitude()), MapplsUtils.formatCoordinate(entryLocation3.latitude())) : location3 != null ? String.format(Locale.US, "%s,%s", MapplsUtils.formatCoordinate(location3.longitude()), MapplsUtils.formatCoordinate(location3.latitude())) : stopModels.get(stopModels.size() - 1).getMapplsPin();
            if (mapplsPin2 == null || mapplsPin3 == null || getContext() == null) {
                return;
            }
            this.d.errorLayout.setVisibility(8);
            this.d.notificationLayout.setVisibility(8);
            this.d.bottomSheetDetails.setVisibility(0);
            this.d.containerRouteDetails.setVisibility(0);
            this.d.progressBar.setVisibility(0);
            MapplsMap mapplsMap = this.i;
            if (mapplsMap != null && mapplsMap.getUiSettings() != null) {
                this.i.getUiSettings().setLogoMargins(0, 0, 0, 350);
            }
            this.d.nearbyReport.setVisibility(8);
            this.d.tripCostSummary.setVisibility(8);
            this.e.setRouteReportSummaryResponse(null);
            this.e.getRouteLiveData(requireContext(), mapplsPin2, mapplsPin3, arrayList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0123  */
    private void a(DirectionsRoute directionsRoute) {
        MapplsRoutingLayoutBinding mapplsRoutingLayoutBinding;
        StringBuilder sb;
        double dDoubleValue;
        DistanceType distanceType;
        String str;
        LegAnnotation legAnnotationAnnotation;
        if (directionsRoute.distance() == null || directionsRoute.distance() == null || directionsRoute.duration() == null) {
            return;
        }
        BottomSheetBehavior<RelativeLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.d.bottomSheetDetails);
        this.h = bottomSheetBehaviorFrom;
        bottomSheetBehaviorFrom.setHideable(false);
        this.h.setState(4);
        if (directionsRoute.legs() == null || directionsRoute.legs().size() <= 0 || (legAnnotationAnnotation = directionsRoute.legs().get(0).annotation()) == null) {
            this.d.textRoute.setTextColor(ContextCompat.getColor(this.p, R.color.mappls_direction_eta_text_color_with_out_traffic));
        } else {
            this.d.textRoute.setTextColor(ContextCompat.getColor(this.p, com.mappls.sdk.direction.ui.common.e.a(legAnnotationAnnotation.congestion())));
        }
        RouteClasses routeClasses = directionsRoute.routeClasses();
        ArrayList arrayList = new ArrayList();
        if (routeClasses != null) {
            if (routeClasses.toll() != null && routeClasses.toll().intValue() == 1) {
                arrayList.add("Toll");
            }
            if (routeClasses.ferry() != null && routeClasses.ferry().intValue() == 1) {
                arrayList.add("Ferry");
            }
            if (routeClasses.ferry() != null && routeClasses.ferry().intValue() == 1) {
                arrayList.add("Tunnel");
            }
            if (routeClasses.motorway() != null && routeClasses.motorway().intValue() == 1) {
                arrayList.add("Motorway");
            }
            if (arrayList.size() > 0) {
                StringBuilder sb2 = new StringBuilder("This route includes ");
                if (arrayList.size() == 1) {
                    sb2.append((String) arrayList.get(0));
                } else {
                    int i = 0;
                    while (i < arrayList.size()) {
                        if (i != arrayList.size() - 1) {
                            str = i != 0 ? ", " : " & ";
                            sb2.append((String) arrayList.get(i));
                            i++;
                        }
                        sb2.append(str);
                        sb2.append((String) arrayList.get(i));
                        i++;
                    }
                }
                this.d.notificationLayout.setVisibility(0);
                this.d.tvClassNotification.setText(sb2.toString());
            } else {
                this.d.notificationLayout.setVisibility(8);
            }
        } else {
            this.d.notificationLayout.setVisibility(8);
        }
        this.d.setRouteTime("" + DirectionFormatter.getFormattedDuration(directionsRoute.duration().doubleValue()));
        this.d.setArrival("Arrival: " + DirectionFormatter.getArrivalTime(directionsRoute.duration().doubleValue(), DateTimeFormat.DATE_12_HOUR));
        DirectionOptions directionOptions = this.e.options;
        if (directionOptions == null || directionOptions.distanceType().intValue() == 0) {
            mapplsRoutingLayoutBinding = this.d;
            sb = new StringBuilder("");
            dDoubleValue = directionsRoute.distance().doubleValue();
            distanceType = DistanceType.METRIC;
        } else {
            mapplsRoutingLayoutBinding = this.d;
            sb = new StringBuilder("");
            dDoubleValue = directionsRoute.distance().doubleValue();
            distanceType = DistanceType.IMPERIAL;
        }
        sb.append(DirectionFormatter.getFormattedDistanceRound(dDoubleValue, distanceType));
        mapplsRoutingLayoutBinding.setDistance(sb.toString());
        this.d.executePendingBindings();
        this.d.invalidateAll();
    }
}
