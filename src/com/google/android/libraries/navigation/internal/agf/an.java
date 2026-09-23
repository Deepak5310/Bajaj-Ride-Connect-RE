package com.google.android.libraries.navigation.internal.agf;

import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class an {
    @Deprecated
    public static void b(ao aoVar, Consumer consumer) {
        s amVar;
        if (consumer instanceof s) {
            amVar = (s) consumer;
        } else {
            Objects.requireNonNull(consumer);
            amVar = new am(consumer);
        }
        aoVar.forEachRemaining(amVar);
    }

    @Deprecated
    public static boolean c(ao aoVar, Consumer consumer) {
        s amVar;
        if (consumer instanceof s) {
            amVar = (s) consumer;
        } else {
            Objects.requireNonNull(consumer);
            amVar = new am(consumer);
        }
        return aoVar.tryAdvance(amVar);
    }

    public static o d() {
        throw new IllegalStateException();
    }
}
