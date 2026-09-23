package com.google.android.libraries.navigation.internal.abf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static String b(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
