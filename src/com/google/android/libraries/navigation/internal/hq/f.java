package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.acd.sn;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.nk.w;
import com.google.android.libraries.navigation.internal.nk.x;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class f implements Function {
    public static final x a(sn snVar) {
        w wVar = (w) x.a.q();
        bq bqVar = snVar.b;
        if (!wVar.b.H()) {
            wVar.v();
        }
        x xVar = (x) wVar.b;
        bq bqVar2 = xVar.b;
        if (!bqVar2.c()) {
            xVar.b = bi.w(bqVar2);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(bqVar, xVar.b);
        return (x) wVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}
