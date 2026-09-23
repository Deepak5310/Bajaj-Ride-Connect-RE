package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ci implements com.google.android.libraries.navigation.internal.qv.e {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.ci");
    private final com.google.android.libraries.navigation.internal.kl.b b;
    private final com.google.android.libraries.navigation.internal.qv.j c;
    private final boolean d = false;

    public ci(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.qv.j jVar, boolean z) {
        this.b = bVar;
        this.c = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.e
    public final cl a(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, byte[] bArr, boolean z, com.google.android.libraries.navigation.internal.oe.as asVar) throws Throwable {
        try {
            cl clVarI = cq.i(sVar, anVar, cdVar, bArr, z, this.b, asVar, this.c.d(), false);
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(((com.google.android.libraries.geo.mapcore.internal.model.q) clVarI).a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1191)).y("Disk vector tile unpack result for tile type %s and coords %s - %s", anVar.name(), cdVar, ((com.google.android.libraries.geo.mapcore.internal.model.q) clVarI).a);
            return clVarI;
        } catch (RuntimeException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1192)).s("Unexpected exception unpacking disk vector tile at coords %s", cdVar);
            return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNEXPECTED_EXCEPTION, com.google.android.libraries.navigation.internal.yx.a.a);
        }
    }
}
