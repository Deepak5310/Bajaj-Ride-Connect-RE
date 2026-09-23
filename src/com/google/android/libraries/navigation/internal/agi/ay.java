package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ay extends be implements gi {
    final /* synthetic */ bi a;
    private final bc h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(bi biVar) {
        super(biVar);
        this.a = biVar;
        this.h = new bc(biVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.be
    public final /* bridge */ /* synthetic */ void aS(Object obj, int i) {
        bc bcVar = this.h;
        bcVar.a = i;
        ((Consumer) obj).accept(bcVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        bc bcVar = this.h;
        bcVar.a = d();
        return bcVar;
    }
}
