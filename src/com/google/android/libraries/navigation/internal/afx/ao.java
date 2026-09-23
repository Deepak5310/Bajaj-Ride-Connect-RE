package com.google.android.libraries.navigation.internal.afx;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao {
    public final List a;
    public final c b;
    public final Object[][] c;

    public ao(List list, c cVar, Object[][] objArr) {
        com.google.android.libraries.navigation.internal.yx.ar.r(list, "addresses are not set");
        this.a = list;
        com.google.android.libraries.navigation.internal.yx.ar.r(cVar, "attrs");
        this.b = cVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(objArr, "customOptions");
        this.c = objArr;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("addrs", this.a);
        akVarB.g("attrs", this.b);
        akVarB.g("customOptions", Arrays.deepToString(this.c));
        return akVarB.toString();
    }
}
