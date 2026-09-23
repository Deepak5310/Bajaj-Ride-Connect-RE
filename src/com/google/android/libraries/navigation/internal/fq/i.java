package com.google.android.libraries.navigation.internal.fq;

import com.google.android.libraries.navigation.internal.agi.em;
import com.google.android.libraries.navigation.internal.agi.ep;
import com.google.android.libraries.navigation.internal.agi.eq;
import com.google.android.libraries.navigation.internal.agi.et;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements Iterator {
    final Iterator a;

    public i(et etVar) {
        this.a = ((eq) etVar.d()).aU();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final j next() {
        ep next = ((em) this.a).next();
        return new j(next.getKey(), next.getValue());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
