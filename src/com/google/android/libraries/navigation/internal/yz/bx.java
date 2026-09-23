package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bx extends AbstractSet {
    final /* synthetic */ cc a;

    public bx(cc ccVar) {
        this.a = ccVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapN = this.a.n();
        if (mapN != null) {
            return mapN.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iF = this.a.f(entry.getKey());
            if (iF != -1 && com.google.android.libraries.navigation.internal.yx.am.a(this.a.j(iF), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.a.k();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapN = this.a.n();
        if (mapN != null) {
            return mapN.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        cc ccVar = this.a;
        if (ccVar.u()) {
            return false;
        }
        int iE = ccVar.e();
        Object key = entry.getKey();
        Object value = entry.getValue();
        cc ccVar2 = this.a;
        int iD = cf.d(key, value, iE, ccVar2.i(), ccVar2.v(), ccVar2.w(), ccVar2.x());
        if (iD == -1) {
            return false;
        }
        this.a.r(iD, iE);
        cc ccVar3 = this.a;
        ccVar3.f--;
        ccVar3.o();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
