package com.google.android.libraries.navigation.internal.age;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class p {
    @Deprecated
    public static Double a(q qVar) {
        return Double.valueOf(qVar.nextDouble());
    }

    @Deprecated
    public static void c(q qVar, final Consumer consumer) {
        DoubleConsumer doubleConsumer;
        if (consumer instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            doubleConsumer = new DoubleConsumer() { // from class: com.google.android.libraries.navigation.internal.age.o
                @Override // java.util.function.DoubleConsumer
                public final void accept(double d) {
                    consumer.accept(Double.valueOf(d));
                }
            };
        }
        qVar.forEachRemaining(doubleConsumer);
    }
}
