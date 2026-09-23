package com.google.android.libraries.navigation.internal.rq;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    private long b = 0;
    public final Map a = new HashMap();

    public final synchronized long a() {
        long j;
        j = this.b + 1;
        this.b = j;
        return j;
    }
}
