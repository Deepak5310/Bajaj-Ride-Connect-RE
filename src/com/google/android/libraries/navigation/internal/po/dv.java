package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dv {
    final /* synthetic */ dy a;

    public dv(dy dyVar) {
        this.a = dyVar;
    }

    public final void a(com.google.android.libraries.navigation.internal.yz.ev evVar) {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        Object obj;
        synchronized (this.a) {
            if (this.a.A()) {
                this.a.f = true;
            }
        }
        com.google.android.libraries.navigation.internal.qu.cf cfVar = this.a.g;
        if (cfVar.k.isEmpty()) {
            int i = com.google.android.libraries.navigation.internal.yz.ev.d;
            evVarO = lv.a;
        } else {
            evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(cfVar.k);
        }
        Iterator<E> it2 = evVarO.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ael.ap apVarA = ((com.google.android.libraries.navigation.internal.oe.ar) it2.next()).a();
            com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
            int size = evVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.libraries.navigation.internal.qi.d dVar = (com.google.android.libraries.navigation.internal.qi.d) evVar.get(i2);
                if (dVar.B() && (obj = dVar.n().get(apVarA)) != null) {
                    eqVar.h(obj);
                }
            }
            if (!eqVar.g().isEmpty()) {
                throw null;
            }
        }
    }
}
