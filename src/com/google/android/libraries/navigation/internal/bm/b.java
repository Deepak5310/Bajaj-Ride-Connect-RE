package com.google.android.libraries.navigation.internal.bm;

import android.graphics.Rect;
import android.view.View;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private final com.google.android.libraries.navigation.internal.oa.k a;
    private final com.google.android.libraries.navigation.internal.s.b b;
    private final com.google.android.libraries.navigation.internal.oq.d c;
    private final com.google.android.libraries.navigation.internal.p.a d;
    private final com.google.android.libraries.navigation.internal.og.b e;

    public b(com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.s.b bVar, com.google.android.libraries.navigation.internal.oq.d dVar, com.google.android.libraries.navigation.internal.p.a aVar, com.google.android.libraries.navigation.internal.og.b bVar2) {
        this.a = kVar;
        this.b = bVar;
        this.c = dVar;
        this.d = aVar;
        this.e = bVar2;
    }

    protected void a(com.google.android.libraries.navigation.internal.pb.c cVar) {
        this.e.a(cVar);
    }

    final void b(com.google.android.libraries.navigation.internal.oe.al alVar, boolean z) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        com.google.android.libraries.navigation.internal.vu.r rVar = ((bp) this.d).d;
        if (rVar != null) {
            com.google.android.libraries.navigation.internal.oa.k kVar = rVar.d;
            if (kVar != null) {
                kVar.b();
            }
            View view = rVar.p;
            if (view != null && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0) {
                com.google.android.libraries.navigation.internal.s.b bVar = this.b;
                Rect rect = new Rect();
                bVar.f(null, rect);
                int iHeight = rect.height();
                Rect[] rectArr = {((bp) this.d).e()};
                com.google.android.libraries.navigation.internal.oe.x xVarZ = com.google.android.libraries.navigation.internal.oe.x.z(this.b.a());
                if (z && xVarZ != null) {
                    int i = 0;
                    while (i <= 0) {
                        Rect rect2 = rectArr[i];
                        double dWidth = rect2.width();
                        double dHeight = rect2.height();
                        int i2 = alVar.b;
                        int i3 = alVar.c;
                        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
                        alVar.d(xVar);
                        com.google.android.libraries.navigation.internal.oe.x xVarC = xVarZ.C(xVar);
                        int i4 = i;
                        xVarC.U(Math.toRadians(alVar.d));
                        double d = xVarC.b;
                        double d2 = iHeight;
                        double d3 = i3;
                        double d4 = d + (d3 / 2.0d);
                        int i5 = iHeight;
                        Rect[] rectArr2 = rectArr;
                        double dMax = Math.max(0.0d, (dHeight - d2) / d4);
                        if (d3 * dMax >= dHeight) {
                            dMax = dHeight / d3;
                        }
                        double d5 = i2;
                        double d6 = dWidth / d5;
                        double d7 = d4 - d3;
                        if (d5 * dMax > dWidth) {
                            dMax = d6;
                        }
                        rect2.top += (int) Math.round(Math.max(0.0d, (d7 * dMax) + d2));
                        i = i4 + 1;
                        iHeight = i5;
                        rectArr = rectArr2;
                    }
                }
                Rect rect3 = (Rect) new com.google.android.libraries.navigation.internal.yz.ba(new ba(((double) alVar.b) / ((double) alVar.c)), lg.a).d(hx.d(rectArr).iterator());
                com.google.android.libraries.navigation.internal.rf.g gVarC = this.c.c();
                if (c(new com.google.android.libraries.navigation.internal.bt.i(rect3.left, gVarC.d() - rect3.right, rect3.top, gVarC.c() - rect3.bottom), alVar)) {
                    return;
                }
                c(new com.google.android.libraries.navigation.internal.bt.i(0, 0, 0, 0), alVar);
            }
        }
    }

    final boolean c(com.google.android.libraries.navigation.internal.bt.i iVar, com.google.android.libraries.navigation.internal.oe.al alVar) {
        int i;
        int i2;
        View viewA = this.a.a();
        if (viewA.getWidth() <= iVar.a + iVar.b) {
            return false;
        }
        int height = viewA.getHeight();
        int i3 = iVar.c;
        int i4 = iVar.d;
        if (height <= i3 + i4 || (i = iVar.a) < 0 || (i2 = iVar.b) < 0 || i3 < 0 || i4 < 0) {
            return false;
        }
        a(new com.google.android.libraries.navigation.internal.pb.e(alVar, i, i2, i3, i4));
        return true;
    }
}
