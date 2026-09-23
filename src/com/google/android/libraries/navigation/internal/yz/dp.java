package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dp extends df implements Queue {
    protected dp() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df
    protected /* bridge */ /* synthetic */ Collection a() {
        throw null;
    }

    protected abstract Queue b();

    @Override // java.util.Queue
    public final Object element() {
        return b().element();
    }

    public boolean offer(Object obj) {
        return b().offer(obj);
    }

    @Override // java.util.Queue
    public final Object peek() {
        return b().peek();
    }

    @Override // java.util.Queue
    public final Object poll() {
        return b().poll();
    }

    @Override // java.util.Queue
    public final Object remove() {
        return b().remove();
    }
}
