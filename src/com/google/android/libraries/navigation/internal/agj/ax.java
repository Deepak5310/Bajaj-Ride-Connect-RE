package com.google.android.libraries.navigation.internal.agj;

import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ax {
    @Deprecated
    public static void b(ay ayVar, Consumer consumer) {
        ag awVar;
        if (consumer instanceof ag) {
            awVar = (ag) consumer;
        } else {
            Objects.requireNonNull(consumer);
            awVar = new aw(consumer);
        }
        ayVar.forEachRemaining(awVar);
    }

    @Deprecated
    public static boolean c(ay ayVar, Consumer consumer) {
        ag awVar;
        if (consumer instanceof ag) {
            awVar = (ag) consumer;
        } else {
            Objects.requireNonNull(consumer);
            awVar = new aw(consumer);
        }
        return ayVar.tryAdvance(awVar);
    }

    public static x d() {
        throw new IllegalStateException();
    }
}
