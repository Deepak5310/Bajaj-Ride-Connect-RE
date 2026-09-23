package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class da {
    final Long a;
    final Boolean b;
    final Integer c;
    final Integer d;
    final ee e;
    final ba f;

    public da(Map map, boolean z, int i, int i2) {
        ee eeVar;
        ba baVar;
        this.a = bw.d(map, "timeout");
        this.b = bw.a(map, "waitForReady");
        Integer numC = bw.c(map, "maxResponseMessageBytes");
        this.c = numC;
        if (numC != null) {
            com.google.android.libraries.navigation.internal.yx.ar.f(numC.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numC);
        }
        Integer numC2 = bw.c(map, "maxRequestMessageBytes");
        this.d = numC2;
        if (numC2 != null) {
            com.google.android.libraries.navigation.internal.yx.ar.f(numC2.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numC2);
        }
        Map mapI = z ? bw.i(map, "retryPolicy") : null;
        if (mapI == null) {
            eeVar = null;
        } else {
            Integer numC3 = bw.c(mapI, "maxAttempts");
            com.google.android.libraries.navigation.internal.yx.ar.r(numC3, "maxAttempts cannot be empty");
            int iIntValue = numC3.intValue();
            com.google.android.libraries.navigation.internal.yx.ar.d(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i);
            Long lD = bw.d(mapI, "initialBackoff");
            com.google.android.libraries.navigation.internal.yx.ar.r(lD, "initialBackoff cannot be empty");
            long jLongValue = lD.longValue();
            com.google.android.libraries.navigation.internal.yx.ar.e(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            Long lD2 = bw.d(mapI, "maxBackoff");
            com.google.android.libraries.navigation.internal.yx.ar.r(lD2, "maxBackoff cannot be empty");
            long jLongValue2 = lD2.longValue();
            com.google.android.libraries.navigation.internal.yx.ar.e(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            Double dB = bw.b(mapI, "backoffMultiplier");
            com.google.android.libraries.navigation.internal.yx.ar.r(dB, "backoffMultiplier cannot be empty");
            double dDoubleValue = dB.doubleValue();
            com.google.android.libraries.navigation.internal.yx.ar.f(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", dB);
            Long lD3 = bw.d(mapI, "perAttemptRecvTimeout");
            com.google.android.libraries.navigation.internal.yx.ar.f(lD3 == null || lD3.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lD3);
            Set setA = em.a(mapI, "retryableStatusCodes");
            com.google.android.libraries.navigation.internal.yx.ca.b(setA != null, "%s is required in retry policy", "retryableStatusCodes");
            com.google.android.libraries.navigation.internal.yx.ca.b(!setA.contains(com.google.android.libraries.navigation.internal.afx.ci.OK), "%s must not contain OK", "retryableStatusCodes");
            com.google.android.libraries.navigation.internal.yx.ar.b((lD3 == null && setA.isEmpty()) ? false : true, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            eeVar = new ee(iMin, jLongValue, jLongValue2, dDoubleValue, lD3, setA);
        }
        this.e = eeVar;
        Map mapI2 = z ? bw.i(map, "hedgingPolicy") : null;
        if (mapI2 == null) {
            baVar = null;
        } else {
            Integer numC4 = bw.c(mapI2, "maxAttempts");
            com.google.android.libraries.navigation.internal.yx.ar.r(numC4, "maxAttempts cannot be empty");
            int iIntValue2 = numC4.intValue();
            com.google.android.libraries.navigation.internal.yx.ar.d(iIntValue2 >= 2, "maxAttempts must be greater than 1: %s", iIntValue2);
            int iMin2 = Math.min(iIntValue2, i2);
            Long lD4 = bw.d(mapI2, "hedgingDelay");
            com.google.android.libraries.navigation.internal.yx.ar.r(lD4, "hedgingDelay cannot be empty");
            long jLongValue3 = lD4.longValue();
            com.google.android.libraries.navigation.internal.yx.ar.e(jLongValue3 >= 0, "hedgingDelay must not be negative: %s", jLongValue3);
            Set setA2 = em.a(mapI2, "nonFatalStatusCodes");
            if (setA2 == null) {
                setA2 = Collections.unmodifiableSet(EnumSet.noneOf(com.google.android.libraries.navigation.internal.afx.ci.class));
            } else {
                com.google.android.libraries.navigation.internal.yx.ca.b(!setA2.contains(com.google.android.libraries.navigation.internal.afx.ci.OK), "%s must not contain OK", "nonFatalStatusCodes");
            }
            baVar = new ba(iMin2, jLongValue3, setA2);
        }
        this.f = baVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof da)) {
            return false;
        }
        da daVar = (da) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, daVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, daVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, daVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.d, daVar.d) && com.google.android.libraries.navigation.internal.yx.am.a(this.e, daVar.e) && com.google.android.libraries.navigation.internal.yx.am.a(this.f, daVar.f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("timeoutNanos", this.a);
        akVarB.g("waitForReady", this.b);
        akVarB.g("maxInboundMessageSize", this.c);
        akVarB.g("maxOutboundMessageSize", this.d);
        akVarB.g("retryPolicy", this.e);
        akVarB.g("hedgingPolicy", this.f);
        return akVarB.toString();
    }
}
