package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lx extends fy {
    public final transient Object[] a;
    public final transient int b = 0;
    public final transient int c;
    private final transient fd d;

    public lx(fd fdVar, Object[] objArr, int i, int i2) {
        this.d = fdVar;
        this.a = objArr;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        return d().a(objArr, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return d().iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy
    public final ev k() {
        return new lw(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}
