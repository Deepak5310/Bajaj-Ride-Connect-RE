package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay implements v {
    private final float a;
    private final int b = 1;

    public ay(float f) {
        this.a = f;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return 1;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionF = beVar.f();
        float fMax = Math.max(Math.min(cameraPositionF.tilt + this.a, 90.0f), 0.0f);
        CameraPosition.Builder builder = CameraPosition.builder(cameraPositionF);
        builder.tilt(fMax);
        return builder.build();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ay)) {
            return false;
        }
        ay ayVar = (ay) obj;
        if (this.a != ayVar.a) {
            return false;
        }
        int i = ayVar.b;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), 1});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean i() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        return true;
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).b("tiltByDeg", this.a).c("animationReason", 1).toString();
    }
}
