package com.google.android.libraries.navigation.internal.abi;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.google.android.libraries.navigation.internal.abf.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements i {
    protected h a;
    public boolean b;
    private j c;

    public final void a(Context context, h hVar, boolean z) {
        this.a = hVar;
        this.c = new j(context, this, z);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.i
    public final void b(j jVar, boolean z) {
        this.a.a();
        if (z) {
            this.a.c(new b(3, jVar));
        } else {
            this.a.c(new b(2, jVar));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abi.i
    public final boolean c(j jVar, boolean z) {
        if (z) {
            return true;
        }
        return this.a.c(new b(0, jVar));
    }

    @Override // com.google.android.libraries.navigation.internal.abi.i
    public final boolean d(j jVar, boolean z) {
        if (z) {
            return true;
        }
        boolean zC = this.a.c(new b(1, jVar));
        if (zC) {
            this.a.b();
        }
        return zC;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:113:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:114:0x0202  */
    /* JADX WARN: Code duplicated, block: B:117:0x0213  */
    /* JADX WARN: Code duplicated, block: B:218:0x0454  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6 A[PHI: r3
      0x00b6: PHI (r3v4 int) = (r3v3 int), (r3v3 int), (r3v5 int) binds: [B:45:0x00af, B:46:0x00b1, B:48:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2  */
    public final void e(MotionEvent motionEvent) {
        int pointerCount;
        MotionEvent motionEvent2;
        int pointerCount2;
        j jVar = this.c;
        int action = motionEvent.getAction();
        int i = (action >> 8) & 255;
        if (jVar.s) {
            if (jVar.d.isEmpty()) {
                jVar.f(MotionEvent.obtain(motionEvent));
            } else if (action == 1) {
                jVar.e(motionEvent);
                if (i == 0) {
                    pointerCount = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount = 0;
                }
                jVar.e = motionEvent.getX(pointerCount);
                jVar.f = motionEvent.getY(pointerCount);
                if (!jVar.r) {
                    jVar.c();
                }
                jVar.d();
            } else if (action == 2) {
                jVar.e(motionEvent);
                jVar.f(jVar.c);
                if (jVar.m / jVar.f128n > 0.67f) {
                    boolean zH = false;
                    for (c cVar : jVar.d) {
                        s.c(cVar.b);
                        if (!cVar.b) {
                            throw new IllegalStateException("Gesture is not active: ".concat(String.valueOf(cVar.getClass().getName())));
                        }
                        zH |= cVar.h(jVar);
                    }
                    if (zH) {
                        jVar.b = MotionEvent.obtain(motionEvent);
                    }
                }
            } else if (action == 3) {
                if (!jVar.r) {
                    jVar.c();
                }
                jVar.d();
            } else if (action == 6 || action == 262) {
                jVar.e(motionEvent);
                if (i == 0) {
                    pointerCount = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount = 0;
                }
                jVar.e = motionEvent.getX(pointerCount);
                jVar.f = motionEvent.getY(pointerCount);
                if (!jVar.r) {
                    jVar.c();
                }
                jVar.d();
            }
        } else if (action == 5 || action == 261 || action == 0) {
            DisplayMetrics displayMetrics = jVar.a.getResources().getDisplayMetrics();
            jVar.p = displayMetrics.widthPixels - jVar.o;
            jVar.q = displayMetrics.heightPixels - jVar.o;
            jVar.d();
            jVar.b = MotionEvent.obtain(motionEvent);
            jVar.e(motionEvent);
            float f = jVar.o;
            float f2 = jVar.p;
            float f3 = jVar.q;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fA = j.a(motionEvent, motionEvent.getPointerCount() - 1);
            float fB = j.b(motionEvent, motionEvent.getPointerCount() - 1);
            boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
            boolean z2 = fA < f || fB < f || fA > f2 || fB > f3;
            if (z && z2) {
                jVar.e = -1.0f;
                jVar.f = -1.0f;
                jVar.r = true;
            } else if (z) {
                jVar.e = motionEvent.getX(motionEvent.getPointerCount() - 1);
                jVar.f = motionEvent.getY(motionEvent.getPointerCount() - 1);
                jVar.r = true;
            } else if (z2) {
                jVar.e = motionEvent.getX(0);
                jVar.f = motionEvent.getY(0);
                jVar.r = true;
            } else {
                jVar.s = true;
            }
        } else if (action != 2) {
            if (action != 6 || action == 262) {
                if (jVar.r) {
                    if (i == 0) {
                        pointerCount2 = motionEvent.getPointerCount() - 1;
                    } else {
                        pointerCount2 = 0;
                    }
                    jVar.e = motionEvent.getX(pointerCount2);
                    jVar.f = motionEvent.getY(pointerCount2);
                }
            } else if (action == 1) {
                action = 1;
                if (jVar.r) {
                    if (i == 0) {
                        pointerCount2 = motionEvent.getPointerCount() - 1;
                    } else {
                        pointerCount2 = 0;
                    }
                    jVar.e = motionEvent.getX(pointerCount2);
                    jVar.f = motionEvent.getY(pointerCount2);
                }
            }
        } else if (jVar.r) {
            float f4 = jVar.o;
            float f5 = jVar.p;
            float f6 = jVar.q;
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            float fA2 = j.a(motionEvent, motionEvent.getPointerCount() - 1);
            float fB2 = j.b(motionEvent, motionEvent.getPointerCount() - 1);
            boolean z3 = rawX2 < f4 || rawY2 < f4 || rawX2 > f5 || rawY2 > f6;
            boolean z4 = fA2 < f4 || fB2 < f4 || fA2 > f5 || fB2 > f6;
            if (z3 && z4) {
                jVar.e = -1.0f;
                jVar.f = -1.0f;
            } else if (z3) {
                jVar.e = motionEvent.getX(motionEvent.getPointerCount() - 1);
                jVar.f = motionEvent.getY(motionEvent.getPointerCount() - 1);
            } else if (z4) {
                jVar.e = motionEvent.getX(0);
                jVar.f = motionEvent.getY(0);
            } else {
                jVar.r = false;
                jVar.s = true;
            }
            action = 2;
        } else {
            action = 2;
            if (action != 6) {
                if (jVar.r) {
                    if (i == 0) {
                        pointerCount2 = motionEvent.getPointerCount() - 1;
                    } else {
                        pointerCount2 = 0;
                    }
                    jVar.e = motionEvent.getX(pointerCount2);
                    jVar.f = motionEvent.getY(pointerCount2);
                }
            } else if (jVar.r) {
                if (i == 0) {
                    pointerCount2 = motionEvent.getPointerCount() - 1;
                } else {
                    pointerCount2 = 0;
                }
                jVar.e = motionEvent.getX(pointerCount2);
                jVar.f = motionEvent.getY(pointerCount2);
            }
        }
        f fVar = jVar.t;
        int action2 = motionEvent.getAction();
        if (fVar.x == null) {
            fVar.x = VelocityTracker.obtain();
        }
        fVar.x.addMovement(motionEvent);
        int i2 = action2 & 255;
        boolean z5 = i2 == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int pointerCount3 = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i3 = 0; i3 < pointerCount3; i3++) {
            if (actionIndex != i3) {
                x += motionEvent.getX(i3);
                y += motionEvent.getY(i3);
            }
        }
        float f7 = z5 ? pointerCount3 - 1 : pointerCount3;
        float f8 = x / f7;
        float f9 = y / f7;
        if (i2 == 0) {
            if (fVar.k != null) {
                boolean zHasMessages = fVar.i.hasMessages(3);
                if (zHasMessages) {
                    fVar.i.removeMessages(3);
                }
                MotionEvent motionEvent3 = fVar.p;
                if (motionEvent3 == null || (motionEvent2 = fVar.q) == null || !zHasMessages || !fVar.o || motionEvent.getEventTime() - motionEvent2.getEventTime() > f.c) {
                    fVar.i.sendEmptyMessageDelayed(3, f.c);
                } else {
                    int x2 = (int) motionEvent3.getX();
                    int x3 = (int) motionEvent.getX();
                    int y2 = ((int) motionEvent3.getY()) - ((int) motionEvent.getY());
                    int i4 = x2 - x3;
                    if ((i4 * i4) + (y2 * y2) < fVar.f) {
                        fVar.r = true;
                        fVar.k.onDoubleTap(fVar.p);
                        fVar.k.onDoubleTapEvent(motionEvent);
                    } else {
                        fVar.i.sendEmptyMessageDelayed(3, f.c);
                    }
                }
            }
            fVar.s = f8;
            fVar.u = f8;
            fVar.t = f9;
            fVar.v = f9;
            MotionEvent motionEvent4 = fVar.p;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            fVar.p = MotionEvent.obtain(motionEvent);
            fVar.f127n = true;
            fVar.o = true;
            fVar.l = true;
            fVar.m = false;
            if (fVar.w) {
                fVar.i.removeMessages(2);
                fVar.i.sendEmptyMessageAtTime(2, fVar.p.getDownTime() + ((long) f.b) + ((long) f.a));
            }
            fVar.i.sendEmptyMessageAtTime(1, fVar.p.getDownTime() + ((long) f.b));
            fVar.j.onDown(motionEvent);
        } else if (i2 == 1) {
            fVar.l = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (fVar.r) {
                fVar.k.onDoubleTapEvent(motionEvent);
            } else if (fVar.m) {
                fVar.i.removeMessages(3);
                fVar.m = false;
                fVar.j.onSingleTapUp(motionEvent);
            } else if (fVar.f127n) {
                fVar.j.onSingleTapUp(motionEvent);
            } else {
                VelocityTracker velocityTracker = fVar.x;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(1000, fVar.h);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                float fAbs = Math.abs(yVelocity);
                float f10 = fVar.g;
                if (fAbs > f10 || Math.abs(xVelocity) > f10) {
                    fVar.j.onFling(fVar.p, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent5 = fVar.q;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            fVar.q = motionEventObtain;
            VelocityTracker velocityTracker2 = fVar.x;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                fVar.x = null;
            }
            fVar.r = false;
            fVar.i.removeMessages(1);
            fVar.i.removeMessages(2);
        } else if (i2 == 2) {
            float f11 = fVar.s - f8;
            float f12 = fVar.t - f9;
            if (fVar.r) {
                fVar.k.onDoubleTapEvent(motionEvent);
            } else if (fVar.f127n) {
                float f13 = f8 - fVar.u;
                int i5 = (int) (f9 - fVar.v);
                int i6 = (int) f13;
                int i7 = (i6 * i6) + (i5 * i5);
                if (i7 > fVar.d) {
                    fVar.j.onScroll(fVar.p, motionEvent, f11, f12);
                    fVar.s = f8;
                    fVar.t = f9;
                    fVar.f127n = false;
                    fVar.i.removeMessages(3);
                    fVar.i.removeMessages(1);
                    fVar.i.removeMessages(2);
                }
                if (i7 > fVar.e) {
                    fVar.o = false;
                }
            } else if (Math.abs(f11) >= 1.0f || Math.abs(f12) >= 1.0f) {
                fVar.j.onScroll(fVar.p, motionEvent, f11, f12);
                fVar.s = f8;
                fVar.t = f9;
            }
        } else if (i2 == 3) {
            fVar.i.removeMessages(1);
            fVar.i.removeMessages(2);
            fVar.i.removeMessages(3);
            fVar.x.recycle();
            fVar.x = null;
            fVar.r = false;
            fVar.l = false;
            fVar.f127n = false;
            fVar.o = false;
            if (fVar.m) {
                fVar.m = false;
            }
        } else if (i2 == 5) {
            fVar.s = f8;
            fVar.u = f8;
            fVar.t = f9;
            fVar.v = f9;
            fVar.i.removeMessages(1);
            fVar.i.removeMessages(2);
            fVar.i.removeMessages(3);
            fVar.r = false;
            fVar.f127n = false;
            fVar.o = false;
            if (fVar.m) {
                fVar.m = false;
            }
        } else if (i2 == 6) {
            fVar.s = f8;
            fVar.u = f8;
            fVar.t = f9;
            fVar.v = f9;
            fVar.x.computeCurrentVelocity(1000, fVar.h);
            int actionIndex2 = motionEvent.getActionIndex();
            int pointerId2 = motionEvent.getPointerId(actionIndex2);
            float xVelocity2 = fVar.x.getXVelocity(pointerId2);
            float yVelocity2 = fVar.x.getYVelocity(pointerId2);
            for (int i8 = 0; i8 < pointerCount3; i8++) {
                if (i8 != actionIndex2) {
                    int pointerId3 = motionEvent.getPointerId(i8);
                    if ((fVar.x.getXVelocity(pointerId3) * xVelocity2) + (fVar.x.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                        fVar.x.clear();
                        break;
                    }
                }
            }
        }
        if (action == 3 || action == 1) {
            ((d) jVar.u).a.f();
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return this.a.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.a.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.a.onDown(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.a.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        this.a.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return !this.b && this.a.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
        this.a.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.a.onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.a.onSingleTapUp(motionEvent);
    }
}
