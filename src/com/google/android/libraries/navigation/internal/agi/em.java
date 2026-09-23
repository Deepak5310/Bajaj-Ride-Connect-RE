package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class em extends er implements gw {
    final ep a;
    final /* synthetic */ et b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em(et etVar) {
        super(etVar);
        this.b = etVar;
        this.a = new ep(etVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.er
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ep epVar = this.a;
        epVar.a = i;
        obj.accept(epVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        er.f();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ep next() {
        ep epVar = this.a;
        epVar.a = c();
        return epVar;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.e(consumer);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        ep epVar = this.a;
        epVar.a = d();
        return epVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        er.g();
    }
}
