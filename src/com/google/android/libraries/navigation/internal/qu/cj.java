package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class cj implements com.google.android.libraries.navigation.internal.qv.f {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.cj");
    private final com.google.android.libraries.navigation.internal.kl.b b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.qv.j d;
    private final boolean e = false;

    public cj(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.qv.j jVar, boolean z) {
        this.b = bVar;
        this.c = aVar;
        this.d = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.f
    public final cl a(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, byte[] bArr, com.google.android.libraries.navigation.internal.oe.as asVar) throws Throwable {
        try {
            cl clVarI = cq.i(sVar, anVar, cdVar, bArr, true, this.b, asVar, this.d.d(), false);
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(((com.google.android.libraries.geo.mapcore.internal.model.q) clVarI).a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1193)).y("Network vector tile unpack result for tile type %s and coords %s - %s", anVar.name(), cdVar, clVarI);
            return clVarI;
        } catch (RuntimeException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1194)).s("Unexpected exception unpacking network vector tile at coords %s", cdVar);
            return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNEXPECTED_EXCEPTION, com.google.android.libraries.navigation.internal.yx.a.a);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.f
    public final boolean b(byte[] bArr) throws IOException {
        return com.google.android.libraries.geo.mapcore.internal.model.ch.e(cq.g(bArr), ((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) this.c.a()).e()).a);
    }
}
