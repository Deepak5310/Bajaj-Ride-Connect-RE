package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gw;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends bc implements gw {
    final /* synthetic */ be a;
    private ba b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(be beVar) {
        super(beVar);
        this.a = beVar;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ba next() {
        ba baVar = new ba(this.a, g());
        this.b = baVar;
        return baVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bc
    public final /* bridge */ /* synthetic */ void aN(Object obj, int i) {
        ((Consumer) obj).accept(new ba(this.a, i));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        bc.i();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        ba baVar = new ba(this.a, h());
        this.b = baVar;
        return baVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bc, com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        super.remove();
        this.b.a = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        bc.j();
    }
}
