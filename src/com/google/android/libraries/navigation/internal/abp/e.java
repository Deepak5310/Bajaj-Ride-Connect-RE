package com.google.android.libraries.navigation.internal.abp;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.RemoteException;
import android.view.Choreographer;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.gms.maps.aq;
import com.google.android.gms.maps.ar;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abf.ak;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.abh.be;
import com.google.android.libraries.navigation.internal.abh.he;
import com.google.android.libraries.navigation.internal.abh.hf;
import com.google.android.libraries.navigation.internal.abs.j;
import com.google.android.libraries.navigation.internal.abs.q;
import com.google.android.libraries.navigation.internal.abs.u;
import com.google.android.libraries.navigation.internal.abt.n;
import com.google.android.libraries.navigation.internal.abv.f;
import com.google.android.libraries.navigation.internal.abv.h;
import com.google.android.libraries.navigation.internal.abv.i;
import com.google.android.libraries.navigation.internal.abv.m;
import com.google.android.libraries.navigation.internal.abw.g;
import com.google.android.libraries.navigation.internal.ly.bv;
import com.google.android.libraries.navigation.internal.ly.bx;
import com.google.android.libraries.navigation.internal.ly.bz;
import com.google.android.libraries.navigation.internal.ly.cb;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.maps.api.android.lib6.common.apiexception.ExternalError;
import com.google.maps.api.android.lib6.common.apiexception.ExternalRuntimeException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends GLSurfaceView implements Executor, com.google.android.libraries.navigation.internal.abq.c, h, hf, he, q, com.google.android.libraries.navigation.internal.abq.h, ak {
    public static final String b = "e";
    private static f u;
    private int A;
    public final Context c;
    public final com.google.android.libraries.navigation.internal.abg.q d;
    public final com.google.android.libraries.navigation.internal.abw.h e;
    public final c f;
    public final m g;
    public final i h;
    public final com.google.android.libraries.navigation.internal.abq.i i;
    public final com.google.android.libraries.navigation.internal.abq.a j;
    public final z k;
    public final u l;
    public final com.google.android.libraries.navigation.internal.abs.m m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f146n;
    public final String o;
    public final String p;
    public boolean q;
    public boolean r;
    public he s;
    com.google.android.libraries.navigation.internal.abt.f t;
    private final com.google.android.libraries.navigation.internal.abi.d v;
    private final ExploreByTouchHelper w;
    private bz x;
    private cb y;
    private int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(be beVar, com.google.android.libraries.navigation.internal.abg.q qVar, f fVar, boolean z, double d, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, String str, String str2, z zVar) {
        super(beVar.a);
        s.k(beVar, "contextManager");
        Context context = beVar.a;
        this.c = context;
        s.k(qVar, "drd");
        this.d = qVar;
        s.k(charSequenceArr, "compassDirectionSuffixes");
        s.k(charSequenceArr2, "fullCompassDirections");
        s.k(str, "localizedYourLocationString");
        this.f146n = str;
        s.k(str2, "localizedInvalidPanoString");
        this.o = str2;
        this.p = "unknown location";
        s.k(zVar, "uiThreadChecker");
        this.k = zVar;
        synchronized (this) {
            this.q = false;
        }
        this.r = true;
        this.x = null;
        this.y = null;
        this.s = null;
        this.A = -1;
        this.z = -1;
        this.t = null;
        g gVar = new g(Choreographer.getInstance());
        this.e = gVar;
        this.l = new u(d, gVar, charSequenceArr);
        com.google.android.libraries.navigation.internal.abs.m mVar = new com.google.android.libraries.navigation.internal.abs.m(gVar, charSequenceArr2);
        this.m = mVar;
        j jVar = new j(mVar, this);
        this.w = jVar;
        com.google.android.libraries.navigation.internal.abq.i iVar = new com.google.android.libraries.navigation.internal.abq.i(this, gVar);
        this.i = iVar;
        iVar.c.a();
        p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
        if (!iVar.g) {
            iVar.i = this;
        }
        iVar.c.a();
        p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
        if (!iVar.g) {
            iVar.k = this;
        }
        com.google.android.libraries.navigation.internal.abq.a aVar = new com.google.android.libraries.navigation.internal.abq.a(this, d);
        this.j = aVar;
        com.google.android.libraries.navigation.internal.abi.d dVar = new com.google.android.libraries.navigation.internal.abi.d();
        this.v = dVar;
        dVar.a(context, aVar, z);
        i iVar2 = new i(fVar, qVar, ah.d);
        this.h = iVar2;
        iVar2.d(this);
        m mVar2 = new m(qVar, fVar, gVar, Bitmap.Config.ARGB_8888);
        this.g = mVar2;
        c cVar = new c(mVar2, gVar, d);
        this.f = cVar;
        cVar.b(this);
        setEGLContextClientVersion(2);
        setRenderer(cVar);
        setRenderMode(0);
        gVar.b = this;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        ViewCompat.setAccessibilityDelegate(this, jVar);
    }

    public static synchronized f j(Context context) {
        s.k(context, "clientApplicationContext");
        if (u == null) {
            String absolutePath = context.getCacheDir().getAbsolutePath();
            long j = f.a;
            s.k(absolutePath, "cacheDirPath");
            u = new f(com.google.android.libraries.navigation.internal.abw.f.a(absolutePath, 10, f.a, f.b), com.google.android.libraries.navigation.internal.abw.f.a(absolutePath, 10, f.a, f.c), com.google.android.libraries.navigation.internal.abw.f.a(absolutePath, 80, f.a, f.d));
        }
        return u;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final StreetViewPanoramaCamera a() {
        this.k.a();
        com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
        iVar.c.a();
        return iVar.t;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final StreetViewPanoramaLocation b() {
        this.k.a();
        com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
        iVar.c.a();
        if (iVar.m.i()) {
            return null;
        }
        return iVar.m.e();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final StreetViewPanoramaOrientation c(int i, int i2) {
        this.k.a();
        p.f(b, 4);
        com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
        iVar.c.a();
        p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
        if (iVar.g || iVar.m.i() || iVar.c() == null) {
            return null;
        }
        return iVar.l.a(i, i2);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return i();
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return i();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final void d(bv bvVar) {
        this.k.a();
        p.f(b, 4);
        com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
        iVar.c.a();
        p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
        if (iVar.g) {
            return;
        }
        iVar.j = bvVar;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        this.k.a();
        s.k(motionEvent, "MotionEvent");
        p.f(b, 4);
        return this.w.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final void e(bx bxVar) {
        this.k.a();
        p.f(b, 4);
        com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
        iVar.c.a();
        p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
        if (iVar.g) {
            return;
        }
        iVar.h = bxVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        s.k(runnable, "Runnable");
        queueEvent(runnable);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final void f(bz bzVar) {
        this.k.a();
        p.f(b, 4);
        this.x = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final void g(cb cbVar) {
        this.k.a();
        p.f(b, 4);
        this.y = cbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final void h(he heVar) {
        this.k.a();
        p.f(b, 4);
        this.s = heVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.hf
    public final boolean i() {
        this.k.a();
        return this.j.a;
    }

    public final void k(String str, LatLng latLng, Integer num, StreetViewSource streetViewSource, StreetViewPanoramaCamera streetViewPanoramaCamera, boolean z) {
        this.k.a();
        String str2 = b;
        p.f(str2, 4);
        if (str == null && latLng == null) {
            p.f(str2, 4);
            return;
        }
        this.z = -1;
        this.A = -1;
        if (str != null) {
            this.t = this.i.b(str, streetViewPanoramaCamera, z);
            i iVar = this.h;
            iVar.b.a();
            iVar.a(str, null, null, null);
            return;
        }
        this.t = null;
        i iVar2 = this.h;
        iVar2.b.a();
        s.k(latLng, "panoLatLng");
        iVar2.a(null, latLng, num, streetViewSource);
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void l(int i, int i2) {
        com.google.android.libraries.navigation.internal.abu.d dVar;
        StreetViewPanoramaCamera streetViewPanoramaCamera;
        int i3;
        com.google.android.libraries.navigation.internal.abu.b bVar;
        this.k.a();
        String str = b;
        p.f(str, 4);
        if (this.r) {
            com.google.android.libraries.navigation.internal.abt.c cVarA = this.i.a();
            if (cVarA.i()) {
                return;
            }
            com.google.android.libraries.navigation.internal.abu.a aVarG = cVarA.g();
            if (aVarG.c()) {
                StreetViewPanoramaOrientation streetViewPanoramaOrientationC = c(i, i2);
                if (streetViewPanoramaOrientationC == null) {
                    p.f(str, 4);
                    return;
                }
                n nVarF = cVarA.f();
                p.f(com.google.android.libraries.navigation.internal.abu.a.a, 4);
                s.k(nVarF, "world");
                float f = streetViewPanoramaOrientationC.tilt;
                s.i(f, "rayTiltDeg cannot be NaN");
                float f2 = streetViewPanoramaOrientationC.bearing;
                s.i(f2, "rayBearingDeg cannot be NaN");
                float f3 = nVarF.b;
                float f4 = f2 - f3;
                float radians = (float) Math.toRadians(f2);
                float radians2 = (float) Math.toRadians(f3);
                float radians3 = (float) Math.toRadians(nVarF.c);
                float radians4 = (float) Math.toRadians(nVarF.d);
                float radians5 = (float) Math.toRadians(f);
                float fCos = (float) Math.cos(radians - radians3);
                int iB = com.google.android.libraries.navigation.internal.abu.a.b(f, f4, aVarG.e);
                com.google.android.libraries.navigation.internal.abu.b bVar2 = iB == 0 ? null : aVarG.f[iB];
                int iB2 = com.google.android.libraries.navigation.internal.abu.a.b(f, f4, aVarG.c);
                com.google.android.libraries.navigation.internal.abu.c cVar = iB2 == 0 ? null : aVarG.d[iB2];
                if (bVar2 != null && !r.a(nVarF.a, bVar2.e) && cVar != null && !cVar.e) {
                    double d = radians - radians2;
                    float fSin = (float) Math.sin(d);
                    float fCos2 = (float) Math.cos(d);
                    double d2 = radians5 - (fCos * radians4);
                    float fSin2 = (float) Math.sin(d2);
                    float fCos3 = (float) Math.cos(d2);
                    float f5 = fSin * fCos3;
                    float f6 = fCos2 * fCos3;
                    Float fA = cVar.a(f5, f6, fSin2);
                    if (fA == null) {
                        dVar = new com.google.android.libraries.navigation.internal.abu.d(bVar2, cVar, null);
                        streetViewPanoramaCamera = null;
                    } else {
                        float fFloatValue = f5 * fA.floatValue();
                        float fFloatValue2 = f6 * fA.floatValue();
                        float fFloatValue3 = fSin2 * fA.floatValue();
                        float f7 = bVar2.f;
                        float f8 = fFloatValue2 - bVar2.g;
                        float f9 = fFloatValue - f7;
                        float fSqrt = (float) Math.sqrt((f9 * f9) + (f8 * f8) + (fFloatValue3 * fFloatValue3));
                        float fAtan2 = (float) Math.atan2(f9 / fSqrt, f8 / fSqrt);
                        float fAsin = (float) Math.asin(fFloatValue3 / fSqrt);
                        float f10 = fAtan2 + radians2;
                        float degrees = (float) Math.toDegrees(f10);
                        float degrees2 = (float) Math.toDegrees(fAsin + (radians4 * ((float) Math.cos(f10 - radians3))));
                        p.f(com.google.android.libraries.navigation.internal.abu.a.a, 3);
                        dVar = new com.google.android.libraries.navigation.internal.abu.d(bVar2, cVar, new StreetViewPanoramaOrientation(degrees2, degrees));
                        i3 = 4;
                        streetViewPanoramaCamera = null;
                    }
                    p.f(str, i3);
                    bVar = dVar.a;
                    if (bVar != null || r.a(cVarA.b, bVar.e)) {
                        p.f(str, 4);
                    }
                    com.google.android.libraries.navigation.internal.abu.c cVar2 = dVar.b;
                    if (cVar2 != null && !cVar2.e && dVar.c != null) {
                        float f11 = a().zoom;
                        StreetViewPanoramaOrientation streetViewPanoramaOrientation = dVar.c;
                        streetViewPanoramaCamera = new StreetViewPanoramaCamera(f11, streetViewPanoramaOrientation.tilt, streetViewPanoramaOrientation.bearing);
                    }
                    p.f(str, 4);
                    k(dVar.a.e, null, null, null, streetViewPanoramaCamera, true);
                    return;
                }
                if (p.f(com.google.android.libraries.navigation.internal.abu.a.a, 3)) {
                    String str2 = nVarF.a;
                }
                streetViewPanoramaCamera = null;
                dVar = new com.google.android.libraries.navigation.internal.abu.d(bVar2, cVar, null);
                i3 = 4;
                p.f(str, i3);
                bVar = dVar.a;
                if (bVar != null) {
                }
                p.f(str, 4);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void m(int i, int i2) {
        this.k.a();
        String str = b;
        p.f(str, 2);
        if (this.z == -1) {
            return;
        }
        p.f(str, 2);
        int iA = this.m.a(i, i2);
        this.A = iA;
        int i3 = this.z;
        if (iA == i3) {
            this.m.b(i3);
        } else {
            this.m.b(-1);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void n() {
        this.k.a();
        String str = b;
        p.f(str, 4);
        int i = this.z;
        if (i == -1 || i != this.A) {
            this.z = -1;
            this.A = -1;
            return;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocationB = b();
        if (streetViewPanoramaLocationB != null) {
            int i2 = this.z;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr = streetViewPanoramaLocationB.links;
            if (i2 < streetViewPanoramaLinkArr.length) {
                k(streetViewPanoramaLinkArr[i2].panoId, null, null, null, null, true);
                return;
            }
        }
        p.f(str, 5);
        this.z = -1;
        this.A = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void o(int i, int i2) {
        this.k.a();
        p.f(b, 4);
        cb cbVar = this.y;
        if (cbVar == null) {
            return;
        }
        try {
            ((ar) cbVar).a.onStreetViewPanoramaLongClick(c(i, i2));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (Error e2) {
            throw new ExternalError(e2);
        } catch (RuntimeException e3) {
            throw new ExternalRuntimeException(e3);
        }
    }

    @Override // android.opengl.GLSurfaceView, com.google.android.libraries.navigation.internal.abh.hf
    public final void onPause() {
        this.k.a();
        p.f(b, 4);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView, com.google.android.libraries.navigation.internal.abh.hf
    public final void onResume() {
        this.k.a();
        p.f(b, 4);
        super.onResume();
        this.e.b();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.k.a();
        s.k(motionEvent, "MotionEvent");
        p.f(b, 2);
        if (this.i.a().i()) {
            return true;
        }
        this.v.e(motionEvent);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void p(com.google.android.libraries.navigation.internal.abq.b bVar) {
        this.k.a();
        p.f(b, 4);
        this.i.d(bVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abv.h
    public final void q(com.google.android.libraries.navigation.internal.abt.c cVar) {
        this.k.a();
        String str = b;
        p.f(str, 4);
        if (cVar.i()) {
            p.f(str, 6);
            com.google.android.libraries.navigation.internal.abt.f fVar = this.t;
            if (fVar == null || !fVar.c || fVar.b.i()) {
                com.google.android.libraries.navigation.internal.abq.i iVar = this.i;
                iVar.c.a();
                p.f(com.google.android.libraries.navigation.internal.abq.i.a, 4);
                if (iVar.g) {
                    new com.google.android.libraries.navigation.internal.abt.f(com.google.android.libraries.navigation.internal.abt.c.a);
                } else {
                    iVar.e(new com.google.android.libraries.navigation.internal.abt.f(iVar.m));
                }
            } else {
                com.google.android.libraries.navigation.internal.abt.f fVar2 = this.t;
                if (fVar2 != null) {
                    com.google.android.libraries.navigation.internal.abq.i iVar2 = this.i;
                    com.google.android.libraries.navigation.internal.abt.c cVar2 = fVar2.b;
                    iVar2.b(cVar2.b, null, false).g(cVar2);
                }
            }
        } else {
            com.google.android.libraries.navigation.internal.abt.f fVar3 = this.t;
            if (fVar3 == null || !fVar3.g(cVar)) {
                p.f(str, 4);
                this.i.b(cVar.b, null, false).g(cVar);
            }
        }
        this.t = null;
        this.i.run();
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final void r(int i, int i2) {
        this.k.a();
        p.f(b, 4);
        bz bzVar = this.x;
        if (bzVar == null) {
            return;
        }
        try {
            ((aq) bzVar).a.onStreetViewPanoramaClick(c(i, i2));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (Error e2) {
            throw new ExternalError(e2);
        } catch (RuntimeException e3) {
            throw new ExternalRuntimeException(e3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void s(com.google.android.libraries.navigation.internal.abt.i iVar) {
        this.k.b();
        s.k(iVar, "rendererRaycaster");
        u uVar = this.l;
        uVar.c.b();
        uVar.d();
        com.google.android.libraries.navigation.internal.abs.m mVar = this.m;
        mVar.e.b();
        p.f(com.google.android.libraries.navigation.internal.abs.m.a, 4);
        mVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void t() {
        this.k.b();
        u uVar = this.l;
        uVar.c.b();
        uVar.d();
        com.google.android.libraries.navigation.internal.abs.m mVar = this.m;
        mVar.e.b();
        p.f(com.google.android.libraries.navigation.internal.abs.m.a, 4);
        mVar.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abq.h
    public final void u(com.google.android.libraries.navigation.internal.abt.c cVar) {
        ev evVar;
        this.k.a();
        s.k(cVar, "pano");
        u uVar = this.l;
        uVar.c.a();
        s.k(cVar, "pano");
        synchronized (uVar) {
            if (p.f(u.a, 4)) {
                String str = uVar.i.b;
                String str2 = cVar.b;
            }
            if (!r.a(uVar.i, cVar)) {
                uVar.i = cVar;
                uVar.b.b();
            }
        }
        com.google.android.libraries.navigation.internal.abs.m mVar = this.m;
        mVar.e.a();
        s.k(cVar, "pano");
        synchronized (mVar) {
            if (p.f(com.google.android.libraries.navigation.internal.abs.m.a, 4)) {
                String str3 = mVar.g.b;
                String str4 = cVar.b;
            }
            if (r.a(mVar.g, cVar)) {
                return;
            }
            mVar.g = cVar;
            if (cVar.i()) {
                evVar = null;
            } else {
                s.d(!cVar.i(), "NULL_TARGET");
                evVar = cVar.m;
            }
            mVar.h = evVar;
            mVar.i = -1;
            mVar.j = null;
            mVar.k = null;
            mVar.c.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abq.c
    public final boolean v(int i, int i2) {
        this.k.a();
        String str = b;
        p.f(str, 4);
        int iA = this.m.a(i, i2);
        this.z = iA;
        this.A = iA;
        this.m.b(iA);
        p.f(str, 4);
        return this.z != -1;
    }
}
