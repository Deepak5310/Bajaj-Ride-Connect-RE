package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.agi.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class Cdo implements Map.Entry, dc {
    int a;
    final /* synthetic */ du b;

    public Cdo(du duVar) {
        this.b = duVar;
    }

    public Cdo(du duVar, int i) {
        this.b = duVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dc
    public final long a() {
        return this.b.c[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(this.b.b[this.a], entry.getKey()) && this.b.c[this.a] == ((Long) entry.getValue()).longValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Long.valueOf(this.b.c[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.b.b[this.a];
        return (obj == null ? 0 : obj.hashCode()) ^ com.google.android.libraries.navigation.internal.agc.e.c(this.b.c[this.a]);
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
        du duVar = this.b;
        Object[] objArr = duVar.b;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + duVar.c[i];
    }
}
