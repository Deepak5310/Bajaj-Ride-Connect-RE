package com.google.android.libraries.navigation.internal.xe;

import android.animation.TimeInterpolator;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.pb.b {
    private final GoogleMap a;
    private final com.google.android.libraries.navigation.internal.pb.t b;
    private final View c;
    private final com.google.android.libraries.navigation.internal.hn.r d;

    public u(GoogleMap googleMap, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.a = googleMap;
        this.b = kVar.c();
        this.c = kVar.a();
        this.d = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int a() {
        return this.c.getMeasuredHeight();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final int b() {
        return this.c.getMeasuredWidth();
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final com.google.android.libraries.navigation.internal.pb.t c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.b
    public final void d(com.google.android.libraries.navigation.internal.pd.d dVar, int i, TimeInterpolator timeInterpolator) {
        if (!Float.isNaN(dVar.k) || ((com.google.android.libraries.navigation.internal.afl.fv) this.d.b()).d) {
            if (i > 0) {
                this.a.animateCamera(CameraUpdateFactory.newCameraPosition(af.a(dVar)), i, null);
            } else {
                this.a.animateCamera(CameraUpdateFactory.newCameraPosition(af.a(dVar)));
            }
        }
    }
}
