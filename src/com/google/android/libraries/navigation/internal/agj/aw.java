package com.google.android.libraries.navigation.internal.agj;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class aw implements ag {
    public final /* synthetic */ Consumer a;

    @Override // com.google.android.libraries.navigation.internal.agj.ag
    public final /* synthetic */ ag a(ag agVar) {
        return af.a(this, agVar);
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
        this.a.accept(Short.valueOf(s));
    }
}
