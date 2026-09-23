package com.google.android.libraries.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends com.google.android.libraries.navigation.internal.ia.k {
    public l(Class cls, NavigationTransactionRecorder navigationTransactionRecorder, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, navigationTransactionRecorder, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        NavigationTransactionRecorder navigationTransactionRecorder = (NavigationTransactionRecorder) this.c;
        com.google.android.libraries.navigation.internal.db.n nVar = (com.google.android.libraries.navigation.internal.db.n) ((com.google.android.libraries.navigation.internal.db.o) aVar).d();
        if (nVar != null) {
            navigationTransactionRecorder.a = nVar;
        }
    }
}
