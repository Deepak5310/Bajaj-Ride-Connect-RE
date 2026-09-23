package com.google.android.libraries.navigation.internal.xe;

import android.location.Location;
import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj implements com.google.android.libraries.navigation.internal.abh.bq {
    private final ai a;

    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void a() {
        if (this.a.d()) {
            this.a.a();
            this.a.a.m();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void b() {
        this.a.a.e();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void c(Location location) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void d(float f) {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void e() {
        if (this.a.d()) {
            this.a.b(false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void f(com.google.android.libraries.navigation.internal.afl.fd fdVar, FollowMyLocationOptions followMyLocationOptions) {
        if (this.a.d()) {
            ai aiVar = this.a;
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (!aiVar.a.t) {
                throw new ApiIllegalStateException("Navigator must be initialized to follow location. Please call NavigationApi.getNavigator.");
            }
            aiVar.b.a(com.google.android.libraries.navigation.internal.zp.n.CY);
            aiVar.a.c(fdVar, followMyLocationOptions == null ? null : followMyLocationOptions.getZoomLevel(), null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final boolean g() {
        return this.a.c();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final boolean h() {
        return this.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bq
    public final void i() {
        this.a.a();
    }
}
