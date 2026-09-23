package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ListenableResultFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.vp.a {
    final ListenableResultFuture.OnResultListener a;

    public l(ListenableResultFuture.OnResultListener onResultListener) {
        this.a = onResultListener;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.a
    public final void a(Object obj) {
        this.a.onResult(obj);
    }
}
