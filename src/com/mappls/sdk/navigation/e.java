package com.mappls.sdk.navigation;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.provider.Settings;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.gpx.GPXDataModel;
import com.mappls.sdk.navigation.iface.CongestionInfoChangedListener;
import com.mappls.sdk.navigation.iface.CongestionInfoLoadedListener;
import com.mappls.sdk.navigation.iface.DeleteDeviceListener;
import com.mappls.sdk.navigation.iface.DeviceListListener;
import com.mappls.sdk.navigation.iface.INavigationListener;
import com.mappls.sdk.navigation.iface.INavigationLoggingListener;
import com.mappls.sdk.navigation.iface.ISaveTrackListener;
import com.mappls.sdk.navigation.iface.ITrackRecordingListener;
import com.mappls.sdk.navigation.iface.JunctionInfoChangedListener;
import com.mappls.sdk.navigation.iface.JunctionViewsLoadedListener;
import com.mappls.sdk.navigation.iface.LocationChangedListener;
import com.mappls.sdk.navigation.iface.NavigationEventListener;
import com.mappls.sdk.navigation.iface.NavigationEventLoadedListener;
import com.mappls.sdk.navigation.iface.OnAuthentication;
import com.mappls.sdk.navigation.iface.OnSpeedLimitListener;
import com.mappls.sdk.navigation.iface.POIAlongTheRouteChangedListener;
import com.mappls.sdk.navigation.iface.TollEntryExitListener;
import com.mappls.sdk.navigation.iface.VoiceCommandListener;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.model.NavigationResponse;
import com.mappls.sdk.navigation.model.NavigationSummary;
import com.mappls.sdk.navigation.notifications.INotificationManagerCallback;
import com.mappls.sdk.navigation.routing.IRecalculatedDirection;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.textinstructions.TextInstructionHelper;
import com.mappls.sdk.navigation.util.AuthenticationError;
import com.mappls.sdk.navigation.util.ErrorType;
import com.mappls.sdk.navigation.util.ManeuverInfo;
import com.mappls.sdk.navigation.util.MapplsNavigationMode;
import com.mappls.sdk.navigation.util.NavigationSummaryHelper;
import com.mappls.sdk.services.api.ApiResponse;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.directions.MapplsDirectionManager;
import com.mappls.sdk.services.api.directions.MapplsDirections;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import com.mappls.sdk.services.api.event.route.model.RouteReportSummaryResponse;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices;
import com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevicesManager;
import com.mappls.sdk.services.api.session.devicelist.model.Device;
import com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice;
import com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDeviceManager;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import com.mappls.sdk.services.utils.Constants;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
class e {
    private static boolean J = false;
    private OnSpeedLimitListener A;
    private INotificationManagerCallback I;
    private VoiceCommandListener a;
    protected Application b;
    private String e;
    Class<?> f;
    Class<Service> g;
    DirectionsResponse i;
    JunctionViewsLoadedListener k;
    CongestionInfoLoadedListener l;
    RouteReportSummaryResponse o;
    private u p;
    private IRecalculatedDirection s;
    private ITrackRecordingListener t;
    private Handler u;
    private String v;
    private String w;
    private int x;
    private String y;
    protected boolean c = true;
    boolean d = true;
    boolean h = true;
    NavigationEventLoadedListener j = null;
    String m = "280X200";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f709n = WeatherCriteria.UNIT_TYPE_DAY;
    private int q = 100;
    private com.mappls.sdk.navigation.routing.d r = null;
    private boolean z = true;
    private boolean B = false;
    private boolean C = false;
    private boolean D = true;
    private boolean E = false;
    private List<AlternateRoute> F = new ArrayList();
    int G = -1;
    int H = 1;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (e.this.t != null) {
                NavLocation lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
                e.this.t.onRecordingInfoUpdated(NavigationFormatter.getFormattedSpeed(lastKnownLocation != null ? lastKnownLocation.getSpeed() : 0.0f, e.this.b), NavigationContext.getNavigationContext().h.getDistance(), NavigationContext.getNavigationContext().h.getDuration());
            }
            e.this.startTrackRecordingHandler();
        }
    }

    final class b implements CoordinateCallback {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        b(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // com.mappls.sdk.maps.CoordinateCallback
        public final void coordinateResultSuccess(List<CoordinateResult> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            e.this.addWayPoint(new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue()), this.a, this.b, this.c);
        }

        @Override // com.mappls.sdk.maps.CoordinateCallback
        public final void onFailure() {
        }
    }

    final class c extends t.b<Void, Object, NavigationResponse> {
        final /* synthetic */ DirectionsResponse a;
        final /* synthetic */ int b;
        final /* synthetic */ LatLng c;
        final /* synthetic */ WayPoint d;
        final /* synthetic */ List e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;
        final /* synthetic */ List h;
        final /* synthetic */ OnAuthentication i;

        c(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List list, String str, boolean z, List list2, OnAuthentication onAuthentication) {
            this.a = directionsResponse;
            this.b = i;
            this.c = latLng;
            this.d = wayPoint;
            this.e = list;
            this.f = str;
            this.g = z;
            this.h = list2;
            this.i = onAuthentication;
        }

        @Override // com.mappls.sdk.navigation.t.b
        protected final NavigationResponse a(Void[] voidArr) {
            return e.this.startNavigation(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        @Override // com.mappls.sdk.navigation.t.b
        protected final void a(NavigationResponse navigationResponse) {
            NavigationResponse navigationResponse2 = navigationResponse;
            if (this.i != null) {
                if (navigationResponse2 == null || navigationResponse2.getError() == null) {
                    this.i.onSuccess();
                } else {
                    this.i.onFailure(navigationResponse2.getError().errorCode, navigationResponse2.getError().errorMessage, navigationResponse2.getException());
                }
            }
        }
    }

    final class d implements Runnable {
        final /* synthetic */ NavLocation a;

        d(NavLocation navLocation) {
            this.a = navLocation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.setCurrentLocation(this.a);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.e$e, reason: collision with other inner class name */
    final class C0095e implements OnResponseCallback<List<Device>> {
        final /* synthetic */ DeviceListListener a;

        C0095e(DeviceListListener deviceListListener) {
            this.a = deviceListListener;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            DeviceListListener deviceListListener = this.a;
            if (deviceListListener != null) {
                deviceListListener.onError("");
            }
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(List<Device> list) {
            List<Device> list2 = list;
            DeviceListListener deviceListListener = this.a;
            if (deviceListListener != null) {
                deviceListListener.onList(list2);
            }
        }
    }

    final class f implements OnResponseCallback<Void> {
        final /* synthetic */ DeleteDeviceListener a;

        f(DeleteDeviceListener deleteDeviceListener) {
            this.a = deleteDeviceListener;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            DeleteDeviceListener deleteDeviceListener = this.a;
            if (deleteDeviceListener != null) {
                deleteDeviceListener.onError("");
            }
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(Void r1) {
            DeleteDeviceListener deleteDeviceListener = this.a;
            if (deleteDeviceListener != null) {
                deleteDeviceListener.onSuccess();
            }
        }
    }

    e() {
    }

    private NavigationRoute getNavigationRoute(LatLng latLng, String str, DirectionsRoute directionsRoute, List<WayPoint> list, List<ReportDetails> list2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        NavLocation navLocation = new NavLocation("router");
        navLocation.setLatitude(latLng.getLatitude());
        navLocation.setLongitude(latLng.getLongitude());
        try {
            List<Point> listCoordinates = LineString.fromPolyline(directionsRoute.geometry(), 6).coordinates();
            NavigationLogger.d("Points = %d", Integer.valueOf(listCoordinates.size()));
            for (int i = 0; i < listCoordinates.size(); i++) {
                NavLocation navLocation2 = new NavLocation("router");
                navLocation2.setLatitude(listCoordinates.get(i).latitude());
                navLocation2.setLongitude(listCoordinates.get(i).longitude());
                arrayList2.add(navLocation2);
            }
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WayPoint wayPoint : list) {
                arrayList.add(new LatLng(wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue()));
                com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(wayPoint.getLatitude().doubleValue(), wayPoint.getLongitude().doubleValue(), wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue());
                aVar.a(wayPoint.getVisualName());
                aVar.b(wayPoint.getSpokenName());
                arrayList4.add(new w.a(new LatLng(wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue()), aVar));
            }
        }
        com.mappls.sdk.navigation.routing.b bVar = new com.mappls.sdk.navigation.routing.b();
        bVar.a = navLocation;
        bVar.b = str;
        bVar.c = arrayList;
        com.mappls.sdk.navigation.d dVarA = NavigationContext.getNavigationContext().h().a();
        bVar.g = ((s.l) NavigationContext.getNavigationContext().k().B0.get()).a;
        ((Boolean) NavigationContext.getNavigationContext().k().B.a(dVarA)).booleanValue();
        bVar.f = (com.mappls.sdk.navigation.routing.c.a) NavigationContext.getNavigationContext().k().u.get();
        bVar.e = dVarA;
        bVar.d = this.b;
        try {
            List<DirectionsWaypoint> listSubList = this.i.waypoints().subList(1, this.i.waypoints().size() - 1);
            if (listSubList != null) {
                for (DirectionsWaypoint directionsWaypoint : listSubList) {
                    arrayList3.add(new LatLng(directionsWaypoint.location().latitude(), directionsWaypoint.location().longitude()));
                }
            }
            bVar.c = arrayList3;
        } catch (Exception e2) {
            NavigationLogger.e(e2);
        }
        return new NavigationRoute(directionsRoute, arrayList2, null, bVar, arrayList4, true, null, list2, null);
    }

    private NavigationRoute getNavigationRoute(DirectionsRoute directionsRoute) {
        ArrayList arrayList = new ArrayList();
        try {
            List<Point> listCoordinates = LineString.fromPolyline(directionsRoute.geometry(), 6).coordinates();
            NavigationLogger.d("Points = %d", Integer.valueOf(listCoordinates.size()));
            for (int i = 0; i < listCoordinates.size(); i++) {
                NavLocation navLocation = new NavLocation("router");
                navLocation.setLatitude(listCoordinates.get(i).latitude());
                navLocation.setLongitude(listCoordinates.get(i).longitude());
                arrayList.add(navLocation);
            }
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
        return new NavigationRoute(directionsRoute, arrayList, null, NavigationContext.getNavigationContext().h().k().getParams(), NavigationContext.getNavigationContext().h().k().getLocationPoints(), true, null, null, null);
    }

    public static boolean isNavigationRequestIsInProgress() {
        return J;
    }

    private boolean isPauseNavigation() {
        return this.r.r();
    }

    private void setOfflineOnlineBaseUrl(String str) {
        if (NavigationContext.getNavigationContext().k().a.get() == null || str == null) {
            return;
        }
        NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().baseUrl(str).build().toJson());
    }

    private synchronized void startNavigation(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list, boolean z, List<ReportDetails> list2) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        setOdometerSpeed(-1);
        if (list != null && directionsResponse.waypoints().size() - 2 == list.size()) {
            for (int i2 = 1; i2 <= directionsResponse.waypoints().size() - 2; i2++) {
                int i3 = i2 - 1;
                list.get(i3).setEntryLatitude(directionsResponse.waypoints().get(i2).location().latitude());
                list.get(i3).setEntryLongitude(directionsResponse.waypoints().get(i2).location().longitude());
                list.get(i3).setLatitude(Double.valueOf(directionsResponse.waypoints().get(i2).location().latitude()));
                list.get(i3).setLongitude(Double.valueOf(directionsResponse.waypoints().get(i2).location().longitude()));
            }
        }
        com.mappls.sdk.navigation.routing.d dVarH = NavigationContext.getNavigationContext().h();
        com.mappls.sdk.navigation.d dVar = com.mappls.sdk.navigation.d.i;
        dVarH.a(dVar);
        this.r.a(false);
        com.mappls.sdk.navigation.routing.d dVarH2 = NavigationContext.getNavigationContext().h();
        com.mappls.sdk.navigation.routing.h hVarO = dVarH2.o();
        boolean zBooleanValue = ((Boolean) NavigationContext.getNavigationContext().k().p0.get()).booleanValue();
        hVarO.getClass();
        com.mappls.sdk.navigation.routing.h.a(zBooleanValue);
        if (!dVarH2.q()) {
            ((s.g) NavigationContext.getNavigationContext().k().I0).set(dVarH2.a());
            NavigationContext.getNavigationContext().k().s0.set(Boolean.TRUE);
            dVarH2.a(true);
            dVarH2.b(false);
            NavigationContext.getNavigationContext().h().getClass();
            NavLocation navLocation = null;
            if (directionsResponse == null) {
                dVarH2.a(NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation(), false);
            } else {
                setDirectionsResponse(directionsResponse);
                setSessionId(directionsResponse.sessionId());
                setUuid(directionsResponse.uuid());
                setRouteIndex(i);
                DirectionsRoute selectedTrip = getSelectedTrip(directionsResponse, i);
                if (selectedTrip.routeOptions() != null) {
                    NavigationContext.getNavigationContext().k().a.set(selectedTrip.routeOptions().toJson());
                    if (selectedTrip.routeOptions().profile().equalsIgnoreCase("walking")) {
                        s.t<com.mappls.sdk.navigation.d> tVar = NavigationContext.getNavigationContext().k().I0;
                        com.mappls.sdk.navigation.d dVar2 = com.mappls.sdk.navigation.d.k;
                        ((s.g) tVar).set(dVar2);
                        NavigationContext.getNavigationContext().h().a(dVar2);
                    } else {
                        ((s.g) NavigationContext.getNavigationContext().k().I0).set(dVar);
                        NavigationContext.getNavigationContext().h().a(dVar);
                    }
                }
                NavLocation lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
                LatLng latLng2 = latLng != null ? latLng : lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
                NavLocation navLocation2 = new NavLocation("");
                if (latLng2 != null) {
                    navLocation2.setLatitude(latLng2.getLatitude());
                    navLocation2.setLongitude(latLng2.getLongitude());
                }
                dVarH2.a(navLocation2, getNavigationRoute(latLng2, wayPoint.isValidCoordinates() ? wayPoint.getEntryLongitude() + "," + wayPoint.getEntryLatitude() : wayPoint.getMapplsPin(), selectedTrip, list, list2), false);
                navLocation = navLocation2;
            }
            NavigationContext.getNavigationContext().m().b();
            if (wayPoint.isValidCoordinates()) {
                com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue());
                aVar.b(wayPoint.getSpokenName());
                aVar.a(wayPoint.getVisualName());
                NavigationContext.getNavigationContext().m().a(new LatLng(wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue()), false, -1, aVar);
            } else {
                com.mappls.sdk.navigation.data.a aVar2 = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, wayPoint.getVisualName());
                aVar2.b(wayPoint.getSpokenName());
                aVar2.a(wayPoint.getVisualName());
                NavigationContext.getNavigationContext().m().a(wayPoint.getMapplsPin(), false, aVar2);
            }
            if (list != null && list.size() > 0) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (list.get(i4).isValidCoordinates()) {
                        com.mappls.sdk.navigation.data.a aVar3 = new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, list.get(i4).getVisualName());
                        aVar3.b(list.get(i4).getSpokenName());
                        NavigationContext.getNavigationContext().k().a(list.get(i4).getEntryLatitude().doubleValue(), list.get(i4).getEntryLongitude().doubleValue(), aVar3, i4);
                    } else {
                        com.mappls.sdk.navigation.data.a aVar4 = new com.mappls.sdk.navigation.data.a(FirebaseAnalytics.Param.DESTINATION, list.get(i4).getVisualName());
                        aVar4.b(list.get(i4).getSpokenName());
                        NavigationContext.getNavigationContext().k().a(list.get(i4).getMapplsPin(), aVar4, i4);
                    }
                }
            }
            NavigationContext.getNavigationContext().m().b(true);
            NavigationContext.getNavigationContext().a(new d(navLocation));
        } else if (((s.g) NavigationContext.getNavigationContext().k().I0).get() != dVarH2.a()) {
            ((s.g) NavigationContext.getNavigationContext().k().I0).set(dVarH2.a());
        }
    }

    public void addCongestionInfoChangedListener(CongestionInfoChangedListener congestionInfoChangedListener) {
        NavigationContext.getNavigationContext().r.a(congestionInfoChangedListener);
    }

    public void addJunctionInfoChangedListener(JunctionInfoChangedListener junctionInfoChangedListener) {
        NavigationContext.getNavigationContext().r.a(junctionInfoChangedListener);
    }

    public void addLocationChangeListener(LocationChangedListener locationChangedListener) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().getLocationProvider().addLocationChangeListener(locationChangedListener);
    }

    public void addNavigationEventListener(NavigationEventListener navigationEventListener) {
        NavigationContext.getNavigationContext().r.a(navigationEventListener);
    }

    protected void addNavigationListener(INavigationListener iNavigationListener) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        com.mappls.sdk.navigation.routing.d dVar = this.r;
        if (dVar != null) {
            dVar.a(iNavigationListener);
        }
    }

    public void addWayPoint(LatLng latLng, int i, String str) {
        addWayPoint(latLng, i, str, str);
    }

    public void addWayPoint(LatLng latLng, int i, String str, String str2) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, str);
        aVar.a(latLng.getLatitude());
        aVar.b(latLng.getLongitude());
        aVar.b(str2);
        NavigationContext.getNavigationContext().m().a(new LatLng(latLng.getLatitude(), latLng.getLongitude()), true, i, aVar);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }

    public void addWayPoint(String str, int i, String str2) {
        addWayPoint(str, i, str2, str2);
    }

    public void addWayPoint(String str, int i, String str2, String str3) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        try {
            Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
            Object objNewInstance = cls.newInstance();
            Method declaredMethod = cls.getDeclaredMethod("getAnnotation", List.class, CoordinateCallback.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(objNewInstance, str, new b(i, str2, str3));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            NavigationLogger.d(e);
        }
    }

    public void addWayPoint(List<WayPoint> list, int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        ArrayList arrayList = new ArrayList();
        for (WayPoint wayPoint : list) {
            com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, wayPoint.getVisualName());
            aVar.a(wayPoint.getEntryLatitude().doubleValue());
            aVar.b(wayPoint.getEntryLongitude().doubleValue());
            aVar.b(wayPoint.getSpokenName());
            arrayList.add(aVar);
        }
        NavigationContext.getNavigationContext().p.a(arrayList, i);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }

    public void announceCurrentDirection() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        try {
            NavigationContext.getNavigationContext().l.o().a(NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation());
        } catch (Exception e) {
            NavigationLogger.d(e);
        }
    }

    void deleteDevice(String str, Device device, DeleteDeviceListener deleteDeviceListener) {
        MapplsDeleteClusterLinkedDeviceManager.newInstance(MapplsDeleteClusterLinkedDevice.builder().clusterId(str).linkedDevice(device.getDeviceFingerprint()).sessionType("navigation").build()).call(new f(deleteDeviceListener));
    }

    public void enableFasterRouteAvailable(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().D0.set(Integer.valueOf(z ? 1 : 0));
    }

    public boolean enableFasterRouteAvailable() {
        if (this.b != null) {
            return ((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() != 0;
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void enableNearbyPoiAlongRoute(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().G.set(Boolean.valueOf(z));
    }

    public void extendNotification(NotificationCompat.Builder builder) {
    }

    public AdviseInfo getAdviseInfo() {
        NavigationStep navigationStep;
        String str;
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationRoute.a aVar = new NavigationRoute.a();
        int averageSpeed = 0;
        NavigationContext.getNavigationContext().l.a(aVar, false);
        String str2 = DateFormat.getTimeInstance(3).format(new Date(System.currentTimeMillis() + ((long) (NavigationContext.getNavigationContext().l.j() * 1000))));
        try {
            if (aVar.a == null) {
                return null;
            }
            AdviseInfo adviseInfo = new AdviseInfo();
            adviseInfo.setText(aVar.a.getDescriptionRoutePart());
            adviseInfo.setEtaInSecond((System.currentTimeMillis() + ((long) (NavigationContext.getNavigationContext().l.j() * 1000))) / 1000);
            adviseInfo.setDistanceToNextAdvise(aVar.b);
            adviseInfo.setLeftDistance(NavigationContext.getNavigationContext().l.h());
            adviseInfo.setEta(str2);
            adviseInfo.setShortText(aVar.a.getShortInstruction());
            adviseInfo.setRouteBeingRecalculated(NavigationContext.getNavigationContext().l.s());
            adviseInfo.setLeftTime(NavigationContext.getNavigationContext().l.j());
            if (aVar.b > 0 && aVar.a.getAverageSpeed() > 0.0f) {
                averageSpeed = (int) (aVar.b / aVar.a.getAverageSpeed());
            }
            adviseInfo.setLeftTimeStep(averageSpeed);
            adviseInfo.setInfo(aVar.a.getExtraInfo());
            adviseInfo.setNextInstructionInfo(aVar.a.getNextExtraInfo());
            NavigationStep navigationStep2 = aVar.a;
            adviseInfo.setNextInstructionText((navigationStep2 == null || navigationStep2.getNextExtraInfo() == null) ? null : TextInstructionHelper.getInstance().getInstruction((LegStep) aVar.a.getNextExtraInfo()));
            adviseInfo.setManeuverID(aVar.a.getManeuverID());
            adviseInfo.setManeuverIDLegacy(aVar.a.getManeuverIdLegacy());
            adviseInfo.setShortText(aVar.a.getShortInstruction());
            NavLocation navLocationConvertLocation = NavigationContext.getNavigationContext().getCurrentLocation() != null ? NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().getCurrentLocation(), this.b) : null;
            if (navLocationConvertLocation == null) {
                navLocationConvertLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
            }
            if (navLocationConvertLocation == null) {
                navLocationConvertLocation = NavigationContext.getNavigationContext().l.f();
            }
            adviseInfo.setLocation(navLocationConvertLocation);
            if (adviseInfo.getDistanceToNextAdvise() < this.r.c() && adviseInfo.getManeuverID() == 8 && (navigationStep = aVar.a) != null) {
                if (navigationStep.isDestination()) {
                    str = "You have arrived";
                } else {
                    adviseInfo.setIntermediate(true);
                    str = "You have reached your intermediate destination";
                }
                adviseInfo.setText(str);
            }
            return adviseInfo;
        } catch (Exception e) {
            NavigationLogger.e(e);
            return null;
        }
    }

    public List<NavLocation> getAllRouteLocations() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getImmutableAllLocations();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public List<AlternateRoute> getAlternateRoutes() {
        return this.F;
    }

    protected List<String> getAvoidanceSettings() {
        if (NavigationContext.getNavigationContext().k().a.get() == null) {
            return null;
        }
        RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
        if (routeOptionsFromJson.exclude() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String strExclude = routeOptionsFromJson.exclude();
        if (strExclude.contains(",")) {
            for (String str : strExclude.split(",")) {
                arrayList.add(str);
            }
        } else {
            arrayList.add(strExclude);
        }
        return arrayList;
    }

    public String getBaseRes() {
        return this.e;
    }

    public CongestionInfoLoadedListener getCongestionInfoLoadedListener() {
        return this.l;
    }

    public Long getCurrentNodeId() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        try {
            DirectionsRoute currentRoute = MapplsNavigationHelper.getInstance().getCurrentRoute();
            if (currentRoute != null && currentRoute.legs() != null && !currentRoute.legs().isEmpty() && currentRoute.legs().get(0).annotation() != null && currentRoute.legs().get(0).annotation().nodes() != null && !currentRoute.legs().get(0).annotation().nodes().isEmpty() && currentRoute.legs().get(0).annotation().nodes().size() > NavigationContext.getNavigationContext().h().k().getCurrentRoute()) {
                return currentRoute.legs().get(0).annotation().nodes().get(NavigationContext.getNavigationContext().h().k().getCurrentRoute());
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public DirectionsRoute getCurrentRoute() {
        return this.r.k().directionsRoute;
    }

    public com.mappls.sdk.navigation.routing.b getDefaultParams() {
        com.mappls.sdk.navigation.routing.b bVar = new com.mappls.sdk.navigation.routing.b();
        com.mappls.sdk.navigation.d dVar = com.mappls.sdk.navigation.d.i;
        bVar.g = ((s.l) NavigationContext.getNavigationContext().k().B0.get()).a;
        ((Boolean) NavigationContext.getNavigationContext().k().B.a(dVar)).booleanValue();
        bVar.f = (com.mappls.sdk.navigation.routing.c.a) NavigationContext.getNavigationContext().k().u.get();
        bVar.e = dVar;
        bVar.d = this.b;
        return bVar;
    }

    public String getDeviceId() {
        Application application = this.b;
        if (application == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (this.y == null) {
            this.y = Settings.Secure.getString(application.getContentResolver(), "android_id");
        }
        return this.y;
    }

    public DirectionsResponse getDirectionsResponse() {
        return this.i;
    }

    public List<ReportDetails> getEvents() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (NavigationContext.getNavigationContext().l.k() != null) {
            return NavigationContext.getNavigationContext().l.k().getEvents();
        }
        return null;
    }

    public NavLocation getFirstLocation() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (this.r.k().getCurrentRoute() < this.r.d().size()) {
            return this.r.d().get(this.r.k().getCurrentRoute());
        }
        return null;
    }

    public String getJunctionViewImageSize() {
        return this.m;
    }

    public String getJunctionViewMode() {
        return this.f709n;
    }

    public String getJunctionViewURL(String str, boolean z) {
        return "https://cdn.mappls.com/jvimage/280X200/" + (z ? WeatherCriteria.UNIT_TYPE_DAY : "night") + RemoteSettings.FORWARD_SLASH_STRING + str;
    }

    public List<Junction> getJunctionViews() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getJunctionViews();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public JunctionViewsLoadedListener getJunctionViewsLoadedListener() {
        return this.k;
    }

    public int getLeftDistance() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.h();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public int getLeftTime() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.j();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    void getListOfDevices(String str, DeviceListListener deviceListListener) {
        MapplsClusterLinkedDevicesManager.newInstance(MapplsClusterLinkedDevices.builder().clusterId(str).sessionType("navigation").build()).call(new C0095e(deviceListListener));
    }

    public ManeuverInfo getManeuverInfo(Context context, int i) {
        ManeuverInfo maneuverInfo = new ManeuverInfo();
        if (i >= 0) {
            int identifier = context.getResources().getIdentifier("step_" + i, "drawable", context.getPackageName());
            int identifier2 = context.getResources().getIdentifier("step_" + i, TypedValues.Custom.S_STRING, context.getPackageName());
            maneuverInfo.setIcon(AppCompatResources.getDrawable(context, identifier));
            maneuverInfo.setInfoText(context.getResources().getString(identifier2));
        }
        return maneuverInfo;
    }

    public int getMinimumVehicleSpeed() {
        return this.H;
    }

    public Class<?> getNavigationActivityClass() {
        return this.f;
    }

    public Class<Service> getNavigationCarAppServiceClass() {
        return this.g;
    }

    public NavigationEventLoadedListener getNavigationEventLoadedListener() {
        return this.j;
    }

    public MapplsNavigationMode getNavigationMode() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().k().s.get();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public List<NavigationStep> getNavigationSteps() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getImmutableAllDirections() == null ? new ArrayList() : NavigationContext.getNavigationContext().l.k().getImmutableAllDirections();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected NavigationSummary getNavigationSummary() {
        NavigationSummaryHelper.Companion companion = NavigationSummaryHelper.Companion;
        return new NavigationSummary(companion.getInstance().getAverageSpeed(), companion.getInstance().getTotalDistance(), companion.getInstance().getTotalTimeTaken());
    }

    public int getNodeIndex() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getCurrentRoute();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public INotificationManagerCallback getNotificationManagerCallback() {
        return this.I;
    }

    public int getOdometerSpeed() {
        int i = this.G;
        return i < 0 ? i : (int) (((double) i) / 3.6d);
    }

    public int getOffRouteThreshold() {
        return this.q;
    }

    public String getOfflineBaseUrl() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().k().t.get();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public OnSpeedLimitListener getOnSpeedLimitListener() {
        return this.A;
    }

    public int getRouteIndex() {
        return this.x;
    }

    public List<NavLocation> getRouteLocations() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getRouteLocations();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public RouteReportSummaryResponse getRouteReportSummaryResponse() {
        return this.o;
    }

    public IRecalculatedDirection getRouteService() {
        return this.s;
    }

    public ArrayList<GPXDataModel> getSavedTracks() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().h.getGPXTracks();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public NavLocation getSecondLocation() {
        if (this.b != null) {
            return this.r.d().get(this.r.k().getCurrentRoute() + 1);
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public DirectionsRoute getSelectedTrip(DirectionsResponse directionsResponse, int i) {
        DirectionsRoute directionsRoute;
        DirectionsRoute directionsRoute2 = null;
        try {
            for (DirectionsRoute directionsRoute3 : directionsResponse.routes()) {
                if (directionsRoute3 != null && directionsRoute3.routeIndex() != null && directionsRoute3.routeIndex().intValue() == i) {
                    return directionsRoute3;
                }
                if (directionsRoute2 == null) {
                    if (directionsResponse.routes().size() > i) {
                        directionsRoute = directionsResponse.routes().get(i);
                    } else if (directionsResponse.routes().size() > 0) {
                        directionsRoute = directionsResponse.routes().get(0);
                    }
                    directionsRoute2 = directionsRoute;
                }
            }
            return directionsRoute2;
        } catch (Exception e) {
            NavigationLogger.d(e);
            return directionsRoute2;
        }
    }

    public String getSessionId() {
        return this.w;
    }

    public TollEntryExitListener getTollEntryExitListener() {
        return NavigationContext.getNavigationContext().l.n();
    }

    public String getUuid() {
        return this.v;
    }

    public VoiceCommandListener getVoiceCommandListener() {
        return this.a;
    }

    public List<WayPoint> getWayPoints() {
        ArrayList arrayList = new ArrayList();
        for (w.a aVar : NavigationContext.getNavigationContext().p.e()) {
            WayPoint wayPoint = new WayPoint(aVar.b(), aVar.c(), aVar.getLatitude(), aVar.getLongitude(), aVar.a(), aVar.d());
            wayPoint.setIndexOnPath(aVar.c);
            arrayList.add(wayPoint);
        }
        Timber.d("Waypoint Size = %d", Integer.valueOf(arrayList.size()));
        for (int i = 0; i < arrayList.size(); i++) {
            Timber.d("index = %d", Integer.valueOf(i));
            ((WayPoint) arrayList.get(i)).setIndex(NavigationContext.getNavigationContext().l.k().getIndexOfIntermediatePoint(((WayPoint) arrayList.get(i)).getIndexOnPath()));
        }
        return arrayList;
    }

    public int getWholeDistance() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.k().getWholeDistance();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected void init(Application application) {
        if (this.b == null) {
            this.b = application;
        }
        this.p = u.a().c().g().a().f().d().e().b(Settings.Secure.getString(application.getContentResolver(), "android_id")).a(MapplsUtils.join(",", new String[]{DirectionsCriteria.ANNOTATION_CONGESTION, DirectionsCriteria.ANNOTATION_NODES, "duration"})).b();
    }

    public void initVoiceCommandPlayer() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().b.b();
    }

    public boolean isCallAlternativeDuringNavigation() {
        return this.C;
    }

    public boolean isCloseServiceOnRemovingTask() {
        return this.z;
    }

    public boolean isCongestionDelayEventEnabled() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().L.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isCurrentMetricSystemKm() {
        if (this.b != null) {
            return ((s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get()).name().equalsIgnoreCase("KILOMETERS_AND_METERS");
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isEnableInstructionsFromAPI() {
        return this.B;
    }

    public boolean isEnableNearbyPoiAlongRoute() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().G.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected boolean isFollowingMode() {
        return this.r.q();
    }

    public boolean isGPSCheckEnableForLocationChange() {
        return this.D;
    }

    public boolean isHideExitFromNotification() {
        return this.E;
    }

    public boolean isInterruptMusicForNavigationInstructions() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().k().w.get().booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isJunctionViewEnabled() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().J.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isLoggingEnabled() {
        return ((Boolean) NavigationContext.getNavigationContext().k().f.get()).booleanValue();
    }

    public boolean isMute() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().p0.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected boolean isNavigating() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.u() || NavigationContext.getNavigationContext().l.s();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isNavigationEventAudioPromptEnabled() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().M.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isNavigationEventEnabled() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().K.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isNightMode() {
        if (this.b != null) {
            return NavigationContext.getNavigationContext().k.b();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isPlayAsVoiceCall() {
        if (this.b != null) {
            return ((Integer) NavigationContext.getNavigationContext().k().l0.get()).intValue() == 0;
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public boolean isPlayDuringPhoneCallEnabled() {
        return this.d;
    }

    public boolean isRecording() {
        if (((com.mappls.sdk.navigation.tracks.a) q.a()) == null) {
            return false;
        }
        return NavigationContext.getNavigationContext().k().x.get().booleanValue();
    }

    protected boolean isRoutePlanningMode() {
        return this.r.u();
    }

    public boolean isSetFasterRouteImmidiately() {
        if (this.b != null) {
            return ((Integer) NavigationContext.getNavigationContext().k().D0.get()).intValue() == 2;
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected boolean isShortestRoute() {
        if (NavigationContext.getNavigationContext().k().a.get() == null) {
            return false;
        }
        RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
        return routeOptionsFromJson.routeType() != null && routeOptionsFromJson.routeType().intValue() == 1;
    }

    public boolean isShouldPlayNavigationInstructions() {
        return this.h;
    }

    public boolean isTrafficProbeEnabled() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().T.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void navigateTo(LatLng latLng, String str) {
        navigateTo(latLng, str, str);
    }

    public void navigateTo(LatLng latLng, String str, String str2) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().m().a(true);
        com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, str);
        aVar.a(latLng.getLatitude());
        aVar.b(latLng.getLongitude());
        aVar.b(str2);
        NavigationContext.getNavigationContext().m().a(new LatLng(latLng.getLatitude(), latLng.getLongitude()), true, -1, aVar);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }

    public void navigateTo(String str, String str2) {
        navigateTo(str, str2, str2);
    }

    public void navigateTo(String str, String str2, String str3) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().p.a(true);
        com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, str2);
        aVar.b(str3);
        NavigationContext.getNavigationContext().p.a(str, true, aVar);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }

    public void recalculateRoute() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().l.v();
    }

    public void removeCongestionInfoChangedListener(CongestionInfoChangedListener congestionInfoChangedListener) {
        NavigationContext.getNavigationContext().r.b(congestionInfoChangedListener);
    }

    public void removeJunctionInfoChangedListener(JunctionInfoChangedListener junctionInfoChangedListener) {
        NavigationContext.getNavigationContext().r.b(junctionInfoChangedListener);
    }

    public void removeLocationChangeListener(LocationChangedListener locationChangedListener) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().getLocationProvider().removeLocationChangeListener(locationChangedListener);
    }

    public void removeNavigationEventListener(NavigationEventListener navigationEventListener) {
        NavigationContext.getNavigationContext().r.b(navigationEventListener);
    }

    protected void removeNavigationListener(INavigationListener iNavigationListener) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        com.mappls.sdk.navigation.routing.d dVar = this.r;
        if (dVar != null) {
            dVar.b(iNavigationListener);
        }
    }

    public void removeWayPoint(int i) {
        NavigationContext.getNavigationContext().p.a(i, true);
        recalculateRoute();
    }

    public void replaceRoute(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list) {
        startNavigation(directionsResponse, i, latLng, wayPoint, list, true, (List<ReportDetails>) null);
    }

    public void replaceWayPoints(List<WayPoint> list) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        ArrayList arrayList = new ArrayList();
        for (WayPoint wayPoint : list) {
            com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, wayPoint.getVisualName());
            aVar.a(wayPoint.getEntryLatitude().doubleValue());
            aVar.b(wayPoint.getEntryLongitude().doubleValue());
            aVar.b(wayPoint.getSpokenName());
            arrayList.add(aVar);
        }
        NavigationContext.getNavigationContext().p.a(arrayList);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }

    public void saveCurrentTrack() {
        saveCurrentTrack(null, null);
    }

    public void saveCurrentTrack(String str, ISaveTrackListener iSaveTrackListener) {
        com.mappls.sdk.navigation.tracks.a aVar = (com.mappls.sdk.navigation.tracks.a) q.a();
        if (aVar == null) {
            return;
        }
        aVar.a(str, iSaveTrackListener);
    }

    public void setAccuracyNavigation(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (i < 6) {
            throw new IllegalArgumentException("Accuracy can't be less than 6 meters");
        }
        if (i > 80) {
            throw new IllegalArgumentException("Accuracy can't be more than 80 meters");
        }
        NavigationContext.getNavigationContext().j.setAccuracyForGpxAndRouting(i);
    }

    public void setAlternateRoutes(List<AlternateRoute> list) {
        this.F = list;
    }

    public void setAvailableBetterRoute(List<DirectionsRoute> list) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().l.a(getNavigationRoute(list.get(0)), list.get(0));
    }

    protected void setAvoidanceSetting(List<String> list) {
        if (NavigationContext.getNavigationContext().k().a.get() == null) {
            return;
        }
        if (list == null || list.size() <= 0) {
            NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().exclude(null).build().toJson());
        } else {
            NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().exclude(MapplsUtils.join(",", list.toArray())).build().toJson());
        }
        recalculateRoute();
    }

    protected void setBaseUrl(String str) {
        this.e = str;
    }

    public void setCallAlternativeDuringNavigation(boolean z) {
        this.C = z;
    }

    public void setCloseServiceOnRemovingTask(boolean z) {
        this.z = z;
    }

    public void setCongestionDelayEventEnabled(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().L.set(Boolean.valueOf(z));
    }

    public void setCongestionDelayVisualPromptBefore(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().h.set(Integer.valueOf(i));
    }

    public void setCongestionInfoLoadedListener(CongestionInfoLoadedListener congestionInfoLoadedListener) {
        this.l = congestionInfoLoadedListener;
    }

    public void setCurrentLocation(Location location) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (location == null) {
            return;
        }
        NavigationContext.getNavigationContext().setCurrentLocation(location);
        NavigationContext.getNavigationContext().getLocationProvider().setLocationFromService(location, NavigationLocationProvider.convertLocation(location, this.b), true);
    }

    public void setCurrentLocation(NavLocation navLocation) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (navLocation == null) {
            return;
        }
        NavigationContext.getNavigationContext().getLocationProvider().setLocationFromService(NavigationLocationProvider.revertLocation(navLocation, this.b), navLocation, true);
    }

    public void setDirectionsResponse(DirectionsResponse directionsResponse) {
        this.i = directionsResponse;
    }

    protected void setEnableInstructionsFromAPI(boolean z) {
        this.B = z;
    }

    public void setEventAudioPromptBefore(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (i >= 50) {
            NavigationContext.getNavigationContext().k().e.set(Integer.valueOf(i));
        } else {
            Timber.d("distance can not be less than 50; setting audio prompt distance to 50", new Object[0]);
            NavigationContext.getNavigationContext().k().e.set(50);
        }
    }

    public void setEventVisualPromptBefore(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (i >= 50) {
            NavigationContext.getNavigationContext().k().d.set(Integer.valueOf(i));
        } else {
            Timber.d("distance can not be less than 50; setting event visual prompt distance to 50", new Object[0]);
            NavigationContext.getNavigationContext().k().d.set(50);
        }
    }

    public void setEvents(List<ReportDetails> list) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().l.k().setEvents(list);
    }

    public void setFasterRouteImmidiately(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (!enableFasterRouteAvailable()) {
            throw new IllegalStateException("Please enable Faster Route Available Setting");
        }
        NavigationContext.getNavigationContext().k().D0.set(Integer.valueOf(z ? 2 : 1));
    }

    public void setGPSCheckEnableForLocationChange(boolean z) {
        this.D = z;
    }

    public void setHideExitFromNotification(boolean z) {
        this.E = z;
    }

    public void setInterruptMusicForNavigationInstructions(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().w.a(com.mappls.sdk.navigation.d.i, Boolean.valueOf(z));
    }

    @Deprecated
    public void setJunctionInfoChangedListener(JunctionInfoChangedListener junctionInfoChangedListener) {
        NavigationContext.getNavigationContext().r.c(junctionInfoChangedListener);
    }

    public void setJunctionViewEnabled(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().J.set(Boolean.valueOf(z));
        NavigationContext.getNavigationContext().q.a(z);
    }

    public void setJunctionViewImageSize(int i, int i2) {
        String str = i + "X" + i2;
        if (this.m.equalsIgnoreCase(str)) {
            return;
        }
        this.m = str;
        if (isNavigating()) {
            recalculateRoute();
        }
    }

    public void setJunctionViewMode(String str) {
        if (this.f709n.equalsIgnoreCase(str)) {
            return;
        }
        this.f709n = str;
        if (isNavigating()) {
            recalculateRoute();
        }
    }

    public void setJunctionViewsLoadedListener(JunctionViewsLoadedListener junctionViewsLoadedListener) {
        this.k = junctionViewsLoadedListener;
    }

    public void setJunctionVisualPromptBefore(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (i >= 50) {
            NavigationContext.getNavigationContext().k().g.set(Integer.valueOf(i));
        } else {
            Timber.d("distance can not be less than 50; setting junction visual prompt distance to 50", new Object[0]);
            NavigationContext.getNavigationContext().k().g.set(50);
        }
    }

    public void setLoggingEnable(boolean z) {
        NavigationContext.getNavigationContext().k().f.set(Boolean.valueOf(z));
    }

    public void setMetricSystemToKM(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().C0.set(z ? s.EnumC0101s.KILOMETERS_AND_METERS : s.EnumC0101s.MILES_AND_FEET);
    }

    public void setMinimumVehicleSpeed(int i) {
        this.H = i;
    }

    public void setMute(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().l.o().getClass();
        com.mappls.sdk.navigation.routing.h.a(z);
        NavigationContext.getNavigationContext().k().p0.set(Boolean.valueOf(z));
        if (!z || NavigationContext.getNavigationContext().f705n == null) {
            return;
        }
        NavigationContext.getNavigationContext().f705n.j();
    }

    public void setNavigationActivityClass(Class<?> cls) {
        this.f = cls;
    }

    void setNavigationCarAppServiceClass(Class<Service> cls) {
        this.g = cls;
    }

    public void setNavigationEventAudioPromptEnabled(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().M.set(Boolean.valueOf(z));
    }

    public void setNavigationEventEnabled(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().K.set(Boolean.valueOf(z));
        NavigationContext.getNavigationContext().q.b(z);
    }

    @Deprecated
    public void setNavigationEventListener(NavigationEventListener navigationEventListener) {
        NavigationContext.getNavigationContext().r.c(navigationEventListener);
    }

    public void setNavigationEventLoadedListener(NavigationEventLoadedListener navigationEventLoadedListener) {
        this.j = navigationEventLoadedListener;
    }

    public void setNavigationLoggingListener(INavigationLoggingListener iNavigationLoggingListener) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().l.a(iNavigationLoggingListener);
    }

    public void setNavigationMode(MapplsNavigationMode mapplsNavigationMode) {
        String str;
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().s.set(mapplsNavigationMode);
        if (mapplsNavigationMode == MapplsNavigationMode.ONLINE) {
            str = Constants.ADVANCE_MAP_BASE_URL;
        } else if (mapplsNavigationMode != MapplsNavigationMode.OFFLINE || (str = NavigationContext.getNavigationContext().k().t.get()) == null) {
            return;
        }
        setOfflineOnlineBaseUrl(str);
    }

    public void setNotificationChannelId(String str) {
        NavigationContext.getNavigationContext().o.setNotificationChannelId(str);
    }

    public void setNotificationManagerCallback(INotificationManagerCallback iNotificationManagerCallback) {
        this.I = iNotificationManagerCallback;
    }

    public void setOdometerSpeed(int i) {
        this.G = i;
    }

    public void setOffRouteThreshold(int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (i <= 0) {
            this.q = -1;
            NavigationContext.getNavigationContext().l.a(-1L);
        } else {
            if (i < 10) {
                throw new IllegalArgumentException("off-route distance can't be less than 10 meters");
            }
            if (i > 100) {
                throw new IllegalArgumentException("off-route distance can't be more than 100 meters");
            }
            this.q = i;
            NavigationContext.getNavigationContext().l.a(i);
        }
    }

    public void setOfflineBaseUrl(String str) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().t.set(str);
    }

    public void setOnSpeedLimitListener(OnSpeedLimitListener onSpeedLimitListener) {
        this.A = onSpeedLimitListener;
    }

    public void setPlaceOnRouteListener(POIAlongTheRouteChangedListener pOIAlongTheRouteChangedListener) {
        NavigationContext.getNavigationContext().r.a(pOIAlongTheRouteChangedListener);
    }

    public void setPlayAsVoiceCall(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        if (NavigationContext.getNavigationContext().f705n == null) {
            return;
        }
        NavigationContext.getNavigationContext().k().l0.a(com.mappls.sdk.navigation.d.i, Integer.valueOf(z ? 0 : 3));
        NavigationContext.getNavigationContext().f705n.a(z ? 0 : 3);
    }

    public void setPlayDuringPhoneCallEnabled(boolean z) {
        this.d = z;
    }

    public void setRouteIndex(int i) {
        this.x = i;
    }

    public void setRouteReportSummaryResponse(RouteReportSummaryResponse routeReportSummaryResponse) {
        this.o = routeReportSummaryResponse;
    }

    public void setRouteService(IRecalculatedDirection iRecalculatedDirection) {
        this.s = iRecalculatedDirection;
    }

    public void setRouteSettingOptions(u uVar) {
        this.p = uVar;
    }

    public void setRoutingHelper(com.mappls.sdk.navigation.routing.d dVar) {
        this.r = dVar;
    }

    public void setSelectedIndex(int i) {
        DirectionsResponse directionsResponse = this.i;
        if (directionsResponse == null || i >= directionsResponse.routes().size()) {
            return;
        }
        DirectionsResponse directionsResponseBuild = this.i.toBuilder().uuid(this.i.routes().get(i).routeId()).build();
        this.i = directionsResponseBuild;
        this.v = directionsResponseBuild.routes().get(i).routeId();
        this.x = i;
        this.r.b(getNavigationRoute(this.i.routes().get(i)));
    }

    public void setSessionId(String str) {
        this.w = str;
    }

    protected void setShortestRoute(boolean z) {
        s.j jVar;
        RouteOptions.Builder builder;
        Integer num;
        if (NavigationContext.getNavigationContext().k().a.get() == null) {
            return;
        }
        RouteOptions routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get());
        if (z) {
            jVar = NavigationContext.getNavigationContext().k().a;
            builder = routeOptionsFromJson.toBuilder();
            num = 1;
        } else {
            jVar = NavigationContext.getNavigationContext().k().a;
            builder = routeOptionsFromJson.toBuilder();
            num = null;
        }
        jVar.set(builder.routeType(num).build().toJson());
        recalculateRoute();
    }

    public void setShouldPlayNavigationInstructions(boolean z) {
        this.h = z;
    }

    public void setTollEntryExitListener(TollEntryExitListener tollEntryExitListener) {
        NavigationContext.getNavigationContext().l.a(tollEntryExitListener);
    }

    public void setTrackRecordingListener(ITrackRecordingListener iTrackRecordingListener) {
        this.t = iTrackRecordingListener;
    }

    public void setTrafficProbeEnabled(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().T.set(Boolean.valueOf(z));
    }

    public void setUuid(String str) {
        this.v = str;
    }

    public void setVoiceCommandListener(VoiceCommandListener voiceCommandListener) {
        this.a = voiceCommandListener;
    }

    public void showRoadConditionsEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().S.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean showRoadConditionsEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().S.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void showSafetyEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().O.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean showSafetyEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().O.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void showTrafficEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().Q.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean showTrafficEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().Q.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void speakNavigationPrompt(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().q0.set(Boolean.valueOf(z));
        if (z || NavigationContext.getNavigationContext().f705n == null) {
            return;
        }
        NavigationContext.getNavigationContext().f705n.j();
    }

    public boolean speakNavigationPrompt() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().q0.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void speakRoadConditionsEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().R.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean speakRoadConditionsEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().R.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void speakSafetyEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().N.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean speakSafetyEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().N.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    public void speakTrafficEvents(boolean z) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().k().P.set(Boolean.valueOf(z));
        if (!NavigationContext.getNavigationContext().l.q() || NavigationContext.getNavigationContext().l.k() == null) {
            return;
        }
        NavigationContext.getNavigationContext().l.k().settingChanged();
    }

    public boolean speakTrafficEvents() {
        if (this.b != null) {
            return ((Boolean) NavigationContext.getNavigationContext().k().P.get()).booleanValue();
        }
        throw new IllegalStateException("Navigation Helper is not initialized.");
    }

    protected NavigationResponse startNavigation(LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, List<ReportDetails> list2) {
        return startNavigation(latLng, wayPoint, list, str, false);
    }

    protected NavigationResponse startNavigation(LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, boolean z) {
        if (J) {
            return new NavigationResponse(ErrorType.NAVIGATION_ALREADY_REQUESTED, null);
        }
        if (isNavigating()) {
            return new NavigationResponse(ErrorType.NAVIGATION_ALREADY_RUNNING, null);
        }
        J = true;
        MapplsDirections.Builder builderOverview = MapplsDirections.builder().origin(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude())).destination(Point.fromLngLat(wayPoint.getEntryLongitude().doubleValue(), wayPoint.getEntryLatitude().doubleValue())).profile(this.p.c).resource(this.p.d).steps(Boolean.valueOf(this.p.a)).annotations(this.p.f).alternatives(Boolean.valueOf(this.p.b)).deviceId(this.p.e).overview("full");
        this.p.getClass();
        MapplsDirections.Builder builderLessVerbose = builderOverview.lessVerbose(Boolean.FALSE);
        this.p.getClass();
        MapplsDirections.Builder builderRouteType = builderLessVerbose.routeType(0);
        String str2 = this.e;
        if (str2 != null) {
            builderRouteType.baseUrl(str2);
        }
        if (this.p.d.equalsIgnoreCase(DirectionsCriteria.RESOURCE_ROUTE_ETA)) {
            builderRouteType.routeRefresh(Boolean.TRUE);
        }
        this.p.getClass();
        if (list != null) {
            for (int i = 0; i < list.size() - 1; i++) {
                builderRouteType.addWaypoint(Point.fromLngLat(list.get(i).getEntryLongitude().doubleValue(), list.get(i).getEntryLatitude().doubleValue()));
            }
        }
        try {
            ApiResponse<DirectionsResponse> apiResponseExecuteCall = MapplsDirectionManager.newInstance(builderRouteType.build()).executeCall();
            if (apiResponseExecuteCall == null) {
                return new NavigationResponse(ErrorType.UNKNOWN_ERROR, null);
            }
            if (apiResponseExecuteCall.getResponseCode() != 200) {
                return new NavigationResponse(new AuthenticationError(apiResponseExecuteCall.getResponseCode(), apiResponseExecuteCall.getErrorMessage()), null);
            }
            DirectionsResponse response = apiResponseExecuteCall.getResponse();
            if (response == null) {
                return new NavigationResponse(ErrorType.NO_ROUTE_FOUND, null);
            }
            NavigationResponse navigationResponseA = NavigationContext.getNavigationContext().m.a(response, 0, latLng, wayPoint, str);
            if (navigationResponseA.getError() == null) {
                try {
                    startNavigation(response, 0, latLng, wayPoint, list, true, (List<ReportDetails>) null);
                } catch (Exception e) {
                    NavigationLogger.d(e);
                    navigationResponseA = new NavigationResponse(ErrorType.UNKNOWN_ERROR, e);
                }
            }
            J = false;
            if (!z) {
                return navigationResponseA;
            }
            NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().b();
            return navigationResponseA;
        } catch (Exception e2) {
            NavigationLogger.d(e2);
            return new NavigationResponse(ErrorType.UNKNOWN_ERROR, e2);
        }
    }

    protected NavigationResponse startNavigation(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, List<ReportDetails> list2) {
        return startNavigation(directionsResponse, i, latLng, wayPoint, list, str, false, list2);
    }

    protected NavigationResponse startNavigation(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, boolean z, List<ReportDetails> list2) {
        RouteOptions routeOptions;
        if (J) {
            return new NavigationResponse(ErrorType.NAVIGATION_ALREADY_REQUESTED, null);
        }
        if (isNavigating()) {
            return new NavigationResponse(ErrorType.NAVIGATION_ALREADY_RUNNING, null);
        }
        setOdometerSpeed(-1);
        boolean z2 = true;
        J = true;
        if (NavigationContext.getNavigationContext().k().s.get() != MapplsNavigationMode.ONLINE && (NavigationContext.getNavigationContext().k().s.get() != MapplsNavigationMode.AUTOMATIC || !NavigationContext.getNavigationContext().k().a(true))) {
            z2 = false;
        }
        NavigationResponse navigationResponse = (z2 && this.c) ? null : new NavigationResponse(null, null);
        if (z2 && this.c) {
            NavigationLogger.e("!isInternal && isOnline", new Object[0]);
            navigationResponse = NavigationContext.getNavigationContext().m.a(directionsResponse, i, latLng, wayPoint, str);
        }
        NavigationResponse navigationResponse2 = navigationResponse;
        if (navigationResponse2.getError() == null) {
            try {
                startNavigation(directionsResponse, i, latLng, wayPoint, list, true, list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("source", latLng.getLatitude() + "," + latLng.getLongitude());
                if (wayPoint != null) {
                    jSONObject.put(FirebaseAnalytics.Param.DESTINATION, wayPoint.getVisualValue());
                }
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<WayPoint> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getVisualValue());
                    }
                    jSONObject.put("via_point", MapplsUtils.join("|", arrayList.toArray()));
                }
                if (directionsResponse.sessionId() != null) {
                    jSONObject.put("session_id", directionsResponse.sessionId());
                }
                if (directionsResponse.uuid() != null) {
                    jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, directionsResponse.uuid());
                }
                jSONObject.put("routeIndex", i);
                if (directionsResponse.routes().size() > 0 && (routeOptions = directionsResponse.routes().get(0).routeOptions()) != null) {
                    jSONObject.put("resource", routeOptions.resource());
                    jSONObject.put("directionProfile", routeOptions.profile());
                    jSONObject.put("alternatives", routeOptions.alternatives());
                }
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("navigation-started", "navigation-sdk", "0.14.2", jSONObject);
                }
            } catch (JSONException unused) {
            } catch (Exception e) {
                NavigationLogger.d(e);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().handledExceptions("startNavigation", "navigation-sdk", "0.14.2", e);
                }
                navigationResponse2 = new NavigationResponse(ErrorType.UNKNOWN_ERROR, e);
            }
        }
        J = false;
        if (z) {
            NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().b();
        }
        return navigationResponse2;
    }

    protected void startNavigation(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, List<ReportDetails> list2, OnAuthentication onAuthentication) {
        startNavigation(directionsResponse, i, latLng, wayPoint, list, str, false, list2, onAuthentication);
    }

    protected void startNavigation(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, List<WayPoint> list, String str, boolean z, List<ReportDetails> list2, OnAuthentication onAuthentication) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        NavigationContext.getNavigationContext().n().getClass();
        t.a(new c(directionsResponse, i, latLng, wayPoint, list, str, z, list2, onAuthentication), new Void[0]);
    }

    void startRecording() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        com.mappls.sdk.navigation.tracks.a aVar = (com.mappls.sdk.navigation.tracks.a) q.a();
        if (aVar == null) {
            return;
        }
        if (!isRecording() && NavigationContext.getNavigationContext().getLocationProvider().checkGPSEnabled(this.b)) {
            aVar.a(this.b);
        }
        startTrackRecordingHandler();
        ITrackRecordingListener iTrackRecordingListener = this.t;
        if (iTrackRecordingListener != null) {
            iTrackRecordingListener.onRecordingStarted();
        }
    }

    void startTrackRecordingHandler() {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        Handler handler = this.u;
        if (handler == null) {
            this.u = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.u.postDelayed(new a(), 2000L);
    }

    protected void stopNavigation() {
        NavigationContext.getNavigationContext().stopNavigation();
    }

    public void stopRecording() {
        com.mappls.sdk.navigation.tracks.a aVar = (com.mappls.sdk.navigation.tracks.a) q.a();
        if (aVar == null) {
            return;
        }
        if (isRecording()) {
            aVar.e();
        }
        stopTrackRecordingHandler();
        ITrackRecordingListener iTrackRecordingListener = this.t;
        if (iTrackRecordingListener != null) {
            iTrackRecordingListener.onRecordingEnded();
        }
    }

    public void stopTrackRecordingHandler() {
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void updateArrivalDistance(int i) {
        NavigationContext.getNavigationContext().l.a(i);
    }

    public void updateWayPoint(WayPoint wayPoint, int i) {
        if (this.b == null) {
            throw new IllegalStateException("Navigation Helper is not initialized.");
        }
        com.mappls.sdk.navigation.data.a aVar = new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, wayPoint.getVisualName());
        aVar.a(wayPoint.getEntryLatitude().doubleValue());
        aVar.b(wayPoint.getEntryLongitude().doubleValue());
        aVar.b(wayPoint.getSpokenName());
        NavigationContext.getNavigationContext().m().a(new LatLng(wayPoint.getEntryLatitude().doubleValue(), wayPoint.getEntryLongitude().doubleValue()), i, aVar);
        NavigationContext.getNavigationContext().l.a(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d, this.b));
        recalculateRoute();
    }
}
