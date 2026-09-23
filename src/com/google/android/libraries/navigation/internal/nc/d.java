package com.google.android.libraries.navigation.internal.nc;

import android.util.LruCache;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends LruCache {
    public d() {
        super(256);
    }

    @Override // android.util.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        return new u(((Integer) obj).intValue());
    }
}
