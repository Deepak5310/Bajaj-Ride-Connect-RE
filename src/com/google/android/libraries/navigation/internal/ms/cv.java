package com.google.android.libraries.navigation.internal.ms;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cv {
    public final com.google.android.libraries.navigation.internal.my.l a = new com.google.android.libraries.navigation.internal.my.l();

    public cv() {
        Collections.newSetFromMap(new IdentityHashMap());
    }

    final List a(cs csVar, boolean z) {
        List arrayList = (List) this.a.a(csVar);
        if (arrayList == null && z) {
            arrayList = new ArrayList();
            com.google.android.libraries.navigation.internal.my.l lVar = this.a;
            synchronized (lVar.b) {
                Map map = lVar.b;
                map.put(new com.google.android.libraries.navigation.internal.my.k(csVar, map), arrayList);
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                if (((WeakReference) arrayList.get(size)).isEnqueued()) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }
}
