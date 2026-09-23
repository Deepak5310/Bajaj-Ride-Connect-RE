package com.google.android.libraries.navigation.internal.yr;

import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class e extends a {
    private final z b;

    public e(String str, ag agVar, z zVar, ae aeVar) {
        super(str, agVar, aeVar);
        com.google.android.libraries.navigation.internal.yx.ar.a(zVar.e);
        this.b = zVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final z h() {
        return z.a(this.b, i());
    }

    public e(String str, UUID uuid, z zVar, ae aeVar) {
        super(str, uuid, aeVar);
        com.google.android.libraries.navigation.internal.yx.ar.a(zVar.e);
        this.b = zVar;
    }
}
