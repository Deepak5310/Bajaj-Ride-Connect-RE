package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fc extends dq implements Serializable, ez {
    private static final long serialVersionUID = -7046029254386353129L;

    public fc(ez ezVar) {
        super(ezVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return dq.d();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, com.google.android.libraries.navigation.internal.agg.Cdo, com.google.android.libraries.navigation.internal.agg.es
    public final /* bridge */ /* synthetic */ boolean c(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, com.google.android.libraries.navigation.internal.agg.Cdo
    public final /* bridge */ /* synthetic */ boolean e(Cdo cdo) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, com.google.android.libraries.navigation.internal.agg.Cdo
    @Deprecated
    public final boolean h(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, com.google.android.libraries.navigation.internal.agg.Cdo, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream parallelStream() {
        super.parallelStream();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dq, com.google.android.libraries.navigation.internal.agg.Cdo, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream stream() {
        super.stream();
        return null;
    }
}
