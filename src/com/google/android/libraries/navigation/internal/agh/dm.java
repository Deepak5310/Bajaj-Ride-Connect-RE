package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dm extends ds implements com.google.android.libraries.navigation.internal.agi.gw {
    final /* synthetic */ du a;
    private dq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ds
    public final /* bridge */ /* synthetic */ void aQ(Object obj, int i) {
        ((Consumer) obj).accept(new dq(this.a, i));
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        ds.i();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        dq dqVar = new dq(this.a, g());
        this.b = dqVar;
        return dqVar;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        dq dqVar = new dq(this.a, h());
        this.b = dqVar;
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ds, com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        super.remove();
        this.b.a = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        ds.j();
    }
}
