package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;
import com.google.android.libraries.navigation.internal.zr.dx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p extends g {
    public p(com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar.a());
    }

    protected abstract dx a();

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        dx dxVarA = a();
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        biVar.r = dxVarA;
        biVar.b |= 2097152;
    }
}
