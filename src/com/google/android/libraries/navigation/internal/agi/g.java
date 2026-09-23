package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements dc {
    protected Object a;
    protected long b;

    public g() {
    }

    public g(Object obj, long j) {
        this.a = obj;
        this.b = j;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.dc
    public final long a() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (obj instanceof dc) {
            dc dcVar = (dc) obj;
            return Objects.equals(this.a, dcVar.getKey()) && this.b == dcVar.a();
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && (value instanceof Long) && Objects.equals(this.a, key) && this.b == ((Long) value).longValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Long.valueOf(this.b);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.a;
        return (obj == null ? 0 : obj.hashCode()) ^ com.google.android.libraries.navigation.internal.agc.e.c(this.b);
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return String.valueOf(this.a) + "->" + this.b;
    }
}
