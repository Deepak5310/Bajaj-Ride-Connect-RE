package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ay extends d implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ay() {
    }

    private Object readResolve() {
        return az.a;
    }

    public final void clear() {
    }

    public Object clone() {
        return az.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final boolean d(long j) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ax
    public final int s(long j) {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
