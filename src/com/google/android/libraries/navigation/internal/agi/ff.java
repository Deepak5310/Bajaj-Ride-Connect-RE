package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ff extends fk implements gi {
    final /* synthetic */ fo a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff(fo foVar) {
        super(foVar);
        this.a = foVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.fk
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        obj.accept(this.a.a[i]);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.c(consumer);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.a.a[b()];
    }
}
