package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class an extends a implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected an() {
    }

    private Object readResolve() {
        return ao.a;
    }

    public final void clear() {
    }

    public Object clone() {
        return ao.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.am
    public final float o(Object obj) {
        return 0.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
