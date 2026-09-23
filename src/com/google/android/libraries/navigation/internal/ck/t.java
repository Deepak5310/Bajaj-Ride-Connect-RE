package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.yz.gi;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements ck {
    private final gi a;
    private final com.google.android.libraries.navigation.internal.oe.r b;
    private final com.google.android.libraries.navigation.internal.ot.q c;

    public t(gi zoomToIcon, com.google.android.libraries.navigation.internal.oe.r latlng, com.google.android.libraries.navigation.internal.ot.h labelManager) {
        Intrinsics.checkNotNullParameter(zoomToIcon, "zoomToIcon");
        Intrinsics.checkNotNullParameter(latlng, "latlng");
        Intrinsics.checkNotNullParameter(labelManager, "labelManager");
        this.a = zoomToIcon;
        this.b = latlng;
        com.google.android.libraries.navigation.internal.rj.b bVarB = labelManager.b(com.google.android.libraries.navigation.internal.ot.g.b);
        Intrinsics.checkNotNullExpressionValue(bVarB, "newPointLabelBuilder(...)");
        dy dyVar = bVarB.a;
        dq dqVar = (dq) dt.a.q();
        dqVar.d(bVarB.b(new com.google.android.libraries.navigation.internal.rd.a(zoomToIcon)));
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar = (ef) dyVar.b;
        dt dtVar = (dt) dqVar.t();
        ef efVar2 = ef.a;
        dtVar.getClass();
        efVar.c = dtVar;
        efVar.b |= 1;
        com.google.android.libraries.navigation.internal.adg.c cVar = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.h hVarA = com.google.android.libraries.navigation.internal.on.k.a(com.google.android.libraries.navigation.internal.oe.x.z(latlng));
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar.b;
        hVarA.getClass();
        dVar.c = hVarA;
        dVar.b |= 1;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar3 = (ef) dyVar.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar.t();
        dVar2.getClass();
        efVar3.e = dVar2;
        efVar3.b |= 8;
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        ef efVar4 = (ef) dyVar.b;
        efVar4.b |= 64;
        efVar4.h = 1;
        this.c = (com.google.android.libraries.navigation.internal.ot.q) bVarB.c();
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    @Deprecated(message = "Scaling measles is deprecated. See go/measles-as-labels for more info.")
    public final float a() {
        return 1.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void b() {
        this.c.c();
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void c() {
        this.c.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    @Deprecated(message = "Rotating measles is deprecated. See go/measles-as-labels for more info.")
    public final void d(float f) {
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    @Deprecated(message = "Scaling measles is deprecated. See go/measles-as-labels for more info.")
    public final void e(float f) {
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ck
    public final void f() {
        this.c.d();
    }
}
