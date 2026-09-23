package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ek implements Map.Entry, dy {
    int a;
    final /* synthetic */ eq b;

    public ek(eq eqVar) {
        this.b = eqVar;
    }

    public ek(eq eqVar, int i) {
        this.b = eqVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dy
    public final long a() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    @Deprecated
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getKey() {
        return Long.valueOf(this.b.a[this.a]);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == ((Long) entry.getKey()).longValue() && Objects.equals(this.b.b[this.a], entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        eq eqVar = this.b;
        long[] jArr = eqVar.a;
        int i = this.a;
        int iC = com.google.android.libraries.navigation.internal.agc.e.c(jArr[i]);
        Object obj = eqVar.b[i];
        return (obj == null ? 0 : obj.hashCode()) ^ iC;
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
        eq eqVar = this.b;
        long[] jArr = eqVar.a;
        int i = this.a;
        return jArr[i] + "=>" + String.valueOf(eqVar.b[i]);
    }
}
