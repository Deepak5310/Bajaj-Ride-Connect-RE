package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ke implements Map.Entry {
    int a;
    final /* synthetic */ kk b;

    public ke(kk kkVar) {
        this.b = kkVar;
    }

    public ke(kk kkVar, int i) {
        this.b = kkVar;
        this.a = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == entry.getKey() && this.b.b[this.a] == entry.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        kk kkVar = this.b;
        Object[] objArr = kkVar.a;
        int i = this.a;
        int iIdentityHashCode = System.identityHashCode(objArr[i]);
        Object obj = kkVar.b[i];
        return (obj == null ? 0 : System.identityHashCode(obj)) ^ iIdentityHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object[] objArr = this.b.b;
        int i = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        kk kkVar = this.b;
        Object[] objArr = kkVar.a;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + String.valueOf(kkVar.b[i]);
    }
}
