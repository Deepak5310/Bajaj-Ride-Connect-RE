package com.google.android.libraries.navigation.internal.agd;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements al {
    protected b() {
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al, com.google.android.libraries.navigation.internal.agd.aq
    public /* synthetic */ Byte a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    public /* synthetic */ void b(ai aiVar) {
        throw null;
    }

    @Override // java.util.PrimitiveIterator
    public /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        b((ai) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ak.d(this, consumer);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public /* bridge */ /* synthetic */ Object next() {
        return a();
    }
}
