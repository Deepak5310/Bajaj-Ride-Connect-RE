package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bl extends c implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected bl() {
    }

    private Object readResolve() {
        return bn.a;
    }

    public final void clear() {
    }

    public Object clone() {
        return bn.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final boolean containsKey(Object obj) {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bk
    public final int o(Object obj) {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
