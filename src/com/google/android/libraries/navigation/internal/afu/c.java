package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements b {
    public static final az a;
    public static final az b;
    public static final az c;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("BoomerangReliabilityManagement__ignore_repeated_log_attempts", false, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.b("BoomerangReliabilityManagement__recovery_crash_count_threshold", 3L, "com.google.android.gms.maps", fyVarQ, true);
        c = bh.d("BoomerangReliabilityManagement__should_queue_tile_deletion_enabled", false, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.b
    public final long a() {
        return ((Long) b.a()).longValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.b
    public final boolean b() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.b
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }
}
