package com.google.android.libraries.navigation.internal.abv;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewSource;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.u;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.abg.q;
import com.google.android.libraries.navigation.internal.afm.aq;
import com.google.android.libraries.navigation.internal.afm.aw;
import com.google.android.libraries.navigation.internal.afm.bd;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements j {
    public static final String a = "i";
    public final z b;
    public boolean c;
    h d;
    k e;
    private final f f;
    private final q g;
    private final Runnable h;
    private final Executor i;
    private final a j;

    public i(f fVar, q qVar, Runnable runnable) {
        Executor executorA = ah.a();
        z zVar = z.a;
        a aVar = a.b;
        s.k(fVar, "tileCache");
        this.f = fVar;
        s.k(qVar, "drd");
        this.g = qVar;
        s.k(runnable, "reportNetworkSuccessfulRunnable");
        this.h = runnable;
        this.i = executorA;
        s.k(zVar, "uiThreadChecker");
        this.b = zVar;
        s.k(aVar, "depthMapParser");
        this.j = aVar;
        synchronized (this) {
            this.c = false;
            this.d = null;
            this.e = null;
        }
    }

    static final com.google.android.libraries.navigation.internal.abu.a f(bd bdVar) {
        com.google.android.libraries.navigation.internal.abu.c[] cVarArr;
        byte[][] bArr;
        com.google.android.libraries.navigation.internal.abu.b[] bVarArr;
        byte[][] bArr2;
        com.google.android.libraries.navigation.internal.abu.a aVar;
        aw awVar = bdVar.g;
        if (awVar == null) {
            awVar = aw.a;
        }
        byte[] bArrB = awVar.c.B();
        aw awVar2 = bdVar.g;
        if (awVar2 == null) {
            awVar2 = aw.a;
        }
        byte[] bArrB2 = awVar2.d.B();
        if (bArrB == null || bArrB2 == null) {
            if (p.f(a.a, 5)) {
                Arrays.toString(bArrB);
                Arrays.toString(bArrB2);
            }
            return com.google.android.libraries.navigation.internal.abu.a.b;
        }
        try {
            b bVarA = a.a(bArrB);
            int unsignedByte = bVarA.readUnsignedByte();
            if (unsignedByte != 8) {
                throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(unsignedByte, "DepthMap has unexpected header size: "));
            }
            int unsignedShort = bVarA.readUnsignedShort();
            int unsignedShort2 = bVarA.readUnsignedShort();
            int unsignedShort3 = bVarA.readUnsignedShort();
            int unsignedByte2 = bVarA.readUnsignedByte();
            if (unsignedByte2 != 8) {
                throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(unsignedByte2, "DepthMap has unexpected plane indices offset: "));
            }
            if (unsignedShort <= 1 || unsignedShort2 == 0 || unsignedShort3 == 0) {
                throw new IOException(String.format("No plane data! [numPlanes,width,height]=[%s,%s,%s]", Integer.valueOf(unsignedShort), Integer.valueOf(unsignedShort2), Integer.valueOf(unsignedShort3)));
            }
            byte[] bArr3 = new byte[unsignedShort2 * unsignedShort3];
            bVarA.readFully(bArr3);
            byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, unsignedShort2, unsignedShort3);
            for (int i = 0; i < unsignedShort2; i++) {
                for (int i2 = 0; i2 < unsignedShort3; i2++) {
                    bArr4[i][i2] = bArr3[(i2 * unsignedShort2) + i];
                }
            }
            com.google.android.libraries.navigation.internal.abu.c[] cVarArr2 = new com.google.android.libraries.navigation.internal.abu.c[unsignedShort];
            for (int i3 = 0; i3 < 4; i3++) {
                bVarA.readFloat();
            }
            cVarArr2[0] = null;
            for (int i4 = 1; i4 < unsignedShort; i4++) {
                cVarArr2[i4] = new com.google.android.libraries.navigation.internal.abu.c(bVarA.readFloat(), bVarA.readFloat(), bVarA.readFloat(), bVarA.readFloat());
            }
            com.google.android.libraries.navigation.internal.abf.q qVar = new com.google.android.libraries.navigation.internal.abf.q(bArr4, cVarArr2);
            bArr = (byte[][]) qVar.a;
            cVarArr = (com.google.android.libraries.navigation.internal.abu.c[]) qVar.b;
            try {
                b bVarA2 = a.a(bArrB2);
                int unsignedByte3 = bVarA2.readUnsignedByte();
                if (unsignedByte3 != 8) {
                    throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(unsignedByte3, "PanoMap has unexpected header size: "));
                }
                int unsignedShort4 = bVarA2.readUnsignedShort();
                int unsignedShort5 = bVarA2.readUnsignedShort();
                int unsignedShort6 = bVarA2.readUnsignedShort();
                int unsignedByte4 = bVarA2.readUnsignedByte();
                if (unsignedByte4 != 8) {
                    throw new IOException(com.google.android.libraries.navigation.internal.b.b.b(unsignedByte4, "PanoMap has unexpected pano indices offset: "));
                }
                if (unsignedShort4 <= 1 || unsignedShort5 == 0 || unsignedShort6 == 0) {
                    throw new IOException(String.format("No pano data! [numPanos,width,height]=[%s,%s,%s]", Integer.valueOf(unsignedShort4), Integer.valueOf(unsignedShort5), Integer.valueOf(unsignedShort6)));
                }
                byte[] bArr5 = new byte[unsignedShort5 * unsignedShort6];
                bVarA2.readFully(bArr5);
                byte[][] bArr6 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, unsignedShort5, unsignedShort6);
                for (int i5 = 0; i5 < unsignedShort5; i5++) {
                    for (int i6 = 0; i6 < unsignedShort6; i6++) {
                        bArr6[i5][i6] = bArr5[(i6 * unsignedShort5) + i5];
                    }
                }
                String[] strArr = new String[unsignedShort4];
                strArr[0] = null;
                byte[] bArr7 = new byte[22];
                for (int i7 = 1; i7 < unsignedShort4; i7++) {
                    bVarA2.readFully(bArr7);
                    strArr[i7] = new String(bArr7);
                }
                com.google.android.libraries.navigation.internal.abu.b[] bVarArr2 = new com.google.android.libraries.navigation.internal.abu.b[unsignedShort4];
                bVarArr2[0] = null;
                for (int i8 = 1; i8 < unsignedShort4; i8++) {
                    bVarArr2[i8] = new com.google.android.libraries.navigation.internal.abu.b(strArr[i8], bVarA2.readFloat(), bVarA2.readFloat());
                }
                com.google.android.libraries.navigation.internal.abf.q qVar2 = new com.google.android.libraries.navigation.internal.abf.q(bArr6, bVarArr2);
                bArr2 = (byte[][]) qVar2.a;
                bVarArr = (com.google.android.libraries.navigation.internal.abu.b[]) qVar2.b;
                if (bArr != null && bArr2 != null) {
                    s.k(cVarArr, "planes");
                    s.k(bVarArr, "panos");
                    aVar = new com.google.android.libraries.navigation.internal.abu.a(bArr, cVarArr, bArr2, bVarArr);
                } else if (bArr != null) {
                    s.k(cVarArr, "planes");
                    aVar = new com.google.android.libraries.navigation.internal.abu.a(bArr, cVarArr, null, null);
                } else if (bArr2 != null) {
                    s.k(bVarArr, "panos");
                    aVar = new com.google.android.libraries.navigation.internal.abu.a(null, null, bArr2, bVarArr);
                } else {
                    aVar = com.google.android.libraries.navigation.internal.abu.a.b;
                }
                p.f(a.a, 4);
                return aVar;
            } catch (IOException | RuntimeException unused) {
                p.f(a.a, 6);
                bVarArr = null;
                bArr2 = null;
            }
        } catch (IOException | RuntimeException unused2) {
            p.f(a.a, 6);
            cVarArr = null;
            bArr = null;
        }
    }

    public final void a(String str, LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        String str2 = a;
        p.f(str2, 4);
        synchronized (this) {
            if (this.c) {
                return;
            }
            bd bdVarA = null;
            this.e = null;
            if (str != null) {
                this.e = new k(str, null, null, null, this, str, u.a, l.b);
                bdVarA = this.f.a(str);
            } else if (num != null && streetViewSource != null) {
                num.intValue();
                s.k(latLng, "latLng");
                this.e = new k(null, latLng, num, streetViewSource, this, String.format("%s@%sm:%s", latLng, num, streetViewSource), u.a, l.b);
            } else if (num != null) {
                num.intValue();
                s.k(latLng, "latLng");
                this.e = new k(null, latLng, num, null, this, String.format("%s@%sm", latLng, num), u.a, l.b);
            } else if (streetViewSource != null) {
                s.k(latLng, "latLng");
                this.e = new k(null, latLng, null, streetViewSource, this, String.format("%s:%s", latLng, streetViewSource), u.a, l.b);
            } else {
                s.k(latLng, "latLng");
                this.e = new k(null, latLng, null, null, this, String.valueOf(latLng), u.a, l.b);
            }
            k kVar = this.e;
            if (bdVarA == null) {
                p.f(str2, 4);
                this.g.j(kVar);
                return;
            }
            aq aqVar = bdVarA.c;
            if (aqVar == null) {
                aqVar = aq.a;
            }
            String str3 = aqVar.j;
            com.google.android.libraries.navigation.internal.abt.c cVar = new com.google.android.libraries.navigation.internal.abt.c(str, bdVarA, f(bdVarA));
            p.f(str2, 4);
            e(kVar, cVar);
        }
    }

    public final synchronized void b() {
        this.b.a();
        if (this.c) {
            p.f(a, 5);
            return;
        }
        p.f(a, 4);
        this.c = true;
        this.d = null;
        this.e = null;
    }

    @Override // com.google.android.libraries.navigation.internal.abv.j
    public final void c(k kVar, bd bdVar, byte[] bArr) {
        String str = a;
        p.f(str, 3);
        synchronized (this) {
            if (this.c) {
                return;
            }
            if (bdVar == null) {
                p.f(str, 6);
                e(kVar, com.google.android.libraries.navigation.internal.abt.c.a);
                return;
            }
            this.h.run();
            aq aqVar = bdVar.c;
            if (aqVar == null) {
                aqVar = aq.a;
            }
            f fVar = this.f;
            String str2 = aqVar.j;
            fVar.c(str2, bdVar);
            if (bArr != null) {
                this.f.b(new com.google.android.libraries.navigation.internal.abt.d(str2, 0, 0, 0), bArr);
            } else {
                p.f(str, 6);
            }
            String str3 = kVar.b;
            if (str3 != null && !r.a(str3, str2)) {
                p.f(str, 4);
                this.f.c(kVar.b, bdVar);
                if (bArr != null) {
                    this.f.b(new com.google.android.libraries.navigation.internal.abt.d(kVar.b, 0, 0, 0), bArr);
                }
            }
            e(kVar, new com.google.android.libraries.navigation.internal.abt.c(kVar.b, bdVar, f(bdVar)));
        }
    }

    public final synchronized void d(h hVar) {
        this.b.a();
        if (this.c) {
            return;
        }
        this.d = hVar;
    }

    final void e(final k kVar, final com.google.android.libraries.navigation.internal.abt.c cVar) {
        s.k(kVar, "StreetViewMetadataProtoRequest");
        s.k(cVar, "StreetViewPanoTarget");
        synchronized (this) {
            if (!this.c && r.a(kVar, this.e)) {
                this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abv.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        i iVar = this.a;
                        iVar.b.a();
                        k kVar2 = kVar;
                        s.k(kVar2, "StreetViewMetadataProtoRequest");
                        com.google.android.libraries.navigation.internal.abt.c cVar2 = cVar;
                        s.k(cVar2, "StreetViewPanoTarget");
                        synchronized (iVar) {
                            if (!iVar.c && r.a(iVar.e, kVar2)) {
                                iVar.e = null;
                                h hVar = iVar.d;
                                if (hVar != null) {
                                    p.f(i.a, 4);
                                    hVar.q(cVar2);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
