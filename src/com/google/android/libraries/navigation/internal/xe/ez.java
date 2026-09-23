package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationTransactionRecorder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ez implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ fi a;

    public ez(fi fiVar) {
        this.a = fiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        com.google.android.libraries.navigation.internal.xh.b bVar = (com.google.android.libraries.navigation.internal.xh.b) obj;
        synchronized (fi.a) {
            if (bVar.c()) {
                try {
                    fi fiVar = this.a;
                    fiVar.i(fiVar.m, false);
                } catch (NavigationTransactionRecorder.TransactionException unused) {
                }
            }
            this.a.m = null;
        }
    }
}
