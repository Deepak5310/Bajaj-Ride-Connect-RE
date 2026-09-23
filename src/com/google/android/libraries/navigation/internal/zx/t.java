package com.google.android.libraries.navigation.internal.zx;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final com.google.android.libraries.navigation.internal.yx.s c = com.google.android.libraries.navigation.internal.yx.s.e("-_.*").c(new com.google.android.libraries.navigation.internal.yx.l('0', '9')).c(new com.google.android.libraries.navigation.internal.yx.l('A', 'Z')).c(new com.google.android.libraries.navigation.internal.yx.l('a', 'z'));
    public static final Charset a = StandardCharsets.UTF_8;

    public static String a(String str, Charset charset) {
        if (charset.equals(a)) {
            return o.a.a(str);
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + length);
        boolean z = false;
        int i = 0;
        for (byte b2 : str.getBytes(charset)) {
            int iA = com.google.android.libraries.navigation.internal.zy.m.a(b2);
            char c2 = (char) iA;
            if (c.b(c2)) {
                sb.append(c2);
                i++;
            } else if (iA == 32) {
                sb.append('+');
                i++;
                z = true;
            } else {
                sb.append('%');
                char[] cArr = b;
                sb.append(cArr[iA >> 4]);
                sb.append(cArr[iA & 15]);
                i += 3;
            }
        }
        return (z || i != str.length()) ? sb.toString() : str;
    }
}
