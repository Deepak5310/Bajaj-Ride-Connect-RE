package com.google.android.libraries.navigation.internal.hh;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public o(int i, Throwable th) {
        String str;
        switch (i) {
            case 1:
                str = "SUCCESS_WITH_CHECKSUM";
                break;
            case 2:
            default:
                str = BuildConfig.TRAVIS;
                break;
            case 3:
                str = "SUCCESS_CHECKSUM_DISABLED";
                break;
            case 4:
                str = "FAILED_BAD_CHECKSUM";
                break;
            case 5:
                str = "FAILED_ERROR_READING_CHECKSUM";
                break;
            case 6:
                str = "FAILED_PARSE_ERROR";
                break;
            case 7:
                str = "FAILED_NO_FILE";
                break;
            case 8:
                str = "SUCCESS_WITH_CHECKSUM_V1";
                break;
            case 9:
                str = "FAILED_IO_ERROR";
                break;
            case 10:
                str = "FAILED_NO_CHECKSUM";
                break;
        }
        super("Error loading: ".concat(str), th);
    }
}
