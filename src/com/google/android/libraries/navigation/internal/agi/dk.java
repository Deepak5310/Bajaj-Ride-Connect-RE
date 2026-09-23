package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dk extends dq implements gi {
    final /* synthetic */ du a;
    private final Cdo h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(du duVar) {
        super(duVar);
        this.a = duVar;
        this.h = new Cdo(duVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dq
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        Cdo cdo = this.h;
        cdo.a = i;
        ((Consumer) obj).accept(cdo);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Cdo cdo = this.h;
        cdo.a = b();
        return cdo;
    }
}
