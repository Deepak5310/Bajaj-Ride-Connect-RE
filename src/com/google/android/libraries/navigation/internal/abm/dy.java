package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Point;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.libraries.navigation.internal.abh.ga;
import com.google.android.libraries.navigation.internal.po.gu;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dy implements ga {
    static final Point a = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final VisibleRegion b;
    private final gu c;

    public dy(gu guVar, VisibleRegion visibleRegion) {
        this.c = guVar;
        this.b = visibleRegion;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final Point a(LatLng latLng) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, FirebaseAnalytics.Param.LOCATION);
        Point pointA = this.c.a(f.e(latLng));
        return pointA != null ? pointA : a;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final LatLng b(Point point) {
        com.google.android.libraries.navigation.internal.abf.s.k(point, "point");
        com.google.android.libraries.navigation.internal.oe.r rVarB = this.c.b(point);
        if (rVarB == null) {
            return null;
        }
        return f.d(rVarB);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final VisibleRegion c() {
        return this.b;
    }
}
