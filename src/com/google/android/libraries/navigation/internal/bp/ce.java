package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.jk;
import com.google.android.libraries.navigation.internal.adr.jo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ce {
    public final cc[] a;

    public ce(bg bgVar) {
        int i;
        jk jkVar;
        boolean z;
        com.google.android.libraries.navigation.internal.yx.ar.a(bgVar.j.equals(com.google.android.libraries.navigation.internal.ady.al.TRANSIT));
        cf cfVar = bgVar.g;
        int i2 = 0;
        com.google.android.libraries.navigation.internal.yx.ar.k(cfVar.b.length == 1);
        av avVar = cfVar.b[0];
        cc[] ccVarArr = new cc[avVar.a()];
        int i3 = 0;
        while (i3 < avVar.a()) {
            bt btVarB = avVar.b(i3);
            cc ccVar = null;
            if (btVarB.j()) {
                ArrayList arrayList = new ArrayList();
                jo joVarH = btVarB.h();
                int iA = com.google.android.libraries.navigation.internal.gz.b.a(joVarH.e, -12417548);
                jk jkVar2 = joVarH.c;
                arrayList.add(jkVar2 == null ? jk.a : jkVar2);
                arrayList.addAll(joVarH.g);
                jk jkVar3 = joVarH.d;
                arrayList.add(jkVar3 == null ? jk.a : jkVar3);
                cc ccVar2 = new cc();
                cd cdVarA = null;
                int i4 = i2;
                while (i4 < arrayList.size()) {
                    jk jkVar4 = (jk) arrayList.get(i4);
                    com.google.android.libraries.navigation.internal.adq.z zVar = jkVar4.d;
                    zVar = zVar == null ? com.google.android.libraries.navigation.internal.adq.z.a : zVar;
                    com.google.android.libraries.navigation.internal.oe.x xVarA = com.google.android.libraries.navigation.internal.oe.x.A(zVar.c, zVar.d);
                    jk jkVar5 = jkVar4;
                    List listAc = bgVar.ac(xVarA, xVarA.e() * 150.0d, bgVar.m.e() - 1, 10);
                    if (listAc.isEmpty()) {
                        new cb(jkVar5);
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F('N')).p("Stop does not map to polyline");
                        i = i4;
                    } else if (cdVarA == null) {
                        i = i4;
                        cdVarA = ccVar2.a(i4, (com.google.android.libraries.navigation.internal.oe.ag) listAc.get(i2), arrayList.size(), bgVar, jkVar5, iA, 0.0f);
                    } else {
                        i = i4;
                        Iterator it2 = listAc.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                jkVar = jkVar5;
                                z = false;
                                break;
                            }
                            com.google.android.libraries.navigation.internal.oe.ag agVar = (com.google.android.libraries.navigation.internal.oe.ag) it2.next();
                            double dB = bgVar.b(agVar);
                            jkVar = jkVar5;
                            if (dB > cdVarA.c) {
                                cdVarA = ccVar2.a(i, agVar, arrayList.size(), bgVar, jkVar, iA, (float) (dB - cdVarA.c));
                                z = true;
                                break;
                            }
                            jkVar5 = jkVar;
                        }
                        if (!z) {
                            new cb(jkVar);
                            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F('M')).p("Stop maps to earlier position on polyline");
                        }
                    }
                    i4 = i + 1;
                    i2 = 0;
                }
                ccVar = ccVar2;
            }
            ccVarArr[i3] = ccVar;
            i3++;
            i2 = 0;
        }
        this.a = ccVarArr;
    }
}
