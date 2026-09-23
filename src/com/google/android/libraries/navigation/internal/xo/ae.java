package com.google.android.libraries.navigation.internal.xo;

import android.util.Base64;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.di;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae extends ah {
    final /* synthetic */ com.google.android.libraries.navigation.internal.la.u a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(af afVar, String str, Object obj, com.google.android.libraries.navigation.internal.la.u uVar) {
        super(afVar, str, obj);
        this.a = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xo.ah
    public final Object a(Object obj) {
        try {
            byte[] bArrDecode = Base64.decode((String) obj, 3);
            com.google.android.libraries.navigation.internal.afk.q qVar = com.google.android.libraries.navigation.internal.afk.q.a;
            int length = bArrDecode.length;
            ar arVar = ar.a;
            di diVar = di.a;
            bi biVarV = bi.v(qVar, bArrDecode, 0, length, ar.a);
            bi.I(biVarV);
            return (com.google.android.libraries.navigation.internal.afk.q) biVarV;
        } catch (IOException | IllegalArgumentException unused) {
            return null;
        }
    }
}
