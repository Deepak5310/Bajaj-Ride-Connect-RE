package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bn implements com.google.android.libraries.navigation.internal.qv.f {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.bn");
    private final bo b;

    public bn(bo boVar) {
        this.b = boVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qv.f
    public final cl a(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, byte[] bArr, com.google.android.libraries.navigation.internal.oe.as asVar) {
        cl qVar;
        try {
            try {
                qVar = cl.c(new com.google.android.libraries.geo.mapcore.internal.model.ac(sVar, anVar, cdVar, bArr, asVar, bArr.length), ck.SUCCESS);
            } catch (IOException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1184)).s("Error unpacking images tile at coords %s", cdVar);
                qVar = new com.google.android.libraries.geo.mapcore.internal.model.q(ck.IO_ERROR, com.google.android.libraries.navigation.internal.yx.a.a);
            }
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(((com.google.android.libraries.geo.mapcore.internal.model.q) qVar).a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1182)).y("Network image tile unpack result for tile type %s and coords %s - %s", anVar.name(), cdVar, qVar);
            return qVar;
        } catch (RuntimeException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1183)).s("Unexpected exception unpacking disk image tile at coords %s", cdVar);
            return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNEXPECTED_EXCEPTION, com.google.android.libraries.navigation.internal.yx.a.a);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qv.f
    public final boolean b(byte[] bArr) throws IOException {
        return true;
    }
}
