package com.google.android.libraries.navigation.internal.uh;

import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements br {
    final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final be a() {
        l lVar = this.a;
        com.google.android.libraries.navigation.internal.ui.a aVar = lVar.o;
        if (aVar == null) {
            return be.TIME;
        }
        be beVar = lVar.j;
        if (beVar != null) {
            return beVar;
        }
        com.google.android.libraries.navigation.internal.tj.j jVar = aVar.h;
        if (jVar != null) {
            int iA = lq.a(jVar.b().e(0).P.m);
            if (iA == 0) {
                iA = lq.b;
            }
            if (iA == lq.c) {
                return be.DISTANCE;
            }
        }
        return be.TIME;
    }
}
