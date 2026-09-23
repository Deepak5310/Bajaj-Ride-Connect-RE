package com.google.android.libraries.navigation.internal.gk;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements com.google.android.libraries.navigation.internal.gg.b {
    final Future a;

    public b(Future future) {
        this.a = future;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.b
    public final boolean a() {
        return this.a.cancel(true);
    }
}
