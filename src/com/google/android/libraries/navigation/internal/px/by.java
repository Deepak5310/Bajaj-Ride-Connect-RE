package com.google.android.libraries.navigation.internal.px;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class by {
    private final List a = new ArrayList(200);
    private final List b = new ArrayList(4);

    final void a(dq dqVar, List list, List list2) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ek ekVar = (ek) list.get(i2);
            if (ekVar.v().isEmpty()) {
                list2.add(ekVar);
            } else {
                this.a.add(ekVar);
            }
        }
        Collections.sort(this.a, new Comparator() { // from class: com.google.android.libraries.navigation.internal.px.bx
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((ek) obj).v().compareTo(((ek) obj2).v());
            }
        });
        while (i < this.a.size()) {
            String strV = ((ek) this.a.get(i)).v();
            int i3 = i + 1;
            while (i3 < this.a.size() && strV.equals(((ek) this.a.get(i3)).v())) {
                i3++;
            }
            this.b.clear();
            while (i < i3) {
                this.b.add((ek) this.a.get(i));
                i++;
            }
            dq.a(this.b, list2);
            i = i3;
        }
        this.a.clear();
    }
}
