package com.mappls.sdk.navigation.util;

import androidx.core.view.ViewCompat;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static String a(int i) {
        if ((i & ViewCompat.MEASURED_STATE_MASK) == -16777216) {
            StringBuilder sbA = h.a("#");
            String hexString = Integer.toHexString(i & 16777215);
            while (hexString.length() < 6) {
                hexString = n.a("0", hexString);
            }
            sbA.append(hexString);
            return sbA.toString();
        }
        StringBuilder sbA2 = h.a("#");
        String hexString2 = Integer.toHexString(i);
        while (hexString2.length() < 8) {
            hexString2 = n.a("0", hexString2);
        }
        sbA2.append(hexString2);
        return sbA2.toString();
    }

    public static String a(int i, boolean z) {
        StringBuilder sb;
        String str;
        int i2 = i % 60;
        if (i2 < 10) {
            sb = new StringBuilder("0");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append("");
        }
        String string = sb.toString();
        int i3 = i / 60;
        if (!z && i3 < 60) {
            return i3 + ":" + string;
        }
        int i4 = i3 % 60;
        if (i4 < 10) {
            str = "0" + i4;
        } else {
            str = i4 + "";
        }
        return (i3 / 60) + ":" + str + ":" + string;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static int b(String str) {
        if (str.charAt(0) != '#') {
            throw new IllegalArgumentException(n.a("Unknown color ", str));
        }
        if (str.length() == 4) {
            StringBuilder sbA = h.a("#");
            sbA.append(str.charAt(1));
            sbA.append(str.charAt(1));
            sbA.append(str.charAt(2));
            sbA.append(str.charAt(2));
            sbA.append(str.charAt(3));
            sbA.append(str.charAt(3));
            str = sbA.toString();
        }
        long j = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            j |= -16777216;
        } else if (str.length() != 9) {
            throw new IllegalArgumentException(n.a("Unknown color ", str));
        }
        return (int) j;
    }
}
