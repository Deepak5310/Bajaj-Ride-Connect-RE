package com.google.android.libraries.navigation.internal.fi;

import com.google.android.libraries.navigation.internal.bp.ao;
import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public static double a(ao aoVar, double d) {
        int iRound = (int) Math.round(Math.ceil(d));
        double dA = aoVar.a(Duration.ofSeconds(iRound - 1));
        double dA2 = aoVar.a(Duration.ofSeconds(iRound));
        return dA2 + ((dA - dA2) * (((double) iRound) - d));
    }
}
