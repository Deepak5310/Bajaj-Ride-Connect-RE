package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bq;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class d extends g {
    final int a;
    final long b;
    final double c;

    public d(long j, int i) {
        this.a = g.d(i);
        if (j <= 0) {
            throw new IllegalArgumentException(bq.a("%s (%s) must be > 0", "firstDelayMillis", Long.valueOf(j)));
        }
        this.b = j;
        ar.i(true, "%s (%s) must be > 0", "multiplier", Double.valueOf(2.0d));
        this.c = 2.0d;
    }

    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final long a(int i) {
        if (i == 0) {
            return 0L;
        }
        if (b(i)) {
            return (long) (this.b * Math.pow(2.0d, i - 1));
        }
        return -1L;
    }

    /* JADX WARN: Failed to inline method: com.google.android.libraries.navigation.internal.zo.g.e(int):void */
    /* JADX WARN: Not passed register '(r2v0 'i' int)' in method call: com.google.android.libraries.navigation.internal.zo.g.e(int):void */
    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final boolean b(int i) {
        g.e(i);
        return i < this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.b == dVar.b) {
                double d = dVar.c;
                if (this.a == dVar.a) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Double.valueOf(2.0d)});
    }
}
