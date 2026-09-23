package com.google.android.libraries.navigation.internal.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ am a;

    public ab(am amVar) {
        this.a = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        int i = am.an;
        if (mVar != null) {
            mVar.c();
        }
        am amVar = this.a;
        Boolean bool = (Boolean) mVar.c();
        com.google.android.libraries.navigation.internal.yx.ar.q(bool);
        amVar.H = bool;
        synchronized (this.a.X) {
            am amVar2 = this.a;
            ak akVar = amVar2.Y;
            if (akVar != null) {
                akVar.a.e(amVar2.H.booleanValue());
            }
        }
    }
}
