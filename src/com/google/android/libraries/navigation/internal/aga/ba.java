package com.google.android.libraries.navigation.internal.aga;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba {
    final int a;
    final long b;
    final Set c;

    public ba(int i, long j, Set set) {
        this.a = i;
        this.b = j;
        this.c = fy.o(set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ba baVar = (ba) obj;
            if (this.a == baVar.a && this.b == baVar.b && com.google.android.libraries.navigation.internal.yx.am.a(this.c, baVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), this.c});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarD = com.google.android.libraries.navigation.internal.yx.al.b(this).c("maxAttempts", this.a).d("hedgingDelayNanos", this.b);
        akVarD.g("nonFatalStatusCodes", this.c);
        return akVarD.toString();
    }
}
