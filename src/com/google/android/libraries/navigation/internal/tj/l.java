package com.google.android.libraries.navigation.internal.tj;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l extends a {
    public final String a;
    public final com.google.android.libraries.navigation.internal.vg.b b;
    private final Duration c;

    public l(com.google.android.libraries.navigation.internal.vg.b bVar, String str, Duration duration) {
        this.a = str;
        this.b = bVar;
        this.c = duration;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final Duration b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.INCIDENT_CALLOUT;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return true;
    }
}
