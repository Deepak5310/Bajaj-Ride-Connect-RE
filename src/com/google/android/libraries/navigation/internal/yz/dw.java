package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dw extends ec {
    final /* synthetic */ ed a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw(ed edVar) {
        super(edVar);
        this.a = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ec
    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new du(this.a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iB = this.a.b(key);
            if (iB != -1 && com.google.android.libraries.navigation.internal.yx.am.a(value, this.a.b[iB])) {
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
        int iC = this.a.c(key, iB);
        if (iC == -1 || !com.google.android.libraries.navigation.internal.yx.am.a(value, this.a.b[iC])) {
            return false;
        }
        this.a.j(iC, iB);
        return true;
    }
}
