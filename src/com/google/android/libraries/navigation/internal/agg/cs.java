package com.google.android.libraries.navigation.internal.agg;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cs implements Map.Entry {
    int a;
    final /* synthetic */ cy b;

    public cs(cy cyVar) {
        this.b = cyVar;
    }

    public cs(cy cyVar, int i) {
        this.b = cyVar;
        this.a = i;
    }

    public final int a() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Integer) entry.getKey()).intValue() && this.b.b[this.a] == entry.getValue();
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Integer.valueOf(this.b.a[this.a]);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        cy cyVar = this.b;
        int[] iArr = cyVar.a;
        int i = this.a;
        int i2 = iArr[i];
        Object obj = cyVar.b[i];
        return (obj == null ? 0 : System.identityHashCode(obj)) ^ i2;
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
        cy cyVar = this.b;
        int[] iArr = cyVar.a;
        int i = this.a;
        return iArr[i] + "=>" + String.valueOf(cyVar.b[i]);
    }
}
