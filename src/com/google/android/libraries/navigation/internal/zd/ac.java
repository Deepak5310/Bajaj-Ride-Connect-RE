package com.google.android.libraries.navigation.internal.zd;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac extends ae {
    public final int[] a;
    public final int b;
    private final n c;
    private final n d;

    public ac(n nVar, n nVar2) {
        int iH;
        this.c = nVar;
        com.google.android.libraries.navigation.internal.zj.b.d(nVar2, "logged metadata");
        this.d = nVar2;
        int iB = nVar2.b();
        int i = 0;
        com.google.android.libraries.navigation.internal.zj.b.a(iB <= 28, "metadata size too large");
        int[] iArr = new int[iB];
        this.a = iArr;
        long j = 0;
        int i2 = 0;
        while (i < iArr.length) {
            com.google.android.libraries.navigation.internal.zb.ac acVarE = e(i);
            long j2 = acVarE.d | j;
            if (j2 != j || (iH = h(acVarE, iArr, i2)) == -1) {
                iArr[i2] = i;
                i2++;
            } else {
                iArr[iH] = acVarE.b ? iArr[iH] | (1 << (i + 4)) : i;
            }
            i++;
            j = j2;
        }
        this.b = i2;
    }

    private final int h(com.google.android.libraries.navigation.internal.zb.ac acVar, int[] iArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (acVar.equals(e(iArr[i2] & 31))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final Object b(com.google.android.libraries.navigation.internal.zb.ac acVar) {
        com.google.android.libraries.navigation.internal.zj.b.a(!acVar.b, "key must be single valued");
        int iH = h(acVar, this.a, this.b);
        if (iH >= 0) {
            return acVar.c(f(this.a[iH]));
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final Set c() {
        return new aa(this);
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final void d(u uVar, Object obj) {
        for (int i = 0; i < this.b; i++) {
            int i2 = this.a[i];
            com.google.android.libraries.navigation.internal.zb.ac acVarE = e(i2 & 31);
            if (acVarE.b) {
                uVar.b(acVarE, new ab(this, acVarE, i2), obj);
            } else {
                uVar.a(acVarE, acVarE.c(f(i2)), obj);
            }
        }
    }

    public final com.google.android.libraries.navigation.internal.zb.ac e(int i) {
        int iB = this.c.b();
        return i >= iB ? this.d.c(i - iB) : this.c.c(i);
    }

    public final Object f(int i) {
        int iB = this.c.b();
        return i >= iB ? this.d.e(i - iB) : this.c.e(i);
    }
}
