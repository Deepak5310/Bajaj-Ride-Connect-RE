package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au implements v {
    private static final String a = "au";
    private final c b;
    private boolean c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;

    public au(c cVar) {
        synchronized (this) {
            this.b = cVar;
            this.c = false;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.i = 0.0f;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return 1;
    }

    public final synchronized void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.d += f;
        this.e += f2;
        this.f += f5;
        this.g += f6;
        if (f != 0.0f || f2 != 0.0f) {
            this.h = f3;
            this.i = f4;
        }
        this.c = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionF = beVar.f();
        float f = this.h;
        float f2 = this.i;
        float f3 = this.f;
        float f4 = this.g;
        com.google.android.libraries.navigation.internal.afu.d.v();
        float f5 = this.d;
        float f6 = f5 * f5;
        float fMax = f5 < 0.0f ? Math.max(f5, f6 * f5 * 100.0f) : Math.min(f5, f6 * f5 * 100.0f);
        float f7 = this.e;
        float f8 = f7 * f7;
        float fMax2 = f7 < 0.0f ? Math.max(f7, f8 * (-0.1f)) : Math.min(f7, f8 * 0.1f);
        this.d = f5 - fMax;
        this.e = f7 - fMax2;
        this.f = 0.0f;
        this.g = 0.0f;
        if (Math.abs(fMax) < 0.001d && Math.abs(fMax2) < 0.001d && f3 == 0.0f && f4 == 0.0f) {
            com.google.android.libraries.navigation.internal.afu.d.v();
            this.c = false;
            return null;
        }
        if (f3 != 0.0f || f4 != 0.0f) {
            LatLng latLngH = beVar.h(f3, f4, false);
            if (latLngH == null) {
                com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
            }
            if (latLngH != null) {
                CameraPosition.Builder builder = CameraPosition.builder(cameraPositionF);
                builder.target(latLngH);
                cameraPositionF = builder.build();
            }
        }
        if (fMax2 != 0.0f) {
            cameraPositionF = beVar.d(cameraPositionF, fMax2, new ac(f, f2));
        }
        if (fMax != 0.0f) {
            return beVar.e(cameraPositionF, fMax, new ac(f, f2), this.b);
        }
        return cameraPositionF;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized boolean i() {
        return !this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized boolean k(CameraPosition cameraPosition, be beVar) {
        return true;
    }

    public final synchronized String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).e("isOngoing", this.c).b("totalZoomBy", this.d).b("totalRotateBy", this.e).b("totalDeltaX", this.f).b("totalDeltaY", this.g).b("x", this.h).b("y", this.i).c("animationReason", 1).toString();
    }
}
