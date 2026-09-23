package com.google.android.libraries.navigation.internal.vu;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    private static final com.google.android.libraries.navigation.internal.zb.j k = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.vu.x");
    public bg b;
    public com.google.android.libraries.navigation.internal.si.d c;
    public be d;
    public final com.google.android.libraries.navigation.internal.rw.f e;
    public final com.google.android.libraries.navigation.internal.nt.m f;
    public final Executor g;
    public boolean j;
    private final com.google.android.libraries.navigation.internal.az.b l;
    public bh a = bh.b;
    public final com.google.android.libraries.navigation.internal.nt.t i = new u(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final br f644n = new v(this);
    private final boolean m = true;
    public final com.google.android.libraries.navigation.internal.rw.d h = new w(this);

    public x(com.google.android.libraries.navigation.internal.az.b bVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.nt.m mVar, Executor executor) {
        this.l = bVar;
        this.e = fVar;
        this.f = mVar;
        this.g = executor;
    }

    public final void a() {
        bg bgVar = this.b;
        if (bgVar == null || this.a.equals(bh.b)) {
            this.l.a();
            return;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("RouteRenderer.drawOrClearCurrentRoute");
        try {
            com.google.android.libraries.navigation.internal.bt.d dVarQ = com.google.android.libraries.navigation.internal.bt.h.Q();
            dVarQ.v(this.a);
            dVarQ.E(com.google.android.libraries.navigation.internal.bq.d.a);
            dVarQ.n(bgVar.C());
            dVarQ.l(new bv(bd.SHOW_ALL));
            dVarQ.m(this.f644n);
            if (this.m) {
                dVarQ.y(true);
                dVarQ.r(true);
            }
            com.google.android.libraries.navigation.internal.si.d dVar = this.c;
            if (dVar != null) {
                dVarQ.t(((com.google.android.libraries.navigation.internal.si.b) dVar).a ? com.google.android.libraries.navigation.internal.bt.e.NONE : com.google.android.libraries.navigation.internal.bt.e.FIRST_DESTINATION);
            }
            this.l.c(dVarQ.I());
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void b(be beVar) {
        if (this.d != beVar) {
            this.d = beVar;
            this.l.b(((v) this.f644n).a());
        }
    }
}
