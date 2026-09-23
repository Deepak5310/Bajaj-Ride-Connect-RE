package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bx extends bv implements gi {
    final /* synthetic */ bz a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(bz bzVar) {
        super(bzVar);
        this.a = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bv
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ((Consumer) obj).accept(this.a.b[i]);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.a.b[b()];
    }
}
