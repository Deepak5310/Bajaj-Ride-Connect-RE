package com.google.android.libraries.navigation.internal.agh;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dq implements Map.Entry, dy {
    int a;
    final /* synthetic */ du b;

    public dq(du duVar) {
        this.b = duVar;
    }

    public dq(du duVar, int i) {
        this.b = duVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dy
    public final long a() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    @Deprecated
    /* JADX INFO: renamed from: b */
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
        du duVar = this.b;
        long[] jArr = duVar.a;
        int i = this.a;
        int iC = com.google.android.libraries.navigation.internal.agc.e.c(jArr[i]);
        Object obj = duVar.b[i];
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
        du duVar = this.b;
        long[] jArr = duVar.a;
        int i = this.a;
        return jArr[i] + "=>" + String.valueOf(duVar.b[i]);
    }
}
