package com.google.android.libraries.navigation.internal.og;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.pc.b {
    private final com.google.android.libraries.navigation.internal.pc.c[] a = new com.google.android.libraries.navigation.internal.pc.c[com.google.android.libraries.navigation.internal.pd.d.b];
    private final HashSet b = new HashSet();
    private final f c = new f();

    public final synchronized int a(com.google.android.libraries.navigation.internal.pc.c cVar) {
        ar.q(cVar);
        int iB = cVar.b();
        if (cVar.d()) {
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i = 0; i < 5; i++) {
                int i2 = iArrB[i];
                int i3 = i2 - 1;
                if (i2 == 0) {
                    throw null;
                }
                com.google.android.libraries.navigation.internal.pc.c cVar2 = this.a[i3];
                if (((1 << i3) & iB) != 0 && cVar2 != null && !cVar2.k(cVar)) {
                    int[] iArrB2 = com.google.android.libraries.navigation.internal.pd.b.b();
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (iArrB2[i4] == i2) {
                            return 0;
                        }
                    }
                }
            }
        }
        int[] iArrB3 = com.google.android.libraries.navigation.internal.pd.b.b();
        int i5 = 0;
        for (int i6 = 0; i6 < 5; i6++) {
            int i7 = iArrB3[i6];
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            }
            int i9 = 1 << i8;
            if ((iB & i9) != 0) {
                com.google.android.libraries.navigation.internal.pc.c cVar3 = this.a[i8];
                if (cVar3 == null || cVar.d() || cVar3.k(cVar)) {
                    i5 |= i9;
                    if (cVar3 != null) {
                        cVar3.i(cVar, i7);
                        if (cVar3.d() && cVar3 != cVar) {
                            this.b.add(cVar3);
                        }
                    }
                    this.a[i8] = cVar;
                }
            } else if (this.a[i8] == cVar) {
                i5 |= i9;
            }
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            b((com.google.android.libraries.navigation.internal.pc.c) it2.next());
        }
        this.b.clear();
        if (i5 != 0) {
            cVar.l(i5);
        }
        return i5;
    }

    final synchronized void b(com.google.android.libraries.navigation.internal.pc.c cVar) {
        if (cVar == null) {
            return;
        }
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        for (int i = 0; i < 5; i++) {
            int i2 = iArrB[i];
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            com.google.android.libraries.navigation.internal.pc.c cVar2 = this.a[i3];
            if (cVar2 == cVar) {
                if (cVar2.k(null)) {
                    this.a[i3].i(null, i2);
                    this.a[i3] = null;
                } else {
                    this.a[i3].j();
                }
            }
        }
    }
}
