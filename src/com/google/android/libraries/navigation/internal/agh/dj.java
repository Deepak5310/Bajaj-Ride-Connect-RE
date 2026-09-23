package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class dj extends h implements Serializable, Cloneable {
    private static final long serialVersionUID = -7046029254386353129L;

    protected dj() {
    }

    private Object readResolve() {
        return dk.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.di
    public final Object aO(long j) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agh.di
    public final boolean c(long j) {
        return false;
    }

    public final void clear() {
    }

    public Object clone() {
        return dk.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof com.google.android.libraries.navigation.internal.agc.d) && ((com.google.android.libraries.navigation.internal.agc.d) obj).size() == 0;
    }

    public int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return 0;
    }

    public String toString() {
        return "{}";
    }
}
