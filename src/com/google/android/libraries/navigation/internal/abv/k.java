package com.google.android.libraries.navigation.internal.abv;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewSource;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.u;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afm.bd;
import com.google.android.libraries.navigation.internal.afm.be;
import com.google.android.libraries.navigation.internal.afm.bi;
import com.google.android.libraries.navigation.internal.afm.bm;
import com.google.android.libraries.navigation.internal.afm.bx;
import com.google.android.libraries.navigation.internal.afm.cl;
import com.google.android.libraries.navigation.internal.afm.y;
import com.google.android.libraries.navigation.internal.afm.z;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.abg.h {
    private static final String f = "k";
    public final String b;
    public final LatLng c;
    public final Integer d;
    public final StreetViewSource e;
    private final j g;
    private final String h;
    private final u i;
    private final l j;

    public k(String str, LatLng latLng, Integer num, StreetViewSource streetViewSource, j jVar, String str2, u uVar, l lVar) {
        s.a((str == null && latLng == null) ? false : true, "Failed to provide PanoID or LatLng.");
        s.a(str == null || latLng == null, "Cannot set both PanoID and LatLng.");
        this.b = str;
        this.c = latLng;
        this.d = num;
        this.e = streetViewSource;
        s.k(jVar, "callback");
        this.g = jVar;
        s.k(str2, "debugStr");
        this.h = str2;
        this.i = uVar;
        s.k(lVar, "streetViewProtoDefaults");
        this.j = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final void b() {
        super.b();
        p.f(f, 6);
        this.g.c(this, null, null);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return r.a(this.b, kVar.b) && r.a(this.c, kVar.c) && r.a(this.d, kVar.d) && r.a(this.e, kVar.e);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 40;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e});
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        be beVarA = this.j.a(0, 0, 0);
        bi biVar = l.d;
        if (!beVarA.b.H()) {
            beVarA.v();
        }
        bx bxVar = (bx) beVarA.b;
        bx bxVar2 = bx.a;
        biVar.getClass();
        bxVar.h = biVar;
        bxVar.b |= 32;
        String str = this.b;
        if (str != null) {
            if (!beVarA.b.H()) {
                beVarA.v();
            }
            bx bxVar3 = (bx) beVarA.b;
            bxVar3.b |= 1;
            bxVar3.c = str;
        } else {
            LatLng latLng = this.c;
            s.k(latLng, "LatLng");
            y yVar = (y) z.a.q();
            int iO = com.google.android.libraries.navigation.internal.abw.k.o(latLng.latitude);
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar = (z) yVar.b;
            zVar.b |= 1;
            zVar.c = iO;
            int iO2 = com.google.android.libraries.navigation.internal.abw.k.o(latLng.longitude);
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar2 = (z) yVar.b;
            zVar2.b |= 2;
            zVar2.d = iO2;
            z zVar3 = (z) yVar.t();
            if (!beVarA.b.H()) {
                beVarA.v();
            }
            bx bxVar4 = (bx) beVarA.b;
            zVar3.getClass();
            bxVar4.d = zVar3;
            bxVar4.b |= 2;
            Integer num = this.d;
            if (num != null) {
                int iIntValue = num.intValue();
                if (!beVarA.b.H()) {
                    beVarA.v();
                }
                bx bxVar5 = (bx) beVarA.b;
                bxVar5.b |= 4;
                bxVar5.e = iIntValue;
            }
            if (r.a(this.e, StreetViewSource.OUTDOOR)) {
                bm bmVar = bm.OUTDOOR;
                if (!beVarA.b.H()) {
                    beVarA.v();
                }
                bx bxVar6 = (bx) beVarA.b;
                bxVar6.f = bmVar.c;
                bxVar6.b |= 8;
            }
        }
        bx bxVar7 = (bx) beVarA.t();
        if (p.f(f, 4)) {
            com.google.android.libraries.navigation.internal.abw.l.b(bxVar7);
        }
        this.i.b(dataOutputStream, bxVar7);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        cl clVar = (cl) this.i.a((dg) cl.a.aH(7, null), dataInputStream);
        String str = f;
        if (p.f(str, 4)) {
            com.google.android.libraries.navigation.internal.abw.l.c(clVar);
        }
        int i = clVar.b;
        if ((i & 1) == 0 || (i & 2) == 0) {
            if (p.f(str, 6)) {
                com.google.android.libraries.navigation.internal.abw.l.c(clVar);
            }
            this.g.c(this, null, null);
        } else {
            byte[] bArr = (byte[]) this.j.b(clVar).get(new com.google.android.libraries.navigation.internal.abt.d(clVar.c, 0, 0, 0));
            j jVar = this.g;
            bd bdVar = clVar.d;
            if (bdVar == null) {
                bdVar = bd.a;
            }
            jVar.c(this, bdVar, bArr);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h
    public final String toString() {
        return String.format("StreetViewMetadataProtoRequest[%s]", this.h);
    }
}
