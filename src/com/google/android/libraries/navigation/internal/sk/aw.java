package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.sl.i a;
    final /* synthetic */ bf b;

    public aw(bf bfVar, com.google.android.libraries.navigation.internal.sl.i iVar) {
        this.a = iVar;
        this.b = bfVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        int i = bf.t;
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1417)).p("VoiceGuidance-error");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.b.h(this.a, 1);
        }
    }
}
