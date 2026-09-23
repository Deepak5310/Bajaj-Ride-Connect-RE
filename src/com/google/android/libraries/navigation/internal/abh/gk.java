package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.navigation.internal.afl.ir;
import com.google.android.libraries.navigation.internal.afl.is;
import com.google.android.libraries.navigation.internal.afl.iv;
import com.google.android.libraries.navigation.internal.afl.iw;
import com.google.android.libraries.navigation.internal.afl.iy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gk extends com.google.android.libraries.navigation.internal.abg.h {
    public gi b;
    private final LatLng c;
    private final float d;
    private gj[] e = null;

    public gk(LatLng latLng, float f) {
        this.c = latLng;
        this.d = f;
    }

    private static int m(double d) {
        return (int) Math.round(d * 1000000.0d);
    }

    private static com.google.android.libraries.navigation.internal.afm.z n(LatLng latLng) {
        com.google.android.libraries.navigation.internal.afm.y yVar = (com.google.android.libraries.navigation.internal.afm.y) com.google.android.libraries.navigation.internal.afm.z.a.q();
        int iM = m(latLng.latitude);
        if (!yVar.b.H()) {
            yVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.z zVar = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
        zVar.b |= 1;
        zVar.c = iM;
        int iM2 = m(latLng.longitude);
        if (!yVar.b.H()) {
            yVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.z zVar2 = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
        zVar2.b |= 2;
        zVar2.d = iM2;
        return (com.google.android.libraries.navigation.internal.afm.z) yVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final void a() {
        super.a();
        gi giVar = this.b;
        if (giVar != null) {
            giVar.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 50;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        ir irVar = (ir) is.a.q();
        com.google.android.libraries.navigation.internal.afm.s sVar = (com.google.android.libraries.navigation.internal.afm.s) com.google.android.libraries.navigation.internal.afm.v.a.q();
        int i = com.google.android.libraries.navigation.internal.afm.u.a;
        if (!sVar.b.H()) {
            sVar.v();
        }
        LatLng latLng = this.c;
        com.google.android.libraries.navigation.internal.afm.v vVar = (com.google.android.libraries.navigation.internal.afm.v) sVar.b;
        if (i == 0) {
            throw null;
        }
        vVar.c = i;
        vVar.b |= 1;
        com.google.android.libraries.navigation.internal.afm.z zVarN = n(latLng);
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.v vVar2 = (com.google.android.libraries.navigation.internal.afm.v) sVar.b;
        zVarN.getClass();
        vVar2.d = zVarN;
        vVar2.b |= 2;
        com.google.android.libraries.navigation.internal.afm.v vVar3 = (com.google.android.libraries.navigation.internal.afm.v) sVar.t();
        if (!irVar.b.H()) {
            irVar.v();
        }
        is isVar = (is) irVar.b;
        vVar3.getClass();
        isVar.c = vVar3;
        isVar.b |= 1;
        LatLng latLng2 = this.c;
        float f = this.d;
        com.google.android.libraries.navigation.internal.afm.w wVar = (com.google.android.libraries.navigation.internal.afm.w) com.google.android.libraries.navigation.internal.afm.x.a.q();
        com.google.android.libraries.navigation.internal.afm.z zVarN2 = n(latLng2);
        if (!wVar.b.H()) {
            wVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.x xVar = (com.google.android.libraries.navigation.internal.afm.x) wVar.b;
        zVarN2.getClass();
        xVar.c = zVarN2;
        xVar.b |= 1;
        int iM = m(1.0E-6d);
        if (!wVar.b.H()) {
            wVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.x xVar2 = (com.google.android.libraries.navigation.internal.afm.x) wVar.b;
        xVar2.b |= 2;
        xVar2.d = iM;
        int iM2 = m(1.0E-6d);
        if (!wVar.b.H()) {
            wVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.x xVar3 = (com.google.android.libraries.navigation.internal.afm.x) wVar.b;
        xVar3.b |= 4;
        xVar3.e = iM2;
        if (f > 0.0f) {
            int i2 = (int) f;
            if (!wVar.b.H()) {
                wVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.x xVar4 = (com.google.android.libraries.navigation.internal.afm.x) wVar.b;
            xVar4.b |= 8;
            xVar4.f = i2;
        }
        com.google.android.libraries.navigation.internal.afm.x xVar5 = (com.google.android.libraries.navigation.internal.afm.x) wVar.t();
        if (!irVar.b.H()) {
            irVar.v();
        }
        is isVar2 = (is) irVar.b;
        xVar5.getClass();
        isVar2.d = xVar5;
        isVar2.b |= 4;
        if (!irVar.b.H()) {
            irVar.v();
        }
        is isVar3 = (is) irVar.b;
        isVar3.b |= 8;
        isVar3.e = true;
        com.google.android.libraries.navigation.internal.abf.u.a.b(dataOutputStream, (is) irVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        iw iwVar = (iw) com.google.android.libraries.navigation.internal.abf.u.a.a((com.google.android.libraries.navigation.internal.ael.dg) iw.a.aH(7, null), dataInputStream);
        int iA = iv.a(iwVar.b);
        if (iA == 0) {
            iA = iv.a;
        }
        if (iA == iv.a) {
            this.e = new gj[iwVar.c.size()];
            int i = 0;
            for (iy iyVar : iwVar.c) {
                String str = iyVar.b.size() > 0 ? (String) iyVar.b.get(0) : "";
                if (iyVar.b.size() > 1) {
                    str = (String) iyVar.b.get(1);
                }
                this.e[i] = new gj(str);
                i++;
            }
        }
    }

    public final int k() {
        gj[] gjVarArr = this.e;
        if (gjVarArr != null) {
            return gjVarArr.length;
        }
        return 0;
    }

    public final gj l() {
        gj[] gjVarArr = this.e;
        if (gjVarArr.length <= 0) {
            return null;
        }
        return gjVarArr[0];
    }
}
