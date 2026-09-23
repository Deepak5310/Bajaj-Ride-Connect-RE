package com.google.android.libraries.navigation.internal.aga;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee {
    final int a;
    final long b;
    final long c;
    final double d;
    final Long e;
    final Set f;

    public ee(int i, long j, long j2, double d, Long l, Set set) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = d;
        this.e = l;
        this.f = fy.o(set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ee)) {
            return false;
        }
        ee eeVar = (ee) obj;
        return this.a == eeVar.a && this.b == eeVar.b && this.c == eeVar.c && Double.compare(this.d, eeVar.d) == 0 && com.google.android.libraries.navigation.internal.yx.am.a(this.e, eeVar.e) && com.google.android.libraries.navigation.internal.yx.am.a(this.f, eeVar.f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Double.valueOf(this.d), this.e, this.f});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarA = com.google.android.libraries.navigation.internal.yx.al.b(this).c("maxAttempts", this.a).d("initialBackoffNanos", this.b).d("maxBackoffNanos", this.c).a("backoffMultiplier", this.d);
        akVarA.g("perAttemptRecvTimeoutNanos", this.e);
        akVarA.g("retryableStatusCodes", this.f);
        return akVarA.toString();
    }
}
