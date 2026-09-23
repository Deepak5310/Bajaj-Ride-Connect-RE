package com.google.android.libraries.navigation.internal.agg;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class eh {
    @Deprecated
    public static Integer a(ei eiVar) {
        return Integer.valueOf(eiVar.nextInt());
    }

    @Deprecated
    public static void c(ei eiVar, final Consumer consumer) {
        IntConsumer intConsumer;
        if (consumer instanceof IntConsumer) {
            intConsumer = (IntConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            intConsumer = new IntConsumer() { // from class: com.google.android.libraries.navigation.internal.agg.eg
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    consumer.accept(Integer.valueOf(i));
                }
            };
        }
        eiVar.forEachRemaining(intConsumer);
    }
}
