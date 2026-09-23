package com.google.android.libraries.navigation.internal.agf;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class am implements s {
    public final /* synthetic */ Consumer a;

    @Override // com.google.android.libraries.navigation.internal.agf.s
    public final /* synthetic */ s a(s sVar) {
        return r.a(this, sVar);
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
        this.a.accept(Float.valueOf(f));
    }

    @Override // com.google.android.libraries.navigation.internal.agf.s
    public final /* synthetic */ void d(Float f) {
        r.e(this, f);
    }
}
