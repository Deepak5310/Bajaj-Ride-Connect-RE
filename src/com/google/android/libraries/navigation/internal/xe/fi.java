package com.google.android.libraries.navigation.internal.xe;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Spanned;
import android.util.DisplayMetrics;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.geo.navcore.ui.header.views.MultiIconView;
import com.google.android.libraries.mapsplatform.turnbyturn.model.Lane;
import com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.mapsplatform.turnbyturn.model.StepInfo;
import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.CustomRoutesOptions;
import com.google.android.libraries.navigation.DisplayOptions;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.NavigationTransactionRecorder;
import com.google.android.libraries.navigation.NavigationUpdatesOptions;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RouteInfo;
import com.google.android.libraries.navigation.RouteSegment;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.Simulator;
import com.google.android.libraries.navigation.SpeedAlertOptions;
import com.google.android.libraries.navigation.SpeedAlertSeverity;
import com.google.android.libraries.navigation.SpeedingListener;
import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.android.libraries.navigation.Waypoint;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.ip;
import com.google.android.libraries.navigation.internal.adr.it;
import com.google.android.libraries.navigation.internal.adr.iu;
import com.google.android.libraries.navigation.internal.adr.jw;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.afl.lo;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fi implements Navigator {
    public static final Object a = new Object();
    public static final ei b = new ey();
    private ae A;
    private final com.google.android.libraries.navigation.environment.v B;
    private final com.google.android.libraries.geo.navcore.service.base.q C;
    public final com.google.android.libraries.navigation.internal.xf.k c;
    public final com.google.android.libraries.navigation.internal.vp.g d;
    public final Context e;
    public final fl k;
    public final ga l;
    private final com.google.android.libraries.navigation.internal.vw.j o;
    private final com.google.android.libraries.navigation.internal.uu.q p;
    private final com.google.android.libraries.navigation.internal.xd.a s;
    private final com.google.android.libraries.navigation.internal.xh.c t;
    private final com.google.android.libraries.navigation.internal.wd.g u;
    private final gf v;
    private final String w;
    private final com.google.android.libraries.navigation.internal.fz.d x;
    private final Executor y;
    private Intent z;
    public final Set f = mp.i();
    public final Set g = mp.i();
    public final Set h = mp.i();
    public final Set i = mp.i();
    public final Set j = mp.i();
    private final ConcurrentHashMap q = new ConcurrentHashMap();
    private final ConcurrentHashMap r = new ConcurrentHashMap();
    public List m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ag f650n = new ag();

    public fi(com.google.android.libraries.navigation.internal.vw.j jVar, com.google.android.libraries.navigation.internal.xf.k kVar, com.google.android.libraries.navigation.environment.v vVar, com.google.android.libraries.navigation.internal.vp.g gVar, Context context, com.google.android.libraries.navigation.internal.xd.a aVar, com.google.android.libraries.navigation.internal.uu.q qVar, com.google.android.libraries.navigation.internal.wd.g gVar2, gf gfVar, fl flVar, ga gaVar, com.google.android.libraries.navigation.internal.xh.c cVar, String str, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.geo.navcore.service.base.q qVar2, Executor executor) {
        this.o = jVar;
        this.c = kVar;
        this.B = vVar;
        this.d = gVar;
        this.e = context;
        this.s = aVar;
        this.p = qVar;
        this.u = gVar2;
        this.v = gfVar;
        this.t = cVar;
        this.k = flVar;
        this.l = gaVar;
        this.w = str;
        this.C = qVar2;
        this.x = dVar;
        this.y = executor;
    }

    public static boolean l() {
        return com.google.android.libraries.navigation.internal.afw.m.c();
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void a(Intent intent) {
        try {
            this.z = intent;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addArrivalListener(Navigator.ArrivalListener arrivalListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.at);
            com.google.android.libraries.navigation.internal.abf.t.c(arrivalListener, "Listener must be non-null");
            if (this.f.isEmpty()) {
                this.o.s = new fb(new Navigator.ArrivalListener() { // from class: com.google.android.libraries.navigation.internal.xe.eo
                    @Override // com.google.android.libraries.navigation.Navigator.ArrivalListener
                    public final void onArrival(ArrivalEvent arrivalEvent) {
                        for (Navigator.ArrivalListener arrivalListener2 : this.a.f) {
                            if (arrivalListener2 != null) {
                                arrivalListener2.onArrival(arrivalEvent);
                            }
                        }
                    }
                });
            }
            this.f.add(arrivalListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addNavigationSessionListener(Navigator.NavigationSessionListener navigationSessionListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ax);
            com.google.android.libraries.navigation.internal.abf.t.c(navigationSessionListener, "Listener must be non-null");
            if (this.j.isEmpty() && navigationSessionListener != null) {
                this.o.w = new fg(new Navigator.NavigationSessionListener() { // from class: com.google.android.libraries.navigation.internal.xe.eq
                    @Override // com.google.android.libraries.navigation.Navigator.NavigationSessionListener
                    public final void onNewNavigationSession() {
                        for (Navigator.NavigationSessionListener navigationSessionListener2 : this.a.j) {
                            if (navigationSessionListener2 != null) {
                                navigationSessionListener2.onNewNavigationSession();
                            }
                        }
                    }
                });
            }
            this.j.add(navigationSessionListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addRemainingTimeOrDistanceChangedListener(int i, int i2, Navigator.RemainingTimeOrDistanceChangedListener remainingTimeOrDistanceChangedListener) {
        try {
            boolean z = true;
            com.google.android.libraries.navigation.internal.abf.t.a(i >= 0, String.format("negative time change threshold: %s", Integer.valueOf(i)));
            if (i2 < 0) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.abf.t.a(z, String.format("negative distance change threshold: %s", Integer.valueOf(i2)));
            com.google.android.libraries.navigation.internal.abf.t.c(remainingTimeOrDistanceChangedListener, "Listener must be non-null");
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ay);
            if (this.q.containsKey(remainingTimeOrDistanceChangedListener)) {
                return;
            }
            fc fcVar = new fc(remainingTimeOrDistanceChangedListener);
            this.q.put(remainingTimeOrDistanceChangedListener, fcVar);
            this.o.y(i, i2, fcVar);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addReroutingListener(Navigator.ReroutingListener reroutingListener) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(reroutingListener, "Listener must be non-null");
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ag);
            if (this.r.containsKey(reroutingListener)) {
                return;
            }
            fd fdVar = new fd(reroutingListener);
            this.r.put(reroutingListener, fdVar);
            this.o.e().c.add(fdVar);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addRouteChangedListener(Navigator.RouteChangedListener routeChangedListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.az);
            com.google.android.libraries.navigation.internal.abf.t.c(routeChangedListener, "Listener must be non-null");
            if (this.g.isEmpty()) {
                this.o.A(new fe(new Navigator.RouteChangedListener() { // from class: com.google.android.libraries.navigation.internal.xe.er
                    @Override // com.google.android.libraries.navigation.Navigator.RouteChangedListener
                    public final void onRouteChanged() {
                        for (Navigator.RouteChangedListener routeChangedListener2 : this.a.g) {
                            if (routeChangedListener2 != null) {
                                routeChangedListener2.onRouteChanged();
                            }
                        }
                    }
                }));
            }
            this.g.add(routeChangedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void addTrafficUpdatedListener(Navigator.TrafficUpdatedListener trafficUpdatedListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aD);
            com.google.android.libraries.navigation.internal.abf.t.c(trafficUpdatedListener, "Listener must be non-null");
            if (this.i.isEmpty() && trafficUpdatedListener != null) {
                this.o.v = new fh(new Navigator.TrafficUpdatedListener() { // from class: com.google.android.libraries.navigation.internal.xe.en
                    @Override // com.google.android.libraries.navigation.Navigator.TrafficUpdatedListener
                    public final void onTrafficUpdated() {
                        for (Navigator.TrafficUpdatedListener trafficUpdatedListener2 : this.a.i) {
                            if (trafficUpdatedListener2 != null) {
                                trafficUpdatedListener2.onTrafficUpdated();
                            }
                        }
                    }
                });
            }
            this.i.add(trafficUpdatedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final com.google.android.libraries.navigation.internal.nt.p b() {
        try {
            return this.o.e;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    final com.google.android.libraries.navigation.internal.vv.a c() {
        com.google.android.libraries.navigation.internal.vv.a aVarA;
        synchronized (d()) {
            aVarA = this.o.a();
        }
        return aVarA;
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized void clearDestinations() {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ai);
            this.o.j();
            ae aeVar = this.A;
            if (aeVar != null) {
                aeVar.c();
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized Waypoint continueToNextDestination() {
        com.google.android.libraries.navigation.internal.bp.ck ckVarB;
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ak);
            ckVarB = this.o.b();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
        return ckVarB == null ? null : new Waypoint(ckVarB);
    }

    final Object d() {
        return this.x.K().j ? this : this.o;
    }

    public final void e(fa faVar) {
        try {
            if (this.h.isEmpty()) {
                this.o.u = new ff(new fa() { // from class: com.google.android.libraries.navigation.internal.xe.ep
                    @Override // com.google.android.libraries.navigation.internal.xe.fa
                    public final void a(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
                        for (fa faVar2 : this.a.h) {
                            if (faVar2 != null) {
                                faVar2.a(bgVar);
                            }
                        }
                    }
                });
            }
            this.h.add(faVar);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<RouteInfo> fetchRouteInfo(Waypoint waypoint, RoutingOptions routingOptions) {
        try {
            m mVarE = m.e();
            com.google.android.libraries.navigation.internal.aac.az.o(this.t.b(), new eu(this, waypoint, routingOptions, mVarE), this.y);
            return mVarE;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final RouteSegment getCurrentRouteSegment() {
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.al);
                com.google.android.libraries.navigation.internal.vv.b bVarC = this.o.c();
                com.google.android.libraries.navigation.internal.vv.a aVarA = this.o.a();
                if (bVarC != null && aVarA != null) {
                    com.google.android.libraries.navigation.internal.bp.bg bgVar = aVarA.e;
                    if (bgVar != null && bgVar.u != null) {
                        ii iiVar = bgVar.u;
                        if ((iiVar.b & 16) == 0) {
                            return new fz(bVarC);
                        }
                        int i = bgVar.i();
                        return new fz(bVarC, bc.a(iiVar, i, i - this.o.d().b));
                    }
                    return new fz(bVarC);
                }
                return null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final TimeAndDistance getCurrentTimeAndDistance() {
        TimeAndDistance timeAndDistance;
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.am);
                com.google.android.libraries.navigation.internal.vv.c cVarD = this.o.d();
                timeAndDistance = cVarD == null ? null : new TimeAndDistance(cVarD);
            }
            return timeAndDistance;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final List<RouteSegment> getRouteSegments() {
        ArrayList arrayList;
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.an);
                List listF = this.o.f();
                arrayList = new ArrayList();
                Iterator it2 = listF.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new fz((com.google.android.libraries.navigation.internal.vv.b) it2.next()));
                }
            }
            return arrayList;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final Simulator getSimulator() {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ao);
            com.google.android.libraries.navigation.internal.vw.j jVar = this.o;
            com.google.android.libraries.navigation.internal.yx.ar.q(jVar.f);
            return new ge(jVar.f, this.c, this.s, this.k, this.l);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final List<TimeAndDistance> getTimeAndDistanceList() {
        ArrayList arrayList;
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.ap);
                List listG = this.o.g();
                arrayList = new ArrayList();
                Iterator it2 = listG.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new TimeAndDistance((com.google.android.libraries.navigation.internal.vv.c) it2.next()));
                }
            }
            return arrayList;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final List<LatLng> getTraveledRoute() {
        List<LatLng> listD;
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.aq);
                listD = z.d(this.o.h());
            }
            return listD;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final void h(fa faVar) {
        try {
            this.h.remove(faVar);
            if (this.h.isEmpty()) {
                this.o.u = null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final void i(List list, boolean z) throws NavigationTransactionRecorder.TransactionException {
        if (z) {
            ao.a(list, true);
        }
        com.google.android.libraries.navigation.internal.vw.j jVar = this.o;
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        if (l()) {
            eqVar.h(this.w);
        }
        eqVar.j(list);
        jVar.a.a(new com.google.android.libraries.navigation.internal.sw.i(com.google.android.libraries.navigation.internal.yz.ev.o(eqVar.g())));
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final boolean isGuidanceRunning() {
        boolean zV;
        try {
            synchronized (d()) {
                this.s.a(com.google.android.libraries.navigation.internal.zp.n.ar);
                zV = this.o.v();
            }
            return zV;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final void j(List list) throws NavigationTransactionRecorder.TransactionException {
        com.google.android.libraries.navigation.internal.xh.b bVarA = this.t.a();
        if (bVarA != null) {
            if (bVarA.c()) {
                i(list, true);
                return;
            }
            return;
        }
        synchronized (a) {
            List list2 = this.m;
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.m = new ArrayList(list);
                com.google.android.libraries.navigation.internal.aac.az.o(this.t.b(), new ez(this), this.y);
            }
        }
    }

    public final synchronized void k(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        this.o.t(bgVar);
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final boolean registerServiceForNavUpdates(String str, String str2, int i) {
        DisplayMetrics displayMetrics;
        try {
            NavigationUpdatesOptions.Builder builder = NavigationUpdatesOptions.builder();
            ((com.google.android.libraries.navigation.c) builder).b = 0;
            ((com.google.android.libraries.navigation.c) builder).a = i;
            ((com.google.android.libraries.navigation.c) builder).d = (byte) 3;
            DisplayMetrics displayMetrics2 = this.e.getResources().getDisplayMetrics();
            if (displayMetrics2 == null) {
                throw new NullPointerException("Null displayMetrics");
            }
            ((com.google.android.libraries.navigation.c) builder).c = displayMetrics2;
            if (((com.google.android.libraries.navigation.c) builder).d == 3 && (displayMetrics = ((com.google.android.libraries.navigation.c) builder).c) != null) {
                return registerServiceForNavUpdates(str, str2, new com.google.android.libraries.navigation.d(((com.google.android.libraries.navigation.c) builder).a, ((com.google.android.libraries.navigation.c) builder).b, displayMetrics));
            }
            StringBuilder sb = new StringBuilder();
            if ((((com.google.android.libraries.navigation.c) builder).d & 1) == 0) {
                sb.append(" numNextStepsToPreview");
            }
            if ((((com.google.android.libraries.navigation.c) builder).d & 2) == 0) {
                sb.append(" generatedStepImagesType");
            }
            if (((com.google.android.libraries.navigation.c) builder).c == null) {
                sb.append(" displayMetrics");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeArrivalListener(Navigator.ArrivalListener arrivalListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.at);
            com.google.android.libraries.navigation.internal.abf.t.c(arrivalListener, "Listener must be non-null");
            this.f.remove(arrivalListener);
            if (this.f.isEmpty()) {
                this.o.s = null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeNavigationSessionListener(Navigator.NavigationSessionListener navigationSessionListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ax);
            com.google.android.libraries.navigation.internal.abf.t.c(navigationSessionListener, "Listener must be non-null");
            this.j.remove(navigationSessionListener);
            if (this.j.isEmpty()) {
                this.o.w = null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeRemainingTimeOrDistanceChangedListener(Navigator.RemainingTimeOrDistanceChangedListener remainingTimeOrDistanceChangedListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aj);
            com.google.android.libraries.navigation.internal.abf.t.c(remainingTimeOrDistanceChangedListener, "Listener must be non-null");
            fc fcVar = (fc) this.q.remove(remainingTimeOrDistanceChangedListener);
            if (fcVar != null) {
                this.o.z(fcVar);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeReroutingListener(Navigator.ReroutingListener reroutingListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.as);
            com.google.android.libraries.navigation.internal.abf.t.c(reroutingListener, "Listener must be non-null");
            fd fdVar = (fd) this.r.remove(reroutingListener);
            if (fdVar != null) {
                this.o.e().c.remove(fdVar);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeRouteChangedListener(Navigator.RouteChangedListener routeChangedListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.az);
            com.google.android.libraries.navigation.internal.abf.t.c(routeChangedListener, "Listener must be non-null");
            this.g.remove(routeChangedListener);
            if (this.g.isEmpty()) {
                this.o.A(null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void removeTrafficUpdatedListener(Navigator.TrafficUpdatedListener trafficUpdatedListener) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aD);
            com.google.android.libraries.navigation.internal.abf.t.c(trafficUpdatedListener, "Listener must be non-null");
            this.i.remove(trafficUpdatedListener);
            if (this.i.isEmpty()) {
                this.o.v = null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized void setAudioGuidance(int i) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.au);
            this.o.l(i);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestination(Waypoint waypoint) {
        try {
            return setDestinations(hx.d(waypoint), new RoutingOptions(), new DisplayOptions());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestinations(List<Waypoint> list) {
        try {
            return setDestinations(list, new RoutingOptions(), new DisplayOptions());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setHeadsUpNotificationEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.av);
            com.google.android.libraries.navigation.internal.vw.j jVar = this.o;
            if (jVar.f645n == z) {
                return;
            }
            jVar.f645n = z;
            jVar.r();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setSpeedAlertOptions(SpeedAlertOptions speedAlertOptions) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aB);
            if (speedAlertOptions == null) {
                this.f650n.a.clear();
                com.google.android.libraries.navigation.internal.uu.r rVar = this.p.d;
                ((com.google.android.libraries.navigation.environment.cs) rVar).a.clear();
                ((com.google.android.libraries.navigation.environment.cs) rVar).b = com.google.android.libraries.navigation.internal.yx.a.a;
                return;
            }
            float speedAlertThresholdPercentage = speedAlertOptions.getSpeedAlertThresholdPercentage(SpeedAlertSeverity.MINOR);
            float speedAlertThresholdPercentage2 = speedAlertOptions.getSpeedAlertThresholdPercentage(SpeedAlertSeverity.MAJOR);
            double severityUpgradeDurationSeconds = speedAlertOptions.getSeverityUpgradeDurationSeconds();
            ag agVar = this.f650n;
            Map map = agVar.a;
            SpeedAlertSeverity speedAlertSeverity = SpeedAlertSeverity.MINOR;
            Float fValueOf = Float.valueOf(speedAlertThresholdPercentage);
            map.put(speedAlertSeverity, fValueOf);
            Map map2 = agVar.a;
            SpeedAlertSeverity speedAlertSeverity2 = SpeedAlertSeverity.MAJOR;
            Float fValueOf2 = Float.valueOf(speedAlertThresholdPercentage2);
            map2.put(speedAlertSeverity2, fValueOf2);
            com.google.android.libraries.navigation.internal.uu.r rVar2 = this.p.d;
            ((com.google.android.libraries.navigation.environment.cs) rVar2).a.put(SpeedAlertSeverity.MINOR, fValueOf);
            ((com.google.android.libraries.navigation.environment.cs) rVar2).a.put(SpeedAlertSeverity.MAJOR, fValueOf2);
            ((com.google.android.libraries.navigation.environment.cs) rVar2).b = com.google.android.libraries.navigation.internal.yx.an.j(Double.valueOf(severityUpgradeDurationSeconds));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setSpeedingListener(SpeedingListener speedingListener) {
        try {
            ag agVar = this.f650n;
            agVar.b = com.google.android.libraries.navigation.internal.yx.an.i(speedingListener);
            if (speedingListener == null) {
                this.p.b.c(agVar);
            } else {
                this.p.b.b(agVar);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setTaskRemovedBehavior(int i) {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aC);
            if (i == 0) {
                this.C.a(true);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid setTaskRemovedBehavior value: "));
                }
                this.C.a(false);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void stopGuidance() {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aG);
            this.o.p();
            ae aeVar = this.A;
            if (aeVar != null) {
                aeVar.c();
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final boolean unregisterServiceForNavUpdates() {
        try {
            ae aeVar = this.A;
            if (aeVar != null && aeVar.f) {
                aeVar.b.unbindService(aeVar.l);
                aeVar.a();
                return true;
            }
            return false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void clearLicensePlateRestrictionInfo() {
        try {
            this.c.d(-1, "");
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final void f() {
        try {
            this.o.r.a();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public final void g() {
        try {
            this.o.r.b();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setLicensePlateRestrictionInfo(int i, String str) {
        try {
            this.c.d(i, str);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestinations(List<Waypoint> list, CustomRoutesOptions customRoutesOptions) {
        try {
            return setDestinations(list, customRoutesOptions, new DisplayOptions());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final void setTransactionIds(List<String> list) throws NavigationTransactionRecorder.TransactionException {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aE);
            j(list);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized void startGuidance() {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.aF);
            this.o.o(this.z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized void cleanup() {
        try {
            this.s.a(com.google.android.libraries.navigation.internal.zp.n.ah);
            this.o.i();
            this.B.b();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestination(Waypoint waypoint, RoutingOptions routingOptions) {
        try {
            return setDestinations(hx.d(waypoint), routingOptions, new DisplayOptions());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestinations(final List<Waypoint> list, CustomRoutesOptions customRoutesOptions, DisplayOptions displayOptions) {
        com.google.android.libraries.navigation.internal.zp.n nVar;
        com.google.android.libraries.navigation.internal.ady.al alVar;
        try {
            com.google.android.libraries.navigation.internal.xd.a aVar = this.s;
            if (list.size() > 1) {
                nVar = com.google.android.libraries.navigation.internal.zp.n.aw;
            } else {
                nVar = com.google.android.libraries.navigation.internal.zp.n.aA;
            }
            aVar.a(nVar);
            final com.google.android.libraries.navigation.internal.vq.b bVarA = com.google.android.libraries.navigation.internal.vq.b.a();
            gc gcVar = new gc(bVarA);
            final com.google.android.libraries.navigation.internal.wd.f fVarA = this.u.a(com.google.android.libraries.navigation.internal.abx.b.NAVIGATION_SET_DESTINATION);
            fl flVar = this.k;
            if (((fv) flVar).f(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS_WITH_ROUTE_TOKEN)) {
                com.google.android.libraries.navigation.internal.vw.j jVar = this.o;
                com.google.android.libraries.navigation.internal.yz.ev evVarD = Waypoint.d(list);
                com.google.android.libraries.navigation.internal.ady.v vVar = gg.a;
                com.google.android.libraries.navigation.internal.yx.ar.r(customRoutesOptions.routeToken(), "A route token must be set.");
                lo loVar = (lo) lr.a.q();
                int iTravelMode = customRoutesOptions.travelMode();
                if (iTravelMode == 0) {
                    alVar = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
                } else if (iTravelMode == 1) {
                    alVar = com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER;
                } else {
                    throw new IllegalArgumentException("Unsupported travel mode: " + iTravelMode);
                }
                ka kaVarC = gg.c(alVar, jw.c);
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar = (lr) loVar.b;
                kaVarC.getClass();
                lrVar.f = kaVarC;
                lrVar.b |= 1;
                com.google.android.libraries.navigation.internal.adr.fz fzVar = (com.google.android.libraries.navigation.internal.adr.fz) com.google.android.libraries.navigation.internal.adr.ga.a.q();
                com.google.android.libraries.navigation.internal.ael.x xVarT = com.google.android.libraries.navigation.internal.ael.x.t(com.google.android.libraries.navigation.internal.zn.g.e.j(customRoutesOptions.routeToken()));
                if (!fzVar.b.H()) {
                    fzVar.v();
                }
                com.google.android.libraries.navigation.internal.adr.ga gaVar = (com.google.android.libraries.navigation.internal.adr.ga) fzVar.b;
                gaVar.b |= 1;
                gaVar.c = xVarT;
                com.google.android.libraries.navigation.internal.adr.ga gaVar2 = (com.google.android.libraries.navigation.internal.adr.ga) fzVar.t();
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar2 = (lr) loVar.b;
                gaVar2.getClass();
                lrVar2.e = gaVar2;
                lrVar2.d = 64;
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar3 = (lr) loVar.b;
                lrVar3.b |= 256;
                lrVar3.k = 1;
                com.google.android.libraries.navigation.internal.adr.c cVarA = gg.a();
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar4 = (lr) loVar.b;
                com.google.android.libraries.navigation.internal.adr.d dVar = (com.google.android.libraries.navigation.internal.adr.d) cVarA.t();
                dVar.getClass();
                lrVar4.r = dVar;
                lrVar4.b |= 134217728;
                com.google.android.libraries.navigation.internal.adr.bt btVar = (com.google.android.libraries.navigation.internal.adr.bt) com.google.android.libraries.navigation.internal.adr.by.a.q();
                ip ipVar = (ip) iu.a.q();
                int i = it.c;
                if (!ipVar.b.H()) {
                    ipVar.v();
                }
                iu iuVar = (iu) ipVar.b;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                iuVar.d = i2;
                iuVar.b = 64 | iuVar.b;
                if (!btVar.b.H()) {
                    btVar.v();
                }
                com.google.android.libraries.navigation.internal.adr.by byVar = (com.google.android.libraries.navigation.internal.adr.by) btVar.b;
                iu iuVar2 = (iu) ipVar.t();
                iuVar2.getClass();
                byVar.e = iuVar2;
                byVar.b |= 512;
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar5 = (lr) loVar.b;
                com.google.android.libraries.navigation.internal.adr.by byVar2 = (com.google.android.libraries.navigation.internal.adr.by) btVar.t();
                byVar2.getClass();
                lrVar5.h = byVar2;
                lrVar5.b |= 4;
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr.i((lr) loVar.b);
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr.h((lr) loVar.b);
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr.e((lr) loVar.b);
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr.g((lr) loVar.b);
                com.google.android.libraries.navigation.internal.ady.v vVar2 = gg.a;
                if (!loVar.b.H()) {
                    loVar.v();
                }
                lr lrVar6 = (lr) loVar.b;
                vVar2.getClass();
                lrVar6.o = vVar2;
                lrVar6.b |= 1048576;
                jVar.w(evVarD, (lr) loVar.t(), z.b(displayOptions), 0L, new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.xe.es
                    @Override // com.google.android.libraries.navigation.internal.yx.as
                    public final boolean a(Object obj) {
                        return true;
                    }
                }).c(new com.google.android.libraries.navigation.internal.vp.a() { // from class: com.google.android.libraries.navigation.internal.xe.et
                    @Override // com.google.android.libraries.navigation.internal.vp.a
                    public final void a(Object obj) {
                        com.google.android.libraries.navigation.internal.vp.c cVar = (com.google.android.libraries.navigation.internal.vp.c) obj;
                        fVarA.b(cVar.ordinal());
                        if (ga.a(cVar)) {
                            this.a.k.c(list.size());
                        }
                        bVarA.d(cVar);
                    }
                });
            } else {
                ((fv) flVar).c(1);
                fVarA.b(com.google.android.libraries.navigation.internal.vp.c.QUOTA_CHECK_FAILED.ordinal());
                bVarA.d(com.google.android.libraries.navigation.internal.vp.c.QUOTA_CHECK_FAILED);
            }
            return gcVar;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestination(Waypoint waypoint, RoutingOptions routingOptions, DisplayOptions displayOptions) {
        try {
            return setDestinations(hx.d(waypoint), routingOptions, displayOptions);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final boolean registerServiceForNavUpdates(String str, String str2, NavigationUpdatesOptions navigationUpdatesOptions) {
        try {
            if (this.A == null) {
                this.A = new ae(this, this.e, this.o, this.v);
            }
            final ae aeVar = this.A;
            if (aeVar != null && !aeVar.f) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(str, str2));
                if (!aeVar.b.bindService(intent, aeVar.l, 1)) {
                    return false;
                }
                aeVar.k = Math.max(0, Math.min(navigationUpdatesOptions.numNextStepsToPreview(), 1000));
                ((com.google.android.libraries.navigation.internal.vw.j) aeVar.c).l = new com.google.android.libraries.navigation.internal.vp.b() { // from class: com.google.android.libraries.navigation.internal.xe.ac
                    /* JADX WARN: Code duplicated, block: B:66:0x0161 A[PHI: r14
                      0x0161: PHI (r14v14 int) = (r14v13 int), (r14v16 int) binds: [B:64:0x015d, B:61:0x0157] A[DONT_GENERATE, DONT_INLINE]] */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r12v3 */
                    /* JADX WARN: Type inference failed for: r12v37 */
                    /* JADX WARN: Type inference failed for: r12v38 */
                    /* JADX WARN: Type inference failed for: r12v39 */
                    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
                    /* JADX WARN: Type inference failed for: r12v9, types: [com.google.android.libraries.navigation.internal.tn.m] */
                    /* JADX WARN: Type inference failed for: r13v0, types: [com.google.android.libraries.mapsplatform.turnbyturn.model.StepInfo$Builder] */
                    /* JADX WARN: Type inference failed for: r14v2 */
                    /* JADX WARN: Type inference failed for: r14v25 */
                    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
                    /* JADX WARN: Type inference failed for: r5v0 */
                    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
                    /* JADX WARN: Type inference failed for: r5v13 */
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
                    @Override // com.google.android.libraries.navigation.internal.vp.b
                    public final void a(com.google.android.libraries.navigation.internal.se.b bVar) {
                        boolean z;
                        ?? IntValue;
                        com.google.android.libraries.navigation.internal.bp.bq[] bqVarArr;
                        StepInfo stepInfoBuild;
                        Bitmap bitmapB;
                        Iterator it2;
                        int i;
                        int i2;
                        int i3;
                        if (bVar.c == null) {
                            return;
                        }
                        ae aeVar2 = aeVar;
                        boolean z2 = true;
                        ?? r5 = 0;
                        if (aeVar2.j == null || bVar.b.j() != aeVar2.j.length) {
                            gf gfVar = aeVar2.d;
                            com.google.android.libraries.navigation.internal.bp.bq[] bqVarArr2 = bVar.b.l;
                            NavigationUpdatesOptions navigationUpdatesOptions2 = aeVar2.g;
                            StepInfo[] stepInfoArr = new StepInfo[bqVarArr2.length];
                            int i4 = 0;
                            while (i4 < bqVarArr2.length) {
                                com.google.android.libraries.navigation.internal.bp.bq bqVar = bqVarArr2[i4];
                                if (bqVar == null) {
                                    bqVarArr = bqVarArr2;
                                    stepInfoBuild = null;
                                } else {
                                    Spanned spanned = bqVar.p;
                                    ?? Builder = StepInfo.builder();
                                    Builder.setFullInstructionText(spanned.toString());
                                    o[] oVarArr = t.a;
                                    int length = oVarArr.length;
                                    ?? r14 = r5;
                                    while (true) {
                                        if (r14 >= 62) {
                                            IntValue = r5;
                                            break;
                                        }
                                        o oVar = oVarArr[r14];
                                        if (oVar.a(bqVar)) {
                                            i3 = oVar.c;
                                            IntValue = i3;
                                            if (bqVar.E != com.google.android.libraries.navigation.internal.adr.en.LEFT) {
                                                break;
                                            }
                                            com.google.android.libraries.navigation.internal.yz.fd fdVar = t.b;
                                            Integer numValueOf = Integer.valueOf(i3);
                                            if (!fdVar.containsKey(numValueOf)) {
                                                break;
                                            }
                                            IntValue = i3;
                                            IntValue = ((Integer) t.b.get(numValueOf)).intValue();
                                            break;
                                        }
                                        r14++;
                                    }
                                    IntValue = i3;
                                    Builder.setManeuver(IntValue);
                                    Builder.setDrivingSide(((Integer) gf.a.getOrDefault(bqVar.E, Integer.valueOf((int) r5))).intValue());
                                    Builder.setFullRoadName(gfVar.b.b(bqVar, r5).toString());
                                    Builder.setSimpleRoadName(gfVar.b.b(bqVar, z2).toString());
                                    com.google.android.libraries.navigation.internal.bp.bs bsVar = bqVar.u;
                                    Builder.setExitNumber(bsVar == null ? null : bsVar.g());
                                    Builder.setRoundaboutTurnNumber(Integer.valueOf(bqVar.h));
                                    Builder.setStepNumber(Integer.valueOf(bqVar.i));
                                    Builder.setDistanceFromPrevStepMeters(Integer.valueOf(bqVar.l));
                                    Builder.setTimeFromPrevStepSeconds(Integer.valueOf((int) bqVar.f355n.toSeconds()));
                                    int i5 = com.google.android.libraries.navigation.internal.yz.ev.d;
                                    com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
                                    Iterator it3 = bqVar.B.iterator();
                                    while (it3.hasNext()) {
                                        com.google.android.libraries.navigation.internal.bp.ar arVar = (com.google.android.libraries.navigation.internal.bp.ar) it3.next();
                                        int i6 = arVar.b;
                                        Lane.Builder builder = Lane.builder();
                                        boolean z3 = i6 == com.google.android.libraries.navigation.internal.adr.dr.a;
                                        com.google.android.libraries.navigation.internal.yz.eq eqVar2 = new com.google.android.libraries.navigation.internal.yz.eq();
                                        for (com.google.android.libraries.navigation.internal.bp.at atVar : arVar.a) {
                                            com.google.android.libraries.navigation.internal.bp.bq[] bqVarArr3 = bqVarArr2;
                                            LaneDirection.Builder builder2 = LaneDirection.builder();
                                            builder2.setIsRecommended(Boolean.valueOf(z3));
                                            com.google.android.libraries.navigation.internal.adr.dv dvVar = atVar.a;
                                            boolean z4 = atVar.b;
                                            int iOrdinal = dvVar.ordinal();
                                            if (iOrdinal != 0) {
                                                it2 = it3;
                                                if (iOrdinal == 1) {
                                                    i2 = 2;
                                                    if (z4) {
                                                        i = 3;
                                                    } else {
                                                        i = i2;
                                                    }
                                                } else if (iOrdinal == 2) {
                                                    i2 = 4;
                                                    if (z4) {
                                                        i = 5;
                                                    } else {
                                                        i = i2;
                                                    }
                                                } else if (iOrdinal == 3) {
                                                    i = z4 ? 7 : 6;
                                                } else if (iOrdinal != 4) {
                                                    i = 0;
                                                } else {
                                                    i = z4 ? 9 : 8;
                                                }
                                            } else {
                                                it2 = it3;
                                                i = 1;
                                            }
                                            builder2.setLaneShape(i);
                                            eqVar2.h(builder2.build());
                                            bqVarArr2 = bqVarArr3;
                                            it3 = it2;
                                            z3 = false;
                                        }
                                        builder.setLaneDirections(eqVar2.g());
                                        eqVar.h(builder.build());
                                    }
                                    bqVarArr = bqVarArr2;
                                    Builder.setLanes(eqVar.g());
                                    if (navigationUpdatesOptions2.generatedStepImagesType() == 1) {
                                        Builder.setManeuverBitmap(com.google.android.libraries.navigation.internal.gw.f.b(com.google.android.libraries.navigation.internal.bl.d.c(bqVar, -1), Math.round(navigationUpdatesOptions2.displayMetrics().density * 128.0f), Math.round(navigationUpdatesOptions2.displayMetrics().density * 128.0f), Bitmap.Config.ARGB_8888));
                                        int iRound = Math.round(navigationUpdatesOptions2.displayMetrics().density * 500.0f);
                                        float f = navigationUpdatesOptions2.displayMetrics().density * 74.0f;
                                        List list = bqVar.B;
                                        int iRound2 = Math.round(f);
                                        if (list.isEmpty()) {
                                            bitmapB = null;
                                        } else {
                                            if (gfVar.f == null) {
                                                gfVar.f = new MultiIconView(gfVar.c);
                                            }
                                            com.google.android.libraries.geo.navcore.ui.header.views.h.a(gfVar.f, list, gfVar.e, gfVar.d.a(false, false), -1);
                                            bitmapB = com.google.android.libraries.navigation.internal.gw.f.b(com.google.android.libraries.navigation.internal.kj.c.a(gfVar.f).mutate(), iRound, iRound2, Bitmap.Config.ARGB_8888);
                                        }
                                        Builder.setLanesBitmap(bitmapB);
                                    }
                                    stepInfoBuild = Builder.build();
                                }
                                stepInfoArr[i4] = stepInfoBuild;
                                i4++;
                                bqVarArr2 = bqVarArr;
                                z2 = true;
                                r5 = 0;
                            }
                            aeVar2.j = stepInfoArr;
                            z = true;
                        } else {
                            z = false;
                        }
                        NavInfo.Builder builder3 = NavInfo.builder();
                        builder3.setNavState(1);
                        builder3.setRouteChanged(z);
                        builder3.setCurrentStep(aeVar2.j[bVar.c.i]);
                        builder3.setTimeToCurrentStepSeconds(Integer.valueOf(bVar.g));
                        builder3.setDistanceToCurrentStepMeters(Integer.valueOf(Math.max(0, bVar.f)));
                        builder3.setTimeToNextDestinationSeconds(Integer.valueOf(bVar.c()));
                        builder3.setDistanceToNextDestinationMeters(Integer.valueOf(bVar.k));
                        builder3.setTimeToFinalDestinationSeconds(Integer.valueOf(bVar.b()));
                        builder3.setDistanceToFinalDestinationMeters(Integer.valueOf(bVar.j));
                        int i7 = aeVar2.k;
                        if (i7 > 0) {
                            int i8 = bVar.c.i + 1;
                            StepInfo[] stepInfoArr2 = aeVar2.j;
                            builder3.setRemainingSteps((StepInfo[]) Arrays.copyOfRange(stepInfoArr2, i8, Math.min(stepInfoArr2.length, i7 + i8)));
                        }
                        aeVar2.b(builder3.build());
                    }
                };
                aeVar.a.addReroutingListener(aeVar.h);
                aeVar.a.addRouteChangedListener(aeVar.i);
                aeVar.g = navigationUpdatesOptions;
                return true;
            }
            return false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final ListenableResultFuture<Navigator.RouteStatus> setDestinations(List<Waypoint> list, RoutingOptions routingOptions) {
        try {
            return setDestinations(list, routingOptions, new DisplayOptions());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator
    public final synchronized ListenableResultFuture<Navigator.RouteStatus> setDestinations(final List<Waypoint> list, RoutingOptions routingOptions, DisplayOptions displayOptions) {
        com.google.android.libraries.navigation.internal.zp.n nVar;
        gc gcVar;
        try {
            try {
                if (routingOptions.getRoutingStrategy() == 2) {
                    List<Integer> targetDistancesMeters = routingOptions.getTargetDistancesMeters();
                    com.google.android.libraries.navigation.internal.abf.t.c(targetDistancesMeters, "Trying to use RoutingStrategy.TARGET_DISTANCE but targetDistancesMeters is null.");
                    com.google.android.libraries.navigation.internal.abf.t.a(!targetDistancesMeters.isEmpty(), "Trying to use RoutingStrategy.TARGET_DISTANCE but targetDistancesMeters is empty.");
                    for (Integer num : targetDistancesMeters) {
                        com.google.android.libraries.navigation.internal.abf.t.c(num, "Trying to use RoutingStrategy.TARGET_DISTANCE but targetDistancesMeters contains a null element.");
                        com.google.android.libraries.navigation.internal.abf.t.a(num.intValue() > 0, "Trying to use RoutingStrategy.TARGET_DISTANCE but targetDistancesMeters contains a negative distance or zero.");
                    }
                }
                com.google.android.libraries.navigation.internal.xd.a aVar = this.s;
                if (list.size() > 1) {
                    nVar = com.google.android.libraries.navigation.internal.zp.n.aw;
                } else {
                    nVar = com.google.android.libraries.navigation.internal.zp.n.aA;
                }
                aVar.a(nVar);
                final com.google.android.libraries.navigation.internal.vq.b bVarA = com.google.android.libraries.navigation.internal.vq.b.a();
                gcVar = new gc(bVarA);
                final com.google.android.libraries.navigation.internal.wd.f fVarA = this.u.a(com.google.android.libraries.navigation.internal.abx.b.NAVIGATION_SET_DESTINATION);
                if (!this.k.a()) {
                    fVarA.b(com.google.android.libraries.navigation.internal.vp.c.QUOTA_CHECK_FAILED.ordinal());
                    bVarA.d(com.google.android.libraries.navigation.internal.vp.c.QUOTA_CHECK_FAILED);
                } else {
                    this.o.w(Waypoint.d(list), gg.b(routingOptions, displayOptions.getShowTrafficLights(), displayOptions.getShowStopSigns(), this.c), z.b(displayOptions), routingOptions.getLocationTimeoutMs(), new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.xe.el
                        @Override // com.google.android.libraries.navigation.internal.yx.as
                        public final boolean a(Object obj) {
                            return true;
                        }
                    }).c(new com.google.android.libraries.navigation.internal.vp.a() { // from class: com.google.android.libraries.navigation.internal.xe.em
                        @Override // com.google.android.libraries.navigation.internal.vp.a
                        public final void a(Object obj) {
                            com.google.android.libraries.navigation.internal.vp.c cVar = (com.google.android.libraries.navigation.internal.vp.c) obj;
                            fVarA.b(cVar.ordinal());
                            if (ga.a(cVar)) {
                                this.a.k.b(list.size());
                            }
                            bVarA.d(cVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
        return gcVar;
    }
}
