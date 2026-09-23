package com.google.android.libraries.navigation.internal.abr;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abt.i;
import com.google.android.libraries.navigation.internal.abw.k;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.abq.b {
    private static final String a = "f";
    private final float b;
    private final float c;
    private final float d;

    public f(float f, float f2, float f3) {
        this.b = f;
        this.c = f2;
        this.d = f3;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        s.k(streetViewPanoramaCamera, "currentCamera");
        s.k(aVar, "currentRaycasterProvider");
        i iVar = (i) aVar.a();
        StreetViewPanoramaOrientation streetViewPanoramaOrientationA = iVar.a((int) this.c, (int) this.d);
        if (streetViewPanoramaOrientationA == null) {
            p.f(a, 6);
            return null;
        }
        float f = streetViewPanoramaCamera.bearing;
        float f2 = streetViewPanoramaOrientationA.bearing;
        double dTan = Math.tan(k.m(k.g(f, f2)));
        float f3 = streetViewPanoramaCamera.tilt;
        float f4 = streetViewPanoramaOrientationA.tilt;
        double dTan2 = Math.tan(k.m(k.g(f3, f4)));
        float f5 = streetViewPanoramaCamera.zoom;
        double dPow = Math.pow(2.0d, -f5) * 0.5d;
        double d2 = iVar.l;
        double d3 = iVar.m;
        double dTan3 = dTan / Math.tan(k.f(dPow * d2));
        double dTan4 = dTan2 / Math.tan(k.f(dPow * d3));
        double dI = k.i(f5 + this.b, 0.0f, i);
        double dPow2 = Math.pow(2.0d, -dI) * 0.5d;
        double dTan5 = dTan3 * Math.tan(k.f(d2 * dPow2));
        return new StreetViewPanoramaCamera((float) dI, k.j((float) (((double) f4) + k.e(Math.atan(dTan4 * Math.tan(k.f(dPow2 * d3)))))), (float) (((double) f2) + k.e(Math.atan(dTan5))));
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return r.a(Float.valueOf(this.b), Float.valueOf(fVar.b)) && r.a(Float.valueOf(this.c), Float.valueOf(fVar.c)) && r.a(Float.valueOf(this.d), Float.valueOf(fVar.d));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d)});
    }

    public final String toString() {
        return aj.f(this).b("deltaZoom", this.b).b("focusXPpx", this.c).b("focusYPpx", this.d).toString();
    }
}
