package com.google.android.libraries.navigation.internal.hf;

import android.content.Context;
import java.util.TimeZone;
import org.joda.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public final CharSequence a;

    private s(CharSequence charSequence) {
        this.a = charSequence;
    }

    public static s a(Context context, long j, TimeZone timeZone, String str) {
        TimeZone timeZone2 = TimeZone.getDefault();
        long millis = Duration.standardSeconds(j).getMillis();
        boolean z = timeZone == null || timeZone2.getOffset(millis) == timeZone.getOffset(millis);
        if (true == z) {
            timeZone = timeZone2;
        }
        String strC = u.c(context, j, timeZone);
        if (!z) {
            strC = context.getString(com.google.android.libraries.navigation.internal.hg.a.b, strC, str);
        }
        return new s(strC);
    }
}
