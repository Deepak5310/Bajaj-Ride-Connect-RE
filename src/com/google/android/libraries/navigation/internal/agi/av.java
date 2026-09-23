package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class av extends com.google.android.libraries.navigation.internal.agf.a {
    final /* synthetic */ bi a;

    public av(bi biVar) {
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final com.google.android.libraries.navigation.internal.agf.v iterator() {
        return new bg(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agf.ao spliterator() {
        return new bh(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    public final boolean e(float f) {
        return this.a.l(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
