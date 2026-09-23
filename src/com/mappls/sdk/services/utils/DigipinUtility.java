package com.mappls.sdk.services.utils;

import com.mappls.sdk.geojson.Point;

/* JADX INFO: loaded from: classes4.dex */
public class DigipinUtility {
    private static final char[][] L = {new char[]{'F', 'C', '9', '8'}, new char[]{'J', '3', '2', '7'}, new char[]{'K', '4', '5', '6'}, new char[]{'L', 'M', 'P', 'T'}};
    private static final int LAT_DIV_BY = 4;
    private static final int LON_DIV_BY = 4;

    public static String getDigipinFromCoordinate(Point point) {
        StringBuilder sb = new StringBuilder();
        double d = 2.5d;
        if (point.latitude() < 2.5d) {
            return "Latitude Out of range";
        }
        double d2 = 38.5d;
        if (point.latitude() > 38.5d) {
            return "Latitude Out of range";
        }
        double d3 = 63.5d;
        if (point.longitude() < 63.5d) {
            return "Longitude Out of range";
        }
        double d4 = 99.5d;
        if (point.longitude() > 99.5d) {
            return "Longitude Out of range";
        }
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (i <= 10) {
            double d5 = (d2 - d) / 4.0d;
            double d6 = (d4 - d3) / 4.0d;
            double d7 = d2 - d5;
            int i4 = 0;
            while (i4 < 4) {
                if (point.latitude() >= d7 && point.latitude() < d2) {
                    i2 = i4;
                    break;
                }
                i4++;
                d2 = d7;
                d7 -= d5;
            }
            double d8 = d3 + d6;
            int i5 = 0;
            while (i5 < 4) {
                if (point.longitude() >= d3 && point.longitude() < d8) {
                    i3 = i5;
                    break;
                }
                i5++;
                double d9 = d8;
                d8 += d6;
                d3 = d9;
            }
            if (i == 1 && L[i2][i3] == '0') {
                return "Out of Bound";
            }
            sb.append(L[i2][i3]);
            if (i == 3 || i == 6) {
                sb.append("-");
            }
            i++;
            d4 = d8;
            d = d7;
        }
        return sb.toString();
    }

    public static Point getCoordinateFromDigipin(String str) {
        boolean z;
        String strReplace = str.replace("-", "");
        if (strReplace.length() != 10) {
            return null;
        }
        double d = 2.5d;
        double d2 = 38.5d;
        double d3 = 63.5d;
        double d4 = 99.5d;
        int i = 0;
        for (int i2 = 10; i < i2; i2 = 10) {
            char cCharAt = strReplace.charAt(i);
            double d5 = (d2 - d) / 4.0d;
            double d6 = (d4 - d3) / 4.0d;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            boolean z2 = false;
            while (true) {
                int i6 = 4;
                if (i5 >= 4) {
                    break;
                }
                int i7 = 0;
                while (true) {
                    if (i7 >= i6) {
                        z = z2;
                        break;
                    }
                    if (L[i5][i7] == cCharAt) {
                        i3 = i5;
                        i4 = i7;
                        z = true;
                        break;
                    }
                    i7++;
                    i6 = 4;
                }
                if (z) {
                    z2 = z;
                    break;
                }
                i5++;
                z2 = z;
            }
            if (!z2) {
                return null;
            }
            double d7 = d2 - (((double) (i3 + 1)) * d5);
            d2 -= d5 * ((double) i3);
            double d8 = (((double) i4) * d6) + d3;
            d4 = (d6 * ((double) (i4 + 1))) + d3;
            i++;
            d3 = d8;
            d = d7;
        }
        return Point.fromLngLat((d3 + d4) / 2.0d, (d + d2) / 2.0d);
    }
}
