package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cp implements Map.Entry {
    int a;
    final /* synthetic */ cv b;

    public cp(cv cvVar) {
        this.b = cvVar;
    }

    public cp(cv cvVar, int i) {
        this.b = cvVar;
        this.a = i;
    }

    public final long a() {
        return this.b.b[this.a];
    }

    public final long b() {
        return this.b.c[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.b[this.a] == ((Long) entry.getKey()).longValue() && this.b.c[this.a] == ((Long) entry.getValue()).longValue();
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Long.valueOf(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Long.valueOf(this.b.c[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        cv cvVar = this.b;
        long[] jArr = cvVar.b;
        int i = this.a;
        return com.google.android.libraries.navigation.internal.agc.e.c(cvVar.c[i]) ^ com.google.android.libraries.navigation.internal.agc.e.c(jArr[i]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        long jLongValue = ((Long) obj).longValue();
        long[] jArr = this.b.c;
        int i = this.a;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    public final String toString() {
        cv cvVar = this.b;
        long[] jArr = cvVar.b;
        int i = this.a;
        return jArr[i] + "=>" + cvVar.c[i];
    }
}
