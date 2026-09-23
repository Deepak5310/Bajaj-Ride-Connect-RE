package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class di extends dq implements gi {
    final /* synthetic */ du a;
    private Cdo h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dq
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        Cdo cdo = new Cdo(this.a, i);
        this.h = cdo;
        ((Consumer) obj).accept(cdo);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Cdo cdo = new Cdo(this.a, b());
        this.h = cdo;
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dq, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
