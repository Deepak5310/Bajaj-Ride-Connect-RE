package com.google.android.libraries.navigation.internal.ck;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bv implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ CallbackToFutureAdapter.Completer a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.cp.r b;

    public bv(CallbackToFutureAdapter.Completer completer, com.google.android.libraries.navigation.internal.cp.r rVar) {
        this.a = completer;
        this.b = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F('|')).p("A problem occurred while waiting for the MapStyles to become ready:");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.a.set(new bw(this.b));
    }
}
