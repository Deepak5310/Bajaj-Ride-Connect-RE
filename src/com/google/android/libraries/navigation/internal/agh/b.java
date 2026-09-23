package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Map.Entry {
    protected long a;
    protected double b;

    public b() {
    }

    public b(long j, double d) {
        this.a = j;
        this.b = d;
    }

    public final double a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Object value;
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.b() && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(bVar.a());
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        return key != null && (key instanceof Long) && (value = entry.getValue()) != null && (value instanceof Double) && this.a == ((Long) key).longValue() && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(((Double) value).doubleValue());
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getKey() {
        return Long.valueOf(this.a);
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Double.valueOf(this.b);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return com.google.android.libraries.navigation.internal.agc.e.c(this.a) ^ com.google.android.libraries.navigation.internal.agc.e.b(this.b);
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return this.a + "->" + this.b;
    }
}
