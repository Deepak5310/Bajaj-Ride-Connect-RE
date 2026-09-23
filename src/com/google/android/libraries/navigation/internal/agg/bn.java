package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn extends bv implements gi {
    final /* synthetic */ bz a;
    private bt h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bz bzVar) {
        super(bzVar);
        this.a = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bv
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        bt btVar = new bt(this.a, i);
        this.h = btVar;
        ((Consumer) obj).accept(btVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        bt btVar = new bt(this.a, b());
        this.h = btVar;
        return btVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bv, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
