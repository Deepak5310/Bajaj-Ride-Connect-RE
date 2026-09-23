package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.ap;
import com.google.android.libraries.navigation.internal.afx.aq;
import com.google.android.libraries.navigation.internal.afx.as;
import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.afx.az;
import com.google.android.libraries.navigation.internal.afx.r;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    public final Object a;
    public final az b;
    final /* synthetic */ f e;
    public ax d = new aq(as.a);
    public r c = r.CONNECTING;

    public d(f fVar, Object obj, ap apVar) {
        this.e = fVar;
        this.a = obj;
        this.b = apVar.a(a());
    }

    protected c a() {
        return new c(this);
    }

    protected final void b() {
        this.b.e();
        this.c = r.SHUTDOWN;
        f.f.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "shutdown", "Child balancer {0} deleted", this.a);
    }

    public final String toString() {
        return "Address = " + String.valueOf(this.a) + ", state = " + String.valueOf(this.c) + ", picker type: " + String.valueOf(this.d.getClass()) + ", lb: " + String.valueOf(this.b);
    }
}
