package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fi implements Map.Entry, ew {
    int a;
    final /* synthetic */ fo b;

    public fi(fo foVar) {
        this.b = foVar;
    }

    public fi(fo foVar, int i) {
        this.b = foVar;
        this.a = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(this.b.a[this.a], entry.getKey()) && Objects.equals(this.b.b[this.a], entry.getValue());
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
        Object obj = this.b.a[this.a];
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b.b[this.a];
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
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
        fo foVar = this.b;
        Object[] objArr = foVar.a;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + String.valueOf(foVar.b[i]);
    }
}
