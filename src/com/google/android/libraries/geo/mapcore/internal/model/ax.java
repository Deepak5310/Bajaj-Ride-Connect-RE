package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.afm.cu;
import com.google.android.libraries.navigation.internal.afm.cv;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ax {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.model.ax");
    public static final byte[] b = {76, 84, 73, 80, 10};
    public cv c;
    public com.google.android.libraries.navigation.internal.afm.cr d;

    public static void b(Collection collection, Collection collection2, int i, DataOutputStream dataOutputStream) throws IOException {
        cu cuVar = (cu) cv.a.q();
        if (collection != null || collection2 != null) {
            com.google.android.libraries.navigation.internal.afm.cq cqVar = (com.google.android.libraries.navigation.internal.afm.cq) com.google.android.libraries.navigation.internal.afm.cr.a.q();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!cqVar.b.H()) {
                    cqVar.v();
                }
                com.google.android.libraries.navigation.internal.afm.cr crVar = (com.google.android.libraries.navigation.internal.afm.cr) cqVar.b;
                str.getClass();
                com.google.android.libraries.navigation.internal.ael.bz bzVar = crVar.c;
                if (!bzVar.c()) {
                    crVar.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                }
                crVar.c.add(str);
            }
            Iterator it3 = collection2.iterator();
            while (it3.hasNext()) {
                String str2 = (String) it3.next();
                if (!cqVar.b.H()) {
                    cqVar.v();
                }
                com.google.android.libraries.navigation.internal.afm.cr crVar2 = (com.google.android.libraries.navigation.internal.afm.cr) cqVar.b;
                str2.getClass();
                com.google.android.libraries.navigation.internal.ael.bz bzVar2 = crVar2.d;
                if (!bzVar2.c()) {
                    crVar2.d = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar2);
                }
                crVar2.d.add(str2);
            }
            if (!cqVar.b.H()) {
                cqVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.cr crVar3 = (com.google.android.libraries.navigation.internal.afm.cr) cqVar.b;
            crVar3.b |= 1;
            crVar3.e = i;
            if (!cuVar.b.H()) {
                cuVar.v();
            }
            cv cvVar = (cv) cuVar.b;
            com.google.android.libraries.navigation.internal.afm.cr crVar4 = (com.google.android.libraries.navigation.internal.afm.cr) cqVar.t();
            crVar4.getClass();
            cvVar.c = crVar4;
            cvVar.b |= 4;
        }
        dataOutputStream.write(b);
        com.google.android.libraries.navigation.internal.ael.bi biVarT = cuVar.t();
        new DataOutputStream(dataOutputStream).writeInt(biVarT.p());
        biVarT.l(dataOutputStream);
    }

    public final com.google.android.libraries.navigation.internal.afm.cr a() {
        cv cvVar;
        if (this.d == null && (cvVar = this.c) != null && (cvVar.b & 4) != 0) {
            com.google.android.libraries.navigation.internal.afm.cr crVar = cvVar.c;
            if (crVar == null) {
                crVar = com.google.android.libraries.navigation.internal.afm.cr.a;
            }
            this.d = crVar;
        }
        return this.d;
    }
}
