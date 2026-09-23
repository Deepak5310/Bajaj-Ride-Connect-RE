package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eg extends em implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ eq a;
    private final ek h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg(eq eqVar) {
        super(eqVar);
        this.a = eqVar;
        this.h = new ek(eqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.em
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ek ekVar = this.h;
        ekVar.a = i;
        ((Consumer) obj).accept(ekVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ek ekVar = this.h;
        ekVar.a = b();
        return ekVar;
    }
}
