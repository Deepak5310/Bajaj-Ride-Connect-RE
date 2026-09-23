package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.fm;
import com.google.android.libraries.navigation.internal.adg.gl;
import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.adg.jr;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae extends com.google.android.libraries.navigation.internal.ol.ar implements com.google.android.libraries.navigation.internal.abh.cq {
    public static final jr a = jr.WORLD_ENCODING_LAT_LNG_DOUBLE;
    static final List b;
    public final com.google.android.libraries.navigation.internal.ol.z c;
    public final com.google.android.libraries.navigation.internal.abh.cr d;
    public final df e;
    public final com.google.android.libraries.navigation.internal.abf.z f;
    public final int g;
    public final com.google.android.libraries.navigation.internal.adg.ap h;
    public final z i;
    public boolean j;
    public boolean k;
    private final Executor l;
    private final gl m;

    static {
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        b = Arrays.asList(fValueOf, fValueOf, fValueOf2, fValueOf, fValueOf2, fValueOf2, fValueOf, fValueOf2);
    }

    public ae(com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.abh.cr crVar, int i) {
        z zVar2 = new z(zVar);
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        df dfVar = df.b;
        com.google.android.libraries.navigation.internal.abf.z zVar3 = com.google.android.libraries.navigation.internal.abf.z.a;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.c = zVar;
        this.d = crVar;
        this.g = i;
        this.i = zVar2;
        this.l = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(dfVar, "multiZoomStyleFactoryPhoenix");
        this.e = dfVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar3, "uiThreadChecker");
        this.f = zVar3;
        this.j = false;
        this.k = false;
        this.h = (com.google.android.libraries.navigation.internal.adg.ap) com.google.android.libraries.navigation.internal.adg.aq.a.q();
        this.m = (gl) gm.a.q();
    }

    private static LatLng f(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.oe.x xVar2, double d) {
        com.google.android.libraries.navigation.internal.oe.x xVarC = xVar.C(xVar2);
        xVarC.U(-d);
        xVarC.S(xVar2);
        return new LatLng(xVarC.b(), xVarC.d());
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.ad
            @Override // java.lang.Runnable
            public final void run() {
                ae aeVar = this.a;
                aeVar.f.a();
                if (aeVar.j && !aeVar.k && aeVar.d.E()) {
                    com.google.android.libraries.navigation.internal.abh.cr crVar = aeVar.d;
                    crVar.c.a();
                    fm fmVar = crVar.a;
                    com.google.android.libraries.navigation.internal.ly.ah ahVar = fmVar.b;
                    if (ahVar == null) {
                        fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_CLICK_WITHOUT_LISTENER);
                        return;
                    }
                    try {
                        ((com.google.android.gms.maps.j) ahVar).a.onGroundOverlayClick(new GroundOverlay(crVar));
                        fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.GROUND_OVERLAY_CLICK_WITH_LISTENER);
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
            }
        });
    }

    public final float c() {
        if (this.d.F()) {
            return this.d.A();
        }
        return 0.0f;
    }

    public final com.google.android.libraries.navigation.internal.ol.as d() {
        if (this.d.E()) {
            return this;
        }
        return null;
    }

    public final void e() {
        double[] dArr;
        LatLngBounds latLngBoundsD = this.d.D();
        LatLng latLngH = this.d.h();
        double dA = this.d.a();
        com.google.android.libraries.navigation.internal.abf.s.k(latLngBoundsD, "bounds");
        com.google.android.libraries.navigation.internal.abf.s.k(latLngH, "anchor");
        if (dA == 0.0d) {
            LatLng latLng = latLngBoundsD.northeast;
            double d = latLng.latitude;
            LatLng latLng2 = latLngBoundsD.southwest;
            double d2 = latLng2.latitude;
            double d3 = latLng2.longitude;
            double d4 = latLng.longitude;
            if (d3 > d4 && d4 == -180.0d) {
                d4 = 180.0d;
            }
            dArr = new double[]{d, d3, d, d4, d2, d4, d2, d3};
        } else {
            LatLng latLng3 = latLngBoundsD.northeast;
            com.google.android.libraries.navigation.internal.oe.x xVarA = com.google.android.libraries.navigation.internal.oe.x.A(latLng3.latitude, latLng3.longitude);
            LatLng latLng4 = latLngBoundsD.southwest;
            com.google.android.libraries.navigation.internal.oe.x xVarA2 = com.google.android.libraries.navigation.internal.oe.x.A(latLng4.latitude, latLng4.longitude);
            com.google.android.libraries.navigation.internal.oe.x xVarA3 = com.google.android.libraries.navigation.internal.oe.x.A(latLngBoundsD.northeast.latitude, latLngBoundsD.southwest.longitude);
            com.google.android.libraries.navigation.internal.oe.x xVarA4 = com.google.android.libraries.navigation.internal.oe.x.A(latLngBoundsD.southwest.latitude, latLngBoundsD.northeast.longitude);
            com.google.android.libraries.navigation.internal.oe.x xVarA5 = com.google.android.libraries.navigation.internal.oe.x.A(latLngH.latitude, latLngH.longitude);
            double radians = Math.toRadians(dA);
            LatLng latLngF = f(xVarA, xVarA5, radians);
            LatLng latLngF2 = f(xVarA2, xVarA5, radians);
            LatLng latLngF3 = f(xVarA3, xVarA5, radians);
            LatLng latLngF4 = f(xVarA4, xVarA5, radians);
            dArr = new double[]{latLngF3.latitude, latLngF3.longitude, latLngF.latitude, latLngF.longitude, latLngF4.latitude, latLngF4.longitude, latLngF2.latitude, latLngF2.longitude};
        }
        gl glVar = this.m;
        com.google.android.libraries.navigation.internal.ael.x xVarB = com.google.android.libraries.navigation.internal.on.k.b(dArr);
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm gmVar = (gm) glVar.b;
        gm gmVar2 = gm.a;
        gmVar.b |= 1;
        gmVar.c = xVarB;
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm gmVar3 = (gm) glVar.b;
        gmVar3.b |= 2;
        gmVar3.f = 4;
        if (!glVar.b.H()) {
            glVar.v();
        }
        gm.d((gm) glVar.b);
        if (!glVar.b.H()) {
            glVar.v();
        }
        ((gm) glVar.b).e = com.google.android.libraries.navigation.internal.ael.ay.a;
        glVar.c(b);
        com.google.android.libraries.navigation.internal.adg.ap apVar = this.h;
        gl glVar2 = this.m;
        if (!apVar.b.H()) {
            apVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.aq aqVar = (com.google.android.libraries.navigation.internal.adg.aq) apVar.b;
        gm gmVar4 = (gm) glVar2.t();
        com.google.android.libraries.navigation.internal.adg.aq aqVar2 = com.google.android.libraries.navigation.internal.adg.aq.a;
        gmVar4.getClass();
        aqVar.c = gmVar4;
        aqVar.b |= 1;
    }
}
