package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fx implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;

    public fx(Object[] objArr) {
        this.a = objArr;
    }

    Object readResolve() {
        return fy.p(this.a);
    }
}
