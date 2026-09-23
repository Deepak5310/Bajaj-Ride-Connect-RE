package com.bajajconnect.navigate.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bajajconnect.NavApplication;
import com.bajajconnect.NavigationVariables;
import com.bajajconnect.R;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.navigate.adapter.AddRouteAdapterMMI;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.viewmodel.RouteViewModel;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.annotations.MarkerOptions;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.iface.IStopSession;
import com.mappls.sdk.navigation.model.NavigationResponse;
import com.mappls.sdk.navigation.util.ErrorType;
import com.mappls.sdk.plugins.places.autocomplete.model.MapplsFavoritePlace;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceAutocompleteFragment;
import com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class RouteFragment extends Fragment implements View.OnClickListener, OnMapReadyCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ARG_E_FROM_LOCATION = "from_location";
    private static final String ARG_E_LOCATION = "e_location";
    private AddRouteAdapterMMI addRouteAdapter;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f34app;
    private ImageView backImageView;
    private LinearLayout cancleBtn;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private MapplsMap mapboxMap;
    private LinearLayout moveToNavigationFragment;
    private Runnable pendingAutoStartRetry;
    private RecyclerView recyclerViewTo;
    private TextView textFrom;
    private TextView textViewDistance;
    private TextView textViewTime;
    private RouteViewModel viewModel;
    private boolean takeMeHome = false;
    private boolean handedOffToGuidance = false;
    private boolean startNavigationInFlight = false;
    private final Handler autoStartHandler = new Handler(Looper.getMainLooper());
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.e("RouteFragment", "intent recieved");
            if (Objects.equals(intent.getAction(), MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION)) {
                RouteFragment.this.openNavigationFragmentOnce();
            }
        }
    };

    public void checkForWifi() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public static RouteFragment newInstance(ELocation eLocation, String str) {
        RouteFragment routeFragment = new RouteFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_E_LOCATION, new Gson().toJson(eLocation));
        bundle.putString(ARG_E_FROM_LOCATION, str);
        routeFragment.setArguments(bundle);
        return routeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.viewModel = (RouteViewModel) ViewModelProviders.of(this).get(RouteViewModel.class);
        NavApplication myApplication = getMyApplication();
        this.f34app = myApplication;
        if (bundle == null) {
            myApplication.setTrip(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_route, viewGroup, false);
        viewInflate.setVisibility(8);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginNavigationMirroring() {
        if (getActivity() == null) {
            return;
        }
        MirroringPolicy.startRoutePreviewMirroring(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.takeMeHome = ((HomeActivity) getActivity()).isTakeMeHome;
        checkForWifi();
        registerBroadcastReciever();
        initView(view);
        this.recyclerViewTo.setLayoutManager(new LinearLayoutManager(getContext()));
        AddRouteAdapterMMI addRouteAdapterMMI = new AddRouteAdapterMMI();
        this.addRouteAdapter = addRouteAdapterMMI;
        this.recyclerViewTo.setAdapter(addRouteAdapterMMI);
        this.addRouteAdapter.setAddRouteListener(new AddRouteAdapterMMI.AddRouteListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.1
            @Override // com.bajajconnect.navigate.adapter.AddRouteAdapterMMI.AddRouteListener
            public void onAddRoute() {
                RouteFragment.this.addRouteAdapter.setShowNextBlankLocation(true);
            }

            @Override // com.bajajconnect.navigate.adapter.AddRouteAdapterMMI.AddRouteListener
            public void onRemoveRoute(int i) {
                if (RouteFragment.this.viewModel.geteLocations() == null) {
                    RouteFragment.this.onFragmentBackPressed();
                    return;
                }
                if (i < RouteFragment.this.viewModel.geteLocations().size()) {
                    RouteFragment.this.viewModel.geteLocations().remove(i);
                } else {
                    RouteFragment.this.viewModel.seteLocation(RouteFragment.this.viewModel.geteLocations().get(RouteFragment.this.viewModel.geteLocations().size() - 1));
                    RouteFragment.this.viewModel.geteLocations().remove(RouteFragment.this.viewModel.geteLocations().size() - 1);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(RouteFragment.this.viewModel.geteLocations());
                arrayList.add(RouteFragment.this.viewModel.geteLocation());
                RouteFragment.this.addRouteAdapter.updateList(arrayList);
                try {
                    if (RouteFragment.this.f34app.getCurrentLocation() != null) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<ELocation> it2 = RouteFragment.this.viewModel.geteLocations().iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(RouteFragment.this.getPoint(it2.next()));
                        }
                        RouteFragment routeFragment = RouteFragment.this;
                        arrayList2.add(routeFragment.getPoint(routeFragment.viewModel.geteLocation()));
                        RouteFragment.this.getRoute(new LatLng(RouteFragment.this.f34app.getCurrentLocation().getLatitude(), RouteFragment.this.f34app.getCurrentLocation().getLongitude()), arrayList2);
                        return;
                    }
                    Toast.makeText(RouteFragment.this.getActivity(), R.string.current_location_not_available, 0).show();
                    RouteFragment.this.onFragmentBackPressed();
                } catch (Exception e) {
                    Timber.e(e);
                    Log.e("RouteFragment", e.toString());
                    Toast.makeText(RouteFragment.this.getActivity(), R.string.something_went_wrong, 0).show();
                    RouteFragment.this.onFragmentBackPressed();
                }
            }

            @Override // com.bajajconnect.navigate.adapter.AddRouteAdapterMMI.AddRouteListener
            public void onClickRouteText(final int i) {
                if (RouteFragment.this.getActivity() != null) {
                    Location currentLocation = RouteFragment.this.f34app.getCurrentLocation();
                    if (currentLocation == null) {
                        Toast.makeText(RouteFragment.this.getContext(), "Please wait before getting current location", 0).show();
                        return;
                    }
                    PlaceAutocompleteFragment placeAutocompleteFragmentNewInstance = PlaceAutocompleteFragment.newInstance(PlaceOptions.builder().saveHistory(true).userAddedLocationEnable(true).historyCount(5).enableTextSearch(true).location(Point.fromLngLat(currentLocation.getLongitude(), currentLocation.getLatitude())).backgroundColor(ContextCompat.getColor(RouteFragment.this.getContext(), androidx.cardview.R.color.cardview_dark_background)).build(2));
                    placeAutocompleteFragmentNewInstance.setOnPlaceSelectedListener(new PlaceSelectionListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.1.1
                        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
                        public void onFavoritePlaceSelected(MapplsFavoritePlace mapplsFavoritePlace) {
                        }

                        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
                        public void requestForCurrentLocation() {
                        }

                        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
                        public void onPlaceSelected(ELocation eLocation) {
                            if (RouteFragment.this.viewModel.geteLocations() == null) {
                                RouteFragment.this.onFragmentBackPressed();
                                return;
                            }
                            int size = RouteFragment.this.viewModel.geteLocations().size();
                            int i2 = i;
                            if (size == i2) {
                                RouteFragment.this.viewModel.seteLocation(eLocation);
                            } else if (i2 < RouteFragment.this.viewModel.geteLocations().size()) {
                                RouteFragment.this.viewModel.geteLocations().remove(i);
                                RouteFragment.this.viewModel.geteLocations().add(i, eLocation);
                            } else {
                                RouteFragment.this.viewModel.geteLocations().add(RouteFragment.this.viewModel.geteLocation());
                                RouteFragment.this.viewModel.seteLocation(eLocation);
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(RouteFragment.this.viewModel.geteLocations());
                            arrayList.add(RouteFragment.this.viewModel.geteLocation());
                            RouteFragment.this.addRouteAdapter.updateList(arrayList);
                            try {
                                if (RouteFragment.this.f34app.getCurrentLocation() != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<ELocation> it2 = RouteFragment.this.viewModel.geteLocations().iterator();
                                    while (it2.hasNext()) {
                                        arrayList2.add(RouteFragment.this.getPoint(it2.next()));
                                    }
                                    arrayList2.add(RouteFragment.this.getPoint(RouteFragment.this.viewModel.geteLocation()));
                                    RouteFragment.this.getRoute(new LatLng(RouteFragment.this.f34app.getCurrentLocation().getLatitude(), RouteFragment.this.f34app.getCurrentLocation().getLongitude()), arrayList2);
                                } else {
                                    Toast.makeText(RouteFragment.this.getActivity(), R.string.current_location_not_available, 0).show();
                                }
                            } catch (Exception e) {
                                Timber.e(e);
                                Log.e("RouteFragment", e.toString());
                                Toast.makeText(RouteFragment.this.getActivity(), R.string.something_went_wrong, 0).show();
                            }
                            RouteFragment.this.onFragmentBackPressed();
                        }

                        @Override // com.mappls.sdk.plugins.places.autocomplete.ui.PlaceSelectionListener
                        public void onCancel() {
                            RouteFragment.this.onFragmentBackPressed();
                        }
                    });
                    ((HomeActivity) RouteFragment.this.getActivity()).addFragment(placeAutocompleteFragmentNewInstance, true);
                }
            }
        });
        if (getActivity() != null && ((HomeActivity) getActivity()).getMapView() != null) {
            ((HomeActivity) getActivity()).getMapView().getMapAsync(this);
        }
        if (getArguments() != null) {
            if (getArguments().containsKey(ARG_E_LOCATION)) {
                if (this.viewModel.geteLocations() == null) {
                    this.viewModel.seteLocations(new ArrayList());
                }
                this.viewModel.seteLocation((ELocation) new Gson().fromJson(getArguments().getString(ARG_E_LOCATION), ELocation.class));
            }
            this.viewModel.setFromLocation(getArguments().getString(ARG_E_FROM_LOCATION));
        }
        if (GlobalVar.waypoints != null && !GlobalVar.waypoints.isEmpty()) {
            this.viewModel.seteLocations(new ArrayList(GlobalVar.waypoints));
        }
        if (this.viewModel.geteLocations() == null) {
            this.viewModel.seteLocations(new ArrayList());
        }
        lambda$setRoute$2();
        this.moveToNavigationFragment.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0(view2);
            }
        });
        this.textFrom.setText(this.viewModel.getFromLocation());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.viewModel.geteLocations());
        if (this.viewModel.geteLocation() != null) {
            arrayList.add(this.viewModel.geteLocation());
        }
        this.addRouteAdapter.updateList(arrayList);
        this.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        startNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setRoute, reason: merged with bridge method [inline-methods] */
    public void lambda$setRoute$2() {
        try {
            if (this.viewModel.getTrip() != null) {
                this.f34app.setTrip(this.viewModel.getTrip());
                this.viewModel.setSelectedIndex(0);
                update();
                addPolyLine(this.viewModel.getTrip());
                if (MirroringGlobarVar.isWifiConnected && getActivity() != null) {
                    beginNavigationMirroring();
                }
                hideStartCancelChrome();
                attemptAutoStartGuidance(0);
                return;
            }
            try {
                if (this.f34app.getCurrentLocation() != null && this.viewModel.geteLocation() != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (this.viewModel.geteLocations() != null) {
                        Iterator<ELocation> it2 = this.viewModel.geteLocations().iterator();
                        while (it2.hasNext()) {
                            arrayList.add(getPoint(it2.next()));
                        }
                    }
                    arrayList.add(getPoint(this.viewModel.geteLocation()));
                    getRoute(new LatLng(this.f34app.getCurrentLocation().getLatitude(), this.f34app.getCurrentLocation().getLongitude()), arrayList);
                    return;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.RouteFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setRoute$2();
                    }
                }, 500L);
            } catch (Exception e) {
                Timber.e(e);
                Log.e("RouteFragment", e.toString());
                Toast.makeText(getActivity(), R.string.something_went_wrong, 0).show();
                onFragmentBackPressed();
            }
        } catch (Exception e2) {
            Log.e("RouteFragment", e2.toString());
            Timber.e(e2);
        }
    }

    private void initView(View view) {
        this.textViewTime = (TextView) view.findViewById(R.id.text_view_time);
        this.textViewDistance = (TextView) view.findViewById(R.id.text_view_distance_header);
        this.textFrom = (TextView) view.findViewById(R.id.text_view_from);
        this.moveToNavigationFragment = (LinearLayout) view.findViewById(R.id.linear_layout_navigation);
        this.backImageView = (ImageView) view.findViewById(R.id.image_view_back);
        this.recyclerViewTo = (RecyclerView) view.findViewById(R.id.recycler_view_path);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout_navigation_cancle);
        this.cancleBtn = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$3(view2);
            }
        });
        hideStartCancelChrome();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(View view) {
        getActivity().finish();
        endMirroring();
    }

    public void endMirroring() {
        if (getContext() == null) {
            return;
        }
        MirroringPolicy.stopMirroringAfterNavigation(requireContext(), "RouteFragment.endMirroring");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (getActivity() == null) {
            return;
        }
        try {
            getActivity().runOnUiThread(new Runnable() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    NavigationApplication navigationApplication = RouteFragment.this.getNavigationApplication();
                    RouteFragment.this.textViewDistance.setText(String.format("%s", NavigationFormatter.getFormattedDistance(RouteFragment.this.viewModel.getTrip().routes().get(RouteFragment.this.viewModel.getSelectedIndex()).distance().floatValue(), navigationApplication)));
                    RouteFragment.this.textViewTime.setText(String.format("%s ", NavigationFormatter.getFormattedDuration(RouteFragment.this.viewModel.getTrip().routes().get(RouteFragment.this.viewModel.getSelectedIndex()).duration().intValue(), navigationApplication)));
                }
            });
        } catch (Exception e) {
            Log.e("RoutFragment", e.toString());
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStartCancelChrome() {
        LinearLayout linearLayout = this.moveToNavigationFragment;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.moveToNavigationFragment.bringToFront();
        }
        LinearLayout linearLayout2 = this.cancleBtn;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            this.cancleBtn.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideStartCancelChrome() {
        LinearLayout linearLayout = this.moveToNavigationFragment;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.cancleBtn;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private void cancelPendingAutoStart() {
        Runnable runnable = this.pendingAutoStartRetry;
        if (runnable != null) {
            this.autoStartHandler.removeCallbacks(runnable);
            this.pendingAutoStartRetry = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptAutoStartGuidance(final int i) {
        if (!isAdded() || getActivity() == null || this.handedOffToGuidance || MapplsNavigationHelper.getInstance().isNavigating()) {
            return;
        }
        ensureUserLocationSeeded();
        if (((HomeActivity) getActivity()).getUserLocation() == null) {
            Log.w("RouteFrg", "auto-start deferred — waiting for GPS attempt=" + i);
            if (i < 5) {
                cancelPendingAutoStart();
                Runnable runnable = new Runnable() { // from class: com.bajajconnect.navigate.fragment.RouteFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$attemptAutoStartGuidance$4(i);
                    }
                };
                this.pendingAutoStartRetry = runnable;
                this.autoStartHandler.postDelayed(runnable, 1000L);
                return;
            }
            showStartCancelChrome();
            Toast.makeText(requireContext(), "Waiting for GPS. Tap Start when ready.", 0).show();
            return;
        }
        startNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attemptAutoStartGuidance$4(int i) {
        attemptAutoStartGuidance(i + 1);
    }

    private void ensureUserLocationSeeded() {
        NavApplication navApplication;
        if (getActivity() == null || (navApplication = this.f34app) == null) {
            return;
        }
        if (navApplication.getCurrentLocation() == null || this.f34app.getCurrentLocation().getLatitude() <= 0.0d) {
            try {
                if (GlobalVar.lat != null && GlobalVar.lng != null && GlobalVar.lat.doubleValue() > 0.0d && GlobalVar.lng.doubleValue() != 0.0d) {
                    Location location = new Location("seed");
                    location.setLatitude(GlobalVar.lat.doubleValue());
                    location.setLongitude(GlobalVar.lng.doubleValue());
                    location.setAccuracy(50.0f);
                    this.f34app.setCurrentLocation(location);
                    Log.i("RouteFrg", "seeded location from GlobalVar");
                    return;
                }
            } catch (Exception e) {
                Log.w("RouteFrg", "seed GlobalVar location failed", e);
            }
            try {
                LocationManager locationManager = (LocationManager) requireContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
                if (locationManager == null) {
                    return;
                }
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    lastKnownLocation = locationManager.getLastKnownLocation("network");
                }
                if (lastKnownLocation == null || lastKnownLocation.getLatitude() <= 0.0d) {
                    return;
                }
                this.f34app.setCurrentLocation(lastKnownLocation);
                Log.i("RouteFrg", "seeded location from LocationManager");
            } catch (Exception e2) {
                Log.w("RouteFrg", "seed LocationManager failed", e2);
            }
        }
    }

    public void startNavigation() {
        if (getActivity() == null) {
            return;
        }
        if (this.handedOffToGuidance || this.startNavigationInFlight) {
            Log.i("RouteFrg", "startNavigation skipped — handedOff=" + this.handedOffToGuidance + " inFlight=" + this.startNavigationInFlight);
            return;
        }
        ensureUserLocationSeeded();
        if (((HomeActivity) getActivity()).getUserLocation() == null) {
            Log.e("Rotefragment", "location is null");
            showStartCancelChrome();
            Toast.makeText(requireContext(), "Waiting for GPS. Try Start again.", 0).show();
        } else {
            Log.e("RouteFrg", "is nav running " + MapplsNavigationHelper.getInstance().isNavigating());
            this.startNavigationInFlight = true;
            new LongOperation().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationApplication getNavigationApplication() {
        NavigationApplication navigationApplicationNavigationContext = NavApplication.navigationContext();
        if (navigationApplicationNavigationContext != null) {
            return navigationApplicationNavigationContext;
        }
        if (getActivity() != null) {
            return (NavigationApplication) getActivity().getApplication();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        cancelPendingAutoStart();
        try {
            unregisterRecieer();
        } catch (Exception unused) {
        }
        try {
            if (getActivity() != null) {
                ((HomeActivity) getActivity()).clearPOIs();
            }
        } catch (Exception unused2) {
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress() {
        try {
            if (getActivity() == null) {
                return;
            }
            ((HomeActivity) getActivity()).showProgress();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        try {
            if (getActivity() == null) {
                return;
            }
            ((HomeActivity) getActivity()).hideProgress();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public void addPolyLine(DirectionsResponse directionsResponse) {
        if (getActivity() == null || this.mapboxMap == null || directionsResponse == null || directionsResponse.routes().get(0).geometry() == null) {
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
            this.directionPolylinePlugin.setOnNewRouteSelectedListener(new DirectionPolylinePlugin.OnNewRouteSelectedListener() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.3
                @Override // com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.OnNewRouteSelectedListener
                public void onNewRouteSelected(int i2, DirectionsRoute directionsRoute) {
                    RouteFragment.this.viewModel.setSelectedIndex(i2);
                    RouteFragment.this.update();
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
            this.mapboxMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(((LatLng) arrayList.get(0)).getLatitude(), ((LatLng) arrayList.get(0)).getLongitude())));
            return;
        }
        try {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.includes(arrayList);
            this.mapboxMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20, 430, 20, 400), 300);
        } catch (Exception e) {
            e.printStackTrace();
            this.mapboxMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(((LatLng) arrayList.get(0)).getLatitude(), ((LatLng) arrayList.get(0)).getLongitude())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRoute(LatLng latLng, ArrayList<String> arrayList) {
        if (getActivity() == null) {
            return;
        }
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.removeAllData();
        }
        if (arrayList == null || arrayList.size() < 1) {
            return;
        }
        Point pointFromLngLat = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
        MapplsDirections.Builder builderOverview = MapplsDirections.builder().origin(pointFromLngLat).destination(arrayList.get(arrayList.size() - 1)).annotations(DirectionsCriteria.ANNOTATION_NODES, "duration").profile("biking").resource(DirectionsCriteria.RESOURCE_ROUTE).steps(true).alternatives(true).routeRefresh(true).deviceId(Settings.Secure.getString(getActivity().getContentResolver(), "android_id")).overview("full");
        if (arrayList.size() >= 2) {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                builderOverview.addWaypoint(arrayList.get(i));
            }
        }
        showProgress();
        MapplsDirectionManager.newInstance(builderOverview.build()).call(new OnResponseCallback<DirectionsResponse>() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.4
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(DirectionsResponse directionsResponse) {
                RouteFragment.this.hideProgress();
                if (directionsResponse == null) {
                    Log.e("RouteFrg", "Eror in success");
                    RouteFragment.this.showErrorMessage(R.string.something_went_wrong);
                    RouteFragment.this.onFragmentBackPressed();
                    return;
                }
                RouteFragment.this.viewModel.setTrip(directionsResponse);
                RouteFragment.this.f34app.setTrip(RouteFragment.this.viewModel.getTrip());
                RouteFragment.this.viewModel.setSelectedIndex(0);
                RouteFragment.this.update();
                RouteFragment routeFragment = RouteFragment.this;
                routeFragment.addPolyLine(routeFragment.viewModel.getTrip());
                if (MirroringGlobarVar.isWifiConnected && RouteFragment.this.getActivity() != null) {
                    RouteFragment.this.beginNavigationMirroring();
                }
                GlobalVar.isIsTakeMeHomeNavStarting = false;
                Log.i("RouteFrg", "route OK — auto-start Mappls guidance takeMeHome=" + RouteFragment.this.takeMeHome);
                RouteFragment.this.hideStartCancelChrome();
                RouteFragment.this.attemptAutoStartGuidance(0);
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i2, String str) {
                Log.e("RouteFragment", "errorCode " + i2 + "msg =" + str);
                GlobalVar.isIsTakeMeHomeNavStarting = false;
                Log.e("RouteFrg", "Eror in error");
                if (i2 != 0) {
                    if (i2 == 401) {
                        RouteFragment.this.showErrorMessage(R.string.limit_expired);
                    } else {
                        RouteFragment.this.showErrorMessage(R.string.something_went_wrong);
                    }
                }
                RouteFragment.this.hideProgress();
                HomeActivity homeActivity = (HomeActivity) RouteFragment.this.getActivity();
                if (homeActivity != null) {
                    homeActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorMessage(int i) {
        try {
            if (getActivity() != null) {
                Toast.makeText(getActivity(), i, 0).show();
            }
        } catch (Resources.NotFoundException e) {
            Timber.e(e);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 280);
        if (getActivity() == null) {
            return;
        }
        try {
            this.mapboxMap = mapplsMap;
            mapplsMap.clear();
            this.directionPolylinePlugin = ((HomeActivity) getActivity()).getDirectionPolylinePlugin();
            if (this.viewModel.getTrip() != null) {
                addPolyLine(this.viewModel.getTrip());
            }
            ELocation eLocation = this.f34app.getELocation();
            if (eLocation != null) {
                if (eLocation.mapplsPin != null) {
                    mapplsMap.addMarker(new MarkerOptions().mapplsPin(eLocation.mapplsPin));
                } else if (eLocation.latitude != null && eLocation.longitude != null) {
                    mapplsMap.addMarker(new MarkerOptions().position(new LatLng(eLocation.latitude.doubleValue(), eLocation.longitude.doubleValue())));
                }
            }
            if (GlobalVar.waypoints == null || GlobalVar.waypoints.isEmpty()) {
                return;
            }
            for (int i = 0; i < GlobalVar.waypoints.size(); i++) {
                mapplsMap.addMarker(new MarkerOptions().mapplsPin(GlobalVar.waypoints.get(i).mapplsPin));
            }
        } catch (Exception e) {
            Log.e("RouteFragment", e.toString());
            Timber.e(e);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        GlobalVar.isIsTakeMeHomeNavStarting = false;
    }

    public void onFragmentBackPressed() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.handedOffToGuidance || MapplsNavigationHelper.getInstance().isNavigating() || this.mapboxMap == null || this.viewModel.getTrip() == null) {
            return;
        }
        lambda$setRoute$2();
        if (this.f34app.getELocation() != null && this.f34app.getELocation().mapplsPin != null) {
            this.mapboxMap.addMarker(new MarkerOptions().mapplsPin(this.f34app.getELocation().mapplsPin));
        } else if (this.f34app.getELocation() != null) {
            this.mapboxMap.addMarker(new MarkerOptions().position(new LatLng(this.f34app.getELocation().latitude.doubleValue(), this.f34app.getELocation().longitude.doubleValue())));
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
            ArrayList arrayList;
            try {
                NavLocation userLocation = ((HomeActivity) RouteFragment.this.requireActivity()).getUserLocation();
                LatLng latLng = userLocation != null ? new LatLng(userLocation.getLatitude(), userLocation.getLongitude()) : null;
                NavLocation navLocation = new NavLocation("navigation");
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (RouteLeg routeLeg : RouteFragment.this.f34app.getTrip().routes().get(0).legs()) {
                    if (routeLeg != null && routeLeg.steps() != null && routeLeg.steps().size() > 0) {
                        for (LegStep legStep : routeLeg.steps()) {
                            arrayList3.add(legStep.maneuver().location());
                            arrayList4.add(new LatLng(legStep.maneuver().location().latitude(), legStep.maneuver().location().longitude()));
                            NavLocation navLocation2 = new NavLocation("navigation");
                            navLocation2.setLongitude(legStep.maneuver().location().longitude());
                            navLocation2.setLatitude(legStep.maneuver().location().latitude());
                            arrayList2.add(navLocation2);
                            navLocation = navLocation;
                        }
                    }
                    navLocation = navLocation;
                }
                NavLocation navLocation3 = navLocation;
                Point pointLocation = RouteFragment.this.f34app.getTrip().routes().get(0).legs().get(0).steps().get(0).maneuver().location();
                LatLng latLng2 = new LatLng(pointLocation.latitude(), pointLocation.longitude());
                navLocation3.setLongitude(latLng2.getLongitude());
                navLocation3.setLatitude(latLng2.getLatitude());
                RouteFragment.this.f34app.setStartNavigationLocation(navLocation3);
                if (latLng == null) {
                    return new NavigationResponse(ErrorType.UNKNOWN_ERROR, null);
                }
                if (RouteFragment.this.viewModel.geteLocations() != null && RouteFragment.this.viewModel.geteLocations().size() > 0) {
                    arrayList = new ArrayList();
                    Iterator<ELocation> it2 = RouteFragment.this.viewModel.geteLocations().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(RouteFragment.this.getWayPoints(it2.next()));
                    }
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList5 = arrayList;
                NavigationVariables.selectedIndex = RouteFragment.this.viewModel.getSelectedIndex();
                NavigationVariables.currentLocation = latLng;
                RouteFragment routeFragment = RouteFragment.this;
                NavigationVariables.wayPoint = routeFragment.getNavigationGeoPoint(routeFragment.viewModel.geteLocation());
                NavigationVariables.wayPoints = arrayList5;
                MapplsNavigationHelper mapplsNavigationHelper = MapplsNavigationHelper.getInstance();
                DirectionsResponse trip = RouteFragment.this.f34app.getTrip();
                int selectedIndex = RouteFragment.this.viewModel.getSelectedIndex();
                RouteFragment routeFragment2 = RouteFragment.this;
                return mapplsNavigationHelper.startNavigation(trip, selectedIndex, latLng, routeFragment2.getNavigationGeoPoint(routeFragment2.viewModel.geteLocation()), (List<WayPoint>) arrayList5, false);
            } catch (Exception e) {
                Timber.e(e);
                Log.e("RouteFragment", e.toString());
                return new NavigationResponse(ErrorType.UNKNOWN_ERROR, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(NavigationResponse navigationResponse) {
            if (RouteFragment.this.getActivity() == null) {
                return;
            }
            RouteFragment.this.hideProgress();
            if (navigationResponse != null && navigationResponse.getError() != null) {
                Timber.d(navigationResponse.toString(), new Object[0]);
                Log.e("RouteFragment", "error in starting nav " + navigationResponse.getError().errorMessage);
                RouteFragment.this.startNavigationInFlight = false;
                if (navigationResponse.getError().errorCode == 409) {
                    RouteFragment.this.deleteNavigationSession();
                    return;
                }
                if (MapplsNavigationHelper.getInstance().isNavigating()) {
                    RouteFragment.this.hideStartCancelChrome();
                    RouteFragment.this.openNavigationFragmentOnce();
                    return;
                }
                RouteFragment.this.showStartCancelChrome();
                Toast.makeText(RouteFragment.this.requireContext(), navigationResponse.getError().errorMessage + "", 0).show();
                return;
            }
            RouteFragment.this.hideStartCancelChrome();
            RouteFragment.this.openNavigationFragmentOnce();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            RouteFragment.this.showProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openNavigationFragmentOnce() {
        if (getActivity() == null) {
            return;
        }
        if (this.handedOffToGuidance && getActivity().getSupportFragmentManager().findFragmentByTag("NavigationFragment") != null) {
            Log.i("RouteFrg", "NavigationFragment already showing — skip replace");
            this.startNavigationInFlight = false;
        } else {
            this.handedOffToGuidance = true;
            this.startNavigationInFlight = false;
            cancelPendingAutoStart();
            ((HomeActivity) getActivity()).navigateTo(new NavigationFragment(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteNavigationSession() {
        StringBuilder sb = new StringBuilder("deleteNavigationSession vinSet=");
        sb.append((GlobalVar.vehcileVin == null || GlobalVar.vehcileVin.isEmpty()) ? false : true);
        Log.d("RouteFragment", sb.toString());
        MapplsNavigationHelper.getInstance().deleteSession(GlobalVar.vehcileVin, new IStopSession() { // from class: com.bajajconnect.navigate.fragment.RouteFragment.5
            @Override // com.mappls.sdk.navigation.iface.IStopSession
            public void onSuccess() {
                RouteFragment.this.startNavigation();
            }

            @Override // com.mappls.sdk.navigation.iface.IStopSession
            public void onFailure() {
                if (RouteFragment.this.getContext() != null) {
                    Toast.makeText(RouteFragment.this.getContext(), "Something went wrong.Try again", 0).show();
                }
            }
        });
    }

    public void registerBroadcastReciever() {
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.mMessageReceiver, new IntentFilter(MirroringGlobarVar.ACTION_NAV_TO_NAVIGATION));
    }

    public void unregisterRecieer() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.mMessageReceiver);
    }
}
