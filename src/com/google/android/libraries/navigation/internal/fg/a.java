package com.google.android.libraries.navigation.internal.fg;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final long a;
    public final int b;
    private final int c;

    public a(int i, int i2, long j) {
        this.b = i;
        this.c = i2;
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.c == aVar.c && this.a == aVar.a && this.b == aVar.b;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.c), Long.valueOf(this.a), Integer.valueOf(this.b));
    }
}
