package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee extends em implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ eq a;
    private ek h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee(eq eqVar) {
        super(eqVar);
        this.a = eqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.em
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ek ekVar = new ek(this.a, i);
        this.h = ekVar;
        ((Consumer) obj).accept(ekVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ek ekVar = new ek(this.a, b());
        this.h = ekVar;
        return ekVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.em, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
