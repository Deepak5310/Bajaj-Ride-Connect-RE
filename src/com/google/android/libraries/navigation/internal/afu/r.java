package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements q {
    public static final az a;
    public static final az b;
    public static final az c;
    public static final az d;

    static {
        mb mbVar = mb.a;
        fy fyVarQ = fy.q("MAPS_API", "GMM_REALTIME_COUNTERS");
        a = bh.d("DeveloperOverrides__force_lite_mode", false, "com.google.android.gms.maps", fyVarQ, true);
        b = bh.c("DeveloperOverrides__quota_status", "", "com.google.android.gms.maps", fyVarQ, true);
        c = bh.d("DeveloperOverrides__show_renderer_label", false, "com.google.android.gms.maps", fyVarQ, true);
        d = bh.d("DeveloperOverrides__show_renderer_version", false, "com.google.android.gms.maps", fyVarQ, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.q
    public final String a() {
        return (String) b.a();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.q
    public final boolean b() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.q
    public final boolean c() {
        return ((Boolean) c.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afu.q
    public final boolean d() {
        return ((Boolean) d.a()).booleanValue();
    }
}
