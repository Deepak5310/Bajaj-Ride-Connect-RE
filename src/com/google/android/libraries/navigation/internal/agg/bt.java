package com.google.android.libraries.navigation.internal.agg;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bt implements Map.Entry, bh {
    int a;
    final /* synthetic */ bz b;

    public bt(bz bzVar) {
        this.b = bzVar;
    }

    public bt(bz bzVar, int i) {
        this.b = bzVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bh
    public final int a() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Integer) entry.getKey()).intValue() && Objects.equals(this.b.b[this.a], entry.getValue());
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
        bz bzVar = this.b;
        int[] iArr = bzVar.a;
        int i = this.a;
        int i2 = iArr[i];
        Object obj = bzVar.b[i];
        return (obj == null ? 0 : obj.hashCode()) ^ i2;
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
        bz bzVar = this.b;
        int[] iArr = bzVar.a;
        int i = this.a;
        return iArr[i] + "=>" + String.valueOf(bzVar.b[i]);
    }
}
