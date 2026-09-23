package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.afx.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends c {
    final /* synthetic */ h b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar) {
        super(hVar);
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agb.c, com.google.android.libraries.navigation.internal.agb.a, com.google.android.libraries.navigation.internal.afx.ar
    public final void f(r rVar, ax axVar) {
        super.f(rVar, axVar);
        if (this.b.f.i || rVar != r.IDLE) {
            return;
        }
        this.b.b.d();
    }
}
