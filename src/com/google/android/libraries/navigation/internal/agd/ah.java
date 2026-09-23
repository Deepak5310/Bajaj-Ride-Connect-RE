package com.google.android.libraries.navigation.internal.agd;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ah {
    public static ai a(final ai aiVar, final ai aiVar2) {
        Objects.requireNonNull(aiVar2);
        return new ai() { // from class: com.google.android.libraries.navigation.internal.agd.ag
            @Override // com.google.android.libraries.navigation.internal.agd.ai
            public final /* synthetic */ ai a(ai aiVar3) {
                return ah.a(this, aiVar3);
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
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
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
                aiVar.c(b);
                aiVar2.c(b);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ai
            public final /* synthetic */ void d(Byte b) {
                ah.e(this, b);
            }
        };
    }

    public static ai b(ai aiVar, final IntConsumer intConsumer) {
        ai aiVar2;
        if (intConsumer instanceof ai) {
            aiVar2 = (ai) intConsumer;
        } else {
            Objects.requireNonNull(intConsumer);
            aiVar2 = new ai() { // from class: com.google.android.libraries.navigation.internal.agd.af
                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ ai a(ai aiVar3) {
                    return ah.a(this, aiVar3);
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
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    ah.g();
                    return null;
                }

                @Override // java.util.function.IntConsumer
                public final /* bridge */ /* synthetic */ IntConsumer andThen(IntConsumer intConsumer2) {
                    return b(intConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ ai b(IntConsumer intConsumer2) {
                    return ah.b(this, intConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final void c(byte b) {
                    intConsumer.accept(b);
                }

                @Override // com.google.android.libraries.navigation.internal.agd.ai
                public final /* synthetic */ void d(Byte b) {
                    ah.e(this, b);
                }
            };
        }
        return aiVar.a(aiVar2);
    }

    @Deprecated
    public static void d(ai aiVar, int i) {
        aiVar.c(com.google.android.libraries.navigation.internal.agc.g.a(i));
    }

    @Deprecated
    public static void e(ai aiVar, Byte b) {
        aiVar.c(b.byteValue());
    }

    @Deprecated
    public static void g() {
        throw new NoSuchMethodError();
    }
}
