package com.google.android.libraries.navigation.internal.abt;

import android.opengl.Matrix;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final String a = "i";
    public final float e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final double j;
    public final float k;
    public final double l;
    public final double m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final double f153n;
    public final double o;
    public final double p;
    public final double q;
    float[] r;
    float[] s;
    float[] t;
    float[] u;
    float[] v;
    private static final ThreadLocal w = new g();
    public static final ThreadLocal b = new g();
    public static final ThreadLocal c = com.google.android.libraries.navigation.internal.abw.k.q();
    public static final float[] d = {0.0f, 1.0f, 0.0f};

    public i(float f, float f2, float f3, int i, int i2) {
        p.f(a, 3);
        s.i(f, "eyeCameraTiltDeg cannot be NaN");
        s.i(f2, "eyeCameraBearingDeg cannot be NaN");
        s.i(f3, "eyeCameraZoom cannot be NaN");
        s.f(f, com.google.android.libraries.navigation.internal.b.b.h(f, "illegal tilt: "));
        s.a(f3 >= 0.0f, com.google.android.libraries.navigation.internal.b.b.h(f3, "illegal eyeCameraZoom: "));
        s.a(i > 0, com.google.android.libraries.navigation.internal.b.b.b(i, "illegal screenWidthPpx: "));
        s.a(i2 > 0, com.google.android.libraries.navigation.internal.b.b.b(i2, "illegal screenHeightPpx: "));
        this.e = f;
        this.f = com.google.android.libraries.navigation.internal.abw.k.l(f2);
        this.g = f3;
        this.h = i;
        this.i = i2;
        this.j = 90.0d;
        this.k = i / i2;
        double dS = com.google.android.libraries.navigation.internal.abw.k.s(i, i2);
        this.l = dS;
        double d2 = com.google.android.libraries.navigation.internal.abw.k.d(i, i2, 90.0d);
        this.m = d2;
        double dPow = Math.pow(2.0d, -f3);
        this.f153n = dPow;
        this.o = dS * dPow;
        double d3 = dPow * d2;
        this.p = d3;
        this.q = (((double) i2) / 2.0d) / Math.tan(com.google.android.libraries.navigation.internal.abw.k.f(d3 / 2.0d));
        synchronized (this) {
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
        }
    }

    public static void c(float f, float f2, float[] fArr) {
        s.i(f, "tiltDeg cannot be NaN");
        s.f(f, String.format("illegal tiltDeg: %s", Float.valueOf(f)));
        s.i(f2, "bearingDeg cannot be NaN");
        s.k(fArr, "worldSpaceVector");
        int length = fArr.length;
        s.b(length == 4, "worldSpaceVector#%s != %s", Integer.valueOf(length), 4);
        float fM = com.google.android.libraries.navigation.internal.abw.k.m(f2);
        float fM2 = com.google.android.libraries.navigation.internal.abw.k.m(f2);
        float fM3 = com.google.android.libraries.navigation.internal.abw.k.m(f);
        double dM = com.google.android.libraries.navigation.internal.abw.k.m(f);
        double dSin = Math.sin(fM);
        double dCos = Math.cos(fM2);
        double dSin2 = Math.sin(fM3);
        double dCos2 = Math.cos(dM);
        fArr[0] = (float) (dSin * dCos2);
        fArr[1] = (float) dSin2;
        fArr[2] = (float) ((-dCos) * dCos2);
        fArr[3] = 1.0f;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d6  */
    public final StreetViewPanoramaOrientation a(int i, int i2) {
        String str = a;
        p.f(str, 4);
        h hVar = (h) w.get();
        float[] fArr = hVar.a;
        float[] fArr2 = hVar.b;
        fArr[0] = (float) (((double) i) - (((double) this.h) * 0.5d));
        fArr[1] = (float) ((((double) this.i) * 0.5d) - ((double) i2));
        fArr[2] = (float) this.q;
        fArr[3] = 1.0f;
        if (p.f(str, 3)) {
            Arrays.toString(fArr);
        }
        Matrix.multiplyMV(fArr2, 0, d(), 0, fArr, 0);
        if (p.f(str, 3)) {
            Arrays.toString(fArr2);
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float f4 = this.f;
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = null;
        if (!Float.isNaN(f) && !Float.isNaN(f2) && !Float.isNaN(f3) && (f != 0.0f || f2 != 0.0f || f3 != 0.0f)) {
            if (f == 0.0f && f3 == 0.0f) {
                streetViewPanoramaOrientation = new StreetViewPanoramaOrientation(f2 > 0.0f ? 90.0f : -90.0f, f4);
            } else {
                double dE = com.google.android.libraries.navigation.internal.abw.k.e(Math.asin(((double) f2) / Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3))));
                double dE2 = com.google.android.libraries.navigation.internal.abw.k.e(Math.atan2(f, f3));
                if (Double.isNaN(dE) || Double.isNaN(dE2)) {
                    p.f(str, 6);
                } else {
                    float f5 = (float) dE;
                    if (Float.isNaN(f5)) {
                        p.f(str, 6);
                    } else {
                        float f6 = (float) dE2;
                        if (Float.isNaN(f6)) {
                            p.f(str, 6);
                        } else {
                            streetViewPanoramaOrientation = new StreetViewPanoramaOrientation(com.google.android.libraries.navigation.internal.abw.k.j(f5), f6);
                        }
                    }
                }
            }
        }
        p.f(str, 3);
        return streetViewPanoramaOrientation;
    }

    public final i b(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        s.k(streetViewPanoramaCamera, "camera");
        return new i(streetViewPanoramaCamera.tilt, streetViewPanoramaCamera.bearing, streetViewPanoramaCamera.zoom, this.h, this.i);
    }

    final synchronized float[] d() {
        float[] fArr = this.s;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[16];
        this.s = fArr2;
        Matrix.invertM(fArr2, 0, e(), 0);
        return this.s;
    }

    public final synchronized float[] e() {
        float[] fArr = this.r;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[16];
        this.r = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.rotateM(this.r, 0, this.e, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.r, 0, -this.f, 0.0f, 1.0f, 0.0f);
        return this.r;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (r.a(Float.valueOf(this.e), Float.valueOf(iVar.e)) && r.a(Float.valueOf(this.f), Float.valueOf(iVar.f)) && r.a(Float.valueOf(this.g), Float.valueOf(iVar.g)) && r.a(Integer.valueOf(this.h), Integer.valueOf(iVar.h)) && r.a(Integer.valueOf(this.i), Integer.valueOf(iVar.i))) {
            Double dValueOf = Double.valueOf(90.0d);
            double d2 = iVar.j;
            if (r.a(dValueOf, dValueOf)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized float[] f() {
        float[] fArr = this.t;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[16];
        this.t = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.rotateM(this.t, 0, -this.e, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.t, 0, this.f, 0.0f, 1.0f, 0.0f);
        return this.t;
    }

    public final synchronized float[] g() {
        float[] fArr = this.v;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[16];
        this.v = fArr2;
        Matrix.multiplyMM(fArr2, 0, h(), 0, f(), 0);
        return this.v;
    }

    public final synchronized float[] h() {
        float[] fArr = this.u;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[16];
        this.u = fArr2;
        Matrix.perspectiveM(fArr2, 0, (float) this.p, this.k, 0.1f, 400.0f);
        return this.u;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g)});
    }

    public final synchronized String toString() {
        boolean z;
        aj ajVarE;
        z = true;
        ajVarE = aj.f(this).b("eyeCameraTiltDeg", this.e).b("eyeCameraBearingDeg", this.f).b("eyeCameraZoom", this.g).c("screenWidthPpx", this.h).c("screenHeightPpx", this.i).a("maxFovDeg", 90.0d).a("unzoomedFovXDeg", this.l).a("unzoomedFovYDeg", this.m).a("fovZoomScale", this.f153n).a("fovXDeg", this.o).a("fovYDeg", this.p).a("distanceFromEyeToScreen", this.q).e("?world2viewMatrix", this.r != null);
        if (this.s == null) {
            z = false;
        }
        return ajVarE.e("?view2worldMatrix", z).toString();
    }

    public i(StreetViewPanoramaCamera streetViewPanoramaCamera, int i, int i2) {
        this(streetViewPanoramaCamera.tilt, streetViewPanoramaCamera.bearing, streetViewPanoramaCamera.zoom, i, i2);
    }
}
