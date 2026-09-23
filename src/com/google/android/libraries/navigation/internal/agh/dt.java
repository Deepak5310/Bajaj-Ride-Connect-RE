package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dt extends ds implements com.google.android.libraries.navigation.internal.agi.gw {
    final /* synthetic */ du a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ds
    public final /* bridge */ /* synthetic */ void aQ(Object obj, int i) {
        ((Consumer) obj).accept(this.a.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        com.google.android.libraries.navigation.internal.agi.gv.a();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.a.b[g()];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        return this.a.b[h()];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        com.google.android.libraries.navigation.internal.agi.gv.c();
    }
}
