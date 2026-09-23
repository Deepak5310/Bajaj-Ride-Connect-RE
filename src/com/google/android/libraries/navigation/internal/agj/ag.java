package com.google.android.libraries.navigation.internal.agj;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface ag extends Consumer, IntConsumer {
    ag a(ag agVar);

    ag b(IntConsumer intConsumer);

    @Deprecated
    void c(Short sh);

    void d(short s);
}
