package com.google.android.libraries.navigation.internal.ri;

import android.view.MotionEvent;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.pn.j;
import com.google.android.libraries.navigation.internal.pn.n;
import com.google.android.libraries.navigation.internal.pn.q;
import com.google.android.libraries.navigation.internal.pn.u;
import com.google.android.libraries.navigation.internal.zt.aq;
import com.google.android.libraries.navigation.internal.zt.as;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.pn.e implements j {
    private static final Duration a = Duration.ofMillis(330);
    private static final double b = Math.log(2.0d);
    private final float c;
    private final com.google.android.libraries.navigation.internal.qj.a d;
    private final com.google.android.libraries.navigation.internal.oq.d e;
    private com.google.android.libraries.navigation.internal.afo.a f;
    private float g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final i f568n;
    private int m = 1;
    private final u l = new u();

    public h(com.google.android.libraries.navigation.internal.qj.a aVar, i iVar, com.google.android.libraries.navigation.internal.oq.d dVar, float f) {
        this.e = dVar;
        this.d = aVar;
        this.f568n = iVar;
        this.c = Math.round(f * 20.0f);
    }

    private final boolean A(float f, float f2, float f3) {
        if (!this.l.g) {
            return false;
        }
        this.d.a(as.ROLL, this.e.a().c());
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).m();
        return true;
    }

    private final boolean B(boolean z, float f, float f2, float f3) {
        if (z && this.j) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.oq.c cVar = (com.google.android.libraries.navigation.internal.oq.c) this.e.a().f();
        float fC = ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).c() * ((cVar.a + 1.0f) / 2.0f);
        float fB = ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b() * ((cVar.b + 1.0f) / 2.0f);
        if (z) {
            if (this.l.d) {
                this.d.a(as.PINCH_CLOSED, this.e.a().c());
                ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, fC, fB, true);
            }
        } else if (this.l.b) {
            float fLog = (float) (Math.log(f) / b);
            if (this.j && f > 0.999f && f < 1.001001f) {
                fLog = 0.0f;
            }
            if (E()) {
                Duration duration = Duration.ZERO;
                f2 = fC;
                f3 = fB;
            } else {
                Duration duration2 = Duration.ZERO;
            }
            if (fLog > 0.0f) {
                this.d.a(as.PINCH_OPEN, this.e.a().c());
            } else if (fLog < 0.0f) {
                this.d.a(as.PINCH_CLOSED, this.e.a().c());
            }
            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, f2, f3, !this.j);
        }
        return true;
    }

    private final boolean C(n nVar) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar == null) {
            return false;
        }
        float f = nVar.b;
        float f2 = nVar.c;
        float f3 = nVar.d;
        float fC = ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).c();
        float fB = ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b() / 2.0f;
        return A((float) ((((double) ((f - f3) * Math.signum(f2 - fB))) * 3.141592653589793d) / 256.0d), fC / 2.0f, fB);
    }

    private final boolean D(float f) {
        if (!this.l.f) {
            return false;
        }
        if ((-f) > 0.0f) {
            this.d.b(as.TWO_FINGER_DRAG, aq.d, this.e.a().c());
        } else {
            this.d.b(as.TWO_FINGER_DRAG, aq.e, this.e.a().c());
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).o();
        return true;
    }

    private final boolean E() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void a(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar;
        if (this.m != 1 || (aVar = this.f) == null) {
            return;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).g(motionEvent.getX(), motionEvent.getY());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final boolean b(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).k(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final boolean c(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
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
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).j();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void f() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void h(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (E()) {
            return;
        }
        if (!this.l.a) {
            com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
            if (aVar != null) {
                ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).h();
                return;
            }
            return;
        }
        this.d.a(as.DRAG, this.e.a().c());
        com.google.android.libraries.navigation.internal.afo.a aVar2 = this.f;
        if (aVar2 != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar2.a()).n();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, com.google.android.libraries.navigation.internal.pn.d
    public final void j() {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void k(n nVar) {
        A(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void l(n nVar, boolean z) {
        this.j = false;
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
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        this.m = 2;
        this.g = motionEvent.getX();
        this.h = motionEvent.getY();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:32:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:35:0x0081 A[PHI: r5
      0x0081: PHI (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:31:0x007b, B:34:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x009e  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        int action;
        float y;
        boolean z = false;
        if (this.m == 1) {
            return false;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 1) {
            action = motionEvent.getAction();
            if (this.f != null) {
                if (this.m == 2 && Math.round(Math.abs(this.h - motionEvent.getY())) > this.c) {
                    this.m = 3;
                    this.i = motionEvent.getY();
                }
                if (this.m == 3) {
                    if (action == 2) {
                        if (this.l.e) {
                            y = motionEvent.getY() - this.i;
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b();
                            Duration duration = Duration.ZERO;
                            z = action == 1;
                            if (y > 0.0f) {
                                this.d.a(as.PINCH_OPEN, this.e.a().c());
                            } else if (y < 0.0f) {
                                this.d.a(as.PINCH_CLOSED, this.e.a().c());
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, this.g, this.h, z);
                            this.i = motionEvent.getY();
                            z = true;
                        }
                    } else if (action == 1) {
                        action = 1;
                        if (this.l.e) {
                            y = motionEvent.getY() - this.i;
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b();
                            Duration duration2 = Duration.ZERO;
                            if (action == 1) {
                            }
                            if (y > 0.0f) {
                                this.d.a(as.PINCH_OPEN, this.e.a().c());
                            } else if (y < 0.0f) {
                                this.d.a(as.PINCH_CLOSED, this.e.a().c());
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, this.g, this.h, z);
                            this.i = motionEvent.getY();
                            z = true;
                        }
                    }
                }
            }
        } else if (this.m != 3) {
            if (this.l.c && this.f != null) {
                float x = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.d.a(as.DOUBLE_TAP, this.e.a().c());
                com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
                if (aVar != null) {
                    ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).p(0.0f, x, y2, true);
                }
                z = true;
            }
            action2 = 1;
        } else {
            action2 = 1;
            action = motionEvent.getAction();
            if (this.f != null) {
                if (this.m == 2) {
                    this.m = 3;
                    this.i = motionEvent.getY();
                }
                if (this.m == 3) {
                    if (action == 2) {
                        if (this.l.e) {
                            y = motionEvent.getY() - this.i;
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b();
                            Duration duration3 = Duration.ZERO;
                            if (action == 1) {
                            }
                            if (y > 0.0f) {
                                this.d.a(as.PINCH_OPEN, this.e.a().c());
                            } else if (y < 0.0f) {
                                this.d.a(as.PINCH_CLOSED, this.e.a().c());
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, this.g, this.h, z);
                            this.i = motionEvent.getY();
                            z = true;
                        }
                    } else if (action == 1) {
                        action = 1;
                        if (this.l.e) {
                            y = motionEvent.getY() - this.i;
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b();
                            Duration duration4 = Duration.ZERO;
                            if (action == 1) {
                            }
                            if (y > 0.0f) {
                                this.d.a(as.PINCH_OPEN, this.e.a().c());
                            } else if (y < 0.0f) {
                                this.d.a(as.PINCH_CLOSED, this.e.a().c());
                            }
                            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).p(0.0f, this.g, this.h, z);
                            this.i = motionEvent.getY();
                            z = true;
                        }
                    }
                }
            }
        }
        if (action2 == 1 || action2 == 3) {
            this.m = 1;
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.e, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.f;
        if (aVar == null) {
            return true;
        }
        ((com.google.android.libraries.navigation.internal.pn.i) aVar.a()).i(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void p(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.f = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean q(n nVar) {
        return A(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean r(n nVar) {
        return A(nVar.a(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean s(n nVar, boolean z) {
        return B(z, nVar.b(), nVar.b, nVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final boolean t(n nVar, boolean z) {
        this.j = true;
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
        if (this.l.f) {
            this.k = true;
        }
        return D(nVar.c());
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final u y() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.j
    public final void z(q qVar) {
        if (this.f == null) {
            return;
        }
        ay ayVar = qVar.a;
        float f = qVar.b;
        float f2 = qVar.c;
        if (this.m == 3) {
            ((com.google.android.libraries.navigation.internal.pn.i) this.f.a()).b();
        }
    }
}
