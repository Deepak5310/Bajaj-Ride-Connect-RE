package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhf {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    public static int zza(String str) {
        byte b;
        if (str == null) {
            return 13;
        }
        switch (str) {
            case "REQUEST_DENIED":
                b = 3;
                break;
            case "INVALID_REQUEST":
                b = 4;
                break;
            case "ZERO_RESULTS":
                b = 1;
                break;
            case "OK":
                b = 0;
                break;
            case "NOT_FOUND":
                b = 5;
                break;
            case "OVER_QUERY_LIMIT":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0 || b == 1) {
            return 0;
        }
        if (b == 2) {
            return PlacesStatusCodes.OVER_QUERY_LIMIT;
        }
        if (b == 3) {
            return PlacesStatusCodes.REQUEST_DENIED;
        }
        if (b == 4) {
            return PlacesStatusCodes.INVALID_REQUEST;
        }
        if (b != 5) {
            return 13;
        }
        return PlacesStatusCodes.NOT_FOUND;
    }

    public static String zzb(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
