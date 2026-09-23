package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.geo.mapcore.internal.model.ck;
import com.google.android.libraries.geo.mapcore.internal.model.cl;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class bm implements com.google.android.libraries.navigation.internal.qv.e {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qu.bm");
    private final bo b;

    public bm(bo boVar) {
        this.b = boVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ee  */
    @Override // com.google.android.libraries.navigation.internal.qv.e
    public final cl a(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, byte[] bArr, boolean z, com.google.android.libraries.navigation.internal.oe.as asVar) {
        cl qVar;
        byte[] bArr2;
        com.google.android.libraries.geo.mapcore.internal.model.ac acVar;
        try {
            if (!z) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1181)).s("unpacking uncompressed tiles not supported for %s tile type", anVar.name());
                anVar.name();
                return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNSUPPORTED_FORMAT, com.google.android.libraries.navigation.internal.yx.a.a);
            }
            try {
                int length = bArr.length;
                if (length == 0) {
                    acVar = new com.google.android.libraries.geo.mapcore.internal.model.ac(sVar, anVar, cdVar, bArr, asVar, 0);
                } else {
                    if (bArr[0] == com.google.android.libraries.navigation.internal.oe.w.a[0]) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                        if (dataInputStream.readInt() == 1146241364) {
                            int iA = com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream);
                            if (iA != 7 && iA != 8) {
                                throw new IOException(com.google.android.libraries.navigation.internal.b.b.j(iA, "Version mismatch: 7 or 8 expected, ", " found"));
                            }
                            com.google.android.libraries.geo.mapcore.internal.model.cd cdVar2 = new com.google.android.libraries.geo.mapcore.internal.model.cd(com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream), com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream), com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream));
                            if (cdVar2.b != cdVar.b || cdVar2.c != cdVar.c || cdVar2.a != cdVar.a) {
                                throw new IOException("Expected tile coords: " + String.valueOf(cdVar) + " but received " + cdVar2.toString());
                            }
                            com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream);
                            int iA2 = com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream);
                            int iA3 = com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream);
                            int iA4 = com.google.android.libraries.navigation.internal.gz.j.a(dataInputStream);
                            if (iA2 < 0 || iA3 < 0) {
                                throw new IOException(com.google.android.libraries.navigation.internal.b.b.l(iA3, iA2, "The tile image dimensions were invalid (width=", ", height="));
                            }
                            if (iA4 < 0) {
                                throw new IOException(com.google.android.libraries.navigation.internal.b.b.j(iA4, "The tile image size of ", " is not valid"));
                            }
                            byte[] bArr3 = new byte[iA4];
                            dataInputStream.readFully(bArr3);
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArr;
                        }
                    } else {
                        bArr2 = bArr;
                    }
                    acVar = new com.google.android.libraries.geo.mapcore.internal.model.ac(sVar, anVar, cdVar, bArr2, asVar, length);
                }
                qVar = cl.c(acVar, ck.SUCCESS);
            } catch (IOException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1177)).p("Error unpacking image tile");
                qVar = new com.google.android.libraries.geo.mapcore.internal.model.q(ck.IO_ERROR, com.google.android.libraries.navigation.internal.yx.a.a);
            }
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(((com.google.android.libraries.geo.mapcore.internal.model.q) qVar).a == ck.SUCCESS ? Level.FINE : Level.WARNING).F(1178)).y("Disk vector tile unpack result for tile type %s and coords %s - %s", anVar.name(), cdVar, ((com.google.android.libraries.geo.mapcore.internal.model.q) qVar).a);
            return qVar;
        } catch (RuntimeException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1179)).s("Unexpected exception unpacking disk image tile at coords %s", cdVar);
            return new com.google.android.libraries.geo.mapcore.internal.model.q(ck.UNEXPECTED_EXCEPTION, com.google.android.libraries.navigation.internal.yx.a.a);
        }
    }
}
