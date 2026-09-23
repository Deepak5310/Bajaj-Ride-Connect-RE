package com.google.android.libraries.navigation.internal.de;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.rw.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements aa {
    final /* synthetic */ m a;

    public k(m mVar) {
        this.a = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        if (z) {
            al alVarC = oVar.a.c();
            if (alVarC != null) {
                this.a.b = alVarC;
            }
            this.a.f();
        }
    }
}
