package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.graphics.Point;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abh.bi;
import com.google.maps.api.android.lib6.common.apiexception.ExternalError;
import com.google.maps.api.android.lib6.common.apiexception.ExternalRuntimeException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hc extends com.google.android.libraries.navigation.internal.ly.ci implements View.OnClickListener {
    private static final String j = "hc";
    public final hf a;
    public final com.google.android.libraries.navigation.internal.abf.z b;
    public final hd c;
    public final be d;
    public final com.google.android.libraries.navigation.internal.abg.q e;
    public final bl f;
    public final boolean g;
    public boolean h;
    public String i;
    private final FrameLayout k;
    private final ht l;
    private final hi m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Executor f125n;
    private final hl o;
    private final hk p;
    private final StreetViewPanoramaCamera q;
    private final m r;

    protected hc(m mVar, be beVar, hf hfVar, com.google.android.libraries.navigation.internal.abf.z zVar, hd hdVar, FrameLayout frameLayout, ht htVar, hi hiVar, com.google.android.libraries.navigation.internal.abg.q qVar, Executor executor, hl hlVar, hk hkVar, bl blVar, boolean z, StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.r = mVar;
        this.d = beVar;
        this.a = hfVar;
        this.b = zVar;
        this.c = hdVar;
        this.k = frameLayout;
        this.l = htVar;
        this.m = hiVar;
        this.e = qVar;
        this.f125n = executor;
        com.google.android.libraries.navigation.internal.abf.s.k(hlVar, "streetViewQuotaEventReporter");
        this.o = hlVar;
        com.google.android.libraries.navigation.internal.abf.s.k(hkVar, "streetViewQuotaEventListener");
        this.p = hkVar;
        this.f = blVar;
        this.g = z;
        this.q = streetViewPanoramaCamera;
        this.h = false;
        this.i = "";
    }

    public static hc G(StreetViewPanoramaOptions streetViewPanoramaOptions, be beVar, m mVar) {
        try {
            com.google.android.libraries.navigation.internal.abf.s.k(streetViewPanoramaOptions, "StreetViewPanoramaOptions");
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "ContextManager");
            com.google.android.libraries.navigation.internal.abf.s.k(mVar, "AppEnvironment");
            dd.a(beVar, mVar);
            Context context = beVar.a;
            FrameLayout frameLayout = new FrameLayout(beVar.i());
            bc bcVar = mVar.a;
            gh ghVar = mVar.h;
            gu guVar = mVar.f;
            com.google.android.libraries.navigation.internal.abx.b bVar = com.google.android.libraries.navigation.internal.abx.b.RENDERER_STREETVIEW_ONLY_ONE_RENDERER;
            ht htVarB = ht.b(context, mVar.b, "H", mVar.m, null);
            htVarB.c(bVar);
            boolean z = com.google.android.libraries.navigation.internal.abf.e.f;
            com.google.android.libraries.navigation.internal.ly.cs csVar = ((com.google.android.libraries.navigation.internal.ly.ct) ghVar).d;
            String str = com.google.android.libraries.navigation.internal.abp.e.b;
            com.google.android.libraries.navigation.internal.abf.s.k(beVar, "ContextManager");
            com.google.android.libraries.navigation.internal.abf.s.k(mVar, "AppEnvironment");
            com.google.android.libraries.navigation.internal.abp.e eVar = new com.google.android.libraries.navigation.internal.abp.e(beVar, (com.google.android.libraries.navigation.internal.abg.q) mVar.a.b.a(), com.google.android.libraries.navigation.internal.abp.e.j(beVar.a), z, beVar.b(), beVar.q(com.google.android.gms.maps.ai.a), beVar.q(com.google.android.gms.maps.ai.b), beVar.n(com.google.android.gms.maps.am.i), beVar.n(com.google.android.gms.maps.am.m), com.google.android.libraries.navigation.internal.abf.z.a);
            hd hdVar = new hd(beVar);
            StreetViewPanoramaCamera streetViewPanoramaCamera = streetViewPanoramaOptions.getStreetViewPanoramaCamera();
            if (streetViewPanoramaCamera == null) {
                streetViewPanoramaCamera = hf.a;
            }
            String panoramaId = streetViewPanoramaOptions.getPanoramaId();
            LatLng position = streetViewPanoramaOptions.getPosition();
            Integer radius = streetViewPanoramaOptions.getRadius();
            StreetViewSource source = streetViewPanoramaOptions.getSource();
            if (com.google.android.libraries.navigation.internal.abw.k.r(streetViewPanoramaCamera)) {
                eVar.i.h(streetViewPanoramaCamera, 0L);
            } else if (streetViewPanoramaCamera != null) {
                com.google.android.libraries.navigation.internal.abf.p.c("Invalid StreetViewPanoramaCamera ignored: ".concat(streetViewPanoramaCamera.toString()));
            }
            eVar.k(panoramaId, position, radius, source, null, false);
            hi hiVar = new hi(context);
            bl blVar = new bl(beVar);
            blVar.a.setVisibility(8);
            frameLayout.addView(eVar);
            frameLayout.addView(hdVar.a);
            frameLayout.addView(blVar.a);
            boolean z2 = streetViewPanoramaOptions.getUseViewLifecycleInFragment() != null && streetViewPanoramaOptions.getUseViewLifecycleInFragment().booleanValue();
            StreetViewPanoramaCamera streetViewPanoramaCamera2 = streetViewPanoramaOptions.getStreetViewPanoramaCamera() != null ? streetViewPanoramaOptions.getStreetViewPanoramaCamera() : hf.a;
            htVarB.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_CREATED);
            hc hcVar = new hc(mVar, beVar, eVar, com.google.android.libraries.navigation.internal.abf.z.a, hdVar, frameLayout, htVarB, hiVar, (com.google.android.libraries.navigation.internal.abg.q) bcVar.b.a(), com.google.android.libraries.navigation.internal.abf.ah.a(), mVar.d, mVar.e, blVar, z2, streetViewPanoramaCamera2);
            hcVar.a.h(new hb(hcVar));
            hcVar.c.c.setOnClickListener(hcVar);
            if (streetViewPanoramaOptions.getUserNavigationEnabled() != null) {
                hcVar.h(streetViewPanoramaOptions.getUserNavigationEnabled().booleanValue());
            }
            if (streetViewPanoramaOptions.getZoomGesturesEnabled() != null) {
                hcVar.i(streetViewPanoramaOptions.getZoomGesturesEnabled().booleanValue());
            }
            if (streetViewPanoramaOptions.getPanningGesturesEnabled() != null) {
                hcVar.f(streetViewPanoramaOptions.getPanningGesturesEnabled().booleanValue());
            }
            if (streetViewPanoramaOptions.getStreetNamesEnabled() != null) {
                hcVar.g(streetViewPanoramaOptions.getStreetNamesEnabled().booleanValue());
            }
            hk hkVar = hcVar.p;
            hkVar.c.a();
            com.google.android.libraries.navigation.internal.abf.p.f(hk.a, 4);
            hkVar.d.add(hcVar);
            hkVar.a();
            return hcVar;
        } catch (Throwable th) {
            bi.c(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.libraries.navigation.internal.abh.hf, java.util.concurrent.Executor] */
    public final void A() {
        try {
            hk hkVar = this.p;
            hkVar.c.a();
            com.google.android.libraries.navigation.internal.abf.p.f(hk.a, 4);
            hkVar.d.remove(this);
            E();
            ?? r0 = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) r0).k.a();
            synchronized (r0) {
                if (((com.google.android.libraries.navigation.internal.abp.e) r0).q) {
                    com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 5);
                    return;
                }
                ((com.google.android.libraries.navigation.internal.abp.e) r0).q = true;
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
                ((com.google.android.libraries.navigation.internal.abp.e) r0).e.b = null;
                final com.google.android.libraries.navigation.internal.abp.c cVar = ((com.google.android.libraries.navigation.internal.abp.e) r0).f;
                cVar.c.a();
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.c.a, 4);
                r0.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abp.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar2 = cVar;
                        try {
                            cVar2.c.b();
                            if (cVar2.d) {
                                p.f(c.a, 5);
                                return;
                            }
                            cVar2.d = true;
                            if (cVar2.e == null) {
                                p.f(c.a, 5);
                                return;
                            }
                            p.f(c.a, 4);
                            cVar2.b.b(null);
                            cVar2.e.b();
                            cVar2.e = null;
                        } catch (Throwable th) {
                            bi.a(th);
                            if (th instanceof RuntimeException) {
                                throw ((RuntimeException) th);
                            }
                            if (!(th instanceof Error)) {
                                throw new RuntimeException(th);
                            }
                            throw ((Error) th);
                        }
                    }
                });
                final com.google.android.libraries.navigation.internal.abs.u uVar = ((com.google.android.libraries.navigation.internal.abp.e) r0).l;
                uVar.c.a();
                r0.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abs.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        u uVar2 = uVar;
                        uVar2.c.b();
                        if (uVar2.d) {
                            com.google.android.libraries.navigation.internal.abf.p.f(u.a, 6);
                            return;
                        }
                        uVar2.d = true;
                        uVar2.a();
                        uVar2.f = com.google.android.libraries.navigation.internal.abt.c.a;
                    }
                });
                ((com.google.android.libraries.navigation.internal.abp.e) r0).m.e.a();
                com.google.android.libraries.navigation.internal.abv.m mVar = ((com.google.android.libraries.navigation.internal.abp.e) r0).g;
                synchronized (mVar) {
                    if (mVar.f) {
                        com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abv.m.a, 5);
                    } else {
                        com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abv.m.a, 4);
                        mVar.f = true;
                        mVar.c.clear();
                        mVar.d.clear();
                        mVar.e = null;
                    }
                }
                ((com.google.android.libraries.navigation.internal.abp.e) r0).h.b();
                com.google.android.libraries.navigation.internal.abq.i iVar = ((com.google.android.libraries.navigation.internal.abp.e) r0).i;
                iVar.c.a();
                if (iVar.g) {
                    com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abq.i.a, 5);
                    return;
                }
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
                iVar.g = true;
                synchronized (iVar) {
                    iVar.o = null;
                    iVar.v = null;
                }
                iVar.f147n = null;
                iVar.u = null;
                iVar.m = com.google.android.libraries.navigation.internal.abt.c.a;
                iVar.t = hf.a;
                iVar.l = null;
                iVar.h = null;
                iVar.i = null;
                iVar.j = null;
                iVar.k = null;
                iVar.b.removeCallbacks(iVar);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void B() {
        try {
            this.r.a();
            this.a.onPause();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void C() {
        try {
            this.r.b();
            this.a.onResume();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void D(Bundle bundle) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            com.google.android.libraries.navigation.internal.afu.d.h();
            b();
            StreetViewPanoramaLocation streetViewPanoramaLocationC = c();
            if (streetViewPanoramaLocationC != null) {
                String str = streetViewPanoramaLocationC.panoId;
                bundle.putString(ViewProps.POSITION, str);
                hl hlVar = this.o;
                hlVar.b.a();
                if (str != null) {
                    hlVar.c.put(str, Long.valueOf(System.currentTimeMillis()));
                    hlVar.b();
                }
            }
            com.google.android.libraries.navigation.internal.abf.p.f(j, 3);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final void E() {
        this.a.h(null);
        this.a.e(null);
        this.a.d(null);
        this.a.f(null);
        this.a.g(null);
    }

    final boolean F() {
        if (!this.h) {
            return false;
        }
        com.google.android.libraries.navigation.internal.abf.p.c(this.i);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final com.google.android.libraries.navigation.internal.lo.l a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            this.b.a();
            Point point = null;
            if (F()) {
                return new com.google.android.libraries.navigation.internal.lo.n(null);
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_PROJECT_TO_POINT);
            if (streetViewPanoramaOrientation == null) {
                return new com.google.android.libraries.navigation.internal.lo.n(null);
            }
            hf hfVar = this.a;
            float f = streetViewPanoramaOrientation.tilt;
            float f2 = streetViewPanoramaOrientation.bearing;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            com.google.android.libraries.navigation.internal.abq.i iVar = ((com.google.android.libraries.navigation.internal.abp.e) hfVar).i;
            iVar.c.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
            if (!iVar.g && !iVar.m.i() && iVar.c() != null) {
                com.google.android.libraries.navigation.internal.abt.i iVar2 = iVar.l;
                if (com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abt.i.a, 4)) {
                    iVar2.toString();
                }
                com.google.android.libraries.navigation.internal.abf.s.i(f, "tiltDeg cannot be NaN");
                com.google.android.libraries.navigation.internal.abf.s.i(f2, "bearingDeg cannot be NaN");
                com.google.android.libraries.navigation.internal.abf.s.f(f, com.google.android.libraries.navigation.internal.b.b.h(f, "illegal tilt: "));
                com.google.android.libraries.navigation.internal.abt.h hVar = (com.google.android.libraries.navigation.internal.abt.h) com.google.android.libraries.navigation.internal.abt.i.b.get();
                float[] fArr = hVar.a;
                float[] fArr2 = hVar.b;
                double dSin = Math.sin(com.google.android.libraries.navigation.internal.abw.k.m(f2));
                double dCos = Math.cos(com.google.android.libraries.navigation.internal.abw.k.m(f2));
                double dSin2 = Math.sin(com.google.android.libraries.navigation.internal.abw.k.m(f));
                double dCos2 = Math.cos(com.google.android.libraries.navigation.internal.abw.k.m(f));
                fArr2[0] = (float) (dSin * dCos2);
                fArr2[1] = (float) dSin2;
                fArr2[2] = (float) (dCos * dCos2);
                fArr2[3] = 1.0f;
                if (com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abt.i.a, 3)) {
                    Arrays.toString(fArr2);
                }
                Matrix.multiplyMV(fArr, 0, iVar2.e(), 0, fArr2, 0);
                if (com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abt.i.a, 3)) {
                    Arrays.toString(fArr);
                }
                float f3 = ((float) iVar2.q) / fArr[2];
                for (int i = 0; i < 4; i++) {
                    fArr[i] = fArr[i] * f3;
                }
                point = new Point((int) (((double) fArr[0]) + (((double) iVar2.h) * 0.5d)), (int) ((((double) iVar2.i) * 0.5d) - ((double) fArr[1])));
            }
            return new com.google.android.libraries.navigation.internal.lo.n(point);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final StreetViewPanoramaCamera b() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.h()) {
                this.b.a();
                return F() ? hf.a : this.a.a();
            }
            this.b.a();
            return F() ? hf.a : this.a.a();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final StreetViewPanoramaLocation c() {
        try {
            if (com.google.android.libraries.navigation.internal.afu.d.h()) {
                this.b.a();
                if (F()) {
                    return null;
                }
                return this.a.b();
            }
            this.b.a();
            if (F()) {
                return null;
            }
            return this.a.b();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final StreetViewPanoramaOrientation d(com.google.android.libraries.navigation.internal.lo.l lVar) {
        try {
            this.b.a();
            if (F()) {
                return null;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_PROJECT_TO_ORIENTATION);
            Point point = (Point) com.google.android.libraries.navigation.internal.lo.n.b(lVar);
            if (point == null) {
                return null;
            }
            return this.a.c(point.x, point.y);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void e(StreetViewPanoramaCamera streetViewPanoramaCamera, long j2) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_ANIMATE_TO);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.s.k(streetViewPanoramaCamera, "camera");
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            if (com.google.android.libraries.navigation.internal.abw.k.r(streetViewPanoramaCamera)) {
                ((com.google.android.libraries.navigation.internal.abp.e) hfVar).i.h(streetViewPanoramaCamera, j2);
            } else {
                com.google.android.libraries.navigation.internal.abf.p.c("Invalid StreetViewPanoramaCamera ignored: ".concat(String.valueOf(String.valueOf(streetViewPanoramaCamera))));
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void f(boolean z) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_ENABLE_PANNING);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).j.a = z;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void g(boolean z) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_ENABLE_STREET_NAMES);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            com.google.android.libraries.navigation.internal.abs.u uVar = ((com.google.android.libraries.navigation.internal.abp.e) hfVar).l;
            uVar.c.a();
            synchronized (uVar) {
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abs.u.a, 4);
                if (uVar.h == z) {
                    return;
                }
                uVar.h = z;
                uVar.b.b();
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void h(boolean z) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_ENABLE_NAVIGATION);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).r = z;
            com.google.android.libraries.navigation.internal.abs.m mVar = ((com.google.android.libraries.navigation.internal.abp.e) hfVar).m;
            mVar.e.a();
            synchronized (mVar) {
                com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abs.m.a, 4);
                if (mVar.f != z) {
                    mVar.f = z;
                    mVar.c.b();
                }
            }
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).e.b();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void i(boolean z) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_ENABLE_ZOOM);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).j.b = z;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void j(com.google.android.libraries.navigation.internal.ly.bv bvVar) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_CAMERA_CHANGE_LISTENER);
            this.a.d(bvVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void k(com.google.android.libraries.navigation.internal.ly.bx bxVar) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_CHANGE_LISTENER);
            this.a.e(bxVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void l(com.google.android.libraries.navigation.internal.ly.bz bzVar) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_CLICK_LISTENER);
            this.a.f(bzVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void m(com.google.android.libraries.navigation.internal.ly.cb cbVar) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_LONG_CLICK_LISTENER);
            this.a.g(cbVar);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void n(LatLng latLng) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(null, latLng, null, null, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void o(String str) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_ID);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(str, null, null, null, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!F() && view == this.c.c) {
                hi hiVar = this.m;
                StreetViewPanoramaLocation streetViewPanoramaLocationB = this.a.b();
                StreetViewPanoramaCamera streetViewPanoramaCameraA = this.a.a();
                com.google.android.libraries.navigation.internal.abf.s.k(streetViewPanoramaLocationB, "StreetViewPanoramaLocation");
                com.google.android.libraries.navigation.internal.abf.s.k(streetViewPanoramaCameraA, "StreetViewPanoramaCamera");
                hiVar.a(String.format("https://%s/cbk?cb_client=%s&output=report&panoid=%s&&cbp=%s", "cbk0.google.com", "an_mobile", streetViewPanoramaLocationB.panoId, String.format(Locale.US, "1,%f,,%f,%f", Float.valueOf(streetViewPanoramaCameraA.bearing), Float.valueOf(streetViewPanoramaCameraA.zoom), Float.valueOf(-streetViewPanoramaCameraA.tilt))));
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void p(LatLng latLng, int i) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_RADIUS);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(null, latLng, Integer.valueOf(i), null, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void q(LatLng latLng, int i, StreetViewSource streetViewSource) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            if (streetViewSource != null) {
                int i2 = streetViewSource.a;
                if (!StreetViewSource.a(i2)) {
                    com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized StreetViewSource value [%s], using StreetViewSource.DEFAULT value instead.", Integer.valueOf(i2)));
                }
            }
            if (com.google.android.libraries.navigation.internal.abf.r.a(streetViewSource, StreetViewSource.OUTDOOR)) {
                this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_OUTDOOR);
            } else {
                this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_RADIUS_AND_SOURCE_DEFAULT);
            }
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(null, latLng, Integer.valueOf(i), streetViewSource, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final void r(LatLng latLng, StreetViewSource streetViewSource) {
        try {
            this.b.a();
            if (F()) {
                return;
            }
            if (streetViewSource != null) {
                int i = streetViewSource.a;
                if (!StreetViewSource.a(i)) {
                    com.google.android.libraries.navigation.internal.abf.p.c(String.format("Unrecognized StreetViewSource value [%s], using StreetViewSource.DEFAULT value instead.", Integer.valueOf(i)));
                }
            }
            if (com.google.android.libraries.navigation.internal.abf.r.a(streetViewSource, StreetViewSource.OUTDOOR)) {
                this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_SOURCE_OUTDOOR);
            } else {
                this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_POSITION_WITH_SOURCE_DEFAULT);
            }
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(null, latLng, null, streetViewSource, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final boolean s() {
        try {
            this.b.a();
            if (F()) {
                return false;
            }
            return this.a.i();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final boolean t() {
        try {
            this.b.a();
            if (F()) {
                return false;
            }
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            return ((com.google.android.libraries.navigation.internal.abp.e) hfVar).l.c();
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final boolean u() {
        try {
            this.b.a();
            if (F()) {
                return false;
            }
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            return ((com.google.android.libraries.navigation.internal.abp.e) hfVar).r;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.cj
    public final boolean v() {
        try {
            this.b.a();
            if (F()) {
                return false;
            }
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            return ((com.google.android.libraries.navigation.internal.abp.e) hfVar).j.b;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    public final View w() {
        try {
            return this.k;
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    public final void x(final com.google.android.libraries.navigation.internal.ly.cd cdVar) {
        try {
            this.b.a();
            this.l.c(com.google.android.libraries.navigation.internal.abx.b.PANORAMA_SET_ON_PANORAMA_READY_CALLBACK);
            this.f125n.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.gz
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.y(cdVar);
                }
            });
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }

    public final /* synthetic */ void y(com.google.android.libraries.navigation.internal.ly.cd cdVar) {
        try {
            cdVar.a(this);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (Error e2) {
            throw new ExternalError(e2);
        } catch (RuntimeException e3) {
            throw new ExternalRuntimeException(e3);
        }
    }

    public final void z(Bundle bundle) {
        try {
            if (F()) {
                this.o.a("");
                return;
            }
            StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.libraries.navigation.internal.ly.cq.c(bundle, "camera");
            if (streetViewPanoramaCamera == null) {
                streetViewPanoramaCamera = this.q;
            }
            String string = bundle.containsKey(ViewProps.POSITION) ? bundle.getString(ViewProps.POSITION) : "";
            this.o.a(string);
            com.google.android.libraries.navigation.internal.abf.p.f(j, 3);
            hf hfVar = this.a;
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k.a();
            com.google.android.libraries.navigation.internal.abf.s.k(streetViewPanoramaCamera, "StreetViewPanoramaCamera");
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            if (com.google.android.libraries.navigation.internal.abw.k.r(streetViewPanoramaCamera)) {
                ((com.google.android.libraries.navigation.internal.abp.e) hfVar).i.h(streetViewPanoramaCamera, 0L);
            } else {
                com.google.android.libraries.navigation.internal.abf.p.c("Invalid StreetViewPanoramaCamera ignored: ".concat(String.valueOf(String.valueOf(streetViewPanoramaCamera))));
            }
            if (com.google.android.libraries.navigation.internal.abf.x.a(string)) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.abp.e) hfVar).k(string, null, null, null, null, false);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }
}
