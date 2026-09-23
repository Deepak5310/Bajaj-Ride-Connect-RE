package com.google.android.libraries.navigation.internal.agd;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface ai extends Consumer, IntConsumer {
    ai a(ai aiVar);

    ai b(IntConsumer intConsumer);

    void c(byte b);

    @Deprecated
    void d(Byte b);
}
