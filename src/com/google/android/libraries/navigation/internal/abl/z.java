package com.google.android.libraries.navigation.internal.abl;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public final long a;
    public final long b;

    public z(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (com.google.android.libraries.navigation.internal.abf.r.a(Long.valueOf(this.a), Long.valueOf(zVar.a))) {
            if (com.google.android.libraries.navigation.internal.abf.r.a(Long.valueOf(this.b), Long.valueOf(zVar.b))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), Long.valueOf(this.b)});
    }
}
