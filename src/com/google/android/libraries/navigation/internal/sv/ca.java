package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ca implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ cd a;

    public ca(cd cdVar) {
        this.a = cdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.tj.u uVar = (com.google.android.libraries.navigation.internal.tj.u) mVar.c();
        if (uVar instanceof com.google.android.libraries.navigation.internal.tj.ag) {
            com.google.android.libraries.navigation.internal.tj.ag agVar = (com.google.android.libraries.navigation.internal.tj.ag) uVar;
            this.a.a = new cb(agVar.a.g, agVar.b);
        }
    }
}
