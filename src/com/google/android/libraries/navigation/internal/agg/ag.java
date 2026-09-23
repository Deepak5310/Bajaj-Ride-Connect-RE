package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag extends am implements gi {
    final /* synthetic */ aq a;
    private final ak h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(aq aqVar) {
        super(aqVar);
        this.a = aqVar;
        this.h = new ak(aqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.am
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ak akVar = this.h;
        akVar.a = i;
        ((Consumer) obj).accept(akVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ak akVar = this.h;
        akVar.a = b();
        return akVar;
    }
}
