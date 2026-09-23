package com.google.android.libraries.navigation.internal.afu;

import com.google.android.libraries.navigation.internal.xt.az;
import com.google.android.libraries.navigation.internal.xt.bh;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements ac {
    public static final az a;

    static {
        mb mbVar = mb.a;
        a = bh.c("NetworkSettings__gmm_server_address", "https://clients4.google.com/glm/mmap", "com.google.android.gms.maps", fy.q("MAPS_API", "GMM_REALTIME_COUNTERS"), true);
    }

    @Override // com.google.android.libraries.navigation.internal.afu.ac
    public final String a() {
        return (String) a.a();
    }
}
