package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc {
    final /* synthetic */ bg a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private com.google.android.libraries.navigation.internal.qv.c c = null;
    private boolean d = false;

    public bc(bg bgVar, com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = bgVar;
        this.b = aVar;
    }

    final synchronized com.google.android.libraries.navigation.internal.qv.c a() {
        if (this.d) {
            return this.c;
        }
        try {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GST - getOrInitializeCache");
            try {
                com.google.android.libraries.navigation.internal.qv.a aVar = (com.google.android.libraries.navigation.internal.qv.a) this.b.a();
                bg bgVar = this.a;
                this.c = aVar.b(bgVar.c, bgVar.f);
                if (dVarB != null) {
                    Trace.endSection();
                }
                this.d = true;
                return this.c;
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
        } catch (Throwable th3) {
            this.d = true;
            throw th3;
        }
    }
}
