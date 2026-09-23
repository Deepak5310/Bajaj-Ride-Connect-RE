package com.mappls.sdk.navigation.refresh;

import android.content.Context;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.services.api.alongroute.models.SuggestedPOI;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements LocationPoint {
    SuggestedPOI a;
    int b;

    public d(SuggestedPOI suggestedPOI, int i) {
        this.a = suggestedPOI;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final double getLatitude() {
        return this.a.getLatitude().doubleValue();
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final double getLongitude() {
        return this.a.getLongitude().doubleValue();
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final com.mappls.sdk.navigation.data.a getPointDescription(Context context) {
        return new com.mappls.sdk.navigation.data.a(GeoCodingCriteria.POD_POINT_OF_INTEREST, this.a.getPopularName());
    }
}
