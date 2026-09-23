package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lq extends lo implements Serializable {
    static final lo a = new lq();
    private static final long serialVersionUID = 0;

    private lq() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        lr lrVar = (lr) obj;
        lr lrVar2 = (lr) obj2;
        return ck.b.e(lrVar.b, lrVar2.b).e(lrVar.c, lrVar2.c).a();
    }
}
