package com.google.android.libraries.navigation.internal.qq;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.bg;
import com.google.android.libraries.geo.mapcore.renderer.bh;
import com.google.android.libraries.geo.mapcore.renderer.bx;
import com.google.android.libraries.geo.mapcore.renderer.ca;
import com.google.android.libraries.geo.mapcore.renderer.eb;
import com.google.android.libraries.geo.mapcore.renderer.fa;
import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class al extends eb implements bh {
    public static final /* synthetic */ int r = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j u = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qq.al");
    private static final float[] v = {0.93f, 0.93f, 0.93f, 1.0f};
    private boolean A;
    private boolean B;
    private final com.google.android.libraries.geo.mapcore.renderer.ai C;
    private final br D;
    public final bx a;
    public ak b;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    public final com.google.android.libraries.navigation.internal.ni.a d;
    public bg e;
    public final com.google.android.libraries.navigation.internal.kg.c f;
    public volatile boolean g;
    public final com.google.android.libraries.navigation.internal.ia.e h;
    public com.google.android.libraries.navigation.internal.ox.c i;
    public final ca j;
    public final int k;
    public final com.google.android.libraries.navigation.internal.kl.b l;
    public final br m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final br f557n;
    public com.google.android.libraries.navigation.internal.pk.c o;
    public String p;
    public final ai q;
    private final List w;
    private final ct x;
    private long y;
    private final Executor z;

    public al(Resources resources, Context context, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ni.a aVar2, bx bxVar, ct ctVar, com.google.android.libraries.navigation.internal.kg.c cVar, Executor executor, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.kl.b bVar, final com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.geo.mapcore.renderer.ai aiVar) {
        super(resources.getDisplayMetrics().widthPixels, resources.getDisplayMetrics().heightPixels);
        this.w = new ArrayList();
        this.A = false;
        this.g = false;
        this.B = true;
        this.p = "";
        this.q = new ai(this);
        bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qq.aa
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i = al.r;
                return Boolean.valueOf(((kx) aVar3.a()).f166n);
            }
        });
        this.m = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qq.ab
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Integer.valueOf(((kx) aVar3.a()).p);
            }
        });
        this.D = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qq.ac
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i = al.r;
                return Boolean.valueOf(((kx) aVar3.a()).t);
            }
        });
        this.f557n = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qq.ad
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                int i = al.r;
                return Boolean.valueOf(((kx) aVar3.a()).v);
            }
        });
        this.c = aVar;
        this.d = aVar2;
        this.a = bxVar;
        if (bxVar != null) {
            bxVar.s(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qq.ae
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.libraries.navigation.internal.ox.c cVar2 = this.a.i;
                    if (cVar2 != null) {
                        cVar2.f();
                    }
                }
            });
            bxVar.t(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qq.af
                @Override // java.lang.Runnable
                public final void run() {
                    bg bgVar;
                    al alVar = this.a;
                    if (!((Boolean) alVar.f557n.a()).booleanValue() || (bgVar = alVar.e) == null) {
                        return;
                    }
                    bgVar.g();
                }
            });
        }
        this.x = ctVar;
        this.f = cVar;
        this.z = executor;
        this.h = eVar;
        this.C = aiVar;
        this.k = (int) (context instanceof Activity ? ((Activity) context).getWindowManager().getDefaultDisplay().getRefreshRate() : ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate());
        this.l = bVar;
        this.j = new ca(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qq.ag
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.ox.c cVar2 = this.a.i;
                if (cVar2 != null) {
                    cVar2.a();
                }
            }
        });
        float[] fArr = v;
        q(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private static void r(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) u.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1122)).w("GL error set on entry to %s, error=%d", str, iGlGetError);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final com.google.android.libraries.geo.mapcore.renderer.ai a() {
        return this.C;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void b() {
        this.a.k();
        com.google.android.libraries.navigation.internal.kg.c cVar = this.f;
        cVar.e = cVar.a.a() - cVar.d;
        int i = cVar.c + 1;
        if (i >= 100) {
            cVar.c = 0;
        } else {
            cVar.c = i;
        }
        cVar.i.a();
        long j = cVar.e;
        if (j <= 16) {
            cVar.f464n++;
        }
        if (j <= 33) {
            cVar.m++;
        }
        if (j > 50) {
            cVar.o++;
        }
        cVar.l++;
        int iMin = Math.min(99, (int) j);
        if (iMin >= 0 && iMin < 100) {
            int[] iArr = cVar.b;
            iArr[iMin] = iArr[iMin] + 1;
            cVar.h++;
        }
        cVar.f += cVar.e;
        cVar.g++;
        Iterator it2 = cVar.k.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.kg.a) it2.next()).a();
        }
        com.google.android.libraries.navigation.internal.ox.c cVar2 = this.i;
        ar.q(cVar2);
        cVar2.b();
        if (this.B) {
            this.B = false;
            this.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qq.z
                @Override // java.lang.Runnable
                public final void run() {
                    bg bgVar = this.a.e;
                    ar.q(bgVar);
                    bgVar.setTransparent(false);
                }
            });
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void c() {
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void d(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        r("onSurfaceChanged");
        this.s = new com.google.android.libraries.geo.mapcore.renderer.g(i, i2);
        this.a.i();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void e() {
        r("onSurfaceCreated");
        if (this.A) {
            ak akVar = this.b;
            if (akVar != null) {
                akVar.au();
            }
            synchronized (this.w) {
                Iterator it2 = this.w.iterator();
                while (it2.hasNext()) {
                    ((aj) it2.next()).au();
                }
            }
        }
        this.A = true;
        this.a.j();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void f() {
    }

    public final void g(aj ajVar) {
        synchronized (this.w) {
            if (this.w.contains(ajVar)) {
                return;
            }
            this.w.add(ajVar);
        }
    }

    public final void h(boolean z) {
        ar.q(this.i);
        if (z) {
            this.i.e();
        } else {
            this.i.d();
        }
    }

    public final void i(aj ajVar) {
        synchronized (this.w) {
            this.w.remove(ajVar);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void j() {
        this.a.w();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final boolean k() {
        return ((Boolean) this.D.a()).booleanValue() && this.a.x();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.eb
    public final boolean l() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final boolean m() {
        if (!this.g) {
            this.g = true;
        }
        this.c.c();
        ar.q(this.i);
        com.google.android.libraries.navigation.internal.kg.c cVar = this.f;
        boolean zH = this.i.h();
        long j = ((com.google.android.libraries.navigation.internal.ox.a) this.i).a;
        if (cVar.p == com.google.android.libraries.navigation.internal.kg.b.a) {
            if (zH && j == 30) {
                cVar.j.a();
            }
            cVar.j.b();
        }
        cVar.d = cVar.a.a();
        cVar.i.b();
        Iterator it2 = cVar.k.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.kg.a) it2.next()).b();
        }
        this.i.c();
        this.j.b();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GL_onDrawFrame");
        try {
            if (!this.x.d()) {
                ct ctVar = this.x;
                ah ahVar = new ah(this);
                synchronized (ctVar.a) {
                    if (ctVar.b) {
                        ahVar.a();
                    } else {
                        ctVar.a.add(ahVar);
                    }
                }
                ak akVar = this.b;
                if (akVar != null) {
                    akVar.y();
                }
                this.a.b().J(this.t, p(), o());
                this.a.b().q();
                if (dVarB != null) {
                    Trace.endSection();
                }
                return true;
            }
            ak akVar2 = this.b;
            if (akVar2 != null) {
                akVar2.z();
            }
            try {
                this.a.g();
            } catch (fa e) {
                long jA = this.c.a();
                long j2 = this.y;
                if (j2 != 0 && jA < 10000 + j2) {
                    throw new fa("GL context is unusable again after " + (jA - j2) + "ms", e);
                }
                this.y = jA;
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1123)).p("GL context is unusable. This may be due to an invalid shader, or may be due to bad GL state. Resetting GL context to attempt to recover.");
                bg bgVar = this.e;
                if (bgVar != null) {
                    bgVar.b();
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            this.j.a(p(), o());
            return true;
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
        if (dVarB != null) {
            Trace.endSection();
        }
        throw th;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bh
    public final void n() {
    }
}
