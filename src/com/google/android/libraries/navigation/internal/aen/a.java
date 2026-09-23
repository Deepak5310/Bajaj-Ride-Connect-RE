package com.google.android.libraries.navigation.internal.aen;

import com.google.android.libraries.navigation.internal.ael.al;
import com.google.android.libraries.navigation.internal.ael.am;
import com.google.android.libraries.navigation.internal.yx.bq;
import com.google.android.libraries.navigation.internal.zw.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final am a;

    static {
        al alVar = (al) am.a.q();
        if (!alVar.b.H()) {
            alVar.v();
        }
        ((am) alVar.b).b = -315576000000L;
        if (!alVar.b.H()) {
            alVar.v();
        }
        ((am) alVar.b).c = -999999999;
        al alVar2 = (al) am.a.q();
        if (!alVar2.b.H()) {
            alVar2.v();
        }
        ((am) alVar2.b).b = 315576000000L;
        if (!alVar2.b.H()) {
            alVar2.v();
        }
        ((am) alVar2.b).c = 999999999;
        al alVar3 = (al) am.a.q();
        if (!alVar3.b.H()) {
            alVar3.v();
        }
        ((am) alVar3.b).b = 0L;
        if (!alVar3.b.H()) {
            alVar3.v();
        }
        ((am) alVar3.b).c = 0;
        a = (am) alVar3.t();
    }

    public static am a(long j) {
        return b(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static am b(long j, int i) {
        if (i <= -1000000000 || i >= 1000000000) {
            j = g.b(j, i / 1000000000);
            i %= 1000000000;
        }
        if (j > 0 && i < 0) {
            i += 1000000000;
            j--;
        }
        if (j < 0 && i > 0) {
            i -= 1000000000;
            j++;
        }
        al alVar = (al) am.a.q();
        if (!alVar.b.H()) {
            alVar.v();
        }
        ((am) alVar.b).b = j;
        if (!alVar.b.H()) {
            alVar.v();
        }
        ((am) alVar.b).c = i;
        am amVar = (am) alVar.t();
        long j2 = amVar.b;
        int i2 = amVar.c;
        if (j2 < -315576000000L || j2 > 315576000000L || i2 < -999999999 || i2 >= 1000000000 || ((j2 < 0 || i2 < 0) && (j2 > 0 || i2 > 0))) {
            throw new IllegalArgumentException(bq.a("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j2), Integer.valueOf(i2)));
        }
        return amVar;
    }
}
