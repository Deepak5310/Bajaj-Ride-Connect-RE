package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Point;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.abh.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cy implements com.google.android.libraries.navigation.internal.abn.bf {
    public LatLng a = null;
    final /* synthetic */ cz b;
    private final es c;

    public cy(cz czVar) {
        this.b = czVar;
        this.c = czVar.d;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(com.google.android.libraries.navigation.internal.abn.aw awVar) {
        awVar.j();
        Point pointA = awVar.a.l().a(this.c.Q());
        this.a = cz.e(awVar, pointA.x, pointA.y);
    }
}
