package com.google.android.libraries.navigation.internal.abw;

import android.util.LruCache;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends LruCache {
    public a(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        b bVar = (b) obj2;
        b bVar2 = (b) obj3;
        if (bVar == null || bVar2 != null) {
            return;
        }
        bVar.a.delete();
    }
}
