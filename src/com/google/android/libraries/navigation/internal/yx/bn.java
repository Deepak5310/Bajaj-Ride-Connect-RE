package com.google.android.libraries.navigation.internal.yx;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn {
    final Set a = new HashSet();

    final bo a() {
        return new bo(this.a);
    }

    final void b(int i) {
        this.a.add(Integer.valueOf(i));
    }

    final void c(int i, int i2) {
        while (i <= i2) {
            this.a.add(Integer.valueOf(i));
            i++;
        }
    }

    final void d(bo boVar) {
        for (Integer num : boVar.b) {
            num.intValue();
            this.a.add(num);
        }
    }
}
