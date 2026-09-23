package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dh extends Cdo implements Iterator {
    protected dh() {
    }

    protected abstract Iterator a();

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    protected /* bridge */ /* synthetic */ Object aF() {
        throw null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return a().hasNext();
    }

    public Object next() {
        return a().next();
    }

    public void remove() {
        a().remove();
    }
}
