package com.google.android.libraries.navigation.internal.zl;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements Serializable {
    private static final long serialVersionUID = 0;
    private final String a;
    private final int b;
    private final String c = "Hashing.sha256()";

    public v(String str, int i, String str2) {
        this.a = str;
        this.b = i;
    }

    private Object readResolve() {
        return new w(this.a, this.b, this.c);
    }
}
