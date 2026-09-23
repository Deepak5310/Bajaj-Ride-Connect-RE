package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bo implements Map.Entry {
    int a;
    final /* synthetic */ bu b;

    public bo(bu buVar) {
        this.b = buVar;
    }

    public bo(bu buVar, int i) {
        this.b = buVar;
        this.a = i;
    }

    public final int a() {
        return this.b.b[this.a];
    }

    public final long b() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Long) entry.getKey()).longValue() && this.b.b[this.a] == ((Integer) entry.getValue()).intValue();
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Long.valueOf(this.b.a[this.a]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Integer.valueOf(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        bu buVar = this.b;
        long[] jArr = buVar.a;
        int i = this.a;
        return buVar.b[i] ^ com.google.android.libraries.navigation.internal.agc.e.c(jArr[i]);
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
        bu buVar = this.b;
        long[] jArr = buVar.a;
        int i = this.a;
        return jArr[i] + "=>" + buVar.b[i];
    }
}
