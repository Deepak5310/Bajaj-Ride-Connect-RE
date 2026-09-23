package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ka extends kg implements gi {
    final /* synthetic */ kk a;
    private final ke h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ka(kk kkVar) {
        super(kkVar);
        this.a = kkVar;
        this.h = new ke(kkVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.kg
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ke keVar = this.h;
        keVar.a = i;
        obj.accept(keVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ke keVar = this.h;
        keVar.a = b();
        return keVar;
    }
}
