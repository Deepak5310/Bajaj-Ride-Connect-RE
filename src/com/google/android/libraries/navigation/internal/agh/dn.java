package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dn extends ds implements com.google.android.libraries.navigation.internal.agi.gw {
    final dq a;
    final /* synthetic */ du b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(du duVar) {
        super(duVar);
        this.b = duVar;
        this.a = new dq(duVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ds
    public final /* bridge */ /* synthetic */ void aQ(Object obj, int i) {
        dq dqVar = this.a;
        dqVar.a = i;
        ((Consumer) obj).accept(dqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        ds.i();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final dq next() {
        dq dqVar = this.a;
        dqVar.a = g();
        return dqVar;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        dq dqVar = this.a;
        dqVar.a = h();
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        ds.j();
    }
}
