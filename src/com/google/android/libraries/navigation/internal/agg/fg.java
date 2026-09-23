package com.google.android.libraries.navigation.internal.agg;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class fg {
    @Deprecated
    public static void a(fh fhVar, Consumer consumer) {
        IntConsumer ffVar;
        if (consumer instanceof IntConsumer) {
            ffVar = (IntConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            ffVar = new ff(consumer);
        }
        fhVar.forEachRemaining(ffVar);
    }

    @Deprecated
    public static boolean b(fh fhVar, Consumer consumer) {
        IntConsumer ffVar;
        if (consumer instanceof IntConsumer) {
            ffVar = (IntConsumer) consumer;
        } else {
            Objects.requireNonNull(consumer);
            ffVar = new ff(consumer);
        }
        return fhVar.tryAdvance(ffVar);
    }

    public static dt c() {
        throw new IllegalStateException();
    }
}
