package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends be implements gi {
    final /* synthetic */ bi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(bi biVar) {
        super(biVar);
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.be
    public final /* bridge */ /* synthetic */ void aS(Object obj, int i) {
        ((Consumer) obj).accept(this.a.a[i]);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.a.a[d()];
    }
}
