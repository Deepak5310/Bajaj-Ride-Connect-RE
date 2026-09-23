package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al {
    final /* synthetic */ am a;

    public al(am amVar) {
        this.a = amVar;
    }

    public final void a(int i, int i2, float f, float f2, boolean z) {
        this.a.b.a(new ai(i, i2, Math.max(0.0f, f), Math.max(0.0f, f2), z));
        long jB = this.a.d.b();
        am amVar = this.a;
        com.google.android.libraries.navigation.internal.kl.a aVar = amVar.c;
        if (aVar != null && jB - amVar.h < 1300000000) {
            ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(24);
        }
        this.a.b();
    }
}
