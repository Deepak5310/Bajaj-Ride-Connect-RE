package com.google.android.libraries.navigation.internal.nc;

import android.util.LruCache;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends LruCache {
    public g() {
        super(16384);
    }

    @Override // android.util.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        j jVar = new j(((Integer) obj).intValue());
        return new i(new Object[]{jVar}, jVar);
    }
}
