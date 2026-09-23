package com.google.android.libraries.navigation.internal.abr;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abw.k;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.google.android.libraries.navigation.internal.abq.b {
    private final float a;
    private final float b;

    public d(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        s.k(streetViewPanoramaCamera, "currentCamera");
        float f = streetViewPanoramaCamera.zoom;
        float fPow = (float) Math.pow(2.0d, -f);
        return new StreetViewPanoramaCamera(f, k.j(streetViewPanoramaCamera.tilt + (this.b * fPow)), streetViewPanoramaCamera.bearing + (fPow * this.a));
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return r.a(Float.valueOf(this.b), Float.valueOf(dVar.b)) && r.a(Float.valueOf(this.a), Float.valueOf(dVar.a));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.b), Float.valueOf(this.a)});
    }

    public final String toString() {
        return aj.f(this).b("tiltDeltaDeg", this.b).b("bearingDeltaDeg", this.a).toString();
    }
}
