package com.google.android.libraries.navigation.internal.bm;

import android.graphics.drawable.Drawable;
import androidx.tracing.Trace;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements com.google.android.libraries.navigation.internal.qz.g {
    final /* synthetic */ h a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.br.u b;

    public e(h hVar, com.google.android.libraries.navigation.internal.br.u uVar) {
        this.b = uVar;
        this.a = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        com.google.android.libraries.navigation.internal.nc.ah ahVarG = kVar.g(com.google.android.libraries.navigation.internal.gw.x.c);
        if (!kVar.p() || ahVarG == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsIconManagerImpl.createDrawable - onIconAvailable");
        try {
            final Drawable drawableA = ahVarG.a(this.a.b);
            Executor executor = this.a.a;
            final com.google.android.libraries.navigation.internal.br.u uVar = this.b;
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.d
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
            if (dVarB != null) {
                Trace.endSection();
            }
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
    }
}
