package com.google.android.libraries.navigation.internal.gn;

import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements Runnable {
    final /* synthetic */ e a;

    public c(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            e eVar = this.a;
            this.a.a.d(eVar.b.a(eVar.c));
            i iVar = this.a.d;
            byte[] globalMetricsDeltas = ((CronetEngine) iVar.b.a()).getGlobalMetricsDeltas();
            if (globalMetricsDeltas == null || globalMetricsDeltas.length <= 0) {
                return;
            }
            iVar.h.j();
        } catch (Exception e) {
            int i = i.l;
            this.a.a.ap(e);
        }
    }
}
