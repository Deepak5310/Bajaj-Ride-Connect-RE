package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.ax;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.av;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac {
    public final av a;
    public final String b;
    public final String c;
    public final ev d;
    public final int e;

    public ac(av avVar, int i, String str, String str2, ev evVar) {
        this.a = avVar;
        this.e = i;
        this.b = str;
        this.c = str2;
        this.d = evVar;
    }

    public final byte[] a(an anVar) {
        av avVar = this.a;
        if (avVar.j.startsWith("image/")) {
            com.google.android.libraries.navigation.internal.afb.b bVar = avVar.i;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.afb.b.a;
            }
            bh bhVarS = bi.s(com.google.android.libraries.navigation.internal.adi.z.b);
            bVar.h(bhVarS);
            if (bVar.w.n(bhVarS.d)) {
                com.google.android.libraries.navigation.internal.afb.b bVar2 = this.a.i;
                if (bVar2 == null) {
                    bVar2 = com.google.android.libraries.navigation.internal.afb.b.a;
                }
                bh bhVarS2 = bi.s(com.google.android.libraries.navigation.internal.adi.z.b);
                bVar2.h(bhVarS2);
                Object objK = bVar2.w.k(bhVarS2.d);
                bz bzVar = ((com.google.android.libraries.navigation.internal.adi.z) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).c;
                int size = bzVar.size();
                fw fwVar = new fw();
                for (int i = 0; i < size; i++) {
                    fwVar.k(((com.google.android.libraries.navigation.internal.adi.r) bzVar.get(i)).b);
                }
                int i2 = Calendar.getInstance().get(1);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (anVar == an.GMM_SATELLITE) {
                        int i3 = ev.d;
                        ax.b(lv.a, fwVar.i(), i2, new DataOutputStream(byteArrayOutputStream));
                    } else {
                        fy fyVarI = fwVar.i();
                        int i4 = ev.d;
                        ax.b(fyVarI, lv.a, i2, new DataOutputStream(byteArrayOutputStream));
                    }
                    byte[] bArr = new byte[byteArrayOutputStream.size() + this.a.d.d()];
                    System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 0, byteArrayOutputStream.size());
                    System.arraycopy(this.a.d.B(), 0, bArr, byteArrayOutputStream.size(), this.a.d.d());
                    return bArr;
                } catch (IOException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1115)).p("Unable to write copyright header");
                    return this.a.d.B();
                }
            }
        }
        return this.a.d.B();
    }
}
