package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi extends bq implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ bu a;
    private bo h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bu buVar) {
        super(buVar);
        this.a = buVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bq
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        bo boVar = new bo(this.a, i);
        this.h = boVar;
        ((Consumer) obj).accept(boVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        bo boVar = new bo(this.a, b());
        this.h = boVar;
        return boVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bq, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
