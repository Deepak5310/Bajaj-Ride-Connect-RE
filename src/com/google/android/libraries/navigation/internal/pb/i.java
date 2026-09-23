package com.google.android.libraries.navigation.internal.pb;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.pc.b {
    private final m d;
    private final com.google.android.libraries.navigation.internal.pc.c[] a = new com.google.android.libraries.navigation.internal.pc.c[com.google.android.libraries.navigation.internal.pd.d.b];
    private final int[] b = new int[com.google.android.libraries.navigation.internal.pd.d.b];
    private final HashSet c = new HashSet();
    private final h e = new h();

    public i(m mVar) {
        ar.q(mVar);
        this.d = mVar;
    }

    public final synchronized int a(long j, com.google.android.libraries.navigation.internal.pd.a aVar) {
        int i;
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArrB[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            com.google.android.libraries.navigation.internal.pc.c cVar = this.a[i4];
            if (cVar == null) {
                this.b[i4] = 0;
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        this.b[i4] = cVar.a(j);
                        break;
                    }
                    if (this.a[i5] == cVar) {
                        int[] iArr = this.b;
                        iArr[i4] = iArr[i5];
                        break;
                    }
                    i5++;
                }
                aVar.c(i3, cVar.g(i3));
            }
        }
        this.d.e(aVar);
        h hVar = this.e;
        long j2 = hVar.c;
        long j3 = j - j2;
        if (j2 >= 0) {
            float f = j3;
            hVar.b.a(aVar);
            g gVar = hVar.b;
            g gVar2 = hVar.a;
            float f2 = gVar.a - gVar2.a;
            gVar.a = f2;
            float f3 = gVar.b - gVar2.b;
            gVar.b = f3;
            float fE = com.google.android.libraries.navigation.internal.nq.a.e(gVar.c - gVar2.c);
            float f4 = gVar.d - gVar2.d;
            float f5 = gVar.e - gVar2.e;
            float f6 = gVar.f - gVar2.f;
            float f7 = gVar.g - gVar2.g;
            float f8 = 1.0f / (f / 1000.0f);
            gVar.a = f2 * f8;
            gVar.b = f3 * f8;
            gVar.c = fE * f8;
            gVar.d = f4 * f8;
            gVar.e = f5 * f8;
            gVar.f = f6 * f8;
            gVar.g = f7 * f8;
        }
        hVar.c = j;
        hVar.a.a(aVar);
        int[] iArrB2 = com.google.android.libraries.navigation.internal.pd.b.b();
        i = 0;
        for (int i6 = 0; i6 < 5; i6++) {
            int i7 = iArrB2[i6];
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            }
            com.google.android.libraries.navigation.internal.pc.c cVar2 = this.a[i8];
            if (cVar2 != null && this.b[i8] == 0) {
                g(cVar2);
            }
            i |= this.b[i8];
        }
        return i;
    }

    public final synchronized int b(com.google.android.libraries.navigation.internal.pc.c cVar) {
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
                            this.c.add(cVar3);
                        }
                    }
                    this.a[i8] = cVar;
                }
            } else if (this.a[i8] == cVar) {
                i5 |= i9;
            }
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            g((com.google.android.libraries.navigation.internal.pc.c) it2.next());
        }
        this.c.clear();
        if (i5 != 0) {
            cVar.l(i5);
        }
        return i5;
    }

    public final synchronized long c() {
        long jMax;
        jMax = -1;
        for (int i = 0; i < com.google.android.libraries.navigation.internal.pd.d.b; i++) {
            com.google.android.libraries.navigation.internal.pc.c cVar = this.a[i];
            if (cVar != null) {
                jMax = Math.max(jMax, cVar.c());
            }
        }
        return jMax;
    }

    public final synchronized boolean d() {
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        for (int i = 0; i < 5; i++) {
            int i2 = iArrB[i];
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            if (this.a[i3] != null && this.b[i3] != 0) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean e() {
        for (int i = 0; i < com.google.android.libraries.navigation.internal.pd.d.b; i++) {
            com.google.android.libraries.navigation.internal.pc.c cVar = this.a[i];
            if (cVar != null && cVar.e()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean f(com.google.android.libraries.navigation.internal.pd.a aVar) {
        boolean z;
        Object objH;
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        z = false;
        for (int i = 0; i < 5; i++) {
            int i2 = iArrB[i];
            com.google.android.libraries.navigation.internal.pc.c[] cVarArr = this.a;
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            com.google.android.libraries.navigation.internal.pc.c cVar = cVarArr[i3];
            if (cVar != null && (objH = cVar.h(i2)) != null) {
                aVar.c(i2, objH);
                z = true;
            }
        }
        return z;
    }

    final synchronized void g(com.google.android.libraries.navigation.internal.pc.c cVar) {
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
