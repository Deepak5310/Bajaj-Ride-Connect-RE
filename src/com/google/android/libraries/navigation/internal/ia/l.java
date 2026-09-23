package com.google.android.libraries.navigation.internal.ia;

import com.google.android.libraries.navigation.internal.yz.gc;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    private final Map a = new HashMap();
    private final i b;

    public l(i iVar) {
        this.b = iVar;
    }

    public final synchronized void a(gc gcVar) {
        nn nnVarListIterator = gcVar.e().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            com.google.android.libraries.navigation.internal.ic.a aVar = (com.google.android.libraries.navigation.internal.ic.a) this.a.get(entry.getKey());
            if (aVar != null) {
                this.b.g(aVar, (k) entry.getValue());
            }
        }
    }

    public final synchronized void b(com.google.android.libraries.navigation.internal.ic.a aVar, Set set) {
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            this.a.put((Class) it2.next(), aVar);
        }
    }
}
