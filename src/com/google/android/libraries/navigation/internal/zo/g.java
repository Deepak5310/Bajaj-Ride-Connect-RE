package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g implements Serializable {
    public static int d(int i) {
        ar.h(i > 0, "%s (%s) must be > 0", "numAttempts", i);
        return Math.min(i, 131072);
    }

    @Deprecated
    public abstract long a(int i);

    public boolean b(int i) {
        return a(i) >= 0;
    }

    @Deprecated
    public long c(int i, long j) {
        if (b(i)) {
            return a(i);
        }
        return -1L;
    }
}
