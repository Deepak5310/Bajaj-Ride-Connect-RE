package com.google.android.libraries.navigation.internal.c;

import com.google.android.libraries.navigation.internal.b.ag;
import com.google.common.net.HttpHeaders;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static long a(String str) {
        try {
            return c("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException unused) {
            if ("0".equals(str) || "-1".equals(str)) {
                ag.a("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            ag.b("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static com.google.android.libraries.navigation.internal.b.b b(com.google.android.libraries.navigation.internal.b.o oVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        Map map = oVar.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long jA = str != null ? a(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long jA2 = str3 != null ? a(str3) : 0L;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long jA3 = str4 != null ? a(str4) : 0L;
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            j4 = jCurrentTimeMillis + (j2 * 1000);
            j3 = z ? j4 : (j * 1000) + j4;
        } else {
            j3 = 0;
            if (jA <= 0 || jA2 < jA) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jA2 - jA);
                j3 = j4;
            }
        }
        com.google.android.libraries.navigation.internal.b.b bVar = new com.google.android.libraries.navigation.internal.b.b();
        bVar.a = oVar.b;
        bVar.b = str5;
        bVar.f = j4;
        bVar.e = j3;
        bVar.c = jA;
        bVar.d = jA3;
        bVar.g = map;
        bVar.h = oVar.d;
        return bVar;
    }

    public static SimpleDateFormat c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(TimeZones.GMT_ID));
        return simpleDateFormat;
    }
}
