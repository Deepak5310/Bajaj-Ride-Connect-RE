package com.google.android.libraries.navigation.internal.aga;

import io.grpc.internal.GrpcUtil;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dv extends com.google.android.libraries.navigation.internal.afx.ba {
    static final boolean a = az.b("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST");
    public static final /* synthetic */ int b = 0;

    @Override // com.google.android.libraries.navigation.internal.afx.ap
    public final com.google.android.libraries.navigation.internal.afx.az a(com.google.android.libraries.navigation.internal.afx.ar arVar) {
        return a ? new dp(arVar) : new du(arVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ba
    public final com.google.android.libraries.navigation.internal.afx.bs b(Map map) {
        try {
            Boolean boolA = bw.a(map, "shuffleAddressList");
            return new com.google.android.libraries.navigation.internal.afx.bs(a ? new dl(boolA) : new dr(boolA));
        } catch (RuntimeException e) {
            return new com.google.android.libraries.navigation.internal.afx.bs(com.google.android.libraries.navigation.internal.afx.cl.f.a(e).b("Failed parsing configuration for ".concat(GrpcUtil.DEFAULT_LB_POLICY)));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ba
    public final String c() {
        return GrpcUtil.DEFAULT_LB_POLICY;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ba
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ba
    public final void e() {
    }
}
