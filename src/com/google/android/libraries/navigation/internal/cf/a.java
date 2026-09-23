package com.google.android.libraries.navigation.internal.cf;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static {
        bj.e(",");
        ev.r(",", StringUtils.SPACE);
        fd.l("N", 1, ExifInterface.LATITUDE_SOUTH, -1);
        fd.l(ExifInterface.LONGITUDE_EAST, 1, ExifInterface.LONGITUDE_WEST, -1);
    }

    public static String a(al alVar) {
        if (alVar == null) {
            return null;
        }
        int iOrdinal = alVar.ordinal();
        if (iOrdinal == 1) {
            return "b";
        }
        if (iOrdinal == 2) {
            return "w";
        }
        if (iOrdinal == 3) {
            return "r";
        }
        if (iOrdinal != 5) {
            return iOrdinal != 7 ? "d" : "x";
        }
        return "l";
    }
}
