package com.google.android.libraries.navigation.internal.rc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private final Map a = new HashMap();
    private final com.google.android.libraries.navigation.internal.hp.e b;
    private final com.google.android.libraries.navigation.internal.mj.a c;

    public f(com.google.android.libraries.navigation.internal.hp.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = eVar;
        this.c = aVar;
    }

    public final void a(int i) {
        Long l;
        long epochMilli = this.c.f().toEpochMilli();
        Map map = this.a;
        Integer numValueOf = Integer.valueOf(i);
        long jLongValue = Long.MAX_VALUE;
        if (map.containsKey(numValueOf) && (l = (Long) this.a.get(numValueOf)) != null) {
            jLongValue = epochMilli - l.longValue();
        }
        if (jLongValue > TimeUnit.HOURS.toMillis(12L)) {
            this.b.a(com.google.android.libraries.navigation.internal.zy.e.c(i));
            this.a.put(numValueOf, Long.valueOf(epochMilli));
        }
    }
}
