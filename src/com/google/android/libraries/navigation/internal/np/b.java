package com.google.android.libraries.navigation.internal.np;

import android.content.Context;
import android.location.LocationManager;
import com.google.android.libraries.navigation.internal.afr.f;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        LocationManager locationManager = (LocationManager) ((Context) ((g) this.a).a).getSystemService(FirebaseAnalytics.Param.LOCATION);
        return locationManager != null ? an.j(new a(locationManager)) : com.google.android.libraries.navigation.internal.yx.a.a;
    }
}
