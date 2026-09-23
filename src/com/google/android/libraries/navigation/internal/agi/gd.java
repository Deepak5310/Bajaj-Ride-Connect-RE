package com.google.android.libraries.navigation.internal.agi;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gd {
    public static final Object[] a = new Object[0];
    public static final Object[] b = new Object[0];

    public static void a(Object[] objArr, int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.b(objArr.length, i, i2);
    }

    public static void b(Object[] objArr) {
        d(objArr, objArr.length);
    }

    public static void c(Object[] objArr, Comparator comparator) {
        e(objArr, objArr.length, comparator);
    }

    public static void d(Object[] objArr, int i) {
        Arrays.sort(objArr, 0, i);
    }

    public static void e(Object[] objArr, int i, Comparator comparator) {
        Arrays.sort(objArr, 0, i, comparator);
    }
}
