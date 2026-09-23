package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements w {
    public static final az a;
    public static final az b;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("45662393", true, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.d("MapCapabilitiesGating__metadata_logging_enabled", true, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.w
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.w
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }
}
