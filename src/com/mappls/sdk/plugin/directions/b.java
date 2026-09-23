package com.mappls.sdk.plugin.directions;

import com.facebook.hermes.intl.Constants;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static String a(String str) {
        str.hashCode();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 3148:
                if (str.equals("bn")) {
                    b = 0;
                }
                break;
            case 3259:
                if (str.equals("fa")) {
                    b = 1;
                }
                break;
            case 3310:
                if (str.equals("gu")) {
                    b = 2;
                }
                break;
            case 3329:
                if (str.equals("hi")) {
                    b = 3;
                }
                break;
            case 3427:
                if (str.equals(Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT)) {
                    b = 4;
                }
                break;
            case 3487:
                if (str.equals("ml")) {
                    b = 5;
                }
                break;
            case 3493:
                if (str.equals("mr")) {
                    b = 6;
                }
                break;
            case 3569:
                if (str.equals("pa")) {
                    b = 7;
                }
                break;
            case 3693:
                if (str.equals("ta")) {
                    b = 8;
                }
                break;
            case 3697:
                if (str.equals("te")) {
                    b = 9;
                }
                break;
            case 3700:
                if (str.equals("th")) {
                    b = 10;
                }
                break;
            case 3715:
                if (str.equals("tw")) {
                    b = Ascii.VT;
                }
                break;
        }
        switch (b) {
            case 0:
                return "mappls-directions-bn";
            case 1:
                return "mappls-directions-fa";
            case 2:
                return "mappls-directions-gu";
            case 3:
                return "mappls-directions-hi";
            case 4:
                return "mappls-directions-kn";
            case 5:
                return "mappls-directions-ml";
            case 6:
                return "mappls-directions-mr";
            case 7:
                return "mappls-directions-pa";
            case 8:
                return "mappls-directions-ta";
            case 9:
                return "mappls-directions-te";
            case 10:
                return "mappls-directions-th";
            case 11:
                return "mappls-directions-tw";
            default:
                return "mappls-directions-en";
        }
    }

    static String b(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "bn":
                return "mappls-directions-bn_short_instructions";
            case "gu":
                return "mappls-directions-gu_short_instructions";
            case "hi":
                return "mappls-directions-hi_short_instructions";
            case "kn":
                return "mappls-directions-kn_short_instructions";
            case "ml":
                return "mappls-directions-ml_short_instructions";
            case "mr":
                return "mappls-directions-mr_short_instructions";
            case "pa":
                return "mappls-directions-pa_short_instructions";
            case "ta":
                return "mappls-directions-ta_short_instructions";
            case "te":
                return "mappls-directions-te_short_instructions";
            default:
                return "mappls-directions-en_short_instructions";
        }
    }
}
