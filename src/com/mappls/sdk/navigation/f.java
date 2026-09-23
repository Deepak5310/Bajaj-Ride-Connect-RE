package com.mappls.sdk.navigation;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfConversion;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
final class f {
    private static HashMap a = new HashMap();
    private static NumberFormat b;

    public static SpannableString a(Context context, double d, boolean z, float f, ForegroundColorSpan foregroundColorSpan) {
        if (context == null || NavigationContext.getNavigationContext().k() == null) {
            return new SpannableString("");
        }
        boolean zIsEmpty = a.isEmpty();
        String str = TurfConstants.UNIT_FEET;
        String str2 = TurfConstants.UNIT_MILES;
        if (zIsEmpty) {
            a.put("kilometers", context.getString(R.string.mappls_kilometers));
            a.put(TurfConstants.UNIT_METERS, context.getString(R.string.mappls_meters));
            a.put(TurfConstants.UNIT_MILES, context.getString(R.string.mappls_miles));
            a.put(TurfConstants.UNIT_FEET, context.getString(R.string.mappls_feet));
        }
        b = NumberFormat.getNumberInstance(Locale.getDefault());
        boolean z2 = ((s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get()) == s.EnumC0101s.KILOMETERS_AND_METERS;
        if (z2) {
            str2 = "kilometers";
        }
        if (z2) {
            str = TurfConstants.UNIT_METERS;
        }
        double dConvertLength = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str);
        double dConvertLength2 = TurfConversion.convertLength(d, TurfConstants.UNIT_METERS, str2);
        if (dConvertLength2 > 10.0d) {
            b.setMaximumFractionDigits(d <= 10000.0d ? 1 : 0);
            return a(b.format(dConvertLength2), str2, z, f, foregroundColorSpan);
        }
        if (dConvertLength >= 999.0d) {
            b.setMaximumFractionDigits(1);
            return a(b.format(dConvertLength2), str2, z, f, foregroundColorSpan);
        }
        if (d > 500.0d) {
            int iRound = (((int) Math.round(dConvertLength)) / 50) * 50;
            return a(String.valueOf(iRound >= 50 ? iRound : 50), str, z, f, foregroundColorSpan);
        }
        if (d > 100.0d) {
            int iRound2 = (((int) Math.round(dConvertLength)) / 25) * 25;
            return a(String.valueOf(iRound2 >= 25 ? iRound2 : 25), str, z, f, foregroundColorSpan);
        }
        if (d > 20.0d) {
            int iRound3 = (((int) Math.round(dConvertLength)) / 10) * 10;
            return a(String.valueOf(iRound3 >= 10 ? iRound3 : 10), str, z, f, foregroundColorSpan);
        }
        int iRound4 = (((int) Math.round(dConvertLength)) / 5) * 5;
        return a(String.valueOf(iRound4 >= 5 ? iRound4 : 5), str, z, f, foregroundColorSpan);
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
}
