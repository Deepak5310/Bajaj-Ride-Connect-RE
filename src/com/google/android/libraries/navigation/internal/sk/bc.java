package com.google.android.libraries.navigation.internal.sk;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc implements Callable {
    final /* synthetic */ bf a;

    public bc(bf bfVar) {
        this.a = bfVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        bf bfVar = this.a;
        com.google.android.libraries.navigation.internal.sl.i iVar = bfVar.p;
        if (iVar == null || bfVar.r == 0) {
            return null;
        }
        return new com.google.android.libraries.navigation.internal.sm.a(iVar);
    }
}
