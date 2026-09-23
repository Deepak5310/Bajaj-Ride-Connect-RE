package com.google.android.libraries.navigation.internal.ky;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class au {
    public static final au a;
    public static final au b;

    static {
        d(1, Double.valueOf(0.0d));
        a = c(3);
        c(4);
        b = c(5);
    }

    static au c(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        return d(i, null);
    }

    static au d(int i, Double d) {
        if (d == null) {
            d = Double.valueOf(0.0d);
        }
        return new k(i, d.doubleValue());
    }

    public abstract double a();

    public abstract int b();
}
