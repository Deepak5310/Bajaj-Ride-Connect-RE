package com.google.android.libraries.navigation.internal.abq;

import android.view.MotionEvent;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abi.j;
import com.google.android.libraries.navigation.internal.abi.l;
import com.google.android.libraries.navigation.internal.abw.k;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.abi.h {
    private static final String c = "a";
    private final c d;
    private final double e;
    public boolean a = true;
    public boolean b = true;
    private float f = 0.0f;
    private float g = 0.0f;
    private boolean h = false;
    private boolean i = false;

    public a(c cVar, double d) {
        this.d = cVar;
        this.e = d;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean c(l lVar) {
        p.f(c, 3);
        if (!this.h && this.b && Math.abs(lVar.a()) >= 1.0f && Math.abs(lVar.b()) >= 1.0f) {
            float fA = lVar.a() - lVar.b();
            double d = this.e;
            c cVar = this.d;
            j jVar = ((com.google.android.libraries.navigation.internal.abi.b) lVar).a;
            cVar.p(new com.google.android.libraries.navigation.internal.abr.f((float) (((double) fA) / (d * 180.0d)), jVar.e, jVar.f));
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean d() {
        p.f(c, 3);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean e() {
        p.f(c, 3);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void f() {
        String str = c;
        p.f(str, 4);
        if (!this.h || this.i) {
            return;
        }
        p.f(str, 4);
        this.i = true;
        this.d.n();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        p.f(c, 3);
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        String str = c;
        p.f(str, 3);
        if (motionEvent == null) {
            p.f(str, 6);
            return true;
        }
        if (!this.h && motionEvent.getAction() == 1) {
            p.f(str, 3);
            this.d.l((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        String str = c;
        p.f(str, 4);
        this.h = false;
        this.i = false;
        this.d.p(new com.google.android.libraries.navigation.internal.abr.e());
        if (motionEvent == null) {
            p.f(str, 6);
            return true;
        }
        boolean zV = this.d.v((int) motionEvent.getX(), (int) motionEvent.getY());
        this.h = zV;
        if (zV) {
            p.f(str, 4);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        String str = c;
        p.f(str, 3);
        if (motionEvent == null || motionEvent2 == null) {
            p.f(str, 6);
            return true;
        }
        if (!this.h && this.a) {
            this.d.p(new com.google.android.libraries.navigation.internal.abr.a(k.i(this.f, -2.5f, 2.5f) * 0.8f, k.i(this.g, -2.5f, 2.5f) * 0.5f));
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        String str = c;
        p.f(str, 4);
        if (motionEvent == null) {
            p.f(str, 6);
        } else {
            if (this.h) {
                return;
            }
            p.f(str, 3);
            this.d.o((int) motionEvent.getX(), (int) motionEvent.getY());
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        String str = c;
        p.f(str, 3);
        if (motionEvent == null || motionEvent2 == null) {
            p.f(str, 6);
            return true;
        }
        if (this.h) {
            this.d.m((int) motionEvent2.getX(), (int) motionEvent2.getY());
            return true;
        }
        if (this.a) {
            c cVar = this.d;
            int width = cVar.getWidth();
            int height = cVar.getHeight();
            if (width != 0 && height != 0) {
                this.f = 0.02f * f;
                this.g = (-0.01f) * f2;
                this.d.p(new com.google.android.libraries.navigation.internal.abr.d((f * ((float) k.s(width, height))) / width, (f2 * ((float) k.d(width, height, 90.0d))) / (-height)));
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        String str = c;
        p.f(str, 3);
        if (motionEvent == null) {
            p.f(str, 6);
            return true;
        }
        if (this.h) {
            return true;
        }
        p.f(str, 3);
        this.d.r((int) motionEvent.getX(), (int) motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        p.f(c, 3);
        return true;
    }
}
