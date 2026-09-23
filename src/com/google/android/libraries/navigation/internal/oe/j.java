package com.google.android.libraries.navigation.internal.oe;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j implements Serializable, Comparable {
    public static final j a = new j(0, 0);
    static final long serialVersionUID = 3249100930050580838L;
    public final long b;
    public final long c;

    public j(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    static long c(String str) {
        return com.google.android.libraries.navigation.internal.zy.p.c(str, 16);
    }

    public static j d(String str) {
        com.google.android.libraries.navigation.internal.yx.ar.q(str);
        int iIndexOf = str.indexOf(":");
        if (iIndexOf > 0) {
            com.google.android.libraries.navigation.internal.yx.ar.a(str.length() > 6 && iIndexOf > 2);
            com.google.android.libraries.navigation.internal.yx.ar.a(str.charAt(0) == '0' && str.charAt(1) == 'x');
            com.google.android.libraries.navigation.internal.yx.ar.a(str.charAt(iIndexOf + 1) == '0' && str.charAt(iIndexOf + 2) == 'x');
            return new j(c(str.substring(2, iIndexOf)), c(str.substring(iIndexOf + 3)));
        }
        int length = str.length();
        if (length != 0) {
            int i = str.charAt(0) != '-' ? 0 : 1;
            if (length - i <= 20) {
                while (i < length) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt >= '0' && cCharAt <= '9') {
                        i++;
                    }
                }
                try {
                    return new j(0L, str.indexOf(45) == 0 ? Long.parseLong(str) : com.google.android.libraries.navigation.internal.zy.p.b(str));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.g(str, "malformed cdocid \"", "\""), e);
                }
            }
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.g(str, "malformed feature id \"", "\""));
    }

    public static j e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static boolean g(long j) {
        return j != 0;
    }

    public static boolean h(j jVar) {
        if (jVar == null) {
            return false;
        }
        return g(jVar.c);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j jVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(jVar);
        long j = this.b;
        long j2 = jVar.b;
        if (j < j2) {
            return -1;
        }
        if (j == j2) {
            return Long.compare(this.c, jVar.c);
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.b == jVar.b && this.c == jVar.c;
    }

    public final String f() {
        return "0x" + Long.toHexString(this.b) + ":0x" + Long.toHexString(this.c);
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return (int) (((j >>> 32) ^ (j ^ j2)) ^ (j2 >>> 32));
    }

    public final String toString() {
        return f();
    }
}
