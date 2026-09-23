package com.google.android.libraries.navigation.internal.agg;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba implements Map.Entry, bh {
    int a;
    final /* synthetic */ be b;

    public ba(be beVar) {
        this.b = beVar;
    }

    public ba(be beVar, int i) {
        this.b = beVar;
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
        be beVar = this.b;
        int[] iArr = beVar.a;
        int i = this.a;
        int i2 = iArr[i];
        Object obj = beVar.b[i];
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
        be beVar = this.b;
        int[] iArr = beVar.a;
        int i = this.a;
        return iArr[i] + "=>" + String.valueOf(beVar.b[i]);
    }
}
