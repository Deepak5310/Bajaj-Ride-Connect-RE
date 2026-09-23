package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.abm.dy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw {
    public final be a;
    public boolean b = false;

    public aw(be beVar) {
        this.a = beVar;
    }

    public final synchronized double a() {
        j();
        return this.a.a();
    }

    public final double b() {
        j();
        return this.a.a;
    }

    public final float c() {
        j();
        return this.a.b();
    }

    public final CameraPosition d() {
        j();
        return this.a.c();
    }

    public final LatLng e(float f, float f2, boolean z) {
        j();
        return this.a.h(f, f2, z);
    }

    public final com.google.android.libraries.navigation.internal.abf.ak f(com.google.android.libraries.navigation.internal.abf.ak akVar) {
        j();
        return this.a.j(akVar);
    }

    public final com.google.android.libraries.navigation.internal.abf.ak g() {
        j();
        return this.a.k();
    }

    public final synchronized dy h(com.google.android.libraries.navigation.internal.abf.ak akVar) {
        j();
        return this.a.m(akVar);
    }

    public final ac i() {
        j();
        return this.a.o();
    }

    public final void j() {
        if (this.b) {
            throw new IllegalStateException("called outside of scope");
        }
    }

    public final void k(Float f) {
        j();
        this.a.v(f);
    }
}
