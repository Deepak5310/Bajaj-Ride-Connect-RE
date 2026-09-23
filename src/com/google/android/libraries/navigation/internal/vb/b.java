package com.google.android.libraries.navigation.internal.vb;

import com.google.android.libraries.navigation.internal.nc.ae;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final ah[] a = new ah[16];
    public final int[] b = new int[16];

    public final void a(boolean z, boolean z2, boolean z3, int i) {
        int i2 = c.a;
        ae aeVar = new ae(i);
        ah[] ahVarArr = this.a;
        int iC = c.c(z, z2, true, z3);
        ahVarArr[iC] = aeVar;
        this.b[iC] = 0;
    }

    public final void b(boolean z, boolean z2, boolean z3, boolean z4, int i, int i2) {
        ah[] ahVarArr = this.a;
        int iC = c.c(z, z2, z3, z4);
        ahVarArr[iC] = com.google.android.libraries.navigation.internal.nc.j.g(i);
        this.b[iC] = i2;
    }

    public final void c() {
        b(true, false, true, false, c.a, 0);
        b(true, true, true, false, c.a, 0);
        b(true, false, true, true, c.b, 0);
        b(true, true, true, true, c.b, 0);
        b(true, false, false, false, c.g, 0);
        b(true, true, false, false, c.g, 0);
        b(true, false, false, true, c.h, 0);
        b(true, true, false, true, c.h, 0);
        b(false, true, true, false, c.c, 3);
        b(false, false, true, false, c.d, 0);
        b(false, true, true, true, c.e, 3);
        b(false, false, true, true, c.f, 0);
        b(false, true, false, false, c.i, 3);
        b(false, true, false, true, c.i, 3);
        b(false, false, false, false, c.j, 0);
        b(false, false, false, true, c.j, 0);
    }
}
