package j$.util.concurrent;

import j$.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class DesugarTimeUnit {
    public static long convert(TimeUnit timeUnit, Duration duration) {
        return timeUnit.convert(duration.toNanos(), TimeUnit.NANOSECONDS);
    }
}
