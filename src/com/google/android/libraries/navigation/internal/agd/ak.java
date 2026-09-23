package com.google.android.libraries.navigation.internal.agd;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ak {
    @Deprecated
    public static Byte a(al alVar) {
        return Byte.valueOf(alVar.c());
    }

    @Deprecated
    public static void d(al alVar, final Consumer consumer) {
        ai aiVar;
        if (consumer instanceof ai) {
            aiVar = (ai) consumer;
        } else {
            Objects.requireNonNull(consumer);
            aiVar = new ai() { // from class: com.google.android.libraries.navigation.internal.agd.aj
                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ ai a(ai aiVar2) {
                    return ah.a(this, aiVar2);
                }

                @Override // java.util.function.IntConsumer
                public final /* synthetic */ void accept(int i) {
                    ah.d(this, i);
                }

                @Override // java.util.function.Consumer
                public final /* bridge */ /* synthetic */ void accept(Object obj) {
                    d((Byte) obj);
                }

                @Override // java.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    ah.g();
                    return null;
                }

                @Override // java.util.function.IntConsumer
                public final /* bridge */ /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                    return b(intConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ ai b(IntConsumer intConsumer) {
                    return ah.b(this, intConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final void c(byte b) {
                    consumer.accept(Byte.valueOf(b));
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ void d(Byte b) {
                    ah.e(this, b);
                }
            };
        }
        alVar.b(aiVar);
    }
}
