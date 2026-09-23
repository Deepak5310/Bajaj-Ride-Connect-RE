package com.google.android.libraries.navigation.internal.agf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends n implements Serializable, ai {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ak(ai aiVar) {
        super(aiVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, java.util.Collection, java.util.Set
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return n.d();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, com.google.android.libraries.navigation.internal.agf.l
    public final /* bridge */ /* synthetic */ boolean c(float f) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    public final boolean g(float f) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream parallelStream() {
        super.parallelStream();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.n, com.google.android.libraries.navigation.internal.agf.l
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream stream() {
        super.stream();
        return null;
    }
}
