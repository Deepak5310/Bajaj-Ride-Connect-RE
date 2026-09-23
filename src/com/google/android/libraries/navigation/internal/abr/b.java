package com.google.android.libraries.navigation.internal.abr;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abw.k;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.abq.b {
    private static final Interpolator a = new LinearInterpolator();
    private final StreetViewPanoramaCamera b;
    private final double c;
    private final boolean d;
    private final Interpolator e;
    private Double f;
    private Double g;
    private StreetViewPanoramaCamera h;
    private final float[] i;

    public b(StreetViewPanoramaCamera streetViewPanoramaCamera, double d, boolean z) {
        s.k(streetViewPanoramaCamera, "StreetViewPanoramaCamera");
        this.b = streetViewPanoramaCamera;
        s.a(d >= 0.0d, "durationSec must be >= 0");
        this.c = d;
        this.d = z;
        this.e = a;
        synchronized (this) {
            this.f = null;
            this.g = null;
            this.h = null;
            float[] fArr = new float[3];
            this.i = fArr;
            Arrays.fill(fArr, 0.0f);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final synchronized StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        s.k(streetViewPanoramaCamera, "currentCamera");
        if (b()) {
            return this.b;
        }
        Double dValueOf = Double.valueOf(d);
        this.g = dValueOf;
        Double d2 = this.f;
        if (d2 != null) {
            float fH = k.h(this.e.getInterpolation((float) k.a((dValueOf.doubleValue() - d2.doubleValue()) / this.c)));
            StreetViewPanoramaCamera streetViewPanoramaCamera2 = this.h;
            float f = streetViewPanoramaCamera2.bearing;
            float[] fArr = this.i;
            return new StreetViewPanoramaCamera(streetViewPanoramaCamera2.zoom + (fH * fArr[2]), k.j(streetViewPanoramaCamera2.tilt + (fArr[1] * fH)), f + (fArr[0] * fH));
        }
        this.f = dValueOf;
        this.h = streetViewPanoramaCamera;
        float[] fArr2 = this.i;
        StreetViewPanoramaCamera streetViewPanoramaCamera3 = this.b;
        float f2 = streetViewPanoramaCamera3.bearing - streetViewPanoramaCamera.bearing;
        fArr2[0] = f2;
        if (f2 < -180.0f) {
            fArr2[0] = f2 + 360.0f;
        } else if (f2 > 180.0f) {
            fArr2[0] = f2 - 360.0f;
        }
        fArr2[1] = streetViewPanoramaCamera3.tilt - streetViewPanoramaCamera.tilt;
        fArr2[2] = streetViewPanoramaCamera3.zoom - streetViewPanoramaCamera.zoom;
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final synchronized boolean b() {
        double d = this.c;
        boolean z = true;
        if (d != 0.0d) {
            Double d2 = this.f;
            if (d2 == null) {
                z = false;
            } else if (this.g.doubleValue() < d2.doubleValue() + d) {
                return false;
            }
        }
        return z;
    }

    public final synchronized boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        synchronized (bVar) {
            if (!r.a(this.b, bVar.b) || !r.a(Double.valueOf(this.c), Double.valueOf(bVar.c)) || !r.a(Boolean.valueOf(this.d), Boolean.valueOf(bVar.d)) || !r.a(this.e, bVar.e) || !r.a(this.f, bVar.f) || !r.a(this.h, bVar.h)) {
                z = false;
            }
        }
        return z;
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Double.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final synchronized String toString() {
        aj ajVarE;
        aj ajVarF = aj.f(this);
        ajVarF.g("destCamera", this.b);
        ajVarE = ajVarF.a("durationSec", this.c).e("isUserGesture", this.d);
        ajVarE.g("interpolator", this.e);
        ajVarE.g("startTimeSec", this.f);
        ajVarE.g("currTimeSec", this.g);
        ajVarE.g("startCamera", this.h);
        ajVarE.g("deltaBearingTiltZoomCache", Arrays.toString(this.i));
        return ajVarE.toString();
    }
}
