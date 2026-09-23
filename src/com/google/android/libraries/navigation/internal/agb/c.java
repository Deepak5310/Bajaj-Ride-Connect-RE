package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.ar;
import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.afx.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c extends a {
    final /* synthetic */ d a;

    protected c(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agb.a, com.google.android.libraries.navigation.internal.afx.ar
    public void f(r rVar, ax axVar) {
        if (this.a.c == r.SHUTDOWN) {
            return;
        }
        d dVar = this.a;
        dVar.c = rVar;
        dVar.d = axVar;
        f fVar = dVar.e;
        if (fVar.i) {
            return;
        }
        fVar.g();
    }

    @Override // com.google.android.libraries.navigation.internal.agb.a
    protected final ar g() {
        return this.a.e.h;
    }
}
