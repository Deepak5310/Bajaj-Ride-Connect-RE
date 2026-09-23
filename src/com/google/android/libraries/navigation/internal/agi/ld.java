package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ld extends kz implements Serializable, lb {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ld(lb lbVar) {
        super(lbVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kz, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kz, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kz, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kz, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.kz, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }
}
