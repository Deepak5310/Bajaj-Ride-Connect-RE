package com.google.android.libraries.navigation.internal.agh;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class hk {
    @Deprecated
    public static void b(hl hlVar, Consumer consumer) {
        LongConsumer hjVar;
        if (consumer instanceof LongConsumer) {
            hjVar = (LongConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            hjVar = new hj(consumer);
        }
        hlVar.forEachRemaining(hjVar);
    }

    @Deprecated
    public static boolean c(hl hlVar, Consumer consumer) {
        LongConsumer hjVar;
        if (consumer instanceof LongConsumer) {
            hjVar = (LongConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            hjVar = new hj(consumer);
        }
        return hlVar.tryAdvance(hjVar);
    }

    public static gk d() {
        throw new IllegalStateException();
    }
}
