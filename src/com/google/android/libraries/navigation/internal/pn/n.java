package com.google.android.libraries.navigation.internal.pn;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    private float A;
    private float B;
    private float C;
    private float D;
    private final ay E;
    private final ay F;
    private final ay G;
    private final float H;
    private float I;
    private float J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final boolean O;
    private float P;
    private float Q;
    private long R;
    private final VelocityTracker S;
    private q T;
    private final f U;
    private final j V;
    private final View W;
    public final b a;
    public float b;
    public float c;
    public float d;
    public boolean e;
    private final Context f;
    private MotionEvent g;
    private MotionEvent h;
    private final List i;
    private final List j;
    private final b k;
    private final b l;
    private final b m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque f518n;
    private long o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public n(j jVar, View view, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        this.j = new ArrayList();
        this.f518n = new ArrayDeque();
        this.E = new ay();
        this.F = new ay();
        this.G = new ay();
        this.e = true;
        this.R = 0L;
        Context context = view.getContext();
        this.f = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H = viewConfiguration.getScaledEdgeSlop();
        this.V = jVar;
        this.W = view;
        float f = 160.0f;
        this.P = 160.0f;
        this.Q = 160.0f;
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.P = displayMetrics.xdpi;
            f = displayMetrics.ydpi;
            this.Q = f;
        }
        v vVar = new v(2, jVar, this.P, f);
        this.l = vVar;
        arrayList.add(vVar);
        v vVar2 = new v(3, jVar, this.P, this.Q);
        this.m = vVar2;
        arrayList.add(vVar2);
        arrayList.add(new w(jVar, this.P, this.Q, viewConfiguration.getScaledTouchSlop()));
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct");
        this.O = !zHasSystemFeature;
        if (zHasSystemFeature) {
            r rVar = new r(jVar, this.P, this.Q);
            this.a = rVar;
            arrayList.add(rVar);
        } else {
            t tVar = new t(jVar, this.P, this.Q);
            this.a = tVar;
            arrayList.add(tVar);
        }
        s sVar = new s(jVar, this.P, this.Q);
        this.k = sVar;
        arrayList.add(sVar);
        f fVar = new f(context, jVar, new Handler(Looper.getMainLooper()), z);
        this.U = fVar;
        fVar.x = true;
        fVar.l = jVar;
        this.S = VelocityTracker.obtain();
    }

    public static float d(float f, float f2) {
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return (float) (1.0d / (Math.exp(((Math.abs(f) / Math.abs(f2)) - 2.0f) * (-2.0f)) + 1.0d));
    }

    private final EnumSet g() {
        EnumSet enumSetNoneOf = EnumSet.noneOf(m.class);
        if (this.l.b || this.m.b) {
            enumSetNoneOf.add(m.TILT);
        } else if (!this.O) {
            enumSetNoneOf.add(m.PAN);
        }
        if (this.k.b) {
            enumSetNoneOf.add(m.ZOOM);
        }
        if (this.a.b && !this.O) {
            enumSetNoneOf.add(m.ROTATE);
        }
        return enumSetNoneOf;
    }

    private final void h(MotionEvent motionEvent) {
        float f = this.I;
        float f2 = this.J;
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = motionEvent.getX(motionEvent.getPointerCount() - 1);
        int pointerCount = motionEvent.getPointerCount() - 1;
        float f3 = this.H;
        float y2 = motionEvent.getY(pointerCount);
        boolean z = x < f3 || y < f3 || x > f || y > f2;
        boolean z2 = x2 < f3 || y2 < f3 || x2 > f || y2 > f2;
        if (z && z2) {
            this.b = -1.0f;
            this.c = -1.0f;
            this.K = true;
        } else if (z) {
            this.b = motionEvent.getX(motionEvent.getPointerCount() - 1);
            this.c = motionEvent.getY(motionEvent.getPointerCount() - 1);
            this.K = true;
        } else if (!z2) {
            this.N = true;
            this.K = false;
        } else {
            this.b = motionEvent.getX(0);
            this.c = motionEvent.getY(0);
            this.K = true;
        }
    }

    private final void i() {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.j.get(i);
            ar.o(bVar.b, "Ending inactive gesture: %s", bVar);
            bVar.b(this);
        }
        this.j.clear();
    }

    private final void j() {
        this.g = null;
        this.h = null;
        this.K = false;
        this.N = false;
        this.j.clear();
        Iterator it2 = this.f518n.iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).d();
        }
        this.f518n.clear();
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.i.get(i);
            if (bVar.b) {
                bVar.b(this);
            }
        }
    }

    private final void k(MotionEvent motionEvent) {
        this.h = MotionEvent.obtain(motionEvent);
        this.t = -1.0f;
        this.u = -1.0f;
        this.x = -1.0f;
        this.y = 0.0f;
        this.L = false;
        this.M = false;
        MotionEvent motionEvent2 = this.g;
        ar.q(motionEvent2);
        float x = motionEvent2.getX(0);
        float y = motionEvent2.getY(0);
        float x2 = motionEvent2.getX(motionEvent2.getPointerCount() - 1);
        float y2 = motionEvent2.getY(motionEvent2.getPointerCount() - 1);
        float x3 = motionEvent.getX(0);
        float y3 = motionEvent.getY(0);
        float x4 = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float f = x2 - x;
        float f2 = x4 - x3;
        float y4 = motionEvent.getY(motionEvent.getPointerCount() - 1);
        float f3 = y4 - y3;
        this.p = f;
        this.q = y2 - y;
        this.r = f2;
        this.s = f3;
        this.v = y;
        this.w = y3;
        this.b = (f2 * 0.5f) + x3;
        this.c = (f3 * 0.5f) + y3;
        this.d = (f * 0.5f) + x;
        motionEvent.getEventTime();
        motionEvent2.getEventTime();
        this.A = motionEvent.getPressure(0) + motionEvent.getPressure(motionEvent.getPointerCount() - 1);
        this.B = motionEvent2.getPressure(0) + motionEvent2.getPressure(motionEvent2.getPointerCount() - 1);
        this.E.q(this.p, this.q);
        this.F.q(x3 - x, y3 - y);
        this.G.q(x4 - x2, y4 - y2);
        ay ayVar = this.E;
        this.C = ayVar.c(this.G) - ayVar.c(this.F);
        this.D = ay.a(ay.a, this.E, this.G) - ay.a(ay.a, this.E, this.F);
    }

    private final boolean l() {
        return !this.j.isEmpty();
    }

    private static boolean m(b bVar) {
        return bVar.b;
    }

    private final boolean n(MotionEvent motionEvent) {
        return motionEvent.getEventTime() <= this.R + 100;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0074  */
    private final void o(MotionEvent motionEvent) {
        boolean z;
        int i;
        int action = motionEvent.getAction();
        if (this.f518n.isEmpty()) {
            this.o = motionEvent.getEventTime();
        }
        this.f518n.addLast(new h(motionEvent));
        if (this.f518n.size() > 20) {
            ((h) this.f518n.removeFirst()).d();
        }
        while (((h) this.f518n.getLast()).c - ((h) this.f518n.getFirst()).c >= 250 && this.f518n.size() > 3) {
            ((h) this.f518n.removeFirst()).d();
        }
        if (action == 1) {
            z = true;
        } else {
            if (action == 3) {
                this.N = false;
            } else if (action == 6 || action == 262) {
                z = true;
            }
            z = false;
        }
        if (this.N) {
            int size = this.i.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.i.get(i2);
                if (!bVar.b) {
                    long j = this.o;
                    ArrayDeque arrayDeque = this.f518n;
                    List list = this.j;
                    if (bVar.e() && !list.isEmpty()) {
                        i = 1;
                        break;
                    }
                    int size2 = list.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            if (z == bVar.g()) {
                                i = bVar.i(j, arrayDeque, list);
                                break;
                            }
                            break;
                        } else if (((b) list.get(i3)).e()) {
                            ar.k(list.size() == 1);
                        } else {
                            i3++;
                        }
                        i = 1;
                        break;
                    }
                    int i4 = i - 1;
                    if (i4 == 1) {
                        break;
                    }
                    if (i4 != 2) {
                        continue;
                    } else {
                        if (bVar.b) {
                            throw new IllegalStateException("Gesture already active: ".concat(String.valueOf(bVar.getClass().getName())));
                        }
                        boolean zD = bVar.d(this);
                        bVar.b = zD;
                        if (zD) {
                            this.j.add(bVar);
                        }
                    }
                }
            }
        }
        if (z) {
            i();
            this.N = false;
        }
    }

    public final float a() {
        float f = 0.0f;
        if (m(this.a)) {
            MotionEvent motionEvent = this.h;
            ar.q(motionEvent);
            MotionEvent motionEvent2 = this.g;
            ar.q(motionEvent2);
            if (motionEvent.getPointerCount() == motionEvent2.getPointerCount()) {
                if (!this.M) {
                    this.z = b.a(h.a(motionEvent2.getX(0), motionEvent2.getY(0), motionEvent2.getX(motionEvent2.getPointerCount() - 1), motionEvent2.getY(motionEvent2.getPointerCount() - 1)), h.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(motionEvent.getPointerCount() - 1), motionEvent.getY(motionEvent.getPointerCount() - 1))) * 57.295776f;
                    this.M = true;
                }
                f = this.z;
            }
        }
        return this.e ? f : f * d(this.D, this.C);
    }

    public final float b() {
        if (!m(this.k)) {
            return 1.0f;
        }
        MotionEvent motionEvent = this.h;
        ar.q(motionEvent);
        MotionEvent motionEvent2 = this.g;
        ar.q(motionEvent2);
        if (motionEvent.getPointerCount() != motionEvent2.getPointerCount()) {
            return 1.0f;
        }
        float f = this.x;
        if (f != -1.0f) {
            return f;
        }
        float fHypot = this.t;
        if (fHypot == -1.0f) {
            fHypot = (float) Math.hypot(this.r, this.s);
            this.t = fHypot;
        }
        float fHypot2 = this.u;
        if (fHypot2 == -1.0f) {
            fHypot2 = (float) Math.hypot(this.p, this.q);
            this.u = fHypot2;
        }
        if (fHypot == 0.0f || fHypot2 == 0.0f) {
            return 1.0f;
        }
        float f2 = fHypot / fHypot2;
        this.x = f2;
        return f2;
    }

    public final float c() {
        if (!m(this.l)) {
            return 0.0f;
        }
        if (!this.L) {
            this.y = (this.w - this.v) * 0.25f;
            this.L = true;
        }
        return this.y;
    }

    public final boolean e(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        f fVar = this.U;
        if (action == 9) {
            return fVar.k.b(motionEvent);
        }
        if (motionEvent.getAction() != 7) {
            return false;
        }
        return fVar.k.c(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:196:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:34:0x0084  */
    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0159  */
    /* JADX WARN: Code duplicated, block: B:68:0x015e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0164  */
    /* JADX WARN: Code duplicated, block: B:72:0x0175  */
    /* JADX WARN: Code duplicated, block: B:75:0x017c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0188  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a0  */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0198, code lost:
    
        if (r2 != 6) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(MotionEvent motionEvent) {
        int pointerCount;
        long eventTime;
        MotionEvent motionEvent2;
        boolean z;
        int pointerCount2;
        if (motionEvent.getActionMasked() == 0) {
            this.S.clear();
        }
        this.S.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            if (!n(motionEvent) || this.T == null) {
                this.T = new q(motionEvent, this.S, g(), !this.e);
            }
            this.V.z(this.T);
        } else if (actionMasked == 6) {
            this.T = new q(motionEvent, this.S, g(), !this.e);
        }
        int action = motionEvent.getAction();
        int i = (action >> 8) & 255;
        if (this.N) {
            if (!l()) {
                o(MotionEvent.obtain(motionEvent));
                if (l() && this.A / this.B > 0.67f) {
                    this.g = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 1) {
                k(motionEvent);
                if (i == 0) {
                    pointerCount = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount = 0;
                }
                this.b = motionEvent.getX(pointerCount);
                this.c = motionEvent.getY(pointerCount);
                if (!this.K) {
                    i();
                }
                if (!this.e) {
                    MotionEvent motionEvent3 = this.h;
                    ar.q(motionEvent3);
                    o(motionEvent3);
                    if (!this.K) {
                        i();
                    }
                }
                j();
            } else if (action == 2) {
                k(motionEvent);
                MotionEvent motionEvent4 = this.h;
                ar.q(motionEvent4);
                o(motionEvent4);
                if (this.A / this.B > 0.67f) {
                    int size = this.j.size();
                    boolean zH = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        b bVar = (b) this.j.get(i2);
                        ar.k(bVar.b);
                        if (!bVar.b) {
                            throw new IllegalStateException("Gesture is not active: ".concat(String.valueOf(bVar.getClass().getName())));
                        }
                        zH |= bVar.h(this);
                    }
                    if (zH) {
                        this.g = MotionEvent.obtain(motionEvent);
                    }
                }
            } else if (action == 3) {
                if (!this.K) {
                    i();
                }
                j();
            } else if (action == 6 || action == 262) {
                k(motionEvent);
                if (i == 0) {
                    pointerCount = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount = 0;
                }
                this.b = motionEvent.getX(pointerCount);
                this.c = motionEvent.getY(pointerCount);
                if (!this.K) {
                    i();
                }
                if (!this.e) {
                    MotionEvent motionEvent5 = this.h;
                    ar.q(motionEvent5);
                    o(motionEvent5);
                    if (!this.K) {
                        i();
                    }
                }
                j();
            }
        } else if (action == 5 || action == 261 || action == 0) {
            this.I = this.W.getWidth() - this.H;
            this.J = this.W.getHeight() - this.H;
            j();
            this.g = MotionEvent.obtain(motionEvent);
            k(motionEvent);
            h(motionEvent);
        } else if (action != 2) {
            if ((action != 6 || action == 262 || action == 1) && this.K) {
                if (i == 0) {
                    pointerCount2 = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount2 = 0;
                }
                this.b = motionEvent.getX(pointerCount2);
                this.c = motionEvent.getY(pointerCount2);
            }
        } else if (this.K) {
            h(motionEvent);
        } else {
            action = 2;
            if (action != 6) {
                if (i == 0) {
                    pointerCount2 = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount2 = 0;
                }
                this.b = motionEvent.getX(pointerCount2);
                this.c = motionEvent.getY(pointerCount2);
            } else {
                if (i == 0) {
                    pointerCount2 = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount2 = 0;
                }
                this.b = motionEvent.getX(pointerCount2);
                this.c = motionEvent.getY(pointerCount2);
            }
        }
        int actionMasked2 = motionEvent.getActionMasked();
        if (actionMasked2 == 0) {
            eventTime = 0;
            this.R = eventTime;
        } else {
            if (actionMasked2 != 1) {
                if (actionMasked2 == 5) {
                    eventTime = 0;
                    this.R = eventTime;
                }
            }
            eventTime = motionEvent.getEventTime();
            this.R = eventTime;
        }
        if (motionEvent.getActionMasked() == 2 && n(motionEvent)) {
            return;
        }
        f fVar = this.U;
        int action2 = motionEvent.getAction();
        if (fVar.z == null) {
            fVar.z = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = fVar.z;
        velocityTracker.addMovement(motionEvent);
        int i3 = action2 & 255;
        boolean z2 = i3 == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount3 = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i4 = 0; i4 < pointerCount3; i4++) {
            if (actionIndex != i4) {
                x += motionEvent.getX(i4);
                y += motionEvent.getY(i4);
            }
        }
        float f = z2 ? pointerCount3 - 1 : pointerCount3;
        float f2 = x / f;
        float f3 = y / f;
        if (i3 == 0) {
            GestureDetector.OnDoubleTapListener onDoubleTapListener = fVar.l;
            if (onDoubleTapListener != null) {
                boolean zHasMessages = fVar.j.hasMessages(3);
                if (zHasMessages) {
                    fVar.j.removeMessages(3);
                }
                MotionEvent motionEvent6 = fVar.q;
                if (motionEvent6 == null || (motionEvent2 = fVar.r) == null || !zHasMessages || !fVar.p || motionEvent.getEventTime() - motionEvent2.getEventTime() > f.c) {
                    fVar.j.sendEmptyMessageDelayed(3, f.c);
                } else {
                    int x2 = (int) motionEvent6.getX();
                    int x3 = (int) motionEvent.getX();
                    int y2 = ((int) motionEvent6.getY()) - ((int) motionEvent.getY());
                    int i5 = x2 - x3;
                    if ((i5 * i5) + (y2 * y2) < fVar.g) {
                        fVar.s = true;
                        onDoubleTapListener.onDoubleTap(fVar.q);
                        onDoubleTapListener.onDoubleTapEvent(motionEvent);
                    } else {
                        fVar.j.sendEmptyMessageDelayed(3, f.c);
                    }
                }
            }
            fVar.t = f2;
            fVar.v = f2;
            fVar.u = f3;
            fVar.w = f3;
            MotionEvent motionEvent7 = fVar.q;
            if (motionEvent7 != null) {
                motionEvent7.recycle();
            }
            fVar.q = MotionEvent.obtain(motionEvent);
            MotionEvent motionEvent8 = fVar.q;
            fVar.o = true;
            fVar.p = true;
            fVar.m = true;
            fVar.f517n = false;
            if (fVar.x) {
                fVar.j.removeMessages(2);
                if (fVar.y) {
                    fVar.j.sendEmptyMessageDelayed(2, f.b + f.a);
                } else {
                    fVar.j.sendEmptyMessageAtTime(2, motionEvent8.getDownTime() + ((long) f.b) + ((long) f.a));
                }
            }
            if (fVar.y) {
                fVar.j.sendEmptyMessageDelayed(1, f.b);
            } else {
                fVar.j.sendEmptyMessageAtTime(1, motionEvent8.getDownTime() + ((long) f.b));
            }
            fVar.k.f();
            return;
        }
        if (i3 == 1) {
            fVar.m = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (fVar.s) {
                GestureDetector.OnDoubleTapListener onDoubleTapListener2 = fVar.l;
                ar.q(onDoubleTapListener2);
                onDoubleTapListener2.onDoubleTapEvent(motionEvent);
            } else if (fVar.f517n) {
                fVar.j.removeMessages(3);
                fVar.f517n = false;
                fVar.k.d(motionEvent);
            } else if (fVar.o) {
                fVar.k.d(motionEvent);
            } else {
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, fVar.i);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                float fAbs = Math.abs(yVelocity);
                float f4 = fVar.h;
                if (fAbs > f4 || Math.abs(xVelocity) > f4) {
                    fVar.k.g(fVar.q, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent9 = fVar.r;
            if (motionEvent9 != null) {
                motionEvent9.recycle();
            }
            fVar.r = motionEventObtain;
            VelocityTracker velocityTracker2 = fVar.z;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                fVar.z = null;
            }
            fVar.s = false;
            fVar.j.removeMessages(1);
            fVar.j.removeMessages(2);
            fVar.k.j();
            return;
        }
        if (i3 == 2) {
            float f5 = fVar.t - f2;
            float f6 = fVar.u - f3;
            if (fVar.s) {
                GestureDetector.OnDoubleTapListener onDoubleTapListener3 = fVar.l;
                ar.q(onDoubleTapListener3);
                onDoubleTapListener3.onDoubleTapEvent(motionEvent);
                return;
            }
            if (!fVar.o) {
                if (Math.abs(f5) >= 1.0f || Math.abs(f6) >= 1.0f) {
                    fVar.k.h(fVar.q, motionEvent, f5, f6);
                    fVar.t = f2;
                    fVar.u = f3;
                    return;
                }
                return;
            }
            float f7 = f2 - fVar.v;
            int i6 = (int) (f3 - fVar.w);
            int i7 = (int) f7;
            int i8 = (i7 * i7) + (i6 * i6);
            if (i8 > fVar.e) {
                float fSqrt = (float) Math.sqrt(i8);
                float f8 = (fSqrt - fVar.d) / fSqrt;
                fVar.k.h(fVar.q, motionEvent, f5 * f8, f6 * f8);
                fVar.t = f2;
                fVar.u = f3;
                z = false;
                fVar.o = false;
                fVar.j.removeMessages(3);
                fVar.j.removeMessages(1);
                fVar.j.removeMessages(2);
            } else {
                z = false;
            }
            if (i8 > fVar.f) {
                fVar.p = z;
                return;
            }
            return;
        }
        if (i3 == 3) {
            fVar.k.e();
            fVar.a(motionEvent);
            VelocityTracker velocityTracker3 = fVar.z;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
            }
            fVar.z = null;
            fVar.m = false;
            return;
        }
        if (i3 == 5) {
            fVar.t = f2;
            fVar.v = f2;
            fVar.u = f3;
            fVar.w = f3;
            fVar.a(motionEvent);
            return;
        }
        if (i3 != 6) {
            return;
        }
        fVar.t = f2;
        fVar.v = f2;
        fVar.u = f3;
        fVar.w = f3;
        velocityTracker.computeCurrentVelocity(1000, fVar.i);
        int actionIndex2 = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex2);
        float xVelocity2 = velocityTracker.getXVelocity(pointerId2);
        float yVelocity2 = velocityTracker.getYVelocity(pointerId2);
        for (int i9 = 0; i9 < pointerCount3; i9++) {
            if (i9 != actionIndex2) {
                int pointerId3 = motionEvent.getPointerId(i9);
                if ((velocityTracker.getXVelocity(pointerId3) * xVelocity2) + (velocityTracker.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }
}
