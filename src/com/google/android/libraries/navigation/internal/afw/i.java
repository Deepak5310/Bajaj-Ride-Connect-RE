package com.google.android.libraries.navigation.internal.afw;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements h {
    public static final az a;
    public static final az b;

    static {
        mb mbVar = mb.a;
        fy fyVarR = fy.r("MAPS_API", "GMM_REALTIME_COUNTERS", "NAVIGATION_SDK_COUNTERS");
        a = bh.d("45660033", false, "nav_android_sdk", fyVarR, true);
        b = bh.d("45663871", false, "nav_android_sdk", fyVarR, true);
    }

    @Override // com.google.android.libraries.navigation.internal.afw.h
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.afw.h
    public final boolean b() {
        return ((Boolean) b.a()).booleanValue();
    }
}
