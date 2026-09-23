package com.google.android.libraries.navigation.internal.vu;

import com.google.android.libraries.navigation.internal.afl.lq;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements br {
    final /* synthetic */ x a;

    public v(x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final be a() {
        x xVar = this.a;
        bg bgVar = xVar.b;
        be beVar = xVar.d;
        if (beVar != null) {
            return beVar;
        }
        if (bgVar != null) {
            int iA = lq.a(bgVar.P.m);
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
