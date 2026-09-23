package com.mappls.sdk.navigation.routing;

import android.app.Application;
import android.content.Context;
import androidx.mediarouter.media.MediaRouteProviderProtocol;
import androidx.work.WorkRequest;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationLocationProvider;
import com.mappls.sdk.navigation.NavigationService;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.iface.INavigationListener;
import com.mappls.sdk.navigation.iface.INavigationLoggingListener;
import com.mappls.sdk.navigation.iface.TollEntryExitListener;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.util.NavigationSummaryHelper;
import com.mappls.sdk.navigation.w;
import com.mappls.sdk.navigation.x;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.MapplsApiConfiguration;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static boolean E = false;
    private TollEntryExitListener C;
    INavigationLoggingListener a;
    private Context g;
    private String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<LatLng> f712n;
    private NavLocation o;
    private NavLocation p;
    private Thread q;
    private String s;
    private String t;
    private com.mappls.sdk.navigation.d w;
    private s x;
    private com.mappls.sdk.navigation.routing.c y;
    private h z;
    private long b = 0;
    private long c = 0;
    private double d = 0.0d;
    private boolean e = false;
    private LinkedList f = new LinkedList();
    private LinkedList h = new LinkedList();
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private NavigationRoute l = new NavigationRoute("");
    private long r = 0;
    private long u = 0;
    private int v = 0;
    private long A = 0;
    private int B = 0;
    private boolean D = false;

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.h != null) {
                Iterator it2 = d.this.h.iterator();
                while (it2.hasNext()) {
                    INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                    if (iNavigationListener == null) {
                        it2.remove();
                    } else {
                        iNavigationListener.onNavigationCancelled();
                    }
                }
            }
            Iterator it3 = d.this.f.iterator();
            while (it3.hasNext()) {
                c cVar = (c) ((WeakReference) it3.next()).get();
                if (cVar == null) {
                    it3.remove();
                } else {
                    cVar.b();
                }
            }
        }
    }

    final class b implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ NavLocation b;
        final /* synthetic */ boolean c;
        final /* synthetic */ NavigationRoute d;

        b(boolean z, NavLocation navLocation, boolean z2, NavigationRoute navigationRoute) {
            this.a = z;
            this.b = navLocation;
            this.c = z2;
            this.d = navigationRoute;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Boolean] */
        @Override // java.lang.Runnable
        public final void run() {
            DirectionsRoute directionsRoute;
            x xVar = new x();
            xVar.a = Boolean.TRUE;
            if (this.a) {
                NavigationSummaryHelper.Companion.getInstance().navigationStarted(this.b);
            }
            if (d.this.h != null) {
                Iterator it2 = d.this.h.iterator();
                while (it2.hasNext()) {
                    INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                    if (iNavigationListener == null) {
                        it2.remove();
                    } else {
                        if (this.a) {
                            iNavigationListener.onNavigationStarted();
                        }
                        if (d.this.l != null && (directionsRoute = d.this.l.directionsRoute) != null && directionsRoute.geometry() != null) {
                            boolean z = this.c;
                            String strGeometry = directionsRoute.geometry();
                            if (z) {
                                iNavigationListener.onETARefreshed(strGeometry);
                            } else {
                                iNavigationListener.onNewRoute(strGeometry);
                            }
                        }
                        if (NavigationContext.getNavigationContext().getCurrentLocation() != null) {
                            d.this.b(NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().getCurrentLocation()));
                        }
                    }
                }
            }
            Iterator it3 = d.this.f.iterator();
            while (it3.hasNext()) {
                c cVar = (c) ((WeakReference) it3.next()).get();
                if (cVar == null) {
                    it3.remove();
                } else {
                    cVar.a();
                }
            }
            if (((Boolean) xVar.a).booleanValue()) {
                d.this.g.getString(R.string.mappls_new_route_calculated_dist);
                DirectionFormatter.getFormattedDistanceRound(this.d.getWholeDistance());
                if (this.d.getRoutingTime() != 0.0f) {
                    com.mappls.sdk.navigation.util.a.a((int) this.d.getRoutingTime(), NavigationContext.getNavigationContext().a());
                }
                NavigationContext.getNavigationContext().q();
            }
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.routing.d$d, reason: collision with other inner class name */
    private class C0100d extends Thread {
        private final com.mappls.sdk.navigation.routing.b a;
        private boolean b;
        private Thread c;

        public C0100d(com.mappls.sdk.navigation.routing.b bVar, boolean z) {
            super("Calculating route");
            this.a = bVar;
            this.b = z;
            if (bVar.h == null) {
                bVar.h = new com.mappls.sdk.navigation.router.a();
            }
        }

        public final void a(Thread thread) {
            this.c = thread;
        }

        public final boolean a() {
            return this.b;
        }

        public final void b() {
            this.a.h.a = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            synchronized (d.this) {
                d.this.q = this;
            }
            if (this.c != null) {
                while (this.c.isAlive()) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        NavigationLogger.d(e);
                    }
                }
                synchronized (d.this) {
                    d.this.q = this;
                }
            }
            d.this.s = null;
            d.this.t = null;
            com.mappls.sdk.navigation.routing.c cVar = d.this.y;
            com.mappls.sdk.navigation.routing.b bVar = this.a;
            cVar.getClass();
            NavigationRoute navigationRouteA = com.mappls.sdk.navigation.routing.c.a(bVar);
            if (this.a.h.a) {
                synchronized (d.this) {
                    d.this.q = null;
                }
                return;
            }
            if (!navigationRouteA.isCalculated()) {
                this.a.f.getClass();
            }
            NavigationRoute navigationRoute = d.this.l;
            synchronized (d.this) {
                if (navigationRouteA.isCalculated()) {
                    d.this.l = navigationRouteA;
                } else {
                    d dVar = d.this;
                    dVar.v = (dVar.v * 3) / 2;
                    d dVar2 = d.this;
                    dVar2.v = Math.min(dVar2.v, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                }
                d.this.q = null;
            }
            if (navigationRouteA.isCalculated()) {
                d.this.a(navigationRoute, navigationRouteA, this.a.a, false);
            } else {
                if (navigationRouteA.getErrorMessage() != null) {
                    d.this.s = d.this.g.getString(R.string.mappls_error_calculating_route) + ":\n" + navigationRouteA.getErrorMessage();
                    d dVar3 = d.this;
                    dVar3.t = dVar3.g.getString(R.string.mappls_error_calculating_route);
                    NavigationContext.getNavigationContext().a(new g(d.this.s));
                } else {
                    d dVar4 = d.this;
                    dVar4.s = dVar4.g.getString(R.string.mappls_empty_route_calculated);
                    d dVar5 = d.this;
                    dVar5.t = dVar5.g.getString(R.string.mappls_empty_route_calculated);
                    NavigationContext.getNavigationContext().a(new g(d.this.s));
                }
                d.a(d.this, navigationRouteA);
            }
            NavigationContext.getNavigationContext().getNotificationHelper().refreshNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a.NAVIGATION);
            d.this.r = System.currentTimeMillis();
        }
    }

    public d(Context context) {
        this.g = context;
        s sVarK = NavigationContext.getNavigationContext().k();
        this.x = sVarK;
        this.z = new h(this, sVarK);
        this.y = new com.mappls.sdk.navigation.routing.c();
        a(this.x.I0.get());
        a(this.x.e().c());
        MapplsNavigationHelper.getInstance().setRoutingHelper(this);
    }

    private static double a(NavLocation navLocation, NavLocation navLocation2, NavLocation navLocation3) {
        if (navLocation == null || navLocation2 == null || navLocation3 == null) {
            return 0.0d;
        }
        return com.mappls.sdk.navigation.util.d.a(navLocation.getLatitude(), navLocation.getLongitude(), navLocation2.getLatitude(), navLocation2.getLongitude(), navLocation3.getLatitude(), navLocation3.getLongitude());
    }

    private void a(NavLocation navLocation, String str, List list, NavigationRoute navigationRoute, boolean z, boolean z2) {
        if (navLocation == null || str == null) {
            return;
        }
        if ((this.q != null || System.currentTimeMillis() - this.r <= this.v) && !z && z2) {
            return;
        }
        if (System.currentTimeMillis() - this.r < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            this.u++;
        }
        com.mappls.sdk.navigation.routing.b bVar = new com.mappls.sdk.navigation.routing.b();
        bVar.a = navLocation;
        bVar.b = str;
        bVar.c = list;
        if (this.u >= 3) {
            this.u = 0L;
        }
        bVar.g = ((s.l) this.x.B0.get()).a;
        ((Boolean) this.x.B.a(this.w)).booleanValue();
        bVar.f = (com.mappls.sdk.navigation.routing.c.a) this.x.u.get();
        bVar.e = this.w;
        bVar.d = (Application) this.g.getApplicationContext();
        synchronized (this) {
            LinkedList linkedList = this.h;
            if (linkedList != null) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                    if (iNavigationListener == null) {
                        it2.remove();
                    } else {
                        iNavigationListener.onReRoutingRequested();
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("source", navLocation.getLatitude() + "," + navLocation.getLongitude());
                a(jSONObject);
                jSONObject.put("start_point_change", z2);
                jSONObject.put("param_change", z);
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("navigation-reroute-requested", "navigation-sdk", "0.14.2", jSONObject);
                }
            } catch (JSONException unused) {
            }
            NavigationLogger.d("Route is being recalculated", new Object[0]);
            Thread thread = this.q;
            C0100d c0100d = new C0100d(bVar, z);
            this.q = c0100d;
            if (thread != null) {
                c0100d.a(thread);
            }
            this.q.start();
        }
    }

    static void a(d dVar, NavigationRoute navigationRoute) {
        LinkedList linkedList = dVar.h;
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                if (iNavigationListener == null) {
                    it2.remove();
                } else {
                    iNavigationListener.onRerouteFailed(navigationRoute.getErrorCode(), navigationRoute.getErrorMessage());
                }
            }
        }
    }

    public static void a(JSONObject jSONObject) throws JSONException {
        RouteOptions routeOptions;
        ArrayList arrayListE = NavigationContext.getNavigationContext().m().e();
        if (arrayListE.size() > 0) {
            jSONObject.put(FirebaseAnalytics.Param.DESTINATION, ((w.a) arrayListE.get(arrayListE.size() - 1)).e());
        }
        if (arrayListE.size() > 1) {
            List listSubList = arrayListE.subList(0, arrayListE.size() - 1);
            if (listSubList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = listSubList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((w.a) it2.next()).e());
                }
                jSONObject.put("via_point", MapplsUtils.join("|", arrayList.toArray()));
            }
        }
        if (MapplsNavigationHelper.getInstance().getUuid() != null) {
            jSONObject.put(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID, MapplsNavigationHelper.getInstance().getUuid());
        }
        if (MapplsNavigationHelper.getInstance().getSessionId() != null) {
            jSONObject.put("session_id", MapplsNavigationHelper.getInstance().getSessionId());
        }
        jSONObject.put("routeIndex", MapplsNavigationHelper.getInstance().getRouteIndex());
        if (MapplsNavigationHelper.getInstance().getCurrentRoute() == null || (routeOptions = MapplsNavigationHelper.getInstance().getCurrentRoute().routeOptions()) == null) {
            return;
        }
        jSONObject.put("resource", routeOptions.resource());
        jSONObject.put("directionProfile", routeOptions.profile());
        jSONObject.put("alternatives", routeOptions.alternatives());
    }

    private boolean a(float f, NavLocation navLocation) {
        boolean z = false;
        if (this.m != null && this.l.isCalculated()) {
            boolean z2 = this.e;
            if (navLocation.hasBearing()) {
                float bearing = navLocation.getBearing();
                NavLocation nextRouteLocation = this.l.getNextRouteLocation();
                if (Math.abs(com.mappls.sdk.navigation.util.d.a(bearing, navLocation.bearingTo(nextRouteLocation))) <= 135.0d) {
                    this.A = 0L;
                } else if (navLocation.distanceTo(nextRouteLocation) > f) {
                    if (this.A == 0) {
                        this.A = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - this.A > 5000) {
                        NavigationLogger.i("bearingMotion is opposite to bearingRoute", new Object[0]);
                        z = true;
                    }
                }
            } else {
                z = z2;
            }
            this.e = z;
        }
        return z;
    }

    private boolean b(float f, NavLocation navLocation) {
        WayPoint wayPoint;
        List<NavLocation> immutableAllLocations = this.l.getImmutableAllLocations();
        int i = this.l.currentRoute;
        while (i + 1 < immutableAllLocations.size()) {
            double dDistanceTo = navLocation.distanceTo(immutableAllLocations.get(i));
            if (i > 0) {
                dDistanceTo = a(navLocation, immutableAllLocations.get(i - 1), immutableAllLocations.get(i));
            }
            boolean z = dDistanceTo >= 250.0d;
            int i2 = z ? 15 : 8;
            double d = Double.POSITIVE_INFINITY;
            int i3 = i;
            int i4 = i3;
            while (i2 > 0) {
                int i5 = i3 + 1;
                if (i5 >= immutableAllLocations.size()) {
                    break;
                }
                double dA = a(navLocation, immutableAllLocations.get(i3), immutableAllLocations.get(i5));
                if (dA < d) {
                    d = dA;
                    i4 = i3;
                }
                i2--;
                i3 = i5;
            }
            int i6 = i4 + 1;
            double dA2 = a(navLocation, immutableAllLocations.get(i4), immutableAllLocations.get(i6));
            if (!z) {
                if (dA2 >= dDistanceTo && dA2 >= 10.0d) {
                    break;
                }
                if (dDistanceTo <= f) {
                    if (!navLocation.hasBearing() && this.p == null) {
                        break;
                    }
                    float fBearingTo = navLocation.bearingTo(immutableAllLocations.get(i));
                    float fBearingTo2 = immutableAllLocations.get(i4).bearingTo(immutableAllLocations.get(i6));
                    double bearing = navLocation.hasBearing() ? navLocation.getBearing() : this.p.bearingTo(navLocation);
                    double d2 = fBearingTo;
                    double dAbs = Math.abs(com.mappls.sdk.navigation.util.d.a(bearing, d2));
                    double d3 = fBearingTo2;
                    double dAbs2 = Math.abs(com.mappls.sdk.navigation.util.d.a(bearing, d3));
                    double dAbs3 = Math.abs(com.mappls.sdk.navigation.util.d.a(d2, d3));
                    boolean z2 = MapplsNavigationHelper.getInstance().getOdometerSpeed() >= 0 || ((int) (((double) navLocation.getSpeed()) * 3.6d)) >= 7;
                    if (i > 0 && dAbs3 > 40.0d && !z2) {
                        NavigationLogger.d("Bearing deltas : " + dAbs2, new Object[0]);
                        break;
                    }
                    if (dAbs <= dAbs2) {
                        break;
                    }
                    NavigationLogger.d("Processed point bearing deltas : " + dAbs + StringUtils.SPACE + dAbs2, new Object[0]);
                } else {
                    NavigationLogger.d("Processed by distance : " + dA2 + StringUtils.SPACE + dDistanceTo, new Object[0]);
                }
                this.l.updateCurrentRoute(i6);
                NavigationContext.getNavigationContext().getNotificationHelper().refreshNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a.NAVIGATION);
                i = i6;
            } else {
                if (dA2 >= dDistanceTo) {
                    break;
                }
                NavigationLogger.d("Processed by distance : (new) " + dA2 + " (old) " + dDistanceTo, new Object[0]);
                this.l.updateCurrentRoute(i6);
                NavigationContext.getNavigationContext().getNotificationHelper().refreshNotification(com.mappls.sdk.navigation.notifications.a.EnumC0097a.NAVIGATION);
                i = i6;
            }
        }
        this.l.getIntermediatePointsToPass();
        if (this.l.getIntermediatePointsToPass() > 0 && this.l.getDistanceToNextIntermediate(this.p) < c() && !this.j) {
            NavigationContext.getNavigationContext().a(new g(this.g.getString(R.string.mappls_arrived_at_intermediate_point)));
            this.l.passIntermediatePoint();
            w wVarM = NavigationContext.getNavigationContext().m();
            String strD = "";
            List<LatLng> list = this.f712n;
            if (list == null || list.isEmpty()) {
                wayPoint = null;
            } else {
                LatLng latLngRemove = this.f712n.remove(0);
                ArrayList arrayListD = wVarM.d();
                int i7 = 0;
                while (true) {
                    if (i7 >= arrayListD.size()) {
                        i7 = -1;
                        wayPoint = null;
                        break;
                    }
                    if (((w.a) arrayListD.get(i7)).a != null && com.mappls.sdk.navigation.util.d.a(((w.a) arrayListD.get(i7)).a, latLngRemove) < 5.0d) {
                        ((w.a) arrayListD.get(i7)).a();
                        strD = ((w.a) arrayListD.get(i7)).d();
                        wayPoint = new WayPoint(((w.a) arrayListD.get(i7)).b(), ((w.a) arrayListD.get(i7)).c(), ((w.a) arrayListD.get(i7)).getLatitude(), ((w.a) arrayListD.get(i7)).getLongitude(), ((w.a) arrayListD.get(i7)).a(), ((w.a) arrayListD.get(i7)).d());
                        wayPoint.setIndexOnPath(((w.a) arrayListD.get(i7)).c);
                        break;
                    }
                    i7++;
                }
                if (i7 >= 0) {
                    wVarM.a(i7, false);
                }
            }
            if (this.i) {
                if (MapplsNavigationHelper.getInstance().isShouldPlayNavigationInstructions()) {
                    this.z.c(strD);
                }
                LinkedList linkedList = this.h;
                if (linkedList != null) {
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                        if (iNavigationListener == null) {
                            it2.remove();
                        } else {
                            iNavigationListener.onWayPointReached(wayPoint);
                        }
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    NavigationRoute navigationRoute = this.l;
                    if (navigationRoute != null && !navigationRoute.isEmpty() && this.l.getParams() != null) {
                        com.mappls.sdk.navigation.routing.b params = this.l.getParams();
                        if (params.a != null) {
                            jSONObject.put("source", params.a.getLatitude() + "," + params.a.getLongitude() + ";UserLocation");
                        }
                        a(jSONObject);
                        if (wayPoint != null) {
                            jSONObject.put("via_point_reached_index", wayPoint.getIndex());
                        }
                    }
                    if (MapplsLMSManager.isInitialised()) {
                        MapplsLMSManager.getInstance().add("navigation-via-point-reached", "navigation-sdk", "0.14.2", jSONObject);
                    }
                } catch (JSONException unused) {
                }
            }
            while (this.f712n != null && this.l.getIntermediatePointsToPass() < this.f712n.size()) {
                this.f712n.remove(0);
            }
        }
        immutableAllLocations.get(immutableAllLocations.size() - 1);
        if (i <= immutableAllLocations.size() - 15 || this.l.getDistanceToFinish(navLocation) >= c() || this.j) {
            return false;
        }
        NavigationContext.getNavigationContext().a(new g(this.g.getString(R.string.mappls_arrived_at_destination)));
        w.a aVarF = NavigationContext.getNavigationContext().m().f();
        if (aVarF != null) {
            aVarF.a();
        }
        a((String) null, (List<LatLng>) null, false);
        NavigationContext.getNavigationContext().a(new f(this));
        synchronized (this) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("event_name", "Finish");
                NavigationRoute navigationRoute2 = this.l;
                if (navigationRoute2 != null && !navigationRoute2.isEmpty() && this.l.getParams() != null) {
                    com.mappls.sdk.navigation.routing.b params2 = this.l.getParams();
                    if (params2.a != null) {
                        jSONObject2.put("source", params2.a.getLatitude() + "," + params2.a.getLongitude() + ";UserLocation");
                    }
                    a(jSONObject2);
                }
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("navigation-finished", "navigation-sdk", "0.14.2", jSONObject2);
                }
            } catch (JSONException unused2) {
            }
            NavigationContext.getNavigationContext().i().b();
            NavigationContext.getNavigationContext().g().a();
            NavigationSummaryHelper.Companion.getInstance().navigationFinished();
            this.j = false;
            if (MapplsNavigationHelper.getInstance().isShouldPlayNavigationInstructions()) {
                this.z.b();
            }
            NavigationContext.getNavigationContext().a(new e(this));
        }
        return true;
    }

    public static boolean p() {
        return E;
    }

    public final NavLocation a(NavLocation navLocation, boolean z) {
        return a(navLocation, z, this.l, false);
    }

    public final com.mappls.sdk.navigation.d a() {
        return this.w;
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void a(NavLocation navLocation) {
        this.p = navLocation;
    }

    public final void a(com.mappls.sdk.navigation.d dVar) {
        this.w = dVar;
        this.z.j();
    }

    public final void a(INavigationLoggingListener iNavigationLoggingListener) {
        this.a = iNavigationLoggingListener;
    }

    public final void a(TollEntryExitListener tollEntryExitListener) {
        this.C = tollEntryExitListener;
    }

    public final void a(NavigationRoute navigationRoute) {
        a(this.o, navigationRoute, true);
    }

    public final synchronized void a(String str, ArrayList arrayList, NavLocation navLocation) {
        NavigationRoute navigationRoute = this.l;
        a(str, (List<LatLng>) arrayList, false);
        this.l = navigationRoute;
        a(navLocation, false, navigationRoute, true);
        NavigationContext.getNavigationContext().o().a(this.l);
    }

    public final synchronized void a(String str, List<LatLng> list, boolean z) {
        this.l = new NavigationRoute("");
        E = false;
        this.v = 0;
        NavigationContext.getNavigationContext().o().a(this.l);
        if (z) {
            NavigationSummaryHelper.getInstance().navigationFinished();
            NavigationContext.getNavigationContext().i().a();
            NavigationContext.getNavigationContext().a(new a());
        }
        this.m = str;
        this.f712n = list;
        Thread thread = this.q;
        if (thread instanceof C0100d) {
            ((C0100d) thread).b();
        }
        if (str == null) {
            this.x.s0.set(Boolean.FALSE);
            this.x.t0.set(null);
            this.o = null;
            a(false);
        }
    }

    public final void a(ArrayList arrayList) {
        LinkedList linkedList = this.h;
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                if (iNavigationListener == null) {
                    it2.remove();
                } else {
                    iNavigationListener.onAlternateRoutesUpdate(arrayList);
                }
            }
        }
    }

    public final void a(List<DirectionsRoute> list) {
        LinkedList linkedList = this.h;
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                INavigationListener iNavigationListener = (INavigationListener) ((WeakReference) it2.next()).get();
                if (iNavigationListener == null) {
                    it2.remove();
                } else {
                    iNavigationListener.onBetterRouteAvailable(list);
                }
            }
        }
    }

    public final void a(boolean z) {
        this.i = z;
        MapplsApiConfiguration.getInstance().setNavigating(z);
        this.k = false;
        if (z) {
            NavigationContext navigationContext = NavigationContext.getNavigationContext();
            int i = NavigationService.o;
            navigationContext.a(1, 0);
            return;
        }
        NavigationService navigationServiceF = NavigationContext.getNavigationContext().f();
        if (navigationServiceF != null) {
            Context context = this.g;
            int i2 = NavigationService.o;
            navigationServiceF.a(context, 1);
            MapplsApiConfiguration.getInstance().setLocation(null);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().setCurrentLocation(null);
            }
        }
    }

    public final Context b() {
        return this.g;
    }

    public final synchronized void b(INavigationListener iNavigationListener) {
        Iterator it2 = this.h.iterator();
        while (it2.hasNext()) {
            INavigationListener iNavigationListener2 = (INavigationListener) ((WeakReference) it2.next()).get();
            if (iNavigationListener2 == null || iNavigationListener == iNavigationListener2) {
                it2.remove();
                return;
            }
        }
    }

    public final void b(NavigationRoute navigationRoute) {
        a(this.o, navigationRoute, false);
    }

    public final void b(boolean z) {
        this.j = z;
    }

    public final float c() {
        int iC = this.B;
        if (iC <= 0) {
            iC = this.x.e().c();
        }
        return ((Float) this.x.k.get()).floatValue() * iC;
    }

    public final List<NavLocation> d() {
        return this.l.getImmutableAllLocations();
    }

    public final com.mappls.sdk.navigation.router.b e() {
        return this.l.getCurrentSegmentResult();
    }

    public final NavLocation f() {
        return this.o;
    }

    public final String g() {
        return this.t;
    }

    public final int h() {
        return this.l.getDistanceToFinish(this.p);
    }

    public final int i() {
        return this.l.getDistanceToNextIntermediate(this.p);
    }

    public final int j() {
        return this.l.getLeftTime(this.p);
    }

    public final NavigationRoute k() {
        return this.l;
    }

    public final double l() {
        NavigationRoute navigationRoute = this.l;
        if (navigationRoute == null || navigationRoute.getImmutableAllDirections().size() < 2) {
            return 0.0d;
        }
        NavigationRoute navigationRoute2 = this.l;
        if (navigationRoute2.currentRoute == 0) {
            return 0.0d;
        }
        List<NavLocation> immutableAllLocations = navigationRoute2.getImmutableAllLocations();
        return a(this.p, immutableAllLocations.get(this.l.currentRoute - 1), immutableAllLocations.get(this.l.currentRoute));
    }

    public final s m() {
        return this.x;
    }

    public final TollEntryExitListener n() {
        return this.C;
    }

    public final h o() {
        return this.z;
    }

    public final boolean q() {
        return this.i;
    }

    public final boolean r() {
        return this.k;
    }

    public final boolean s() {
        return this.q instanceof C0100d;
    }

    public final boolean t() {
        return this.l.isCalculated();
    }

    public final boolean u() {
        return this.j;
    }

    public final void v() {
        a(this.m, this.f712n, false);
        a(this.p, this.m, this.f712n, this.l, true, false);
    }

    public final void w() {
        this.k = true;
        NavigationService navigationServiceF = NavigationContext.getNavigationContext().f();
        if (navigationServiceF != null) {
            Context context = this.g;
            int i = NavigationService.o;
            navigationServiceF.a(context, 1);
        }
    }

    public final boolean x() {
        int odometerSpeed = MapplsNavigationHelper.getInstance().getOdometerSpeed();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.r;
        if (odometerSpeed < 0) {
            return jCurrentTimeMillis > 60000;
        }
        return jCurrentTimeMillis > 60000 && MapplsNavigationHelper.getInstance().getOdometerSpeed() > 0;
    }

    public final synchronized void a(INavigationListener iNavigationListener) {
        this.h.add(new WeakReference(iNavigationListener));
        if (iNavigationListener != null) {
            if (this.i) {
                iNavigationListener.onNavigationStarted();
            }
            if (this.q instanceof C0100d) {
                iNavigationListener.onReRoutingRequested();
            }
            DirectionsRoute directionsRoute = this.l.directionsRoute;
            if (directionsRoute != null && directionsRoute.geometry() != null) {
                iNavigationListener.onNewRoute(this.l.directionsRoute.geometry());
            }
            NavLocation lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
            if (lastKnownLocation == null && NavigationContext.getNavigationContext().d != null) {
                lastKnownLocation = NavigationLocationProvider.convertLocation(NavigationContext.getNavigationContext().d);
            }
            b(lastKnownLocation);
        }
    }

    public final synchronized NavigationRoute.a a(NavigationRoute.a aVar, boolean z) {
        NavigationRoute.a nextRouteDirectionInfo;
        nextRouteDirectionInfo = this.l.getNextRouteDirectionInfo(aVar, this.o, z);
        if (nextRouteDirectionInfo != null) {
            h hVar = this.z;
            float f = nextRouteDirectionInfo.b;
            NavLocation navLocation = this.o;
            hVar.a((navLocation == null || !navLocation.hasSpeed()) ? hVar.c : navLocation.getSpeed(), f, hVar.k, 0.0f);
        }
        return nextRouteDirectionInfo;
    }

    public final synchronized NavigationRoute.a a(NavigationRoute.a aVar, NavigationRoute.a aVar2) {
        NavigationRoute.a nextRouteDirectionInfoAfter;
        nextRouteDirectionInfoAfter = this.l.getNextRouteDirectionInfoAfter(aVar, aVar2, true);
        if (nextRouteDirectionInfoAfter != null) {
            h hVar = this.z;
            hVar.a(hVar.c, nextRouteDirectionInfoAfter.b, hVar.k, 0.0f);
        }
        return nextRouteDirectionInfoAfter;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x026f  */
    /* JADX WARN: Code duplicated, block: B:120:0x027f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0292  */
    /* JADX WARN: Code duplicated, block: B:125:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:128:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:130:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:132:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:135:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:138:0x0303  */
    /* JADX WARN: Code duplicated, block: B:140:0x030e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0310  */
    /* JADX WARN: Code duplicated, block: B:144:0x031f  */
    /* JADX WARN: Code duplicated, block: B:147:0x034e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x0350  */
    /* JADX WARN: Code duplicated, block: B:152:0x036a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0374  */
    /* JADX WARN: Code duplicated, block: B:161:0x038e A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:164:0x03c3 A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03eb A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:172:0x03f6 A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:173:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:175:0x03fd A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:177:0x0408 A[Catch: Exception -> 0x0424, TryCatch #1 {Exception -> 0x0424, blocks: (B:159:0x038a, B:161:0x038e, B:162:0x03bd, B:164:0x03c3, B:166:0x03d1, B:167:0x03d5, B:168:0x03d9, B:170:0x03eb, B:172:0x03f6, B:178:0x040c, B:175:0x03fd, B:177:0x0408), top: B:260:0x038a }] */
    /* JADX WARN: Code duplicated, block: B:205:0x051c  */
    /* JADX WARN: Code duplicated, block: B:209:0x0532  */
    /* JADX WARN: Code duplicated, block: B:212:0x053d A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x054d A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x060c A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x062a  */
    /* JADX WARN: Code duplicated, block: B:231:0x062e A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0642 A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x064d A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x067c A[Catch: Exception -> 0x0694, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0687 A[Catch: Exception -> 0x0694, TRY_LEAVE, TryCatch #0 {Exception -> 0x0694, blocks: (B:210:0x0537, B:212:0x053d, B:213:0x0547, B:215:0x054d, B:216:0x0557, B:218:0x05cd, B:220:0x05db, B:222:0x05ed, B:224:0x060c, B:227:0x061a, B:231:0x062e, B:232:0x0633, B:233:0x063a, B:235:0x0642, B:236:0x0647, B:238:0x064d, B:239:0x0659, B:241:0x067c, B:243:0x0687), top: B:258:0x0537 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x069e  */
    /* JADX WARN: Code duplicated, block: B:265:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x0382 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v125, types: [com.mappls.sdk.navigation.iface.TollEntryExitListener] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.mappls.android.lms.MapplsLMSManager] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v28, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v35, types: [com.mappls.sdk.navigation.iface.OnSpeedLimitListener] */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    private com.mappls.sdk.navigation.NavLocation a(com.mappls.sdk.navigation.NavLocation r33, boolean r34, com.mappls.sdk.navigation.routing.NavigationRoute r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 1734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mappls.sdk.navigation.routing.d.a(com.mappls.sdk.navigation.NavLocation, boolean, com.mappls.sdk.navigation.routing.NavigationRoute, boolean):com.mappls.sdk.navigation.NavLocation");
    }

    public final void b(NavLocation navLocation) {
        if (this.i || ((this.x.m() == null && this.j) || NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().a())) {
            a(navLocation, false);
        }
    }

    public final void a(NavLocation navLocation, NavigationRoute navigationRoute, boolean z) {
        DirectionsRoute directionsRoute;
        NavigationLogger.d("fromRouteRefresh %s", Boolean.valueOf(z));
        try {
            RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).profile();
        } catch (Exception unused) {
        }
        NavigationRoute navigationRoute2 = this.l;
        this.l = navigationRoute;
        if (navigationRoute != null && (directionsRoute = navigationRoute.directionsRoute) != null && directionsRoute.geometry() != null) {
            LineString.fromPolyline((String) Objects.requireNonNull(navigationRoute.directionsRoute.geometry()), 6);
        }
        this.p = navLocation;
        a(navigationRoute2, navigationRoute, navLocation, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    public void a(NavigationRoute navigationRoute, NavigationRoute navigationRoute2, NavLocation navLocation, boolean z) {
        NavLocation navLocation2;
        boolean z2;
        boolean zIsCalculated = navigationRoute.isCalculated();
        boolean z3 = !zIsCalculated;
        if (this.i) {
            NavLocation navLocation3 = this.p;
            if (navLocation3 == null) {
                navLocation3 = navLocation;
            }
            List<NavLocation> immutableAllLocations = navigationRoute2.getImmutableAllLocations();
            if (immutableAllLocations == null || immutableAllLocations.isEmpty()) {
                z2 = false;
            } else {
                int i = navigationRoute2.currentRoute;
                double d = Double.POSITIVE_INFINITY;
                int i2 = 15;
                int i3 = i;
                while (i2 > 0) {
                    int i4 = i + 1;
                    if (i4 >= immutableAllLocations.size()) {
                        break;
                    }
                    double dA = a(navLocation3, immutableAllLocations.get(i), immutableAllLocations.get(i4));
                    if (dA < d) {
                        i3 = i;
                        d = dA;
                    }
                    i2--;
                    i = i4;
                }
                int i5 = i3 + 1;
                if (i5 < immutableAllLocations.size()) {
                    NavLocation navLocation4 = immutableAllLocations.get(i5);
                    if (navLocation3 == null || !navLocation3.hasBearing() || navLocation4 == null) {
                        z2 = false;
                    } else {
                        if (Math.abs(com.mappls.sdk.navigation.util.d.a(navLocation3.getBearing(), navLocation3.bearingTo(navLocation4))) > 60.0d) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    int iMin = 3000;
                    if (!z2) {
                        int iMax = Math.max(3000, (this.v * 3) / 2);
                        this.v = iMax;
                        iMin = Math.min(iMax, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                    }
                    this.v = iMin;
                } else {
                    z2 = false;
                }
            }
            if (!z2 || !zIsCalculated) {
                this.e = false;
                NavigationLogger.i("Route recalculated", new Object[0]);
                if (!z && MapplsNavigationHelper.getInstance().isShouldPlayNavigationInstructions()) {
                    this.z.a(NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation());
                }
                if (zIsCalculated) {
                    NavigationContext.getNavigationContext().i().d();
                    if (this.l.getImmutableAllLocations().size() > 0) {
                        NavigationContext.getNavigationContext().g().a(this.l.getImmutableAllLocations().get(this.l.getImmutableAllLocations().size() - 1));
                    }
                } else {
                    this.b = 0L;
                    this.c = 0L;
                    NavigationContext.getNavigationContext().i().e();
                }
            }
            navLocation2 = navLocation3;
        } else {
            navLocation2 = navLocation;
        }
        NavigationContext.getNavigationContext().o().a(navigationRoute2);
        NavigationContext.getNavigationContext().a(new b(z3, navLocation2, z, navigationRoute2));
    }

    public final void a(long j) {
        if (j >= 10) {
            this.x.r.c().set(Float.valueOf(j));
        } else {
            this.x.r.d();
        }
    }

    public final void a(NavigationRoute navigationRoute, DirectionsRoute directionsRoute) {
        MapplsNavigationHelper.getInstance().setDirectionsResponse(MapplsNavigationHelper.getInstance().getDirectionsResponse().toBuilder().uuid(directionsRoute.routeId()).build());
        MapplsNavigationHelper.getInstance().setUuid(directionsRoute.routeId());
        MapplsNavigationHelper.getInstance().setRouteIndex(1);
        NavigationContext.getNavigationContext().k().a.set(RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get()).toBuilder().requestUuid(directionsRoute.routeId()).build().toJson());
        if (navigationRoute != null) {
            a(this.o, navigationRoute, false);
        }
    }
}
