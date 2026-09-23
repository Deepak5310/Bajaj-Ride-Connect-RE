package com.google.android.libraries.navigation.internal.nt;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.libraries.navigation.internal.aac.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z implements as {
    final /* synthetic */ CallbackToFutureAdapter.Completer a;

    public z(CallbackToFutureAdapter.Completer completer) {
        this.a = completer;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        this.a.setException(th);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.a.set(null);
    }
}
