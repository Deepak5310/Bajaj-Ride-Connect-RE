package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cz extends dp implements Serializable {
    private static final long serialVersionUID = 0;
    final int a;
    private final Queue b;

    public cz(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.d(true, "maxSize (%s) must >= 0", 10);
        this.b = new ArrayDeque(10);
        this.a = 10;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dp, com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Collection aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        if (size() == 10) {
            this.b.remove();
        }
        this.b.add(obj);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection
    public final boolean addAll(Collection collection) {
        int size = collection.size();
        if (size < 10) {
            return hb.f(this, collection.iterator());
        }
        clear();
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        com.google.android.libraries.navigation.internal.yx.ar.b(true, "number to skip cannot be negative");
        return gs.f(this, new gr(collection, size - 10));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dp
    protected final Queue b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dp, java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }
}
