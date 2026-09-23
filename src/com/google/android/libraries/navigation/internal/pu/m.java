package com.google.android.libraries.navigation.internal.pu;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public Context a = null;
    public com.google.android.libraries.navigation.internal.ob.n b = null;
    public com.google.android.libraries.navigation.internal.pz.c c = null;
    public com.google.android.libraries.navigation.internal.oo.c d = null;
    public com.google.android.libraries.navigation.internal.pn.j e = null;
    public boolean f = false;
    public com.google.android.libraries.navigation.internal.adi.an g = com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_TRAFFIC_V2;
    public String h = null;
    public Integer i = null;
    private final a j;
    private final n k;
    private final com.google.android.libraries.navigation.internal.pm.d l;
    private final com.google.android.libraries.navigation.internal.ox.f m;

    public m(a aVar, com.google.android.libraries.navigation.internal.pm.d dVar, com.google.android.libraries.navigation.internal.ox.f fVar, n nVar) {
        this.j = aVar;
        this.l = dVar;
        this.k = nVar;
        this.m = fVar;
    }

    public final com.google.android.libraries.navigation.internal.oo.b a() {
        Context context = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.r(context, "Activity context must be set");
        com.google.android.libraries.navigation.internal.ob.n nVar = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.r(nVar, "MapConfig must be set");
        com.google.android.libraries.navigation.internal.pz.c cVar = this.c;
        com.google.android.libraries.navigation.internal.yx.ar.r(cVar, "Theme type must be set");
        return this.j.a(context, nVar, cVar, com.google.android.libraries.navigation.internal.yx.an.i(null), com.google.android.libraries.navigation.internal.yx.an.i(this.d), com.google.android.libraries.navigation.internal.yx.an.i(this.e), com.google.android.libraries.navigation.internal.yx.an.i(null), com.google.android.libraries.navigation.internal.yx.an.i(null), Boolean.valueOf(this.f), com.google.android.libraries.navigation.internal.kn.a.PRIMARY_MAP, this.g, com.google.android.libraries.navigation.internal.yx.an.i(this.h), com.google.android.libraries.navigation.internal.yx.an.i(this.i), new com.google.android.libraries.navigation.internal.ob.w()).a();
    }
}
