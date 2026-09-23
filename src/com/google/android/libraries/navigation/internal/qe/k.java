package com.google.android.libraries.navigation.internal.qe;

import android.view.MotionEvent;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.pn.n;
import com.google.android.libraries.navigation.internal.pn.q;
import com.google.android.libraries.navigation.internal.pn.r;
import com.google.android.libraries.navigation.internal.pn.u;
import com.google.android.libraries.navigation.internal.zt.aq;
import com.google.android.libraries.navigation.internal.zt.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.pn.e implements com.google.android.libraries.navigation.internal.pn.j {
    private static final double a = Math.log(2.0d);
    private final float b;
    private final com.google.android.libraries.navigation.internal.qj.a c;
    private final e d;
    private com.google.android.libraries.navigation.internal.afo.a e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f553n = 1;
    private final u m = new u();

    public k(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, e eVar2, float f) {
        this.d = eVar2;
        this.c = new com.google.android.libraries.navigation.internal.qj.a(aVar, eVar);
        this.b = Math.round(f * 20.0f);
    }

    private final boolean A(float f, float f2, float f3) {
        if (!this.m.g) {
            return false;
        }
        if (E()) {
            this.d.t(f);
        } else {
            this.d.u(f2, f3, f);
        }
        this.c.a(as.ROLL, this.d.b.k);
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).m();
        return true;
    }

    private final boolean B(boolean z, float f, float f2, float f3) {
        float fK;
        if (z && this.i) {
            return true;
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.pd.e eVar = this.d.b.f515n;
        float fC = ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).c() * eVar.a();
        float fB = ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b() * eVar.b();
        if (z) {
            if (this.m.d) {
                e eVar2 = this.d;
                com.google.android.libraries.navigation.internal.qj.a aVar2 = this.c;
                float fL = eVar2.l(-1.0f, ExifDirectoryBase.TAG_SUB_IFD_OFFSET);
                aVar2.a(as.PINCH_CLOSED, eVar2.b.k);
                ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fL, fC, fB, true);
            }
        } else if (this.m.b) {
            float fLog = (float) (Math.log(f) / a);
            if (this.i && f > 0.999f && f < 1.001001f) {
                fLog = 0.0f;
            }
            if (E()) {
                fK = this.d.i(fLog);
                f2 = fC;
                f3 = fB;
            } else {
                fK = this.d.k(fLog, f2, f3);
            }
            if (fLog > 0.0f) {
                this.c.a(as.PINCH_OPEN, this.d.b.k);
            } else if (fLog < 0.0f) {
                this.c.a(as.PINCH_CLOSED, this.d.b.k);
            }
            ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fK, f2, f3, !this.i);
        }
        return true;
    }

    private final boolean C(n nVar) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar == null) {
            return false;
        }
        float f = nVar.b;
        float f2 = nVar.c;
        float f3 = nVar.d;
        float fC = ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).c();
        float fB = ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b() / 2.0f;
        return A((float) ((((double) ((f - f3) * Math.signum(f2 - fB))) * 3.141592653589793d) / 256.0d), fC / 2.0f, fB);
    }

    private final boolean D(float f) {
        if (!this.m.f) {
            return false;
        }
        float f2 = -f;
        this.d.s(f2);
        if (f2 > 0.0f) {
            this.c.b(as.TWO_FINGER_DRAG, aq.d, this.d.b.k);
        } else {
            this.c.b(as.TWO_FINGER_DRAG, aq.e, this.d.b.k);
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).o();
        return true;
    }

    private final boolean E() {
        if (this.k) {
            return true;
        }
        if (this.l) {
            return this.j || this.i;
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void a(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar;
        if (this.f553n != 1 || (aVar = this.e) == null) {
            return;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).g(motionEvent.getX(), motionEvent.getY());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final boolean b(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).k(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final boolean c(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).l(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final boolean d(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void e() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).j();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void f() {
        this.d.r();
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void h(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (E()) {
            return;
        }
        if (!this.m.a) {
            com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
            if (aVar != null) {
                ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).h();
                return;
            }
            return;
        }
        this.d.p(f, f2);
        this.c.a(as.DRAG, this.d.b.k);
        com.google.android.libraries.navigation.internal.afo.a aVar2 = this.e;
        if (aVar2 != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar2.a()).n();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void j() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void k(n nVar) {
        A(nVar.a(), nVar.b, nVar.c);
        this.j = false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void l(n nVar, boolean z) {
        this.i = false;
        B(z, nVar.b(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void m(n nVar) {
        C(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void n(n nVar) {
        D(nVar.c());
        this.k = false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void o(com.google.android.libraries.navigation.internal.ql.a aVar) {
        this.l = aVar != com.google.android.libraries.navigation.internal.ql.a.OFF;
        com.google.android.libraries.navigation.internal.afo.a aVar2 = this.e;
        if (aVar2 != null) {
            n nVarD = ((com.google.android.libraries.navigation.internal.pn.i) aVar2.a()).d();
            boolean z = !this.l;
            nVarD.e = z;
            com.google.android.libraries.navigation.internal.pn.b bVar = nVarD.a;
            if (bVar instanceof r) {
                ((r) bVar).e = z;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.f553n = 2;
        this.f = motionEvent.getX();
        this.g = motionEvent.getY();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4 A[PHI: r4
      0x00c4: PHI (r4v1 int) = (r4v0 int), (r4v9 int) binds: [B:39:0x00bd, B:42:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:55:0x010b  */
    /* JADX WARN: Code duplicated, block: B:57:0x010f  */
    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        int action;
        float y;
        float fI;
        com.google.android.libraries.navigation.internal.afo.a aVar;
        float x;
        float y2;
        boolean z = false;
        if (this.f553n == 1) {
            return false;
        }
        this.d.n();
        int action2 = motionEvent.getAction();
        if (action2 != 1) {
            action = motionEvent.getAction();
            if (this.e != null) {
                if (this.f553n == 2 && Math.round(Math.abs(this.g - motionEvent.getY())) > this.b) {
                    this.f553n = 3;
                    this.h = motionEvent.getY();
                }
                if (this.f553n == 3) {
                    if (action == 2) {
                        if (this.m.e) {
                            y = motionEvent.getY() - this.h;
                            int i = -((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b();
                            e eVar = this.d;
                            z = action == 1;
                            fI = eVar.i(-((y / i) * 4.0f));
                            if (z) {
                                fI += this.d.j();
                            }
                            if (y > 0.0f) {
                                this.c.a(as.PINCH_OPEN, this.d.b.k);
                            } else if (y < 0.0f) {
                                this.c.a(as.PINCH_CLOSED, this.d.b.k);
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fI, this.f, this.g, z);
                            this.h = motionEvent.getY();
                            z = true;
                        }
                    } else if (action == 1) {
                        action = 1;
                        if (this.m.e) {
                            y = motionEvent.getY() - this.h;
                            int i2 = -((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b();
                            e eVar2 = this.d;
                            if (action == 1) {
                            }
                            fI = eVar2.i(-((y / i2) * 4.0f));
                            if (z) {
                                fI += this.d.j();
                            }
                            if (y > 0.0f) {
                                this.c.a(as.PINCH_OPEN, this.d.b.k);
                            } else if (y < 0.0f) {
                                this.c.a(as.PINCH_CLOSED, this.d.b.k);
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fI, this.f, this.g, z);
                            this.h = motionEvent.getY();
                            z = true;
                        }
                    }
                }
            }
        } else if (this.f553n != 3) {
            if (this.m.c && (aVar = this.e) != null) {
                if (this.l) {
                    com.google.android.libraries.navigation.internal.pd.e eVar3 = this.d.b.f515n;
                    x = ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).c() * eVar3.a();
                    y2 = ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b() * eVar3.b();
                } else {
                    x = motionEvent.getX();
                    y2 = motionEvent.getY();
                }
                float fL = this.l ? this.d.l(1.0f, ExifDirectoryBase.TAG_SUB_IFD_OFFSET) : this.d.v(x, y2);
                this.c.a(as.DOUBLE_TAP, this.d.b.k);
                com.google.android.libraries.navigation.internal.afo.a aVar2 = this.e;
                if (aVar2 != null) {
                    ((com.google.android.libraries.navigation.internal.pn.i) aVar2.a()).p(fL, x, y2, true);
                }
                z = true;
            }
            action2 = 1;
        } else {
            action2 = 1;
            action = motionEvent.getAction();
            if (this.e != null) {
                if (this.f553n == 2) {
                    this.f553n = 3;
                    this.h = motionEvent.getY();
                }
                if (this.f553n == 3) {
                    if (action == 2) {
                        if (this.m.e) {
                            y = motionEvent.getY() - this.h;
                            int i3 = -((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b();
                            e eVar4 = this.d;
                            if (action == 1) {
                            }
                            fI = eVar4.i(-((y / i3) * 4.0f));
                            if (z) {
                                fI += this.d.j();
                            }
                            if (y > 0.0f) {
                                this.c.a(as.PINCH_OPEN, this.d.b.k);
                            } else if (y < 0.0f) {
                                this.c.a(as.PINCH_CLOSED, this.d.b.k);
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fI, this.f, this.g, z);
                            this.h = motionEvent.getY();
                            z = true;
                        }
                    } else if (action == 1) {
                        action = 1;
                        if (this.m.e) {
                            y = motionEvent.getY() - this.h;
                            int i4 = -((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b();
                            e eVar5 = this.d;
                            if (action == 1) {
                            }
                            fI = eVar5.i(-((y / i4) * 4.0f));
                            if (z) {
                                fI += this.d.j();
                            }
                            if (y > 0.0f) {
                                this.c.a(as.PINCH_OPEN, this.d.b.k);
                            } else if (y < 0.0f) {
                                this.c.a(as.PINCH_CLOSED, this.d.b.k);
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).p(fI, this.f, this.g, z);
                            this.h = motionEvent.getY();
                            z = true;
                        }
                    }
                }
            }
        }
        if (action2 == 1 || action2 == 3) {
            this.f553n = 1;
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.e;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).i(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void p(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.e = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean q(n nVar) {
        return A(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean r(n nVar) {
        if (this.m.g) {
            this.j = true;
        }
        return A(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean s(n nVar, boolean z) {
        return B(z, nVar.b(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean t(n nVar, boolean z) {
        this.i = true;
        return B(z, nVar.b(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean u(n nVar) {
        return C(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean v(n nVar) {
        return C(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean w(n nVar) {
        return D(nVar.c());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean x(n nVar) {
        if (this.m.f) {
            this.k = true;
        }
        return D(nVar.c());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final u y() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void z(q qVar) {
        if (this.e == null) {
            return;
        }
        ay ayVar = qVar.a;
        float[] fArr = {ayVar.b, ayVar.c, qVar.b, qVar.c};
        boolean z = this.f553n == 3;
        if (z) {
            float f = fArr[1];
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = (f / ((com.google.android.libraries.navigation.internal.pn.i) this.e.a()).b()) * 4.0f;
        } else {
            fArr[0] = -fArr[0];
            fArr[1] = -fArr[1];
        }
        if (E()) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
        } else if (!this.m.a && (fArr[0] != 0.0f || fArr[1] != 0.0f)) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
        }
        if (fArr[2] != 0.0f) {
            if (z) {
                if (!this.m.e) {
                    fArr[2] = 0.0f;
                }
            } else if (!this.m.b) {
                fArr[2] = 0.0f;
            }
        }
        if (!this.m.g && fArr[3] != 0.0f) {
            fArr[3] = 0.0f;
        }
        this.d.q(fArr);
    }
}
