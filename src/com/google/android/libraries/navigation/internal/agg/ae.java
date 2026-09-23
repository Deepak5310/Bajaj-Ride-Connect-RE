package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae extends am implements gi {
    final /* synthetic */ aq a;
    private ak h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(aq aqVar) {
        super(aqVar);
        this.a = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.am
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ak akVar = new ak(this.a, i);
        this.h = akVar;
        ((Consumer) obj).accept(akVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ak akVar = new ak(this.a, b());
        this.h = akVar;
        return akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.am, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
