package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ ba a;

    public az(ba baVar) {
        this.a = baVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        int i = bf.t;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1418)).p("VoiceGuidance-error");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            return;
        }
        this.a.a.f(com.google.android.libraries.navigation.internal.yp.a.IDLE);
    }
}
