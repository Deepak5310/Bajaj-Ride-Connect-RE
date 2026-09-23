package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.ady.ad;
import com.google.android.libraries.navigation.internal.zr.af;
import com.google.android.libraries.navigation.internal.zr.ag;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends g {
    private final int a;
    private final int d;
    private final ad e;

    public e(com.google.android.libraries.navigation.internal.mj.a aVar, int i, int i2, ad adVar) {
        super(aVar.a());
        this.a = i;
        this.d = i2;
        this.e = adVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        af afVar = (af) ag.a.q();
        if (!afVar.b.H()) {
            afVar.v();
        }
        int i = this.a;
        ag agVar = (ag) afVar.b;
        agVar.b |= 2;
        agVar.c = i;
        int i2 = this.d;
        if (!afVar.b.H()) {
            afVar.v();
        }
        ag agVar2 = (ag) afVar.b;
        agVar2.b |= 4;
        agVar2.d = i2;
        ad adVar = this.e;
        if (!afVar.b.H()) {
            afVar.v();
        }
        ag agVar3 = (ag) afVar.b;
        agVar3.e = adVar.e;
        agVar3.b |= 8;
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        ag agVar4 = (ag) afVar.t();
        bi biVar2 = bi.a;
        agVar4.getClass();
        biVar.m = agVar4;
        biVar.b |= 16384;
    }
}
