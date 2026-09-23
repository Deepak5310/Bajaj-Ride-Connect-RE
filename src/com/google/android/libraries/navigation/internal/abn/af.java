package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af implements v {
    private static final String a = "af";
    private float b;
    private float c;
    private long d;
    private boolean e;

    public af(float f, float f2) {
        synchronized (this) {
            this.b = f * (-0.001f);
            this.c = f2 * (-0.001f);
            this.d = 0L;
            this.e = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return 1;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized CameraPosition c(be beVar, long j) {
        if (i()) {
            return null;
        }
        if (!this.e) {
            this.d = j;
            this.e = true;
            return null;
        }
        long j2 = j - this.d;
        this.d = j;
        float fExp = (float) Math.exp((-j2) * 0.006f);
        float f = this.b;
        float f2 = (1.0f - fExp) / 0.006f;
        float f3 = this.c;
        this.b = f * fExp;
        this.c = f3 * fExp;
        CameraPosition cameraPositionF = beVar.f();
        LatLng latLngH = beVar.h(f * f2, f2 * f3, false);
        if (latLngH != null) {
            CameraPosition.Builder builder = CameraPosition.builder(cameraPositionF);
            builder.target(latLngH);
            return builder.build();
        }
        if (com.google.android.libraries.navigation.internal.abf.p.f(a, 3)) {
            String.valueOf(beVar);
        }
        this.b = 0.0f;
        this.c = 0.0f;
        return null;
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
        return Math.abs(this.b) < 0.15f && Math.abs(this.c) < 0.15f;
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
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).b("velocityX", this.b).b("velocityY", this.c).c("animationReason", 1).toString();
    }
}
