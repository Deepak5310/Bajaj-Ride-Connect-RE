package com.google.android.libraries.navigation.internal.yx;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, Character.valueOf(c)));
        }
    }

    public static void d(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, Integer.valueOf(i)));
        }
    }

    public static void e(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, Long.valueOf(j)));
        }
    }

    public static void f(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, obj));
        }
    }

    public static void g(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void h(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, obj, Integer.valueOf(i)));
        }
    }

    public static void i(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(bq.a(str, obj, obj2));
        }
    }

    public static void j(int i, int i2, int i3) {
        String strV;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strV = v(i, i3, "start index");
            } else {
                strV = (i2 < 0 || i2 > i3) ? v(i2, i3, "end index") : bq.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strV);
        }
    }

    public static void k(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void l(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(bq.a(str, Integer.valueOf(i)));
        }
    }

    public static void n(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(bq.a(str, Long.valueOf(j)));
        }
    }

    public static void o(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(bq.a(str, obj));
        }
    }

    public static void p(int i, int i2) {
        String strA;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strA = bq.a("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
            } else {
                if (i2 < 0) {
                    throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i2, "negative size: "));
                }
                strA = bq.a("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void q(Object obj) {
        obj.getClass();
    }

    public static void r(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(obj2));
        }
    }

    public static void s(Object obj, String str, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(bq.a(str, obj2));
        }
    }

    public static void t(Object obj, String str, Object obj2, Object obj3) {
        if (obj == null) {
            throw new NullPointerException(bq.a(str, obj2, obj3));
        }
    }

    public static void u(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(v(i, i2, FirebaseAnalytics.Param.INDEX));
        }
    }

    private static String v(int i, int i2, String str) {
        if (i < 0) {
            return bq.a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return bq.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i2, "negative size: "));
    }
}
