package com.google.android.libraries.navigation.internal.ms;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba {
    final List a = new ArrayList();
    final SimpleArrayMap b = new SimpleArrayMap();
    final List c = new ArrayList();
    int d;
    int e;

    final void a() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.mx.w wVar = (com.google.android.libraries.navigation.internal.mx.w) this.a.get(i);
            cw cwVarA = wVar == null ? null : wVar.a();
            if ((cwVarA instanceof e) && ((e) cwVarA).b()) {
                this.c.add(wVar);
            }
        }
    }

    final void b() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d = 0;
        this.e = 0;
    }

    final boolean c(cw cwVar) {
        Integer num = (Integer) this.b.remove(cwVar);
        if (num == null) {
            return false;
        }
        com.google.android.libraries.navigation.internal.mx.w wVar = (com.google.android.libraries.navigation.internal.mx.w) this.a.get(num.intValue());
        if (wVar == null) {
            throw new IllegalStateException("Index exists with null property.");
        }
        if (wVar.c()) {
            this.d--;
        } else {
            this.e--;
        }
        this.a.set(num.intValue(), null);
        return true;
    }
}
