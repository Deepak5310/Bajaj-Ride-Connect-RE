package com.mappls.sdk.plugin.directions;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfConversion;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    private static Map a = new HashMap();

    /* JADX INFO: renamed from: com.mappls.sdk.plugin.directions.a$a, reason: collision with other inner class name */
    public static class C0108a {
        public final String a;
        public final String b;
        private final boolean c;

        public C0108a(String str, String str2) {
            this(str, str2, true);
        }

        public String a() {
            return this.c ? new MessageFormat("{0} {1}").format(new Object[]{this.a, this.b}) : new MessageFormat("{0}{1}").format(new Object[]{this.a, this.b});
        }

        public C0108a(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4  */
    public static SpannableString a(double d, DistanceType distanceType, boolean z, float f, ForegroundColorSpan foregroundColorSpan) {
        int i;
        String strA;
        boolean zIsEmpty = a.isEmpty();
        String str = TurfConstants.UNIT_YARDS;
        String str2 = TurfConstants.UNIT_MILES;
        if (zIsEmpty) {
            a.put("kilometers", "km");
            a.put(TurfConstants.UNIT_METERS, "m");
            a.put(TurfConstants.UNIT_MILES, "mi");
            a.put(TurfConstants.UNIT_YARDS, "yd");
        }
        DistanceType distanceType2 = DistanceType.METRIC;
        if (distanceType == distanceType2) {
            str2 = "kilometers";
        }
        if (distanceType == distanceType2) {
            str = TurfConstants.UNIT_METERS;
        }
        double dConvertLength = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str);
        double dConvertLength2 = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str2);
        int i2 = 0;
        if (dConvertLength2 > 10.0d) {
            strA = dConvertLength2 >= 1000.0d ? String.format("%,d", Long.valueOf((long) dConvertLength2)) : b(dConvertLength2, i2);
        } else if (dConvertLength2 >= 1.0d) {
            if (dConvertLength <= 9500.0d) {
                i2 = 1;
            }
        } else if (distanceType == distanceType2) {
            if (dConvertLength >= 975.0d) {
                if (d <= 10000.0d) {
                    i2 = 1;
                }
                strA = b(1.0d, i2);
            } else {
                if (dConvertLength > 300.0d) {
                    i = 50;
                } else if (dConvertLength > 100.0d) {
                    i = 10;
                } else {
                    i = 5;
                }
                strA = a(dConvertLength, i);
                str2 = str;
            }
        } else if (dConvertLength >= 1750.0d) {
            if (dConvertLength <= 17600.0d) {
                i2 = 1;
            }
            strA = b(1.0d, i2);
        } else {
            if (dConvertLength > 527.0d) {
                i = 50;
            } else if (dConvertLength > 175.0d) {
                i = 10;
            } else {
                i = 5;
            }
            strA = a(dConvertLength, i);
            str2 = str;
        }
        return a(strA, str2, z, f, foregroundColorSpan);
    }

    private static String b(double d, int i) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.getDefault());
        numberInstance.setMaximumFractionDigits(i);
        return numberInstance.format(d);
    }

    public static C0108a a(float f, String str, boolean z, int i) {
        String str2;
        if (i > 0) {
            char[] cArr = new char[i];
            Arrays.fill(cArr, z ? '0' : '#');
            str2 = "0." + String.valueOf(cArr);
        } else {
            str2 = "0";
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setGroupingSeparator(' ');
        DecimalFormat decimalFormat = new DecimalFormat(str2);
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        if (Math.abs(f) >= 10000.0f) {
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
        }
        MessageFormat messageFormat = new MessageFormat("{0}");
        messageFormat.setFormatByArgumentIndex(0, decimalFormat);
        return new C0108a(messageFormat.format(new Object[]{Float.valueOf(f)}).replace('\n', ' '), (String) a.get(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SpannableString a(String str, String str2, boolean z, float f, ForegroundColorSpan foregroundColorSpan) {
        String str3 = (z || foregroundColorSpan == null) ? "%s %s" : "%s%s";
        if (!z) {
            str2 = a.get(str2);
        }
        SpannableString spannableString = new SpannableString(String.format(str3, str, str2));
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(f), str.length(), spannableString.length(), 33);
        if (foregroundColorSpan != null) {
            spannableString.setSpan(foregroundColorSpan, str.length(), spannableString.length(), 33);
        }
        return spannableString;
    }

    public static C0108a a(double d, boolean z, DistanceType distanceType) {
        boolean zIsEmpty = a.isEmpty();
        String str = TurfConstants.UNIT_YARDS;
        String str2 = TurfConstants.UNIT_MILES;
        if (zIsEmpty) {
            a.put("kilometers", "km");
            a.put(TurfConstants.UNIT_METERS, "m");
            a.put(TurfConstants.UNIT_MILES, "mi");
            a.put(TurfConstants.UNIT_YARDS, "yd");
        }
        DistanceType distanceType2 = DistanceType.METRIC;
        if (distanceType == distanceType2) {
            str2 = "kilometers";
        }
        if (distanceType == distanceType2) {
            str = TurfConstants.UNIT_METERS;
        }
        double dConvertLength = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str);
        double dConvertLength2 = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str2);
        if (distanceType == distanceType2) {
            if (dConvertLength2 >= 100.0d) {
                return a((float) (dConvertLength2 + 0.5d), str2, z, 0);
            }
            if (dConvertLength2 >= 10.0d) {
                return a((float) dConvertLength2, str2, z, 1);
            }
            return dConvertLength2 >= 1.0d ? a((float) dConvertLength2, str2, z, 2) : a((float) (dConvertLength + 0.5d), str, z, 0);
        }
        if (dConvertLength2 >= 100.0d) {
            return a((float) (dConvertLength2 + 0.5d), str2, z, 0);
        }
        if (dConvertLength2 >= 10.0d) {
            return a((float) dConvertLength2, str2, z, 1);
        }
        return dConvertLength2 >= 1.0d ? a((float) dConvertLength2, str2, z, 2) : a((float) (dConvertLength + 0.5d), str, z, 0);
    }

    private static String a(double d, int i) {
        return String.valueOf(Math.max(((int) Math.round(d / ((double) i))) * i, i));
    }
}
