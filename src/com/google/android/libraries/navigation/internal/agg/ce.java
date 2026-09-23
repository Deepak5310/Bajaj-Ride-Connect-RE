package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ce extends f implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ce() {
    }

    private Object readResolve() {
        return cf.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agg.cd
    public final boolean c(int i) {
        return false;
    }

    public final void clear() {
    }

    public Object clone() {
        return cf.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cd
    public final Object h(int i) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
