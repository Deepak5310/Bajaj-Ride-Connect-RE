package com.google.android.libraries.navigation.internal.sn;

import android.app.Application;
import com.drew.metadata.iptc.IptcDirectory;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.sn.e");
    public final Application b;
    public final com.google.android.libraries.navigation.internal.hf.c c;
    public final c d = new c();
    private final c g = new c();
    private final c h = new c();
    private final c i = new c();
    public final c e = new c();
    private final c j = new c();
    private final c k = new c();
    private final c l = new c();
    public final c f = new c();
    private final c m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c f578n = new c();
    private final c o = new c();

    public e(Application application, com.google.android.libraries.navigation.internal.hf.c cVar) {
        this.b = application;
        this.c = cVar;
    }

    public final void a() {
        int i = 4;
        c[] cVarArr = {this.d, this.g, this.h, this.i};
        int[] iArr = {com.google.android.libraries.navigation.internal.dw.f.m, com.google.android.libraries.navigation.internal.dw.f.c, com.google.android.libraries.navigation.internal.dw.f.h, com.google.android.libraries.navigation.internal.dw.f.r};
        int[] iArr2 = {com.google.android.libraries.navigation.internal.dw.f.l, com.google.android.libraries.navigation.internal.dw.f.b, com.google.android.libraries.navigation.internal.dw.f.g, com.google.android.libraries.navigation.internal.dw.f.q};
        int[] iArr3 = {com.google.android.libraries.navigation.internal.dw.h.A, com.google.android.libraries.navigation.internal.dw.h.q, com.google.android.libraries.navigation.internal.dw.h.v, com.google.android.libraries.navigation.internal.dw.h.M};
        int i2 = 0;
        while (i2 < i) {
            cVarArr[i2].add(new a(this, 95, iArr[i2], (Integer) 50));
            cVarArr[i2].add(new a(this, 145, iArr[i2], (Integer) 100));
            cVarArr[i2].add(new a(this, 190, iArr[i2], (Integer) 150));
            cVarArr[i2].add(new a(this, 280, iArr[i2], (Integer) 200));
            cVarArr[i2].add(new a(this, 370, iArr[i2], (Integer) 300));
            cVarArr[i2].add(new a(this, 460, iArr[i2], (Integer) 400));
            cVarArr[i2].add(new a(this, IptcDirectory.TAG_EXPIRATION_TIME, iArr[i2], (Integer) 500));
            cVarArr[i2].add(new a(this, 750, iArr[i2], (Integer) 600));
            cVarArr[i2].add(new a(this, 950, iArr[i2], (Integer) 800));
            cVarArr[i2].add(new d(this, 1300, iArr2[i2], 1000.0f));
            cVarArr[i2].add(new a(this, 1850, iArr3[i2], (Integer) null));
            cVarArr[i2].add(new d(this, Integer.MAX_VALUE, iArr2[i2], 1000.0f));
            i2++;
            i = 4;
        }
        c[] cVarArr2 = new c[i];
        cVarArr2[0] = this.e;
        cVarArr2[1] = this.j;
        cVarArr2[2] = this.k;
        cVarArr2[3] = this.l;
        int[] iArr4 = {com.google.android.libraries.navigation.internal.dw.f.k, com.google.android.libraries.navigation.internal.dw.f.a, com.google.android.libraries.navigation.internal.dw.f.f, com.google.android.libraries.navigation.internal.dw.f.p};
        int[] iArr5 = {com.google.android.libraries.navigation.internal.dw.f.f417n, com.google.android.libraries.navigation.internal.dw.f.d, com.google.android.libraries.navigation.internal.dw.f.i, com.google.android.libraries.navigation.internal.dw.f.s};
        int[] iArr6 = {com.google.android.libraries.navigation.internal.dw.h.z, com.google.android.libraries.navigation.internal.dw.h.p, com.google.android.libraries.navigation.internal.dw.h.u, com.google.android.libraries.navigation.internal.dw.h.L};
        int[] iArr7 = {com.google.android.libraries.navigation.internal.dw.h.y, com.google.android.libraries.navigation.internal.dw.h.o, com.google.android.libraries.navigation.internal.dw.h.t, com.google.android.libraries.navigation.internal.dw.h.K};
        int[] iArr8 = {com.google.android.libraries.navigation.internal.dw.h.C, com.google.android.libraries.navigation.internal.dw.h.s, com.google.android.libraries.navigation.internal.dw.h.x, com.google.android.libraries.navigation.internal.dw.h.O};
        int[] iArr9 = {com.google.android.libraries.navigation.internal.dw.h.B, com.google.android.libraries.navigation.internal.dw.h.r, com.google.android.libraries.navigation.internal.dw.h.w, com.google.android.libraries.navigation.internal.dw.h.N};
        for (int i3 = 0; i3 < 4; i3++) {
            cVarArr2[i3].add(new a(this, 28.956001f, iArr4[i3], (Integer) 50));
            cVarArr2[i3].add(new a(this, 44.196f, iArr4[i3], (Integer) 100));
            cVarArr2[i3].add(new a(this, 57.912003f, iArr4[i3], (Integer) 150));
            cVarArr2[i3].add(new a(this, 85.344f, iArr4[i3], (Integer) 200));
            cVarArr2[i3].add(new a(this, 112.776f, iArr4[i3], (Integer) 300));
            cVarArr2[i3].add(new a(this, 140.20801f, iArr4[i3], (Integer) 400));
            cVarArr2[i3].add(new a(this, 167.64f, iArr4[i3], (Integer) 500));
            cVarArr2[i3].add(new a(this, 225.552f, iArr4[i3], (Integer) 600));
            cVarArr2[i3].add(new a(this, 289.56f, iArr4[i3], (Integer) 800));
            cVarArr2[i3].add(new a(this, 396.24f, iArr4[i3], (Integer) 1000));
            cVarArr2[i3].add(new a(this, 724.2048f, iArr6[i3], (Integer) null));
            cVarArr2[i3].add(new a(this, 1126.5408f, iArr7[i3], (Integer) null));
            cVarArr2[i3].add(new a(this, 1528.8768f, iArr8[i3], (Integer) null));
            cVarArr2[i3].add(new d(this, iArr5[i3]));
            cVarArr2[i3].add(new a(this, 2896.819f, iArr9[i3], (Integer) null));
            cVarArr2[i3].add(new d(this, Integer.MAX_VALUE, iArr5[i3], 1609.344f));
        }
        c[] cVarArr3 = {this.f, this.m, this.f578n, this.o};
        int[] iArr10 = {com.google.android.libraries.navigation.internal.dw.f.o, com.google.android.libraries.navigation.internal.dw.f.e, com.google.android.libraries.navigation.internal.dw.f.j, com.google.android.libraries.navigation.internal.dw.f.t};
        for (int i4 = 0; i4 < 4; i4++) {
            cVarArr3[i4].add(new a(this, 86.868004f, iArr10[i4], (Integer) 50));
            cVarArr3[i4].add(new a(this, 132.58801f, iArr10[i4], (Integer) 100));
            cVarArr3[i4].add(new a(this, 173.73601f, iArr10[i4], (Integer) 150));
            cVarArr3[i4].add(new a(this, 256.032f, iArr10[i4], (Integer) 200));
            cVarArr3[i4].add(new a(this, 338.328f, iArr10[i4], (Integer) 300));
            cVarArr3[i4].add(new a(this, 724.2048f, iArr6[i4], (Integer) null));
            cVarArr3[i4].add(new a(this, 1126.5408f, iArr7[i4], (Integer) null));
            cVarArr3[i4].add(new a(this, 1528.8768f, iArr8[i4], (Integer) null));
            cVarArr3[i4].add(new d(this, iArr5[i4]));
            cVarArr3[i4].add(new a(this, 2896.819f, iArr9[i4], (Integer) null));
            cVarArr3[i4].add(new d(this, Integer.MAX_VALUE, iArr5[i4], 1609.344f));
        }
    }
}
