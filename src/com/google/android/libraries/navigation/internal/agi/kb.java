package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class kb extends kg implements gi {
    final /* synthetic */ kk a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb(kk kkVar) {
        super(kkVar);
        this.a = kkVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.kg
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        obj.accept(this.a.a[i]);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.a.a[b()];
    }
}
