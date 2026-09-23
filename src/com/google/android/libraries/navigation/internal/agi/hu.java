package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class hu extends x implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected hu() {
    }

    private Object readResolve() {
        return hv.a;
    }

    public final void clear() {
    }

    public Object clone() {
        return hv.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ht
    public final int o(Object obj) {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
