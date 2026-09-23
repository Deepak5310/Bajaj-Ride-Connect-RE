package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cm extends cu implements gi {
    final /* synthetic */ cy a;
    private cs h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm(cy cyVar) {
        super(cyVar);
        this.a = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cu
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        cs csVar = new cs(this.a, i);
        this.h = csVar;
        ((Consumer) obj).accept(csVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        cs csVar = new cs(this.a, b());
        this.h = csVar;
        return csVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cu, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
