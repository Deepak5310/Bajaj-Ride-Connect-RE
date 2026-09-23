package com.google.android.libraries.navigation.internal.abr;

import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements com.google.android.libraries.navigation.internal.abq.b {
    private final boolean a = true;

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final StreetViewPanoramaCamera a(StreetViewPanoramaCamera streetViewPanoramaCamera, com.google.android.libraries.navigation.internal.agl.a aVar, int i, double d) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abq.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        boolean z = ((e) obj).a;
        return r.a(true, true);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{true});
    }

    public final String toString() {
        return aj.f(this).e("isUserGesture", true).toString();
    }
}
