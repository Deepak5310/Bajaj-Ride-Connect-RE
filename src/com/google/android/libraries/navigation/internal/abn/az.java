package com.google.android.libraries.navigation.internal.abn;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az {
    public static final az a = new az(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public az(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        return this.b == azVar.b && this.c == azVar.c && this.d == azVar.d && this.e == azVar.e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).c("left", this.b).c("top", this.c).c("right", this.d).c("bottom", this.e).toString();
    }
}
