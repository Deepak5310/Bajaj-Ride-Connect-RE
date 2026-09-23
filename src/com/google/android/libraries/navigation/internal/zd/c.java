package com.google.android.libraries.navigation.internal.zd;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final c a;
    private static final long e;
    public final int b;
    public final int c;
    public final int d;

    static {
        long jCharAt = 0;
        for (int i = 0; i < 7; i++) {
            jCharAt |= (((long) i) + 1) << ((int) (((long) (" #(+,-0".charAt(i) - ' ')) * 3));
        }
        e = jCharAt;
        a = new c(0, -1, -1);
    }

    public c(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public static int a(char c) {
        return ((int) ((e >>> ((c - ' ') * 3)) & 7)) - 1;
    }

    public static int b(String str, int i, int i2) throws com.google.android.libraries.navigation.internal.zi.e {
        if (i == i2) {
            throw com.google.android.libraries.navigation.internal.zi.e.a("missing precision", str, i - 1);
        }
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            char cCharAt = (char) (str.charAt(i4) - '0');
            if (cCharAt >= '\n') {
                throw com.google.android.libraries.navigation.internal.zi.e.a("invalid precision character", str, i4);
            }
            i3 = (i3 * 10) + cCharAt;
            if (i3 > 999999) {
                throw com.google.android.libraries.navigation.internal.zi.e.b("precision too large", str, i, i2);
            }
        }
        if (i3 != 0) {
            return i3;
        }
        if (i2 == i + 1) {
            return 0;
        }
        throw com.google.android.libraries.navigation.internal.zi.e.b("invalid precision", str, i, i2);
    }

    public final boolean c() {
        return this == a;
    }

    public final boolean d() {
        return (this.b & 128) != 0;
    }

    public final boolean e(int i, boolean z) {
        int i2;
        if (c()) {
            return true;
        }
        int i3 = this.b;
        if (((~i) & i3) != 0) {
            return false;
        }
        if (z || this.d == -1) {
            return ((i3 & 9) == 9 || (i2 = i3 & 96) == 96 || (i2 != 0 && this.c == -1)) ? false : true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.b == this.b && cVar.c == this.c && cVar.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public final void f(StringBuilder sb) {
        if (c()) {
            return;
        }
        int i = this.b;
        int i2 = 0;
        while (true) {
            int i3 = i & (-129);
            int i4 = 1 << i2;
            if (i4 > i3) {
                break;
            }
            if ((i3 & i4) != 0) {
                sb.append(" #(+,-0".charAt(i2));
            }
            i2++;
        }
        int i5 = this.c;
        if (i5 != -1) {
            sb.append(i5);
        }
        if (this.d != -1) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            sb.append(this.d);
        }
    }

    public final int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d;
    }
}
