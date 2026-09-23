package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fn extends fl implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ fp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fn(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fl
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
