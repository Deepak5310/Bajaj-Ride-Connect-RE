package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hg extends gh implements Serializable, he {
    private static final long serialVersionUID = -7046029254386353129L;

    public hg(he heVar) {
        super(heVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return gh.f();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf
    public final /* bridge */ /* synthetic */ boolean c(long j) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf
    public final /* bridge */ /* synthetic */ boolean d(gf gfVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf
    @Deprecated
    public final boolean g(long j) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf
    public final /* bridge */ /* synthetic */ long[] k() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream parallelStream() {
        super.parallelStream();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gh, com.google.android.libraries.navigation.internal.agh.gf, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream stream() {
        super.stream();
        return null;
    }
}
