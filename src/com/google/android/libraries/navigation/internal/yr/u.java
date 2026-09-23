package com.google.android.libraries.navigation.internal.yr;

import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends e {
    static final u b = new u();
    private static final UUID c = UUID.randomUUID();

    public u() {
        super("<skip trace>", c, y.a, i.a());
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final z i() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final ag j(String str, z zVar, ae aeVar) {
        throw new IllegalStateException("Can't create child trace for no trace!");
    }
}
