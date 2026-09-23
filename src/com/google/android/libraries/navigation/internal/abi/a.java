package com.google.android.libraries.navigation.internal.abi;

import android.view.MotionEvent;
import com.google.android.libraries.navigation.internal.abf.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends g {
    private MotionEvent a;

    public a(MotionEvent motionEvent) {
        s.j(motionEvent);
        this.a = motionEvent;
    }

    private final void k() {
        s.k(this.a, "Event has been recycled.");
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final float a(int i) {
        k();
        return this.a.getX(i);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final float b() {
        k();
        return com.google.android.libraries.navigation.internal.abf.e.i;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final float c(int i) {
        k();
        return this.a.getY(i);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final float d() {
        k();
        return com.google.android.libraries.navigation.internal.abf.e.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final int e() {
        k();
        return this.a.getPointerCount();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final long f() {
        k();
        return this.a.getEventTime();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.g
    public final void g() {
        k();
        this.a.recycle();
        this.a = null;
    }
}
