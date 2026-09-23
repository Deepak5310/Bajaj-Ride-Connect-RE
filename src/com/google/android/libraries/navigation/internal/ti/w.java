package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.bt;
import com.google.android.libraries.navigation.internal.db.ap;
import com.google.android.libraries.navigation.internal.db.aq;
import com.google.android.libraries.navigation.internal.zs.Cdo;
import com.google.android.libraries.navigation.internal.zs.dm;
import com.google.android.libraries.navigation.internal.zs.dn;
import com.google.android.libraries.navigation.internal.zs.dp;
import com.google.android.libraries.navigation.internal.zs.dq;
import com.google.android.libraries.navigation.internal.zs.dr;
import com.google.android.libraries.navigation.internal.zs.ds;
import com.google.android.libraries.navigation.internal.zs.dt;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w {
    public long a = 0;
    public aq b = aq.a;

    public static dt a(aq aqVar, aq aqVar2, long j, long j2, v vVar) {
        int i;
        int i2;
        int i3;
        boolean z;
        char c;
        int iB = b(aqVar, vVar);
        int iB2 = b(aqVar2, vVar);
        int iC = iB;
        int iC2 = iB2;
        while (true) {
            i = 0;
            i2 = 1;
            i3 = -1;
            if (iC == -1) {
                z = false;
                break;
            }
            if (iC2 == -1) {
                z = false;
                iC2 = -1;
                break;
            }
            if (((ap) aqVar.b.get(iC)).b != ((ap) aqVar2.b.get(iC2)).b) {
                z = true;
                break;
            }
            iC = c(aqVar, iC, vVar);
            iC2 = c(aqVar2, iC2, vVar);
        }
        if (iC == -1 && iC2 == -1 && !z) {
            return null;
        }
        HashMap map = new HashMap(aqVar.b.size());
        while (iB != -1) {
            Long lValueOf = Long.valueOf(((ap) aqVar.b.get(iB)).b);
            if (!map.containsKey(lValueOf)) {
                map.put(lValueOf, new t(iB, i));
            }
            iB = c(aqVar, iB, vVar);
            i++;
        }
        dm dmVar = (dm) dt.a.q();
        int i4 = (int) j;
        if (!dmVar.b.H()) {
            dmVar.v();
        }
        dt dtVar = (dt) dmVar.b;
        dtVar.b |= 1;
        dtVar.c = i4;
        int i5 = (int) j2;
        if (!dmVar.b.H()) {
            dmVar.v();
        }
        dt dtVar2 = (dt) dmVar.b;
        char c2 = 2;
        dtVar2.b |= 2;
        dtVar2.e = i5;
        long j3 = 0;
        Cdo cdo = null;
        while (iB2 != i3) {
            long j4 = ((ap) aqVar2.b.get(iB2)).b;
            t tVar = (t) map.get(Long.valueOf(j4));
            if (tVar != null) {
                if (cdo != null) {
                    dn dnVar = (dn) ds.a.q();
                    dp dpVar = (dp) cdo.t();
                    if (!dnVar.b.H()) {
                        dnVar.v();
                    }
                    ds dsVar = (ds) dnVar.b;
                    dpVar.getClass();
                    dsVar.c = dpVar;
                    dsVar.b = i2;
                    dmVar.a((ds) dnVar.t());
                }
                int i6 = tVar.a;
                int i7 = tVar.b;
                dn dnVar2 = (dn) ds.a.q();
                dq dqVar = (dq) dr.a.q();
                if (!dqVar.b.H()) {
                    dqVar.v();
                }
                dr drVar = (dr) dqVar.b;
                drVar.b |= i2;
                drVar.c = i7;
                int i8 = i7;
                int i9 = i6;
                while (i6 != i3 && iB2 != i3 && ((ap) aqVar.b.get(i6)).b == ((ap) aqVar2.b.get(iB2)).b) {
                    int iC3 = c(aqVar, i6, vVar);
                    iB2 = c(aqVar2, iB2, vVar);
                    i8++;
                    i3 = -1;
                    i9 = i6;
                    i6 = iC3;
                }
                j3 = ((ap) aqVar.b.get(i9)).b;
                if (!dqVar.b.H()) {
                    dqVar.v();
                }
                dr drVar2 = (dr) dqVar.b;
                drVar2.b |= 2;
                drVar2.d = i8;
                if (!dnVar2.b.H()) {
                    dnVar2.v();
                }
                ds dsVar2 = (ds) dnVar2.b;
                dr drVar3 = (dr) dqVar.t();
                drVar3.getClass();
                dsVar2.c = drVar3;
                c = 2;
                dsVar2.b = 2;
                dmVar.a((ds) dnVar2.t());
                cdo = null;
            } else {
                c = c2;
                if (cdo == null) {
                    cdo = (Cdo) dp.a.q();
                }
                long jD = d(j4);
                long jD2 = d(j3);
                if (!cdo.b.H()) {
                    cdo.v();
                }
                dp dpVar2 = (dp) cdo.b;
                dp dpVar3 = dp.a;
                bt btVar = dpVar2.b;
                if (!btVar.c()) {
                    dpVar2.b = bi.x(btVar);
                }
                dpVar2.b.f(jD - jD2);
                int size = ((ap) aqVar2.b.get(iB2)).e.size();
                if (!cdo.b.H()) {
                    cdo.v();
                }
                dp dpVar4 = (dp) cdo.b;
                bq bqVar = dpVar4.c;
                if (!bqVar.c()) {
                    dpVar4.c = bi.w(bqVar);
                }
                dpVar4.c.i(size);
                iB2 = c(aqVar2, iB2, vVar);
                j3 = j4;
            }
            c2 = c;
            i2 = 1;
            i3 = -1;
        }
        if (cdo != null) {
            dn dnVar3 = (dn) ds.a.q();
            dp dpVar5 = (dp) cdo.t();
            if (!dnVar3.b.H()) {
                dnVar3.v();
            }
            ds dsVar3 = (ds) dnVar3.b;
            dpVar5.getClass();
            dsVar3.c = dpVar5;
            dsVar3.b = 1;
            dmVar.a((ds) dnVar3.t());
        }
        return (dt) dmVar.t();
    }

    private static int b(aq aqVar, v vVar) {
        if (aqVar.b.size() == 0) {
            return -1;
        }
        int i = 0;
        while (i < aqVar.b.size() && !vVar.a((ap) aqVar.b.get(i))) {
            i++;
        }
        return i;
    }

    private static int c(aq aqVar, int i, v vVar) {
        ap apVar = (ap) aqVar.b.get(i);
        int size = apVar.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iD = apVar.e.d(i2);
            if (vVar.a((ap) aqVar.b.get(iD))) {
                return iD;
            }
        }
        return -1;
    }

    private static long d(long j) {
        return j & 4503599627370495L;
    }
}
