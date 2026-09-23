package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac extends y implements Set {
    final /* synthetic */ ae f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(ae aeVar, Object obj, Set set) {
        super(aeVar, obj, set, null);
        this.f = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.y, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zK = mp.k((Set) this.b, collection);
        if (zK) {
            int size2 = this.b.size();
            this.f.b += size2 - size;
            c();
        }
        return zK;
    }
}
