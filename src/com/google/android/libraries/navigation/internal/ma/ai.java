package com.google.android.libraries.navigation.internal.ma;

import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.le.ap;
import com.google.android.libraries.navigation.internal.xt.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai implements ap {
    final /* synthetic */ byte[] a;

    public ai(byte[] bArr) {
        this.a = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.le.ap
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        aq aqVar = (aq) obj;
        try {
            byte[] bArr = this.a;
            ar arVar = ar.a;
            di diVar = di.a;
            bi biVarV = bi.v(com.google.android.libraries.navigation.internal.xt.ag.a, bArr, 0, bArr.length, ar.a);
            bi.I(biVarV);
            aqVar.a((com.google.android.libraries.navigation.internal.xt.ag) biVarV);
        } catch (cc unused) {
        }
    }
}
