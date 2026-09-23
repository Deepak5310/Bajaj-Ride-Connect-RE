package com.google.android.libraries.navigation.internal.zl;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends b implements Serializable {
    public static final m a = new y(0);
    private static final long serialVersionUID = 0;
    private final int b = 0;

    public y(int i) {
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final n e() {
        return new x(0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        int i = ((y) obj).b;
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode();
    }

    public final String toString() {
        return "Hashing.murmur3_128(0)";
    }
}
