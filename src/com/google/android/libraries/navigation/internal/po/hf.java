package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hf implements com.google.android.libraries.navigation.internal.ol.aw {
    private boolean a = false;
    private List b = new ArrayList();

    @Override // com.google.android.libraries.navigation.internal.ol.aw
    public final void a(com.google.android.libraries.navigation.internal.adi.bo boVar) {
        List list;
        synchronized (this) {
            list = null;
            if (!this.a) {
                List list2 = this.b;
                this.b = null;
                list = list2;
            }
            this.a = true;
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
        }
    }

    final void b(Runnable runnable) {
        boolean z;
        synchronized (this) {
            z = this.a;
            if (!z) {
                List list = this.b;
                com.google.android.libraries.navigation.internal.yx.ar.q(list);
                list.add(runnable);
            }
        }
        if (z) {
            runnable.run();
        }
    }
}
