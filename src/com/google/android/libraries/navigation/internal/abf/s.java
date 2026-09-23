package com.google.android.libraries.navigation.internal.abf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void c(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void d(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void e(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void f(float f, Object obj) {
        if (f < -90.0f || f > 90.0f) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void h(double d, Object obj) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void i(float f, Object obj) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void j(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void k(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(obj2));
        }
    }

    public static void l(double d, Object obj) {
        if (d == 0.0d) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void g(int i, int i2, int i3, Object obj) {
        if (i2 > i3) {
            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.k(i3, i2, "Invalid interval [", ",", "]"));
        }
        if (i < i2 || i3 < i) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
}
