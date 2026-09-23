package com.mappls.sdk.navigation.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static String a(double d, int i) {
        if (d < -180.0d || d > 180.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("coordinate=" + d);
        }
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("outputType=" + i);
        }
        StringBuilder sb = new StringBuilder();
        if (d < 0.0d) {
            sb.append('-');
            d = -d;
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0.00000", new DecimalFormatSymbols(Locale.US));
        if (i == 1 || i == 2) {
            int iFloor = (int) Math.floor(d);
            sb.append(iFloor);
            sb.append(':');
            d = (d - ((double) iFloor)) * 60.0d;
            if (i == 2) {
                int iFloor2 = (int) Math.floor(d);
                sb.append(iFloor2);
                sb.append(':');
                d = (d - ((double) iFloor2)) * 60.0d;
            }
        }
        sb.append(decimalFormat.format(d));
        return sb.toString();
    }
}
