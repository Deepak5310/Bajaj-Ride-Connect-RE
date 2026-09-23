package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fd extends fl implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ fp a;
    private fj h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd(fp fpVar) {
        super(fpVar);
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fl
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        fj fjVar = new fj(this.a, i);
        this.h = fjVar;
        ((Consumer) obj).accept(fjVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        fj fjVar = new fj(this.a, b());
        this.h = fjVar;
        return fjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.fl, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
