package com.google.android.libraries.navigation.internal.qu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax implements com.google.android.libraries.navigation.internal.qz.g {
    final /* synthetic */ String a;
    final /* synthetic */ bg b;
    final com.google.android.libraries.navigation.internal.kk.e c;

    public ax(bg bgVar, String str) {
        this.a = str;
        this.b = bgVar;
        this.c = ((com.google.android.libraries.navigation.internal.kl.b) bgVar.a.a()).c();
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final synchronized void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        if (kVar.p()) {
            if (this.b.j.get()) {
                bg bgVar = this.b;
                if (bgVar.d.s(this.a)) {
                }
            } else {
                bg bgVar2 = this.b;
                if (bgVar2.d.s(this.a)) {
                }
                bg bgVar3 = this.b;
                if (bgVar3.e.s(this.a)) {
                }
            }
        }
    }
}
