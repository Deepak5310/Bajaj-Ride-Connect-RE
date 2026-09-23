package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bg implements Runnable {
    final /* synthetic */ bh a;

    public bg(bh bhVar) {
        this.a = bhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bt btVar = this.a.b;
        de deVar = btVar.m;
        btVar.l = null;
        btVar.m = null;
        deVar.c(com.google.android.libraries.navigation.internal.afx.cl.f.b("InternalSubchannel closed transport due to address change"));
    }
}
