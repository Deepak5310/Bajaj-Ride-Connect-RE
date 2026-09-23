package com.google.android.libraries.navigation.internal.agf;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class r {
    public static s a(final s sVar, final s sVar2) {
        Objects.requireNonNull(sVar2);
        return new s() { // from class: com.google.android.libraries.navigation.internal.agf.q
            @Override // com.google.android.libraries.navigation.internal.agf.s
            public final /* synthetic */ s a(s sVar3) {
                return r.a(this, sVar3);
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
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
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
                sVar.c(f);
                sVar2.c(f);
            }

            @Override // com.google.android.libraries.navigation.internal.agf.s
            public final /* synthetic */ void d(Float f) {
                r.e(this, f);
            }
        };
    }

    public static s b(s sVar, final DoubleConsumer doubleConsumer) {
        s sVar2;
        if (doubleConsumer instanceof s) {
            sVar2 = (s) doubleConsumer;
        } else {
            Objects.requireNonNull(doubleConsumer);
            sVar2 = new s() { // from class: com.google.android.libraries.navigation.internal.agf.p
                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ s a(s sVar3) {
                    return r.a(this, sVar3);
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
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    r.g();
                    return null;
                }

                @Override // java.util.function.DoubleConsumer
                public final /* bridge */ /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer2) {
                    return b(doubleConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ s b(DoubleConsumer doubleConsumer2) {
                    return r.b(this, doubleConsumer2);
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final void c(float f) {
                    doubleConsumer.accept(f);
                }

                @Override // com.google.android.libraries.navigation.internal.agf.s
                public final /* synthetic */ void d(Float f) {
                    r.e(this, f);
                }
            };
        }
        return sVar.a(sVar2);
    }

    @Deprecated
    public static void d(s sVar, double d) {
        sVar.c(com.google.android.libraries.navigation.internal.agc.g.b(d));
    }

    @Deprecated
    public static void e(s sVar, Float f) {
        sVar.c(f.floatValue());
    }

    @Deprecated
    public static void g() {
        throw new NoSuchMethodError();
    }
}
