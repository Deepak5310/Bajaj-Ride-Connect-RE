package com.google.android.libraries.navigation.internal.zy;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Serializable {
    public static final g a = new g(new long[0]);
    public final int b;
    private final long[] c;

    public g(long[] jArr) {
        this(jArr, jArr.length);
    }

    public g(long[] jArr, int i) {
        this.c = jArr;
        this.b = i;
    }

    public final long a(int i) {
        ar.p(i, this.b);
        return this.c[i];
    }

    public final boolean b() {
        return this.b == 0;
    }

    public final long[] c() {
        return Arrays.copyOfRange(this.c, 0, this.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.b != gVar.b) {
            return false;
        }
        for (int i = 0; i < this.b; i++) {
            if (a(i) != gVar.a(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.b; i++) {
            iA = (iA * 31) + k.a(this.c[i]);
        }
        return iA;
    }

    Object readResolve() {
        return b() ? a : this;
    }

    public final String toString() {
        if (b()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(this.b * 5);
        sb.append('[');
        sb.append(this.c[0]);
        for (int i = 1; i < this.b; i++) {
            sb.append(", ");
            sb.append(this.c[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    Object writeReplace() {
        return this.b < this.c.length ? new g(c()) : this;
    }
}
