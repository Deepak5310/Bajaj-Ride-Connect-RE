package com.google.android.libraries.navigation.internal.mv;

import com.google.android.libraries.navigation.internal.ms.bw;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    public b(String str, Throwable th) {
        super(str, th);
    }

    public static b a(Exception exc, bw bwVar, cs csVar) {
        ak akVarB = al.b(bwVar);
        akVarB.g("property", bwVar);
        akVarB.g("viewModel", csVar);
        return new b(akVarB.toString(), exc);
    }
}
