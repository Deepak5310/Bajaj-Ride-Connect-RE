package com.google.android.libraries.navigation.internal.we;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends be {
    public final long a;
    public final int b;
    public final String c;

    public o(long j, int i, String str) {
        this.a = j;
        this.b = i;
        Objects.requireNonNull(str);
        this.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.we.be
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.we.be
    public final long b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.we.be
    public final String c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof be) {
            be beVar = (be) obj;
            if (this.a == beVar.b() && this.b == beVar.a() && this.c.equals(beVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + "}";
    }
}
