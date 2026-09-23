package com.google.android.libraries.navigation.internal.lp;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements m {
    @Override // com.google.android.libraries.navigation.internal.lp.m
    public final l a(Context context, k kVar) throws j {
        int iB;
        l lVar = new l();
        int iA = kVar.a(context);
        lVar.a = iA;
        int i = 0;
        if (iA != 0) {
            iB = kVar.b(context, false);
            lVar.b = iB;
        } else {
            iB = kVar.b(context, true);
            lVar.b = iB;
        }
        int i2 = lVar.a;
        if (i2 != 0 || iB != 0) {
            i = i2 >= iB ? -1 : 1;
        }
        lVar.c = i;
        return lVar;
    }
}
