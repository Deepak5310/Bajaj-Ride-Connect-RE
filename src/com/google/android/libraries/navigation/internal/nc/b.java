package com.google.android.libraries.navigation.internal.nc;

import android.util.LruCache;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends LruCache {
    public b() {
        super(16384);
    }

    @Override // android.util.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        return new k(((Integer) obj).intValue());
    }
}
