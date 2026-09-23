package com.google.android.libraries.navigation.internal.aga;

import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dj implements com.google.android.libraries.navigation.internal.afx.ay {
    public Cdo a;
    final /* synthetic */ dp b;

    public dj(dp dpVar) {
        this.b = dpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ay
    public final void a(com.google.android.libraries.navigation.internal.afx.s sVar) {
        if (this.b.k) {
            dp.f.logp(Level.WARNING, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Ignoring health status {0} for subchannel {1} as this is not under a petiole policy", new Object[]{sVar, this.a.a});
            return;
        }
        dp.f.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer$HealthListener", "onSubchannelState", "Received health status {0} for subchannel {1}", new Object[]{sVar, this.a.a});
        this.a.d = sVar;
        if (this.b.i.f()) {
            Cdo cdo = this.a;
            dp dpVar = this.b;
            if (cdo == dpVar.h.get(dpVar.i.b())) {
                this.b.g(this.a);
            }
        }
    }
}
