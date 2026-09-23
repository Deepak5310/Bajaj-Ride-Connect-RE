package com.google.android.libraries.navigation.internal.age;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends m implements Serializable, u {
    private static final long serialVersionUID = -7046029254386353129L;

    protected w(u uVar) {
        super(uVar);
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, java.util.Collection
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return m.d();
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, com.google.android.libraries.navigation.internal.age.k
    public final /* bridge */ /* synthetic */ boolean c(double d) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public final boolean g(double d) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream parallelStream() {
        super.parallelStream();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.age.m, com.google.android.libraries.navigation.internal.age.k
    @Deprecated
    public final /* bridge */ /* synthetic */ Stream stream() {
        super.stream();
        return null;
    }
}
