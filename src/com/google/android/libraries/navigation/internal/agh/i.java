package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements dy {
    protected long a;
    protected Object b;

    public i() {
    }

    public i(long j, Object obj) {
        this.a = j;
        this.b = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dy
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dy
    public final /* synthetic */ Long b() {
        throw null;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (obj instanceof dy) {
            dy dyVar = (dy) obj;
            return this.a == dyVar.a() && Objects.equals(this.b, dyVar.getValue());
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        if (key != null && (key instanceof Long)) {
            Object value = entry.getValue();
            if (this.a == ((Long) key).longValue() && Objects.equals(this.b, value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getKey() {
        return dx.a(this);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int iC = com.google.android.libraries.navigation.internal.agc.e.c(this.a);
        Object obj = this.b;
        return iC ^ (obj == null ? 0 : obj.hashCode());
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return this.a + "->" + String.valueOf(this.b);
    }
}
