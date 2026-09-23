package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co extends cu implements gi {
    final /* synthetic */ cy a;
    private final cs h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(cy cyVar) {
        super(cyVar);
        this.a = cyVar;
        this.h = new cs(cyVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cu
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        cs csVar = this.h;
        csVar.a = i;
        ((Consumer) obj).accept(csVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        cs csVar = this.h;
        csVar.a = b();
        return csVar;
    }
}
