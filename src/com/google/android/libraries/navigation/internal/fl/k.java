package com.google.android.libraries.navigation.internal.fl;

import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.bl;
import com.google.android.libraries.navigation.internal.hx.ap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.ia.k {
    public k(Class cls, i iVar, ap apVar) {
        super(cls, iVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        List listG;
        i iVar = (i) this.c;
        bl blVar = ((af) ((com.google.android.libraries.navigation.internal.hm.o) aVar).c().a()).f;
        if (blVar == null) {
            blVar = bl.a;
        }
        int i = blVar.b;
        synchronized (iVar) {
            iVar.a = i;
            listG = iVar.g();
        }
        Iterator it2 = listG.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
    }
}
