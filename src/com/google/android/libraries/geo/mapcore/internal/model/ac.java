package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afm.cv;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ac implements cc {
    public final cd a;
    public final byte[] b;
    public int c;
    public final ev d;
    public final ev e;
    public final int f;
    private final com.google.android.libraries.navigation.internal.adi.an g;
    private final int h;
    private com.google.android.libraries.navigation.internal.dm.s i;
    private com.google.android.libraries.navigation.internal.oe.as j;

    public ac(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.adi.an anVar, cd cdVar, byte[] bArr, com.google.android.libraries.navigation.internal.oe.as asVar, int i) throws IOException {
        int length;
        int i2;
        ev evVarG;
        ev evVarG2;
        int i3;
        this.a = cdVar;
        this.g = anVar;
        this.j = asVar;
        this.h = i;
        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) sVar.aH(5, null);
        bbVar.x(sVar);
        com.google.android.libraries.navigation.internal.dm.r rVar = (com.google.android.libraries.navigation.internal.dm.r) bbVar;
        if (!rVar.b.H()) {
            rVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.s sVar2 = (com.google.android.libraries.navigation.internal.dm.s) rVar.b;
        com.google.android.libraries.navigation.internal.dm.s sVar3 = com.google.android.libraries.navigation.internal.dm.s.a;
        sVar2.b |= 128;
        sVar2.j = 1;
        this.i = (com.google.android.libraries.navigation.internal.dm.s) rVar.t();
        int i4 = ev.d;
        ev evVar = lv.a;
        ev evVar2 = lv.a;
        int i5 = -1;
        if (bArr != null && (length = bArr.length) != 0) {
            ax axVar = new ax();
            byte[] bArr2 = ax.b;
            if (length < 5) {
                i2 = 0;
                break;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= 5) {
                    try {
                        byte[] bArr3 = new byte[4];
                        System.arraycopy(bArr, 5, bArr3, 0, 4);
                        com.google.android.libraries.navigation.internal.yx.ar.g(true, "array too small: %s < %s", 4, 4);
                        int iB = com.google.android.libraries.navigation.internal.zy.i.b(bArr3[0], bArr3[1], bArr3[2], bArr3[3]);
                        int iAbs = Math.abs(iB);
                        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 9, iAbs);
                        byteArrayInputStream = iB < 0 ? new GZIPInputStream(byteArrayInputStream) : byteArrayInputStream;
                        axVar.c = (cv) ((dg) cv.a.aH(7, null)).e(byteArrayInputStream);
                        byteArrayInputStream.close();
                        axVar.d = null;
                        i2 = iAbs + 9;
                        break;
                    } catch (IOException e) {
                        ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) ax.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1082)).p("IOException reading map tile info");
                        i2 = 0;
                        break;
                    }
                }
                if (bArr[i6] == bArr2[i6]) {
                    i6++;
                }
                i2 = 0;
                break;
            }
            this.c = length - i2 < 0 ? -1 : i2;
            com.google.android.libraries.navigation.internal.afm.cr crVarA = axVar.a();
            if (crVarA == null) {
                evVarG = lv.a;
            } else {
                int size = crVarA.c.size();
                eq eqVarJ = ev.j(size);
                for (int i7 = 0; i7 < size; i7++) {
                    eqVarJ.h((String) crVarA.c.get(i7));
                }
                evVarG = eqVarJ.g();
            }
            com.google.android.libraries.navigation.internal.afm.cr crVarA2 = axVar.a();
            if (crVarA2 == null) {
                evVarG2 = lv.a;
            } else {
                int size2 = crVarA2.d.size();
                eq eqVarJ2 = ev.j(size2);
                for (int i8 = 0; i8 < size2; i8++) {
                    eqVarJ2.h((String) crVarA2.d.get(i8));
                }
                evVarG2 = eqVarJ2.g();
            }
            evVar2 = evVarG2;
            com.google.android.libraries.navigation.internal.afm.cr crVarA3 = axVar.a();
            if (crVarA3 != null && (crVarA3.b & 1) != 0 && (i3 = crVarA3.e) != 0) {
                i5 = i3;
            }
            int i9 = this.c;
            if (i9 >= 0 && bArr[i9] == 67) {
                try {
                    bArr = com.google.android.libraries.navigation.internal.abb.c.b(bArr, i9, bArr.length - i9);
                } catch (UnsupportedOperationException e2) {
                    throw new IOException("Input image is not Compact JPEG", e2);
                }
            }
            evVar = evVarG;
        }
        this.b = bArr;
        this.d = evVar;
        this.e = evVar2;
        this.f = i5;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final int a() {
        return this.h;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.dm.s b() {
        return this.i;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized com.google.android.libraries.navigation.internal.oe.as c() {
        return this.j;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final com.google.android.libraries.navigation.internal.adi.an d() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void e(com.google.android.libraries.navigation.internal.dm.s sVar) {
        this.i = sVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.cc
    public final synchronized void f(com.google.android.libraries.navigation.internal.oe.as asVar) {
        this.j = asVar;
    }
}
