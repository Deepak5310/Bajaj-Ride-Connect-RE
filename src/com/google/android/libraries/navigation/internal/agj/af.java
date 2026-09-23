package com.google.android.libraries.navigation.internal.agj;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class af {
    public static ag a(final ag agVar, final ag agVar2) {
        Objects.requireNonNull(agVar2);
        return new ag() { // from class: com.google.android.libraries.navigation.internal.agj.ae
            @Override // com.google.android.libraries.navigation.internal.agj.ag
            public final /* synthetic */ ag a(ag agVar3) {
                return af.a(this, agVar3);
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
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
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
                agVar.d(s);
                agVar2.d(s);
            }
        };
    }

    public static ag b(ag agVar, final IntConsumer intConsumer) {
        ag agVar2;
        if (intConsumer instanceof ag) {
            agVar2 = (ag) intConsumer;
        } else {
            Objects.requireNonNull(intConsumer);
            agVar2 = new ag() { // from class: com.google.android.libraries.navigation.internal.agj.ad
                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ ag a(ag agVar3) {
                    return af.a(this, agVar3);
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
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    af.g();
                    return null;
                }

                @Override // java.util.function.IntConsumer
                public final /* bridge */ /* synthetic */ IntConsumer andThen(IntConsumer intConsumer2) {
                    return b(intConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ ag b(IntConsumer intConsumer2) {
                    return af.b(this, intConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final /* synthetic */ void c(Short sh) {
                    af.f(this, sh);
                }

                @Override // com.google.android.libraries.navigation.internal.agj.ag
                public final void d(short s) {
                    intConsumer.accept(s);
                }
            };
        }
        return agVar.a(agVar2);
    }

    @Deprecated
    public static void d(ag agVar, int i) {
        agVar.d(com.google.android.libraries.navigation.internal.agc.g.c(i));
    }

    @Deprecated
    public static void f(ag agVar, Short sh) {
        agVar.d(sh.shortValue());
    }

    @Deprecated
    public static void g() {
        throw new NoSuchMethodError();
    }
}
