package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jj extends aj {
    final Object a;
    Object b;
    final /* synthetic */ jk c;

    public jj(jk jkVar, Object obj, Object obj2) {
        this.c = jkVar;
        this.a = obj;
        this.b = obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.a.equals(entry.getKey()) && this.b.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object objPut = this.c.put(this.a, obj);
        this.b = obj;
        return objPut;
    }
}
