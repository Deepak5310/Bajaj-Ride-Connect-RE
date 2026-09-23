package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class em implements Serializable {
    private static final long serialVersionUID = 0;
    final EnumMap a;

    public em(EnumMap enumMap) {
        this.a = enumMap;
    }

    Object readResolve() {
        return new en(this.a);
    }
}
