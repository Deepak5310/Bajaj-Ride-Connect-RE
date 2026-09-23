package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends f {
    public final al e;
    private final ev f;
    private final ev g;

    /* JADX WARN: Multi-variable type inference failed */
    public h(g gVar) {
        super(gVar);
        this.e = gVar.e;
        ev evVar = gVar.f;
        this.f = evVar;
        this.g = gVar.g;
        if (evVar.isEmpty()) {
            bh bhVar = bh.b;
            return;
        }
        eq eqVar = new eq();
        if (((lv) evVar).c <= 0) {
            bh.h(0, eqVar.g());
        } else {
            throw null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tj.f
    public final String toString() {
        ak akVarA = a();
        akVarA.g("requestedTravelMode", this.e);
        return akVarA.c("numImplicitDestinations", ((lv) this.f).c).c("numOverviewImplicitDestinations", ((lv) this.g).c).toString();
    }
}
