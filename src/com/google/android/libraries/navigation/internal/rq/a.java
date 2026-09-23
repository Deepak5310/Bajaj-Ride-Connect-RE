package com.google.android.libraries.navigation.internal.rq;

import com.google.android.libraries.navigation.internal.zy.p;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Comparable, Serializable {
    public static final a a = new a(-1);
    public static final a b = a(new long[0]);
    private final long c;

    private a(long j) {
        this.c = j;
    }

    public static a a(long... jArr) {
        long j = 0;
        for (int i = 0; i < jArr.length; i = 1) {
            j |= 1 << ((int) jArr[0]);
        }
        return new a(j);
    }

    public final boolean b(long j) {
        return ((1 << ((int) j)) & this.c) != 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return p.a(this.c, ((a) obj).c);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).c == this.c;
    }

    public final int hashCode() {
        long j = this.c;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean z = true;
        for (long j = 0; j <= 63; j++) {
            if (b(j)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(j);
                z = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
