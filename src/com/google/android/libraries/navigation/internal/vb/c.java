package com.google.android.libraries.navigation.internal.vb;

import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a {
    public static final int a = com.google.android.libraries.navigation.internal.v.a.f;
    public static final int b = com.google.android.libraries.navigation.internal.v.a.g;
    public static final int c = com.google.android.libraries.navigation.internal.dw.c.p;
    public static final int d = com.google.android.libraries.navigation.internal.v.a.g;
    public static final int e = com.google.android.libraries.navigation.internal.dw.c.q;
    public static final int f = com.google.android.libraries.navigation.internal.v.a.h;
    public static final int g = com.google.android.libraries.navigation.internal.f.b.p;
    public static final int h = com.google.android.libraries.navigation.internal.f.b.q;
    public static final int i = com.google.android.libraries.navigation.internal.dw.c.r;
    public static final int j = com.google.android.libraries.navigation.internal.f.b.C;
    private final ah[] k = new ah[16];
    private final int[] l = new int[16];

    public c(b bVar) {
        for (int i2 = 0; i2 < 16; i2++) {
            ah[] ahVarArr = this.k;
            ah ahVar = bVar.a[i2];
            ar.q(ahVar);
            ahVarArr[i2] = ahVar;
            this.l[i2] = bVar.b[i2];
        }
    }

    public static int c(boolean z, boolean z2, boolean z3, boolean z4) {
        return (true != z ? 0 : 8) + (true != z2 ? 0 : 4) + (true == z3 ? 2 : 0) + (z4 ? 1 : 0);
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a
    public final ah a(boolean z, boolean z2, boolean z3, boolean z4) {
        return this.k[c(z, z2, z3, z4)];
    }

    @Override // com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a
    public final int b(boolean z, boolean z2, boolean z3) {
        return this.l[c(false, z, z2, z3)];
    }
}
