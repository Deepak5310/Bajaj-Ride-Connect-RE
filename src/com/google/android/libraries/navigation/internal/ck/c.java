package com.google.android.libraries.navigation.internal.ck;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends ab {
    private final int a;
    private final int b;
    private final cu c;

    public c(int i, int i2, cu cuVar) {
        this.a = i;
        this.b = i2;
        Objects.requireNonNull(cuVar);
        this.c = cuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ab
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ab
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.ab
    public final cu c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ab) {
            ab abVar = (ab) obj;
            if (this.a == abVar.b() && this.b == abVar.a() && this.c.equals(abVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + String.valueOf(this.c) + "}";
    }
}
