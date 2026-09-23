package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class am extends a implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected am() {
    }

    private Object readResolve() {
        return an.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final double a() {
        return 0.0d;
    }

    public final void clear() {
    }

    public Object clone() {
        return an.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final boolean e(long j) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.al
    public final double t(long j) {
        return 0.0d;
    }

    public String toString() {
        return "{}";
    }
}
