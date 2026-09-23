package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class by implements com.google.android.libraries.navigation.internal.rw.w {
    final /* synthetic */ bz a;

    public by(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.w
    public final void b(int i) {
        ab abVar;
        if (i == 2 && (abVar = this.a.a) != null && abVar.f()) {
            ab abVar2 = this.a.a;
            if (abVar2.f()) {
                abVar2.nativeDidReroute(abVar2.b);
            }
        }
    }
}
