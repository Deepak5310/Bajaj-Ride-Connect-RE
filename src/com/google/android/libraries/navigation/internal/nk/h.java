package com.google.android.libraries.navigation.internal.nk;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import io.grpc.internal.PickFirstLeafLoadBalancer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public final br a = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.nk.g
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            System.setProperty(PickFirstLeafLoadBalancer.GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS, "false");
            return null;
        }
    });
}
