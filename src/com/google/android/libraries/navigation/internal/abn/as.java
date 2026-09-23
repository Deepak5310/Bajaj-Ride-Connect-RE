package com.google.android.libraries.navigation.internal.abn;

import android.view.MotionEvent;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.libraries.navigation.internal.abh.cp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as implements com.google.android.libraries.navigation.internal.pn.j {
    public static final double a = Math.log(2.0d);
    private static final String g = "as";
    public float b;
    public float c;
    public bl d;
    public cp e;
    public com.google.android.libraries.navigation.internal.afo.a f;
    private final float h;
    private final float i;
    private MotionEvent j;
    private final z k;
    private final c l;
    private final com.google.android.libraries.navigation.internal.abf.z m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final aq f144n;
    private boolean o;
    private boolean p;
    private boolean q;
    private final a r;
    private final List s;
    private final List t;
    private at[] u;
    private ab v;
    private int w;

    public as(z zVar, c cVar) {
        com.google.android.libraries.navigation.internal.abf.z zVar2 = com.google.android.libraries.navigation.internal.abf.z.a;
        aq aqVar = aq.a;
        this.w = 1;
        synchronized (this) {
            this.k = zVar;
            this.l = cVar;
            this.m = zVar2;
            this.f144n = aqVar;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = new a();
            this.s = new ArrayList();
            this.t = new ArrayList();
            this.d = null;
            this.e = null;
            this.u = null;
            this.v = null;
            this.f = null;
            this.i = com.google.android.libraries.navigation.internal.abf.e.a(20.0d);
            this.h = com.google.android.libraries.navigation.internal.abf.e.a(20.0d);
        }
    }

    private static int G(MotionEvent motionEvent) {
        return motionEvent.getPointerCount() < 2 ? 1 : 2;
    }

    private final void H(v vVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(this.d, "worldStateProvider");
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.d.d(new am());
        } else {
            this.d.c().v(null);
        }
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        ab abVar = this.v;
        if (abVar == null) {
            this.v = new ab(vVar);
        } else if (vVar != abVar.a) {
            abVar.b();
            this.v = new ab(vVar);
        }
        this.d.e(this.v);
    }

    private final void I(float f, float f2, float f3) {
        au auVarC = C();
        auVarC.b(0.0f, f3, f, f2, 0.0f, 0.0f);
        H(auVarC);
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).m();
        }
    }

    private final boolean J(float f, float f2, float f3) {
        this.m.a();
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        synchronized (this) {
            if (!this.r.g) {
                return false;
            }
            I(f2, f3, f);
            return true;
        }
    }

    private final boolean K(float f) {
        this.m.a();
        com.google.android.libraries.navigation.internal.afu.d.t();
        synchronized (this) {
            if (!this.r.f) {
                return false;
            }
            H(new ay(-f));
            com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
            if (aVar == null) {
                return true;
            }
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).o();
            return true;
        }
    }

    private final synchronized at[] L() {
        if (this.u == null) {
            this.u = M();
        }
        return this.u;
    }

    private final synchronized at[] M() {
        at[] atVarArr;
        atVarArr = new at[this.s.size() + this.t.size()];
        for (int i = 0; i < this.s.size(); i++) {
            atVarArr[i] = (at) this.s.get(i);
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            atVarArr[this.s.size() + i2] = (at) this.t.get(i2);
        }
        return atVarArr;
    }

    private final void N(boolean z, float f, float f2, float f3) {
        ac acVarO;
        bl blVar;
        boolean z2;
        boolean z3 = false;
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.m.a();
            if (!z) {
                z2 = false;
            } else if (this.p) {
                return;
            } else {
                z2 = true;
            }
            com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
            if (this.r.b) {
                an anVar = new an(this, f2, f3, z2, f);
                this.d.d(anVar);
                if (anVar.a != null) {
                    com.google.android.libraries.navigation.internal.pn.i iVar = (com.google.android.libraries.navigation.internal.pn.i) this.f.a();
                    ar arVar = anVar.a;
                    float f4 = arVar.a;
                    ac acVar = arVar.b;
                    iVar.p(f4, (float) acVar.a, (float) acVar.b, true);
                    return;
                }
                return;
            }
            return;
        }
        this.m.a();
        if (z) {
            if (this.p) {
                return;
            } else {
                z3 = true;
            }
        }
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        synchronized (this) {
            if (this.r.b) {
                if (y().j) {
                    acVarO = null;
                } else {
                    acVarO = this.d.c().o();
                    f2 = (float) acVarO.a;
                    f3 = (float) acVarO.b;
                }
                if (z3) {
                    E(-1.0f, acVarO, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
                    return;
                }
                double dLog = Math.log(f) / a;
                au auVarC = C();
                float f5 = (float) dLog;
                auVarC.b(f5, 0.0f, f2, f3, 0.0f, 0.0f);
                H(auVarC);
                if (this.f == null || (blVar = this.d) == null) {
                    return;
                }
                ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(blVar.c().b() + f5, f2, f3, true);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final synchronized a y() {
        return this.r;
    }

    final ar B(aw awVar, float f, ac acVar, int i) {
        D(new ak(f, acVar, i, this.l), awVar);
        if (this.f == null || this.d == null) {
            return null;
        }
        float fC = awVar.c() + f;
        if (acVar == null) {
            acVar = awVar.i();
        }
        return new ar(fC, acVar);
    }

    public final void D(v vVar, aw awVar) {
        awVar.k(null);
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        synchronized (this.k) {
            ab abVar = this.v;
            if (abVar == null) {
                this.v = new ab(vVar);
            } else if (vVar != abVar.a) {
                abVar.b();
                this.v = new ab(vVar);
            }
        }
        this.d.e(this.v);
    }

    final void E(float f, ac acVar, int i) {
        bl blVar;
        H(new ak(f, acVar, i, this.l));
        if (this.f == null || (blVar = this.d) == null) {
            return;
        }
        be beVarC = blVar.c();
        float fB = beVarC.b() + f;
        if (acVar == null) {
            acVar = beVarC.o();
        }
        ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(fB, (float) acVar.a, (float) acVar.b, true);
    }

    public final synchronized void F(at atVar) {
        this.s.add(atVar);
        this.u = null;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void a(MotionEvent motionEvent) {
        this.m.a();
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        if (this.j == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
            if (aVar != null) {
                ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).g(x, y);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final boolean b(MotionEvent motionEvent) {
        this.m.a();
        cp cpVar = this.e;
        if (cpVar != null && cpVar.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).k(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final boolean c(MotionEvent motionEvent) {
        this.m.a();
        cp cpVar = this.e;
        if (cpVar != null && cpVar.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).l(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final boolean d(MotionEvent motionEvent) {
        this.m.a();
        String str = g;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        G(motionEvent);
        double x = motionEvent.getX();
        double y = motionEvent.getY();
        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
        for (at atVar : L()) {
            if (atVar.b(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void e() {
        this.m.a();
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).j();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void f() {
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void g(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.m.a();
        if (com.google.android.libraries.navigation.internal.abf.p.f(g, 3)) {
            String.valueOf(motionEvent);
            String.valueOf(motionEvent2);
        }
        synchronized (this) {
            if (this.r.a) {
                if (d(motionEvent2)) {
                    return;
                }
                H(new af(f, f2));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[Catch: all -> 0x007e, TryCatch #0 {, blocks: (B:22:0x0050, B:26:0x005c, B:24:0x0056, B:28:0x005e), top: B:36:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x005e A[Catch: all -> 0x007e, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {, blocks: (B:22:0x0050, B:26:0x005c, B:24:0x0056, B:28:0x005e), top: B:36:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void h(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        com.google.android.libraries.navigation.internal.afo.a aVar;
        this.m.a();
        com.google.android.libraries.navigation.internal.afu.d.t();
        if (this.o) {
            return;
        }
        String str = g;
        if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
            String.valueOf(motionEvent);
            String.valueOf(motionEvent2);
        }
        boolean z = true;
        if (!this.p && !this.q) {
            z = false;
        }
        if (!z) {
            G(motionEvent2);
            double x = motionEvent2.getX();
            double y = motionEvent2.getY();
            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
            for (at atVar : L()) {
                if (atVar.c(x, y)) {
                    return;
                }
            }
        }
        synchronized (this) {
            if (z) {
                if (this.r.j) {
                    if (this.r.a) {
                        au auVarC = C();
                        auVarC.b(0.0f, 0.0f, 0.0f, 0.0f, f, f2);
                        H(auVarC);
                        aVar = this.f;
                        if (aVar != null) {
                            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).n();
                        }
                    }
                }
            } else if (this.r.a) {
                au auVarC2 = C();
                auVarC2.b(0.0f, 0.0f, 0.0f, 0.0f, f, f2);
                H(auVarC2);
                aVar = this.f;
                if (aVar != null) {
                    ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).n();
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.d
    public final void j() {
        this.m.a();
        for (at atVar : L()) {
            atVar.d();
        }
        z zVar = this.k;
        zVar.b.a();
        com.google.android.libraries.navigation.internal.abh.af afVar = zVar.c;
        afVar.c.a();
        if (afVar.e) {
            afVar.e = false;
            afVar.a();
        } else {
            com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abh.af.a, 5);
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void k(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        J(nVar.a(), nVar.b, nVar.c);
        this.q = false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void l(com.google.android.libraries.navigation.internal.pn.n nVar, boolean z) {
        this.m.a();
        this.p = false;
        N(z, nVar.b(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void m(com.google.android.libraries.navigation.internal.pn.n nVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void n(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        K(nVar.c());
        this.o = false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void o(com.google.android.libraries.navigation.internal.ql.a aVar) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.m.a();
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        this.w = 2;
        this.j = motionEvent;
        this.b = motionEvent.getX();
        this.c = motionEvent.getY();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c5 A[PHI: r7
      0x00c5: PHI (r7v12 boolean) = (r7v11 boolean), (r7v11 boolean), (r7v11 boolean), (r7v13 boolean) binds: [B:24:0x0092, B:26:0x009c, B:28:0x00a4, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d9 A[PHI: r9
      0x01d9: PHI (r9v1 boolean) = (r9v0 boolean), (r9v0 boolean), (r9v0 boolean), (r9v2 boolean) binds: [B:67:0x01a3, B:69:0x01ad, B:71:0x01b5, B:75:0x01d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:78:0x01dd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x0202 A[RETURN] */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        ap apVar;
        if (com.google.android.libraries.navigation.internal.afu.d.j()) {
            this.m.a();
            com.google.android.libraries.navigation.internal.abf.s.k(this.d, "worldStateProvider");
            com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
            a aVar = this.r;
            boolean z4 = aVar.a;
            boolean z5 = aVar.e;
            boolean z6 = aVar.g;
            boolean z7 = aVar.c;
            if (this.j == null || motionEvent.getAction() != 1) {
                if (this.j == null && motionEvent.getAction() == 2) {
                    float y = motionEvent.getY() - this.c;
                    float x = motionEvent.getX() - this.b;
                    if (this.w == 2) {
                        float fAbs = Math.abs(y);
                        float f = this.i;
                        if (fAbs >= f || Math.abs(x) >= f) {
                            if (this.w == 3 && z5) {
                                apVar = new ap(this, y);
                                this.d.d(apVar);
                                if (apVar.a != null) {
                                    com.google.android.libraries.navigation.internal.pn.i iVar = (com.google.android.libraries.navigation.internal.pn.i) this.f.a();
                                    ar arVar = apVar.a;
                                    float f2 = arVar.a;
                                    ac acVar = arVar.b;
                                    iVar.p(f2, (float) acVar.a, (float) acVar.b, true);
                                }
                            }
                            this.b = motionEvent.getX();
                            this.c = motionEvent.getY();
                        } else if (Math.round(Math.abs(this.j.getY() - motionEvent.getY())) > this.h && z5) {
                            this.w = 3;
                            z5 = true;
                            if (this.w == 3) {
                                apVar = new ap(this, y);
                                this.d.d(apVar);
                                if (apVar.a != null) {
                                    com.google.android.libraries.navigation.internal.pn.i iVar2 = (com.google.android.libraries.navigation.internal.pn.i) this.f.a();
                                    ar arVar2 = apVar.a;
                                    float f3 = arVar2.a;
                                    ac acVar2 = arVar2.b;
                                    iVar2.p(f3, (float) acVar2.a, (float) acVar2.b, true);
                                }
                            }
                            this.b = motionEvent.getX();
                            this.c = motionEvent.getY();
                        }
                    } else {
                        if (this.w == 3) {
                            apVar = new ap(this, y);
                            this.d.d(apVar);
                            if (apVar.a != null) {
                                com.google.android.libraries.navigation.internal.pn.i iVar3 = (com.google.android.libraries.navigation.internal.pn.i) this.f.a();
                                ar arVar3 = apVar.a;
                                float f4 = arVar3.a;
                                ac acVar3 = arVar3.b;
                                iVar3.p(f4, (float) acVar3.a, (float) acVar3.b, true);
                            }
                        }
                        this.b = motionEvent.getX();
                        this.c = motionEvent.getY();
                    }
                }
            } else {
                if (!z7 || this.w != 2) {
                    this.j = null;
                    this.w = 1;
                    return this.j == null ? false : false;
                }
                ao aoVar = new ao(this, z4 ? new ac(motionEvent.getX(), motionEvent.getY()) : null);
                this.d.d(aoVar);
                if (aoVar.a != null) {
                    com.google.android.libraries.navigation.internal.pn.i iVar4 = (com.google.android.libraries.navigation.internal.pn.i) this.f.a();
                    ar arVar4 = aoVar.a;
                    float f5 = arVar4.a;
                    ac acVar4 = arVar4.b;
                    iVar4.p(f5, (float) acVar4.a, (float) acVar4.b, true);
                }
                this.j = null;
                this.w = 1;
            }
        } else {
            this.m.a();
            com.google.android.libraries.navigation.internal.abf.s.k(this.d, "worldStateProvider");
            String str = g;
            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
            com.google.android.libraries.navigation.internal.abf.ak akVarK = this.d.c().k();
            synchronized (this) {
                a aVar2 = this.r;
                z = aVar2.a;
                z2 = aVar2.e;
                boolean z8 = aVar2.g;
                z3 = aVar2.c;
            }
            if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                String.valueOf(this.j);
                String.valueOf(motionEvent);
                String.valueOf(this.f);
                String.valueOf(this.d);
            }
            if (this.j != null && motionEvent.getAction() == 1) {
                com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                if (!z3 || this.w != 2) {
                    com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                    this.j = null;
                    this.w = 1;
                    return this.j == null ? false : false;
                }
                com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                if (z) {
                    com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                    E(1.0f, new ac(motionEvent.getX(), motionEvent.getY()), ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
                } else {
                    com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                    E(1.0f, null, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
                }
                com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                this.j = null;
                this.w = 1;
            } else if (this.j == null && motionEvent.getAction() == 2) {
                float y2 = motionEvent.getY() - this.c;
                float x2 = motionEvent.getX() - this.b;
                com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                if (this.w == 2) {
                    float fAbs2 = Math.abs(y2);
                    float f6 = this.i;
                    if (fAbs2 >= f6 || Math.abs(x2) >= f6) {
                        if (this.w == 3 && z2) {
                            float height = y2 / akVarK.getHeight();
                            com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                            E(height * 6.0f, null, 0);
                        }
                        this.b = motionEvent.getX();
                        this.c = motionEvent.getY();
                        if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                            return true;
                        }
                    } else {
                        int iRound = Math.round(Math.abs(this.j.getY() - motionEvent.getY()));
                        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                        if (iRound > this.h && z2) {
                            this.w = 3;
                            z2 = true;
                            if (this.w == 3) {
                                float height2 = y2 / akVarK.getHeight();
                                com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                                E(height2 * 6.0f, null, 0);
                            }
                            this.b = motionEvent.getX();
                            this.c = motionEvent.getY();
                            if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                                return true;
                            }
                        }
                    }
                } else {
                    if (this.w == 3) {
                        float height3 = y2 / akVarK.getHeight();
                        com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                        E(height3 * 6.0f, null, 0);
                    }
                    this.b = motionEvent.getX();
                    this.c = motionEvent.getY();
                    if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                        return true;
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.m.a();
        com.google.android.libraries.navigation.internal.abf.p.f(g, 3);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).i(x, y);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void p(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.m.a();
        com.google.android.libraries.navigation.internal.abf.s.k(aVar, "gestureDispatcher");
        this.f = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean q(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        return J(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean r(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        com.google.android.libraries.navigation.internal.afu.d.a.a().M();
        this.q = true;
        return J(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean s(com.google.android.libraries.navigation.internal.pn.n nVar, boolean z) {
        this.m.a();
        N(z, nVar.b(), nVar.b, nVar.c);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean t(com.google.android.libraries.navigation.internal.pn.n nVar, boolean z) {
        this.m.a();
        this.p = true;
        N(z, nVar.b(), nVar.b, nVar.c);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean u(com.google.android.libraries.navigation.internal.pn.n nVar) {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean v(com.google.android.libraries.navigation.internal.pn.n nVar) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean w(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        return K(nVar.c());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean x(com.google.android.libraries.navigation.internal.pn.n nVar) {
        this.m.a();
        synchronized (this) {
            this.o = this.r.f;
        }
        return K(nVar.c());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void z(com.google.android.libraries.navigation.internal.pn.q qVar) {
    }

    public final synchronized au C() {
        v vVarG = this.v;
        while (vVarG != null) {
            if (vVarG instanceof au) {
                return (au) vVarG;
            }
            vVarG = vVarG instanceof w ? ((w) vVarG).g() : null;
        }
        return new au(this.l);
    }
}
