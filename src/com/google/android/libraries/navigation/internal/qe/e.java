package com.google.android.libraries.navigation.internal.qe;

import android.animation.TimeInterpolator;
import android.content.Context;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.libraries.navigation.internal.nt.p;
import com.google.android.libraries.navigation.internal.pb.m;
import com.google.android.libraries.navigation.internal.pb.q;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pb.y;
import com.google.android.libraries.navigation.internal.pi.ad;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.po.eo;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.pb.a, com.google.android.libraries.navigation.internal.pc.g {
    public final t a;
    public com.google.android.libraries.navigation.internal.pd.d b;
    public final com.google.android.libraries.navigation.internal.pd.a c;
    public boolean d;
    private final com.google.android.libraries.navigation.internal.pd.a e;
    private long f;
    private int g;
    private com.google.android.libraries.navigation.internal.pc.f h;
    private com.google.android.libraries.navigation.internal.pc.a i;
    private final com.google.android.libraries.navigation.internal.ni.a j;
    private final d k;
    private final q l;
    private final y m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c f552n;
    private final com.google.android.libraries.navigation.internal.pb.i o;
    private final com.google.android.libraries.navigation.internal.agl.a p;
    private final s q;
    private final p r;

    public e(Context context, t tVar, com.google.android.libraries.navigation.internal.pb.i iVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, s sVar) {
        com.google.android.libraries.navigation.internal.pd.a aVar3 = new com.google.android.libraries.navigation.internal.pd.a();
        this.e = aVar3;
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        this.c = new com.google.android.libraries.navigation.internal.pd.a();
        this.h = null;
        this.i = null;
        this.r = new p(false);
        this.a = tVar;
        this.j = aVar;
        this.p = aVar2;
        this.q = sVar;
        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
        this.b = dVarW;
        aVar3.b(dVarW);
        this.k = new d(context, tVar, aVar);
        this.l = new q(aVar, tVar);
        this.m = new y(aVar);
        this.f552n = new c(aVar, tVar);
        this.o = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.a
    public final com.google.android.libraries.navigation.internal.pd.j a() {
        if (this.d) {
            return new com.google.android.libraries.navigation.internal.pd.j(this.c.a(), this.f);
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.a
    public final synchronized int b() {
        fy fyVarO;
        this.o.e();
        com.google.android.libraries.navigation.internal.ni.a aVar = this.j;
        int i = this.g;
        int iA = this.o.a(aVar.a(), this.e);
        this.g = iA;
        this.r.c(Boolean.valueOf(iA != 0));
        com.google.android.libraries.navigation.internal.pd.d dVarA = this.e.a();
        this.b = dVarA;
        this.a.B(dVarA);
        if (i != 0 && this.g == 0) {
            com.google.android.libraries.navigation.internal.pc.a aVar2 = this.i;
            if (aVar2 != null) {
                synchronized (((eo) aVar2).a) {
                    Set set = ((eo) aVar2).a;
                    ar.q(set);
                    fyVarO = fy.o(set);
                }
                nn nnVarListIterator = fyVarO.listIterator();
                while (nnVarListIterator.hasNext()) {
                    ((com.google.android.libraries.navigation.internal.pc.d) nnVarListIterator.next()).a();
                }
            }
            com.google.android.libraries.navigation.internal.pc.f fVar = this.h;
            if (fVar != null) {
                fVar.b(this.b);
            }
        }
        notifyAll();
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized void c(com.google.android.libraries.navigation.internal.pd.d dVar, int i, TimeInterpolator timeInterpolator) {
        com.google.android.libraries.navigation.internal.pd.d dVarD = this.a.b.d(dVar);
        this.g = 6;
        this.r.c(true);
        if (((com.google.android.libraries.navigation.internal.om.j) this.p.a()).b() && i != 0 && !this.b.equals(dVarD)) {
            com.google.android.libraries.navigation.internal.pd.d dVar2 = this.b;
            this.l.m(dVar2, dVarD);
            if (i != -1) {
                this.l.p(i);
            }
            if (timeInterpolator != null) {
                this.l.f(timeInterpolator);
            }
            d(this.l);
            this.m.m(dVar2, dVarD);
            if (i != -1) {
                this.m.p(i);
            }
            if (timeInterpolator != null) {
                this.m.f(timeInterpolator);
            }
            d(this.m);
            return;
        }
        o(dVarD);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized void d(com.google.android.libraries.navigation.internal.pc.c cVar) {
        com.google.android.libraries.navigation.internal.pc.f fVar;
        if (!(this.a.c instanceof e)) {
            this.g = 0;
            this.r.c(false);
            return;
        }
        if (this.o.b(cVar) != 0) {
            this.a.e();
            this.c.b(this.b);
            this.d = this.o.f(this.c);
            this.f = this.j.a() + this.o.c();
            notifyAll();
            q qVar = this.l;
            if (cVar != qVar && !qVar.n() && (fVar = this.h) != null) {
                fVar.a();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized void e(com.google.android.libraries.navigation.internal.pc.a aVar) {
        this.i = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized void f(com.google.android.libraries.navigation.internal.pc.f fVar) {
        this.h = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized boolean g() {
        return this.g != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.g
    public final synchronized boolean h(com.google.android.libraries.navigation.internal.pd.a aVar) {
        return this.o.f(aVar);
    }

    final synchronized float i(float f) {
        float fW;
        this.k.m(this.b, null);
        d dVar = this.k;
        fW = dVar.w(f);
        d(dVar);
        return fW;
    }

    final synchronized float j() {
        d dVar = this.k;
        if (!dVar.D()) {
            return 0.0f;
        }
        float fT = dVar.t();
        if (Float.isNaN(fT)) {
            return 0.0f;
        }
        return fT;
    }

    final synchronized float k(float f, float f2, float f3) {
        float fX;
        this.k.m(this.b, null);
        d dVar = this.k;
        fX = dVar.x(f, f2, f3);
        d(dVar);
        return fX;
    }

    public final synchronized float l(float f, int i) {
        return m(this.b.k + f, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
    }

    public final synchronized float m(float f, int i) {
        this.f552n.m(this.b, null);
        c cVar = this.f552n;
        cVar.a = false;
        cVar.m = f;
        cVar.p = null;
        cVar.q = 330L;
        d(cVar);
        return m.b(f);
    }

    final synchronized void n() {
    }

    public final synchronized void o(com.google.android.libraries.navigation.internal.pd.d dVar) {
        com.google.android.libraries.navigation.internal.pd.d dVar2 = this.b;
        this.e.b(dVar);
        this.a.b.e(this.e);
        com.google.android.libraries.navigation.internal.pd.d dVarA = this.e.a();
        this.b = dVarA;
        this.l.m(dVar2, dVarA);
        this.l.p(0L);
        d(this.l);
        this.m.m(dVar2, this.b);
        this.m.p(0L);
        d(this.m);
    }

    public final synchronized void p(float f, float f2) {
        this.k.m(this.b, null);
        this.k.B(f, f2);
        d(this.k);
    }

    final synchronized void q(float[] fArr) {
        this.k.m(this.b, null);
        this.k.z(fArr);
        float fT = this.k.t();
        if (Float.isNaN(fT)) {
            this.q.i(new ad(this.k.n()));
        } else if (fT != 0.0f) {
            this.q.i(new ad(this.k.n() + fT));
        }
        d(this.k);
    }

    final synchronized void r() {
        this.k.y();
    }

    public final synchronized void s(float f) {
        this.k.m(this.b, null);
        this.k.C(f);
        d(this.k);
    }

    final synchronized void t(float f) {
        this.k.m(this.b, null);
        d dVar = this.k;
        dVar.u(f);
        d(dVar);
    }

    final synchronized void u(float f, float f2, float f3) {
        this.k.m(this.b, null);
        d dVar = this.k;
        dVar.v(f3, f, f2);
        d(dVar);
    }

    public final synchronized float v(float f, float f2) {
        this.f552n.m(this.b, null);
        float f3 = this.b.k + 1.0f;
        c cVar = this.f552n;
        cVar.a = true;
        cVar.m = f3;
        cVar.f550n = f;
        cVar.o = f2;
        cVar.p = null;
        cVar.q = 330L;
        d(cVar);
        return m.b(this.b.k + 1.0f);
    }
}
