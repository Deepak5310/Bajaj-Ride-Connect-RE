package com.google.android.libraries.navigation.internal.agd;

import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bd {
    @Deprecated
    public static void b(be beVar, Consumer consumer) {
        ai bcVar;
        if (consumer instanceof ai) {
            bcVar = (ai) consumer;
        } else {
            Objects.requireNonNull(consumer);
            bcVar = new bc(consumer);
        }
        beVar.forEachRemaining(bcVar);
    }

    @Deprecated
    public static boolean c(be beVar, Consumer consumer) {
        ai bcVar;
        if (consumer instanceof ai) {
            bcVar = (ai) consumer;
        } else {
            Objects.requireNonNull(consumer);
            bcVar = new bc(consumer);
        }
        return beVar.tryAdvance(bcVar);
    }

    public static z d() {
        throw new IllegalStateException();
    }
}
