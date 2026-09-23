package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements h {
    public static final az a;

    static {
        mb mbVar = mb.a;
        a = bh.d("ClientSignals__send_zwieback_cookie_in_client_log", false, "com.google.android.gms.maps", fy.q("MAPS_API", "GMM_REALTIME_COUNTERS"), true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.h
    public final boolean a() {
        return ((Boolean) a.a()).booleanValue();
    }
}
