package com.google.android.libraries.navigation.internal.agf;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class u {
    @Deprecated
    public static Float a(v vVar) {
        return Float.valueOf(vVar.a());
    }

    public static void c(v vVar, s sVar) {
        Objects.requireNonNull(sVar);
        while (vVar.hasNext()) {
            sVar.c(vVar.a());
        }
    }

    @Deprecated
    public static void e(v vVar, final Consumer consumer) {
        s sVar;
        if (consumer instanceof s) {
            sVar = (s) consumer;
        } else {
            Objects.requireNonNull(consumer);
            sVar = new s() { // from class: com.google.android.libraries.navigation.internal.agf.t
                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ s a(s sVar2) {
                    return r.a(this, sVar2);
                }

                @Override // java.util.function.DoubleConsumer
                public final /* synthetic */ void accept(double d) {
                    r.d(this, d);
                }

                @Override // java.util.function.Consumer
                public final /* bridge */ /* synthetic */ void accept(Object obj) {
                    d((Float) obj);
                }

                @Override // java.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    r.g();
                    return null;
                }

                @Override // java.util.function.DoubleConsumer
                public final /* bridge */ /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                    return b(doubleConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ s b(DoubleConsumer doubleConsumer) {
                    return r.b(this, doubleConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final void c(float f) {
                    consumer.accept(Float.valueOf(f));
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ void d(Float f) {
                    r.e(this, f);
                }
            };
        }
        vVar.c(sVar);
    }
}
