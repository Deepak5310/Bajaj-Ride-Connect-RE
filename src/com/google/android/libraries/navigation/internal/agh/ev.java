package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ev extends l implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ev() {
    }

    private Object readResolve() {
        return ew.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agh.eu
    public final boolean c(long j) {
        return false;
    }

    public final void clear() {
    }

    public Object clone() {
        return ew.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.eu
    public final Object h(long j) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
