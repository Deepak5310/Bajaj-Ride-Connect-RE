package com.google.android.libraries.navigation.internal.agj;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ai {
    @Deprecated
    public static Short a(aj ajVar) {
        return Short.valueOf(ajVar.d());
    }

    @Deprecated
    public static void c(aj ajVar, final Consumer consumer) {
        ag agVar;
        if (consumer instanceof ag) {
            agVar = (ag) consumer;
        } else {
            Objects.requireNonNull(consumer);
            agVar = new ag() { // from class: com.google.android.libraries.navigation.internal.agj.ah
                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ ag a(ag agVar2) {
                    return af.a(this, agVar2);
                }

                @Override // java.util.function.IntConsumer
                public final /* synthetic */ void accept(int i) {
                    af.d(this, i);
                }

                @Override // java.util.function.Consumer
                public final /* bridge */ /* synthetic */ void accept(Object obj) {
                    c((Short) obj);
                }

                @Override // java.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    af.g();
                    return null;
                }

                @Override // java.util.function.IntConsumer
                public final /* bridge */ /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                    return b(intConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ ag b(IntConsumer intConsumer) {
                    return af.b(this, intConsumer);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ void c(Short sh) {
                    af.f(this, sh);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final void d(short s) {
                    consumer.accept(Short.valueOf(s));
                }
            };
        }
        ajVar.b(agVar);
    }
}
