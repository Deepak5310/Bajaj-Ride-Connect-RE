package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bz extends f implements Serializable {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final bx b;

    protected bz(bx bxVar) {
        this.b = bxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long a() {
        return ((f) this.b).a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long b(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final long c(long j) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    @Deprecated
    public final Long d(Object obj) {
        return bw.a(this.b, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final boolean e(long j) {
        return this.b.e(j);
    }

    public boolean equals(Object obj) {
        return obj == this || this.b.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    @Deprecated
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Deprecated
    public final Long n(Long l, Long l2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Long p(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final int size() {
        return ((cv) this.b).i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bx
    public final long t(long j) {
        return this.b.t(j);
    }

    public final String toString() {
        return this.b.toString();
    }
}
