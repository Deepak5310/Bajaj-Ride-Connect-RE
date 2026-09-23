package com.google.android.libraries.navigation.internal.qx;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements com.google.android.libraries.navigation.internal.qz.g {
    public final com.google.android.libraries.navigation.internal.qz.k[] a;
    private final Bitmap[] b;
    private final com.google.android.libraries.navigation.internal.qz.k c;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final int e;
    private final boolean f;
    private final g g;

    public n(com.google.android.libraries.navigation.internal.qz.k kVar, int i, int i2, com.google.android.libraries.navigation.internal.mj.a aVar, boolean z, g gVar) {
        this.c = kVar;
        this.d = aVar;
        this.e = i;
        this.b = new Bitmap[i2];
        this.a = new com.google.android.libraries.navigation.internal.qz.k[i2];
        this.f = z;
        this.g = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final synchronized void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        if (this.c.a() == 0) {
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                com.google.android.libraries.navigation.internal.qz.k[] kVarArr = this.a;
                if (i2 >= kVarArr.length) {
                    break;
                }
                if (am.a(kVarArr[i2], kVar)) {
                    this.b[i2] = kVar.c();
                    i = i2;
                }
                if (this.b[i2] != null) {
                    i3++;
                }
                i2++;
            }
            if (this.b[i] == null) {
                this.c.o(2);
                this.c.n(this.d.f().toEpochMilli());
                this.c.j(false);
                this.c.i();
            }
            if (i3 == this.e) {
                Rect rect = this.f ? new Rect() : null;
                g gVar = this.g;
                Bitmap[] bitmapArr = this.b;
                com.google.android.libraries.navigation.internal.qy.f fVar = (com.google.android.libraries.navigation.internal.qy.f) gVar.a.k.a();
                bj bjVar = com.google.android.libraries.navigation.internal.qy.g.i;
                Bitmap bitmapA = fVar.a(new com.google.android.libraries.navigation.internal.qy.a(gVar.b, aq.b(gVar.c), gVar.d, gVar.e, gVar.f, true, 0, 0), bitmapArr, rect);
                if (bitmapA != null) {
                    this.c.l(bitmapA);
                    this.c.o(3);
                    if (rect != null) {
                        this.c.k(rect);
                    }
                } else {
                    this.c.o(2);
                }
                this.c.n(this.d.f().toEpochMilli());
                this.c.j(false);
                this.c.i();
            }
        }
    }
}
