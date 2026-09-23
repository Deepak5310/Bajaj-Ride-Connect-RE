package com.google.android.libraries.navigation.internal.op;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends g {
    public final long a;

    public a(long j) {
        this.a = j;
    }

    @Override // com.google.android.libraries.navigation.internal.op.g
    public final long a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof g) && this.a == ((g) obj).a();
    }

    public final int hashCode() {
        long j = this.a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public final String toString() {
        return "{" + this.a + "}";
    }
}
