package com.google.android.libraries.navigation.internal.db;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v {
    public static final v a = new v(false, -1, false);
    public final boolean b;
    public final int c;
    public final boolean d;

    public v() {
        this(false, -1, false);
    }

    public v(boolean z, int i, boolean z2) {
        this.b = z;
        this.c = i;
        this.d = z2;
    }

    public final boolean a() {
        return this.c >= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.b == vVar.b && this.c == vVar.c && this.d == vVar.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.b), Integer.valueOf(this.c), Boolean.valueOf(this.d)});
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).e("isGpsAccurate", this.b).c("numSatInFix", this.c).e("mightBeDeadReckoned", this.d).toString();
    }
}
