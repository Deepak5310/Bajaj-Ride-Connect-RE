package com.google.android.libraries.navigation.internal.hn;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aap.aa;
import com.google.android.libraries.navigation.internal.aap.ac;
import com.google.android.libraries.navigation.internal.aap.ad;
import com.google.android.libraries.navigation.internal.aap.ag;
import com.google.android.libraries.navigation.internal.aap.t;
import com.google.android.libraries.navigation.internal.aap.x;
import com.google.android.libraries.navigation.internal.ael.bs;
import com.google.android.libraries.navigation.internal.afl.cy;
import com.google.android.libraries.navigation.internal.afl.ex;
import com.google.android.libraries.navigation.internal.afl.ey;
import com.google.android.libraries.navigation.internal.afl.ez;
import com.google.android.libraries.navigation.internal.afl.fa;
import com.google.android.libraries.navigation.internal.afl.fb;
import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.afl.fg;
import com.google.android.libraries.navigation.internal.afl.fn;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.afl.jw;
import com.google.android.libraries.navigation.internal.afl.kc;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static final /* synthetic */ int b = 0;
    private static final br c = bw.a(new n());
    public final fs a;
    private final br d = bw.a(new l(this));
    private final br e = bw.a(new m(this));

    public p(fs fsVar) {
        this.a = fsVar;
    }

    public static void l(List list, fd fdVar, boolean z, boolean z2, float f, float f2, float f3, float f4, float f5, float f6) {
        fb fbVar = (fb) fg.a.q();
        if (!fbVar.b.H()) {
            fbVar.v();
        }
        fg fgVar = (fg) fbVar.b;
        fgVar.c = fdVar.e;
        fgVar.b |= 1;
        if (!fbVar.b.H()) {
            fbVar.v();
        }
        fg fgVar2 = (fg) fbVar.b;
        fgVar2.b |= 2;
        fgVar2.d = z;
        if (!fbVar.b.H()) {
            fbVar.v();
        }
        fg fgVar3 = (fg) fbVar.b;
        fgVar3.b |= 4;
        fgVar3.e = z2;
        v(list, fbVar, fdVar, ff.FAR_VIEW_MODE, f);
        v(list, fbVar, fdVar, ff.NORMAL, f2);
        v(list, fbVar, fdVar, ff.APPROACH, f3);
        v(list, fbVar, fdVar, ff.LIMITED_CONTROLLED_ACCESS_MANEUVER, f4);
        v(list, fbVar, fdVar, ff.INSPECT_STEP, f5);
        v(list, fbVar, fdVar, ff.INSPECT_ROUTE, f6);
    }

    private static final double t(int i) {
        return ((double) i) * 1.0E-6d;
    }

    private final List u() {
        return this.a.L.isEmpty() ? (List) c.a() : this.a.L;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004f  */
    private static void v(List list, fb fbVar, fd fdVar, ff ffVar, float f) {
        ex exVar = (ex) ey.a.q();
        if (!fbVar.b.H()) {
            fbVar.v();
        }
        fg fgVar = (fg) fbVar.b;
        fg fgVar2 = fg.a;
        fgVar.f = ffVar.j;
        fgVar.b |= 8;
        fg fgVar3 = (fg) fbVar.t();
        if (!exVar.b.H()) {
            exVar.v();
        }
        ey eyVar = (ey) exVar.b;
        fgVar3.getClass();
        eyVar.c = fgVar3;
        eyVar.b |= 1;
        float f2 = 0.0f;
        if (fdVar == fd.CAMERA_3D) {
            if (ffVar == ff.FAR_VIEW_MODE || ffVar == ff.NORMAL) {
                f2 = 65.0f;
            } else if (ffVar == ff.APPROACH) {
                f2 = 55.0f;
            } else if (ffVar == ff.LIMITED_CONTROLLED_ACCESS_MANEUVER) {
                f2 = 65.0f;
            } else if (ffVar == ff.INSPECT_STEP) {
                f2 = 40.0f;
            }
        }
        ez ezVar = (ez) fa.a.q();
        if (!ezVar.b.H()) {
            ezVar.v();
        }
        fa faVar = (fa) ezVar.b;
        faVar.b |= 1;
        faVar.c = f2;
        if (!ezVar.b.H()) {
            ezVar.v();
        }
        fa faVar2 = (fa) ezVar.b;
        faVar2.b |= 2;
        faVar2.d = f;
        fa faVar3 = (fa) ezVar.t();
        if (!exVar.b.H()) {
            exVar.v();
        }
        ey eyVar2 = (ey) exVar.b;
        faVar3.getClass();
        eyVar2.d = faVar3;
        eyVar2.b |= 2;
        list.add((ey) exVar.t());
    }

    public final double a() {
        return t(this.a.p);
    }

    public final int b() {
        return Math.max(0, this.a.aq);
    }

    public final int c() {
        return this.a.as;
    }

    public final int d() {
        return Math.max(500, this.a.V);
    }

    public final int e() {
        return this.a.F;
    }

    public final int f() {
        return this.a.f311n;
    }

    public final int g() {
        return this.a.E;
    }

    public final cy h() {
        cy cyVar = this.a.aO;
        return cyVar == null ? cy.a : cyVar;
    }

    public final ey i(fd fdVar, boolean z, boolean z2, ff ffVar) {
        Map map = (Map) this.d.a();
        o oVar = new o(fdVar, z, z2, ffVar);
        ey eyVar = (ey) map.get(oVar);
        if (eyVar != null) {
            return eyVar;
        }
        ey eyVar2 = (ey) ((Map) this.e.a()).get(oVar);
        ar.q(eyVar2);
        return eyVar2;
    }

    public final kc j() {
        kc kcVar = this.a.aQ;
        return kcVar == null ? kc.a : kcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map k(boolean z) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationParameters.getCameraParametersMap");
        try {
            HashMap map = new HashMap();
            List<ey> listU = z ? (List) c.a() : u();
            for (ey eyVar : listU) {
                fg fgVar = eyVar.c;
                if (fgVar == null) {
                    fgVar = fg.a;
                }
                fd fdVarB = fd.b(fgVar.c);
                if (fdVarB == null) {
                    fdVarB = fd.UNKNOWN_CAMERA_TYPE;
                }
                boolean z2 = fgVar.d;
                boolean z3 = fgVar.e;
                ff ffVarB = ff.b(fgVar.f);
                if (ffVarB == null) {
                    ffVarB = ff.UNKNOWN_VIEW_MODE;
                }
                map.put(new o(fdVarB, z2, z3, ffVarB), eyVar);
            }
            if (!z) {
                jw jwVar = this.a.aV;
                if (jwVar == null) {
                    jwVar = jw.a;
                }
                for (ag agVar : jwVar.b) {
                    if (new bs(agVar.e, ag.a).contains(com.google.android.libraries.navigation.internal.aap.b.LEGACY_CAMERA_SURFACE)) {
                        final ad adVar = agVar.c;
                        if (adVar == null) {
                            adVar = ad.a;
                        }
                        int iA = aa.a(adVar.b);
                        if (iA == 0) {
                            iA = aa.a;
                        }
                        if (iA == 0) {
                            throw null;
                        }
                        int i = iA - 1;
                        ev evVar = (ev) (i != 1 ? i != 2 ? ev.q(fd.UNKNOWN_CAMERA_TYPE) : ev.r(fd.CAMERA_2D_HEADING_UP, fd.CAMERA_2D_NORTH_UP) : ev.q(fd.CAMERA_3D)).stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.hn.k
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                ff ffVar;
                                fd fdVar = (fd) obj;
                                int i2 = p.b;
                                fb fbVar = (fb) fg.a.q();
                                if (!fbVar.b.H()) {
                                    fbVar.v();
                                }
                                ad adVar2 = adVar;
                                fg fgVar2 = (fg) fbVar.b;
                                fgVar2.c = fdVar.e;
                                fgVar2.b |= 1;
                                boolean z4 = adVar2.c;
                                if (!fbVar.b.H()) {
                                    fbVar.v();
                                }
                                fg fgVar3 = (fg) fbVar.b;
                                fgVar3.b |= 2;
                                fgVar3.d = z4;
                                int iA2 = t.a(adVar2.e);
                                if (iA2 == 0) {
                                    iA2 = t.a;
                                }
                                boolean z5 = iA2 == t.c;
                                if (!fbVar.b.H()) {
                                    fbVar.v();
                                }
                                fg fgVar4 = (fg) fbVar.b;
                                fgVar4.b |= 4;
                                fgVar4.e = z5;
                                int iA3 = ac.a(adVar2.d);
                                if (iA3 == 0) {
                                    iA3 = ac.a;
                                }
                                int i3 = iA3 - 1;
                                if (iA3 == 0) {
                                    throw null;
                                }
                                if (i3 == 1) {
                                    ffVar = ff.FAR_VIEW_MODE;
                                } else if (i3 == 2) {
                                    ffVar = ff.NORMAL;
                                } else if (i3 == 3) {
                                    ffVar = ff.APPROACH;
                                } else if (i3 == 4) {
                                    ffVar = ff.INSPECT_STEP;
                                } else if (i3 == 5) {
                                    ffVar = ff.INSPECT_ROUTE;
                                } else if (i3 != 11) {
                                    ffVar = i3 != 12 ? ff.UNKNOWN_VIEW_MODE : ff.LIMITED_CONTROLLED_ACCESS_MANEUVER;
                                } else {
                                    ffVar = ff.ARRIVING;
                                }
                                if (!fbVar.b.H()) {
                                    fbVar.v();
                                }
                                fg fgVar5 = (fg) fbVar.b;
                                fgVar5.f = ffVar.j;
                                fgVar5.b |= 8;
                                return (fg) fbVar.t();
                            }
                        }).collect(com.google.android.libraries.navigation.internal.yz.br.a);
                        x xVar = agVar.d;
                        if (xVar == null) {
                            xVar = x.a;
                        }
                        ez ezVar = (ez) fa.a.q();
                        float f = xVar.b;
                        if (!ezVar.b.H()) {
                            ezVar.v();
                        }
                        fa faVar = (fa) ezVar.b;
                        faVar.b |= 1;
                        faVar.c = f;
                        float f2 = xVar.c;
                        if (!ezVar.b.H()) {
                            ezVar.v();
                        }
                        fa faVar2 = (fa) ezVar.b;
                        faVar2.b |= 2;
                        faVar2.d = f2;
                        fa faVar3 = (fa) ezVar.t();
                        no it2 = evVar.iterator();
                        while (it2.hasNext()) {
                            fg fgVar2 = (fg) it2.next();
                            ex exVar = (ex) ey.a.q();
                            if (!exVar.b.H()) {
                                exVar.v();
                            }
                            ey eyVar2 = (ey) exVar.b;
                            fgVar2.getClass();
                            eyVar2.c = fgVar2;
                            eyVar2.b |= 1;
                            if (!exVar.b.H()) {
                                exVar.v();
                            }
                            ey eyVar3 = (ey) exVar.b;
                            faVar3.getClass();
                            eyVar3.d = faVar3;
                            eyVar3.b |= 2;
                            ey eyVar4 = (ey) exVar.t();
                            fd fdVarB2 = fd.b(fgVar2.c);
                            if (fdVarB2 == null) {
                                fdVarB2 = fd.UNKNOWN_CAMERA_TYPE;
                            }
                            boolean z4 = fgVar2.d;
                            boolean z5 = fgVar2.e;
                            ff ffVarB2 = ff.b(fgVar2.f);
                            if (ffVarB2 == null) {
                                ffVarB2 = ff.UNKNOWN_VIEW_MODE;
                            }
                            map.put(new o(fdVarB2, z4, z5, ffVarB2), eyVar4);
                        }
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            listU.size();
            map.size();
            return map;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final boolean m() {
        return this.a.v;
    }

    public final boolean n() {
        return this.a.aB;
    }

    public final boolean o() {
        return this.a.av;
    }

    public final boolean p() {
        return this.a.aw;
    }

    public final boolean q() {
        return this.a.P;
    }

    public final boolean r() {
        return this.a.at;
    }

    public final boolean s() {
        return this.a.Q;
    }

    public final String toString() {
        ak akVarC = al.b(this).a("hmmBaselineTransitionLikelihood", Math.pow(10.0d, ((double) (-this.a.b)) * 0.1d)).a("hmmOffTheRoadLikelihoodThreshold", t(this.a.c)).c("hmmNumCandidatesToKeep", this.a.d).c("hmmMaxRoadNetworkRadiusMeters", this.a.e).c("hmmConnectivityToleranceWorld", this.a.f).c("hmmRouteMatchingToleranceWorld", this.a.g).c("hmmRoadNetworkBearingErrorStdDeg", this.a.h).a("hmmRouteLikelihoodWeight", t(this.a.i)).a("hmmTunnelEmissionLikelihood", t(this.a.j)).c("bearingNoiseThresholdCentimetersPerSec", this.a.k).c("bearingNoiseSpeedFalloffMs", this.a.l).c("gpsMinUpdateIntervalMs", this.a.m).c("navFirstTripUpdateIntervalSeconds", e()).c("navTripUpdateIntervalSeconds", g()).c("maxNavTripUpdateIntervalSeconds", this.a.J).c("navTrafficValidityPeriodSeconds", f()).c("navTrafficStatusDistanceKm", this.a.o).a("navOnRouteConfidenceThreshold", a()).c("prefetcherMaxKm", this.a.q).c("prefetcherMaxTilesPerRequest", this.a.r).c("prefetcherCacheProcessingDelayMs", this.a.s).c("prefetcherFetchProcessingDelayMs", this.a.t).c("vectorMinIconHeightForScalingPx", this.a.u).e("controllerUseAnimation", m()).c("voiceRmiEnablePercent", this.a.w).c("offlineReroutingEnablePercent", this.a.x).e("disablePowerManager", this.a.z).c("polylineSnappingRerouteBaseMeters", this.a.A).e("rasterMaps", this.a.B).e("disableIndoorMaps", this.a.C).e("disableImplicitDirectionSearch", this.a.D).c("betterTripPromptTimeoutSeconds", this.a.G).c("estimatedBatteryLifeSeconds", this.a.H).c("predictedBatteryDrainPercentToTriggerPowerSavings", this.a.I).c("maxUseTrafficInSavedDirectionsSeconds", this.a.K);
        akVarC.g("cameraParameters", u());
        ak akVarE = akVarC.e("enableGreyOutSelectedRoute", this.a.aH).e("enableNavToAddAStop", this.a.aI).e("enableCompassInNavigation", this.a.M);
        fn fnVarB = fn.b(this.a.aL);
        if (fnVarB == null) {
            fnVarB = fn.UNKNOWN_NAVIGATION_SDK_LOG_MECHANISM;
        }
        akVarE.g("getNavigationSdkLogMechanism", fnVarB);
        return akVarE.toString();
    }
}
