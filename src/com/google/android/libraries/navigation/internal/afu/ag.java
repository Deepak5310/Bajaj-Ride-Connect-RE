package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements af {
    public static final az a;
    public static final az b;
    public static final az c;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("SliLogging__detailed_startup_time_logging_enabled", false, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.d("SliLogging__sli_logging_add_marker_nav_safe", false, "com.google.android.gms.maps", fyVarQ, true);
        c = bh.d("SliLogging__sli_logging_api_expected_exception_nav_safe", false, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.af
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.af
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.af
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }
}
