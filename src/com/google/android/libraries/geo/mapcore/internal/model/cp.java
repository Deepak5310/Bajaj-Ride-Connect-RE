package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cp implements Iterator {
    private final List a;
    private int b = 0;

    public cp(List list) {
        this.a = list;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final br next() {
        int i = this.b;
        this.b = i + 1;
        return (br) this.a.get(i);
    }

    public final br b() {
        return (br) this.a.get(this.b);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.a.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("remove() not supported");
    }
}
