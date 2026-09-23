package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.FollowMyLocationOptions;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bv {
    private final ac a;
    public final bq c;
    public final fe d;
    protected final bs e;

    public bv(af afVar, ac acVar, bq bqVar, fe feVar) {
        this.a = acVar;
        this.c = bqVar;
        this.d = feVar;
        this.e = new bs(bqVar, feVar, afVar);
    }

    public void a(com.google.android.libraries.navigation.internal.afl.fd fdVar, FollowMyLocationOptions followMyLocationOptions) {
        if (!b()) {
            this.a.s();
        }
        this.d.e(true);
        this.c.f(fdVar, followMyLocationOptions);
    }

    public final boolean b() {
        return this.c.g();
    }
}
