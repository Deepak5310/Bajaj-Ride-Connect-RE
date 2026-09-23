package com.google.android.libraries.navigation.internal.agf;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements v {
    protected final v a;

    public x(v vVar) {
        this.a = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final float a() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final /* synthetic */ Float b() {
        return u.a(this);
    }

    @Override // java.util.PrimitiveIterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void forEachRemaining(s sVar) {
        this.a.forEachRemaining(sVar);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return b();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v, java.util.Iterator
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }
}
