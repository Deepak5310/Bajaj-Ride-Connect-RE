package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fc extends fk implements gi {
    final /* synthetic */ fo a;
    private fi h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(fo foVar) {
        super(foVar);
        this.a = foVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.fk
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        fi fiVar = new fi(this.a, i);
        this.h = fiVar;
        obj.accept(fiVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        fi fiVar = new fi(this.a, b());
        this.h = fiVar;
        return fiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.fk, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
