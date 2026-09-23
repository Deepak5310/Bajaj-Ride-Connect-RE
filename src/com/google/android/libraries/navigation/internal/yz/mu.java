package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mu implements Iterator {
    final /* synthetic */ Iterator a;
    final /* synthetic */ mw b;

    public mu(mw mwVar, Iterator it2) {
        this.a = it2;
        this.b = mwVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new mv((Map.Entry) this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
        this.b.b();
    }
}
