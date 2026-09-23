package com.google.android.libraries.navigation.internal.agj;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements aj {
    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj, com.google.android.libraries.navigation.internal.agj.ao
    public /* synthetic */ Short a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj
    public /* synthetic */ void b(ag agVar) {
        throw null;
    }

    @Override // java.util.PrimitiveIterator
    public /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        b((ag) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ai.c(this, consumer);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public /* bridge */ /* synthetic */ Object next() {
        return a();
    }
}
