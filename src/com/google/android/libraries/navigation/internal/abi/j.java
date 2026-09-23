package com.google.android.libraries.navigation.internal.abi;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public final Context a;
    public MotionEvent b;
    public MotionEvent c;
    public final List d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f128n;
    public final float o;
    public float p;
    public float q;
    public boolean r;
    public boolean s;
    public final f t;
    public final i u;
    private final List v;
    private final LinkedList w;
    private long x;

    public j(Context context, i iVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.v = arrayList;
        this.d = new ArrayList();
        this.w = new LinkedList();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.a = context;
        this.u = iVar;
        this.o = viewConfiguration.getScaledEdgeSlop();
        arrayList.add(new o(iVar));
        if (z) {
            arrayList.add(new k(iVar));
        } else {
            arrayList.add(new n(iVar));
        }
        arrayList.add(new m(iVar));
        arrayList.add(new q(iVar));
        f fVar = new f(context, iVar, new Handler(Looper.getMainLooper()));
        this.t = fVar;
        fVar.w = true;
        fVar.k = iVar;
    }

    public static float a(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    public static float b(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    public final void c() {
        for (c cVar : this.d) {
            s.c(cVar.b);
            cVar.b(this);
        }
    }

    public final void d() {
        this.b = null;
        this.c = null;
        this.r = false;
        this.s = false;
        this.d.clear();
        Iterator it2 = this.w.iterator();
        while (it2.hasNext()) {
            ((g) it2.next()).g();
        }
        this.w.clear();
        for (c cVar : this.v) {
            if (cVar.b) {
                cVar.b(this);
            }
        }
    }

    public final void e(MotionEvent motionEvent) {
        this.c = MotionEvent.obtain(motionEvent);
        this.k = -1.0f;
        this.l = -1.0f;
        MotionEvent motionEvent2 = this.b;
        float x = motionEvent2.getX(0);
        float y = motionEvent2.getY(0);
        float x2 = motionEvent2.getX(motionEvent2.getPointerCount() - 1);
        float y2 = motionEvent2.getY(motionEvent2.getPointerCount() - 1);
        float x3 = motionEvent.getX(0);
        float y3 = motionEvent.getY(0);
        float f = x2 - x;
        float x4 = motionEvent.getX(motionEvent.getPointerCount() - 1) - x3;
        float y4 = motionEvent.getY(motionEvent.getPointerCount() - 1) - y3;
        this.g = f;
        this.h = y2 - y;
        this.i = x4;
        this.j = y4;
        this.e = x3 + (x4 * 0.5f);
        this.f = y3 + (y4 * 0.5f);
        motionEvent.getEventTime();
        motionEvent2.getEventTime();
        this.m = motionEvent.getPressure(0) + motionEvent.getPressure(motionEvent.getPointerCount() - 1);
        this.f128n = motionEvent2.getPressure(0) + motionEvent2.getPressure(motionEvent2.getPointerCount() - 1);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0078  */
    public final void f(MotionEvent motionEvent) {
        boolean z;
        int i;
        int action = motionEvent.getAction();
        if (this.w.isEmpty()) {
            this.x = motionEvent.getEventTime();
        }
        this.w.addLast(new a(motionEvent));
        if (this.w.size() > 20) {
            ((g) this.w.removeFirst()).g();
        }
        while (((g) this.w.getLast()).f() - ((g) this.w.getFirst()).f() >= 250 && this.w.size() > 3) {
            ((g) this.w.removeFirst()).g();
        }
        if (action == 1) {
            z = true;
        } else {
            if (action == 3) {
                this.s = false;
            } else if (action == 6 || action == 262) {
                z = true;
            }
            z = false;
        }
        if (this.s) {
            for (c cVar : this.v) {
                if (!cVar.b) {
                    long j = this.x;
                    LinkedList linkedList = this.w;
                    List list = this.d;
                    if (cVar.e() && !list.isEmpty()) {
                        i = 1;
                        break;
                    }
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            if (z == cVar.g()) {
                                i = cVar.i(j, linkedList, list);
                                break;
                            }
                            break;
                        } else if (((c) it2.next()).e()) {
                            s.c(list.size() == 1);
                        }
                        i = 1;
                        break;
                    }
                    int i2 = i - 1;
                    if (i2 == 1) {
                        break;
                    }
                    if (i2 != 2) {
                        continue;
                    } else {
                        if (cVar.b) {
                            throw new IllegalStateException("Gesture already active: ".concat(String.valueOf(cVar.getClass().getName())));
                        }
                        boolean zD = cVar.d(this);
                        cVar.b = zD;
                        if (zD) {
                            this.d.add(cVar);
                        }
                    }
                }
            }
        }
        if (z) {
            c();
            this.s = false;
        }
    }
}
