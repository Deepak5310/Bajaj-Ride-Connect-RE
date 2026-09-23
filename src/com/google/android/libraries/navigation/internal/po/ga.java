package com.google.android.libraries.navigation.internal.po;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ga implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ gm a;

    public ga(gm gmVar) {
        this.a = gmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        gm gmVar = this.a;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.createStylesImpl");
        try {
            hi hiVar = new hi(gmVar.w, gmVar.m, ((com.google.android.libraries.navigation.internal.om.l) gmVar.a.a()).P(), com.google.android.libraries.geo.mapcore.renderer.bt.a().a(true), gmVar.d, gmVar.o);
            if (dVarB != null) {
                Trace.endSection();
            }
            return hiVar;
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
