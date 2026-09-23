package com.google.android.libraries.navigation.internal.ma;

import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.le.bk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah extends com.google.android.libraries.navigation.internal.mb.c {
    final /* synthetic */ com.google.android.libraries.navigation.internal.me.aa a;

    public ah(com.google.android.libraries.navigation.internal.me.aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mb.d
    public final void b(com.google.android.libraries.navigation.internal.ld.ab abVar, byte[] bArr) {
        if (!abVar.b()) {
            bk.b(abVar, null, this.a);
            return;
        }
        try {
            bi biVarV = bi.v(com.google.android.libraries.navigation.internal.xs.t.a, bArr, 0, bArr.length, ar.b());
            bi.I(biVarV);
            bk.b(abVar, (com.google.android.libraries.navigation.internal.xs.t) biVarV, this.a);
        } catch (cc e) {
            this.a.a(e);
        }
    }
}
