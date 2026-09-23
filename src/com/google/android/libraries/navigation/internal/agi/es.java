package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class es extends er implements gw {
    final /* synthetic */ et a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(et etVar) {
        super(etVar);
        this.a = etVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.er
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        obj.accept(this.a.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        gv.a();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.e(consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.a.b[c()];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        return this.a.b[d()];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        gv.c();
    }
}
