package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.SimulationOptions;
import com.google.android.libraries.navigation.Simulator;
import com.google.android.libraries.navigation.Waypoint;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ge implements Simulator {
    public final fl a;
    public final ga b;
    private final com.google.android.libraries.navigation.internal.vp.i c;
    private final com.google.android.libraries.navigation.internal.bj.b d;
    private final com.google.android.libraries.navigation.internal.xd.a e;

    public ge(com.google.android.libraries.navigation.internal.vp.i iVar, com.google.android.libraries.navigation.internal.bj.b bVar, com.google.android.libraries.navigation.internal.xd.a aVar, fl flVar, ga gaVar) {
        this.c = iVar;
        this.d = bVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        this.e = aVar;
        this.a = flVar;
        this.b = gaVar;
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void setUserLocation(LatLng latLng) {
        try {
            com.google.android.libraries.navigation.internal.abf.t.c(latLng, "location cannot be null");
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aN);
            this.c.d(new com.google.android.libraries.navigation.internal.oe.r(latLng.latitude, latLng.longitude));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final void simulateLocationsAlongExistingRoute() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aP);
            ((com.google.android.libraries.navigation.internal.vw.q) this.c).f(new com.google.android.libraries.navigation.internal.vp.h());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(List<Waypoint> list) {
        try {
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
        return simulateLocationsAlongNewRoute(list, new RoutingOptions());
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void hideDummyTrafficPrompt() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aK);
            this.c.a();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void pause() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aL);
            this.c.b();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void resume() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aM);
            this.c.c();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void showDummyTrafficPrompt() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aO);
            this.c.e();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(List<Waypoint> list, RoutingOptions routingOptions) {
        try {
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
        return simulateLocationsAlongNewRoute(list, routingOptions, new SimulationOptions());
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void unsetUserLocation() {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aR);
            this.c.g();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized ListenableResultFuture<Navigator.RouteStatus> simulateLocationsAlongNewRoute(final List<Waypoint> list, RoutingOptions routingOptions, SimulationOptions simulationOptions) {
        try {
            try {
                com.google.android.libraries.navigation.internal.abf.t.c(list, "Tried to set a null destination list.");
                com.google.android.libraries.navigation.internal.abf.t.a(!list.isEmpty(), "Tried to set an empty destination list.");
                Iterator<Waypoint> it2 = list.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.abf.t.c(it2.next(), "Tried to set a null destination.");
                }
                com.google.android.libraries.navigation.internal.abf.t.c(routingOptions, "Tried to set null routing options. Use new RoutingOptions() instead.");
                com.google.android.libraries.navigation.internal.abf.t.c(simulationOptions, "Tried to set null simulation options. Use new SimulationOptions() instead.");
                this.e.a(com.google.android.libraries.navigation.internal.zp.n.aQ);
                if (this.a.a()) {
                    com.google.android.libraries.navigation.internal.vq.b bVarH = this.c.h(Waypoint.d(list), gg.b(routingOptions, false, false, this.d), routingOptions.getLocationTimeoutMs(), simulationOptions.a());
                    bVarH.c(new com.google.android.libraries.navigation.internal.vp.a() { // from class: com.google.android.libraries.navigation.internal.xe.gd
                        @Override // com.google.android.libraries.navigation.internal.vp.a
                        public final void a(Object obj) {
                            if (ga.a((com.google.android.libraries.navigation.internal.vp.c) obj)) {
                                this.a.a.b(list.size());
                            }
                        }
                    });
                    return new gc(bVarH);
                }
                m mVarE = m.e();
                mVarE.d(Navigator.RouteStatus.QUOTA_CHECK_FAILED);
                return mVarE;
            } catch (Throwable th) {
                throw th;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.Simulator
    public final synchronized void simulateLocationsAlongExistingRoute(SimulationOptions simulationOptions) {
        try {
            this.e.a(com.google.android.libraries.navigation.internal.zp.n.aP);
            this.c.f(simulationOptions.a());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
