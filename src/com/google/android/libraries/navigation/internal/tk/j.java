package com.google.android.libraries.navigation.internal.tk;

import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.nt.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements t {
    final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.vn.d dVar;
        bw bwVar;
        if (!this.a.b() || (dVar = (com.google.android.libraries.navigation.internal.vn.d) mVar.c()) == null || (bwVar = dVar.d) == null) {
            return;
        }
        this.a.d.d(bwVar);
    }
}
