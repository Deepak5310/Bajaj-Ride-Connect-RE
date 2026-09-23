package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gv;
import com.google.android.libraries.navigation.internal.agi.gw;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bd extends bc implements gw {
    final /* synthetic */ be a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(be beVar) {
        super(beVar);
        this.a = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bc
    public final /* bridge */ /* synthetic */ void aN(Object obj, int i) {
        ((Consumer) obj).accept(this.a.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        gv.a();
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
        gv.c();
    }
}
