package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.model.FollowMyLocationOptions;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends com.google.android.libraries.navigation.internal.abh.bv {
    public com.google.android.libraries.navigation.internal.afl.fd a;
    public FollowMyLocationOptions b;
    private final dn f;

    public ak(com.google.android.libraries.navigation.internal.abh.af afVar, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.abh.bq bqVar, com.google.android.libraries.navigation.internal.abh.fe feVar, dn dnVar) {
        super(afVar, acVar, bqVar, feVar);
        this.f = dnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bv
    public final void a(com.google.android.libraries.navigation.internal.afl.fd fdVar, FollowMyLocationOptions followMyLocationOptions) {
        if (!this.d.j()) {
            throw new ApiIllegalStateException("Custom location source is not allowed during follow mode. Please call setLocationSource(null) to unset it.");
        }
        if (!this.c.h()) {
            throw new ApiIllegalStateException("Navigator must be initialized to follow location. Please call NavigationApi.getNavigator.");
        }
        if (this.f.e) {
            this.c.f(fdVar, followMyLocationOptions);
            return;
        }
        this.a = fdVar;
        this.b = followMyLocationOptions;
        this.f.a(true);
    }
}
