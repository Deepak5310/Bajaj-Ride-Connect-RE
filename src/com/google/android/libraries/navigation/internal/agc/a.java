package com.google.android.libraries.navigation.internal.agc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static void a(int i, int i2, int i3) {
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i2, "Start index (", ") is negative"));
        }
        if (i2 > i3) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.k(i3, i2, "Start index (", ") is greater than end index (", ")"));
        }
        if (i3 > i) {
            throw new ArrayIndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.k(i, i3, "End index (", ") is greater than array length (", ")"));
        }
    }

    public static void b(int i, int i2, int i3) {
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i2, "Offset (", ") is negative"));
        }
        if (i3 < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i3, "Length (", ") is negative"));
        }
        if (i3 <= i - i2) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Last index (" + (((long) i2) + ((long) i3)) + ") is greater than array length (" + i + ")");
    }
}
