package com.google.android.libraries.navigation.internal.ne;

import com.google.android.libraries.navigation.internal.yz.fy;
import j$.util.DesugarTimeZone;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Provider {
    public static final fy a = fy.p(TimeZone.getAvailableIDs());
    private static final TimeZone b = DesugarTimeZone.getTimeZone("UTC");
    private static final ConcurrentHashMap c = new ConcurrentHashMap();

    @Override // org.joda.time.tz.Provider
    public final Set getAvailableIDs() {
        return a;
    }

    @Override // org.joda.time.tz.Provider
    public final DateTimeZone getZone(String str) {
        if (str == null) {
            return DateTimeZone.UTC;
        }
        ConcurrentHashMap concurrentHashMap = c;
        DateTimeZone bVar = (DateTimeZone) concurrentHashMap.get(str);
        if (bVar == null) {
            TimeZone timeZone = DesugarTimeZone.getTimeZone(str);
            bVar = (timeZone == null || timeZone.hasSameRules(b)) ? DateTimeZone.UTC : new b(timeZone);
            DateTimeZone dateTimeZone = (DateTimeZone) concurrentHashMap.putIfAbsent(str, bVar);
            if (dateTimeZone != null) {
                return dateTimeZone;
            }
        }
        return bVar;
    }
}
