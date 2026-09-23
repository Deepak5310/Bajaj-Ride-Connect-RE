package com.google.android.libraries.navigation.internal.abh;

import android.os.SystemClock;
import java.util.UUID;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ea {
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final UUID a = UUID.randomUUID();
    private final long c = SystemClock.elapsedRealtime();

    public ea(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = aVar;
    }

    public final String a() {
        return SystemClock.elapsedRealtime() - this.c > DateUtils.MILLIS_PER_DAY ? "over_ttl" : this.a.toString();
    }
}
