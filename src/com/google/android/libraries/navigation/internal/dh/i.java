package com.google.android.libraries.navigation.internal.dh;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final long e;

    public i(long j, long j2, int i, int i2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = i2;
        this.e = j3;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("ble-beacon").g("eidmsb", this.a).g("eidlsb", this.b).f("rssi", this.c).f("power", this.d).g("timeNs", this.e);
    }

    public final String toString() {
        return String.format(Locale.US, "EID: %s %s, rssi: %d, power: %d, timeNS: %d", Long.toHexString(this.a), Long.toHexString(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Long.valueOf(this.e));
    }
}
