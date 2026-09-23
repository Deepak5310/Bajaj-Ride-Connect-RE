package com.mappls.sdk.navigation.data;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.common.b;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.m;
import com.mappls.sdk.navigation.util.c;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private String a;
    private String b;
    private String c;
    private String d;
    private double e;
    private double f;
    private double g;
    private double h;

    public a(double d, double d2) {
        this(FirebaseAnalytics.Param.LOCATION, "");
        this.e = d;
        this.g = d;
        this.f = d2;
        this.h = d2;
    }

    public a(double d, double d2, double d3, double d4) {
        this(FirebaseAnalytics.Param.LOCATION, "");
        this.e = d3;
        this.g = d;
        this.f = d4;
        this.h = d2;
    }

    public a(String str, String str2) {
        this.c = "";
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0.0d;
        this.a = str;
        this.b = str2;
        if (str2 == null) {
            this.b = "";
        }
    }

    public a(String str, String str2, String str3) {
        this.c = "";
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0d;
        this.h = 0.0d;
        this.a = str;
        this.b = str3;
        this.d = str2;
        if (str3 == null) {
            this.b = "";
        }
    }

    public static a a(LatLng latLng, String str) {
        a aVar;
        int iIndexOf;
        String strTrim;
        if (str == null || str.length() <= 0 || (iIndexOf = str.indexOf(35)) < 0) {
            aVar = null;
        } else {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(35, i);
            if (iIndexOf2 > 0) {
                strTrim = str.substring(i, iIndexOf2).trim();
                str.substring(iIndexOf2 + 1).getClass();
            } else {
                strTrim = str.substring(i).trim();
            }
            String strSubstring = str.substring(0, iIndexOf);
            aVar = strSubstring.contains(".") ? new a(strSubstring.substring(0, strSubstring.indexOf(46)), strSubstring.substring(strSubstring.indexOf(46) + 1), strTrim) : new a(strSubstring, strTrim);
        }
        if (aVar == null) {
            aVar = new a(FirebaseAnalytics.Param.LOCATION, "");
        }
        if (aVar.g() && latLng != null) {
            aVar.e = latLng.getLatitude();
            aVar.f = latLng.getLongitude();
        }
        return aVar;
    }

    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        String str = aVar.a;
        if (!com.mappls.sdk.navigation.util.a.a(aVar.d)) {
            str = str + ClassUtils.PACKAGE_SEPARATOR_CHAR + aVar.d;
        }
        String str2 = str + "#" + aVar.b;
        if (com.mappls.sdk.navigation.util.a.a((String) null)) {
            return str2;
        }
        return str2 + "#null";
    }

    public final double a() {
        return this.e;
    }

    public final void a(double d) {
        this.e = d;
    }

    public final void a(String str) {
        this.b = str;
        if (str == null) {
            this.b = "";
        }
    }

    public final double b() {
        return this.f;
    }

    public final void b(double d) {
        this.f = d;
    }

    public final void b(String str) {
        this.c = str;
        if (str == null) {
            this.c = "";
        }
    }

    public final double c() {
        return this.g;
    }

    public final double d() {
        return this.h;
    }

    public final String e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return com.mappls.sdk.navigation.util.a.a(aVar.b, this.b) && com.mappls.sdk.navigation.util.a.a(aVar.a, this.a) && com.mappls.sdk.navigation.util.a.a(Double.valueOf(aVar.e), Double.valueOf(this.e)) && com.mappls.sdk.navigation.util.a.a(Double.valueOf(aVar.f), Double.valueOf(this.f)) && com.mappls.sdk.navigation.util.a.a(aVar.d, this.d);
    }

    public final String f() {
        return this.c;
    }

    public final boolean g() {
        return FirebaseAnalytics.Param.LOCATION.equals(this.a);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.a;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        double d = this.e;
        int iHashCode4 = (iHashCode3 + (d == 0.0d ? 0 : new Double(d).hashCode())) * 31;
        double d2 = this.f;
        return iHashCode4 + (d2 != 0.0d ? new Double(d2).hashCode() : 0);
    }

    public static a a(String str, String str2) {
        a aVar;
        int iIndexOf;
        if (str == null || str.length() <= 0 || (iIndexOf = str.indexOf(35)) < 0) {
            aVar = null;
        } else {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(35, i);
            String strTrim = (iIndexOf2 > 0 ? str.substring(i, iIndexOf2) : str.substring(i)).trim();
            String strSubstring = str.substring(0, iIndexOf);
            aVar = strSubstring.contains(".") ? new a(strSubstring.substring(0, strSubstring.indexOf(46)), strSubstring.substring(strSubstring.indexOf(46) + 1), strTrim) : new a(strSubstring, strTrim);
        }
        if (aVar == null) {
            aVar = new a(FirebaseAnalytics.Param.LOCATION, "");
        }
        if (aVar.g() && str2 != null && str2.contains(",")) {
            aVar.e = Double.parseDouble(str2.split(",")[1]);
            aVar.f = Double.parseDouble(str2.split(",")[0]);
        }
        return aVar;
    }

    public static String a(Context context) {
        return m.a(context, R.string.mappls_shared_string_ellipsis, h.a(""));
    }

    public static String a(LocationPoint locationPoint, Context context) {
        String string;
        a pointDescription = locationPoint.getPointDescription(context);
        if (!pointDescription.g()) {
            if (com.mappls.sdk.navigation.util.a.a(pointDescription.d)) {
                return pointDescription.c;
            }
            if (com.mappls.sdk.navigation.util.a.a(pointDescription.c)) {
                return pointDescription.d;
            }
            return pointDescription.d.trim() + ": " + pointDescription.c;
        }
        if (!com.mappls.sdk.navigation.util.a.a(pointDescription.c) && !pointDescription.c.equals(context.getString(R.string.mappls_no_address_found))) {
            return pointDescription.c;
        }
        double d = pointDescription.e;
        double d2 = pointDescription.f;
        int iIntValue = ((Integer) NavigationContext.getNavigationContext().k().r0.get()).intValue();
        if (iIntValue == 3) {
            com.mappls.sdk.navigation.common.a aVar = new com.mappls.sdk.navigation.common.a(d, d2);
            b bVar = new b();
            b.a(aVar, bVar);
            string = bVar.c + "" + bVar.d + StringUtils.SPACE + ((long) bVar.b) + StringUtils.SPACE + ((long) bVar.a);
        } else {
            try {
                string = context.getString(R.string.mappls_short_location_on_map, c.a(d, iIntValue), c.a(d2, iIntValue));
            } catch (RuntimeException e) {
                NavigationLogger.d(e);
                string = context.getString(R.string.mappls_short_location_on_map, 0, 0);
            }
        }
        return string.replace('\n', ' ');
    }
}
