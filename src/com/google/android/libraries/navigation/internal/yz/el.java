package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el extends aj implements Serializable {
    private static final long serialVersionUID = 0;
    final Object a;
    final Object b;

    public el(Object obj, Object obj2) {
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
        throw new UnsupportedOperationException();
    }
}
