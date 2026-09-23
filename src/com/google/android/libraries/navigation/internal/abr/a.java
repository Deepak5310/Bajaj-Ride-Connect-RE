package com.google.android.libraries.navigation.internal.abr;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abw.k;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.abq.b {
    private final float a;
    private final float b;
    private float c;
    private float d;
    private Double e;

    public a(float f, float f2) {
        this.a = f;
        this.b = f2;
        synchronized (this) {
            this.c = Math.abs(f);
            this.d = Math.abs(f2);
            this.e = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final synchronized StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        s.k(streetViewPanoramaCamera, "currentCamera");
        if (!b()) {
            Double d2 = this.e;
            if (d2 == null) {
                this.e = Double.valueOf(d);
                return null;
            }
            if (d - d2.doubleValue() >= 0.03d) {
                this.e = Double.valueOf(d);
                float f = this.b >= 0.0f ? this.d : -this.d;
                float f2 = this.a >= 0.0f ? this.c : -this.c;
                this.c = (this.c * 0.87f) - 0.005f;
                this.d = (this.d * 0.87f) - 0.005f;
                float f3 = streetViewPanoramaCamera.zoom;
                float fPow = (float) Math.pow(2.0d, -f3);
                return new StreetViewPanoramaCamera(f3, k.j(streetViewPanoramaCamera.tilt + (f * 10.0f * fPow)), streetViewPanoramaCamera.bearing + (fPow * f2 * 10.0f));
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final synchronized boolean b() {
        return this.c <= 0.0f && this.d <= 0.0f;
    }

    public final synchronized boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        synchronized (aVar) {
            if (!r.a(Float.valueOf(this.a), Float.valueOf(aVar.a)) || !r.a(Float.valueOf(this.b), Float.valueOf(aVar.b)) || !r.a(Float.valueOf(this.c), Float.valueOf(aVar.c)) || !r.a(Float.valueOf(this.d), Float.valueOf(aVar.d))) {
                z = false;
            }
        }
        return z;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b)});
    }

    public final synchronized String toString() {
        aj ajVarB;
        ajVarB = aj.f(this).b("dx", this.a).b("dy", this.b).b("angularVelocityX", this.c).b("angularVelocityY", this.d);
        ajVarB.g("currTimeSec", this.e);
        return ajVarB.toString();
    }
}
