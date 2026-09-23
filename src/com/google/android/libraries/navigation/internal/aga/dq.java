package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dq implements com.google.android.libraries.navigation.internal.afx.ay {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.aw a;
    final /* synthetic */ du b;

    public dq(du duVar, com.google.android.libraries.navigation.internal.afx.aw awVar) {
        this.a = awVar;
        this.b = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ay
    public final void a(com.google.android.libraries.navigation.internal.afx.s sVar) {
        com.google.android.libraries.navigation.internal.afx.ax dsVar;
        com.google.android.libraries.navigation.internal.afx.r rVar = sVar.a;
        if (rVar == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        du duVar = this.b;
        if (rVar == com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE || rVar == com.google.android.libraries.navigation.internal.afx.r.IDLE) {
            duVar.f.e();
        }
        if (duVar.g == com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE) {
            if (rVar == com.google.android.libraries.navigation.internal.afx.r.CONNECTING) {
                return;
            }
            if (rVar == com.google.android.libraries.navigation.internal.afx.r.IDLE) {
                duVar.d();
                return;
            }
        }
        com.google.android.libraries.navigation.internal.afx.aw awVar = this.a;
        int iOrdinal = rVar.ordinal();
        if (iOrdinal == 0) {
            dsVar = new ds(com.google.android.libraries.navigation.internal.afx.as.a);
        } else if (iOrdinal == 1) {
            dsVar = new ds(com.google.android.libraries.navigation.internal.afx.as.c(awVar));
        } else if (iOrdinal == 2) {
            dsVar = new ds(com.google.android.libraries.navigation.internal.afx.as.b(sVar.b));
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(String.valueOf(rVar))));
            }
            dsVar = new dt(duVar, awVar);
        }
        duVar.f(rVar, dsVar);
    }
}
