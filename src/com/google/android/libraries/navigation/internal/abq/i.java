package com.google.android.libraries.navigation.internal.abq;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.maps.ao;
import com.google.android.gms.maps.ap;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.libraries.navigation.internal.abf.ak;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.abh.gi;
import com.google.android.libraries.navigation.internal.abh.gk;
import com.google.android.libraries.navigation.internal.abh.hb;
import com.google.android.libraries.navigation.internal.abh.hc;
import com.google.android.libraries.navigation.internal.abh.he;
import com.google.android.libraries.navigation.internal.abh.hf;
import com.google.android.libraries.navigation.internal.abw.k;
import com.google.android.libraries.navigation.internal.ly.bv;
import com.google.android.libraries.navigation.internal.ly.bx;
import com.google.maps.api.android.lib6.common.apiexception.ExternalError;
import com.google.maps.api.android.lib6.common.apiexception.ExternalRuntimeException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Runnable {
    public static final String a = "i";
    public final Handler b;
    public final z c;
    final Runnable d;
    final Runnable e;
    final com.google.android.libraries.navigation.internal.agl.a f;
    public boolean g;
    public bx h;
    public he i;
    public bv j;
    public h k;
    public com.google.android.libraries.navigation.internal.abt.i l;
    public com.google.android.libraries.navigation.internal.abt.c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.android.libraries.navigation.internal.abt.f f147n;
    public Double o;
    public com.google.android.libraries.navigation.internal.abt.c p;
    public com.google.android.libraries.navigation.internal.abt.c q;
    public com.google.android.libraries.navigation.internal.abt.a r;
    public com.google.android.libraries.navigation.internal.abt.f s;
    public StreetViewPanoramaCamera t;
    public b u;
    public StreetViewPanoramaCamera v;
    private final ak w;
    private final com.google.android.libraries.navigation.internal.abw.h x;
    private final com.google.android.libraries.navigation.internal.abf.a y;
    private final d z;

    public i(ak akVar, com.google.android.libraries.navigation.internal.abw.h hVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        z zVar = z.a;
        com.google.android.libraries.navigation.internal.abf.a aVar = com.google.android.libraries.navigation.internal.abf.a.a;
        d dVar = new d();
        this.w = akVar;
        s.k(hVar, "frameRequestor");
        this.x = hVar;
        this.b = handler;
        s.k(zVar, "uiThreadChecker");
        this.c = zVar;
        this.y = aVar;
        this.z = dVar;
        this.d = new Runnable() { // from class: com.google.android.libraries.navigation.internal.abq.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        };
        this.e = new Runnable() { // from class: com.google.android.libraries.navigation.internal.abq.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        };
        this.f = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.abq.g
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                i iVar = this.a;
                iVar.c.a();
                p.f(i.a, 2);
                com.google.android.libraries.navigation.internal.abt.i iVar2 = null;
                if (!iVar.g && !iVar.m.i() && iVar.c() != null) {
                    iVar2 = iVar.l;
                }
                if (iVar2 != null) {
                    return iVar2;
                }
                throw new IllegalStateException("Raycaster requested before View layout.");
            }
        };
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = com.google.android.libraries.navigation.internal.abt.c.a;
        this.f147n = null;
        this.t = hf.a;
        this.u = null;
        this.l = null;
        synchronized (this) {
            this.o = null;
            com.google.android.libraries.navigation.internal.abt.c cVar = com.google.android.libraries.navigation.internal.abt.c.a;
            this.p = cVar;
            this.q = cVar;
            this.r = null;
            this.s = null;
            this.v = null;
        }
    }

    public final com.google.android.libraries.navigation.internal.abt.c a() {
        this.c.a();
        return this.m;
    }

    public final com.google.android.libraries.navigation.internal.abt.f b(String str, StreetViewPanoramaCamera streetViewPanoramaCamera, boolean z) {
        com.google.android.libraries.navigation.internal.abu.b bVar;
        com.google.android.libraries.navigation.internal.abt.f fVar;
        this.c.a();
        String str2 = a;
        p.f(str2, 4);
        s.k(str, "destinationPanoId");
        if (this.g) {
            return new com.google.android.libraries.navigation.internal.abt.f(com.google.android.libraries.navigation.internal.abt.c.a);
        }
        this.c.a();
        p.f(str2, 4);
        s.k(str, "destinationPanoId");
        if (this.m.i()) {
            fVar = new com.google.android.libraries.navigation.internal.abt.f(this.m, str, streetViewPanoramaCamera, z);
        } else {
            com.google.android.libraries.navigation.internal.abu.a aVarG = this.m.g();
            if (str != null && aVarG.c()) {
                com.google.android.libraries.navigation.internal.abu.b[] bVarArr = aVarG.f;
                int length = bVarArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        com.google.android.libraries.navigation.internal.abu.b bVar2 = bVarArr[i];
                        if (bVar2 != null && r.a(bVar2.e, str)) {
                            bVar = bVar2;
                            break;
                        }
                        i++;
                    } else {
                        bVar = null;
                        break;
                    }
                }
            } else {
                bVar = null;
                break;
            }
            if (bVar == null) {
                fVar = new com.google.android.libraries.navigation.internal.abt.f(this.m, str, streetViewPanoramaCamera, z);
            } else {
                com.google.android.libraries.navigation.internal.abt.c cVar = this.m;
                s.k(cVar, "srcPanoTarget");
                fVar = new com.google.android.libraries.navigation.internal.abt.f(cVar, bVar.e, bVar, streetViewPanoramaCamera, z, com.google.android.libraries.navigation.internal.abt.f.a);
            }
        }
        e(fVar);
        return fVar;
    }

    public final com.google.android.libraries.navigation.internal.abt.i c() {
        this.c.a();
        ak akVar = this.w;
        int width = akVar.getWidth();
        int height = akVar.getHeight();
        if (width == 0 || height == 0) {
            p.f(a, 3);
            this.l = null;
            return null;
        }
        com.google.android.libraries.navigation.internal.abt.i iVar = this.l;
        if (iVar == null) {
            p.f(a, 4);
            com.google.android.libraries.navigation.internal.abt.i iVar2 = new com.google.android.libraries.navigation.internal.abt.i(this.t, width, height);
            this.l = iVar2;
            return iVar2;
        }
        if (width != iVar.h || height != iVar.i) {
            p.f(a, 4);
            com.google.android.libraries.navigation.internal.abt.i iVar3 = new com.google.android.libraries.navigation.internal.abt.i(this.t, width, height);
            this.l = iVar3;
            return iVar3;
        }
        if (r.a(new StreetViewPanoramaCamera(iVar.g, iVar.e, iVar.f), this.t)) {
            return this.l;
        }
        p.f(a, 2);
        com.google.android.libraries.navigation.internal.abt.i iVarB = this.l.b(this.t);
        this.l = iVarB;
        return iVarB;
    }

    public final void d(b bVar) {
        this.c.a();
        p.f(a, 4);
        if (this.g) {
            return;
        }
        this.u = bVar;
        run();
    }

    public final void e(com.google.android.libraries.navigation.internal.abt.f fVar) {
        this.c.a();
        p.f(a, 4);
        if (this.k != null && !fVar.f()) {
            this.k.u(com.google.android.libraries.navigation.internal.abt.c.a);
        }
        this.f147n = fVar;
        StreetViewPanoramaCamera streetViewPanoramaCamera = fVar.e;
        if (streetViewPanoramaCamera != null) {
            this.u = new com.google.android.libraries.navigation.internal.abr.b(streetViewPanoramaCamera, 1.0d, fVar.c);
        }
        run();
    }

    final void f() {
        this.c.a();
        if (this.g) {
            return;
        }
        p.f(a, 2);
        bv bvVar = this.j;
        if (bvVar != null) {
            try {
                ((ap) bvVar).a.onStreetViewPanoramaCameraChange(this.t);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (Error e2) {
                throw new ExternalError(e2);
            } catch (RuntimeException e3) {
                throw new ExternalRuntimeException(e3);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0053  */
    final void g() {
        String str;
        this.c.a();
        if (this.g) {
            return;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocationE = this.m.i() ? null : this.m.e();
        if (this.m.i()) {
            str = "";
        } else {
            com.google.android.libraries.navigation.internal.abt.c cVar = this.m;
            s.d(!cVar.i(), "NULL_TARGET");
            if (cVar.e.booleanValue()) {
                com.google.android.libraries.navigation.internal.abt.c cVar2 = this.m;
                s.d(!cVar2.i(), "NULL_TARGET");
                s.d(cVar2.e.booleanValue(), "hasCopyright");
                str = cVar2.f;
            } else {
                str = "";
            }
        }
        p.f(a, 4);
        h hVar = this.k;
        if (hVar != null) {
            hVar.u(this.m);
        }
        he heVar = this.i;
        if (heVar != null) {
            final com.google.android.libraries.navigation.internal.abp.e eVar = (com.google.android.libraries.navigation.internal.abp.e) heVar;
            eVar.k.a();
            s.k(str, "copyrightStr");
            p.f(com.google.android.libraries.navigation.internal.abp.e.b, 4);
            if (com.google.android.libraries.navigation.internal.abh.b.a(eVar.c)) {
                com.google.android.libraries.navigation.internal.abt.c cVarA = eVar.i.a();
                if (cVarA.i()) {
                    eVar.setContentDescription(String.format("%s: %s", eVar.f146n, eVar.o));
                } else {
                    s.d(!cVarA.i(), "NULL_TARGET");
                    gk gkVar = new gk(cVarA.d, 21.0f);
                    final String str2 = cVarA.b;
                    gkVar.b = new gi() { // from class: com.google.android.libraries.navigation.internal.abp.d
                        @Override // com.google.android.libraries.navigation.internal.abh.gi
                        public final void a(gk gkVar2) {
                            String str3 = str2;
                            s.k(str3, "requestedPanoId");
                            e eVar2 = eVar;
                            com.google.android.libraries.navigation.internal.abt.c cVarA2 = eVar2.i.a();
                            if (cVarA2.i() || !r.a(str3, cVarA2.b)) {
                                return;
                            }
                            if (gkVar2.k() <= 0) {
                                eVar2.setContentDescription(String.format("%s: %s", eVar2.f146n, eVar2.p));
                            } else {
                                eVar2.setContentDescription(String.format("%s: %s", eVar2.f146n, gkVar2.l().a()));
                            }
                        }
                    };
                    eVar.d.j(gkVar);
                }
            } else {
                eVar.setContentDescription("");
            }
            he heVar2 = eVar.s;
            if (heVar2 != null) {
                boolean z = (streetViewPanoramaLocationE == null || com.google.android.libraries.navigation.internal.abf.e.b) ? false : true;
                final hc hcVar = ((hb) heVar2).a;
                hcVar.c.a(str);
                hcVar.c.a.setVisibility(true != z ? 8 : 0);
                if (streetViewPanoramaLocationE != null && com.google.android.libraries.navigation.internal.abh.b.a(hcVar.d.a)) {
                    gk gkVar2 = new gk(streetViewPanoramaLocationE.position, 21.0f);
                    gkVar2.b = new gi() { // from class: com.google.android.libraries.navigation.internal.abh.ha
                        @Override // com.google.android.libraries.navigation.internal.abh.gi
                        public final void a(gk gkVar3) {
                            if (gkVar3.k() > 0) {
                                hc hcVar2 = hcVar;
                                gj gjVarL = gkVar3.l();
                                ((View) hcVar2.a).announceForAccessibility(hcVar2.d.n(com.google.android.gms.maps.am.i) + ": " + gjVarL.a());
                            }
                        }
                    };
                    hcVar.e.j(gkVar2);
                }
            }
        }
        bx bxVar = this.h;
        if (bxVar != null) {
            try {
                ((ao) bxVar).a.onStreetViewPanoramaChange(streetViewPanoramaLocationE);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (Error e2) {
                throw new ExternalError(e2);
            } catch (RuntimeException e3) {
                throw new ExternalRuntimeException(e3);
            }
        }
    }

    public final void h(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) {
        this.c.a();
        p.f(a, 4);
        s.k(streetViewPanoramaCamera, "camera");
        if (this.g) {
            return;
        }
        d(j == 0 ? new com.google.android.libraries.navigation.internal.abr.c(streetViewPanoramaCamera) : new com.google.android.libraries.navigation.internal.abr.b(streetViewPanoramaCamera, j / 1000.0d, false));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0201  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f8  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        boolean z3;
        float fPow;
        float f;
        this.c.a();
        String str = a;
        p.f(str, 2);
        if (this.g) {
            return;
        }
        this.b.removeCallbacks(this);
        if (this.f147n == null && this.u == null) {
            this.x.b();
            return;
        }
        z zVar = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zVar.a();
        int i = Integer.MAX_VALUE;
        if (this.f147n == null) {
            z2 = false;
        } else {
            p.f(str, 2);
            com.google.android.libraries.navigation.internal.abt.c cVarB = this.f147n.b();
            synchronized (this) {
                this.o = Double.valueOf(this.f147n.a(jCurrentTimeMillis * 0.001d));
                z = this.f147n.e() && cVarB != null && this.f147n.d();
                if (z) {
                    this.p = cVarB;
                    this.q = null;
                    this.r = null;
                    this.s = null;
                } else {
                    com.google.android.libraries.navigation.internal.abt.f fVar = this.f147n;
                    this.p = fVar.b;
                    this.q = cVarB;
                    this.r = fVar.d;
                    this.s = fVar;
                }
            }
            if (this.f147n.e()) {
                if (cVarB == null) {
                    p.f(str, 2);
                } else if (z) {
                    p.f(str, 4);
                    this.f147n = null;
                    this.m = cVarB;
                    d dVar = this.z;
                    s.k(cVarB, "pano");
                    if (cVarB.i()) {
                        dVar.b = false;
                        dVar.l = Integer.MAX_VALUE;
                    } else if (!dVar.b || !r.a(dVar.c, cVarB.b)) {
                        dVar.b = true;
                        dVar.c = cVarB.b;
                        s.d(!cVarB.i(), "NULL_TARGET");
                        dVar.d = cVarB.k.floatValue();
                        s.d(!cVarB.i(), "NULL_TARGET");
                        dVar.e = cVarB.l.floatValue();
                        dVar.f = cVarB.a();
                        dVar.g = cVarB.b();
                        dVar.a();
                    }
                    this.b.postDelayed(this.d, 0L);
                    this.x.b();
                } else {
                    p.f(str, 2);
                    this.x.b();
                }
                z2 = false;
            } else {
                p.f(str, 2);
                this.x.b();
                z2 = true;
            }
        }
        z zVar2 = this.c;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        zVar2.a();
        if (this.u == null) {
            z2 = z2;
            z3 = false;
        } else {
            p.f(str, 2);
            ak akVar = this.w;
            int width = akVar.getWidth();
            int height = akVar.getHeight();
            if (width == 0 || height == 0) {
                z2 = z2;
                p.f(str, 3);
            } else {
                d dVar2 = this.z;
                if (width == 0 || height == 0) {
                    dVar2.h = false;
                    dVar2.l = Integer.MAX_VALUE;
                } else if (!dVar2.h || dVar2.i != width || dVar2.j != height) {
                    dVar2.h = true;
                    dVar2.i = width;
                    dVar2.j = height;
                    dVar2.k = k.d(width, height, 90.0d);
                    dVar2.a();
                }
                d dVar3 = this.z;
                b bVar = this.u;
                StreetViewPanoramaCamera streetViewPanoramaCamera = this.t;
                com.google.android.libraries.navigation.internal.agl.a aVar = this.f;
                if (dVar3.b && dVar3.h) {
                    i = dVar3.l;
                }
                StreetViewPanoramaCamera streetViewPanoramaCameraA = bVar.a(streetViewPanoramaCamera, aVar, i, jCurrentTimeMillis2 * 0.001d);
                if (streetViewPanoramaCameraA != null && dVar3.b && dVar3.h) {
                    float f2 = streetViewPanoramaCameraA.zoom;
                    float f3 = dVar3.l;
                    float f4 = streetViewPanoramaCameraA.tilt;
                    float fI = k.i(f2, 0.0f, f3);
                    float f5 = dVar3.e;
                    float f6 = dVar3.d;
                    boolean z4 = f5 < 90.0f;
                    boolean z5 = f6 > -90.0f;
                    if (z4) {
                        fPow = (float) (Math.pow(2.0d, -fI) * 0.5d * dVar3.k);
                        if (f5 - f6 <= fPow + fPow) {
                            f = (f6 + f5) / 2.0f;
                        } else if (!z4 && f4 + fPow > f5) {
                            f = f5 - fPow;
                        } else if (z5 || f4 - fPow >= f6) {
                            f = f4;
                        } else {
                            f = f6 + fPow;
                        }
                    } else if (z5) {
                        z5 = true;
                        fPow = (float) (Math.pow(2.0d, -fI) * 0.5d * dVar3.k);
                        if (f5 - f6 <= fPow + fPow) {
                            f = (f6 + f5) / 2.0f;
                        } else if (!z4) {
                            if (z5) {
                                f = f4;
                            } else {
                                f = f4;
                            }
                        } else if (z5) {
                            f = f4;
                        } else {
                            f = f4;
                        }
                    } else {
                        f = f4;
                    }
                    if (f != f4 || fI != f2) {
                        streetViewPanoramaCameraA = new StreetViewPanoramaCamera(fI, f, streetViewPanoramaCameraA.bearing);
                    }
                }
                p.f(str, 2);
                if (streetViewPanoramaCameraA != null && !r.a(streetViewPanoramaCameraA, this.t)) {
                    this.t = streetViewPanoramaCameraA;
                    synchronized (this) {
                        this.v = streetViewPanoramaCameraA;
                    }
                    this.x.b();
                    this.b.postDelayed(this.e, 0L);
                }
                if (this.u.b()) {
                    p.f(str, 4);
                    this.u = null;
                    z3 = false;
                }
            }
            z3 = true;
        }
        if (z2 || z3) {
            this.b.postDelayed(this, 16L);
        }
    }
}
