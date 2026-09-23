package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.RouteInfo;
import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fy implements RouteInfo {
    public static final fy a = new fy(null, null);
    private final TimeAndDistance b;
    private final TimeAndDistance c;

    public fy(TimeAndDistance timeAndDistance, TimeAndDistance timeAndDistance2) {
        this.b = timeAndDistance;
        this.c = timeAndDistance2;
    }

    @Override // com.google.android.libraries.navigation.RouteInfo
    public final TimeAndDistance getTimeAndDistance(int i) {
        if (i == 0) {
            return this.b;
        }
        if (i == 1) {
            return this.c;
        }
        throw new ApiIllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "Unknown routing strategy: "));
    }
}
