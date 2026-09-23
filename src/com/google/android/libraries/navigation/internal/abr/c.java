package com.google.android.libraries.navigation.internal.abr;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.abq.b {
    private final StreetViewPanoramaCamera a;
    private final boolean b;

    public c(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        s.k(streetViewPanoramaCamera, "StreetViewPanoramaCamera");
        this.a = streetViewPanoramaCamera;
        this.b = false;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (r.a(this.a, cVar.a)) {
            boolean z = cVar.b;
            if (r.a(false, false)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, false});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("destCamera", this.a);
        return ajVarF.e("isUserGesture", false).toString();
    }
}
