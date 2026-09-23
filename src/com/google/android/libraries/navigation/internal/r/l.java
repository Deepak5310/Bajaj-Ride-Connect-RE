package com.google.android.libraries.navigation.internal.r;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import com.google.android.libraries.navigation.internal.ob.r;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.on.q;
import com.google.android.libraries.navigation.internal.vu.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l {
    final /* synthetic */ m a;
    private final SparseArray b = new SparseArray();

    public l(m mVar) {
        this.a = mVar;
    }

    public final com.google.android.libraries.navigation.internal.ol.g a(r rVar, com.google.android.libraries.navigation.internal.on.l lVar) {
        if (lVar == null) {
            return null;
        }
        com.google.android.libraries.navigation.internal.ol.j jVarB = ((com.google.android.libraries.navigation.internal.vu.c) this.a.i).a.b(rVar.i().a, rVar.i().b, 100, 2.0f, false, ((com.google.android.libraries.navigation.internal.on.m) lVar).a, true, 1);
        com.google.android.libraries.navigation.internal.ol.i iVarC = jVarB.c();
        iVarC.e(rVar.b(), rVar.i().a);
        jVarB.d(iVarC);
        ((n) this.a.b).a.e(jVarB);
        return jVarB;
    }

    public final com.google.android.libraries.navigation.internal.on.l b(r rVar) {
        if (rVar.b() <= 0) {
            return null;
        }
        return ((q) this.a.g.a()).b(rVar.c());
    }

    public final Bitmap c(u uVar, int i) {
        Bitmap bitmapDecodeResource;
        int iA = this.a.k.a(uVar, i);
        synchronized (this.b) {
            bitmapDecodeResource = (Bitmap) this.b.get(iA);
            if (bitmapDecodeResource == null) {
                bitmapDecodeResource = BitmapFactory.decodeResource(this.a.a, iA);
                this.b.put(iA, bitmapDecodeResource);
            }
        }
        return bitmapDecodeResource;
    }
}
