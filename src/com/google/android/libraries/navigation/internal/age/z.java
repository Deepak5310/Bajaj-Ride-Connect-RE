package com.google.android.libraries.navigation.internal.age;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class z {
    @Deprecated
    public static void b(aa aaVar, Consumer consumer) {
        DoubleConsumer yVar;
        if (consumer instanceof DoubleConsumer) {
            yVar = (DoubleConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            yVar = new y(consumer);
        }
        aaVar.forEachRemaining(yVar);
    }

    @Deprecated
    public static boolean c(aa aaVar, Consumer consumer) {
        DoubleConsumer yVar;
        if (consumer instanceof DoubleConsumer) {
            yVar = (DoubleConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            yVar = new y(consumer);
        }
        return aaVar.tryAdvance(yVar);
    }

    public static n d() {
        throw new IllegalStateException();
    }
}
