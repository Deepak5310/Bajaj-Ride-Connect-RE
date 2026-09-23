package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class el extends er implements gw {
    final /* synthetic */ et a;
    private ep b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el(et etVar) {
        super(etVar);
        this.a = etVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.er
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        obj.accept(new ep(this.a, i));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        er.f();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.e(consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ep epVar = new ep(this.a, c());
        this.b = epVar;
        return epVar;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        ep epVar = new ep(this.a, d());
        this.b = epVar;
        return epVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.er, com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        super.remove();
        this.b.a = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        er.g();
    }
}
