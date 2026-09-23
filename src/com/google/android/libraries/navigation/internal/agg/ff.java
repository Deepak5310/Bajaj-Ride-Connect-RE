package com.google.android.libraries.navigation.internal.agg;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ff implements IntConsumer {
    public final /* synthetic */ Consumer a;

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.a.accept(Integer.valueOf(i));
    }
}
