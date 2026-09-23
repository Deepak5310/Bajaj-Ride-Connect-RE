package com.google.android.libraries.navigation.internal.mx;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.ms.bk;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.co;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends g {
    public final g a;
    final j b;
    private final boolean f;

    public h(g gVar, boolean z, j jVar, m[] mVarArr) {
        super(mVarArr);
        this.a = gVar;
        this.f = z;
        this.b = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.g
    public final View a(co coVar, int i, Integer num, ViewGroup viewGroup, boolean z) {
        bk bkVar = new bk(coVar.a(num, viewGroup), null);
        coVar.c(viewGroup, bkVar, z);
        bkVar.a = this.a;
        bkVar.b = this.f;
        bkVar.c = this.b;
        return bkVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.g
    protected final cc c() {
        return this.a.d();
    }
}
