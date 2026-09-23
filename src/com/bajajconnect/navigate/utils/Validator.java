package com.bajajconnect.navigate.utils;

import android.text.TextUtils;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes3.dex */
public class Validator {
    private static final String REGEX_ALPHA_NUMERIC = "[A-Za-z0-9]+";

    public static boolean isValidLatLng(double d, double d2) {
        return d > 0.0d && d < 90.0d && d2 > 0.0d && d2 < 180.0d;
    }

    public static boolean isAlphanumeric(String str) {
        return str != null && str.matches(REGEX_ALPHA_NUMERIC);
    }

    public static boolean isValidLatLng(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        return isValidLatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    public static boolean isValidEloc(String str) {
        return !TextUtils.isEmpty(str) && str.length() == 6 && isAlphanumeric(str);
    }
}
