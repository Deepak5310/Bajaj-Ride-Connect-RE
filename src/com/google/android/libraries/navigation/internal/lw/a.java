package com.google.android.libraries.navigation.internal.lw;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.ROOT);
    public static final StringBuilder b;

    static {
        new SimpleDateFormat("MM-dd HH:mm:ss", Locale.ROOT);
        b = new StringBuilder(33);
    }

    public static void a(long j, StringBuilder sb) {
        if (j == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z = false;
        if (j < 0) {
            sb.append("-");
            if (j != Long.MIN_VALUE) {
                j = -j;
            } else {
                j = Long.MAX_VALUE;
                z = true;
            }
        }
        if (j >= DateUtils.MILLIS_PER_DAY) {
            sb.append(j / DateUtils.MILLIS_PER_DAY);
            sb.append("d");
            j %= DateUtils.MILLIS_PER_DAY;
        }
        if (true == z) {
            j = 25975808;
        }
        if (j >= DateUtils.MILLIS_PER_HOUR) {
            sb.append(j / DateUtils.MILLIS_PER_HOUR);
            sb.append("h");
            j %= DateUtils.MILLIS_PER_HOUR;
        }
        if (j >= 60000) {
            sb.append(j / 60000);
            sb.append("m");
            j %= 60000;
        }
        if (j >= 1000) {
            sb.append(j / 1000);
            sb.append("s");
            j %= 1000;
        }
        if (j > 0) {
            sb.append(j);
            sb.append("ms");
        }
    }
}
