package com.google.android.libraries.navigation.internal.aen;

import com.google.android.libraries.navigation.internal.ael.ec;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.yx.bq;
import com.google.android.libraries.navigation.internal.zw.g;
import com.google.android.libraries.navigation.internal.zw.h;
import java.lang.reflect.Method;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final Method a;
    public static final Method b;
    public static final Method c;

    static {
        ec ecVar = (ec) ed.a.q();
        if (!ecVar.b.H()) {
            ecVar.v();
        }
        ((ed) ecVar.b).b = -62135596800L;
        if (!ecVar.b.H()) {
            ecVar.v();
        }
        ((ed) ecVar.b).c = 0;
        ec ecVar2 = (ec) ed.a.q();
        if (!ecVar2.b.H()) {
            ecVar2.v();
        }
        ((ed) ecVar2.b).b = 253402300799L;
        if (!ecVar2.b.H()) {
            ecVar2.v();
        }
        ((ed) ecVar2.b).c = 999999999;
        ec ecVar3 = (ec) ed.a.q();
        if (!ecVar3.b.H()) {
            ecVar3.v();
        }
        ((ed) ecVar3.b).b = 0L;
        if (!ecVar3.b.H()) {
            ecVar3.v();
        }
        ((ed) ecVar3.b).c = 0;
        new c();
        a = e("now");
        b = e("getEpochSecond");
        c = e("getNano");
    }

    public static long a(ed edVar) {
        d(edVar);
        return g.b(g.c(edVar.b, 1000L), edVar.c / DurationKt.NANOS_IN_MILLIS);
    }

    public static ed b(long j) {
        return c(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static ed c(long j, int i) {
        if (!f(j)) {
            throw new IllegalArgumentException(bq.a("Timestamp is not valid. Input seconds is too large. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. ", Long.valueOf(j)));
        }
        if (i <= -1000000000 || i >= 1000000000) {
            j = g.b(j, i / 1000000000);
            i %= 1000000000;
        }
        long j2 = j;
        if (i < 0) {
            i += 1000000000;
            long j3 = (-1) + j2;
            h.b(((j2 ^ j3) >= 0) | ((1 ^ j2) >= 0), "checkedSubtract", j2, 1L);
            j2 = j3;
        }
        ec ecVar = (ec) ed.a.q();
        if (!ecVar.b.H()) {
            ecVar.v();
        }
        ((ed) ecVar.b).b = j2;
        if (!ecVar.b.H()) {
            ecVar.v();
        }
        ((ed) ecVar.b).c = i;
        ed edVar = (ed) ecVar.t();
        d(edVar);
        return edVar;
    }

    public static void d(ed edVar) {
        long j = edVar.b;
        boolean zF = f(j);
        int i = edVar.c;
        if (!zF || i < 0 || i >= 1000000000) {
            throw new IllegalArgumentException(bq.a("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    private static Method e(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean f(long j) {
        return j >= -62135596800L && j <= 253402300799L;
    }
}
