package com.bajajconnect.navigate.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.navigate.RecenterButton;
import com.bajajconnect.navigate.adapter.NavigationPagerAdapter;
import com.bajajconnect.navigate.maps.plugins.BearingIconPlugin;
import com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin;
import com.bajajconnect.navigate.maps.plugins.MapEventsPlugin;
import com.bajajconnect.navigate.maps.plugins.RouteArrowPlugin;
import com.bajajconnect.navigate.model.Stop;
import com.bajajconnect.navigate.utils.NavigationLocationEngine;
import com.bajajconnect.utils.NavChromeInsets;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.bajajconnect.wifi.MirroringPolicy;
import com.bajajconnect.wifi.Screens;
import com.drew.metadata.avi.AviDirectory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.perf.util.Constants;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.camera.CameraUpdateFactory;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.location.LocationComponent;
import com.mappls.sdk.maps.location.LocationComponentConstants;
import com.mappls.sdk.maps.location.engine.LocationEngineProvider;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import com.mappls.sdk.maps.utils.MathUtils;
import com.mappls.sdk.navigation.AlternateRoute;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.NavigationFormatter;
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
import com.mappls.sdk.navigation.iface.OnSpeedLimitListener;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.util.GPSInfo;
import com.mappls.sdk.plugin.directions.view.ManeuverView;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteClasses;
import com.mappls.sdk.services.api.directions.models.RouteLeg;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationFragment extends Fragment implements View.OnClickListener, MapplsMap.OnMoveListener, LocationChangedListener, INavigationListener, OnMapReadyCallback {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f33app;
    private BearingIconPlugin bearingIconPlugin;
    private ImageView bottomCloseButton;
    private NavigationCamera camera;
    private LinearLayout cardview;
    private DirectionPolylinePlugin directionPolylinePlugin;
    private AnimationSet fadeInSlowOut;
    private GPSInfo gpsInfo;
    private ImageView ivRouteOverview;
    private ImageView junctionViewImageView;
    private LocationComponent locationPlugin;
    private BroadcastReceiver mBroadcastReceiver;
    private RecenterButton mFollowMeButton;
    private MapEventsPlugin mapEventsPlugin;
    private MapplsMap mapplsMap;
    private Bitmap navEventBitmap;
    private TextView navEventDistance;
    private ImageView navEventImage;
    private TextView navEventLbl;
    private ViewPager navigationStripViewPager;
    private View nextInstructionContainer;
    private ImageView nextInstructionImageView;
    private TextView otherInfoTextView;
    private RouteArrowPlugin routeArrowPlugin;
    private FloatingActionButton settingFloatingActionButton;
    private TextView soundChipText;
    private FloatingActionButton soundFab;
    private TextView tvDistanceLeft;
    private TextView tvDurationLeft;
    private TextView tvEta;
    private TextView tvRouteClassDetail;
    private TextView warningTextView;
    String lastImageSetFor = null;
    Handler gpsHandler = new Handler();
    private boolean isItSaveForFragmentTransaction = true;
    private boolean mFragmentTransactionSave = true;
    private int currentPageLocation = 1;
    Runnable gpsRunnable = new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (NavigationFragment.this.getActivity() == null) {
                return;
            }
            if (NavigationFragment.this.gpsInfo != null && !NavigationFragment.this.gpsInfo.fixed) {
                if (NavigationFragment.this.warningTextView != null) {
                    NavigationFragment.this.warningTextView.setBackgroundColor(NavigationFragment.this.getResources().getColor(R.color.red));
                }
            } else {
                if (NavigationFragment.this.gpsInfo != null && NavigationFragment.this.gpsInfo.usedSatellites < 3) {
                    if (NavigationFragment.this.warningTextView != null) {
                        NavigationFragment.this.warningTextView.setBackgroundColor(NavigationFragment.this.getResources().getColor(R.color.common_gray));
                        return;
                    }
                    return;
                }
                NavigationFragment.this.dismissSnackBar();
            }
        }
    };
    private boolean isNavEventVisible = false;
    private ExecutorService networkExecutor = Executors.newSingleThreadExecutor();
    private BroadcastReceiver mMessageReceiverTbt = new AnonymousClass10();

    /* JADX INFO: Access modifiers changed from: private */
    interface OnImageAdded {
        void getBitmap(Bitmap bitmap);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onEvent(NavEvent navEvent) {
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBroadcastReceiver = new MyLocalBroadcastReceiver();
        this.f33app = getMyApplication();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_navigation, viewGroup, false);
    }

    public void checkForWifi() {
        if (!MirroringGlobarVar.isWifiConnected || NavApplication.streamingHandler == null) {
            return;
        }
        if (NavApplication.streamingHandler.udpServerService == null) {
            try {
                NavApplication.streamingHandler.initUdpServer();
            } catch (Exception e) {
                Log.w("NavigationFrg", "initUdpServer on SoftAP resume failed", e);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.checkForWifi();
                }
            }, 150L);
            return;
        }
        if (!NavApplication.streamingHandler.onUdpReady()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.checkForWifi();
                }
            }, 150L);
            return;
        }
        try {
            NavApplication.streamingHandler.udpServerService.stopScreenCapture();
            MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
            NavApplication.customProjection.startActivity();
            NavApplication.streamingHandler.udpServerService.onScreenChange();
        } catch (Exception e2) {
            Log.e("NavigationFrg", "checkForWifi mirror resume failed", e2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViews(view);
        MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
        checkForWifi();
        registerBroadcastReciever();
        ImageView imageView = (ImageView) view.findViewById(R.id.bottom_close_btn);
        this.bottomCloseButton = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NavigationFragment.this.locationModeNavigation(false);
                NavigationFragment.this.getActivity().onBackPressed();
            }
        });
        if (getActivity() instanceof HomeActivity) {
            ((HomeActivity) getActivity()).getMapView().getMapAsync(this);
        }
        MapplsNavigationHelper.getInstance().addNavigationListener(this);
        onRouteProgress(MapplsNavigationHelper.getInstance().getAdviseInfo());
        MapplsNavigationHelper.getInstance().setOnSpeedLimitListener(new OnSpeedLimitListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.3
            @Override // com.mappls.sdk.navigation.iface.OnSpeedLimitListener
            public void onSpeedChanged(double d, boolean z) {
                if (NavigationFragment.this.settingFloatingActionButton != null) {
                    NavigationFragment.this.settingFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(z ? SupportMenu.CATEGORY_MASK : -16711936));
                }
            }
        });
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventLoadedListener(new NavigationEventLoadedListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.4
            @Override // com.mappls.sdk.navigation.iface.NavigationEventLoadedListener
            public void onNavigationEventsLoaded(List<ReportDetails> list) {
                if (MapplsNavigationHelper.getInstance().getEvents() == null || MapplsNavigationHelper.getInstance().getEvents().size() <= 0 || NavigationFragment.this.mapEventsPlugin == null) {
                    return;
                }
                NavigationFragment.this.mapEventsPlugin.setNavigationEvents(MapplsNavigationHelper.getInstance().getEvents());
            }
        });
        MapplsNavigationHelper.getInstance().setJunctionVisualPromptBefore(200);
        MapplsNavigationHelper.getInstance().setJunctionViewsLoadedListener(new JunctionViewsLoadedListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.5
            @Override // com.mappls.sdk.navigation.iface.JunctionViewsLoadedListener
            public void onJunctionViewsLoaded(List<Junction> list) {
            }
        });
        MapplsNavigationHelper.getInstance().setJunctionInfoChangedListener(new JunctionInfoChangedListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.6
            @Override // com.mappls.sdk.navigation.iface.JunctionInfoChangedListener
            public void junctionInfoChanged(Junction junction) {
                if (junction == null) {
                    Timber.tag("JunctionView").d("Junction point is null", new Object[0]);
                    NavigationFragment.this.lastImageSetFor = null;
                    NavigationFragment.this.junctionViewImageView.setVisibility(4);
                } else {
                    Timber.tag("JunctionView").d("Junction View approaching %s", Double.valueOf(junction.getLeftDistance()));
                    if (junction.bitmap != null) {
                        NavigationFragment.this.junctionViewImageView.setImageBitmap(junction.bitmap);
                    }
                    NavigationFragment.this.junctionViewImageView.setVisibility(0);
                }
            }
        });
        MapplsNavigationHelper.getInstance().setEnableInstructionsFromAPI(true);
        MapplsNavigationHelper.getInstance().setNavigationEventListener(new AnonymousClass7());
    }

    /* JADX INFO: renamed from: com.bajajconnect.navigate.fragment.NavigationFragment$7, reason: invalid class name */
    class AnonymousClass7 implements NavigationEventListener {
        AnonymousClass7() {
        }

        @Override // com.mappls.sdk.navigation.iface.NavigationEventListener
        public void onNavigationEvent(NavEvent navEvent) {
            if (navEvent != null) {
                Log.e("NavigationFragment", "Navigation Event approaching %s in %f" + navEvent.getName() + navEvent.getDistanceLeft());
                Timber.d("Navigation Event approaching %s in %f", navEvent.getName(), Double.valueOf(navEvent.getDistanceLeft()));
                if (!NavigationFragment.this.isNavEventVisible) {
                    NavigationFragment.this.isNavEventVisible = true;
                }
                NavigationFragment.this.cardview.setVisibility(0);
                int distanceLeft = (int) navEvent.getDistanceLeft();
                NavigationFragment.this.navEventDistance.setText(distanceLeft + " m");
                NavigationFragment.this.navEventLbl.setText(navEvent.getName());
                if (NavigationFragment.this.navEventBitmap == null) {
                    NavigationFragment.this.getBitmap(navEvent.getReportDetails().getReportIcon("48px"), new OnImageAdded() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.7.1
                        @Override // com.bajajconnect.navigate.fragment.NavigationFragment.OnImageAdded
                        public void getBitmap(final Bitmap bitmap) {
                            Log.e("NavigationFragment", "icon downloaded");
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.7.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Log.e("NavigationFragment", "icon downloaded set image");
                                    NavigationFragment.this.navEventBitmap = bitmap;
                                    NavigationFragment.this.navEventImage.setImageBitmap(bitmap);
                                }
                            });
                        }
                    });
                    return;
                } else {
                    NavigationFragment.this.navEventImage.setImageBitmap(NavigationFragment.this.navEventBitmap);
                    return;
                }
            }
            if (NavigationFragment.this.isNavEventVisible) {
                NavigationFragment.this.isNavEventVisible = false;
                NavigationFragment.this.navEventBitmap = null;
                NavigationFragment.this.navEventImage.setImageBitmap(null);
                NavigationFragment.this.cardview.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBitmap(final String str, final OnImageAdded onImageAdded) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NavigationFragment.lambda$getBitmap$0(str, onImageAdded);
            }
        });
    }

    static /* synthetic */ void lambda$getBitmap$0(String str, OnImageAdded onImageAdded) {
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

    private void openNavigationSummaryDialog() {
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("RouteSummaryDialogFragment") == null) {
            new RouteSummaryDialogFragment().show(supportFragmentManager, "RouteSummaryDialogFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openClassesDetailDialog() {
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag("ClassesDetailDialogFragment") == null) {
            new ClassesDetailDialogFragment().show(supportFragmentManager, "ClassesDetailDialogFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPolyLine() {
        if (getActivity() == null) {
            return;
        }
        try {
            if (MapplsNavigationHelper.getInstance().getCurrentRoute() == null) {
                return;
            }
            new ArrayList();
            String strGeometry = MapplsNavigationHelper.getInstance().getCurrentRoute().geometry();
            Timber.e(MapplsNavigationHelper.getInstance().getCurrentRoute().toJson(), new Object[0]);
            if (this.directionPolylinePlugin != null) {
                LatLng latLng = (this.f33app.getELocation() == null || this.f33app.getELocation().latitude == null || this.f33app.getELocation().longitude == null) ? null : new LatLng(this.f33app.getELocation().latitude.doubleValue(), this.f33app.getELocation().longitude.doubleValue());
                ArrayList arrayList = new ArrayList();
                arrayList.add(LineString.fromPolyline(strGeometry, 6));
                ArrayList arrayList2 = new ArrayList();
                if (this.f33app.getTrip() != null && this.f33app.getTrip().waypoints() != null) {
                    for (int i = 0; i < this.f33app.getTrip().waypoints().size() - 1; i++) {
                        if (i != 0) {
                            Point pointLocation = this.f33app.getTrip().waypoints().get(i).location();
                            arrayList2.add(new LatLng(pointLocation.latitude(), pointLocation.longitude()));
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(MapplsNavigationHelper.getInstance().getCurrentRoute());
                this.directionPolylinePlugin.setTrips(arrayList, null, latLng, arrayList2, arrayList3);
                this.directionPolylinePlugin.setEnabled(true);
            }
        } catch (Exception e) {
            Log.w("NavigationFrg", "drawPolyLine failed", e);
        }
    }

    public void endMirroring() {
        if (getContext() == null) {
            return;
        }
        Log.e("NavFrg", "stop mirroring");
        MirroringPolicy.stopMirroringAfterNavigation(requireContext(), "NavigationFragment.endMirroring");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getActivity() == null) {
            return;
        }
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.removeAllData();
        }
        if (this.locationPlugin != null) {
            if (ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(requireContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return;
            } else {
                Log.e("NavigationFragment", "set location component disable");
            }
        }
        this.camera = null;
        if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            locationModeNavigation(false);
        }
        MapplsNavigationHelper.getInstance().removeNavigationListener(this);
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.removeOnMoveListener(this);
            this.mapplsMap.removeAnnotations();
        }
        super.onDestroyView();
    }

    public void onBackPressed(boolean z) {
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStop();
        }
        try {
            MapplsNavigationHelper.getInstance().stopNavigation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.locationPlugin.setRenderMode(18);
            NavigationCamera navigationCamera = this.camera;
            if (navigationCamera != null) {
                navigationCamera.updateCameraTrackingMode(2);
            }
            if (ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && ActivityCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                locationModeNavigation(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            MapplsNavigationHelper.getInstance().removeNavigationListener(this);
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap != null) {
                mapplsMap.removeOnMoveListener(this);
                this.mapplsMap.removeAnnotations();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            unregisterRecieer();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (NavApplication.customProjection == null || z) {
                return;
            }
            NavApplication.customProjection.navBackToRouteScreen();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
        if (directionPolylinePlugin != null) {
            directionPolylinePlugin.setEnabled(true);
        }
        super.onDetach();
    }

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NavigationApplication getNavigationApplication() {
        NavigationApplication navigationApplication = NavApplication.navigationApplication();
        if (navigationApplication != null) {
            return navigationApplication;
        }
        if (getActivity() != null) {
            return (NavigationApplication) getActivity().getApplication();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (getActivity() == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.follow_button) {
            this.nextInstructionContainer.setVisibility(0);
            setNavigationPadding(true);
            followMe(true);
            return;
        }
        if (id == R.id.sound_btn) {
            toggleMute();
            return;
        }
        if (id == R.id.reset_bounds_button) {
            NavigationCamera navigationCamera = this.camera;
            if (navigationCamera != null) {
                navigationCamera.updateCameraTrackingMode(2);
            }
            List<NavigationStep> routeDirections = getNavigationApplication().getRouteDirections();
            ArrayList arrayList = new ArrayList();
            Iterator<NavigationStep> it2 = routeDirections.iterator();
            while (it2.hasNext()) {
                NavLocation navLocation = it2.next().getNavLocation();
                if (navLocation != null) {
                    arrayList.add(new LatLng(navLocation.getLatitude(), navLocation.getLongitude()));
                }
            }
            if (arrayList.size() > 1) {
                this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().includes(arrayList).build(), 0));
                return;
            }
            return;
        }
        if (id != R.id.image_route_overview || getActivity() == null || MapplsNavigationHelper.getInstance().getCurrentRoute() == null) {
            return;
        }
        setNavigationPadding(false);
        NavigationCamera navigationCamera2 = this.camera;
        if (navigationCamera2 != null) {
            navigationCamera2.updateCameraTrackingMode(2);
        }
        this.mapplsMap.setCameraPosition(new CameraPosition.Builder().bearing(0.0d).tilt(0.0d).build());
        if (this.mFollowMeButton.getVisibility() != 0) {
            this.mFollowMeButton.setVisibility(0);
        }
        this.ivRouteOverview.setVisibility(8);
        ArrayList arrayList2 = new ArrayList();
        List<Point> listDecode = PolylineUtils.decode(MapplsNavigationHelper.getInstance().getCurrentRoute().geometry(), 6);
        if (listDecode == null || listDecode.size() <= 0) {
            return;
        }
        for (Point point : listDecode) {
            if (point != null) {
                arrayList2.add(new LatLng(point.latitude(), point.longitude()));
            }
        }
        if (arrayList2.size() > 1) {
            this.mapplsMap.animateCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().includes(arrayList2).build(), 20, AviDirectory.TAG_DATETIME_ORIGINAL, 20, 280), Constants.MAX_URL_LENGTH);
        }
    }

    float getLocationAngle(NavLocation navLocation) {
        try {
            List<NavLocation> path = getNavigationApplication().getCalculatedRoute().getPath();
            return (float) MathUtils.wrap(navLocation.bearingTo(path.get(path.indexOf(navLocation) + 1)), 0.0d, 360.0d);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        try {
            Timber.e("onMapReady", new Object[0]);
            if (getActivity() == null) {
                return;
            }
            this.mapplsMap = mapplsMap;
            mapplsMap.getUiSettings().setLogoMargins(0, 0, 0, 250);
            mapplsMap.getStyle(new AnonymousClass8(mapplsMap));
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    /* JADX INFO: renamed from: com.bajajconnect.navigate.fragment.NavigationFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Style.OnStyleLoaded {
        final /* synthetic */ MapplsMap val$map;

        AnonymousClass8(MapplsMap mapplsMap) {
            this.val$map = mapplsMap;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0095  */
        @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            int position;
            NavigationFragment.this.mapplsMap.removeAnnotations();
            NavigationFragment navigationFragment = NavigationFragment.this;
            navigationFragment.locationPlugin = navigationFragment.mapplsMap.getLocationComponent();
            NavigationFragment.this.locationPlugin.setRenderMode(8);
            NavigationFragment navigationFragment2 = NavigationFragment.this;
            navigationFragment2.directionPolylinePlugin = ((HomeActivity) navigationFragment2.getActivity()).getDirectionPolylinePlugin();
            NavigationFragment navigationFragment3 = NavigationFragment.this;
            navigationFragment3.bearingIconPlugin = ((HomeActivity) navigationFragment3.getActivity()).getBearingIconPlugin();
            NavigationFragment navigationFragment4 = NavigationFragment.this;
            navigationFragment4.routeArrowPlugin = ((HomeActivity) navigationFragment4.getActivity()).getRouteArrowPlugin();
            NavigationFragment navigationFragment5 = NavigationFragment.this;
            navigationFragment5.mapEventsPlugin = ((HomeActivity) navigationFragment5.getActivity()).getMapEventPlugin();
            List<NavigationStep> routeDirections = NavigationFragment.this.getNavigationApplication().getRouteDirections();
            if (routeDirections == null || routeDirections.isEmpty()) {
                Log.w("NavigationFrg", "onMapReady — route directions not ready yet");
                NavigationFragment.this.setNavigationPadding(true);
                NavigationFragment.this.initCamera();
                return;
            }
            AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
            if (adviseInfo == null) {
                position = 0;
            } else {
                position = adviseInfo.getPosition() == 0 ? adviseInfo.getPosition() : adviseInfo.getPosition() - 1;
                if (position < 0 || position >= routeDirections.size()) {
                    position = 0;
                }
            }
            LegStep legStep = (LegStep) routeDirections.get(position).getExtraInfo();
            if (NavigationFragment.this.routeArrowPlugin != null) {
                NavigationFragment.this.routeArrowPlugin.addUpcomingManeuverArrow(legStep, null);
            }
            NavigationFragment.this.directionPolylinePlugin.setOnNewRouteSelectedListener(new DirectionPolylinePlugin.OnNewRouteSelectedListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.8.1
                @Override // com.bajajconnect.navigate.maps.plugins.DirectionPolylinePlugin.OnNewRouteSelectedListener
                public void onNewRouteSelected(int i, DirectionsRoute directionsRoute) {
                    MapplsNavigationHelper.getInstance().setRouteIndex(i);
                }
            });
            if (NavigationFragment.this.bearingIconPlugin != null) {
                NavigationFragment.this.bearingIconPlugin.setBearingLayerVisibility(false);
                NavigationFragment.this.bearingIconPlugin.setBearingIcon(0.0f, null);
            }
            this.val$map.addOnMoveListener(NavigationFragment.this);
            if (NavigationFragment.this.camera != null) {
                NavigationFragment.this.camera.updateCameraTrackingMode(0);
                adviseInfo.setLocation(NavigationLocationProvider.convertLocation(NavigationFragment.this.getLocationForNavigation(), NavigationFragment.this.f33app));
                NavigationFragment.this.onRouteProgress(MapplsNavigationHelper.getInstance().getAdviseInfo());
            }
            if (NavigationFragment.this.getActivity() != null && ((HomeActivity) NavigationFragment.this.getActivity()).getMapView() != null) {
                ((HomeActivity) NavigationFragment.this.getActivity()).getMapView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$8$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$onStyleLoaded$0(view, motionEvent);
                    }
                });
            }
            if (ActivityCompat.checkSelfPermission(NavigationFragment.this.getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(NavigationFragment.this.getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                NavigationFragment.this.locationModeNavigation(true);
            }
            NavigationFragment.this.setNavigationPadding(true);
            NavigationFragment.this.drawPolyLine();
            NavigationFragment.this.initCamera();
            NavigationFragment.this.showRouteClassesDetailToast();
            style.getLayer(LocationComponentConstants.SHADOW_LAYER).setProperties(PropertyFactory.visibility("none"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onStyleLoaded$0(View view, MotionEvent motionEvent) {
            NavigationFragment.this.followMe(false);
            return view.onTouchEvent(motionEvent);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setNavigationPadding(true);
        followMe(true);
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
        Timber.e(i + "------" + str, new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.isItSaveForFragmentTransaction = true;
        if (getActivity() != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                getActivity().registerReceiver(this.mBroadcastReceiver, new IntentFilter("NAVIGATION_STOP_NAVIGATION_SERVICE_ACTION"), 4);
            } else {
                getActivity().registerReceiver(this.mBroadcastReceiver, new IntentFilter("NAVIGATION_STOP_NAVIGATION_SERVICE_ACTION"));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.isItSaveForFragmentTransaction = false;
        super.onPause();
        try {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.mBroadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean zIsNavigating = MapplsNavigationHelper.getInstance().isNavigating();
        if (getActivity() == null || !this.isItSaveForFragmentTransaction || zIsNavigating) {
            return;
        }
        getNavigationApplication().stopNavigation();
        dismissSnackBar();
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMoveListener
    public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
        this.ivRouteOverview.setVisibility(0);
        followMe(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCamera() {
        NavigationCamera navigationCamera = new NavigationCamera(this.mapplsMap);
        this.camera = navigationCamera;
        navigationCamera.start(null);
    }

    public void locationModeNavigation(boolean z) {
        try {
            MapplsMap mapplsMap = this.mapplsMap;
            if (mapplsMap == null) {
                return;
            }
            if (z) {
                getNavigationApplication().getLocationProvider().setLocationChangedListener(this);
                Location locationForNavigation = getLocationForNavigation();
                if (this.locationPlugin != null && !((HomeActivity) getActivity()).getMapView().isDestroyed()) {
                    this.locationPlugin.forceLocationUpdate(locationForNavigation);
                }
                this.mapplsMap.getLocationComponent().setLocationEngine(new NavigationLocationEngine());
                followMe(true);
                return;
            }
            mapplsMap.getLocationComponent().setLocationEngine(LocationEngineProvider.getBestLocationEngine(getActivity()));
            getNavigationApplication().getLocationProvider().setLocationChangedListener(null);
            this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().bearing(0.0d).tilt(0.0d).build()));
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.isItSaveForFragmentTransaction = false;
        super.onPause();
        try {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.mBroadcastReceiver);
            }
        } catch (Exception unused) {
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onGpsStateChange(false);
            BleFeatures.navigationCallback.onNavigationStop();
        }
        try {
            MapplsNavigationHelper.getInstance().stopNavigation();
        } catch (Exception unused2) {
        }
    }

    public Location getLocationForNavigation() {
        if (getActivity() == null) {
            return null;
        }
        Location location = new Location("gps");
        NavLocation startNavigationLocation = this.f33app.getStartNavigationLocation();
        if (startNavigationLocation != null) {
            location.setLatitude(startNavigationLocation.getLatitude());
            location.setLongitude(startNavigationLocation.getLongitude());
        }
        try {
            NavLocation firstLocation = MapplsNavigationHelper.getInstance().getFirstLocation();
            if (firstLocation.distanceTo(NavigationLocationProvider.convertLocation(location, this.f33app)) < 10.0f) {
                firstLocation.setBearing(firstLocation.bearingTo(MapplsNavigationHelper.getInstance().getSecondLocation()));
                return NavigationLocationProvider.revertLocation(firstLocation, this.f33app);
            }
            if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            LocationComponent locationComponent = this.locationPlugin;
            Location lastKnownLocation = locationComponent != null ? locationComponent.getLastKnownLocation() : null;
            return lastKnownLocation != null ? lastKnownLocation : NavigationLocationProvider.revertLocation(getNavigationApplication().getLocationProvider().getFirstTimeRunDefaultLocation(), getNavigationApplication());
        } catch (Exception e) {
            Timber.e(e);
            return NavigationLocationProvider.revertLocation(getNavigationApplication().getLocationProvider().getFirstTimeRunDefaultLocation(), getNavigationApplication());
        }
    }

    public synchronized void followMe(boolean z) {
        Location lastKnownLocation;
        if (getActivity() == null) {
            return;
        }
        int i = 0;
        if (!z) {
            if (this.mFollowMeButton.getVisibility() != 0) {
                this.mFollowMeButton.show();
            }
        } else {
            if ((ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) && (lastKnownLocation = this.locationPlugin.getLastKnownLocation()) != null) {
                this.mapplsMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(45.0d).zoom(16.0d).target(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())).build()));
            }
            if (this.mFollowMeButton.getVisibility() == 0) {
                this.mFollowMeButton.hide();
            }
            BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
            if (bearingIconPlugin != null) {
                bearingIconPlugin.setBearingLayerVisibility(false);
            }
        }
        NavigationCamera navigationCamera = this.camera;
        if (navigationCamera != null && z != navigationCamera.isTrackingEnabled()) {
            NavigationCamera navigationCamera2 = this.camera;
            if (!z) {
                i = 2;
            }
            navigationCamera2.updateCameraTrackingMode(i);
        }
    }

    private void mute() {
        setSoundChipText(getString(R.string.muted));
        showSoundChip();
        soundFabOff();
        MapplsNavigationHelper.getInstance().setMute(true);
    }

    private void unmute() {
        setSoundChipText(getString(R.string.unmuted));
        showSoundChip();
        soundFabOn();
        MapplsNavigationHelper.getInstance().setMute(false);
    }

    private void soundFabOff() {
        this.soundFab.setImageResource(R.drawable.ic_sound_off);
    }

    private void soundFabOn() {
        this.soundFab.setImageResource(R.drawable.ic_sound_on);
    }

    private void setSoundChipText(String str) {
        this.soundChipText.setText(str);
    }

    private void showSoundChip() {
        this.soundChipText.startAnimation(this.fadeInSlowOut);
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

    void showSnackBar(String str) {
        TextView textView = this.warningTextView;
        if (textView != null) {
            textView.setText(str);
            this.warningTextView.setAlpha(1.0f);
        }
    }

    void dismissSnackBar() {
        TextView textView = this.warningTextView;
        if (textView != null) {
            textView.setAlpha(0.0f);
        }
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onLocationChanged(Location location) {
        this.gpsHandler.removeCallbacksAndMessages(null);
        if (getActivity() == null || location == null || this.mapplsMap == null || !this.mFragmentTransactionSave || ((HomeActivity) getActivity()).getMapView().isDestroyed()) {
            return;
        }
        dismissSnackBar();
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onGPSConnectionChanged(boolean z) {
        if (z) {
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onGpsStateChange(true);
            }
            showSnackBar(getString(R.string.gps_connection_restored));
            dismissSnackBar();
            return;
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onGpsStateChange(false);
        }
        showSnackBar(getString(R.string.gps_connection_lost));
    }

    @Override // com.mappls.sdk.navigation.iface.LocationChangedListener
    public void onSatelliteInfoChanged(GPSInfo gPSInfo) {
        this.gpsInfo = gPSInfo;
        this.gpsHandler.postDelayed(this.gpsRunnable, 2000L);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onNavigationStarted() {
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationStart();
        }
        try {
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).onMapplsGuidanceStarted();
            }
        } catch (Exception e) {
            Log.w("NavigationFrg", "onMapplsGuidanceStarted failed", e);
        }
        Timber.e("onNavigationStarted", new Object[0]);
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onReRoutingRequested() {
        Timber.e("onReRoutingRequested", new Object[0]);
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onRerouting();
        }
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReRoutingRequested$1();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onReRoutingRequested$2();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReRoutingRequested$1() {
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
    public /* synthetic */ void lambda$onReRoutingRequested$2() {
        try {
            followMe(true);
        } catch (Exception unused) {
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
        if (getActivity() == null) {
            return;
        }
        Timber.e("onNewRoute", new Object[0]);
        getActivity().runOnUiThread(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onNewRoute$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNewRoute$3() {
        if (getActivity() == null) {
            return;
        }
        showRouteClassesDetailToast();
        setAdapter();
        this.otherInfoTextView.setVisibility(8);
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap != null) {
            mapplsMap.removeAnnotations();
        }
        Location locationForNavigation = getLocationForNavigation();
        NavLocation navLocation = new NavLocation("Router");
        if (locationForNavigation != null) {
            navLocation.setLatitude(locationForNavigation.getLatitude());
            navLocation.setLongitude(locationForNavigation.getLongitude());
        }
        List<RouteLeg> listLegs = MapplsNavigationHelper.getInstance().getCurrentRoute().legs();
        if (listLegs != null && listLegs.size() > 0 && listLegs.get(0).annotation() != null) {
            this.tvEta.setTextColor(ContextCompat.getColor(getContext(), getCongestionPercentage(listLegs.get(0).annotation().congestion(), MapplsNavigationHelper.getInstance().getNodeIndex())));
        }
        drawPolyLine();
        try {
            if (BleFeatures.navigationCallback != null) {
                BleFeatures.navigationCallback.onRouteReady();
            }
        } catch (Exception e) {
            Log.w("NavigationFrg", "onRouteReady after Mappls onNewRoute failed", e);
        }
    }

    private int getCongestionPercentage(List<String> list, int i) {
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
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onDestinationReached();
        }
        if (getContext() != null) {
            Toast.makeText(getContext(), "Reached to destination", 0).show();
        }
        if (getActivity() == null || !this.isItSaveForFragmentTransaction) {
            return;
        }
        dismissSnackBar();
    }

    @Override // com.mappls.sdk.navigation.iface.INavigationListener
    public void onRouteProgress(final AdviseInfo adviseInfo) {
        if (getActivity() == null || adviseInfo == null) {
            return;
        }
        if (BleFeatures.navigationCallback != null) {
            BleFeatures.navigationCallback.onNavigationProgress(adviseInfo, null);
        }
        try {
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).onMapplsRouteProgress(adviseInfo);
            }
        } catch (Exception unused) {
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onRouteProgress$4(adviseInfo);
            }
        });
        if (adviseInfo.isRouteBeingRecalculated() && !adviseInfo.isOnRoute()) {
            this.otherInfoTextView.setVisibility(0);
            this.nextInstructionContainer.setVisibility(8);
            return;
        }
        this.otherInfoTextView.setVisibility(8);
        if (this.navigationStripViewPager.getAdapter() == null || !(this.navigationStripViewPager.getAdapter() instanceof NavigationPagerAdapter)) {
            setAdapter();
        }
        NavigationCamera navigationCamera = this.camera;
        if (navigationCamera != null && navigationCamera.isTrackingEnabled()) {
            this.navigationStripViewPager.setCurrentItem(adviseInfo.getPosition());
        }
        if (this.navigationStripViewPager.getAdapter() != null) {
            ((NavigationPagerAdapter) this.navigationStripViewPager.getAdapter()).setDistance(adviseInfo.getDistanceToNextAdvise());
            ((NavigationPagerAdapter) this.navigationStripViewPager.getAdapter()).setSelectedPosition(adviseInfo.getPosition());
        }
        if (adviseInfo.isOnRoute()) {
            this.otherInfoTextView.setVisibility(8);
            this.nextInstructionContainer.setVisibility(0);
        }
        List<NavigationStep> routeDirections = getNavigationApplication() != null ? getNavigationApplication().getRouteDirections() : null;
        if (routeDirections == null || routeDirections.isEmpty()) {
            return;
        }
        this.nextInstructionContainer.setVisibility(0);
        if (adviseInfo.getPosition() == this.navigationStripViewPager.getCurrentItem() && routeDirections.size() - 1 > adviseInfo.getPosition()) {
            NavigationStep navigationStep = routeDirections.get(adviseInfo.getPosition() + 1);
            if (((LegStep) navigationStep.getExtraInfo()) != null) {
                this.nextInstructionImageView.setImageResource(getDrawableResId(navigationStep.getManeuverID()));
            } else {
                this.nextInstructionContainer.setVisibility(8);
            }
        } else {
            this.nextInstructionContainer.setVisibility(8);
        }
        routeDirections.get(adviseInfo.getPosition());
        this.tvEta.setTextColor(ContextCompat.getColor(getContext(), getCongestionPercentage(MapplsNavigationHelper.getInstance().getCurrentRoute().legs().get(0).annotation().congestion(), MapplsNavigationHelper.getInstance().getNodeIndex())));
        NavigationApplication navigationApplication = getNavigationApplication();
        this.tvDistanceLeft.setText(NavigationFormatter.getFormattedDistance(adviseInfo.getLeftDistance(), navigationApplication));
        this.tvDurationLeft.setText(NavigationFormatter.getFormattedDuration(adviseInfo.getLeftTime(), navigationApplication));
        this.tvEta.setText(String.format("%s ETA", adviseInfo.getEta()));
        int position = adviseInfo.getPosition() == 0 ? adviseInfo.getPosition() : adviseInfo.getPosition() - 1;
        LegStep legStep = (LegStep) routeDirections.get(position).getExtraInfo();
        int i = position + 1;
        LegStep legStep2 = routeDirections.size() > i ? (LegStep) routeDirections.get(i).getExtraInfo() : null;
        RouteArrowPlugin routeArrowPlugin = this.routeArrowPlugin;
        if (routeArrowPlugin != null) {
            routeArrowPlugin.addUpcomingManeuverArrow(legStep, legStep2);
        }
        this.currentPageLocation = adviseInfo.getPosition();
        NavigationCamera navigationCamera2 = this.camera;
        if (navigationCamera2 != null && navigationCamera2.isTrackingEnabled()) {
            this.camera.onRouteProgress(adviseInfo);
            return;
        }
        LocationComponent locationComponent = this.locationPlugin;
        if (locationComponent != null) {
            locationComponent.forceLocationUpdate(adviseInfo.getLocation());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRouteProgress$4(AdviseInfo adviseInfo) {
        try {
            DirectionPolylinePlugin directionPolylinePlugin = this.directionPolylinePlugin;
            if (directionPolylinePlugin != null) {
                directionPolylinePlugin.setCurrentLocation(adviseInfo.getLocation());
            }
        } catch (Exception unused) {
        }
    }

    int getDrawableResId(int i) {
        return getResources().getIdentifier("ic_step_" + i, "drawable", getActivity().getPackageName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void setNavigationPadding(boolean z) {
        MapplsMap mapplsMap = this.mapplsMap;
        if (mapplsMap == null) {
            return;
        }
        if (z) {
            if (getResources().getConfiguration().orientation == 1) {
                this.mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 750.0d, 0.0d, 0.0d));
                return;
            } else {
                this.mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 250.0d, 0.0d, 0.0d));
                return;
            }
        }
        mapplsMap.moveCamera(CameraUpdateFactory.paddingTo(0.0d, 0.0d, 0.0d, 0.0d));
    }

    void initViews(View view) {
        int identifier;
        View viewFindViewById;
        initAnimations();
        this.soundChipText = (TextView) view.findViewById(R.id.sound_text);
        this.soundFab = (FloatingActionButton) view.findViewById(R.id.sound_btn);
        this.tvRouteClassDetail = (TextView) view.findViewById(R.id.class_detail_text);
        this.soundFab.setOnClickListener(this);
        RecenterButton recenterButton = (RecenterButton) view.findViewById(R.id.follow_button);
        this.mFollowMeButton = recenterButton;
        recenterButton.setOnClickListener(this);
        view.findViewById(R.id.reset_bounds_button).setOnClickListener(this);
        this.warningTextView = (TextView) view.findViewById(R.id.warning_text_view);
        this.otherInfoTextView = (TextView) view.findViewById(R.id.other_info_text_view);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.navigation_strip_left_image_button);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.navigation_strip_right_image_button);
        this.navigationStripViewPager = (ViewPager) view.findViewById(R.id.navigation_info_layout_new);
        this.nextInstructionImageView = (ImageView) view.findViewById(R.id.next_instruction_image_view);
        this.nextInstructionContainer = view.findViewById(R.id.next_advise_container);
        this.tvEta = (TextView) view.findViewById(R.id.text_view_reach_eta);
        this.tvDistanceLeft = (TextView) view.findViewById(R.id.text_view_total_distance_left);
        this.tvDurationLeft = (TextView) view.findViewById(R.id.text_view_total_time_left);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_route_overview);
        this.ivRouteOverview = imageView;
        imageView.setColorFilter(getActivity().getResources().getColor(R.color.white));
        this.ivRouteOverview.setVisibility(0);
        this.ivRouteOverview.setOnClickListener(this);
        this.junctionViewImageView = (ImageView) view.findViewById(R.id.junction_view_image_view);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.settings_button);
        this.settingFloatingActionButton = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MapplsNavigationHelper.getInstance().getCurrentRoute() != null) {
                    if (MapplsNavigationHelper.getInstance().getCurrentRoute().routeClasses() != null) {
                        NavigationFragment.this.openClassesDetailDialog();
                        return;
                    } else {
                        Toast.makeText(NavigationFragment.this.requireContext(), "This route does not contain any Classes", 0).show();
                        return;
                    }
                }
                Toast.makeText(NavigationFragment.this.requireContext(), "Please wait No Route Found", 0).show();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$5(view2);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$6(view2);
            }
        });
        this.mFollowMeButton.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$7(view2);
            }
        });
        if (getActivity() != null && (identifier = getResources().getIdentifier("move_to_current_location", "id", getActivity().getPackageName())) != 0 && (viewFindViewById = getActivity().findViewById(identifier)) != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = view.findViewById(R.id.options_recycler_view_container);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(0);
            viewFindViewById2.bringToFront();
            NavChromeInsets.applyBottomChromeInsets(null, viewFindViewById2, this.soundFab, this.mFollowMeButton);
        }
        this.cardview = (LinearLayout) view.findViewById(R.id.nav_event_view);
        this.navEventDistance = (TextView) view.findViewById(R.id.navEventDistance);
        this.navEventLbl = (TextView) view.findViewById(R.id.nav_event_lbl);
        this.navEventImage = (ImageView) view.findViewById(R.id.event_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$5(View view) {
        nextPreviousButtonPressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$6(View view) {
        nextPreviousButtonPressed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$7(View view) {
        this.navigationStripViewPager.setCurrentItem(this.currentPageLocation);
        this.nextInstructionContainer.setVisibility(0);
        this.ivRouteOverview.setVisibility(0);
        setNavigationPadding(true);
        followMe(true);
    }

    void setAdapter() {
        NavigationApplication navigationApplication;
        if (getActivity() == null || (navigationApplication = getNavigationApplication()) == null) {
            return;
        }
        List<NavigationStep> routeDirections = navigationApplication.getRouteDirections();
        if (routeDirections == null || routeDirections.isEmpty() || this.navigationStripViewPager == null) {
            Log.w("NavigationFrg", "setAdapter skipped — directions not ready");
            return;
        }
        Stop stop = new Stop();
        stop.setName("END STOP");
        NavigationPagerAdapter navigationPagerAdapter = new NavigationPagerAdapter(getActivity(), routeDirections, stop);
        navigationPagerAdapter.setOnStripClickListener(new NavigationPagerAdapter.OnStripClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda10
            @Override // com.bajajconnect.navigate.adapter.NavigationPagerAdapter.OnStripClickListener
            public final void onStripClicked() {
                this.f$0.showStepsListDialog();
            }
        });
        this.navigationStripViewPager.setAdapter(navigationPagerAdapter);
        navigationPagerAdapter.setSelectedPosition(1);
        this.navigationStripViewPager.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStepsListDialog() {
        NavigationApplication navigationApplication;
        List<NavigationStep> routeDirections;
        if (getActivity() == null || !isAdded() || (navigationApplication = getNavigationApplication()) == null || (routeDirections = navigationApplication.getRouteDirections()) == null || routeDirections.isEmpty()) {
            return;
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_navigation_steps, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.steps_header_instruction);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.steps_header_distance);
        ManeuverView maneuverView = (ManeuverView) viewInflate.findViewById(R.id.steps_header_maneuver_view);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.steps_footer_distance);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.steps_footer_duration);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.steps_close_btn);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.steps_recycler_view);
        int iMax = Math.max(0, Math.min(this.currentPageLocation, routeDirections.size() - 1));
        ViewPager viewPager = this.navigationStripViewPager;
        if (viewPager != null) {
            iMax = Math.max(0, Math.min(viewPager.getCurrentItem(), routeDirections.size() - 1));
        }
        NavigationStep navigationStep = routeDirections.get(iMax);
        textView.setText(navigationStep.getShortInstruction());
        long distanceToNextAdvise = navigationStep.distance;
        ViewPager viewPager2 = this.navigationStripViewPager;
        if (viewPager2 != null && (viewPager2.getAdapter() instanceof NavigationPagerAdapter) && (iMax == this.currentPageLocation || iMax == this.navigationStripViewPager.getCurrentItem())) {
            try {
                AdviseInfo adviseInfo = MapplsNavigationHelper.getInstance().getAdviseInfo();
                if (adviseInfo != null && adviseInfo.getDistanceToNextAdvise() > 0) {
                    distanceToNextAdvise = adviseInfo.getDistanceToNextAdvise();
                }
            } catch (Exception unused) {
            }
        }
        textView2.setText(NavigationFormatter.getFormattedDistance(distanceToNextAdvise, getNavigationApplication()));
        bindManeuverView(maneuverView, navigationStep);
        TextView textView6 = this.tvDistanceLeft;
        if (textView6 != null) {
            textView3.setText(textView6.getText());
        }
        TextView textView7 = this.tvDurationLeft;
        if (textView7 != null) {
            textView4.setText(textView7.getText());
        }
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewInflate).create();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new StepsListAdapter(routeDirections, iMax, new StepsListAdapter.Listener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda1
            @Override // com.bajajconnect.navigate.fragment.NavigationFragment.StepsListAdapter.Listener
            public final void onStepSelected(int i) {
                this.f$0.lambda$showStepsListDialog$8(alertDialogCreate, i);
            }
        }));
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        alertDialogCreate.show();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setLayout(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showStepsListDialog$8(AlertDialog alertDialog, int i) {
        alertDialog.dismiss();
        previewStepAtIndex(i);
    }

    private void bindManeuverView(ManeuverView maneuverView, NavigationStep navigationStep) {
        if (maneuverView == null || navigationStep == null || !(navigationStep.getExtraInfo() instanceof LegStep)) {
            return;
        }
        LegStep legStep = (LegStep) navigationStep.getExtraInfo();
        if (legStep.maneuver() == null) {
            return;
        }
        maneuverView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
        if (legStep.maneuver().degree() != null) {
            maneuverView.setRoundaboutAngle(legStep.maneuver().degree().floatValue());
        } else {
            maneuverView.setRoundaboutAngle(180.0f);
        }
    }

    private void previewStepAtIndex(int i) {
        if (this.navigationStripViewPager == null) {
            return;
        }
        List<NavigationStep> routeDirections = getNavigationApplication() != null ? getNavigationApplication().getRouteDirections() : null;
        if (routeDirections == null || i < 0 || i >= routeDirections.size()) {
            return;
        }
        this.nextInstructionContainer.setVisibility(8);
        NavigationCamera navigationCamera = this.camera;
        if (navigationCamera != null) {
            navigationCamera.updateCameraTrackingMode(2);
        }
        RecenterButton recenterButton = this.mFollowMeButton;
        if (recenterButton != null && recenterButton.getVisibility() != 0) {
            this.mFollowMeButton.setVisibility(0);
        }
        this.navigationStripViewPager.setCurrentItem(i);
        BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
        if (bearingIconPlugin != null) {
            bearingIconPlugin.setBearingLayerVisibility(true);
        }
        setNavigationPadding(false);
        fixPreviewNavigationMarker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class StepsListAdapter extends RecyclerView.Adapter<StepVH> {
        private final int highlightIndex;
        private final Listener listener;
        private final List<NavigationStep> steps;

        interface Listener {
            void onStepSelected(int i);
        }

        StepsListAdapter(List<NavigationStep> list, int i, Listener listener) {
            this.steps = list;
            this.highlightIndex = i;
            this.listener = listener;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public StepVH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new StepVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_navigation_step, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(StepVH stepVH, int i) {
            final int i2 = i + this.highlightIndex + 1;
            if (i2 >= this.steps.size()) {
                return;
            }
            NavigationStep navigationStep = this.steps.get(i2);
            stepVH.instruction.setText(navigationStep.getShortInstruction());
            NavigationApplication navigationApplicationNavigationContext = NavApplication.navigationContext();
            if (navigationApplicationNavigationContext == null && (stepVH.itemView.getContext().getApplicationContext() instanceof NavigationApplication)) {
                navigationApplicationNavigationContext = (NavigationApplication) stepVH.itemView.getContext().getApplicationContext();
            }
            if (navigationApplicationNavigationContext != null) {
                stepVH.distance.setText(NavigationFormatter.getFormattedDistance(navigationStep.distance, navigationApplicationNavigationContext));
            } else {
                stepVH.distance.setText(String.valueOf(Math.round(navigationStep.distance)) + " m");
            }
            if (navigationStep.getExtraInfo() instanceof LegStep) {
                LegStep legStep = (LegStep) navigationStep.getExtraInfo();
                if (legStep.maneuver() != null) {
                    stepVH.maneuver.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
                    if (legStep.maneuver().degree() != null) {
                        stepVH.maneuver.setRoundaboutAngle(legStep.maneuver().degree().floatValue());
                    } else {
                        stepVH.maneuver.setRoundaboutAngle(180.0f);
                    }
                }
            }
            stepVH.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$StepsListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(i2, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
            Listener listener = this.listener;
            if (listener != null) {
                listener.onStepSelected(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return Math.max(0, (this.steps.size() - this.highlightIndex) - 1);
        }

        static final class StepVH extends RecyclerView.ViewHolder {
            final TextView distance;
            final TextView instruction;
            final ManeuverView maneuver;

            StepVH(View view) {
                super(view);
                this.maneuver = (ManeuverView) view.findViewById(R.id.step_item_maneuver);
                this.distance = (TextView) view.findViewById(R.id.step_item_distance);
                this.instruction = (TextView) view.findViewById(R.id.step_item_instruction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRouteClassesDetailToast() {
        if (MapplsNavigationHelper.getInstance().getCurrentRoute() != null && MapplsNavigationHelper.getInstance().getCurrentRoute().routeClasses() != null) {
            RouteClasses routeClasses = MapplsNavigationHelper.getInstance().getCurrentRoute().routeClasses();
            ArrayList arrayList = new ArrayList();
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
            if (routeClasses.restricted() != null && routeClasses.restricted().intValue() == 1) {
                arrayList.add("Restricted");
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder("This route contains ");
                if (arrayList.size() == 1) {
                    sb.append((String) arrayList.get(0));
                } else {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (i == arrayList.size() - 1) {
                            sb.append(" & ");
                            sb.append((String) arrayList.get(i));
                        } else if (i == 0) {
                            sb.append((String) arrayList.get(i));
                        } else {
                            sb.append(", ");
                            sb.append((String) arrayList.get(i));
                        }
                    }
                }
                this.tvRouteClassDetail.setText(sb.toString());
            } else {
                this.tvRouteClassDetail.setText("This route does not contains any classes");
            }
        } else {
            this.tvRouteClassDetail.setText("This route does not contains any classes");
        }
        this.tvRouteClassDetail.startAnimation(this.fadeInSlowOut);
    }

    private void nextPreviousButtonPressed(boolean z) {
        this.nextInstructionContainer.setVisibility(8);
        NavigationCamera navigationCamera = this.camera;
        if (navigationCamera != null) {
            navigationCamera.updateCameraTrackingMode(2);
        }
        if (this.mFollowMeButton.getVisibility() != 0) {
            this.mFollowMeButton.setVisibility(0);
        }
        if (z) {
            if (this.navigationStripViewPager.getCurrentItem() > this.currentPageLocation) {
                ViewPager viewPager = this.navigationStripViewPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
                if (bearingIconPlugin != null) {
                    bearingIconPlugin.setBearingLayerVisibility(true);
                }
                setNavigationPadding(false);
                fixPreviewNavigationMarker();
                return;
            }
            return;
        }
        if (this.navigationStripViewPager.getCurrentItem() < getNavigationApplication().getRouteDirections().size()) {
            ViewPager viewPager2 = this.navigationStripViewPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            BearingIconPlugin bearingIconPlugin2 = this.bearingIconPlugin;
            if (bearingIconPlugin2 != null) {
                bearingIconPlugin2.setBearingLayerVisibility(true);
            }
            setNavigationPadding(false);
            fixPreviewNavigationMarker();
        }
    }

    private void fixPreviewNavigationMarker() {
        NavigationCamera navigationCamera;
        try {
            if (this.mapplsMap != null && (navigationCamera = this.camera) != null) {
                navigationCamera.updateCameraTrackingMode(2);
            }
            List<NavigationStep> routeDirections = getNavigationApplication().getRouteDirections();
            NavLocation navLocation = routeDirections.get(this.navigationStripViewPager.getCurrentItem()).getNavLocation();
            if (this.mapplsMap == null || navLocation == null) {
                return;
            }
            this.mapplsMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(navLocation.getLatitude(), navLocation.getLongitude())).zoom(this.mapplsMap.getMaxZoomLevel()).tilt(0.0d).build()), Constants.MAX_URL_LENGTH);
            NavLocation navLocation2 = routeDirections.get(this.navigationStripViewPager.getCurrentItem()).getNavLocation();
            if (navLocation2 != null) {
                float locationAngle = getLocationAngle(navLocation2);
                BearingIconPlugin bearingIconPlugin = this.bearingIconPlugin;
                if (bearingIconPlugin != null) {
                    bearingIconPlugin.setBearingIcon(locationAngle, new LatLng(navLocation2.getLatitude(), navLocation2.getLongitude()));
                }
            }
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    class MyLocalBroadcastReceiver extends BroadcastReceiver {
        MyLocalBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NavigationFragment.this.mFragmentTransactionSave && NavigationFragment.this.getActivity() != null) {
                NavigationFragment.this.locationModeNavigation(false);
            }
            NavigationFragment.this.getActivity().onBackPressed();
        }
    }

    private void registerBroadcastReciever() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MirroringGlobarVar.ACTION_STOP_NAVIGATION);
        intentFilter.addAction(MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.mMessageReceiverTbt, intentFilter);
    }

    private void unregisterRecieer() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.mMessageReceiverTbt);
    }

    /* JADX INFO: renamed from: com.bajajconnect.navigate.fragment.NavigationFragment$10, reason: invalid class name */
    class AnonymousClass10 extends BroadcastReceiver {
        AnonymousClass10() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MirroringGlobarVar.ACTION_SOFTAP_RECONNECTED.equals(intent != null ? intent.getAction() : null)) {
                Log.i("NavigationFrg", "SoftAP reconnected — resume TBT mirroring");
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment$10$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onReceive$0();
                    }
                });
            } else {
                Log.e("NavigationFrg", "stopNAvigation recieved");
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bajajconnect.navigate.fragment.NavigationFragment.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NavigationFragment.this.endMirroring();
                        HomeActivity homeActivity = (HomeActivity) NavigationFragment.this.getActivity();
                        if (homeActivity != null) {
                            homeActivity.endMapplsNavigation("clusterOrBroadcastStop");
                        } else if (BleFeatures.navigationCallback != null) {
                            BleFeatures.navigationCallback.onNavigationStop();
                            NavigationFragment.this.onBackPressed(true);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() {
            MirroringGlobarVar.currentNavigationScreen = MirroringGlobarVar.CurrentNavigationScreen.NAVIGATION;
            if (NavApplication.customProjection != null && NavApplication.customProjection.mImageReader != null && (NavApplication.customProjection.myNavigationPresentation != null || NavApplication.customProjection.routeInfoPresentationMMI != null || NavApplication.customProjection.routeInfoPresentation != null)) {
                MirroringGlobarVar.currentScreen = Screens.TBT_SCREEN;
                try {
                    if (NavApplication.streamingHandler == null || NavApplication.streamingHandler.udpServerService == null) {
                        return;
                    }
                    NavApplication.streamingHandler.udpServerService.onScreenChange();
                    return;
                } catch (Exception e) {
                    Log.w("NavigationFrg", "SoftAP re-announce TBT failed", e);
                    return;
                }
            }
            MirroringGlobarVar.currentScreen = Screens.NONE;
            NavigationFragment.this.checkForWifi();
        }
    }
}
