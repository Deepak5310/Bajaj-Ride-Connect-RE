package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jy extends kg implements gi {
    final /* synthetic */ kk a;
    private ke h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jy(kk kkVar) {
        super(kkVar);
        this.a = kkVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.kg
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ke keVar = new ke(this.a, i);
        this.h = keVar;
        obj.accept(keVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ke keVar = new ke(this.a, b());
        this.h = keVar;
        return keVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kg, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
