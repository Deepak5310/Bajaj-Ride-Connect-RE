package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eo extends em implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ eq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(eq eqVar) {
        super(eqVar);
        this.a = eqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.em
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
