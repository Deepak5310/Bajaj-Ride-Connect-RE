package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class le implements Serializable {
    private static final long serialVersionUID = 0;
    private final Map a;

    public le(Map map) {
        this.a = map;
    }

    Object readResolve() {
        return new lf(this.a);
    }
}
