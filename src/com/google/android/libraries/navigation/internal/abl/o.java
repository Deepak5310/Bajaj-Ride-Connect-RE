package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Location;
import com.google.android.libraries.navigation.internal.abh.be;
import com.google.android.libraries.navigation.internal.abh.fe;
import com.google.android.libraries.navigation.internal.abh.fg;
import com.google.android.libraries.navigation.internal.yx.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements fg {
    public final be a;
    public boolean b = false;
    public final Paint c = new Paint();
    public Location d;
    public Bitmap e;
    public Bitmap f;
    public fe g;
    public Point h;
    public float i;
    private final l j;

    public o(l lVar, be beVar) {
        this.j = lVar;
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.a = beVar;
        this.g = null;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void a() {
        if (this.b) {
            this.j.invalidate();
        }
        this.b = false;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void b() {
        if (!this.b) {
            this.j.invalidate();
        }
        this.b = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void c(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void e(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void f(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void g(fe feVar) {
        this.g = feVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final void h(Location location) {
        if (!am.a(location, this.d)) {
            this.j.invalidate();
        }
        this.d = location;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fg
    public final boolean i() {
        return this.b;
    }
}
