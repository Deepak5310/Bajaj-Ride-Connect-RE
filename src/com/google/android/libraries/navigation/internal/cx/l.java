package com.google.android.libraries.navigation.internal.cx;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.rw.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements aa {
    final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        if (z) {
            al alVarC = oVar.a.c();
            if (alVarC != null) {
                this.a.u = alVarC;
            }
            this.a.j();
        }
    }
}
