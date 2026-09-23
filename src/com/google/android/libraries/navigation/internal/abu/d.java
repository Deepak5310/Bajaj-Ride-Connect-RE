package com.google.android.libraries.navigation.internal.abu;

import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final b a;
    public final c b;
    public final StreetViewPanoramaOrientation c;

    public d(b bVar, c cVar, StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.a = bVar;
        this.b = cVar;
        this.c = streetViewPanoramaOrientation;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return r.a(this.a, dVar.a) && r.a(this.b, dVar.b) && r.a(this.c, dVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("pano", this.a);
        ajVarF.g("plane", this.b);
        ajVarF.g("newOrientation", this.c);
        return ajVarF.toString();
    }
}
