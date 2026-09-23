package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cf implements cm {
    private final cg a;
    private final com.google.android.libraries.navigation.internal.on.h b;

    public cf(cg cgVar, com.google.android.libraries.navigation.internal.on.h hVar) {
        this.a = cgVar;
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final void e(com.google.android.libraries.navigation.internal.ol.ax axVar) {
        ci ciVar = (ci) this.a;
        axVar.j(ciVar.a);
        axVar.j(ciVar.b);
        axVar.j(ciVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cm
    public final List f(be beVar, boolean z, int i) {
        com.google.android.libraries.navigation.internal.ol.aq aqVar;
        if (z) {
            aqVar = beVar.f ? ((ci) this.a).a : ((ci) this.a).b;
        } else {
            aqVar = ((ci) this.a).c;
        }
        return hx.d(this.b.h(beVar.m, aqVar, ff.a, ff.a, cz.a));
    }
}
