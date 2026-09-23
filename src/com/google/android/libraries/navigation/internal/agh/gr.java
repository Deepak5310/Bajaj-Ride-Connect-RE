package com.google.android.libraries.navigation.internal.agh;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class gr {
    @Deprecated
    public static Long a(gs gsVar) {
        return Long.valueOf(gsVar.nextLong());
    }

    @Deprecated
    public static void c(gs gsVar, final Consumer consumer) {
        LongConsumer longConsumer;
        if (consumer instanceof LongConsumer) {
            longConsumer = (LongConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            longConsumer = new LongConsumer() { // from class: com.google.android.libraries.navigation.internal.agh.gq
                @Override // java.util.function.LongConsumer
                public final void accept(long j) {
                    consumer.accept(Long.valueOf(j));
                }
            };
        }
        gsVar.forEachRemaining(longConsumer);
    }
}
