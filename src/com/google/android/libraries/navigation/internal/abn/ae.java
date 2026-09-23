package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final CameraPosition d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public ae(ad adVar) {
        boolean z = adVar.a;
        boolean z2 = adVar.b;
        CameraPosition cameraPosition = adVar.d;
        boolean z3 = adVar.f;
        boolean z4 = adVar.g;
        boolean z5 = adVar.h;
        this.a = z;
        this.b = z2;
        this.c = false;
        com.google.android.libraries.navigation.internal.abf.s.k(cameraPosition, "rendererCameraPosition");
        this.d = cameraPosition;
        this.e = z3;
        this.f = z4;
        this.g = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ae)) {
            return false;
        }
        ae aeVar = (ae) obj;
        if (this.a == aeVar.a && this.b == aeVar.b) {
            boolean z = aeVar.c;
            if (com.google.android.libraries.navigation.internal.abf.r.a(this.d, aeVar.d) && this.e == aeVar.e && this.f == aeVar.f && this.g == aeVar.g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.a), Boolean.valueOf(this.b), false, this.d, Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g)});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarE = com.google.android.libraries.navigation.internal.abf.aj.f(this).e("isCameraMoving", this.a).e("isUserGesture", this.b).e("isSceneResolved", false);
        ajVarE.g("rendererCameraPosition", this.d);
        return ajVarE.e("wasCameraClamped", this.e).e("wasCameraDiscarded", this.f).e("wasAnimationExhausted", this.g).toString();
    }
}
