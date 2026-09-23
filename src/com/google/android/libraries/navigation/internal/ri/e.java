package com.google.android.libraries.navigation.internal.ri;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.geo.mapcore.renderer.bg;
import com.google.android.libraries.navigation.internal.pn.j;
import com.google.android.libraries.navigation.internal.pn.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.pn.i {
    public final View a;
    private final n b;

    public e(bg bgVar, j jVar, boolean z) {
        View viewA = bgVar.a();
        this.a = viewA;
        n nVar = new n(jVar, bgVar.a(), z);
        this.b = nVar;
        viewA.setClickable(true);
        a aVar = new a(this, nVar);
        viewA.setOnTouchListener(new b(aVar));
        viewA.setOnHoverListener(new d(this, aVar));
    }

    public static boolean a(View view, MotionEvent motionEvent, n nVar) {
        if (!view.isEnabled() || !view.isClickable()) {
            return false;
        }
        nVar.f(motionEvent);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final int b() {
        return this.a.getHeight();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final int c() {
        return this.a.getWidth();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final n d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void e() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void f() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void g(float f, float f2) {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void h() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void i(float f, float f2) {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void k(float f, float f2) {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void l(float f, float f2) {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void m() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void o() {
    }

    @Override // com.google.android.libraries.navigation.internal.pn.i
    public final void p(float f, float f2, float f3, boolean z) {
    }
}
