package com.google.android.libraries.navigation.internal.agf;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface s extends Consumer, DoubleConsumer {
    s a(s sVar);

    s b(DoubleConsumer doubleConsumer);

    void c(float f);

    @Deprecated
    void d(Float f);
}
