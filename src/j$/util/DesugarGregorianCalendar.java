package j$.util;

import j$.time.Instant;
import j$.time.ZonedDateTime;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class DesugarGregorianCalendar {
    public static ZonedDateTime toZonedDateTime(GregorianCalendar gregorianCalendar) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(gregorianCalendar.getTimeInMillis()), TimeZoneRetargetClass.toZoneId(gregorianCalendar.getTimeZone()));
    }
}
