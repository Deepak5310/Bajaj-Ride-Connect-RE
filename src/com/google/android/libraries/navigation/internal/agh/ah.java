package com.google.android.libraries.navigation.internal.agh;

import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah extends com.google.android.libraries.navigation.internal.age.a {
    final /* synthetic */ ai a;

    public ah(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: a */
    public final com.google.android.libraries.navigation.internal.age.q iterator() {
        return new af(this);
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.age.aa spliterator() {
        return new ag(this, 0, this.a.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    public final boolean e(double d) {
        return this.a.q(d);
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new af(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
