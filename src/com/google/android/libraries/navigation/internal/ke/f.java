package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends g {
    private final int a;

    public f(int i, com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar.a());
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        int i = this.a;
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        biVar.b |= 524288;
        biVar.q = i;
    }
}
