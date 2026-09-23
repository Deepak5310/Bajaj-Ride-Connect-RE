package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ x a;

    public v(x xVar) {
        this.a = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        int i = x.s;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1412)).p("VoiceGuidance-error");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            x xVar = this.a;
            dp dpVar = xVar.q;
            if (dpVar != null) {
                xVar.q = null;
                xVar.v(dpVar);
                return;
            }
            xVar.prevJob = xVar.p;
            xVar.p = null;
            af afVar = xVar.k;
            com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
            afVar.b(com.google.android.libraries.navigation.internal.sl.i.IDLE);
        }
    }
}
