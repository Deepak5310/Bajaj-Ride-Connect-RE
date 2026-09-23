package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements k {
    public static final az a;
    public static final az b;
    public static final az c;
    public static final az d;
    public static final az e;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("ContextualStyling__enable_custom_navigation", false, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.d("ContextualStyling__enable_custom_navigation_low_light", false, "com.google.android.gms.maps", fyVarQ, true);
        c = bh.d("ContextualStyling__enable_custom_roadmap_dark", false, "com.google.android.gms.maps", fyVarQ, true);
        d = bh.d("ContextualStyling__enable_map_id_config", false, "com.google.android.gms.maps", fyVarQ, true);
        e = bh.d("ContextualStyling__enable_prefetching_roadmap_dark", false, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.k
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.k
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.k
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.k
    public final boolean d() {
        return ((Boolean) d.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.k
    public final boolean e() {
        return ((Boolean) e.a()).booleanValue();
    }
}
