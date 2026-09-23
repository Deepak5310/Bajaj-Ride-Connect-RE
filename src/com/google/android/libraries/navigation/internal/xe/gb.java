package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ListenableResultFuture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gb implements com.google.android.libraries.navigation.internal.vp.a {
    final ListenableResultFuture.OnResultListener a;

    public gb(ListenableResultFuture.OnResultListener onResultListener) {
        this.a = onResultListener;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.a
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.a.onResult(gc.a((com.google.android.libraries.navigation.internal.vp.c) obj));
    }
}
