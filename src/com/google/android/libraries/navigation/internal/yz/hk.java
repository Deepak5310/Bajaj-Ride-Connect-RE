package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hk extends aj {
    final Object a;
    Object b;
    hk c;
    hk d;
    hk e;
    hk f;

    public hk(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
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
    public final Object setValue(Object obj) {
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }
}
