package com.google.android.libraries.navigation.internal.qy;

import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zy.k;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    public static final bj i = bj.e(",");
    public static final bj j = bj.e("&");
    public static final int[] k = new int[0];

    public static int[] j(String str) {
        List listI = i.i(str);
        int size = listI.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            try {
                long j2 = Long.parseLong((String) listI.get(i2), 16);
                if (j2 > 2147483647L) {
                    j2 -= 4294967296L;
                }
                iArr[i2] = (int) k.b(j2, -2147483648L, 2147483647L);
            } catch (NumberFormatException unused) {
                iArr[i2] = 0;
            }
        }
        return iArr;
    }

    public abstract float a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract ev f();

    public abstract String g();

    public abstract boolean h();

    public static URL i(String str) {
        int iLastIndexOf;
        int iIndexOf = str.indexOf(61);
        try {
            if (str.contains("?") || iIndexOf == -1 || (iLastIndexOf = str.lastIndexOf(47, iIndexOf)) == -1) {
                return new URL(str);
            }
            return new URL(str.substring(0, iLastIndexOf) + "?" + str.substring(iLastIndexOf + 1));
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
