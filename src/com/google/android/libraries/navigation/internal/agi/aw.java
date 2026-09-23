package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw extends be implements gi {
    final /* synthetic */ bi a;
    private bc h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(bi biVar) {
        super(biVar);
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.be
    public final /* bridge */ /* synthetic */ void aS(Object obj, int i) {
        bc bcVar = new bc(this.a, i);
        this.h = bcVar;
        ((Consumer) obj).accept(bcVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        bc bcVar = new bc(this.a, d());
        this.h = bcVar;
        return bcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.be, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
