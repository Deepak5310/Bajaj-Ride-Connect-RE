package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jh implements Map.Entry {
    int a;
    final /* synthetic */ jn b;

    public jh(jn jnVar) {
        this.b = jnVar;
    }

    public jh(jn jnVar, int i) {
        this.b = jnVar;
        this.a = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.b.a[this.a] == entry.getKey() && Objects.equals(this.b.b[this.a], entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        jn jnVar = this.b;
        Object[] objArr = jnVar.a;
        int i = this.a;
        int iIdentityHashCode = System.identityHashCode(objArr[i]);
        Object obj = jnVar.b[i];
        return (obj == null ? 0 : obj.hashCode()) ^ iIdentityHashCode;
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
        jn jnVar = this.b;
        Object[] objArr = jnVar.a;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + String.valueOf(jnVar.b[i]);
    }
}
