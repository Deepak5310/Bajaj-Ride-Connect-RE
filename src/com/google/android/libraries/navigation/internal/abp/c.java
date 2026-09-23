package com.google.android.libraries.navigation.internal.abp;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.abh.bi;
import com.google.android.libraries.navigation.internal.abh.hf;
import com.google.android.libraries.navigation.internal.abs.g;
import com.google.android.libraries.navigation.internal.abs.q;
import com.google.android.libraries.navigation.internal.abs.w;
import com.google.android.libraries.navigation.internal.abt.i;
import com.google.android.libraries.navigation.internal.abt.k;
import com.google.android.libraries.navigation.internal.abt.l;
import com.google.android.libraries.navigation.internal.abt.m;
import com.google.android.libraries.navigation.internal.abw.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements GLSurfaceView.Renderer, k {
    public static final String a = "c";
    public final m b;
    public final z c;
    public boolean d;
    public w e;
    private final h f;
    private final double g;
    private final com.google.android.libraries.navigation.internal.abs.b h;
    private final b i;
    private q j;
    private StreetViewPanoramaCamera k;
    private i l;
    private com.google.android.libraries.navigation.internal.abt.c m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.abt.c f145n;
    private com.google.android.libraries.navigation.internal.abt.a o;
    private double p;
    private final HashSet q;

    public c(m mVar, h hVar, double d) {
        z zVar = z.a;
        com.google.android.libraries.navigation.internal.abs.b bVar = com.google.android.libraries.navigation.internal.abs.b.a;
        b bVar2 = b.a;
        s.k(mVar, "tileProvider");
        this.b = mVar;
        s.b(true, "tileMemoryCacheSize[%s] < %s", 17, 2);
        s.k(hVar, "frameRequestor");
        this.f = hVar;
        s.h(d, "displayDensityRatio");
        this.g = d;
        s.b(d > 0.0d, "displayDensityRatio[%s] < 0", Double.valueOf(d));
        s.k(zVar, "uiThreadChecker");
        this.c = zVar;
        this.h = bVar;
        this.i = bVar2;
        synchronized (this) {
            this.d = false;
            this.e = null;
            this.j = null;
            this.k = hf.a;
            this.l = null;
            com.google.android.libraries.navigation.internal.abt.c cVar = com.google.android.libraries.navigation.internal.abt.c.a;
            this.m = cVar;
            this.f145n = cVar;
            this.o = null;
            this.p = 0.0d;
            this.q = new HashSet();
        }
    }

    private final synchronized q d() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abt.k
    public final void a(com.google.android.libraries.navigation.internal.abt.c cVar, com.google.android.libraries.navigation.internal.abt.c cVar2, com.google.android.libraries.navigation.internal.abt.a aVar, double d) {
        this.c.b();
        s.k(cVar, "fromPano");
        s.a(!cVar.i(), "Cannot blend from the null target");
        s.a(cVar2 == null || !cVar2.i(), "Cannot blend into the null target");
        s.b(d >= 0.0d && d <= 1.0d, "Invalid blendRatio %s", Double.valueOf(d));
        if (p.f(a, 2)) {
            String str = cVar.b;
        }
        this.m = cVar;
        if (cVar2 == null) {
            cVar2 = com.google.android.libraries.navigation.internal.abt.c.a;
        }
        this.f145n = cVar2;
        this.o = aVar;
        if (aVar == null) {
            d = 0.0d;
        }
        this.p = d;
    }

    public final synchronized void b(q qVar) {
        this.j = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abt.k
    public final void c(com.google.android.libraries.navigation.internal.abt.c cVar) {
        this.c.b();
        s.k(cVar, "panorama");
        if (p.f(a, 2)) {
            String str = cVar.b;
        }
        this.m = cVar;
        this.f145n = com.google.android.libraries.navigation.internal.abt.c.a;
        this.o = null;
        this.p = 0.0d;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        Double d;
        com.google.android.libraries.navigation.internal.abt.c cVar;
        com.google.android.libraries.navigation.internal.abt.c cVar2;
        com.google.android.libraries.navigation.internal.abt.a aVar;
        StreetViewPanoramaCamera streetViewPanoramaCamera;
        try {
            this.c.b();
            if (this.e == null) {
                p.f(a, 5);
                return;
            }
            if (this.l == null) {
                p.f(a, 5);
                return;
            }
            p.f(a, 2);
            q qVarD = d();
            if (qVarD != null) {
                i iVar = this.l;
                ((e) qVarD).k.b();
                s.k(iVar, "rendererRaycaster");
                com.google.android.libraries.navigation.internal.abv.m mVar = ((e) qVarD).g;
                p.f(com.google.android.libraries.navigation.internal.abv.m.a, 2);
                synchronized (mVar) {
                    if (mVar.f) {
                        p.f(com.google.android.libraries.navigation.internal.abv.m.a, 5);
                    } else if (mVar.d.isEmpty()) {
                        p.f(com.google.android.libraries.navigation.internal.abv.m.a, 2);
                    } else {
                        l lVar = mVar.e;
                        if (lVar == null) {
                            p.f(com.google.android.libraries.navigation.internal.abv.m.a, 2);
                            mVar.d.clear();
                        } else {
                            ArrayList arrayList = new ArrayList(mVar.d.size());
                            arrayList.addAll(mVar.d);
                            mVar.d.clear();
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                com.google.android.libraries.navigation.internal.abf.q qVar = (com.google.android.libraries.navigation.internal.abf.q) arrayList.get(i);
                                if (p.f(com.google.android.libraries.navigation.internal.abv.m.a, 3)) {
                                    Object obj = qVar.a;
                                    Object obj2 = qVar.b;
                                }
                                com.google.android.libraries.navigation.internal.abt.d dVar = (com.google.android.libraries.navigation.internal.abt.d) qVar.a;
                                Bitmap bitmap = (Bitmap) qVar.b;
                                p.f(w.a, 3);
                                s.k(dVar, "key");
                                com.google.android.libraries.navigation.internal.abs.p pVar = (com.google.android.libraries.navigation.internal.abs.p) ((w) lVar).e.get(dVar.a);
                                if (pVar != null) {
                                    pVar.c(dVar, bitmap);
                                } else {
                                    p.f(w.a, 5);
                                }
                            }
                            mVar.b.b();
                        }
                    }
                }
                com.google.android.libraries.navigation.internal.abq.i iVar2 = ((e) qVarD).i;
                c cVar3 = ((e) qVarD).f;
                iVar2.c.b();
                p.f(com.google.android.libraries.navigation.internal.abq.i.a, 2);
                s.k(cVar3, "renderer");
                synchronized (iVar2) {
                    d = iVar2.o;
                    cVar = iVar2.p;
                    cVar2 = iVar2.q;
                    aVar = iVar2.r;
                    iVar2.o = null;
                    iVar2.p = null;
                    iVar2.q = null;
                    iVar2.r = null;
                    streetViewPanoramaCamera = iVar2.v;
                    iVar2.v = null;
                }
                if (d != null) {
                    if (aVar != null) {
                        cVar3.a(cVar, cVar2, aVar, d.doubleValue());
                    } else if (cVar2 == null) {
                        cVar3.c(cVar);
                    } else if (cVar2.i()) {
                        cVar3.c(com.google.android.libraries.navigation.internal.abt.c.a);
                    } else if (cVar.i()) {
                        cVar3.c(cVar2);
                    } else {
                        cVar3.a(cVar, cVar2, null, 0.0d);
                    }
                }
                if (streetViewPanoramaCamera != null) {
                    cVar3.c.b();
                    p.f(a, 3);
                    cVar3.k = streetViewPanoramaCamera;
                    i iVar3 = cVar3.l;
                    if (iVar3 != null) {
                        cVar3.l = iVar3.b(streetViewPanoramaCamera);
                    }
                }
            }
            i iVar4 = this.l;
            GLES20.glViewport(0, 0, iVar4.h, iVar4.i);
            GLES20.glClear(16384);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            w wVar = this.e;
            com.google.android.libraries.navigation.internal.abt.c cVar4 = this.m;
            com.google.android.libraries.navigation.internal.abt.c cVar5 = this.f145n;
            com.google.android.libraries.navigation.internal.abt.a aVar2 = this.o;
            double d2 = this.p;
            i iVar5 = this.l;
            s.k(cVar4, "currentPano");
            s.k(cVar5, "transitioningToPano");
            s.b(d2 >= 0.0d && d2 <= 1.0d, "Invalid blendRatio %s", Double.valueOf(d2));
            s.k(iVar5, "rendererRaycaster");
            if (p.f(w.a, 2)) {
                String str = cVar4.b;
                String str2 = cVar5.b;
            }
            wVar.c.j(String.format("%s.onDrawFrame()::start", w.a));
            if (wVar.d == 0) {
                p.f(w.a, 6);
                z2 = false;
                z = true;
            } else {
                String str3 = cVar4.b;
                String str4 = cVar5.b;
                List list = (List) w.b.get();
                list.clear();
                for (String str5 : wVar.e.keySet()) {
                    if (!r.a(str5, str3) && !r.a(str5, str4)) {
                        list.add(str5);
                    }
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.abs.p) wVar.e.remove((String) it2.next())).a();
                }
                if (cVar4.i() && cVar5.i()) {
                    z = true;
                    z2 = true;
                } else {
                    com.google.android.libraries.navigation.internal.abs.p pVarA = wVar.a(cVar4);
                    com.google.android.libraries.navigation.internal.abs.p pVarA2 = wVar.a(cVar5);
                    boolean z4 = pVarA2 != null && pVarA2.g();
                    boolean z5 = aVar2 != null && z4;
                    double dMin = (aVar2 == null || z4) ? d2 : Math.min(d2, aVar2.a());
                    boolean z6 = z5;
                    z = true;
                    boolean zC = wVar.c(pVarA, z5 ? com.google.android.libraries.navigation.internal.abw.k.a(1.0d - d2) : 1.0d, dMin, aVar2 != null ? aVar2.d() : null, iVar5, cVar5.i());
                    boolean zC2 = wVar.c(pVarA2, true != z6 ? 0.0d : d2, com.google.android.libraries.navigation.internal.abw.k.a(1.0d - dMin), z6 ? aVar2.c() : null, iVar5, true);
                    wVar.c.j(String.format("%s.onDrawFrame()::end", w.a));
                    z2 = zC && zC2;
                }
            }
            this.q.clear();
            this.q.add(com.google.android.libraries.navigation.internal.abt.c.a);
            if (z2) {
                this.q.add(this.m);
                this.q.add(this.f145n);
            }
            if (qVarD != null) {
                i iVar6 = this.l;
                ((e) qVarD).k.b();
                s.k(iVar6, "rendererRaycaster");
                com.google.android.libraries.navigation.internal.abq.i iVar7 = ((e) qVarD).i;
                c cVar6 = ((e) qVarD).f;
                iVar7.c.b();
                p.f(com.google.android.libraries.navigation.internal.abq.i.a, 2);
                s.k(cVar6, "renderer");
                synchronized (iVar7) {
                    if (iVar7.s != null) {
                        cVar6.c.b();
                        if (cVar6.q.contains(iVar7.s.b())) {
                            iVar7.s.c();
                            iVar7.s = null;
                            z3 = z;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            iVar7.b.postDelayed(iVar7, 16L);
                        }
                    }
                }
                ((e) qVarD).l.b(iVar6);
                ((e) qVarD).m.c(iVar6);
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

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        try {
            this.c.b();
            p.f(a, 4);
            StreetViewPanoramaCamera streetViewPanoramaCamera = this.k;
            this.l = new i(streetViewPanoramaCamera.tilt, streetViewPanoramaCamera.bearing, streetViewPanoramaCamera.zoom, i, i2);
            w wVar = this.e;
            if (wVar != null) {
                p.f(w.a, 4);
                wVar.c.j(String.format("%s.onSurfaceChanged()::start", w.a));
                try {
                    wVar.d = 0;
                    wVar.b();
                    int iA = g.a(w.a, wVar.c);
                    wVar.d = iA;
                    if (iA == 0) {
                        wVar.c.j(String.format("%s.onSurfaceChanged()::failed", w.a));
                        throw new IllegalStateException("Failed to register GridMesh shader program!");
                    }
                } catch (RuntimeException unused) {
                    p.f(w.a, 6);
                }
                wVar.c.j(String.format("%s.onSurfaceChanged()::end", w.a));
            } else {
                p.c("onSurfaceChanged() called before onSurfaceCreated() or after onDestroy()");
            }
            q qVarD = d();
            if (qVarD != null) {
                qVarD.s(this.l);
            }
            this.f.b();
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

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.c.b();
            if (this.d) {
                p.f(a, 5);
                return;
            }
            if (this.e != null) {
                p.f(a, 4);
            } else {
                p.f(a, 4);
                w wVar = new w(this.b, this.f, this.g);
                this.e = wVar;
                this.b.b(wVar);
            }
            q qVarD = d();
            if (qVarD != null) {
                qVarD.t();
            }
            this.f.b();
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
