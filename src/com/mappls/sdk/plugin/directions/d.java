package com.mappls.sdk.plugin.directions;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    private static Map a = new HashMap();

    /* JADX WARN: Code duplicated, block: B:12:0x0033 A[PHI: r11
      0x0033: PHI (r11v12 double) = (r11v3 double), (r11v1 double) binds: [B:17:0x0063, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:15:0x0049 A[PHI: r11
      0x0049: PHI (r11v4 double) = (r11v3 double), (r11v1 double) binds: [B:17:0x0063, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(double d, SpeedUnitType speedUnitType) {
        a.C0108a c0108aA;
        if (a.isEmpty()) {
            a.put("kilometer per hour", "km/h");
            a.put("miles per hour", "mph");
        }
        SpeedUnitType speedUnitType2 = SpeedUnitType.KILOMETERS_PER_HOUR;
        String str = speedUnitType == speedUnitType2 ? "kilometer per hour" : "miles per hour";
        double d2 = d * 3.5999999046325684d;
        if (speedUnitType != speedUnitType2) {
            d2 = (d2 * 1000.0d) / 1609.343994140625d;
            if (d2 >= 20.0d) {
                c0108aA = a.a(Math.round(d2), (String) a.get(str), false, 0);
            } else {
                c0108aA = a.a(Math.round(d2 * 10.0d) / 10.0f, str, true, 1);
            }
        } else if (d2 >= 20.0d) {
            c0108aA = a.a(Math.round(d2), (String) a.get(str), false, 0);
        } else {
            c0108aA = a.a(Math.round(d2 * 10.0d) / 10.0f, str, true, 1);
        }
        return c0108aA.a();
    }
}
