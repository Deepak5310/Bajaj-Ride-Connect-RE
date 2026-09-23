package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ik implements Map.Entry {
    int a;
    final /* synthetic */ iq b;

    public ik(iq iqVar) {
        this.b = iqVar;
    }

    public ik(iq iqVar, int i) {
        this.b = iqVar;
        this.a = i;
    }

    public final int a() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == entry.getKey() && this.b.b[this.a] == ((Integer) entry.getValue()).intValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Integer.valueOf(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        iq iqVar = this.b;
        Object[] objArr = iqVar.a;
        int i = this.a;
        return iqVar.b[i] ^ System.identityHashCode(objArr[i]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        int[] iArr = this.b.b;
        int i = this.a;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    public final String toString() {
        iq iqVar = this.b;
        Object[] objArr = iqVar.a;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + iqVar.b[i];
    }
}
