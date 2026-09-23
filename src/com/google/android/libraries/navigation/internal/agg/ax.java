package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gw;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax extends bc implements gw {
    final ba a;
    final /* synthetic */ be b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(be beVar) {
        super(beVar);
        this.b = beVar;
        this.a = new ba(beVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bc
    public final /* bridge */ /* synthetic */ void aN(Object obj, int i) {
        ba baVar = this.a;
        baVar.a = i;
        ((Consumer) obj).accept(baVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        bc.i();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ba baVar = this.a;
        baVar.a = g();
        return baVar;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        ba baVar = this.a;
        baVar.a = h();
        return baVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        bc.j();
    }
}
