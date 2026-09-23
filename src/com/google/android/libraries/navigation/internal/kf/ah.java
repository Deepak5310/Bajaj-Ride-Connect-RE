package com.google.android.libraries.navigation.internal.kf;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends com.google.android.libraries.navigation.internal.ia.k {
    public ah(Class cls, af afVar, ap apVar) {
        super(cls, afVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        af afVar = (af) this.c;
        com.google.android.libraries.navigation.internal.jy.u uVar = (com.google.android.libraries.navigation.internal.jy.u) aVar;
        String str = uVar.a;
        if (aq.c(null)) {
            return;
        }
        com.google.android.libraries.navigation.internal.zt.d dVarA = com.google.android.libraries.navigation.internal.kb.a.a(null);
        if (dVarA != null) {
            int i = dVarA.b;
            if ((i & 2) != 0 && (i & 1) != 0) {
                return;
            }
        }
        v vVar = (v) afVar.a.a.a();
        String str2 = uVar.a;
        vVar.h = null;
    }
}
