package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b {
    public final ev a;
    public final Long b;
    public final long c;
    public final int d;

    public b(int i, long j, List list, Long l) {
        this.d = i;
        this.a = ev.o(list);
        this.c = j;
        this.b = l;
    }

    public final String toString() {
        return String.format(Locale.US, "sessionId: 0x%016x, type: %s, timestamp: %d, transactionIds: {%s}", this.b, this.d != 1 ? "DROPOFF" : "PICKUP", Long.valueOf(this.c), new ah(",").f(this.a));
    }
}
