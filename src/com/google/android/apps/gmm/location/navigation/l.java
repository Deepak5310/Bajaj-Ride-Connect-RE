package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.yz.ma;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final long a;
    private final String c = "";
    private final Map b = ma.b;

    public l(long j) {
        this.a = j;
    }

    private static double b(double d, double d2, double d3) {
        return ((d2 - d3) * (1.0d - d)) + ((d2 + d3) * d);
    }

    public final double a(String str, double d, double d2) {
        String str2 = (String) this.b.get(str);
        if (str2 != null) {
            return Double.parseDouble(str2);
        }
        long j = this.a;
        return j == 0 ? d : b(new com.google.android.libraries.navigation.internal.zy.n(new com.google.android.libraries.navigation.internal.zl.ac(j, 1L).b(str, Charset.forName("UTF-8")).c()).doubleValue() / com.google.android.libraries.navigation.internal.zy.n.a.doubleValue(), d, d2);
    }
}
