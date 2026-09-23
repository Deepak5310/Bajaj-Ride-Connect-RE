package com.google.android.libraries.navigation.internal.wt;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bm;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private int d = Integer.MAX_VALUE;
    private int e = Integer.MAX_VALUE;
    public h a = h.LIFO;
    public bj b = az.h(true);
    public bm c = null;

    public final m a() {
        int i = this.d;
        int i2 = this.e;
        h hVar = this.a;
        bm bmVar = this.c;
        ar.q(bmVar);
        final m mVar = new m(i, i2, hVar, bmVar, this.b);
        mVar.b.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.wt.e
            @Override // java.lang.Runnable
            public final void run() {
                mVar.d();
            }
        }, mVar.a);
        return mVar;
    }

    public final void b(int i) {
        ar.a(this.e > 0);
        this.d = i;
    }

    public final void c() {
        ar.a(true);
        this.e = 25;
    }
}
