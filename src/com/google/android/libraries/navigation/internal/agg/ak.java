package com.google.android.libraries.navigation.internal.agg;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ak implements Map.Entry {
    int a;
    final /* synthetic */ aq b;

    public ak(aq aqVar) {
        this.b = aqVar;
    }

    public ak(aq aqVar, int i) {
        this.b = aqVar;
        this.a = i;
    }

    public final int a() {
        return this.b.a[this.a];
    }

    public final int b() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Integer) entry.getKey()).intValue() && this.b.b[this.a] == ((Integer) entry.getValue()).intValue();
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Integer.valueOf(this.b.a[this.a]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Integer.valueOf(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        aq aqVar = this.b;
        int[] iArr = aqVar.a;
        int i = this.a;
        return aqVar.b[i] ^ iArr[i];
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
        aq aqVar = this.b;
        int[] iArr = aqVar.a;
        int i = this.a;
        return iArr[i] + "=>" + aqVar.b[i];
    }
}
