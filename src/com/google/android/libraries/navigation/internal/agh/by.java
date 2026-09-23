package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class by extends f implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected by() {
    }

    private Object readResolve() {
        return ca.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long a() {
        return 0L;
    }

    public final void clear() {
    }

    public Object clone() {
        return ca.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final boolean e(long j) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bx
    public final long t(long j) {
        return 0L;
    }

    public String toString() {
        return "{}";
    }
}
