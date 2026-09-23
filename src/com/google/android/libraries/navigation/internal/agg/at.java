package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class at extends c implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected at() {
    }

    private Object readResolve() {
        return au.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agg.as
    public final boolean c(int i) {
        return false;
    }

    public final void clear() {
    }

    public Object clone() {
        return au.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.as
    public final Object p(int i) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.c, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
