package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ff extends fl implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ fp a;
    private final fj h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
        this.h = new fj(fpVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fl
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        fj fjVar = this.h;
        fjVar.a = i;
        ((Consumer) obj).accept(fjVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        fj fjVar = this.h;
        fjVar.a = b();
        return fjVar;
    }
}
