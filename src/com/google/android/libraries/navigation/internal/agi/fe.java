package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fe extends fk implements gi {
    final /* synthetic */ fo a;
    private final fi h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe(fo foVar) {
        super(foVar);
        this.a = foVar;
        this.h = new fi(foVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.fk
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        fi fiVar = this.h;
        fiVar.a = i;
        obj.accept(fiVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        fi fiVar = this.h;
        fiVar.a = b();
        return fiVar;
    }
}
