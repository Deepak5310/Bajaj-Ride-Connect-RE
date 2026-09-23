package com.google.android.libraries.geo.navcore.ui.header.views;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class p extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ SwipeableHeaderView a;

    public p(SwipeableHeaderView swipeableHeaderView) {
        this.a = swipeableHeaderView;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027 A[PHI: r3
      0x0027: PHI (r3v7 com.google.android.libraries.geo.navcore.ui.header.views.SwipeableHeaderView) = 
      (r3v5 com.google.android.libraries.geo.navcore.ui.header.views.SwipeableHeaderView)
      (r3v8 com.google.android.libraries.geo.navcore.ui.header.views.SwipeableHeaderView)
     binds: [B:11:0x0024, B:8:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        SwipeableHeaderView swipeableHeaderView;
        if (Math.abs(f) <= Math.abs(f2)) {
            return false;
        }
        int i = 2;
        if (this.a.i()) {
            swipeableHeaderView = this.a;
            if (f <= 0.0f) {
                i = 3;
            }
        } else {
            swipeableHeaderView = this.a;
            if (f >= 0.0f) {
                i = 3;
            }
        }
        swipeableHeaderView.u = i;
        return false;
    }
}
