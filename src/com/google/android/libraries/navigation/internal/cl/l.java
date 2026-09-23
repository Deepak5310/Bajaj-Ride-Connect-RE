package com.google.android.libraries.navigation.internal.cl;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends af {
    private final String a;
    private final int b;
    private final int c;

    public l(String str, int i, int i2) {
        Objects.requireNonNull(str);
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.af
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.af
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.af
    public final String c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof af) {
            af afVar = (af) obj;
            if (this.a.equals(afVar.c()) && this.b == afVar.b() && this.c == afVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + "}";
    }
}
