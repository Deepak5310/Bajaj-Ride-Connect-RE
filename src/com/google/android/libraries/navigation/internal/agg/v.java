package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class v extends a implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected v() {
    }

    private Object readResolve() {
        return w.a;
    }

    public final void clear() {
    }

    public Object clone() {
        return w.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final boolean d(int i) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.u
    public final int s(int i) {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
