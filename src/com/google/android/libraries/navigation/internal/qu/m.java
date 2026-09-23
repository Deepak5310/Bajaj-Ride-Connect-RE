package com.google.android.libraries.navigation.internal.qu;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    private final ArrayList a = new ArrayList();

    public final void a() {
        ArrayList arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList(this.a.size());
            int i = 0;
            while (i < this.a.size()) {
                com.google.android.libraries.navigation.internal.qd.u uVar = (com.google.android.libraries.navigation.internal.qd.u) ((WeakReference) this.a.get(i)).get();
                if (uVar != null) {
                    arrayList.add(uVar);
                } else {
                    this.a.remove(i);
                    i--;
                }
                i++;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.qd.u) it2.next()).a();
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.qd.u uVar) {
        synchronized (this.a) {
            this.a.add(new WeakReference(uVar));
        }
    }
}
