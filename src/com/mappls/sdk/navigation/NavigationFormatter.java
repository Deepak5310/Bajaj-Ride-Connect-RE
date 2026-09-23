package com.mappls.sdk.navigation;

import android.content.Context;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationFormatter {
    private static final char DELIMITER_DEGREES = 176;
    private static final char DELIMITER_MINUTES = 8242;
    private static final char DELIMITER_SECONDS = 8243;
    private static final char EAST = 'E';
    public static final float FEET_IN_ONE_METER = 3.2808f;
    public static final int FORMAT_DEGREES = 0;
    public static final int FORMAT_DEGREES_SHORT = 8;
    public static final int FORMAT_MINUTES = 1;
    public static final int FORMAT_SECONDS = 2;
    public static final float METERS_IN_KILOMETER = 1000.0f;
    public static final float METERS_IN_ONE_MILE = 1609.344f;
    public static final float METERS_IN_ONE_NAUTICALMILE = 1852.0f;
    public static final int MGRS_FORMAT = 5;
    public static final float MILS_IN_DEGREE = 17.777779f;
    private static final int MIN_DURATION_FOR_DATE_FORMAT = 172800;
    private static final char NORTH = 'N';
    public static final int OLC_FORMAT = 4;
    private static final char SOUTH = 'S';
    public static final int SWISS_GRID_FORMAT = 6;
    public static final int SWISS_GRID_PLUS_FORMAT = 7;
    public static final int UTM_FORMAT = 3;
    private static final char WEST = 'W';
    public static final float YARDS_IN_ONE_METER = 1.0936f;
    private static final DecimalFormat fixed1;
    private static final DecimalFormat fixed2;
    private static b fullTimeFormatter;
    private static b shortTimeFormatter;
    private static boolean twelveHoursFormat;

    public static class a {
        public final String a;
        public final String b;
        private final boolean c;

        public a(String str, String str2, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = z;
        }

        public final String a(Context context) {
            return this.c ? context.getString(R.string.mappls_ltr_or_rtl_combine_via_space, this.a, this.b) : new MessageFormat("{0}{1}").format(new Object[]{this.a, this.b});
        }
    }

    private static class b {
        private final SimpleDateFormat a;
        private final SimpleDateFormat b;

        public b(Locale locale, String str, String str2) {
            this.a = new SimpleDateFormat(str, locale);
            this.b = new SimpleDateFormat(str2, locale);
        }

        public final String a(Date date, boolean z) {
            return (z ? this.b : this.a).format(date);
        }
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        fixed2 = decimalFormat;
        DecimalFormat decimalFormat2 = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);
        fixed1 = decimalFormat2;
        setTwelveHoursFormatting(false, Locale.getDefault());
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat2.setMinimumFractionDigits(1);
        decimalFormat2.setMinimumIntegerDigits(1);
        decimalFormat.setMinimumIntegerDigits(1);
    }

    private static void addPoiString(String str, String str2, List<String> list) {
        if (str != null && str2.contains(str)) {
            list.add(str2);
        }
        if (str2.length() == 0) {
            list.add(str);
        }
        list.add(str + StringUtils.SPACE + str2);
    }

    public static double calculateRoundedDist(double d, Context context) {
        double d2;
        if (context == null || NavigationContext.getNavigationContext().k() == null) {
            return 0.0d;
        }
        s.EnumC0101s enumC0101s = (s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get();
        double d3 = 1609.343994140625d;
        if (enumC0101s == s.EnumC0101s.MILES_AND_FEET) {
            d2 = 3.2808001041412354d;
        } else if (enumC0101s != s.EnumC0101s.MILES_AND_METERS) {
            if (enumC0101s == s.EnumC0101s.NAUTICAL_MILES) {
                d3 = 1852.0d;
            } else if (enumC0101s == s.EnumC0101s.MILES_AND_YARDS) {
                d2 = 1.0936000347137451d;
            } else {
                d3 = 1000.0d;
            }
            d2 = 1.0d;
        } else {
            d2 = 1.0d;
        }
        double d4 = d2;
        int i = 1;
        byte b2 = 1;
        double d5 = 1.0d;
        while (true) {
            double d6 = i;
            if (d * d4 <= d6) {
                break;
            }
            d5 = d6 / d4;
            byte b3 = (byte) (b2 + 1);
            i = b2 % 3 == 2 ? (i * 5) / 2 : i * 2;
            if (d4 != d2 || d3 * d2 * 0.8999999761581421d > i) {
                b2 = b3;
            } else {
                d4 = 1.0d / d3;
                i = 1;
                b2 = 1;
            }
        }
        s.EnumC0101s enumC0101s2 = s.EnumC0101s.MILES_AND_METERS;
        if (enumC0101s != enumC0101s2 || d5 != 1000.0d) {
            if (enumC0101s != enumC0101s2 || d5 != 500.0d) {
                s.EnumC0101s enumC0101s3 = s.EnumC0101s.MILES_AND_FEET;
                if (enumC0101s != enumC0101s3 || d5 != 609.6073934755952d) {
                    if (enumC0101s != enumC0101s3 || d5 != 304.8036967377976d) {
                        s.EnumC0101s enumC0101s4 = s.EnumC0101s.MILES_AND_YARDS;
                        if (enumC0101s != enumC0101s4 || d5 != 914.4110902133929d) {
                            if (enumC0101s != enumC0101s4 || d5 != 457.20554510669643d) {
                                return d5;
                            }
                        }
                    }
                }
            }
            return 402.33599853515625d;
        }
        return 804.6719970703125d;
    }

    private static double formatCoordinate(double d, StringBuilder sb, char c) {
        int iFloor = (int) Math.floor(d);
        if (iFloor < 10) {
            sb.append('0');
        }
        sb.append(iFloor);
        sb.append(c);
        return (d - ((double) iFloor)) * 60.0d;
    }

    private static String formatCoordinate(double d, int i) {
        if (d < -180.0d || d > 180.0d || Double.isNaN(d)) {
            return "Error. Wrong coordinates data!";
        }
        if (i != 0 && i != 1 && i != 2 && i != 8) {
            return "Unknown Output Format!";
        }
        Locale locale = Locale.US;
        DecimalFormat decimalFormat = new DecimalFormat("##0.00000", new DecimalFormatSymbols(locale));
        DecimalFormat decimalFormat2 = new DecimalFormat("00.000", new DecimalFormatSymbols(locale));
        DecimalFormat decimalFormat3 = new DecimalFormat("00.0", new DecimalFormatSymbols(locale));
        StringBuilder sb = new StringBuilder();
        if (d < 0.0d) {
            if (i == 8) {
                sb.append('-');
            }
            d = -d;
        }
        if (i == 8) {
            sb.append(decimalFormat.format(d));
        } else if (i == 0) {
            sb.append(decimalFormat.format(d));
            sb.append((char) 176);
        } else {
            double coordinate = formatCoordinate(d, sb, (char) 176);
            if (i == 1) {
                sb.append(decimalFormat2.format(coordinate));
                sb.append((char) 8242);
            } else {
                sb.append(decimalFormat3.format(formatCoordinate(coordinate, sb, (char) 8242)));
                sb.append((char) 8243);
            }
        }
        return sb.toString();
    }

    public static String formatInteger(int i, String str, Context context) {
        return formatIntegerValue(i, str, context).a(context);
    }

    public static a formatIntegerValue(int i, String str, Context context) {
        return formatValue(i, str, false, 0, context);
    }

    public static a formatValue(float f, int i, boolean z, int i2, Context context) {
        return formatValue(f, context.getString(i), z, i2, context);
    }

    public static a formatValue(float f, String str, boolean z, int i, Context context) {
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
        return new a(messageFormat.format(new Object[]{Float.valueOf(f)}).replace('\n', ' '), str, true);
    }

    public static String getFormattedAlt(double d, Context context) {
        if (context == null || NavigationContext.getNavigationContext().k() == null) {
            return "";
        }
        if (((s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get()) == s.EnumC0101s.KILOMETERS_AND_METERS) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) (d + 0.5d));
            sb.append(StringUtils.SPACE);
            return m.a(context, R.string.mappls_m, sb);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((int) ((d * 3.2808001041412354d) + 0.5d));
        sb2.append(StringUtils.SPACE);
        return m.a(context, R.string.mappls_foot, sb2);
    }

    public static String getFormattedAlt(double d, Context context, s.EnumC0101s enumC0101s) {
        return getFormattedAltitudeValue(d, context, enumC0101s).a(context);
    }

    public static a getFormattedAltitudeValue(double d, Context context, s.EnumC0101s enumC0101s) {
        float f;
        int i;
        if (enumC0101s == s.EnumC0101s.MILES_AND_FEET || enumC0101s == s.EnumC0101s.MILES_AND_YARDS) {
            f = (int) ((d * 3.2808001041412354d) + 0.5d);
            i = R.string.mappls_foot;
        } else {
            f = (int) (d + 0.5d);
            i = R.string.mappls_m;
        }
        return formatValue(f, i, false, 0, context);
    }

    public static String getFormattedDate(Context context, long j) {
        return DateUtils.formatDateTime(context, j, 524304);
    }

    public static String getFormattedDistance(double d, Context context, boolean z) {
        int i;
        float f;
        String str = z ? "{0,number,0.0} " : "{0,number,0.#} ";
        String str2 = z ? "{0,number,0.00} " : "{0,number,0.##} ";
        if (context == null || NavigationContext.getNavigationContext().k() == null) {
            return "";
        }
        s.EnumC0101s enumC0101s = (s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get();
        s.EnumC0101s enumC0101s2 = s.EnumC0101s.KILOMETERS_AND_METERS;
        if (enumC0101s == enumC0101s2) {
            i = R.string.mappls_km;
            f = 1000.0f;
        } else if (enumC0101s == s.EnumC0101s.NAUTICAL_MILES) {
            i = R.string.mappls_nm;
            f = 1852.0f;
        } else {
            i = R.string.mappls_mile;
            f = 1609.344f;
        }
        if (d >= 100.0f * f) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) ((d / ((double) f)) + 0.5d));
            sb.append(StringUtils.SPACE);
            return m.a(context, i, sb);
        }
        if (d > 9.99f * f) {
            return MessageFormat.format(m.a(context, i, h.a(str)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        if (d > 0.999f * f) {
            return MessageFormat.format(m.a(context, i, h.a(str2)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        s.EnumC0101s enumC0101s3 = s.EnumC0101s.MILES_AND_FEET;
        if (enumC0101s == enumC0101s3 && d > f * 0.249f) {
            return MessageFormat.format(m.a(context, i, h.a(str2)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        s.EnumC0101s enumC0101s4 = s.EnumC0101s.MILES_AND_METERS;
        if (enumC0101s == enumC0101s4 && d > f * 0.249f) {
            return MessageFormat.format(m.a(context, i, h.a(str2)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        s.EnumC0101s enumC0101s5 = s.EnumC0101s.MILES_AND_YARDS;
        if (enumC0101s == enumC0101s5 && d > 0.249f * f) {
            return MessageFormat.format(m.a(context, i, h.a(str2)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        if (enumC0101s == s.EnumC0101s.NAUTICAL_MILES && d > 0.99f * f) {
            return MessageFormat.format(m.a(context, i, h.a(str2)), Double.valueOf(d / ((double) f))).replace('\n', ' ');
        }
        if (enumC0101s == enumC0101s2 || enumC0101s == enumC0101s4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((int) (d + 0.5d));
            sb2.append(StringUtils.SPACE);
            return m.a(context, R.string.mappls_m, sb2);
        }
        if (enumC0101s == enumC0101s3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append((int) ((3.2808001041412354d * d) + 0.5d));
            sb3.append(StringUtils.SPACE);
            return m.a(context, R.string.mappls_foot, sb3);
        }
        if (enumC0101s == enumC0101s5) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append((int) ((1.0936000347137451d * d) + 0.5d));
            sb4.append(StringUtils.SPACE);
            return m.a(context, R.string.mappls_yard, sb4);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) (d + 0.5d));
        sb5.append(StringUtils.SPACE);
        return m.a(context, R.string.mappls_m, sb5);
    }

    public static String getFormattedDistance(float f, Context context) {
        return getFormattedDistance(f, context, false);
    }

    public static String getFormattedDistance(float f, Context context, boolean z) {
        return context == null ? "" : getFormattedDistance(f, context, z, (s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get());
    }

    public static String getFormattedDistance(float f, Context context, boolean z, s.EnumC0101s enumC0101s) {
        return getFormattedDistanceValue(f, context, z, enumC0101s).a(context);
    }

    public static String getFormattedDistanceInterval(Context context, double d, boolean z) {
        return getFormattedDistance((float) calculateRoundedDist(d, context), context, z);
    }

    public static String getFormattedDistanceNavigation(double d, Context context) {
        return f.a(context, d, true, 0.65f, (ForegroundColorSpan) null).toString();
    }

    public static SpannableString getFormattedDistanceRound(float f, Context context, float f2) {
        return f.a(context, f, false, f2, (ForegroundColorSpan) null);
    }

    public static SpannableString getFormattedDistanceRound(float f, Context context, float f2, ForegroundColorSpan foregroundColorSpan) {
        return f.a(context, f, false, f2, foregroundColorSpan);
    }

    public static String getFormattedDistanceRound(float f, Context context) {
        return f.a(context, f, false, 0.65f, (ForegroundColorSpan) null).toString();
    }

    public static a getFormattedDistanceValue(float f, Context context, boolean z, s.EnumC0101s enumC0101s) {
        int i;
        float f2;
        s.EnumC0101s enumC0101s2 = s.EnumC0101s.KILOMETERS_AND_METERS;
        if (enumC0101s == enumC0101s2) {
            i = R.string.mappls_km;
            f2 = 1000.0f;
        } else if (enumC0101s == s.EnumC0101s.NAUTICAL_MILES) {
            i = R.string.mappls_nm;
            f2 = 1852.0f;
        } else {
            i = R.string.mappls_mile;
            f2 = 1609.344f;
        }
        float f3 = f / f2;
        if (f >= 100.0f * f2) {
            return formatValue((int) (((double) f3) + 0.5d), i, z, 0, context);
        }
        if (f > 9.99f * f2) {
            return formatValue(f3, i, z, 1, context);
        }
        if (f > 0.999f * f2) {
            return formatValue(f3, i, z, 2, context);
        }
        s.EnumC0101s enumC0101s3 = s.EnumC0101s.MILES_AND_FEET;
        if (enumC0101s == enumC0101s3 && f > f2 * 0.249f) {
            return formatValue(f3, i, z, 2, context);
        }
        s.EnumC0101s enumC0101s4 = s.EnumC0101s.MILES_AND_METERS;
        if (enumC0101s == enumC0101s4 && f > f2 * 0.249f) {
            return formatValue(f3, i, z, 2, context);
        }
        s.EnumC0101s enumC0101s5 = s.EnumC0101s.MILES_AND_YARDS;
        if (enumC0101s == enumC0101s5 && f > 0.249f * f2) {
            return formatValue(f3, i, z, 2, context);
        }
        if (enumC0101s == s.EnumC0101s.NAUTICAL_MILES && f > f2 * 0.99f) {
            return formatValue(f3, i, z, 2, context);
        }
        if (enumC0101s == enumC0101s2 || enumC0101s == enumC0101s4) {
            return formatValue((int) (((double) f) + 0.5d), R.string.mappls_m, z, 0, context);
        }
        if (enumC0101s == enumC0101s3) {
            return formatValue((int) (((double) (f * 3.2808f)) + 0.5d), R.string.mappls_foot, z, 0, context);
        }
        return enumC0101s == enumC0101s5 ? formatValue((int) (((double) (f * 1.0936f)) + 0.5d), R.string.mappls_foot, z, 0, context) : formatValue((int) (((double) f) + 0.5d), R.string.mappls_m, z, 0, context);
    }

    public static String getFormattedDuration(int i, Context context) {
        int i2 = i % 60;
        long j = (i % 3600) / 60;
        long j2 = (i % DateTimeConstants.SECONDS_PER_DAY) / 3600;
        long j3 = i / DateTimeConstants.SECONDS_PER_DAY;
        String strA = "";
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(j3);
            sb.append(StringUtils.SPACE);
            sb.append(context.getString(j3 > 1 ? R.string.mappls_navigation_days : R.string.mappls_navigation_day));
            sb.append(StringUtils.SPACE);
            sb.append(j2);
            sb.append(StringUtils.SPACE);
            sb.append(context.getString(R.string.mappls_navigation_hour));
            if (j > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(StringUtils.SPACE);
                sb2.append(j);
                sb2.append(StringUtils.SPACE);
                strA = m.a(context, R.string.mappls_navigation_minute, sb2);
            }
            sb.append(strA);
            return sb.toString();
        }
        if (j2 <= 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(j >= 1 ? Long.valueOf(j) : "<1");
            sb3.append(StringUtils.SPACE);
            return m.a(context, R.string.mappls_navigation_minute, sb3);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(j2);
        sb4.append(StringUtils.SPACE);
        sb4.append(context.getString(R.string.mappls_navigation_hour));
        if (j > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(StringUtils.SPACE);
            sb5.append(j);
            sb5.append(StringUtils.SPACE);
            strA = m.a(context, R.string.mappls_navigation_minute, sb5);
        }
        sb4.append(strA);
        return sb4.toString();
    }

    public static String getFormattedDurationShort(int i) {
        Object objValueOf;
        Object objValueOf2;
        int i2 = i / 3600;
        int i3 = (i / 60) % 60;
        int i4 = i % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(":");
        if (i3 < 10) {
            objValueOf = "0" + i3;
        } else {
            objValueOf = Integer.valueOf(i3);
        }
        sb.append(objValueOf);
        sb.append(":");
        if (i4 < 10) {
            objValueOf2 = "0" + i4;
        } else {
            objValueOf2 = Integer.valueOf(i4);
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public static String getFormattedDurationShortMinutes(int i) {
        Object objValueOf;
        int i2 = i / 3600;
        int i3 = (i / 60) % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(":");
        if (i3 < 10) {
            objValueOf = "0" + i3;
        } else {
            objValueOf = Integer.valueOf(i3);
        }
        sb.append(objValueOf);
        return sb.toString();
    }

    public static String getFormattedFullTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return fullTimeFormatter.a(calendar.getTime(), twelveHoursFormat);
    }

    private static a getFormattedLowSpeed(float f, String str, Context context) {
        return formatValue(f, str, true, 1, context);
    }

    public static String getFormattedRoundDistanceKm(float f, int i, Context context) {
        int i2 = R.string.mappls_km;
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) (((double) (f / 1000.0f)) + 0.5d));
            sb.append(StringUtils.SPACE);
            return m.a(context, i2, sb);
        }
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fixed1.format(f / 1000.0f));
            sb2.append(StringUtils.SPACE);
            return m.a(context, i2, sb2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(fixed2.format(f / 1000.0f));
        sb3.append(StringUtils.SPACE);
        return m.a(context, i2, sb3);
    }

    private static a getFormattedSpeed(float f, String str, Context context) {
        return formatValue(f, str, false, 0, context);
    }

    public static String getFormattedSpeed(float f, Context context) {
        StringBuilder sb;
        int iRound;
        int iRound2;
        if (context == null || NavigationContext.getNavigationContext().k() == null) {
            return "";
        }
        s sVarK = NavigationContext.getNavigationContext().k();
        s.v vVar = (s.v) sVarK.v0.get();
        d dVarE = sVarK.e();
        float f2 = 3.6f * f;
        s.v vVar2 = s.v.KILOMETERS_PER_HOUR;
        String str = StringUtils.SPACE;
        if (vVar == vVar2) {
            if (f2 >= 20.0f || dVarE.h()) {
                sb = new StringBuilder();
                iRound2 = Math.round(f2);
                sb.append(iRound2);
                sb.append(str);
            } else {
                iRound = Math.round(f2 * 10.0f);
                sb = new StringBuilder();
                sb.append(iRound / 10.0f);
                sb.append(str);
            }
        } else if (vVar == s.v.MILES_PER_HOUR) {
            f2 = (f2 * 1000.0f) / 1609.344f;
            if (f2 >= 20.0f || dVarE.h()) {
                sb = new StringBuilder();
                iRound2 = Math.round(f2);
                sb.append(iRound2);
                sb.append(str);
            } else {
                iRound = Math.round(f2 * 10.0f);
                sb = new StringBuilder();
                sb.append(iRound / 10.0f);
                sb.append(str);
            }
        } else {
            if (vVar == s.v.NAUTICALMILES_PER_HOUR) {
                f2 = (f2 * 1000.0f) / 1852.0f;
                if (f2 >= 20.0f || dVarE.h()) {
                    sb = new StringBuilder();
                    iRound2 = Math.round(f2);
                    sb.append(iRound2);
                    sb.append(str);
                } else {
                    iRound = Math.round(f2 * 10.0f);
                    sb = new StringBuilder();
                }
            } else if (vVar == s.v.MINUTES_PER_KILOMETER) {
                if (f < 0.111111111d) {
                    sb = new StringBuilder();
                    str = "-";
                    sb.append(str);
                } else {
                    float f3 = 1000.0f / (f * 60.0f);
                    if (f3 >= 10.0f) {
                        sb = new StringBuilder();
                        iRound2 = Math.round(f3);
                        sb.append(iRound2);
                        sb.append(str);
                    } else {
                        iRound = Math.round(f3 * 10.0f);
                        sb = new StringBuilder();
                    }
                }
            } else if (vVar != s.v.MINUTES_PER_MILE) {
                if (f >= 10.0f) {
                    sb = new StringBuilder();
                    sb.append(Math.round(f));
                } else {
                    int iRound3 = Math.round(f * 10.0f);
                    sb = new StringBuilder();
                    sb.append(iRound3 / 10.0f);
                }
                sb.append(StringUtils.SPACE);
                vVar = s.v.METERS_PER_SECOND;
            } else if (f < 0.111111111d) {
                sb = new StringBuilder();
                str = "-";
                sb.append(str);
            } else {
                float f4 = 1609.344f / (f * 60.0f);
                if (f4 >= 10.0f) {
                    sb = new StringBuilder();
                    iRound2 = Math.round(f4);
                    sb.append(iRound2);
                    sb.append(str);
                } else {
                    iRound = Math.round(f4 * 10.0f);
                    sb = new StringBuilder();
                }
            }
            sb.append(iRound / 10.0f);
            sb.append(str);
        }
        sb.append(vVar.a(context));
        return sb.toString();
    }

    public static a getFormattedSpeedValue(float f, Context context) {
        s sVarK = NavigationContext.getNavigationContext().k();
        s.v vVar = (s.v) sVarK.v0.get();
        String strA = vVar.a(context);
        d dVarE = sVarK.e();
        float f2 = 3.6f * f;
        if (vVar == s.v.KILOMETERS_PER_HOUR) {
            return (f2 >= 20.0f || dVarE.h()) ? getFormattedSpeed(Math.round(f2), strA, context) : getFormattedLowSpeed(Math.round(f2 * 10.0f) / 10.0f, strA, context);
        }
        if (vVar == s.v.MILES_PER_HOUR) {
            float f3 = (f2 * 1000.0f) / 1609.344f;
            return (f3 >= 20.0f || dVarE.h()) ? getFormattedSpeed(Math.round(f3), strA, context) : getFormattedLowSpeed(Math.round(f3 * 10.0f) / 10.0f, strA, context);
        }
        if (vVar == s.v.NAUTICALMILES_PER_HOUR) {
            float f4 = (f2 * 1000.0f) / 1852.0f;
            return (f4 >= 20.0f || dVarE.h()) ? getFormattedSpeed(Math.round(f4), strA, context) : getFormattedLowSpeed(Math.round(f4 * 10.0f) / 10.0f, strA, context);
        }
        if (vVar == s.v.MINUTES_PER_KILOMETER) {
            if (f < 0.111111111d) {
                return new a("-", strA, false);
            }
            float f5 = 1000.0f / (f * 60.0f);
            return f5 >= 10.0f ? getFormattedSpeed(Math.round(f5), strA, context) : new a(com.mappls.sdk.navigation.util.a.a(Math.round(f5 * 60.0f), false), strA, true);
        }
        if (vVar != s.v.MINUTES_PER_MILE) {
            String strA2 = s.v.METERS_PER_SECOND.a(context);
            return f >= 10.0f ? getFormattedSpeed(Math.round(f), strA2, context) : getFormattedLowSpeed(Math.round(f * 10.0f) / 10.0f, strA2, context);
        }
        if (f < 0.111111111d) {
            return new a("-", strA, false);
        }
        float f6 = 1609.344f / (f * 60.0f);
        return f6 >= 10.0f ? getFormattedSpeed(Math.round(f6), strA, context) : getFormattedLowSpeed(Math.round(f6 * 10.0f) / 10.0f, strA, context);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean isSameDay(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return isSameDay(calendar, calendar2);
    }

    public static void setTwelveHoursFormatting(boolean z, Locale locale) {
        twelveHoursFormat = z;
        fullTimeFormatter = new b(locale, "H:mm:ss", "h:mm:ss a");
        shortTimeFormatter = new b(locale, "HH:mm", "h:mm a");
    }
}
