package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fj implements Map.Entry {
    int a;
    final /* synthetic */ fp b;

    public fj(fp fpVar) {
        this.b = fpVar;
    }

    public fj(fp fpVar, int i) {
        this.b = fpVar;
        this.a = i;
    }

    public final long a() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Long) entry.getKey()).longValue() && this.b.b[this.a] == entry.getValue();
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Long.valueOf(this.b.a[this.a]);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        fp fpVar = this.b;
        long[] jArr = fpVar.a;
        int i = this.a;
        int iC = com.google.android.libraries.navigation.internal.agc.e.c(jArr[i]);
        Object obj = fpVar.b[i];
        return (obj == null ? 0 : System.identityHashCode(obj)) ^ iC;
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
        fp fpVar = this.b;
        long[] jArr = fpVar.a;
        int i = this.a;
        return jArr[i] + "=>" + String.valueOf(fpVar.b[i]);
    }
}
