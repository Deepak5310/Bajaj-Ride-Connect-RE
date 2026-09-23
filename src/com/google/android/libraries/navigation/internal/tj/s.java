package com.google.android.libraries.navigation.internal.tj;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends a {
    public static final Duration a = Duration.ofSeconds(2);

    @Override // com.google.android.libraries.navigation.internal.tj.a, com.google.android.libraries.navigation.internal.tj.u
    public final Duration b() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.OFFLINE_TO_ONLINE_TRANSITION;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return false;
    }
}
