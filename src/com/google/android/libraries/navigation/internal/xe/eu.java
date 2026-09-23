package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.RoutingOptions;
import com.google.android.libraries.navigation.Waypoint;
import com.google.android.libraries.navigation.internal.afl.lo;
import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eu implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ Waypoint a;
    final /* synthetic */ RoutingOptions b;
    final /* synthetic */ m c;
    final /* synthetic */ fi d;

    public eu(fi fiVar, Waypoint waypoint, RoutingOptions routingOptions, m mVar) {
        this.a = waypoint;
        this.b = routingOptions;
        this.c = mVar;
        this.d = fiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.c.d(fy.a);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (!((com.google.android.libraries.navigation.internal.xh.b) obj).c()) {
            this.c.d(fy.a);
            return;
        }
        fi fiVar = this.d;
        Waypoint waypoint = this.a;
        RoutingOptions routingOptions = this.b;
        ev evVar = new ev(fiVar, this.c);
        lr lrVarB = gg.b(routingOptions, false, false, fiVar.c);
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) lrVarB.aH(5, null);
        bbVar.x(lrVarB);
        lo loVar = (lo) bbVar;
        int i = lq.b;
        if (!loVar.b.H()) {
            loVar.v();
        }
        lr lrVar = (lr) loVar.b;
        lr lrVar2 = lr.a;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        lrVar.m = i2;
        lrVar.b |= 2048;
        lr lrVar3 = (lr) loVar.t();
        com.google.android.libraries.navigation.internal.vp.g gVar = fiVar.d;
        com.google.android.libraries.navigation.internal.yz.ev evVarD = Waypoint.d(hx.d(waypoint));
        int i3 = com.google.android.libraries.navigation.internal.yz.ev.d;
        gVar.c(evVarD, lv.a, lrVar3, routingOptions.getLocationTimeoutMs(), evVar, null, null);
    }
}
