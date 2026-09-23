package j$.time;

/* JADX INFO: loaded from: classes8.dex */
public class TimeConversions {
    public static java.time.ZonedDateTime convert(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        return java.time.ZonedDateTime.of(zonedDateTime.getYear(), zonedDateTime.getMonthValue(), zonedDateTime.getDayOfMonth(), zonedDateTime.getHour(), zonedDateTime.getMinute(), zonedDateTime.getSecond(), zonedDateTime.getNano(), convert(zonedDateTime.getZone()));
    }

    public static java.time.ZoneId convert(ZoneId zoneId) {
        if (zoneId == null) {
            return null;
        }
        return java.time.ZoneId.of(zoneId.getId());
    }

    public static java.time.Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return java.time.Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
    }

    public static java.time.Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return java.time.Duration.ofSeconds(duration.getSeconds(), duration.getNano());
    }

    public static Duration convert(java.time.Duration duration) {
        if (duration == null) {
            return null;
        }
        return Duration.ofSeconds(duration.getSeconds(), duration.getNano());
    }
}
