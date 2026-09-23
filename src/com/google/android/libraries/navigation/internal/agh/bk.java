package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bk extends bq implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ bu a;
    private final bo h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bu buVar) {
        super(buVar);
        this.a = buVar;
        this.h = new bo(buVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bq
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        bo boVar = this.h;
        boVar.a = i;
        ((Consumer) obj).accept(boVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        bo boVar = this.h;
        boVar.a = b();
        return boVar;
    }
}
