package com.google.android.libraries.navigation.internal.abj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static int a(double d) {
        return (int) Math.round(Math.log(Math.tan((Math.toRadians(d) * 0.5d) + 0.7853981633974483d)) * 1.708913188941079E8d);
    }

    public static int b(double d) {
        return (int) Math.round(Math.toRadians(d) * 1.708913188941079E8d);
    }
}
