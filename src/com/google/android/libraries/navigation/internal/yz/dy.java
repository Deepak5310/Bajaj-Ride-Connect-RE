package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dy extends ec {
    public dy(ed edVar) {
        super(edVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ec
    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new dv(this.b, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iE = this.b.e(key);
            if (iE != -1 && com.google.android.libraries.navigation.internal.yx.am.a(this.b.a[iE], value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int iB = eh.b(key);
        int iF = this.b.f(key, iB);
        if (iF == -1 || !com.google.android.libraries.navigation.internal.yx.am.a(this.b.a[iF], value)) {
            return false;
        }
        this.b.k(iF, iB);
        return true;
    }
}
