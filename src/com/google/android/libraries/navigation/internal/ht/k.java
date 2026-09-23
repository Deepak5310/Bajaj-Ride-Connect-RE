package com.google.android.libraries.navigation.internal.ht;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public k(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("fetch getPseudonymousIdToken");
            try {
                com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
                if (dVarB == null) {
                    return aVar;
                }
                Trace.endSection();
                return aVar;
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception unused) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
    }
}
